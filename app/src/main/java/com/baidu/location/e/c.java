package com.baidu.location.e;

import java.util.ArrayList;

public class c
{
  public static int a(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayList.size(); j = k)
    {
      k = j;
      if (((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() > 0.0F) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static int b(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayList.size(); j = k)
    {
      k = j;
      if (((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() >= 15.0F) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static int c(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayList.size(); j = k)
    {
      k = j;
      if (((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() >= 20.0F) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static int d(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < paramArrayList.size(); f1 = f2)
    {
      f2 = f1;
      if (((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() > 0.0F) {
        f2 = f1 + ((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue();
      }
      i += 1;
    }
    return Math.round(f1);
  }
  
  public static int e(ArrayList<ArrayList<Float>> paramArrayList)
  {
    return Math.round(d(paramArrayList) / a(paramArrayList));
  }
  
  public static int f(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < paramArrayList.size(); f1 = f2)
    {
      f2 = f1;
      if (((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() > 0.0F) {
        f2 = f1 + ((Float)((ArrayList)paramArrayList.get(i)).get(2)).floatValue() * ((Float)((ArrayList)paramArrayList.get(i)).get(1)).floatValue();
      }
      i += 1;
    }
    return Math.round(f1);
  }
  
  public static int g(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int i = a(paramArrayList);
    return Math.round(f(paramArrayList) / i);
  }
  
  public static int h(ArrayList<ArrayList<Float>> paramArrayList)
  {
    int[] arrayOfInt = new int[37];
    int m = 0;
    int j = 0;
    int k;
    int i;
    for (;;)
    {
      int n = paramArrayList.size();
      k = 1;
      i = m;
      if (j >= n) {
        break;
      }
      if (((Float)((ArrayList)paramArrayList.get(j)).get(0)).floatValue() < 360.0D)
      {
        i = (int)Math.ceil(((Float)((ArrayList)paramArrayList.get(j)).get(0)).floatValue() / 10.0F);
        arrayOfInt[i] += 1;
      }
      j += 1;
    }
    while (k <= 36)
    {
      j = i;
      if (arrayOfInt[k] > 0) {
        j = i + 1;
      }
      k += 1;
      i = j;
    }
    return Math.round(i / 36.0F * 1000.0F);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.e.c
 * JD-Core Version:    0.7.0.1
 */