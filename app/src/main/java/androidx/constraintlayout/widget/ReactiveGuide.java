package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ReactiveGuide
  extends View
  implements e.a
{
  private int a = -1;
  private boolean b = false;
  private int c = 0;
  private boolean d = true;
  
  public ReactiveGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
    a(paramAttributeSet);
  }
  
  public ReactiveGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
          this.a = paramAttributeSet.getResourceId(k, this.a);
        } else if (k == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
          this.b = paramAttributeSet.getBoolean(k, this.b);
        } else if (k == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
          this.c = paramAttributeSet.getResourceId(k, this.c);
        } else if (k == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
          this.d = paramAttributeSet.getBoolean(k, this.d);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    if (this.a != -1) {
      ConstraintLayout.getSharedValues().a(this.a, this);
    }
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  public int getApplyToConstraintSetId()
  {
    return this.c;
  }
  
  public int getAttributeId()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public void setAnimateChange(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setApplyToConstraintSetId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setAttributeId(int paramInt)
  {
    e locale = ConstraintLayout.getSharedValues();
    int i = this.a;
    if (i != -1) {
      locale.b(i, this);
    }
    this.a = paramInt;
    if (paramInt != -1) {
      locale.a(paramInt, this);
    }
  }
  
  public void setGuidelineBegin(int paramInt)
  {
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.a = paramInt;
    setLayoutParams(localLayoutParams);
  }
  
  public void setGuidelineEnd(int paramInt)
  {
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.b = paramInt;
    setLayoutParams(localLayoutParams);
  }
  
  public void setGuidelinePercent(float paramFloat)
  {
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.c = paramFloat;
    setLayoutParams(localLayoutParams);
  }
  
  public void setVisibility(int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.ReactiveGuide
 * JD-Core Version:    0.7.0.1
 */