package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R.attr;
import com.google.android.material.R.layout;

public class Snackbar
  extends BaseTransientBottomBar<Snackbar>
{
  private static final int[] y;
  private static final int[] z;
  private final AccessibilityManager w;
  private boolean x;
  
  static
  {
    int i = R.attr.snackbarButtonStyle;
    y = new int[] { i };
    z = new int[] { i, R.attr.snackbarTextViewStyle };
  }
  
  private Snackbar(Context paramContext, ViewGroup paramViewGroup, View paramView, a parama)
  {
    super(paramContext, paramViewGroup, paramView, parama);
    this.w = ((AccessibilityManager)paramViewGroup.getContext().getSystemService("accessibility"));
  }
  
  private static ViewGroup X(View paramView)
  {
    Object localObject2 = null;
    View localView = paramView;
    Object localObject1;
    do
    {
      if ((localView instanceof CoordinatorLayout)) {
        return (ViewGroup)localView;
      }
      localObject1 = localObject2;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290) {
          return (ViewGroup)localView;
        }
        localObject1 = (ViewGroup)localView;
      }
      paramView = localView;
      if (localView != null)
      {
        paramView = localView.getParent();
        if ((paramView instanceof View)) {
          paramView = (View)paramView;
        } else {
          paramView = null;
        }
      }
      localObject2 = localObject1;
      localView = paramView;
    } while (paramView != null);
    return localObject1;
  }
  
  private SnackbarContentLayout Y()
  {
    return (SnackbarContentLayout)this.c.getChildAt(0);
  }
  
  private TextView Z()
  {
    return Y().getMessageView();
  }
  
  private static boolean a0(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(z);
    boolean bool2 = false;
    int i = paramContext.getResourceId(0, -1);
    int j = paramContext.getResourceId(1, -1);
    paramContext.recycle();
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Snackbar b0(View paramView, int paramInt1, int paramInt2)
  {
    return c0(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  public static Snackbar c0(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    return d0(null, paramView, paramCharSequence, paramInt);
  }
  
  private static Snackbar d0(Context paramContext, View paramView, CharSequence paramCharSequence, int paramInt)
  {
    ViewGroup localViewGroup = X(paramView);
    if (localViewGroup != null)
    {
      paramView = paramContext;
      if (paramContext == null) {
        paramView = localViewGroup.getContext();
      }
      paramContext = LayoutInflater.from(paramView);
      int i;
      if (a0(paramView)) {
        i = R.layout.mtrl_layout_snackbar_include;
      } else {
        i = R.layout.design_layout_snackbar_include;
      }
      paramContext = (SnackbarContentLayout)paramContext.inflate(i, localViewGroup, false);
      paramContext = new Snackbar(paramView, localViewGroup, paramContext, paramContext);
      paramContext.e0(paramCharSequence);
      paramContext.L(paramInt);
      return paramContext;
    }
    throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
  }
  
  public void P()
  {
    super.P();
  }
  
  public Snackbar e0(CharSequence paramCharSequence)
  {
    Z().setText(paramCharSequence);
    return this;
  }
  
  public void q()
  {
    super.q();
  }
  
  public int u()
  {
    int j = super.u();
    if (j == -2) {
      return -2;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (this.x) {
        i = 4;
      } else {
        i = 0;
      }
      return this.w.getRecommendedTimeoutMillis(j, i | 0x1 | 0x2);
    }
    int i = j;
    if (this.x)
    {
      i = j;
      if (this.w.isTouchExplorationEnabled()) {
        i = -2;
      }
    }
    return i;
  }
  
  public static final class SnackbarLayout
    extends BaseTransientBottomBar.s
  {
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      paramInt2 = getChildCount();
      int i = getMeasuredWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        View localView = getChildAt(paramInt1);
        if (localView.getLayoutParams().width == -1) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.snackbar.Snackbar
 * JD-Core Version:    0.7.0.1
 */