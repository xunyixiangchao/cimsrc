package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class s
{
  private static s b;
  public Map<String, String> a = null;
  private Context c;
  
  private s(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static s a(Context paramContext)
  {
    if (b == null) {
      b = new s(paramContext);
    }
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new URL(paramString2);
      if (a.b() != null) {
        paramString1 = paramString2.openConnection(a.b());
      }
      for (;;)
      {
        paramString1 = (HttpURLConnection)paramString1;
        break;
        if ((paramString1 != null) && (paramString1.toLowerCase(Locale.US).contains("wap")))
        {
          paramString1 = new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
          paramString1 = paramString2.openConnection(new Proxy(Proxy.Type.HTTP, paramString1));
        }
        else
        {
          paramString1 = paramString2.openConnection();
        }
      }
      paramString1.setConnectTimeout(30000);
      paramString1.setReadTimeout(10000);
      paramString1.setDoOutput(true);
      paramString1.setDoInput(true);
      paramString1.setRequestMethod("POST");
      paramString1.setUseCaches(false);
      paramString1.setInstanceFollowRedirects(false);
      return paramString1;
    }
    finally
    {
      if (!y.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
  {
    if (paramString1 == null)
    {
      y.e("destUrl is null.", new Object[0]);
      return null;
    }
    a locala = new a();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { locala }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    paramString1 = a(paramString2, paramString1);
    if (paramString1 == null)
    {
      y.e("Failed to get HttpURLConnection object.", new Object[0]);
      return null;
    }
    try
    {
      paramString1.setRequestProperty("wup_version", "3.0");
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          paramString1.setRequestProperty((String)localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "utf-8"));
        }
      }
      paramString1.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
      paramString1.setRequestProperty("A38", URLEncoder.encode(paramString2, "utf-8"));
      paramString2 = paramString1.getOutputStream();
      if (paramArrayOfByte == null)
      {
        paramString2.write(0);
        return paramString1;
      }
      paramString2.write(paramArrayOfByte);
      return paramString1;
    }
    finally
    {
      if (!y.a(paramString1)) {
        paramString1.printStackTrace();
      }
      y.e("Failed to upload, please check your network.", new Object[0]);
    }
    return null;
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection)
  {
    HashMap localHashMap = new HashMap();
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if ((paramHttpURLConnection != null) && (paramHttpURLConnection.size() != 0))
    {
      Iterator localIterator = paramHttpURLConnection.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        List localList = (List)paramHttpURLConnection.get(str);
        if (localList.size() > 0) {
          localHashMap.put(str, localList.get(0));
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  /* Error */
  private static byte[] b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 274	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 278	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: invokespecial 281	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new 283	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 284	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_2
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 288	java/io/BufferedInputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle +13 -> 52
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 291	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -17 -> 32
    //   52: aload_2
    //   53: invokevirtual 294	java/io/ByteArrayOutputStream:flush	()V
    //   56: aload_2
    //   57: invokevirtual 298	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: astore_2
    //   61: aload_0
    //   62: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   65: aload_2
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: goto +6 -> 81
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_2
    //   82: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   85: ifne +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   92: aload_0
    //   93: ifnull +14 -> 107
    //   96: aload_0
    //   97: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_2
    //   110: aload_0
    //   111: ifnull +15 -> 126
    //   114: aload_0
    //   115: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   118: goto +8 -> 126
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   126: aload_2
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramHttpURLConnection	HttpURLConnection
    //   37	9	1	i	int
    //   25	48	2	localObject1	Object
    //   74	1	2	localObject2	Object
    //   78	11	2	localThrowable	Throwable
    //   109	18	2	localObject3	Object
    //   31	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	65	67	finally
    //   18	32	74	finally
    //   32	38	74	finally
    //   42	49	74	finally
    //   52	61	74	finally
    //   6	18	78	finally
    //   96	100	102	finally
    //   81	92	109	finally
    //   114	118	121	finally
  }
  
  /* Error */
  public final byte[] a(String paramString, byte[] paramArrayOfByte, w paramw, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +16 -> 17
    //   4: ldc_w 306
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 142	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aconst_null
    //   16: areturn
    //   17: aload_2
    //   18: ifnonnull +9 -> 27
    //   21: lconst_0
    //   22: lstore 11
    //   24: goto +8 -> 32
    //   27: aload_2
    //   28: arraylength
    //   29: i2l
    //   30: lstore 11
    //   32: iconst_1
    //   33: istore 8
    //   35: ldc_w 308
    //   38: iconst_4
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: lload 11
    //   50: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: invokestatic 319	android/os/Process:myPid	()I
    //   59: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_3
    //   65: invokestatic 325	android/os/Process:myTid	()I
    //   68: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: invokestatic 327	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   75: pop
    //   76: iconst_0
    //   77: istore 5
    //   79: iload 5
    //   81: istore 7
    //   83: iload 7
    //   85: istore 6
    //   87: iload 5
    //   89: ifgt +690 -> 779
    //   92: iload 7
    //   94: ifgt +685 -> 779
    //   97: iload 6
    //   99: ifeq +9 -> 108
    //   102: iconst_0
    //   103: istore 6
    //   105: goto +73 -> 178
    //   108: iload 5
    //   110: iconst_1
    //   111: iadd
    //   112: istore 5
    //   114: iload 5
    //   116: iload 8
    //   118: if_icmple +60 -> 178
    //   121: new 329	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 331
    //   128: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: astore 17
    //   133: aload 17
    //   135: iload 5
    //   137: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 17
    //   143: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 327	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   153: pop
    //   154: new 342	java/util/Random
    //   157: dup
    //   158: invokestatic 346	java/lang/System:currentTimeMillis	()J
    //   161: invokespecial 349	java/util/Random:<init>	(J)V
    //   164: sipush 10000
    //   167: invokevirtual 353	java/util/Random:nextInt	(I)I
    //   170: i2l
    //   171: ldc2_w 354
    //   174: ladd
    //   175: invokestatic 360	android/os/SystemClock:sleep	(J)V
    //   178: aload_0
    //   179: getfield 22	com/tencent/bugly/proguard/s:c	Landroid/content/Context;
    //   182: invokestatic 365	com/tencent/bugly/crashreport/common/info/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   185: astore 17
    //   187: aload 17
    //   189: ifnonnull +20 -> 209
    //   192: ldc_w 367
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 370	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   202: pop
    //   203: iconst_1
    //   204: istore 8
    //   206: goto -119 -> 87
    //   209: aload_3
    //   210: lload 11
    //   212: invokevirtual 374	com/tencent/bugly/proguard/w:a	(J)V
    //   215: aload_0
    //   216: aload_1
    //   217: aload_2
    //   218: aload 17
    //   220: aload 4
    //   222: invokespecial 376	com/tencent/bugly/proguard/s:a	(Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   225: astore 19
    //   227: aload 19
    //   229: ifnull +528 -> 757
    //   232: aload 19
    //   234: invokevirtual 379	java/net/HttpURLConnection:getResponseCode	()I
    //   237: istore 9
    //   239: new 329	java/lang/StringBuilder
    //   242: dup
    //   243: ldc_w 381
    //   246: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   249: astore 17
    //   251: aload 17
    //   253: iload 9
    //   255: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 17
    //   261: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 327	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   271: pop
    //   272: iload 9
    //   274: sipush 200
    //   277: if_icmpne +65 -> 342
    //   280: aload_0
    //   281: aload 19
    //   283: invokestatic 383	com/tencent/bugly/proguard/s:a	(Ljava/net/HttpURLConnection;)Ljava/util/Map;
    //   286: putfield 20	com/tencent/bugly/proguard/s:a	Ljava/util/Map;
    //   289: aload 19
    //   291: invokestatic 385	com/tencent/bugly/proguard/s:b	(Ljava/net/HttpURLConnection;)[B
    //   294: astore 17
    //   296: aload 17
    //   298: ifnonnull +9 -> 307
    //   301: lconst_0
    //   302: lstore 13
    //   304: goto +9 -> 313
    //   307: aload 17
    //   309: arraylength
    //   310: i2l
    //   311: lstore 13
    //   313: aload_3
    //   314: lload 13
    //   316: invokevirtual 387	com/tencent/bugly/proguard/w:b	(J)V
    //   319: aload 19
    //   321: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   324: aload 17
    //   326: areturn
    //   327: astore_1
    //   328: aload_1
    //   329: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   332: ifne +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   339: aload 17
    //   341: areturn
    //   342: iload 9
    //   344: sipush 301
    //   347: if_icmpeq +36 -> 383
    //   350: iload 9
    //   352: sipush 302
    //   355: if_icmpeq +28 -> 383
    //   358: iload 9
    //   360: sipush 303
    //   363: if_icmpeq +20 -> 383
    //   366: iload 9
    //   368: sipush 307
    //   371: if_icmpne +6 -> 377
    //   374: goto +9 -> 383
    //   377: iconst_0
    //   378: istore 8
    //   380: goto +6 -> 386
    //   383: iconst_1
    //   384: istore 8
    //   386: iload 8
    //   388: ifeq +158 -> 546
    //   391: aload 19
    //   393: ldc_w 392
    //   396: invokevirtual 395	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 17
    //   401: aload 17
    //   403: ifnonnull +66 -> 469
    //   406: new 329	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 397
    //   413: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: astore 17
    //   418: aload 17
    //   420: iload 9
    //   422: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 17
    //   428: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 142	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   438: pop
    //   439: aload 19
    //   441: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   444: aconst_null
    //   445: areturn
    //   446: astore_1
    //   447: aload_1
    //   448: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   451: ifne -7 -> 444
    //   454: aload_1
    //   455: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   458: goto -14 -> 444
    //   461: astore 17
    //   463: iconst_1
    //   464: istore 6
    //   466: goto +170 -> 636
    //   469: iload 7
    //   471: iconst_1
    //   472: iadd
    //   473: istore 7
    //   475: ldc_w 399
    //   478: iconst_2
    //   479: anewarray 4	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: iload 9
    //   486: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: dup
    //   491: iconst_1
    //   492: aload 17
    //   494: aastore
    //   495: invokestatic 327	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   498: pop
    //   499: aload 17
    //   501: astore_1
    //   502: iconst_1
    //   503: istore 6
    //   505: iconst_0
    //   506: istore 5
    //   508: goto +38 -> 546
    //   511: astore_1
    //   512: goto +7 -> 519
    //   515: astore_1
    //   516: goto +3 -> 519
    //   519: aload 17
    //   521: astore 18
    //   523: iconst_1
    //   524: istore 6
    //   526: iconst_0
    //   527: istore 5
    //   529: aload_1
    //   530: astore 17
    //   532: aload 18
    //   534: astore_1
    //   535: goto +101 -> 636
    //   538: astore 17
    //   540: iconst_1
    //   541: istore 6
    //   543: goto +93 -> 636
    //   546: aload 19
    //   548: invokevirtual 402	java/net/HttpURLConnection:getContentLength	()I
    //   551: i2l
    //   552: lstore 15
    //   554: lload 15
    //   556: lstore 13
    //   558: lload 15
    //   560: lconst_0
    //   561: lcmp
    //   562: ifge +6 -> 568
    //   565: lconst_0
    //   566: lstore 13
    //   568: aload_3
    //   569: lload 13
    //   571: invokevirtual 387	com/tencent/bugly/proguard/w:b	(J)V
    //   574: aload 19
    //   576: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   579: iload 5
    //   581: istore 10
    //   583: aload_1
    //   584: astore 17
    //   586: iload 7
    //   588: istore 9
    //   590: iload 6
    //   592: istore 8
    //   594: goto +123 -> 717
    //   597: astore 18
    //   599: iload 5
    //   601: istore 10
    //   603: aload_1
    //   604: astore 17
    //   606: iload 7
    //   608: istore 9
    //   610: iload 6
    //   612: istore 8
    //   614: aload 18
    //   616: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   619: ifne +98 -> 717
    //   622: goto +75 -> 697
    //   625: astore 17
    //   627: goto +9 -> 636
    //   630: astore_1
    //   631: goto +104 -> 735
    //   634: astore 17
    //   636: aload 17
    //   638: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   641: ifne +8 -> 649
    //   644: aload 17
    //   646: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   649: aload 19
    //   651: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   654: iload 5
    //   656: istore 10
    //   658: aload_1
    //   659: astore 17
    //   661: iload 7
    //   663: istore 9
    //   665: iload 6
    //   667: istore 8
    //   669: goto +48 -> 717
    //   672: astore 18
    //   674: iload 5
    //   676: istore 10
    //   678: aload_1
    //   679: astore 17
    //   681: iload 7
    //   683: istore 9
    //   685: iload 6
    //   687: istore 8
    //   689: aload 18
    //   691: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   694: ifne +23 -> 717
    //   697: aload 18
    //   699: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   702: iload 6
    //   704: istore 8
    //   706: iload 7
    //   708: istore 9
    //   710: aload_1
    //   711: astore 17
    //   713: iload 5
    //   715: istore 10
    //   717: iload 10
    //   719: istore 5
    //   721: aload 17
    //   723: astore_1
    //   724: iload 9
    //   726: istore 7
    //   728: iload 8
    //   730: istore 6
    //   732: goto +41 -> 773
    //   735: aload 19
    //   737: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   740: goto +15 -> 755
    //   743: astore_2
    //   744: aload_2
    //   745: invokestatic 128	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   748: ifne +7 -> 755
    //   751: aload_2
    //   752: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   755: aload_1
    //   756: athrow
    //   757: ldc_w 405
    //   760: iconst_0
    //   761: anewarray 4	java/lang/Object
    //   764: invokestatic 327	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   767: pop
    //   768: aload_3
    //   769: lconst_0
    //   770: invokevirtual 387	com/tencent/bugly/proguard/w:b	(J)V
    //   773: iconst_1
    //   774: istore 8
    //   776: goto -689 -> 87
    //   779: aconst_null
    //   780: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	s
    //   0	781	1	paramString	String
    //   0	781	2	paramArrayOfByte	byte[]
    //   0	781	3	paramw	w
    //   0	781	4	paramMap	Map<String, String>
    //   77	430	5	i	int
    //   85	419	6	j	int
    //   81	393	7	k	int
    //   33	354	8	m	int
    //   237	248	9	n	int
    //   22	189	11	l1	long
    //   302	13	13	l2	long
    //   131	296	17	localObject	Object
    //   461	39	17	localIOException	java.io.IOException
    //   225	215	19	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   319	324	327	finally
    //   439	444	446	finally
    //   406	439	461	java/io/IOException
    //   475	499	511	java/io/IOException
    //   391	401	538	java/io/IOException
    //   574	579	597	finally
    //   546	554	625	java/io/IOException
    //   568	574	625	java/io/IOException
    //   232	272	630	finally
    //   280	296	630	finally
    //   307	313	630	finally
    //   313	319	630	finally
    //   391	401	630	finally
    //   406	439	630	finally
    //   475	499	630	finally
    //   546	554	630	finally
    //   568	574	630	finally
    //   636	649	630	finally
    //   232	272	634	java/io/IOException
    //   280	296	634	java/io/IOException
    //   307	313	634	java/io/IOException
    //   313	319	634	java/io/IOException
    //   649	654	672	finally
    //   735	740	743	finally
  }
  
  static final class a
    implements X509TrustManager
  {
    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      y.c("checkClientTrusted", new Object[0]);
    }
    
    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      y.c("checkServerTrusted", new Object[0]);
    }
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.s
 * JD-Core Version:    0.7.0.1
 */