package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.mapsdkplatform.comapi.commonutils.c.c;
import com.baidu.mapsdkplatform.comapi.commonutils.c.c.d;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static final String b = "d";
  private AsyncHttpClient a = new AsyncHttpClient();
  
  public static d a()
  {
    return d.a();
  }
  
  /* Error */
  private String a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 40	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokevirtual 46	android/content/Context:getFilesDir	()Ljava/io/File;
    //   19: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   22: ldc 52
    //   24: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 59	java/io/File:exists	()Z
    //   34: ifne +6 -> 40
    //   37: ldc 61
    //   39: areturn
    //   40: new 63	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: new 66	java/io/BufferedReader
    //   53: dup
    //   54: new 68	java/io/FileReader
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   63: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +12 -> 85
    //   76: aload_3
    //   77: aload_1
    //   78: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -15 -> 67
    //   85: aload_2
    //   86: invokevirtual 84	java/io/BufferedReader:close	()V
    //   89: goto +8 -> 97
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   97: aload_3
    //   98: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: areturn
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto +40 -> 147
    //   110: astore_3
    //   111: goto +11 -> 122
    //   114: astore_2
    //   115: goto +32 -> 147
    //   118: astore_3
    //   119: aload 4
    //   121: astore_2
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: ifnull +15 -> 144
    //   132: aload_2
    //   133: invokevirtual 84	java/io/BufferedReader:close	()V
    //   136: ldc 61
    //   138: areturn
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   144: ldc 61
    //   146: areturn
    //   147: aload_1
    //   148: ifnull +15 -> 163
    //   151: aload_1
    //   152: invokevirtual 84	java/io/BufferedReader:close	()V
    //   155: goto +8 -> 163
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   163: aload_2
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	d
    //   0	165	1	paramContext	Context
    //   4	103	2	localObject1	Object
    //   114	1	2	localObject2	Object
    //   121	43	2	localObject3	Object
    //   47	51	3	localStringBuilder	StringBuilder
    //   102	4	3	localObject4	Object
    //   110	1	3	localIOException1	IOException
    //   118	7	3	localIOException2	IOException
    //   1	119	4	localObject5	Object
    //   27	32	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   85	89	92	java/io/IOException
    //   67	72	102	finally
    //   76	82	102	finally
    //   67	72	110	java/io/IOException
    //   76	82	110	java/io/IOException
    //   50	67	114	finally
    //   124	128	114	finally
    //   50	67	118	java/io/IOException
    //   132	136	139	java/io/IOException
    //   151	155	158	java/io/IOException
  }
  
  private String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sc_sty_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".sty");
    return localStringBuilder.toString();
  }
  
  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext == null) {
      return "";
    }
    String str = b(paramContext, paramString);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("style_id", paramString);
    if (paramBoolean) {
      paramContext = "publish";
    } else {
      paramContext = "edit";
    }
    localLinkedHashMap.put("type", paramContext);
    localLinkedHashMap.put("md5", str);
    localLinkedHashMap.put("token", SyncSysInfo.getAuthToken());
    paramContext = a(localLinkedHashMap);
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append(SyncSysInfo.getPhoneInfo());
    paramContext = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append("&sign=");
    paramString.append(AppMD5.getSignMD5String(paramContext));
    paramContext = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(a("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle"));
    paramString.append("?");
    paramString.append(paramContext);
    return paramString.toString();
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder;
    if (HttpClient.isHttpsEnable) {
      localStringBuilder = new StringBuilder();
    }
    for (String str = "https://";; str = "http://")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
    }
  }
  
  private String a(Map<String, String> paramMap)
  {
    if (paramMap.isEmpty()) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = AppMD5.encodeUrlParamsValue((String)paramMap.get(str1));
      if (i != 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(str1);
      localStringBuilder.append("=");
      localStringBuilder.append(str2);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 40	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokevirtual 46	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: ldc 52
    //   18: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore 10
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 202	com/baidu/mapsdkplatform/comapi/map/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 8
    //   33: aconst_null
    //   34: astore 9
    //   36: aload 9
    //   38: astore_1
    //   39: aload 6
    //   41: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifeq +18 -> 62
    //   47: aload 9
    //   49: astore_1
    //   50: new 209	org/json/JSONArray
    //   53: dup
    //   54: invokespecial 210	org/json/JSONArray:<init>	()V
    //   57: astore 6
    //   59: goto +17 -> 76
    //   62: aload 9
    //   64: astore_1
    //   65: new 209	org/json/JSONArray
    //   68: dup
    //   69: aload 6
    //   71: invokespecial 213	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   74: astore 6
    //   76: aload 9
    //   78: astore_1
    //   79: aload 6
    //   81: invokevirtual 217	org/json/JSONArray:length	()I
    //   84: istore 5
    //   86: iload 5
    //   88: ifne +233 -> 321
    //   91: aload 9
    //   93: astore_1
    //   94: new 219	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 220	org/json/JSONObject:<init>	()V
    //   101: astore 7
    //   103: aload 9
    //   105: astore_1
    //   106: aload 7
    //   108: aload_2
    //   109: aload_3
    //   110: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 7
    //   116: astore_2
    //   117: aload 9
    //   119: astore_1
    //   120: aload 6
    //   122: aload_2
    //   123: invokevirtual 226	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   126: pop
    //   127: goto +112 -> 239
    //   130: iload 4
    //   132: iload 5
    //   134: if_icmpge +207 -> 341
    //   137: aload 9
    //   139: astore_1
    //   140: aload 6
    //   142: iload 4
    //   144: invokevirtual 230	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   147: checkcast 219	org/json/JSONObject
    //   150: astore 7
    //   152: aload 7
    //   154: ifnull +175 -> 329
    //   157: aload 9
    //   159: astore_1
    //   160: aload 7
    //   162: aload_2
    //   163: invokevirtual 234	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   166: ifeq +163 -> 329
    //   169: goto +3 -> 172
    //   172: iload 4
    //   174: iconst_m1
    //   175: if_icmpeq +35 -> 210
    //   178: aload 7
    //   180: ifnull +30 -> 210
    //   183: aload 9
    //   185: astore_1
    //   186: aload 7
    //   188: aload_2
    //   189: aload_3
    //   190: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 9
    //   196: astore_1
    //   197: aload 6
    //   199: iload 4
    //   201: aload 7
    //   203: invokevirtual 237	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   206: pop
    //   207: goto +32 -> 239
    //   210: aload 9
    //   212: astore_1
    //   213: new 219	org/json/JSONObject
    //   216: dup
    //   217: invokespecial 220	org/json/JSONObject:<init>	()V
    //   220: astore 7
    //   222: aload 9
    //   224: astore_1
    //   225: aload 7
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 7
    //   235: astore_2
    //   236: goto -119 -> 117
    //   239: aload 9
    //   241: astore_1
    //   242: new 239	java/io/PrintWriter
    //   245: dup
    //   246: new 241	java/io/FileWriter
    //   249: dup
    //   250: aload 10
    //   252: invokevirtual 244	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   255: invokespecial 245	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   258: invokespecial 248	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   261: astore_2
    //   262: aload_2
    //   263: aload 6
    //   265: invokevirtual 249	org/json/JSONArray:toString	()Ljava/lang/String;
    //   268: invokevirtual 252	java/io/PrintWriter:write	(Ljava/lang/String;)V
    //   271: aload_2
    //   272: invokevirtual 253	java/io/PrintWriter:close	()V
    //   275: return
    //   276: astore_3
    //   277: aload_2
    //   278: astore_1
    //   279: aload_3
    //   280: astore_2
    //   281: goto +30 -> 311
    //   284: astore_3
    //   285: goto +11 -> 296
    //   288: astore_2
    //   289: goto +22 -> 311
    //   292: astore_3
    //   293: aload 8
    //   295: astore_2
    //   296: aload_2
    //   297: astore_1
    //   298: aload_3
    //   299: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 253	java/io/PrintWriter:close	()V
    //   310: return
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 253	java/io/PrintWriter:close	()V
    //   319: aload_2
    //   320: athrow
    //   321: iconst_0
    //   322: istore 4
    //   324: aconst_null
    //   325: astore_1
    //   326: goto -196 -> 130
    //   329: iload 4
    //   331: iconst_1
    //   332: iadd
    //   333: istore 4
    //   335: aload 7
    //   337: astore_1
    //   338: goto -208 -> 130
    //   341: iconst_m1
    //   342: istore 4
    //   344: aload_1
    //   345: astore 7
    //   347: goto -175 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	d
    //   0	350	1	paramContext	Context
    //   0	350	2	paramString1	String
    //   0	350	3	paramString2	String
    //   130	213	4	i	int
    //   84	51	5	j	int
    //   28	236	6	localObject1	Object
    //   101	245	7	localObject2	Object
    //   31	263	8	localObject3	Object
    //   34	206	9	localObject4	Object
    //   21	230	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   262	271	276	finally
    //   262	271	284	java/lang/Exception
    //   39	47	288	finally
    //   50	59	288	finally
    //   65	76	288	finally
    //   79	86	288	finally
    //   94	103	288	finally
    //   106	114	288	finally
    //   120	127	288	finally
    //   140	152	288	finally
    //   160	169	288	finally
    //   186	194	288	finally
    //   197	207	288	finally
    //   213	222	288	finally
    //   225	233	288	finally
    //   242	262	288	finally
    //   298	302	288	finally
    //   39	47	292	java/lang/Exception
    //   50	59	292	java/lang/Exception
    //   65	76	292	java/lang/Exception
    //   79	86	292	java/lang/Exception
    //   94	103	292	java/lang/Exception
    //   106	114	292	java/lang/Exception
    //   120	127	292	java/lang/Exception
    //   140	152	292	java/lang/Exception
    //   160	169	292	java/lang/Exception
    //   186	194	292	java/lang/Exception
    //   197	207	292	java/lang/Exception
    //   213	222	292	java/lang/Exception
    //   225	233	292	java/lang/Exception
    //   242	262	292	java/lang/Exception
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, c paramc)
  {
    String str2 = a(paramContext, paramString2);
    String str1;
    if (b(str2)) {
      str1 = str2;
    } else {
      str1 = null;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramc != null)
      {
        paramContext = HttpClient.HttpStateError.SERVER_ERROR;
        paramc.onCustomMapStyleLoadFailed(paramContext.ordinal(), paramContext.name(), str1);
      }
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      int i = paramString1.optInt("status");
      String str3 = paramString1.optString("message");
      if (!a(i, str2))
      {
        if (paramc != null) {
          paramc.onCustomMapStyleLoadSuccess(false, str1);
        }
        return;
      }
      if (i != 0)
      {
        if (paramc != null) {
          paramc.onCustomMapStyleLoadFailed(i, str3, str1);
        }
        return;
      }
      paramString1 = paramString1.optJSONObject("data");
      if ((paramString1 != null) && (paramString1.length() != 0))
      {
        str1 = paramString1.optString("md5", "");
        a(paramContext, paramString1.optString("pb_url", ""), paramString2, str1, paramc);
        return;
      }
      if (paramc != null) {
        paramc.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str1);
      }
      return;
    }
    catch (JSONException paramContext)
    {
      label215:
      break label215;
    }
    if (paramc != null) {
      paramc.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str1);
    }
  }
  
  private void a(final Context paramContext, String paramString1, final String paramString2, final String paramString3, final c paramc)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramContext == null) {
        return;
      }
      paramString1 = a(paramString1);
      final String str1 = a(paramContext, paramString2);
      String str2 = paramContext.getFilesDir().getAbsolutePath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      new c().a(paramString1, str2, (String)localObject, 2, new b(paramContext, paramString2, paramc, paramString3, str1));
    }
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean, c paramc)
  {
    String str = a(paramContext, paramString);
    if (!b(str)) {
      str = null;
    }
    if (paramc != null) {
      paramc.onPreLoadLastCustomMapStyle(str);
    }
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      if (paramc != null)
      {
        paramContext = HttpClient.HttpStateError.NETWORK_ERROR;
        paramc.onCustomMapStyleLoadFailed(paramContext.ordinal(), paramContext.name(), str);
      }
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    str = a(paramContext, paramString, paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      Log.e(b, "build request url failed");
      return;
    }
    b(paramContext, str, paramString, paramc);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    return (103 != paramInt) || (!b(paramString));
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +415 -> 416
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 10
    //   22: aconst_null
    //   23: astore 11
    //   25: aconst_null
    //   26: astore 12
    //   28: aconst_null
    //   29: astore 13
    //   31: aconst_null
    //   32: astore 5
    //   34: new 375	java/util/zip/ZipFile
    //   37: dup
    //   38: aload_2
    //   39: invokevirtual 244	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   42: invokespecial 376	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   45: astore 6
    //   47: new 63	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   54: astore 5
    //   56: aload 5
    //   58: aload_3
    //   59: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 5
    //   65: ldc 98
    //   67: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: aload 5
    //   75: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 380	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +24 -> 109
    //   88: aload 6
    //   90: invokevirtual 381	java/util/zip/ZipFile:close	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_1
    //   96: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   99: ldc_w 383
    //   102: aload_1
    //   103: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: iconst_0
    //   108: ireturn
    //   109: new 40	java/io/File
    //   112: dup
    //   113: aload_0
    //   114: aload_1
    //   115: aload_3
    //   116: invokespecial 150	com/baidu/mapsdkplatform/comapi/map/d:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   119: invokespecial 387	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_1
    //   123: aload_0
    //   124: aload 6
    //   126: aload 5
    //   128: invokevirtual 391	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   131: new 393	java/io/FileOutputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   139: invokespecial 397	com/baidu/mapsdkplatform/comapi/map/d:a	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)Z
    //   142: istore 4
    //   144: aload_2
    //   145: invokevirtual 400	java/io/File:delete	()Z
    //   148: pop
    //   149: aload 6
    //   151: invokevirtual 381	java/util/zip/ZipFile:close	()V
    //   154: iload 4
    //   156: ireturn
    //   157: astore_1
    //   158: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   161: ldc_w 383
    //   164: aload_1
    //   165: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   168: pop
    //   169: iload 4
    //   171: ireturn
    //   172: astore_1
    //   173: aload 6
    //   175: astore 5
    //   177: goto +212 -> 389
    //   180: aload 6
    //   182: astore_1
    //   183: goto +49 -> 232
    //   186: astore_2
    //   187: aload 6
    //   189: astore_1
    //   190: goto +60 -> 250
    //   193: astore_2
    //   194: aload 6
    //   196: astore_1
    //   197: goto +74 -> 271
    //   200: astore_2
    //   201: aload 6
    //   203: astore_1
    //   204: goto +88 -> 292
    //   207: astore_2
    //   208: aload 6
    //   210: astore_1
    //   211: goto +102 -> 313
    //   214: astore_2
    //   215: aload 6
    //   217: astore_1
    //   218: goto +116 -> 334
    //   221: astore_2
    //   222: aload 6
    //   224: astore_1
    //   225: goto +130 -> 355
    //   228: astore_1
    //   229: goto +160 -> 389
    //   232: aload_1
    //   233: ifnull +154 -> 387
    //   236: aload_1
    //   237: invokevirtual 381	java/util/zip/ZipFile:close	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: goto +133 -> 376
    //   246: astore_2
    //   247: aload 7
    //   249: astore_1
    //   250: aload_1
    //   251: astore 5
    //   253: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   256: ldc_w 402
    //   259: aload_2
    //   260: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   263: pop
    //   264: aload_1
    //   265: ifnull +122 -> 387
    //   268: goto -32 -> 236
    //   271: aload_1
    //   272: astore 5
    //   274: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   277: ldc_w 404
    //   280: aload_2
    //   281: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   284: pop
    //   285: aload_1
    //   286: ifnull +101 -> 387
    //   289: goto -53 -> 236
    //   292: aload_1
    //   293: astore 5
    //   295: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   298: ldc_w 406
    //   301: aload_2
    //   302: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   305: pop
    //   306: aload_1
    //   307: ifnull +80 -> 387
    //   310: goto -74 -> 236
    //   313: aload_1
    //   314: astore 5
    //   316: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   319: ldc_w 408
    //   322: aload_2
    //   323: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   326: pop
    //   327: aload_1
    //   328: ifnull +59 -> 387
    //   331: goto -95 -> 236
    //   334: aload_1
    //   335: astore 5
    //   337: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   340: ldc_w 410
    //   343: aload_2
    //   344: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   347: pop
    //   348: aload_1
    //   349: ifnull +38 -> 387
    //   352: goto -116 -> 236
    //   355: aload_1
    //   356: astore 5
    //   358: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   361: ldc_w 412
    //   364: aload_2
    //   365: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   368: pop
    //   369: aload_1
    //   370: ifnull +17 -> 387
    //   373: goto -137 -> 236
    //   376: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   379: ldc_w 383
    //   382: aload_1
    //   383: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   386: pop
    //   387: iconst_0
    //   388: ireturn
    //   389: aload 5
    //   391: ifnull +23 -> 414
    //   394: aload 5
    //   396: invokevirtual 381	java/util/zip/ZipFile:close	()V
    //   399: goto +15 -> 414
    //   402: astore_2
    //   403: getstatic 346	com/baidu/mapsdkplatform/comapi/map/d:b	Ljava/lang/String;
    //   406: ldc_w 383
    //   409: aload_2
    //   410: invokestatic 386	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   413: pop
    //   414: aload_1
    //   415: athrow
    //   416: iconst_0
    //   417: ireturn
    //   418: astore_1
    //   419: aload 8
    //   421: astore_1
    //   422: goto -190 -> 232
    //   425: astore_1
    //   426: goto -246 -> 180
    //   429: astore_2
    //   430: aload 9
    //   432: astore_1
    //   433: goto -162 -> 271
    //   436: astore_2
    //   437: aload 10
    //   439: astore_1
    //   440: goto -148 -> 292
    //   443: astore_2
    //   444: aload 11
    //   446: astore_1
    //   447: goto -134 -> 313
    //   450: astore_2
    //   451: aload 12
    //   453: astore_1
    //   454: goto -120 -> 334
    //   457: astore_2
    //   458: aload 13
    //   460: astore_1
    //   461: goto -106 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	d
    //   0	464	1	paramContext	Context
    //   0	464	2	paramFile	File
    //   0	464	3	paramString	String
    //   142	28	4	bool	boolean
    //   32	363	5	localObject1	Object
    //   45	178	6	localZipFile	java.util.zip.ZipFile
    //   14	234	7	localObject2	Object
    //   11	409	8	localObject3	Object
    //   17	414	9	localObject4	Object
    //   20	418	10	localObject5	Object
    //   23	422	11	localObject6	Object
    //   26	426	12	localObject7	Object
    //   29	430	13	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   149	154	157	java/io/IOException
    //   47	83	172	finally
    //   109	149	172	finally
    //   47	83	186	java/lang/SecurityException
    //   109	149	186	java/lang/SecurityException
    //   47	83	193	java/lang/IllegalStateException
    //   109	149	193	java/lang/IllegalStateException
    //   47	83	200	java/lang/NullPointerException
    //   109	149	200	java/lang/NullPointerException
    //   47	83	207	java/io/IOException
    //   109	149	207	java/io/IOException
    //   47	83	214	java/util/zip/ZipException
    //   109	149	214	java/util/zip/ZipException
    //   47	83	221	java/io/FileNotFoundException
    //   109	149	221	java/io/FileNotFoundException
    //   34	47	228	finally
    //   253	264	228	finally
    //   274	285	228	finally
    //   295	306	228	finally
    //   316	327	228	finally
    //   337	348	228	finally
    //   358	369	228	finally
    //   236	240	242	java/io/IOException
    //   34	47	246	java/lang/SecurityException
    //   394	399	402	java/io/IOException
    //   34	47	418	java/lang/Exception
    //   47	83	425	java/lang/Exception
    //   109	149	425	java/lang/Exception
    //   34	47	429	java/lang/IllegalStateException
    //   34	47	436	java/lang/NullPointerException
    //   34	47	443	java/io/IOException
    //   34	47	450	java/util/zip/ZipException
    //   34	47	457	java/io/FileNotFoundException
  }
  
  private boolean a(InputStream paramInputStream, FileOutputStream paramFileOutputStream)
  {
    if (paramInputStream != null)
    {
      if (paramFileOutputStream == null) {
        return false;
      }
      byte[] arrayOfByte = new byte[4096];
      try
      {
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramFileOutputStream.write(arrayOfByte, 0, i);
        }
        paramFileOutputStream.flush();
        return true;
      }
      finally
      {
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          Log.e(b, "Close InputStream error", paramInputStream);
        }
        try
        {
          paramFileOutputStream.close();
        }
        catch (IOException paramInputStream)
        {
          Log.e(b, "Close OutputStream error", paramInputStream);
        }
      }
    }
    return false;
  }
  
  private String b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    try
    {
      paramContext = new JSONArray(paramContext);
      int j = paramContext.length();
      int i = 0;
      while (i < j)
      {
        String str = ((JSONObject)paramContext.opt(i)).optString(paramString);
        boolean bool = TextUtils.isEmpty(str);
        if (!bool) {
          return str;
        }
        i += 1;
      }
      return "";
    }
    catch (JSONException paramContext) {}
    return "";
  }
  
  private void b(final Context paramContext, String paramString1, final String paramString2, final c paramc)
  {
    this.a.get(paramString1, new a(paramContext, paramString2, paramc));
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public void a(Context paramContext, String paramString, c paramc)
  {
    a(paramContext, paramString, true, paramc);
  }
  
  class a
    extends HttpClient.ProtoResultCallback
  {
    a(Context paramContext, String paramString, d.c paramc) {}
    
    public void onFailed(HttpClient.HttpStateError paramHttpStateError)
    {
      Object localObject1 = d.a(d.this, paramContext, paramString2);
      if (!d.a(d.this, (String)localObject1)) {
        localObject1 = null;
      }
      Object localObject2 = paramc;
      if (localObject2 != null) {
        ((d.c)localObject2).onCustomMapStyleLoadFailed(paramHttpStateError.ordinal(), paramHttpStateError.name(), (String)localObject1);
      }
      if (OpenLogUtil.isMapLogEnable())
      {
        localObject1 = b.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CustomMap failed error = ");
        ((StringBuilder)localObject2).append(paramHttpStateError.ordinal());
        ((b)localObject1).a(((StringBuilder)localObject2).toString());
      }
    }
    
    public void onSuccess(String paramString)
    {
      d.a(d.this, paramContext, paramString, paramString2, paramc);
      if (OpenLogUtil.isMapLogEnable())
      {
        b localb = b.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CustomMap result = ");
        localStringBuilder.append(paramString);
        localb.a(localStringBuilder.toString());
      }
    }
  }
  
  class b
    implements c.d
  {
    b(Context paramContext, String paramString1, d.c paramc, String paramString2, String paramString3) {}
    
    public void a()
    {
      d.c localc = paramc;
      if (localc != null) {
        localc.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
      }
      if (OpenLogUtil.isMapLogEnable()) {
        b.a().a("CustomMap loadStyleFile failed");
      }
    }
    
    public void a(File paramFile)
    {
      boolean bool = d.a(d.this, paramContext, paramFile, paramString2);
      if (OpenLogUtil.isMapLogEnable())
      {
        paramFile = b.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CustomMap loadStyleFile success ret = ");
        localStringBuilder.append(bool);
        paramFile.a(localStringBuilder.toString());
      }
      paramFile = null;
      if (!bool)
      {
        paramFile = paramc;
        if (paramFile != null) {
          paramFile.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
        }
        return;
      }
      d.a(d.this, paramContext, paramString2, paramString3);
      if (paramc != null)
      {
        if (d.a(d.this, str1)) {
          paramFile = str1;
        }
        paramc.onCustomMapStyleLoadSuccess(true, paramFile);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onCustomMapStyleLoadFailed(int paramInt, String paramString1, String paramString2);
    
    public abstract void onCustomMapStyleLoadSuccess(boolean paramBoolean, String paramString);
    
    public abstract void onPreLoadLastCustomMapStyle(String paramString);
  }
  
  private static class d
  {
    private static final d a = new d(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.d
 * JD-Core Version:    0.7.0.1
 */