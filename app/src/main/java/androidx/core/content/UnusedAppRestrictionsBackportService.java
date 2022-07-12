package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import o0.a;
import o0.b.a;

public abstract class UnusedAppRestrictionsBackportService
  extends Service
{
  private b.a a = new a();
  
  protected abstract void a(d paramd);
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  class a
    extends b.a
  {
    a() {}
    
    public void a(a parama)
    {
      if (parama == null) {
        return;
      }
      parama = new d(parama);
      UnusedAppRestrictionsBackportService.this.a(parama);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.content.UnusedAppRestrictionsBackportService
 * JD-Core Version:    0.7.0.1
 */