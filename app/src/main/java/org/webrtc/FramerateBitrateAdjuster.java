package org.webrtc;

class FramerateBitrateAdjuster
  extends BaseBitrateAdjuster
{
  private static final int INITIAL_FPS = 30;
  
  public int getCodecConfigFramerate()
  {
    return 30;
  }
  
  public void setTargets(int paramInt1, int paramInt2)
  {
    if (this.targetFps == 0) {
      paramInt2 = 30;
    }
    super.setTargets(paramInt1, paramInt2);
    this.targetBitrateBps = (this.targetBitrateBps * 30 / this.targetFps);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.FramerateBitrateAdjuster
 * JD-Core Version:    0.7.0.1
 */