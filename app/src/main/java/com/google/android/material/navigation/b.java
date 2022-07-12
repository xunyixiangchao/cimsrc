package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;

public final class b
  extends e
{
  private final Class<?> B;
  private final int C;
  
  public b(Context paramContext, Class<?> paramClass, int paramInt)
  {
    super(paramContext);
    this.B = paramClass;
    this.C = paramInt;
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 <= this.C)
    {
      h0();
      paramCharSequence = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
      if ((paramCharSequence instanceof g)) {
        ((g)paramCharSequence).t(true);
      }
      g0();
      return paramCharSequence;
    }
    paramCharSequence = this.B.getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Maximum number of items supported by ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(" is ");
    localStringBuilder.append(this.C);
    localStringBuilder.append(". Limit can be checked with ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append("#getMaxItemCount()");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuilder();
    paramCharSequence.append(this.B.getSimpleName());
    paramCharSequence.append(" does not support submenus");
    throw new UnsupportedOperationException(paramCharSequence.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.navigation.b
 * JD-Core Version:    0.7.0.1
 */