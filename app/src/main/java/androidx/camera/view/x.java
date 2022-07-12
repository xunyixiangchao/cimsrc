package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;

public class x
{
  public static final RectF a = new RectF(-1.0F, -1.0F, 1.0F, 1.0F);
  
  public static Matrix a(Rect paramRect)
  {
    return b(new RectF(paramRect));
  }
  
  private static Matrix b(RectF paramRectF)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(a, paramRectF, Matrix.ScaleToFit.FILL);
    return localMatrix;
  }
  
  public static Matrix c(RectF paramRectF1, RectF paramRectF2, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(paramRectF1, a, Matrix.ScaleToFit.FILL);
    localMatrix.postRotate(paramInt);
    localMatrix.postConcat(b(paramRectF2));
    return localMatrix;
  }
  
  public static boolean d(int paramInt)
  {
    if ((paramInt != 90) && (paramInt != 270))
    {
      if ((paramInt != 0) && (paramInt != 180))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid rotation degrees: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  public static boolean e(Size paramSize1, boolean paramBoolean1, Size paramSize2, boolean paramBoolean2)
  {
    float f2;
    float f1;
    if (paramBoolean1)
    {
      f2 = paramSize1.getWidth() / paramSize1.getHeight();
      f1 = f2;
    }
    else
    {
      f2 = (paramSize1.getWidth() + 1.0F) / (paramSize1.getHeight() - 1.0F);
      f1 = (paramSize1.getWidth() - 1.0F) / (paramSize1.getHeight() + 1.0F);
    }
    float f3;
    float f4;
    float f5;
    if (paramBoolean2)
    {
      f3 = paramSize2.getWidth() / paramSize2.getHeight();
      f4 = f3;
      f5 = f3;
    }
    else
    {
      f3 = (paramSize2.getWidth() + 1.0F) / (paramSize2.getHeight() - 1.0F);
      f5 = (paramSize2.getWidth() - 1.0F) / (paramSize2.getHeight() + 1.0F);
      f4 = f3;
    }
    return (f2 >= f5) && (f4 >= f1);
  }
  
  public static int f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return 270;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected rotation value ");
          localStringBuilder.append(paramInt);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        return 180;
      }
      return 90;
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.x
 * JD-Core Version:    0.7.0.1
 */