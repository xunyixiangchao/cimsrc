package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import o7.d;
import o7.f;

public class m
{
  private final TextPaint a = new TextPaint(1);
  private final f b = new a();
  private float c;
  private boolean d = true;
  private WeakReference<b> e = new WeakReference(null);
  private d f;
  
  public m(b paramb)
  {
    g(paramb);
  }
  
  private float c(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.a.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public d d()
  {
    return this.f;
  }
  
  public TextPaint e()
  {
    return this.a;
  }
  
  public float f(String paramString)
  {
    if (!this.d) {
      return this.c;
    }
    float f1 = c(paramString);
    this.c = f1;
    this.d = false;
    return f1;
  }
  
  public void g(b paramb)
  {
    this.e = new WeakReference(paramb);
  }
  
  public void h(d paramd, Context paramContext)
  {
    if (this.f != paramd)
    {
      this.f = paramd;
      if (paramd != null)
      {
        paramd.o(paramContext, this.a, this.b);
        b localb = (b)this.e.get();
        if (localb != null) {
          this.a.drawableState = localb.getState();
        }
        paramd.n(paramContext, this.a, this.b);
        this.d = true;
      }
      paramd = (b)this.e.get();
      if (paramd != null)
      {
        paramd.a();
        paramd.onStateChange(paramd.getState());
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void j(Context paramContext)
  {
    this.f.n(paramContext, this.a, this.b);
  }
  
  class a
    extends f
  {
    a() {}
    
    public void a(int paramInt)
    {
      m.a(m.this, true);
      m.b localb = (m.b)m.b(m.this).get();
      if (localb != null) {
        localb.a();
      }
    }
    
    public void b(Typeface paramTypeface, boolean paramBoolean)
    {
      if (paramBoolean) {
        return;
      }
      m.a(m.this, true);
      paramTypeface = (m.b)m.b(m.this).get();
      if (paramTypeface != null) {
        paramTypeface.a();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract int[] getState();
    
    public abstract boolean onStateChange(int[] paramArrayOfInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.m
 * JD-Core Version:    0.7.0.1
 */