package e7;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g
  implements TypeEvaluator<Matrix>
{
  private final float[] a = new float[9];
  private final float[] b = new float[9];
  private final Matrix c = new Matrix();
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.a);
    paramMatrix2.getValues(this.b);
    int i = 0;
    while (i < 9)
    {
      paramMatrix1 = this.b;
      float f1 = paramMatrix1[i];
      paramMatrix2 = this.a;
      float f2 = paramMatrix2[i];
      paramMatrix2[i] += (f1 - f2) * paramFloat;
      i += 1;
    }
    this.c.setValues(this.b);
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.g
 * JD-Core Version:    0.7.0.1
 */