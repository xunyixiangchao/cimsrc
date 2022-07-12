package com.bumptech.glide;

public enum g
{
  private final float a;
  
  static
  {
    g localg1 = new g("LOW", 0, 0.5F);
    b = localg1;
    g localg2 = new g("NORMAL", 1, 1.0F);
    c = localg2;
    g localg3 = new g("HIGH", 2, 1.5F);
    d = localg3;
    e = new g[] { localg1, localg2, localg3 };
  }
  
  private g(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.g
 * JD-Core Version:    0.7.0.1
 */