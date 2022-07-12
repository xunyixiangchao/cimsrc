package n7;

import android.content.ContentResolver;
import android.provider.Settings.Global;

public class a
{
  public float a(ContentResolver paramContentResolver)
  {
    return Settings.Global.getFloat(paramContentResolver, "animator_duration_scale", 1.0F);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n7.a
 * JD-Core Version:    0.7.0.1
 */