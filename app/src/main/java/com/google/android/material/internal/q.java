package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class q
{
  private static final Comparator<View> a = new a();
  
  private static ImageView a(Toolbar paramToolbar, Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = 0;
    while (i < paramToolbar.getChildCount())
    {
      Object localObject = paramToolbar.getChildAt(i);
      if ((localObject instanceof ImageView))
      {
        localObject = (ImageView)localObject;
        Drawable localDrawable = ((ImageView)localObject).getDrawable();
        if ((localDrawable != null) && (localDrawable.getConstantState() != null) && (localDrawable.getConstantState().equals(paramDrawable.getConstantState()))) {
          return localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static ImageView b(Toolbar paramToolbar)
  {
    return a(paramToolbar, paramToolbar.getLogo());
  }
  
  public static TextView c(Toolbar paramToolbar)
  {
    paramToolbar = d(paramToolbar, paramToolbar.getSubtitle());
    if (paramToolbar.isEmpty()) {
      return null;
    }
    return (TextView)Collections.max(paramToolbar, a);
  }
  
  private static List<TextView> d(Toolbar paramToolbar, CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramToolbar.getChildCount())
    {
      Object localObject = paramToolbar.getChildAt(i);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        if (TextUtils.equals(((TextView)localObject).getText(), paramCharSequence)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static TextView e(Toolbar paramToolbar)
  {
    paramToolbar = d(paramToolbar, paramToolbar.getTitle());
    if (paramToolbar.isEmpty()) {
      return null;
    }
    return (TextView)Collections.min(paramToolbar, a);
  }
  
  class a
    implements Comparator<View>
  {
    public int a(View paramView1, View paramView2)
    {
      return paramView1.getTop() - paramView2.getTop();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.q
 * JD-Core Version:    0.7.0.1
 */