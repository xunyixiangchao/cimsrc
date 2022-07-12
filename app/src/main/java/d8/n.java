package d8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

class n
  implements m
{
  private Context a;
  
  n(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    boolean bool1 = this.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
    boolean bool2 = true;
    if (!bool1) {
      return true;
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    bool1 = bool2;
    if (localTelephonyManager.getPhoneType() != 0)
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(localTelephonyManager.getDeviceId()))
      {
        if (!TextUtils.isEmpty(localTelephonyManager.getSubscriberId())) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.n
 * JD-Core Version:    0.7.0.1
 */