package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class e
{
  @Deprecated
  public Fragment b(Context paramContext, String paramString, Bundle paramBundle)
  {
    return Fragment.instantiate(paramContext, paramString, paramBundle);
  }
  
  public abstract View c(int paramInt);
  
  public abstract boolean d();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.e
 * JD-Core Version:    0.7.0.1
 */