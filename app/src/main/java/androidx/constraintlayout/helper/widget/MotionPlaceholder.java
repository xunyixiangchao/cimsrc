package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.VirtualLayout;
import k0.e;
import k0.f;
import k0.i;
import k0.l;
import k0.m;

public class MotionPlaceholder
  extends VirtualLayout
{
  l l;
  
  public MotionPlaceholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MotionPlaceholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    this.d = new l();
    w();
  }
  
  @SuppressLint({"WrongCall"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    x(this.l, paramInt1, paramInt2);
  }
  
  public void v(f paramf, i parami, SparseArray<e> paramSparseArray) {}
  
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
 * Qualified Name:     androidx.constraintlayout.helper.widget.MotionPlaceholder
 * JD-Core Version:    0.7.0.1
 */