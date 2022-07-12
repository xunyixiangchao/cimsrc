package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

public class a
{
  private static final boolean a = true;
  
  public static Bitmap a(String paramString, Context paramContext)
  {
    try
    {
      localObject = paramContext.getAssets().open(paramString);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeStream((InputStream)localObject);
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      Object localObject;
      label22:
      break label22;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("assets/");
    ((StringBuilder)localObject).append(paramString);
    return BitmapFactory.decodeFile(a(((StringBuilder)localObject).toString(), paramString, paramContext));
  }
  
  /* Error */
  private static String a(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: new 37	java/lang/StringBuilder
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 61	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: getstatic 10	com/baidu/mapsdkplatform/comapi/commonutils/a:a	Z
    //   19: ifeq +12 -> 31
    //   22: aload_2
    //   23: invokevirtual 72	android/content/Context:getPackageCodePath	()Ljava/lang/String;
    //   26: astore 5
    //   28: goto +7 -> 35
    //   31: ldc 74
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 6
    //   38: aconst_null
    //   39: astore 4
    //   41: new 76	java/util/zip/ZipFile
    //   44: dup
    //   45: aload 5
    //   47: invokespecial 77	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore 5
    //   52: aload_1
    //   53: ldc 79
    //   55: invokevirtual 85	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   58: istore_3
    //   59: iload_3
    //   60: ifle +90 -> 150
    //   63: new 63	java/io/File
    //   66: dup
    //   67: aload_2
    //   68: invokevirtual 61	android/content/Context:getFilesDir	()Ljava/io/File;
    //   71: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_2
    //   78: aload_1
    //   79: iconst_0
    //   80: iload_3
    //   81: invokevirtual 90	java/lang/String:substring	(II)Ljava/lang/String;
    //   84: astore 4
    //   86: aload_1
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: aload_1
    //   91: invokevirtual 94	java/lang/String:length	()I
    //   94: invokevirtual 90	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore_1
    //   98: new 37	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   105: astore 6
    //   107: aload 6
    //   109: aload_2
    //   110: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 6
    //   119: ldc 79
    //   121: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 6
    //   127: aload 4
    //   129: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: new 63	java/io/File
    //   136: dup
    //   137: aload 6
    //   139: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload_1
    //   143: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: astore_1
    //   147: goto +30 -> 177
    //   150: new 63	java/io/File
    //   153: dup
    //   154: aload_2
    //   155: invokevirtual 61	android/content/Context:getFilesDir	()Ljava/io/File;
    //   158: ldc 99
    //   160: invokespecial 102	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   163: astore_2
    //   164: new 63	java/io/File
    //   167: dup
    //   168: aload_2
    //   169: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   172: aload_1
    //   173: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: astore_1
    //   177: aload_2
    //   178: invokevirtual 106	java/io/File:mkdirs	()Z
    //   181: pop
    //   182: aload 5
    //   184: aload_0
    //   185: invokevirtual 110	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   188: astore_2
    //   189: aload_2
    //   190: ifnonnull +10 -> 200
    //   193: aload 5
    //   195: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   198: aconst_null
    //   199: areturn
    //   200: aload 5
    //   202: aload_2
    //   203: invokevirtual 117	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   206: new 119	java/io/FileOutputStream
    //   209: dup
    //   210: aload_1
    //   211: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   214: invokestatic 125	com/baidu/mapsdkplatform/comapi/commonutils/a:a	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)V
    //   217: aload 7
    //   219: ldc 79
    //   221: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 7
    //   227: aload_0
    //   228: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 5
    //   234: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   237: goto +49 -> 286
    //   240: astore_0
    //   241: aload 5
    //   243: astore 4
    //   245: goto +47 -> 292
    //   248: astore_1
    //   249: aload 5
    //   251: astore_0
    //   252: goto +11 -> 263
    //   255: astore_0
    //   256: goto +36 -> 292
    //   259: astore_1
    //   260: aload 6
    //   262: astore_0
    //   263: aload_0
    //   264: astore 4
    //   266: ldc 2
    //   268: invokevirtual 130	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   271: ldc 132
    //   273: aload_1
    //   274: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   277: pop
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   286: aload 7
    //   288: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: areturn
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 113	java/util/zip/ZipFile:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: aconst_null
    //   306: areturn
    //   307: astore_0
    //   308: goto -22 -> 286
    //   311: astore_1
    //   312: goto -10 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramString1	String
    //   0	315	1	paramString2	String
    //   0	315	2	paramContext	Context
    //   58	32	3	i	int
    //   39	259	4	localObject1	Object
    //   26	224	5	localObject2	Object
    //   36	225	6	localStringBuilder1	StringBuilder
    //   14	273	7	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   52	59	240	finally
    //   63	147	240	finally
    //   150	177	240	finally
    //   177	189	240	finally
    //   200	232	240	finally
    //   52	59	248	java/lang/Exception
    //   63	147	248	java/lang/Exception
    //   150	177	248	java/lang/Exception
    //   177	189	248	java/lang/Exception
    //   200	232	248	java/lang/Exception
    //   41	52	255	finally
    //   266	278	255	finally
    //   41	52	259	java/lang/Exception
    //   193	198	304	java/io/IOException
    //   232	237	307	java/io/IOException
    //   282	286	307	java/io/IOException
    //   297	302	311	java/io/IOException
  }
  
  /* Error */
  private static void a(InputStream paramInputStream, java.io.FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore_3
    //   6: aload_0
    //   7: aload_3
    //   8: invokevirtual 144	java/io/InputStream:read	([B)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +13 -> 27
    //   17: aload_1
    //   18: aload_3
    //   19: iconst_0
    //   20: iload_2
    //   21: invokevirtual 148	java/io/FileOutputStream:write	([BII)V
    //   24: goto -18 -> 6
    //   27: aload_1
    //   28: invokevirtual 151	java/io/FileOutputStream:flush	()V
    //   31: aload_0
    //   32: invokevirtual 152	java/io/InputStream:close	()V
    //   35: aload_1
    //   36: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   39: return
    //   40: astore_3
    //   41: aload_0
    //   42: invokevirtual 152	java/io/InputStream:close	()V
    //   45: aload_1
    //   46: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   49: aload_3
    //   50: athrow
    //   51: astore_0
    //   52: goto -17 -> 35
    //   55: astore_0
    //   56: return
    //   57: astore_0
    //   58: goto -13 -> 45
    //   61: astore_0
    //   62: goto -13 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramInputStream	InputStream
    //   0	65	1	paramFileOutputStream	java.io.FileOutputStream
    //   11	10	2	i	int
    //   5	14	3	arrayOfByte	byte[]
    //   40	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	40	finally
    //   17	24	40	finally
    //   27	31	40	finally
    //   31	35	51	java/io/IOException
    //   35	39	55	java/io/IOException
    //   41	45	57	java/io/IOException
    //   45	49	61	java/io/IOException
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.commonutils.a
 * JD-Core Version:    0.7.0.1
 */