package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssMeasurementsEvent.Callback;
import android.location.GnssNavigationMessage;
import android.location.GnssNavigationMessage.Callback;
import android.location.GnssStatus;
import android.location.GnssStatus.Callback;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.k;
import com.baidu.location.b.n;
import com.baidu.location.b.r;
import com.baidu.location.b.s;
import com.baidu.location.e.c;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class d
{
  private static String L;
  private static double N = 100.0D;
  private static float Q = -1.0F;
  public static int a = 0;
  public static String b = "";
  public static String c = "";
  private static d e;
  private static Location i;
  private static int j = -1;
  private static int t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static long y;
  private boolean A;
  private boolean B;
  private String C;
  private boolean D;
  private long E;
  private double F;
  private double G;
  private double H;
  private long I;
  private long J;
  private long K;
  private e M;
  private long O;
  private long P;
  private a R;
  private b S;
  private ArrayList<ArrayList<Float>> T;
  private ArrayList<ArrayList<Float>> U;
  private ArrayList<ArrayList<Float>> V;
  private ArrayList<ArrayList<Float>> W;
  private ArrayList<ArrayList<Float>> X;
  private ArrayList<ArrayList<Float>> Y;
  private String Z;
  private long aa;
  private ArrayList<Integer> ab;
  private String ac;
  private String ad;
  private long ae;
  private long af;
  private long ag;
  private BDLocation ah;
  private boolean ai;
  private boolean aj;
  private long ak;
  private String al;
  private long am;
  private StringBuilder an;
  public long d;
  private Context f;
  private LocationManager g;
  private Location h;
  private f k;
  private h l;
  private GpsStatus m;
  private c n;
  private boolean o;
  private d p;
  private boolean q;
  private GpsStatus.NmeaListener r;
  private OnNmeaMessageListener s;
  private long z;
  
  /* Error */
  private d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 123	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 127	com/baidu/location/c/d:k	Lcom/baidu/location/c/d$f;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 129	com/baidu/location/c/d:l	Lcom/baidu/location/c/d$h;
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 131	com/baidu/location/c/d:o	Z
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 133	com/baidu/location/c/d:p	Lcom/baidu/location/c/d$d;
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 135	com/baidu/location/c/d:q	Z
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 137	com/baidu/location/c/d:r	Landroid/location/GpsStatus$NmeaListener;
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 139	com/baidu/location/c/d:s	Landroid/location/OnNmeaMessageListener;
    //   44: aload_0
    //   45: lconst_0
    //   46: putfield 141	com/baidu/location/c/d:z	J
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 143	com/baidu/location/c/d:A	Z
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 145	com/baidu/location/c/d:B	Z
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 147	com/baidu/location/c/d:C	Ljava/lang/String;
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 149	com/baidu/location/c/d:D	Z
    //   69: aload_0
    //   70: lconst_0
    //   71: putfield 151	com/baidu/location/c/d:E	J
    //   74: aload_0
    //   75: ldc2_w 152
    //   78: putfield 155	com/baidu/location/c/d:F	D
    //   81: aload_0
    //   82: dconst_0
    //   83: putfield 157	com/baidu/location/c/d:G	D
    //   86: aload_0
    //   87: dconst_0
    //   88: putfield 159	com/baidu/location/c/d:H	D
    //   91: aload_0
    //   92: lconst_0
    //   93: putfield 161	com/baidu/location/c/d:I	J
    //   96: aload_0
    //   97: lconst_0
    //   98: putfield 163	com/baidu/location/c/d:J	J
    //   101: aload_0
    //   102: lconst_0
    //   103: putfield 165	com/baidu/location/c/d:K	J
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 167	com/baidu/location/c/d:M	Lcom/baidu/location/c/d$e;
    //   111: aload_0
    //   112: lconst_0
    //   113: putfield 169	com/baidu/location/c/d:O	J
    //   116: aload_0
    //   117: lconst_0
    //   118: putfield 171	com/baidu/location/c/d:P	J
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 173	com/baidu/location/c/d:R	Lcom/baidu/location/c/d$a;
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 175	com/baidu/location/c/d:S	Lcom/baidu/location/c/d$b;
    //   131: aload_0
    //   132: new 177	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 178	java/util/ArrayList:<init>	()V
    //   139: putfield 180	com/baidu/location/c/d:T	Ljava/util/ArrayList;
    //   142: aload_0
    //   143: new 177	java/util/ArrayList
    //   146: dup
    //   147: invokespecial 178	java/util/ArrayList:<init>	()V
    //   150: putfield 182	com/baidu/location/c/d:U	Ljava/util/ArrayList;
    //   153: aload_0
    //   154: new 177	java/util/ArrayList
    //   157: dup
    //   158: invokespecial 178	java/util/ArrayList:<init>	()V
    //   161: putfield 184	com/baidu/location/c/d:V	Ljava/util/ArrayList;
    //   164: aload_0
    //   165: new 177	java/util/ArrayList
    //   168: dup
    //   169: invokespecial 178	java/util/ArrayList:<init>	()V
    //   172: putfield 186	com/baidu/location/c/d:W	Ljava/util/ArrayList;
    //   175: aload_0
    //   176: new 177	java/util/ArrayList
    //   179: dup
    //   180: invokespecial 178	java/util/ArrayList:<init>	()V
    //   183: putfield 188	com/baidu/location/c/d:X	Ljava/util/ArrayList;
    //   186: aload_0
    //   187: new 177	java/util/ArrayList
    //   190: dup
    //   191: invokespecial 178	java/util/ArrayList:<init>	()V
    //   194: putfield 190	com/baidu/location/c/d:Y	Ljava/util/ArrayList;
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 192	com/baidu/location/c/d:Z	Ljava/lang/String;
    //   202: aload_0
    //   203: lconst_0
    //   204: putfield 194	com/baidu/location/c/d:aa	J
    //   207: aload_0
    //   208: new 177	java/util/ArrayList
    //   211: dup
    //   212: invokespecial 178	java/util/ArrayList:<init>	()V
    //   215: putfield 196	com/baidu/location/c/d:ab	Ljava/util/ArrayList;
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 198	com/baidu/location/c/d:ac	Ljava/lang/String;
    //   223: aload_0
    //   224: aconst_null
    //   225: putfield 200	com/baidu/location/c/d:ad	Ljava/lang/String;
    //   228: aload_0
    //   229: lconst_0
    //   230: putfield 202	com/baidu/location/c/d:ae	J
    //   233: aload_0
    //   234: ldc2_w 203
    //   237: putfield 206	com/baidu/location/c/d:af	J
    //   240: aload_0
    //   241: ldc2_w 203
    //   244: putfield 208	com/baidu/location/c/d:ag	J
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 210	com/baidu/location/c/d:ai	Z
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 212	com/baidu/location/c/d:aj	Z
    //   257: aload_0
    //   258: lconst_0
    //   259: putfield 214	com/baidu/location/c/d:ak	J
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 216	com/baidu/location/c/d:al	Ljava/lang/String;
    //   267: aload_0
    //   268: lconst_0
    //   269: putfield 218	com/baidu/location/c/d:am	J
    //   272: aload_0
    //   273: new 220	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   280: putfield 223	com/baidu/location/c/d:an	Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: lconst_0
    //   285: putfield 225	com/baidu/location/c/d:d	J
    //   288: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   291: bipush 24
    //   293: if_icmplt +22 -> 315
    //   296: ldc 232
    //   298: invokestatic 238	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   301: pop
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 131	com/baidu/location/c/d:o	Z
    //   307: goto +8 -> 315
    //   310: aload_0
    //   311: iconst_0
    //   312: putfield 131	com/baidu/location/c/d:o	Z
    //   315: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   318: bipush 28
    //   320: if_icmplt +18 -> 338
    //   323: aload_0
    //   324: getstatic 243	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   327: putfield 216	com/baidu/location/c/d:al	Ljava/lang/String;
    //   330: goto +8 -> 338
    //   333: astore_1
    //   334: aload_1
    //   335: invokevirtual 248	java/lang/Throwable:printStackTrace	()V
    //   338: aload_0
    //   339: iconst_0
    //   340: putfield 135	com/baidu/location/c/d:q	Z
    //   343: return
    //   344: astore_1
    //   345: goto -35 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	d
    //   333	2	1	localObject	Object
    //   344	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   323	330	333	finally
    //   296	307	344	java/lang/ClassNotFoundException
  }
  
  public static d a()
  {
    try
    {
      if (e == null) {
        e = new d();
      }
      d locald = e;
      return locald;
    }
    finally {}
  }
  
  public static String a(Location paramLocation)
  {
    if (paramLocation == null) {
      return null;
    }
    float f1 = (float)(paramLocation.getSpeed() * 3.6D);
    boolean bool = paramLocation.hasSpeed();
    float f3 = -1.0F;
    if (!bool) {
      f1 = -1.0F;
    }
    if (paramLocation.hasAccuracy()) {
      f2 = paramLocation.getAccuracy();
    } else {
      f2 = -1.0F;
    }
    int i1 = (int)f2;
    double d1;
    if (paramLocation.hasAltitude()) {
      d1 = paramLocation.getAltitude();
    } else {
      d1 = 555.0D;
    }
    float f2 = f3;
    if (paramLocation.hasBearing()) {
      f2 = paramLocation.getBearing();
    }
    if (Q < -0.01F) {
      paramLocation = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f", new Object[] { Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getLatitude()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(a), Double.valueOf(d1), Long.valueOf(paramLocation.getTime() / 1000L), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Double.valueOf(N) });
    } else {
      paramLocation = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", new Object[] { Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getLatitude()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(a), Double.valueOf(d1), Long.valueOf(paramLocation.getTime() / 1000L), Integer.valueOf(a), Integer.valueOf(t), Integer.valueOf(u), Integer.valueOf(v), Integer.valueOf(w), Double.valueOf(N), Float.valueOf(Q) });
    }
    try
    {
      StringBuilder localStringBuilder;
      if ((j == 2) && (i != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocation);
        localStringBuilder.append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", new Object[] { Integer.valueOf(j), Double.valueOf(i.getLongitude()), Double.valueOf(i.getLatitude()), Long.valueOf(i.getTime() / 1000L) }));
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocation);
        localStringBuilder.append("&ll_fake=");
        localStringBuilder.append(j);
      }
      return paramLocation;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String a(ArrayList<ArrayList<Float>> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList.size() == 0) {
      return localStringBuilder.toString();
    }
    paramArrayList = paramArrayList.iterator();
    int i1 = 1;
    while (paramArrayList.hasNext())
    {
      ArrayList localArrayList = (ArrayList)paramArrayList.next();
      if (localArrayList.size() == 6)
      {
        if (i1 != 0) {
          i1 = 0;
        } else {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(String.format("%.1f;", new Object[] { localArrayList.get(0) }));
        localStringBuilder.append(String.format("%.1f;", new Object[] { localArrayList.get(1) }));
        localStringBuilder.append(String.format("%.1f;", new Object[] { localArrayList.get(2) }));
        localStringBuilder.append(String.format("%.0f;", new Object[] { localArrayList.get(3) }));
        localStringBuilder.append(String.format("%.0f", new Object[] { localArrayList.get(4) }));
        localStringBuilder.append(String.format("%.0f", new Object[] { localArrayList.get(5) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  private ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> paramArrayList, boolean paramBoolean, float paramFloat)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramArrayList.size() <= 40)
    {
      if (paramArrayList.size() == 0) {
        return localArrayList1;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)paramArrayList.next();
        if (localArrayList2.size() == 6)
        {
          float f1 = ((Float)localArrayList2.get(3)).floatValue();
          float f2 = ((Float)localArrayList2.get(2)).floatValue();
          if (((!paramBoolean) || (f1 >= 1.0F)) && ((paramFloat <= 0.0F) || (f2 >= paramFloat))) {
            localArrayList1.add(localArrayList2);
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private ArrayList<ArrayList<Float>> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean1) {
      localArrayList.addAll(a(this.V, paramBoolean5, paramFloat));
    }
    if (paramBoolean2) {
      localArrayList.addAll(a(this.W, paramBoolean5, paramFloat));
    }
    if (paramBoolean3) {
      localArrayList.addAll(a(this.X, paramBoolean5, paramFloat));
    }
    if (paramBoolean4) {
      localArrayList.addAll(a(this.Y, paramBoolean5, paramFloat));
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!b(paramString)) {
        return;
      }
      if (paramString.startsWith("$GPGGA,"))
      {
        a(paramString, 2, 4, 6);
        return;
      }
      if (paramString.startsWith("$GPRMC,")) {
        a(paramString, 3, 5, 2);
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String[] arrayOfString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!b(paramString)) {
        return;
      }
      arrayOfString = paramString.split(",");
      if (paramString.startsWith("$GPGGA,"))
      {
        if (arrayOfString.length >= 7) {}
      }
      else if ((paramString.startsWith("$GPRMC,")) && (arrayOfString.length < 6)) {
        return;
      }
      if ((TextUtils.isEmpty(arrayOfString[paramInt1].trim())) || (arrayOfString[paramInt1].trim().length() <= 2)) {}
    }
    try
    {
      d1 = Double.valueOf(arrayOfString[paramInt1].substring(0, 2)).doubleValue();
      d2 = Double.valueOf(arrayOfString[paramInt1].substring(2)).doubleValue() / 60.0D;
      if (this.ah == null) {
        this.ah = new BDLocation();
      }
      this.ah.setLatitude(d1 + d2);
    }
    catch (NumberFormatException paramString)
    {
      double d1;
      double d2;
      label160:
      break label160;
    }
    this.aj = true;
    break label173;
    this.ah = null;
    label173:
    if ((this.ah != null) && (!TextUtils.isEmpty(arrayOfString[paramInt2].trim())) && (arrayOfString[paramInt2].trim().length() > 3)) {}
    try
    {
      d1 = Double.valueOf(arrayOfString[paramInt2].substring(0, 3)).doubleValue();
      d2 = Double.valueOf(arrayOfString[paramInt2].substring(3)).doubleValue() / 60.0D;
      this.ah.setLongitude(d1 + d2);
    }
    catch (NumberFormatException paramString)
    {
      label259:
      label272:
      label360:
      break label259;
    }
    this.aj = true;
    break label272;
    this.ah = null;
    if (!TextUtils.isEmpty(arrayOfString[paramInt3].trim()))
    {
      if (paramInt3 == 2) {
        if (!TextUtils.equals(arrayOfString[paramInt3], "V")) {}
      }
      do
      {
        this.ai = false;
        break label360;
        if (!TextUtils.equals(arrayOfString[paramInt3], "A")) {
          break label360;
        }
        break;
        if (paramInt3 != 6) {
          break label360;
        }
      } while (TextUtils.equals(arrayOfString[paramInt3], "0"));
      this.ai = true;
    }
    if (this.ah != null) {
      this.aj = false;
    }
    this.ag = System.currentTimeMillis();
  }
  
  private void a(String paramString, Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(com.baidu.location.b.b.a().c());
    paramString = localStringBuilder.toString();
    boolean bool = i.a().e();
    n.a(new a(b.a().f()));
    n.a(System.currentTimeMillis());
    n.a(new Location(paramLocation));
    n.a(paramString);
    if (!bool) {
      r.a(n.c(), null, n.d(), paramString);
    }
  }
  
  public static boolean a(Location paramLocation1, Location paramLocation2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramLocation1 == paramLocation2) {
      return false;
    }
    if (paramLocation1 != null)
    {
      if (paramLocation2 == null) {
        return true;
      }
      float f1 = paramLocation2.getSpeed();
      if ((paramBoolean) && ((h.u == 3) || (!e.a().a(paramLocation2.getLongitude(), paramLocation2.getLatitude()))) && (f1 < 5.0F)) {
        return true;
      }
      float f2 = paramLocation2.distanceTo(paramLocation1);
      if (f1 > h.K)
      {
        paramBoolean = bool1;
        if (f2 > h.M) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      if (f1 > h.J)
      {
        paramBoolean = bool2;
        if (f2 > h.L) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      paramBoolean = bool3;
      if (f2 > 5.0F) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    return true;
  }
  
  public static String b(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null)
    {
      paramLocation = new StringBuilder();
      paramLocation.append(str);
      paramLocation.append("&g_tp=0");
      paramLocation = paramLocation.toString();
    }
    return paramLocation;
  }
  
  private void b(ArrayList<ArrayList<Float>> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = new StringBuilder(100);
      paramArrayList.append(c.g(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.f(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.a(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.h(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.b(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.c(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.e(this.V));
      paramArrayList.append("|");
      paramArrayList.append(c.d(this.V));
      paramArrayList = paramArrayList.toString();
    }
    else
    {
      paramArrayList = null;
    }
    this.Z = paramArrayList;
    this.aa = System.currentTimeMillis();
  }
  
  private void b(boolean paramBoolean)
  {
    this.D = paramBoolean;
    Q = -1.0F;
  }
  
  private boolean b(String paramString)
  {
    if (paramString.indexOf("*") == -1) {
      return false;
    }
    if (paramString.indexOf("$") == -1) {
      return false;
    }
    if (paramString.indexOf("$") > paramString.indexOf("*")) {
      return false;
    }
    if (paramString.length() >= paramString.indexOf("*"))
    {
      Object localObject = paramString.substring(0, paramString.indexOf("*")).getBytes();
      int i2 = localObject[1];
      int i1 = 2;
      while (i1 < localObject.length)
      {
        i2 ^= localObject[i1];
        i1 += 1;
      }
      localObject = String.format("%02x", new Object[] { Integer.valueOf(i2) });
      i1 = paramString.indexOf("*");
      if (i1 == -1) {
        return false;
      }
      i2 = paramString.length();
      int i3 = i1 + 3;
      if ((i2 >= i3) && (((String)localObject).equalsIgnoreCase(paramString.substring(i1 + 1, i3)))) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null)
    {
      paramLocation = new StringBuilder();
      paramLocation.append(str);
      paramLocation.append(L);
      paramLocation = paramLocation.toString();
    }
    return paramLocation;
  }
  
  private void e(Location paramLocation)
  {
    if ((this.M != null) && (System.currentTimeMillis() - this.am > 3000L))
    {
      paramLocation = this.M.obtainMessage(1, paramLocation);
      this.M.sendMessage(paramLocation);
    }
  }
  
  private int f(Location paramLocation)
  {
    if (paramLocation == null) {
      return 0;
    }
    try
    {
      if (paramLocation.isFromMockProvider()) {
        return 100;
      }
      if (Math.abs(this.af - this.ag) < 3000L)
      {
        if (this.ah == null)
        {
          if (!this.ai) {
            return 200;
          }
          if (this.aj) {
            return 300;
          }
        }
        else if ((!this.aj) && (this.ai))
        {
          return 400;
        }
      }
      else
      {
        this.ag = -1L;
        this.aj = false;
        this.ai = false;
        this.ah = null;
      }
      if (this.af > 0L)
      {
        long l1 = this.ag;
        if (l1 == -1L) {
          return 500;
        }
      }
      return 0;
    }
    catch (Exception|Error paramLocation) {}
    return 0;
  }
  
  private void g(Location paramLocation)
  {
    if ((paramLocation == null) || (a == 0)) {}
    try
    {
      paramLocation.getExtras().getInt("satellites");
      if ((this.q) && (h.a(paramLocation.getSpeed(), 0.0F)) && (!h.a(this.G, 0.0D)) && (System.currentTimeMillis() - this.H < 2000.0D)) {
        paramLocation.setSpeed((float)this.G);
      }
      localLocation = new Location(paramLocation);
      this.E = System.currentTimeMillis();
      this.h = paramLocation;
      i2 = a;
      l1 = System.currentTimeMillis();
      this.h.setTime(l1);
      f1 = (float)(this.h.getSpeed() * 3.6D);
      if (!this.h.hasSpeed()) {
        f1 = -1.0F;
      }
      i1 = i2;
      if (i2 != 0) {}
    }
    catch (Exception localException1)
    {
      try
      {
        Location localLocation;
        long l1;
        float f1;
        i1 = this.h.getExtras().getInt("satellites");
        this.C = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[] { Double.valueOf(this.h.getLongitude()), Double.valueOf(this.h.getLatitude()), Float.valueOf(f1), Float.valueOf(this.h.getBearing()), Integer.valueOf(i1), Long.valueOf(l1) });
        if (this.h != null)
        {
          BDLocation localBDLocation = new BDLocation(f());
          localBDLocation.setExtrainfo(paramLocation.getExtras());
          paramLocation = this.h;
          if ((paramLocation != null) && ("bd_beidou".equals(paramLocation.getProvider()))) {
            localBDLocation.setGnssProvider("bd_beidou");
          }
          a(localBDLocation);
          if ((a > 2) && (r.a(this.h, true)) && ("gps".equals(this.h.getProvider())))
          {
            boolean bool = i.a().e();
            n.a(new a(b.a().f()));
            n.a(System.currentTimeMillis());
            n.a(new Location(this.h));
            n.a(com.baidu.location.b.b.a().c());
            if (!bool) {
              s.a().b();
            }
          }
        }
        if ("gps".equals(localLocation.getProvider())) {
          s.a().a(localLocation, a);
        }
        return;
        this.h = null;
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i2;
          int i1 = i2;
        }
      }
    }
  }
  
  public static String l()
  {
    long l1 = System.currentTimeMillis() - y;
    if ((l1 >= 0L) && (l1 < 3000L)) {
      return String.format(Locale.US, "&gsvn=%d&gsfn=%d", new Object[] { Integer.valueOf(x), Integer.valueOf(a) });
    }
    return null;
  }
  
  public void a(BDLocation paramBDLocation)
  {
    if ((!h.l) && (f(this.h) > 0))
    {
      com.baidu.location.b.b.a().c(paramBDLocation);
      return;
    }
    com.baidu.location.b.b.a().d(paramBDLocation);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 774	com/baidu/location/f:isServing	Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: invokestatic 778	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   16: astore_2
    //   17: aload_0
    //   18: aload_2
    //   19: putfield 780	com/baidu/location/c/d:f	Landroid/content/Context;
    //   22: aload_0
    //   23: aload_2
    //   24: ldc_w 782
    //   27: invokevirtual 788	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 790	android/location/LocationManager
    //   33: putfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   36: aload_0
    //   37: new 20	com/baidu/location/c/d$e
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 793	com/baidu/location/c/d$e:<init>	(Lcom/baidu/location/c/d;)V
    //   45: putfield 167	com/baidu/location/c/d:M	Lcom/baidu/location/c/d$e;
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: goto -21 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	d
    //   5	2	1	bool	boolean
    //   16	8	2	localContext	Context
    //   51	4	2	localObject	Object
    //   56	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	6	51	finally
    //   13	22	51	finally
    //   22	36	51	finally
    //   36	48	51	finally
    //   22	36	56	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc_w 795
    //   3: ldc_w 797
    //   6: invokestatic 802	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield 145	com/baidu/location/c/d:B	Z
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 131	com/baidu/location/c/d:o	Z
    //   22: ifne +30 -> 52
    //   25: new 17	com/baidu/location/c/d$d
    //   28: dup
    //   29: aload_0
    //   30: aconst_null
    //   31: invokespecial 805	com/baidu/location/c/d$d:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 133	com/baidu/location/c/d:p	Lcom/baidu/location/c/d$d;
    //   40: aload_0
    //   41: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   44: aload_1
    //   45: invokevirtual 809	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   48: pop
    //   49: goto +41 -> 90
    //   52: aload_0
    //   53: getfield 780	com/baidu/location/c/d:f	Landroid/content/Context;
    //   56: ldc_w 811
    //   59: invokestatic 814	com/baidu/location/e/h:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   62: iconst_1
    //   63: if_icmpne +27 -> 90
    //   66: new 14	com/baidu/location/c/d$c
    //   69: dup
    //   70: aload_0
    //   71: aconst_null
    //   72: invokespecial 815	com/baidu/location/c/d$c:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   75: astore_1
    //   76: aload_0
    //   77: aload_1
    //   78: putfield 817	com/baidu/location/c/d:n	Lcom/baidu/location/c/d$c;
    //   81: aload_0
    //   82: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   85: aload_1
    //   86: invokevirtual 821	android/location/LocationManager:registerGnssStatusCallback	(Landroid/location/GnssStatus$Callback;)Z
    //   89: pop
    //   90: new 29	com/baidu/location/c/d$h
    //   93: dup
    //   94: aload_0
    //   95: aconst_null
    //   96: invokespecial 822	com/baidu/location/c/d$h:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   99: astore_1
    //   100: aload_0
    //   101: aload_1
    //   102: putfield 129	com/baidu/location/c/d:l	Lcom/baidu/location/c/d$h;
    //   105: aload_0
    //   106: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   109: ldc_w 824
    //   112: ldc2_w 825
    //   115: fconst_0
    //   116: aload_1
    //   117: invokevirtual 830	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   120: aload_0
    //   121: new 23	com/baidu/location/c/d$f
    //   124: dup
    //   125: aload_0
    //   126: aconst_null
    //   127: invokespecial 831	com/baidu/location/c/d$f:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   130: putfield 127	com/baidu/location/c/d:k	Lcom/baidu/location/c/d$f;
    //   133: new 695	android/os/Bundle
    //   136: dup
    //   137: invokespecial 832	android/os/Bundle:<init>	()V
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   145: ldc_w 741
    //   148: ldc_w 834
    //   151: aload_1
    //   152: invokevirtual 838	android/location/LocationManager:sendExtraCommand	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   155: pop
    //   156: aload_0
    //   157: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   160: ldc_w 741
    //   163: ldc2_w 339
    //   166: fconst_0
    //   167: aload_0
    //   168: getfield 127	com/baidu/location/c/d:k	Lcom/baidu/location/c/d$f;
    //   171: invokevirtual 830	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   174: aload_0
    //   175: getfield 131	com/baidu/location/c/d:o	Z
    //   178: ifeq +47 -> 225
    //   181: aload_0
    //   182: getfield 175	com/baidu/location/c/d:S	Lcom/baidu/location/c/d$b;
    //   185: ifnonnull +40 -> 225
    //   188: getstatic 841	com/baidu/location/e/h:aB	I
    //   191: iconst_1
    //   192: if_icmpne +33 -> 225
    //   195: new 843	java/util/Random
    //   198: dup
    //   199: invokespecial 844	java/util/Random:<init>	()V
    //   202: invokevirtual 847	java/util/Random:nextDouble	()D
    //   205: getstatic 850	com/baidu/location/e/h:aA	D
    //   208: dcmpg
    //   209: ifge +16 -> 225
    //   212: aload_0
    //   213: new 11	com/baidu/location/c/d$b
    //   216: dup
    //   217: aload_0
    //   218: aconst_null
    //   219: invokespecial 851	com/baidu/location/c/d$b:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   222: putfield 175	com/baidu/location/c/d:S	Lcom/baidu/location/c/d$b;
    //   225: aload_0
    //   226: getfield 175	com/baidu/location/c/d:S	Lcom/baidu/location/c/d$b;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +12 -> 243
    //   234: aload_0
    //   235: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   238: aload_1
    //   239: invokevirtual 855	android/location/LocationManager:registerGnssNavigationMessageCallback	(Landroid/location/GnssNavigationMessage$Callback;)Z
    //   242: pop
    //   243: aload_0
    //   244: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   247: putfield 169	com/baidu/location/c/d:O	J
    //   250: getstatic 759	com/baidu/location/e/h:l	Z
    //   253: ifne +98 -> 351
    //   256: getstatic 858	com/baidu/location/e/h:aM	I
    //   259: iconst_1
    //   260: if_icmpne +91 -> 351
    //   263: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   266: bipush 24
    //   268: if_icmplt +29 -> 297
    //   271: new 6	com/baidu/location/c/d$1
    //   274: dup
    //   275: aload_0
    //   276: invokespecial 859	com/baidu/location/c/d$1:<init>	(Lcom/baidu/location/c/d;)V
    //   279: astore_1
    //   280: aload_0
    //   281: aload_1
    //   282: putfield 139	com/baidu/location/c/d:s	Landroid/location/OnNmeaMessageListener;
    //   285: aload_0
    //   286: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   289: aload_1
    //   290: invokevirtual 863	android/location/LocationManager:addNmeaListener	(Landroid/location/OnNmeaMessageListener;)Z
    //   293: pop
    //   294: goto +57 -> 351
    //   297: aload_0
    //   298: new 26	com/baidu/location/c/d$g
    //   301: dup
    //   302: aload_0
    //   303: aconst_null
    //   304: invokespecial 864	com/baidu/location/c/d$g:<init>	(Lcom/baidu/location/c/d;Lcom/baidu/location/c/d$1;)V
    //   307: putfield 137	com/baidu/location/c/d:r	Landroid/location/GpsStatus$NmeaListener;
    //   310: ldc_w 866
    //   313: invokestatic 238	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   316: ldc_w 867
    //   319: iconst_1
    //   320: anewarray 234	java/lang/Class
    //   323: dup
    //   324: iconst_0
    //   325: ldc_w 869
    //   328: aastore
    //   329: invokevirtual 873	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   332: aload_0
    //   333: getfield 125	com/baidu/location/c/d:g	Landroid/location/LocationManager;
    //   336: iconst_1
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_0
    //   343: getfield 137	com/baidu/location/c/d:r	Landroid/location/GpsStatus$NmeaListener;
    //   346: aastore
    //   347: invokevirtual 879	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: aload_0
    //   352: iconst_1
    //   353: putfield 145	com/baidu/location/c/d:B	Z
    //   356: return
    //   357: astore_1
    //   358: goto -238 -> 120
    //   361: astore_1
    //   362: return
    //   363: astore_1
    //   364: goto -208 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	d
    //   34	256	1	localObject	Object
    //   357	1	1	localException1	Exception
    //   361	1	1	localException2	Exception
    //   363	1	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   18	49	357	java/lang/Exception
    //   52	90	357	java/lang/Exception
    //   90	120	357	java/lang/Exception
    //   120	133	361	java/lang/Exception
    //   156	225	361	java/lang/Exception
    //   225	230	361	java/lang/Exception
    //   234	243	361	java/lang/Exception
    //   243	294	361	java/lang/Exception
    //   297	351	361	java/lang/Exception
    //   351	356	361	java/lang/Exception
    //   133	156	363	java/lang/Exception
  }
  
  public void d()
  {
    if (!this.B) {
      return;
    }
    Object localObject = this.g;
    if (localObject != null) {}
    label190:
    try
    {
      d locald = this.p;
      if (locald != null)
      {
        ((LocationManager)localObject).removeGpsStatusListener(locald);
        this.p = null;
      }
      if (this.o)
      {
        localObject = this.n;
        if (localObject != null)
        {
          this.g.unregisterGnssStatusCallback((GnssStatus.Callback)localObject);
          this.n = null;
        }
      }
      localObject = this.l;
      if (localObject != null)
      {
        this.g.removeUpdates((LocationListener)localObject);
        this.l = null;
      }
    }
    catch (Exception localException1)
    {
      label87:
      break label87;
    }
    try
    {
      localObject = this.k;
      if (localObject != null) {
        this.g.removeUpdates((LocationListener)localObject);
      }
      localObject = this.s;
      if (localObject != null) {
        this.g.removeNmeaListener((OnNmeaMessageListener)localObject);
      }
      if (this.r != null) {
        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", new Class[] { GpsStatus.NmeaListener.class }).invoke(this.g, new Object[] { this.r });
      }
      localObject = this.S;
      if (localObject != null) {
        this.g.unregisterGnssNavigationMessageCallback((GnssNavigationMessage.Callback)localObject);
      }
      k();
    }
    catch (Exception localException2)
    {
      break label190;
    }
    h.d = 0;
    h.u = 0;
    this.k = null;
    this.B = false;
    b(false);
  }
  
  public void e()
  {
    try
    {
      d();
      Object localObject1 = this.g;
      if (localObject1 == null) {
        return;
      }
      try
      {
        localObject1 = this.M;
        if (localObject1 != null) {
          ((Handler)localObject1).removeCallbacksAndMessages(null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.g = null;
      return;
    }
    finally {}
  }
  
  public String f()
  {
    if (this.h != null)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("{\"result\":{\"time\":\"");
      ((StringBuilder)localObject1).append(h.a());
      ((StringBuilder)localObject1).append("\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":");
      ((StringBuilder)localObject1).append("\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",");
      ((StringBuilder)localObject1).append("\"s\":\"%f\",\"n\":\"%d\"");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      if (this.h.hasAccuracy()) {
        f1 = this.h.getAccuracy();
      } else {
        f1 = 10.0F;
      }
      int i2 = (int)f1;
      float f1 = (float)(this.h.getSpeed() * 3.6D);
      if (!this.h.hasSpeed()) {
        f1 = -1.0F;
      }
      localObject1 = new double[2];
      int i1;
      if (e.a().a(this.h.getLongitude(), this.h.getLatitude()))
      {
        localObject1 = Jni.coorEncrypt(this.h.getLongitude(), this.h.getLatitude(), "gps2gcj");
        if ((localObject1[0] <= 0.0D) && (localObject1[1] <= 0.0D))
        {
          localObject1[0] = this.h.getLongitude();
          localObject1[1] = this.h.getLatitude();
        }
        i1 = 1;
      }
      else
      {
        localObject1[0] = this.h.getLongitude();
        localObject1[1] = this.h.getLatitude();
        if ((localObject1[0] <= 0.0D) && (localObject1[1] <= 0.0D))
        {
          localObject1[0] = this.h.getLongitude();
          localObject1[1] = this.h.getLatitude();
        }
        i1 = 0;
      }
      localObject2 = String.format(Locale.CHINA, (String)localObject2, new Object[] { Double.valueOf(localObject1[0]), Double.valueOf(localObject1[1]), Integer.valueOf(i2), Float.valueOf(this.h.getBearing()), Float.valueOf(f1), Integer.valueOf(a) });
      localObject1 = localObject2;
      if (i1 == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",\"in_cn\":\"0\"");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (!h.l)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(String.format(Locale.CHINA, ",\"is_mock\":%d", new Object[] { Integer.valueOf(f(this.h)) }));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      Object localObject3;
      if (this.h.hasAltitude())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[] { Double.valueOf(this.h.getAltitude()) });
        localObject2 = localObject3;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject3 = "}}";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    return null;
  }
  
  public Location g()
  {
    if (this.h == null) {
      return null;
    }
    if (Math.abs(System.currentTimeMillis() - this.h.getTime()) > 60000L) {
      return null;
    }
    return this.h;
  }
  
  public BDLocation h()
  {
    if (this.ah == null) {
      return null;
    }
    if (Math.abs(System.currentTimeMillis() - this.ag) > 3000L) {
      return null;
    }
    return this.ah;
  }
  
  /* Error */
  public boolean i()
  {
    // Byte code:
    //   0: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: getstatic 334	com/baidu/location/c/d:a	I
    //   7: istore_3
    //   8: iload_3
    //   9: ifne +17 -> 26
    //   12: aload_0
    //   13: getfield 710	com/baidu/location/c/d:h	Landroid/location/Location;
    //   16: invokevirtual 691	android/location/Location:getExtras	()Landroid/os/Bundle;
    //   19: ldc_w 693
    //   22: invokevirtual 698	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   25: pop
    //   26: aload_0
    //   27: getfield 710	com/baidu/location/c/d:h	Landroid/location/Location;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +29 -> 63
    //   37: aload 4
    //   39: invokevirtual 322	android/location/Location:getLatitude	()D
    //   42: dconst_0
    //   43: dcmpl
    //   44: ifeq +19 -> 63
    //   47: aload_0
    //   48: getfield 710	com/baidu/location/c/d:h	Landroid/location/Location;
    //   51: invokevirtual 313	android/location/Location:getLongitude	()D
    //   54: dstore_1
    //   55: dload_1
    //   56: dconst_0
    //   57: dcmpl
    //   58: ifeq +5 -> 63
    //   61: iconst_1
    //   62: ireturn
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_0
    //   66: getfield 710	com/baidu/location/c/d:h	Landroid/location/Location;
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +27 -> 100
    //   76: aload 4
    //   78: invokevirtual 322	android/location/Location:getLatitude	()D
    //   81: dconst_0
    //   82: dcmpl
    //   83: ifeq +17 -> 100
    //   86: aload_0
    //   87: getfield 710	com/baidu/location/c/d:h	Landroid/location/Location;
    //   90: invokevirtual 313	android/location/Location:getLongitude	()D
    //   93: dconst_0
    //   94: dcmpl
    //   95: ifeq +5 -> 100
    //   98: iconst_1
    //   99: ireturn
    //   100: iconst_0
    //   101: ireturn
    //   102: astore 4
    //   104: goto -39 -> 65
    //   107: astore 4
    //   109: goto -83 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	d
    //   54	2	1	d1	double
    //   7	2	3	i1	int
    //   30	47	4	localLocation	Location
    //   102	1	4	localException1	Exception
    //   107	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	102	java/lang/Exception
    //   26	32	102	java/lang/Exception
    //   37	55	102	java/lang/Exception
    //   12	26	107	java/lang/Exception
  }
  
  public boolean j()
  {
    if (!i()) {
      return false;
    }
    if (System.currentTimeMillis() - this.E > 10000L) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    if ((this.A) && (l1 - this.z < 3000L)) {
      return true;
    }
    return this.D;
  }
  
  public void k()
  {
    if (this.o)
    {
      a locala = this.R;
      if (locala != null)
      {
        LocationManager localLocationManager = this.g;
        if (localLocationManager != null)
        {
          try
          {
            localLocationManager.unregisterGnssMeasurementsCallback(locala);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          this.R = null;
        }
      }
    }
  }
  
  /* Error */
  public String m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 948
    //   5: astore_1
    //   6: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   9: aload_0
    //   10: getfield 194	com/baidu/location/c/d:aa	J
    //   13: lsub
    //   14: invokestatic 685	java/lang/Math:abs	(J)J
    //   17: ldc2_w 661
    //   20: lcmp
    //   21: ifge +19 -> 40
    //   24: aload_0
    //   25: getfield 192	com/baidu/location/c/d:Z	Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +58 -> 88
    //   33: ldc_w 525
    //   36: astore_1
    //   37: goto +15 -> 52
    //   40: ldc_w 950
    //   43: astore_1
    //   44: goto +8 -> 52
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 248	java/lang/Throwable:printStackTrace	()V
    //   52: new 220	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc_w 952
    //   64: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: aload_1
    //   70: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: aload_2
    //   89: astore_1
    //   90: goto -38 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	d
    //   5	77	1	str1	String
    //   83	4	1	localObject1	Object
    //   89	1	1	localObject2	Object
    //   28	2	2	str2	String
    //   47	2	2	localObject3	Object
    //   59	30	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	29	47	finally
    //   48	52	83	finally
    //   52	79	83	finally
  }
  
  @TargetApi(24)
  private class a
    extends GnssMeasurementsEvent.Callback
  {
    public int a;
    
    public void onGnssMeasurementsReceived(GnssMeasurementsEvent paramGnssMeasurementsEvent) {}
    
    public void onStatusChanged(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  @TargetApi(24)
  private class b
    extends GnssNavigationMessage.Callback
  {
    public int a = 0;
    
    private b() {}
    
    public void onGnssNavigationMessageReceived(GnssNavigationMessage paramGnssNavigationMessage)
    {
      s locals;
      long l;
      if (d.e(d.this) != 0L)
      {
        locals = s.a();
        l = d.e(d.this);
      }
      else
      {
        locals = s.a();
        l = System.currentTimeMillis() / 1000L;
      }
      locals.a(paramGnssNavigationMessage, l);
    }
    
    public void onStatusChanged(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  @TargetApi(24)
  private class c
    extends GnssStatus.Callback
  {
    private c() {}
    
    public void onFirstFix(int paramInt) {}
    
    public void onSatelliteStatusChanged(GnssStatus paramGnssStatus)
    {
      if (d.f(d.this) == null) {
        return;
      }
      d.f(d.this, System.currentTimeMillis());
      int i2 = paramGnssStatus.getSatelliteCount();
      d.g(d.this).clear();
      d.h(d.this).clear();
      d.i(d.this).clear();
      d.j(d.this).clear();
      int j = 0;
      int k = 0;
      int i = k;
      int n;
      for (int m = i; j < i2; m = n)
      {
        n = m + 1;
        ArrayList localArrayList2 = new ArrayList();
        int i3 = paramGnssStatus.getConstellationType(j);
        localArrayList2.add(Float.valueOf(paramGnssStatus.getAzimuthDegrees(j)));
        localArrayList2.add(Float.valueOf(paramGnssStatus.getElevationDegrees(j)));
        localArrayList2.add(Float.valueOf(paramGnssStatus.getCn0DbHz(j)));
        if (paramGnssStatus.usedInFix(j))
        {
          int i1 = k + 1;
          localArrayList2.add(Float.valueOf(1.0F));
          k = i1;
          m = i;
          if (i3 == 1)
          {
            m = i + 1;
            k = i1;
          }
        }
        else
        {
          localArrayList2.add(Float.valueOf(0.0F));
          m = i;
        }
        localArrayList2.add(Float.valueOf(paramGnssStatus.getSvid(j)));
        ArrayList localArrayList1;
        if (i3 == 1)
        {
          localArrayList2.add(Float.valueOf(1.0F));
          localArrayList1 = d.g(d.this);
        }
        for (;;)
        {
          localArrayList1.add(localArrayList2);
          break;
          if (i3 == 5)
          {
            localArrayList2.add(Float.valueOf(2.0F));
            localArrayList1 = d.h(d.this);
          }
          else if (i3 == 3)
          {
            localArrayList2.add(Float.valueOf(3.0F));
            localArrayList1 = d.i(d.this);
          }
          else
          {
            if (i3 != 6) {
              break;
            }
            localArrayList2.add(Float.valueOf(4.0F));
            localArrayList1 = d.j(d.this);
          }
        }
        j += 1;
        i = m;
      }
      paramGnssStatus = new ArrayList();
      paramGnssStatus.addAll(d.g(d.this));
      paramGnssStatus.addAll(d.h(d.this));
      paramGnssStatus.addAll(d.i(d.this));
      paramGnssStatus.addAll(d.j(d.this));
      d.a(d.this, paramGnssStatus);
      paramGnssStatus = d.this;
      d.b(paramGnssStatus, d.a(paramGnssStatus, true, false, false, false, true, -1.0F));
      paramGnssStatus = d.this;
      d.b = d.c(paramGnssStatus, d.k(paramGnssStatus));
      paramGnssStatus = d.this;
      d.d(paramGnssStatus, d.a(paramGnssStatus, true, true, true, true, true, -1.0F));
      paramGnssStatus = d.this;
      d.c = d.c(paramGnssStatus, d.l(paramGnssStatus));
      d.a = k;
      d.a(i);
      d.f(m);
      d.a(System.currentTimeMillis());
      paramGnssStatus = d.this;
      d.b(d.a(paramGnssStatus, d.i(paramGnssStatus), true, -1.0F).size());
      paramGnssStatus = d.this;
      d.c(d.a(paramGnssStatus, d.j(paramGnssStatus), true, -1.0F).size());
      paramGnssStatus = d.this;
      d.d(d.a(paramGnssStatus, d.h(paramGnssStatus), true, -1.0F).size());
    }
    
    public void onStarted() {}
    
    public void onStopped()
    {
      d.b(d.this, null);
      d.a(d.this, false);
      d.a = 0;
      d.a(0);
      d.b(0);
      d.c(0);
      d.d(0);
      d.e(-1);
      d.d(null);
    }
  }
  
  private class d
    implements GpsStatus.Listener
  {
    private long b = 0L;
    
    private d() {}
    
    public void onGpsStatusChanged(int paramInt)
    {
      if (d.f(d.this) == null) {
        return;
      }
      int i = 0;
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return;
        }
        if (!d.b(d.this)) {
          return;
        }
      }
      try
      {
        if (d.m(d.this) == null)
        {
          localObject = d.this;
          d.a((d)localObject, d.f((d)localObject).getGpsStatus(null));
        }
        else
        {
          d.f(d.this).getGpsStatus(d.m(d.this));
        }
        Iterator localIterator = d.m(d.this).getSatellites().iterator();
        d.f(d.this, System.currentTimeMillis());
        d.g(d.this).clear();
        d.h(d.this).clear();
        d.i(d.this).clear();
        d.j(d.this).clear();
        paramInt = 0;
        if (localIterator.hasNext())
        {
          localObject = (GpsSatellite)localIterator.next();
          ArrayList localArrayList = new ArrayList();
          int m = ((GpsSatellite)localObject).getPrn();
          localArrayList.add(Float.valueOf(((GpsSatellite)localObject).getAzimuth()));
          localArrayList.add(Float.valueOf(((GpsSatellite)localObject).getElevation()));
          localArrayList.add(Float.valueOf(((GpsSatellite)localObject).getSnr()));
          int j;
          int k;
          if (((GpsSatellite)localObject).usedInFix())
          {
            i += 1;
            localArrayList.add(Float.valueOf(1.0F));
            j = paramInt;
            k = i;
            if (m >= 1)
            {
              j = paramInt;
              k = i;
              if (m <= 32)
              {
                j = paramInt + 1;
                k = i;
              }
            }
          }
          else
          {
            localArrayList.add(Float.valueOf(0.0F));
            k = i;
            j = paramInt;
          }
          localArrayList.add(Float.valueOf(m));
          if ((m >= 1) && (m <= 32))
          {
            localArrayList.add(Float.valueOf(1.0F));
            localObject = d.g(d.this);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(localArrayList);
            paramInt = j;
            i = k;
            break;
            if ((m >= 201) && (m <= 235))
            {
              localArrayList.add(Float.valueOf(2.0F));
              localObject = d.h(d.this);
            }
            else if ((m >= 65) && (m <= 96))
            {
              localArrayList.add(Float.valueOf(3.0F));
              localObject = d.i(d.this);
            }
            else
            {
              paramInt = j;
              i = k;
              if (m < 301) {
                break;
              }
              paramInt = j;
              i = k;
              if (m > 336) {
                break;
              }
              localArrayList.add(Float.valueOf(4.0F));
              localObject = d.j(d.this);
            }
          }
        }
        Object localObject = new ArrayList();
        ((ArrayList)localObject).addAll(d.g(d.this));
        ((ArrayList)localObject).addAll(d.h(d.this));
        ((ArrayList)localObject).addAll(d.i(d.this));
        ((ArrayList)localObject).addAll(d.j(d.this));
        d.a(d.this, (ArrayList)localObject);
        localObject = d.this;
        d.b((d)localObject, d.a((d)localObject, true, false, false, false, true, -1.0F));
        localObject = d.this;
        d.b = d.c((d)localObject, d.k((d)localObject));
        localObject = d.this;
        d.d((d)localObject, d.a((d)localObject, true, true, true, true, true, -1.0F));
        localObject = d.this;
        d.c = d.c((d)localObject, d.l((d)localObject));
        if (paramInt > 0) {
          d.a(paramInt);
        }
        if (i > 0) {}
        for (long l = System.currentTimeMillis();; l = System.currentTimeMillis())
        {
          this.b = l;
          d.a = i;
          break;
          if (System.currentTimeMillis() - this.b <= 100L) {
            break;
          }
        }
        d.a(System.currentTimeMillis());
        return;
      }
      catch (Exception localException) {}
      d.b(d.this, null);
      d.a(d.this, false);
      d.a = 0;
      d.a(0);
      d.b(0);
      d.c(0);
      d.d(0);
      return;
    }
  }
  
  private static class e
    extends Handler
  {
    WeakReference<d> a;
    d b;
    
    e(d paramd)
    {
      this.a = new WeakReference(paramd);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (!f.isServing) {
        return;
      }
      d locald = (d)this.a.get();
      this.b = locald;
      if (locald == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        Location localLocation;
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            d.a(locald, (String)paramMessage.obj);
            return;
          }
          localLocation = (Location)paramMessage.obj;
          paramMessage = "&og=2";
        }
        else
        {
          localLocation = (Location)paramMessage.obj;
          paramMessage = "&og=1";
        }
        d.a(locald, paramMessage, localLocation);
        return;
      }
      d.a(locald, (Location)paramMessage.obj);
    }
  }
  
  private class f
    implements LocationListener
  {
    private f() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if ((paramLocation == null) && (h.f == 4)) {
        return;
      }
      if (h.a(paramLocation)) {
        return;
      }
      int j;
      int i;
      if (Math.abs(paramLocation.getLatitude()) <= 360.0D)
      {
        if (Math.abs(paramLocation.getLongitude()) > 360.0D) {
          return;
        }
        d.a(d.this, paramLocation.getTime() / 1000L);
        d.b(d.this, System.currentTimeMillis());
        if (d.c(d.this) != 0L) {
          d.c(d.this, System.currentTimeMillis() - d.c(d.this));
        }
        d.d(d.this, System.currentTimeMillis());
        j = d.a;
        i = j;
        if (j != 0) {}
      }
      try
      {
        i = paramLocation.getExtras().getInt("satellites");
        if ((i == 0) || (k.c().j()))
        {
          System.currentTimeMillis();
          d.d(d.this);
        }
        d.a(d.this, true);
        d.b(d.this, paramLocation);
        d.b(d.this, false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = j;
        }
      }
    }
    
    public void onProviderDisabled(String paramString)
    {
      d.b(d.this, null);
      d.a(d.this, false);
    }
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          d.b(d.this, false);
          return;
        }
        d.e(d.this, System.currentTimeMillis());
        d.b(d.this, true);
      }
      else
      {
        d.b(d.this, null);
      }
      d.a(d.this, false);
    }
  }
  
  private class g
    implements GpsStatus.NmeaListener
  {
    private g() {}
    
    public void onNmeaReceived(long paramLong, String paramString)
    {
      if (d.a(d.this) != null)
      {
        paramString = d.a(d.this).obtainMessage(5, paramString);
        d.a(d.this).sendMessage(paramString);
      }
    }
  }
  
  private class h
    implements LocationListener
  {
    private long b = 0L;
    
    private h() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if ((d.b(d.this)) && (h.f == 4)) {
        return;
      }
      if ((paramLocation != null) && (TextUtils.equals(paramLocation.getProvider(), "gps")))
      {
        if (System.currentTimeMillis() - this.b < 10000L) {
          return;
        }
        if (Math.abs(paramLocation.getLatitude()) <= 360.0D)
        {
          if (Math.abs(paramLocation.getLongitude()) > 360.0D) {
            return;
          }
          if (r.a(paramLocation, false))
          {
            this.b = System.currentTimeMillis();
            if (d.a(d.this) != null)
            {
              d.this.d = System.currentTimeMillis();
              paramLocation = d.a(d.this).obtainMessage(4, paramLocation);
              d.a(d.this).sendMessage(paramLocation);
            }
          }
        }
      }
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.d
 * JD-Core Version:    0.7.0.1
 */