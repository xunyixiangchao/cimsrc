package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.x;
import com.google.android.material.R.animator;
import e7.h;
import e7.j;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  private Map<View, Integer> i;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g0(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int m = ((ViewGroup)localObject).getChildCount();
    if (paramBoolean) {
      this.i = new HashMap(m);
    }
    int j = 0;
    while (j < m)
    {
      View localView = ((ViewGroup)localObject).getChildAt(j);
      int k;
      if (((localView.getLayoutParams() instanceof CoordinatorLayout.e)) && ((((CoordinatorLayout.e)localView.getLayoutParams()).f() instanceof FabTransformationScrimBehavior))) {
        k = 1;
      } else {
        k = 0;
      }
      if ((localView != paramView) && (k == 0))
      {
        Map localMap = this.i;
        if (!paramBoolean)
        {
          if ((localMap == null) || (!localMap.containsKey(localView))) {
            break label190;
          }
          k = ((Integer)this.i.get(localView)).intValue();
        }
        else
        {
          localMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          k = 4;
        }
        x.B0(localView, k);
      }
      label190:
      j += 1;
    }
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  protected boolean H(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    g0(paramView2, paramBoolean1);
    return super.H(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
  
  protected FabTransformationBehavior.e e0(Context paramContext, boolean paramBoolean)
  {
    int j;
    if (paramBoolean) {
      j = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      j = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    }
    FabTransformationBehavior.e locale = new FabTransformationBehavior.e();
    locale.a = h.d(paramContext, j);
    locale.b = new j(17, 0.0F, 0.0F);
    return locale;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.transformation.FabTransformationSheetBehavior
 * JD-Core Version:    0.7.0.1
 */