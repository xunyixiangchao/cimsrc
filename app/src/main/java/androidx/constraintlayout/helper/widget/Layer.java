package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R.styleable;
import k0.e;

public class Layer
  extends ConstraintHelper
{
  private boolean A;
  private float j = (0.0F / 0.0F);
  private float k = (0.0F / 0.0F);
  private float l = (0.0F / 0.0F);
  ConstraintLayout m;
  private float n = 1.0F;
  private float o = 1.0F;
  protected float p = (0.0F / 0.0F);
  protected float q = (0.0F / 0.0F);
  protected float r = (0.0F / 0.0F);
  protected float s = (0.0F / 0.0F);
  protected float t = (0.0F / 0.0F);
  protected float u = (0.0F / 0.0F);
  boolean v = true;
  View[] w = null;
  private float x = 0.0F;
  private float y = 0.0F;
  private boolean z;
  
  public Layer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Layer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void y()
  {
    if (this.m == null) {
      return;
    }
    int i = this.b;
    if (i == 0) {
      return;
    }
    View[] arrayOfView = this.w;
    if ((arrayOfView == null) || (arrayOfView.length != i)) {
      this.w = new View[i];
    }
    i = 0;
    while (i < this.b)
    {
      int i1 = this.a[i];
      this.w[i] = this.m.l(i1);
      i += 1;
    }
  }
  
  private void z()
  {
    if (this.m == null) {
      return;
    }
    if (this.w == null) {
      y();
    }
    x();
    double d;
    if (Float.isNaN(this.l)) {
      d = 0.0D;
    } else {
      d = Math.toRadians(this.l);
    }
    float f1 = (float)Math.sin(d);
    float f2 = (float)Math.cos(d);
    float f3 = this.n;
    float f4 = this.o;
    float f5 = -f4;
    int i = 0;
    while (i < this.b)
    {
      View localView = this.w[i];
      int i1 = (localView.getLeft() + localView.getRight()) / 2;
      int i2 = (localView.getTop() + localView.getBottom()) / 2;
      float f6 = i1 - this.p;
      float f7 = i2 - this.q;
      float f8 = this.x;
      float f9 = this.y;
      localView.setTranslationX(f3 * f2 * f6 + f5 * f1 * f7 - f6 + f8);
      localView.setTranslationY(f6 * (f3 * f1) + f4 * f2 * f7 - f7 + f9);
      localView.setScaleY(this.o);
      localView.setScaleX(this.n);
      if (!Float.isNaN(this.l)) {
        localView.setRotation(this.l);
      }
      i += 1;
    }
  }
  
  protected void j(ConstraintLayout paramConstraintLayout)
  {
    i(paramConstraintLayout);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    int i = 0;
    this.e = false;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i1 = paramAttributeSet.getIndexCount();
      while (i < i1)
      {
        int i2 = paramAttributeSet.getIndex(i);
        if (i2 == R.styleable.ConstraintLayout_Layout_android_visibility) {
          this.z = true;
        } else if (i2 == R.styleable.ConstraintLayout_Layout_android_elevation) {
          this.A = true;
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.m = ((ConstraintLayout)getParent());
    if ((this.z) || (this.A))
    {
      int i1 = getVisibility();
      float f = getElevation();
      int i = 0;
      while (i < this.b)
      {
        int i2 = this.a[i];
        View localView = this.m.l(i2);
        if (localView != null)
        {
          if (this.z) {
            localView.setVisibility(i1);
          }
          if ((this.A) && (f > 0.0F)) {
            localView.setTranslationZ(localView.getTranslationZ() + f);
          }
        }
        i += 1;
      }
    }
  }
  
  public void r(ConstraintLayout paramConstraintLayout)
  {
    y();
    this.p = (0.0F / 0.0F);
    this.q = (0.0F / 0.0F);
    paramConstraintLayout = ((ConstraintLayout.LayoutParams)getLayoutParams()).b();
    paramConstraintLayout.o1(0);
    paramConstraintLayout.P0(0);
    x();
    layout((int)this.t - getPaddingLeft(), (int)this.u - getPaddingTop(), (int)this.r + getPaddingRight(), (int)this.s + getPaddingBottom());
    z();
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    h();
  }
  
  public void setPivotX(float paramFloat)
  {
    this.j = paramFloat;
    z();
  }
  
  public void setPivotY(float paramFloat)
  {
    this.k = paramFloat;
    z();
  }
  
  public void setRotation(float paramFloat)
  {
    this.l = paramFloat;
    z();
  }
  
  public void setScaleX(float paramFloat)
  {
    this.n = paramFloat;
    z();
  }
  
  public void setScaleY(float paramFloat)
  {
    this.o = paramFloat;
    z();
  }
  
  public void setTranslationX(float paramFloat)
  {
    this.x = paramFloat;
    z();
  }
  
  public void setTranslationY(float paramFloat)
  {
    this.y = paramFloat;
    z();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    h();
  }
  
  public void t(ConstraintLayout paramConstraintLayout)
  {
    this.m = paramConstraintLayout;
    float f = getRotation();
    if ((f != 0.0F) || (!Float.isNaN(this.l))) {
      this.l = f;
    }
  }
  
  protected void x()
  {
    if (this.m == null) {
      return;
    }
    if ((!this.v) && (!Float.isNaN(this.p)) && (!Float.isNaN(this.q))) {
      return;
    }
    if ((!Float.isNaN(this.j)) && (!Float.isNaN(this.k)))
    {
      this.q = this.k;
      this.p = this.j;
      return;
    }
    View[] arrayOfView = n(this.m);
    int i3 = 0;
    int i4 = arrayOfView[0].getLeft();
    int i2 = arrayOfView[0].getTop();
    int i1 = arrayOfView[0].getRight();
    int i = arrayOfView[0].getBottom();
    while (i3 < this.b)
    {
      View localView = arrayOfView[i3];
      i4 = Math.min(i4, localView.getLeft());
      i2 = Math.min(i2, localView.getTop());
      i1 = Math.max(i1, localView.getRight());
      i = Math.max(i, localView.getBottom());
      i3 += 1;
    }
    this.r = i1;
    this.s = i;
    this.t = i4;
    this.u = i2;
    float f;
    if (Float.isNaN(this.j)) {
      f = (i4 + i1) / 2;
    } else {
      f = this.j;
    }
    this.p = f;
    if (Float.isNaN(this.k)) {
      f = (i2 + i) / 2;
    } else {
      f = this.k;
    }
    this.q = f;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.helper.widget.Layer
 * JD-Core Version:    0.7.0.1
 */