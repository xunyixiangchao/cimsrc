package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService
  extends Service
{
  static final Object h = new Object();
  static final HashMap<ComponentName, h> i = new HashMap();
  b a;
  h b;
  a c;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  final ArrayList<d> g;
  
  public JobIntentService()
  {
    ArrayList localArrayList;
    if (Build.VERSION.SDK_INT >= 26) {
      localArrayList = null;
    } else {
      localArrayList = new ArrayList();
    }
    this.g = localArrayList;
  }
  
  static h d(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = i;
    h localh = (h)localHashMap.get(paramComponentName);
    Object localObject = localh;
    if (localh == null)
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        if (paramBoolean) {
          paramContext = new g(paramContext, paramComponentName, paramInt);
        } else {
          throw new IllegalArgumentException("Can't be here without a job id");
        }
      }
      else {
        paramContext = new c(paramContext, paramComponentName);
      }
      localHashMap.put(paramComponentName, paramContext);
      localObject = paramContext;
    }
    return localObject;
  }
  
  e a()
  {
    ??? = this.a;
    if (??? != null) {
      return ((b)???).a();
    }
    synchronized (this.g)
    {
      if (this.g.size() > 0)
      {
        e locale = (e)this.g.remove(0);
        return locale;
      }
      return null;
    }
  }
  
  boolean b()
  {
    a locala = this.c;
    if (locala != null) {
      locala.cancel(this.d);
    }
    this.e = true;
    return f();
  }
  
  void c(boolean paramBoolean)
  {
    if (this.c == null)
    {
      this.c = new a();
      h localh = this.b;
      if ((localh != null) && (paramBoolean)) {
        localh.c();
      }
      this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void e(Intent paramIntent);
  
  public boolean f()
  {
    return true;
  }
  
  void g()
  {
    ArrayList localArrayList1 = this.g;
    if (localArrayList1 != null) {
      try
      {
        this.c = null;
        ArrayList localArrayList2 = this.g;
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          c(false);
        } else if (!this.f) {
          this.b.b();
        }
        return;
      }
      finally {}
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = this.a;
    if (paramIntent != null) {
      return paramIntent.b();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.a = new f(this);
      this.b = null;
      return;
    }
    this.a = null;
    this.b = d(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ArrayList localArrayList = this.g;
    if (localArrayList != null) {
      try
      {
        this.f = true;
        this.b.b();
        return;
      }
      finally {}
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.g != null)
    {
      this.b.d();
      synchronized (this.g)
      {
        ArrayList localArrayList2 = this.g;
        if (paramIntent == null) {
          paramIntent = new Intent();
        }
        localArrayList2.add(new d(paramIntent, paramInt2));
        c(true);
        return 3;
      }
    }
    return 2;
  }
  
  final class a
    extends AsyncTask<Void, Void, Void>
  {
    a() {}
    
    protected Void a(Void... paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs = JobIntentService.this.a();
        if (paramVarArgs == null) {
          break;
        }
        JobIntentService.this.e(paramVarArgs.getIntent());
        paramVarArgs.a();
      }
      return null;
    }
    
    protected void b(Void paramVoid)
    {
      JobIntentService.this.g();
    }
    
    protected void c(Void paramVoid)
    {
      JobIntentService.this.g();
    }
  }
  
  static abstract interface b
  {
    public abstract JobIntentService.e a();
    
    public abstract IBinder b();
  }
  
  static final class c
    extends JobIntentService.h
  {
    private final Context d;
    private final PowerManager.WakeLock e;
    private final PowerManager.WakeLock f;
    boolean g;
    boolean h;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.d = paramContext.getApplicationContext();
      paramContext = (PowerManager)paramContext.getSystemService("power");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramComponentName.getClassName());
      ((StringBuilder)localObject).append(":launch");
      localObject = paramContext.newWakeLock(1, ((StringBuilder)localObject).toString());
      this.e = ((PowerManager.WakeLock)localObject);
      ((PowerManager.WakeLock)localObject).setReferenceCounted(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramComponentName.getClassName());
      ((StringBuilder)localObject).append(":run");
      paramContext = paramContext.newWakeLock(1, ((StringBuilder)localObject).toString());
      this.f = paramContext;
      paramContext.setReferenceCounted(false);
    }
    
    public void b()
    {
      try
      {
        if (this.h)
        {
          if (this.g) {
            this.e.acquire(60000L);
          }
          this.h = false;
          this.f.release();
        }
        return;
      }
      finally {}
    }
    
    public void c()
    {
      try
      {
        if (!this.h)
        {
          this.h = true;
          this.f.acquire(600000L);
          this.e.release();
        }
        return;
      }
      finally {}
    }
    
    public void d()
    {
      try
      {
        this.g = false;
        return;
      }
      finally {}
    }
  }
  
  final class d
    implements JobIntentService.e
  {
    final Intent a;
    final int b;
    
    d(Intent paramIntent, int paramInt)
    {
      this.a = paramIntent;
      this.b = paramInt;
    }
    
    public void a()
    {
      JobIntentService.this.stopSelf(this.b);
    }
    
    public Intent getIntent()
    {
      return this.a;
    }
  }
  
  static abstract interface e
  {
    public abstract void a();
    
    public abstract Intent getIntent();
  }
  
  static final class f
    extends JobServiceEngine
    implements JobIntentService.b
  {
    final JobIntentService a;
    final Object b = new Object();
    JobParameters c;
    
    f(JobIntentService paramJobIntentService)
    {
      super();
      this.a = paramJobIntentService;
    }
    
    public JobIntentService.e a()
    {
      synchronized (this.b)
      {
        Object localObject2 = this.c;
        if (localObject2 == null) {
          return null;
        }
        localObject2 = ((JobParameters)localObject2).dequeueWork();
        if (localObject2 != null)
        {
          ((JobWorkItem)localObject2).getIntent().setExtrasClassLoader(this.a.getClassLoader());
          return new a((JobWorkItem)localObject2);
        }
        return null;
      }
    }
    
    public IBinder b()
    {
      return getBinder();
    }
    
    public boolean onStartJob(JobParameters paramJobParameters)
    {
      this.c = paramJobParameters;
      this.a.c(false);
      return true;
    }
    
    public boolean onStopJob(JobParameters arg1)
    {
      boolean bool = this.a.b();
      synchronized (this.b)
      {
        this.c = null;
        return bool;
      }
    }
    
    final class a
      implements JobIntentService.e
    {
      final JobWorkItem a;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.a = paramJobWorkItem;
      }
      
      public void a()
      {
        synchronized (JobIntentService.f.this.b)
        {
          JobParameters localJobParameters = JobIntentService.f.this.c;
          if (localJobParameters != null) {
            localJobParameters.completeWork(this.a);
          }
          return;
        }
      }
      
      public Intent getIntent()
      {
        return this.a.getIntent();
      }
    }
  }
  
  static final class g
    extends JobIntentService.h
  {
    private final JobInfo d;
    private final JobScheduler e;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      a(paramInt);
      this.d = new JobInfo.Builder(paramInt, this.a).setOverrideDeadline(0L).build();
      this.e = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
  }
  
  static abstract class h
  {
    final ComponentName a;
    boolean b;
    int c;
    
    h(ComponentName paramComponentName)
    {
      this.a = paramComponentName;
    }
    
    void a(int paramInt)
    {
      if (!this.b)
      {
        this.b = true;
        this.c = paramInt;
        return;
      }
      if (this.c == paramInt) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Given job ID ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is different than previous ");
      localStringBuilder.append(this.c);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public void b() {}
    
    public void c() {}
    
    public void d() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */