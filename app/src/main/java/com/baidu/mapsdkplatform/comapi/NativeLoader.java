package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NativeLoader
{
  private static final String a = "NativeLoader";
  private static Context b;
  private static final Set<String> c = new HashSet();
  private static final Set<String> d = new HashSet();
  private static NativeLoader e;
  private static c f = c.b;
  private static boolean g = false;
  private static String h = null;
  
  @TargetApi(8)
  private String a()
  {
    if (b == null) {
      return "";
    }
    return b.getPackageCodePath();
  }
  
  private String a(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib/");
    localStringBuilder.append(paramc.a());
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void a(java.io.InputStream paramInputStream, java.io.FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore 4
    //   7: aload_1
    //   8: aload 4
    //   10: invokevirtual 88	java/io/InputStream:read	([B)I
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_m1
    //   16: if_icmpeq +14 -> 30
    //   19: aload_2
    //   20: aload 4
    //   22: iconst_0
    //   23: iload_3
    //   24: invokevirtual 94	java/io/FileOutputStream:write	([BII)V
    //   27: goto -20 -> 7
    //   30: aload_2
    //   31: invokevirtual 97	java/io/FileOutputStream:flush	()V
    //   34: aload_1
    //   35: invokevirtual 100	java/io/InputStream:close	()V
    //   38: goto +14 -> 52
    //   41: astore_1
    //   42: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   45: ldc 104
    //   47: aload_1
    //   48: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   51: pop
    //   52: aload_2
    //   53: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   61: ldc 112
    //   63: aload_1
    //   64: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   67: pop
    //   68: return
    //   69: astore 4
    //   71: aload_1
    //   72: invokevirtual 100	java/io/InputStream:close	()V
    //   75: goto +14 -> 89
    //   78: astore_1
    //   79: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   82: ldc 104
    //   84: aload_1
    //   85: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   88: pop
    //   89: aload_2
    //   90: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   93: goto +14 -> 107
    //   96: astore_1
    //   97: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   100: ldc 112
    //   102: aload_1
    //   103: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: aload 4
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	NativeLoader
    //   0	110	1	paramInputStream	java.io.InputStream
    //   0	110	2	paramFileOutputStream	java.io.FileOutputStream
    //   13	11	3	i	int
    //   5	16	4	arrayOfByte	byte[]
    //   69	39	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	38	41	java/io/IOException
    //   52	56	57	java/io/IOException
    //   7	14	69	finally
    //   19	27	69	finally
    //   30	34	69	finally
    //   71	75	78	java/io/IOException
    //   89	93	96	java/io/IOException
  }
  
  private void a(final String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      if (!paramString1.contains("libBaiduMapSDK_")) {
        return;
      }
    }
    try
    {
      paramString1 = paramString1.split("_v");
      if (paramString1.length <= 1) {
        return;
      }
      paramString1 = paramString1[1];
      paramString1 = new File(b()).listFiles(new a(paramString1));
      if (paramString1 != null)
      {
        if (paramString1.length == 0) {
          return;
        }
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          paramString1[i].delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private void a(Throwable paramThrowable)
  {
    Log.e(a, "loadException", paramThrowable);
    paramThrowable = d.iterator();
    while (paramThrowable.hasNext())
    {
      String str1 = (String)paramThrowable.next();
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" Failed to load.");
      Log.e(str2, localStringBuilder.toString());
    }
  }
  
  static void a(boolean paramBoolean, String paramString)
  {
    g = paramBoolean;
    h = paramString;
  }
  
  private boolean a(String paramString)
  {
    String str = System.mapLibraryName(paramString);
    synchronized (c)
    {
      if (???.contains(paramString)) {
        return true;
      }
      int i = b.a[f.ordinal()];
      boolean bool;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                bool = false;
              } else {
                bool = f(paramString, str);
              }
            }
            else {
              bool = e(paramString, str);
            }
          }
          else {
            bool = c(paramString, str);
          }
        }
        else {
          bool = d(paramString, str);
        }
      }
      else {
        bool = b(paramString, str);
      }
      try
      {
        ???.add(paramString);
        return bool;
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean a(String paramString, c paramc)
  {
    // Byte code:
    //   0: new 135	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 137	com/baidu/mapsdkplatform/comapi/NativeLoader:b	()Ljava/lang/String;
    //   8: aload_1
    //   9: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 213	java/io/File:exists	()Z
    //   17: ifeq +14 -> 31
    //   20: aload_3
    //   21: invokevirtual 217	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +5 -> 31
    //   29: iconst_1
    //   30: ireturn
    //   31: new 65	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_3
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 219	com/baidu/mapsdkplatform/comapi/NativeLoader:a	(Lcom/baidu/mapsdkplatform/comapi/NativeLoader$c;)Ljava/lang/String;
    //   45: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 5
    //   61: aconst_null
    //   62: astore 4
    //   64: aconst_null
    //   65: astore_2
    //   66: getstatic 44	com/baidu/mapsdkplatform/comapi/NativeLoader:g	Z
    //   69: ifne +11 -> 80
    //   72: aload_0
    //   73: invokespecial 220	com/baidu/mapsdkplatform/comapi/NativeLoader:a	()Ljava/lang/String;
    //   76: astore_3
    //   77: goto +7 -> 84
    //   80: getstatic 46	com/baidu/mapsdkplatform/comapi/NativeLoader:h	Ljava/lang/String;
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +181 -> 266
    //   88: aload_3
    //   89: invokevirtual 121	java/lang/String:isEmpty	()Z
    //   92: ifeq +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: new 222	java/util/zip/ZipFile
    //   100: dup
    //   101: aload_3
    //   102: invokespecial 223	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   105: astore_3
    //   106: aload_3
    //   107: aload 5
    //   109: invokevirtual 227	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   112: astore_2
    //   113: aload_2
    //   114: ifnonnull +22 -> 136
    //   117: aload_3
    //   118: invokevirtual 228	java/util/zip/ZipFile:close	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   127: ldc 230
    //   129: aload_1
    //   130: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   133: pop
    //   134: iconst_0
    //   135: ireturn
    //   136: new 135	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 137	com/baidu/mapsdkplatform/comapi/NativeLoader:b	()Ljava/lang/String;
    //   144: aload_1
    //   145: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: astore_1
    //   149: aload_0
    //   150: aload_3
    //   151: aload_2
    //   152: invokevirtual 234	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   155: new 90	java/io/FileOutputStream
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 237	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: invokespecial 239	com/baidu/mapsdkplatform/comapi/NativeLoader:a	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)V
    //   166: aload_3
    //   167: invokevirtual 228	java/util/zip/ZipFile:close	()V
    //   170: iconst_1
    //   171: ireturn
    //   172: astore_1
    //   173: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   176: ldc 230
    //   178: aload_1
    //   179: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   182: pop
    //   183: iconst_1
    //   184: ireturn
    //   185: astore_1
    //   186: aload_3
    //   187: astore_2
    //   188: goto +54 -> 242
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: aload_2
    //   195: astore_3
    //   196: goto +11 -> 207
    //   199: astore_1
    //   200: goto +42 -> 242
    //   203: astore_3
    //   204: aload 4
    //   206: astore_1
    //   207: aload_1
    //   208: astore_2
    //   209: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   212: ldc 241
    //   214: aload_3
    //   215: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   218: pop
    //   219: aload_1
    //   220: ifnull +20 -> 240
    //   223: aload_1
    //   224: invokevirtual 228	java/util/zip/ZipFile:close	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_1
    //   230: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   233: ldc 230
    //   235: aload_1
    //   236: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   239: pop
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_2
    //   243: ifnull +21 -> 264
    //   246: aload_2
    //   247: invokevirtual 228	java/util/zip/ZipFile:close	()V
    //   250: goto +14 -> 264
    //   253: astore_2
    //   254: getstatic 102	com/baidu/mapsdkplatform/comapi/NativeLoader:a	Ljava/lang/String;
    //   257: ldc 230
    //   259: aload_2
    //   260: invokestatic 109	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   263: pop
    //   264: aload_1
    //   265: athrow
    //   266: iconst_0
    //   267: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	NativeLoader
    //   0	268	1	paramString	String
    //   0	268	2	paramc	c
    //   12	184	3	localObject1	Object
    //   203	12	3	localException	Exception
    //   62	143	4	localObject2	Object
    //   59	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   117	121	123	java/io/IOException
    //   166	170	172	java/io/IOException
    //   106	113	185	finally
    //   136	166	185	finally
    //   106	113	191	java/lang/Exception
    //   136	166	191	java/lang/Exception
    //   97	106	199	finally
    //   209	219	199	finally
    //   97	106	203	java/lang/Exception
    //   223	227	229	java/io/IOException
    //   246	250	253	java/io/IOException
  }
  
  private String b()
  {
    if (b == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("libs");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(f.a());
    localObject = ((StringBuilder)localObject).toString();
    localObject = new File(b.getFilesDir(), (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  private boolean b(String paramString)
  {
    try
    {
      synchronized (c)
      {
        if (???.contains(paramString)) {
          return true;
        }
        System.loadLibrary(paramString);
        try
        {
          ???.add(paramString);
          return true;
        }
        finally {}
      }
      return a(paramString);
    }
    finally
    {
      localObject1.printStackTrace();
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (!a(paramString2, c.d)) {
      return d(paramString1, paramString2);
    }
    return g(paramString2, paramString1);
  }
  
  @TargetApi(21)
  private static c c()
  {
    Object localObject = android.os.Build.SUPPORTED_ABIS[0];
    if (localObject == null) {
      return c.b;
    }
    if ((((String)localObject).contains("arm")) && (((String)localObject).contains("v7"))) {
      f = c.c;
    }
    if ((((String)localObject).contains("arm")) && (((String)localObject).contains("64")) && (d())) {
      f = c.d;
    }
    if (((String)localObject).contains("x86"))
    {
      if (((String)localObject).contains("64")) {
        localObject = c.f;
      } else {
        localObject = c.e;
      }
      f = (c)localObject;
    }
    return f;
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    c localc = c.b;
    if (a(paramString2, localc)) {
      return g(paramString2, paramString1);
    }
    paramString2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("found lib ");
    localStringBuilder.append(localc.a());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".so error");
    Log.e(paramString2, localStringBuilder.toString());
    return false;
  }
  
  private static boolean d()
  {
    return Process.is64Bit();
  }
  
  private boolean d(String paramString1, String paramString2)
  {
    if (!a(paramString2, c.c)) {
      return c(paramString1, paramString2);
    }
    return g(paramString2, paramString1);
  }
  
  private boolean e(String paramString1, String paramString2)
  {
    if (!a(paramString2, c.f)) {
      return f(paramString1, paramString2);
    }
    return g(paramString2, paramString1);
  }
  
  private boolean f(String paramString1, String paramString2)
  {
    if (!a(paramString2, c.e)) {
      return d(paramString1, paramString2);
    }
    return g(paramString2, paramString1);
  }
  
  /* Error */
  private boolean g(String arg1, String paramString2)
  {
    // Byte code:
    //   0: new 135	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 137	com/baidu/mapsdkplatform/comapi/NativeLoader:b	()Ljava/lang/String;
    //   8: aload_1
    //   9: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokevirtual 259	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: invokestatic 262	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   18: getstatic 36	com/baidu/mapsdkplatform/comapi/NativeLoader:c	Ljava/util/Set;
    //   21: astore_3
    //   22: aload_3
    //   23: monitorenter
    //   24: aload_3
    //   25: aload_2
    //   26: invokeinterface 207 2 0
    //   31: pop
    //   32: aload_3
    //   33: monitorexit
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 309	com/baidu/mapsdkplatform/comapi/NativeLoader:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: iconst_1
    //   41: ireturn
    //   42: astore_1
    //   43: aload_3
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_3
    //   48: getstatic 38	com/baidu/mapsdkplatform/comapi/NativeLoader:d	Ljava/util/Set;
    //   51: astore_1
    //   52: aload_1
    //   53: monitorenter
    //   54: aload_1
    //   55: aload_2
    //   56: invokeinterface 207 2 0
    //   61: pop
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_0
    //   65: aload_3
    //   66: invokespecial 311	com/baidu/mapsdkplatform/comapi/NativeLoader:a	(Ljava/lang/Throwable;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	NativeLoader
    //   0	76	2	paramString2	String
    //   47	19	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	34	42	finally
    //   43	45	42	finally
    //   0	24	47	finally
    //   34	40	47	finally
    //   45	47	47	finally
    //   54	64	71	finally
    //   72	74	71	finally
  }
  
  public static NativeLoader getInstance()
  {
    try
    {
      if (e == null)
      {
        e = new NativeLoader();
        f = c();
      }
      NativeLoader localNativeLoader = e;
      return localNativeLoader;
    }
    finally {}
  }
  
  public static void setContext(Context paramContext)
  {
    b = paramContext;
  }
  
  public boolean loadLibrary(String paramString)
  {
    try
    {
      boolean bool;
      if (!g)
      {
        bool = b(paramString);
        return bool;
      }
      String str = h;
      if ((str != null) && (!str.isEmpty()))
      {
        bool = a(paramString);
        return bool;
      }
      Log.e(a, "Given custom so file path is null, please check!");
      return false;
    }
    finally {}
  }
  
  class a
    implements FilenameFilter
  {
    a(String paramString) {}
    
    public boolean accept(File paramFile, String paramString)
    {
      boolean bool2 = false;
      if (paramString == null) {
        return false;
      }
      boolean bool1 = bool2;
      if (paramString.contains("libBaiduMapSDK_"))
      {
        bool1 = bool2;
        if (!paramString.contains(paramString1)) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private static enum c
  {
    private String a;
    
    static
    {
      c localc1 = new c("ARMEABI", 0, "armeabi");
      b = localc1;
      c localc2 = new c("ARMV7", 1, "armeabi-v7a");
      c = localc2;
      c localc3 = new c("ARM64", 2, "arm64-v8a");
      d = localc3;
      c localc4 = new c("X86", 3, "x86");
      e = localc4;
      c localc5 = new c("X86_64", 4, "x86_64");
      f = localc5;
      g = new c[] { localc1, localc2, localc3, localc4, localc5 };
    }
    
    private c(String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.NativeLoader
 * JD-Core Version:    0.7.0.1
 */