package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static List<File> a = new ArrayList();
  
  /* Error */
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +289 -> 293
    //   7: aload_1
    //   8: ifnull +285 -> 293
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: goto +278 -> 293
    //   18: new 22	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: ldc 24
    //   25: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 31	java/io/File:exists	()Z
    //   33: ifeq +258 -> 291
    //   36: aload_1
    //   37: invokevirtual 34	java/io/File:canRead	()Z
    //   40: ifne +5 -> 45
    //   43: aconst_null
    //   44: areturn
    //   45: new 36	java/io/BufferedInputStream
    //   48: dup
    //   49: new 38	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_1
    //   63: aload_3
    //   64: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +132 -> 203
    //   74: aload_3
    //   75: astore_1
    //   76: aload 4
    //   78: ldc 49
    //   80: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +6 -> 89
    //   86: goto +117 -> 203
    //   89: aload_3
    //   90: astore_1
    //   91: new 57	java/util/HashMap
    //   94: dup
    //   95: invokespecial 58	java/util/HashMap:<init>	()V
    //   98: astore 6
    //   100: goto +205 -> 305
    //   103: aload_3
    //   104: astore_1
    //   105: aload_3
    //   106: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +32 -> 145
    //   116: aload 4
    //   118: ifnonnull +10 -> 128
    //   121: aload 5
    //   123: astore 4
    //   125: goto -22 -> 103
    //   128: aload_3
    //   129: astore_1
    //   130: aload 6
    //   132: aload 4
    //   134: aload 5
    //   136: invokeinterface 64 3 0
    //   141: pop
    //   142: goto +163 -> 305
    //   145: aload 4
    //   147: ifnull +33 -> 180
    //   150: aload_3
    //   151: astore_1
    //   152: ldc 66
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload 4
    //   162: aastore
    //   163: invokestatic 72	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_3
    //   168: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_3
    //   181: astore_1
    //   182: aload_0
    //   183: aload 6
    //   185: aload_2
    //   186: invokestatic 81	com/tencent/bugly/crashreport/crash/jni/b:a	(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   189: astore_0
    //   190: aload_3
    //   191: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   194: aload_0
    //   195: areturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   201: aload_0
    //   202: areturn
    //   203: aload_3
    //   204: astore_1
    //   205: ldc 83
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 4
    //   215: aastore
    //   216: invokestatic 72	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_3
    //   221: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_2
    //   234: aload_3
    //   235: astore_0
    //   236: goto +13 -> 249
    //   239: astore_0
    //   240: aload 4
    //   242: astore_1
    //   243: goto +30 -> 273
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_0
    //   249: aload_0
    //   250: astore_1
    //   251: aload_2
    //   252: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   255: aload_0
    //   256: ifnull +14 -> 270
    //   259: aload_0
    //   260: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: aload_1
    //   274: ifnull +15 -> 289
    //   277: aload_1
    //   278: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   289: aload_0
    //   290: athrow
    //   291: aconst_null
    //   292: areturn
    //   293: ldc 85
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 72	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   302: pop
    //   303: aconst_null
    //   304: areturn
    //   305: aconst_null
    //   306: astore 4
    //   308: goto -205 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramContext	Context
    //   0	311	1	paramString	String
    //   0	311	2	paramNativeExceptionHandler	NativeExceptionHandler
    //   60	175	3	localBufferedInputStream	java.io.BufferedInputStream
    //   1	306	4	localObject	Object
    //   109	26	5	str	String
    //   98	86	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   167	171	173	java/io/IOException
    //   190	194	196	java/io/IOException
    //   220	224	226	java/io/IOException
    //   63	69	233	java/io/IOException
    //   76	86	233	java/io/IOException
    //   91	100	233	java/io/IOException
    //   105	111	233	java/io/IOException
    //   130	142	233	java/io/IOException
    //   152	167	233	java/io/IOException
    //   182	190	233	java/io/IOException
    //   205	220	233	java/io/IOException
    //   45	61	239	finally
    //   45	61	246	java/io/IOException
    //   259	263	265	java/io/IOException
    //   63	69	272	finally
    //   76	86	272	finally
    //   91	100	272	finally
    //   105	111	272	finally
    //   130	142	272	finally
    //   152	167	272	finally
    //   182	190	272	finally
    //   205	220	272	finally
    //   251	255	272	finally
    //   277	281	284	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler)
  {
    if (paramMap == null) {}
    int i;
    for (;;)
    {
      i = 0;
      break;
      if (a.a(paramContext) == null)
      {
        y.e("abnormal com info not created", new Object[0]);
      }
      else
      {
        paramContext = (String)paramMap.get("intStateStr");
        if ((paramContext != null) && (paramContext.trim().length() > 0))
        {
          i = 1;
          break;
        }
        y.e("no intStateStr", new Object[0]);
      }
    }
    if (i == 0) {
      return null;
    }
    Object localObject6 = d((String)paramMap.get("intStateStr"));
    if (localObject6 == null)
    {
      y.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    }
    for (;;)
    {
      try
      {
        ((Integer)((Map)localObject6).get("sino")).intValue();
        ((Integer)((Map)localObject6).get("sud")).intValue();
        String str3 = (String)paramMap.get("soVersion");
        if (TextUtils.isEmpty(str3))
        {
          y.e("error format at version", new Object[0]);
          return null;
        }
        String str2 = (String)a(paramMap, "codeMsg", "unknown");
        String str1 = (String)a(paramMap, "signalName", "unknown");
        paramMap.get("errnoMsg");
        localObject1 = (String)a(paramMap, "stack", "unknown");
        Object localObject2 = (String)paramMap.get("jstack");
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          paramContext = new StringBuilder();
          paramContext.append((String)localObject1);
          paramContext.append("java:\n");
          paramContext.append((String)localObject2);
          paramContext = paramContext.toString();
        }
        localObject1 = (Integer)((Map)localObject6).get("sico");
        if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(")");
          str1 = ((StringBuilder)localObject1).toString();
          str2 = "KERNEL";
          localObject1 = (String)paramMap.get("nativeLog");
          if ((localObject1 == null) || (((String)localObject1).isEmpty())) {
            break label986;
          }
          localObject1 = ab.a(null, (String)localObject1, "BuglyNativeLog.txt");
          Object localObject3 = (String)a(paramMap, "sendingProcess", "unknown");
          Object localObject4 = (Integer)((Map)localObject6).get("spd");
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(localObject4);
            ((StringBuilder)localObject2).append(")");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject4 = (String)a(paramMap, "threadName", "unknown");
          Object localObject5 = (Integer)((Map)localObject6).get("et");
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject4);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(localObject5);
            ((StringBuilder)localObject3).append(")");
            localObject3 = ((StringBuilder)localObject3).toString();
          }
          localObject5 = (String)a(paramMap, "processName", "unknown");
          Object localObject7 = (Integer)((Map)localObject6).get("ep");
          localObject4 = localObject5;
          if (localObject7 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject5);
            ((StringBuilder)localObject4).append("(");
            ((StringBuilder)localObject4).append(localObject7);
            ((StringBuilder)localObject4).append(")");
            localObject4 = ((StringBuilder)localObject4).toString();
          }
          localObject5 = a(paramMap);
          long l1 = ((Integer)((Map)localObject6).get("ets")).intValue();
          long l2 = ((Integer)((Map)localObject6).get("etms")).intValue() / 1000L;
          localObject6 = (String)a(paramMap, "errorAddr", "unknown");
          paramContext = a(paramContext);
          localObject7 = (String)paramMap.get("sysLogPath");
          String str4 = (String)paramMap.get("jniLogPath");
          paramContext = paramNativeExceptionHandler.packageCrashDatas((String)localObject4, (String)localObject3, l1 * 1000L + l2, str1, (String)localObject6, paramContext, str2, (String)localObject2, (String)a(paramMap, "tombPath", "unknown"), (String)localObject7, str4, str3, (byte[])localObject1, (Map)localObject5, false, false);
          if (paramContext != null)
          {
            paramNativeExceptionHandler = (String)a(paramMap, "userId", paramContext.m);
            paramContext.m = paramNativeExceptionHandler;
            y.c("[Native record info] userId: %s", new Object[] { paramNativeExceptionHandler });
            paramNativeExceptionHandler = (String)a(paramMap, "sysLog", paramContext.w);
            paramContext.w = paramNativeExceptionHandler;
            paramNativeExceptionHandler = (String)a(paramMap, "appVersion", paramNativeExceptionHandler);
            paramContext.f = paramNativeExceptionHandler;
            y.c("[Native record info] appVersion: %s", new Object[] { paramNativeExceptionHandler });
            paramNativeExceptionHandler = (String)paramMap.get("isAppForeground");
            if (paramNativeExceptionHandler == null) {
              break label992;
            }
            y.c("[Native record info] isAppForeground: %s", new Object[] { paramNativeExceptionHandler });
            bool = paramNativeExceptionHandler.equalsIgnoreCase("true");
            paramContext.Q = bool;
            paramContext.P = b(paramMap);
            paramContext.z = null;
            paramContext.k = true;
          }
          return paramContext;
        }
      }
      finally
      {
        y.e("error format", new Object[0]);
        paramContext.printStackTrace();
        return null;
      }
      continue;
      label986:
      Object localObject1 = null;
      continue;
      label992:
      boolean bool = false;
    }
  }
  
  private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> paramMap, KeyT paramKeyT, ValueT paramValueT)
  {
    try
    {
      paramMap = paramMap.get(paramKeyT);
      if (paramMap != null) {
        return paramMap;
      }
    }
    catch (Exception paramMap)
    {
      y.a(paramMap);
    }
    return paramValueT;
  }
  
  /* Error */
  private static String a(java.io.BufferedInputStream paramBufferedInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 296	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 299	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 302	java/io/BufferedInputStream:read	()I
    //   21: istore_1
    //   22: aload_2
    //   23: astore_3
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +58 -> 84
    //   29: iload_1
    //   30: ifne +24 -> 54
    //   33: new 51	java/lang/String
    //   36: dup
    //   37: aload_2
    //   38: invokevirtual 306	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: ldc_w 308
    //   44: invokespecial 311	java/lang/String:<init>	([BLjava/lang/String;)V
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 312	java/io/ByteArrayOutputStream:close	()V
    //   52: aload_0
    //   53: areturn
    //   54: aload_2
    //   55: iload_1
    //   56: invokevirtual 315	java/io/ByteArrayOutputStream:write	(I)V
    //   59: goto -42 -> 17
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: astore_2
    //   67: goto +6 -> 73
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_2
    //   74: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   77: pop
    //   78: aload_0
    //   79: ifnull +9 -> 88
    //   82: aload_0
    //   83: astore_3
    //   84: aload_3
    //   85: invokevirtual 312	java/io/ByteArrayOutputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_2
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 312	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramBufferedInputStream	java.io.BufferedInputStream
    //   21	35	1	i	int
    //   16	51	2	localObject1	Object
    //   70	4	2	localThrowable	Throwable
    //   90	10	2	localObject2	Object
    //   23	1	3	localObject3	Object
    //   62	4	3	localObject4	Object
    //   83	2	3	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   17	22	62	finally
    //   33	48	62	finally
    //   54	59	62	finally
    //   6	17	70	finally
    //   73	78	90	finally
  }
  
  protected static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String[] arrayOfString = paramString.split("\n");
    String str = paramString;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return paramString;
      }
      paramString = new StringBuilder();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!str.contains("java.lang.Thread.getStackTrace("))
        {
          paramString.append(str);
          paramString.append("\n");
        }
        i += 1;
      }
      str = paramString.toString();
    }
    return str;
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +385 -> 389
    //   7: iload_1
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 22	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: aload 6
    //   25: invokevirtual 31	java/io/File:exists	()Z
    //   28: ifeq +361 -> 389
    //   31: aload 6
    //   33: invokevirtual 34	java/io/File:canRead	()Z
    //   36: ifne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: ldc_w 334
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload 6
    //   52: invokevirtual 337	java/io/File:length	()J
    //   55: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload 6
    //   63: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 347	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   70: pop
    //   71: getstatic 16	com/tencent/bugly/crashreport/crash/jni/b:a	Ljava/util/List;
    //   74: aload 6
    //   76: invokeinterface 352 2 0
    //   81: pop
    //   82: ldc_w 354
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 240	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_2
    //   94: ifnonnull +17 -> 111
    //   97: new 22	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: iload_1
    //   106: iload_3
    //   107: invokestatic 357	com/tencent/bugly/proguard/ab:a	(Ljava/io/File;IZ)Ljava/lang/String;
    //   110: areturn
    //   111: new 157	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   118: astore 5
    //   120: new 359	java/io/BufferedReader
    //   123: dup
    //   124: new 361	java/io/InputStreamReader
    //   127: dup
    //   128: new 38	java/io/FileInputStream
    //   131: dup
    //   132: aload 6
    //   134: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: ldc_w 363
    //   140: invokespecial 366	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   143: invokespecial 369	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 372	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +113 -> 268
    //   158: new 157	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   165: astore 6
    //   167: aload 6
    //   169: aload_2
    //   170: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: ldc_w 374
    //   179: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 380	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   191: aload 4
    //   193: invokevirtual 384	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   196: invokevirtual 389	java/util/regex/Matcher:find	()Z
    //   199: ifeq +20 -> 219
    //   202: aload 5
    //   204: aload 4
    //   206: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 5
    //   212: ldc_w 319
    //   215: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: iload_1
    //   220: ifle -73 -> 147
    //   223: aload 5
    //   225: invokevirtual 390	java/lang/StringBuilder:length	()I
    //   228: iload_1
    //   229: if_icmple -82 -> 147
    //   232: iload_3
    //   233: ifeq +18 -> 251
    //   236: aload 5
    //   238: iload_1
    //   239: aload 5
    //   241: invokevirtual 390	java/lang/StringBuilder:length	()I
    //   244: invokevirtual 394	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: goto +20 -> 268
    //   251: aload 5
    //   253: iconst_0
    //   254: aload 5
    //   256: invokevirtual 390	java/lang/StringBuilder:length	()I
    //   259: iload_1
    //   260: isub
    //   261: invokevirtual 394	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: goto -118 -> 147
    //   268: aload 5
    //   270: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 4
    //   275: aload 4
    //   277: astore_2
    //   278: aload_0
    //   279: invokevirtual 395	java/io/BufferedReader:close	()V
    //   282: aload 4
    //   284: areturn
    //   285: astore_0
    //   286: aload_0
    //   287: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   290: pop
    //   291: aload_2
    //   292: areturn
    //   293: astore_2
    //   294: goto +7 -> 301
    //   297: astore_2
    //   298: aload 4
    //   300: astore_0
    //   301: aload_2
    //   302: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   305: pop
    //   306: new 157	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 397
    //   313: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: astore 4
    //   318: aload 4
    //   320: aload_2
    //   321: invokevirtual 399	java/lang/Throwable:toString	()Ljava/lang/String;
    //   324: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 4
    //   330: ldc_w 401
    //   333: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 5
    //   339: aload 4
    //   341: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 5
    //   350: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: astore 4
    //   355: aload_0
    //   356: ifnull +10 -> 366
    //   359: aload 4
    //   361: astore_2
    //   362: aload_0
    //   363: invokevirtual 395	java/io/BufferedReader:close	()V
    //   366: aload 4
    //   368: areturn
    //   369: astore_2
    //   370: aload_0
    //   371: ifnull +16 -> 387
    //   374: aload_0
    //   375: invokevirtual 395	java/io/BufferedReader:close	()V
    //   378: goto +9 -> 387
    //   381: astore_0
    //   382: aload_0
    //   383: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   386: pop
    //   387: aload_2
    //   388: athrow
    //   389: aconst_null
    //   390: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramInt	int
    //   0	391	2	paramString2	String
    //   0	391	3	paramBoolean	boolean
    //   1	366	4	localObject1	Object
    //   118	231	5	localStringBuilder	StringBuilder
    //   21	163	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   278	282	285	java/lang/Exception
    //   362	366	285	java/lang/Exception
    //   147	153	293	finally
    //   158	219	293	finally
    //   223	232	293	finally
    //   236	248	293	finally
    //   251	265	293	finally
    //   268	275	293	finally
    //   120	147	297	finally
    //   301	355	369	finally
    //   374	378	381	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = b(paramString1, paramString2);
      if ((str != null) && (!str.isEmpty()))
      {
        localStringBuilder.append("Register infos:\n");
        localStringBuilder.append(str);
      }
      paramString1 = c(paramString1, paramString2);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("System SO infos:\n");
        localStringBuilder.append(paramString1);
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject = (String)paramMap.get("key-value");
    if (localObject != null)
    {
      paramMap = new HashMap();
      localObject = ((String)localObject).split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split("=");
        if (arrayOfString.length == 2) {
          paramMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
      return paramMap;
    }
    return null;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramString != null)
    {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean) {
        c(paramString);
      }
    }
    paramString = a;
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = a.iterator();
      while (paramString.hasNext())
      {
        File localFile = (File)paramString.next();
        if ((localFile.exists()) && (localFile.canWrite()))
        {
          localFile.delete();
          y.c("Delete record file %s", new Object[] { localFile.getAbsoluteFile() });
        }
      }
    }
  }
  
  private static long b(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("launchTime");
    if (paramMap != null)
    {
      y.c("[Native record info] launchTime: %s", new Object[] { paramMap });
      try
      {
        long l = Long.parseLong(paramMap);
        return l;
      }
      catch (NumberFormatException paramMap)
      {
        if (!y.a(paramMap)) {
          paramMap.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString, "backup_record.txt");
    if (paramString.exists()) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    localBufferedReader = ab.a(paramString1, "reg_record.txt");
    if (localBufferedReader == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        paramString1 = localBufferedReader.readLine();
        if (paramString1 == null) {
          continue;
        }
        if (paramString1.startsWith(paramString2)) {
          continue;
        }
      }
      finally
      {
        try
        {
          StringBuilder localStringBuilder;
          y.a(paramString1);
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            y.a(paramString1);
            return null;
          }
          int i = 18;
        }
        finally
        {
          try
          {
            localBufferedReader.close();
          }
          catch (Exception paramString2)
          {
            y.a(paramString2);
          }
        }
        int j = 0;
        int k = j;
        continue;
        paramString1 = "  ";
        continue;
      }
      paramString2 = localBufferedReader.readLine();
      if (paramString2 == null) {
        continue;
      }
      if (j % 4 == 0)
      {
        if (j <= 0) {
          continue;
        }
        localStringBuilder.append("\n");
        continue;
        localStringBuilder.append(paramString1);
      }
      else
      {
        if (paramString2.length() > 16) {
          i = 28;
        }
        paramString1 = "                ".substring(0, i - k);
        continue;
      }
      k = paramString2.length();
      localStringBuilder.append(paramString2);
      j += 1;
    }
    localStringBuilder.append("\n");
    paramString1 = localStringBuilder.toString();
    try
    {
      localBufferedReader.close();
      return paramString1;
    }
    catch (Exception paramString2)
    {
      y.a(paramString2);
      return paramString1;
    }
    try
    {
      localBufferedReader.close();
      return null;
    }
    catch (Exception paramString1)
    {
      y.a(paramString1);
      return null;
    }
  }
  
  /* Error */
  private static String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 420
    //   4: invokestatic 466	com/tencent/bugly/proguard/ab:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 157	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 372	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +67 -> 95
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 469	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   36: ifne +6 -> 42
    //   39: goto +56 -> 95
    //   42: aload_0
    //   43: invokevirtual 372	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +28 -> 76
    //   51: aload_2
    //   52: ldc_w 477
    //   55: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc_w 319
    //   69: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -31 -> 42
    //   76: aload_2
    //   77: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_1
    //   81: aload_0
    //   82: invokevirtual 395	java/io/BufferedReader:close	()V
    //   85: aload_1
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   92: pop
    //   93: aload_1
    //   94: areturn
    //   95: aload_0
    //   96: invokevirtual 395	java/io/BufferedReader:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   106: pop
    //   107: aconst_null
    //   108: areturn
    //   109: astore_1
    //   110: aload_1
    //   111: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   114: pop
    //   115: aload_0
    //   116: invokevirtual 395	java/io/BufferedReader:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   126: pop
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: aload_0
    //   131: invokevirtual 395	java/io/BufferedReader:close	()V
    //   134: goto +9 -> 143
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic 293	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   142: pop
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString1	String
    //   0	145	1	paramString2	String
    //   21	56	2	localStringBuilder	StringBuilder
    //   26	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/lang/Exception
    //   95	99	101	java/lang/Exception
    //   14	27	109	finally
    //   31	39	109	finally
    //   42	47	109	finally
    //   51	73	109	finally
    //   76	81	109	finally
    //   115	119	121	java/lang/Exception
    //   110	115	129	finally
    //   130	134	137	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.canRead()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles();
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            if ((localObject.canRead()) && (localObject.canWrite()) && (localObject.length() == 0L))
            {
              localObject.delete();
              y.c("Delete empty record file %s", new Object[] { localObject.getAbsoluteFile() });
            }
            i += 1;
          }
        }
      }
      return;
    }
    finally
    {
      y.a(paramString);
    }
  }
  
  private static Map<String, Integer> d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      String[] arrayOfString1 = paramString.split(",");
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString1[i];
        String[] arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          y.e("error format at %s", new Object[] { str });
          return null;
        }
        int k = Integer.parseInt(arrayOfString2[1]);
        localHashMap.put(arrayOfString2[0], Integer.valueOf(k));
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      y.e("error format intStateStr %s", new Object[] { paramString });
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.b
 * JD-Core Version:    0.7.0.1
 */