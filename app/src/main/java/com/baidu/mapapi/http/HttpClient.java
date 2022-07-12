package com.baidu.mapapi.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.f;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpClient
{
  public static boolean isHttpsEnable = true;
  private String a = null;
  private String b = null;
  HttpURLConnection c;
  private int d;
  private int e;
  private String f;
  private ProtoResultCallback g;
  
  public HttpClient(String paramString, ProtoResultCallback paramProtoResultCallback)
  {
    this.f = paramString;
    this.g = paramProtoResultCallback;
  }
  
  private HttpURLConnection a()
  {
    try
    {
      Object localObject = new URL(this.a);
      if (isHttpsEnable)
      {
        localObject = (HttpsURLConnection)((URL)localObject).openConnection();
        ((HttpsURLConnection)localObject).setHostnameVerifier(new a());
      }
      else
      {
        localObject = (HttpURLConnection)((URL)localObject).openConnection();
      }
      ((HttpURLConnection)localObject).setRequestMethod(this.f);
      ((HttpURLConnection)localObject).setDoOutput(false);
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).setConnectTimeout(this.d);
      ((HttpURLConnection)localObject).setReadTimeout(this.e);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("HttpClient", "url connect failed");
      if (Logger.debugEnable()) {
        localException.printStackTrace();
      } else {
        Logger.logW("HttpClient", localException.getMessage());
      }
    }
    return null;
  }
  
  public static String getAuthToken()
  {
    return f.x;
  }
  
  public static String getPhoneInfo()
  {
    return f.g();
  }
  
  protected boolean checkNetwork()
  {
    try
    {
      Object localObject = (ConnectivityManager)JNIInitializer.getCachedContext().getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkCapabilities(((ConnectivityManager)localObject).getActiveNetwork());
        if ((localObject != null) && (((NetworkCapabilities)localObject).hasCapability(12))) {
          return true;
        }
      }
      else
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null)
        {
          boolean bool = ((NetworkInfo)localObject).isAvailable();
          return bool;
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      if (Logger.debugEnable()) {
        localException.printStackTrace();
      } else {
        Logger.logW("HttpClient", localException.getMessage());
      }
      localException.printStackTrace();
      return false;
    }
    return false;
  }
  
  /* Error */
  protected void request(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 35	com/baidu/mapapi/http/HttpClient:a	Ljava/lang/String;
    //   5: aload_0
    //   6: invokevirtual 168	com/baidu/mapapi/http/HttpClient:checkNetwork	()Z
    //   9: ifne +14 -> 23
    //   12: aload_0
    //   13: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   16: getstatic 172	com/baidu/mapapi/http/HttpClient$HttpStateError:NETWORK_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   19: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   22: return
    //   23: aload_0
    //   24: invokespecial 178	com/baidu/mapapi/http/HttpClient:a	()Ljava/net/HttpURLConnection;
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: putfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   33: aload_1
    //   34: ifnonnull +22 -> 56
    //   37: ldc 87
    //   39: ldc 182
    //   41: invokestatic 94	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   49: getstatic 185	com/baidu/mapapi/http/HttpClient$HttpStateError:INNER_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   52: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   55: return
    //   56: aload_0
    //   57: getfield 35	com/baidu/mapapi/http/HttpClient:a	Ljava/lang/String;
    //   60: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +14 -> 77
    //   66: aload_0
    //   67: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   70: getstatic 194	com/baidu/mapapi/http/HttpClient$HttpStateError:REQUEST_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   73: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   76: return
    //   77: aload_0
    //   78: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   81: invokevirtual 197	java/net/HttpURLConnection:connect	()V
    //   84: aload_0
    //   85: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   88: invokevirtual 201	java/net/HttpURLConnection:getResponseCode	()I
    //   91: istore_2
    //   92: sipush 200
    //   95: iload_2
    //   96: if_icmpne +166 -> 262
    //   99: aload_0
    //   100: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   103: invokevirtual 205	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   106: astore_3
    //   107: aload_3
    //   108: astore_1
    //   109: aload_3
    //   110: astore 4
    //   112: new 207	java/io/BufferedReader
    //   115: dup
    //   116: new 209	java/io/InputStreamReader
    //   119: dup
    //   120: aload_3
    //   121: ldc 211
    //   123: invokespecial 214	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   126: invokespecial 217	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   129: astore 5
    //   131: aload_3
    //   132: astore 4
    //   134: aload 5
    //   136: astore_1
    //   137: new 219	java/lang/StringBuffer
    //   140: dup
    //   141: invokespecial 220	java/lang/StringBuffer:<init>	()V
    //   144: astore 6
    //   146: aload_3
    //   147: astore 4
    //   149: aload 5
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 223	java/io/BufferedReader:read	()I
    //   157: istore_2
    //   158: iload_2
    //   159: iconst_m1
    //   160: if_icmpeq +20 -> 180
    //   163: aload_3
    //   164: astore 4
    //   166: aload 5
    //   168: astore_1
    //   169: aload 6
    //   171: iload_2
    //   172: i2c
    //   173: invokevirtual 227	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   176: pop
    //   177: goto -31 -> 146
    //   180: aload_3
    //   181: astore 4
    //   183: aload 5
    //   185: astore_1
    //   186: aload_0
    //   187: aload 6
    //   189: invokevirtual 230	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   192: putfield 37	com/baidu/mapapi/http/HttpClient:b	Ljava/lang/String;
    //   195: aload_3
    //   196: ifnull +12 -> 208
    //   199: aload 5
    //   201: invokevirtual 233	java/io/BufferedReader:close	()V
    //   204: aload_3
    //   205: invokevirtual 236	java/io/InputStream:close	()V
    //   208: aload_0
    //   209: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   221: aload_0
    //   222: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   225: aload_0
    //   226: getfield 37	com/baidu/mapapi/http/HttpClient:b	Ljava/lang/String;
    //   229: invokevirtual 242	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onSuccess	(Ljava/lang/String;)V
    //   232: return
    //   233: astore_3
    //   234: goto +330 -> 564
    //   237: astore 6
    //   239: goto +218 -> 457
    //   242: astore_3
    //   243: aconst_null
    //   244: astore 5
    //   246: aload_1
    //   247: astore 4
    //   249: aload 5
    //   251: astore_1
    //   252: goto +312 -> 564
    //   255: astore_3
    //   256: aload 4
    //   258: astore_1
    //   259: goto +190 -> 449
    //   262: new 244	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   269: astore_1
    //   270: aload_1
    //   271: ldc 247
    //   273: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: iload_2
    //   279: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 87
    //   285: aload_1
    //   286: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 94	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   292: pop
    //   293: iload_2
    //   294: sipush 500
    //   297: if_icmplt +10 -> 307
    //   300: getstatic 257	com/baidu/mapapi/http/HttpClient$HttpStateError:SERVER_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   303: astore_3
    //   304: goto +21 -> 325
    //   307: iload_2
    //   308: sipush 400
    //   311: if_icmplt +10 -> 321
    //   314: getstatic 194	com/baidu/mapapi/http/HttpClient$HttpStateError:REQUEST_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   317: astore_3
    //   318: goto +7 -> 325
    //   321: getstatic 185	com/baidu/mapapi/http/HttpClient$HttpStateError:INNER_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   324: astore_3
    //   325: invokestatic 100	com/baidu/mapapi/common/Logger:debugEnable	()Z
    //   328: ifeq +36 -> 364
    //   331: aload_0
    //   332: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   335: invokevirtual 260	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   338: astore 5
    //   340: aload 5
    //   342: astore_1
    //   343: aload 5
    //   345: astore 4
    //   347: ldc 87
    //   349: aload 5
    //   351: invokevirtual 261	java/lang/Object:toString	()Ljava/lang/String;
    //   354: invokestatic 111	com/baidu/mapapi/common/Logger:logW	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: astore 4
    //   361: goto +51 -> 412
    //   364: new 244	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   371: astore_1
    //   372: aload_1
    //   373: ldc_w 263
    //   376: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iload_2
    //   382: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_1
    //   387: ldc_w 265
    //   390: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_1
    //   395: aload_3
    //   396: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 87
    //   402: aload_1
    //   403: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 111	com/baidu/mapapi/common/Logger:logW	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aconst_null
    //   410: astore 4
    //   412: aload 4
    //   414: astore_1
    //   415: aload_0
    //   416: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   419: aload_3
    //   420: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   423: aload_0
    //   424: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   427: astore_1
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   436: return
    //   437: astore_3
    //   438: aconst_null
    //   439: astore_1
    //   440: aload_1
    //   441: astore 4
    //   443: goto +121 -> 564
    //   446: astore_3
    //   447: aconst_null
    //   448: astore_1
    //   449: aconst_null
    //   450: astore 5
    //   452: aload_3
    //   453: astore 6
    //   455: aload_1
    //   456: astore_3
    //   457: aload_3
    //   458: astore 4
    //   460: aload 5
    //   462: astore_1
    //   463: invokestatic 100	com/baidu/mapapi/common/Logger:debugEnable	()Z
    //   466: ifeq +17 -> 483
    //   469: aload_3
    //   470: astore 4
    //   472: aload 5
    //   474: astore_1
    //   475: aload 6
    //   477: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   480: goto +19 -> 499
    //   483: aload_3
    //   484: astore 4
    //   486: aload 5
    //   488: astore_1
    //   489: ldc 87
    //   491: aload 6
    //   493: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   496: invokestatic 111	com/baidu/mapapi/common/Logger:logW	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload_3
    //   500: astore 4
    //   502: aload 5
    //   504: astore_1
    //   505: ldc 87
    //   507: ldc_w 270
    //   510: aload 6
    //   512: invokestatic 273	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   515: pop
    //   516: aload_3
    //   517: astore 4
    //   519: aload 5
    //   521: astore_1
    //   522: aload_0
    //   523: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   526: getstatic 185	com/baidu/mapapi/http/HttpClient$HttpStateError:INNER_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   529: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   532: aload_3
    //   533: ifnull +17 -> 550
    //   536: aload 5
    //   538: ifnull +12 -> 550
    //   541: aload 5
    //   543: invokevirtual 233	java/io/BufferedReader:close	()V
    //   546: aload_3
    //   547: invokevirtual 236	java/io/InputStream:close	()V
    //   550: aload_0
    //   551: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   554: astore_1
    //   555: aload_1
    //   556: ifnull +85 -> 641
    //   559: aload_1
    //   560: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   563: return
    //   564: aload 4
    //   566: ifnull +16 -> 582
    //   569: aload_1
    //   570: ifnull +12 -> 582
    //   573: aload_1
    //   574: invokevirtual 233	java/io/BufferedReader:close	()V
    //   577: aload 4
    //   579: invokevirtual 236	java/io/InputStream:close	()V
    //   582: aload_0
    //   583: getfield 180	com/baidu/mapapi/http/HttpClient:c	Ljava/net/HttpURLConnection;
    //   586: astore_1
    //   587: aload_1
    //   588: ifnull +7 -> 595
    //   591: aload_1
    //   592: invokevirtual 239	java/net/HttpURLConnection:disconnect	()V
    //   595: aload_3
    //   596: athrow
    //   597: astore_1
    //   598: invokestatic 100	com/baidu/mapapi/common/Logger:debugEnable	()Z
    //   601: ifeq +10 -> 611
    //   604: aload_1
    //   605: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   608: goto +12 -> 620
    //   611: ldc 87
    //   613: aload_1
    //   614: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   617: invokestatic 111	com/baidu/mapapi/common/Logger:logW	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: ldc 87
    //   622: ldc_w 275
    //   625: aload_1
    //   626: invokestatic 273	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   629: pop
    //   630: aload_0
    //   631: getfield 41	com/baidu/mapapi/http/HttpClient:g	Lcom/baidu/mapapi/http/HttpClient$ProtoResultCallback;
    //   634: getstatic 185	com/baidu/mapapi/http/HttpClient$HttpStateError:INNER_ERROR	Lcom/baidu/mapapi/http/HttpClient$HttpStateError;
    //   637: invokevirtual 176	com/baidu/mapapi/http/HttpClient$ProtoResultCallback:onFailed	(Lcom/baidu/mapapi/http/HttpClient$HttpStateError;)V
    //   640: return
    //   641: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	HttpClient
    //   0	642	1	paramString	String
    //   91	291	2	i	int
    //   106	99	3	localInputStream	java.io.InputStream
    //   233	1	3	localObject1	Object
    //   242	1	3	localObject2	Object
    //   255	1	3	localException1	Exception
    //   303	117	3	localHttpStateError	HttpStateError
    //   437	1	3	localObject3	Object
    //   446	7	3	localException2	Exception
    //   456	140	3	str	String
    //   110	468	4	localObject4	Object
    //   129	413	5	localObject5	Object
    //   144	44	6	localStringBuffer	java.lang.StringBuffer
    //   237	1	6	localException3	Exception
    //   453	58	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   137	146	233	finally
    //   152	158	233	finally
    //   169	177	233	finally
    //   186	195	233	finally
    //   463	469	233	finally
    //   475	480	233	finally
    //   489	499	233	finally
    //   505	516	233	finally
    //   522	532	233	finally
    //   137	146	237	java/lang/Exception
    //   152	158	237	java/lang/Exception
    //   169	177	237	java/lang/Exception
    //   186	195	237	java/lang/Exception
    //   112	131	242	finally
    //   347	357	242	finally
    //   415	423	242	finally
    //   112	131	255	java/lang/Exception
    //   347	357	255	java/lang/Exception
    //   415	423	255	java/lang/Exception
    //   84	92	437	finally
    //   99	107	437	finally
    //   262	293	437	finally
    //   300	304	437	finally
    //   314	318	437	finally
    //   321	325	437	finally
    //   325	340	437	finally
    //   364	409	437	finally
    //   84	92	446	java/lang/Exception
    //   99	107	446	java/lang/Exception
    //   262	293	446	java/lang/Exception
    //   300	304	446	java/lang/Exception
    //   314	318	446	java/lang/Exception
    //   321	325	446	java/lang/Exception
    //   325	340	446	java/lang/Exception
    //   364	409	446	java/lang/Exception
    //   77	84	597	java/lang/Exception
    //   199	208	597	java/lang/Exception
    //   208	213	597	java/lang/Exception
    //   217	221	597	java/lang/Exception
    //   423	428	597	java/lang/Exception
    //   432	436	597	java/lang/Exception
    //   541	550	597	java/lang/Exception
    //   550	555	597	java/lang/Exception
    //   559	563	597	java/lang/Exception
    //   573	582	597	java/lang/Exception
    //   582	587	597	java/lang/Exception
    //   591	595	597	java/lang/Exception
    //   595	597	597	java/lang/Exception
  }
  
  public void setMaxTimeOut(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setReadTimeOut(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static enum HttpStateError
  {
    static
    {
      HttpStateError localHttpStateError1 = new HttpStateError("NO_ERROR", 0);
      NO_ERROR = localHttpStateError1;
      HttpStateError localHttpStateError2 = new HttpStateError("NETWORK_ERROR", 1);
      NETWORK_ERROR = localHttpStateError2;
      HttpStateError localHttpStateError3 = new HttpStateError("INNER_ERROR", 2);
      INNER_ERROR = localHttpStateError3;
      HttpStateError localHttpStateError4 = new HttpStateError("REQUEST_ERROR", 3);
      REQUEST_ERROR = localHttpStateError4;
      HttpStateError localHttpStateError5 = new HttpStateError("SERVER_ERROR", 4);
      SERVER_ERROR = localHttpStateError5;
      $VALUES = new HttpStateError[] { localHttpStateError1, localHttpStateError2, localHttpStateError3, localHttpStateError4, localHttpStateError5 };
    }
    
    private HttpStateError() {}
  }
  
  public static abstract class ProtoResultCallback
  {
    public abstract void onFailed(HttpClient.HttpStateError paramHttpStateError);
    
    public abstract void onSuccess(String paramString);
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
 * Qualified Name:     com.baidu.mapapi.http.HttpClient
 * JD-Core Version:    0.7.0.1
 */