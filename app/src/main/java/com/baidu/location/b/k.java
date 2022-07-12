package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.c.a;
import com.baidu.location.c.d;
import com.baidu.location.c.i;
import com.baidu.location.f;
import java.util.List;

public class k
  extends h
{
  public static String f = "0";
  public static boolean h = false;
  private static k i;
  private PoiRegion A = null;
  private double B;
  private double C;
  private boolean D = false;
  private long E = 0L;
  private long F = 0L;
  private a G = null;
  private boolean H = false;
  private boolean I = false;
  private boolean J = true;
  private boolean K = false;
  private boolean L = false;
  private b M = null;
  private boolean N = false;
  private int O = 0;
  private long P = 0L;
  private boolean Q = false;
  private String R = null;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private boolean V = true;
  public h.b e = null;
  public final Handler g = new h.a(this);
  private boolean j = true;
  private String k = null;
  private BDLocation l = null;
  private BDLocation m = null;
  private com.baidu.location.c.h n = null;
  private a o = null;
  private com.baidu.location.c.h p = null;
  private a q = null;
  private boolean r = true;
  private volatile boolean s = false;
  private boolean t = false;
  private long u = 0L;
  private long v = 0L;
  private Address w = null;
  private long x;
  private String y = null;
  private List<Poi> z = null;
  
  private boolean a(a parama)
  {
    a locala = com.baidu.location.c.b.a().f();
    this.b = locala;
    if (locala == parama) {
      return false;
    }
    if (locala != null)
    {
      if (parama == null) {
        return true;
      }
      return parama.a(locala) ^ true;
    }
    return true;
  }
  
  private boolean a(com.baidu.location.c.h paramh)
  {
    com.baidu.location.c.h localh = i.a().o();
    this.a = localh;
    if (paramh == localh) {
      return false;
    }
    if (localh != null)
    {
      if (paramh == null) {
        return true;
      }
      return paramh.c(localh) ^ true;
    }
    return true;
  }
  
  private void b(String paramString)
  {
    boolean bool;
    if ((paramString != null) && ("subway".equals(paramString.toLowerCase()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.T = bool;
  }
  
  public static k c()
  {
    try
    {
      if (i == null) {
        i = new k();
      }
      k localk = i;
      return localk;
    }
    finally {}
  }
  
  private void c(Message paramMessage)
  {
    if (!com.baidu.location.e.h.c(f.getServiceContext()))
    {
      paramMessage = new BDLocation();
      paramMessage.setLocType(62);
      b.a().a(paramMessage);
      return;
    }
    if (com.baidu.location.e.h.b()) {
      Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
    }
    if (paramMessage.getData().getBoolean("isWaitingLocTag", false)) {
      h = true;
    }
    int i1 = b.a().d(paramMessage);
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 != 3) && (i1 != 4)) {
          throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[] { Integer.valueOf(i1) }));
        }
        g(paramMessage);
        return;
      }
      if (d.a().j()) {
        e(paramMessage);
      }
    }
    else
    {
      d(paramMessage);
    }
  }
  
  private void d(Message paramMessage)
  {
    if (d.a().j())
    {
      e(paramMessage);
      m.a().c();
      return;
    }
    g(paramMessage);
    m.a().b();
  }
  
  private void d(BDLocation paramBDLocation)
  {
    if ((!com.baidu.location.e.h.l) && (paramBDLocation.getMockGpsStrategy() > 0))
    {
      b.a().c(paramBDLocation);
      return;
    }
    b.a().a(paramBDLocation);
  }
  
  private void e(Message paramMessage)
  {
    paramMessage = new BDLocation(d.a().f());
    Object localObject = d.a().g();
    if ((localObject != null) && ("bd_beidou".equals(((Location)localObject).getProvider()))) {
      paramMessage.setGnssProvider("bd_beidou");
    }
    if (localObject != null) {
      paramMessage.setExtrainfo(((Location)localObject).getExtras());
    }
    if ((com.baidu.location.e.h.e.equals("all")) || (com.baidu.location.e.h.g) || (com.baidu.location.e.h.i))
    {
      localObject = new float[2];
      Location.distanceBetween(this.C, this.B, paramMessage.getLatitude(), paramMessage.getLongitude(), (float[])localObject);
      if (localObject[0] < 100.0F)
      {
        localObject = this.w;
        if (localObject != null) {
          paramMessage.setAddr((Address)localObject);
        }
        localObject = this.y;
        if (localObject != null) {
          paramMessage.setLocationDescribe((String)localObject);
        }
        localObject = this.z;
        if (localObject != null) {
          paramMessage.setPoiList((List)localObject);
        }
        localObject = this.A;
        if (localObject != null) {
          paramMessage.setPoiRegion((PoiRegion)localObject);
        }
      }
      else
      {
        this.D = true;
        g(null);
      }
    }
    this.l = paramMessage;
    this.m = null;
    d(paramMessage);
  }
  
  private void e(BDLocation paramBDLocation)
  {
    boolean bool;
    if ((paramBDLocation != null) && (paramBDLocation.isInIndoorPark())) {
      bool = true;
    } else {
      bool = false;
    }
    this.U = bool;
  }
  
  private void f(Message paramMessage)
  {
    if (i.a().f())
    {
      this.t = true;
      if (this.M == null) {
        this.M = new b(null);
      }
      if (this.N)
      {
        paramMessage = this.M;
        if (paramMessage != null) {
          this.g.removeCallbacks(paramMessage);
        }
      }
      this.g.postDelayed(this.M, 3500L);
      this.N = true;
      return;
    }
    h(paramMessage);
  }
  
  private void g(Message paramMessage)
  {
    this.O = 0;
    if (this.r)
    {
      this.O = 1;
      this.F = SystemClock.uptimeMillis();
      if (i.a().j())
      {
        f(paramMessage);
        return;
      }
      h(paramMessage);
      return;
    }
    f(paramMessage);
    this.F = SystemClock.uptimeMillis();
  }
  
  private void h(Message paramMessage)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.u;
    if ((this.s) && (l1 - l2 <= 12000L)) {
      return;
    }
    l1 = System.currentTimeMillis();
    long l3 = this.u;
    l2 = 0L;
    if ((l1 - l3 > 0L) && (System.currentTimeMillis() - this.u < 1000L))
    {
      if (this.l != null) {
        b.a().a(this.l);
      }
      m();
      return;
    }
    this.s = true;
    this.j = a(this.o);
    if ((!a(this.n)) && (!this.j) && (this.l != null) && (!this.D))
    {
      if ((this.m != null) && (System.currentTimeMillis() - this.v > 30000L))
      {
        this.l = this.m;
        this.m = null;
      }
      if (m.a().d()) {
        this.l.setDirection(m.a().e());
      }
      if (this.l.getLocType() == 62)
      {
        l3 = System.currentTimeMillis() - this.P;
        l1 = l3;
        if (l3 > 0L) {}
      }
      else
      {
        l1 = 0L;
      }
      if ((this.l.getLocType() == 61) || (this.l.getLocType() == 161) || ((this.l.getLocType() == 62) && (l1 < 15000L)))
      {
        b.a().a(this.l);
        m();
        return;
      }
    }
    this.u = System.currentTimeMillis();
    Object localObject2 = a(null);
    this.L = false;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.L = true;
      this.P = System.currentTimeMillis();
      localObject1 = new String[2];
      try
      {
        localObject2 = l();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      l1 = System.currentTimeMillis();
      if (l1 - this.E > 60000L) {
        this.E = l1;
      }
      localObject3 = i.a().l();
      if (localObject3 != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(b());
        ((StringBuilder)localObject4).append(localObject1[0]);
        localObject1 = ((StringBuilder)localObject4).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(b());
        ((StringBuilder)localObject3).append(localObject1[0]);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      Object localObject4 = this.b;
      localObject3 = localObject1;
      if (localObject4 != null)
      {
        localObject3 = localObject1;
        if (((a)localObject4).h() != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.b.h());
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject3 = ((StringBuilder)localObject3).toString();
        }
      }
      localObject4 = com.baidu.location.e.b.a().a(true);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append((String)localObject4);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    Object localObject3 = localObject1;
    if (this.k != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.k);
      localObject3 = ((StringBuilder)localObject3).toString();
      this.k = null;
    }
    localObject1 = this.a;
    l1 = l2;
    if (localObject1 != null) {
      l1 = ((com.baidu.location.c.h)localObject1).f();
    }
    this.e.a((String)localObject3, l1);
    this.o = this.b;
    this.n = this.a;
    if (this.r == true)
    {
      this.r = false;
      if ((i.a().i()) && (paramMessage != null)) {
        b.a().e(paramMessage);
      }
    }
    int i1 = this.O;
    if (i1 > 0)
    {
      if (i1 == 2) {
        i.a().f();
      }
      this.O = 0;
    }
  }
  
  private String[] l()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "Location failed beacuse we can not get any loc information!";
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("&apl=");
    int i2 = com.baidu.location.e.h.a(f.getServiceContext());
    String str1 = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
    if (i2 == 1) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
    }
    localStringBuffer.append(i2);
    Object localObject = com.baidu.location.e.h.d(f.getServiceContext());
    if (((String)localObject).contains("0|0|")) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information without any location permission!";
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("&loc=");
    int i3 = com.baidu.location.e.h.b(f.getServiceContext());
    int i1;
    if (i3 == 0)
    {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    localStringBuffer.append(i3);
    localStringBuffer.append("&lmd=");
    i3 = com.baidu.location.e.h.b(f.getServiceContext());
    if (i3 >= 0) {
      localStringBuffer.append(i3);
    }
    String str2 = com.baidu.location.c.b.a().g();
    String str3 = i.a().g();
    localStringBuffer.append(str3);
    localStringBuffer.append(str2);
    localStringBuffer.append(com.baidu.location.e.h.e(f.getServiceContext()));
    if (i2 == 1)
    {
      localObject = c.a();
      i1 = 7;
    }
    for (;;)
    {
      ((c)localObject).a(62, i1, str1);
      break label347;
      if (((String)localObject).contains("0|0|"))
      {
        c.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        break label347;
      }
      if (i1 != 0)
      {
        c.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        break label347;
      }
      if ((str2 == null) || (str3 == null) || (!str2.equals("&sim=1")) || (str3.equals("&wifio=1"))) {
        break;
      }
      localObject = c.a();
      i1 = 6;
      str1 = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
    }
    c.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
    label347:
    arrayOfString[0] = localStringBuffer.toString();
    return arrayOfString;
  }
  
  private void m()
  {
    this.s = false;
    this.I = false;
    this.J = false;
    this.D = false;
    n();
    if (this.V) {
      this.V = false;
    }
  }
  
  private void n()
  {
    if ((this.l != null) && (i.a().i())) {
      s.a().d();
    }
  }
  
  public Address a(BDLocation paramBDLocation)
  {
    if ((com.baidu.location.e.h.e.equals("all")) || (com.baidu.location.e.h.g) || (com.baidu.location.e.h.i))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.C, this.B, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] < 100.0D)
      {
        paramBDLocation = this.w;
        if (paramBDLocation != null) {
          return paramBDLocation;
        }
      }
      else
      {
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = true;
        this.g.post(new Runnable()
        {
          public void run()
          {
            k.a(k.this, null);
          }
        });
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = this.G;
    if ((localObject1 != null) && (this.H))
    {
      this.H = false;
      this.g.removeCallbacks((Runnable)localObject1);
    }
    if (d.a().j())
    {
      localObject1 = new BDLocation(d.a().f());
      Object localObject2 = d.a().g();
      if ((localObject2 != null) && ("bd_beidou".equals(((Location)localObject2).getProvider()))) {
        ((BDLocation)localObject1).setGnssProvider("bd_beidou");
      }
      if (localObject2 != null) {
        ((BDLocation)localObject1).setExtrainfo(((Location)localObject2).getExtras());
      }
      if ((com.baidu.location.e.h.e.equals("all")) || (com.baidu.location.e.h.g) || (com.baidu.location.e.h.i))
      {
        localObject2 = new float[2];
        Location.distanceBetween(this.C, this.B, ((BDLocation)localObject1).getLatitude(), ((BDLocation)localObject1).getLongitude(), (float[])localObject2);
        if (localObject2[0] < 100.0F)
        {
          localObject2 = this.w;
          if (localObject2 != null) {
            ((BDLocation)localObject1).setAddr((Address)localObject2);
          }
          localObject2 = this.y;
          if (localObject2 != null) {
            ((BDLocation)localObject1).setLocationDescribe((String)localObject2);
          }
          localObject2 = this.z;
          if (localObject2 != null) {
            ((BDLocation)localObject1).setPoiList((List)localObject2);
          }
          localObject2 = this.A;
          if (localObject2 != null) {
            ((BDLocation)localObject1).setPoiRegion((PoiRegion)localObject2);
          }
        }
      }
      b.a().a((BDLocation)localObject1);
    }
    for (;;)
    {
      m();
      return;
      if (this.I)
      {
        m();
        return;
      }
      if ((!this.j) && (this.l != null))
      {
        b.a().a(this.l);
      }
      else
      {
        localObject1 = new BDLocation();
        ((BDLocation)localObject1).setLocType(63);
        this.l = null;
        b.a().a((BDLocation)localObject1);
      }
      this.m = null;
    }
  }
  
  public void a(Message paramMessage)
  {
    a locala = this.G;
    if ((locala != null) && (this.H))
    {
      this.H = false;
      this.g.removeCallbacks(locala);
    }
    paramMessage = (BDLocation)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.getLocType() == 161))
    {
      b(paramMessage.getTraffic());
      e(paramMessage);
    }
    if ((paramMessage != null) && (paramMessage.getLocType() == 167) && (this.L)) {
      paramMessage.setLocType(62);
    }
    b(paramMessage);
  }
  
  public void b(Message paramMessage)
  {
    if (!this.K) {
      return;
    }
    c(paramMessage);
  }
  
  public void b(BDLocation paramBDLocation)
  {
    new BDLocation(paramBDLocation);
    if (paramBDLocation.hasAddr())
    {
      localObject = paramBDLocation.getAddress();
      this.w = ((Address)localObject);
      if (localObject != null)
      {
        localObject = ((Address)localObject).cityCode;
        if (localObject != null)
        {
          f = (String)localObject;
          this.x = System.currentTimeMillis();
        }
      }
      this.B = paramBDLocation.getLongitude();
      this.C = paramBDLocation.getLatitude();
    }
    if (paramBDLocation.getLocationDescribe() != null)
    {
      this.y = paramBDLocation.getLocationDescribe();
      this.B = paramBDLocation.getLongitude();
      this.C = paramBDLocation.getLatitude();
    }
    if (paramBDLocation.getPoiList() != null)
    {
      this.z = paramBDLocation.getPoiList();
      this.B = paramBDLocation.getLongitude();
      this.C = paramBDLocation.getLatitude();
    }
    if (paramBDLocation.getPoiRegion() != null)
    {
      this.A = paramBDLocation.getPoiRegion();
      this.B = paramBDLocation.getLongitude();
      this.C = paramBDLocation.getLatitude();
    }
    boolean bool = d.a().j();
    int i2 = 0;
    if (bool)
    {
      paramBDLocation = new BDLocation(d.a().f());
      localObject = d.a().g();
      if ((localObject != null) && ("bd_beidou".equals(((Location)localObject).getProvider()))) {
        paramBDLocation.setGnssProvider("bd_beidou");
      }
      if (localObject != null) {
        paramBDLocation.setExtrainfo(((Location)localObject).getExtras());
      }
      if ((com.baidu.location.e.h.e.equals("all")) || (com.baidu.location.e.h.g) || (com.baidu.location.e.h.i))
      {
        localObject = new float[2];
        Location.distanceBetween(this.C, this.B, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject);
        if (localObject[0] < 100.0F)
        {
          localObject = this.w;
          if (localObject != null) {
            paramBDLocation.setAddr((Address)localObject);
          }
          localObject = this.y;
          if (localObject != null) {
            paramBDLocation.setLocationDescribe((String)localObject);
          }
          localObject = this.z;
          if (localObject != null) {
            paramBDLocation.setPoiList((List)localObject);
          }
          localObject = this.A;
          if (localObject != null) {
            paramBDLocation.setPoiRegion((PoiRegion)localObject);
          }
        }
      }
      d(paramBDLocation);
      m();
      return;
    }
    if (this.I)
    {
      localObject = new float[2];
      BDLocation localBDLocation = this.l;
      if (localBDLocation != null) {
        Location.distanceBetween(localBDLocation.getLatitude(), this.l.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject);
      }
      if (localObject[0] > 10.0F)
      {
        this.l = paramBDLocation;
        if (this.J) {
          break label481;
        }
        this.J = false;
      }
      else
      {
        if (paramBDLocation.getUserIndoorState() <= -1) {
          break label481;
        }
        this.l = paramBDLocation;
      }
      b.a().a(paramBDLocation);
      label481:
      m();
      return;
    }
    if (paramBDLocation.getLocType() == 167)
    {
      c.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
    }
    else if (paramBDLocation.getLocType() == 161)
    {
      i1 = com.baidu.location.e.h.b(f.getServiceContext());
      if ((i1 != 0) && (i1 != 2)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 != 0)
      {
        c.a().a(161, 1, "NetWork location successful, open gps will be better!");
      }
      else if ((paramBDLocation.getRadius() >= 100.0F) && (paramBDLocation.getNetworkLocationType() != null) && (paramBDLocation.getNetworkLocationType().equals("cl")))
      {
        localObject = i.a().g();
        if ((localObject != null) && (!((String)localObject).equals("&wifio=1"))) {
          c.a().a(161, 2, "NetWork location successful, open wifi will be better!");
        }
      }
    }
    this.m = null;
    int i1 = i2;
    if (paramBDLocation.getLocType() == 161)
    {
      i1 = i2;
      if ("cl".equals(paramBDLocation.getNetworkLocationType()))
      {
        localObject = this.l;
        i1 = i2;
        if (localObject != null)
        {
          i1 = i2;
          if (((BDLocation)localObject).getLocType() == 161)
          {
            i1 = i2;
            if ("wf".equals(this.l.getNetworkLocationType()))
            {
              i1 = i2;
              if (System.currentTimeMillis() - this.v < 30000L)
              {
                this.m = paramBDLocation;
                i1 = 1;
              }
            }
          }
        }
      }
    }
    Object localObject = b.a();
    if (i1 != 0)
    {
      ((b)localObject).a(this.l);
    }
    else
    {
      ((b)localObject).a(paramBDLocation);
      this.v = System.currentTimeMillis();
    }
    if (com.baidu.location.e.h.a(paramBDLocation))
    {
      if (i1 == 0) {
        this.l = paramBDLocation;
      }
    }
    else {
      this.l = null;
    }
    i1 = com.baidu.location.e.h.a(h.c, "ssid\":\"", "\"");
    if (i1 != -2147483648)
    {
      paramBDLocation = this.n;
      if (paramBDLocation != null)
      {
        this.k = paramBDLocation.b(i1);
        break label841;
      }
    }
    this.k = null;
    label841:
    i.a().i();
    m();
  }
  
  public void c(BDLocation paramBDLocation)
  {
    this.l = new BDLocation(paramBDLocation);
  }
  
  public void d()
  {
    this.r = true;
    this.s = false;
    this.K = true;
  }
  
  public void e()
  {
    this.s = false;
    this.t = false;
    this.I = false;
    this.J = true;
    k();
    this.K = false;
  }
  
  public String f()
  {
    return this.y;
  }
  
  public List<Poi> g()
  {
    return this.z;
  }
  
  public PoiRegion h()
  {
    return this.A;
  }
  
  public void i()
  {
    if (this.t)
    {
      h(null);
      this.t = false;
    }
  }
  
  public boolean j()
  {
    return this.U;
  }
  
  public void k()
  {
    this.l = null;
  }
  
  private class a
    implements Runnable
  {
    public void run()
    {
      if (k.c(this.a) == true)
      {
        k.c(this.a, false);
        k.d(this.a);
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (k.a(k.this)) {
        k.a(k.this, false);
      }
      if (k.b(k.this) == true)
      {
        k.b(k.this, false);
        k.b(k.this, null);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.k
 * JD-Core Version:    0.7.0.1
 */