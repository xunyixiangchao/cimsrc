package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import android.view.Surface;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import s.g2;
import s.g2.b;
import s.g2.c;
import s.g2.f;
import s.j1;
import s.m1;
import s.r0;
import s.s0;
import s.t1;
import s.t2;
import s.t2.a;
import s.u1;
import s.u2;
import s.u2.b;
import s.v0;
import s.y1;
import v.i;
import z.d;

public final class f3
  extends v2
{
  public static final e S = new e();
  private static final int[] T = { 8, 6, 5, 4 };
  private g2.b A = new g2.b();
  private MediaMuxer B;
  private final AtomicBoolean C = new AtomicBoolean(false);
  private int D;
  private int E;
  Surface F;
  private volatile AudioRecord G;
  private volatile int H;
  private volatile boolean I = false;
  private int J;
  private int K;
  private int L;
  private v0 M;
  volatile Uri N;
  private volatile ParcelFileDescriptor O;
  private final AtomicBoolean P = new AtomicBoolean(true);
  private j Q = j.a;
  private Throwable R;
  private final MediaCodec.BufferInfo l = new MediaCodec.BufferInfo();
  private final Object m = new Object();
  private final AtomicBoolean n = new AtomicBoolean(true);
  private final AtomicBoolean o = new AtomicBoolean(true);
  private final AtomicBoolean p = new AtomicBoolean(true);
  private final MediaCodec.BufferInfo q = new MediaCodec.BufferInfo();
  public final AtomicBoolean r = new AtomicBoolean(false);
  public final AtomicBoolean s = new AtomicBoolean(false);
  private HandlerThread t;
  private Handler u;
  private HandlerThread v;
  private Handler w;
  MediaCodec x;
  private MediaCodec y;
  private u7.a<Void> z = null;
  
  f3(s.v2 paramv2)
  {
    super(paramv2);
  }
  
  private AudioRecord T(s.v2 paramv2)
  {
    int i;
    if (this.J == 1) {
      i = 16;
    } else {
      i = 12;
    }
    try
    {
      int k = AudioRecord.getMinBufferSize(this.K, i, 2);
      int j = k;
      if (k <= 0) {
        j = paramv2.K();
      }
      paramv2 = new AudioRecord(5, this.K, i, 2, j * 2);
      if (paramv2.getState() == 1)
      {
        this.H = j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("source: 5 audioSampleRate: ");
        localStringBuilder.append(this.K);
        localStringBuilder.append(" channelConfig: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" audioFormat: ");
        localStringBuilder.append(2);
        localStringBuilder.append(" bufferSize: ");
        localStringBuilder.append(j);
        n1.e("VideoCapture", localStringBuilder.toString());
        return paramv2;
      }
    }
    catch (Exception paramv2)
    {
      n1.d("VideoCapture", "Exception, keep trying.", paramv2);
    }
    return null;
  }
  
  private MediaFormat U()
  {
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.K, this.J);
    localMediaFormat.setInteger("aac-profile", 2);
    localMediaFormat.setInteger("bitrate", this.L);
    return localMediaFormat;
  }
  
  private static MediaFormat V(s.v2 paramv2, Size paramSize)
  {
    paramSize = MediaFormat.createVideoFormat("video/avc", paramSize.getWidth(), paramSize.getHeight());
    paramSize.setInteger("color-format", 2130708361);
    paramSize.setInteger("bitrate", paramv2.M());
    paramSize.setInteger("frame-rate", paramv2.O());
    paramSize.setInteger("i-frame-interval", paramv2.N());
    return paramSize;
  }
  
  private ByteBuffer W(MediaCodec paramMediaCodec, int paramInt)
  {
    return paramMediaCodec.getInputBuffer(paramInt);
  }
  
  private ByteBuffer X(MediaCodec paramMediaCodec, int paramInt)
  {
    return paramMediaCodec.getOutputBuffer(paramInt);
  }
  
  private MediaMuxer Y(h paramh)
  {
    Object localObject;
    if (paramh.g())
    {
      localObject = paramh.c();
      this.N = Uri.fromFile(paramh.c());
      return new MediaMuxer(((File)localObject).getAbsolutePath(), 0);
    }
    if (paramh.h())
    {
      if (Build.VERSION.SDK_INT >= 26) {
        return c.a(paramh.d(), 0);
      }
      throw new IllegalArgumentException("Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
    }
    if (paramh.i())
    {
      if (paramh.b() != null) {
        localObject = new ContentValues(paramh.b());
      } else {
        localObject = new ContentValues();
      }
      this.N = paramh.a().insert(paramh.f(), (ContentValues)localObject);
      if (this.N != null) {
        try
        {
          if (Build.VERSION.SDK_INT < 26)
          {
            paramh = d.a(paramh.a(), this.N);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Saved Location Path: ");
            ((StringBuilder)localObject).append(paramh);
            n1.e("VideoCapture", ((StringBuilder)localObject).toString());
            return new MediaMuxer(paramh, 0);
          }
          this.O = paramh.a().openFileDescriptor(this.N, "rw");
          paramh = c.a(this.O.getFileDescriptor(), 0);
          return paramh;
        }
        catch (IOException paramh)
        {
          this.N = null;
          throw paramh;
        }
      }
      throw new IOException("Invalid Uri!");
    }
    throw new IllegalArgumentException("The OutputFileOptions should assign before recording");
  }
  
  private void h0()
  {
    this.v.quitSafely();
    MediaCodec localMediaCodec = this.y;
    if (localMediaCodec != null)
    {
      localMediaCodec.release();
      this.y = null;
    }
    if (this.G != null)
    {
      this.G.release();
      this.G = null;
    }
  }
  
  private void i0(boolean paramBoolean)
  {
    v0 localv0 = this.M;
    if (localv0 == null) {
      return;
    }
    MediaCodec localMediaCodec = this.x;
    localv0.c();
    this.M.i().h(new e3(paramBoolean, localMediaCodec), t.a.d());
    if (paramBoolean) {
      this.x = null;
    }
    this.F = null;
    this.M = null;
  }
  
  private void j0()
  {
    this.t.quitSafely();
    h0();
    if (this.F != null) {
      i0(true);
    }
  }
  
  private boolean k0(h paramh)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check Recording Result First Video Key Frame Write: ");
    localStringBuilder.append(this.r.get());
    n1.e("VideoCapture", localStringBuilder.toString());
    boolean bool;
    if (!this.r.get())
    {
      n1.e("VideoCapture", "The recording result has no key frame.");
      bool = false;
    }
    else
    {
      bool = true;
    }
    if (paramh.g())
    {
      paramh = paramh.c();
      if (!bool)
      {
        n1.e("VideoCapture", "Delete file.");
        paramh.delete();
        return bool;
      }
    }
    else if ((paramh.i()) && (!bool))
    {
      n1.e("VideoCapture", "Delete file.");
      if (this.N != null) {
        paramh.a().delete(this.N, null, null);
      }
    }
    return bool;
  }
  
  private void l0(Size paramSize, String paramString)
  {
    int k = 0;
    try
    {
      int[] arrayOfInt = T;
      int i1 = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= i1) {
          break;
        }
        j = arrayOfInt[i];
        if (CamcorderProfile.hasProfile(Integer.parseInt(paramString), j))
        {
          CamcorderProfile localCamcorderProfile = CamcorderProfile.get(Integer.parseInt(paramString), j);
          if ((paramSize.getWidth() == localCamcorderProfile.videoFrameWidth) && (paramSize.getHeight() == localCamcorderProfile.videoFrameHeight))
          {
            this.J = localCamcorderProfile.audioChannels;
            this.K = localCamcorderProfile.audioSampleRate;
            this.L = localCamcorderProfile.audioBitRate;
            j = 1;
            break;
          }
        }
        i += 1;
      }
    }
    catch (NumberFormatException paramSize)
    {
      int j;
      label118:
      break label118;
    }
    n1.e("VideoCapture", "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.");
    j = k;
    if (j == 0)
    {
      paramSize = (s.v2)g();
      this.J = paramSize.J();
      this.K = paramSize.L();
      this.L = paramSize.I();
    }
  }
  
  private boolean q0(int paramInt)
  {
    ByteBuffer localByteBuffer = X(this.y, paramInt);
    localByteBuffer.position(this.q.offset);
    if (this.C.get()) {
      try
      {
        ??? = this.q;
        if ((((MediaCodec.BufferInfo)???).size > 0) && (((MediaCodec.BufferInfo)???).presentationTimeUs > 0L)) {
          synchronized (this.m)
          {
            if (!this.s.get())
            {
              n1.e("VideoCapture", "First audio sample written.");
              this.s.set(true);
            }
            this.B.writeSampleData(this.E, localByteBuffer, this.q);
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioBufferInfo size: ");
        localStringBuilder.append(this.q.size);
        localStringBuilder.append(" presentationTimeUs: ");
        localStringBuilder.append(this.q.presentationTimeUs);
        n1.e("VideoCapture", localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("audio error:size=");
        ((StringBuilder)???).append(this.q.size);
        ((StringBuilder)???).append("/offset=");
        ((StringBuilder)???).append(this.q.offset);
        ((StringBuilder)???).append("/timeUs=");
        ((StringBuilder)???).append(this.q.presentationTimeUs);
        n1.c("VideoCapture", ((StringBuilder)???).toString());
        localException.printStackTrace();
      }
    }
    this.y.releaseOutputBuffer(paramInt, false);
    return (this.q.flags & 0x4) != 0;
  }
  
  private boolean r0(int paramInt)
  {
    boolean bool = false;
    if (paramInt < 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Output buffer should not have negative index: ");
      ((StringBuilder)localObject1).append(paramInt);
      n1.c("VideoCapture", ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject1 = this.x.getOutputBuffer(paramInt);
    if (localObject1 == null)
    {
      n1.a("VideoCapture", "OutputBuffer was null.");
      return false;
    }
    if (this.C.get())
    {
      ??? = this.l;
      if (((MediaCodec.BufferInfo)???).size > 0)
      {
        ((ByteBuffer)localObject1).position(((MediaCodec.BufferInfo)???).offset);
        ??? = this.l;
        ((ByteBuffer)localObject1).limit(((MediaCodec.BufferInfo)???).offset + ((MediaCodec.BufferInfo)???).size);
        this.l.presentationTimeUs = (System.nanoTime() / 1000L);
      }
    }
    for (;;)
    {
      synchronized (this.m)
      {
        if (!this.r.get())
        {
          if ((this.l.flags & 0x1) == 0) {
            break label317;
          }
          i = 1;
          if (i != 0)
          {
            n1.e("VideoCapture", "First video key frame written.");
            this.r.set(true);
          }
          else
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("request-sync", 0);
            this.x.setParameters(localBundle);
          }
        }
        this.B.writeSampleData(this.D, (ByteBuffer)localObject1, this.l);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mVideoBufferInfo.size <= 0, index ");
      localStringBuilder.append(paramInt);
      n1.e("VideoCapture", localStringBuilder.toString());
      this.x.releaseOutputBuffer(paramInt, false);
      if ((this.l.flags & 0x4) != 0) {
        bool = true;
      }
      return bool;
      label317:
      int i = 0;
    }
  }
  
  public void A()
  {
    o0();
    u7.a locala = this.z;
    if (locala != null)
    {
      locala.h(new a3(this), t.a.d());
      return;
    }
    j0();
  }
  
  public void D()
  {
    o0();
  }
  
  protected Size E(Size paramSize)
  {
    if (this.F != null)
    {
      this.x.stop();
      this.x.release();
      this.y.stop();
      this.y.release();
      i0(false);
    }
    try
    {
      this.x = MediaCodec.createEncoderByType("video/avc");
      this.y = MediaCodec.createEncoderByType("audio/mp4a-latm");
      m0(f(), paramSize);
      r();
      return paramSize;
    }
    catch (IOException paramSize)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to create MediaCodec due to: ");
      localStringBuilder.append(paramSize.getCause());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  boolean S(g paramg)
  {
    long l1 = 0L;
    boolean bool1 = false;
    for (;;)
    {
      int j;
      boolean bool3;
      long l3;
      long l2;
      int i;
      if ((!bool1) && (this.I))
      {
        if (this.o.get())
        {
          this.o.set(false);
          this.I = false;
        }
        if ((this.y == null) || (this.G == null)) {
          continue;
        }
        label150:
        StringBuilder localStringBuilder;
        try
        {
          j = this.y.dequeueInputBuffer(-1L);
          bool3 = bool1;
          l3 = l1;
          if (j < 0) {
            break label256;
          }
          Object localObject1 = W(this.y, j);
          ((ByteBuffer)localObject1).clear();
          int k = this.G.read((ByteBuffer)localObject1, this.H);
          bool3 = bool1;
          l3 = l1;
          if (k <= 0) {
            break label256;
          }
          localObject1 = this.y;
          l2 = System.nanoTime() / 1000L;
          if (!this.I) {
            break label555;
          }
          i = 0;
          ((MediaCodec)localObject1).queueInputBuffer(j, 0, k, l2, i);
          bool3 = bool1;
          l3 = l1;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("audio dequeueInputBuffer IllegalStateException ");
          String str = localIllegalStateException1.getMessage();
        }
        catch (MediaCodec.CodecException localCodecException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("audio dequeueInputBuffer CodecException ");
          ??? = localCodecException.getMessage();
        }
        localStringBuilder.append((String)???);
        n1.e("VideoCapture", localStringBuilder.toString());
        l3 = l1;
        bool3 = bool1;
      }
      label256:
      boolean bool2;
      label555:
      do
      {
        i = this.y.dequeueOutputBuffer(this.q, 0L);
        if (i != -2)
        {
          bool2 = bool3;
          l2 = l3;
          if (i != -1) {
            if (this.q.presentationTimeUs > l3)
            {
              bool2 = q0(i);
              l2 = this.q.presentationTimeUs;
            }
            else
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("Drops frame, current frame's timestamp ");
              ((StringBuilder)???).append(this.q.presentationTimeUs);
              ((StringBuilder)???).append(" is earlier that last frame ");
              ((StringBuilder)???).append(l3);
              n1.k("VideoCapture", ((StringBuilder)???).toString());
              this.y.releaseOutputBuffer(i, false);
              bool2 = bool3;
              l2 = l3;
            }
          }
        }
        else
        {
          synchronized (this.m)
          {
            j = this.B.addTrack(this.y.getOutputFormat());
            this.E = j;
            if ((j >= 0) && (this.D >= 0))
            {
              n1.e("VideoCapture", "MediaMuxer start on audio encoder thread.");
              this.B.start();
              this.C.set(true);
            }
            bool2 = bool3;
            l2 = l3;
          }
          try
          {
            n1.e("VideoCapture", "audioRecorder stop");
            this.G.stop();
          }
          catch (IllegalStateException localIllegalStateException2)
          {
            paramg.A(1, "Audio recorder stop failed!", localIllegalStateException2);
          }
          try
          {
            this.y.stop();
          }
          catch (IllegalStateException localIllegalStateException3)
          {
            paramg.A(1, "Audio encoder stop failed!", localIllegalStateException3);
          }
          n1.e("VideoCapture", "Audio encode thread end");
          this.n.set(true);
          return false;
          i = 4;
          break label150;
        }
        bool1 = bool2;
        l1 = l2;
        if (i < 0) {
          break;
        }
        bool3 = bool2;
        l3 = l2;
      } while (!bool2);
      bool1 = bool2;
      l1 = l2;
    }
  }
  
  public t2<?> h(boolean paramBoolean, u2 paramu2)
  {
    s0 locals0 = paramu2.a(u2.b.d, 1);
    paramu2 = locals0;
    if (paramBoolean) {
      paramu2 = r0.b(locals0, S.a());
    }
    if (paramu2 == null) {
      return null;
    }
    return n(paramu2).b();
  }
  
  void m0(String arg1, final Size paramSize)
  {
    Object localObject1 = (s.v2)g();
    this.x.reset();
    this.Q = j.a;
    try
    {
      try
      {
        this.x.configure(V((s.v2)localObject1, paramSize), null, null, 1);
        if (this.F != null) {
          i0(false);
        }
        Surface localSurface = this.x.createInputSurface();
        this.F = localSurface;
        this.A = g2.b.p((t2)localObject1);
        Object localObject2 = this.M;
        if (localObject2 != null) {
          ((v0)localObject2).c();
        }
        localObject2 = new m1(this.F, paramSize, i());
        this.M = ((v0)localObject2);
        localObject2 = ((v0)localObject2).i();
        Objects.requireNonNull(localSurface);
        ((u7.a)localObject2).h(new x2(localSurface), t.a.d());
        this.A.h(this.M);
        this.A.f(new a(???, paramSize));
        I(this.A.n());
        this.P.set(true);
        l0(paramSize, ???);
        this.y.reset();
        this.y.configure(U(), null, null, 1);
        if (this.G != null) {
          this.G.release();
        }
        this.G = T((s.v2)localObject1);
        if (this.G == null)
        {
          n1.c("VideoCapture", "AudioRecord object cannot initialized correctly!");
          this.P.set(false);
        }
        synchronized (this.m)
        {
          this.D = -1;
          this.E = -1;
          this.I = false;
          return;
        }
        this.Q = j.b;
      }
      catch (IllegalStateException ???) {}catch (IllegalArgumentException ???) {}
      this.R = ???;
      return;
    }
    catch (MediaCodec.CodecException paramSize)
    {
      int i = b.a(paramSize);
      ??? = paramSize.getDiagnosticInfo();
      if (i == 1100)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CodecException: code: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" diagnostic: ");
        ((StringBuilder)localObject1).append(???);
        n1.e("VideoCapture", ((StringBuilder)localObject1).toString());
      }
      for (??? = j.c;; ??? = j.d)
      {
        this.Q = ???;
        break;
        if (i != 1101) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CodecException: code: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" diagnostic: ");
        ((StringBuilder)localObject1).append(???);
        n1.e("VideoCapture", ((StringBuilder)localObject1).toString());
      }
      this.R = paramSize;
    }
  }
  
  public t2.a<?, ?, ?> n(s0 params0)
  {
    return d.d(params0);
  }
  
  /* Error */
  public void n0(h paramh, Executor paramExecutor, g paramg)
  {
    // Byte code:
    //   0: invokestatic 860	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   3: invokestatic 863	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +23 -> 29
    //   9: invokestatic 485	t/a:d	()Ljava/util/concurrent/ScheduledExecutorService;
    //   12: new 865	androidx/camera/core/d3
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: invokespecial 867	androidx/camera/core/d3:<init>	(Landroidx/camera/core/f3;Landroidx/camera/core/f3$h;Ljava/util/concurrent/Executor;Landroidx/camera/core/f3$g;)V
    //   23: invokeinterface 873 2 0
    //   28: return
    //   29: ldc 230
    //   31: ldc_w 416
    //   34: invokestatic 239	androidx/camera/core/n1:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 133	androidx/camera/core/f3:r	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   41: iconst_0
    //   42: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   45: aload_0
    //   46: getfield 135	androidx/camera/core/f3:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   49: iconst_0
    //   50: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   53: new 38	androidx/camera/core/f3$k
    //   56: dup
    //   57: aload_2
    //   58: aload_3
    //   59: invokespecial 876	androidx/camera/core/f3$k:<init>	(Ljava/util/concurrent/Executor;Landroidx/camera/core/f3$g;)V
    //   62: astore_2
    //   63: aload_0
    //   64: invokevirtual 419	androidx/camera/core/v2:d	()Ls/g0;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnonnull +46 -> 117
    //   74: new 212	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc_w 878
    //   86: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: aload_0
    //   92: invokevirtual 678	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc_w 880
    //   100: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: iconst_5
    //   106: aload_1
    //   107: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: aconst_null
    //   111: invokeinterface 743 4 0
    //   116: return
    //   117: aload_0
    //   118: getfield 152	androidx/camera/core/f3:Q	Landroidx/camera/core/f3$j;
    //   121: astore_3
    //   122: aload_3
    //   123: getstatic 848	androidx/camera/core/f3$j:c	Landroidx/camera/core/f3$j;
    //   126: if_acmpeq +541 -> 667
    //   129: aload_3
    //   130: getstatic 834	androidx/camera/core/f3$j:b	Landroidx/camera/core/f3$j;
    //   133: if_acmpeq +534 -> 667
    //   136: aload_3
    //   137: getstatic 850	androidx/camera/core/f3$j:d	Landroidx/camera/core/f3$j;
    //   140: if_acmpne +6 -> 146
    //   143: goto +524 -> 667
    //   146: aload_0
    //   147: getfield 129	androidx/camera/core/f3:p	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   150: invokevirtual 505	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   153: ifne +15 -> 168
    //   156: aload_2
    //   157: iconst_3
    //   158: ldc_w 882
    //   161: aconst_null
    //   162: invokeinterface 743 4 0
    //   167: return
    //   168: aload_0
    //   169: getfield 148	androidx/camera/core/f3:P	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   172: invokevirtual 505	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   175: ifeq +135 -> 310
    //   178: aload_0
    //   179: getfield 463	androidx/camera/core/f3:G	Landroid/media/AudioRecord;
    //   182: invokevirtual 208	android/media/AudioRecord:getState	()I
    //   185: iconst_1
    //   186: if_icmpne +64 -> 250
    //   189: aload_0
    //   190: getfield 463	androidx/camera/core/f3:G	Landroid/media/AudioRecord;
    //   193: invokevirtual 884	android/media/AudioRecord:startRecording	()V
    //   196: goto +54 -> 250
    //   199: astore_3
    //   200: new 212	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   207: astore 5
    //   209: aload 5
    //   211: ldc_w 886
    //   214: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 5
    //   220: aload_3
    //   221: invokevirtual 708	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 230
    //   230: aload 5
    //   232: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 239	androidx/camera/core/n1:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: getfield 148	androidx/camera/core/f3:P	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   242: iconst_0
    //   243: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   246: aload_0
    //   247: invokespecial 496	androidx/camera/core/f3:h0	()V
    //   250: aload_0
    //   251: getfield 463	androidx/camera/core/f3:G	Landroid/media/AudioRecord;
    //   254: invokevirtual 889	android/media/AudioRecord:getRecordingState	()I
    //   257: iconst_3
    //   258: if_icmpeq +52 -> 310
    //   261: new 212	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   268: astore_3
    //   269: aload_3
    //   270: ldc_w 891
    //   273: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_3
    //   278: aload_0
    //   279: getfield 463	androidx/camera/core/f3:G	Landroid/media/AudioRecord;
    //   282: invokevirtual 889	android/media/AudioRecord:getRecordingState	()I
    //   285: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: ldc 230
    //   291: aload_3
    //   292: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 239	androidx/camera/core/n1:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: getfield 148	androidx/camera/core/f3:P	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   302: iconst_0
    //   303: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   306: aload_0
    //   307: invokespecial 496	androidx/camera/core/f3:h0	()V
    //   310: new 410	java/util/concurrent/atomic/AtomicReference
    //   313: dup
    //   314: invokespecial 892	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   317: astore_3
    //   318: aload_0
    //   319: new 894	androidx/camera/core/w2
    //   322: dup
    //   323: aload_3
    //   324: invokespecial 897	androidx/camera/core/w2:<init>	(Ljava/util/concurrent/atomic/AtomicReference;)V
    //   327: invokestatic 902	androidx/concurrent/futures/c:a	(Landroidx/concurrent/futures/c$c;)Lu7/a;
    //   330: putfield 137	androidx/camera/core/f3:z	Lu7/a;
    //   333: aload_3
    //   334: invokevirtual 905	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   337: checkcast 445	androidx/concurrent/futures/c$a
    //   340: invokestatic 909	x0/h:g	(Ljava/lang/Object;)Ljava/lang/Object;
    //   343: checkcast 445	androidx/concurrent/futures/c$a
    //   346: astore_3
    //   347: aload_0
    //   348: getfield 137	androidx/camera/core/f3:z	Lu7/a;
    //   351: new 911	androidx/camera/core/y2
    //   354: dup
    //   355: aload_0
    //   356: invokespecial 912	androidx/camera/core/y2:<init>	(Landroidx/camera/core/f3;)V
    //   359: invokestatic 485	t/a:d	()Ljava/util/concurrent/ScheduledExecutorService;
    //   362: invokeinterface 490 3 0
    //   367: ldc 230
    //   369: ldc_w 914
    //   372: invokestatic 239	androidx/camera/core/n1:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 469	androidx/camera/core/f3:x	Landroid/media/MediaCodec;
    //   379: invokevirtual 915	android/media/MediaCodec:start	()V
    //   382: aload_0
    //   383: getfield 148	androidx/camera/core/f3:P	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: invokevirtual 505	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   389: ifeq +18 -> 407
    //   392: ldc 230
    //   394: ldc_w 917
    //   397: invokestatic 239	androidx/camera/core/n1:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 461	androidx/camera/core/f3:y	Landroid/media/MediaCodec;
    //   404: invokevirtual 915	android/media/MediaCodec:start	()V
    //   407: aload_0
    //   408: getfield 118	androidx/camera/core/f3:m	Ljava/lang/Object;
    //   411: astore 5
    //   413: aload 5
    //   415: monitorenter
    //   416: aload_0
    //   417: aload_1
    //   418: invokespecial 919	androidx/camera/core/f3:Y	(Landroidx/camera/core/f3$h;)Landroid/media/MediaMuxer;
    //   421: astore 6
    //   423: aload_0
    //   424: aload 6
    //   426: putfield 588	androidx/camera/core/f3:B	Landroid/media/MediaMuxer;
    //   429: aload 6
    //   431: invokestatic 909	x0/h:g	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: aload_0
    //   436: getfield 588	androidx/camera/core/f3:B	Landroid/media/MediaMuxer;
    //   439: aload_0
    //   440: aload 4
    //   442: invokevirtual 922	androidx/camera/core/v2:k	(Ls/g0;)I
    //   445: invokevirtual 926	android/media/MediaMuxer:setOrientationHint	(I)V
    //   448: aload_1
    //   449: invokevirtual 929	androidx/camera/core/f3$h:e	()Landroidx/camera/core/f3$f;
    //   452: astore 4
    //   454: aload 4
    //   456: ifnull +37 -> 493
    //   459: aload 4
    //   461: getfield 932	androidx/camera/core/f3$f:a	Landroid/location/Location;
    //   464: astore 6
    //   466: aload 6
    //   468: ifnull +25 -> 493
    //   471: aload_0
    //   472: getfield 588	androidx/camera/core/f3:B	Landroid/media/MediaMuxer;
    //   475: aload 6
    //   477: invokevirtual 938	android/location/Location:getLatitude	()D
    //   480: d2f
    //   481: aload 4
    //   483: getfield 932	androidx/camera/core/f3$f:a	Landroid/location/Location;
    //   486: invokevirtual 941	android/location/Location:getLongitude	()D
    //   489: d2f
    //   490: invokevirtual 945	android/media/MediaMuxer:setLocation	(FF)V
    //   493: aload 5
    //   495: monitorexit
    //   496: aload_0
    //   497: getfield 125	androidx/camera/core/f3:n	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   500: iconst_0
    //   501: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   504: aload_0
    //   505: getfield 127	androidx/camera/core/f3:o	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   508: iconst_0
    //   509: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   512: aload_0
    //   513: getfield 129	androidx/camera/core/f3:p	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   516: iconst_0
    //   517: invokevirtual 586	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   520: aload_0
    //   521: iconst_1
    //   522: putfield 146	androidx/camera/core/f3:I	Z
    //   525: aload_0
    //   526: getfield 142	androidx/camera/core/f3:A	Ls/g2$b;
    //   529: invokevirtual 948	s/g2$b:o	()Ls/g2$b;
    //   532: pop
    //   533: aload_0
    //   534: getfield 142	androidx/camera/core/f3:A	Ls/g2$b;
    //   537: aload_0
    //   538: getfield 467	androidx/camera/core/f3:M	Ls/v0;
    //   541: invokevirtual 950	s/g2$b:l	(Ls/v0;)Ls/g2$b;
    //   544: pop
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 142	androidx/camera/core/f3:A	Ls/g2$b;
    //   550: invokevirtual 821	s/g2$b:n	()Ls/g2;
    //   553: invokevirtual 824	androidx/camera/core/v2:I	(Ls/g2;)V
    //   556: aload_0
    //   557: invokevirtual 952	androidx/camera/core/v2:v	()V
    //   560: aload_0
    //   561: getfield 148	androidx/camera/core/f3:P	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   564: invokevirtual 505	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   567: ifeq +20 -> 587
    //   570: aload_0
    //   571: getfield 954	androidx/camera/core/f3:w	Landroid/os/Handler;
    //   574: new 956	androidx/camera/core/b3
    //   577: dup
    //   578: aload_0
    //   579: aload_2
    //   580: invokespecial 958	androidx/camera/core/b3:<init>	(Landroidx/camera/core/f3;Landroidx/camera/core/f3$g;)V
    //   583: invokevirtual 964	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   586: pop
    //   587: aload_0
    //   588: invokevirtual 421	androidx/camera/core/v2:f	()Ljava/lang/String;
    //   591: astore 4
    //   593: aload_0
    //   594: invokevirtual 424	androidx/camera/core/v2:c	()Landroid/util/Size;
    //   597: astore 5
    //   599: aload_0
    //   600: getfield 966	androidx/camera/core/f3:u	Landroid/os/Handler;
    //   603: new 968	androidx/camera/core/c3
    //   606: dup
    //   607: aload_0
    //   608: aload_2
    //   609: aload 4
    //   611: aload 5
    //   613: aload_1
    //   614: aload_3
    //   615: invokespecial 970	androidx/camera/core/c3:<init>	(Landroidx/camera/core/f3;Landroidx/camera/core/f3$g;Ljava/lang/String;Landroid/util/Size;Landroidx/camera/core/f3$h;Landroidx/concurrent/futures/c$a;)V
    //   618: invokevirtual 964	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   621: pop
    //   622: return
    //   623: astore_1
    //   624: aload 5
    //   626: monitorexit
    //   627: aload_1
    //   628: athrow
    //   629: astore_1
    //   630: aload_3
    //   631: aconst_null
    //   632: invokevirtual 448	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   635: pop
    //   636: aload_2
    //   637: iconst_2
    //   638: ldc_w 972
    //   641: aload_1
    //   642: invokeinterface 743 4 0
    //   647: return
    //   648: astore_1
    //   649: aload_3
    //   650: aconst_null
    //   651: invokevirtual 448	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   654: pop
    //   655: aload_2
    //   656: iconst_1
    //   657: ldc_w 974
    //   660: aload_1
    //   661: invokeinterface 743 4 0
    //   666: return
    //   667: aload_2
    //   668: iconst_1
    //   669: ldc_w 976
    //   672: aload_0
    //   673: getfield 836	androidx/camera/core/f3:R	Ljava/lang/Throwable;
    //   676: invokeinterface 743 4 0
    //   681: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	f3
    //   0	682	1	paramh	h
    //   0	682	2	paramExecutor	Executor
    //   0	682	3	paramg	g
    //   67	543	4	localObject1	Object
    //   421	55	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   178	196	199	java/lang/IllegalStateException
    //   416	454	623	finally
    //   459	466	623	finally
    //   471	493	623	finally
    //   493	496	623	finally
    //   624	627	623	finally
    //   407	416	629	java/io/IOException
    //   627	629	629	java/io/IOException
    //   367	407	648	java/lang/IllegalStateException
  }
  
  public void o0()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      t.a.d().execute(new z2(this));
      return;
    }
    n1.e("VideoCapture", "stopRecording");
    this.A.o();
    this.A.h(this.M);
    I(this.A.n());
    v();
    if (this.I)
    {
      AtomicBoolean localAtomicBoolean;
      if (this.P.get()) {
        localAtomicBoolean = this.o;
      } else {
        localAtomicBoolean = this.n;
      }
      localAtomicBoolean.set(true);
    }
  }
  
  boolean p0(g paramg, String arg2, Size paramSize, h paramh)
  {
    bool2 = false;
    boolean bool1 = bool2;
    while ((!bool2) && (!bool1))
    {
      if (this.n.get())
      {
        this.x.signalEndOfInputStream();
        this.n.set(false);
      }
      int i = this.x.dequeueOutputBuffer(this.l, 10000L);
      if (i != -2)
      {
        if (i != -1) {
          bool2 = r0(i);
        }
      }
      else
      {
        if (this.C.get())
        {
          paramg.A(1, "Unexpected change in video encoding format.", null);
          bool1 = true;
        }
        synchronized (this.m)
        {
          this.D = this.B.addTrack(this.x.getOutputFormat());
          if (((this.P.get()) && (this.E >= 0) && (this.D >= 0)) || ((!this.P.get()) && (this.D >= 0)))
          {
            paramSize = new StringBuilder();
            paramSize.append("MediaMuxer started on video encode thread and audio enabled: ");
            paramSize.append(this.P);
            n1.e("VideoCapture", paramSize.toString());
            this.B.start();
            this.C.set(true);
          }
        }
      }
    }
    try
    {
      n1.e("VideoCapture", "videoEncoder stop");
      this.x.stop();
    }
    catch (IllegalStateException ???)
    {
      paramg.A(1, "Video encoder stop failed!", ???);
      bool1 = true;
    }
    try
    {
      synchronized (this.m)
      {
        if (this.B != null)
        {
          if (this.C.get())
          {
            n1.e("VideoCapture", "Muxer already started");
            this.B.stop();
          }
          this.B.release();
          this.B = null;
        }
        if (!k0(paramh)) {
          paramg.A(6, "The file has no video key frame.", null);
        }
      }
      return bool2;
    }
    catch (IllegalStateException ???)
    {
      paramSize = new StringBuilder();
      paramSize.append("muxer stop IllegalStateException: ");
      paramSize.append(System.currentTimeMillis());
      n1.e("VideoCapture", paramSize.toString());
      paramSize = new StringBuilder();
      paramSize.append("muxer stop exception, mIsFirstVideoKeyFrameWrite: ");
      paramSize.append(this.r.get());
      n1.e("VideoCapture", paramSize.toString());
      if (this.r.get()) {
        paramg.A(2, "Muxer stop failed!", ???);
      } else {
        paramg.A(6, "The file has no video key frame.", null);
      }
      bool1 = true;
      bool2 = bool1;
      if (this.O != null) {
        try
        {
          this.O.close();
          this.O = null;
          bool2 = bool1;
        }
        catch (IOException ???)
        {
          paramg.A(2, "File descriptor close failed!", ???);
          bool2 = true;
        }
      }
      this.C.set(false);
      this.p.set(true);
      this.r.set(false);
      n1.e("VideoCapture", "Video encode thread end.");
    }
  }
  
  public void x()
  {
    this.t = new HandlerThread("CameraX-video encoding thread");
    this.v = new HandlerThread("CameraX-audio encoding thread");
    this.t.start();
    this.u = new Handler(this.t.getLooper());
    this.v.start();
    this.w = new Handler(this.v.getLooper());
  }
  
  class a
    implements g2.c
  {
    a(String paramString, Size paramSize) {}
    
    public void a(g2 paramg2, g2.f paramf)
    {
      if (f3.this.p(paramString))
      {
        f3.this.m0(paramString, paramSize);
        f3.this.t();
      }
    }
  }
  
  private static class b
  {
    static int a(MediaCodec.CodecException paramCodecException)
    {
      return paramCodecException.getErrorCode();
    }
  }
  
  private static class c
  {
    static MediaMuxer a(FileDescriptor paramFileDescriptor, int paramInt)
    {
      return new MediaMuxer(paramFileDescriptor, paramInt);
    }
  }
  
  public static final class d
    implements t2.a<f3, s.v2, d>
  {
    private final u1 a;
    
    public d()
    {
      this(u1.M());
    }
    
    private d(u1 paramu1)
    {
      this.a = paramu1;
      paramu1 = (Class)paramu1.e(i.x, null);
      if ((paramu1 != null) && (!paramu1.equals(f3.class)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid target class configuration for ");
        localStringBuilder.append(this);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramu1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      o(f3.class);
    }
    
    static d d(s0 params0)
    {
      return new d(u1.N(params0));
    }
    
    public t1 a()
    {
      return this.a;
    }
    
    public f3 c()
    {
      if ((a().e(j1.g, null) != null) && (a().e(j1.j, null) != null)) {
        throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
      }
      return new f3(e());
    }
    
    public s.v2 e()
    {
      return new s.v2(y1.K(this.a));
    }
    
    public d f(int paramInt)
    {
      a().G(s.v2.E, Integer.valueOf(paramInt));
      return this;
    }
    
    public d g(int paramInt)
    {
      a().G(s.v2.G, Integer.valueOf(paramInt));
      return this;
    }
    
    public d h(int paramInt)
    {
      a().G(s.v2.H, Integer.valueOf(paramInt));
      return this;
    }
    
    public d i(int paramInt)
    {
      a().G(s.v2.F, Integer.valueOf(paramInt));
      return this;
    }
    
    public d j(int paramInt)
    {
      a().G(s.v2.C, Integer.valueOf(paramInt));
      return this;
    }
    
    public d k(int paramInt)
    {
      a().G(s.v2.D, Integer.valueOf(paramInt));
      return this;
    }
    
    public d l(Size paramSize)
    {
      a().G(j1.l, paramSize);
      return this;
    }
    
    public d m(int paramInt)
    {
      a().G(t2.r, Integer.valueOf(paramInt));
      return this;
    }
    
    public d n(int paramInt)
    {
      a().G(j1.g, Integer.valueOf(paramInt));
      return this;
    }
    
    public d o(Class<f3> paramClass)
    {
      a().G(i.x, paramClass);
      if (a().e(i.w, null) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getCanonicalName());
        localStringBuilder.append("-");
        localStringBuilder.append(UUID.randomUUID());
        p(localStringBuilder.toString());
      }
      return this;
    }
    
    public d p(String paramString)
    {
      a().G(i.w, paramString);
      return this;
    }
    
    public d q(int paramInt)
    {
      a().G(j1.h, Integer.valueOf(paramInt));
      return this;
    }
    
    public d r(int paramInt)
    {
      a().G(s.v2.B, Integer.valueOf(paramInt));
      return this;
    }
  }
  
  public static final class e
  {
    private static final Size a;
    private static final s.v2 b;
    
    static
    {
      Size localSize = new Size(1920, 1080);
      a = localSize;
      b = new f3.d().r(30).j(8388608).k(1).f(64000).i(8000).g(1).h(1024).l(localSize).m(3).n(1).e();
    }
    
    public s.v2 a()
    {
      return b;
    }
  }
  
  public static final class f
  {
    public Location a;
  }
  
  public static abstract interface g
  {
    public abstract void A(int paramInt, String paramString, Throwable paramThrowable);
    
    public abstract void I(f3.i parami);
  }
  
  public static final class h
  {
    private static final f3.f g = new f3.f();
    private final File a;
    private final FileDescriptor b;
    private final ContentResolver c;
    private final Uri d;
    private final ContentValues e;
    private final f3.f f;
    
    h(File paramFile, FileDescriptor paramFileDescriptor, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, f3.f paramf)
    {
      this.a = paramFile;
      this.b = paramFileDescriptor;
      this.c = paramContentResolver;
      this.d = paramUri;
      this.e = paramContentValues;
      paramFile = paramf;
      if (paramf == null) {
        paramFile = g;
      }
      this.f = paramFile;
    }
    
    ContentResolver a()
    {
      return this.c;
    }
    
    ContentValues b()
    {
      return this.e;
    }
    
    File c()
    {
      return this.a;
    }
    
    FileDescriptor d()
    {
      return this.b;
    }
    
    f3.f e()
    {
      return this.f;
    }
    
    Uri f()
    {
      return this.d;
    }
    
    boolean g()
    {
      return c() != null;
    }
    
    boolean h()
    {
      return d() != null;
    }
    
    boolean i()
    {
      return (f() != null) && (a() != null) && (b() != null);
    }
    
    public static final class a
    {
      private File a;
      private FileDescriptor b;
      private ContentResolver c;
      private Uri d;
      private ContentValues e;
      private f3.f f;
      
      public a(File paramFile)
      {
        this.a = paramFile;
      }
      
      public f3.h a()
      {
        return new f3.h(this.a, this.b, this.c, this.d, this.e, this.f);
      }
    }
  }
  
  public static class i
  {
    private Uri a;
    
    i(Uri paramUri)
    {
      this.a = paramUri;
    }
  }
  
  static enum j
  {
    static
    {
      j localj1 = new j("VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED", 0);
      a = localj1;
      j localj2 = new j("VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED", 1);
      b = localj2;
      j localj3 = new j("VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE", 2);
      c = localj3;
      j localj4 = new j("VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED", 3);
      d = localj4;
      e = new j[] { localj1, localj2, localj3, localj4 };
    }
    
    private j() {}
  }
  
  private static final class k
    implements f3.g
  {
    Executor a;
    f3.g b;
    
    k(Executor paramExecutor, f3.g paramg)
    {
      this.a = paramExecutor;
      this.b = paramg;
    }
    
    public void A(int paramInt, String paramString, Throwable paramThrowable)
    {
      try
      {
        this.a.execute(new g3(this, paramInt, paramString, paramThrowable));
        return;
      }
      catch (RejectedExecutionException paramString)
      {
        label21:
        break label21;
      }
      n1.c("VideoCapture", "Unable to post to the supplied executor.");
    }
    
    public void I(f3.i parami)
    {
      try
      {
        this.a.execute(new h3(this, parami));
        return;
      }
      catch (RejectedExecutionException parami)
      {
        label19:
        break label19;
      }
      n1.c("VideoCapture", "Unable to post to the supplied executor.");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.f3
 * JD-Core Version:    0.7.0.1
 */