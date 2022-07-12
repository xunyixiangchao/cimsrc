package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.c.a;
import androidx.constraintlayout.widget.c.c;
import androidx.constraintlayout.widget.c.e;
import i0.b;
import i0.p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import n0.c.d;
import n0.d.d;
import n0.f.d;

public class m
{
  private ArrayList<d> A = new ArrayList();
  private HashMap<String, n0.f> B;
  private HashMap<String, n0.d> C;
  private HashMap<String, n0.c> D;
  private k[] E;
  private int F;
  private int G;
  private View H;
  private int I;
  private float J;
  private Interpolator K;
  private boolean L;
  Rect a = new Rect();
  View b;
  int c;
  boolean d = false;
  String e;
  private int f = -1;
  private o g = new o();
  private o h = new o();
  private l i = new l();
  private l j = new l();
  private b[] k;
  private b l;
  float m = (0.0F / 0.0F);
  float n = 0.0F;
  float o = 1.0F;
  float p;
  float q;
  private int[] r;
  private double[] s;
  private double[] t;
  private String[] u;
  private int[] v;
  private int w = 4;
  private float[] x = new float[4];
  private ArrayList<o> y = new ArrayList();
  private float[] z = new float[1];
  
  m(View paramView)
  {
    int i1 = d.f;
    this.F = i1;
    this.G = i1;
    this.H = null;
    this.I = i1;
    this.J = (0.0F / 0.0F);
    this.K = null;
    this.L = false;
    H(paramView);
  }
  
