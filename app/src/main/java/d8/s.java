package d8;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public final class s
  implements l
{
  public boolean a(Context paramContext, String... paramVarArgs)
  {
    return b(paramContext, Arrays.asList(paramVarArgs));
  }
  
  public boolean b(Context paramContext, List<String> paramList)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<String>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if (paramContext.checkPermission((String)localObject, Process.myPid(), Process.myUid()) == -1) {
        return false;
      }
      String str = AppOpsManager.permissionToOp((String)localObject);
      if (!TextUtils.isEmpty(str))
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = (AppOpsManager)paramContext.getSystemService("appops");
        }
        int i = ((AppOpsManager)localObject).checkOpNoThrow(str, Process.myUid(), paramContext.getPackageName());
        paramList = (List<String>)localObject;
        if (i != 0)
        {
          paramList = (List<String>)localObject;
          if (i != 4) {
            return false;
          }
        }
      }
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.s
 * JD-Core Version:    0.7.0.1
 */