package c1;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.x;
import java.util.Arrays;

public class c
{
  private static final Interpolator x = new a();
  private int a;
  private int b;
  private int c = -1;
  private float[] d;
  private float[] e;
  private float[] f;
  private float[] g;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private VelocityTracker l;
  private float m;
  private float n;
  private int o;
  private final int p;
  private int q;
  private OverScroller r;
  private final c s;
  private View t;
  private boolean u;
  private final ViewGroup v;
  private final Runnable w = new b();
  
  private c(Context paramContext, ViewGroup paramViewGroup, c paramc)
  {
    if (paramViewGroup != null)
    {
      if (paramc != null)
      {
        this.v = paramViewGroup;
        this.s = paramc;
        paramViewGroup = ViewConfiguration.get(paramContext);
        int i1 = (int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F);
        this.p = i1;
        this.o = i1;
        this.b = paramViewGroup.getScaledTouchSlop();
        this.m = paramViewGroup.getScaledMaximumFlingVelocity();
        this.n = paramViewGroup.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(paramContext, x);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private boolean E(int paramInt)
  {
    if (!D(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring pointerId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      Log.e("ViewDragHelper", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private void H()
  {
    this.l.computeCurrentVelocity(1000, this.m);
    q(h(this.l.getXVelocity(this.c), this.n, this.m), h(this.l.getYVelocity(this.c), this.n, this.m));
  }
  
  private void I(float paramFloat1, float paramFloat2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void J(float paramFloat1, float paramFloat2, int paramInt)
  {
    t(paramInt);
    float[] arrayOfFloat = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.h[paramInt] = z((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }
  
  private void K(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getPointerCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramMotionEvent.getPointerId(i1);
      if (E(i3))
      {
        float f1 = paramMotionEvent.getX(i1);
        float f2 = paramMotionEvent.getY(i1);
        this.f[i3] = f1;
        this.g[i3] = f2;
      }
      i1 += 1;
    }
  }
  
  private boolean d(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i1 = this.h[paramInt1];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i1 & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.q & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.j[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.i[paramInt1] & paramInt2) != paramInt2)
          {
            i1 = this.b;
            if ((paramFloat1 <= i1) && (paramFloat2 <= i1)) {
              return false;
            }
            if ((paramFloat1 < paramFloat2 * 0.5F) && (this.s.g(paramInt2)))
            {
              int[] arrayOfInt = this.j;
              arrayOfInt[paramInt1] |= paramInt2;
              return false;
            }
            bool1 = bool2;
            if ((this.i[paramInt1] & paramInt2) == 0)
            {
              bool1 = bool2;
              if (paramFloat1 > this.b) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean g(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramView == null) {
      return false;
    }
    int i1;
    if (this.s.d(paramView) > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (this.s.e(paramView) > 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0))
    {
      i1 = this.b;
      if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > i1 * i1) {
        bool1 = true;
      }
      return bool1;
    }
    if (i1 != 0)
    {
      bool1 = bool3;
      if (Math.abs(paramFloat1) > this.b) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (i2 != 0)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat2) > this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private float h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      return 0.0F;
    }
    if (f1 > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      return -paramFloat3;
    }
    return paramFloat1;
  }
  
  private int i(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      return 0;
    }
    if (i1 > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      return -paramInt3;
    }
    return paramInt1;
  }
  
  private void j()
  {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }
  
  private void k(int paramInt)
  {
    if (this.d != null)
    {
      if (!D(paramInt)) {
        return;
      }
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.g[paramInt] = 0.0F;
      this.h[paramInt] = 0;
      this.i[paramInt] = 0;
      this.j[paramInt] = 0;
      this.k = (1 << paramInt & this.k);
    }
  }
  
  private int l(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = this.v.getWidth();
    int i2 = i1 / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f1 = i2;
    f2 = r(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  private int m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = i(paramInt3, (int)this.n, (int)this.m);
    paramInt4 = i(paramInt4, (int)this.n, (int)this.m);
    int i1 = Math.abs(paramInt1);
    int i2 = Math.abs(paramInt2);
    int i3 = Math.abs(paramInt3);
    int i4 = Math.abs(paramInt4);
    int i5 = i3 + i4;
    int i6 = i1 + i2;
    float f1;
    float f2;
    if (paramInt3 != 0)
    {
      f1 = i3;
      f2 = i5;
    }
    else
    {
      f1 = i1;
      f2 = i6;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = i4;
      f2 = i5;
    }
    else
    {
      f1 = i2;
      f2 = i6;
    }
    f1 /= f2;
    paramInt1 = l(paramInt1, paramInt3, this.s.d(paramView));
    paramInt2 = l(paramInt2, paramInt4, this.s.e(paramView));
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  public static c o(ViewGroup paramViewGroup, float paramFloat, c paramc)
  {
    paramViewGroup = p(paramViewGroup, paramc);
    paramViewGroup.b = ((int)(paramViewGroup.b * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static c p(ViewGroup paramViewGroup, c paramc)
  {
    return new c(paramViewGroup.getContext(), paramViewGroup, paramc);
  }
  
  private void q(float paramFloat1, float paramFloat2)
  {
    this.u = true;
    this.s.l(this.t, paramFloat1, paramFloat2);
    this.u = false;
    if (this.a == 1) {
      L(0);
    }
  }
  
  private float r(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = this.t.getLeft();
    int i3 = this.t.getTop();
    int i1 = paramInt1;
    if (paramInt3 != 0)
    {
      i1 = this.s.a(this.t, paramInt1, paramInt3);
      x.a0(this.t, i1 - i2);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.s.b(this.t, paramInt2, paramInt4);
      x.b0(this.t, paramInt1 - i3);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.s.k(this.t, i1, paramInt1, i1 - i2, paramInt1 - i3);
    }
  }
  
  private void t(int paramInt)
  {
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      paramInt += 1;
      float[] arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      float[] arrayOfFloat4 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, arrayOfFloat1, 0, localObject.length);
        localObject = this.e;
        System.arraycopy(localObject, 0, arrayOfFloat2, 0, localObject.length);
        localObject = this.f;
        System.arraycopy(localObject, 0, arrayOfFloat3, 0, localObject.length);
        localObject = this.g;
        System.arraycopy(localObject, 0, arrayOfFloat4, 0, localObject.length);
        localObject = this.h;
        System.arraycopy(localObject, 0, arrayOfInt1, 0, localObject.length);
        localObject = this.i;
        System.arraycopy(localObject, 0, arrayOfInt2, 0, localObject.length);
        localObject = this.j;
        System.arraycopy(localObject, 0, arrayOfInt3, 0, localObject.length);
      }
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    }
  }
  
  private boolean v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.t.getLeft();
    int i2 = this.t.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.r.abortAnimation();
      L(0);
      return false;
    }
    paramInt3 = m(this.t, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r.startScroll(i1, i2, paramInt1, paramInt2, paramInt3);
    L(2);
    return true;
  }
  
  private int z(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.v.getLeft() + this.o) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = i2;
    if (paramInt2 < this.v.getTop() + this.o) {
      i1 = i2 | 0x4;
    }
    int i2 = i1;
    if (paramInt1 > this.v.getRight() - this.o) {
      i2 = i1 | 0x2;
    }
    paramInt1 = i2;
    if (paramInt2 > this.v.getBottom() - this.o) {
      paramInt1 = i2 | 0x8;
    }
    return paramInt1;
  }
  
  public int A()
  {
    return this.b;
  }
  
  public int B()
  {
    return this.a;
  }
  
  public boolean C(int paramInt1, int paramInt2)
  {
    return F(this.t, paramInt1, paramInt2);
  }
  
  public boolean D(int paramInt)
  {
    return (1 << paramInt & this.k) != 0;
  }
  
  public boolean F(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt1 >= paramView.getLeft())
    {
      bool1 = bool2;
      if (paramInt1 < paramView.getRight())
      {
        bool1 = bool2;
        if (paramInt2 >= paramView.getTop())
        {
          bool1 = bool2;
          if (paramInt2 < paramView.getBottom()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void G(MotionEvent paramMotionEvent)
  {
    int i4 = paramMotionEvent.getActionMasked();
    int i3 = paramMotionEvent.getActionIndex();
    if (i4 == 0) {
      b();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    int i2 = 0;
    int i1 = 0;
    float f1;
    float f2;
    if (i4 != 0)
    {
      if (i4 != 1)
      {
        Object localObject;
        if (i4 != 2)
        {
          if (i4 != 3)
          {
            if (i4 != 5)
            {
              if (i4 != 6) {
                return;
              }
              i2 = paramMotionEvent.getPointerId(i3);
              if ((this.a == 1) && (i2 == this.c))
              {
                i3 = paramMotionEvent.getPointerCount();
                while (i1 < i3)
                {
                  i4 = paramMotionEvent.getPointerId(i1);
                  if (i4 != this.c)
                  {
                    f1 = paramMotionEvent.getX(i1);
                    f2 = paramMotionEvent.getY(i1);
                    localObject = u((int)f1, (int)f2);
                    View localView = this.t;
                    if ((localObject == localView) && (S(localView, i4)))
                    {
                      i1 = this.c;
                      break label213;
                    }
                  }
                  i1 += 1;
                }
                i1 = -1;
                label213:
                if (i1 == -1) {
                  H();
                }
              }
              k(i2);
              return;
            }
            i1 = paramMotionEvent.getPointerId(i3);
            f1 = paramMotionEvent.getX(i3);
            f2 = paramMotionEvent.getY(i3);
            J(f1, f2, i1);
            if (this.a == 0)
            {
              S(u((int)f1, (int)f2), i1);
              i2 = this.h[i1];
              i3 = this.q;
              if ((i2 & i3) == 0) {
                return;
              }
              this.s.h(i2 & i3, i1);
              return;
            }
            if (!C((int)f1, (int)f2)) {
              return;
            }
            S(this.t, i1);
            return;
          }
          if (this.a == 1) {
            q(0.0F, 0.0F);
          }
        }
        else
        {
          if (this.a == 1)
          {
            if (!E(this.c)) {
              return;
            }
            i1 = paramMotionEvent.findPointerIndex(this.c);
            f1 = paramMotionEvent.getX(i1);
            f2 = paramMotionEvent.getY(i1);
            localObject = this.f;
            i2 = this.c;
            i1 = (int)(f1 - localObject[i2]);
            i2 = (int)(f2 - this.g[i2]);
            s(this.t.getLeft() + i1, this.t.getTop() + i2, i1, i2);
          }
          label610:
          for (;;)
          {
            K(paramMotionEvent);
            return;
            i3 = paramMotionEvent.getPointerCount();
            i1 = i2;
            for (;;)
            {
              if (i1 >= i3) {
                break label610;
              }
              i2 = paramMotionEvent.getPointerId(i1);
              if (E(i2))
              {
                f1 = paramMotionEvent.getX(i1);
                f2 = paramMotionEvent.getY(i1);
                float f3 = f1 - this.d[i2];
                float f4 = f2 - this.e[i2];
                I(f3, f4, i2);
                if (this.a == 1) {
                  break;
                }
                localObject = u((int)f1, (int)f2);
                if ((g((View)localObject, f3, f4)) && (S((View)localObject, i2))) {
                  break;
                }
              }
              i1 += 1;
            }
          }
        }
      }
      else if (this.a == 1)
      {
        H();
      }
      b();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = paramMotionEvent.getPointerId(0);
      paramMotionEvent = u((int)f1, (int)f2);
      J(f1, f2, i1);
      S(paramMotionEvent, i1);
      i2 = this.h[i1];
      i3 = this.q;
      if ((i2 & i3) != 0) {
        this.s.h(i2 & i3, i1);
      }
    }
  }
  
  void L(int paramInt)
  {
    this.v.removeCallbacks(this.w);
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.s.j(paramInt);
      if (this.a == 0) {
        this.t = null;
      }
    }
  }
  
  public void M(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void N(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void O(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public boolean P(int paramInt1, int paramInt2)
  {
    if (this.u) {
      return v(paramInt1, paramInt2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean Q(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0) {
      b();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    float f1;
    float f2;
    int i3;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 == 3) {
            break label517;
          }
          if (i1 != 5) {
            if (i1 != 6) {
              break label619;
            }
          }
        }
      }
      for (;;)
      {
        k(paramMotionEvent.getPointerId(i2));
        continue;
        i1 = paramMotionEvent.getPointerId(i2);
        f1 = paramMotionEvent.getX(i2);
        f2 = paramMotionEvent.getY(i2);
        J(f1, f2, i1);
        i2 = this.a;
        if (i2 == 0)
        {
          i2 = this.h[i1];
          i3 = this.q;
          if ((i2 & i3) != 0) {
            this.s.h(i2 & i3, i1);
          }
        }
        else if (i2 == 2)
        {
          paramMotionEvent = u((int)f1, (int)f2);
          if (paramMotionEvent == this.t)
          {
            S(paramMotionEvent, i1);
            continue;
            if ((this.d != null) && (this.e != null))
            {
              i3 = paramMotionEvent.getPointerCount();
              i1 = 0;
              while (i1 < i3)
              {
                int i4 = paramMotionEvent.getPointerId(i1);
                if (E(i4))
                {
                  f1 = paramMotionEvent.getX(i1);
                  f2 = paramMotionEvent.getY(i1);
                  float f3 = f1 - this.d[i4];
                  float f4 = f2 - this.e[i4];
                  View localView = u((int)f1, (int)f2);
                  if ((localView != null) && (g(localView, f3, f4))) {
                    i2 = 1;
                  } else {
                    i2 = 0;
                  }
                  if (i2 != 0)
                  {
                    int i5 = localView.getLeft();
                    int i6 = (int)f3;
                    i6 = this.s.a(localView, i5 + i6, i6);
                    int i7 = localView.getTop();
                    int i8 = (int)f4;
                    i8 = this.s.b(localView, i7 + i8, i8);
                    int i9 = this.s.d(localView);
                    int i10 = this.s.e(localView);
                    if (((i9 == 0) || ((i9 > 0) && (i6 == i5))) && ((i10 == 0) || ((i10 > 0) && (i8 == i7)))) {
                      break;
                    }
                  }
                  else
                  {
                    I(f3, f4, i4);
                    if ((this.a == 1) || ((i2 != 0) && (S(localView, i4)))) {
                      break;
                    }
                  }
                }
                i1 += 1;
              }
              K(paramMotionEvent);
              continue;
              label517:
              b();
            }
          }
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = paramMotionEvent.getPointerId(0);
      J(f1, f2, i1);
      paramMotionEvent = u((int)f1, (int)f2);
      if ((paramMotionEvent == this.t) && (this.a == 2)) {
        S(paramMotionEvent, i1);
      }
      i2 = this.h[i1];
      i3 = this.q;
      if ((i2 & i3) != 0) {
        this.s.h(i2 & i3, i1);
      }
    }
    label619:
    boolean bool = false;
    if (this.a == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean R(View paramView, int paramInt1, int paramInt2)
  {
    this.t = paramView;
    this.c = -1;
    boolean bool = v(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.a == 0) && (this.t != null)) {
      this.t = null;
    }
    return bool;
  }
  
  boolean S(View paramView, int paramInt)
  {
    if ((paramView == this.t) && (this.c == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.s.m(paramView, paramInt)))
    {
      this.c = paramInt;
      c(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    b();
    if (this.a == 2)
    {
      int i1 = this.r.getCurrX();
      int i2 = this.r.getCurrY();
      this.r.abortAnimation();
      int i3 = this.r.getCurrX();
      int i4 = this.r.getCurrY();
      this.s.k(this.t, i3, i4, i3 - i1, i4 - i2);
    }
    L(0);
  }
  
  public void b()
  {
    this.c = -1;
    j();
    VelocityTracker localVelocityTracker = this.l;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.l = null;
    }
  }
  
  public void c(View paramView, int paramInt)
  {
    if (paramView.getParent() == this.v)
    {
      this.t = paramView;
      this.c = paramInt;
      this.s.i(paramView, paramInt);
      L(1);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    paramView.append(this.v);
    paramView.append(")");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public boolean e(int paramInt)
  {
    int i2 = this.d.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (f(paramInt, i1)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean f(int paramInt1, int paramInt2)
  {
    boolean bool4 = D(paramInt2);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool4) {
      return false;
    }
    int i1;
    if ((paramInt1 & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    float f1 = this.f[paramInt2] - this.d[paramInt2];
    float f2 = this.g[paramInt2] - this.e[paramInt2];
    if ((i1 != 0) && (paramInt1 != 0))
    {
      paramInt1 = this.b;
      if (f1 * f1 + f2 * f2 > paramInt1 * paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    if (i1 != 0)
    {
      bool1 = bool3;
      if (Math.abs(f1) > this.b) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (Math.abs(f2) > this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean n(boolean paramBoolean)
  {
    int i1 = this.a;
    boolean bool2 = false;
    if (i1 == 2)
    {
      boolean bool3 = this.r.computeScrollOffset();
      i1 = this.r.getCurrX();
      int i2 = this.r.getCurrY();
      int i3 = i1 - this.t.getLeft();
      int i4 = i2 - this.t.getTop();
      if (i3 != 0) {
        x.a0(this.t, i3);
      }
      if (i4 != 0) {
        x.b0(this.t, i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        this.s.k(this.t, i1, i2, i3, i4);
      }
      boolean bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i1 == this.r.getFinalX())
        {
          bool1 = bool3;
          if (i2 == this.r.getFinalY())
          {
            this.r.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        if (paramBoolean) {
          this.v.post(this.w);
        } else {
          L(0);
        }
      }
    }
    paramBoolean = bool2;
    if (this.a == 2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public View u(int paramInt1, int paramInt2)
  {
    int i1 = this.v.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = this.v.getChildAt(this.s.c(i1));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i1 -= 1;
    }
    return null;
  }
  
  public View w()
  {
    return this.t;
  }
  
  public int x()
  {
    return this.p;
  }
  
  public int y()
  {
    return this.o;
  }
  
  class a
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      c.this.L(0);
    }
  }
  
  public static abstract class c
  {
    public abstract int a(View paramView, int paramInt1, int paramInt2);
    
    public abstract int b(View paramView, int paramInt1, int paramInt2);
    
    public int c(int paramInt)
    {
      return paramInt;
    }
    
    public int d(View paramView)
    {
      return 0;
    }
    
    public int e(View paramView)
    {
      return 0;
    }
    
    public void f(int paramInt1, int paramInt2) {}
    
    public boolean g(int paramInt)
    {
      return false;
    }
    
    public void h(int paramInt1, int paramInt2) {}
    
    public void i(View paramView, int paramInt) {}
    
    public abstract void j(int paramInt);
    
    public abstract void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void l(View paramView, float paramFloat1, float paramFloat2);
    
    public abstract boolean m(View paramView, int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c1.c
 * JD-Core Version:    0.7.0.1
 */