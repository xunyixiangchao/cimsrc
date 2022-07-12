package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.b;
import androidx.core.view.a;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import c1.c;
import c1.c.c;
import java.util.ArrayList;
import y0.d;

public class SlidingPaneLayout
  extends ViewGroup
{
  private int a = -858993460;
  private int b;
  private Drawable c;
  private Drawable d;
  private final int e;
  private boolean f;
  View g;
  float h;
  private float i;
  int j;
  boolean k;
  private int l;
  private float m;
  private float n;
  private d o;
  final c p;
  boolean q;
  private boolean r = true;
  private final Rect s = new Rect();
  final ArrayList<b> t = new ArrayList();
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.e = ((int)(32.0F * f1 + 0.5F));
    setWillNotDraw(false);
    x.q0(this, new a());
    x.B0(this, 1);
    paramContext = c.o(this, 0.5F, new c());
    this.p = paramContext;
    paramContext.O(f1 * 400.0F);
  }
  
  private boolean b(View paramView, int paramInt)
  {
    if ((!this.r) && (!q(0.0F, paramInt))) {
      return false;
    }
    this.q = false;
    return true;
  }
  
  private void c(View paramView, float paramFloat, int paramInt)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i1 = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (((LayoutParams)localObject).d == null) {
        ((LayoutParams)localObject).d = new Paint();
      }
      ((LayoutParams)localObject).d.setColorFilter(new PorterDuffColorFilter(i1 << 24 | paramInt & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, ((LayoutParams)localObject).d);
      }
      g(paramView);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      localObject = ((LayoutParams)localObject).d;
      if (localObject != null) {
        ((Paint)localObject).setColorFilter(null);
      }
      paramView = new b(paramView);
      this.t.add(paramView);
      x.i0(this, paramView);
    }
  }
  
  private boolean n(View paramView, int paramInt)
  {
    if ((!this.r) && (!q(1.0F, paramInt))) {
      return false;
    }
    this.q = true;
    return true;
  }
  
  private void o(float paramFloat)
  {
    boolean bool1 = i();
    Object localObject = (LayoutParams)this.g.getLayoutParams();
    boolean bool2 = ((LayoutParams)localObject).c;
    int i2 = 0;
    if (bool2)
    {
      if (bool1) {
        i1 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      } else {
        i1 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      }
      if (i1 <= 0)
      {
        i1 = 1;
        break label64;
      }
    }
    int i1 = 0;
    label64:
    int i5 = getChildCount();
    while (i2 < i5)
    {
      localObject = getChildAt(i2);
      if (localObject != this.g)
      {
        float f1 = this.i;
        int i3 = this.l;
        int i4 = (int)((1.0F - f1) * i3);
        this.i = paramFloat;
        i4 -= (int)((1.0F - paramFloat) * i3);
        i3 = i4;
        if (bool1) {
          i3 = -i4;
        }
        ((View)localObject).offsetLeftAndRight(i3);
        if (i1 != 0)
        {
          f1 = this.i;
          if (bool1) {
            f1 -= 1.0F;
          } else {
            f1 = 1.0F - f1;
          }
          c((View)localObject, f1, this.b);
        }
      }
      i2 += 1;
    }
  }
  
  private static boolean s(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public boolean a()
  {
    return b(this.g, 0);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.p.n(true))
    {
      if (!this.f)
      {
        this.p.a();
        return;
      }
      x.h0(this);
    }
  }
  
  void d(View paramView)
  {
    d locald = this.o;
    if (locald != null) {
      locald.c(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (i()) {
      localDrawable = this.d;
    } else {
      localDrawable = this.c;
    }
    View localView;
    if (getChildCount() > 1) {
      localView = getChildAt(1);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      if (localDrawable == null) {
        return;
      }
      int i4 = localView.getTop();
      int i5 = localView.getBottom();
      int i3 = localDrawable.getIntrinsicWidth();
      int i1;
      int i2;
      if (i())
      {
        i1 = localView.getRight();
        i2 = i3 + i1;
      }
      else
      {
        i2 = localView.getLeft();
        i1 = i2;
        i3 = i2 - i3;
        i2 = i1;
        i1 = i3;
      }
      localDrawable.setBounds(i1, i4, i2, i5);
      localDrawable.draw(paramCanvas);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i1 = paramCanvas.save();
    if ((this.f) && (!((LayoutParams)localObject).b) && (this.g != null))
    {
      paramCanvas.getClipBounds(this.s);
      if (i())
      {
        localObject = this.s;
        ((Rect)localObject).left = Math.max(((Rect)localObject).left, this.g.getRight());
      }
      else
      {
        localObject = this.s;
        ((Rect)localObject).right = Math.min(((Rect)localObject).right, this.g.getLeft());
      }
      paramCanvas.clipRect(this.s);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i1);
    return bool;
  }
  
  void e(View paramView)
  {
    d locald = this.o;
    if (locald != null) {
      locald.b(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void f(View paramView)
  {
    d locald = this.o;
    if (locald != null) {
      locald.a(paramView, this.h);
    }
  }
  
  void g(View paramView)
  {
    x.D0(paramView, ((LayoutParams)paramView.getLayoutParams()).d);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCoveredFadeColor()
  {
    return this.b;
  }
  
  public int getParallaxDistance()
  {
    return this.l;
  }
  
  public int getSliderFadeColor()
  {
    return this.a;
  }
  
  boolean h(View paramView)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (this.f)
    {
      bool1 = bool2;
      if (paramView.c)
      {
        bool1 = bool2;
        if (this.h > 0.0F) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  boolean i()
  {
    return x.B(this) == 1;
  }
  
  public boolean j()
  {
    return (!this.f) || (this.h == 1.0F);
  }
  
  public boolean k()
  {
    return this.f;
  }
  
  void l(int paramInt)
  {
    if (this.g == null)
    {
      this.h = 0.0F;
      return;
    }
    boolean bool = i();
    LayoutParams localLayoutParams = (LayoutParams)this.g.getLayoutParams();
    int i2 = this.g.getWidth();
    int i1 = paramInt;
    if (bool) {
      i1 = getWidth() - paramInt - i2;
    }
    if (bool) {
      paramInt = getPaddingRight();
    } else {
      paramInt = getPaddingLeft();
    }
    if (bool) {
      i2 = localLayoutParams.rightMargin;
    } else {
      i2 = localLayoutParams.leftMargin;
    }
    float f1 = (i1 - (paramInt + i2)) / this.j;
    this.h = f1;
    if (this.l != 0) {
      o(f1);
    }
    if (localLayoutParams.c) {
      c(this.g, this.h, this.a);
    }
    f(this.g);
  }
  
  public boolean m()
  {
    return n(this.g, 0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r = true;
    int i2 = this.t.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((b)this.t.get(i1)).run();
      i1 += 1;
    }
    this.t.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool2 = this.f;
    boolean bool1 = true;
    if ((!bool2) && (i1 == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        this.q = (this.p.F(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) ^ true);
      }
    }
    if ((this.f) && ((!this.k) || (i1 == 0)))
    {
      if ((i1 != 3) && (i1 != 1))
      {
        float f2;
        float f1;
        if (i1 != 0)
        {
          if (i1 == 2)
          {
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - this.m);
            f1 = Math.abs(f1 - this.n);
            if ((f2 > this.p.A()) && (f1 > f2))
            {
              this.p.b();
              this.k = true;
              return false;
            }
          }
        }
        else
        {
          this.k = false;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          this.m = f1;
          this.n = f2;
          if ((this.p.F(this.g, (int)f1, (int)f2)) && (h(this.g)))
          {
            i1 = 1;
            break label247;
          }
        }
        i1 = 0;
        label247:
        if (!this.p.Q(paramMotionEvent))
        {
          if (i1 != 0) {
            return true;
          }
          bool1 = false;
        }
        return bool1;
      }
      this.p.b();
      return false;
    }
    this.p.b();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = i();
    Object localObject = this.p;
    if (bool) {
      ((c)localObject).N(2);
    } else {
      ((c)localObject).N(1);
    }
    int i3 = paramInt3 - paramInt1;
    if (bool) {
      paramInt1 = getPaddingRight();
    } else {
      paramInt1 = getPaddingLeft();
    }
    if (bool) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int i5 = getPaddingTop();
    int i4 = getChildCount();
    if (this.r)
    {
      float f1;
      if ((this.f) && (this.q)) {
        f1 = 1.0F;
      } else {
        f1 = 0.0F;
      }
      this.h = f1;
    }
    paramInt2 = paramInt1;
    int i1 = 0;
    while (i1 < i4)
    {
      localObject = getChildAt(i1);
      if (((View)localObject).getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        int i6 = ((View)localObject).getMeasuredWidth();
        int i2;
        if (localLayoutParams.b)
        {
          paramInt3 = localLayoutParams.leftMargin;
          int i7 = localLayoutParams.rightMargin;
          i2 = i3 - paramInt4;
          i7 = Math.min(paramInt1, i2 - this.e) - paramInt2 - (paramInt3 + i7);
          this.j = i7;
          if (bool) {
            paramInt3 = localLayoutParams.rightMargin;
          } else {
            paramInt3 = localLayoutParams.leftMargin;
          }
          if (paramInt2 + paramInt3 + i7 + i6 / 2 > i2) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localLayoutParams.c = paramBoolean;
          i2 = (int)(i7 * this.h);
          paramInt2 += paramInt3 + i2;
          this.h = (i2 / i7);
          paramInt3 = 0;
        }
        else
        {
          if (this.f)
          {
            paramInt2 = this.l;
            if (paramInt2 != 0)
            {
              paramInt3 = (int)((1.0F - this.h) * paramInt2);
              paramInt2 = paramInt1;
              break label356;
            }
          }
          paramInt2 = paramInt1;
          paramInt3 = 0;
        }
        label356:
        if (bool)
        {
          i2 = i3 - paramInt2 + paramInt3;
          paramInt3 = i2 - i6;
        }
        else
        {
          paramInt3 = paramInt2 - paramInt3;
          i2 = paramInt3 + i6;
        }
        ((View)localObject).layout(paramInt3, i5, i2, ((View)localObject).getMeasuredHeight() + i5);
        paramInt1 += ((View)localObject).getWidth();
      }
      i1 += 1;
    }
    if (this.r)
    {
      if (this.f)
      {
        if (this.l != 0) {
          o(this.h);
        }
        if (((LayoutParams)this.g.getLayoutParams()).c) {
          c(this.g, this.h, this.a);
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < i4)
        {
          c(getChildAt(paramInt1), 0.0F, this.a);
          paramInt1 += 1;
        }
      }
      r(this.g);
    }
    this.r = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    if (paramParcelable.c) {
      m();
    } else {
      a();
    }
    this.q = paramParcelable.c;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (k()) {
      bool = j();
    } else {
      bool = this.q;
    }
    localSavedState.c = bool;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.r = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.f) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.p.G(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return true;
      }
      if (h(this.g))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.m;
        float f4 = f2 - this.n;
        i1 = this.p.A();
        if ((f3 * f3 + f4 * f4 < i1 * i1) && (this.p.F(this.g, (int)f1, (int)f2)))
        {
          b(this.g, 0);
          return true;
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.m = f1;
      this.n = f2;
    }
    return true;
  }
  
  void p()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  boolean q(float paramFloat, int paramInt)
  {
    if (!this.f) {
      return false;
    }
    boolean bool = i();
    Object localObject = (LayoutParams)this.g.getLayoutParams();
    if (bool)
    {
      paramInt = getPaddingRight();
      int i1 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      int i2 = this.g.getWidth();
      paramInt = (int)(getWidth() - (paramInt + i1 + paramFloat * this.j + i2));
    }
    else
    {
      paramInt = (int)(getPaddingLeft() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + paramFloat * this.j);
    }
    localObject = this.p;
    View localView = this.g;
    if (((c)localObject).R(localView, paramInt, localView.getTop()))
    {
      p();
      x.h0(this);
      return true;
    }
    return false;
  }
  
  void r(View paramView)
  {
    boolean bool = i();
    int i1;
    if (bool) {
      i1 = getWidth() - getPaddingRight();
    } else {
      i1 = getPaddingLeft();
    }
    int i2;
    if (bool) {
      i2 = getPaddingLeft();
    } else {
      i2 = getWidth() - getPaddingRight();
    }
    int i9 = getPaddingTop();
    int i10 = getHeight();
    int i11 = getPaddingBottom();
    int i3;
    int i4;
    int i5;
    int i6;
    if ((paramView != null) && (s(paramView)))
    {
      i3 = paramView.getLeft();
      i4 = paramView.getRight();
      i5 = paramView.getTop();
      i6 = paramView.getBottom();
    }
    else
    {
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
    }
    int i12 = getChildCount();
    int i7 = 0;
    while (i7 < i12)
    {
      View localView = getChildAt(i7);
      if (localView == paramView) {
        return;
      }
      if (localView.getVisibility() != 8)
      {
        if (bool) {
          i8 = i2;
        } else {
          i8 = i1;
        }
        int i13 = Math.max(i8, localView.getLeft());
        int i14 = Math.max(i9, localView.getTop());
        if (bool) {
          i8 = i1;
        } else {
          i8 = i2;
        }
        int i8 = Math.min(i8, localView.getRight());
        int i15 = Math.min(i10 - i11, localView.getBottom());
        if ((i13 >= i3) && (i14 >= i5) && (i8 <= i4) && (i15 <= i6)) {
          i8 = 4;
        } else {
          i8 = 0;
        }
        localView.setVisibility(i8);
      }
      i7 += 1;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.f))
    {
      boolean bool;
      if (paramView1 == this.g) {
        bool = true;
      } else {
        bool = false;
      }
      this.q = bool;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.o = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.c = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.d = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(b.d(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(b.d(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] e = { 16843137 };
    public float a = 0.0F;
    boolean b;
    boolean c;
    Paint d;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e);
      this.a = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean c;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.c = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<SlidingPaneLayout.SavedState>
    {
      public SlidingPaneLayout.SavedState a(Parcel paramParcel)
      {
        return new SlidingPaneLayout.SavedState(paramParcel, null);
      }
      
      public SlidingPaneLayout.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new SlidingPaneLayout.SavedState(paramParcel, null);
      }
      
      public SlidingPaneLayout.SavedState[] c(int paramInt)
      {
        return new SlidingPaneLayout.SavedState[paramInt];
      }
    }
  }
  
  class a
    extends a
  {
    private final Rect d = new Rect();
    
    a() {}
    
    private void n(d paramd1, d paramd2)
    {
      Rect localRect = this.d;
      paramd2.m(localRect);
      paramd1.X(localRect);
      paramd2.n(localRect);
      paramd1.Y(localRect);
      paramd1.H0(paramd2.N());
      paramd1.s0(paramd2.v());
      paramd1.c0(paramd2.p());
      paramd1.g0(paramd2.r());
      paramd1.i0(paramd2.F());
      paramd1.d0(paramd2.E());
      paramd1.k0(paramd2.G());
      paramd1.l0(paramd2.H());
      paramd1.V(paramd2.B());
      paramd1.A0(paramd2.L());
      paramd1.p0(paramd2.I());
      paramd1.a(paramd2.k());
      paramd1.r0(paramd2.t());
    }
    
    public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.f(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void g(View paramView, d paramd)
    {
      d locald = d.Q(paramd);
      super.g(paramView, locald);
      n(paramd, locald);
      locald.S();
      paramd.c0(SlidingPaneLayout.class.getName());
      paramd.C0(paramView);
      paramView = x.H(paramView);
      if ((paramView instanceof View)) {
        paramd.u0((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!o(paramView)) && (paramView.getVisibility() == 0))
        {
          x.B0(paramView, 1);
          paramd.c(paramView);
        }
        i += 1;
      }
    }
    
    public boolean i(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!o(paramView)) {
        return super.i(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
    
    public boolean o(View paramView)
    {
      return SlidingPaneLayout.this.h(paramView);
    }
  }
  
  private class b
    implements Runnable
  {
    final View a;
    
    b(View paramView)
    {
      this.a = paramView;
    }
    
    public void run()
    {
      if (this.a.getParent() == SlidingPaneLayout.this)
      {
        this.a.setLayerType(0, null);
        SlidingPaneLayout.this.g(this.a);
      }
      SlidingPaneLayout.this.t.remove(this);
    }
  }
  
  private class c
    extends c.c
  {
    c() {}
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.g.getLayoutParams();
      if (SlidingPaneLayout.this.i())
      {
        paramInt2 = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.getPaddingRight() + paramView.rightMargin + SlidingPaneLayout.this.g.getWidth());
        i = SlidingPaneLayout.this.j;
        return Math.max(Math.min(paramInt1, paramInt2), paramInt2 - i);
      }
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft() + paramView.leftMargin;
      int i = SlidingPaneLayout.this.j;
      return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    }
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int d(View paramView)
    {
      return SlidingPaneLayout.this.j;
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
      localSlidingPaneLayout.p.c(localSlidingPaneLayout.g, paramInt2);
    }
    
    public void i(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.p();
    }
    
    public void j(int paramInt)
    {
      if (SlidingPaneLayout.this.p.B() == 0)
      {
        SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
        boolean bool;
        if (localSlidingPaneLayout.h == 0.0F)
        {
          localSlidingPaneLayout.r(localSlidingPaneLayout.g);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          localSlidingPaneLayout.d(localSlidingPaneLayout.g);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          bool = false;
        }
        else
        {
          localSlidingPaneLayout.e(localSlidingPaneLayout.g);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          bool = true;
        }
        localSlidingPaneLayout.q = bool;
      }
    }
    
    public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SlidingPaneLayout.this.l(paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void l(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int j;
      int i;
      if (SlidingPaneLayout.this.i())
      {
        j = SlidingPaneLayout.this.getPaddingRight() + localLayoutParams.rightMargin;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.h <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.j;
        }
        j = SlidingPaneLayout.this.g.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      else
      {
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        boolean bool = paramFloat1 < 0.0F;
        if (!bool)
        {
          i = j;
          if (!bool)
          {
            i = j;
            if (SlidingPaneLayout.this.h <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.j;
        }
      }
      SlidingPaneLayout.this.p.P(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public boolean m(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.this.k) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).b;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, float paramFloat);
    
    public abstract void b(View paramView);
    
    public abstract void c(View paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.slidingpanelayout.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */