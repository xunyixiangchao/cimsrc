package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;

public class ButtonBarLayout
  extends LinearLayout
{
  private boolean a;
  private boolean b;
  private int c = -1;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.ButtonBarLayout;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    x.o0(this, paramContext, arrayOfInt, paramAttributeSet, localTypedArray, 0, 0);
    this.a = localTypedArray.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
    localTypedArray.recycle();
    if (getOrientation() == 1) {
      setStacked(this.a);
    }
  }
  
  private int a(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private boolean b()
  {
    return this.b;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    boolean bool = this.a;
    int m = 0;
    if (bool)
    {
      if ((i > this.c) && (b())) {
        setStacked(false);
      }
      this.c = i;
    }
    int j;
    if ((!b()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
      i = 1;
    }
    else
    {
      j = paramInt1;
      i = 0;
    }
    super.onMeasure(j, paramInt2);
    int k = i;
    if (this.a)
    {
      k = i;
      if (!b())
      {
        if ((getMeasuredWidthAndState() & 0xFF000000) == 16777216) {
          j = 1;
        } else {
          j = 0;
        }
        k = i;
        if (j != 0)
        {
          setStacked(true);
          k = 1;
        }
      }
    }
    if (k != 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
    k = a(0);
    i = m;
    if (k >= 0)
    {
      View localView = getChildAt(k);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      j = getPaddingTop() + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0;
      if (b())
      {
        k = a(k + 1);
        i = j;
        if (k >= 0) {
          i = j + (getChildAt(k).getPaddingTop() + (int)(getResources().getDisplayMetrics().density * 16.0F));
        }
      }
      else
      {
        i = j + getPaddingBottom();
      }
    }
    if (x.C(this) != i)
    {
      setMinimumHeight(i);
      if (paramInt2 == 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      if ((!paramBoolean) && (b())) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ButtonBarLayout
 * JD-Core Version:    0.7.0.1
 */