package org.webrtc;

import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class FileVideoCapturer
  implements VideoCapturer
{
  private static final String TAG = "FileVideoCapturer";
  private CapturerObserver capturerObserver;
  private final TimerTask tickTask = new TimerTask()
  {
    public void run()
    {
      FileVideoCapturer.this.tick();
    }
  };
  private final Timer timer = new Timer();
  private final VideoReader videoReader;
  
  public FileVideoCapturer(String paramString)
  {
    try
    {
      this.videoReader = new VideoReaderY4M(paramString);
      return;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not open video file: ");
      localStringBuilder.append(paramString);
      Logging.d("FileVideoCapturer", localStringBuilder.toString());
      throw localIOException;
    }
  }
  
  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dispose()
  {
    this.videoReader.close();
  }
  
  public void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    this.capturerObserver = paramCapturerObserver;
  }
  
  public boolean isScreencast()
  {
    return false;
  }
  
  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.timer.schedule(this.tickTask, 0L, 1000 / paramInt3);
  }
  
  public void stopCapture()
  {
    this.timer.cancel();
  }
  
  public void tick()
  {
    VideoFrame localVideoFrame = this.videoReader.getNextFrame();
    this.capturerObserver.onFrameCaptured(localVideoFrame);
    localVideoFrame.release();
  }
  
  private static abstract interface VideoReader
  {
    public abstract void close();
    
    public abstract VideoFrame getNextFrame();
  }
  
  private static class VideoReaderY4M
    implements FileVideoCapturer.VideoReader
  {
    private static final int FRAME_DELIMETER_LENGTH = 6;
    private static final String TAG = "VideoReaderY4M";
    private static final String Y4M_FRAME_DELIMETER = "FRAME";
    private final int frameHeight;
    private final int frameWidth;
    private final RandomAccessFile mediaFile;
    private final FileChannel mediaFileChannel;
    private final long videoStart;
    
    public VideoReaderY4M(String paramString)
    {
      Object localObject1 = new RandomAccessFile(paramString, "r");
      this.mediaFile = ((RandomAccessFile)localObject1);
      this.mediaFileChannel = ((RandomAccessFile)localObject1).getChannel();
      localObject1 = new StringBuilder();
      for (;;)
      {
        int i = this.mediaFile.read();
        if (i == -1) {
          break;
        }
        if (i == 10)
        {
          this.videoStart = this.mediaFileChannel.position();
          localObject1 = ((StringBuilder)localObject1).toString().split("[ ]");
          int n = localObject1.length;
          paramString = "";
          int m = 0;
          i = m;
          int j = i;
          int k = i;
          i = m;
          while (i < n)
          {
            Object localObject2 = localObject1[i];
            m = localObject2.charAt(0);
            if (m != 67)
            {
              if (m != 72)
              {
                if (m == 87) {
                  k = Integer.parseInt(localObject2.substring(1));
                }
              }
              else {
                j = Integer.parseInt(localObject2.substring(1));
              }
            }
            else {
              paramString = localObject2.substring(1);
            }
            i += 1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Color space: ");
          ((StringBuilder)localObject1).append(paramString);
          Logging.d("VideoReaderY4M", ((StringBuilder)localObject1).toString());
          if ((!paramString.equals("420")) && (!paramString.equals("420mpeg2"))) {
            throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
          }
          if ((k % 2 != 1) && (j % 2 != 1))
          {
            this.frameWidth = k;
            this.frameHeight = j;
            paramString = new StringBuilder();
            paramString.append("frame dim: (");
            paramString.append(k);
            paramString.append(", ");
            paramString.append(j);
            paramString.append(")");
            Logging.d("VideoReaderY4M", paramString.toString());
            return;
          }
          throw new IllegalArgumentException("Does not support odd width or height");
        }
        ((StringBuilder)localObject1).append((char)i);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Found end of file before end of header for file: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    
    public void close()
    {
      try
      {
        this.mediaFile.close();
        return;
      }
      catch (IOException localIOException)
      {
        Logging.e("VideoReaderY4M", "Problem closing file", localIOException);
      }
    }
    
    public VideoFrame getNextFrame()
    {
      long l = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
      Object localObject1 = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
      ByteBuffer localByteBuffer1 = ((JavaI420Buffer)localObject1).getDataY();
      ByteBuffer localByteBuffer2 = ((JavaI420Buffer)localObject1).getDataU();
      ByteBuffer localByteBuffer3 = ((JavaI420Buffer)localObject1).getDataV();
      int i = (this.frameHeight + 1) / 2;
      ((JavaI420Buffer)localObject1).getStrideY();
      ((JavaI420Buffer)localObject1).getStrideU();
      ((JavaI420Buffer)localObject1).getStrideV();
      try
      {
        i = FRAME_DELIMETER_LENGTH;
        Object localObject2 = ByteBuffer.allocate(i);
        if (this.mediaFileChannel.read((ByteBuffer)localObject2) < i)
        {
          this.mediaFileChannel.position(this.videoStart);
          if (this.mediaFileChannel.read((ByteBuffer)localObject2) < i) {
            throw new RuntimeException("Error looping video");
          }
        }
        localObject2 = new String(((ByteBuffer)localObject2).array(), Charset.forName("US-ASCII"));
        if (((String)localObject2).equals("FRAME\n"))
        {
          this.mediaFileChannel.read(localByteBuffer1);
          this.mediaFileChannel.read(localByteBuffer2);
          this.mediaFileChannel.read(localByteBuffer3);
          return new VideoFrame((VideoFrame.Buffer)localObject1, 0, l);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Frames should be delimited by FRAME plus newline, found delimter was: '");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("'");
        throw new RuntimeException(((StringBuilder)localObject1).toString());
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.FileVideoCapturer
 * JD-Core Version:    0.7.0.1
 */