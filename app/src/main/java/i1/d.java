package i1;

import android.view.animation.Interpolator;

abstract class d
  implements Interpolator
{
  private final float[] a;
  private final float b;
  
  protected d(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat;
    this.b = (1.0F / (paramArrayOfFloat.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    float[] arrayOfFloat = this.a;
    int i = Math.min((int)((arrayOfFloat.length - 1) * paramFloat), arrayOfFloat.length - 2);
    float f1 = i;
    float f2 = this.b;
    paramFloat = (paramFloat - f1 * f2) / f2;
    arrayOfFloat = this.a;
    return arrayOfFloat[i] + paramFloat * (arrayOfFloat[(i + 1)] - arrayOfFloat[i]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i1.d
 * JD-Core Version:    0.7.0.1
 */