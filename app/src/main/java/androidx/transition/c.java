package androidx.transition;

import android.animation.TypeEvaluator;

class c
  implements TypeEvaluator<float[]>
{
  private float[] a;
  
  c(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat;
  }
  
  public float[] a(float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat2 = this.a;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null) {
      arrayOfFloat1 = new float[paramArrayOfFloat1.length];
    }
    int i = 0;
    while (i < arrayOfFloat1.length)
    {
      float f = paramArrayOfFloat1[i];
      arrayOfFloat1[i] = (f + (paramArrayOfFloat2[i] - f) * paramFloat);
      i += 1;
    }
    return arrayOfFloat1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.c
 * JD-Core Version:    0.7.0.1
 */