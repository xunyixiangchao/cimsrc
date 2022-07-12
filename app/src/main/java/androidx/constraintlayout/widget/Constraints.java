package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Constraints
  extends ViewGroup
{
  c a;
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramAttributeSet);
    super.setVisibility(8);
  }
  
  private void c(AttributeSet paramAttributeSet)
  {
    Log.v("Constraints", " ################# init");
  }
  
  protected LayoutParams a()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public c getConstraintSet()
  {
    if (this.a == null) {
      this.a = new c();
    }
    this.a.r(this);
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float A0;
    public float B0;
    public float C0;
    public float D0;
    public float E0;
    public float F0;
    public float G0;
    public float H0;
    public float I0;
    public float J0;
    public float x0 = 1.0F;
    public boolean y0;
    public float z0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.y0 = false;
      this.z0 = 0.0F;
      this.A0 = 0.0F;
      this.B0 = 0.0F;
      this.C0 = 0.0F;
      this.D0 = 1.0F;
      this.E0 = 1.0F;
      this.F0 = 0.0F;
      this.G0 = 0.0F;
      this.H0 = 0.0F;
      this.I0 = 0.0F;
      this.J0 = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      int i = 0;
      this.y0 = false;
      this.z0 = 0.0F;
      this.A0 = 0.0F;
      this.B0 = 0.0F;
      this.C0 = 0.0F;
      this.D0 = 1.0F;
      this.E0 = 1.0F;
      this.F0 = 0.0F;
      this.G0 = 0.0F;
      this.H0 = 0.0F;
      this.I0 = 0.0F;
      this.J0 = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.ConstraintSet_android_alpha)
        {
          this.x0 = paramContext.getFloat(k, this.x0);
        }
        else if (k == R.styleable.ConstraintSet_android_elevation)
        {
          this.z0 = paramContext.getFloat(k, this.z0);
          this.y0 = true;
        }
        else if (k == R.styleable.ConstraintSet_android_rotationX)
        {
          this.B0 = paramContext.getFloat(k, this.B0);
        }
        else if (k == R.styleable.ConstraintSet_android_rotationY)
        {
          this.C0 = paramContext.getFloat(k, this.C0);
        }
        else if (k == R.styleable.ConstraintSet_android_rotation)
        {
          this.A0 = paramContext.getFloat(k, this.A0);
        }
        else if (k == R.styleable.ConstraintSet_android_scaleX)
        {
          this.D0 = paramContext.getFloat(k, this.D0);
        }
        else if (k == R.styleable.ConstraintSet_android_scaleY)
        {
          this.E0 = paramContext.getFloat(k, this.E0);
        }
        else if (k == R.styleable.ConstraintSet_android_transformPivotX)
        {
          this.F0 = paramContext.getFloat(k, this.F0);
        }
        else if (k == R.styleable.ConstraintSet_android_transformPivotY)
        {
          this.G0 = paramContext.getFloat(k, this.G0);
        }
        else if (k == R.styleable.ConstraintSet_android_translationX)
        {
          this.H0 = paramContext.getFloat(k, this.H0);
        }
        else if (k == R.styleable.ConstraintSet_android_translationY)
        {
          this.I0 = paramContext.getFloat(k, this.I0);
        }
        else if (k == R.styleable.ConstraintSet_android_translationZ)
        {
          this.J0 = paramContext.getFloat(k, this.J0);
        }
        i += 1;
      }
      paramContext.recycle();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.Constraints
 * JD-Core Version:    0.7.0.1
 */