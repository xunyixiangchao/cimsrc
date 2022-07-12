package com.baidu.platform.comapi.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.File;

public class c
{
  public static final c b = new c();
  private final SharedPreferences a = com.baidu.platform.comapi.b.b().getSharedPreferences("engine_resource_sp", 0);
  
  private String a()
  {
    String str = SysOSUtil.getInstance().getOutputDirPath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private static void a(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if ((!paramFile.isFile()) && ((!paramFile.exists()) || (paramFile.list() == null) || (paramFile.list().length != 0)))
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          arrayOfFile[i].delete();
          i += 1;
        }
      }
      if (!paramFile.exists()) {}
    }
    else
    {
      paramFile.delete();
    }
  }
  
  private void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    paramString = new File(paramString, "shader/");
    if (!paramString.exists())
    {
      this.a.edit().putString("fingerprint", Build.FINGERPRINT).commit();
      return;
    }
    String str = this.a.getString("fingerprint", "");
    if ((!TextUtils.isEmpty(str)) && (Build.FINGERPRINT.equals(str))) {
      return;
    }
    a(paramString);
    if (!paramString.exists()) {
      this.a.edit().putString("fingerprint", Build.FINGERPRINT).commit();
    }
  }
  
  /* Error */
  private boolean a(AssetManager paramAssetManager, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aload 10
    //   11: astore 7
    //   13: aload 11
    //   15: astore 8
    //   17: aload_3
    //   18: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +379 -> 400
    //   24: aload 10
    //   26: astore 7
    //   28: aload 11
    //   30: astore 8
    //   32: aload_3
    //   33: ldc 122
    //   35: invokevirtual 126	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   38: ifeq +362 -> 400
    //   41: aload 10
    //   43: astore 7
    //   45: aload 11
    //   47: astore 8
    //   49: aload_3
    //   50: iconst_0
    //   51: aload_3
    //   52: ldc 122
    //   54: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   57: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
    //   60: astore 12
    //   62: aload 10
    //   64: astore 7
    //   66: aload 11
    //   68: astore 8
    //   70: aload 4
    //   72: iconst_0
    //   73: aload 4
    //   75: ldc 122
    //   77: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore 4
    //   85: aload 10
    //   87: astore 7
    //   89: aload 11
    //   91: astore 8
    //   93: aload_1
    //   94: aload 12
    //   96: invokevirtual 139	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   99: astore 13
    //   101: aload 9
    //   103: astore_3
    //   104: aload 13
    //   106: ifnull +423 -> 529
    //   109: aload 9
    //   111: astore_3
    //   112: aload 10
    //   114: astore 7
    //   116: aload 11
    //   118: astore 8
    //   120: aload 13
    //   122: arraylength
    //   123: ifle +406 -> 529
    //   126: aload 10
    //   128: astore 7
    //   130: aload 11
    //   132: astore 8
    //   134: new 44	java/io/File
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload 10
    //   146: astore 7
    //   148: aload 11
    //   150: astore 8
    //   152: aload_3
    //   153: invokevirtual 51	java/io/File:exists	()Z
    //   156: ifeq +16 -> 172
    //   159: aload 10
    //   161: astore 7
    //   163: aload 11
    //   165: astore 8
    //   167: aload_3
    //   168: invokevirtual 71	java/io/File:delete	()Z
    //   171: pop
    //   172: aload 10
    //   174: astore 7
    //   176: aload 11
    //   178: astore 8
    //   180: aload_3
    //   181: invokevirtual 54	java/io/File:mkdirs	()Z
    //   184: pop
    //   185: aload 10
    //   187: astore 7
    //   189: aload 11
    //   191: astore 8
    //   193: aload 13
    //   195: arraylength
    //   196: istore 6
    //   198: iconst_0
    //   199: istore 5
    //   201: aload 9
    //   203: astore_3
    //   204: iload 5
    //   206: iload 6
    //   208: if_icmpge +321 -> 529
    //   211: aload 13
    //   213: iload 5
    //   215: aaload
    //   216: astore_3
    //   217: aload 10
    //   219: astore 7
    //   221: aload 11
    //   223: astore 8
    //   225: aload_3
    //   226: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifne +325 -> 554
    //   232: aload 10
    //   234: astore 7
    //   236: aload 11
    //   238: astore 8
    //   240: new 141	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   247: astore 14
    //   249: aload 10
    //   251: astore 7
    //   253: aload 11
    //   255: astore 8
    //   257: aload 14
    //   259: aload 12
    //   261: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 10
    //   267: astore 7
    //   269: aload 11
    //   271: astore 8
    //   273: aload 14
    //   275: ldc 148
    //   277: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: astore 7
    //   285: aload 11
    //   287: astore 8
    //   289: aload 14
    //   291: aload_3
    //   292: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 10
    //   298: astore 7
    //   300: aload 11
    //   302: astore 8
    //   304: aload 14
    //   306: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore 14
    //   311: aload 10
    //   313: astore 7
    //   315: aload 11
    //   317: astore 8
    //   319: new 141	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   326: astore 15
    //   328: aload 10
    //   330: astore 7
    //   332: aload 11
    //   334: astore 8
    //   336: aload 15
    //   338: aload 4
    //   340: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 10
    //   346: astore 7
    //   348: aload 11
    //   350: astore 8
    //   352: aload 15
    //   354: ldc 148
    //   356: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 10
    //   362: astore 7
    //   364: aload 11
    //   366: astore 8
    //   368: aload 15
    //   370: aload_3
    //   371: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 10
    //   377: astore 7
    //   379: aload 11
    //   381: astore 8
    //   383: aload_0
    //   384: aload_1
    //   385: aload_2
    //   386: aload 14
    //   388: aload 15
    //   390: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokespecial 153	com/baidu/platform/comapi/d/c:a	(Landroid/content/res/AssetManager;[BLjava/lang/String;Ljava/lang/String;)Z
    //   396: pop
    //   397: goto +157 -> 554
    //   400: aload 10
    //   402: astore 7
    //   404: aload 11
    //   406: astore 8
    //   408: aload_1
    //   409: aload_3
    //   410: invokevirtual 157	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   413: astore_1
    //   414: aload_1
    //   415: astore 7
    //   417: aload_1
    //   418: astore 8
    //   420: new 44	java/io/File
    //   423: dup
    //   424: aload 4
    //   426: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   429: astore_3
    //   430: aload_1
    //   431: astore 7
    //   433: aload_1
    //   434: astore 8
    //   436: aload_3
    //   437: invokevirtual 161	java/io/File:getParentFile	()Ljava/io/File;
    //   440: astore 4
    //   442: aload 4
    //   444: ifnull +29 -> 473
    //   447: aload_1
    //   448: astore 7
    //   450: aload_1
    //   451: astore 8
    //   453: aload 4
    //   455: invokevirtual 164	java/io/File:isDirectory	()Z
    //   458: ifne +15 -> 473
    //   461: aload_1
    //   462: astore 7
    //   464: aload_1
    //   465: astore 8
    //   467: aload 4
    //   469: invokevirtual 54	java/io/File:mkdirs	()Z
    //   472: pop
    //   473: aload_1
    //   474: astore 7
    //   476: aload_1
    //   477: astore 8
    //   479: aload_3
    //   480: invokevirtual 51	java/io/File:exists	()Z
    //   483: ifeq +14 -> 497
    //   486: aload_1
    //   487: astore 7
    //   489: aload_1
    //   490: astore 8
    //   492: aload_3
    //   493: invokevirtual 71	java/io/File:delete	()Z
    //   496: pop
    //   497: aload_1
    //   498: astore 7
    //   500: aload_1
    //   501: astore 8
    //   503: aload_3
    //   504: invokevirtual 167	java/io/File:createNewFile	()Z
    //   507: pop
    //   508: aload_1
    //   509: astore 7
    //   511: aload_1
    //   512: astore 8
    //   514: aload_1
    //   515: new 169	java/io/FileOutputStream
    //   518: dup
    //   519: aload_3
    //   520: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   523: aload_2
    //   524: invokestatic 176	com/baidu/platform/comapi/d/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   527: aload_1
    //   528: astore_3
    //   529: aload_3
    //   530: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   533: iconst_1
    //   534: ireturn
    //   535: astore_1
    //   536: aload 7
    //   538: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   541: aload_1
    //   542: athrow
    //   543: aload 8
    //   545: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   548: iconst_0
    //   549: ireturn
    //   550: astore_1
    //   551: goto -8 -> 543
    //   554: iload 5
    //   556: iconst_1
    //   557: iadd
    //   558: istore 5
    //   560: goto -359 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	c
    //   0	563	1	paramAssetManager	AssetManager
    //   0	563	2	paramArrayOfByte	byte[]
    //   0	563	3	paramString1	String
    //   0	563	4	paramString2	String
    //   199	360	5	i	int
    //   196	13	6	j	int
    //   11	526	7	localObject1	Object
    //   15	529	8	localObject2	Object
    //   7	195	9	localObject3	Object
    //   1	400	10	localObject4	Object
    //   4	401	11	localObject5	Object
    //   60	200	12	str	String
    //   99	113	13	arrayOfString	String[]
    //   247	140	14	localObject6	Object
    //   326	63	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	24	535	finally
    //   32	41	535	finally
    //   49	62	535	finally
    //   70	85	535	finally
    //   93	101	535	finally
    //   120	126	535	finally
    //   134	144	535	finally
    //   152	159	535	finally
    //   167	172	535	finally
    //   180	185	535	finally
    //   193	198	535	finally
    //   225	232	535	finally
    //   240	249	535	finally
    //   257	265	535	finally
    //   273	281	535	finally
    //   289	296	535	finally
    //   304	311	535	finally
    //   319	328	535	finally
    //   336	344	535	finally
    //   352	360	535	finally
    //   368	375	535	finally
    //   383	397	535	finally
    //   408	414	535	finally
    //   420	430	535	finally
    //   436	442	535	finally
    //   453	461	535	finally
    //   467	473	535	finally
    //   479	486	535	finally
    //   492	497	535	finally
    //   503	508	535	finally
    //   514	527	535	finally
    //   17	24	550	java/lang/Exception
    //   32	41	550	java/lang/Exception
    //   49	62	550	java/lang/Exception
    //   70	85	550	java/lang/Exception
    //   93	101	550	java/lang/Exception
    //   120	126	550	java/lang/Exception
    //   134	144	550	java/lang/Exception
    //   152	159	550	java/lang/Exception
    //   167	172	550	java/lang/Exception
    //   180	185	550	java/lang/Exception
    //   193	198	550	java/lang/Exception
    //   225	232	550	java/lang/Exception
    //   240	249	550	java/lang/Exception
    //   257	265	550	java/lang/Exception
    //   273	281	550	java/lang/Exception
    //   289	296	550	java/lang/Exception
    //   304	311	550	java/lang/Exception
    //   319	328	550	java/lang/Exception
    //   336	344	550	java/lang/Exception
    //   352	360	550	java/lang/Exception
    //   368	375	550	java/lang/Exception
    //   383	397	550	java/lang/Exception
    //   408	414	550	java/lang/Exception
    //   420	430	550	java/lang/Exception
    //   436	442	550	java/lang/Exception
    //   453	461	550	java/lang/Exception
    //   467	473	550	java/lang/Exception
    //   479	486	550	java/lang/Exception
    //   492	497	550	java/lang/Exception
    //   503	508	550	java/lang/Exception
    //   514	527	550	java/lang/Exception
  }
  
  /* Error */
  private boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +71 -> 72
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_1
    //   16: invokevirtual 51	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 71	java/io/File:delete	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 167	java/io/File:createNewFile	()Z
    //   31: pop
    //   32: new 169	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: astore_1
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 184	java/io/FileOutputStream:write	([B)V
    //   46: aload_1
    //   47: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   50: iconst_1
    //   51: ireturn
    //   52: astore_2
    //   53: goto +9 -> 62
    //   56: goto +12 -> 68
    //   59: astore_2
    //   60: aload_3
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   66: aload_2
    //   67: athrow
    //   68: aload_1
    //   69: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload 4
    //   77: astore_1
    //   78: goto -10 -> 68
    //   81: astore_2
    //   82: goto -26 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	c
    //   0	85	1	paramFile	File
    //   0	85	2	paramArrayOfByte	byte[]
    //   14	47	3	localObject1	Object
    //   11	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	46	52	finally
    //   15	27	59	finally
    //   27	41	59	finally
    //   15	27	74	java/lang/Exception
    //   27	41	74	java/lang/Exception
    //   41	46	81	java/lang/Exception
  }
  
  /* Error */
  private boolean b(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +84 -> 85
    //   4: aload_1
    //   5: invokevirtual 51	java/io/File:exists	()Z
    //   8: ifeq +77 -> 85
    //   11: aload_2
    //   12: ifnonnull +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: new 188	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 193	java/io/FileInputStream:available	()I
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_1
    //   41: aload 4
    //   43: invokevirtual 197	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload 4
    //   49: aload_2
    //   50: invokestatic 202	java/util/Arrays:equals	([B[B)Z
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +13 -> 68
    //   58: aload_1
    //   59: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_2
    //   65: goto +10 -> 75
    //   68: goto +13 -> 81
    //   71: astore_2
    //   72: aload 4
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   79: aload_2
    //   80: athrow
    //   81: aload_1
    //   82: invokestatic 179	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: aload 5
    //   90: astore_1
    //   91: goto -10 -> 81
    //   94: astore_2
    //   95: goto -27 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	c
    //   0	98	1	paramFile	File
    //   0	98	2	paramArrayOfByte	byte[]
    //   53	2	3	bool	boolean
    //   21	52	4	arrayOfByte	byte[]
    //   18	71	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	54	64	finally
    //   23	32	71	finally
    //   23	32	87	java/io/IOException
    //   32	54	94	java/io/IOException
  }
  
  public void a(b paramb)
  {
    Object localObject3;
    boolean bool4;
    String str1;
    int j;
    int i;
    label104:
    try
    {
      localObject3 = com.baidu.platform.comapi.b.b();
      bool3 = false;
      localObject1 = null;
      localObject2 = null;
      bool1 = true;
      bool5 = true;
      bool4 = true;
    }
    finally {}
    try
    {
      str1 = a();
      localFile = new File(str1, "/ver.dat");
      localObject2 = localObject1;
    }
    catch (RuntimeException|Exception paramb)
    {
      label187:
      break label201;
    }
    try
    {
      localObject1 = paramb.a();
      localObject2 = localObject1;
      bool2 = b(localFile, (byte[])localObject1);
      if (!bool2) {}
    }
    catch (RuntimeException|Exception paramb)
    {
      paramb = (b)localObject2;
      bool1 = bool5;
      localObject1 = localFile;
      break label211;
    }
    try
    {
      localObject2 = ((Context)localObject3).getAssets();
      paramb = paramb.b();
      localObject3 = new byte[65536];
      j = paramb.length;
      i = 0;
      bool1 = bool4;
      if (i < j)
      {
        String str2 = paramb[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("/");
        localStringBuilder.append(str2);
        bool1 = a((AssetManager)localObject2, (byte[])localObject3, str2, localStringBuilder.toString());
        i += 1;
        break label104;
      }
      a(str1);
      paramb = (b)localObject1;
      localObject1 = localFile;
    }
    catch (RuntimeException|Exception paramb)
    {
      break label187;
    }
    bool1 = bool2;
    paramb = (b)localObject1;
    localObject1 = localFile;
    break label211;
    label201:
    localObject1 = null;
    bool1 = bool5;
    paramb = (b)localObject2;
    label211:
    boolean bool2 = bool1;
    bool1 = bool3;
    boolean bool3 = bool1;
    if (bool2)
    {
      bool3 = bool1;
      if (bool1) {
        bool3 = a((File)localObject1, paramb);
      }
    }
    if (OpenLogUtil.isMapLogEnable())
    {
      paramb = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initEngineRes firstInit = ");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append("; isInitSucceed = ");
      ((StringBuilder)localObject1).append(bool3);
      paramb.a(((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.d.c
 * JD-Core Version:    0.7.0.1
 */