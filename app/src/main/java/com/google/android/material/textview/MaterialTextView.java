package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import o7.b;
import o7.c;
import s7.a;

public class MaterialTextView
  extends AppCompatTextView
{
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public MaterialTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(a.c(paramContext, paramAttributeSet, paramInt1, paramInt2), paramAttributeSet, paramInt1);
    paramContext = getContext();
    if (l(paramContext))
    {
      Resources.Theme localTheme = paramContext.getTheme();
      if (!o(paramContext, localTheme, paramAttributeSet, paramInt1, paramInt2))
      {
        paramInt1 = m(localTheme, paramAttributeSet, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          k(localTheme, paramInt1);
        }
      }
    }
  }
  
  private void k(Resources.Theme paramTheme, int paramInt)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramInt, R.styleable.MaterialTextAppearance);
    paramInt = n(getContext(), paramTheme, new int[] { R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight });
    paramTheme.recycle();
    if (paramInt >= 0) {
      setLineHeight(paramInt);
    }
  }
  
  private static boolean l(Context paramContext)
  {
    return b.b(paramContext, R.attr.textAppearanceLineHeightEnabled, true);
  }
  
  private static int m(Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialTextView, paramInt1, paramInt2);
    paramInt1 = paramTheme.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
    paramTheme.recycle();
    return paramInt1;
  }
  
  private static int n(Context paramContext, TypedArray paramTypedArray, int... paramVarArgs)
  {
    int i = 0;
    int j = -1;
    while ((i < paramVarArgs.length) && (j < 0))
    {
      j = c.d(paramContext, paramTypedArray, paramVarArgs[i], -1);
      i += 1;
    }
    return j;
  }
  
  private static boolean o(Context paramContext, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialTextView, paramInt1, paramInt2);
    paramInt1 = R.styleable.MaterialTextView_android_lineHeight;
    boolean bool = false;
    paramInt1 = n(paramContext, paramTheme, new int[] { paramInt1, R.styleable.MaterialTextView_lineHeight });
    paramTheme.recycle();
    if (paramInt1 != -1) {
      bool = true;
    }
    return bool;
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (l(paramContext)) {
      k(paramContext.getTheme(), paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textview.MaterialTextView
 * JD-Core Version:    0.7.0.1
 */