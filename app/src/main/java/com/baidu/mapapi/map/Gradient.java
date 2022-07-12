package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;

public class Gradient
{
  private final int a;
  private final int[] b;
  private final float[] c;
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this(paramArrayOfInt, paramArrayOfFloat, 1000);
  }
  
  private Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfFloat != null))
    {
      if (paramArrayOfInt.length == paramArrayOfFloat.length)
      {
        if (paramArrayOfInt.length != 0)
        {
          int i = 1;
          while (i < paramArrayOfFloat.length) {
            if (paramArrayOfFloat[i] > paramArrayOfFloat[(i - 1)]) {
              i += 1;
            } else {
              throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
            }
          }
          this.a = paramInt;
          int[] arrayOfInt = new int[paramArrayOfInt.length];
          this.b = arrayOfInt;
          float[] arrayOfFloat = new float[paramArrayOfFloat.length];
          this.c = arrayOfFloat;
          System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
          System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, paramArrayOfFloat.length);
          return;
        }
        throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
      }
      throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
    }
    throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = (int)((Color.alpha(paramInt2) - Color.alpha(paramInt1)) * paramFloat + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    paramInt1 = 0;
    if (arrayOfFloat1[0] - arrayOfFloat2[0] > 180.0F) {
      arrayOfFloat2[0] += 360.0F;
    } else if (arrayOfFloat2[0] - arrayOfFloat1[0] > 180.0F) {
      arrayOfFloat1[0] += 360.0F;
    }
    float[] arrayOfFloat3 = new float[3];
    while (paramInt1 < 3)
    {
      arrayOfFloat3[paramInt1] = ((arrayOfFloat2[paramInt1] - arrayOfFloat1[paramInt1]) * paramFloat + arrayOfFloat1[paramInt1]);
      paramInt1 += 1;
    }
    return Color.HSVToColor(i, arrayOfFloat3);
  }
  
  private HashMap<Integer, b> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.c[0] != 0.0F) {
      localHashMap.put(Integer.valueOf(0), new b(Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0])), this.b[0], this.a * this.c[0], null));
    }
    int i = 1;
    int j;
    while (i < this.b.length)
    {
      float f = this.a;
      localObject = this.c;
      j = i - 1;
      int k = (int)(f * localObject[j]);
      localObject = this.b;
      int m = localObject[j];
      int n = localObject[i];
      f = this.a;
      localObject = this.c;
      localHashMap.put(Integer.valueOf(k), new b(m, n, (localObject[i] - localObject[j]) * f, null));
      i += 1;
    }
    Object localObject = this.c;
    if (localObject[(localObject.length - 1)] != 1.0F)
    {
      i = localObject.length - 1;
      j = (int)(this.a * localObject[i]);
      localObject = this.b;
      localHashMap.put(Integer.valueOf(j), new b(localObject[i], localObject[i], this.a * (1.0F - this.c[i]), null));
    }
    return localHashMap;
  }
  
  int[] a(double paramDouble)
  {
    HashMap localHashMap = a();
    int[] arrayOfInt = new int[this.a];
    int k = 0;
    b localb = (b)localHashMap.get(Integer.valueOf(0));
    int i = 0;
    int j = i;
    while (i < this.a)
    {
      if (localHashMap.containsKey(Integer.valueOf(i)))
      {
        localb = (b)localHashMap.get(Integer.valueOf(i));
        j = i;
      }
      float f = (i - j) / b.a(localb);
      arrayOfInt[i] = a(b.b(localb), b.c(localb), f);
      i += 1;
    }
    if (paramDouble != 1.0D)
    {
      i = k;
      while (i < this.a)
      {
        j = arrayOfInt[i];
        arrayOfInt[i] = Color.argb((int)(Color.alpha(j) * paramDouble), Color.red(j), Color.green(j), Color.blue(j));
        i += 1;
      }
    }
    return arrayOfInt;
  }
  
  private class b
  {
    private final int a;
    private final int b;
    private final float c;
    
    private b(int paramInt1, int paramInt2, float paramFloat)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramFloat;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Gradient
 * JD-Core Version:    0.7.0.1
 */