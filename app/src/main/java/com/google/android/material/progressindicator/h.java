package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.b;

abstract class h<T extends Animator>
{
  protected i a;
  protected final float[] b;
  protected final int[] c;
  
  protected h(int paramInt)
  {
    this.b = new float[paramInt * 2];
    this.c = new int[paramInt];
  }
  
  abstract void a();
  
  protected float b(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 - paramInt2) / paramInt3;
  }
  
  public abstract void c();
  
  public abstract void d(b paramb);
  
  protected void e(i parami)
  {
    this.a = parami;
  }
  
  abstract void f();
  
  abstract void g();
  
  public abstract void h();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.h
 * JD-Core Version:    0.7.0.1
 */