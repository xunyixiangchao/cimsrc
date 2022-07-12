package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ab
{
  private static Map<String, String> a;
  
  public static Context a(Context paramContext)
  {
    if (paramContext == null) {
      return paramContext;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private static BufferedReader a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.canRead()) {
        return null;
      }
      try
      {
        paramFile = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
        return paramFile;
      }
      finally
      {
        y.a(paramFile);
      }
    }
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = new File(paramString1, paramString2);
      if (paramString1.exists())
      {
        if (!paramString1.canRead()) {
          return null;
        }
        paramString1 = a(paramString1);
        return paramString1;
      }
      return null;
    }
    catch (NullPointerException paramString1)
    {
      y.a(paramString1);
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramArrayOfObject);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    try
    {
      paramArrayOfByte = paramCreator.createFromParcel(localParcel);
      localParcel.recycle();
      return paramArrayOfByte;
    }
    finally
    {
      try
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
  
  public static String a()
  {
    return a(System.currentTimeMillis());
  }
  
  /* Error */
  public static String a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +31 -> 32
    //   4: iconst_4
    //   5: anewarray 135	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc 137
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 139
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 141
    //   22: aastore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 143
    //   27: aastore
    //   28: astore_2
    //   29: goto +38 -> 67
    //   32: bipush 6
    //   34: anewarray 135	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 137
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 139
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc 141
    //   51: aastore
    //   52: dup
    //   53: iconst_3
    //   54: ldc 143
    //   56: aastore
    //   57: dup
    //   58: iconst_4
    //   59: ldc 145
    //   61: aastore
    //   62: dup
    //   63: iconst_5
    //   64: aload_1
    //   65: aastore
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: new 147	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   76: astore_3
    //   77: invokestatic 154	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   80: aload_2
    //   81: invokevirtual 158	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: new 37	java/io/BufferedReader
    //   90: dup
    //   91: new 39	java/io/InputStreamReader
    //   94: dup
    //   95: aload_2
    //   96: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   99: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   102: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore 4
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   114: astore 5
    //   116: aload 5
    //   118: ifnull +52 -> 170
    //   121: aload_2
    //   122: astore_1
    //   123: aload_3
    //   124: aload 5
    //   126: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: astore_1
    //   132: aload_3
    //   133: ldc 176
    //   135: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: iload_0
    //   140: ifle -33 -> 107
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   149: iload_0
    //   150: if_icmple -43 -> 107
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: iconst_0
    //   157: aload_3
    //   158: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   161: iload_0
    //   162: isub
    //   163: invokevirtual 184	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: goto -60 -> 107
    //   170: aload_2
    //   171: astore_1
    //   172: aload_3
    //   173: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 4
    //   178: aload_2
    //   179: invokevirtual 191	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   182: invokevirtual 196	java/io/OutputStream:close	()V
    //   185: goto +8 -> 193
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   193: aload_2
    //   194: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   197: invokevirtual 200	java/io/InputStream:close	()V
    //   200: goto +8 -> 208
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   208: aload_2
    //   209: invokevirtual 203	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   212: invokevirtual 200	java/io/InputStream:close	()V
    //   215: aload 4
    //   217: areturn
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   223: aload 4
    //   225: areturn
    //   226: astore_2
    //   227: aload_2
    //   228: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   231: ifne +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   238: aload_3
    //   239: ldc 205
    //   241: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_3
    //   246: aload_2
    //   247: invokevirtual 206	java/lang/Throwable:toString	()Ljava/lang/String;
    //   250: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: ldc 208
    //   257: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_3
    //   262: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: astore_2
    //   266: aload_1
    //   267: ifnull +47 -> 314
    //   270: aload_1
    //   271: invokevirtual 191	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   274: invokevirtual 196	java/io/OutputStream:close	()V
    //   277: goto +8 -> 285
    //   280: astore_3
    //   281: aload_3
    //   282: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   285: aload_1
    //   286: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   289: invokevirtual 200	java/io/InputStream:close	()V
    //   292: goto +8 -> 300
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   300: aload_1
    //   301: invokevirtual 203	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   304: invokevirtual 200	java/io/InputStream:close	()V
    //   307: aload_2
    //   308: areturn
    //   309: astore_1
    //   310: aload_1
    //   311: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   314: aload_2
    //   315: areturn
    //   316: astore_2
    //   317: aload_1
    //   318: ifnull +48 -> 366
    //   321: aload_1
    //   322: invokevirtual 191	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   325: invokevirtual 196	java/io/OutputStream:close	()V
    //   328: goto +8 -> 336
    //   331: astore_3
    //   332: aload_3
    //   333: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   336: aload_1
    //   337: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   340: invokevirtual 200	java/io/InputStream:close	()V
    //   343: goto +8 -> 351
    //   346: astore_3
    //   347: aload_3
    //   348: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   351: aload_1
    //   352: invokevirtual 203	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   355: invokevirtual 200	java/io/InputStream:close	()V
    //   358: goto +8 -> 366
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   366: aload_2
    //   367: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramInt	int
    //   0	368	1	paramString	String
    //   28	181	2	localObject1	Object
    //   226	21	2	localThrowable	Throwable
    //   265	50	2	str1	String
    //   316	51	2	localObject2	Object
    //   76	186	3	localStringBuilder	StringBuilder
    //   280	2	3	localIOException1	java.io.IOException
    //   295	2	3	localIOException2	java.io.IOException
    //   331	2	3	localIOException3	java.io.IOException
    //   346	2	3	localIOException4	java.io.IOException
    //   105	119	4	localObject3	Object
    //   114	11	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   178	185	188	java/io/IOException
    //   193	200	203	java/io/IOException
    //   208	215	218	java/io/IOException
    //   77	85	226	finally
    //   87	107	226	finally
    //   109	116	226	finally
    //   123	130	226	finally
    //   132	139	226	finally
    //   145	153	226	finally
    //   155	167	226	finally
    //   172	178	226	finally
    //   270	277	280	java/io/IOException
    //   285	292	295	java/io/IOException
    //   300	307	309	java/io/IOException
    //   227	238	316	finally
    //   238	266	316	finally
    //   321	328	331	java/io/IOException
    //   336	343	346	java/io/IOException
    //   351	358	361	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return new Date().toString();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return "";
      }
      if (a == null)
      {
        a = new HashMap();
        Object localObject = "/system/bin/sh";
        if ((!new File("/system/bin/sh").exists()) || (!new File("/system/bin/sh").canExecute())) {
          localObject = "sh";
        }
        localObject = a(paramContext, new String[] { localObject, "-c", "getprop" });
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          y.b(ab.class, "Successfully get 'getprop' list.", new Object[0]);
          paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
            if (localMatcher.find()) {
              a.put(localMatcher.group(1), localMatcher.group(2));
            }
          }
          y.b(ab.class, "Systems properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
        }
      }
      if (a.containsKey(paramString)) {
        return (String)a.get(paramString);
      }
      return "fail";
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +190 -> 191
    //   4: aload_0
    //   5: invokevirtual 32	java/io/File:exists	()Z
    //   8: ifeq +183 -> 191
    //   11: aload_0
    //   12: invokevirtual 35	java/io/File:canRead	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 147	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: new 37	java/io/BufferedReader
    //   31: dup
    //   32: new 39	java/io/InputStreamReader
    //   35: dup
    //   36: new 41	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: ldc 46
    //   46: invokespecial 49	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +61 -> 122
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: ldc 176
    //   74: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: iload_1
    //   79: ifle -26 -> 53
    //   82: aload_3
    //   83: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   86: iload_1
    //   87: if_icmple -34 -> 53
    //   90: iload_2
    //   91: ifeq +16 -> 107
    //   94: aload_3
    //   95: iload_1
    //   96: aload_3
    //   97: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   100: invokevirtual 184	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: goto +18 -> 122
    //   107: aload_3
    //   108: iconst_0
    //   109: aload_3
    //   110: invokevirtual 180	java/lang/StringBuilder:length	()I
    //   113: iload_1
    //   114: isub
    //   115: invokevirtual 184	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: goto -66 -> 53
    //   122: aload_3
    //   123: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: aload_0
    //   128: invokevirtual 335	java/io/BufferedReader:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   138: pop
    //   139: aload_3
    //   140: areturn
    //   141: astore_3
    //   142: goto +6 -> 148
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_3
    //   149: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   152: pop
    //   153: aload_0
    //   154: ifnull +15 -> 169
    //   157: aload_0
    //   158: invokevirtual 335	java/io/BufferedReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   168: pop
    //   169: aconst_null
    //   170: areturn
    //   171: astore_3
    //   172: aload_0
    //   173: ifnull +16 -> 189
    //   176: aload_0
    //   177: invokevirtual 335	java/io/BufferedReader:close	()V
    //   180: goto +9 -> 189
    //   183: astore_0
    //   184: aload_0
    //   185: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   188: pop
    //   189: aload_3
    //   190: athrow
    //   191: aconst_null
    //   192: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramFile	File
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   27	113	3	localObject1	Object
    //   141	1	3	localObject2	Object
    //   145	4	3	localThrowable	Throwable
    //   171	19	3	localObject3	Object
    //   57	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/lang/Exception
    //   53	59	141	finally
    //   64	78	141	finally
    //   82	90	141	finally
    //   94	104	141	finally
    //   107	119	141	finally
    //   122	127	141	finally
    //   20	53	145	finally
    //   157	161	163	java/lang/Exception
    //   148	153	171	finally
    //   176	180	183	java/lang/Exception
  }
  
  public static String a(Thread paramThread)
  {
    if (paramThread == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramThread = paramThread.getStackTrace();
    int j = paramThread.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramThread[i].toString());
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    finally
    {
      if (!y.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    try
    {
      paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      label25:
      break label25;
    }
    return new Date().toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      try
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        if (paramArrayOfByte == null) {
          return "";
        }
        localObject = new StringBuffer();
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
          if (str.length() == 1) {
            ((StringBuffer)localObject).append("0");
          }
          ((StringBuffer)localObject).append(str);
          i += 1;
        }
        paramArrayOfByte = ((StringBuffer)localObject).toString().toUpperCase();
        return paramArrayOfByte;
      }
      finally
      {
        if (!y.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        return null;
      }
    }
    return "NULL";
  }
  
  public static Thread a(Runnable paramRunnable, String paramString)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(paramString);
      paramRunnable.start();
      return paramRunnable;
    }
    finally
    {
      y.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
    }
    return null;
  }
  
  /* Error */
  private static ArrayList<String> a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 420	com/tencent/bugly/crashreport/common/info/AppInfo:e	(Landroid/content/Context;)Z
    //   4: ifeq +24 -> 28
    //   7: new 422	java/util/ArrayList
    //   10: dup
    //   11: iconst_1
    //   12: anewarray 135	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 424
    //   20: aastore
    //   21: invokestatic 430	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   24: invokespecial 433	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   27: areturn
    //   28: new 422	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 434	java/util/ArrayList:<init>	()V
    //   35: astore_3
    //   36: invokestatic 154	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   39: aload_1
    //   40: invokevirtual 158	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   43: astore_0
    //   44: new 37	java/io/BufferedReader
    //   47: dup
    //   48: new 39	java/io/InputStreamReader
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 164	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   56: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +12 -> 81
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 437	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -15 -> 63
    //   81: new 37	java/io/BufferedReader
    //   84: dup
    //   85: new 39	java/io/InputStreamReader
    //   88: dup
    //   89: aload_0
    //   90: invokevirtual 203	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   93: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   96: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +12 -> 118
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 437	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -15 -> 100
    //   118: aload_2
    //   119: invokevirtual 335	java/io/BufferedReader:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: invokevirtual 335	java/io/BufferedReader:close	()V
    //   134: aload_3
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   141: aload_3
    //   142: areturn
    //   143: astore_1
    //   144: goto +14 -> 158
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: goto +8 -> 158
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: astore_0
    //   158: aload_1
    //   159: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   162: ifne +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull +15 -> 185
    //   173: aload_2
    //   174: invokevirtual 335	java/io/BufferedReader:close	()V
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +14 -> 200
    //   189: aload_0
    //   190: invokevirtual 335	java/io/BufferedReader:close	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_1
    //   203: aload_2
    //   204: ifnull +15 -> 219
    //   207: aload_2
    //   208: invokevirtual 335	java/io/BufferedReader:close	()V
    //   211: goto +8 -> 219
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: ifnull +15 -> 235
    //   223: aload_0
    //   224: invokevirtual 335	java/io/BufferedReader:close	()V
    //   227: goto +8 -> 235
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramContext	Context
    //   0	237	1	paramArrayOfString	String[]
    //   62	146	2	localBufferedReader	BufferedReader
    //   214	2	2	localIOException	java.io.IOException
    //   35	107	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   118	122	125	java/io/IOException
    //   130	134	136	java/io/IOException
    //   100	105	143	finally
    //   109	115	143	finally
    //   63	68	147	finally
    //   72	78	147	finally
    //   81	100	147	finally
    //   36	63	153	finally
    //   173	177	180	java/io/IOException
    //   189	193	195	java/io/IOException
    //   158	169	202	finally
    //   207	211	214	java/io/IOException
    //   223	227	230	java/io/IOException
  }
  
  private static Map<String, String> a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(12);
    Object localObject2 = Thread.getAllStackTraces();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = Looper.getMainLooper().getThread();
    if (!((Map)localObject2).containsKey(localObject1)) {
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
    }
    long l = Thread.currentThread().getId();
    localObject1 = new StringBuilder();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if ((!paramBoolean) || (l != ((Thread)localEntry.getKey()).getId()))
      {
        int i = 0;
        ((StringBuilder)localObject1).setLength(0);
        if ((localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length != 0))
        {
          Object localObject3 = (StackTraceElement[])localEntry.getValue();
          int j = localObject3.length;
          while (i < j)
          {
            Object localObject4 = localObject3[i];
            if ((paramInt > 0) && (((StringBuilder)localObject1).length() >= paramInt))
            {
              localObject3 = new StringBuilder("\n[Stack over limit size :");
              ((StringBuilder)localObject3).append(paramInt);
              ((StringBuilder)localObject3).append(" , has been cut!]");
              ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
              break;
            }
            ((StringBuilder)localObject1).append(localObject4.toString());
            ((StringBuilder)localObject1).append("\n");
            i += 1;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getName());
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getId());
          ((StringBuilder)localObject3).append(")");
          localHashMap.put(((StringBuilder)localObject3).toString(), ((StringBuilder)localObject1).toString());
        }
      }
    }
    return localHashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel)
  {
    Object localObject1 = paramParcel.readBundle();
    paramParcel = null;
    if (localObject1 == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = ((Integer)((Bundle)localObject1).get("pluginNum")).intValue();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginKey");
      ((StringBuilder)localObject2).append(i);
      localArrayList1.add(((Bundle)localObject1).getString(((StringBuilder)localObject2).toString()));
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("plugInId");
      localObject2 = ((Bundle)localObject1).getString(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("plugInUUID");
      localObject3 = ((Bundle)localObject1).getString(((StringBuilder)localObject3).toString());
      StringBuilder localStringBuilder = new StringBuilder("pluginVal");
      localStringBuilder.append(i);
      localStringBuilder.append("plugInVersion");
      localArrayList2.add(new PlugInBean((String)localObject2, ((Bundle)localObject1).getString(localStringBuilder.toString()), (String)localObject3));
      i += 1;
    }
    if (localArrayList1.size() == localArrayList2.size())
    {
      localObject1 = new HashMap(localArrayList1.size());
      i = j;
      for (;;)
      {
        paramParcel = (Parcel)localObject1;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject1).put(localArrayList1.get(i), PlugInBean.class.cast(localArrayList2.get(i)));
        i += 1;
      }
    }
    y.e("map plugin parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static Map<String, String> a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      y.c("get all thread stack not enable", new Object[0]);
      return new HashMap();
    }
    Map localMap = a(paramInt, false);
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      Object localObject;
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        localArrayList1.add(((Map.Entry)localObject).getKey());
        localArrayList2.add(((Map.Entry)localObject).getValue());
      }
      paramMap = new Bundle();
      paramMap.putInt("pluginNum", localArrayList1.size());
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= localArrayList1.size()) {
          break;
        }
        localObject = new StringBuilder("pluginKey");
        ((StringBuilder)localObject).append(i);
        paramMap.putString(((StringBuilder)localObject).toString(), (String)localArrayList1.get(i));
        i += 1;
      }
      while (j < localArrayList1.size())
      {
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInId");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).a);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInUUID");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).c);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInVersion");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).b);
        j += 1;
      }
      paramParcel.writeBundle(paramMap);
      return;
    }
    paramParcel.writeBundle(null);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass.set(null, paramObject1);
      return;
    }
    catch (Exception paramClass) {}
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    y.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        if (System.currentTimeMillis() - ((File)localObject).lastModified() < 10000L) {
          return false;
        }
        y.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      }
      return ((File)localObject).createNewFile();
    }
    finally
    {
      y.a(paramContext);
    }
    return false;
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile2 != null) && (!paramFile1.equals(paramFile2)))
    {
      if ((paramFile1.exists()) && (paramFile1.canRead()))
      {
        try
        {
          if ((paramFile2.getParentFile() != null) && (!paramFile2.getParentFile().exists())) {
            paramFile2.getParentFile().mkdirs();
          }
          if (!paramFile2.exists()) {
            paramFile2.createNewFile();
          }
        }
        finally
        {
          if (!y.a(paramFile1)) {
            paramFile1.printStackTrace();
          }
        }
        return (paramFile2.exists()) && (paramFile2.canWrite());
      }
      y.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
      return false;
    }
    y.d("rqdp{  err ZF 1R!}", new Object[0]);
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 650
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 652	com/tencent/bugly/proguard/ab:a	(Ljava/io/File;Ljava/io/File;)Z
    //   16: ifne +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: aconst_null
    //   22: astore 4
    //   24: new 41	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: new 654	java/util/zip/ZipOutputStream
    //   36: dup
    //   37: new 656	java/io/BufferedOutputStream
    //   40: dup
    //   41: new 658	java/io/FileOutputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 659	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 662	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: invokespecial 663	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_1
    //   56: aload_1
    //   57: bipush 8
    //   59: invokevirtual 666	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   62: aload_1
    //   63: new 668	java/util/zip/ZipEntry
    //   66: dup
    //   67: aload_0
    //   68: invokevirtual 669	java/io/File:getName	()Ljava/lang/String;
    //   71: invokespecial 670	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 674	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   77: sipush 5000
    //   80: sipush 1000
    //   83: invokestatic 680	java/lang/Math:max	(II)I
    //   86: newarray byte
    //   88: astore_0
    //   89: aload_3
    //   90: aload_0
    //   91: invokevirtual 684	java/io/FileInputStream:read	([B)I
    //   94: istore_2
    //   95: iload_2
    //   96: ifle +13 -> 109
    //   99: aload_1
    //   100: aload_0
    //   101: iconst_0
    //   102: iload_2
    //   103: invokevirtual 687	java/util/zip/ZipOutputStream:write	([BII)V
    //   106: goto -17 -> 89
    //   109: aload_1
    //   110: invokevirtual 690	java/util/zip/ZipOutputStream:flush	()V
    //   113: aload_1
    //   114: invokevirtual 693	java/util/zip/ZipOutputStream:closeEntry	()V
    //   117: aload_3
    //   118: invokevirtual 694	java/io/FileInputStream:close	()V
    //   121: goto +8 -> 129
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   129: aload_1
    //   130: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   133: goto +8 -> 141
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   141: ldc_w 697
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   151: pop
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_0
    //   155: goto +6 -> 161
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_1
    //   161: goto +9 -> 170
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 4
    //   169: astore_3
    //   170: aload_0
    //   171: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   174: ifne +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   181: aload_3
    //   182: ifnull +15 -> 197
    //   185: aload_3
    //   186: invokevirtual 694	java/io/FileInputStream:close	()V
    //   189: goto +8 -> 197
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   197: aload_1
    //   198: ifnull +15 -> 213
    //   201: aload_1
    //   202: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   205: goto +8 -> 213
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   213: ldc_w 697
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   223: pop
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_0
    //   227: aload_3
    //   228: ifnull +15 -> 243
    //   231: aload_3
    //   232: invokevirtual 694	java/io/FileInputStream:close	()V
    //   235: goto +8 -> 243
    //   238: astore_3
    //   239: aload_3
    //   240: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   243: aload_1
    //   244: ifnull +15 -> 259
    //   247: aload_1
    //   248: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   259: ldc_w 697
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   269: pop
    //   270: aload_0
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramFile1	File
    //   0	272	1	paramFile2	File
    //   0	272	2	paramInt	int
    //   32	200	3	localObject1	Object
    //   238	2	3	localIOException	java.io.IOException
    //   22	146	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	124	java/io/IOException
    //   129	133	136	java/io/IOException
    //   56	89	154	finally
    //   89	95	154	finally
    //   99	106	154	finally
    //   109	117	154	finally
    //   33	56	158	finally
    //   24	33	164	finally
    //   185	189	192	java/io/IOException
    //   201	205	208	java/io/IOException
    //   170	181	226	finally
    //   231	235	238	java/io/IOException
    //   247	251	254	java/io/IOException
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Object localObject = x.a();
      if (localObject != null) {
        return ((x)localObject).a(paramRunnable);
      }
      localObject = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, localObject[(localObject.length - 1)]) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
  
  /* Error */
  public static byte[] a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +221 -> 222
    //   4: aload_1
    //   5: invokevirtual 386	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: ldc_w 650
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: new 732	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 734
    //   32: invokevirtual 738	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   35: invokespecial 740	java/io/ByteArrayInputStream:<init>	([B)V
    //   38: astore_1
    //   39: new 742	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 743	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: new 654	java/util/zip/ZipOutputStream
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 663	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: bipush 8
    //   61: invokevirtual 666	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   64: aload_0
    //   65: new 668	java/util/zip/ZipEntry
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 670	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 674	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore_2
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 744	java/io/ByteArrayInputStream:read	([B)I
    //   87: istore_3
    //   88: iload_3
    //   89: ifle +13 -> 102
    //   92: aload_0
    //   93: aload_2
    //   94: iconst_0
    //   95: iload_3
    //   96: invokevirtual 687	java/util/zip/ZipOutputStream:write	([BII)V
    //   99: goto -17 -> 82
    //   102: aload_0
    //   103: invokevirtual 693	java/util/zip/ZipOutputStream:closeEntry	()V
    //   106: aload_0
    //   107: invokevirtual 690	java/util/zip/ZipOutputStream:flush	()V
    //   110: aload_0
    //   111: invokevirtual 747	java/util/zip/ZipOutputStream:finish	()V
    //   114: aload 4
    //   116: invokevirtual 750	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   124: goto +8 -> 132
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   132: ldc_w 697
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   142: pop
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: goto +6 -> 152
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_1
    //   153: invokestatic 57	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   156: ifne +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   163: aload_0
    //   164: ifnull +15 -> 179
    //   167: aload_0
    //   168: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   171: goto +8 -> 179
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   179: ldc_w 697
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: aload_0
    //   194: ifnull +15 -> 209
    //   197: aload_0
    //   198: invokevirtual 695	java/util/zip/ZipOutputStream:close	()V
    //   201: goto +8 -> 209
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   209: ldc_w 697
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 551	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_1
    //   221: athrow
    //   222: aconst_null
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramFile	File
    //   0	224	1	paramString1	String
    //   0	224	2	paramString2	String
    //   87	9	3	i	int
    //   46	69	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   120	124	127	java/io/IOException
    //   58	82	145	finally
    //   82	88	145	finally
    //   92	99	145	finally
    //   102	120	145	finally
    //   24	58	149	finally
    //   167	171	174	java/io/IOException
    //   152	163	192	finally
    //   197	201	204	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    y.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      af localaf = ae.a(2);
      if (localaf == null) {
        return null;
      }
      paramArrayOfByte = localaf.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    finally
    {
      if (!y.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static long b()
  {
    try
    {
      long l = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L;
      int i = TimeZone.getDefault().getRawOffset();
      return l * 86400000L - i;
    }
    finally
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static long b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(new String(paramArrayOfByte, "utf-8"));
      return l;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1L;
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static Map<String, String> b(Parcel paramParcel)
  {
    Object localObject = paramParcel.readBundle();
    paramParcel = null;
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList1 = ((Bundle)localObject).getStringArrayList("keys");
    ArrayList localArrayList2 = ((Bundle)localObject).getStringArrayList("values");
    int i = 0;
    if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() == localArrayList2.size()))
    {
      localObject = new HashMap(localArrayList1.size());
      for (;;)
      {
        paramParcel = (Parcel)localObject;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject).put(localArrayList1.get(i), localArrayList2.get(i));
        i += 1;
      }
    }
    y.e("map parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localArrayList1.add(localEntry.getKey());
        localArrayList2.add(localEntry.getValue());
      }
      paramMap = new Bundle();
      paramMap.putStringArrayList("keys", localArrayList1);
      paramMap.putStringArrayList("values", localArrayList2);
    }
    for (;;)
    {
      paramParcel.writeBundle(paramMap);
      return;
      paramMap = null;
    }
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists()) && (paramString.canWrite())) {
      paramString.delete();
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().E != null)) {
      a.b().E.edit().putString(paramString1, paramString2).apply();
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    y.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      paramContext = new File(localStringBuilder.toString());
      if (paramContext.exists()) {
        return paramContext.delete();
      }
      return true;
    }
    finally
    {
      y.a(paramContext);
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    y.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      af localaf = ae.a(2);
      if (localaf == null) {
        return null;
      }
      paramArrayOfByte = localaf.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    finally
    {
      if ((paramArrayOfByte.getMessage() != null) && (paramArrayOfByte.getMessage().contains("Not in GZIP format")))
      {
        y.d(paramArrayOfByte.getMessage(), new Object[0]);
        return null;
      }
      if (!y.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().E != null)) {
      return a.b().E.getString(paramString1, paramString2);
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (paramString.length() > 255)
    {
      y.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    }
    if (!paramString.toLowerCase().startsWith("http"))
    {
      y.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static byte[] c(long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString().getBytes("utf-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ab
 * JD-Core Version:    0.7.0.1
 */