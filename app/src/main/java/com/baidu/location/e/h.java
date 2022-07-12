package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.a;
import com.baidu.location.c.d;
import com.baidu.location.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class h
{
  public static float A = 2.3F;
  public static float B = 3.8F;
  public static int C = 3;
  public static int D = 10;
  public static int E = 2;
  public static int F = 7;
  public static int G = 20;
  public static int H = 70;
  public static int I = 120;
  public static float J = 2.0F;
  public static float K = 10.0F;
  public static float L = 50.0F;
  public static float M = 200.0F;
  public static int N = 16;
  public static int O = 32;
  public static float P = 0.9F;
  public static int Q = 10000;
  public static float R = 0.5F;
  public static float S = 0.0F;
  public static float T = 0.1F;
  public static int U = 30;
  public static int V = 100;
  public static int W = 0;
  public static int X = 0;
  public static int Y = 0;
  public static int Z = 420000;
  public static boolean a = false;
  public static double aA = -0.1000000014901161D;
  public static int aB = 0;
  public static int aC = 0;
  public static int aD = 1;
  public static boolean aE = false;
  public static int aF = -1;
  public static int aG = 10;
  public static int aH = 3;
  public static int aI = 40;
  public static double[] aJ;
  public static int aK = 1;
  public static int aL = 1;
  public static int aM = 1;
  public static boolean aN = false;
  private static String aO = Build.MANUFACTURER;
  public static boolean aa = true;
  public static boolean ab = true;
  public static int ac = 20;
  public static int ad = 300;
  public static int ae = 1000;
  public static int af = 2147483647;
  public static long ag = 900000L;
  public static long ah = 420000L;
  public static long ai = 180000L;
  public static long aj = 0L;
  public static long ak = 15L;
  public static long al = 300000L;
  public static int am = 1000;
  public static int an = 0;
  public static int ao = 30000;
  public static int ap = 30000;
  public static float aq = 10.0F;
  public static float ar = 6.0F;
  public static float as = 10.0F;
  public static int at = 60;
  public static int au = 70;
  public static int av = 6;
  public static String aw;
  public static boolean ax = false;
  public static int ay = 16;
  public static float az = 0.75F;
  public static boolean b = false;
  public static boolean c = false;
  public static int d = 0;
  public static String e = "no";
  public static int f = 4;
  public static boolean g = false;
  public static boolean h = false;
  public static boolean i = false;
  public static boolean j = false;
  public static boolean k = false;
  public static boolean l = false;
  public static String m = "gcj02";
  public static String n = "";
  public static boolean o = true;
  public static int p = 3;
  public static double q = 0.0D;
  public static double r = 0.0D;
  public static double s = 0.0D;
  public static double t = 0.0D;
  public static int u = 0;
  public static byte[] v;
  public static boolean w = false;
  public static int x = 0;
  public static float y = 1.1F;
  public static float z = 2.2F;
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(paramDouble1, paramDouble2, paramDouble3, paramDouble4, arrayOfFloat);
    return arrayOfFloat[0];
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      int i1 = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      return i1;
    }
    catch (Exception paramContext)
    {
      label13:
      break label13;
    }
    return 2;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      i1 = paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
      if (i1 != 0) {
        i1 = 0;
      }
    }
    catch (Exception paramContext)
    {
      int i1;
      label24:
      break label24;
    }
    i1 = 1;
    if (i1 == 0) {
      return 0;
    }
    return 1;
  }
  
  public static int a(Object paramObject, String paramString)
  {
    paramString = paramObject.getClass().getDeclaredMethod(paramString, null);
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return ((Integer)paramString.invoke(paramObject, null)).intValue();
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int i1;
    if (paramString1 != null)
    {
      if (paramString1.equals("")) {
        return -2147483648;
      }
      i1 = paramString1.indexOf(paramString2);
      if (i1 == -1) {
        return -2147483648;
      }
      i1 += paramString2.length();
      int i2 = paramString1.indexOf(paramString3, i1);
      if (i2 == -1) {
        return -2147483648;
      }
      paramString1 = paramString1.substring(i1, i2);
      if (paramString1 != null) {
        if (paramString1.equals("")) {
          return -2147483648;
        }
      }
    }
    try
    {
      i1 = Integer.parseInt(paramString1);
      return i1;
    }
    catch (NumberFormatException paramString1) {}
    return -2147483648;
    return -2147483648;
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(11);
    int i5 = localCalendar.get(12);
    int i6 = localCalendar.get(13);
    return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
  }
  
  public static String a(a parama, com.baidu.location.c.h paramh, Location paramLocation, String paramString, int paramInt)
  {
    return a(parama, paramh, paramLocation, paramString, paramInt, false);
  }
  
  public static String a(a parama, com.baidu.location.c.h paramh, Location paramLocation, String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(2048);
    if (parama != null)
    {
      str = com.baidu.location.c.b.a().b(parama);
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (paramh != null)
    {
      if (paramInt == 0)
      {
        if (paramBoolean) {
          str = paramh.b();
        } else {
          str = paramh.c();
        }
      }
      else {
        str = paramh.d();
      }
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (paramLocation != null)
    {
      if ((d != 0) && (paramInt != 0)) {
        str = d.c(paramLocation);
      } else {
        str = d.b(paramLocation);
      }
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    paramBoolean = false;
    if (paramInt == 0) {
      paramBoolean = true;
    }
    String str = b.a().a(paramBoolean);
    if (str != null) {
      localStringBuffer.append(str);
    }
    if (paramString != null) {
      localStringBuffer.append(paramString);
    }
    localStringBuffer.append(d.a().m());
    parama = com.baidu.location.c.b.a().a(parama);
    if ((parama != null) && (parama.length() + localStringBuffer.length() < 2000)) {
      localStringBuffer.append(parama);
    }
    parama = localStringBuffer.toString();
    if ((paramLocation != null) && (paramh != null)) {}
    try
    {
      float f1 = paramLocation.getSpeed();
      paramInt = d;
      int i1 = paramh.h();
      int i2 = paramh.a();
      paramBoolean = paramh.i();
      if ((f1 < ar) && ((paramInt == 1) || (paramInt == 0)) && ((i1 < at) || (paramBoolean == true)))
      {
        p = 1;
        return parama;
      }
      if ((f1 < as) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 3)) && ((i1 < au) || (i2 > av)))
      {
        p = 2;
        return parama;
      }
      p = 3;
      return parama;
    }
    catch (Exception paramh)
    {
      label361:
      break label361;
    }
    p = 3;
    return parama;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append(";");
    localStringBuilder.append(paramString);
    return Jni.en1(localStringBuilder.toString());
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i1] & 0xFF);
      String str1 = str2;
      if (paramBoolean) {
        str1 = str2.toUpperCase();
      }
      if (str1.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(paramString);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = a(localMessageDigest.digest(), "", paramBoolean);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) <= 1.192092896E-007D;
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) <= 1.192093E-007F;
  }
  
  public static boolean a(Location paramLocation)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLocation != null)
    {
      String str = aO;
      bool1 = bool2;
      if (str != null) {
        if (!"huawei".equalsIgnoreCase(str)) {
          return false;
        }
      }
    }
    try
    {
      paramLocation = paramLocation.getExtras();
      bool1 = bool2;
      if (paramLocation != null)
      {
        int i1 = paramLocation.getInt("SourceType");
        bool1 = bool2;
        if ((i1 & 0x80) == 128) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramLocation) {}
    return false;
  }
  
  public static boolean a(BDLocation paramBDLocation)
  {
    int i1 = paramBDLocation.getLocType();
    return ((i1 > 100) && (i1 < 200)) || (i1 == 62);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      int i1 = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode", -1);
      return i1;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    finally
    {
      label7:
      break label7;
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
      byte[] arrayOfByte = new byte[2048];
      for (;;)
      {
        int i1 = paramArrayOfByte.read(arrayOfByte);
        if (i1 < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i1);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static String c()
  {
    String str = "";
    try
    {
      InetAddress localInetAddress;
      do
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        while (!((Enumeration)localObject).hasMoreElements())
        {
          localObject = str;
          if (!localEnumeration.hasMoreElements()) {
            break;
          }
          localObject = ((NetworkInterface)localEnumeration.nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet6Address)) || (localInetAddress.getHostAddress() == null) || (localInetAddress.getHostAddress().startsWith("fe80:")));
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (SocketException localSocketException) {}
    return "";
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 572	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_2
    //   6: new 379	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 574
    //   18: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_0
    //   24: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: new 576	java/io/BufferedReader
    //   31: dup
    //   32: new 578	java/io/InputStreamReader
    //   35: dup
    //   36: aload_2
    //   37: aload_3
    //   38: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 582	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   44: invokevirtual 588	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: invokespecial 589	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   50: sipush 1024
    //   53: invokespecial 592	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 595	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 596	java/io/BufferedReader:close	()V
    //   66: aload_0
    //   67: invokevirtual 596	java/io/BufferedReader:close	()V
    //   70: aload_1
    //   71: invokestatic 602	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifeq +5 -> 79
    //   77: aconst_null
    //   78: areturn
    //   79: aload_1
    //   80: areturn
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: goto +4 -> 90
    //   89: astore_0
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 596	java/io/BufferedReader:close	()V
    //   98: aload_0
    //   99: athrow
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 596	java/io/BufferedReader:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: goto -13 -> 100
    //   116: astore_1
    //   117: goto -15 -> 102
    //   120: astore_0
    //   121: goto -51 -> 70
    //   124: astore_1
    //   125: goto -27 -> 98
    //   128: astore_0
    //   129: aconst_null
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   1	94	1	str	String
    //   116	1	1	localIOException1	IOException
    //   124	1	1	localIOException2	IOException
    //   5	32	2	localRuntime	java.lang.Runtime
    //   81	4	2	localObject	Object
    //   13	25	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	66	81	finally
    //   2	57	89	finally
    //   2	57	112	java/io/IOException
    //   57	66	116	java/io/IOException
    //   66	70	120	java/io/IOException
    //   94	98	124	java/io/IOException
    //   106	110	128	java/io/IOException
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = true;
    int i1;
    if (paramContext != null)
    {
      try
      {
        i1 = paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 = 0;
      }
      if (i1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
      if (!bool) {}
    }
    try
    {
      i1 = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode", 1);
      if (i1 == 0) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      label57:
      break label57;
    }
    return bool;
  }
  
  public static String d()
  {
    return "https://daup.map.baidu.com/cltr/rcvr";
  }
  
  public static String d(Context paramContext)
  {
    int i1 = a(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
    int i2 = a(paramContext, "android.permission.ACCESS_FINE_LOCATION");
    int i3 = a(paramContext, "android.permission.READ_PHONE_STATE");
    paramContext = new StringBuilder();
    paramContext.append("&per=");
    paramContext.append(i1);
    paramContext.append("|");
    paramContext.append(i2);
    paramContext.append("|");
    paramContext.append(i3);
    return paramContext.toString();
  }
  
  public static String e()
  {
    Object localObject2;
    if (Build.VERSION.SDK_INT <= 28) {
      try
      {
        if (Environment.getExternalStorageState().equals("mounted")) {
          localObject2 = Environment.getExternalStorageDirectory().getPath();
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else {
      localObject2 = null;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT > 28)
      {
        localObject1 = localObject2;
        if (f.getServiceContext() == null) {}
      }
    }
    try
    {
      localObject1 = f.getServiceContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
    }
    catch (Exception localException3)
    {
      label77:
      break label77;
    }
    localObject1 = null;
    if (localObject1 != null) {
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("/baidu/tempdata");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return null;
      }
    }
    return localException2;
  }
  
  public static String e(Context paramContext)
  {
    i2 = -1;
    i1 = i2;
    if (paramContext != null) {}
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      i1 = i2;
      if (paramContext != null)
      {
        i1 = i2;
        if (paramContext.isAvailable()) {
          i1 = paramContext.getType();
        }
      }
    }
    finally
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("&netc=");
    paramContext.append(i1);
    return paramContext.toString();
  }
  
  public static String f()
  {
    String str = e();
    if (str == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/baidu/tempdata");
    return localStringBuilder.toString();
  }
  
  public static String g()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f.getServiceContext().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("lldt");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
      return localObject;
    }
    catch (Exception localException)
    {
      label66:
      break label66;
    }
    return null;
  }
  
  public static String h()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f.getServiceContext().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("/baidu/tempdata");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = f.getServiceContext().getFilesDir().getPath();
      return localObject;
    }
    catch (Exception localException)
    {
      label71:
      break label71;
    }
    return null;
  }
  
  public static String i()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f.getServiceContext().getFilesDir());
      String str = File.separator;
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/baidu/tempdata");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f.getServiceContext().getFilesDir().getPath());
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/baidu/tempdata");
      str = ((StringBuilder)localObject).toString();
      return str;
    }
    catch (Exception localException)
    {
      label104:
      break label104;
    }
    return null;
  }
  
  public static String j()
  {
    return c("ro.mediatek.platform");
  }
  
  public static SSLSocketFactory k()
  {
    X509TrustManager local1 = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        int j = paramAnonymousArrayOfX509Certificate.length;
        int i = 0;
        while (i < j)
        {
          paramAnonymousArrayOfX509Certificate[i].checkValidity();
          i += 1;
        }
      }
      
      public X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    SecureRandom localSecureRandom = new SecureRandom();
    localSSLContext.init(null, new TrustManager[] { local1 }, localSecureRandom);
    return localSSLContext.getSocketFactory();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.e.h
 * JD-Core Version:    0.7.0.1
 */