package org.webrtc;

import android.graphics.ImageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraEnumerationAndroid
{
  static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList(Arrays.asList(new Size[] { new Size(160, 120), new Size(240, 160), new Size(320, 240), new Size(400, 240), new Size(480, 320), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(1024, 576), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(1920, 1080), new Size(1920, 1440), new Size(2560, 1440), new Size(3840, 2160) }));
  private static final String TAG = "CameraEnumerationAndroid";
  
  public static CameraEnumerationAndroid.CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> paramList, int paramInt)
  {
    (CameraEnumerationAndroid.CaptureFormat.FramerateRange)Collections.min(paramList, new ClosestComparator(paramInt)
    {
      private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
      private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
      private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
      private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
      private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
      private static final int MIN_FPS_THRESHOLD = 8000;
      
      private int progressivePenalty(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousInt1 < paramAnonymousInt2) {
          return paramAnonymousInt1 * paramAnonymousInt3;
        }
        return (paramAnonymousInt1 - paramAnonymousInt2) * paramAnonymousInt4 + paramAnonymousInt3 * paramAnonymousInt2;
      }
      
      int diff(CameraEnumerationAndroid.CaptureFormat.FramerateRange paramAnonymousFramerateRange)
      {
        return progressivePenalty(paramAnonymousFramerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs(this.val$requestedFps * 1000 - paramAnonymousFramerateRange.max), 5000, 1, 3);
      }
    });
  }
  
  public static Size getClosestSupportedSize(List<Size> paramList, int paramInt1, final int paramInt2)
  {
    (Size)Collections.min(paramList, new ClosestComparator(paramInt1)
    {
      int diff(Size paramAnonymousSize)
      {
        return Math.abs(this.val$requestedWidth - paramAnonymousSize.width) + Math.abs(paramInt2 - paramAnonymousSize.height);
      }
    });
  }
  
  static void reportCameraResolution(Histogram paramHistogram, Size paramSize)
  {
    paramHistogram.addSample(COMMON_RESOLUTIONS.indexOf(paramSize) + 1);
  }
  
  public static class CaptureFormat
  {
    public final FramerateRange framerate;
    public final int height;
    public final int imageFormat = 17;
    public final int width;
    
    public CaptureFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.framerate = new FramerateRange(paramInt3, paramInt4);
    }
    
    public CaptureFormat(int paramInt1, int paramInt2, FramerateRange paramFramerateRange)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.framerate = paramFramerateRange;
    }
    
    public static int frameSize(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 == 17) {
        return paramInt1 * paramInt2 * ImageFormat.getBitsPerPixel(paramInt3) / 8;
      }
      throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof CaptureFormat;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (CaptureFormat)paramObject;
      bool1 = bool2;
      if (this.width == paramObject.width)
      {
        bool1 = bool2;
        if (this.height == paramObject.height)
        {
          bool1 = bool2;
          if (this.framerate.equals(paramObject.framerate)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int frameSize()
    {
      return frameSize(this.width, this.height, 17);
    }
    
    public int hashCode()
    {
      return (this.width * 65497 + this.height) * 251 + 1 + this.framerate.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.width);
      localStringBuilder.append("x");
      localStringBuilder.append(this.height);
      localStringBuilder.append("@");
      localStringBuilder.append(this.framerate);
      return localStringBuilder.toString();
    }
    
    public static class FramerateRange
    {
      public int max;
      public int min;
      
      public FramerateRange(int paramInt1, int paramInt2)
      {
        this.min = paramInt1;
        this.max = paramInt2;
      }
      
      public boolean equals(Object paramObject)
      {
        boolean bool1 = paramObject instanceof FramerateRange;
        boolean bool2 = false;
        if (!bool1) {
          return false;
        }
        paramObject = (FramerateRange)paramObject;
        bool1 = bool2;
        if (this.min == paramObject.min)
        {
          bool1 = bool2;
          if (this.max == paramObject.max) {
            bool1 = true;
          }
        }
        return bool1;
      }
      
      public int hashCode()
      {
        return this.min * 65537 + 1 + this.max;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.min / 1000.0F);
        localStringBuilder.append(":");
        localStringBuilder.append(this.max / 1000.0F);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    }
  }
  
  private static abstract class ClosestComparator<T>
    implements Comparator<T>
  {
    public int compare(T paramT1, T paramT2)
    {
      return diff(paramT1) - diff(paramT2);
    }
    
    abstract int diff(T paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CameraEnumerationAndroid
 * JD-Core Version:    0.7.0.1
 */