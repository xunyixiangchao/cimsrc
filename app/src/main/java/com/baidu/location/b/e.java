package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.c.c;
import com.baidu.location.e.f;
import com.baidu.location.e.g;
import com.baidu.location.e.h;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static String f = "0";
  private static e j;
  private b A = null;
  private boolean B = false;
  private boolean C = false;
  private int D = 0;
  private float E = 0.0F;
  private float F = 0.0F;
  private long G = 0L;
  private int H = 500;
  private Handler I = null;
  private byte[] J = new byte[4];
  private byte[] K = null;
  private int L = 0;
  private List<Byte> M = null;
  private boolean N = false;
  long a = 0L;
  Location b = null;
  Location c = null;
  StringBuilder d = null;
  long e = 0L;
  int g = 0;
  double h = 116.22345545D;
  double i = 40.245667322999999D;
  private int k = 1;
  private double l = 0.699999988079071D;
  private String m = "3G|4G";
  private int n = 1;
  private int o = 307200;
  private int p = 15;
  private int q = 1;
  private double r = 3.5D;
  private double s = 3.0D;
  private double t = 0.5D;
  private int u = 300;
  private int v = 60;
  private int w = 0;
  private int x = 60;
  private int y = 0;
  private long z = 0L;
  
  public static e a()
  {
    if (j == null) {
      j = new e();
    }
    return j;
  }
  
  private String a(File paramFile, String paramString)
  {
    String str = UUID.randomUUID().toString();
    try
    {
      HttpsURLConnection.setDefaultSSLSocketFactory(h.k());
      Object localObject1 = new URL(paramString);
      paramString = (HttpsURLConnection)((URL)localObject1).openConnection();
      paramString.setReadTimeout(10000);
      paramString.setConnectTimeout(10000);
      paramString.setDoInput(true);
      paramString.setDoOutput(true);
      paramString.setUseCaches(false);
      paramString.setRequestMethod("POST");
      paramString.setRequestProperty("Charset", "utf-8");
      paramString.setHostnameVerifier(new a((URL)localObject1));
      paramString.setRequestProperty("connection", "close");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("multipart/form-data");
      ((StringBuilder)localObject1).append(";boundary=");
      ((StringBuilder)localObject1).append(str);
      paramString.setRequestProperty("Content-Type", ((StringBuilder)localObject1).toString());
      if ((paramFile != null) && (paramFile.exists()))
      {
        localObject1 = paramString.getOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject1);
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("--");
        ((StringBuffer)localObject2).append(str);
        ((StringBuffer)localObject2).append("\r\n");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"");
        localStringBuilder.append(paramFile.getName());
        localStringBuilder.append("\"");
        localStringBuilder.append("\r\n");
        ((StringBuffer)localObject2).append(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Content-Type: application/octet-stream; charset=utf-8");
        localStringBuilder.append("\r\n");
        ((StringBuffer)localObject2).append(localStringBuilder.toString());
        ((StringBuffer)localObject2).append("\r\n");
        localDataOutputStream.write(((StringBuffer)localObject2).toString().getBytes());
        paramFile = new FileInputStream(paramFile);
        localObject2 = new byte[1024];
        for (;;)
        {
          i1 = paramFile.read((byte[])localObject2);
          if (i1 == -1) {
            break;
          }
          localDataOutputStream.write((byte[])localObject2, 0, i1);
        }
        paramFile.close();
        localDataOutputStream.write("\r\n".getBytes());
        paramFile = new StringBuilder();
        paramFile.append("--");
        paramFile.append(str);
        paramFile.append("--");
        paramFile.append("\r\n");
        localDataOutputStream.write(paramFile.toString().getBytes());
        localDataOutputStream.flush();
        localDataOutputStream.close();
        int i1 = paramString.getResponseCode();
        ((OutputStream)localObject1).close();
        paramString.disconnect();
        int i2 = this.y + 400;
        this.y = i2;
        c(i2);
        if (i1 == 200) {
          return "1";
        }
      }
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return "0";
    }
    catch (MalformedURLException|IOException paramFile)
    {
      label491:
      break label491;
    }
  }
  
  private boolean a(String paramString, Context paramContext)
  {
    return true;
  }
  
  private byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((paramInt & 0xFF000000) >> 24) };
  }
  
  private byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes();
    int i1 = (byte)new SecureRandom().nextInt(255);
    int i2 = (byte)new SecureRandom().nextInt(255);
    byte[] arrayOfByte = new byte[paramString.length + 2];
    int i5 = paramString.length;
    int i4 = 0;
    int i3 = 0;
    while (i4 < i5)
    {
      arrayOfByte[i3] = ((byte)(paramString[i4] ^ i1));
      i4 += 1;
      i3 += 1;
    }
    arrayOfByte[i3] = i1;
    arrayOfByte[(i3 + 1)] = i2;
    return arrayOfByte;
  }
  
  private String b(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  private void b(int paramInt)
  {
    byte[] arrayOfByte = a(paramInt);
    paramInt = 0;
    while (paramInt < 4)
    {
      this.M.add(Byte.valueOf(arrayOfByte[paramInt]));
      paramInt += 1;
    }
  }
  
  private void b(Location paramLocation)
  {
    c(paramLocation);
    h();
  }
  
  private void c()
  {
    if (this.N) {
      return;
    }
    this.N = true;
    d(com.baidu.location.e.b.e);
    j();
    d();
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(g.a);
    ((StringBuilder)localObject1).append("/grtcf.dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      localObject1 = new File((String)localObject1);
      boolean bool = ((File)localObject1).exists();
      if (!bool)
      {
        localObject2 = new File(g.a);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (!((File)localObject1).createNewFile()) {
          return;
        }
        localObject2 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject2).seek(2L);
        ((RandomAccessFile)localObject2).writeInt(0);
        ((RandomAccessFile)localObject2).seek(8L);
        byte[] arrayOfByte = "1980_01_01:0".getBytes();
        ((RandomAccessFile)localObject2).writeInt(arrayOfByte.length);
        ((RandomAccessFile)localObject2).write(arrayOfByte);
        ((RandomAccessFile)localObject2).seek(200L);
        ((RandomAccessFile)localObject2).writeBoolean(false);
        ((RandomAccessFile)localObject2).seek(800L);
        ((RandomAccessFile)localObject2).writeBoolean(false);
        ((RandomAccessFile)localObject2).close();
      }
      localObject1 = new RandomAccessFile((File)localObject1, "rw");
      ((RandomAccessFile)localObject1).seek(8L);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b("%d_%02d_%02d"));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramInt);
      localObject2 = ((StringBuilder)localObject2).toString().getBytes();
      ((RandomAccessFile)localObject1).writeInt(localObject2.length);
      ((RandomAccessFile)localObject1).write((byte[])localObject2);
      ((RandomAccessFile)localObject1).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c(Location paramLocation)
  {
    if (System.currentTimeMillis() - this.a >= this.H)
    {
      if (paramLocation == null) {
        return;
      }
      if ((paramLocation.hasSpeed()) && (paramLocation.getSpeed() > this.E)) {
        this.E = paramLocation.getSpeed();
      }
    }
    try
    {
      if (this.M == null)
      {
        this.M = new ArrayList();
        i();
        d(paramLocation);
      }
      else
      {
        e(paramLocation);
      }
    }
    catch (Exception paramLocation)
    {
      label84:
      break label84;
    }
    this.L += 1;
  }
  
  private void c(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("on")) {
        this.k = paramString.getInt("on");
      }
      if (paramString.has("bash")) {
        this.l = paramString.getDouble("bash");
      }
      if (paramString.has("net")) {
        this.m = paramString.getString("net");
      }
      if (paramString.has("tcon")) {
        this.n = paramString.getInt("tcon");
      }
      if (paramString.has("tcsh")) {
        this.o = paramString.getInt("tcsh");
      }
      if (paramString.has("per")) {
        this.p = paramString.getInt("per");
      }
      if (paramString.has("chdron")) {
        this.q = paramString.getInt("chdron");
      }
      if (paramString.has("spsh")) {
        this.r = paramString.getDouble("spsh");
      }
      if (paramString.has("acsh")) {
        this.s = paramString.getDouble("acsh");
      }
      if (paramString.has("stspsh")) {
        this.t = paramString.getDouble("stspsh");
      }
      if (paramString.has("drstsh")) {
        this.u = paramString.getInt("drstsh");
      }
      if (paramString.has("stper")) {
        this.v = paramString.getInt("stper");
      }
      if (paramString.has("nondron")) {
        this.w = paramString.getInt("nondron");
      }
      if (paramString.has("nondrper")) {
        this.x = paramString.getInt("nondrper");
      }
      if (paramString.has("uptime")) {
        this.z = paramString.getLong("uptime");
      }
      k();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void d()
  {
    Object localObject = "9.3.0.3".split("\\.");
    int i4 = localObject.length;
    byte[] arrayOfByte = this.J;
    int i3 = 0;
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 0;
    arrayOfByte[3] = 0;
    int i1 = i4;
    int i2 = i3;
    if (i4 >= 4)
    {
      i1 = 4;
      i2 = i3;
    }
    for (;;)
    {
      if (i2 < i1) {}
      try
      {
        this.J[i2] = ((byte)(Integer.valueOf(localObject[i2]).intValue() & 0xFF));
        i2 += 1;
      }
      catch (Exception localException)
      {
        label92:
        break label92;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(com.baidu.location.e.b.e);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(com.baidu.location.e.b.a().c);
    this.K = a(((StringBuilder)localObject).toString());
  }
  
  private void d(Location paramLocation)
  {
    this.e = System.currentTimeMillis();
    b((int)(paramLocation.getTime() / 1000L));
    b((int)(paramLocation.getLongitude() * 1000000.0D));
    b((int)(paramLocation.getLatitude() * 1000000.0D));
    boolean bool1 = paramLocation.hasBearing();
    boolean bool2 = paramLocation.hasSpeed();
    byte b1;
    if ((bool1 ^ true)) {
      b1 = 32;
    } else {
      b1 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0xFFFFFFDF);
    }
    this.M.add(Byte.valueOf(b1));
    if ((bool2 ^ true)) {
      b1 = -128;
    } else {
      b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
    }
    this.M.add(Byte.valueOf(b1));
    this.b = paramLocation;
  }
  
  private void d(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(g.a);
    ((StringBuilder)localObject1).append("/grtcf.dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists())
      {
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(2L);
        i3 = ((RandomAccessFile)localObject1).readInt();
        ((RandomAccessFile)localObject1).seek(8L);
        int i4 = ((RandomAccessFile)localObject1).readInt();
        i2 = 1;
        i1 = i2;
        if (i4 < 4096)
        {
          localObject2 = new byte[i4];
          ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i4);
          localObject2 = new String((byte[])localObject2);
          i1 = i2;
          if (((String)localObject2).contains(b("%d_%02d_%02d")))
          {
            boolean bool = ((String)localObject2).contains(":");
            i1 = i2;
            if (!bool) {}
          }
        }
      }
    }
    catch (Exception paramString)
    {
      int i3;
      Object localObject2;
      label206:
      long l1;
      return;
    }
    try
    {
      localObject2 = ((String)localObject2).split(":");
      i1 = i2;
      if (localObject2.length > 1)
      {
        this.y = Integer.valueOf(localObject2[1]).intValue();
        i1 = i2;
      }
    }
    catch (Exception localException)
    {
      i1 = i2;
      break label206;
      i1 += 1;
      break label206;
    }
    if (i1 <= i3)
    {
      l1 = i1 * 2048;
      ((RandomAccessFile)localObject1).seek(l1);
      i2 = ((RandomAccessFile)localObject1).readInt();
      if (i2 > 4096) {
        break label306;
      }
      localObject2 = new byte[i2];
      ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i2);
      localObject2 = new String((byte[])localObject2);
      if ((paramString == null) || (!((String)localObject2).contains(paramString))) {
        break label306;
      }
      c((String)localObject2);
    }
    ((RandomAccessFile)localObject1).close();
  }
  
  private void e(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    int i2 = (int)((paramLocation.getLongitude() - this.b.getLongitude()) * 1000000.0D);
    int i3 = (int)((paramLocation.getLatitude() - this.b.getLatitude()) * 1000000.0D);
    boolean bool1 = paramLocation.hasBearing();
    boolean bool2 = paramLocation.hasSpeed();
    int i1;
    if (i2 > 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i4 = Math.abs(i2);
    if (i3 > 0) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    i3 = Math.abs(i3);
    if (this.L > 1) {
      this.c = this.b;
    }
    this.b = paramLocation;
    if ((this.c != null) && (paramLocation.getTime() > this.c.getTime()) && (this.b.getTime() - this.c.getTime() < 5000L))
    {
      long l1 = this.b.getTime() - this.c.getTime();
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.b.getAltitude(), this.b.getLongitude(), this.c.getLatitude(), this.c.getLongitude(), arrayOfFloat);
      double d1 = (arrayOfFloat[0] - this.c.getSpeed() * (float)l1) * 2.0F / (float)(l1 * l1);
      if (d1 > this.F) {
        this.F = ((float)d1);
      }
    }
    this.M.add(Byte.valueOf((byte)(i4 & 0xFF)));
    this.M.add(Byte.valueOf((byte)((i4 & 0xFF00) >> 8)));
    this.M.add(Byte.valueOf((byte)(i3 & 0xFF)));
    this.M.add(Byte.valueOf((byte)((i3 & 0xFF00) >> 8)));
    if ((bool1 ^ true))
    {
      b1 = 32;
      if (i2 > 0) {
        b1 = (byte)96;
      }
      b2 = b1;
      if (i1 <= 0) {
        break label430;
      }
      i1 = b1;
    }
    else
    {
      b2 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0x1F);
      b1 = b2;
      if (i2 > 0) {
        b1 = (byte)(b2 | 0x40);
      }
      b2 = b1;
      if (i1 <= 0) {
        break label430;
      }
      i1 = b1;
    }
    byte b2 = (byte)(i1 | 0xFFFFFF80);
    label430:
    this.M.add(Byte.valueOf(b2));
    if ((bool2 ^ true))
    {
      this.M.add(Byte.valueOf((byte)-128));
      return;
    }
    byte b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
    this.M.add(Byte.valueOf(b1));
  }
  
  private void e(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(g.a);
    ((StringBuilder)localObject1).append("/grtcf.dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = new File((String)localObject1);
        boolean bool = ((File)localObject1).exists();
        Object localObject2;
        if (!bool)
        {
          localObject2 = new File(g.a);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          if (!((File)localObject1).createNewFile()) {
            break label333;
          }
          localObject2 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject2).seek(2L);
          ((RandomAccessFile)localObject2).writeInt(0);
          ((RandomAccessFile)localObject2).seek(8L);
          byte[] arrayOfByte = "1980_01_01:0".getBytes();
          ((RandomAccessFile)localObject2).writeInt(arrayOfByte.length);
          ((RandomAccessFile)localObject2).write(arrayOfByte);
          ((RandomAccessFile)localObject2).seek(200L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).seek(800L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).close();
        }
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(2L);
        int i2 = ((RandomAccessFile)localObject1).readInt();
        i1 = 1;
        if (i1 <= i2)
        {
          ((RandomAccessFile)localObject1).seek(i1 * 2048);
          int i3 = ((RandomAccessFile)localObject1).readInt();
          localObject2 = new byte[i3];
          ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i3);
          if (!new String((byte[])localObject2).contains(com.baidu.location.e.b.e)) {
            break label334;
          }
        }
        if (i1 >= i2)
        {
          ((RandomAccessFile)localObject1).seek(2L);
          ((RandomAccessFile)localObject1).writeInt(i1);
        }
        ((RandomAccessFile)localObject1).seek(i1 * 2048);
        paramString = paramString.getBytes();
        ((RandomAccessFile)localObject1).writeInt(paramString.length);
        ((RandomAccessFile)localObject1).write(paramString);
        ((RandomAccessFile)localObject1).close();
        return;
      }
      catch (Exception paramString)
      {
        return;
      }
      label333:
      return;
      label334:
      i1 += 1;
    }
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: new 251	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: invokestatic 621	com/baidu/location/e/h:f	()Ljava/lang/String;
    //   26: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: getstatic 624	java/io/File:separator	Ljava/lang/String;
    //   35: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: ldc_w 626
    //   44: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 265	java/io/File
    //   51: dup
    //   52: aload 4
    //   54: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 419	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 4
    //   62: aload 4
    //   64: invokevirtual 269	java/io/File:exists	()Z
    //   67: ifne +9 -> 76
    //   70: aload 4
    //   72: invokevirtual 425	java/io/File:createNewFile	()Z
    //   75: pop
    //   76: new 427	java/io/RandomAccessFile
    //   79: dup
    //   80: aload 4
    //   82: ldc_w 429
    //   85: invokespecial 432	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 630	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   95: astore 6
    //   97: aload 6
    //   99: invokevirtual 636	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   102: astore 5
    //   104: aload 5
    //   106: astore_3
    //   107: goto +13 -> 120
    //   110: astore_3
    //   111: aload 6
    //   113: astore 5
    //   115: goto +47 -> 162
    //   118: iconst_1
    //   119: istore_1
    //   120: aload_3
    //   121: ifnull +9 -> 130
    //   124: iload_1
    //   125: istore_2
    //   126: aload_3
    //   127: invokevirtual 641	java/nio/channels/FileLock:release	()V
    //   130: aload 6
    //   132: ifnull +10 -> 142
    //   135: iload_1
    //   136: istore_2
    //   137: aload 6
    //   139: invokevirtual 642	java/nio/channels/FileChannel:close	()V
    //   142: iload_1
    //   143: istore_2
    //   144: aload 4
    //   146: invokevirtual 454	java/io/RandomAccessFile:close	()V
    //   149: iload_1
    //   150: ireturn
    //   151: astore_3
    //   152: goto +10 -> 162
    //   155: goto +29 -> 184
    //   158: astore_3
    //   159: aconst_null
    //   160: astore 4
    //   162: aload 5
    //   164: ifnull +8 -> 172
    //   167: aload 5
    //   169: invokevirtual 642	java/nio/channels/FileChannel:close	()V
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 454	java/io/RandomAccessFile:close	()V
    //   182: aload_3
    //   183: athrow
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 454	java/io/RandomAccessFile:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_3
    //   197: aload 6
    //   199: astore 4
    //   201: goto -17 -> 184
    //   204: astore_3
    //   205: goto -50 -> 155
    //   208: astore 5
    //   210: goto -92 -> 118
    //   213: astore_3
    //   214: iload_2
    //   215: ireturn
    //   216: astore 4
    //   218: goto -36 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	e
    //   11	139	1	bool1	boolean
    //   9	206	2	bool2	boolean
    //   7	100	3	localObject1	Object
    //   110	17	3	localObject2	Object
    //   151	1	3	localObject3	Object
    //   158	25	3	localObject4	Object
    //   196	1	3	localException1	Exception
    //   204	1	3	localException2	Exception
    //   213	1	3	localException3	Exception
    //   19	181	4	localObject5	Object
    //   216	1	4	localException4	Exception
    //   1	167	5	localObject6	Object
    //   208	1	5	localException5	Exception
    //   4	194	6	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   97	104	110	finally
    //   90	97	151	finally
    //   12	76	158	finally
    //   76	90	158	finally
    //   12	76	196	java/lang/Exception
    //   76	90	196	java/lang/Exception
    //   90	97	204	java/lang/Exception
    //   97	104	208	java/lang/Exception
    //   126	130	213	java/lang/Exception
    //   137	142	213	java/lang/Exception
    //   144	149	213	java/lang/Exception
    //   189	194	213	java/lang/Exception
    //   167	172	216	java/lang/Exception
    //   177	182	216	java/lang/Exception
  }
  
  private boolean f()
  {
    boolean bool1 = this.B;
    boolean bool2 = false;
    if (bool1)
    {
      if (this.C)
      {
        if (this.E < this.t)
        {
          int i1 = this.D + this.p;
          this.D = i1;
          if (i1 > this.u)
          {
            bool1 = bool2;
            if (System.currentTimeMillis() - this.G <= this.v * 1000) {
              return bool1;
            }
          }
        }
        else
        {
          this.D = 0;
          this.C = false;
        }
      }
      else if (this.E < this.t)
      {
        this.C = true;
        this.D = (0 + this.p);
      }
    }
    else if ((this.E < this.r) && (this.F < this.s))
    {
      bool1 = bool2;
      if (this.w != 1) {
        return bool1;
      }
      bool1 = bool2;
      if (System.currentTimeMillis() - this.G <= this.x * 1000) {
        return bool1;
      }
    }
    else
    {
      this.B = true;
    }
    bool1 = true;
    return bool1;
  }
  
  private void g()
  {
    this.M = null;
    this.e = 0L;
    this.L = 0;
    this.b = null;
    this.c = null;
    this.E = 0.0F;
    this.F = 0.0F;
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/baidu/location/b/e:e	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +356 -> 362
    //   9: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   12: aload_0
    //   13: getfield 139	com/baidu/location/b/e:e	J
    //   16: lsub
    //   17: aload_0
    //   18: getfield 87	com/baidu/location/b/e:p	I
    //   21: sipush 1000
    //   24: imul
    //   25: i2l
    //   26: lcmp
    //   27: ifge +4 -> 31
    //   30: return
    //   31: invokestatic 648	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   34: ldc_w 650
    //   37: iconst_4
    //   38: invokevirtual 656	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: astore_3
    //   42: iconst_0
    //   43: istore_1
    //   44: aload_3
    //   45: ldc_w 658
    //   48: iconst_0
    //   49: invokeinterface 664 3 0
    //   54: ifeq +8 -> 62
    //   57: aload_0
    //   58: invokespecial 666	com/baidu/location/b/e:g	()V
    //   61: return
    //   62: aload_0
    //   63: getfield 82	com/baidu/location/b/e:n	I
    //   66: iconst_1
    //   67: if_icmpne +15 -> 82
    //   70: aload_0
    //   71: invokespecial 668	com/baidu/location/b/e:f	()Z
    //   74: ifne +8 -> 82
    //   77: aload_0
    //   78: invokespecial 666	com/baidu/location/b/e:g	()V
    //   81: return
    //   82: getstatic 406	com/baidu/location/e/b:e	Ljava/lang/String;
    //   85: ldc_w 670
    //   88: invokevirtual 673	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifne +21 -> 112
    //   94: aload_0
    //   95: getstatic 406	com/baidu/location/e/b:e	Ljava/lang/String;
    //   98: invokestatic 648	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   101: invokespecial 675	com/baidu/location/b/e:a	(Ljava/lang/String;Landroid/content/Context;)Z
    //   104: ifne +20 -> 124
    //   107: aload_0
    //   108: invokespecial 666	com/baidu/location/b/e:g	()V
    //   111: return
    //   112: aload_0
    //   113: invokespecial 677	com/baidu/location/b/e:e	()Z
    //   116: ifeq +8 -> 124
    //   119: aload_0
    //   120: invokespecial 666	com/baidu/location/b/e:g	()V
    //   123: return
    //   124: aload_0
    //   125: getfield 149	com/baidu/location/b/e:M	Ljava/util/List;
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +232 -> 362
    //   133: aload_3
    //   134: invokeinterface 680 1 0
    //   139: istore_2
    //   140: aload_0
    //   141: getfield 149	com/baidu/location/b/e:M	Ljava/util/List;
    //   144: iconst_0
    //   145: iload_2
    //   146: sipush 255
    //   149: iand
    //   150: i2b
    //   151: invokestatic 392	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   154: invokeinterface 684 3 0
    //   159: pop
    //   160: aload_0
    //   161: getfield 149	com/baidu/location/b/e:M	Ljava/util/List;
    //   164: iconst_1
    //   165: ldc_w 355
    //   168: iload_2
    //   169: iand
    //   170: bipush 8
    //   172: ishr
    //   173: i2b
    //   174: invokestatic 392	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   177: invokeinterface 684 3 0
    //   182: pop
    //   183: aload_0
    //   184: getfield 149	com/baidu/location/b/e:M	Ljava/util/List;
    //   187: iconst_3
    //   188: aload_0
    //   189: getfield 147	com/baidu/location/b/e:L	I
    //   192: sipush 255
    //   195: iand
    //   196: i2b
    //   197: invokestatic 392	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   200: invokeinterface 684 3 0
    //   205: pop
    //   206: iload_2
    //   207: newarray byte
    //   209: astore_3
    //   210: iload_1
    //   211: iload_2
    //   212: if_icmpge +29 -> 241
    //   215: aload_3
    //   216: iload_1
    //   217: aload_0
    //   218: getfield 149	com/baidu/location/b/e:M	Ljava/util/List;
    //   221: iload_1
    //   222: invokeinterface 687 2 0
    //   227: checkcast 389	java/lang/Byte
    //   230: invokevirtual 691	java/lang/Byte:byteValue	()B
    //   233: bastore
    //   234: iload_1
    //   235: iconst_1
    //   236: iadd
    //   237: istore_1
    //   238: goto -28 -> 210
    //   241: new 265	java/io/File
    //   244: dup
    //   245: invokestatic 693	com/baidu/location/e/h:h	()Ljava/lang/String;
    //   248: ldc_w 695
    //   251: invokespecial 697	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: astore 4
    //   256: aload 4
    //   258: invokevirtual 269	java/io/File:exists	()Z
    //   261: ifne +9 -> 270
    //   264: aload 4
    //   266: invokevirtual 422	java/io/File:mkdirs	()Z
    //   269: pop
    //   270: aload 4
    //   272: invokevirtual 269	java/io/File:exists	()Z
    //   275: ifeq +76 -> 351
    //   278: new 265	java/io/File
    //   281: dup
    //   282: aload 4
    //   284: ldc_w 699
    //   287: invokespecial 700	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   290: astore 4
    //   292: aload 4
    //   294: invokevirtual 269	java/io/File:exists	()Z
    //   297: ifeq +9 -> 306
    //   300: aload 4
    //   302: invokevirtual 703	java/io/File:delete	()Z
    //   305: pop
    //   306: new 705	java/io/BufferedOutputStream
    //   309: dup
    //   310: new 707	java/io/FileOutputStream
    //   313: dup
    //   314: aload 4
    //   316: invokespecial 708	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   319: invokespecial 709	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   322: astore 4
    //   324: aload 4
    //   326: aload_3
    //   327: invokevirtual 710	java/io/BufferedOutputStream:write	([B)V
    //   330: aload 4
    //   332: invokevirtual 711	java/io/BufferedOutputStream:flush	()V
    //   335: aload 4
    //   337: invokevirtual 712	java/io/BufferedOutputStream:close	()V
    //   340: new 8	com/baidu/location/b/e$2
    //   343: dup
    //   344: aload_0
    //   345: invokespecial 715	com/baidu/location/b/e$2:<init>	(Lcom/baidu/location/b/e;)V
    //   348: invokevirtual 720	java/lang/Thread:start	()V
    //   351: aload_0
    //   352: invokespecial 666	com/baidu/location/b/e:g	()V
    //   355: aload_0
    //   356: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   359: putfield 127	com/baidu/location/b/e:G	J
    //   362: return
    //   363: astore_3
    //   364: return
    //   365: astore_3
    //   366: goto -15 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	e
    //   43	195	1	i1	int
    //   139	74	2	i2	int
    //   41	286	3	localObject1	Object
    //   363	1	3	localException1	Exception
    //   365	1	3	localException2	Exception
    //   254	82	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   133	210	363	java/lang/Exception
    //   215	234	363	java/lang/Exception
    //   241	270	363	java/lang/Exception
    //   270	306	363	java/lang/Exception
    //   351	362	363	java/lang/Exception
    //   306	351	365	java/lang/Exception
  }
  
  private void i()
  {
    List localList = this.M;
    int i1 = 0;
    Byte localByte = Byte.valueOf((byte)0);
    localList.add(localByte);
    this.M.add(localByte);
    byte b1;
    if (f.equals("0"))
    {
      localList = this.M;
      b1 = -82;
    }
    else
    {
      localList = this.M;
      b1 = -66;
    }
    localList.add(Byte.valueOf(b1));
    this.M.add(localByte);
    this.M.add(Byte.valueOf(this.J[0]));
    this.M.add(Byte.valueOf(this.J[1]));
    this.M.add(Byte.valueOf(this.J[2]));
    this.M.add(Byte.valueOf(this.J[3]));
    int i2 = this.K.length;
    this.M.add(Byte.valueOf((byte)(i2 + 1 & 0xFF)));
    while (i1 < i2)
    {
      this.M.add(Byte.valueOf(this.K[i1]));
      i1 += 1;
    }
  }
  
  private void j()
  {
    if (System.currentTimeMillis() - this.z > 86400000L)
    {
      if (this.A == null) {
        this.A = new b();
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(com.baidu.location.e.b.a().a(false));
      localStringBuffer.append(b.a().c());
      this.A.a(localStringBuffer.toString());
    }
    k();
  }
  
  private void k() {}
  
  public void a(final Location paramLocation)
  {
    if (!this.N) {
      c();
    }
    if ((this.k == 1) && (this.m.contains(c.a(com.baidu.location.c.b.a().e()))))
    {
      if ((this.n == 1) && (this.y > this.o)) {
        return;
      }
      this.I.post(new Runnable()
      {
        public void run()
        {
          e.a(e.this, paramLocation);
        }
      });
    }
  }
  
  public void b()
  {
    if (!this.N) {
      return;
    }
    this.N = false;
    g();
  }
  
  private static class a
    implements HostnameVerifier
  {
    private URL a;
    
    public a(URL paramURL)
    {
      this.a = paramURL;
    }
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return this.a.getHost().equals(paramString);
    }
  }
  
  class b
    extends f
  {
    String a = null;
    
    public b()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      this.g = "https://loc.map.baidu.com/cc.php";
      String str = Jni.encode(this.a);
      this.a = null;
      this.j.put("q", str);
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
      b("https://loc.map.baidu.com/cc.php");
    }
    
    public void a(boolean paramBoolean)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = this.i;
        if (localObject == null) {}
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("prod", com.baidu.location.e.b.e);
        ((JSONObject)localObject).put("uptime", System.currentTimeMillis());
        e.a(e.this, ((JSONObject)localObject).toString());
        label53:
        localObject = this.j;
        if (localObject != null) {
          ((Map)localObject).clear();
        }
        return;
      }
      catch (Exception localException)
      {
        break label53;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.e
 * JD-Core Version:    0.7.0.1
 */