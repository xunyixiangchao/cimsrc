package c1;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.x;
import g0.h;
import java.util.ArrayList;
import java.util.List;
import y0.d;
import y0.e;
import y0.f;

public abstract class a
  extends androidx.core.view.a
{
  private static final Rect n = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  private static final b.a<d> o = new a();
  private static final b.b<h<d>, d> p = new b();
  private final Rect d = new Rect();
  private final Rect e = new Rect();
  private final Rect f = new Rect();
  private final int[] g = new int[2];
  private final AccessibilityManager h;
  private final View i;
  private c j;
  int k = -2147483648;
  int l = -2147483648;
  private int m = -2147483648;
  
  public a(View paramView)
  {
    if (paramView != null)
    {
      this.i = paramView;
      this.h = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      paramView.setFocusable(true);
      if (x.z(paramView) == 0) {
        x.B0(paramView, 1);
      }
      return;
    }
    throw new IllegalArgumentException("View may not be null");
  }
  
  private static Rect D(View paramView, int paramInt, Rect paramRect)
  {
    int i1 = paramView.getWidth();
    int i2 = paramView.getHeight();
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramRect.set(0, -1, i1, -1);
            return paramRect;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramRect.set(-1, 0, -1, i2);
        return paramRect;
      }
      paramRect.set(0, i2, i1, i2);
      return paramRect;
    }
    paramRect.set(i1, 0, i1, i2);
    return paramRect;
  }
  
  private boolean G(Rect paramRect)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRect != null)
    {
      if (paramRect.isEmpty()) {
        return false;
      }
      if (this.i.getWindowVisibility() != 0) {
        return false;
      }
      paramRect = this.i;
      View localView;
      do
      {
        paramRect = paramRect.getParent();
        if (!(paramRect instanceof View)) {
          break label75;
        }
        localView = (View)paramRect;
        if (localView.getAlpha() <= 0.0F) {
          break;
        }
        paramRect = localView;
      } while (localView.getVisibility() == 0);
      return false;
      label75:
      bool1 = bool2;
      if (paramRect != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int H(int paramInt)
  {
    if (paramInt != 19)
    {
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          return 130;
        }
        return 66;
      }
      return 17;
    }
    return 33;
  }
  
  private boolean I(int paramInt, Rect paramRect)
  {
    h localh = y();
    int i2 = this.l;
    int i1 = -2147483648;
    d locald;
    if (i2 == -2147483648) {
      locald = null;
    } else {
      locald = (d)localh.e(i2);
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 17) && (paramInt != 33) && (paramInt != 66) && (paramInt != 130)) {
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
      Rect localRect = new Rect();
      i2 = this.l;
      if (i2 != -2147483648) {
        z(i2, localRect);
      } else if (paramRect != null) {
        localRect.set(paramRect);
      } else {
        D(this.i, paramInt, localRect);
      }
      paramRect = b.c(localh, p, o, locald, localRect, paramInt);
    }
    else
    {
      boolean bool;
      if (x.B(this.i) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramRect = b.d(localh, p, o, locald, paramInt, bool, false);
    }
    paramRect = (d)paramRect;
    if (paramRect == null) {
      paramInt = i1;
    } else {
      paramInt = localh.k(localh.j(paramRect));
    }
    return V(paramInt);
  }
  
  private boolean S(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 64)
        {
          if (paramInt2 != 128) {
            return L(paramInt1, paramInt2, paramBundle);
          }
          return n(paramInt1);
        }
        return U(paramInt1);
      }
      return o(paramInt1);
    }
    return V(paramInt1);
  }
  
  private boolean T(int paramInt, Bundle paramBundle)
  {
    return x.f0(this.i, paramInt, paramBundle);
  }
  
  private boolean U(int paramInt)
  {
    if (this.h.isEnabled())
    {
      if (!this.h.isTouchExplorationEnabled()) {
        return false;
      }
      int i1 = this.k;
      if (i1 != paramInt)
      {
        if (i1 != -2147483648) {
          n(i1);
        }
        this.k = paramInt;
        this.i.invalidate();
        W(paramInt, 32768);
        return true;
      }
    }
    return false;
  }
  
  private void X(int paramInt)
  {
    int i1 = this.m;
    if (i1 == paramInt) {
      return;
    }
    this.m = paramInt;
    W(paramInt, 128);
    W(i1, 256);
  }
  
  private boolean n(int paramInt)
  {
    if (this.k == paramInt)
    {
      this.k = -2147483648;
      this.i.invalidate();
      W(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  private boolean p()
  {
    int i1 = this.l;
    return (i1 != -2147483648) && (L(i1, 16, null));
  }
  
  private AccessibilityEvent q(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      return r(paramInt1, paramInt2);
    }
    return s(paramInt2);
  }
  
  private AccessibilityEvent r(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    d locald = J(paramInt1);
    localAccessibilityEvent.getText().add(locald.x());
    localAccessibilityEvent.setContentDescription(locald.r());
    localAccessibilityEvent.setScrollable(locald.K());
    localAccessibilityEvent.setPassword(locald.J());
    localAccessibilityEvent.setEnabled(locald.F());
    localAccessibilityEvent.setChecked(locald.D());
    N(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(locald.p());
    f.c(localAccessibilityEvent, this.i, paramInt1);
    localAccessibilityEvent.setPackageName(this.i.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent s(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    this.i.onInitializeAccessibilityEvent(localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private d t(int paramInt)
  {
    d locald = d.O();
    locald.i0(true);
    locald.k0(true);
    locald.c0("android.view.View");
    Object localObject = n;
    locald.X((Rect)localObject);
    locald.Y((Rect)localObject);
    locald.u0(this.i);
    P(paramInt, locald);
    if ((locald.x() == null) && (locald.r() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    locald.m(this.e);
    if (!this.e.equals(localObject))
    {
      int i1 = locald.k();
      if ((i1 & 0x40) == 0)
      {
        if ((i1 & 0x80) == 0)
        {
          locald.s0(this.i.getContext().getPackageName());
          locald.D0(this.i, paramInt);
          if (this.k == paramInt)
          {
            locald.V(true);
            locald.a(128);
          }
          else
          {
            locald.V(false);
            locald.a(64);
          }
          boolean bool;
          if (this.l == paramInt) {
            bool = true;
          } else {
            bool = false;
          }
          if (bool) {
            locald.a(2);
          } else if (locald.G()) {
            locald.a(1);
          }
          locald.l0(bool);
          this.i.getLocationOnScreen(this.g);
          locald.n(this.d);
          if (this.d.equals(localObject))
          {
            locald.m(this.d);
            if (locald.b != -1)
            {
              localObject = d.O();
              for (paramInt = locald.b; paramInt != -1; paramInt = ((d)localObject).b)
              {
                ((d)localObject).v0(this.i, -1);
                ((d)localObject).X(n);
                P(paramInt, (d)localObject);
                ((d)localObject).m(this.e);
                Rect localRect1 = this.d;
                Rect localRect2 = this.e;
                localRect1.offset(localRect2.left, localRect2.top);
              }
              ((d)localObject).S();
            }
            this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
          }
          if (this.i.getLocalVisibleRect(this.f))
          {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.d.intersect(this.f))
            {
              locald.Y(this.d);
              if (G(this.d)) {
                locald.H0(true);
              }
            }
          }
          return locald;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
  }
  
  private d u()
  {
    d locald = d.P(this.i);
    x.d0(this.i, locald);
    ArrayList localArrayList = new ArrayList();
    C(localArrayList);
    if ((locald.o() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int i1 = 0;
    int i2 = localArrayList.size();
    while (i1 < i2)
    {
      locald.d(this.i, ((Integer)localArrayList.get(i1)).intValue());
      i1 += 1;
    }
    return locald;
  }
  
  private h<d> y()
  {
    ArrayList localArrayList = new ArrayList();
    C(localArrayList);
    h localh = new h();
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      d locald = t(((Integer)localArrayList.get(i1)).intValue());
      localh.l(((Integer)localArrayList.get(i1)).intValue(), locald);
      i1 += 1;
    }
    return localh;
  }
  
  private void z(int paramInt, Rect paramRect)
  {
    J(paramInt).m(paramRect);
  }
  
  public final int A()
  {
    return this.l;
  }
  
  protected abstract int B(float paramFloat1, float paramFloat2);
  
  protected abstract void C(List<Integer> paramList);
  
  public final void E(int paramInt)
  {
    F(paramInt, 0);
  }
  
  public final void F(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -2147483648) && (this.h.isEnabled()))
    {
      ViewParent localViewParent = this.i.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = q(paramInt1, 2048);
        y0.b.b(localAccessibilityEvent, paramInt2);
        localViewParent.requestSendAccessibilityEvent(this.i, localAccessibilityEvent);
      }
    }
  }
  
  d J(int paramInt)
  {
    if (paramInt == -1) {
      return u();
    }
    return t(paramInt);
  }
  
  public final void K(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    int i1 = this.l;
    if (i1 != -2147483648) {
      o(i1);
    }
    if (paramBoolean) {
      I(paramInt, paramRect);
    }
  }
  
  protected abstract boolean L(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void M(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void N(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void O(d paramd) {}
  
  protected abstract void P(int paramInt, d paramd);
  
  protected void Q(int paramInt, boolean paramBoolean) {}
  
  boolean R(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      return S(paramInt1, paramInt2, paramBundle);
    }
    return T(paramInt2, paramBundle);
  }
  
  public final boolean V(int paramInt)
  {
    if ((!this.i.isFocused()) && (!this.i.requestFocus())) {
      return false;
    }
    int i1 = this.l;
    if (i1 == paramInt) {
      return false;
    }
    if (i1 != -2147483648) {
      o(i1);
    }
    if (paramInt == -2147483648) {
      return false;
    }
    this.l = paramInt;
    Q(paramInt, true);
    W(paramInt, 8);
    return true;
  }
  
  public final boolean W(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -2147483648)
    {
      if (!this.h.isEnabled()) {
        return false;
      }
      ViewParent localViewParent = this.i.getParent();
      if (localViewParent == null) {
        return false;
      }
      AccessibilityEvent localAccessibilityEvent = q(paramInt1, paramInt2);
      return localViewParent.requestSendAccessibilityEvent(this.i, localAccessibilityEvent);
    }
    return false;
  }
  
  public e b(View paramView)
  {
    if (this.j == null) {
      this.j = new c();
    }
    return this.j;
  }
  
  public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.f(paramView, paramAccessibilityEvent);
    M(paramAccessibilityEvent);
  }
  
  public void g(View paramView, d paramd)
  {
    super.g(paramView, paramd);
    O(paramd);
  }
  
  public final boolean o(int paramInt)
  {
    if (this.l != paramInt) {
      return false;
    }
    this.l = -2147483648;
    Q(paramInt, false);
    W(paramInt, 8);
    return true;
  }
  
  public final boolean v(MotionEvent paramMotionEvent)
  {
    boolean bool3 = this.h.isEnabled();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      if (!this.h.isTouchExplorationEnabled()) {
        return false;
      }
      int i1 = paramMotionEvent.getAction();
      if ((i1 != 7) && (i1 != 9))
      {
        if (i1 != 10) {
          return false;
        }
        if (this.m != -2147483648)
        {
          X(-2147483648);
          return true;
        }
        return false;
      }
      i1 = B(paramMotionEvent.getX(), paramMotionEvent.getY());
      X(i1);
      bool1 = bool2;
      if (i1 != -2147483648) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean w(KeyEvent paramKeyEvent)
  {
    int i2 = paramKeyEvent.getAction();
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1 = bool2;
    if (i2 != 1)
    {
      i2 = paramKeyEvent.getKeyCode();
      if (i2 != 61)
      {
        if (i2 != 66)
        {
          switch (i2)
          {
          default: 
            return false;
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            bool1 = bool2;
            if (!paramKeyEvent.hasNoModifiers()) {
              break;
            }
            i2 = H(i2);
            int i3 = paramKeyEvent.getRepeatCount();
            for (bool1 = false; (i1 < i3 + 1) && (I(i2, null)); bool1 = true) {
              i1 += 1;
            }
            return bool1;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool2;
            if (paramKeyEvent.getRepeatCount() == 0)
            {
              p();
              return true;
            }
          }
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return I(2, null);
        }
        bool1 = bool2;
        if (paramKeyEvent.hasModifiers(1)) {
          bool1 = I(1, null);
        }
      }
    }
    return bool1;
  }
  
  public final int x()
  {
    return this.k;
  }
  
  class a
    implements b.a<d>
  {
    public void b(d paramd, Rect paramRect)
    {
      paramd.m(paramRect);
    }
  }
  
  class b
    implements b.b<h<d>, d>
  {
    public d c(h<d> paramh, int paramInt)
    {
      return (d)paramh.o(paramInt);
    }
    
    public int d(h<d> paramh)
    {
      return paramh.n();
    }
  }
  
  private class c
    extends e
  {
    c() {}
    
    public d b(int paramInt)
    {
      return d.Q(a.this.J(paramInt));
    }
    
    public d d(int paramInt)
    {
      if (paramInt == 2) {
        paramInt = a.this.k;
      } else {
        paramInt = a.this.l;
      }
      if (paramInt == -2147483648) {
        return null;
      }
      return b(paramInt);
    }
    
    public boolean f(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return a.this.R(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c1.a
 * JD-Core Version:    0.7.0.1
 */