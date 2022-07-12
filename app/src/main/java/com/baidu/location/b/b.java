package com.baidu.location.b;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.PoiRegion;
import com.baidu.location.a.a;
import com.baidu.location.c.d;
import com.baidu.location.c.i;
import com.baidu.location.e.h;
import com.baidu.location.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static long c = 0L;
  public static int d = -1;
  private static b f;
  public boolean a = false;
  boolean b = false;
  int e = 0;
  private ArrayList<a> g = null;
  private boolean h = false;
  private BDLocation i = null;
  private BDLocation j = null;
  private Object k = new Object();
  private BDLocation l = null;
  private boolean m = false;
  private boolean n = false;
  private b o = null;
  
  private a a(Messenger paramMessenger)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        boolean bool = locala.b.equals(paramMessenger);
        if (bool) {
          return locala;
        }
      }
    }
    catch (Exception paramMessenger)
    {
      paramMessenger.printStackTrace();
    }
    return null;
  }
  
  public static b a()
  {
    if (f == null) {
      f = new b();
    }
    return f;
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.k)
    {
      if (a(parama.b) != null)
      {
        a.a(parama, 14);
      }
      else
      {
        this.g.add(parama);
        a.a(parama, 13);
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("com.baidu.location.flp.log");
    localIntent.setPackage("com.baidu.baidulocationdemo");
    localIntent.putExtra("data", paramString);
    localIntent.putExtra("pack", com.baidu.location.e.b.e);
    localIntent.putExtra("tag", "state");
    f.getServiceContext().sendBroadcast(localIntent);
  }
  
  private void e()
  {
    f();
    d();
    g();
  }
  
  private void f()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    try
    {
      Iterator localIterator = this.g.iterator();
      bool1 = false;
      for (;;)
      {
        bool3 = bool2;
        bool5 = bool2;
        bool4 = bool1;
        try
        {
          if (!localIterator.hasNext()) {
            break label112;
          }
          bool3 = bool2;
          LocationClientOption localLocationClientOption = ((a)localIterator.next()).c;
          bool4 = bool2;
          bool3 = bool2;
          if (localLocationClientOption.openGps) {
            bool4 = true;
          }
          bool3 = bool4;
          bool5 = localLocationClientOption.location_change_notify;
          bool2 = bool4;
          if (bool5)
          {
            bool1 = true;
            bool2 = bool4;
          }
        }
        catch (Exception localException1) {}
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      bool1 = false;
    }
    boolean bool4 = bool1;
    boolean bool5 = bool3;
    label112:
    h.a = bool4;
    if (this.h != bool5)
    {
      this.h = bool5;
      d.a().a(this.h);
    }
  }
  
  private void g()
  {
    try
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        h.f = Math.min(h.f, locala.c.priority);
      }
      if (!f.isServing)
      {
        h.f = 4;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.g.iterator();
      try
      {
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          a.a(locala, paramInt, paramBundle);
          if (locala.d > 4) {
            localIterator.remove();
          }
        }
      }
      catch (Exception paramBundle)
      {
        label64:
        break label64;
      }
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (paramMessage.replyTo == null) {
        return;
      }
      c = System.currentTimeMillis();
      this.a = true;
      i.a().b();
      a(new a(paramMessage));
      e();
      if (this.m)
      {
        a("start");
        this.e = 0;
      }
    }
  }
  
  public void a(BDLocation paramBDLocation)
  {
    b(paramBDLocation);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    d = i1;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/baidu/location/b/b:k	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/baidu/location/b/b:g	Ljava/util/ArrayList;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +7 -> 20
    //   16: aload_2
    //   17: invokevirtual 243	java/util/ArrayList:clear	()V
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 51	com/baidu/location/b/b:i	Lcom/baidu/location/BDLocation;
    //   27: aload_0
    //   28: invokespecial 232	com/baidu/location/b/b:e	()V
    //   31: return
    //   32: astore_2
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    //   37: astore_2
    //   38: goto -18 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	b
    //   4	30	1	localObject1	Object
    //   11	6	2	localArrayList	ArrayList
    //   32	4	2	localObject2	Object
    //   37	1	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	22	32	finally
    //   33	35	32	finally
    //   7	12	37	finally
    //   16	20	37	finally
  }
  
  public void b(Message paramMessage)
  {
    synchronized (this.k)
    {
      paramMessage = a(paramMessage.replyTo);
      if (paramMessage != null) {
        this.g.remove(paramMessage);
      }
      m.a().c();
      e();
      if (this.m)
      {
        a("stop");
        this.e = 0;
      }
      return;
    }
  }
  
  public void b(BDLocation paramBDLocation)
  {
    if ((paramBDLocation != null) && (paramBDLocation.getLocType() == 161) && (!a.a().b()))
    {
      if (this.j == null)
      {
        ??? = new BDLocation();
        this.j = ((BDLocation)???);
        ((BDLocation)???).setLocType(505);
      }
      synchronized (this.k)
      {
        Object localObject2 = this.g.iterator();
        try
        {
          while (((Iterator)localObject2).hasNext())
          {
            locala = (a)((Iterator)localObject2).next();
            locala.a(this.j);
            if (locala.d > 4) {
              ((Iterator)localObject2).remove();
            }
          }
        }
        catch (Exception localException1)
        {
          a locala;
          label116:
          break label116;
        }
      }
    }
    synchronized (this.k)
    {
      localObject2 = this.g.iterator();
      try
      {
        while (((Iterator)localObject2).hasNext())
        {
          locala = (a)((Iterator)localObject2).next();
          locala.a(paramBDLocation);
          if (locala.d > 4) {
            ((Iterator)localObject2).remove();
          }
        }
      }
      catch (Exception localException2)
      {
        label189:
        boolean bool;
        break label189;
      }
      bool = k.h;
      if (bool) {
        k.h = false;
      }
      if ((h.W >= 10000) && ((paramBDLocation.getLocType() == 61) || (paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66)))
      {
        ??? = this.i;
        if (??? != null)
        {
          localObject2 = new float[1];
          Location.distanceBetween(((BDLocation)???).getLatitude(), this.i.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject2);
          if ((localObject2[0] <= h.Y) && (!bool)) {
            return;
          }
          this.i = null;
          paramBDLocation = new BDLocation(paramBDLocation);
        }
        else
        {
          paramBDLocation = new BDLocation(paramBDLocation);
        }
        this.i = paramBDLocation;
      }
      return;
    }
  }
  
  public String c()
  {
    Object localObject = new StringBuffer(256);
    if (this.g.isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&prod=");
      ((StringBuilder)localObject).append(com.baidu.location.e.b.f);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(com.baidu.location.e.b.e);
      return ((StringBuilder)localObject).toString();
    }
    String str1 = ((StringBuffer)localObject).toString();
    try
    {
      a locala = (a)this.g.get(0);
      String str2 = locala.c.prodName;
      if (str2 != null) {
        ((StringBuffer)localObject).append(str2);
      }
      if (locala.a != null)
      {
        ((StringBuffer)localObject).append(":");
        ((StringBuffer)localObject).append(locala.a);
        ((StringBuffer)localObject).append("|");
      }
      if ((str1 != null) && (!str1.equals("")))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&prod=");
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(str1);
        return ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&prod=");
        ((StringBuilder)localObject).append(com.baidu.location.e.b.f);
        ((StringBuilder)localObject).append(":");
        str1 = com.baidu.location.e.b.e;
      }
    }
    catch (Exception localException)
    {
      label216:
      break label216;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&prod=");
    ((StringBuilder)localObject).append(com.baidu.location.e.b.f);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(com.baidu.location.e.b.e);
    return ((StringBuilder)localObject).toString();
  }
  
  public void c(BDLocation paramBDLocation)
  {
    Address localAddress = k.c().a(paramBDLocation);
    String str = k.c().f();
    List localList = k.c().g();
    PoiRegion localPoiRegion = k.c().h();
    if (localAddress != null) {
      paramBDLocation.setAddr(localAddress);
    }
    if (str != null) {
      paramBDLocation.setLocationDescribe(str);
    }
    if (localList != null) {
      paramBDLocation.setPoiList(localList);
    }
    if (localPoiRegion != null) {
      paramBDLocation.setPoiRegion(localPoiRegion);
    }
    a(paramBDLocation);
    k.c().c(paramBDLocation);
  }
  
  public boolean c(Message paramMessage)
  {
    a locala = a(paramMessage.replyTo);
    boolean bool3 = false;
    boolean bool2 = false;
    if (locala == null) {
      return false;
    }
    Object localObject = locala.c;
    int i1 = ((LocationClientOption)localObject).scanSpan;
    ((LocationClientOption)localObject).scanSpan = paramMessage.getData().getInt("scanSpan", locala.c.scanSpan);
    if (locala.c.scanSpan < 1000)
    {
      m.a().c();
      this.a = false;
    }
    else
    {
      this.a = true;
    }
    localObject = locala.c;
    boolean bool1 = bool3;
    if (((LocationClientOption)localObject).scanSpan > 999)
    {
      bool1 = bool3;
      if (i1 < 1000)
      {
        if ((((LocationClientOption)localObject).mIsNeedDeviceDirect) || (((LocationClientOption)localObject).isNeedAltitude))
        {
          m.a().a(locala.c.mIsNeedDeviceDirect);
          m.a().b();
        }
        if (!this.b)
        {
          bool1 = bool2;
          if (!locala.c.isNeedAltitude) {}
        }
        else
        {
          bool1 = true;
        }
        this.b = bool1;
        bool1 = true;
      }
    }
    locala.c.openGps = paramMessage.getData().getBoolean("openGPS", locala.c.openGps);
    localObject = paramMessage.getData().getString("coorType");
    LocationClientOption localLocationClientOption = locala.c;
    if ((localObject == null) || (((String)localObject).equals(""))) {
      localObject = locala.c.coorType;
    }
    localLocationClientOption.coorType = ((String)localObject);
    localObject = paramMessage.getData().getString("addrType");
    localLocationClientOption = locala.c;
    if ((localObject == null) || (((String)localObject).equals(""))) {
      localObject = locala.c.addrType;
    }
    localLocationClientOption.addrType = ((String)localObject);
    if (!h.e.equals(locala.c.addrType)) {
      k.c().k();
    }
    locala.c.timeOut = paramMessage.getData().getInt("timeOut", locala.c.timeOut);
    locala.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify", locala.c.location_change_notify);
    locala.c.priority = paramMessage.getData().getInt("priority", locala.c.priority);
    h.f = locala.c.priority;
    i1 = paramMessage.getData().getInt("wifitimeout", 2147483647);
    if (i1 < h.af) {
      h.af = i1;
    }
    e();
    return bool1;
  }
  
  public int d(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.replyTo;
      if (paramMessage == null) {
        return 1;
      }
      paramMessage = a(paramMessage);
      if (paramMessage != null)
      {
        if (paramMessage.c == null) {
          return 1;
        }
        return h.f;
      }
    }
    return 1;
  }
  
  public void d()
  {
    try
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d(BDLocation paramBDLocation)
  {
    c(paramBDLocation);
  }
  
  public int e(Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramMessage = paramMessage.replyTo;
      if (paramMessage == null) {
        return 1000;
      }
      paramMessage = a(paramMessage);
      if (paramMessage != null)
      {
        paramMessage = paramMessage.c;
        if (paramMessage == null) {
          return 1000;
        }
        return paramMessage.scanSpan;
      }
    }
    return 1000;
  }
  
  private class a
  {
    public String a = null;
    public Messenger b = null;
    public LocationClientOption c = new LocationClientOption();
    public int d = 0;
    
    public a(Message paramMessage)
    {
      this.b = paramMessage.replyTo;
      this.a = paramMessage.getData().getString("packName");
      this.c.prodName = paramMessage.getData().getString("prodName");
      com.baidu.location.e.b.a().a(this.c.prodName, this.a);
      this.c.coorType = paramMessage.getData().getString("coorType");
      this.c.addrType = paramMessage.getData().getString("addrType");
      this.c.enableSimulateGps = paramMessage.getData().getBoolean("enableSimulateGps", false);
      if ((!h.l) && (!this.c.enableSimulateGps)) {
        bool = false;
      } else {
        bool = true;
      }
      h.l = bool;
      if (!h.e.equals("all")) {
        h.e = this.c.addrType;
      }
      this.c.openGps = paramMessage.getData().getBoolean("openGPS");
      this.c.scanSpan = paramMessage.getData().getInt("scanSpan");
      this.c.timeOut = paramMessage.getData().getInt("timeOut");
      this.c.priority = paramMessage.getData().getInt("priority");
      this.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify");
      this.c.mIsNeedDeviceDirect = paramMessage.getData().getBoolean("needDirect", false);
      this.c.isNeedAltitude = paramMessage.getData().getBoolean("isneedaltitude", false);
      this.c.isNeedNewVersionRgc = paramMessage.getData().getBoolean("isneednewrgc", false);
      if ((!h.h) && (!this.c.isNeedNewVersionRgc)) {
        bool = false;
      } else {
        bool = true;
      }
      h.h = bool;
      if ((!h.g) && (!paramMessage.getData().getBoolean("isneedaptag", false))) {
        bool = false;
      } else {
        bool = true;
      }
      h.g = bool;
      if ((!h.i) && (!paramMessage.getData().getBoolean("isneedaptagd", false))) {
        bool = false;
      } else {
        bool = true;
      }
      h.i = bool;
      h.R = paramMessage.getData().getFloat("autoNotifyLocSensitivity", 0.5F);
      int i = paramMessage.getData().getInt("wfnum", h.ay);
      float f = paramMessage.getData().getFloat("wfsm", h.az);
      int j = paramMessage.getData().getInt("gnmcon", h.aB);
      double d1 = paramMessage.getData().getDouble("gnmcrm", h.aA);
      int k = paramMessage.getData().getInt("iupl", 1);
      h.aG = paramMessage.getData().getInt("ct", 10);
      h.aH = paramMessage.getData().getInt("suci", 3);
      h.aJ = paramMessage.getData().getDoubleArray("cgs");
      h.aK = paramMessage.getData().getInt("ums", 1);
      h.aI = paramMessage.getData().getInt("smn", 40);
      if (k <= 0) {
        h.aF = 0;
      } else if (h.aF == -1) {
        h.aF = 1;
      }
      if (paramMessage.getData().getInt("opetco", 1) == 0) {
        h.aL = 0;
      }
      if (paramMessage.getData().getInt("lpcs", h.aM) == 0) {
        h.aM = 0;
      }
      if (j == 1) {
        h.aB = 1;
      }
      if (d1 > h.aA) {
        h.aA = d1;
      }
      boolean bool = paramMessage.getData().getBoolean("ischeckper", false);
      if ((!h.ax) && (!bool)) {
        bool = false;
      } else {
        bool = true;
      }
      h.ax = bool;
      bool = paramMessage.getData().getBoolean("isEnableBeidouMode", false);
      if (Build.VERSION.SDK_INT >= 28)
      {
        if ((!h.aN) && (!bool)) {
          bool = false;
        } else {
          bool = true;
        }
        h.aN = bool;
      }
      if (i > h.ay) {
        h.ay = i;
      }
      if (f > h.az) {
        h.az = f;
      }
      i = paramMessage.getData().getInt("wifitimeout", 2147483647);
      if (i < h.af) {
        h.af = i;
      }
      i = paramMessage.getData().getInt("autoNotifyMaxInterval", 0);
      if (i >= h.W) {
        h.W = i;
      }
      i = paramMessage.getData().getInt("autoNotifyMinDistance", 0);
      if (i >= h.Y) {
        h.Y = i;
      }
      i = paramMessage.getData().getInt("autoNotifyMinTimeInterval", 0);
      if (i >= h.X) {
        h.X = i;
      }
      LocationClientOption localLocationClientOption = this.c;
      if ((localLocationClientOption.mIsNeedDeviceDirect) || (localLocationClientOption.isNeedAltitude))
      {
        m.a().a(this.c.mIsNeedDeviceDirect);
        m.a().b();
      }
      if ((!b.this.b) && (!this.c.isNeedAltitude)) {
        bool = false;
      } else {
        bool = true;
      }
      b.this.b = bool;
      if (paramMessage.getData().getInt("hpdts", h.aC) == 1) {
        h.aC = 1;
      } else {
        h.aC = 0;
      }
      if (paramMessage.getData().getInt("oldts", h.aD) == 1)
      {
        h.aD = 1;
        return;
      }
      h.aD = 0;
    }
    
    private double a(boolean paramBoolean, BDLocation paramBDLocation1, BDLocation paramBDLocation2)
    {
      double d2;
      double d3;
      double d4;
      if (paramBoolean)
      {
        if (TextUtils.equals(paramBDLocation2.getCoorType(), paramBDLocation1.getCoorType()))
        {
          if (!TextUtils.equals("bd09", paramBDLocation2.getCoorType())) {
            break label349;
          }
          arrayOfDouble1 = Jni.coorEncrypt(paramBDLocation2.getLongitude(), paramBDLocation2.getLatitude(), "bd092gcj");
          double[] arrayOfDouble2 = Jni.coorEncrypt(paramBDLocation1.getLongitude(), paramBDLocation1.getLatitude(), "bd092gcj");
          d1 = arrayOfDouble1[1];
          d2 = arrayOfDouble1[0];
          d3 = arrayOfDouble2[1];
          d4 = arrayOfDouble2[0];
        }
        else
        {
          if (!TextUtils.equals("wgs84", paramBDLocation1.getCoorType()))
          {
            if (TextUtils.equals("bd09", paramBDLocation1.getCoorType()))
            {
              arrayOfDouble1 = Jni.coorEncrypt(paramBDLocation1.getLongitude(), paramBDLocation1.getLatitude(), "bd092gcj");
            }
            else if (TextUtils.equals("bd09ll", paramBDLocation1.getCoorType()))
            {
              arrayOfDouble1 = Jni.coorEncrypt(paramBDLocation1.getLongitude(), paramBDLocation1.getLatitude(), "bd09ll2gcj");
            }
            else
            {
              arrayOfDouble1 = new double[2];
              arrayOfDouble1[0] = paramBDLocation1.getLongitude();
              arrayOfDouble1[1] = paramBDLocation1.getLatitude();
            }
            arrayOfDouble1 = Jni.coorEncrypt(arrayOfDouble1[0], arrayOfDouble1[1], "gcj2wgs");
          }
          else
          {
            arrayOfDouble1 = new double[2];
            arrayOfDouble1[0] = paramBDLocation1.getLongitude();
            arrayOfDouble1[1] = paramBDLocation1.getLatitude();
          }
          paramBDLocation1.setLatitude(arrayOfDouble1[1]);
          d1 = arrayOfDouble1[0];
          break label329;
        }
      }
      else
      {
        if (!TextUtils.equals(paramBDLocation2.getCoorType(), paramBDLocation1.getCoorType())) {
          break label299;
        }
        d1 = paramBDLocation2.getLatitude();
        d2 = paramBDLocation2.getLongitude();
        d3 = paramBDLocation1.getLatitude();
        d4 = paramBDLocation1.getLongitude();
      }
      double d1 = h.a(d1, d2, d3, d4);
      break label370;
      label299:
      double[] arrayOfDouble1 = Jni.coorEncrypt(paramBDLocation1.getLongitude(), paramBDLocation1.getLatitude(), "gcj2wgs");
      paramBDLocation1.setLatitude(arrayOfDouble1[1]);
      d1 = arrayOfDouble1[0];
      label329:
      paramBDLocation1.setLongitude(d1);
      paramBDLocation1.setTime(h.a());
      paramBDLocation1.setCoorType("wgs84");
      label349:
      d1 = h.a(paramBDLocation2.getLatitude(), paramBDLocation2.getLongitude(), paramBDLocation1.getLatitude(), paramBDLocation1.getLongitude());
      label370:
      paramBDLocation2.setDisToRealLocation(d1);
      if (paramBDLocation1 != null) {
        paramBDLocation2.setReallLocation(paramBDLocation1);
      }
      return d1;
    }
    
    private int a(double paramDouble)
    {
      if ((paramDouble >= 0.0D) && (paramDouble <= 10.0D)) {
        return 0;
      }
      if ((paramDouble > 10.0D) && (paramDouble <= 100.0D)) {
        return 1;
      }
      if ((paramDouble > 100.0D) && (paramDouble <= 200.0D)) {
        return 2;
      }
      return 3;
    }
    
    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        Messenger localMessenger = this.b;
        if (localMessenger != null) {
          localMessenger.send(localMessage);
        }
        this.d = 0;
        return;
      }
      catch (Exception localException)
      {
        if ((localException instanceof DeadObjectException)) {
          this.d += 1;
        }
      }
    }
    
    private void a(int paramInt, Bundle paramBundle)
    {
      Message localMessage = Message.obtain(null, paramInt);
      localMessage.setData(paramBundle);
      try
      {
        paramBundle = this.b;
        if (paramBundle != null) {
          paramBundle.send(localMessage);
        }
        this.d = 0;
        return;
      }
      catch (Exception paramBundle)
      {
        if ((paramBundle instanceof DeadObjectException)) {
          this.d += 1;
        }
        paramBundle.printStackTrace();
      }
    }
    
    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      localBundle.setClassLoader(BDLocation.class.getClassLoader());
      paramString = Message.obtain(null, paramInt);
      paramString.setData(localBundle);
      try
      {
        paramBDLocation = this.b;
        if (paramBDLocation != null) {
          paramBDLocation.send(paramString);
        }
        this.d = 0;
        return;
      }
      catch (Exception paramString)
      {
        if ((paramString instanceof DeadObjectException)) {
          this.d += 1;
        }
      }
    }
    
    private BDLocation b()
    {
      Object localObject = d.a().h();
      if (localObject != null)
      {
        localObject = Jni.coorEncrypt(((BDLocation)localObject).getLongitude(), ((BDLocation)localObject).getLatitude(), "gps2gcj");
        localObject = Jni.coorEncrypt(localObject[0], localObject[1], this.c.coorType);
        BDLocation localBDLocation = new BDLocation();
        localBDLocation.setLongitude(localObject[0]);
        localBDLocation.setLatitude(localObject[1]);
        localBDLocation.setTime(h.a());
        localBDLocation.setLocType(61);
        localBDLocation.setCoorType(this.c.coorType);
        return localBDLocation;
      }
      return null;
    }
    
    private BDLocation c()
    {
      Object localObject = d.a().h();
      if (localObject != null)
      {
        localObject = Jni.coorEncrypt(((BDLocation)localObject).getLongitude(), ((BDLocation)localObject).getLatitude(), "gps2gcj");
        BDLocation localBDLocation = new BDLocation();
        localBDLocation.setLongitude(localObject[0]);
        localBDLocation.setLatitude(localObject[1]);
        localBDLocation.setTime(h.a());
        localBDLocation.setLocType(61);
        localBDLocation.setCoorType("gcj02");
        return localBDLocation;
      }
      return null;
    }
    
    public int a(int paramInt, boolean paramBoolean, BDLocation paramBDLocation)
    {
      BDLocation localBDLocation;
      if (paramInt == 100)
      {
        if (paramBoolean)
        {
          localBDLocation = b();
          if (localBDLocation != null) {
            a(true, localBDLocation, paramBDLocation);
          }
        }
        else
        {
          localBDLocation = c();
          if (localBDLocation != null) {
            a(false, localBDLocation, paramBDLocation);
          }
        }
        return 3;
      }
      if (paramInt == 200) {
        return 1;
      }
      if (paramInt == 300) {
        return 1;
      }
      if (paramInt == 400)
      {
        if (paramBoolean)
        {
          localBDLocation = b();
          if (localBDLocation == null) {}
        }
        else
        {
          for (double d1 = a(true, localBDLocation, paramBDLocation);; d1 = a(false, localBDLocation, paramBDLocation))
          {
            return a(d1);
            localBDLocation = c();
            if (localBDLocation == null) {
              break;
            }
          }
        }
        return -1;
      }
      if (paramInt == 500) {
        return 1;
      }
      return 0;
    }
    
    public void a()
    {
      if (this.c.location_change_notify == true)
      {
        int i;
        if (h.b) {
          i = 54;
        } else {
          i = 55;
        }
        a(i);
      }
    }
    
    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }
    
    public void a(BDLocation paramBDLocation, int paramInt)
    {
      BDLocation localBDLocation = new BDLocation(paramBDLocation);
      if (paramInt == 21) {
        a(27, "locStr", localBDLocation);
      }
      paramBDLocation = this.c.coorType;
      int i;
      if ((paramBDLocation != null) && (!paramBDLocation.equals("gcj02")))
      {
        double d1 = localBDLocation.getLongitude();
        double d2 = localBDLocation.getLatitude();
        if ((d1 != 4.9E-324D) && (d2 != 4.9E-324D))
        {
          if (((localBDLocation.getCoorType() != null) && (localBDLocation.getCoorType().equals("gcj02"))) || (localBDLocation.getCoorType() == null))
          {
            paramBDLocation = Jni.coorEncrypt(d1, d2, this.c.coorType);
            localBDLocation.setLongitude(paramBDLocation[0]);
            localBDLocation.setLatitude(paramBDLocation[1]);
          }
          for (paramBDLocation = this.c.coorType;; paramBDLocation = "wgs84mc")
          {
            localBDLocation.setCoorType(paramBDLocation);
            break;
            if ((localBDLocation.getCoorType() == null) || (!localBDLocation.getCoorType().equals("wgs84")) || (this.c.coorType.equals("bd09ll"))) {
              break;
            }
            paramBDLocation = Jni.coorEncrypt(d1, d2, "wgs842mc");
            localBDLocation.setLongitude(paramBDLocation[0]);
            localBDLocation.setLatitude(paramBDLocation[1]);
          }
        }
        if ((h.l) || (localBDLocation.getMockGpsStrategy() <= 0)) {
          break label293;
        }
        i = a(localBDLocation.getMockGpsStrategy(), true, localBDLocation);
      }
      else
      {
        if ((h.l) || (localBDLocation.getMockGpsStrategy() <= 0)) {
          break label293;
        }
        i = a(localBDLocation.getMockGpsStrategy(), false, localBDLocation);
      }
      localBDLocation.setMockGpsProbability(i);
      label293:
      a(paramInt, "locStr", localBDLocation);
    }
  }
  
  private class b
    implements Runnable
  {
    private int b;
    private boolean c;
    
    public void run()
    {
      if (this.c) {
        return;
      }
      this.b += 1;
      b.a(this.a, false);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.b
 * JD-Core Version:    0.7.0.1
 */