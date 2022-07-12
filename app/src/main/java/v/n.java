package v;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.v2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import x0.h;
import z.b;

public class n
{
  public static Map<v2, Rect> a(Rect paramRect, boolean paramBoolean, Rational paramRational, int paramInt1, int paramInt2, int paramInt3, Map<v2, Size> paramMap)
  {
    boolean bool;
    if ((paramRect.width() > 0) && (paramRect.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    h.b(bool, "Cannot compute viewport crop rects zero sized sensor rect.");
    Object localObject2 = new RectF(paramRect);
    Object localObject1 = new HashMap();
    paramRect = new RectF(paramRect);
    paramMap = paramMap.entrySet().iterator();
    Object localObject3;
    Object localObject4;
    while (paramMap.hasNext())
    {
      Object localObject5 = (Map.Entry)paramMap.next();
      localObject3 = new Matrix();
      localObject4 = new RectF(0.0F, 0.0F, ((Size)((Map.Entry)localObject5).getValue()).getWidth(), ((Size)((Map.Entry)localObject5).getValue()).getHeight());
      ((Matrix)localObject3).setRectToRect((RectF)localObject4, (RectF)localObject2, Matrix.ScaleToFit.CENTER);
      ((Map)localObject1).put((v2)((Map.Entry)localObject5).getKey(), localObject3);
      localObject5 = new RectF();
      ((Matrix)localObject3).mapRect((RectF)localObject5, (RectF)localObject4);
      paramRect.intersect((RectF)localObject5);
    }
    paramRect = g(paramRect, b.d(paramInt1, paramRational), paramInt2, paramBoolean, paramInt3, paramInt1);
    paramRational = new HashMap();
    paramMap = new RectF();
    localObject2 = new Matrix();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      ((Matrix)((Map.Entry)localObject3).getValue()).invert((Matrix)localObject2);
      ((Matrix)localObject2).mapRect(paramMap, paramRect);
      localObject4 = new Rect();
      paramMap.round((Rect)localObject4);
      paramRational.put((v2)((Map.Entry)localObject3).getKey(), localObject4);
    }
    return paramRational;
  }
  
  private static RectF b(boolean paramBoolean, int paramInt, RectF paramRectF1, RectF paramRectF2)
  {
    int k = 1;
    int i;
    if ((paramInt == 0) && (!paramBoolean)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramInt == 90) && (paramBoolean)) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return paramRectF2;
      }
      if ((paramInt == 0) && (paramBoolean)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramInt == 270) && (!paramBoolean)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i == 0) && (j == 0))
      {
        if ((paramInt == 90) && (!paramBoolean)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramInt == 180) && (paramBoolean)) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i == 0) && (j == 0))
        {
          if ((paramInt == 180) && (!paramBoolean)) {
            i = 1;
          } else {
            i = 0;
          }
          if ((paramInt == 270) && (paramBoolean)) {
            j = k;
          } else {
            j = 0;
          }
          if ((i == 0) && (j == 0))
          {
            paramRectF1 = new StringBuilder();
            paramRectF1.append("Invalid argument: mirrored ");
            paramRectF1.append(paramBoolean);
            paramRectF1.append(" rotation ");
            paramRectF1.append(paramInt);
            throw new IllegalArgumentException(paramRectF1.toString());
          }
          return c(d(paramRectF2, paramRectF1.centerY()), paramRectF1.centerX());
        }
        return d(paramRectF2, paramRectF1.centerY());
      }
      return c(paramRectF2, paramRectF1.centerX());
    }
    return paramRectF2;
  }
  
  private static RectF c(RectF paramRectF, float paramFloat)
  {
    return new RectF(e(paramRectF.right, paramFloat), paramRectF.top, e(paramRectF.left, paramFloat), paramRectF.bottom);
  }
  
  private static RectF d(RectF paramRectF, float paramFloat)
  {
    return new RectF(paramRectF.left, f(paramRectF.bottom, paramFloat), paramRectF.right, f(paramRectF.top, paramFloat));
  }
  
  private static float e(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 + paramFloat2 - paramFloat1;
  }
  
  private static float f(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 + paramFloat2 - paramFloat1;
  }
  
  @SuppressLint({"SwitchIntDef"})
  public static RectF g(RectF paramRectF, Rational paramRational, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 3) {
      return paramRectF;
    }
    Matrix localMatrix = new Matrix();
    RectF localRectF = new RectF(0.0F, 0.0F, paramRational.getNumerator(), paramRational.getDenominator());
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          paramRational = Matrix.ScaleToFit.END;
        }
        else
        {
          paramRectF = new StringBuilder();
          paramRectF.append("Unexpected scale type: ");
          paramRectF.append(paramInt1);
          throw new IllegalStateException(paramRectF.toString());
        }
      }
      else {
        paramRational = Matrix.ScaleToFit.CENTER;
      }
    }
    else {
      paramRational = Matrix.ScaleToFit.START;
    }
    localMatrix.setRectToRect(localRectF, paramRectF, paramRational);
    paramRational = new RectF();
    localMatrix.mapRect(paramRational, localRectF);
    return b(h(paramBoolean, paramInt2), paramInt3, paramRectF, paramRational);
  }
  
  private static boolean h(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    return paramBoolean ^ paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v.n
 * JD-Core Version:    0.7.0.1
 */