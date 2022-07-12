package o7;

import android.graphics.Typeface;

public final class a
  extends f
{
  private final Typeface a;
  private final a b;
  private boolean c;
  
  public a(a parama, Typeface paramTypeface)
  {
    this.a = paramTypeface;
    this.b = parama;
  }
  
  private void d(Typeface paramTypeface)
  {
    if (!this.c) {
      this.b.a(paramTypeface);
    }
  }
  
  public void a(int paramInt)
  {
    d(this.a);
  }
  
  public void b(Typeface paramTypeface, boolean paramBoolean)
  {
    d(paramTypeface);
  }
  
  public void c()
  {
    this.c = true;
  }
  
  public static abstract interface a
  {
    public abstract void a(Typeface paramTypeface);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o7.a
 * JD-Core Version:    0.7.0.1
 */