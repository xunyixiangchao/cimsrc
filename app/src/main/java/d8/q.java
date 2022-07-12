package d8;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipProfile.Builder;

class q
  implements m
{
  private Context a;
  
  q(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    if (!SipManager.isApiSupported(this.a)) {
      return true;
    }
    SipManager localSipManager = SipManager.newInstance(this.a);
    if (localSipManager == null) {
      return true;
    }
    Object localObject = new SipProfile.Builder("Permission", "127.0.0.1");
    ((SipProfile.Builder)localObject).setPassword("password");
    localObject = ((SipProfile.Builder)localObject).build();
    localSipManager.open((SipProfile)localObject);
    localSipManager.close(((SipProfile)localObject).getUriString());
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.q
 * JD-Core Version:    0.7.0.1
 */