package org.webrtc;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class AndroidVideoDecoder
  implements VideoDecoder, VideoSink
{
  private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
  private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
  private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
  private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
  private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
  private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
  private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
  private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
  private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
  private static final String TAG = "AndroidVideoDecoder";
  private VideoDecoder.Callback callback;
  private MediaCodecWrapper codec;
  private final String codecName;
  private final VideoCodecMimeType codecType;
  private int colorFormat;
  private ThreadUtils.ThreadChecker decoderThreadChecker;
  private final Object dimensionLock = new Object();
  private final BlockingDeque<FrameInfo> frameInfos;
  private boolean hasDecodedFirstFrame;
  private int height;
  private boolean keyFrameRequired;
  private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
  private Thread outputThread;
  private ThreadUtils.ThreadChecker outputThreadChecker;
  private DecodedTextureMetadata renderedTextureMetadata;
  private final Object renderedTextureMetadataLock = new Object();
  private volatile boolean running;
  private final EglBase.Context sharedContext;
  private volatile Exception shutdownException;
  private int sliceHeight;
  private int stride;
  private Surface surface;
  private SurfaceTextureHelper surfaceTextureHelper;
  private int width;
  
  AndroidVideoDecoder(MediaCodecWrapperFactory paramMediaCodecWrapperFactory, String paramString, VideoCodecMimeType paramVideoCodecMimeType, int paramInt, EglBase.Context paramContext)
  {
    if (isSupportedColorFormat(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ctor name: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type: ");
      localStringBuilder.append(paramVideoCodecMimeType);
      localStringBuilder.append(" color format: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramContext);
      Logging.d("AndroidVideoDecoder", localStringBuilder.toString());
      this.mediaCodecWrapperFactory = paramMediaCodecWrapperFactory;
      this.codecName = paramString;
      this.codecType = paramVideoCodecMimeType;
      this.colorFormat = paramInt;
      this.sharedContext = paramContext;
      this.frameInfos = new LinkedBlockingDeque();
      return;
    }
    paramMediaCodecWrapperFactory = new StringBuilder();
    paramMediaCodecWrapperFactory.append("Unsupported color format: ");
    paramMediaCodecWrapperFactory.append(paramInt);
    throw new IllegalArgumentException(paramMediaCodecWrapperFactory.toString());
  }
  
  private VideoFrame.Buffer copyI420Buffer(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 % 2 == 0)
    {
      int j = (paramInt3 + 1) / 2;
      int k = paramInt2 % 2;
      int i;
      if (k == 0) {
        i = (paramInt4 + 1) / 2;
      } else {
        i = paramInt4 / 2;
      }
      int m = paramInt1 / 2;
      int n = paramInt1 * paramInt2 + 0;
      int i1 = m * i;
      paramInt2 = n + m * paramInt2 / 2;
      VideoFrame.I420Buffer localI420Buffer = allocateI420Buffer(paramInt3, paramInt4);
      paramByteBuffer.limit(paramInt1 * paramInt4 + 0);
      paramByteBuffer.position(0);
      copyPlane(paramByteBuffer.slice(), paramInt1, localI420Buffer.getDataY(), localI420Buffer.getStrideY(), paramInt3, paramInt4);
      paramByteBuffer.limit(n + i1);
      paramByteBuffer.position(n);
      copyPlane(paramByteBuffer.slice(), m, localI420Buffer.getDataU(), localI420Buffer.getStrideU(), j, i);
      ByteBuffer localByteBuffer;
      if (k == 1)
      {
        paramByteBuffer.position(n + (i - 1) * m);
        localByteBuffer = localI420Buffer.getDataU();
        localByteBuffer.position(localI420Buffer.getStrideU() * i);
        localByteBuffer.put(paramByteBuffer);
      }
      paramByteBuffer.limit(paramInt2 + i1);
      paramByteBuffer.position(paramInt2);
      copyPlane(paramByteBuffer.slice(), m, localI420Buffer.getDataV(), localI420Buffer.getStrideV(), j, i);
      if (k == 1)
      {
        paramByteBuffer.position(paramInt2 + m * (i - 1));
        localByteBuffer = localI420Buffer.getDataV();
        localByteBuffer.position(localI420Buffer.getStrideV() * i);
        localByteBuffer.put(paramByteBuffer);
      }
      return localI420Buffer;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Stride is not divisible by two: ");
    paramByteBuffer.append(paramInt1);
    throw new AssertionError(paramByteBuffer.toString());
  }
  
  private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new NV12Buffer(paramInt3, paramInt4, paramInt1, paramInt2, paramByteBuffer, null).toI420();
  }
  
  private Thread createOutputThread()
  {
    new Thread("AndroidVideoDecoder.outputThread")
    {
      public void run()
      {
        AndroidVideoDecoder.access$002(AndroidVideoDecoder.this, new ThreadUtils.ThreadChecker());
        while (AndroidVideoDecoder.this.running) {
          AndroidVideoDecoder.this.deliverDecodedFrame();
        }
        AndroidVideoDecoder.this.releaseCodecOnOutputThread();
      }
    };
  }
  
  private void deliverByteFrame(int paramInt1, MediaCodec.BufferInfo paramBufferInfo, int paramInt2, Integer paramInteger)
  {
    synchronized (this.dimensionLock)
    {
      int j = this.width;
      int k = this.height;
      int i = this.stride;
      int m = this.sliceHeight;
      int n = paramBufferInfo.size;
      if (n < j * k * 3 / 2)
      {
        paramInteger = new StringBuilder();
        paramInteger.append("Insufficient output buffer size: ");
        paramInteger.append(paramBufferInfo.size);
        Logging.e("AndroidVideoDecoder", paramInteger.toString());
        return;
      }
      if ((n < i * k * 3 / 2) && (m == k) && (i > j)) {
        i = n * 2 / (k * 3);
      }
      ??? = this.codec.getOutputBuffers()[paramInt1];
      ((ByteBuffer)???).position(paramBufferInfo.offset);
      ((ByteBuffer)???).limit(paramBufferInfo.offset + paramBufferInfo.size);
      ??? = ((ByteBuffer)???).slice();
      if (this.colorFormat == 19) {
        ??? = copyI420Buffer((ByteBuffer)???, i, m, j, k);
      } else {
        ??? = copyNV12ToI420Buffer((ByteBuffer)???, i, m, j, k);
      }
      this.codec.releaseOutputBuffer(paramInt1, false);
      paramBufferInfo = new VideoFrame((VideoFrame.Buffer)???, paramInt2, paramBufferInfo.presentationTimeUs * 1000L);
      this.callback.onDecodedFrame(paramBufferInfo, paramInteger, null);
      paramBufferInfo.release();
      return;
    }
  }
  
  private void deliverTextureFrame(int paramInt1, MediaCodec.BufferInfo paramBufferInfo, int paramInt2, Integer paramInteger)
  {
    synchronized (this.dimensionLock)
    {
      int i = this.width;
      int j = this.height;
      synchronized (this.renderedTextureMetadataLock)
      {
        if (this.renderedTextureMetadata != null)
        {
          this.codec.releaseOutputBuffer(paramInt1, false);
          return;
        }
        this.surfaceTextureHelper.setTextureSize(i, j);
        this.surfaceTextureHelper.setFrameRotation(paramInt2);
        this.renderedTextureMetadata = new DecodedTextureMetadata(paramBufferInfo.presentationTimeUs, paramInteger);
        this.codec.releaseOutputBuffer(paramInt1, true);
        return;
      }
    }
  }
  
  private VideoCodecStatus initDecodeInternal(int paramInt1, int paramInt2)
  {
    this.decoderThreadChecker.checkIsOnValidThread();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initDecodeInternal name: ");
    ((StringBuilder)localObject).append(this.codecName);
    ((StringBuilder)localObject).append(" type: ");
    ((StringBuilder)localObject).append(this.codecType);
    ((StringBuilder)localObject).append(" width: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height: ");
    ((StringBuilder)localObject).append(paramInt2);
    Logging.d("AndroidVideoDecoder", ((StringBuilder)localObject).toString());
    if (this.outputThread != null)
    {
      Logging.e("AndroidVideoDecoder", "initDecodeInternal called while the codec is already running");
      return VideoCodecStatus.FALLBACK_SOFTWARE;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.stride = paramInt1;
    this.sliceHeight = paramInt2;
    this.hasDecodedFirstFrame = false;
    this.keyFrameRequired = true;
    try
    {
      this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
      try
      {
        localObject = MediaFormat.createVideoFormat(this.codecType.mimeType(), paramInt1, paramInt2);
        if (this.sharedContext == null) {
          ((MediaFormat)localObject).setInteger("color-format", this.colorFormat);
        }
        this.codec.configure((MediaFormat)localObject, this.surface, null, 0);
        this.codec.start();
        this.running = true;
        localObject = createOutputThread();
        this.outputThread = ((Thread)localObject);
        ((Thread)localObject).start();
        Logging.d("AndroidVideoDecoder", "initDecodeInternal done");
        return VideoCodecStatus.OK;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}
      Logging.e("AndroidVideoDecoder", "initDecode failed", localIllegalStateException);
      release();
      return VideoCodecStatus.FALLBACK_SOFTWARE;
    }
    catch (IOException|IllegalArgumentException|IllegalStateException localIOException)
    {
      label261:
      StringBuilder localStringBuilder;
      break label261;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create media decoder ");
    localStringBuilder.append(this.codecName);
    Logging.e("AndroidVideoDecoder", localStringBuilder.toString());
    return VideoCodecStatus.FALLBACK_SOFTWARE;
  }
  
  private boolean isSupportedColorFormat(int paramInt)
  {
    int[] arrayOfInt = MediaCodecUtils.DECODER_COLOR_FORMATS;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void reformat(MediaFormat paramMediaFormat)
  {
    this.outputThreadChecker.checkIsOnValidThread();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Decoder format changed: ");
    ((StringBuilder)???).append(paramMediaFormat.toString());
    Logging.d("AndroidVideoDecoder", ((StringBuilder)???).toString());
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = paramMediaFormat.getInteger("crop-right") + 1 - paramMediaFormat.getInteger("crop-left");
      j = paramMediaFormat.getInteger("crop-bottom") + 1 - paramMediaFormat.getInteger("crop-top");
    }
    else
    {
      i = paramMediaFormat.getInteger("width");
      j = paramMediaFormat.getInteger("height");
    }
    synchronized (this.dimensionLock)
    {
      if ((this.hasDecodedFirstFrame) && ((this.width != i) || (this.height != j)))
      {
        paramMediaFormat = new StringBuilder();
        paramMediaFormat.append("Unexpected size change. Configured ");
        paramMediaFormat.append(this.width);
        paramMediaFormat.append("*");
        paramMediaFormat.append(this.height);
        paramMediaFormat.append(". New ");
        paramMediaFormat.append(i);
        paramMediaFormat.append("*");
        paramMediaFormat.append(j);
        stopOnOutputThread(new RuntimeException(paramMediaFormat.toString()));
        return;
      }
      this.width = i;
      this.height = j;
      if ((this.surfaceTextureHelper == null) && (paramMediaFormat.containsKey("color-format")))
      {
        this.colorFormat = paramMediaFormat.getInteger("color-format");
        ??? = new StringBuilder();
        ((StringBuilder)???).append("Color: 0x");
        ((StringBuilder)???).append(Integer.toHexString(this.colorFormat));
        Logging.d("AndroidVideoDecoder", ((StringBuilder)???).toString());
        if (!isSupportedColorFormat(this.colorFormat))
        {
          paramMediaFormat = new StringBuilder();
          paramMediaFormat.append("Unsupported color format: ");
          paramMediaFormat.append(this.colorFormat);
          stopOnOutputThread(new IllegalStateException(paramMediaFormat.toString()));
          return;
        }
      }
      synchronized (this.dimensionLock)
      {
        if (paramMediaFormat.containsKey("stride")) {
          this.stride = paramMediaFormat.getInteger("stride");
        }
        if (paramMediaFormat.containsKey("slice-height")) {
          this.sliceHeight = paramMediaFormat.getInteger("slice-height");
        }
        paramMediaFormat = new StringBuilder();
        paramMediaFormat.append("Frame stride and slice height: ");
        paramMediaFormat.append(this.stride);
        paramMediaFormat.append(" x ");
        paramMediaFormat.append(this.sliceHeight);
        Logging.d("AndroidVideoDecoder", paramMediaFormat.toString());
        this.stride = Math.max(this.width, this.stride);
        this.sliceHeight = Math.max(this.height, this.sliceHeight);
        return;
      }
    }
  }
  
  private VideoCodecStatus reinitDecode(int paramInt1, int paramInt2)
  {
    this.decoderThreadChecker.checkIsOnValidThread();
    VideoCodecStatus localVideoCodecStatus = releaseInternal();
    if (localVideoCodecStatus != VideoCodecStatus.OK) {
      return localVideoCodecStatus;
    }
    return initDecodeInternal(paramInt1, paramInt2);
  }
  
  private void releaseCodecOnOutputThread()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    Logging.d("AndroidVideoDecoder", "Releasing MediaCodec on output thread");
    try
    {
      this.codec.stop();
    }
    catch (Exception localException1)
    {
      Logging.e("AndroidVideoDecoder", "Media decoder stop failed", localException1);
    }
    try
    {
      this.codec.release();
    }
    catch (Exception localException2)
    {
      Logging.e("AndroidVideoDecoder", "Media decoder release failed", localException2);
      this.shutdownException = localException2;
    }
    Logging.d("AndroidVideoDecoder", "Release on output thread done");
  }
  
  private VideoCodecStatus releaseInternal()
  {
    if (!this.running)
    {
      Logging.d("AndroidVideoDecoder", "release: Decoder is not running.");
      return VideoCodecStatus.OK;
    }
    try
    {
      this.running = false;
      VideoCodecStatus localVideoCodecStatus;
      if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L))
      {
        Logging.e("AndroidVideoDecoder", "Media decoder release timeout", new RuntimeException());
        localVideoCodecStatus = VideoCodecStatus.TIMEOUT;
        return localVideoCodecStatus;
      }
      if (this.shutdownException != null)
      {
        Logging.e("AndroidVideoDecoder", "Media decoder release error", new RuntimeException(this.shutdownException));
        this.shutdownException = null;
        localVideoCodecStatus = VideoCodecStatus.ERROR;
        return localVideoCodecStatus;
      }
      return VideoCodecStatus.OK;
    }
    finally
    {
      this.codec = null;
      this.outputThread = null;
    }
  }
  
  private void stopOnOutputThread(Exception paramException)
  {
    this.outputThreadChecker.checkIsOnValidThread();
    this.running = false;
    this.shutdownException = paramException;
  }
  
  protected VideoFrame.I420Buffer allocateI420Buffer(int paramInt1, int paramInt2)
  {
    return JavaI420Buffer.allocate(paramInt1, paramInt2);
  }
  
  protected void copyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4)
  {
    YuvHelper.copyPlane(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramInt3, paramInt4);
  }
  
  protected SurfaceTextureHelper createSurfaceTextureHelper()
  {
    return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
  }
  
  /* Error */
  public VideoCodecStatus decode(EncodedImage paramEncodedImage, VideoDecoder.DecodeInfo paramDecodeInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 322	org/webrtc/AndroidVideoDecoder:decoderThreadChecker	Lorg/webrtc/ThreadUtils$ThreadChecker;
    //   4: invokevirtual 327	org/webrtc/ThreadUtils$ThreadChecker:checkIsOnValidThread	()V
    //   7: aload_0
    //   8: getfield 257	org/webrtc/AndroidVideoDecoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   11: astore_2
    //   12: iconst_0
    //   13: istore 8
    //   15: aload_2
    //   16: ifnull +370 -> 386
    //   19: aload_0
    //   20: getfield 287	org/webrtc/AndroidVideoDecoder:callback	Lorg/webrtc/VideoDecoder$Callback;
    //   23: ifnonnull +6 -> 29
    //   26: goto +360 -> 386
    //   29: aload_1
    //   30: getfield 531	org/webrtc/EncodedImage:buffer	Ljava/nio/ByteBuffer;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +15 -> 50
    //   38: ldc 45
    //   40: ldc_w 533
    //   43: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 536	org/webrtc/VideoCodecStatus:ERR_PARAMETER	Lorg/webrtc/VideoCodecStatus;
    //   49: areturn
    //   50: aload_2
    //   51: invokevirtual 539	java/nio/ByteBuffer:remaining	()I
    //   54: istore_3
    //   55: iload_3
    //   56: ifne +15 -> 71
    //   59: ldc 45
    //   61: ldc_w 541
    //   64: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: getstatic 536	org/webrtc/VideoCodecStatus:ERR_PARAMETER	Lorg/webrtc/VideoCodecStatus;
    //   70: areturn
    //   71: aload_0
    //   72: getfield 90	org/webrtc/AndroidVideoDecoder:dimensionLock	Ljava/lang/Object;
    //   75: astore_2
    //   76: aload_2
    //   77: monitorenter
    //   78: aload_0
    //   79: getfield 239	org/webrtc/AndroidVideoDecoder:width	I
    //   82: istore 4
    //   84: aload_0
    //   85: getfield 241	org/webrtc/AndroidVideoDecoder:height	I
    //   88: istore 5
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_1
    //   93: getfield 544	org/webrtc/EncodedImage:encodedWidth	I
    //   96: istore 6
    //   98: aload_1
    //   99: getfield 547	org/webrtc/EncodedImage:encodedHeight	I
    //   102: istore 7
    //   104: iload 6
    //   106: iload 7
    //   108: imul
    //   109: ifle +35 -> 144
    //   112: iload 6
    //   114: iload 4
    //   116: if_icmpne +10 -> 126
    //   119: iload 7
    //   121: iload 5
    //   123: if_icmpeq +21 -> 144
    //   126: aload_0
    //   127: iload 6
    //   129: iload 7
    //   131: invokespecial 549	org/webrtc/AndroidVideoDecoder:reinitDecode	(II)Lorg/webrtc/VideoCodecStatus;
    //   134: astore_2
    //   135: aload_2
    //   136: getstatic 389	org/webrtc/VideoCodecStatus:OK	Lorg/webrtc/VideoCodecStatus;
    //   139: if_acmpeq +5 -> 144
    //   142: aload_2
    //   143: areturn
    //   144: aload_0
    //   145: getfield 347	org/webrtc/AndroidVideoDecoder:keyFrameRequired	Z
    //   148: ifeq +44 -> 192
    //   151: aload_1
    //   152: getfield 553	org/webrtc/EncodedImage:frameType	Lorg/webrtc/EncodedImage$FrameType;
    //   155: getstatic 558	org/webrtc/EncodedImage$FrameType:VideoFrameKey	Lorg/webrtc/EncodedImage$FrameType;
    //   158: if_acmpeq +15 -> 173
    //   161: ldc 45
    //   163: ldc_w 560
    //   166: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: getstatic 563	org/webrtc/VideoCodecStatus:NO_OUTPUT	Lorg/webrtc/VideoCodecStatus;
    //   172: areturn
    //   173: aload_1
    //   174: getfield 566	org/webrtc/EncodedImage:completeFrame	Z
    //   177: ifne +15 -> 192
    //   180: ldc 45
    //   182: ldc_w 568
    //   185: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: getstatic 563	org/webrtc/VideoCodecStatus:NO_OUTPUT	Lorg/webrtc/VideoCodecStatus;
    //   191: areturn
    //   192: aload_0
    //   193: getfield 257	org/webrtc/AndroidVideoDecoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   196: ldc2_w 569
    //   199: invokeinterface 574 3 0
    //   204: istore 4
    //   206: iload 4
    //   208: ifge +15 -> 223
    //   211: ldc 45
    //   213: ldc_w 576
    //   216: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: getstatic 498	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   222: areturn
    //   223: aload_0
    //   224: getfield 257	org/webrtc/AndroidVideoDecoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   227: invokeinterface 579 1 0
    //   232: iload 4
    //   234: aaload
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 582	java/nio/ByteBuffer:capacity	()I
    //   240: iload_3
    //   241: if_icmpge +15 -> 256
    //   244: ldc 45
    //   246: ldc_w 584
    //   249: invokestatic 255	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: getstatic 498	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   255: areturn
    //   256: aload_2
    //   257: aload_1
    //   258: getfield 531	org/webrtc/EncodedImage:buffer	Ljava/nio/ByteBuffer;
    //   261: invokevirtual 205	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   264: pop
    //   265: aload_0
    //   266: getfield 142	org/webrtc/AndroidVideoDecoder:frameInfos	Ljava/util/concurrent/BlockingDeque;
    //   269: new 15	org/webrtc/AndroidVideoDecoder$FrameInfo
    //   272: dup
    //   273: invokestatic 589	android/os/SystemClock:elapsedRealtime	()J
    //   276: aload_1
    //   277: getfield 592	org/webrtc/EncodedImage:rotation	I
    //   280: invokespecial 595	org/webrtc/AndroidVideoDecoder$FrameInfo:<init>	(JI)V
    //   283: invokeinterface 601 2 0
    //   288: pop
    //   289: aload_0
    //   290: getfield 257	org/webrtc/AndroidVideoDecoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   293: iload 4
    //   295: iconst_0
    //   296: iload_3
    //   297: getstatic 607	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   300: aload_1
    //   301: getfield 610	org/webrtc/EncodedImage:captureTimeNs	J
    //   304: invokevirtual 614	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   307: iconst_0
    //   308: invokeinterface 618 7 0
    //   313: aload_0
    //   314: getfield 347	org/webrtc/AndroidVideoDecoder:keyFrameRequired	Z
    //   317: ifeq +8 -> 325
    //   320: aload_0
    //   321: iconst_0
    //   322: putfield 347	org/webrtc/AndroidVideoDecoder:keyFrameRequired	Z
    //   325: getstatic 389	org/webrtc/VideoCodecStatus:OK	Lorg/webrtc/VideoCodecStatus;
    //   328: areturn
    //   329: astore_1
    //   330: ldc 45
    //   332: ldc_w 620
    //   335: aload_1
    //   336: invokestatic 394	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload_0
    //   340: getfield 142	org/webrtc/AndroidVideoDecoder:frameInfos	Ljava/util/concurrent/BlockingDeque;
    //   343: invokeinterface 624 1 0
    //   348: pop
    //   349: getstatic 498	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   352: areturn
    //   353: astore_1
    //   354: ldc 45
    //   356: ldc_w 626
    //   359: aload_1
    //   360: invokestatic 394	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: getstatic 498	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   366: areturn
    //   367: astore_1
    //   368: ldc 45
    //   370: ldc_w 628
    //   373: aload_1
    //   374: invokestatic 394	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: getstatic 498	org/webrtc/VideoCodecStatus:ERROR	Lorg/webrtc/VideoCodecStatus;
    //   380: areturn
    //   381: astore_1
    //   382: aload_2
    //   383: monitorexit
    //   384: aload_1
    //   385: athrow
    //   386: new 98	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   393: astore_1
    //   394: aload_1
    //   395: ldc_w 630
    //   398: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_0
    //   403: getfield 257	org/webrtc/AndroidVideoDecoder:codec	Lorg/webrtc/MediaCodecWrapper;
    //   406: ifnull +6 -> 412
    //   409: iconst_1
    //   410: istore 8
    //   412: aload_1
    //   413: iload 8
    //   415: invokevirtual 633	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_1
    //   420: ldc_w 635
    //   423: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: aload_0
    //   429: getfield 287	org/webrtc/AndroidVideoDecoder:callback	Lorg/webrtc/VideoDecoder$Callback;
    //   432: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 45
    //   438: aload_1
    //   439: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 127	org/webrtc/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: getstatic 638	org/webrtc/VideoCodecStatus:UNINITIALIZED	Lorg/webrtc/VideoCodecStatus;
    //   448: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	AndroidVideoDecoder
    //   0	449	1	paramEncodedImage	EncodedImage
    //   0	449	2	paramDecodeInfo	VideoDecoder.DecodeInfo
    //   54	243	3	i	int
    //   82	212	4	j	int
    //   88	36	5	k	int
    //   96	32	6	m	int
    //   102	28	7	n	int
    //   13	401	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   289	313	329	java/lang/IllegalStateException
    //   223	236	353	java/lang/IllegalStateException
    //   192	206	367	java/lang/IllegalStateException
    //   78	92	381	finally
    //   382	384	381	finally
  }
  
  protected void deliverDecodedFrame()
  {
    this.outputThreadChecker.checkIsOnValidThread();
    try
    {
      MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
      int j = this.codec.dequeueOutputBuffer(localBufferInfo, 100000L);
      if (j == -2)
      {
        reformat(this.codec.getOutputFormat());
        return;
      }
      if (j < 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dequeueOutputBuffer returned ");
        ((StringBuilder)localObject).append(j);
        Logging.v("AndroidVideoDecoder", ((StringBuilder)localObject).toString());
        return;
      }
      FrameInfo localFrameInfo = (FrameInfo)this.frameInfos.poll();
      Object localObject = null;
      int i = 0;
      if (localFrameInfo != null)
      {
        localObject = Integer.valueOf((int)(SystemClock.elapsedRealtime() - localFrameInfo.decodeStartTimeMs));
        i = localFrameInfo.rotation;
      }
      this.hasDecodedFirstFrame = true;
      if (this.surfaceTextureHelper != null)
      {
        deliverTextureFrame(j, localBufferInfo, i, (Integer)localObject);
        return;
      }
      deliverByteFrame(j, localBufferInfo, i, (Integer)localObject);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logging.e("AndroidVideoDecoder", "deliverDecodedFrame failed", localIllegalStateException);
    }
  }
  
  public String getImplementationName()
  {
    return this.codecName;
  }
  
  public boolean getPrefersLateDecoding()
  {
    return true;
  }
  
  public VideoCodecStatus initDecode(VideoDecoder.Settings paramSettings, VideoDecoder.Callback paramCallback)
  {
    this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
    this.callback = paramCallback;
    if (this.sharedContext != null)
    {
      this.surfaceTextureHelper = createSurfaceTextureHelper();
      this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
      this.surfaceTextureHelper.startListening(this);
    }
    return initDecodeInternal(paramSettings.width, paramSettings.height);
  }
  
  public void onFrame(VideoFrame paramVideoFrame)
  {
    synchronized (this.renderedTextureMetadataLock)
    {
      Object localObject2 = this.renderedTextureMetadata;
      if (localObject2 != null)
      {
        long l = ((DecodedTextureMetadata)localObject2).presentationTimestampUs;
        localObject2 = ((DecodedTextureMetadata)localObject2).decodeTimeMs;
        this.renderedTextureMetadata = null;
        paramVideoFrame = new VideoFrame(paramVideoFrame.getBuffer(), paramVideoFrame.getRotation(), l * 1000L);
        this.callback.onDecodedFrame(paramVideoFrame, (Integer)localObject2, null);
        return;
      }
      throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
    }
  }
  
  public VideoCodecStatus release()
  {
    Logging.d("AndroidVideoDecoder", "release");
    VideoCodecStatus localVideoCodecStatus = releaseInternal();
    if (this.surface != null)
    {
      releaseSurface();
      this.surface = null;
      this.surfaceTextureHelper.stopListening();
      this.surfaceTextureHelper.dispose();
      this.surfaceTextureHelper = null;
    }
    synchronized (this.renderedTextureMetadataLock)
    {
      this.renderedTextureMetadata = null;
      this.callback = null;
      this.frameInfos.clear();
      return localVideoCodecStatus;
    }
  }
  
  protected void releaseSurface()
  {
    this.surface.release();
  }
  
  private static class DecodedTextureMetadata
  {
    final Integer decodeTimeMs;
    final long presentationTimestampUs;
    
    DecodedTextureMetadata(long paramLong, Integer paramInteger)
    {
      this.presentationTimestampUs = paramLong;
      this.decodeTimeMs = paramInteger;
    }
  }
  
  private static class FrameInfo
  {
    final long decodeStartTimeMs;
    final int rotation;
    
    FrameInfo(long paramLong, int paramInt)
    {
      this.decodeStartTimeMs = paramLong;
      this.rotation = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.AndroidVideoDecoder
 * JD-Core Version:    0.7.0.1
 */