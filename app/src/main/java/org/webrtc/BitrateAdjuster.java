package org.webrtc;

abstract interface BitrateAdjuster
{
  public abstract int getAdjustedBitrateBps();
  
  public abstract int getCodecConfigFramerate();
  
  public abstract void reportEncodedFrame(int paramInt);
  
  public abstract void setTargets(int paramInt1, int paramInt2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.BitrateAdjuster
 * JD-Core Version:    0.7.0.1
 */