package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;
import java.util.HashMap;

public class CircularFlow
  extends VirtualLayout
{
  private static int v;
  private static float w;
  ConstraintLayout l;
  int m;
  private float[] n;
  private int[] o;
  private int p;
  private int q;
  private String r;
  private String s;
  private Float t;
  private Integer u;
  
  public CircularFlow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CircularFlow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void A()
  {
    this.l = ((ConstraintLayout)getParent());
    int i = 0;
    while (i < this.b)
    {
      View localView = this.l.l(this.a[i]);
      if (localView != null)
      {
        int j = v;
        float f = w;
        Object localObject = this.o;
        if ((localObject != null) && (i < localObject.length))
        {
          j = localObject[i];
        }
        else
        {
          localObject = this.u;
          if ((localObject != null) && (((Integer)localObject).intValue() != -1))
          {
            this.p += 1;
            if (this.o == null) {
              this.o = new int[1];
            }
            localObject = getRadius();
            this.o = ((int[])localObject);
            localObject[(this.p - 1)] = j;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added radius to view with id: ");
            ((StringBuilder)localObject).append((String)this.i.get(Integer.valueOf(localView.getId())));
            Log.e("CircularFlow", ((StringBuilder)localObject).toString());
          }
        }
        localObject = this.n;
        if ((localObject != null) && (i < localObject.length))
        {
          f = localObject[i];
        }
        else
        {
          localObject = this.t;
          if ((localObject != null) && (((Float)localObject).floatValue() != -1.0F))
          {
            this.q += 1;
            if (this.n == null) {
              this.n = new float[1];
            }
            localObject = getAngles();
            this.n = ((float[])localObject);
            localObject[(this.q - 1)] = f;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added angle to view with id: ");
            ((StringBuilder)localObject).append((String)this.i.get(Integer.valueOf(localView.getId())));
            Log.e("CircularFlow", ((StringBuilder)localObject).toString());
          }
        }
        localObject = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
        ((ConstraintLayout.LayoutParams)localObject).r = f;
        ((ConstraintLayout.LayoutParams)localObject).p = this.m;
        ((ConstraintLayout.LayoutParams)localObject).q = j;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i += 1;
    }
    h();
  }
  
  private void setAngles(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = 0;
    this.q = 0;
    for (;;)
    {
      int j = paramString.indexOf(',', i);
      if (j == -1)
      {
        y(paramString.substring(i).trim());
        return;
      }
      y(paramString.substring(i, j).trim());
      i = j + 1;
    }
  }
  
  private void setRadius(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = 0;
    this.p = 0;
    for (;;)
    {
      int j = paramString.indexOf(',', i);
      if (j == -1)
      {
        z(paramString.substring(i).trim());
        return;
      }
      z(paramString.substring(i, j).trim());
      i = j + 1;
    }
  }
  
  private void y(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (this.c == null) {
        return;
      }
      float[] arrayOfFloat = this.n;
      if (arrayOfFloat == null) {
        return;
      }
      if (this.q + 1 > arrayOfFloat.length) {
        this.n = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length + 1);
      }
      this.n[this.q] = Integer.parseInt(paramString);
      this.q += 1;
    }
  }
  
  private void z(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (this.c == null) {
        return;
      }
      int[] arrayOfInt = this.o;
      if (arrayOfInt == null) {
        return;
      }
      if (this.p + 1 > arrayOfInt.length) {
        this.o = Arrays.copyOf(arrayOfInt, arrayOfInt.length + 1);
      }
      this.o[this.p] = ((int)(Integer.parseInt(paramString) * this.c.getResources().getDisplayMetrics().density));
      this.p += 1;
    }
  }
  
  public float[] getAngles()
  {
    return Arrays.copyOf(this.n, this.q);
  }
  
  public int[] getRadius()
  {
    return Arrays.copyOf(this.o, this.p);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter)
        {
          this.m = paramAttributeSet.getResourceId(k, 0);
        }
        else
        {
          Object localObject;
          if (k == R.styleable.ConstraintLayout_Layout_circularflow_angles)
          {
            localObject = paramAttributeSet.getString(k);
            this.r = ((String)localObject);
            setAngles((String)localObject);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP)
          {
            localObject = paramAttributeSet.getString(k);
            this.s = ((String)localObject);
            setRadius((String)localObject);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle)
          {
            localObject = Float.valueOf(paramAttributeSet.getFloat(k, w));
            this.t = ((Float)localObject);
            setDefaultAngle(((Float)localObject).floatValue());
          }
          else if (k == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius)
          {
            localObject = Integer.valueOf(paramAttributeSet.getDimensionPixelSize(k, v));
            this.u = ((Integer)localObject);
            setDefaultRadius(((Integer)localObject).intValue());
          }
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.r;
    if (localObject != null)
    {
      this.n = new float[1];
      setAngles((String)localObject);
    }
    localObject = this.s;
    if (localObject != null)
    {
      this.o = new int[1];
      setRadius((String)localObject);
    }
    localObject = this.t;
    if (localObject != null) {
      setDefaultAngle(((Float)localObject).floatValue());
    }
    localObject = this.u;
    if (localObject != null) {
      setDefaultRadius(((Integer)localObject).intValue());
    }
    A();
  }
  
  public void setDefaultAngle(float paramFloat)
  {
    w = paramFloat;
  }
  
  public void setDefaultRadius(int paramInt)
  {
    v = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.helper.widget.CircularFlow
 * JD-Core Version:    0.7.0.1
 */