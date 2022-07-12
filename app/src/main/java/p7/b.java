package p7;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;
import q0.a;

public class b
{
  public static final boolean a = true;
  private static final int[] b = { 16842919 };
  private static final int[] c = { 16843623, 16842908 };
  private static final int[] d = { 16842908 };
  private static final int[] e = { 16843623 };
  private static final int[] f = { 16842913, 16842919 };
  private static final int[] g = { 16842913, 16843623, 16842908 };
  private static final int[] h = { 16842913, 16842908 };
  private static final int[] i = { 16842913, 16843623 };
  private static final int[] j = { 16842913 };
  private static final int[] k = { 16842910, 16842919 };
  static final String l = b.class.getSimpleName();
  
  public static ColorStateList a(ColorStateList paramColorStateList)
  {
    if (a)
    {
      arrayOfInt1 = j;
      m = c(paramColorStateList, f);
      arrayOfInt2 = StateSet.NOTHING;
      n = c(paramColorStateList, b);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { m, n });
    }
    int[] arrayOfInt1 = f;
    int m = c(paramColorStateList, arrayOfInt1);
    int[] arrayOfInt2 = g;
    int n = c(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = h;
    int i1 = c(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = i;
    int i2 = c(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = j;
    int[] arrayOfInt6 = b;
    int i3 = c(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = c;
    int i4 = c(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = d;
    int i5 = c(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = e;
    int i6 = c(paramColorStateList, arrayOfInt9);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { m, n, i1, i2, 0, i3, i4, i5, i6, 0 });
  }
  
  @TargetApi(21)
  private static int b(int paramInt)
  {
    return a.o(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  private static int c(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    int m;
    if (paramColorStateList != null) {
      m = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      m = 0;
    }
    int n = m;
    if (a) {
      n = b(m);
    }
    return n;
  }
  
  public static ColorStateList d(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if ((Build.VERSION.SDK_INT <= 27) && (Color.alpha(paramColorStateList.getDefaultColor()) == 0) && (Color.alpha(paramColorStateList.getColorForState(k, 0)) != 0)) {
        Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
      }
      return paramColorStateList;
    }
    return ColorStateList.valueOf(0);
  }
  
  public static boolean e(int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    boolean bool2 = false;
    int i2 = 0;
    int m = i2;
    int i1 = m;
    int n = m;
    m = i2;
    while (m < i3)
    {
      int i4 = paramArrayOfInt[m];
      if (i4 == 16842910)
      {
        i2 = 1;
      }
      else
      {
        if (i4 == 16842908) {}
        do
        {
          do
          {
            i1 = 1;
            i2 = n;
            break;
          } while (i4 == 16842919);
          i2 = n;
        } while (i4 == 16843623);
      }
      m += 1;
      n = i2;
    }
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p7.b
 * JD-Core Version:    0.7.0.1
 */