package org.webrtc;

class BaseBitrateAdjuster
  implements BitrateAdjuster
{
  protected int targetBitrateBps;
  protected int targetFps;
  
  public int getAdjustedBitrateBps()
  {
    return this.targetBitrateBps;
  }
  
  public int getCodecConfigFramerate()
  {
    return this.targetFps;
  }
  
  public void reportEncodedFrame(int paramInt) {}
  
  public void setTargets(int paramInt1, int paramInt2)
  {
    this.targetBitrateBps = paramInt1;
    this.targetFps = paramInt2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.BaseBitrateAdjuster
 * JD-Core Version:    0.7.0.1
 */