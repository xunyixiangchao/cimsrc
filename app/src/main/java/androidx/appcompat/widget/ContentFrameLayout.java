package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.core.view.x;

public class ContentFrameLayout
  extends FrameLayout
{
  private TypedValue a;
  private TypedValue b;
  private TypedValue c;
  private TypedValue d;
  private TypedValue e;
  private TypedValue f;
  private final Rect g = new Rect();
  private a h;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (x.U(this)) {
      requestLayout();
    }
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.e == null) {
      this.e = new TypedValue();
    }
    return this.e;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.f == null) {
      this.f = new TypedValue();
    }
    return this.f;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.c == null) {
      this.c = new TypedValue();
    }
    return this.c;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.d == null) {
      this.d = new TypedValue();
    }
    return this.d;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.a == null) {
      this.a = new TypedValue();
    }
    return this.a;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.b == null) {
      this.b = new TypedValue();
    }
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a locala = this.h;
    if (locala != null) {
      locala.a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a locala = this.h;
    if (locala != null) {
      locala.onDetachedFromWindow();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    int n = 1;
    if (i < j) {
      i = 1;
    } else {
      i = 0;
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    Object localObject;
    float f1;
    if (i1 == -2147483648)
    {
      if (i != 0) {
        localObject = this.d;
      } else {
        localObject = this.c;
      }
      if (localObject != null)
      {
        j = ((TypedValue)localObject).type;
        if (j != 0)
        {
          if (j == 5) {}
          for (f1 = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f1 = ((TypedValue)localObject).getFraction(j, j))
          {
            j = (int)f1;
            break label154;
            if (j != 6) {
              break;
            }
            j = localDisplayMetrics.widthPixels;
          }
          j = 0;
          label154:
          if (j > 0)
          {
            localObject = this.g;
            k = View.MeasureSpec.makeMeasureSpec(Math.min(j - (((Rect)localObject).left + ((Rect)localObject).right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
            paramInt1 = 1;
            break label207;
          }
        }
      }
    }
    j = 0;
    int k = paramInt1;
    paramInt1 = j;
    label207:
    j = paramInt2;
    if (m == -2147483648)
    {
      if (i != 0) {
        localObject = this.e;
      } else {
        localObject = this.f;
      }
      j = paramInt2;
      if (localObject != null)
      {
        m = ((TypedValue)localObject).type;
        j = paramInt2;
        if (m != 0)
        {
          if (m == 5) {}
          for (f1 = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f1 = ((TypedValue)localObject).getFraction(j, j))
          {
            m = (int)f1;
            break label313;
            if (m != 6) {
              break;
            }
            j = localDisplayMetrics.heightPixels;
          }
          m = 0;
          label313:
          j = paramInt2;
          if (m > 0)
          {
            localObject = this.g;
            j = View.MeasureSpec.makeMeasureSpec(Math.min(m - (((Rect)localObject).top + ((Rect)localObject).bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
        }
      }
    }
    super.onMeasure(k, j);
    m = getMeasuredWidth();
    k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    if ((paramInt1 == 0) && (i1 == -2147483648))
    {
      if (i != 0) {
        localObject = this.b;
      } else {
        localObject = this.a;
      }
      if (localObject != null)
      {
        paramInt1 = ((TypedValue)localObject).type;
        if (paramInt1 != 0)
        {
          if (paramInt1 == 5) {}
          for (f1 = ((TypedValue)localObject).getDimension(localDisplayMetrics);; f1 = ((TypedValue)localObject).getFraction(paramInt1, paramInt1))
          {
            paramInt1 = (int)f1;
            break label470;
            if (paramInt1 != 6) {
              break;
            }
            paramInt1 = localDisplayMetrics.widthPixels;
          }
          paramInt1 = 0;
          label470:
          paramInt2 = paramInt1;
          if (paramInt1 > 0)
          {
            localObject = this.g;
            paramInt2 = paramInt1 - (((Rect)localObject).left + ((Rect)localObject).right);
          }
          if (m < paramInt2)
          {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            paramInt1 = n;
            break label520;
          }
        }
      }
    }
    paramInt1 = 0;
    paramInt2 = k;
    label520:
    if (paramInt1 != 0) {
      super.onMeasure(paramInt2, j);
    }
  }
  
  public void setAttachListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void onDetachedFromWindow();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ContentFrameLayout
 * JD-Core Version:    0.7.0.1
 */