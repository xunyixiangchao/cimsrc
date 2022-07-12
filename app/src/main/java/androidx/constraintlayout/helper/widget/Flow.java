package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c.a;
import k0.e;
import k0.g;
import k0.j;
import k0.m;

public class Flow
  extends VirtualLayout
{
  private g l;
  
  public Flow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Flow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    this.l = new g();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_orientation) {
          this.l.H2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_padding) {
          this.l.M1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
          this.l.R1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
          this.l.O1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
          this.l.P1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
          this.l.S1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
          this.l.Q1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
          this.l.N1(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
          this.l.M2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
          this.l.B2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
          this.l.L2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
          this.l.v2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
          this.l.D2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
          this.l.x2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
          this.l.F2(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
          this.l.z2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
          this.l.u2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
          this.l.C2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
          this.l.w2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
          this.l.E2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
          this.l.J2(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
          this.l.y2(paramAttributeSet.getInt(k, 2));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
          this.l.I2(paramAttributeSet.getInt(k, 2));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
          this.l.A2(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
          this.l.K2(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
          this.l.G2(paramAttributeSet.getInt(k, -1));
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    this.d = this.l;
    w();
  }
  
  @SuppressLint({"WrongCall"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    x(this.l, paramInt1, paramInt2);
  }
  
  public void p(c.a parama, j paramj, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<e> paramSparseArray)
  {
    super.p(parama, paramj, paramLayoutParams, paramSparseArray);
    if ((paramj instanceof g))
    {
      parama = (g)paramj;
      int i = paramLayoutParams.Z;
      if (i != -1) {
        parama.H2(i);
      }
    }
  }
  
  public void q(e parame, boolean paramBoolean)
  {
    this.l.x1(paramBoolean);
  }
  
  public void setFirstHorizontalBias(float paramFloat)
  {
    this.l.u2(paramFloat);
    requestLayout();
  }
  
  public void setFirstHorizontalStyle(int paramInt)
  {
    this.l.v2(paramInt);
    requestLayout();
  }
  
  public void setFirstVerticalBias(float paramFloat)
  {
    this.l.w2(paramFloat);
    requestLayout();
  }
  
  public void setFirstVerticalStyle(int paramInt)
  {
    this.l.x2(paramInt);
    requestLayout();
  }
  
  public void setHorizontalAlign(int paramInt)
  {
    this.l.y2(paramInt);
    requestLayout();
  }
  
  public void setHorizontalBias(float paramFloat)
  {
    this.l.z2(paramFloat);
    requestLayout();
  }
  
  public void setHorizontalGap(int paramInt)
  {
    this.l.A2(paramInt);
    requestLayout();
  }
  
  public void setHorizontalStyle(int paramInt)
  {
    this.l.B2(paramInt);
    requestLayout();
  }
  
  public void setLastHorizontalBias(float paramFloat)
  {
    this.l.C2(paramFloat);
    requestLayout();
  }
  
  public void setLastHorizontalStyle(int paramInt)
  {
    this.l.D2(paramInt);
    requestLayout();
  }
  
  public void setLastVerticalBias(float paramFloat)
  {
    this.l.E2(paramFloat);
    requestLayout();
  }
  
  public void setLastVerticalStyle(int paramInt)
  {
    this.l.F2(paramInt);
    requestLayout();
  }
  
  public void setMaxElementsWrap(int paramInt)
  {
    this.l.G2(paramInt);
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    this.l.H2(paramInt);
    requestLayout();
  }
  
  public void setPadding(int paramInt)
  {
    this.l.M1(paramInt);
    requestLayout();
  }
  
  public void setPaddingBottom(int paramInt)
  {
    this.l.N1(paramInt);
    requestLayout();
  }
  
  public void setPaddingLeft(int paramInt)
  {
    this.l.P1(paramInt);
    requestLayout();
  }
  
  public void setPaddingRight(int paramInt)
  {
    this.l.Q1(paramInt);
    requestLayout();
  }
  
  public void setPaddingTop(int paramInt)
  {
    this.l.S1(paramInt);
    requestLayout();
  }
  
  public void setVerticalAlign(int paramInt)
  {
    this.l.I2(paramInt);
    requestLayout();
  }
  
  public void setVerticalBias(float paramFloat)
  {
    this.l.J2(paramFloat);
    requestLayout();
  }
  
  public void setVerticalGap(int paramInt)
  {
    this.l.K2(paramInt);
    requestLayout();
  }
  
  public void setVerticalStyle(int paramInt)
  {
    this.l.L2(paramInt);
    requestLayout();
  }
  
  public void setWrapMode(int paramInt)
  {
    this.l.M2(paramInt);
    requestLayout();
  }
  
  public void x(m paramm, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramm != null)
    {
      paramm.G1(i, paramInt1, j, paramInt2);
      setMeasuredDimension(paramm.B1(), paramm.A1());
      return;
    }
    setMeasuredDimension(0, 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.helper.widget.Flow
 * JD-Core Version:    0.7.0.1
 */