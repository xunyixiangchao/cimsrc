package q2;

import android.content.Context;
import android.util.Log;

public class d
  implements b
{
  public a a(Context paramContext, a.a parama)
  {
    int i;
    if (androidx.core.content.b.a(paramContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (Log.isLoggable("ConnectivityMonitor", 3))
    {
      String str;
      if (i != 0) {
        str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
      } else {
        str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
      }
      Log.d("ConnectivityMonitor", str);
    }
    if (i != 0) {
      return new c(paramContext, parama);
    }
    return new g();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q2.d
 * JD-Core Version:    0.7.0.1
 */