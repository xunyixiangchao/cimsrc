package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private static final ArrayList<c> a = new a();
  private static final Map<Integer, String> b = new b();
  private static final String[] c = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramContext.getApplicationInfo() == null) {
        return "fail";
      }
      paramContext = paramContext.getApplicationInfo().nativeLibraryDir;
      if (TextUtils.isEmpty(paramContext)) {
        return "fail";
      }
      if (paramContext.endsWith("arm")) {
        return "armeabi-v7a";
      }
      if (paramContext.endsWith("arm64")) {
        return "arm64-v8a";
      }
      if (paramContext.endsWith("x86")) {
        return "x86";
      }
      if (paramContext.endsWith("x86_64")) {
        return "x86_64";
      }
    }
    return "fail";
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = System.getProperty("os.arch");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    finally
    {
      if (!y.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    String str = "unknown";
    Object localObject;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return null;
      }
      if (localNetworkInfo.getType() == 1) {
        return "WIFI";
      }
      localObject = str;
      if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        localObject = str;
        if (paramContext != null)
        {
          int i = paramContext.getNetworkType();
          paramContext = (String)b.get(Integer.valueOf(i));
          if (paramContext == null) {
            try
            {
              localObject = new StringBuilder("MOBILE(");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(")");
              localObject = ((StringBuilder)localObject).toString();
            }
            catch (Exception localException1)
            {
              break label132;
            }
          } else {
            localObject = paramContext;
          }
        }
      }
    }
    catch (Exception localException2)
    {
      paramContext = str;
      label132:
      localObject = paramContext;
      if (!y.a(localException2))
      {
        localException2.printStackTrace();
        localObject = paramContext;
      }
    }
    return localObject;
  }
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  public static String c(Context paramContext)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = ((c)localIterator.next()).a(paramContext);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return null;
  }
  
  public static long d()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static boolean d(Context paramContext)
  {
    return !TextUtils.isEmpty(new k((byte)0).a(paramContext));
  }
  
  public static long e()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static boolean e(Context paramContext)
  {
    return !TextUtils.isEmpty(new m((byte)0).a(paramContext));
  }
  
  public static long f()
  {
    return Debug.getPss() << 10;
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: new 298	java/io/BufferedReader
    //   5: dup
    //   6: new 300	java/io/FileReader
    //   9: dup
    //   10: ldc_w 302
    //   13: invokespecial 303	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 306	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore 6
    //   21: aload 6
    //   23: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore 7
    //   28: lload_2
    //   29: lstore_0
    //   30: aload 7
    //   32: ifnull +29 -> 61
    //   35: aload 7
    //   37: ldc_w 311
    //   40: invokevirtual 314	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   43: ifeq -22 -> 21
    //   46: aload 7
    //   48: ldc_w 316
    //   51: ldc_w 318
    //   54: invokevirtual 322	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 328	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: lstore_0
    //   61: lload_0
    //   62: lstore 4
    //   64: aload 6
    //   66: invokevirtual 331	java/io/BufferedReader:close	()V
    //   69: goto +49 -> 118
    //   72: astore 6
    //   74: aload 6
    //   76: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   79: lload 4
    //   81: lstore_0
    //   82: goto +36 -> 118
    //   85: astore 7
    //   87: goto +8 -> 95
    //   90: astore 7
    //   92: aconst_null
    //   93: astore 6
    //   95: aload 7
    //   97: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   100: pop
    //   101: lload_2
    //   102: lstore_0
    //   103: aload 6
    //   105: ifnull +13 -> 118
    //   108: lload_2
    //   109: lstore 4
    //   111: aload 6
    //   113: invokevirtual 331	java/io/BufferedReader:close	()V
    //   116: lload_2
    //   117: lstore_0
    //   118: lload_0
    //   119: bipush 10
    //   121: lshl
    //   122: lreturn
    //   123: astore 7
    //   125: aload 6
    //   127: ifnull +18 -> 145
    //   130: aload 6
    //   132: invokevirtual 331	java/io/BufferedReader:close	()V
    //   135: goto +10 -> 145
    //   138: astore 6
    //   140: aload 6
    //   142: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   145: aload 7
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	90	0	l1	long
    //   1	116	2	l2	long
    //   62	48	4	l3	long
    //   19	46	6	localBufferedReader	java.io.BufferedReader
    //   72	3	6	localObject1	Object
    //   93	38	6	localObject2	Object
    //   138	3	6	localObject3	Object
    //   26	21	7	str	String
    //   85	1	7	localObject4	Object
    //   90	6	7	localThrowable	Throwable
    //   123	23	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   64	69	72	finally
    //   111	116	72	finally
    //   21	28	85	finally
    //   35	61	85	finally
    //   2	21	90	finally
    //   95	101	123	finally
    //   130	135	138	finally
  }
  
  public static long h()
  {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
  }
  
  /* Error */
  public static long i()
  {
    // Byte code:
    //   0: new 300	java/io/FileReader
    //   3: dup
    //   4: ldc_w 347
    //   7: invokespecial 303	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 298	java/io/BufferedReader
    //   15: dup
    //   16: aload 4
    //   18: sipush 2048
    //   21: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +46 -> 77
    //   34: aload_2
    //   35: invokevirtual 331	java/io/BufferedReader:close	()V
    //   38: goto +15 -> 53
    //   41: astore_2
    //   42: aload_2
    //   43: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   46: ifne +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   53: aload 4
    //   55: invokevirtual 352	java/io/FileReader:close	()V
    //   58: goto +15 -> 73
    //   61: astore_2
    //   62: aload_2
    //   63: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   66: ifne +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   73: ldc2_w 280
    //   76: lreturn
    //   77: aload_3
    //   78: ldc_w 354
    //   81: iconst_2
    //   82: invokevirtual 358	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   85: iconst_1
    //   86: aaload
    //   87: invokevirtual 361	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   90: ldc_w 363
    //   93: ldc_w 318
    //   96: invokevirtual 367	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   99: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   102: invokestatic 328	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore_0
    //   106: lload_0
    //   107: bipush 10
    //   109: lshl
    //   110: lstore_0
    //   111: aload_2
    //   112: invokevirtual 331	java/io/BufferedReader:close	()V
    //   115: goto +15 -> 130
    //   118: astore_2
    //   119: aload_2
    //   120: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   123: ifne +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   130: aload 4
    //   132: invokevirtual 352	java/io/FileReader:close	()V
    //   135: lload_0
    //   136: lreturn
    //   137: astore_2
    //   138: aload_2
    //   139: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   142: ifne +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   149: lload_0
    //   150: lreturn
    //   151: astore_3
    //   152: goto +16 -> 168
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: goto +10 -> 168
    //   161: astore_3
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 4
    //   167: astore_2
    //   168: aload_3
    //   169: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   172: ifne +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   179: aload_2
    //   180: ifnull +22 -> 202
    //   183: aload_2
    //   184: invokevirtual 331	java/io/BufferedReader:close	()V
    //   187: goto +15 -> 202
    //   190: astore_2
    //   191: aload_2
    //   192: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   195: ifne +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   202: aload 4
    //   204: ifnull +23 -> 227
    //   207: aload 4
    //   209: invokevirtual 352	java/io/FileReader:close	()V
    //   212: goto +15 -> 227
    //   215: astore_2
    //   216: aload_2
    //   217: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   220: ifne +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   227: ldc2_w 371
    //   230: lreturn
    //   231: astore_3
    //   232: aload_2
    //   233: ifnull +22 -> 255
    //   236: aload_2
    //   237: invokevirtual 331	java/io/BufferedReader:close	()V
    //   240: goto +15 -> 255
    //   243: astore_2
    //   244: aload_2
    //   245: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   248: ifne +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   255: aload 4
    //   257: ifnull +23 -> 280
    //   260: aload 4
    //   262: invokevirtual 352	java/io/FileReader:close	()V
    //   265: goto +15 -> 280
    //   268: astore_2
    //   269: aload_2
    //   270: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   273: ifne +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   280: aload_3
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   105	45	0	l	long
    //   24	11	2	localBufferedReader	java.io.BufferedReader
    //   41	9	2	localIOException1	java.io.IOException
    //   61	51	2	localIOException2	java.io.IOException
    //   118	9	2	localIOException3	java.io.IOException
    //   137	9	2	localIOException4	java.io.IOException
    //   157	27	2	localFileReader1	java.io.FileReader
    //   190	9	2	localIOException5	java.io.IOException
    //   215	22	2	localIOException6	java.io.IOException
    //   243	9	2	localIOException7	java.io.IOException
    //   268	9	2	localIOException8	java.io.IOException
    //   29	49	3	str	String
    //   151	1	3	localObject1	Object
    //   155	1	3	localObject2	Object
    //   161	15	3	localThrowable	Throwable
    //   231	50	3	localObject3	Object
    //   10	251	4	localFileReader2	java.io.FileReader
    // Exception table:
    //   from	to	target	type
    //   34	38	41	java/io/IOException
    //   53	58	61	java/io/IOException
    //   111	115	118	java/io/IOException
    //   130	135	137	java/io/IOException
    //   25	30	151	finally
    //   77	106	151	finally
    //   12	25	155	finally
    //   0	12	161	finally
    //   183	187	190	java/io/IOException
    //   207	212	215	java/io/IOException
    //   168	179	231	finally
    //   236	240	243	java/io/IOException
    //   260	265	268	java/io/IOException
  }
  
  /* Error */
  public static long j()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 300	java/io/FileReader
    //   6: dup
    //   7: ldc_w 347
    //   10: invokespecial 303	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: new 298	java/io/BufferedReader
    //   18: dup
    //   19: aload 7
    //   21: sipush 2048
    //   24: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 6
    //   29: aload 6
    //   31: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: pop
    //   35: aload 6
    //   37: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnonnull +54 -> 98
    //   47: aload 6
    //   49: invokevirtual 331	java/io/BufferedReader:close	()V
    //   52: goto +18 -> 70
    //   55: astore 6
    //   57: aload 6
    //   59: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   62: ifne +8 -> 70
    //   65: aload 6
    //   67: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   70: aload 7
    //   72: invokevirtual 352	java/io/FileReader:close	()V
    //   75: ldc2_w 280
    //   78: lreturn
    //   79: astore 6
    //   81: aload 6
    //   83: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   86: ifne +8 -> 94
    //   89: aload 6
    //   91: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   94: ldc2_w 280
    //   97: lreturn
    //   98: aload 8
    //   100: ldc_w 354
    //   103: iconst_2
    //   104: invokevirtual 358	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   107: iconst_1
    //   108: aaload
    //   109: invokevirtual 361	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: ldc_w 363
    //   115: ldc_w 318
    //   118: invokevirtual 367	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   124: invokestatic 328	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   127: lstore_0
    //   128: aload 6
    //   130: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   133: astore 8
    //   135: aload 8
    //   137: ifnonnull +54 -> 191
    //   140: aload 6
    //   142: invokevirtual 331	java/io/BufferedReader:close	()V
    //   145: goto +18 -> 163
    //   148: astore 6
    //   150: aload 6
    //   152: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   155: ifne +8 -> 163
    //   158: aload 6
    //   160: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   163: aload 7
    //   165: invokevirtual 352	java/io/FileReader:close	()V
    //   168: ldc2_w 280
    //   171: lreturn
    //   172: astore 6
    //   174: aload 6
    //   176: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   179: ifne +8 -> 187
    //   182: aload 6
    //   184: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   187: ldc2_w 280
    //   190: lreturn
    //   191: aload 8
    //   193: ldc_w 354
    //   196: iconst_2
    //   197: invokevirtual 358	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   200: iconst_1
    //   201: aaload
    //   202: invokevirtual 361	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   205: ldc_w 363
    //   208: ldc_w 318
    //   211: invokevirtual 367	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   214: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   217: invokestatic 328	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   220: lstore_2
    //   221: aload 6
    //   223: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   226: astore 8
    //   228: aload 8
    //   230: ifnonnull +54 -> 284
    //   233: aload 6
    //   235: invokevirtual 331	java/io/BufferedReader:close	()V
    //   238: goto +18 -> 256
    //   241: astore 6
    //   243: aload 6
    //   245: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   248: ifne +8 -> 256
    //   251: aload 6
    //   253: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   256: aload 7
    //   258: invokevirtual 352	java/io/FileReader:close	()V
    //   261: ldc2_w 280
    //   264: lreturn
    //   265: astore 6
    //   267: aload 6
    //   269: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   272: ifne +8 -> 280
    //   275: aload 6
    //   277: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   280: ldc2_w 280
    //   283: lreturn
    //   284: aload 8
    //   286: ldc_w 354
    //   289: iconst_2
    //   290: invokevirtual 358	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   293: iconst_1
    //   294: aaload
    //   295: invokevirtual 361	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   298: ldc_w 363
    //   301: ldc_w 318
    //   304: invokevirtual 367	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   307: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   310: invokestatic 328	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   313: lstore 4
    //   315: lload_0
    //   316: bipush 10
    //   318: lshl
    //   319: lconst_0
    //   320: ladd
    //   321: lload_2
    //   322: bipush 10
    //   324: lshl
    //   325: ladd
    //   326: lload 4
    //   328: bipush 10
    //   330: lshl
    //   331: ladd
    //   332: lstore_0
    //   333: aload 6
    //   335: invokevirtual 331	java/io/BufferedReader:close	()V
    //   338: goto +18 -> 356
    //   341: astore 6
    //   343: aload 6
    //   345: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   348: ifne +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   356: aload 7
    //   358: invokevirtual 352	java/io/FileReader:close	()V
    //   361: lload_0
    //   362: lreturn
    //   363: astore 6
    //   365: aload 6
    //   367: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   370: ifne +8 -> 378
    //   373: aload 6
    //   375: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   378: lload_0
    //   379: lreturn
    //   380: astore 9
    //   382: aload 6
    //   384: astore 8
    //   386: aload 9
    //   388: astore 6
    //   390: goto +13 -> 403
    //   393: astore 6
    //   395: goto +8 -> 403
    //   398: astore 6
    //   400: aconst_null
    //   401: astore 7
    //   403: aload 6
    //   405: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   408: ifne +8 -> 416
    //   411: aload 6
    //   413: invokevirtual 122	java/lang/Throwable:printStackTrace	()V
    //   416: aload 8
    //   418: ifnull +26 -> 444
    //   421: aload 8
    //   423: invokevirtual 331	java/io/BufferedReader:close	()V
    //   426: goto +18 -> 444
    //   429: astore 6
    //   431: aload 6
    //   433: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   436: ifne +8 -> 444
    //   439: aload 6
    //   441: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   444: aload 7
    //   446: ifnull +26 -> 472
    //   449: aload 7
    //   451: invokevirtual 352	java/io/FileReader:close	()V
    //   454: goto +18 -> 472
    //   457: astore 6
    //   459: aload 6
    //   461: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   464: ifne +8 -> 472
    //   467: aload 6
    //   469: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   472: ldc2_w 371
    //   475: lreturn
    //   476: astore 6
    //   478: aload 8
    //   480: ifnull +26 -> 506
    //   483: aload 8
    //   485: invokevirtual 331	java/io/BufferedReader:close	()V
    //   488: goto +18 -> 506
    //   491: astore 8
    //   493: aload 8
    //   495: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   498: ifne +8 -> 506
    //   501: aload 8
    //   503: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   506: aload 7
    //   508: ifnull +26 -> 534
    //   511: aload 7
    //   513: invokevirtual 352	java/io/FileReader:close	()V
    //   516: goto +18 -> 534
    //   519: astore 7
    //   521: aload 7
    //   523: invokestatic 117	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   526: ifne +8 -> 534
    //   529: aload 7
    //   531: invokevirtual 351	java/io/IOException:printStackTrace	()V
    //   534: aload 6
    //   536: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   127	252	0	l1	long
    //   220	102	2	l2	long
    //   313	14	4	l3	long
    //   27	21	6	localBufferedReader	java.io.BufferedReader
    //   55	11	6	localIOException1	java.io.IOException
    //   79	62	6	localIOException2	java.io.IOException
    //   148	11	6	localIOException3	java.io.IOException
    //   172	62	6	localIOException4	java.io.IOException
    //   241	11	6	localIOException5	java.io.IOException
    //   265	69	6	localIOException6	java.io.IOException
    //   341	11	6	localIOException7	java.io.IOException
    //   363	20	6	localIOException8	java.io.IOException
    //   388	1	6	localObject1	Object
    //   393	1	6	localObject2	Object
    //   398	14	6	localThrowable	Throwable
    //   429	11	6	localIOException9	java.io.IOException
    //   457	11	6	localIOException10	java.io.IOException
    //   476	59	6	localObject3	Object
    //   13	499	7	localFileReader	java.io.FileReader
    //   519	11	7	localIOException11	java.io.IOException
    //   1	483	8	localObject4	Object
    //   491	11	8	localIOException12	java.io.IOException
    //   380	7	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   47	52	55	java/io/IOException
    //   70	75	79	java/io/IOException
    //   140	145	148	java/io/IOException
    //   163	168	172	java/io/IOException
    //   233	238	241	java/io/IOException
    //   256	261	265	java/io/IOException
    //   333	338	341	java/io/IOException
    //   356	361	363	java/io/IOException
    //   29	42	380	finally
    //   98	135	380	finally
    //   191	228	380	finally
    //   284	315	380	finally
    //   15	29	393	finally
    //   3	15	398	finally
    //   421	426	429	java/io/IOException
    //   449	454	457	java/io/IOException
    //   403	416	476	finally
    //   483	488	491	java/io/IOException
    //   511	516	519	java/io/IOException
  }
  
  public static long k()
  {
    if (!p()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      return j * i;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static long l()
  {
    if (!p()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return j * i;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String m()
  {
    return "";
  }
  
  public static boolean n()
  {
    Object localObject = c;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (new File(localObject[i]).exists())
      {
        i = 1;
        break label44;
      }
      i += 1;
    }
    i = 0;
    label44:
    localObject = Build.TAGS;
    if ((localObject != null) && (((String)localObject).contains("test-keys"))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return i != 0;
    }
    return true;
  }
  
  public static boolean o()
  {
    float f1 = (float)(Runtime.getRuntime().maxMemory() / 1048576.0D);
    float f2 = (float)(Runtime.getRuntime().totalMemory() / 1048576.0D);
    float f3 = f1 - f2;
    y.c("maxMemory : %f", new Object[] { Float.valueOf(f1) });
    y.c("totalMemory : %f", new Object[] { Float.valueOf(f2) });
    y.c("freeMemory : %f", new Object[] { Float.valueOf(f3) });
    return f3 < 10.0F;
  }
  
  private static boolean p()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool) {
        return true;
      }
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  static final class a
    extends ArrayList<b.c>
  {
    a()
    {
      add(new b.n((byte)0));
      add(new b.h((byte)0));
      add(new b.i((byte)0));
      add(new b.o((byte)0));
      add(new b.j((byte)0));
      add(new b.k((byte)0));
      add(new b.m((byte)0));
      add(new b.g((byte)0));
      add(new b.l((byte)0));
      add(new b.d((byte)0));
      add(new b.f((byte)0));
      add(new b.e((byte)0));
    }
  }
  
  static final class b
    extends HashMap<Integer, String>
  {
    b()
    {
      put(Integer.valueOf(1), "GPRS");
      put(Integer.valueOf(2), "EDGE");
      put(Integer.valueOf(3), "UMTS");
      put(Integer.valueOf(8), "HSDPA");
      put(Integer.valueOf(9), "HSUPA");
      put(Integer.valueOf(10), "HSPA");
      put(Integer.valueOf(4), "CDMA");
      put(Integer.valueOf(5), "EVDO_0");
      put(Integer.valueOf(6), "EVDO_A");
      put(Integer.valueOf(7), "1xRTT");
      put(Integer.valueOf(11), "iDen");
      put(Integer.valueOf(12), "EVDO_B");
      put(Integer.valueOf(13), "LTE");
      put(Integer.valueOf(14), "eHRPD");
      put(Integer.valueOf(15), "HSPA+");
    }
  }
  
  static abstract class c
  {
    public abstract String a(Context paramContext);
  }
  
  static final class d
    extends b.c
  {
    private d()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      String str = ab.a(paramContext, "ro.gn.gnromvernumber");
      if ((!ab.a(str)) && (!str.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("amigo/");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append(ab.a(paramContext, "ro.build.display.id"));
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class e
    extends b.c
  {
    private e()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ab.a(paramContext, "ro.build.fingerprint"));
      localStringBuilder.append("/");
      localStringBuilder.append(ab.a(paramContext, "ro.build.rom.id"));
      return localStringBuilder.toString();
    }
  }
  
  static final class f
    extends b.c
  {
    private f()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      paramContext = ab.a(paramContext, "ro.build.tyd.kbstyle_version");
      if ((!ab.a(paramContext)) && (!paramContext.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("dido/");
        localStringBuilder.append(paramContext);
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class g
    extends b.c
  {
    private g()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      String str = ab.a(paramContext, "ro.aa.romver");
      if ((!ab.a(str)) && (!str.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("htc/");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append(ab.a(paramContext, "ro.build.description"));
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class h
    extends b.c
  {
    private h()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      paramContext = ab.a(paramContext, "ro.build.version.emui");
      if ((!ab.a(paramContext)) && (!paramContext.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("HuaWei/EMOTION/");
        localStringBuilder.append(paramContext);
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class i
    extends b.c
  {
    private i()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      Object localObject = ab.a(paramContext, "ro.lenovo.series");
      if ((!ab.a((String)localObject)) && (!((String)localObject).equals("fail")))
      {
        paramContext = ab.a(paramContext, "ro.build.version.incremental");
        localObject = new StringBuilder("Lenovo/VIBE/");
        ((StringBuilder)localObject).append(paramContext);
        return ((StringBuilder)localObject).toString();
      }
      return null;
    }
  }
  
  static final class j
    extends b.c
  {
    private j()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      Object localObject = ab.a(paramContext, "ro.meizu.product.model");
      if ((!ab.a((String)localObject)) && (!((String)localObject).equals("fail")))
      {
        localObject = new StringBuilder("Meizu/FLYME/");
        ((StringBuilder)localObject).append(ab.a(paramContext, "ro.build.display.id"));
        return ((StringBuilder)localObject).toString();
      }
      return null;
    }
  }
  
  static final class k
    extends b.c
  {
    private k()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      paramContext = ab.a(paramContext, "ro.build.version.opporom");
      if ((!ab.a(paramContext)) && (!paramContext.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("Oppo/COLOROS/");
        localStringBuilder.append(paramContext);
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class l
    extends b.c
  {
    private l()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      String str = ab.a(paramContext, "ro.lewa.version");
      if ((!ab.a(str)) && (!str.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("tcl/");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append(ab.a(paramContext, "ro.build.display.id"));
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class m
    extends b.c
  {
    private m()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      paramContext = ab.a(paramContext, "ro.vivo.os.build.display.id");
      if ((!ab.a(paramContext)) && (!paramContext.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("vivo/FUNTOUCH/");
        localStringBuilder.append(paramContext);
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class n
    extends b.c
  {
    private n()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      paramContext = ab.a(paramContext, "ro.miui.ui.version.name");
      if ((!ab.a(paramContext)) && (!paramContext.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("XiaoMi/MIUI/");
        localStringBuilder.append(paramContext);
        return localStringBuilder.toString();
      }
      return null;
    }
  }
  
  static final class o
    extends b.c
  {
    private o()
    {
      super();
    }
    
    public final String a(Context paramContext)
    {
      String str = ab.a(paramContext, "ro.build.nubia.rom.name");
      if ((!ab.a(str)) && (!str.equals("fail")))
      {
        StringBuilder localStringBuilder = new StringBuilder("Zte/NUBIA/");
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(ab.a(paramContext, "ro.build.nubia.rom.code"));
        return localStringBuilder.toString();
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.b
 * JD-Core Version:    0.7.0.1
 */