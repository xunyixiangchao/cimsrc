package org.webrtc;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EglRenderer
  implements VideoSink
{
  private static final long LOG_INTERVAL_SEC = 4L;
  private static final String TAG = "EglRenderer";
  private final GlTextureFrameBuffer bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
  private final Matrix drawMatrix = new Matrix();
  private RendererCommon.GlDrawer drawer;
  private EglBase eglBase;
  private final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation(null);
  private volatile ErrorCallback errorCallback;
  private final Object fpsReductionLock = new Object();
  private final VideoFrameDrawer frameDrawer;
  private final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList();
  private final Object frameLock = new Object();
  private int framesDropped;
  private int framesReceived;
  private int framesRendered;
  private final Object handlerLock = new Object();
  private float layoutAspectRatio;
  private final Object layoutLock = new Object();
  private final Runnable logStatisticsRunnable = new Runnable()
  {
    public void run()
    {
      EglRenderer.this.logStatistics();
      synchronized (EglRenderer.this.handlerLock)
      {
        if (EglRenderer.this.renderThreadHandler != null)
        {
          EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
          EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
        return;
      }
    }
  };
  private long minRenderPeriodNs;
  private boolean mirrorHorizontally;
  private boolean mirrorVertically;
  protected final String name;
  private long nextFrameTimeNs;
  private VideoFrame pendingFrame;
  private long renderSwapBufferTimeNs;
  private Handler renderThreadHandler;
  private long renderTimeNs;
  private final Object statisticsLock = new Object();
  private long statisticsStartTimeNs;
  private boolean usePresentationTimeStamp;
  
  public EglRenderer(String paramString)
  {
    this(paramString, new VideoFrameDrawer());
  }
  
  public EglRenderer(String paramString, VideoFrameDrawer paramVideoFrameDrawer)
  {
    this.name = paramString;
    this.frameDrawer = paramVideoFrameDrawer;
  }
  
  private String averageTimeAsString(long paramLong, int paramInt)
  {
    if (paramInt <= 0) {
      return "NA";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TimeUnit.NANOSECONDS.toMicros(paramLong / paramInt));
    localStringBuilder.append(" us");
    return localStringBuilder.toString();
  }
  
  private void clearSurfaceOnRenderThread(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    EglBase localEglBase = this.eglBase;
    if ((localEglBase != null) && (localEglBase.hasSurface()))
    {
      logD("clearSurface");
      GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      GLES20.glClear(16384);
      this.eglBase.swapBuffers();
    }
  }
  
  private void createEglSurfaceInternal(Object paramObject)
  {
    this.eglSurfaceCreationRunnable.setSurface(paramObject);
    postToRenderThread(this.eglSurfaceCreationRunnable);
  }
  
  private void logD(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(paramString);
    Logging.d("EglRenderer", localStringBuilder.toString());
  }
  
  private void logE(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(paramString);
    Logging.e("EglRenderer", localStringBuilder.toString(), paramThrowable);
  }
  
  private void logStatistics()
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#.0");
    long l1 = System.nanoTime();
    synchronized (this.statisticsLock)
    {
      long l2 = l1 - this.statisticsStartTimeNs;
      if ((l2 > 0L) && ((this.minRenderPeriodNs != 9223372036854775807L) || (this.framesReceived != 0)))
      {
        float f = (float)(this.framesRendered * TimeUnit.SECONDS.toNanos(1L)) / (float)l2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Duration: ");
        localStringBuilder.append(TimeUnit.NANOSECONDS.toMillis(l2));
        localStringBuilder.append(" ms. Frames received: ");
        localStringBuilder.append(this.framesReceived);
        localStringBuilder.append(". Dropped: ");
        localStringBuilder.append(this.framesDropped);
        localStringBuilder.append(". Rendered: ");
        localStringBuilder.append(this.framesRendered);
        localStringBuilder.append(". Render fps: ");
        localStringBuilder.append(localDecimalFormat.format(f));
        localStringBuilder.append(". Average render time: ");
        localStringBuilder.append(averageTimeAsString(this.renderTimeNs, this.framesRendered));
        localStringBuilder.append(". Average swapBuffer time: ");
        localStringBuilder.append(averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered));
        localStringBuilder.append(".");
        logD(localStringBuilder.toString());
        resetStatistics(l1);
        return;
      }
      return;
    }
  }
  
  private void logW(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(paramString);
    Logging.w("EglRenderer", localStringBuilder.toString());
  }
  
  private void notifyCallbacks(VideoFrame paramVideoFrame, boolean paramBoolean)
  {
    if (this.frameListeners.isEmpty()) {
      return;
    }
    this.drawMatrix.reset();
    this.drawMatrix.preTranslate(0.5F, 0.5F);
    Object localObject = this.drawMatrix;
    float f1;
    if (this.mirrorHorizontally) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    }
    float f2;
    if (this.mirrorVertically) {
      f2 = -1.0F;
    } else {
      f2 = 1.0F;
    }
    ((Matrix)localObject).preScale(f1, f2);
    this.drawMatrix.preScale(1.0F, -1.0F);
    this.drawMatrix.preTranslate(-0.5F, -0.5F);
    Iterator localIterator = this.frameListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FrameListenerAndParams)localIterator.next();
      if ((paramBoolean) || (!((FrameListenerAndParams)localObject).applyFpsReduction))
      {
        localIterator.remove();
        int i = (int)(((FrameListenerAndParams)localObject).scale * paramVideoFrame.getRotatedWidth());
        int j = (int)(((FrameListenerAndParams)localObject).scale * paramVideoFrame.getRotatedHeight());
        Bitmap localBitmap;
        if ((i != 0) && (j != 0))
        {
          this.bitmapTextureFramebuffer.setSize(i, j);
          GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          this.frameDrawer.drawFrame(paramVideoFrame, ((FrameListenerAndParams)localObject).drawer, this.drawMatrix, 0, 0, i, j);
          ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(i * j * 4);
          GLES20.glViewport(0, 0, i, j);
          GLES20.glReadPixels(0, 0, i, j, 6408, 5121, localByteBuffer);
          GLES20.glBindFramebuffer(36160, 0);
          GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
          localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localBitmap.copyPixelsFromBuffer(localByteBuffer);
          localObject = ((FrameListenerAndParams)localObject).listener;
        }
        else
        {
          localObject = ((FrameListenerAndParams)localObject).listener;
          localBitmap = null;
        }
        ((FrameListener)localObject).onFrame(localBitmap);
      }
    }
  }
  
  private void postToRenderThread(Runnable paramRunnable)
  {
    synchronized (this.handlerLock)
    {
      Handler localHandler = this.renderThreadHandler;
      if (localHandler != null) {
        localHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  /* Error */
  private void renderFrameOnRenderThread()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	org/webrtc/EglRenderer:frameLock	Ljava/lang/Object;
    //   4: astore 13
    //   6: aload 13
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 533	org/webrtc/EglRenderer:pendingFrame	Lorg/webrtc/VideoFrame;
    //   13: astore 12
    //   15: aload 12
    //   17: ifnonnull +7 -> 24
    //   20: aload 13
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 533	org/webrtc/EglRenderer:pendingFrame	Lorg/webrtc/VideoFrame;
    //   29: aload 13
    //   31: monitorexit
    //   32: aload_0
    //   33: getfield 141	org/webrtc/EglRenderer:eglBase	Lorg/webrtc/EglBase;
    //   36: astore 13
    //   38: aload 13
    //   40: ifnull +518 -> 558
    //   43: aload 13
    //   45: invokeinterface 204 1 0
    //   50: ifne +6 -> 56
    //   53: goto +505 -> 558
    //   56: aload_0
    //   57: getfield 99	org/webrtc/EglRenderer:fpsReductionLock	Ljava/lang/Object;
    //   60: astore 13
    //   62: aload 13
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 367	org/webrtc/EglRenderer:minRenderPeriodNs	J
    //   69: lstore 5
    //   71: lload 5
    //   73: ldc2_w 368
    //   76: lcmp
    //   77: ifne +508 -> 585
    //   80: goto +499 -> 579
    //   83: invokestatic 363	java/lang/System:nanoTime	()J
    //   86: lstore 5
    //   88: aload_0
    //   89: getfield 535	org/webrtc/EglRenderer:nextFrameTimeNs	J
    //   92: lstore 7
    //   94: lload 5
    //   96: lload 7
    //   98: lcmp
    //   99: ifge +13 -> 112
    //   102: aload_0
    //   103: ldc_w 537
    //   106: invokespecial 209	org/webrtc/EglRenderer:logD	(Ljava/lang/String;)V
    //   109: goto +470 -> 579
    //   112: lload 7
    //   114: aload_0
    //   115: getfield 367	org/webrtc/EglRenderer:minRenderPeriodNs	J
    //   118: ladd
    //   119: lstore 7
    //   121: aload_0
    //   122: lload 7
    //   124: putfield 535	org/webrtc/EglRenderer:nextFrameTimeNs	J
    //   127: aload_0
    //   128: lload 7
    //   130: lload 5
    //   132: invokestatic 543	java/lang/Math:max	(JJ)J
    //   135: putfield 535	org/webrtc/EglRenderer:nextFrameTimeNs	J
    //   138: goto +454 -> 592
    //   141: aload 13
    //   143: monitorexit
    //   144: invokestatic 363	java/lang/System:nanoTime	()J
    //   147: lstore 5
    //   149: aload 12
    //   151: invokevirtual 455	org/webrtc/VideoFrame:getRotatedWidth	()I
    //   154: i2f
    //   155: aload 12
    //   157: invokevirtual 458	org/webrtc/VideoFrame:getRotatedHeight	()I
    //   160: i2f
    //   161: fdiv
    //   162: fstore_2
    //   163: aload_0
    //   164: getfield 108	org/webrtc/EglRenderer:layoutLock	Ljava/lang/Object;
    //   167: astore 13
    //   169: aload 13
    //   171: monitorenter
    //   172: aload_0
    //   173: getfield 545	org/webrtc/EglRenderer:layoutAspectRatio	F
    //   176: fstore_1
    //   177: fload_1
    //   178: fconst_0
    //   179: fcmpl
    //   180: ifeq +418 -> 598
    //   183: goto +3 -> 186
    //   186: aload 13
    //   188: monitorexit
    //   189: fconst_1
    //   190: fstore 4
    //   192: fload_2
    //   193: fload_1
    //   194: fcmpl
    //   195: ifle +12 -> 207
    //   198: fload_1
    //   199: fload_2
    //   200: fdiv
    //   201: fstore_2
    //   202: fconst_1
    //   203: fstore_1
    //   204: goto +9 -> 213
    //   207: fload_2
    //   208: fload_1
    //   209: fdiv
    //   210: fstore_1
    //   211: fconst_1
    //   212: fstore_2
    //   213: aload_0
    //   214: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   217: invokevirtual 429	android/graphics/Matrix:reset	()V
    //   220: aload_0
    //   221: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   224: ldc_w 430
    //   227: ldc_w 430
    //   230: invokevirtual 434	android/graphics/Matrix:preTranslate	(FF)Z
    //   233: pop
    //   234: aload_0
    //   235: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   238: astore 13
    //   240: aload_0
    //   241: getfield 436	org/webrtc/EglRenderer:mirrorHorizontally	Z
    //   244: ifeq +10 -> 254
    //   247: ldc_w 437
    //   250: fstore_3
    //   251: goto +5 -> 256
    //   254: fconst_1
    //   255: fstore_3
    //   256: aload_0
    //   257: getfield 439	org/webrtc/EglRenderer:mirrorVertically	Z
    //   260: ifeq +8 -> 268
    //   263: ldc_w 437
    //   266: fstore 4
    //   268: aload 13
    //   270: fload_3
    //   271: fload 4
    //   273: invokevirtual 442	android/graphics/Matrix:preScale	(FF)Z
    //   276: pop
    //   277: aload_0
    //   278: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   281: fload_2
    //   282: fload_1
    //   283: invokevirtual 442	android/graphics/Matrix:preScale	(FF)Z
    //   286: pop
    //   287: aload_0
    //   288: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   291: ldc_w 443
    //   294: ldc_w 443
    //   297: invokevirtual 434	android/graphics/Matrix:preTranslate	(FF)Z
    //   300: pop
    //   301: iload 11
    //   303: ifeq +157 -> 460
    //   306: fconst_0
    //   307: fconst_0
    //   308: fconst_0
    //   309: fconst_0
    //   310: invokestatic 214	android/opengl/GLES20:glClearColor	(FFFF)V
    //   313: sipush 16384
    //   316: invokestatic 217	android/opengl/GLES20:glClear	(I)V
    //   319: aload_0
    //   320: getfield 131	org/webrtc/EglRenderer:frameDrawer	Lorg/webrtc/VideoFrameDrawer;
    //   323: aload 12
    //   325: aload_0
    //   326: getfield 258	org/webrtc/EglRenderer:drawer	Lorg/webrtc/RendererCommon$GlDrawer;
    //   329: aload_0
    //   330: getfield 104	org/webrtc/EglRenderer:drawMatrix	Landroid/graphics/Matrix;
    //   333: iconst_0
    //   334: iconst_0
    //   335: aload_0
    //   336: getfield 141	org/webrtc/EglRenderer:eglBase	Lorg/webrtc/EglBase;
    //   339: invokeinterface 548 1 0
    //   344: aload_0
    //   345: getfield 141	org/webrtc/EglRenderer:eglBase	Lorg/webrtc/EglBase;
    //   348: invokeinterface 551 1 0
    //   353: invokevirtual 482	org/webrtc/VideoFrameDrawer:drawFrame	(Lorg/webrtc/VideoFrame;Lorg/webrtc/RendererCommon$GlDrawer;Landroid/graphics/Matrix;IIII)V
    //   356: invokestatic 363	java/lang/System:nanoTime	()J
    //   359: lstore 7
    //   361: aload_0
    //   362: getfield 553	org/webrtc/EglRenderer:usePresentationTimeStamp	Z
    //   365: ifeq +20 -> 385
    //   368: aload_0
    //   369: getfield 141	org/webrtc/EglRenderer:eglBase	Lorg/webrtc/EglBase;
    //   372: aload 12
    //   374: invokevirtual 556	org/webrtc/VideoFrame:getTimestampNs	()J
    //   377: invokeinterface 558 3 0
    //   382: goto +12 -> 394
    //   385: aload_0
    //   386: getfield 141	org/webrtc/EglRenderer:eglBase	Lorg/webrtc/EglBase;
    //   389: invokeinterface 220 1 0
    //   394: invokestatic 363	java/lang/System:nanoTime	()J
    //   397: lstore 9
    //   399: aload_0
    //   400: getfield 110	org/webrtc/EglRenderer:statisticsLock	Ljava/lang/Object;
    //   403: astore 13
    //   405: aload 13
    //   407: monitorenter
    //   408: aload_0
    //   409: aload_0
    //   410: getfield 373	org/webrtc/EglRenderer:framesRendered	I
    //   413: iconst_1
    //   414: iadd
    //   415: putfield 373	org/webrtc/EglRenderer:framesRendered	I
    //   418: aload_0
    //   419: aload_0
    //   420: getfield 405	org/webrtc/EglRenderer:renderTimeNs	J
    //   423: lload 9
    //   425: lload 5
    //   427: lsub
    //   428: ladd
    //   429: putfield 405	org/webrtc/EglRenderer:renderTimeNs	J
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 411	org/webrtc/EglRenderer:renderSwapBufferTimeNs	J
    //   437: lload 9
    //   439: lload 7
    //   441: lsub
    //   442: ladd
    //   443: putfield 411	org/webrtc/EglRenderer:renderSwapBufferTimeNs	J
    //   446: aload 13
    //   448: monitorexit
    //   449: goto +11 -> 460
    //   452: astore 14
    //   454: aload 13
    //   456: monitorexit
    //   457: aload 14
    //   459: athrow
    //   460: aload_0
    //   461: aload 12
    //   463: iload 11
    //   465: invokespecial 560	org/webrtc/EglRenderer:notifyCallbacks	(Lorg/webrtc/VideoFrame;Z)V
    //   468: aload 12
    //   470: invokevirtual 561	org/webrtc/VideoFrame:release	()V
    //   473: return
    //   474: astore 13
    //   476: goto +58 -> 534
    //   479: astore 13
    //   481: aload_0
    //   482: ldc_w 563
    //   485: aload 13
    //   487: invokespecial 565	org/webrtc/EglRenderer:logE	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   490: aload_0
    //   491: getfield 567	org/webrtc/EglRenderer:errorCallback	Lorg/webrtc/EglRenderer$ErrorCallback;
    //   494: astore 13
    //   496: aload 13
    //   498: ifnull +10 -> 508
    //   501: aload 13
    //   503: invokeinterface 570 1 0
    //   508: aload_0
    //   509: getfield 258	org/webrtc/EglRenderer:drawer	Lorg/webrtc/RendererCommon$GlDrawer;
    //   512: invokeinterface 290 1 0
    //   517: aload_0
    //   518: getfield 131	org/webrtc/EglRenderer:frameDrawer	Lorg/webrtc/VideoFrameDrawer;
    //   521: invokevirtual 291	org/webrtc/VideoFrameDrawer:release	()V
    //   524: aload_0
    //   525: getfield 117	org/webrtc/EglRenderer:bitmapTextureFramebuffer	Lorg/webrtc/GlTextureFrameBuffer;
    //   528: invokevirtual 292	org/webrtc/GlTextureFrameBuffer:release	()V
    //   531: goto -63 -> 468
    //   534: aload 12
    //   536: invokevirtual 561	org/webrtc/VideoFrame:release	()V
    //   539: aload 13
    //   541: athrow
    //   542: astore 12
    //   544: aload 13
    //   546: monitorexit
    //   547: aload 12
    //   549: athrow
    //   550: astore 12
    //   552: aload 13
    //   554: monitorexit
    //   555: aload 12
    //   557: athrow
    //   558: aload_0
    //   559: ldc_w 572
    //   562: invokespecial 209	org/webrtc/EglRenderer:logD	(Ljava/lang/String;)V
    //   565: aload 12
    //   567: invokevirtual 561	org/webrtc/VideoFrame:release	()V
    //   570: return
    //   571: astore 12
    //   573: aload 13
    //   575: monitorexit
    //   576: aload 12
    //   578: athrow
    //   579: iconst_0
    //   580: istore 11
    //   582: goto -441 -> 141
    //   585: lload 5
    //   587: lconst_0
    //   588: lcmp
    //   589: ifgt -506 -> 83
    //   592: iconst_1
    //   593: istore 11
    //   595: goto -454 -> 141
    //   598: fload_2
    //   599: fstore_1
    //   600: goto -414 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	EglRenderer
    //   176	424	1	f1	float
    //   162	437	2	f2	float
    //   250	21	3	f3	float
    //   190	82	4	f4	float
    //   69	517	5	l1	long
    //   92	348	7	l2	long
    //   397	41	9	l3	long
    //   301	293	11	bool	boolean
    //   13	522	12	localVideoFrame	VideoFrame
    //   542	6	12	localObject1	Object
    //   550	16	12	localObject2	Object
    //   571	6	12	localObject3	Object
    //   474	1	13	localObject5	Object
    //   479	7	13	localGlOutOfMemoryException	GlUtil.GlOutOfMemoryException
    //   494	80	13	localErrorCallback	ErrorCallback
    //   452	6	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   408	449	452	finally
    //   454	457	452	finally
    //   306	382	474	finally
    //   385	394	474	finally
    //   394	408	474	finally
    //   457	460	474	finally
    //   460	468	474	finally
    //   481	496	474	finally
    //   501	508	474	finally
    //   508	531	474	finally
    //   306	382	479	org/webrtc/GlUtil$GlOutOfMemoryException
    //   385	394	479	org/webrtc/GlUtil$GlOutOfMemoryException
    //   394	408	479	org/webrtc/GlUtil$GlOutOfMemoryException
    //   457	460	479	org/webrtc/GlUtil$GlOutOfMemoryException
    //   460	468	479	org/webrtc/GlUtil$GlOutOfMemoryException
    //   172	177	542	finally
    //   186	189	542	finally
    //   544	547	542	finally
    //   65	71	550	finally
    //   83	94	550	finally
    //   102	109	550	finally
    //   112	138	550	finally
    //   141	144	550	finally
    //   552	555	550	finally
    //   9	15	571	finally
    //   20	23	571	finally
    //   24	32	571	finally
    //   573	576	571	finally
  }
  
  private void resetStatistics(long paramLong)
  {
    synchronized (this.statisticsLock)
    {
      this.statisticsStartTimeNs = paramLong;
      this.framesReceived = 0;
      this.framesDropped = 0;
      this.framesRendered = 0;
      this.renderTimeNs = 0L;
      this.renderSwapBufferTimeNs = 0L;
      return;
    }
  }
  
  public void addFrameListener(FrameListener paramFrameListener, float paramFloat)
  {
    addFrameListener(paramFrameListener, paramFloat, null, false);
  }
  
  public void addFrameListener(FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer)
  {
    addFrameListener(paramFrameListener, paramFloat, paramGlDrawer, false);
  }
  
  public void addFrameListener(FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer, boolean paramBoolean)
  {
    postToRenderThread(new o(this, paramGlDrawer, paramFrameListener, paramFloat, paramBoolean));
  }
  
  public void clearImage()
  {
    clearImage(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void clearImage(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    synchronized (this.handlerLock)
    {
      Handler localHandler = this.renderThreadHandler;
      if (localHandler == null) {
        return;
      }
      localHandler.postAtFrontOfQueue(new i(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
      return;
    }
  }
  
  public void createEglSurface(SurfaceTexture paramSurfaceTexture)
  {
    createEglSurfaceInternal(paramSurfaceTexture);
  }
  
  public void createEglSurface(Surface paramSurface)
  {
    createEglSurfaceInternal(paramSurface);
  }
  
  public void disableFpsReduction()
  {
    setFpsReduction((1.0F / 1.0F));
  }
  
  public void init(EglBase.Context paramContext, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer)
  {
    init(paramContext, paramArrayOfInt, paramGlDrawer, false);
  }
  
  public void init(EglBase.Context paramContext, int[] paramArrayOfInt, RendererCommon.GlDrawer paramGlDrawer, boolean paramBoolean)
  {
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null)
      {
        logD("Initializing EglRenderer");
        this.drawer = paramGlDrawer;
        this.usePresentationTimeStamp = paramBoolean;
        paramGlDrawer = new StringBuilder();
        paramGlDrawer.append(this.name);
        paramGlDrawer.append("EglRenderer");
        paramGlDrawer = new HandlerThread(paramGlDrawer.toString());
        paramGlDrawer.start();
        paramGlDrawer = new HandlerWithExceptionCallback(paramGlDrawer.getLooper(), new Runnable()
        {
          public void run()
          {
            synchronized (EglRenderer.this.handlerLock)
            {
              EglRenderer.access$302(EglRenderer.this, null);
              return;
            }
          }
        });
        this.renderThreadHandler = paramGlDrawer;
        ThreadUtils.invokeAtFrontUninterruptibly(paramGlDrawer, new n(this, paramContext, paramArrayOfInt));
        this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
        resetStatistics(System.nanoTime());
        this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append(this.name);
      paramContext.append("Already initialized");
      throw new IllegalStateException(paramContext.toString());
    }
  }
  
  public void onFrame(VideoFrame arg1)
  {
    for (;;)
    {
      synchronized (this.statisticsLock)
      {
        this.framesReceived += 1;
        synchronized (this.handlerLock)
        {
          if (this.renderThreadHandler == null)
          {
            logD("Dropping frame - Not initialized or already released.");
            return;
          }
          synchronized (this.frameLock)
          {
            VideoFrame localVideoFrame = this.pendingFrame;
            if (localVideoFrame != null)
            {
              i = 1;
              if (i != 0) {
                localVideoFrame.release();
              }
              this.pendingFrame = ???;
              ???.retain();
              this.renderThreadHandler.post(new h(this));
              if (i != 0) {
                synchronized (this.statisticsLock)
                {
                  this.framesDropped += 1;
                  return;
                }
              }
              return;
            }
          }
        }
      }
      int i = 0;
    }
  }
  
  public void pauseVideo()
  {
    setFpsReduction(0.0F);
  }
  
  public void printStackTrace()
  {
    synchronized (this.handlerLock)
    {
      Object localObject1 = this.renderThreadHandler;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((Handler)localObject1).getLooper().getThread();
      }
      if (localObject1 != null)
      {
        localObject1 = ((Thread)localObject1).getStackTrace();
        if (localObject1.length > 0)
        {
          logW("EglRenderer stack trace:");
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            logW(localObject1[i].toString());
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  public void release()
  {
    logD("Releasing.");
    Object localObject2 = new CountDownLatch(1);
    synchronized (this.handlerLock)
    {
      Object localObject5 = this.renderThreadHandler;
      if (localObject5 == null)
      {
        logD("Already released");
        return;
      }
      ((Handler)localObject5).removeCallbacks(this.logStatisticsRunnable);
      this.renderThreadHandler.postAtFrontOfQueue(new l(this, (CountDownLatch)localObject2));
      localObject5 = this.renderThreadHandler.getLooper();
      this.renderThreadHandler.post(new j(this, (Looper)localObject5));
      this.renderThreadHandler = null;
      ThreadUtils.awaitUninterruptibly((CountDownLatch)localObject2);
      synchronized (this.frameLock)
      {
        localObject2 = this.pendingFrame;
        if (localObject2 != null)
        {
          ((VideoFrame)localObject2).release();
          this.pendingFrame = null;
        }
        logD("Releasing done.");
        return;
      }
    }
  }
  
  public void releaseEglSurface(Runnable paramRunnable)
  {
    this.eglSurfaceCreationRunnable.setSurface(null);
    synchronized (this.handlerLock)
    {
      Handler localHandler = this.renderThreadHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.eglSurfaceCreationRunnable);
        this.renderThreadHandler.postAtFrontOfQueue(new k(this, paramRunnable));
        return;
      }
      paramRunnable.run();
      return;
    }
  }
  
  public void removeFrameListener(FrameListener paramFrameListener)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    synchronized (this.handlerLock)
    {
      if (this.renderThreadHandler == null) {
        return;
      }
      if (Thread.currentThread() != this.renderThreadHandler.getLooper().getThread())
      {
        postToRenderThread(new m(this, localCountDownLatch, paramFrameListener));
        ThreadUtils.awaitUninterruptibly(localCountDownLatch);
        return;
      }
      throw new RuntimeException("removeFrameListener must not be called on the render thread.");
    }
  }
  
  public void setErrorCallback(ErrorCallback paramErrorCallback)
  {
    this.errorCallback = paramErrorCallback;
  }
  
  public void setFpsReduction(float paramFloat)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("setFpsReduction: ");
    ((StringBuilder)???).append(paramFloat);
    logD(((StringBuilder)???).toString());
    synchronized (this.fpsReductionLock)
    {
      long l = this.minRenderPeriodNs;
      if (paramFloat <= 0.0F) {
        this.minRenderPeriodNs = 9223372036854775807L;
      } else {
        this.minRenderPeriodNs = (((float)TimeUnit.SECONDS.toNanos(1L) / paramFloat));
      }
      if (this.minRenderPeriodNs != l) {
        this.nextFrameTimeNs = System.nanoTime();
      }
      return;
    }
  }
  
  public void setLayoutAspectRatio(float paramFloat)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("setLayoutAspectRatio: ");
    ((StringBuilder)???).append(paramFloat);
    logD(((StringBuilder)???).toString());
    synchronized (this.layoutLock)
    {
      this.layoutAspectRatio = paramFloat;
      return;
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("setMirrorHorizontally: ");
    ((StringBuilder)???).append(paramBoolean);
    logD(((StringBuilder)???).toString());
    synchronized (this.layoutLock)
    {
      this.mirrorHorizontally = paramBoolean;
      return;
    }
  }
  
  public void setMirrorVertically(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("setMirrorVertically: ");
    ((StringBuilder)???).append(paramBoolean);
    logD(((StringBuilder)???).toString());
    synchronized (this.layoutLock)
    {
      this.mirrorVertically = paramBoolean;
      return;
    }
  }
  
  private class EglSurfaceCreation
    implements Runnable
  {
    private Object surface;
    
    private EglSurfaceCreation() {}
    
    public void run()
    {
      try
      {
        if ((this.surface != null) && (EglRenderer.this.eglBase != null) && (!EglRenderer.this.eglBase.hasSurface()))
        {
          Object localObject1 = this.surface;
          if ((localObject1 instanceof Surface))
          {
            EglRenderer.this.eglBase.createSurface((Surface)this.surface);
          }
          else
          {
            if (!(localObject1 instanceof SurfaceTexture)) {
              break label116;
            }
            EglRenderer.this.eglBase.createSurface((SurfaceTexture)this.surface);
          }
          EglRenderer.this.eglBase.makeCurrent();
          GLES20.glPixelStorei(3317, 1);
          break label152;
          label116:
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Invalid surface: ");
          ((StringBuilder)localObject1).append(this.surface);
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
        label152:
        return;
      }
      finally {}
    }
    
    public void setSurface(Object paramObject)
    {
      try
      {
        this.surface = paramObject;
        return;
      }
      finally
      {
        paramObject = finally;
        throw paramObject;
      }
    }
  }
  
  public static abstract interface ErrorCallback
  {
    public abstract void onGlOutOfMemory();
  }
  
  public static abstract interface FrameListener
  {
    public abstract void onFrame(Bitmap paramBitmap);
  }
  
  private static class FrameListenerAndParams
  {
    public final boolean applyFpsReduction;
    public final RendererCommon.GlDrawer drawer;
    public final EglRenderer.FrameListener listener;
    public final float scale;
    
    public FrameListenerAndParams(EglRenderer.FrameListener paramFrameListener, float paramFloat, RendererCommon.GlDrawer paramGlDrawer, boolean paramBoolean)
    {
      this.listener = paramFrameListener;
      this.scale = paramFloat;
      this.drawer = paramGlDrawer;
      this.applyFpsReduction = paramBoolean;
    }
  }
  
  private static class HandlerWithExceptionCallback
    extends Handler
  {
    private final Runnable exceptionCallback;
    
    public HandlerWithExceptionCallback(Looper paramLooper, Runnable paramRunnable)
    {
      super();
      this.exceptionCallback = paramRunnable;
    }
    
    public void dispatchMessage(Message paramMessage)
    {
      try
      {
        super.dispatchMessage(paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        Logging.e("EglRenderer", "Exception on EglRenderer thread", paramMessage);
        this.exceptionCallback.run();
        throw paramMessage;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglRenderer
 * JD-Core Version:    0.7.0.1
 */