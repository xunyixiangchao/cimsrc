package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c.a;
import androidx.constraintlayout.widget.c.b;
import androidx.constraintlayout.widget.c.c;
import androidx.constraintlayout.widget.c.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class o
  implements Comparable<o>
{
  static String[] t = { "position", "x", "y", "width", "height", "pathRotate" };
  i0.c a;
  int b = 0;
  float c;
  float d;
  float e;
  float f;
  float g;
  float h;
  float i = (0.0F / 0.0F);
  float j = (0.0F / 0.0F);
  int k;
  int l;
  float m;
  m n;
  LinkedHashMap<String, a> o;
  int p;
  int q;
  double[] r;
  double[] s;
  
  public o()
  {
    int i1 = d.f;
    this.k = i1;
    this.l = i1;
    this.m = (0.0F / 0.0F);
    this.n = null;
    this.o = new LinkedHashMap();
    this.p = 0;
    this.r = new double[18];
    this.s = new double[18];
  }
  
  public o(int paramInt1, int paramInt2, h paramh, o paramo1, o paramo2)
  {
    int i1 = d.f;
    this.k = i1;
    this.l = i1;
    this.m = (0.0F / 0.0F);
    this.n = null;
    this.o = new LinkedHashMap();
    this.p = 0;
    this.r = new double[18];
    this.s = new double[18];
    if (paramo1.l != d.f)
    {
      n(paramInt1, paramInt2, paramh, paramo1, paramo2);
      return;
    }
    i1 = paramh.q;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        l(paramh, paramo1, paramo2);
        return;
      }
      o(paramInt1, paramInt2, paramh, paramo1, paramo2);
      return;
    }
    m(paramh, paramo1, paramo2);
  }
  
  private boolean c(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat1 - paramFloat2) > 1.0E-006F;
    }
    return Float.isNaN(paramFloat1) != Float.isNaN(paramFloat2);
  }
  
  public void a(c.a parama)
  {
    this.a = i0.c.c(parama.d.d);
    Object localObject = parama.d;
    this.k = ((c.c)localObject).e;
    this.l = ((c.c)localObject).b;
    this.i = ((c.c)localObject).i;
    this.b = ((c.c)localObject).f;
    this.q = ((c.c)localObject).c;
    this.j = parama.c.e;
    this.m = parama.e.D;
    localObject = parama.g.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      a locala = (a)parama.g.get(str);
      if ((locala != null) && (locala.g())) {
        this.o.put(str, locala);
      }
    }
  }
  
  public int b(o paramo)
  {
    return Float.compare(this.d, paramo.d);
  }
  
  void d(o paramo, boolean[] paramArrayOfBoolean, String[] paramArrayOfString, boolean paramBoolean)
  {
    boolean bool1 = c(this.e, paramo.e);
    boolean bool2 = c(this.f, paramo.f);
    paramArrayOfBoolean[0] |= c(this.d, paramo.d);
    int i2 = paramArrayOfBoolean[1];
    int i1 = bool1 | bool2 | paramBoolean;
    paramArrayOfBoolean[1] = (i2 | i1);
    paramArrayOfBoolean[2] = (i1 | paramArrayOfBoolean[2]);
    paramArrayOfBoolean[3] |= c(this.g, paramo.g);
    paramBoolean = paramArrayOfBoolean[4];
    paramArrayOfBoolean[4] = (c(this.h, paramo.h) | paramBoolean);
  }
  
  void e(double[] paramArrayOfDouble, int[] paramArrayOfInt)
  {
    float f1 = this.d;
    int i1 = 0;
    float f2 = this.e;
    float f3 = this.f;
    float f4 = this.g;
    float f5 = this.h;
    float f6 = this.i;
    int i3;
    for (int i2 = 0; i1 < paramArrayOfInt.length; i2 = i3)
    {
      i3 = i2;
      if (paramArrayOfInt[i1] < 6)
      {
        i3 = paramArrayOfInt[i1];
        paramArrayOfDouble[i2] = new float[] { f1, f2, f3, f4, f5, f6 }[i3];
        i3 = i2 + 1;
      }
      i1 += 1;
    }
  }
  
  void f(double paramDouble, int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat, int paramInt)
  {
    float f3 = this.e;
    float f2 = this.f;
    float f5 = this.g;
    float f4 = this.h;
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      f1 = (float)paramArrayOfDouble[i1];
      int i2 = paramArrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              f4 = f1;
            }
          }
          else {
            f5 = f1;
          }
        }
        else {
          f2 = f1;
        }
      }
      else {
        f3 = f1;
      }
      i1 += 1;
    }
    paramArrayOfInt = this.n;
    float f6 = f3;
    float f1 = f2;
    if (paramArrayOfInt != null)
    {
      paramArrayOfDouble = new float[2];
      paramArrayOfInt.i(paramDouble, paramArrayOfDouble, new float[2]);
      f6 = paramArrayOfDouble[0];
      f1 = paramArrayOfDouble[1];
      paramDouble = f6;
      double d1 = f3;
      double d2 = f2;
      f2 = (float)(paramDouble + Math.sin(d2) * d1 - f5 / 2.0F);
      f1 = (float)(f1 - d1 * Math.cos(d2) - f4 / 2.0F);
      f6 = f2;
    }
    paramArrayOfFloat[paramInt] = (f6 + f5 / 2.0F + 0.0F);
    paramArrayOfFloat[(paramInt + 1)] = (f1 + f4 / 2.0F + 0.0F);
  }
  
  void g(double paramDouble, int[] paramArrayOfInt, double[] paramArrayOfDouble1, float[] paramArrayOfFloat1, double[] paramArrayOfDouble2, float[] paramArrayOfFloat2)
  {
    float f3 = this.e;
    float f4 = this.f;
    float f6 = this.g;
    float f5 = this.h;
    int i1 = 0;
    float f8 = 0.0F;
    float f10 = 0.0F;
    float f7 = 0.0F;
    float f9 = 0.0F;
    while (i1 < paramArrayOfInt.length)
    {
      f2 = (float)paramArrayOfDouble1[i1];
      f1 = (float)paramArrayOfDouble2[i1];
      int i2 = paramArrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4)
            {
              f5 = f2;
              f9 = f1;
            }
          }
          else
          {
            f6 = f2;
            f10 = f1;
          }
        }
        else
        {
          f4 = f2;
          f7 = f1;
        }
      }
      else
      {
        f8 = f1;
        f3 = f2;
      }
      i1 += 1;
    }
    float f1 = f10 / 2.0F + f8;
    float f2 = f9 / 2.0F + f7;
    paramArrayOfInt = this.n;
    if (paramArrayOfInt != null)
    {
      paramArrayOfDouble1 = new float[2];
      paramArrayOfDouble2 = new float[2];
      paramArrayOfInt.i(paramDouble, paramArrayOfDouble1, paramArrayOfDouble2);
      f10 = paramArrayOfDouble1[0];
      f9 = paramArrayOfDouble1[1];
      f1 = paramArrayOfDouble2[0];
      f2 = paramArrayOfDouble2[1];
      double d1 = f10;
      double d2 = f3;
      paramDouble = f4;
      f3 = (float)(d1 + Math.sin(paramDouble) * d2 - f6 / 2.0F);
      f4 = (float)(f9 - d2 * Math.cos(paramDouble) - f5 / 2.0F);
      d1 = f1;
      d2 = f8;
      double d3 = Math.sin(paramDouble);
      double d4 = Math.cos(paramDouble);
      double d5 = f7;
      f1 = (float)(d1 + d3 * d2 + d4 * d5);
      f2 = (float)(f2 - d2 * Math.cos(paramDouble) + Math.sin(paramDouble) * d5);
    }
    paramArrayOfFloat1[0] = (f3 + f6 / 2.0F + 0.0F);
    paramArrayOfFloat1[1] = (f4 + f5 / 2.0F + 0.0F);
    paramArrayOfFloat2[0] = f1;
    paramArrayOfFloat2[1] = f2;
  }
  
  int h(String paramString, double[] paramArrayOfDouble, int paramInt)
  {
    paramString = (a)this.o.get(paramString);
    int i1 = 0;
    if (paramString == null) {
      return 0;
    }
    if (paramString.h() == 1)
    {
      paramArrayOfDouble[paramInt] = paramString.e();
      return 1;
    }
    int i2 = paramString.h();
    float[] arrayOfFloat = new float[i2];
    paramString.f(arrayOfFloat);
    while (i1 < i2)
    {
      paramArrayOfDouble[paramInt] = arrayOfFloat[i1];
      i1 += 1;
      paramInt += 1;
    }
    return i2;
  }
  
  int i(String paramString)
  {
    paramString = (a)this.o.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.h();
  }
  
  void j(int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat, int paramInt)
  {
    float f3 = this.e;
    float f2 = this.f;
    float f5 = this.g;
    float f4 = this.h;
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      f1 = (float)paramArrayOfDouble[i1];
      int i2 = paramArrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              f4 = f1;
            }
          }
          else {
            f5 = f1;
          }
        }
        else {
          f2 = f1;
        }
      }
      else {
        f3 = f1;
      }
      i1 += 1;
    }
    paramArrayOfInt = this.n;
    float f6 = f3;
    float f1 = f2;
    if (paramArrayOfInt != null)
    {
      f6 = paramArrayOfInt.j();
      f1 = this.n.k();
      double d1 = f6;
      double d2 = f3;
      double d3 = f2;
      f6 = (float)(d1 + Math.sin(d3) * d2 - f5 / 2.0F);
      f1 = (float)(f1 - d2 * Math.cos(d3) - f4 / 2.0F);
    }
    f2 = f5 + f6;
    f3 = f4 + f1;
    Float.isNaN((0.0F / 0.0F));
    Float.isNaN((0.0F / 0.0F));
    i1 = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f6 + 0.0F);
    paramInt = i1 + 1;
    paramArrayOfFloat[i1] = (f1 + 0.0F);
    i1 = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f2 + 0.0F);
    paramInt = i1 + 1;
    paramArrayOfFloat[i1] = (f1 + 0.0F);
    i1 = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f2 + 0.0F);
    paramInt = i1 + 1;
    paramArrayOfFloat[i1] = (f3 + 0.0F);
    paramArrayOfFloat[paramInt] = (f6 + 0.0F);
    paramArrayOfFloat[(paramInt + 1)] = (f3 + 0.0F);
  }
  
  boolean k(String paramString)
  {
    return this.o.containsKey(paramString);
  }
  
  void l(h paramh, o paramo1, o paramo2)
  {
    float f1 = paramh.a / 100.0F;
    this.c = f1;
    this.b = paramh.j;
    if (Float.isNaN(paramh.k)) {
      f2 = f1;
    } else {
      f2 = paramh.k;
    }
    if (Float.isNaN(paramh.l)) {
      f3 = f1;
    } else {
      f3 = paramh.l;
    }
    float f7 = paramo2.g;
    float f4 = paramo1.g;
    float f10 = paramo2.h;
    float f8 = paramo1.h;
    this.d = this.c;
    float f11 = paramo1.e;
    float f5 = f4 / 2.0F;
    float f9 = paramo1.f;
    float f6 = f8 / 2.0F;
    float f14 = paramo2.e;
    float f15 = f7 / 2.0F;
    float f12 = paramo2.f;
    float f13 = f10 / 2.0F;
    f5 = f14 + f15 - (f5 + f11);
    f6 = f12 + f13 - (f9 + f6);
    float f2 = (f7 - f4) * f2;
    f7 = f2 / 2.0F;
    this.e = ((int)(f11 + f5 * f1 - f7));
    float f3 = (f10 - f8) * f3;
    f10 = f3 / 2.0F;
    this.f = ((int)(f9 + f6 * f1 - f10));
    this.g = ((int)(f4 + f2));
    this.h = ((int)(f8 + f3));
    if (Float.isNaN(paramh.m)) {
      f2 = f1;
    } else {
      f2 = paramh.m;
    }
    boolean bool = Float.isNaN(paramh.p);
    f4 = 0.0F;
    if (bool) {
      f3 = 0.0F;
    } else {
      f3 = paramh.p;
    }
    if (!Float.isNaN(paramh.n)) {
      f1 = paramh.n;
    }
    if (!Float.isNaN(paramh.o)) {
      f4 = paramh.o;
    }
    this.p = 0;
    this.e = ((int)(paramo1.e + f2 * f5 + f4 * f6 - f7));
    this.f = ((int)(paramo1.f + f5 * f3 + f6 * f1 - f10));
    this.a = i0.c.c(paramh.h);
    this.k = paramh.i;
  }
  
  void m(h paramh, o paramo1, o paramo2)
  {
    float f1 = paramh.a / 100.0F;
    this.c = f1;
    this.b = paramh.j;
    if (Float.isNaN(paramh.k)) {
      f3 = f1;
    } else {
      f3 = paramh.k;
    }
    if (Float.isNaN(paramh.l)) {
      f2 = f1;
    } else {
      f2 = paramh.l;
    }
    float f11 = paramo2.g;
    float f12 = paramo1.g;
    float f5 = paramo2.h;
    float f6 = paramo1.h;
    this.d = this.c;
    if (!Float.isNaN(paramh.m)) {
      f1 = paramh.m;
    }
    float f13 = paramo1.e;
    float f7 = paramo1.g;
    float f4 = f7 / 2.0F;
    float f8 = paramo1.f;
    float f9 = paramo1.h;
    float f10 = f9 / 2.0F;
    float f16 = paramo2.e;
    float f17 = paramo2.g / 2.0F;
    float f14 = paramo2.f;
    float f15 = paramo2.h / 2.0F;
    f4 = f16 + f17 - (f4 + f13);
    f14 = f14 + f15 - (f10 + f8);
    f10 = f4 * f1;
    f12 = (f11 - f12) * f3;
    float f3 = f12 / 2.0F;
    this.e = ((int)(f13 + f10 - f3));
    f11 = f1 * f14;
    f1 = (f5 - f6) * f2;
    float f2 = f1 / 2.0F;
    this.f = ((int)(f8 + f11 - f2));
    this.g = ((int)(f7 + f12));
    this.h = ((int)(f9 + f1));
    if (Float.isNaN(paramh.n)) {
      f1 = 0.0F;
    } else {
      f1 = paramh.n;
    }
    f5 = -f14;
    this.p = 1;
    f3 = (int)(paramo1.e + f10 - f3);
    f2 = (int)(paramo1.f + f11 - f2);
    this.e = (f3 + f5 * f1);
    this.f = (f2 + f4 * f1);
    this.l = this.l;
    this.a = i0.c.c(paramh.h);
    this.k = paramh.i;
  }
  
  void n(int paramInt1, int paramInt2, h paramh, o paramo1, o paramo2)
  {
    float f1 = paramh.a / 100.0F;
    this.c = f1;
    this.b = paramh.j;
    this.p = paramh.q;
    float f2;
    if (Float.isNaN(paramh.k)) {
      f2 = f1;
    } else {
      f2 = paramh.k;
    }
    float f3;
    if (Float.isNaN(paramh.l)) {
      f3 = f1;
    } else {
      f3 = paramh.l;
    }
    float f4 = paramo2.g;
    float f5 = paramo1.g;
    float f6 = paramo2.h;
    float f7 = paramo1.h;
    this.d = this.c;
    this.g = ((int)(f5 + (f4 - f5) * f2));
    this.h = ((int)(f7 + (f6 - f7) * f3));
    paramInt1 = paramh.q;
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
      {
        if (Float.isNaN(paramh.m)) {
          f2 = f1;
        } else {
          f2 = paramh.m;
        }
        f3 = paramo2.e;
        f4 = paramo1.e;
        this.e = (f2 * (f3 - f4) + f4);
        if (!Float.isNaN(paramh.n)) {
          f1 = paramh.n;
        }
      }
    }
    for (;;)
    {
      f2 = paramo2.f;
      f3 = paramo1.f;
      for (f1 = f1 * (f2 - f3) + f3;; f1 = paramh.n)
      {
        this.f = f1;
        break label421;
        if (Float.isNaN(paramh.m))
        {
          f2 = paramo2.e;
          f3 = paramo1.e;
          f2 = (f2 - f3) * f1 + f3;
        }
        else
        {
          f4 = paramh.m;
          f2 = Math.min(f3, f2) * f4;
        }
        this.e = f2;
        if (Float.isNaN(paramh.n)) {
          break;
        }
      }
      if (Float.isNaN(paramh.m)) {
        f2 = f1;
      } else {
        f2 = paramh.m;
      }
      f3 = paramo2.e;
      f4 = paramo1.e;
      this.e = (f2 * (f3 - f4) + f4);
      if (!Float.isNaN(paramh.n)) {
        break;
      }
    }
    label421:
    this.l = paramo1.l;
    this.a = i0.c.c(paramh.h);
    this.k = paramh.i;
  }
  
  void o(int paramInt1, int paramInt2, h paramh, o paramo1, o paramo2)
  {
    float f1 = paramh.a / 100.0F;
    this.c = f1;
    this.b = paramh.j;
    if (Float.isNaN(paramh.k)) {
      f2 = f1;
    } else {
      f2 = paramh.k;
    }
    if (Float.isNaN(paramh.l)) {
      f3 = f1;
    } else {
      f3 = paramh.l;
    }
    float f15 = paramo2.g;
    float f4 = paramo1.g;
    float f10 = paramo2.h;
    float f5 = paramo1.h;
    this.d = this.c;
    float f11 = paramo1.e;
    float f12 = f4 / 2.0F;
    float f6 = paramo1.f;
    float f7 = f5 / 2.0F;
    float f13 = paramo2.e;
    float f14 = f15 / 2.0F;
    float f8 = paramo2.f;
    float f9 = f10 / 2.0F;
    float f2 = (f15 - f4) * f2;
    this.e = ((int)(f11 + (f13 + f14 - (f12 + f11)) * f1 - f2 / 2.0F));
    float f3 = (f10 - f5) * f3;
    this.f = ((int)(f6 + (f8 + f9 - (f6 + f7)) * f1 - f3 / 2.0F));
    this.g = ((int)(f4 + f2));
    this.h = ((int)(f5 + f3));
    this.p = 2;
    if (!Float.isNaN(paramh.m))
    {
      paramInt1 = (int)(paramInt1 - this.g);
      this.e = ((int)(paramh.m * paramInt1));
    }
    if (!Float.isNaN(paramh.n))
    {
      paramInt1 = (int)(paramInt2 - this.h);
      this.f = ((int)(paramh.n * paramInt1));
    }
    this.l = this.l;
    this.a = i0.c.c(paramh.h);
    this.k = paramh.i;
  }
  
  void p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
  }
  
  void q(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i1 = 0;
    float f5 = 0.0F;
    float f1 = f5;
    float f2 = f1;
    float f3 = f2;
    float f4 = f2;
    f2 = f1;
    while (i1 < paramArrayOfInt.length)
    {
      f1 = (float)paramArrayOfDouble1[i1];
      double d1 = paramArrayOfDouble2[i1];
      int i2 = paramArrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              f3 = f1;
            }
          }
          else {
            f2 = f1;
          }
        }
        else {
          f4 = f1;
        }
      }
      else {
        f5 = f1;
      }
      i1 += 1;
    }
    f1 = f5 - 0.0F * f2 / 2.0F;
    f4 -= 0.0F * f3 / 2.0F;
    paramArrayOfFloat[0] = (f1 * (1.0F - paramFloat1) + (f2 * 1.0F + f1) * paramFloat1 + 0.0F);
    paramArrayOfFloat[1] = (f4 * (1.0F - paramFloat2) + (f3 * 1.0F + f4) * paramFloat2 + 0.0F);
  }
  
  void r(float paramFloat, View paramView, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, boolean paramBoolean)
  {
    float f7 = this.e;
    float f6 = this.f;
    float f8 = this.g;
    float f5 = this.h;
    if ((paramArrayOfInt.length != 0) && (this.r.length <= paramArrayOfInt[(paramArrayOfInt.length - 1)]))
    {
      i1 = paramArrayOfInt[(paramArrayOfInt.length - 1)] + 1;
      this.r = new double[i1];
      this.s = new double[i1];
    }
    Arrays.fill(this.r, (0.0D / 0.0D));
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      this.r[paramArrayOfInt[i1]] = paramArrayOfDouble1[i1];
      this.s[paramArrayOfInt[i1]] = paramArrayOfDouble2[i1];
      i1 += 1;
    }
    float f3 = (0.0F / 0.0F);
    i1 = 0;
    float f10 = 0.0F;
    float f9 = 0.0F;
    float f12 = 0.0F;
    float f11 = 0.0F;
    double d1;
    float f2;
    float f1;
    float f4;
    for (;;)
    {
      paramArrayOfInt = this.r;
      if (i1 >= paramArrayOfInt.length) {
        break;
      }
      boolean bool = Double.isNaN(paramArrayOfInt[i1]);
      d1 = 0.0D;
      if ((!bool) || ((paramArrayOfDouble3 == null) || (paramArrayOfDouble3[i1] != 0.0D)))
      {
        if (paramArrayOfDouble3 != null) {
          d1 = paramArrayOfDouble3[i1];
        }
        if (!Double.isNaN(this.r[i1])) {
          d1 = this.r[i1] + d1;
        }
        f2 = f3;
        f1 = (float)d1;
        f4 = (float)this.s[i1];
        if (i1 == 1) {
          break label336;
        }
        if (i1 == 2) {
          break label321;
        }
        if (i1 == 3) {
          break label306;
        }
        if (i1 == 4) {
          break label291;
        }
        if (i1 == 5) {}
      }
      else
      {
        f1 = f3;
        break label348;
      }
      break label348;
      label291:
      f5 = f1;
      f1 = f2;
      f11 = f4;
      break label348;
      label306:
      f8 = f1;
      f1 = f2;
      f12 = f4;
      break label348;
      label321:
      f6 = f1;
      f1 = f2;
      f9 = f4;
      break label348;
      label336:
      f7 = f1;
      f10 = f4;
      f1 = f2;
      label348:
      i1 += 1;
      f3 = f1;
    }
    paramArrayOfInt = this.n;
    if (paramArrayOfInt != null)
    {
      paramArrayOfDouble1 = new float[2];
      paramArrayOfDouble3 = new float[2];
      paramArrayOfInt.i(paramFloat, paramArrayOfDouble1, paramArrayOfDouble3);
      paramFloat = paramArrayOfDouble1[0];
      f1 = paramArrayOfDouble1[1];
      f4 = paramArrayOfDouble3[0];
      f2 = paramArrayOfDouble3[1];
      double d3 = paramFloat;
      d1 = f7;
      double d2 = f6;
      paramFloat = (float)(d3 + Math.sin(d2) * d1 - f8 / 2.0F);
      f1 = (float)(f1 - Math.cos(d2) * d1 - f5 / 2.0F);
      d3 = f4;
      double d4 = f10;
      double d5 = Math.sin(d2);
      double d6 = Math.cos(d2);
      double d7 = f9;
      f4 = (float)(d3 + d5 * d4 + d6 * d1 * d7);
      f2 = (float)(f2 - d4 * Math.cos(d2) + d1 * Math.sin(d2) * d7);
      if (paramArrayOfDouble2.length >= 2)
      {
        paramArrayOfDouble2[0] = f4;
        paramArrayOfDouble2[1] = f2;
      }
      if (!Float.isNaN(f3)) {
        paramView.setRotation((float)(f3 + Math.toDegrees(Math.atan2(f2, f4))));
      }
    }
    else
    {
      paramFloat = f7;
      f1 = f6;
      if (!Float.isNaN(f3))
      {
        paramFloat = f12 / 2.0F;
        f1 = f11 / 2.0F;
        paramView.setRotation((float)(0.0F + (f3 + Math.toDegrees(Math.atan2(f9 + f1, f10 + paramFloat)))));
        f1 = f6;
        paramFloat = f7;
      }
    }
    i1 = 0;
    if ((paramView instanceof c))
    {
      ((c)paramView).a(paramFloat, f1, f8 + paramFloat, f1 + f5);
      return;
    }
    paramFloat += 0.5F;
    int i2 = (int)paramFloat;
    f1 += 0.5F;
    int i3 = (int)f1;
    int i4 = (int)(paramFloat + f8);
    int i5 = (int)(f1 + f5);
    int i6 = i4 - i2;
    int i7 = i5 - i3;
    if ((i6 != paramView.getMeasuredWidth()) || (i7 != paramView.getMeasuredHeight())) {
      i1 = 1;
    }
    if ((i1 != 0) || (paramBoolean)) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
    }
    paramView.layout(i2, i3, i4, i5);
  }
  
  public void s(m paramm, o paramo)
  {
    double d1 = this.e + this.g / 2.0F - paramo.e - paramo.g / 2.0F;
    double d2 = this.f + this.h / 2.0F - paramo.f - paramo.h / 2.0F;
    this.n = paramm;
    this.e = ((float)Math.hypot(d2, d1));
    if (Float.isNaN(this.m)) {
      d1 = Math.atan2(d2, d1) + 1.570796326794897D;
    } else {
      d1 = Math.toRadians(this.m);
    }
    this.f = ((float)d1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.o
 * JD-Core Version:    0.7.0.1
 */