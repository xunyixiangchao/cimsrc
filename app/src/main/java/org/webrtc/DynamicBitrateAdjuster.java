package org.webrtc;

class DynamicBitrateAdjuster
  extends BaseBitrateAdjuster
{
  private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0D;
  private static final double BITRATE_ADJUSTMENT_SEC = 3.0D;
  private static final int BITRATE_ADJUSTMENT_STEPS = 20;
  private static final double BITS_PER_BYTE = 8.0D;
  private int bitrateAdjustmentScaleExp;
  private double deviationBytes;
  private double timeSinceLastAdjustmentMs;
  
  private double getBitrateAdjustmentScale()
  {
    return Math.pow(4.0D, this.bitrateAdjustmentScaleExp / 20.0D);
  }
  
  public int getAdjustedBitrateBps()
  {
    return (int)(this.targetBitrateBps * getBitrateAdjustmentScale());
  }
  
  public void reportEncodedFrame(int paramInt)
  {
    int i = this.targetFps;
    if (i == 0) {
      return;
    }
    int j = this.targetBitrateBps;
    double d1 = j / 8.0D / i;
    double d3 = this.deviationBytes + (paramInt - d1);
    this.deviationBytes = d3;
    this.timeSinceLastAdjustmentMs += 1000.0D / i;
    d1 = j / 8.0D;
    double d2 = 3.0D * d1;
    d3 = Math.min(d3, d2);
    this.deviationBytes = d3;
    d2 = Math.max(d3, -d2);
    this.deviationBytes = d2;
    if (this.timeSinceLastAdjustmentMs <= 3000.0D) {
      return;
    }
    if (d2 > d1)
    {
      paramInt = (int)(d2 / d1 + 0.5D);
      paramInt = this.bitrateAdjustmentScaleExp - paramInt;
      this.bitrateAdjustmentScaleExp = paramInt;
      this.bitrateAdjustmentScaleExp = Math.max(paramInt, -20);
      this.deviationBytes = d1;
    }
    else
    {
      d3 = -d1;
      if (d2 < d3)
      {
        paramInt = (int)(-d2 / d1 + 0.5D);
        paramInt = this.bitrateAdjustmentScaleExp + paramInt;
        this.bitrateAdjustmentScaleExp = paramInt;
        this.bitrateAdjustmentScaleExp = Math.min(paramInt, 20);
        this.deviationBytes = d3;
      }
    }
    this.timeSinceLastAdjustmentMs = 0.0D;
  }
  
  public void setTargets(int paramInt1, int paramInt2)
  {
    int i = this.targetBitrateBps;
    if ((i > 0) && (paramInt1 < i)) {
      this.deviationBytes = (this.deviationBytes * paramInt1 / i);
    }
    super.setTargets(paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.DynamicBitrateAdjuster
 * JD-Core Version:    0.7.0.1
 */