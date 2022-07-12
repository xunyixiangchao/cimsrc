package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSAuthManager
{
  public static final int CODE_AUTHENTICATE_SUCC = 0;
  public static final int CODE_AUTHENTICATING = 602;
  public static final int CODE_INNER_ERROR = -1;
  public static final int CODE_KEY_NOT_EXIST = 101;
  public static final int CODE_NETWORK_FAILED = -11;
  public static final int CODE_NETWORK_INVALID = -10;
  public static final int CODE_UNAUTHENTICATE = 601;
  public static final String VERSION = "1.0.25";
  private static Context a;
  private static m d;
  private static int e;
  private static Hashtable f = new Hashtable();
  private static LBSAuthManager g;
  private static String i = "";
  private static String j = "";
  private static String k = "";
  private static String[] l = null;
  private static boolean m = false;
  private c b = null;
  private e c = null;
  private boolean h = false;
  private final Handler n = new i(this, Looper.getMainLooper());
  
  private LBSAuthManager(Context paramContext)
  {
    a = paramContext;
    paramContext = d;
    if ((paramContext != null) && (!paramContext.isAlive())) {
      d = null;
    }
    a.b("BaiduApiAuth SDK Version:1.0.25");
    e();
  }
  
  private int a(String paramString)
  {
    int i2 = -1;
    int i1 = i2;
    for (;;)
    {
      int i3;
      try
      {
        paramString = new JSONObject(paramString);
        i1 = i2;
        if (!paramString.has("status"))
        {
          i1 = i2;
          paramString.put("status", -1);
        }
        i1 = i2;
        i3 = paramString.getInt("status");
        i2 = i3;
        i1 = i3;
        long l1;
        if (paramString.has("current"))
        {
          i2 = i3;
          if (i3 == 0)
          {
            i1 = i3;
            l1 = paramString.getLong("current");
            i1 = i3;
            long l2 = System.currentTimeMillis();
            i1 = i3;
            if ((l2 - l1) / 3600000.0D >= 24.0D) {
              break label247;
            }
            i2 = i3;
            i1 = i3;
            if (this.h)
            {
              i1 = i3;
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
              i2 = i3;
              i1 = i3;
              if (!localSimpleDateFormat.format(Long.valueOf(l2)).equals(localSimpleDateFormat.format(Long.valueOf(l1)))) {
                break label247;
              }
            }
          }
        }
        i1 = i2;
        i3 = i2;
        if (paramString.has("current"))
        {
          i3 = i2;
          if (i2 == 602)
          {
            i1 = i2;
            l1 = paramString.getLong("current");
            i1 = i2;
            l1 = (System.currentTimeMillis() - l1) / 1000L;
            i3 = i2;
            if (l1 > 180.0D) {
              return 601;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        i3 = i1;
      }
      return i3;
      label247:
      i2 = 601;
    }
  }
  
  /* Error */
  private String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 179	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 182
    //   13: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: iload_1
    //   19: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc 191
    //   26: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 193	java/io/FileInputStream
    //   33: dup
    //   34: new 195	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 200	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_2
    //   49: new 205	java/io/InputStreamReader
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 208	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: new 210	java/io/BufferedReader
    //   62: dup
    //   63: aload 4
    //   65: invokespecial 213	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   68: astore 5
    //   70: aload 5
    //   72: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 6
    //   77: aload 5
    //   79: invokevirtual 219	java/io/BufferedReader:close	()V
    //   82: aload 4
    //   84: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   87: aload 6
    //   89: astore_3
    //   90: aload_2
    //   91: invokevirtual 221	java/io/FileInputStream:close	()V
    //   94: aload_3
    //   95: areturn
    //   96: astore_3
    //   97: aload 4
    //   99: astore 6
    //   101: aload 5
    //   103: astore 4
    //   105: goto +58 -> 163
    //   108: astore_3
    //   109: aconst_null
    //   110: astore 5
    //   112: aload 4
    //   114: astore 6
    //   116: aload 5
    //   118: astore 4
    //   120: goto +43 -> 163
    //   123: aconst_null
    //   124: astore 5
    //   126: goto +75 -> 201
    //   129: aconst_null
    //   130: astore 5
    //   132: goto +104 -> 236
    //   135: astore_3
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: astore 6
    //   143: goto +20 -> 163
    //   146: goto +49 -> 195
    //   149: goto +81 -> 230
    //   152: astore_3
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 6
    //   158: astore 4
    //   160: aload 4
    //   162: astore_2
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 219	java/io/BufferedReader:close	()V
    //   173: aload 6
    //   175: ifnull +8 -> 183
    //   178: aload 6
    //   180: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   183: aload_2
    //   184: ifnull +7 -> 191
    //   187: aload_2
    //   188: invokevirtual 221	java/io/FileInputStream:close	()V
    //   191: aload_3
    //   192: athrow
    //   193: aconst_null
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 4
    //   198: aconst_null
    //   199: astore 5
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 219	java/io/BufferedReader:close	()V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   221: aload_2
    //   222: ifnull +41 -> 263
    //   225: goto -135 -> 90
    //   228: aconst_null
    //   229: astore_2
    //   230: aconst_null
    //   231: astore 4
    //   233: aconst_null
    //   234: astore 5
    //   236: aload 5
    //   238: ifnull +8 -> 246
    //   241: aload 5
    //   243: invokevirtual 219	java/io/BufferedReader:close	()V
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   256: aload_2
    //   257: ifnull +6 -> 263
    //   260: goto -170 -> 90
    //   263: aconst_null
    //   264: areturn
    //   265: astore_2
    //   266: goto -38 -> 228
    //   269: astore_2
    //   270: goto -77 -> 193
    //   273: astore 4
    //   275: goto -126 -> 149
    //   278: astore 4
    //   280: goto -134 -> 146
    //   283: astore 5
    //   285: goto -156 -> 129
    //   288: astore 5
    //   290: goto -167 -> 123
    //   293: astore 6
    //   295: goto -59 -> 236
    //   298: astore 6
    //   300: goto -99 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	LBSAuthManager
    //   0	303	1	paramInt	int
    //   9	248	2	localObject1	Object
    //   265	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   269	1	2	localIOException1	IOException
    //   1	94	3	localObject2	Object
    //   96	1	3	localObject3	Object
    //   108	1	3	localObject4	Object
    //   135	1	3	localObject5	Object
    //   152	40	3	localObject6	Object
    //   57	195	4	localObject7	Object
    //   273	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   278	1	4	localIOException2	IOException
    //   68	174	5	localBufferedReader	java.io.BufferedReader
    //   283	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   288	1	5	localIOException3	IOException
    //   75	104	6	localObject8	Object
    //   293	1	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   298	1	6	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   70	77	96	finally
    //   59	70	108	finally
    //   49	59	135	finally
    //   2	49	152	finally
    //   2	49	265	java/io/FileNotFoundException
    //   2	49	269	java/io/IOException
    //   49	59	273	java/io/FileNotFoundException
    //   49	59	278	java/io/IOException
    //   59	70	283	java/io/FileNotFoundException
    //   59	70	288	java/io/IOException
    //   70	77	293	java/io/FileNotFoundException
    //   70	77	298	java/io/IOException
  }
  
  private String a(Context paramContext)
  {
    int i1 = Process.myPid();
    try
    {
      paramContext = a(i1);
    }
    catch (IOException paramContext)
    {
      label13:
      break label13;
    }
    paramContext = null;
    if (paramContext != null) {
      return paramContext;
    }
    return a.getPackageName();
  }
  
  private String a(Context paramContext, String paramString)
  {
    localObject1 = "";
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    Object localObject2 = paramContext.getPackageName();
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo((String)localObject2, 128).metaData;
      if (paramContext == null)
      {
        paramContext = (LBSAuthManagerListener)f.get(paramString);
        localObject2 = localObject1;
        if (paramContext != null)
        {
          paramContext.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
          return "";
        }
      }
      else
      {
        paramContext = paramContext.getString("com.baidu.lbsapi.API_KEY");
        if (paramContext == null) {}
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        label133:
        paramContext = (Context)localObject1;
      }
    }
    try
    {
      if (paramContext.equals(""))
      {
        localObject1 = (LBSAuthManagerListener)f.get(paramString);
        if (localObject1 != null) {
          ((LBSAuthManagerListener)localObject1).onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
        }
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label133;
    }
    paramString = (LBSAuthManagerListener)f.get(paramString);
    localObject2 = paramContext;
    if (paramString != null)
    {
      paramString.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
      localObject2 = paramContext;
    }
    return localObject2;
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {}
    try
    {
      localObject = g();
      paramString1 = this.n.obtainMessage();
      int i2 = -1;
      int i1 = i2;
      try
      {
        localObject = new JSONObject((String)localObject);
        i1 = i2;
        if (!((JSONObject)localObject).has("status"))
        {
          i1 = i2;
          ((JSONObject)localObject).put("status", -1);
        }
        i1 = i2;
        if (!((JSONObject)localObject).has("current"))
        {
          i1 = i2;
          ((JSONObject)localObject).put("current", System.currentTimeMillis());
        }
        i1 = i2;
        c(((JSONObject)localObject).toString());
        i1 = i2;
        if (((JSONObject)localObject).has("current"))
        {
          i1 = i2;
          ((JSONObject)localObject).remove("current");
        }
        i1 = i2;
        i2 = ((JSONObject)localObject).getInt("status");
        i1 = i2;
        paramString1.what = i2;
        i1 = i2;
        paramString1.obj = ((JSONObject)localObject).toString();
        i1 = i2;
        localObject = new Bundle();
        i1 = i2;
        ((Bundle)localObject).putString("listenerKey", paramString2);
        i1 = i2;
        paramString1.setData((Bundle)localObject);
        i1 = i2;
        this.n.sendMessage(paramString1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        paramString1.what = i1;
        paramString1.obj = new JSONObject();
        Bundle localBundle = new Bundle();
        localBundle.putString("listenerKey", paramString2);
        paramString1.setData(localBundle);
        this.n.sendMessage(paramString1);
      }
      paramString1 = d;
      if (paramString1 != null) {
        paramString1.c();
      }
      e -= 1;
      paramString1 = new StringBuilder();
      paramString1.append("httpRequest called mAuthCounter-- = ");
      paramString1.append(e);
      a.a(paramString1.toString());
      if (e == 0)
      {
        paramString1 = d;
        if (paramString1 != null)
        {
          paramString1.a();
          d = null;
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable paramHashtable, String paramString2)
  {
    Object localObject1 = a(a, paramString2);
    HashMap localHashMap;
    if (localObject1 != null)
    {
      if (((String)localObject1).equals("")) {
        return;
      }
      localHashMap = new HashMap();
      localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
      a.a("url:https://api.map.baidu.com/sdkcs/verify");
      localHashMap.put("output", "json");
      localHashMap.put("ak", localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ak:");
      ((StringBuilder)localObject2).append((String)localObject1);
      a.a(((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(k)) {
        localObject1 = k;
      } else {
        localObject1 = b.a(a);
      }
      localHashMap.put("mcode", localObject1);
      localHashMap.put("from", "lbs_yunsdk");
      if ((paramHashtable != null) && (paramHashtable.size() > 0))
      {
        paramHashtable = paramHashtable.entrySet().iterator();
        while (paramHashtable.hasNext())
        {
          localObject2 = (Map.Entry)paramHashtable.next();
          localObject1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
      paramHashtable = getCUID();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cuid:");
      ((StringBuilder)localObject1).append(paramHashtable);
      a.a(((StringBuilder)localObject1).toString());
      if (!TextUtils.isEmpty(paramHashtable)) {
        localHashMap.put("cuid", paramHashtable);
      } else {
        localHashMap.put("cuid", "");
      }
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.25");
      localHashMap.put("macaddr", "");
    }
    try
    {
      paramHashtable = b.a();
    }
    catch (Exception paramHashtable)
    {
      label366:
      int i1;
      break label366;
    }
    paramHashtable = "";
    if (!TextUtils.isEmpty(paramHashtable)) {
      localHashMap.put("language", paramHashtable);
    } else {
      localHashMap.put("language", "");
    }
    if (paramBoolean)
    {
      if (paramBoolean)
      {
        paramHashtable = new StringBuilder();
        i1 = 1;
      }
      else
      {
        paramHashtable = new StringBuilder();
        i1 = 0;
      }
      paramHashtable.append(i1);
      paramHashtable.append("");
      localHashMap.put("force", paramHashtable.toString());
    }
    if (paramString1 == null) {
      localHashMap.put("from_service", "");
    } else {
      localHashMap.put("from_service", paramString1);
    }
    paramString1 = f();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("extend", paramString1);
    }
    paramString1 = new c(a);
    this.b = paramString1;
    paramString1.a(localHashMap, new k(this, paramString2));
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable paramHashtable, String[] paramArrayOfString, String paramString2)
  {
    Object localObject1 = a(a, paramString2);
    HashMap localHashMap;
    if (localObject1 != null)
    {
      if (((String)localObject1).equals("")) {
        return;
      }
      localHashMap = new HashMap();
      localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
      localHashMap.put("output", "json");
      localHashMap.put("ak", localObject1);
      localHashMap.put("from", "lbs_yunsdk");
      if ((paramHashtable != null) && (paramHashtable.size() > 0))
      {
        paramHashtable = paramHashtable.entrySet().iterator();
        while (paramHashtable.hasNext())
        {
          Object localObject2 = (Map.Entry)paramHashtable.next();
          localObject1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
      paramHashtable = getCUID();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendAuthRequests : cuid: ");
      ((StringBuilder)localObject1).append(paramHashtable);
      a.a(((StringBuilder)localObject1).toString());
      if (!TextUtils.isEmpty(paramHashtable)) {
        localHashMap.put("cuid", paramHashtable);
      } else {
        localHashMap.put("cuid", "");
      }
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.25");
      localHashMap.put("macaddr", "");
    }
    try
    {
      paramHashtable = b.a();
    }
    catch (Exception paramHashtable)
    {
      label290:
      int i1;
      break label290;
    }
    paramHashtable = "";
    if (!TextUtils.isEmpty(paramHashtable)) {
      localHashMap.put("language", paramHashtable);
    } else {
      localHashMap.put("language", "");
    }
    if (paramBoolean)
    {
      if (paramBoolean)
      {
        paramHashtable = new StringBuilder();
        i1 = 1;
      }
      else
      {
        paramHashtable = new StringBuilder();
        i1 = 0;
      }
      paramHashtable.append(i1);
      paramHashtable.append("");
      localHashMap.put("force", paramHashtable.toString());
    }
    if (paramString1 == null) {
      localHashMap.put("from_service", "");
    } else {
      localHashMap.put("from_service", paramString1);
    }
    paramString1 = f();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("extend", paramString1);
    }
    paramString1 = new e(a);
    this.c = paramString1;
    paramString1.a(localHashMap, paramArrayOfString, new l(this, paramString2));
  }
  
  private boolean b(String paramString)
  {
    String str = a(a, paramString);
    paramString = g();
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("ak")) {
        return true;
      }
      paramString = paramString.getString("ak");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = "";
    }
    return (str != null) && (paramString != null) && (!str.equals(paramString));
  }
  
  private void c(String paramString)
  {
    Context localContext = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authStatus_");
    localStringBuilder.append(a(a));
    localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("status", paramString).commit();
  }
  
  private void e()
  {
    try
    {
      if (d == null)
      {
        Object localObject1 = new m("auth");
        d = (m)localObject1;
        ((Thread)localObject1).start();
        for (;;)
        {
          localObject1 = d.a;
          if (localObject1 != null) {
            break;
          }
          try
          {
            a.a("wait for create auth thread.");
            Thread.sleep(3L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private String f()
  {
    Object localObject = g();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (!((JSONObject)localObject).has("extend")) {
        return "";
      }
      localObject = ((JSONObject)localObject).getString("extend");
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  private String g()
  {
    Context localContext = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("authStatus_");
    localStringBuilder.append(a(a));
    return localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("status", "{\"status\":601}");
  }
  
  public static LBSAuthManager getInstance(Context paramContext)
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new LBSAuthManager(paramContext);
        }
      }
      finally {}
    } else if (paramContext == null)
    {
      if (a.a)
      {
        a.c("input context is null");
        new RuntimeException("here").printStackTrace();
      }
    }
    else {
      a = paramContext;
    }
    return g;
  }
  
  public int authenticate(boolean paramBoolean, String paramString, Hashtable paramHashtable, LBSAuthManagerListener paramLBSAuthManagerListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramHashtable != null) {}
    try
    {
      Object localObject = (String)paramHashtable.get("zero_auth");
      if (localObject == null)
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (Integer.valueOf((String)localObject).intValue() == 1) {
          bool1 = true;
        }
      }
      this.h = bool1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      if (paramLBSAuthManagerListener != null) {
        f.put(localObject, paramLBSAuthManagerListener);
      }
      paramLBSAuthManagerListener = a(a, (String)localObject);
      if ((paramLBSAuthManagerListener != null) && (!paramLBSAuthManagerListener.equals("")))
      {
        e += 1;
        paramLBSAuthManagerListener = new StringBuilder();
        paramLBSAuthManagerListener.append(" mAuthCounter  ++ = ");
        paramLBSAuthManagerListener.append(e);
        a.a(paramLBSAuthManagerListener.toString());
        paramLBSAuthManagerListener = g();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAuthMessage from cache:");
        localStringBuilder.append(paramLBSAuthManagerListener);
        a.a(localStringBuilder.toString());
        int i1 = a(paramLBSAuthManagerListener);
        if (i1 == 601) {
          try
          {
            c(new JSONObject().put("status", 602).toString());
          }
          catch (JSONException paramLBSAuthManagerListener)
          {
            paramLBSAuthManagerListener.printStackTrace();
          }
        }
        e();
        paramLBSAuthManagerListener = d;
        if ((paramLBSAuthManagerListener != null) && (paramLBSAuthManagerListener.a != null))
        {
          paramLBSAuthManagerListener = new StringBuilder();
          paramLBSAuthManagerListener.append("mThreadLooper.mHandler = ");
          paramLBSAuthManagerListener.append(d.a);
          a.a(paramLBSAuthManagerListener.toString());
          d.a.post(new j(this, i1, paramBoolean, (String)localObject, paramString, paramHashtable));
          return i1;
        }
        return -1;
      }
      return 101;
    }
    finally {}
  }
  
  public String getCUID()
  {
    Object localObject1 = a;
    String str1 = "";
    if (localObject1 == null) {
      return "";
    }
    localObject1 = str1;
    try
    {
      Object localObject2 = new StringBuilder();
      localObject1 = str1;
      ((StringBuilder)localObject2).append("mIsPrivacyMode ");
      localObject1 = str1;
      ((StringBuilder)localObject2).append(m);
      localObject1 = str1;
      a.a(((StringBuilder)localObject2).toString());
      localObject1 = str1;
      if (m)
      {
        localObject1 = str1;
        str1 = com.baidu.a.a.a.a.a.a(a);
        localObject1 = str1;
        localObject2 = new StringBuilder();
        localObject1 = str1;
        ((StringBuilder)localObject2).append("getCUID: ");
        localObject1 = str1;
        ((StringBuilder)localObject2).append(str1);
        localObject1 = str1;
        a.a(((StringBuilder)localObject2).toString());
        return str1;
      }
      localObject1 = str1;
      localObject2 = a.getSharedPreferences("Map_Privacy", 0);
      localObject1 = str1;
      if (((SharedPreferences)localObject2).contains("cuid"))
      {
        localObject1 = str1;
        return ((SharedPreferences)localObject2).getString("cuid", "");
      }
      localObject1 = str1;
      String str2 = n.a(UUID.randomUUID().toString().getBytes(), true);
      localObject1 = str1;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = str1;
      localStringBuilder.append(str2);
      localObject1 = str1;
      localStringBuilder.append("|MAPSDK001");
      localObject1 = str1;
      str1 = localStringBuilder.toString();
      localObject1 = str1;
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject1 = str1;
      ((SharedPreferences.Editor)localObject2).putString("cuid", str1);
      localObject1 = str1;
      ((SharedPreferences.Editor)localObject2).apply();
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject1;
  }
  
  public String getKey()
  {
    Object localObject = a;
    if (localObject == null) {
      return "";
    }
    try
    {
      localObject = getPublicKey((Context)localObject);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public String getMCode()
  {
    if (a == null) {
      return "";
    }
    if (!TextUtils.isEmpty(k)) {
      return k;
    }
    return b.a(a);
  }
  
  public boolean getPrivacyMode()
  {
    return m;
  }
  
  public String getPublicKey(Context paramContext)
  {
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    String str = paramContext.getPackageName();
    return paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.getString("com.baidu.lbsapi.API_KEY");
  }
  
  public void setKey(String paramString)
  {
    if (a != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      i = paramString;
    }
  }
  
  public void setMCode(String paramString)
  {
    k = paramString;
  }
  
  public void setMCodes(String[] paramArrayOfString)
  {
    l = paramArrayOfString;
  }
  
  public void setPackageName(String paramString)
  {
    j = paramString;
  }
  
  public void setPrivacyMode(boolean paramBoolean)
  {
    Object localObject = a;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("Map_Privacy", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    if (paramBoolean)
    {
      localEditor.putBoolean("privacyMode", paramBoolean);
      localEditor.apply();
    }
    else
    {
      paramBoolean = ((SharedPreferences)localObject).getBoolean("privacyMode", false);
    }
    m = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.LBSAuthManager
 * JD-Core Version:    0.7.0.1
 */