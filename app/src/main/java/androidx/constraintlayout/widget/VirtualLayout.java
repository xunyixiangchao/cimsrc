package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import k0.m;

public abstract class VirtualLayout
  extends ConstraintHelper
{
  private boolean j;
  private boolean k;
  
  public VirtualLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VirtualLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void j(ConstraintLayout paramConstraintLayout)
  {
    i(paramConstraintLayout);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int m = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < m)
      {
        int n = paramAttributeSet.getIndex(i);
        if (n == R.styleable.ConstraintLayout_Layout_android_visibility) {
          this.j = true;
        } else if (n == R.styleable.ConstraintLayout_Layout_android_elevation) {
          this.k = true;
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.j) || (this.k))
    {
      Object localObject = getParent();
      if ((localObject instanceof ConstraintLayout))
      {
        localObject = (ConstraintLayout)localObject;
        int m = getVisibility();
        float f = getElevation();
        int i = 0;
        while (i < this.b)
        {
          View localView = ((ConstraintLayout)localObject).l(this.a[i]);
          if (localView != null)
          {
            if (this.j) {
              localView.setVisibility(m);
            }
            if ((this.k) && (f > 0.0F)) {
              localView.setTranslationZ(localView.getTranslationZ() + f);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    h();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    h();
  }
  
  public void x(m paramm, int paramInt1, int paramInt2) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.VirtualLayout
 * JD-Core Version:    0.7.0.1
 */