package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import p0.i;

public class ArcMotion
  extends PathMotion
{
  private static final float g = (float)Math.tan(Math.toRadians(35.0D));
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 70.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = g;
  
  public ArcMotion() {}
  
  @SuppressLint({"RestrictedApi"})
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.j);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    d(i.f(paramContext, paramAttributeSet, "minimumVerticalAngle", 1, 0.0F));
    c(i.f(paramContext, paramAttributeSet, "minimumHorizontalAngle", 0, 0.0F));
    b(i.f(paramContext, paramAttributeSet, "maximumAngle", 2, 70.0F));
    paramContext.recycle();
  }
  
  private static float e(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 90.0F)) {
      return (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
    }
    throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
  }
  
  public Path a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f1 * f1 + f2 * f2;
    float f7 = (paramFloat1 + paramFloat3) / 2.0F;
    float f6 = (paramFloat2 + paramFloat4) / 2.0F;
    float f4 = 0.25F * f3;
    int i;
    if (paramFloat2 > paramFloat4) {
      i = 1;
    } else {
      i = 0;
    }
    if (Math.abs(f1) < Math.abs(f2))
    {
      f1 = Math.abs(f3 / (f2 * 2.0F));
      if (i != 0)
      {
        f1 += paramFloat4;
        f2 = paramFloat3;
      }
      else
      {
        f1 += paramFloat2;
        f2 = paramFloat1;
      }
      f3 = this.e;
    }
    else
    {
      f2 = f3 / (f1 * 2.0F);
      if (i != 0)
      {
        f1 = paramFloat2;
        f2 += paramFloat1;
      }
      else
      {
        f2 = paramFloat3 - f2;
        f1 = paramFloat4;
      }
      f3 = this.d;
    }
    f3 = f4 * f3 * f3;
    float f5 = f7 - f2;
    float f8 = f6 - f1;
    f8 = f5 * f5 + f8 * f8;
    f5 = this.f;
    f4 = f4 * f5 * f5;
    if (f8 >= f3) {
      if (f8 > f4) {
        f3 = f4;
      } else {
        f3 = 0.0F;
      }
    }
    f5 = f1;
    f4 = f2;
    if (f3 != 0.0F)
    {
      f3 = (float)Math.sqrt(f3 / f8);
      f4 = (f2 - f7) * f3 + f7;
      f5 = f6 + f3 * (f1 - f6);
    }
    localPath.cubicTo((paramFloat1 + f4) / 2.0F, (paramFloat2 + f5) / 2.0F, (f4 + paramFloat3) / 2.0F, (f5 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
    return localPath;
  }
  
  public void b(float paramFloat)
  {
    this.c = paramFloat;
    this.f = e(paramFloat);
  }
  
  public void c(float paramFloat)
  {
    this.a = paramFloat;
    this.d = e(paramFloat);
  }
  
  public void d(float paramFloat)
  {
    this.b = paramFloat;
    this.e = e(paramFloat);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ArcMotion
 * JD-Core Version:    0.7.0.1
 */