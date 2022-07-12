package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.b.b;
import com.baidu.location.b.k;
import com.baidu.location.b.n;
import com.baidu.location.b.s;
import com.baidu.location.f;
import java.util.List;

public class i
{
  public static long a;
  private static i b;
  private WifiManager c = null;
  private a d = null;
  private h e = null;
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private ConnectivityManager i = null;
  private Handler j = new Handler();
  private boolean k = false;
  private long l = 0L;
  private long m = 0L;
  
  public static i a()
  {
    try
    {
      if (b == null) {
        b = new i();
      }
      i locali = b;
      return locali;
    }
    finally {}
  }
  
  private String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    boolean bool2 = a(paramh1, paramh2, com.baidu.location.e.h.az);
    long l1 = System.currentTimeMillis() - b.c;
    boolean bool1 = bool2;
    if (l1 > 0L)
    {
      bool1 = bool2;
      if (l1 < 30000L)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (paramh2.g() - paramh1.g() > 30L) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(h paramh1, h paramh2, float paramFloat)
  {
    if (paramh1 != null)
    {
      if (paramh2 == null) {
        return false;
      }
      List localList1 = paramh1.a;
      List localList2 = paramh2.a;
      if (localList1 == localList2) {
        return true;
      }
      if (localList1 != null)
      {
        if (localList2 == null) {
          return false;
        }
        int i4 = localList1.size();
        int i5 = localList2.size();
        if ((i4 == 0) && (i5 == 0)) {
          return true;
        }
        if (i4 != 0)
        {
          if (i5 == 0) {
            return false;
          }
          int n = 0;
          int i2;
          for (int i1 = n; n < i4; i1 = i2)
          {
            if (localList1.get(n) != null) {
              paramh1 = ((ScanResult)localList1.get(n)).BSSID;
            } else {
              paramh1 = null;
            }
            if (paramh1 == null)
            {
              i2 = i1;
            }
            else
            {
              int i3 = 0;
              for (;;)
              {
                i2 = i1;
                if (i3 >= i5) {
                  break;
                }
                if (localList2.get(i3) != null) {
                  paramh2 = ((ScanResult)localList2.get(i3)).BSSID;
                } else {
                  paramh2 = null;
                }
                if ((paramh2 != null) && (paramh1.equals(paramh2)))
                {
                  i2 = i1 + 1;
                  break;
                }
                i3 += 1;
              }
            }
            n += 1;
          }
          if (i1 >= i4 * paramFloat) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void q()
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = a((WifiManager)localObject1, System.currentTimeMillis());
      Object localObject2 = ((h)localObject1).a;
      if (localObject2 != null)
      {
        localObject2 = this.e;
        if ((localObject2 == null) || (!((h)localObject1).a((h)localObject2))) {
          this.e = ((h)localObject1);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public h a(WifiManager paramWifiManager, long paramLong)
  {
    h localh2 = new h(null, 0L);
    h localh1 = localh2;
    if (paramWifiManager != null)
    {
      localh1 = localh2;
      if (com.baidu.location.e.h.f != 4) {
        localh1 = new h(paramWifiManager.getScanResults(), paramLong);
      }
    }
    return localh1;
  }
  
  public void b()
  {
    this.l = 0L;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/baidu/location/c/i:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 172	com/baidu/location/f:isServing	Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokestatic 176	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   30: invokevirtual 181	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: ldc 183
    //   35: invokevirtual 187	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast 163	android/net/wifi/WifiManager
    //   41: putfield 39	com/baidu/location/c/i:c	Landroid/net/wifi/WifiManager;
    //   44: aload_0
    //   45: new 8	com/baidu/location/c/i$a
    //   48: dup
    //   49: aload_0
    //   50: aconst_null
    //   51: invokespecial 190	com/baidu/location/c/i$a:<init>	(Lcom/baidu/location/c/i;Lcom/baidu/location/c/i$1;)V
    //   54: putfield 41	com/baidu/location/c/i:d	Lcom/baidu/location/c/i$a;
    //   57: invokestatic 176	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   60: aload_0
    //   61: getfield 41	com/baidu/location/c/i:d	Lcom/baidu/location/c/i$a;
    //   64: new 192	android/content/IntentFilter
    //   67: dup
    //   68: ldc 194
    //   70: invokespecial 197	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 201	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   76: pop
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 49	com/baidu/location/c/i:h	Z
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_2
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: goto -14 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	i
    //   6	14	1	bool	boolean
    //   85	4	2	localObject	Object
    //   90	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	85	finally
    //   15	19	85	finally
    //   26	57	85	finally
    //   57	77	85	finally
    //   77	82	85	finally
    //   57	77	90	java/lang/Exception
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/baidu/location/c/i:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 176	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 41	com/baidu/location/c/i:d	Lcom/baidu/location/c/i$a;
    //   21: invokevirtual 205	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: lconst_0
    //   25: putstatic 207	com/baidu/location/c/i:a	J
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 41	com/baidu/location/c/i:d	Lcom/baidu/location/c/i$a;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 39	com/baidu/location/c/i:c	Landroid/net/wifi/WifiManager;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 49	com/baidu/location/c/i:h	Z
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: goto -24 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	i
    //   6	2	1	bool	boolean
    //   46	4	2	localObject	Object
    //   51	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	46	finally
    //   14	28	46	finally
    //   28	43	46	finally
    //   14	28	51	java/lang/Exception
  }
  
  public boolean e()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.g;
    if ((l1 - l2 > 0L) && (l1 - l2 <= 5000L)) {
      return false;
    }
    this.g = l1;
    b();
    return f();
  }
  
  public boolean f()
  {
    if (this.c == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    if (l1 - l2 > 0L)
    {
      long l3 = this.l;
      if (l1 - l2 <= l3 + 5000L) {
        return false;
      }
      if (l1 - a * 1000L <= l3 + 5000L) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 28) && (l1 - l2 < 25000L)) {
        return false;
      }
      if ((i()) && (l1 - this.f <= this.l + 10000L)) {
        return false;
      }
    }
    return h();
  }
  
  @SuppressLint({"NewApi"})
  public String g()
  {
    WifiManager localWifiManager = this.c;
    String str2 = "";
    String str1 = str2;
    if (localWifiManager != null) {}
    try
    {
      if (!localWifiManager.isWifiEnabled())
      {
        str1 = str2;
        if (!this.c.isScanAlwaysAvailable()) {}
      }
      else
      {
        str1 = "&wifio=1";
      }
      return str1;
    }
    catch (NoSuchMethodError|Exception localNoSuchMethodError) {}
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public boolean h()
  {
    long l1 = System.currentTimeMillis() - this.m;
    if ((l1 >= 0L) && (l1 <= 2000L)) {
      return false;
    }
    this.m = System.currentTimeMillis();
    try
    {
      if (((this.c.isWifiEnabled()) || (this.c.isScanAlwaysAvailable())) && (com.baidu.location.e.h.f != 4))
      {
        this.c.startScan();
        this.f = System.currentTimeMillis();
        return true;
      }
      return false;
    }
    catch (NoSuchMethodError|Exception localNoSuchMethodError) {}
    return false;
  }
  
  public boolean i()
  {
    boolean bool = false;
    try
    {
      if (this.i == null) {
        this.i = ((ConnectivityManager)f.getServiceContext().getSystemService("connectivity"));
      }
      ConnectivityManager localConnectivityManager = this.i;
      if (localConnectivityManager != null) {
        bool = localConnectivityManager.getNetworkInfo(1).isConnected();
      }
      return bool;
    }
    catch (Exception|Error localException) {}
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public boolean j()
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if (!this.c.isWifiEnabled())
      {
        bool1 = bool2;
        if (!this.c.isScanAlwaysAvailable()) {}
      }
      else
      {
        if (i()) {
          return false;
        }
        h localh = n();
        bool1 = bool2;
        if (localh != null)
        {
          boolean bool3 = localh.e();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (NoSuchMethodError|Exception localNoSuchMethodError) {}
    return false;
  }
  
  public WifiInfo k()
  {
    Object localObject = this.c;
    if (localObject != null) {
      if (com.baidu.location.e.h.f == 4) {
        return null;
      }
    }
    try
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null))
      {
        if (((WifiInfo)localObject).getRssi() <= -100) {
          return null;
        }
        String str = ((WifiInfo)localObject).getBSSID();
        if (str != null)
        {
          str = str.replace(":", "");
          if ((!"000000000000".equals(str)) && (!"".equals(str)))
          {
            boolean bool = str.equals("020000000000");
            if (!bool) {}
          }
          else
          {
            return null;
          }
        }
        return localObject;
      }
      return null;
    }
    catch (Exception|Error localException) {}
    return null;
  }
  
  public String l()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = a().k();
    if ((localObject1 != null) && (((WifiInfo)localObject1).getBSSID() != null))
    {
      Object localObject2 = ((WifiInfo)localObject1).getBSSID().replace(":", "");
      int i1 = ((WifiInfo)localObject1).getRssi();
      String str = a().m();
      int n = i1;
      if (i1 < 0) {
        n = -i1;
      }
      if ((localObject2 != null) && (n < 100) && (!((String)localObject2).equals("020000000000")))
      {
        localStringBuffer.append("&wf=");
        localStringBuffer.append((String)localObject2);
        localStringBuffer.append(";");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(";");
        localStringBuffer.append(((StringBuilder)localObject2).toString());
        localObject2 = ((WifiInfo)localObject1).getSSID();
        localObject1 = localObject2;
        if (localObject2 != null) {
          if (!((String)localObject2).contains("&"))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).contains(";")) {}
          }
          else
          {
            localObject1 = ((String)localObject2).replace("&", "_");
          }
        }
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append("&wf_n=1");
        if (str != null)
        {
          localStringBuffer.append("&wf_gw=");
          localStringBuffer.append(str);
        }
        return localStringBuffer.toString();
      }
    }
    return null;
  }
  
  public String m()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getDhcpInfo();
      if (localObject != null) {
        return a(((DhcpInfo)localObject).gateway);
      }
    }
    return null;
  }
  
  public h n()
  {
    h localh = this.e;
    if ((localh != null) && (localh.j())) {
      return this.e;
    }
    return p();
  }
  
  public h o()
  {
    h localh = this.e;
    if ((localh != null) && (localh.k())) {
      return this.e;
    }
    return p();
  }
  
  public h p()
  {
    Object localObject = this.c;
    if (localObject != null) {}
    try
    {
      localObject = a((WifiManager)localObject, this.f);
      return localObject;
    }
    catch (Exception localException)
    {
      label21:
      break label21;
    }
    return a(null, 0L);
  }
  
  private class a
    extends BroadcastReceiver
  {
    private long b = 0L;
    private boolean c = false;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null) {
        return;
      }
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
      {
        i.a = System.currentTimeMillis() / 1000L;
        final boolean bool = paramIntent.getBooleanExtra("resultsUpdated", true);
        i.c(i.this).post(new Runnable()
        {
          public void run()
          {
            if (!i.a(i.this)) {
              i.a(i.this, bool);
            }
            i.b(i.this);
            k.c().i();
            if (System.currentTimeMillis() - n.b() <= 5000L) {
              s.a().c();
            }
          }
        });
        return;
      }
      if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
      {
        if (!((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED)) {
          return;
        }
        if (System.currentTimeMillis() - this.b < 5000L) {
          return;
        }
        this.b = System.currentTimeMillis();
        if (!this.c) {
          this.c = true;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.i
 * JD-Core Version:    0.7.0.1
 */