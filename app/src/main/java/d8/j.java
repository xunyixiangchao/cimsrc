package d8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import java.util.List;

class j
  implements m
{
  private Context a;
  
  j(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    LocationManager localLocationManager = (LocationManager)this.a.getSystemService("location");
    if (localLocationManager.getProviders(true).contains("network")) {
      return true;
    }
    if (!this.a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
      return true;
    }
    return localLocationManager.isProviderEnabled("network") ^ true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.j
 * JD-Core Version:    0.7.0.1
 */