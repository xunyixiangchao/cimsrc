package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

public class MultiInstanceInvalidationService
  extends Service
{
  int a = 0;
  final HashMap<Integer, String> b = new HashMap();
  final RemoteCallbackList<j> c = new a();
  private final k.a d = new b();
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.d;
  }
  
  class a
    extends RemoteCallbackList<j>
  {
    a() {}
    
    public void a(j paramj, Object paramObject)
    {
      MultiInstanceInvalidationService.this.b.remove(Integer.valueOf(((Integer)paramObject).intValue()));
    }
  }
  
  class b
    extends k.a
  {
    b() {}
    
    public int c(j paramj, String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      synchronized (MultiInstanceInvalidationService.this.c)
      {
        MultiInstanceInvalidationService localMultiInstanceInvalidationService = MultiInstanceInvalidationService.this;
        int i = localMultiInstanceInvalidationService.a + 1;
        localMultiInstanceInvalidationService.a = i;
        if (localMultiInstanceInvalidationService.c.register(paramj, Integer.valueOf(i)))
        {
          MultiInstanceInvalidationService.this.b.put(Integer.valueOf(i), paramString);
          return i;
        }
        paramj = MultiInstanceInvalidationService.this;
        paramj.a -= 1;
        return 0;
      }
    }
    
    public void d(int paramInt, String[] paramArrayOfString)
    {
      synchronized (MultiInstanceInvalidationService.this.c)
      {
        String str1 = (String)MultiInstanceInvalidationService.this.b.get(Integer.valueOf(paramInt));
        if (str1 == null)
        {
          Log.w("ROOM", "Remote invalidation client ID not registered");
          return;
        }
        int j = MultiInstanceInvalidationService.this.c.beginBroadcast();
        int i = 0;
        while (i < j) {
          try
          {
            int k = ((Integer)MultiInstanceInvalidationService.this.c.getBroadcastCookie(i)).intValue();
            String str2 = (String)MultiInstanceInvalidationService.this.b.get(Integer.valueOf(k));
            if (paramInt != k)
            {
              boolean bool = str1.equals(str2);
              if (bool) {
                try
                {
                  ((j)MultiInstanceInvalidationService.this.c.getBroadcastItem(i)).b(paramArrayOfString);
                }
                catch (RemoteException localRemoteException)
                {
                  Log.w("ROOM", "Error invoking a remote callback", localRemoteException);
                }
              }
            }
            i += 1;
          }
          finally
          {
            MultiInstanceInvalidationService.this.c.finishBroadcast();
          }
        }
        MultiInstanceInvalidationService.this.c.finishBroadcast();
        return;
      }
    }
    
    public void e(j paramj, int paramInt)
    {
      synchronized (MultiInstanceInvalidationService.this.c)
      {
        MultiInstanceInvalidationService.this.c.unregister(paramj);
        MultiInstanceInvalidationService.this.b.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.MultiInstanceInvalidationService
 * JD-Core Version:    0.7.0.1
 */