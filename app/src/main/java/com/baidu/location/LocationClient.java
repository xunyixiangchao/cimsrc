package com.baidu.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.b.d;
import com.baidu.location.b.d.b;
import com.baidu.location.b.j;
import com.baidu.location.e.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
  implements d.b
{
  public static final int CONNECT_HOT_SPOT_FALSE = 0;
  public static final int CONNECT_HOT_SPOT_TRUE = 1;
  public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
  private static boolean G = false;
  public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
  public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
  public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
  public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
  private Boolean A;
  private boolean B;
  private d C;
  private boolean D;
  private boolean E;
  private boolean F;
  private ServiceConnection H;
  private long a = 0L;
  private String b = null;
  private LocationClientOption c = new LocationClientOption();
  private LocationClientOption d = new LocationClientOption();
  private boolean e = false;
  private Context f = null;
  private Messenger g = null;
  private a h;
  private final Messenger i;
  private ArrayList<BDLocationListener> j = null;
  private ArrayList<BDAbstractLocationListener> k = null;
  private BDLocation l = null;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private b p = null;
  private boolean q = false;
  private final Object r = new Object();
  private long s = 0L;
  private long t = 0L;
  private String u = null;
  private String v;
  private boolean w = false;
  private boolean x = true;
  private Boolean y;
  private Boolean z;
  
  public LocationClient(Context paramContext)
  {
    Boolean localBoolean = Boolean.FALSE;
    this.y = localBoolean;
    this.z = localBoolean;
    this.A = Boolean.TRUE;
    this.C = null;
    this.D = false;
    this.E = false;
    this.F = false;
    this.H = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        LocationClient.a(LocationClient.this, new Messenger(paramAnonymousIBinder));
        if (LocationClient.a(LocationClient.this) == null) {
          return;
        }
        LocationClient.a(LocationClient.this, true);
        Log.d("baidu_location_client", "baidu location connected ...");
        if (LocationClient.b(LocationClient.this))
        {
          LocationClient.c(LocationClient.this).obtainMessage(2).sendToTarget();
          return;
        }
        try
        {
          paramAnonymousComponentName = Message.obtain(null, 11);
          paramAnonymousComponentName.replyTo = LocationClient.d(LocationClient.this);
          paramAnonymousComponentName.setData(LocationClient.e(LocationClient.this));
          LocationClient.a(LocationClient.this).send(paramAnonymousComponentName);
          LocationClient.a(LocationClient.this, true);
          if (LocationClient.f(LocationClient.this) != null)
          {
            LocationClient.g(LocationClient.this).booleanValue();
            LocationClient.c(LocationClient.this).obtainMessage(4).sendToTarget();
          }
          return;
        }
        catch (Exception paramAnonymousComponentName) {}
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        LocationClient.a(LocationClient.this, null);
        LocationClient.a(LocationClient.this, false);
      }
    };
    c();
    this.f = paramContext;
    this.c = new LocationClientOption();
    this.d = new LocationClientOption();
    this.h = new a(Looper.getMainLooper(), this);
    this.i = new Messenger(this.h);
  }
  
  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    Boolean localBoolean = Boolean.FALSE;
    this.y = localBoolean;
    this.z = localBoolean;
    this.A = Boolean.TRUE;
    this.C = null;
    this.D = false;
    this.E = false;
    this.F = false;
    this.H = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        LocationClient.a(LocationClient.this, new Messenger(paramAnonymousIBinder));
        if (LocationClient.a(LocationClient.this) == null) {
          return;
        }
        LocationClient.a(LocationClient.this, true);
        Log.d("baidu_location_client", "baidu location connected ...");
        if (LocationClient.b(LocationClient.this))
        {
          LocationClient.c(LocationClient.this).obtainMessage(2).sendToTarget();
          return;
        }
        try
        {
          paramAnonymousComponentName = Message.obtain(null, 11);
          paramAnonymousComponentName.replyTo = LocationClient.d(LocationClient.this);
          paramAnonymousComponentName.setData(LocationClient.e(LocationClient.this));
          LocationClient.a(LocationClient.this).send(paramAnonymousComponentName);
          LocationClient.a(LocationClient.this, true);
          if (LocationClient.f(LocationClient.this) != null)
          {
            LocationClient.g(LocationClient.this).booleanValue();
            LocationClient.c(LocationClient.this).obtainMessage(4).sendToTarget();
          }
          return;
        }
        catch (Exception paramAnonymousComponentName) {}
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        LocationClient.a(LocationClient.this, null);
        LocationClient.a(LocationClient.this, false);
      }
    };
    c();
    this.f = paramContext;
    this.c = paramLocationClientOption;
    this.d = new LocationClientOption(paramLocationClientOption);
    this.h = new a(Looper.getMainLooper(), this);
    this.i = new Messenger(this.h);
  }
  
  private void a()
  {
    if (this.e == true) {
      return;
    }
    if (this.A.booleanValue())
    {
      boolean bool = h.c(this.f);
      if (this.d.isOnceLocation()) {
        bool = true;
      }
      if (!bool) {}
    }
    try
    {
      new Thread()
      {
        public void run()
        {
          try
          {
            if (LocationClient.h(LocationClient.this) != null)
            {
              LocationClient.h(LocationClient.this).a();
              LocationClient.h(LocationClient.this).c();
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }.start();
      if (this.d.isOnceLocation()) {
        return;
      }
      this.A = Boolean.FALSE;
      this.b = this.f.getPackageName();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("_bdls_v2.9");
      this.u = ((StringBuilder)localObject1).toString();
      localObject1 = new Intent(this.f, f.class);
    }
    finally
    {
      try
      {
        Object localObject1;
        ((Intent)localObject1).putExtra("debug_dev", this.B);
        label140:
        if (this.c == null) {
          this.c = new LocationClientOption();
        }
        ((Intent)localObject1).putExtra("cache_exception", this.c.isIgnoreCacheException);
        ((Intent)localObject1).putExtra("kill_process", this.c.isIgnoreKillProcess);
        try
        {
          this.f.bindService((Intent)localObject1, this.H, 1);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          this.e = false;
          return;
        }
        localObject2 = finally;
      }
      catch (Exception localException2)
      {
        break label140;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.l.getCoorType() == null) {
      this.l.setCoorType(this.c.coorType);
    }
    if ((this.m == true) || ((this.c.location_change_notify == true) && (this.l.getLocType() == 61)) || (this.l.getLocType() == 66) || (this.l.getLocType() == 67) || (this.w) || (this.l.getLocType() == 161))
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BDLocationListener)((Iterator)localObject).next()).onReceiveLocation(this.l);
        }
      }
      localObject = this.k;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BDAbstractLocationListener)((Iterator)localObject).next()).onReceiveLocation(this.l);
        }
      }
      if (this.l.getLocType() != 66)
      {
        if (this.l.getLocType() == 67) {
          return;
        }
        this.m = false;
        this.t = System.currentTimeMillis();
      }
    }
  }
  
  private void a(int paramInt, Notification paramNotification)
  {
    try
    {
      Intent localIntent = new Intent(this.f, f.class);
      localIntent.putExtra("notification", paramNotification);
      localIntent.putExtra("id", paramInt);
      localIntent.putExtra("command", 1);
      if (Build.VERSION.SDK_INT >= 26) {
        this.f.startForegroundService(localIntent);
      } else {
        this.f.startService(localIntent);
      }
      this.F = true;
      return;
    }
    catch (Exception paramNotification) {}
  }
  
  private void a(Message paramMessage)
  {
    this.n = false;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = (LocationClientOption)paramMessage;
      if ((!this.c.optionEquals(paramMessage)) && (this.c.scanSpan == paramMessage.scanSpan)) {}
    }
    try
    {
      synchronized (this.r)
      {
        if (this.o == true)
        {
          this.h.removeCallbacks(this.p);
          this.o = false;
        }
        if ((paramMessage.scanSpan >= 1000) && (!this.o))
        {
          if (this.p == null) {
            this.p = new b(null);
          }
          this.h.postDelayed(this.p, paramMessage.scanSpan);
          this.o = true;
        }
      }
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.c = new LocationClientOption(paramMessage);
    if (this.g == null) {
      return;
    }
    try
    {
      paramMessage = Message.obtain(null, 15);
      paramMessage.replyTo = this.i;
      paramMessage.setData(d());
      this.g.send(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void a(Message paramMessage, int paramInt)
  {
    if (!this.e) {
      return;
    }
    try
    {
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(BDLocation.class.getClassLoader());
      paramMessage = (BDLocation)paramMessage.getParcelable("locStr");
      this.l = paramMessage;
      if (paramMessage.getLocType() == 61) {
        this.s = System.currentTimeMillis();
      }
      if ((this.l.getLocType() == 61) || (this.l.getLocType() == 161)) {
        com.baidu.location.b.a.a().a(this.l.getLatitude(), this.l.getLongitude(), this.l.getCoorType());
      }
      a(paramInt);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void a(BDLocation paramBDLocation)
  {
    if (this.x) {
      return;
    }
    this.l = paramBDLocation;
    if ((!this.E) && (paramBDLocation.getLocType() == 161))
    {
      this.D = true;
      com.baidu.location.b.a.a().a(paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), paramBDLocation.getCoorType());
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BDLocationListener)((Iterator)localObject).next()).onReceiveLocation(paramBDLocation);
      }
    }
    localObject = this.k;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BDAbstractLocationListener)((Iterator)localObject).next()).onReceiveLocation(paramBDLocation);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(this.f, f.class);
      localIntent.putExtra("removenotify", paramBoolean);
      localIntent.putExtra("command", 2);
      this.f.startService(localIntent);
      this.F = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/baidu/location/LocationClient:e	Z
    //   4: ifeq +165 -> 169
    //   7: aload_0
    //   8: getfield 114	com/baidu/location/LocationClient:g	Landroid/os/Messenger;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: bipush 12
    //   18: invokestatic 372	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 189	com/baidu/location/LocationClient:i	Landroid/os/Messenger;
    //   27: putfield 375	android/os/Message:replyTo	Landroid/os/Messenger;
    //   30: aload_0
    //   31: getfield 114	com/baidu/location/LocationClient:g	Landroid/os/Messenger;
    //   34: aload_2
    //   35: invokevirtual 385	android/os/Messenger:send	(Landroid/os/Message;)V
    //   38: goto +8 -> 46
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   46: aload_0
    //   47: getfield 112	com/baidu/location/LocationClient:f	Landroid/content/Context;
    //   50: aload_0
    //   51: getfield 169	com/baidu/location/LocationClient:H	Landroid/content/ServiceConnection;
    //   54: invokevirtual 444	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   57: aload_0
    //   58: getfield 164	com/baidu/location/LocationClient:F	Z
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +31 -> 94
    //   66: new 237	android/content/Intent
    //   69: dup
    //   70: aload_0
    //   71: getfield 112	com/baidu/location/LocationClient:f	Landroid/content/Context;
    //   74: ldc 239
    //   76: invokespecial 242	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   79: astore_2
    //   80: aload_0
    //   81: getfield 112	com/baidu/location/LocationClient:f	Landroid/content/Context;
    //   84: aload_2
    //   85: invokevirtual 448	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   88: pop
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 164	com/baidu/location/LocationClient:F	Z
    //   94: aload_0
    //   95: getfield 132	com/baidu/location/LocationClient:r	Ljava/lang/Object;
    //   98: astore_2
    //   99: aload_2
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 126	com/baidu/location/LocationClient:o	Z
    //   105: iconst_1
    //   106: if_icmpne +26 -> 132
    //   109: aload_0
    //   110: getfield 182	com/baidu/location/LocationClient:h	Lcom/baidu/location/LocationClient$a;
    //   113: aload_0
    //   114: getfield 128	com/baidu/location/LocationClient:p	Lcom/baidu/location/LocationClient$b;
    //   117: invokevirtual 361	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 126	com/baidu/location/LocationClient:o	Z
    //   125: goto +7 -> 132
    //   128: astore_3
    //   129: goto +36 -> 165
    //   132: aload_2
    //   133: monitorexit
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 114	com/baidu/location/LocationClient:g	Landroid/os/Messenger;
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 124	com/baidu/location/LocationClient:n	Z
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield 140	com/baidu/location/LocationClient:w	Z
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 110	com/baidu/location/LocationClient:e	Z
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 160	com/baidu/location/LocationClient:D	Z
    //   159: aload_0
    //   160: iconst_0
    //   161: putfield 162	com/baidu/location/LocationClient:E	Z
    //   164: return
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_3
    //   168: athrow
    //   169: return
    //   170: astore_2
    //   171: goto -77 -> 94
    //   174: astore_2
    //   175: goto -86 -> 89
    //   178: astore_3
    //   179: goto -47 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	LocationClient
    //   61	2	1	bool	boolean
    //   21	14	2	localMessage	Message
    //   41	2	2	localException1	Exception
    //   170	1	2	localException2	Exception
    //   174	1	2	localException3	Exception
    //   128	40	3	localObject2	Object
    //   178	1	3	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	41	java/lang/Exception
    //   101	125	128	finally
    //   132	134	128	finally
    //   165	167	128	finally
    //   46	62	170	java/lang/Exception
    //   89	94	170	java/lang/Exception
    //   66	89	174	java/lang/Exception
    //   101	125	178	java/lang/Exception
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = (BDLocationListener)paramMessage;
      if (this.j == null) {
        this.j = new ArrayList();
      }
      if (!this.j.contains(paramMessage)) {
        this.j.add(paramMessage);
      }
    }
  }
  
  private void c()
  {
    if (G) {
      return;
    }
    Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
  }
  
  private void c(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = (BDAbstractLocationListener)paramMessage;
      if (this.k == null) {
        this.k = new ArrayList();
      }
      if (!this.k.contains(paramMessage)) {
        this.k.add(paramMessage);
      }
    }
  }
  
  private Bundle d()
  {
    if (this.c == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.b);
    localBundle.putString("prodName", this.c.prodName);
    localBundle.putString("coorType", this.c.coorType);
    localBundle.putString("addrType", this.c.addrType);
    localBundle.putBoolean("openGPS", this.c.openGps);
    localBundle.putBoolean("location_change_notify", this.c.location_change_notify);
    localBundle.putInt("scanSpan", this.c.scanSpan);
    localBundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
    localBundle.putInt("timeOut", this.c.timeOut);
    localBundle.putInt("priority", this.c.priority);
    localBundle.putBoolean("map", this.y.booleanValue());
    localBundle.putBoolean("import", this.z.booleanValue());
    localBundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
    localBundle.putBoolean("isneedaptag", this.c.isNeedAptag);
    localBundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
    localBundle.putBoolean("isneedregular", this.c.isNeedRegular);
    localBundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
    localBundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
    localBundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
    localBundle.putInt("autoNotifyMaxInterval", this.c.a());
    localBundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
    localBundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
    localBundle.putFloat("autoNotifyLocSensitivity", this.c.b());
    localBundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
    localBundle.putInt("wfnum", com.baidu.location.b.a.a().b);
    localBundle.putBoolean("ischeckper", com.baidu.location.b.a.a().a);
    localBundle.putFloat("wfsm", (float)com.baidu.location.b.a.a().c);
    localBundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f);
    localBundle.putInt("gnmcon", com.baidu.location.b.a.a().g);
    localBundle.putInt("iupl", com.baidu.location.b.a.a().h);
    localBundle.putInt("lpcs", com.baidu.location.b.a.a().e);
    localBundle.putInt("hpdts", com.baidu.location.b.a.a().o);
    localBundle.putInt("oldts", com.baidu.location.b.a.a().p);
    return localBundle;
  }
  
  private void d(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = (BDAbstractLocationListener)paramMessage;
      ArrayList localArrayList = this.k;
      if ((localArrayList != null) && (localArrayList.contains(paramMessage))) {
        this.k.remove(paramMessage);
      }
    }
  }
  
  private void e()
  {
    if (this.g == null) {
      return;
    }
    Object localObject2;
    if (((System.currentTimeMillis() - this.s > 3000L) || (!this.c.location_change_notify) || (this.n)) && ((!this.w) || (System.currentTimeMillis() - this.t > 20000L) || (this.n)))
    {
      Message localMessage = Message.obtain(null, 22);
      if (this.n)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("isWaitingLocTag", this.n);
        this.n = false;
        localMessage.setData((Bundle)localObject2);
      }
      try
      {
        localMessage.replyTo = this.i;
        this.g.send(localMessage);
        this.a = System.currentTimeMillis();
        this.m = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    synchronized (this.r)
    {
      localObject2 = this.c;
      if ((localObject2 != null) && (((LocationClientOption)localObject2).scanSpan >= 1000) && (!this.o))
      {
        if (this.p == null) {
          this.p = new b(null);
        }
        this.h.postDelayed(this.p, this.c.scanSpan);
        this.o = true;
      }
      return;
    }
  }
  
  private void e(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      paramMessage = (BDLocationListener)paramMessage;
      ArrayList localArrayList = this.j;
      if ((localArrayList != null) && (localArrayList.contains(paramMessage))) {
        this.j.remove(paramMessage);
      }
    }
  }
  
  public static BDLocation getBDLocationInCoorType(BDLocation paramBDLocation, String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramBDLocation);
    paramBDLocation = Jni.coorEncrypt(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), paramString);
    localBDLocation.setLatitude(paramBDLocation[1]);
    localBDLocation.setLongitude(paramBDLocation[0]);
    return localBDLocation;
  }
  
  public static void setAgreePrivacy(boolean paramBoolean)
  {
    G = paramBoolean;
  }
  
  public void disableAssistantLocation()
  {
    j.a().b();
  }
  
  public void disableLocInForeground(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("removenotify", paramBoolean);
    Message localMessage = this.h.obtainMessage(704);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void enableAssistantLocation(WebView paramWebView)
  {
    j.a().a(this.f, paramWebView, this);
  }
  
  public void enableLocInForeground(int paramInt, Notification paramNotification)
  {
    if ((paramInt > 0) && (paramNotification != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      localBundle.putParcelable("notification", paramNotification);
      paramNotification = this.h.obtainMessage(703);
      paramNotification.setData(localBundle);
      paramNotification.sendToTarget();
      return;
    }
    Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
  }
  
  public String getAccessKey()
  {
    try
    {
      String str = com.baidu.location.a.a.b(this.f);
      this.v = str;
      if (!TextUtils.isEmpty(str)) {
        return String.format("KEY=%s", new Object[] { this.v });
      }
      throw new IllegalStateException("please setting key from Manifest.xml");
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public BDLocation getLastKnownLocation()
  {
    return this.l;
  }
  
  public LocationClientOption getLocOption()
  {
    return this.c;
  }
  
  public String getVersion()
  {
    return "9.3.0.3";
  }
  
  public boolean isStarted()
  {
    return this.e;
  }
  
  public void onReceiveLightLocString(String paramString) {}
  
  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    if ((this.E == true) && (!this.D)) {
      return;
    }
    if (paramBDLocation == null) {
      return;
    }
    Message localMessage = this.h.obtainMessage(701);
    localMessage.obj = paramBDLocation;
    localMessage.sendToTarget();
  }
  
  public void registerLocationListener(BDAbstractLocationListener paramBDAbstractLocationListener)
  {
    if (paramBDAbstractLocationListener != null)
    {
      Message localMessage = this.h.obtainMessage(1300);
      localMessage.obj = paramBDAbstractLocationListener;
      localMessage.sendToTarget();
      return;
    }
    throw new IllegalStateException("please set a non-null listener");
  }
  
  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener != null)
    {
      Message localMessage = this.h.obtainMessage(5);
      localMessage.obj = paramBDLocationListener;
      localMessage.sendToTarget();
      return;
    }
    throw new IllegalStateException("please set a non-null listener");
  }
  
  public boolean requestHotSpotState()
  {
    if (this.g != null) {
      if (!this.e) {
        return false;
      }
    }
    try
    {
      Message localMessage = Message.obtain(null, 406);
      this.g.send(localMessage);
      return true;
    }
    catch (Exception localException) {}
    return false;
    return false;
  }
  
  public int requestLocation()
  {
    if (this.g != null)
    {
      if (this.i == null) {
        return 1;
      }
      Object localObject = this.j;
      if ((localObject == null) || (((ArrayList)localObject).size() < 1))
      {
        localObject = this.k;
        if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {}
      }
      else
      {
        if (System.currentTimeMillis() - this.a < 1000L) {
          return 6;
        }
        this.n = true;
        localObject = this.h.obtainMessage(4);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).sendToTarget();
        return 0;
      }
      return 2;
    }
    return 1;
  }
  
  public void restart()
  {
    stop();
    this.x = false;
    this.h.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    LocationClientOption localLocationClientOption = paramLocationClientOption;
    if (paramLocationClientOption == null) {
      localLocationClientOption = new LocationClientOption();
    }
    if (localLocationClientOption.a() > 0)
    {
      localLocationClientOption.setScanSpan(0);
      localLocationClientOption.setLocationNotify(true);
    }
    this.d = new LocationClientOption(localLocationClientOption);
    paramLocationClientOption = this.h.obtainMessage(3);
    paramLocationClientOption.obj = localLocationClientOption;
    paramLocationClientOption.sendToTarget();
  }
  
  public void start()
  {
    this.x = false;
    LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(G);
    com.baidu.location.b.a.a().a(this.f, this.d, null);
    new c(null).start();
  }
  
  public void stop()
  {
    this.x = true;
    this.h.obtainMessage(2).sendToTarget();
    this.C = null;
  }
  
  public void unRegisterLocationListener(BDAbstractLocationListener paramBDAbstractLocationListener)
  {
    if (paramBDAbstractLocationListener != null)
    {
      Message localMessage = this.h.obtainMessage(1400);
      localMessage.obj = paramBDAbstractLocationListener;
      localMessage.sendToTarget();
      return;
    }
    throw new IllegalStateException("please set a non-null listener");
  }
  
  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener != null)
    {
      Message localMessage = this.h.obtainMessage(6);
      localMessage.obj = paramBDLocationListener;
      localMessage.sendToTarget();
      return;
    }
    throw new IllegalStateException("please set a non-null listener");
  }
  
  public boolean updateLocation(Location paramLocation)
  {
    if ((this.g != null) && (this.i != null) && (paramLocation != null))
    {
      try
      {
        Message localMessage = Message.obtain(null, 57);
        localMessage.obj = paramLocation;
        this.g.send(localMessage);
      }
      catch (Exception paramLocation)
      {
        paramLocation.printStackTrace();
      }
      return true;
    }
    return false;
  }
  
  private static class a
    extends Handler
  {
    private final WeakReference<LocationClient> a;
    
    a(Looper paramLooper, LocationClient paramLocationClient)
    {
      super();
      this.a = new WeakReference(paramLocationClient);
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject1 = (LocationClient)this.a.get();
      if (localObject1 == null) {
        return;
      }
      int i = paramMessage.what;
      boolean bool = true;
      if (i != 21) {
        if (i != 303) {
          if (i != 406) {
            if (i != 701) {
              if (i != 1300) {
                if (i != 1400) {
                  if (i != 54)
                  {
                    bool = false;
                    if (i != 55) {
                      if (i != 703) {
                        if (i != 704)
                        {
                          switch (i)
                          {
                          default: 
                            super.handleMessage(paramMessage);
                            return;
                          case 6: 
                            LocationClient.c((LocationClient)localObject1, paramMessage);
                            return;
                          case 5: 
                            LocationClient.b((LocationClient)localObject1, paramMessage);
                            return;
                          case 4: 
                            LocationClient.r((LocationClient)localObject1);
                            return;
                          case 3: 
                            LocationClient.a((LocationClient)localObject1, paramMessage);
                            return;
                          case 2: 
                            LocationClient.q((LocationClient)localObject1);
                            return;
                          }
                          LocationClient.p((LocationClient)localObject1);
                          return;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        LocationClient.e((LocationClient)localObject1, paramMessage.getData().getBoolean("removenotify"));
        return;
      }
      catch (Exception paramMessage) {}
      paramMessage = paramMessage.getData();
      i = paramMessage.getInt("id", 0);
      if (i > 0)
      {
        LocationClient.a((LocationClient)localObject1, i, (Notification)paramMessage.getParcelable("notification"));
        return;
        if (LocationClient.f((LocationClient)localObject1).location_change_notify) {
          if (LocationClient.f((LocationClient)localObject1).location_change_notify)
          {
            LocationClient.c((LocationClient)localObject1, bool);
            return;
            LocationClient.e((LocationClient)localObject1, paramMessage);
            return;
            LocationClient.d((LocationClient)localObject1, paramMessage);
            return;
            LocationClient.a((LocationClient)localObject1, (BDLocation)paramMessage.obj);
            return;
            Object localObject2 = paramMessage.getData();
            byte[] arrayOfByte = ((Bundle)localObject2).getByteArray("mac");
            paramMessage = null;
            if (arrayOfByte != null) {
              paramMessage = new String(arrayOfByte, "UTF-8");
            }
            i = ((Bundle)localObject2).getInt("hotspot", -1);
            if (LocationClient.m((LocationClient)localObject1) != null)
            {
              localObject1 = LocationClient.m((LocationClient)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((BDAbstractLocationListener)((Iterator)localObject1).next()).onConnectHotSpotMessage(paramMessage, i);
              }
              paramMessage = paramMessage.getData();
              i = paramMessage.getInt("loctype");
              int j = paramMessage.getInt("diagtype");
              paramMessage = paramMessage.getByteArray("diagmessage");
              if ((i > 0) && (j > 0) && (paramMessage != null) && (LocationClient.m((LocationClient)localObject1) != null))
              {
                localObject1 = LocationClient.m((LocationClient)localObject1).iterator();
                while (((Iterator)localObject1).hasNext()) {
                  ((BDAbstractLocationListener)((Iterator)localObject1).next()).onLocDiagnosticMessage(i, j, new String(paramMessage, "UTF-8"));
                }
                localObject2 = paramMessage.getData();
                ((Bundle)localObject2).setClassLoader(BDLocation.class.getClassLoader());
                localObject2 = (BDLocation)((Bundle)localObject2).getParcelable("locStr");
                if ((!LocationClient.s((LocationClient)localObject1)) && (LocationClient.t((LocationClient)localObject1) == true) && (((BDLocation)localObject2).getLocType() == 66)) {
                  return;
                }
                if ((!LocationClient.s((LocationClient)localObject1)) && (LocationClient.t((LocationClient)localObject1) == true))
                {
                  LocationClient.d((LocationClient)localObject1, true);
                  return;
                }
                if (!LocationClient.s((LocationClient)localObject1)) {
                  LocationClient.d((LocationClient)localObject1, true);
                }
                LocationClient.a((LocationClient)localObject1, paramMessage, 21);
              }
            }
          }
        }
      }
      return;
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      synchronized (LocationClient.k(LocationClient.this))
      {
        LocationClient.b(LocationClient.this, false);
        if ((LocationClient.a(LocationClient.this) != null) && (LocationClient.d(LocationClient.this) != null))
        {
          if (((LocationClient.l(LocationClient.this) != null) && (LocationClient.l(LocationClient.this).size() >= 1)) || ((LocationClient.m(LocationClient.this) != null) && (LocationClient.m(LocationClient.this).size() >= 1)))
          {
            if (LocationClient.n(LocationClient.this))
            {
              if (LocationClient.o(LocationClient.this) == null)
              {
                LocationClient localLocationClient = LocationClient.this;
                LocationClient.a(localLocationClient, new b(localLocationClient));
              }
              LocationClient.c(LocationClient.this).postDelayed(LocationClient.o(LocationClient.this), LocationClient.f(LocationClient.this).scanSpan);
              return;
            }
            LocationClient.c(LocationClient.this).obtainMessage(4).sendToTarget();
            return;
          }
          return;
        }
        return;
      }
    }
  }
  
  private class c
    extends Thread
  {
    private c() {}
    
    public void run()
    {
      try
      {
        if (LocationClient.g(LocationClient.this).booleanValue())
        {
          if (LocationClient.h(LocationClient.this) == null) {
            LocationClient.a(LocationClient.this, new d(LocationClient.i(LocationClient.this), LocationClient.j(LocationClient.this), LocationClient.this, null));
          }
          if (LocationClient.j(LocationClient.this).firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC)
          {
            LocationClient.h(LocationClient.this).d();
            LocationClient.h(LocationClient.this).e();
          }
        }
        LocationClient.c(LocationClient.this).obtainMessage(1).sendToTarget();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.LocationClient
 * JD-Core Version:    0.7.0.1
 */