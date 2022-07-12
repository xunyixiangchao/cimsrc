package j7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import com.google.android.material.R.attr;
import o7.b;

public class a
{
  private static final int f = (int)Math.round(5.100000000000001D);
  private final boolean a;
  private final int b;
  private final int c;
  private final int d;
  private final float e;
  
  public a(Context paramContext)
  {
    this(b.b(paramContext, R.attr.elevationOverlayEnabled, false), g7.a.b(paramContext, R.attr.elevationOverlayColor, 0), g7.a.b(paramContext, R.attr.elevationOverlayAccentColor, 0), g7.a.b(paramContext, R.attr.colorSurface, 0), paramContext.getResources().getDisplayMetrics().density);
  }
  
  public a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramFloat;
  }
  
  private boolean f(int paramInt)
  {
    return q0.a.o(paramInt, 255) == this.d;
  }
  
  public float a(float paramFloat)
  {
    float f1 = this.e;
    if (f1 > 0.0F)
    {
      if (paramFloat <= 0.0F) {
        return 0.0F;
      }
      return Math.min(((float)Math.log1p(paramFloat / f1) * 4.5F + 2.0F) / 100.0F, 1.0F);
    }
    return 0.0F;
  }
  
  public int b(int paramInt, float paramFloat)
  {
    paramFloat = a(paramFloat);
    int j = Color.alpha(paramInt);
    int i = g7.a.h(q0.a.o(paramInt, 255), this.b, paramFloat);
    paramInt = i;
    if (paramFloat > 0.0F)
    {
      int k = this.c;
      paramInt = i;
      if (k != 0) {
        paramInt = g7.a.g(i, q0.a.o(k, f));
      }
    }
    return q0.a.o(paramInt, j);
  }
  
  public int c(int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (this.a)
    {
      i = paramInt;
      if (f(paramInt)) {
        i = b(paramInt, paramFloat);
      }
    }
    return i;
  }
  
  public int d(float paramFloat)
  {
    return c(this.d, paramFloat);
  }
  
  public boolean e()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j7.a
 * JD-Core Version:    0.7.0.1
 */