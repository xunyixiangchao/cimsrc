package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.view.x;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.d;
import com.google.android.material.chip.Chip;

class TimePickerView
  extends ConstraintLayout
{
  private final ClockHandView A;
  private final ClockFaceView B;
  private final MaterialButtonToggleGroup C;
  private final View.OnClickListener E = new a();
  private f F;
  private g G;
  private e H;
  private final Chip y;
  private final Chip z;
  
  public TimePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.material_timepicker, this);
    this.B = ((ClockFaceView)findViewById(R.id.material_clock_face));
    paramContext = (MaterialButtonToggleGroup)findViewById(R.id.material_clock_period_toggle);
    this.C = paramContext;
    paramContext.b(new b());
    this.y = ((Chip)findViewById(R.id.material_minute_tv));
    this.z = ((Chip)findViewById(R.id.material_hour_tv));
    this.A = ((ClockHandView)findViewById(R.id.material_clock_hand));
    F();
    E();
  }
  
  private void E()
  {
    Chip localChip = this.y;
    int i = R.id.selection_type;
    localChip.setTag(i, Integer.valueOf(12));
    this.z.setTag(i, Integer.valueOf(10));
    this.y.setOnClickListener(this.E);
    this.z.setOnClickListener(this.E);
    this.y.setAccessibilityClassName("android.view.View");
    this.z.setAccessibilityClassName("android.view.View");
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void F()
  {
    d locald = new d(new GestureDetector(getContext(), new c()));
    this.y.setOnTouchListener(locald);
    this.z.setOnTouchListener(locald);
  }
  
  private void G()
  {
    if (this.C.getVisibility() == 0)
    {
      c localc = new c();
      localc.p(this);
      int i = x.B(this);
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        j = 2;
      }
      localc.n(R.id.material_clock_display, j);
      localc.i(this);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    G();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramView == this) && (paramInt == 0)) {
      G();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (TimePickerView.B(TimePickerView.this) != null) {
        TimePickerView.B(TimePickerView.this).a(((Integer)paramView.getTag(R.id.selection_type)).intValue());
      }
    }
  }
  
  class b
    implements MaterialButtonToggleGroup.d
  {
    b() {}
    
    public void a(MaterialButtonToggleGroup paramMaterialButtonToggleGroup, int paramInt, boolean paramBoolean)
    {
      if (paramInt == R.id.material_clock_period_pm_button) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((TimePickerView.C(TimePickerView.this) != null) && (paramBoolean)) {
        TimePickerView.C(TimePickerView.this).a(paramInt);
      }
    }
  }
  
  class c
    extends GestureDetector.SimpleOnGestureListener
  {
    c() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = TimePickerView.D(TimePickerView.this);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.a();
        return true;
      }
      return false;
    }
  }
  
  class d
    implements View.OnTouchListener
  {
    d(GestureDetector paramGestureDetector) {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (((Checkable)paramView).isChecked()) {
        return this.a.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
  }
  
  static abstract interface e
  {
    public abstract void a();
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt);
  }
  
  static abstract interface g
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView
 * JD-Core Version:    0.7.0.1
 */