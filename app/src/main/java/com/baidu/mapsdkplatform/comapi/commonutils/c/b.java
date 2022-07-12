package com.baidu.mapsdkplatform.comapi.commonutils.c;

import java.io.File;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class b
  implements Runnable
{
  private String a;
  private File b;
  private a c;
  private c.c d;
  private volatile boolean e = false;
  
  public b(String paramString, File paramFile, a parama, c.c paramc)
  {
    this.a = paramString;
    this.b = paramFile;
    this.c = parama;
    this.d = paramc;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 4
    //   14: new 42	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: getfield 27	com/baidu/mapsdkplatform/comapi/commonutils/c/b:a	Ljava/lang/String;
    //   22: invokespecial 45	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: astore_2
    //   26: getstatic 50	com/baidu/mapapi/http/HttpClient:isHttpsEnable	Z
    //   29: ifeq +27 -> 56
    //   32: aload_2
    //   33: invokevirtual 54	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   39: astore 6
    //   41: aload 6
    //   43: new 8	com/baidu/mapsdkplatform/comapi/commonutils/c/b$a
    //   46: dup
    //   47: invokespecial 57	com/baidu/mapsdkplatform/comapi/commonutils/c/b$a:<init>	()V
    //   50: invokevirtual 61	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   53: goto +12 -> 65
    //   56: aload_2
    //   57: invokevirtual 54	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   60: checkcast 63	java/net/HttpURLConnection
    //   63: astore 6
    //   65: aload 6
    //   67: ldc 65
    //   69: invokevirtual 68	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   72: aload 6
    //   74: sipush 10000
    //   77: invokevirtual 72	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   80: aload 6
    //   82: sipush 10000
    //   85: invokevirtual 75	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   88: new 77	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   95: astore_2
    //   96: aload_2
    //   97: ldc 80
    //   99: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: aload_0
    //   105: getfield 31	com/baidu/mapsdkplatform/comapi/commonutils/c/b:c	Lcom/baidu/mapsdkplatform/comapi/commonutils/c/a;
    //   108: invokevirtual 89	com/baidu/mapsdkplatform/comapi/commonutils/c/a:b	()I
    //   111: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: ldc 94
    //   118: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: aload_0
    //   124: getfield 31	com/baidu/mapsdkplatform/comapi/commonutils/c/b:c	Lcom/baidu/mapsdkplatform/comapi/commonutils/c/a;
    //   127: invokevirtual 96	com/baidu/mapsdkplatform/comapi/commonutils/c/a:a	()I
    //   130: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: ldc 98
    //   138: aload_2
    //   139: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 6
    //   147: ldc 108
    //   149: ldc 110
    //   151: invokevirtual 106	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: new 112	java/io/RandomAccessFile
    //   157: dup
    //   158: aload_0
    //   159: getfield 29	com/baidu/mapsdkplatform/comapi/commonutils/c/b:b	Ljava/io/File;
    //   162: ldc 114
    //   164: invokespecial 117	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   167: astore 7
    //   169: aload 8
    //   171: astore_2
    //   172: aload 7
    //   174: astore 5
    //   176: aload 9
    //   178: astore_3
    //   179: aload 7
    //   181: aload_0
    //   182: getfield 31	com/baidu/mapsdkplatform/comapi/commonutils/c/b:c	Lcom/baidu/mapsdkplatform/comapi/commonutils/c/a;
    //   185: invokevirtual 89	com/baidu/mapsdkplatform/comapi/commonutils/c/a:b	()I
    //   188: i2l
    //   189: invokevirtual 121	java/io/RandomAccessFile:seek	(J)V
    //   192: aload 8
    //   194: astore_2
    //   195: aload 7
    //   197: astore 5
    //   199: aload 9
    //   201: astore_3
    //   202: aload 6
    //   204: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   207: istore_1
    //   208: iload_1
    //   209: sipush 200
    //   212: if_icmpeq +10 -> 222
    //   215: iload_1
    //   216: sipush 206
    //   219: if_icmpne +85 -> 304
    //   222: aload 8
    //   224: astore_2
    //   225: aload 7
    //   227: astore 5
    //   229: aload 9
    //   231: astore_3
    //   232: ldc 125
    //   234: newarray byte
    //   236: astore 10
    //   238: aload 8
    //   240: astore_2
    //   241: aload 7
    //   243: astore 5
    //   245: aload 9
    //   247: astore_3
    //   248: aload 6
    //   250: invokevirtual 129	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   253: astore 6
    //   255: aload 6
    //   257: astore_2
    //   258: aload 7
    //   260: astore 5
    //   262: aload 6
    //   264: astore_3
    //   265: aload 6
    //   267: aload 10
    //   269: invokevirtual 135	java/io/InputStream:read	([B)I
    //   272: istore_1
    //   273: aload 6
    //   275: astore 4
    //   277: iload_1
    //   278: iconst_m1
    //   279: if_icmpeq +25 -> 304
    //   282: aload 6
    //   284: astore_2
    //   285: aload 7
    //   287: astore 5
    //   289: aload 6
    //   291: astore_3
    //   292: aload 7
    //   294: aload 10
    //   296: iconst_0
    //   297: iload_1
    //   298: invokevirtual 139	java/io/RandomAccessFile:write	([BII)V
    //   301: goto -46 -> 255
    //   304: aload 4
    //   306: astore_2
    //   307: aload 7
    //   309: astore 5
    //   311: aload 4
    //   313: astore_3
    //   314: aload_0
    //   315: iconst_1
    //   316: putfield 25	com/baidu/mapsdkplatform/comapi/commonutils/c/b:e	Z
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 142	java/io/InputStream:close	()V
    //   329: aload 7
    //   331: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   334: goto +75 -> 409
    //   337: astore_2
    //   338: aconst_null
    //   339: astore 4
    //   341: aload 5
    //   343: astore_3
    //   344: aload 4
    //   346: astore 5
    //   348: goto +79 -> 427
    //   351: aconst_null
    //   352: astore 4
    //   354: aload_3
    //   355: astore_2
    //   356: aload 4
    //   358: astore 5
    //   360: aload_0
    //   361: iconst_0
    //   362: putfield 25	com/baidu/mapsdkplatform/comapi/commonutils/c/b:e	Z
    //   365: aload_3
    //   366: astore_2
    //   367: aload 4
    //   369: astore 5
    //   371: aload_0
    //   372: getfield 33	com/baidu/mapsdkplatform/comapi/commonutils/c/b:d	Lcom/baidu/mapsdkplatform/comapi/commonutils/c/c$c;
    //   375: aload_0
    //   376: invokeinterface 148 2 0
    //   381: aload_3
    //   382: ifnull +10 -> 392
    //   385: aload_3
    //   386: invokevirtual 142	java/io/InputStream:close	()V
    //   389: goto +3 -> 392
    //   392: aload 4
    //   394: ifnull +15 -> 409
    //   397: aload 4
    //   399: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   402: goto +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   409: aload_0
    //   410: getfield 33	com/baidu/mapsdkplatform/comapi/commonutils/c/b:d	Lcom/baidu/mapsdkplatform/comapi/commonutils/c/c$c;
    //   413: aload_0
    //   414: invokeinterface 153 2 0
    //   419: return
    //   420: astore 4
    //   422: aload_2
    //   423: astore_3
    //   424: aload 4
    //   426: astore_2
    //   427: aload_3
    //   428: ifnull +10 -> 438
    //   431: aload_3
    //   432: invokevirtual 142	java/io/InputStream:close	()V
    //   435: goto +3 -> 438
    //   438: aload 5
    //   440: ifnull +15 -> 455
    //   443: aload 5
    //   445: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   448: goto +7 -> 455
    //   451: aload_3
    //   452: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   455: aload_2
    //   456: athrow
    //   457: astore_2
    //   458: goto -107 -> 351
    //   461: astore_2
    //   462: aload 7
    //   464: astore 4
    //   466: goto -112 -> 354
    //   469: astore_2
    //   470: goto -65 -> 405
    //   473: astore_3
    //   474: goto -23 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	b
    //   207	91	1	i	int
    //   25	282	2	localObject1	Object
    //   337	1	2	localObject2	Object
    //   355	101	2	localObject3	Object
    //   457	1	2	localException1	java.lang.Exception
    //   461	1	2	localException2	java.lang.Exception
    //   469	1	2	localIOException1	java.io.IOException
    //   1	451	3	localObject4	Object
    //   473	1	3	localIOException2	java.io.IOException
    //   12	386	4	localObject5	Object
    //   420	5	4	localObject6	Object
    //   464	1	4	localObject7	Object
    //   6	438	5	localObject8	Object
    //   39	251	6	localObject9	Object
    //   167	296	7	localRandomAccessFile	java.io.RandomAccessFile
    //   3	236	8	localObject10	Object
    //   9	237	9	localObject11	Object
    //   236	59	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	53	337	finally
    //   56	65	337	finally
    //   65	88	337	finally
    //   88	169	337	finally
    //   179	192	420	finally
    //   202	208	420	finally
    //   232	238	420	finally
    //   248	255	420	finally
    //   265	273	420	finally
    //   292	301	420	finally
    //   314	319	420	finally
    //   360	365	420	finally
    //   371	381	420	finally
    //   14	53	457	java/lang/Exception
    //   56	65	457	java/lang/Exception
    //   65	88	457	java/lang/Exception
    //   88	169	457	java/lang/Exception
    //   179	192	461	java/lang/Exception
    //   202	208	461	java/lang/Exception
    //   232	238	461	java/lang/Exception
    //   248	255	461	java/lang/Exception
    //   265	273	461	java/lang/Exception
    //   292	301	461	java/lang/Exception
    //   314	319	461	java/lang/Exception
    //   324	329	469	java/io/IOException
    //   329	334	469	java/io/IOException
    //   385	389	469	java/io/IOException
    //   397	402	469	java/io/IOException
    //   431	435	473	java/io/IOException
    //   443	448	473	java/io/IOException
  }
  
  static class a
    implements HostnameVerifier
  {
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.commonutils.c.b
 * JD-Core Version:    0.7.0.1
 */