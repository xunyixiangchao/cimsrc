package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import k0.a;
import k0.e;
import k0.f;
import k0.j;

public class Barrier
  extends ConstraintHelper
{
  private int j;
  private int k;
  private a l;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
  }
  
  private void x(e parame, int paramInt, boolean paramBoolean)
  {
    this.k = paramInt;
    if (paramBoolean)
    {
      paramInt = this.j;
      if (paramInt != 5) {}
    }
    label46:
    do
    {
      this.k = 1;
      break;
      if (paramInt != 6) {
        break;
      }
      break label46;
      paramInt = this.j;
      if (paramInt == 5)
      {
        this.k = 0;
        break;
      }
    } while (paramInt == 6);
    if ((parame instanceof a)) {
      ((a)parame).E1(this.k);
    }
  }
  
  public boolean getAllowsGoneWidget()
  {
    return this.l.y1();
  }
  
  public int getMargin()
  {
    return this.l.A1();
  }
  
  public int getType()
  {
    return this.j;
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    this.l = new a();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int m = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < m)
      {
        int n = paramAttributeSet.getIndex(i);
        if (n == R.styleable.ConstraintLayout_Layout_barrierDirection)
        {
          setType(paramAttributeSet.getInt(n, 0));
        }
        else if (n == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets)
        {
          this.l.D1(paramAttributeSet.getBoolean(n, true));
        }
        else if (n == R.styleable.ConstraintLayout_Layout_barrierMargin)
        {
          n = paramAttributeSet.getDimensionPixelSize(n, 0);
          this.l.F1(n);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    this.d = this.l;
    w();
  }
  
  public void p(c.a parama, j paramj, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<e> paramSparseArray)
  {
    super.p(parama, paramj, paramLayoutParams, paramSparseArray);
    if ((paramj instanceof a))
    {
      paramLayoutParams = (a)paramj;
      boolean bool = ((f)paramj.M()).T1();
      x(paramLayoutParams, parama.e.h0, bool);
      paramLayoutParams.D1(parama.e.p0);
      paramLayoutParams.F1(parama.e.i0);
    }
  }
  
  public void q(e parame, boolean paramBoolean)
  {
    x(parame, this.j, paramBoolean);
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.l.D1(paramBoolean);
  }
  
  public void setDpMargin(int paramInt)
  {
    float f = getResources().getDisplayMetrics().density;
    paramInt = (int)(paramInt * f + 0.5F);
    this.l.F1(paramInt);
  }
  
  public void setMargin(int paramInt)
  {
    this.l.F1(paramInt);
  }
  
  public void setType(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.Barrier
 * JD-Core Version:    0.7.0.1
 */