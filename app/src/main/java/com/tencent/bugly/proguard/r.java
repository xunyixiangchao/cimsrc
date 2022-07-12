package com.tencent.bugly.proguard;

import android.util.Pair;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  /* Error */
  private Pair<Integer, String> a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_m1
    //   4: istore 5
    //   6: new 15	java/net/URL
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 18	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 22	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 24	java/net/HttpURLConnection
    //   20: astore_1
    //   21: iload 5
    //   23: istore 4
    //   25: aload_1
    //   26: ldc 26
    //   28: invokevirtual 29	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   31: iload 5
    //   33: istore 4
    //   35: aload_1
    //   36: iconst_1
    //   37: invokevirtual 33	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   40: iload 5
    //   42: istore 4
    //   44: aload_1
    //   45: iconst_1
    //   46: invokevirtual 36	java/net/HttpURLConnection:setDoInput	(Z)V
    //   49: iload 5
    //   51: istore 4
    //   53: aload_1
    //   54: iconst_0
    //   55: invokevirtual 39	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   58: iload 5
    //   60: istore 4
    //   62: aload_1
    //   63: ldc 41
    //   65: ldc 43
    //   67: invokevirtual 47	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iload 5
    //   72: istore 4
    //   74: aload_1
    //   75: aload_3
    //   76: invokestatic 50	com/tencent/bugly/proguard/r:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   79: iload 5
    //   81: istore 4
    //   83: aload_1
    //   84: sipush 5000
    //   87: invokevirtual 54	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   90: iload 5
    //   92: istore 4
    //   94: aload_1
    //   95: sipush 5000
    //   98: invokevirtual 57	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   101: iload 5
    //   103: istore 4
    //   105: aload_1
    //   106: invokevirtual 60	java/net/HttpURLConnection:connect	()V
    //   109: iload 5
    //   111: istore 4
    //   113: aload_2
    //   114: ldc 62
    //   116: invokevirtual 68	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   119: astore_2
    //   120: iload 5
    //   122: istore 4
    //   124: new 70	java/io/DataOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokevirtual 74	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   132: invokespecial 77	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 7
    //   137: aload 7
    //   139: aload_2
    //   140: invokevirtual 81	java/io/DataOutputStream:write	([B)V
    //   143: aload 7
    //   145: invokevirtual 84	java/io/DataOutputStream:flush	()V
    //   148: aload 7
    //   150: invokevirtual 87	java/io/DataOutputStream:close	()V
    //   153: iload 5
    //   155: istore 4
    //   157: aload_1
    //   158: invokevirtual 91	java/net/HttpURLConnection:getResponseCode	()I
    //   161: istore 5
    //   163: iload 5
    //   165: sipush 400
    //   168: if_icmplt +15 -> 183
    //   171: iload 5
    //   173: istore 4
    //   175: aload_1
    //   176: invokevirtual 95	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   179: astore_2
    //   180: goto +12 -> 192
    //   183: iload 5
    //   185: istore 4
    //   187: aload_1
    //   188: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   191: astore_2
    //   192: new 100	java/io/BufferedReader
    //   195: dup
    //   196: new 102	java/io/InputStreamReader
    //   199: dup
    //   200: aload_2
    //   201: ldc 62
    //   203: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   206: invokespecial 108	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   209: astore_3
    //   210: new 110	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   217: astore 7
    //   219: aload_3
    //   220: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 8
    //   225: aload 8
    //   227: ifnull +22 -> 249
    //   230: aload 7
    //   232: aload 8
    //   234: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 7
    //   240: ldc 121
    //   242: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: goto -27 -> 219
    //   249: aload_3
    //   250: invokevirtual 122	java/io/BufferedReader:close	()V
    //   253: aload 7
    //   255: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_3
    //   259: aload_2
    //   260: ifnonnull +6 -> 266
    //   263: goto +18 -> 281
    //   266: aload_2
    //   267: invokeinterface 128 1 0
    //   272: goto +9 -> 281
    //   275: astore_2
    //   276: aload_2
    //   277: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   280: pop
    //   281: aload_1
    //   282: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   285: iload 5
    //   287: istore 4
    //   289: aload_3
    //   290: astore_1
    //   291: goto +120 -> 411
    //   294: astore_3
    //   295: aload_1
    //   296: astore 7
    //   298: aload_2
    //   299: astore_1
    //   300: iload 5
    //   302: istore 4
    //   304: aload 7
    //   306: astore_2
    //   307: goto +36 -> 343
    //   310: astore_3
    //   311: aload_1
    //   312: astore_2
    //   313: aconst_null
    //   314: astore_1
    //   315: aload 7
    //   317: astore 6
    //   319: iload 5
    //   321: istore 4
    //   323: goto +20 -> 343
    //   326: astore_3
    //   327: aload_1
    //   328: astore_2
    //   329: aconst_null
    //   330: astore_1
    //   331: goto +12 -> 343
    //   334: astore_3
    //   335: aconst_null
    //   336: astore_1
    //   337: aload_1
    //   338: astore_2
    //   339: iload 5
    //   341: istore 4
    //   343: aload_3
    //   344: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   347: pop
    //   348: aload_3
    //   349: invokevirtual 142	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   352: astore_3
    //   353: aload 6
    //   355: ifnonnull +6 -> 361
    //   358: goto +21 -> 379
    //   361: aload 6
    //   363: invokeinterface 128 1 0
    //   368: goto +11 -> 379
    //   371: astore 6
    //   373: aload 6
    //   375: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   378: pop
    //   379: aload_1
    //   380: ifnonnull +6 -> 386
    //   383: goto +18 -> 401
    //   386: aload_1
    //   387: invokeinterface 128 1 0
    //   392: goto +9 -> 401
    //   395: astore_1
    //   396: aload_1
    //   397: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   400: pop
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   409: aload_3
    //   410: astore_1
    //   411: new 144	android/util/Pair
    //   414: dup
    //   415: iload 4
    //   417: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aload_1
    //   421: invokespecial 153	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   424: areturn
    //   425: astore_3
    //   426: aload 6
    //   428: ifnonnull +6 -> 434
    //   431: goto +21 -> 452
    //   434: aload 6
    //   436: invokeinterface 128 1 0
    //   441: goto +11 -> 452
    //   444: astore 6
    //   446: aload 6
    //   448: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   451: pop
    //   452: aload_1
    //   453: ifnonnull +6 -> 459
    //   456: goto +18 -> 474
    //   459: aload_1
    //   460: invokeinterface 128 1 0
    //   465: goto +9 -> 474
    //   468: astore_1
    //   469: aload_1
    //   470: invokestatic 134	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   473: pop
    //   474: aload_2
    //   475: ifnull +7 -> 482
    //   478: aload_2
    //   479: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   482: aload_3
    //   483: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	r
    //   0	484	1	paramString1	String
    //   0	484	2	paramString2	String
    //   0	484	3	paramMap	Map<String, String>
    //   23	393	4	i	int
    //   4	336	5	j	int
    //   1	361	6	localObject1	Object
    //   371	64	6	localException1	java.lang.Exception
    //   444	3	6	localException2	java.lang.Exception
    //   135	181	7	localObject2	Object
    //   223	10	8	str	String
    // Exception table:
    //   from	to	target	type
    //   266	272	275	java/lang/Exception
    //   192	219	294	finally
    //   219	225	294	finally
    //   230	246	294	finally
    //   249	259	294	finally
    //   137	153	310	finally
    //   25	31	326	finally
    //   35	40	326	finally
    //   44	49	326	finally
    //   53	58	326	finally
    //   62	70	326	finally
    //   74	79	326	finally
    //   83	90	326	finally
    //   94	101	326	finally
    //   105	109	326	finally
    //   113	120	326	finally
    //   124	137	326	finally
    //   157	163	326	finally
    //   175	180	326	finally
    //   187	192	326	finally
    //   6	21	334	finally
    //   361	368	371	java/lang/Exception
    //   386	392	395	java/lang/Exception
    //   343	353	425	finally
    //   434	441	444	java/lang/Exception
    //   459	465	468	java/lang/Exception
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
  {
    if ((paramHttpURLConnection != null) && (paramMap != null))
    {
      if (paramMap.isEmpty()) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final Pair<Integer, String> a(List<String> paramList)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("Atta-Type", "batch-report");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("attaid", "0d000062340").put("token", "2273782735").put("type", "batch").put("version", "v1.0.0");
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      localJSONObject.put("datas", localJSONArray);
      paramList = a("https://h.trace.qq.com/kv", localJSONObject.toString(), localHashMap);
      return paramList;
    }
    finally
    {
      y.b(paramList);
    }
    return new Pair(Integer.valueOf(-1), paramList.getMessage());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.r
 * JD-Core Version:    0.7.0.1
 */