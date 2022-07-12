package androidx.camera.camera2.internal;

import n.z;

class z1
{
  private final Object a = new Object();
  private final z b;
  private int c;
  
  z1(z paramz, int paramInt)
  {
    this.b = paramz;
    this.c = paramInt;
  }
  
  public int a()
  {
    synchronized (this.a)
    {
      int i = this.c;
      return i;
    }
  }
  
  void b(int paramInt)
  {
    synchronized (this.a)
    {
      this.c = paramInt;
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.z1
 * JD-Core Version:    0.7.0.1
 */