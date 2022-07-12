package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;

public class MotionHelper
  extends ConstraintHelper
  implements MotionLayout.j
{
  private boolean j = false;
  private boolean k = false;
  private float l;
  protected View[] m;
  
  public MotionHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    o(paramAttributeSet);
  }
  
  public MotionHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o(paramAttributeSet);
  }
  
  public void A(MotionLayout paramMotionLayout) {}
  
  public void B(Canvas paramCanvas) {}
  
  public void C(Canvas paramCanvas) {}
  
  public void D(MotionLayout paramMotionLayout, HashMap<View, m> paramHashMap) {}
  
  public void E(View paramView, float paramFloat) {}
  
  public void a(MotionLayout paramMotionLayout, int paramInt1, int paramInt2, float paramFloat) {}
  
  public void b(MotionLayout paramMotionLayout, int paramInt1, int paramInt2) {}
  
  public void c(MotionLayout paramMotionLayout, int paramInt, boolean paramBoolean, float paramFloat) {}
  
  public void d(MotionLayout paramMotionLayout, int paramInt) {}
  
  public float getProgress()
  {
    return this.l;
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MotionHelper);
      int n = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < n)
      {
        int i1 = paramAttributeSet.getIndex(i);
        if (i1 == R.styleable.MotionHelper_onShow) {
          this.j = paramAttributeSet.getBoolean(i1, this.j);
        } else if (i1 == R.styleable.MotionHelper_onHide) {
          this.k = paramAttributeSet.getBoolean(i1, this.k);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.l = paramFloat;
    int i1 = this.b;
    int i = 0;
    int n = 0;
    if (i1 > 0)
    {
      this.m = n((ConstraintLayout)getParent());
      i = n;
      while (i < this.b)
      {
        E(this.m[i], paramFloat);
        i += 1;
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getParent();
    n = localViewGroup.getChildCount();
    while (i < n)
    {
      View localView = localViewGroup.getChildAt(i);
      if (!(localView instanceof MotionHelper)) {
        E(localView, paramFloat);
      }
      i += 1;
    }
  }
  
  public boolean x()
  {
    return false;
  }
  
  public boolean y()
  {
    return this.k;
  }
  
  public boolean z()
  {
    return this.j;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionHelper
 * JD-Core Version:    0.7.0.1
 */