package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.e;
import androidx.core.view.x;
import g.b;

public class ActionBarContextView
  extends a
{
  private CharSequence i;
  private CharSequence j;
  private View k;
  private View l;
  private View m;
  private LinearLayout n;
  private TextView o;
  private TextView p;
  private int q;
  private int r;
  private boolean s;
  private int t;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = k0.v(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    x.u0(this, paramContext.g(R.styleable.ActionMode_background));
    this.q = paramContext.n(R.styleable.ActionMode_titleTextStyle, 0);
    this.r = paramContext.n(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.e = paramContext.m(R.styleable.ActionMode_height, 0);
    this.t = paramContext.n(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    paramContext.w();
  }
  
  private void i()
  {
    if (this.n == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      localObject = (LinearLayout)getChildAt(getChildCount() - 1);
      this.n = ((LinearLayout)localObject);
      this.o = ((TextView)((LinearLayout)localObject).findViewById(R.id.action_bar_title));
      this.p = ((TextView)this.n.findViewById(R.id.action_bar_subtitle));
      if (this.q != 0) {
        this.o.setTextAppearance(getContext(), this.q);
      }
      if (this.r != 0) {
        this.p.setTextAppearance(getContext(), this.r);
      }
    }
    this.o.setText(this.i);
    this.p.setText(this.j);
    boolean bool2 = TextUtils.isEmpty(this.i);
    boolean bool1 = TextUtils.isEmpty(this.j) ^ true;
    Object localObject = this.p;
    int i2 = 0;
    if (bool1) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    localObject = this.n;
    int i1 = i2;
    if (!(bool2 ^ true)) {
      if (bool1) {
        i1 = i2;
      } else {
        i1 = 8;
      }
    }
    ((LinearLayout)localObject).setVisibility(i1);
    if (this.n.getParent() == null) {
      addView(this.n);
    }
  }
  
  public void g()
  {
    if (this.k == null) {
      k();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.j;
  }
  
  public CharSequence getTitle()
  {
    return this.i;
  }
  
  public void h(final b paramb)
  {
    Object localObject = this.k;
    if (localObject == null)
    {
      localObject = LayoutInflater.from(getContext()).inflate(this.t, this, false);
      this.k = ((View)localObject);
    }
    for (;;)
    {
      addView((View)localObject);
      break;
      if (((View)localObject).getParent() != null) {
        break;
      }
      localObject = this.k;
    }
    localObject = this.k.findViewById(R.id.action_mode_close_button);
    this.l = ((View)localObject);
    ((View)localObject).setOnClickListener(new a(paramb));
    paramb = (e)paramb.e();
    localObject = this.d;
    if (localObject != null) {
      ((ActionMenuPresenter)localObject).B();
    }
    localObject = new ActionMenuPresenter(getContext());
    this.d = ((ActionMenuPresenter)localObject);
    ((ActionMenuPresenter)localObject).M(true);
    localObject = new ViewGroup.LayoutParams(-2, -1);
    paramb.c(this.d, this.b);
    paramb = (ActionMenuView)this.d.r(this);
    this.c = paramb;
    x.u0(paramb, null);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean j()
  {
    return this.s;
  }
  
  public void k()
  {
    removeAllViews();
    this.m = null;
    this.c = null;
    this.d = null;
    View localView = this.l;
    if (localView != null) {
      localView.setOnClickListener(null);
    }
  }
  
  public boolean l()
  {
    ActionMenuPresenter localActionMenuPresenter = this.d;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.N();
    }
    return false;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ActionMenuPresenter localActionMenuPresenter = this.d;
    if (localActionMenuPresenter != null)
    {
      localActionMenuPresenter.E();
      this.d.F();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = r0.b(this);
    int i1;
    if (paramBoolean) {
      i1 = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i1 = getPaddingLeft();
    }
    int i2 = getPaddingTop();
    int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    Object localObject = this.k;
    paramInt2 = i1;
    if (localObject != null)
    {
      paramInt2 = i1;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
        if (paramBoolean) {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        } else {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        if (paramBoolean) {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        } else {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        paramInt2 = a.d(i1, paramInt2, paramBoolean);
        paramInt2 = a.d(paramInt2 + e(this.k, paramInt2, i2, i3, paramBoolean), paramInt4, paramBoolean);
      }
    }
    localObject = this.n;
    paramInt4 = paramInt2;
    if (localObject != null)
    {
      paramInt4 = paramInt2;
      if (this.m == null)
      {
        paramInt4 = paramInt2;
        if (((LinearLayout)localObject).getVisibility() != 8) {
          paramInt4 = paramInt2 + e(this.n, paramInt2, i2, i3, paramBoolean);
        }
      }
    }
    localObject = this.m;
    if (localObject != null) {
      e((View)localObject, paramInt4, i2, i3, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    localObject = this.c;
    if (localObject != null) {
      e((View)localObject, paramInt1, i2, i3, paramBoolean ^ true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i3 = 1073741824;
    if (i1 == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int i6 = View.MeasureSpec.getSize(paramInt1);
        i1 = this.e;
        if (i1 <= 0) {
          i1 = View.MeasureSpec.getSize(paramInt2);
        }
        int i7 = getPaddingTop() + getPaddingBottom();
        paramInt1 = i6 - getPaddingLeft() - getPaddingRight();
        int i5 = i1 - i7;
        int i2 = View.MeasureSpec.makeMeasureSpec(i5, -2147483648);
        localObject = this.k;
        int i4 = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = c((View)localObject, paramInt1, i2, 0);
          localObject = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
          paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
        }
        localObject = this.c;
        paramInt1 = paramInt2;
        if (localObject != null)
        {
          paramInt1 = paramInt2;
          if (((ViewGroup)localObject).getParent() == this) {
            paramInt1 = c(this.c, paramInt2, i2, 0);
          }
        }
        localObject = this.n;
        paramInt2 = paramInt1;
        int i8;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (this.m == null) {
            if (this.s)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              this.n.measure(paramInt2, i2);
              i8 = this.n.getMeasuredWidth();
              if (i8 <= paramInt1) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              paramInt2 = paramInt1;
              if (i2 != 0) {
                paramInt2 = paramInt1 - i8;
              }
              localObject = this.n;
              if (i2 != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((LinearLayout)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = c((View)localObject, paramInt1, i2, 0);
            }
          }
        }
        localObject = this.m;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          i8 = ((ViewGroup.LayoutParams)localObject).width;
          if (i8 != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = -2147483648;
          }
          i2 = paramInt2;
          if (i8 >= 0) {
            i2 = Math.min(i8, paramInt2);
          }
          i8 = ((ViewGroup.LayoutParams)localObject).height;
          if (i8 != -2) {
            paramInt2 = i3;
          } else {
            paramInt2 = -2147483648;
          }
          i3 = i5;
          if (i8 >= 0) {
            i3 = Math.min(i8, i5);
          }
          this.m.measure(View.MeasureSpec.makeMeasureSpec(i2, paramInt1), View.MeasureSpec.makeMeasureSpec(i3, paramInt2));
        }
        if (this.e <= 0)
        {
          i3 = getChildCount();
          paramInt2 = 0;
          paramInt1 = i4;
          while (paramInt1 < i3)
          {
            i2 = getChildAt(paramInt1).getMeasuredHeight() + i7;
            i1 = paramInt2;
            if (i2 > paramInt2) {
              i1 = i2;
            }
            paramInt1 += 1;
            paramInt2 = i1;
          }
          setMeasuredDimension(i6, paramInt2);
          return;
        }
        setMeasuredDimension(i6, i1);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = this.m;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.m = paramView;
    if (paramView != null)
    {
      localObject = this.n;
      if (localObject != null)
      {
        removeView((View)localObject);
        this.n = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    i();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    i();
    x.t0(this, paramCharSequence);
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.s) {
      requestLayout();
    }
    this.s = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  class a
    implements View.OnClickListener
  {
    a(b paramb) {}
    
    public void onClick(View paramView)
    {
      paramb.c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */