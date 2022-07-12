package org.webrtc;

public abstract interface VideoEncoder
{
  @CalledByNative
  public abstract long createNativeVideoEncoder();
  
  @CalledByNative
  public abstract VideoCodecStatus encode(VideoFrame paramVideoFrame, EncodeInfo paramEncodeInfo);
  
  @CalledByNative
  public abstract String getImplementationName();
  
  @CalledByNative
  public abstract ResolutionBitrateLimits[] getResolutionBitrateLimits();
  
  @CalledByNative
  public abstract ScalingSettings getScalingSettings();
  
  @CalledByNative
  public abstract VideoCodecStatus initEncode(Settings paramSettings, Callback paramCallback);
  
  @CalledByNative
  public abstract boolean isHardwareEncoder();
  
  @CalledByNative
  public abstract VideoCodecStatus release();
  
  @CalledByNative
  public abstract VideoCodecStatus setRateAllocation(BitrateAllocation paramBitrateAllocation, int paramInt);
  
  public static class BitrateAllocation
  {
    public final int[][] bitratesBbs;
    
    @CalledByNative("BitrateAllocation")
    public BitrateAllocation(int[][] paramArrayOfInt)
    {
      this.bitratesBbs = paramArrayOfInt;
    }
    
    public int getSum()
    {
      int[][] arrayOfInt = this.bitratesBbs;
      int m = arrayOfInt.length;
      int i = 0;
      int j = i;
      while (i < m)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        int n = arrayOfInt1.length;
        int k = 0;
        while (k < n)
        {
          j += arrayOfInt1[k];
          k += 1;
        }
        i += 1;
      }
      return j;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onEncodedFrame(EncodedImage paramEncodedImage, VideoEncoder.CodecSpecificInfo paramCodecSpecificInfo);
  }
  
  public static class Capabilities
  {
    public final boolean lossNotification;
    
    @CalledByNative("Capabilities")
    public Capabilities(boolean paramBoolean)
    {
      this.lossNotification = paramBoolean;
    }
  }
  
  public static class CodecSpecificInfo {}
  
  public static class CodecSpecificInfoH264
    extends VideoEncoder.CodecSpecificInfo
  {}
  
  public static class CodecSpecificInfoVP8
    extends VideoEncoder.CodecSpecificInfo
  {}
  
  public static class CodecSpecificInfoVP9
    extends VideoEncoder.CodecSpecificInfo
  {}
  
  public static class EncodeInfo
  {
    public final EncodedImage.FrameType[] frameTypes;
    
    @CalledByNative("EncodeInfo")
    public EncodeInfo(EncodedImage.FrameType[] paramArrayOfFrameType)
    {
      this.frameTypes = paramArrayOfFrameType;
    }
  }
  
  public static class ResolutionBitrateLimits
  {
    public final int frameSizePixels;
    public final int maxBitrateBps;
    public final int minBitrateBps;
    public final int minStartBitrateBps;
    
    public ResolutionBitrateLimits(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.frameSizePixels = paramInt1;
      this.minStartBitrateBps = paramInt2;
      this.minBitrateBps = paramInt3;
      this.maxBitrateBps = paramInt4;
    }
    
    @CalledByNative("ResolutionBitrateLimits")
    public int getFrameSizePixels()
    {
      return this.frameSizePixels;
    }
    
    @CalledByNative("ResolutionBitrateLimits")
    public int getMaxBitrateBps()
    {
      return this.maxBitrateBps;
    }
    
    @CalledByNative("ResolutionBitrateLimits")
    public int getMinBitrateBps()
    {
      return this.minBitrateBps;
    }
    
    @CalledByNative("ResolutionBitrateLimits")
    public int getMinStartBitrateBps()
    {
      return this.minStartBitrateBps;
    }
  }
  
  public static class ScalingSettings
  {
    public static final ScalingSettings OFF = new ScalingSettings();
    public final Integer high;
    public final Integer low;
    public final boolean on;
    
    private ScalingSettings()
    {
      this.on = false;
      this.low = null;
      this.high = null;
    }
    
    public ScalingSettings(int paramInt1, int paramInt2)
    {
      this.on = true;
      this.low = Integer.valueOf(paramInt1);
      this.high = Integer.valueOf(paramInt2);
    }
    
    @Deprecated
    public ScalingSettings(boolean paramBoolean)
    {
      this.on = paramBoolean;
      this.low = null;
      this.high = null;
    }
    
    @Deprecated
    public ScalingSettings(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.on = paramBoolean;
      this.low = Integer.valueOf(paramInt1);
      this.high = Integer.valueOf(paramInt2);
    }
    
    public String toString()
    {
      if (this.on)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ ");
        localStringBuilder.append(this.low);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.high);
        localStringBuilder.append(" ]");
        return localStringBuilder.toString();
      }
      return "OFF";
    }
  }
  
  public static class Settings
  {
    public final boolean automaticResizeOn;
    public final VideoEncoder.Capabilities capabilities;
    public final int height;
    public final int maxFramerate;
    public final int numberOfCores;
    public final int numberOfSimulcastStreams;
    public final int startBitrate;
    public final int width;
    
    @Deprecated
    public Settings(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, new VideoEncoder.Capabilities(false));
    }
    
    @CalledByNative("Settings")
    public Settings(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, VideoEncoder.Capabilities paramCapabilities)
    {
      this.numberOfCores = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
      this.startBitrate = paramInt4;
      this.maxFramerate = paramInt5;
      this.numberOfSimulcastStreams = paramInt6;
      this.automaticResizeOn = paramBoolean;
      this.capabilities = paramCapabilities;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoEncoder
 * JD-Core Version:    0.7.0.1
 */