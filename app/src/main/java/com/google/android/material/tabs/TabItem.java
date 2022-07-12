package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.k0;
import com.google.android.material.R.styleable;

public class TabItem
  extends View
{
  public final CharSequence a;
  public final Drawable b;
  public final int c;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = k0.u(paramContext, paramAttributeSet, R.styleable.TabItem);
    this.a = paramContext.p(R.styleable.TabItem_android_text);
    this.b = paramContext.g(R.styleable.TabItem_android_icon);
    this.c = paramContext.n(R.styleable.TabItem_android_layout, 0);
    paramContext.w();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.tabs.TabItem
 * JD-Core Version:    0.7.0.1
 */