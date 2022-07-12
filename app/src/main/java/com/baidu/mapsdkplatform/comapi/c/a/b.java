package com.baidu.mapsdkplatform.comapi.c.a;

import android.content.Context;
import android.os.Build;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.d;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class b
{
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private Context a;
  
  private StringBuilder a(File paramFile)
  {
    Object localObject = paramFile.getName();
    paramFile = paramFile.getName().substring(0, ((String)localObject).length() - 4).split("_");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--bd_map_sdk_cc");
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
    ((StringBuilder)localObject).append("\r\n");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SyncSysInfo.getPhoneInfo());
    localStringBuilder.append("&abi=");
    localStringBuilder.append(d);
    ((StringBuilder)localObject).append(URLDecoder.decode(localStringBuilder.toString()));
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--bd_map_sdk_cc");
    ((StringBuilder)localObject).append("\r\n");
    if ((paramFile[0] != null) && (!paramFile[0].isEmpty()))
    {
      ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"packname\"\r\n");
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append(paramFile[0]);
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append("--bd_map_sdk_cc");
      ((StringBuilder)localObject).append("\r\n");
    }
    if ((paramFile[1] != null) && (!paramFile[1].isEmpty()))
    {
      ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"version\"\r\n");
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append(paramFile[1]);
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append("--bd_map_sdk_cc");
      ((StringBuilder)localObject).append("\r\n");
    }
    if ((paramFile[2] != null) && (!paramFile[2].isEmpty()))
    {
      ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append(paramFile[2]);
      ((StringBuilder)localObject).append("\r\n");
      ((StringBuilder)localObject).append("--bd_map_sdk_cc");
      ((StringBuilder)localObject).append("\r\n");
    }
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"os\"\r\n");
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("android");
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--bd_map_sdk_cc");
    ((StringBuilder)localObject).append("\r\n");
    return localObject;
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localGZIPOutputStream.write(arrayOfByte, 0, i);
    }
    localGZIPOutputStream.flush();
    localGZIPOutputStream.close();
    try
    {
      paramOutputStream.close();
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream) {}
  }
  
  private void a(File[] paramArrayOfFile)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j - 10)
    {
      int k = i + 10;
      if ((paramArrayOfFile[k] != null) && (paramArrayOfFile[k].exists())) {
        paramArrayOfFile[k].delete();
      }
      i += 1;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = new ByteArrayOutputStream(paramArrayOfByte.length);
    a(localByteArrayInputStream, paramArrayOfByte);
    byte[] arrayOfByte = paramArrayOfByte.toByteArray();
    paramArrayOfByte.flush();
    paramArrayOfByte.close();
    localByteArrayInputStream.close();
    return arrayOfByte;
  }
  
  /* Error */
  private boolean b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_0
    //   12: invokespecial 160	com/baidu/mapsdkplatform/comapi/c/a/b:e	()Ljava/net/HttpURLConnection;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +22 -> 39
    //   20: aload_3
    //   21: ifnull +14 -> 35
    //   24: aload_3
    //   25: invokevirtual 165	java/net/HttpURLConnection:disconnect	()V
    //   28: goto +7 -> 35
    //   31: astore_1
    //   32: goto +500 -> 532
    //   35: aload_0
    //   36: monitorexit
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_3
    //   40: invokevirtual 168	java/net/HttpURLConnection:connect	()V
    //   43: aload_3
    //   44: invokevirtual 172	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   47: astore 6
    //   49: aload 6
    //   51: aload_0
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial 174	com/baidu/mapsdkplatform/comapi/c/a/b:a	(Ljava/io/File;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 177	java/lang/String:getBytes	()[B
    //   63: invokespecial 179	com/baidu/mapsdkplatform/comapi/c/a/b:a	([B)[B
    //   66: invokevirtual 181	java/io/OutputStream:write	([B)V
    //   69: new 49	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: ldc 52
    //   82: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 4
    //   88: ldc 58
    //   90: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: ldc 183
    //   98: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 4
    //   104: ldc 58
    //   106: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: aload_0
    //   113: aload 4
    //   115: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 177	java/lang/String:getBytes	()[B
    //   121: invokespecial 179	com/baidu/mapsdkplatform/comapi/c/a/b:a	([B)[B
    //   124: invokevirtual 181	java/io/OutputStream:write	([B)V
    //   127: new 142	java/io/ByteArrayOutputStream
    //   130: dup
    //   131: aload_1
    //   132: invokevirtual 186	java/io/File:length	()J
    //   135: l2i
    //   136: invokespecial 145	java/io/ByteArrayOutputStream:<init>	(I)V
    //   139: astore 4
    //   141: new 188	java/io/DataInputStream
    //   144: dup
    //   145: new 190	java/io/FileInputStream
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: invokespecial 196	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   156: astore 9
    //   158: sipush 1024
    //   161: newarray byte
    //   163: astore 10
    //   165: aload 9
    //   167: aload 10
    //   169: invokevirtual 199	java/io/DataInputStream:read	([B)I
    //   172: istore_2
    //   173: iload_2
    //   174: iconst_m1
    //   175: if_icmpeq +15 -> 190
    //   178: aload 4
    //   180: aload 10
    //   182: iconst_0
    //   183: iload_2
    //   184: invokevirtual 200	java/io/ByteArrayOutputStream:write	([BII)V
    //   187: goto -22 -> 165
    //   190: aload 6
    //   192: aload_0
    //   193: aload 4
    //   195: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: invokespecial 179	com/baidu/mapsdkplatform/comapi/c/a/b:a	([B)[B
    //   201: invokevirtual 181	java/io/OutputStream:write	([B)V
    //   204: aload 9
    //   206: invokevirtual 201	java/io/DataInputStream:close	()V
    //   209: aload 4
    //   211: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   214: aload 6
    //   216: aload_0
    //   217: ldc 203
    //   219: invokevirtual 177	java/lang/String:getBytes	()[B
    //   222: invokespecial 179	com/baidu/mapsdkplatform/comapi/c/a/b:a	([B)[B
    //   225: invokevirtual 181	java/io/OutputStream:write	([B)V
    //   228: aload 6
    //   230: invokevirtual 204	java/io/OutputStream:flush	()V
    //   233: aload_3
    //   234: invokevirtual 207	java/net/HttpURLConnection:getResponseCode	()I
    //   237: sipush 200
    //   240: if_icmpne +132 -> 372
    //   243: aload_3
    //   244: invokevirtual 211	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   247: astore 4
    //   249: new 213	java/io/BufferedReader
    //   252: dup
    //   253: new 215	java/io/InputStreamReader
    //   256: dup
    //   257: aload 4
    //   259: invokespecial 216	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   262: invokespecial 219	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   265: astore 5
    //   267: new 221	java/lang/StringBuffer
    //   270: dup
    //   271: invokespecial 222	java/lang/StringBuffer:<init>	()V
    //   274: astore 7
    //   276: aload 5
    //   278: invokevirtual 224	java/io/BufferedReader:read	()I
    //   281: istore_2
    //   282: iload_2
    //   283: iconst_m1
    //   284: if_icmpeq +14 -> 298
    //   287: aload 7
    //   289: iload_2
    //   290: i2c
    //   291: invokevirtual 227	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   294: pop
    //   295: goto -19 -> 276
    //   298: aload 7
    //   300: invokevirtual 228	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   303: astore 7
    //   305: new 230	org/json/JSONObject
    //   308: dup
    //   309: aload 7
    //   311: invokespecial 233	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   314: astore 7
    //   316: aload 7
    //   318: ldc 235
    //   320: invokevirtual 239	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   323: ifeq +25 -> 348
    //   326: aload 7
    //   328: ldc 235
    //   330: invokevirtual 243	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   333: ifne +15 -> 348
    //   336: aload_1
    //   337: invokevirtual 127	java/io/File:exists	()Z
    //   340: ifeq +8 -> 348
    //   343: aload_1
    //   344: invokevirtual 130	java/io/File:delete	()Z
    //   347: pop
    //   348: aload 5
    //   350: astore_1
    //   351: goto +27 -> 378
    //   354: astore_1
    //   355: goto +87 -> 442
    //   358: aload 5
    //   360: astore_1
    //   361: goto +132 -> 493
    //   364: astore_1
    //   365: aload 7
    //   367: astore 5
    //   369: goto +73 -> 442
    //   372: aconst_null
    //   373: astore 4
    //   375: aload 5
    //   377: astore_1
    //   378: aload 6
    //   380: invokevirtual 123	java/io/OutputStream:close	()V
    //   383: aload 4
    //   385: ifnull +16 -> 401
    //   388: aload_1
    //   389: ifnull +12 -> 401
    //   392: aload 4
    //   394: invokevirtual 124	java/io/InputStream:close	()V
    //   397: aload_1
    //   398: invokevirtual 244	java/io/BufferedReader:close	()V
    //   401: aload_3
    //   402: invokevirtual 165	java/net/HttpURLConnection:disconnect	()V
    //   405: aload_0
    //   406: monitorexit
    //   407: iconst_1
    //   408: ireturn
    //   409: astore_1
    //   410: goto +201 -> 611
    //   413: aconst_null
    //   414: astore 4
    //   416: aload 8
    //   418: astore_1
    //   419: goto +74 -> 493
    //   422: astore_1
    //   423: goto +9 -> 432
    //   426: goto +58 -> 484
    //   429: astore_1
    //   430: aconst_null
    //   431: astore_3
    //   432: aconst_null
    //   433: astore 6
    //   435: aconst_null
    //   436: astore 4
    //   438: aload 7
    //   440: astore 5
    //   442: aload 6
    //   444: ifnull +8 -> 452
    //   447: aload 6
    //   449: invokevirtual 123	java/io/OutputStream:close	()V
    //   452: aload 4
    //   454: ifnull +18 -> 472
    //   457: aload 5
    //   459: ifnull +13 -> 472
    //   462: aload 4
    //   464: invokevirtual 124	java/io/InputStream:close	()V
    //   467: aload 5
    //   469: invokevirtual 244	java/io/BufferedReader:close	()V
    //   472: aload_3
    //   473: ifnull +7 -> 480
    //   476: aload_3
    //   477: invokevirtual 165	java/net/HttpURLConnection:disconnect	()V
    //   480: aload_1
    //   481: athrow
    //   482: aconst_null
    //   483: astore_3
    //   484: aconst_null
    //   485: astore 6
    //   487: aconst_null
    //   488: astore 4
    //   490: aload 8
    //   492: astore_1
    //   493: aload 6
    //   495: ifnull +8 -> 503
    //   498: aload 6
    //   500: invokevirtual 123	java/io/OutputStream:close	()V
    //   503: aload 4
    //   505: ifnull +16 -> 521
    //   508: aload_1
    //   509: ifnull +12 -> 521
    //   512: aload 4
    //   514: invokevirtual 124	java/io/InputStream:close	()V
    //   517: aload_1
    //   518: invokevirtual 244	java/io/BufferedReader:close	()V
    //   521: aload_3
    //   522: ifnull +14 -> 536
    //   525: aload_3
    //   526: invokevirtual 165	java/net/HttpURLConnection:disconnect	()V
    //   529: goto +7 -> 536
    //   532: aload_0
    //   533: monitorexit
    //   534: aload_1
    //   535: athrow
    //   536: aload_0
    //   537: monitorexit
    //   538: iconst_0
    //   539: ireturn
    //   540: astore_1
    //   541: goto -59 -> 482
    //   544: astore_1
    //   545: goto -510 -> 35
    //   548: astore_1
    //   549: goto -123 -> 426
    //   552: astore_1
    //   553: goto -140 -> 413
    //   556: astore_1
    //   557: aload 8
    //   559: astore_1
    //   560: goto -67 -> 493
    //   563: astore_1
    //   564: goto -206 -> 358
    //   567: astore_1
    //   568: goto -220 -> 348
    //   571: astore 5
    //   573: goto -190 -> 383
    //   576: astore_1
    //   577: goto -176 -> 401
    //   580: astore_1
    //   581: goto -176 -> 405
    //   584: astore 6
    //   586: goto -134 -> 452
    //   589: astore 4
    //   591: goto -119 -> 472
    //   594: astore_3
    //   595: goto -115 -> 480
    //   598: astore 5
    //   600: goto -97 -> 503
    //   603: astore_1
    //   604: goto -83 -> 521
    //   607: astore_1
    //   608: goto -72 -> 536
    //   611: aconst_null
    //   612: astore 4
    //   614: aload 7
    //   616: astore 5
    //   618: goto -176 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	b
    //   0	621	1	paramFile	File
    //   172	118	2	i	int
    //   15	511	3	localHttpURLConnection	HttpURLConnection
    //   594	1	3	localException1	Exception
    //   76	437	4	localObject1	Object
    //   589	1	4	localException2	Exception
    //   612	1	4	localObject2	Object
    //   9	459	5	localObject3	Object
    //   571	1	5	localException3	Exception
    //   598	1	5	localException4	Exception
    //   616	1	5	localObject4	Object
    //   47	452	6	localOutputStream	OutputStream
    //   584	1	6	localException5	Exception
    //   3	612	7	localObject5	Object
    //   6	552	8	localObject6	Object
    //   156	49	9	localDataInputStream	java.io.DataInputStream
    //   163	18	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	28	31	finally
    //   378	383	31	finally
    //   392	401	31	finally
    //   401	405	31	finally
    //   447	452	31	finally
    //   462	472	31	finally
    //   476	480	31	finally
    //   480	482	31	finally
    //   498	503	31	finally
    //   512	521	31	finally
    //   525	529	31	finally
    //   267	276	354	finally
    //   276	282	354	finally
    //   287	295	354	finally
    //   298	305	354	finally
    //   305	348	354	finally
    //   249	267	364	finally
    //   49	165	409	finally
    //   165	173	409	finally
    //   178	187	409	finally
    //   190	249	409	finally
    //   39	49	422	finally
    //   11	16	429	finally
    //   11	16	540	java/lang/Exception
    //   24	28	544	java/lang/Exception
    //   39	49	548	java/lang/Exception
    //   49	165	552	java/lang/Exception
    //   165	173	552	java/lang/Exception
    //   178	187	552	java/lang/Exception
    //   190	249	552	java/lang/Exception
    //   249	267	556	java/lang/Exception
    //   267	276	563	java/lang/Exception
    //   276	282	563	java/lang/Exception
    //   287	295	563	java/lang/Exception
    //   298	305	563	java/lang/Exception
    //   305	348	567	java/lang/Exception
    //   378	383	571	java/lang/Exception
    //   392	401	576	java/lang/Exception
    //   401	405	580	java/lang/Exception
    //   447	452	584	java/lang/Exception
    //   462	472	589	java/lang/Exception
    //   476	480	594	java/lang/Exception
    //   498	503	598	java/lang/Exception
    //   512	521	603	java/lang/Exception
    //   525	529	607	java/lang/Exception
  }
  
  public static b c()
  {
    return b.a();
  }
  
  private void d()
  {
    if (e.b().a() == null) {
      return;
    }
    String str = e.b().a().a();
    if (str.isEmpty()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("crash");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (localFile.exists()) {}
    while (localFile.mkdir())
    {
      b = (String)localObject;
      return;
    }
    b = str;
  }
  
  private HttpURLConnection e()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Connection", "keep-alive");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
      localHttpURLConnection.setRequestProperty("Cache-Control", "no-cache");
      localHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
      localHttpURLConnection.setConnectTimeout(10000);
      return localHttpURLConnection;
    }
    catch (Exception localException)
    {
      label83:
      break label83;
    }
    return null;
  }
  
  private void f()
  {
    Object localObject = b;
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = c;
      if (localObject != null)
      {
        if (((String)localObject).isEmpty()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(b);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(c);
        localObject = ((StringBuilder)localObject).toString();
        a.a().a((String)localObject);
        JNIHandler.registerNativeHandler((String)localObject);
      }
    }
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetworkAvailable(this.a)) {
      return;
    }
    new Thread(new a()).start();
  }
  
  public void a(Context paramContext)
  {
    Object localObject = Build.SUPPORTED_ABIS;
    if (localObject.length > 0) {
      d = localObject[0];
    }
    this.a = paramContext;
    localObject = f.f();
    if (((String)localObject).isEmpty()) {
      return;
    }
    paramContext = (Context)localObject;
    if (((String)localObject).contains("_")) {
      paramContext = ((String)localObject).replaceAll("_", "");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(f.m());
    ((StringBuilder)localObject).append("_");
    c = ((StringBuilder)localObject).toString();
    d();
    f();
    g();
  }
  
  public void a(String paramString1, String paramString2)
  {
    JNIHandler.addLog(paramString1, paramString2);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (e.b().a() == null) {
        return;
      }
      Object localObject = new File(b.a());
      if (!((File)localObject).exists()) {
        return;
      }
      localObject = ((File)localObject).listFiles();
      if (localObject != null) {
        if (localObject.length == 0) {
          return;
        }
      }
      try
      {
        Arrays.sort((Object[])localObject, new c());
        label55:
        int j = localObject.length;
        int i = j;
        if (j > 10) {
          i = 10;
        }
        j = 0;
        while (j < i)
        {
          File localFile = localObject[j];
          if ((!localFile.isDirectory()) && (localFile.exists()) && (localFile.isFile()) && (localFile.getName().contains(b.b())))
          {
            if (localFile.getName().endsWith(".txt")) {}
            while ((localFile.getName().endsWith(".zip")) && (localFile.exists()))
            {
              b.a(b.this, localFile);
              break;
            }
          }
          j += 1;
        }
        if (localObject.length > 10) {
          b.a(b.this, (File[])localObject);
        }
        return;
      }
      catch (Exception localException)
      {
        break label55;
      }
    }
  }
  
  private static final class b
  {
    private static final b a = new b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.c.a.b
 * JD-Core Version:    0.7.0.1
 */