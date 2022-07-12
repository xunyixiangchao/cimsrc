package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

public class VideoFileRenderer
  implements VideoSink
{
  private static final String TAG = "VideoFileRenderer";
  private EglBase eglBase;
  private final HandlerThread fileThread;
  private final Handler fileThreadHandler;
  private int frameCount;
  private final int outputFileHeight;
  private final String outputFileName;
  private final int outputFileWidth;
  private final ByteBuffer outputFrameBuffer;
  private final int outputFrameSize;
  private final HandlerThread renderThread;
  private final Handler renderThreadHandler;
  private final FileOutputStream videoOutFile;
  private YuvConverter yuvConverter;
  
  public VideoFileRenderer(String paramString, int paramInt1, int paramInt2, final EglBase.Context paramContext)
  {
    if ((paramInt1 % 2 != 1) && (paramInt2 % 2 != 1))
    {
      this.outputFileName = paramString;
      this.outputFileWidth = paramInt1;
      this.outputFileHeight = paramInt2;
      int i = paramInt1 * paramInt2 * 3 / 2;
      this.outputFrameSize = i;
      this.outputFrameBuffer = ByteBuffer.allocateDirect(i);
      paramString = new FileOutputStream(paramString);
      this.videoOutFile = paramString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("YUV4MPEG2 C420 W");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" H");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" Ip F30:1 A1:1\n");
      paramString.write(((StringBuilder)localObject).toString().getBytes(Charset.forName("US-ASCII")));
      paramString = new HandlerThread("VideoFileRendererRenderThread");
      this.renderThread = paramString;
      paramString.start();
      paramString = new Handler(paramString.getLooper());
      this.renderThreadHandler = paramString;
      localObject = new HandlerThread("VideoFileRendererFileThread");
      this.fileThread = ((HandlerThread)localObject);
      ((HandlerThread)localObject).start();
      this.fileThreadHandler = new Handler(((HandlerThread)localObject).getLooper());
      ThreadUtils.invokeAtFrontUninterruptibly(paramString, new Runnable()
      {
        public void run()
        {
          VideoFileRenderer.access$002(VideoFileRenderer.this, g.d(paramContext, EglBase.CONFIG_PIXEL_BUFFER));
          VideoFileRenderer.this.eglBase.createDummyPbufferSurface();
          VideoFileRenderer.this.eglBase.makeCurrent();
          VideoFileRenderer.access$102(VideoFileRenderer.this, new YuvConverter());
        }
      });
      return;
    }
    throw new IllegalArgumentException("Does not support uneven width or height");
  }
  
  private void renderFrameOnRenderThread(VideoFrame paramVideoFrame)
  {
    VideoFrame.Buffer localBuffer = paramVideoFrame.getBuffer();
    int i;
    if (paramVideoFrame.getRotation() % 180 == 0) {
      i = this.outputFileWidth;
    } else {
      i = this.outputFileHeight;
    }
    int j;
    if (paramVideoFrame.getRotation() % 180 == 0) {
      j = this.outputFileHeight;
    } else {
      j = this.outputFileWidth;
    }
    float f1 = localBuffer.getWidth() / localBuffer.getHeight();
    float f2 = i / j;
    int k = localBuffer.getWidth();
    int m = localBuffer.getHeight();
    if (f2 > f1) {
      m = (int)(m * (f1 / f2));
    } else {
      k = (int)(k * (f2 / f1));
    }
    localBuffer = localBuffer.cropAndScale((localBuffer.getWidth() - k) / 2, (localBuffer.getHeight() - m) / 2, k, m, i, j);
    paramVideoFrame.release();
    VideoFrame.I420Buffer localI420Buffer = localBuffer.toI420();
    localBuffer.release();
    this.fileThreadHandler.post(new p0(this, localI420Buffer, paramVideoFrame));
  }
  
  public void onFrame(VideoFrame paramVideoFrame)
  {
    paramVideoFrame.retain();
    this.renderThreadHandler.post(new q0(this, paramVideoFrame));
  }
  
  public void release()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.renderThreadHandler.post(new o0(this, localCountDownLatch));
    ThreadUtils.awaitUninterruptibly(localCountDownLatch);
    this.fileThreadHandler.post(new n0(this));
    try
    {
      this.fileThread.join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      Logging.e("VideoFileRenderer", "Interrupted while waiting for the write to disk to complete.", localInterruptedException);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoFileRenderer
 * JD-Core Version:    0.7.0.1
 */