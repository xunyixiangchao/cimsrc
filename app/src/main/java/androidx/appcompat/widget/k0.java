package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.a;
import p0.h;
import p0.h.d;

public class k0
{
  private final Context a;
  private final TypedArray b;
  private TypedValue c;
  
  private k0(Context paramContext, TypedArray paramTypedArray)
  {
    this.a = paramContext;
    this.b = paramTypedArray;
  }
  
  public static k0 t(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    return new k0(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
  }
  
  public static k0 u(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new k0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static k0 v(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new k0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return this.b.getBoolean(paramInt, paramBoolean);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return this.b.getColor(paramInt1, paramInt2);
  }
  
  public ColorStateList c(int paramInt)
  {
    if (this.b.hasValue(paramInt))
    {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = a.a(this.a, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return this.b.getColorStateList(paramInt);
  }
  
  public float d(int paramInt, float paramFloat)
  {
    return this.b.getDimension(paramInt, paramFloat);
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    return this.b.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public int f(int paramInt1, int paramInt2)
  {
    return this.b.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public Drawable g(int paramInt)
  {
    if (this.b.hasValue(paramInt))
    {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0) {
        return a.b(this.a, i);
      }
    }
    return this.b.getDrawable(paramInt);
  }
  
  public Drawable h(int paramInt)
  {
    if (this.b.hasValue(paramInt))
    {
      paramInt = this.b.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return g.b().d(this.a, paramInt, true);
      }
    }
    return null;
  }
  
  public float i(int paramInt, float paramFloat)
  {
    return this.b.getFloat(paramInt, paramFloat);
  }
  
  public Typeface j(int paramInt1, int paramInt2, h.d paramd)
  {
    paramInt1 = this.b.getResourceId(paramInt1, 0);
    if (paramInt1 == 0) {
      return null;
    }
    if (this.c == null) {
      this.c = new TypedValue();
    }
    return h.h(this.a, paramInt1, this.c, paramInt2, paramd);
  }
  
  public int k(int paramInt1, int paramInt2)
  {
    return this.b.getInt(paramInt1, paramInt2);
  }
  
  public int l(int paramInt1, int paramInt2)
  {
    return this.b.getInteger(paramInt1, paramInt2);
  }
  
  public int m(int paramInt1, int paramInt2)
  {
    return this.b.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public int n(int paramInt1, int paramInt2)
  {
    return this.b.getResourceId(paramInt1, paramInt2);
  }
  
  public String o(int paramInt)
  {
    return this.b.getString(paramInt);
  }
  
  public CharSequence p(int paramInt)
  {
    return this.b.getText(paramInt);
  }
  
  public CharSequence[] q(int paramInt)
  {
    return this.b.getTextArray(paramInt);
  }
  
  public TypedArray r()
  {
    return this.b;
  }
  
  public boolean s(int paramInt)
  {
    return this.b.hasValue(paramInt);
  }
  
  public void w()
  {
    this.b.recycle();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.k0
 * JD-Core Version:    0.7.0.1
 */