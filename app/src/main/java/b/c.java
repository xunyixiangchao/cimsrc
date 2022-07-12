package b;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

public final class c
  extends a<Intent, ActivityResult>
{
  public Intent d(Context paramContext, Intent paramIntent)
  {
    return paramIntent;
  }
  
  public ActivityResult e(int paramInt, Intent paramIntent)
  {
    return new ActivityResult(paramInt, paramIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b.c
 * JD-Core Version:    0.7.0.1
 */