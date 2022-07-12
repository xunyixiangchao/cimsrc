package d8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import java.util.List;

class k
  implements m
{
  private Context a;
  
  k(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    LocationManager localLocationManager = (LocationManager)this.a.getSystemService("location");
    List localList = localLocationManager.getProviders(true);
    boolean bool1 = localList.contains("gps");
    boolean bool2 = localList.contains("passive");
    if (!bool1)
    {
      if (bool2) {
        return true;
      }
      if (!this.a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
        return true;
      }
      return localLocationManager.isProviderEnabled("gps") ^ true;
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.k
 * JD-Core Version:    0.7.0.1
 */