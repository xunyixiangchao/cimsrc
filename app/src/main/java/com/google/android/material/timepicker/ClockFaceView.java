package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import java.util.Arrays;
import o7.c;
import y0.d;
import y0.d.a;
import y0.d.b;
import y0.d.c;

class ClockFaceView
  extends RadialViewGroup
  implements ClockHandView.d
{
  private final ClockHandView B;
  private final Rect C = new Rect();
  private final RectF E = new RectF();
  private final SparseArray<TextView> F = new SparseArray();
  private final androidx.core.view.a G;
  private final int[] H;
  private final float[] I = { 0.0F, 0.9F, 1.0F };
  private final int J;
  private final int K;
  private final int L;
  private final int M;
  private String[] N;
  private float O;
  private final ColorStateList P;
  
  public ClockFaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialClockStyle);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public ClockFaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ClockFaceView, paramInt, R.style.Widget_MaterialComponents_TimePicker_Clock);
    paramAttributeSet = getResources();
    ColorStateList localColorStateList = c.a(paramContext, localTypedArray, R.styleable.ClockFaceView_clockNumberTextColor);
    this.P = localColorStateList;
    LayoutInflater.from(paramContext).inflate(R.layout.material_clockface_view, this, true);
    ClockHandView localClockHandView = (ClockHandView)findViewById(R.id.material_clock_hand);
    this.B = localClockHandView;
    this.J = paramAttributeSet.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
    paramInt = localColorStateList.getDefaultColor();
    paramInt = localColorStateList.getColorForState(new int[] { 16842913 }, paramInt);
    this.H = new int[] { paramInt, paramInt, localColorStateList.getDefaultColor() };
    localClockHandView.b(this);
    paramInt = c.a.a(paramContext, R.color.material_timepicker_clockface).getDefaultColor();
    paramContext = c.a(paramContext, localTypedArray, R.styleable.ClockFaceView_clockFaceBackgroundColor);
    if (paramContext != null) {
      paramInt = paramContext.getDefaultColor();
    }
    setBackgroundColor(paramInt);
    getViewTreeObserver().addOnPreDrawListener(new a());
    setFocusable(true);
    localTypedArray.recycle();
    this.G = new b();
    paramContext = new String[12];
    Arrays.fill(paramContext, "");
    N(paramContext, 0);
    this.K = paramAttributeSet.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
    this.L = paramAttributeSet.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
    this.M = paramAttributeSet.getDimensionPixelSize(R.dimen.material_clock_size);
  }
  
  private void K()
  {
    RectF localRectF = this.B.d();
    int i = 0;
    while (i < this.F.size())
    {
      TextView localTextView = (TextView)this.F.get(i);
      if (localTextView != null)
      {
        localTextView.getDrawingRect(this.C);
        offsetDescendantRectToMyCoords(localTextView, this.C);
        localTextView.setSelected(localRectF.contains(this.C.centerX(), this.C.centerY()));
        RadialGradient localRadialGradient = L(localRectF, this.C, localTextView);
        localTextView.getPaint().setShader(localRadialGradient);
        localTextView.invalidate();
      }
      i += 1;
    }
  }
  
  private RadialGradient L(RectF paramRectF, Rect paramRect, TextView paramTextView)
  {
    this.E.set(paramRect);
    this.E.offset(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop());
    if (!RectF.intersects(paramRectF, this.E)) {
      return null;
    }
    return new RadialGradient(paramRectF.centerX() - this.E.left, paramRectF.centerY() - this.E.top, paramRectF.width() * 0.5F, this.H, this.I, Shader.TileMode.CLAMP);
  }
  
  private static float M(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  private void O(int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    int j = this.F.size();
    int i = 0;
    while (i < Math.max(this.N.length, j))
    {
      TextView localTextView2 = (TextView)this.F.get(i);
      if (i >= this.N.length)
      {
        removeView(localTextView2);
        this.F.remove(i);
      }
      else
      {
        TextView localTextView1 = localTextView2;
        if (localTextView2 == null)
        {
          localTextView1 = (TextView)localLayoutInflater.inflate(R.layout.material_clockface_textview, this, false);
          this.F.put(i, localTextView1);
          addView(localTextView1);
        }
        localTextView1.setVisibility(0);
        localTextView1.setText(this.N[i]);
        localTextView1.setTag(R.id.material_value_index, Integer.valueOf(i));
        x.q0(localTextView1, this.G);
        localTextView1.setTextColor(this.P);
        if (paramInt != 0) {
          localTextView1.setContentDescription(getResources().getString(paramInt, new Object[] { this.N[i] }));
        }
      }
      i += 1;
    }
  }
  
  public void D(int paramInt)
  {
    if (paramInt != C())
    {
      super.D(paramInt);
      this.B.j(C());
    }
  }
  
  public void N(String[] paramArrayOfString, int paramInt)
  {
    this.N = paramArrayOfString;
    O(paramInt);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (Math.abs(this.O - paramFloat) > 0.001F)
    {
      this.O = paramFloat;
      K();
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    d.J0(paramAccessibilityNodeInfo).e0(d.b.b(1, this.N.length, false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    K();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f1 = localDisplayMetrics.heightPixels;
    float f2 = localDisplayMetrics.widthPixels;
    paramInt1 = (int)(this.M / M(this.K / f1, this.L / f2, 1.0F));
    paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    setMeasuredDimension(paramInt1, paramInt1);
    super.onMeasure(paramInt2, paramInt2);
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      if (!ClockFaceView.this.isShown()) {
        return true;
      }
      ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
      int i = ClockFaceView.this.getHeight() / 2;
      int j = ClockFaceView.H(ClockFaceView.this).g();
      int k = ClockFaceView.I(ClockFaceView.this);
      ClockFaceView.this.D(i - j - k);
      return true;
    }
  }
  
  class b
    extends androidx.core.view.a
  {
    b() {}
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      int i = ((Integer)paramView.getTag(R.id.material_value_index)).intValue();
      if (i > 0) {
        paramd.G0((View)ClockFaceView.J(ClockFaceView.this).get(i - 1));
      }
      paramd.f0(d.c.a(0, 1, i, 1, false, paramView.isSelected()));
      paramd.d0(true);
      paramd.b(d.a.i);
    }
    
    public boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      if (paramInt == 16)
      {
        long l = SystemClock.uptimeMillis();
        float f1 = paramView.getX() + paramView.getWidth() / 2.0F;
        float f2 = paramView.getY();
        f2 = paramView.getHeight() / 2.0F + f2;
        ClockFaceView.H(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(l, l, 0, f1, f2, 0));
        ClockFaceView.H(ClockFaceView.this).onTouchEvent(MotionEvent.obtain(l, l, 1, f1, f2, 0));
        return true;
      }
      return super.j(paramView, paramInt, paramBundle);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.ClockFaceView
 * JD-Core Version:    0.7.0.1
 */