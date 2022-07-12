package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.fragment.R.styleable;
import java.util.ArrayList;

public final class FragmentContainerView
  extends FrameLayout
{
  private ArrayList<View> a;
  private ArrayList<View> b;
  private View.OnApplyWindowInsetsListener c;
  private boolean d = true;
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      Object localObject = paramAttributeSet.getClassAttribute();
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FragmentContainerView);
      if (localObject == null)
      {
        paramAttributeSet = localTypedArray.getString(R.styleable.FragmentContainerView_android_name);
        paramContext = "android:name";
      }
      else
      {
        paramContext = "class";
        paramAttributeSet = (AttributeSet)localObject;
      }
      localTypedArray.recycle();
      if (paramAttributeSet != null)
      {
        if (isInEditMode()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FragmentContainerView must be within a FragmentActivity to use ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("=\"");
        ((StringBuilder)localObject).append(paramAttributeSet);
        ((StringBuilder)localObject).append("\"");
        throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, FragmentManager paramFragmentManager)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getClassAttribute();
    Object localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FragmentContainerView);
    Object localObject1 = str;
    if (str == null) {
      localObject1 = ((TypedArray)localObject2).getString(R.styleable.FragmentContainerView_android_name);
    }
    str = ((TypedArray)localObject2).getString(R.styleable.FragmentContainerView_android_tag);
    ((TypedArray)localObject2).recycle();
    int i = getId();
    localObject2 = paramFragmentManager.i0(i);
    if ((localObject1 != null) && (localObject2 == null))
    {
      if (i <= 0)
      {
        if (str != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(" with tag ");
          paramContext.append(str);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("FragmentContainerView must have an android:id to add Fragment ");
        paramAttributeSet.append((String)localObject1);
        paramAttributeSet.append(paramContext);
        throw new IllegalStateException(paramAttributeSet.toString());
      }
      localObject1 = paramFragmentManager.r0().a(paramContext.getClassLoader(), (String)localObject1);
      ((Fragment)localObject1).onInflate(paramContext, paramAttributeSet, null);
      paramFragmentManager.m().q(true).c(this, (Fragment)localObject1, str).j();
    }
    paramFragmentManager.V0(this);
  }
  
  private void a(View paramView)
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (localArrayList.contains(paramView)))
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      this.a.add(paramView);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (FragmentManager.A0(paramView) != null)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (FragmentManager.A0(paramView) != null) {
      return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public WindowInsets dispatchApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    h0 localh0 = h0.w(paramWindowInsets);
    View.OnApplyWindowInsetsListener localOnApplyWindowInsetsListener = this.c;
    if (localOnApplyWindowInsetsListener != null) {
      localh0 = h0.w(localOnApplyWindowInsetsListener.onApplyWindowInsets(this, paramWindowInsets));
    } else {
      localh0 = x.c0(this, localh0);
    }
    if (!localh0.p())
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        x.g(getChildAt(i), localh0);
        i += 1;
      }
    }
    return paramWindowInsets;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.d) && (this.a != null))
    {
      int i = 0;
      while (i < this.a.size())
      {
        super.drawChild(paramCanvas, (View)this.a.get(i), getDrawingTime());
        i += 1;
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (this.d)
    {
      ArrayList localArrayList = this.a;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (this.a.contains(paramView))) {
        return false;
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void endViewTransition(View paramView)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null)
    {
      localArrayList.remove(paramView);
      localArrayList = this.a;
      if ((localArrayList != null) && (localArrayList.remove(paramView))) {
        this.d = true;
      }
    }
    super.endViewTransition(paramView);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    return paramWindowInsets;
  }
  
  public void removeAllViewsInLayout()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      a(getChildAt(i));
      i -= 1;
    }
    super.removeAllViewsInLayout();
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramView);
    }
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeView(View paramView)
  {
    a(paramView);
    super.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    a(getChildAt(paramInt));
    super.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(View paramView)
  {
    a(paramView);
    super.removeViewInLayout(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(getChildAt(i));
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(getChildAt(i));
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
  }
  
  public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    this.c = paramOnApplyWindowInsetsListener;
  }
  
  public void startViewTransition(View paramView)
  {
    if (paramView.getParent() == this)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(paramView);
    }
    super.startViewTransition(paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentContainerView
 * JD-Core Version:    0.7.0.1
 */