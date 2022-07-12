package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.R.styleable;
import androidx.core.view.e;
import androidx.core.view.x;

public class LinearLayoutCompat
  extends ViewGroup
{
  private boolean a = true;
  private int b = -1;
  private int c = 0;
  private int d;
  private int e = 8388659;
  private int f;
  private float g;
  private boolean h;
  private int[] i;
  private int[] j;
  private Drawable k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int[] arrayOfInt = R.styleable.LinearLayoutCompat;
    k0 localk0 = k0.v(paramContext, paramAttributeSet, arrayOfInt, paramInt, 0);
    x.o0(this, paramContext, arrayOfInt, paramAttributeSet, localk0.r(), paramInt, 0);
    paramInt = localk0.k(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = localk0.k(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = localk0.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.g = localk0.i(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.b = localk0.k(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.h = localk0.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(localk0.g(R.styleable.LinearLayoutCompat_divider));
    this.n = localk0.k(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.o = localk0.f(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    localk0.w();
  }
  
  private void A(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private void k(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i1 = 0;
    while (i1 < paramInt1)
    {
      View localView = s(i1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.height == -1)
        {
          int i3 = localLayoutParams.width;
          localLayoutParams.width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, i2, 0);
          localLayoutParams.width = i3;
        }
      }
      i1 += 1;
    }
  }
  
  private void l(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i1 = 0;
    while (i1 < paramInt1)
    {
      View localView = s(i1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int i3 = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i2, 0, paramInt2, 0);
          localLayoutParams.height = i3;
        }
      }
      i1 += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void f(Canvas paramCanvas)
  {
    int i3 = getVirtualChildCount();
    boolean bool = r0.b(this);
    int i1 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    while (i1 < i3)
    {
      localView = s(i1);
      if ((localView != null) && (localView.getVisibility() != 8) && (t(i1)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          i2 = localView.getRight() + localLayoutParams.rightMargin;
        } else {
          i2 = localView.getLeft() - localLayoutParams.leftMargin - this.l;
        }
        i(paramCanvas, i2);
      }
      i1 += 1;
    }
    if (t(i3))
    {
      localView = s(i3 - 1);
      if (localView == null)
      {
        if (bool)
        {
          i1 = getPaddingLeft();
          break label211;
        }
        i1 = getWidth();
        i2 = getPaddingRight();
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label199;
        }
        i1 = localView.getLeft();
        i2 = localLayoutParams.leftMargin;
      }
      i1 = i1 - i2 - this.l;
      break label211;
      label199:
      i1 = localView.getRight() + localLayoutParams.rightMargin;
      label211:
      i(paramCanvas, i1);
    }
  }
  
  void g(Canvas paramCanvas)
  {
    int i2 = getVirtualChildCount();
    int i1 = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i1 < i2)
    {
      localView = s(i1);
      if ((localView != null) && (localView.getVisibility() != 8) && (t(i1)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        h(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.m);
      }
      i1 += 1;
    }
    if (t(i2))
    {
      localView = s(i2 - 1);
      if (localView == null)
      {
        i1 = getHeight() - getPaddingBottom() - this.m;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = localView.getBottom() + localLayoutParams.bottomMargin;
      }
      h(paramCanvas, i1);
    }
  }
  
  public int getBaseline()
  {
    if (this.b < 0) {
      return super.getBaseline();
    }
    int i1 = getChildCount();
    int i2 = this.b;
    if (i1 > i2)
    {
      View localView = getChildAt(i2);
      int i3 = localView.getBaseline();
      if (i3 == -1)
      {
        if (this.b == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      i2 = this.c;
      i1 = i2;
      if (this.d == 1)
      {
        int i4 = this.e & 0x70;
        i1 = i2;
        if (i4 != 48) {
          if (i4 != 16)
          {
            if (i4 != 80) {
              i1 = i2;
            } else {
              i1 = getBottom() - getTop() - getPaddingBottom() - this.f;
            }
          }
          else {
            i1 = i2 + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.f) / 2;
          }
        }
      }
      return i1 + ((LayoutParams)localView.getLayoutParams()).topMargin + i3;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.b;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.k;
  }
  
  public int getDividerPadding()
  {
    return this.o;
  }
  
  public int getDividerWidth()
  {
    return this.l;
  }
  
  public int getGravity()
  {
    return this.e;
  }
  
  public int getOrientation()
  {
    return this.d;
  }
  
  public int getShowDividers()
  {
    return this.n;
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.g;
  }
  
  void h(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(getPaddingLeft() + this.o, paramInt, getWidth() - getPaddingRight() - this.o, this.m + paramInt);
    this.k.draw(paramCanvas);
  }
  
  void i(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(paramInt, getPaddingTop() + this.o, this.l + paramInt, getHeight() - getPaddingBottom() - this.o);
    this.k.draw(paramCanvas);
  }
  
  protected LayoutParams m()
  {
    int i1 = this.d;
    if (i1 == 0) {
      return new LayoutParams(-2, -2);
    }
    if (i1 == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public LayoutParams n(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams o(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.k == null) {
      return;
    }
    if (this.d == 1)
    {
      g(paramCanvas);
      return;
    }
    f(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d == 1)
    {
      v(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    u(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d == 1)
    {
      z(paramInt1, paramInt2);
      return;
    }
    x(paramInt1, paramInt2);
  }
  
  int p(View paramView, int paramInt)
  {
    return 0;
  }
  
  int q(View paramView)
  {
    return 0;
  }
  
  int r(View paramView)
  {
    return 0;
  }
  
  View s(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      this.b = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.k) {
      return;
    }
    this.k = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.l = paramDrawable.getIntrinsicWidth();
      this.m = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      this.l = 0;
      this.m = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.e != paramInt)
    {
      int i1 = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i1 = paramInt | 0x800003;
      }
      paramInt = i1;
      if ((i1 & 0x70) == 0) {
        paramInt = i1 | 0x30;
      }
      this.e = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    int i1 = this.e;
    if ((0x800007 & i1) != paramInt)
    {
      this.e = (paramInt | 0xFF7FFFF8 & i1);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.n) {
      requestLayout();
    }
    this.n = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i1 = this.e;
    if ((i1 & 0x70) != paramInt)
    {
      this.e = (paramInt | i1 & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.g = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected boolean t(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0)
    {
      if ((this.n & 0x1) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt == getChildCount())
    {
      bool1 = bool2;
      if ((this.n & 0x4) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    if ((this.n & 0x2) != 0)
    {
      paramInt -= 1;
      while (paramInt >= 0)
      {
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
    }
    return false;
  }
  
  void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = r0.b(this);
    int i6 = getPaddingTop();
    int i8 = paramInt4 - paramInt2;
    int i9 = getPaddingBottom();
    int i10 = getPaddingBottom();
    int i4 = getVirtualChildCount();
    paramInt2 = this.e;
    paramInt4 = paramInt2 & 0x70;
    boolean bool1 = this.a;
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = this.j;
    paramInt2 = e.b(0x800007 & paramInt2, x.B(this));
    int i14 = 1;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 5) {
        paramInt2 = getPaddingLeft();
      } else {
        paramInt2 = getPaddingLeft() + paramInt3 - paramInt1 - this.f;
      }
    }
    else {
      paramInt2 = getPaddingLeft() + (paramInt3 - paramInt1 - this.f) / 2;
    }
    int i2;
    int i3;
    if (bool2)
    {
      i2 = i4 - 1;
      i3 = -1;
    }
    else
    {
      i2 = 0;
      i3 = 1;
    }
    int i1 = 0;
    paramInt3 = paramInt4;
    paramInt4 = i6;
    while (i1 < i4)
    {
      int i12 = i2 + i3 * i1;
      View localView = s(i12);
      if (localView == null)
      {
        paramInt2 += y(i12);
      }
      else if (localView.getVisibility() != 8)
      {
        int i11 = localView.getMeasuredWidth();
        int i13 = localView.getMeasuredHeight();
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((bool1) && (localLayoutParams.height != -1)) {
          i5 = localView.getBaseline();
        } else {
          i5 = -1;
        }
        int i7 = localLayoutParams.gravity;
        paramInt1 = i7;
        if (i7 < 0) {
          paramInt1 = paramInt3;
        }
        paramInt1 &= 0x70;
        if (paramInt1 != 16)
        {
          if (paramInt1 != 48)
          {
            if (paramInt1 != 80)
            {
              paramInt1 = paramInt4;
            }
            else
            {
              i7 = i8 - i9 - i13 - localLayoutParams.bottomMargin;
              paramInt1 = i7;
              if (i5 != -1)
              {
                paramInt1 = localView.getMeasuredHeight();
                paramInt1 = i7 - (arrayOfInt2[2] - (paramInt1 - i5));
              }
            }
          }
          else
          {
            i7 = localLayoutParams.topMargin + paramInt4;
            paramInt1 = i7;
            if (i5 != -1)
            {
              paramInt1 = i7 + (arrayOfInt1[1] - i5);
              break label426;
            }
          }
        }
        else {
          paramInt1 = (i8 - i6 - i10 - i13) / 2 + paramInt4 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
        }
        label426:
        i14 = 1;
        int i5 = paramInt2;
        if (t(i12)) {
          i5 = paramInt2 + this.l;
        }
        paramInt2 = localLayoutParams.leftMargin + i5;
        A(localView, paramInt2 + q(localView), paramInt1, i11, i13);
        paramInt1 = localLayoutParams.rightMargin;
        i5 = r(localView);
        i1 += p(localView, i12);
        paramInt2 += i11 + paramInt1 + i5;
      }
      else
      {
        i14 = 1;
      }
      i1 += 1;
    }
  }
  
  void v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getPaddingLeft();
    int i2 = paramInt3 - paramInt1;
    int i3 = getPaddingRight();
    int i4 = getPaddingRight();
    int i5 = getVirtualChildCount();
    int i6 = this.e;
    paramInt1 = i6 & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.f;
      }
    }
    else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.f) / 2;
    }
    paramInt2 = 0;
    while (paramInt2 < i5)
    {
      View localView = s(paramInt2);
      if (localView == null)
      {
        paramInt3 = paramInt1 + y(paramInt2);
      }
      else
      {
        paramInt3 = paramInt1;
        if (localView.getVisibility() != 8)
        {
          int i8 = localView.getMeasuredWidth();
          int i7 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          paramInt4 = localLayoutParams.gravity;
          paramInt3 = paramInt4;
          if (paramInt4 < 0) {
            paramInt3 = i6 & 0x800007;
          }
          paramInt3 = e.b(paramInt3, x.B(this)) & 0x7;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 5)
            {
              paramInt3 = localLayoutParams.leftMargin + i1;
              break label262;
            }
            paramInt3 = i2 - i3 - i8;
          }
          else
          {
            paramInt3 = (i2 - i1 - i4 - i8) / 2 + i1 + localLayoutParams.leftMargin;
          }
          paramInt3 -= localLayoutParams.rightMargin;
          label262:
          paramInt4 = paramInt1;
          if (t(paramInt2)) {
            paramInt4 = paramInt1 + this.m;
          }
          paramInt1 = paramInt4 + localLayoutParams.topMargin;
          A(localView, paramInt3, paramInt1 + q(localView), i8, i7);
          paramInt3 = localLayoutParams.bottomMargin;
          paramInt4 = r(localView);
          paramInt2 += p(localView, paramInt2);
          paramInt1 += i7 + paramInt3 + paramInt4;
          break label348;
        }
      }
      paramInt1 = paramInt3;
      label348:
      paramInt2 += 1;
    }
  }
  
  void w(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void x(int paramInt1, int paramInt2)
  {
    this.f = 0;
    int i12 = getVirtualChildCount();
    int i19 = View.MeasureSpec.getMode(paramInt1);
    int i18 = View.MeasureSpec.getMode(paramInt2);
    if ((this.i == null) || (this.j == null))
    {
      this.i = new int[4];
      this.j = new int[4];
    }
    int[] arrayOfInt = this.i;
    Object localObject = this.j;
    arrayOfInt[3] = -1;
    arrayOfInt[2] = -1;
    arrayOfInt[1] = -1;
    arrayOfInt[0] = -1;
    localObject[3] = -1;
    localObject[2] = -1;
    localObject[1] = -1;
    localObject[0] = -1;
    boolean bool1 = this.a;
    boolean bool2 = this.h;
    int i10 = 1073741824;
    int i11;
    if (i19 == 1073741824) {
      i11 = 1;
    } else {
      i11 = 0;
    }
    int i4 = 0;
    int i3 = i4;
    int i9 = i3;
    int i2 = i9;
    int i7 = i2;
    int i8 = i7;
    int i5 = i8;
    int i6 = i5;
    int i1 = 1;
    float f1 = 0.0F;
    View localView;
    LayoutParams localLayoutParams;
    float f2;
    while (i4 < i12)
    {
      localView = s(i4);
      if (localView == null) {
        this.f += y(i4);
      }
      for (;;)
      {
        i13 = i4;
        i4 = i10;
        i10 = i13;
        break label866;
        if (localView.getVisibility() != 8) {
          break;
        }
        i4 += p(localView, i4);
      }
      if (t(i4)) {
        this.f += this.l;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f2 = localLayoutParams.weight;
      f1 += f2;
      if ((i19 == i10) && (localLayoutParams.width == 0) && (f2 > 0.0F))
      {
        i10 = this.f;
        if (i11 != 0) {
          i10 += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        } else {
          i10 = Math.max(i10, localLayoutParams.leftMargin + i10 + localLayoutParams.rightMargin);
        }
        this.f = i10;
        if (bool1)
        {
          i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
          localView.measure(i10, i10);
          i10 = i3;
        }
        else
        {
          i8 = 1;
          break label591;
        }
      }
      else
      {
        if ((localLayoutParams.width == 0) && (f2 > 0.0F))
        {
          localLayoutParams.width = -2;
          i10 = 0;
        }
        else
        {
          i10 = -2147483648;
        }
        if (f1 == 0.0F) {
          i13 = this.f;
        } else {
          i13 = 0;
        }
        w(localView, i4, paramInt1, i13, paramInt2, 0);
        if (i10 != -2147483648) {
          localLayoutParams.width = i10;
        }
        i13 = localView.getMeasuredWidth();
        if (i11 != 0)
        {
          i10 = this.f + (localLayoutParams.leftMargin + i13 + localLayoutParams.rightMargin + r(localView));
        }
        else
        {
          i10 = this.f;
          i10 = Math.max(i10, i10 + i13 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + r(localView));
        }
        this.f = i10;
        i10 = i3;
        if (bool2) {
          i10 = Math.max(i13, i3);
        }
      }
      i3 = i10;
      label591:
      int i15 = i4;
      i14 = 1073741824;
      if ((i18 != 1073741824) && (localLayoutParams.height == -1))
      {
        i4 = 1;
        i6 = i4;
      }
      else
      {
        i4 = 0;
      }
      i10 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      i13 = localView.getMeasuredHeight() + i10;
      int i16 = View.combineMeasuredStates(i5, localView.getMeasuredState());
      if (bool1)
      {
        int i20 = localView.getBaseline();
        if (i20 != -1)
        {
          int i17 = localLayoutParams.gravity;
          i5 = i17;
          if (i17 < 0) {
            i5 = this.e;
          }
          i5 = ((i5 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
          arrayOfInt[i5] = Math.max(arrayOfInt[i5], i20);
          localObject[i5] = Math.max(localObject[i5], i13 - i20);
        }
      }
      i9 = Math.max(i9, i13);
      if ((i1 != 0) && (localLayoutParams.height == -1)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (localLayoutParams.weight > 0.0F)
      {
        if (i4 == 0) {
          i10 = i13;
        }
        i4 = Math.max(i7, i10);
      }
      else
      {
        if (i4 == 0) {
          i10 = i13;
        }
        i2 = Math.max(i2, i10);
        i4 = i7;
      }
      i10 = p(localView, i15) + i15;
      i5 = i16;
      i7 = i4;
      i4 = i14;
      label866:
      i13 = i4;
      i4 = i10 + 1;
      i10 = i13;
    }
    if ((this.f > 0) && (t(i12))) {
      this.f += this.l;
    }
    if ((arrayOfInt[1] == -1) && (arrayOfInt[0] == -1) && (arrayOfInt[2] == -1) && (arrayOfInt[3] == -1)) {
      i4 = i9;
    } else {
      i4 = Math.max(i9, Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))) + Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))));
    }
    i9 = i5;
    i10 = i4;
    if (bool2) {
      if (i19 != -2147483648)
      {
        i10 = i4;
        if (i19 != 0) {}
      }
      else
      {
        this.f = 0;
        i5 = 0;
        for (;;)
        {
          i10 = i4;
          if (i5 >= i12) {
            break;
          }
          localView = s(i5);
          if (localView == null)
          {
            this.f += y(i5);
          }
          else
          {
            if (localView.getVisibility() != 8) {
              break label1118;
            }
            i5 += p(localView, i5);
          }
          for (;;)
          {
            break;
            label1118:
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            i10 = this.f;
            if (i11 != 0) {
              this.f = (i10 + (localLayoutParams.leftMargin + i3 + localLayoutParams.rightMargin + r(localView)));
            } else {
              this.f = Math.max(i10, i10 + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + r(localView));
            }
          }
          i5 += 1;
        }
      }
    }
    i4 = this.f + (getPaddingLeft() + getPaddingRight());
    this.f = i4;
    int i14 = View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumWidth()), paramInt1, 0);
    int i13 = (0xFFFFFF & i14) - this.f;
    if ((i8 == 0) && ((i13 == 0) || (f1 <= 0.0F)))
    {
      i5 = Math.max(i2, i7);
      if ((bool2) && (i19 != 1073741824))
      {
        i2 = 0;
        while (i2 < i12)
        {
          localObject = s(i2);
          if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).weight > 0.0F)) {
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824));
          }
          i2 += 1;
        }
      }
      i4 = i12;
      i3 = i10;
      i2 = i5;
    }
    else
    {
      f2 = this.g;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      arrayOfInt[3] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[0] = -1;
      localObject[3] = -1;
      localObject[2] = -1;
      localObject[1] = -1;
      localObject[0] = -1;
      this.f = 0;
      i8 = -1;
      i3 = i9;
      i9 = 0;
      i5 = i1;
      i4 = i12;
      i1 = i3;
      i7 = i2;
      i2 = i13;
      while (i9 < i4)
      {
        localView = s(i9);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = localLayoutParams.weight;
          if (f2 > 0.0F)
          {
            i10 = (int)(i2 * f2 / f1);
            i13 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height);
            if ((localLayoutParams.width == 0) && (i19 == 1073741824))
            {
              if (i10 > 0)
              {
                i3 = i10;
                break label1644;
              }
            }
            else
            {
              i12 = localView.getMeasuredWidth() + i10;
              i3 = i12;
              if (i12 >= 0) {
                break label1644;
              }
            }
            i3 = 0;
            label1644:
            localView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i13);
            i1 = View.combineMeasuredStates(i1, localView.getMeasuredState() & 0xFF000000);
            f1 -= f2;
            i2 -= i10;
          }
          i3 = this.f;
          if (i11 != 0) {
            this.f = (i3 + (localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + r(localView)));
          } else {
            this.f = Math.max(i3, localView.getMeasuredWidth() + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + r(localView));
          }
          if ((i18 != 1073741824) && (localLayoutParams.height == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i12 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i10 = localView.getMeasuredHeight() + i12;
          i8 = Math.max(i8, i10);
          if (i3 != 0) {
            i3 = i12;
          } else {
            i3 = i10;
          }
          i7 = Math.max(i7, i3);
          if ((i5 != 0) && (localLayoutParams.height == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (bool1)
          {
            i13 = localView.getBaseline();
            if (i13 != -1)
            {
              i12 = localLayoutParams.gravity;
              i5 = i12;
              if (i12 < 0) {
                i5 = this.e;
              }
              i5 = ((i5 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt[i5] = Math.max(arrayOfInt[i5], i13);
              localObject[i5] = Math.max(localObject[i5], i10 - i13);
            }
          }
          i5 = i3;
        }
        i9 += 1;
      }
      this.f += getPaddingLeft() + getPaddingRight();
      if ((arrayOfInt[1] == -1) && (arrayOfInt[0] == -1) && (arrayOfInt[2] == -1) && (arrayOfInt[3] == -1)) {
        i2 = i8;
      } else {
        i2 = Math.max(i8, Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))) + Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))));
      }
      i9 = i1;
      i1 = i5;
      i3 = i2;
      i2 = i7;
    }
    if ((i1 != 0) || (i18 == 1073741824)) {
      i2 = i3;
    }
    setMeasuredDimension(i14 | i9 & 0xFF000000, View.resolveSizeAndState(Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, i9 << 16));
    if (i6 != 0) {
      k(i4, paramInt1);
    }
  }
  
  int y(int paramInt)
  {
    return 0;
  }
  
  void z(int paramInt1, int paramInt2)
  {
    this.f = 0;
    int i8 = getVirtualChildCount();
    int i16 = View.MeasureSpec.getMode(paramInt1);
    int i11 = View.MeasureSpec.getMode(paramInt2);
    int i17 = this.b;
    boolean bool = this.h;
    int i1 = 0;
    int i10 = i1;
    int i5 = i10;
    int i2 = i5;
    int i4 = i2;
    int i6 = i4;
    int i9 = i6;
    int i7 = i9;
    float f1 = 0.0F;
    int i3 = 1;
    View localView;
    LayoutParams localLayoutParams;
    float f2;
    int i14;
    int i15;
    while (i6 < i8)
    {
      localView = s(i6);
      if (localView == null)
      {
        this.f += y(i6);
      }
      else if (localView.getVisibility() == 8)
      {
        i6 += p(localView, i6);
      }
      else
      {
        if (t(i6)) {
          this.f += this.m;
        }
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        f2 = localLayoutParams.weight;
        f1 += f2;
        if ((i11 == 1073741824) && (localLayoutParams.height == 0) && (f2 > 0.0F))
        {
          i9 = this.f;
          this.f = Math.max(i9, localLayoutParams.topMargin + i9 + localLayoutParams.bottomMargin);
          i9 = 1;
        }
        else
        {
          if ((localLayoutParams.height == 0) && (f2 > 0.0F))
          {
            localLayoutParams.height = -2;
            i12 = 0;
          }
          else
          {
            i12 = -2147483648;
          }
          if (f1 == 0.0F) {
            i13 = this.f;
          } else {
            i13 = 0;
          }
          w(localView, i6, paramInt1, 0, paramInt2, i13);
          if (i12 != -2147483648) {
            localLayoutParams.height = i12;
          }
          i12 = localView.getMeasuredHeight();
          i13 = this.f;
          this.f = Math.max(i13, i13 + i12 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + r(localView));
          if (bool) {
            i5 = Math.max(i12, i5);
          }
        }
        i14 = i6;
        if ((i17 >= 0) && (i17 == i14 + 1)) {
          this.c = this.f;
        }
        if ((i14 < i17) && (localLayoutParams.weight > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        if ((i16 != 1073741824) && (localLayoutParams.width == -1))
        {
          i6 = 1;
          i7 = i6;
        }
        else
        {
          i6 = 0;
        }
        i12 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        i13 = localView.getMeasuredWidth() + i12;
        i10 = Math.max(i10, i13);
        i15 = View.combineMeasuredStates(i1, localView.getMeasuredState());
        if ((i3 != 0) && (localLayoutParams.width == -1)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (localLayoutParams.weight > 0.0F)
        {
          if (i6 == 0) {
            i12 = i13;
          }
          i2 = Math.max(i2, i12);
          i3 = i4;
        }
        else
        {
          if (i6 == 0) {
            i12 = i13;
          }
          i3 = Math.max(i4, i12);
        }
        i6 = p(localView, i14);
        i4 = i3;
        i12 = i15;
        i6 += i14;
        i3 = i1;
        i1 = i12;
      }
      i6 += 1;
    }
    if ((this.f > 0) && (t(i8))) {
      this.f += this.m;
    }
    int i12 = i8;
    if ((bool) && ((i11 == -2147483648) || (i11 == 0)))
    {
      this.f = 0;
      i6 = 0;
      while (i6 < i12)
      {
        localView = s(i6);
        if (localView == null) {}
        for (i8 = this.f + y(i6);; i8 = Math.max(i8, i8 + i5 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + r(localView)))
        {
          this.f = i8;
          break;
          if (localView.getVisibility() == 8)
          {
            i6 += p(localView, i6);
            break;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i8 = this.f;
        }
        i6 += 1;
      }
    }
    i6 = this.f + (getPaddingTop() + getPaddingBottom());
    this.f = i6;
    int i13 = View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), paramInt2, 0);
    i6 = (0xFFFFFF & i13) - this.f;
    if ((i9 == 0) && ((i6 == 0) || (f1 <= 0.0F)))
    {
      i4 = Math.max(i4, i2);
      if ((bool) && (i11 != 1073741824))
      {
        i2 = 0;
        while (i2 < i12)
        {
          localView = s(i2);
          if ((localView != null) && (localView.getVisibility() != 8) && (((LayoutParams)localView.getLayoutParams()).weight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
          }
          i2 += 1;
        }
      }
      i2 = i1;
      i1 = i4;
    }
    else
    {
      f2 = this.g;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      this.f = 0;
      i2 = i6;
      i5 = 0;
      while (i5 < i12)
      {
        localView = s(i5);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = localLayoutParams.weight;
          if (f2 > 0.0F)
          {
            i8 = (int)(i2 * f2 / f1);
            i9 = getPaddingLeft();
            i14 = getPaddingRight();
            i15 = localLayoutParams.leftMargin;
            i17 = localLayoutParams.rightMargin;
            int i18 = localLayoutParams.width;
            i6 = i2 - i8;
            i9 = ViewGroup.getChildMeasureSpec(paramInt1, i9 + i14 + i15 + i17, i18);
            if ((localLayoutParams.height == 0) && (i11 == 1073741824))
            {
              if (i8 > 0)
              {
                i2 = i8;
                break label1208;
              }
            }
            else
            {
              i8 = localView.getMeasuredHeight() + i8;
              i2 = i8;
              if (i8 >= 0) {
                break label1208;
              }
            }
            i2 = 0;
            label1208:
            localView.measure(i9, View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
            i1 = View.combineMeasuredStates(i1, localView.getMeasuredState() & 0xFFFFFF00);
            f1 -= f2;
            i2 = i6;
          }
          i8 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          i9 = localView.getMeasuredWidth() + i8;
          i10 = Math.max(i10, i9);
          if ((i16 != 1073741824) && (localLayoutParams.width == -1)) {
            i6 = 1;
          } else {
            i6 = 0;
          }
          if (i6 != 0) {
            i6 = i8;
          } else {
            i6 = i9;
          }
          i4 = Math.max(i4, i6);
          if ((i3 != 0) && (localLayoutParams.width == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i6 = this.f;
          this.f = Math.max(i6, localView.getMeasuredHeight() + i6 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + r(localView));
        }
        i5 += 1;
      }
      this.f += getPaddingTop() + getPaddingBottom();
      i2 = i1;
      i1 = i4;
    }
    if ((i3 != 0) || (i16 == 1073741824)) {
      i1 = i10;
    }
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, i2), i13);
    if (i7 != 0) {
      l(i12, paramInt2);
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0.1
 */