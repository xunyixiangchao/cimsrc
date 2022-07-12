package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import p0.i;
import q0.d;

public class PatternPathMotion
  extends PathMotion
{
  private Path a;
  private final Path b;
  private final Matrix c;
  
  public PatternPathMotion()
  {
    Path localPath = new Path();
    this.b = localPath;
    this.c = new Matrix();
    localPath.lineTo(1.0F, 0.0F);
    this.a = localPath;
  }
  
  @SuppressLint({"RestrictedApi"})
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = new Path();
    this.c = new Matrix();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.k);
    try
    {
      paramAttributeSet = i.i(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet != null)
      {
        c(d.e(paramAttributeSet));
        return;
      }
      throw new RuntimeException("pathData must be supplied for patternPathMotion");
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static float b(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public Path a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = b(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.c.setScale(f, f);
    this.c.postRotate((float)Math.toDegrees(d));
    this.c.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.b.transform(this.c, localPath);
    return localPath;
  }
  
  public void c(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1)) {
      throw new IllegalArgumentException("pattern must not end at the starting point");
    }
    this.c.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / b(f3, f1);
    this.c.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.c.postRotate((float)Math.toDegrees(-d));
    paramPath.transform(this.c, this.b);
    this.a = paramPath;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.PatternPathMotion
 * JD-Core Version:    0.7.0.1
 */