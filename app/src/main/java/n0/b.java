package n0;

import i0.k;
import i0.m;

public class b
  extends androidx.constraintlayout.motion.widget.n
{
  private i0.n a;
  private k b;
  private m c;
  
  public b()
  {
    i0.n localn = new i0.n();
    this.a = localn;
    this.c = localn;
  }
  
  public float a()
  {
    return this.c.b();
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    i0.n localn = this.a;
    this.c = localn;
    localn.d(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public boolean c()
  {
    return this.c.a();
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt)
  {
    if (this.b == null) {
      this.b = new k();
    }
    k localk = this.b;
    this.c = localk;
    localk.d(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramInt);
  }
  
  public float getInterpolation(float paramFloat)
  {
    return this.c.getInterpolation(paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n0.b
 * JD-Core Version:    0.7.0.1
 */