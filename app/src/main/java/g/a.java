package g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.bool;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.styleable;

public class a
{
  private Context a;
  
  private a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static a b(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public boolean a()
  {
    return this.a.getApplicationInfo().targetSdkVersion < 14;
  }
  
  public int c()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels / 2;
  }
  
  public int d()
  {
    Configuration localConfiguration = this.a.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp <= 600) && (i <= 600) && ((i <= 960) || (j <= 720)) && ((i <= 720) || (j <= 960)))
    {
      if ((i < 500) && ((i <= 640) || (j <= 480)) && ((i <= 480) || (j <= 640)))
      {
        if (i >= 360) {
          return 3;
        }
        return 2;
      }
      return 4;
    }
    return 5;
  }
  
  public int e()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
  }
  
  public int f()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
    Resources localResources = this.a.getResources();
    int i = j;
    if (!g()) {
      i = Math.min(j, localResources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    return i;
  }
  
  public boolean g()
  {
    return this.a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
  }
  
  public boolean h()
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.a
 * JD-Core Version:    0.7.0.1
 */