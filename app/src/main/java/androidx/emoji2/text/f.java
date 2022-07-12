package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import f1.a;
import f1.b;

public class f
{
  private static final ThreadLocal<a> d = new ThreadLocal();
  private final int a;
  private final l b;
  private volatile int c = 0;
  
  f(l paraml, int paramInt)
  {
    this.b = paraml;
    this.a = paramInt;
  }
  
  private a g()
  {
    ThreadLocal localThreadLocal = d;
    a locala2 = (a)localThreadLocal.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      localThreadLocal.set(locala1);
    }
    this.b.d().j(locala1, this.a);
    return locala1;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    Typeface localTypeface1 = this.b.g();
    Typeface localTypeface2 = paramPaint.getTypeface();
    paramPaint.setTypeface(localTypeface1);
    int i = this.a;
    paramCanvas.drawText(this.b.c(), i * 2, 2, paramFloat1, paramFloat2, paramPaint);
    paramPaint.setTypeface(localTypeface2);
  }
  
  public int b(int paramInt)
  {
    return g().h(paramInt);
  }
  
  public int c()
  {
    return g().i();
  }
  
  @SuppressLint({"KotlinPropertyAccess"})
  public int d()
  {
    return this.c;
  }
  
  public short e()
  {
    return g().k();
  }
  
  public int f()
  {
    return g().l();
  }
  
  public short h()
  {
    return g().m();
  }
  
  public short i()
  {
    return g().n();
  }
  
  public boolean j()
  {
    return g().j();
  }
  
  @SuppressLint({"KotlinPropertyAccess"})
  public void k(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    this.c = i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", id:");
    localStringBuilder.append(Integer.toHexString(f()));
    localStringBuilder.append(", codepoints:");
    int j = c();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toHexString(b(i)));
      localStringBuilder.append(" ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.f
 * JD-Core Version:    0.7.0.1
 */