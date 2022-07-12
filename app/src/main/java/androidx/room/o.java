package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class o
{
  final Context a;
  final String b;
  int c;
  final n d;
  final n.c e;
  k f;
  final Executor g;
  final j h = new a();
  final AtomicBoolean i = new AtomicBoolean(false);
  final ServiceConnection j;
  final Runnable k;
  final Runnable l;
  
  o(Context paramContext, String paramString, Intent paramIntent, n paramn, Executor paramExecutor)
  {
    b localb = new b();
    this.j = localb;
    this.k = new c();
    this.l = new d();
    paramContext = paramContext.getApplicationContext();
    this.a = paramContext;
    this.b = paramString;
    this.d = paramn;
    this.g = paramExecutor;
    this.e = new e((String[])paramn.a.keySet().toArray(new String[0]));
    paramContext.bindService(paramIntent, localb, 1);
  }
  
  void a()
  {
    if (this.i.compareAndSet(false, true))
    {
      this.d.i(this.e);
      try
      {
        k localk = this.f;
        if (localk != null) {
          localk.e(this.h, this.c);
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", localRemoteException);
      }
      this.a.unbindService(this.j);
    }
  }
  
  class a
    extends j.a
  {
    a() {}
    
    public void b(final String[] paramArrayOfString)
    {
      o.this.g.execute(new a(paramArrayOfString));
    }
    
    class a
      implements Runnable
    {
      a(String[] paramArrayOfString) {}
      
      public void run()
      {
        o.this.d.f(paramArrayOfString);
      }
    }
  }
  
  class b
    implements ServiceConnection
  {
    b() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      o.this.f = k.a.g(paramIBinder);
      paramComponentName = o.this;
      paramComponentName.g.execute(paramComponentName.k);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = o.this;
      paramComponentName.g.execute(paramComponentName.l);
      o.this.f = null;
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      try
      {
        o localo = o.this;
        k localk = localo.f;
        if (localk != null)
        {
          localo.c = localk.c(localo.h, localo.b);
          localo = o.this;
          localo.d.a(localo.e);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("ROOM", "Cannot register multi-instance invalidation callback", localRemoteException);
      }
    }
  }
  
  class d
    implements Runnable
  {
    d() {}
    
    public void run()
    {
      o localo = o.this;
      localo.d.i(localo.e);
    }
  }
  
  class e
    extends n.c
  {
    e(String[] paramArrayOfString)
    {
      super();
    }
    
    boolean a()
    {
      return true;
    }
    
    public void b(Set<String> paramSet)
    {
      if (o.this.i.get()) {
        return;
      }
      try
      {
        o localo = o.this;
        k localk = localo.f;
        if (localk != null)
        {
          localk.d(localo.c, (String[])paramSet.toArray(new String[0]));
          return;
        }
      }
      catch (RemoteException paramSet)
      {
        Log.w("ROOM", "Cannot broadcast invalidation", paramSet);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.o
 * JD-Core Version:    0.7.0.1
 */