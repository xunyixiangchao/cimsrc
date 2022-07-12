package q2;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import x2.f;
import x2.f.b;
import x2.l;

final class j
{
  private static volatile j d;
  private final c a;
  final Set<a.a> b = new HashSet();
  private boolean c;
  
  private j(final Context paramContext)
  {
    f.b localb = f.a(new a(paramContext));
    b localb1 = new b();
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = new d(localb, localb1);
    } else {
      paramContext = new e(paramContext, localb, localb1);
    }
    this.a = paramContext;
  }
  
  static j a(Context paramContext)
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new j(paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return d;
  }
  
  private void b()
  {
    if (!this.c)
    {
      if (this.b.isEmpty()) {
        return;
      }
      this.c = this.a.b();
    }
  }
  
  private void c()
  {
    if (this.c)
    {
      if (!this.b.isEmpty()) {
        return;
      }
      this.a.a();
      this.c = false;
    }
  }
  
  void d(a.a parama)
  {
    try
    {
      this.b.add(parama);
      b();
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  void e(a.a parama)
  {
    try
    {
      this.b.remove(parama);
      c();
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  class a
    implements f.b<ConnectivityManager>
  {
    a(Context paramContext) {}
    
    public ConnectivityManager a()
    {
      return (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
  }
  
  class b
    implements a.a
  {
    b() {}
    
    public void a(boolean paramBoolean)
    {
      synchronized (j.this)
      {
        ArrayList localArrayList = new ArrayList(j.this.b);
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((a.a)((Iterator)???).next()).a(paramBoolean);
        }
        return;
      }
    }
  }
  
  private static abstract interface c
  {
    public abstract void a();
    
    public abstract boolean b();
  }
  
  private static final class d
    implements j.c
  {
    boolean a;
    final a.a b;
    private final f.b<ConnectivityManager> c;
    private final ConnectivityManager.NetworkCallback d = new a();
    
    d(f.b<ConnectivityManager> paramb, a.a parama)
    {
      this.c = paramb;
      this.b = parama;
    }
    
    public void a()
    {
      ((ConnectivityManager)this.c.get()).unregisterNetworkCallback(this.d);
    }
    
    @SuppressLint({"MissingPermission"})
    public boolean b()
    {
      boolean bool;
      if (((ConnectivityManager)this.c.get()).getActiveNetwork() != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
      try
      {
        ((ConnectivityManager)this.c.get()).registerDefaultNetworkCallback(this.d);
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (Log.isLoggable("ConnectivityMonitor", 5)) {
          Log.w("ConnectivityMonitor", "Failed to register callback", localRuntimeException);
        }
      }
      return false;
    }
    
    class a
      extends ConnectivityManager.NetworkCallback
    {
      a() {}
      
      private void b(final boolean paramBoolean)
      {
        l.u(new a(paramBoolean));
      }
      
      void a(boolean paramBoolean)
      {
        l.b();
        j.d locald = j.d.this;
        boolean bool = locald.a;
        locald.a = paramBoolean;
        if (bool != paramBoolean) {
          locald.b.a(paramBoolean);
        }
      }
      
      public void onAvailable(Network paramNetwork)
      {
        b(true);
      }
      
      public void onLost(Network paramNetwork)
      {
        b(false);
      }
      
      class a
        implements Runnable
      {
        a(boolean paramBoolean) {}
        
        public void run()
        {
          j.d.a.this.a(paramBoolean);
        }
      }
    }
  }
  
  private static final class e
    implements j.c
  {
    private final Context a;
    final a.a b;
    private final f.b<ConnectivityManager> c;
    boolean d;
    private final BroadcastReceiver e = new a();
    
    e(Context paramContext, f.b<ConnectivityManager> paramb, a.a parama)
    {
      this.a = paramContext.getApplicationContext();
      this.c = paramb;
      this.b = parama;
    }
    
    public void a()
    {
      this.a.unregisterReceiver(this.e);
    }
    
    public boolean b()
    {
      this.d = c();
      try
      {
        this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return true;
      }
      catch (SecurityException localSecurityException)
      {
        if (Log.isLoggable("ConnectivityMonitor", 5)) {
          Log.w("ConnectivityMonitor", "Failed to register", localSecurityException);
        }
      }
      return false;
    }
    
    @SuppressLint({"MissingPermission"})
    boolean c()
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.get()).getActiveNetworkInfo();
        return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
      }
      catch (RuntimeException localRuntimeException)
      {
        if (Log.isLoggable("ConnectivityMonitor", 5)) {
          Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", localRuntimeException);
        }
      }
      return true;
    }
    
    class a
      extends BroadcastReceiver
    {
      a() {}
      
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        paramContext = j.e.this;
        boolean bool = paramContext.d;
        paramContext.d = paramContext.c();
        if (bool != j.e.this.d)
        {
          if (Log.isLoggable("ConnectivityMonitor", 3))
          {
            paramContext = new StringBuilder();
            paramContext.append("connectivity changed, isConnected: ");
            paramContext.append(j.e.this.d);
            Log.d("ConnectivityMonitor", paramContext.toString());
          }
          paramContext = j.e.this;
          paramContext.b.a(paramContext.d);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q2.j
 * JD-Core Version:    0.7.0.1
 */