  private float g(float paramFloat, float[] paramArrayOfFloat)
  {
    float f3 = 0.0F;
    float f4 = 1.0F;
    float f1;
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[0] = 1.0F;
      f1 = paramFloat;
    }
    else
    {
      float f5 = this.o;
      f1 = paramFloat;
      if (f5 != 1.0D)
      {
        float f6 = this.n;
        f2 = paramFloat;
        if (paramFloat < f6) {
          f2 = 0.0F;
        }
        f1 = f2;
        if (f2 > f6)
        {
          f1 = f2;
          if (f2 < 1.0D) {
            f1 = Math.min((f2 - f6) * f5, 1.0F);
          }
        }
      }
    }
    Object localObject = this.g.a;
    paramFloat = (0.0F / 0.0F);
    Iterator localIterator = this.y.iterator();
    float f2 = f3;
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      i0.c localc = localo.a;
      if (localc != null)
      {
        f3 = localo.c;
        if (f3 < f1)
        {
          localObject = localc;
          f2 = f3;
        }
        else if (Float.isNaN(paramFloat))
        {
          paramFloat = localo.c;
        }
      }
    }
    f3 = f1;
    if (localObject != null)
    {
      if (Float.isNaN(paramFloat)) {
        paramFloat = f4;
      }
      paramFloat -= f2;
      double d1 = (f1 - f2) / paramFloat;
      paramFloat = (float)((i0.c)localObject).a(d1) * paramFloat + f2;
      f3 = paramFloat;
      if (paramArrayOfFloat != null)
      {
        paramArrayOfFloat[0] = ((float)((i0.c)localObject).b(d1));
        f3 = paramFloat;
      }
    }
    return f3;
  }
  
  private static Interpolator p(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != -2)
    {
      if (paramInt1 != -1)
      {
        if (paramInt1 != 0)
        {
          if (paramInt1 != 1)
          {
            if (paramInt1 != 2)
            {
              if (paramInt1 != 4)
              {
                if (paramInt1 != 5) {
                  return null;
                }
                return new OvershootInterpolator();
              }
              return new BounceInterpolator();
            }
            return new DecelerateInterpolator();
          }
          return new AccelerateInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
      }
      return new a(i0.c.c(paramString));
    }
    return AnimationUtils.loadInterpolator(paramContext, paramInt2);
  }
  
  private float s()
  {
    float[] arrayOfFloat = new float[2];
    float f6 = 1.0F / 99;
    double d1 = 0.0D;
    double d2 = d1;
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < 100)
    {
      float f7 = i1 * f6;
      double d3 = f7;
      Object localObject1 = this.g.a;
      Iterator localIterator = this.y.iterator();
      float f2 = (0.0F / 0.0F);
      float f4;
      float f5;
      for (float f3 = 0.0F; localIterator.hasNext(); f3 = f5)
      {
        o localo = (o)localIterator.next();
        i0.c localc = localo.a;
        Object localObject2 = localObject1;
        f4 = f2;
        f5 = f3;
        if (localc != null)
        {
          f5 = localo.c;
          if (f5 < f7)
          {
            localObject2 = localc;
            f4 = f2;
          }
          else
          {
            localObject2 = localObject1;
            f4 = f2;
            f5 = f3;
            if (Float.isNaN(f2))
            {
              f4 = localo.c;
              f5 = f3;
              localObject2 = localObject1;
            }
          }
        }
        localObject1 = localObject2;
        f2 = f4;
      }
      if (localObject1 != null)
      {
        f4 = f2;
        if (Float.isNaN(f2)) {
          f4 = 1.0F;
        }
        f2 = f4 - f3;
        d3 = (float)((i0.c)localObject1).a((f7 - f3) / f2) * f2 + f3;
      }
      this.k[0].d(d3, this.s);
      this.g.f(d3, this.r, this.s, arrayOfFloat, 0);
      if (i1 > 0) {
        f1 = (float)(f1 + Math.hypot(d2 - arrayOfFloat[1], d1 - arrayOfFloat[0]));
      }
      d1 = arrayOfFloat[0];
      d2 = arrayOfFloat[1];
      i1 += 1;
    }
    return f1;
  }
  
  private void w(o paramo)
  {
    int i1 = Collections.binarySearch(this.y, paramo);
    if (i1 == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" KeyPath position \"");
      localStringBuilder.append(paramo.d);
      localStringBuilder.append("\" outside of range");
      Log.e("MotionController", localStringBuilder.toString());
    }
    this.y.add(-i1 - 1, paramo);
  }
  
  private void y(o paramo)
  {
    paramo.p((int)this.b.getX(), (int)this.b.getY(), this.b.getWidth(), this.b.getHeight());
  }
  
  void A(Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      int i1;
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return;
          }
          paramInt3 = paramRect1.left + paramRect1.right;
          i1 = paramRect1.bottom;
          paramInt1 = paramRect1.top;
        }
        else
        {
          paramInt1 = paramRect1.left + paramRect1.right;
          paramInt2 = paramRect1.height() / 2 + paramRect1.top - paramInt1 / 2;
          break label160;
        }
      }
      else
      {
        paramInt3 = paramRect1.left + paramRect1.right;
        i1 = paramRect1.top;
        paramInt1 = paramRect1.bottom;
      }
      paramRect2.left = (paramInt2 - (i1 + paramInt1 + paramRect1.width()) / 2);
      paramRect2.top = ((paramInt3 - paramRect1.height()) / 2);
      break label181;
    }
    else
    {
      paramInt1 = paramRect1.left + paramRect1.right;
      paramInt2 = (paramRect1.top + paramRect1.bottom - paramRect1.width()) / 2;
    }
    label160:
    paramRect2.left = paramInt2;
    paramRect2.top = (paramInt3 - (paramInt1 + paramRect1.height()) / 2);
    label181:
    paramRect2.right = (paramRect2.left + paramRect1.width());
    paramRect2.bottom = (paramRect2.top + paramRect1.height());
  }
  
  void B(View paramView)
  {
    o localo = this.g;
    localo.c = 0.0F;
    localo.d = 0.0F;
    this.L = true;
    localo.p(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    this.h.p(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    this.i.j(paramView);
    this.j.j(paramView);
  }
  
  void C(Rect paramRect, androidx.constraintlayout.widget.c paramc, int paramInt1, int paramInt2)
  {
    int i1 = paramc.d;
    Rect localRect = paramRect;
    if (i1 != 0)
    {
      A(paramRect, this.a, i1, paramInt1, paramInt2);
      localRect = this.a;
    }
    paramRect = this.h;
    paramRect.c = 1.0F;
    paramRect.d = 1.0F;
    y(paramRect);
    this.h.p(localRect.left, localRect.top, localRect.width(), localRect.height());
    this.h.a(paramc.z(this.c));
    this.j.i(localRect, paramc, i1, this.c);
  }
  
  public void D(int paramInt)
  {
    this.F = paramInt;
  }
  
  void E(View paramView)
  {
    o localo = this.g;
    localo.c = 0.0F;
    localo.d = 0.0F;
    localo.p(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    this.i.j(paramView);
  }
  
  void F(Rect paramRect, androidx.constraintlayout.widget.c paramc, int paramInt1, int paramInt2)
  {
    int i1 = paramc.d;
    if (i1 != 0) {
      A(paramRect, this.a, i1, paramInt1, paramInt2);
    }
    Object localObject = this.g;
    ((o)localObject).c = 0.0F;
    ((o)localObject).d = 0.0F;
    y((o)localObject);
    this.g.p(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    localObject = paramc.z(this.c);
    this.g.a((c.a)localObject);
    this.m = ((c.a)localObject).d.g;
    this.i.i(paramRect, paramc, i1, this.c);
    this.G = ((c.a)localObject).f.i;
    paramRect = ((c.a)localObject).d;
    this.I = paramRect.k;
    this.J = paramRect.j;
    paramRect = this.b.getContext();
    paramc = ((c.a)localObject).d;
    this.K = p(paramRect, paramc.m, paramc.l, paramc.n);
  }
  
  public void G(n0.e parame, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.g;
    ((o)localObject).c = 0.0F;
    ((o)localObject).d = 0.0F;
    localObject = new Rect();
    int i1;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        break label180;
      }
      paramInt2 = parame.b;
      i1 = parame.d;
      ((Rect)localObject).left = (paramInt3 - (parame.c + parame.e + parame.b()) / 2);
      paramInt2 = (paramInt2 + i1 - parame.a()) / 2;
    }
    else
    {
      paramInt3 = parame.b;
      i1 = parame.d;
      ((Rect)localObject).left = ((parame.c + parame.e - parame.b()) / 2);
      paramInt2 -= (paramInt3 + i1 + parame.a()) / 2;
    }
    ((Rect)localObject).top = paramInt2;
    ((Rect)localObject).right = (((Rect)localObject).left + parame.b());
    ((Rect)localObject).bottom = (((Rect)localObject).top + parame.a());
    label180:
    this.g.p(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height());
    this.i.h((Rect)localObject, paramView, paramInt1, parame.a);
  }
  
  public void H(View paramView)
  {
    this.b = paramView;
    this.c = paramView.getId();
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof ConstraintLayout.LayoutParams)) {
      this.e = ((ConstraintLayout.LayoutParams)paramView).a();
    }
  }
  
  public void I(int paramInt1, int paramInt2, float paramFloat, long paramLong)
  {
    new HashSet();
    Object localObject5 = new HashSet();
    Object localObject3 = new HashSet();
    HashSet localHashSet = new HashSet();
    Object localObject4 = new HashMap();
    int i1 = this.F;
    if (i1 != d.f) {
      this.g.k = i1;
    }
    this.i.f(this.j, (HashSet)localObject3);
    Object localObject1 = this.A;
    if (localObject1 != null)
    {
      localObject6 = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject6).hasNext()) {
          break;
        }
        localObject7 = (d)((Iterator)localObject6).next();
        if ((localObject7 instanceof h))
        {
          localObject2 = (h)localObject7;
          w(new o(paramInt1, paramInt2, (h)localObject2, this.g, this.h));
          i1 = ((i)localObject2).g;
          if (i1 != d.f) {
            this.f = i1;
          }
        }
        else if ((localObject7 instanceof f))
        {
          ((d)localObject7).d(localHashSet);
        }
        else if ((localObject7 instanceof j))
        {
          ((d)localObject7).d((HashSet)localObject5);
        }
        else if ((localObject7 instanceof k))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add((k)localObject7);
          localObject1 = localObject2;
        }
        else
        {
          ((d)localObject7).h((HashMap)localObject4);
          ((d)localObject7).d((HashSet)localObject3);
        }
      }
    }
    Object localObject2 = null;
    if (localObject2 != null) {
      this.E = ((k[])((ArrayList)localObject2).toArray(new k[0]));
    }
    Object localObject8;
    Object localObject9;
    if (!((HashSet)localObject3).isEmpty())
    {
      this.C = new HashMap();
      localObject2 = ((HashSet)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject6 = (String)((Iterator)localObject2).next();
        if (((String)localObject6).startsWith("CUSTOM,"))
        {
          localObject1 = new SparseArray();
          localObject7 = localObject6.split(",")[1];
          localObject8 = this.A.iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (d)((Iterator)localObject8).next();
            Object localObject10 = ((d)localObject9).e;
            if (localObject10 != null) {
              for (;;)
              {
                localObject10 = (androidx.constraintlayout.widget.a)((HashMap)localObject10).get(localObject7);
                if (localObject10 != null) {
                  ((SparseArray)localObject1).append(((d)localObject9).a, localObject10);
                }
              }
            }
          }
          localObject1 = n0.d.f((String)localObject6, (SparseArray)localObject1);
        }
        else
        {
          localObject1 = n0.d.g((String)localObject6);
        }
        if (localObject1 != null)
        {
          ((i0.j)localObject1).d((String)localObject6);
          this.C.put(localObject6, localObject1);
        }
      }
      localObject1 = this.A;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (d)((Iterator)localObject1).next();
          if ((localObject2 instanceof e)) {
            ((d)localObject2).a(this.C);
          }
        }
      }
      this.i.a(this.C, 0);
      this.j.a(this.C, 100);
      localObject1 = this.C.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((HashMap)localObject4).containsKey(localObject2))
        {
          localObject6 = (Integer)((HashMap)localObject4).get(localObject2);
          if (localObject6 != null)
          {
            paramInt1 = ((Integer)localObject6).intValue();
            break label676;
          }
        }
        paramInt1 = 0;
        label676:
        localObject2 = (i0.j)this.C.get(localObject2);
        if (localObject2 != null) {
          ((i0.j)localObject2).e(paramInt1);
        }
      }
    }
    if (!((HashSet)localObject5).isEmpty())
    {
      if (this.B == null) {
        this.B = new HashMap();
      }
      localObject2 = ((HashSet)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (String)((Iterator)localObject2).next();
        if (!this.B.containsKey(localObject5))
        {
          if (((String)localObject5).startsWith("CUSTOM,"))
          {
            localObject1 = new SparseArray();
            localObject6 = localObject5.split(",")[1];
            localObject7 = this.A.iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (d)((Iterator)localObject7).next();
              localObject9 = ((d)localObject8).e;
              if (localObject9 != null)
              {
                localObject9 = (androidx.constraintlayout.widget.a)((HashMap)localObject9).get(localObject6);
                if (localObject9 != null) {
                  ((SparseArray)localObject1).append(((d)localObject8).a, localObject9);
                }
              }
            }
            localObject1 = n0.f.g((String)localObject5, (SparseArray)localObject1);
          }
          else
          {
            localObject1 = n0.f.h((String)localObject5, paramLong);
          }
          if (localObject1 != null)
          {
            ((i0.o)localObject1).d((String)localObject5);
            this.B.put(localObject5, localObject1);
          }
        }
      }
      localObject1 = this.A;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (d)((Iterator)localObject1).next();
          if ((localObject2 instanceof j)) {
            ((j)localObject2).U(this.B);
          }
        }
      }
      localObject1 = this.B.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((HashMap)localObject4).containsKey(localObject2)) {
          paramInt1 = ((Integer)((HashMap)localObject4).get(localObject2)).intValue();
        } else {
          paramInt1 = 0;
        }
        ((n0.f)this.B.get(localObject2)).e(paramInt1);
      }
    }
    int i3 = this.y.size() + 2;
    localObject5 = new o[i3];
    localObject5[0] = this.g;
    localObject5[(i3 - 1)] = this.h;
    if ((this.y.size() > 0) && (this.f == -1)) {
      this.f = 0;
    }
    localObject1 = this.y.iterator();
    paramInt1 = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject5[paramInt1] = ((o)((Iterator)localObject1).next());
      paramInt1 += 1;
    }
    localObject1 = new HashSet();
    localObject2 = this.h.o.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      if (this.g.o.containsKey(localObject4))
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("CUSTOM,");
        ((StringBuilder)localObject6).append((String)localObject4);
        if (!((HashSet)localObject3).contains(((StringBuilder)localObject6).toString())) {
          ((HashSet)localObject1).add(localObject4);
        }
      }
    }
    localObject1 = (String[])((HashSet)localObject1).toArray(new String[0]);
    this.u = ((String[])localObject1);
    this.v = new int[localObject1.length];
    paramInt1 = 0;
    for (;;)
    {
      localObject1 = this.u;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      localObject2 = localObject1[paramInt1];
      this.v[paramInt1] = 0;
      paramInt2 = 0;
      while (paramInt2 < i3)
      {
        if (localObject5[paramInt2].o.containsKey(localObject2))
        {
          localObject1 = (androidx.constraintlayout.widget.a)localObject5[paramInt2].o.get(localObject2);
          if (localObject1 != null)
          {
            localObject2 = this.v;
            localObject2[paramInt1] += ((androidx.constraintlayout.widget.a)localObject1).h();
            break;
          }
        }
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    boolean bool;
    if (localObject5[0].k != d.f) {
      bool = true;
    } else {
      bool = false;
    }
    int i2 = 18 + localObject1.length;
    localObject1 = new boolean[i2];
    paramInt1 = 1;
    while (paramInt1 < i3)
    {
      localObject5[paramInt1].d(localObject5[(paramInt1 - 1)], (boolean[])localObject1, this.u, bool);
      paramInt1 += 1;
    }
    paramInt2 = 0;
    paramInt1 = 1;
    while (paramInt1 < i2)
    {
      i1 = paramInt2;
      if (localObject1[paramInt1] != 0) {
        i1 = paramInt2 + 1;
      }
      paramInt1 += 1;
      paramInt2 = i1;
    }
    this.r = new int[paramInt2];
    paramInt1 = Math.max(2, paramInt2);
    this.s = new double[paramInt1];
    this.t = new double[paramInt1];
    paramInt2 = 0;
    paramInt1 = 1;
    while (paramInt1 < i2)
    {
      i1 = paramInt2;
      if (localObject1[paramInt1] != 0)
      {
        this.r[paramInt2] = paramInt1;
        i1 = paramInt2 + 1;
      }
      paramInt1 += 1;
      paramInt2 = i1;
    }
    Object localObject6 = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, this.r.length });
    Object localObject7 = new double[i3];
    paramInt1 = 0;
    while (paramInt1 < i3)
    {
      localObject5[paramInt1].e(localObject6[paramInt1], this.r);
      localObject7[paramInt1] = localObject5[paramInt1].c;
      paramInt1 += 1;
    }
    paramInt1 = 0;
    for (;;)
    {
      localObject1 = this.r;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      if (localObject1[paramInt1] < o.t.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(o.t[this.r[paramInt1]]);
        ((StringBuilder)localObject1).append(" [");
        localObject1 = ((StringBuilder)localObject1).toString();
        paramInt2 = 0;
        while (paramInt2 < i3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(localObject6[paramInt2][paramInt1]);
          localObject1 = ((StringBuilder)localObject2).toString();
          paramInt2 += 1;
        }
      }
      paramInt1 += 1;
    }
    this.k = new b[this.u.length + 1];
    paramInt1 = 0;
    for (;;)
    {
      localObject1 = this.u;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      localObject8 = localObject1[paramInt1];
      paramInt2 = 0;
      i1 = paramInt2;
      localObject2 = null;
      for (localObject1 = null; paramInt2 < i3; localObject1 = localObject3)
      {
        localObject4 = localObject2;
        i2 = i1;
        localObject3 = localObject1;
        if (localObject5[paramInt2].k((String)localObject8))
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new double[i3];
            localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, localObject5[paramInt2].i((String)localObject8) });
          }
          localObject2[i1] = localObject5[paramInt2].c;
          localObject5[paramInt2].h((String)localObject8, localObject3[i1], 0);
          i2 = i1 + 1;
          localObject4 = localObject2;
        }
        paramInt2 += 1;
        localObject2 = localObject4;
        i1 = i2;
      }
      localObject2 = Arrays.copyOf((double[])localObject2, i1);
      localObject1 = (double[][])Arrays.copyOf((Object[])localObject1, i1);
      localObject3 = this.k;
      paramInt1 += 1;
      localObject3[paramInt1] = b.a(this.f, (double[])localObject2, (double[][])localObject1);
    }
    this.k[0] = b.a(this.f, (double[])localObject7, (double[][])localObject6);
    if (localObject5[0].k != d.f)
    {
      localObject1 = new int[i3];
      localObject2 = new double[i3];
      localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, 2 });
      paramInt1 = 0;
      while (paramInt1 < i3)
      {
        localObject1[paramInt1] = localObject5[paramInt1].k;
        localObject2[paramInt1] = localObject5[paramInt1].c;
        localObject3[paramInt1][0] = localObject5[paramInt1].e;
        localObject3[paramInt1][1] = localObject5[paramInt1].f;
        paramInt1 += 1;
      }
      this.l = b.b((int[])localObject1, (double[])localObject2, (double[][])localObject3);
    }
    paramFloat = (0.0F / 0.0F);
    this.D = new HashMap();
    if (this.A != null)
    {
      localObject1 = localHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = n0.c.i((String)localObject2);
        if (localObject3 != null)
        {
          float f1 = paramFloat;
          if (((i0.e)localObject3).h())
          {
            f1 = paramFloat;
            if (Float.isNaN(paramFloat)) {
              f1 = s();
            }
          }
          ((i0.e)localObject3).f((String)localObject2);
          this.D.put(localObject2, localObject3);
          paramFloat = f1;
        }
      }
      localObject1 = this.A.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if ((localObject2 instanceof f)) {
          ((f)localObject2).Y(this.D);
        }
      }
      localObject1 = this.D.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((n0.c)((Iterator)localObject1).next()).g(paramFloat);
      }
    }
  }
  
  public void J(m paramm)
  {
    this.g.s(paramm, paramm.g);
    this.h.s(paramm, paramm.h);
  }
  
  public void a(d paramd)
  {
    this.A.add(paramd);
  }
  
  void b(ArrayList<d> paramArrayList)
  {
    this.A.addAll(paramArrayList);
  }
  
  int c(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    if (paramArrayOfFloat != null)
    {
      double[] arrayOfDouble = this.k[0].h();
      if (paramArrayOfInt != null)
      {
        Iterator localIterator = this.y.iterator();
        i1 = 0;
        while (localIterator.hasNext())
        {
          paramArrayOfInt[i1] = ((o)localIterator.next()).p;
          i1 += 1;
        }
      }
      int i1 = 0;
      int i2 = i1;
      while (i1 < arrayOfDouble.length)
      {
        this.k[0].d(arrayOfDouble[i1], this.s);
        this.g.f(arrayOfDouble[i1], this.r, this.s, paramArrayOfFloat, i2);
        i2 += 2;
        i1 += 1;
      }
      return i2 / 2;
    }
    return 0;
  }
  
  void d(float[] paramArrayOfFloat, int paramInt)
  {
    float f6 = 1.0F / (paramInt - 1);
    Object localObject1 = this.C;
    n0.c localc = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (i0.j)((HashMap)localObject1).get("translationX");
    }
    Object localObject2 = this.C;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (i0.j)((HashMap)localObject2).get("translationY");
    }
    Object localObject3 = this.D;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = (n0.c)((HashMap)localObject3).get("translationX");
    }
    Object localObject4 = this.D;
    if (localObject4 != null) {
      localc = (n0.c)((HashMap)localObject4).get("translationY");
    }
    int i1 = 0;
    while (i1 < paramInt)
    {
      float f3 = i1 * f6;
      float f4 = this.o;
      float f1 = f3;
      float f5;
      if (f4 != 1.0F)
      {
        f5 = this.n;
        f2 = f3;
        if (f3 < f5) {
          f2 = 0.0F;
        }
        f1 = f2;
        if (f2 > f5)
        {
          f1 = f2;
          if (f2 < 1.0D) {
            f1 = Math.min((f2 - f5) * f4, 1.0F);
          }
        }
      }
      double d1 = f1;
      localObject4 = this.g.a;
      float f2 = (0.0F / 0.0F);
      Iterator localIterator = this.y.iterator();
      for (f3 = 0.0F; localIterator.hasNext(); f3 = f5)
      {
        o localo = (o)localIterator.next();
        localObject6 = localo.a;
        localObject5 = localObject4;
        f4 = f2;
        f5 = f3;
        if (localObject6 != null)
        {
          f5 = localo.c;
          if (f5 < f1)
          {
            localObject5 = localObject6;
            f4 = f2;
          }
          else
          {
            localObject5 = localObject4;
            f4 = f2;
            f5 = f3;
            if (Float.isNaN(f2))
            {
              f4 = localo.c;
              f5 = f3;
              localObject5 = localObject4;
            }
          }
        }
        localObject4 = localObject5;
        f2 = f4;
      }
      if (localObject4 != null)
      {
        f4 = f2;
        if (Float.isNaN(f2)) {
          f4 = 1.0F;
        }
        f2 = f4 - f3;
        d1 = (float)((i0.c)localObject4).a((f1 - f3) / f2) * f2 + f3;
      }
      this.k[0].d(d1, this.s);
      localObject4 = this.l;
      if (localObject4 != null)
      {
        localObject5 = this.s;
        if (localObject5.length > 0) {
          ((b)localObject4).d(d1, (double[])localObject5);
        }
      }
      localObject4 = this.g;
      Object localObject5 = this.r;
      Object localObject6 = this.s;
      int i2 = i1 * 2;
      ((o)localObject4).f(d1, (int[])localObject5, (double[])localObject6, paramArrayOfFloat, i2);
      if (localObject3 != null) {
        paramArrayOfFloat[i2] += ((i0.e)localObject3).a(f1);
      } else if (localObject1 != null) {
        paramArrayOfFloat[i2] += ((i0.j)localObject1).a(f1);
      }
      if (localc != null)
      {
        i2 += 1;
        paramArrayOfFloat[i2] += localc.a(f1);
      }
      else if (localObject2 != null)
      {
        i2 += 1;
        paramArrayOfFloat[i2] += ((i0.j)localObject2).a(f1);
      }
      i1 += 1;
    }
  }
  
  void e(float paramFloat, float[] paramArrayOfFloat, int paramInt)
  {
    paramFloat = g(paramFloat, null);
    this.k[0].d(paramFloat, this.s);
    this.g.j(this.r, this.s, paramArrayOfFloat, paramInt);
  }
  
  void f(boolean paramBoolean)
  {
    if (("button".equals(a.d(this.b))) && (this.E != null))
    {
      int i1 = 0;
      for (;;)
      {
        Object localObject = this.E;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        float f1;
        if (paramBoolean) {
          f1 = -100.0F;
        } else {
          f1 = 100.0F;
        }
        ((k)localObject).y(f1, this.b);
        i1 += 1;
      }
    }
  }
  
  public int h()
  {
    return this.g.l;
  }
  
  public void i(double paramDouble, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    double[] arrayOfDouble1 = new double[4];
    double[] arrayOfDouble2 = new double[4];
    this.k[0].d(paramDouble, arrayOfDouble1);
    this.k[0].g(paramDouble, arrayOfDouble2);
    Arrays.fill(paramArrayOfFloat2, 0.0F);
    this.g.g(paramDouble, this.r, arrayOfDouble1, paramArrayOfFloat1, arrayOfDouble2, paramArrayOfFloat2);
  }
  
  public float j()
  {
    return this.p;
  }
  
  public float k()
  {
    return this.q;
  }
  
  void l(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    paramFloat1 = g(paramFloat1, this.z);
    Object localObject1 = this.k;
    int i1 = 0;
    if (localObject1 != null)
    {
      localObject1 = localObject1[0];
      double d1 = paramFloat1;
      ((b)localObject1).g(d1, this.t);
      this.k[0].d(d1, this.s);
      paramFloat1 = this.z[0];
      for (;;)
      {
        localObject2 = this.t;
        if (i1 >= localObject2.length) {
          break;
        }
        localObject2[i1] *= paramFloat1;
        i1 += 1;
      }
      localObject1 = this.l;
      if (localObject1 != null)
      {
        localObject2 = this.s;
        if (localObject2.length > 0)
        {
          ((b)localObject1).d(d1, (double[])localObject2);
          this.l.g(d1, this.t);
          this.g.q(paramFloat2, paramFloat3, paramArrayOfFloat, this.r, this.t, this.s);
        }
        return;
      }
      this.g.q(paramFloat2, paramFloat3, paramArrayOfFloat, this.r, (double[])localObject2, this.s);
      return;
    }
    localObject1 = this.h;
    paramFloat1 = ((o)localObject1).e;
    Object localObject2 = this.g;
    paramFloat1 -= ((o)localObject2).e;
    float f1 = ((o)localObject1).f - ((o)localObject2).f;
    float f2 = ((o)localObject1).g;
    float f3 = ((o)localObject2).g;
    float f4 = ((o)localObject1).h;
    float f5 = ((o)localObject2).h;
    paramArrayOfFloat[0] = (paramFloat1 * (1.0F - paramFloat2) + (f2 - f3 + paramFloat1) * paramFloat2);
    paramArrayOfFloat[1] = (f1 * (1.0F - paramFloat3) + (f4 - f5 + f1) * paramFloat3);
  }
  
  public int m()
  {
    int i1 = this.g.b;
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext()) {
      i1 = Math.max(i1, ((o)localIterator.next()).b);
    }
    return Math.max(i1, this.h.b);
  }
  
  public float n()
  {
    return this.h.e;
  }
  
  public float o()
  {
    return this.h.f;
  }
  
  o q(int paramInt)
  {
    return (o)this.y.get(paramInt);
  }
  
  void r(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    paramFloat1 = g(paramFloat1, this.z);
    Object localObject1 = this.C;
    n0.c localc = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (i0.j)((HashMap)localObject1).get("translationX");
    }
    Object localObject2 = this.C;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (i0.j)((HashMap)localObject2).get("translationY");
    }
    Object localObject3 = this.C;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = (i0.j)((HashMap)localObject3).get("rotation");
    }
    Object localObject4 = this.C;
    if (localObject4 == null) {
      localObject4 = null;
    } else {
      localObject4 = (i0.j)((HashMap)localObject4).get("scaleX");
    }
    Object localObject5 = this.C;
    if (localObject5 == null) {
      localObject5 = null;
    } else {
      localObject5 = (i0.j)((HashMap)localObject5).get("scaleY");
    }
    Object localObject6 = this.D;
    if (localObject6 == null) {
      localObject6 = null;
    } else {
      localObject6 = (n0.c)((HashMap)localObject6).get("translationX");
    }
    Object localObject7 = this.D;
    if (localObject7 == null) {
      localObject7 = null;
    } else {
      localObject7 = (n0.c)((HashMap)localObject7).get("translationY");
    }
    Object localObject8 = this.D;
    if (localObject8 == null) {
      localObject8 = null;
    } else {
      localObject8 = (n0.c)((HashMap)localObject8).get("rotation");
    }
    Object localObject9 = this.D;
    if (localObject9 == null) {
      localObject9 = null;
    } else {
      localObject9 = (n0.c)((HashMap)localObject9).get("scaleX");
    }
    Object localObject10 = this.D;
    if (localObject10 != null) {
      localc = (n0.c)((HashMap)localObject10).get("scaleY");
    }
    localObject10 = new p();
    ((p)localObject10).b();
    ((p)localObject10).d((i0.j)localObject3, paramFloat1);
    ((p)localObject10).h((i0.j)localObject1, (i0.j)localObject2, paramFloat1);
    ((p)localObject10).f((i0.j)localObject4, (i0.j)localObject5, paramFloat1);
    ((p)localObject10).c((i0.e)localObject8, paramFloat1);
    ((p)localObject10).g((i0.e)localObject6, (i0.e)localObject7, paramFloat1);
    ((p)localObject10).e((i0.e)localObject9, localc, paramFloat1);
    Object localObject11 = this.l;
    double d1;
    if (localObject11 != null)
    {
      localObject1 = this.s;
      if (localObject1.length > 0)
      {
        d1 = paramFloat1;
        ((b)localObject11).d(d1, (double[])localObject1);
        this.l.g(d1, this.t);
        this.g.q(paramFloat2, paramFloat3, paramArrayOfFloat, this.r, this.t, this.s);
      }
      ((p)localObject10).a(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
      return;
    }
    localObject11 = this.k;
    int i1 = 0;
    if (localObject11 != null)
    {
      paramFloat1 = g(paramFloat1, this.z);
      localObject1 = this.k[0];
      d1 = paramFloat1;
      ((b)localObject1).g(d1, this.t);
      this.k[0].d(d1, this.s);
      paramFloat1 = this.z[0];
      for (;;)
      {
        localObject1 = this.t;
        if (i1 >= localObject1.length) {
          break;
        }
        localObject1[i1] *= paramFloat1;
        i1 += 1;
      }
      this.g.q(paramFloat2, paramFloat3, paramArrayOfFloat, this.r, (double[])localObject1, this.s);
      ((p)localObject10).a(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
      return;
    }
    localObject11 = this.h;
    float f1 = ((o)localObject11).e;
    o localo = this.g;
    f1 -= localo.e;
    float f2 = ((o)localObject11).f - localo.f;
    float f3 = ((o)localObject11).g;
    float f4 = localo.g;
    float f5 = ((o)localObject11).h;
    float f6 = localo.h;
    paramArrayOfFloat[0] = (f1 * (1.0F - paramFloat2) + (f3 - f4 + f1) * paramFloat2);
    paramArrayOfFloat[1] = (f2 * (1.0F - paramFloat3) + (f5 - f6 + f2) * paramFloat3);
    ((p)localObject10).b();
    ((p)localObject10).d((i0.j)localObject3, paramFloat1);
    ((p)localObject10).h((i0.j)localObject1, (i0.j)localObject2, paramFloat1);
    ((p)localObject10).f((i0.j)localObject4, (i0.j)localObject5, paramFloat1);
    ((p)localObject10).c((i0.e)localObject8, paramFloat1);
    ((p)localObject10).g((i0.e)localObject6, (i0.e)localObject7, paramFloat1);
    ((p)localObject10).e((i0.e)localObject9, localc, paramFloat1);
    ((p)localObject10).a(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public float t()
  {
    return this.g.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" start: x: ");
    localStringBuilder.append(this.g.e);
    localStringBuilder.append(" y: ");
    localStringBuilder.append(this.g.f);
    localStringBuilder.append(" end: x: ");
    localStringBuilder.append(this.h.e);
    localStringBuilder.append(" y: ");
    localStringBuilder.append(this.h.f);
    return localStringBuilder.toString();
  }
  
  public float u()
  {
    return this.g.f;
  }
  
  public View v()
  {
    return this.b;
  }
  
  boolean x(View paramView, float paramFloat, long paramLong, i0.d paramd)
  {
    float f1 = g(paramFloat, null);
    int i1 = this.I;
    paramFloat = f1;
    float f2;
    float f3;
    if (i1 != d.f)
    {
      f2 = 1.0F / i1;
      f3 = (float)Math.floor(f1 / f2);
      f1 = f1 % f2 / f2;
      paramFloat = f1;
      if (!Float.isNaN(this.J)) {
        paramFloat = (f1 + this.J) % 1.0F;
      }
      localObject1 = this.K;
      if (localObject1 != null) {
        paramFloat = ((Interpolator)localObject1).getInterpolation(paramFloat);
      } else if (paramFloat > 0.5D) {
        paramFloat = 1.0F;
      } else {
        paramFloat = 0.0F;
      }
      paramFloat = paramFloat * f2 + f3 * f2;
    }
    Object localObject1 = this.C;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((n0.d)((Iterator)localObject1).next()).h(paramView, paramFloat);
      }
    }
    localObject1 = this.B;
    boolean bool1;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((HashMap)localObject1).values().iterator();
      localObject1 = null;
      bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (n0.f)((Iterator)localObject2).next();
        if ((localObject3 instanceof f.d)) {
          localObject1 = (f.d)localObject3;
        } else {
          bool1 |= ((n0.f)localObject3).i(paramView, paramFloat, paramLong, paramd);
        }
      }
    }
    else
    {
      localObject1 = null;
      bool1 = false;
    }
    Object localObject2 = this.k;
    float f4;
    label808:
    boolean bool2;
    if (localObject2 != null)
    {
      localObject2 = localObject2[0];
      double d1 = paramFloat;
      ((b)localObject2).d(d1, this.s);
      this.k[0].g(d1, this.t);
      localObject2 = this.l;
      if (localObject2 != null)
      {
        localObject3 = this.s;
        if (localObject3.length > 0)
        {
          ((b)localObject2).d(d1, (double[])localObject3);
          this.l.g(d1, this.t);
        }
      }
      if (!this.L)
      {
        this.g.r(paramFloat, paramView, this.r, this.s, this.t, null, this.d);
        this.d = false;
      }
      if (this.G != d.f)
      {
        if (this.H == null) {
          this.H = ((View)paramView.getParent()).findViewById(this.G);
        }
        localObject2 = this.H;
        if (localObject2 != null)
        {
          f1 = (((View)localObject2).getTop() + this.H.getBottom()) / 2.0F;
          f2 = (this.H.getLeft() + this.H.getRight()) / 2.0F;
          if ((paramView.getRight() - paramView.getLeft() > 0) && (paramView.getBottom() - paramView.getTop() > 0))
          {
            f3 = paramView.getLeft();
            f4 = paramView.getTop();
            paramView.setPivotX(f2 - f3);
            paramView.setPivotY(f1 - f4);
          }
        }
      }
      localObject2 = this.C;
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (i0.j)((Iterator)localObject2).next();
          if ((localObject3 instanceof d.d))
          {
            double[] arrayOfDouble = this.t;
            if (arrayOfDouble.length > 1) {
              ((d.d)localObject3).i(paramView, paramFloat, arrayOfDouble[0], arrayOfDouble[1]);
            }
          }
        }
      }
      if (localObject1 != null)
      {
        localObject2 = this.t;
        bool1 |= ((f.d)localObject1).j(paramView, paramd, paramFloat, paramLong, localObject2[0], localObject2[1]);
      }
      i1 = 1;
      for (;;)
      {
        paramd = this.k;
        if (i1 >= paramd.length) {
          break;
        }
        paramd[i1].e(d1, this.x);
        n0.a.b((androidx.constraintlayout.widget.a)this.g.o.get(this.u[(i1 - 1)]), paramView, this.x);
        i1 += 1;
      }
      paramd = this.i;
      if (paramd.b == 0)
      {
        if (paramFloat <= 0.0F) {}
        for (;;)
        {
          paramView.setVisibility(paramd.c);
          break label808;
          if (paramFloat < 1.0F) {
            break;
          }
          paramd = this.j;
        }
        if (this.j.c != paramd.c) {
          paramView.setVisibility(0);
        }
      }
      bool2 = bool1;
      if (this.E != null)
      {
        i1 = 0;
        for (;;)
        {
          paramd = this.E;
          bool2 = bool1;
          if (i1 >= paramd.length) {
            break;
          }
          paramd[i1].y(paramFloat, paramView);
          i1 += 1;
        }
      }
    }
    else
    {
      paramd = this.g;
      float f7 = paramd.e;
      localObject1 = this.h;
      float f8 = ((o)localObject1).e;
      float f5 = paramd.f;
      float f6 = ((o)localObject1).f;
      f1 = paramd.g;
      f2 = ((o)localObject1).g;
      f3 = paramd.h;
      f4 = ((o)localObject1).h;
      f7 = f7 + (f8 - f7) * paramFloat + 0.5F;
      i1 = (int)f7;
      f5 = f5 + (f6 - f5) * paramFloat + 0.5F;
      int i2 = (int)f5;
      int i3 = (int)(f7 + ((f2 - f1) * paramFloat + f1));
      int i4 = (int)(f5 + ((f4 - f3) * paramFloat + f3));
      if ((f2 != f1) || (f4 != f3) || (this.d))
      {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(i3 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        this.d = false;
      }
      paramView.layout(i1, i2, i3, i4);
      bool2 = bool1;
    }
    paramd = this.D;
    if (paramd != null)
    {
      paramd = paramd.values().iterator();
      while (paramd.hasNext())
      {
        localObject1 = (n0.c)paramd.next();
        if ((localObject1 instanceof c.d))
        {
          localObject1 = (c.d)localObject1;
          localObject2 = this.t;
          ((c.d)localObject1).k(paramView, paramFloat, localObject2[0], localObject2[1]);
        }
        else
        {
          ((n0.c)localObject1).j(paramView, paramFloat);
        }
      }
    }
    return bool2;
  }
  
  public void z()
  {
    this.d = true;
  }
  
  class a
    implements Interpolator
  {
    a() {}
    
    public float getInterpolation(float paramFloat)
    {
      return (float)m.this.a(paramFloat);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.m
 * JD-Core Version:    0.7.0.1
 */