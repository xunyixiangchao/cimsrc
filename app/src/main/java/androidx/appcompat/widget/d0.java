package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.app.ActionBar.b;
import g.a;

public class d0
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator j = new DecelerateInterpolator();
  Runnable a;
  private c b;
  LinearLayoutCompat c;
  private Spinner d;
  private boolean e;
  int f;
  int g;
  private int h;
  private int i;
  
  private Spinner b()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  private boolean d()
  {
    Spinner localSpinner = this.d;
    return (localSpinner != null) && (localSpinner.getParent() == this);
  }
  
  private void e()
  {
    if (d()) {
      return;
    }
    if (this.d == null) {
      this.d = b();
    }
    removeView(this.c);
    addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    if (this.d.getAdapter() == null) {
      this.d.setAdapter(new b());
    }
    Runnable localRunnable = this.a;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      this.a = null;
    }
    this.d.setSelection(this.i);
  }
  
  private boolean f()
  {
    if (!d()) {
      return false;
    }
    removeView(this.d);
    addView(this.c, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.d.getSelectedItemPosition());
    return false;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.c.getChildAt(paramInt);
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    localObject = new a((View)localObject);
    this.a = ((Runnable)localObject);
    post((Runnable)localObject);
  }
  
  d c(ActionBar.b paramb, boolean paramBoolean)
  {
    paramb = new d(getContext(), paramb, paramBoolean);
    if (paramBoolean)
    {
      paramb.setBackgroundDrawable(null);
      paramb.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
      return paramb;
    }
    paramb.setFocusable(true);
    if (this.b == null) {
      this.b = new c();
    }
    paramb.setOnClickListener(this.b);
    return paramb;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.b(getContext());
    setContentHeight(paramConfiguration.f());
    this.g = paramConfiguration.e();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((d)paramView).b().e();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getMode(paramInt1);
    int k = 1;
    boolean bool;
    if (paramInt2 == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int m = this.c.getChildCount();
    if ((m > 1) && ((paramInt2 == 1073741824) || (paramInt2 == -2147483648)))
    {
      if (m > 2) {
        this.f = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      } else {
        this.f = (View.MeasureSpec.getSize(paramInt1) / 2);
      }
      paramInt2 = Math.min(this.f, this.g);
    }
    else
    {
      paramInt2 = -1;
    }
    this.f = paramInt2;
    m = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
    if ((!bool) && (this.e)) {
      paramInt2 = k;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      this.c.measure(0, m);
      if (this.c.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1))
      {
        e();
        break label179;
      }
    }
    f();
    label179:
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, m);
    paramInt1 = getMeasuredWidth();
    if ((bool) && (paramInt2 != paramInt1)) {
      setTabSelected(this.i);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.i = paramInt;
    int m = this.c.getChildCount();
    int k = 0;
    while (k < m)
    {
      localObject = this.c.getChildAt(k);
      boolean bool;
      if (k == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject).setSelected(bool);
      if (bool) {
        a(paramInt);
      }
      k += 1;
    }
    Object localObject = this.d;
    if ((localObject != null) && (paramInt >= 0)) {
      ((Spinner)localObject).setSelection(paramInt);
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView) {}
    
    public void run()
    {
      int i = this.a.getLeft();
      int j = (d0.this.getWidth() - this.a.getWidth()) / 2;
      d0.this.smoothScrollTo(i - j, 0);
      d0.this.a = null;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    b() {}
    
    public int getCount()
    {
      return d0.this.c.getChildCount();
    }
    
    public Object getItem(int paramInt)
    {
      return ((d0.d)d0.this.c.getChildAt(paramInt)).b();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return d0.this.c((ActionBar.b)getItem(paramInt), true);
      }
      ((d0.d)paramView).a((ActionBar.b)getItem(paramInt));
      return paramView;
    }
  }
  
  private class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      ((d0.d)paramView).b().e();
      int j = d0.this.c.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = d0.this.c.getChildAt(i);
        boolean bool;
        if (localView == paramView) {
          bool = true;
        } else {
          bool = false;
        }
        localView.setSelected(bool);
        i += 1;
      }
    }
  }
  
  private class d
    extends LinearLayout
  {
    private final int[] a;
    private ActionBar.b b;
    private TextView c;
    private ImageView d;
    private View e;
    
    public d(Context paramContext, ActionBar.b paramb, boolean paramBoolean)
    {
      super(null, i);
      this$1 = new int[1];
      d0.this[0] = 16842964;
      this.a = d0.this;
      this.b = paramb;
      this$1 = k0.v(paramContext, null, d0.this, i, 0);
      if (d0.this.s(0)) {
        setBackgroundDrawable(d0.this.g(0));
      }
      d0.this.w();
      if (paramBoolean) {
        setGravity(8388627);
      }
      c();
    }
    
    public void a(ActionBar.b paramb)
    {
      this.b = paramb;
      c();
    }
    
    public ActionBar.b b()
    {
      return this.b;
    }
    
    public void c()
    {
      ActionBar.b localb = this.b;
      Object localObject2 = localb.b();
      Object localObject1 = null;
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.e = ((View)localObject2);
        localObject1 = this.c;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.d;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          this.d.setImageDrawable(null);
        }
      }
      else
      {
        localObject2 = this.e;
        if (localObject2 != null)
        {
          removeView((View)localObject2);
          this.e = null;
        }
        Object localObject3 = localb.c();
        localObject2 = localb.d();
        Object localObject4;
        if (localObject3 != null)
        {
          if (this.d == null)
          {
            localObject4 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.gravity = 16;
            ((ImageView)localObject4).setLayoutParams(localLayoutParams);
            addView((View)localObject4, 0);
            this.d = ((ImageView)localObject4);
          }
          this.d.setImageDrawable((Drawable)localObject3);
          this.d.setVisibility(0);
        }
        else
        {
          localObject3 = this.d;
          if (localObject3 != null)
          {
            ((ImageView)localObject3).setVisibility(8);
            this.d.setImageDrawable(null);
          }
        }
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
        if (bool)
        {
          if (this.c == null)
          {
            localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).gravity = 16;
            ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            addView((View)localObject3);
            this.c = ((TextView)localObject3);
          }
          this.c.setText((CharSequence)localObject2);
          this.c.setVisibility(0);
        }
        else
        {
          localObject2 = this.c;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(8);
            this.c.setText(null);
          }
        }
        localObject2 = this.d;
        if (localObject2 != null) {
          ((ImageView)localObject2).setContentDescription(localb.a());
        }
        if (!bool) {
          localObject1 = localb.a();
        }
        n0.a(this, (CharSequence)localObject1);
      }
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (d0.this.f > 0)
      {
        paramInt1 = getMeasuredWidth();
        int i = d0.this.f;
        if (paramInt1 > i) {
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), paramInt2);
        }
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.d0
 * JD-Core Version:    0.7.0.1
 */