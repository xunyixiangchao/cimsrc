package b;

import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends a<String[], Map<String, Boolean>>
{
  static Intent e(String[] paramArrayOfString)
  {
    return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString);
  }
  
  public Intent d(Context paramContext, String[] paramArrayOfString)
  {
    return e(paramArrayOfString);
  }
  
  public a.a<Map<String, Boolean>> f(Context paramContext, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      g0.a locala = new g0.a();
      int k = paramArrayOfString.length;
      int i = 0;
      int j = 1;
      while (i < k)
      {
        String str = paramArrayOfString[i];
        boolean bool;
        if (androidx.core.content.b.a(paramContext, str) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        locala.put(str, Boolean.valueOf(bool));
        if (!bool) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        return new a.a(locala);
      }
      return null;
    }
    return new a.a(Collections.emptyMap());
  }
  
  public Map<String, Boolean> g(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return Collections.emptyMap();
    }
    if (paramIntent == null) {
      return Collections.emptyMap();
    }
    String[] arrayOfString = paramIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
    paramIntent = paramIntent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
    if ((paramIntent != null) && (arrayOfString != null))
    {
      HashMap localHashMap = new HashMap();
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        String str = arrayOfString[paramInt];
        boolean bool;
        if (paramIntent[paramInt] == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localHashMap.put(str, Boolean.valueOf(bool));
        paramInt += 1;
      }
      return localHashMap;
    }
    return Collections.emptyMap();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b.b
 * JD-Core Version:    0.7.0.1
 */