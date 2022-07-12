package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;

public class SnackbarContentLayout
  extends LinearLayout
  implements a
{
  private TextView a;
  private Button b;
  private int c;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void d(View paramView, int paramInt1, int paramInt2)
  {
    if (x.W(paramView))
    {
      x.F0(paramView, x.G(paramView), paramInt1, x.F(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((this.a.getPaddingTop() == paramInt2) && (this.a.getPaddingBottom() == paramInt3)) {
      return bool;
    }
    d(this.a, paramInt2, paramInt3);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.a.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0)
    {
      this.b.setAlpha(0.0F);
      this.b.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.a.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0)
    {
      this.b.setAlpha(1.0F);
      this.b.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  void c(float paramFloat)
  {
    if (paramFloat != 1.0F)
    {
      int i = this.b.getCurrentTextColor();
      i = g7.a.h(g7.a.d(this, R.attr.colorSurface), i, paramFloat);
      this.b.setTextColor(i);
    }
  }
  
  public Button getActionView()
  {
    return this.b;
  }
  
  public TextView getMessageView()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(R.id.snackbar_text));
    this.b = ((Button)findViewById(R.id.snackbar_action));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getOrientation();
    int j = 1;
    if (i == 1) {
      return;
    }
    int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    if (this.a.getLayout().getLineCount() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (this.c > 0) && (this.b.getMeasuredWidth() > this.c))
    {
      if (e(1, k, k - m))
      {
        i = j;
        break label142;
      }
    }
    else
    {
      if (i != 0) {
        i = k;
      } else {
        i = m;
      }
      if (e(0, i, i))
      {
        i = j;
        break label142;
      }
    }
    i = 0;
    label142:
    if (i != 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public void setMaxInlineActionWidth(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */