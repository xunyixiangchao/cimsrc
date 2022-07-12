package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import z.b;

final class k1
  implements Runnable
{
  private final e1 a;
  private final int b;
  private final int c;
  private final z0.p d;
  private final Executor e;
  private final b f;
  private final Executor g;
  
  k1(e1 parame1, z0.p paramp, int paramInt1, int paramInt2, Executor paramExecutor1, Executor paramExecutor2, b paramb)
  {
    this.a = parame1;
    this.d = paramp;
    this.b = paramInt1;
    this.c = paramInt2;
    this.f = paramb;
    this.e = paramExecutor1;
    this.g = paramExecutor2;
  }
  
  /* Error */
  private void e(File paramFile, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 62	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore 4
    //   16: aload_1
    //   17: aload 4
    //   19: invokevirtual 70	java/io/InputStream:read	([B)I
    //   22: istore_3
    //   23: iload_3
    //   24: ifle +14 -> 38
    //   27: aload_2
    //   28: aload 4
    //   30: iconst_0
    //   31: iload_3
    //   32: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   35: goto -19 -> 16
    //   38: aload_1
    //   39: invokevirtual 79	java/io/InputStream:close	()V
    //   42: return
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 79	java/io/InputStream:close	()V
    //   48: goto +9 -> 57
    //   51: astore_1
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual 85	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	k1
    //   0	59	1	paramFile	File
    //   0	59	2	paramOutputStream	java.io.OutputStream
    //   22	10	3	i	int
    //   14	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	16	43	finally
    //   16	23	43	finally
    //   27	35	43	finally
    //   44	48	51	finally
  }
  
  /* Error */
  private boolean f(File paramFile, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   4: invokevirtual 91	androidx/camera/core/z0$p:a	()Landroid/content/ContentResolver;
    //   7: aload_2
    //   8: invokevirtual 97	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +13 -> 26
    //   16: aload_2
    //   17: ifnull +7 -> 24
    //   20: aload_2
    //   21: invokevirtual 98	java/io/OutputStream:close	()V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial 100	androidx/camera/core/k1:e	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   32: aload_2
    //   33: invokevirtual 98	java/io/OutputStream:close	()V
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 98	java/io/OutputStream:close	()V
    //   43: goto +9 -> 52
    //   46: astore_2
    //   47: aload_1
    //   48: aload_2
    //   49: invokevirtual 85	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	k1
    //   0	54	1	paramFile	File
    //   0	54	2	paramUri	Uri
    // Exception table:
    //   from	to	target	type
    //   26	32	38	finally
    //   39	43	46	finally
  }
  
  private byte[] g(e1 parame1, int paramInt)
  {
    boolean bool = b.n(parame1);
    int i = parame1.getFormat();
    if (i == 256)
    {
      if (!bool) {
        return b.i(parame1);
      }
      return b.j(parame1, parame1.C(), paramInt);
    }
    Rect localRect = null;
    if (i == 35)
    {
      if (bool) {
        localRect = parame1.C();
      }
      return b.p(parame1, localRect, paramInt);
    }
    parame1 = new StringBuilder();
    parame1.append("Unrecognized image format: ");
    parame1.append(i);
    n1.k("ImageSaver", parame1.toString());
    return null;
  }
  
  private boolean h()
  {
    return this.d.c() != null;
  }
  
  private boolean i()
  {
    return (this.d.f() != null) && (this.d.a() != null) && (this.d.b() != null);
  }
  
  private boolean j()
  {
    return this.d.e() != null;
  }
  
  private void n(c paramc, String paramString, Throwable paramThrowable)
  {
    try
    {
      this.e.execute(new i1(this, paramc, paramString, paramThrowable));
      return;
    }
    catch (RejectedExecutionException paramc)
    {
      label21:
      break label21;
    }
    n1.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
  }
  
  private void o(Uri paramUri)
  {
    try
    {
      this.e.execute(new h1(this, paramUri));
      return;
    }
    catch (RejectedExecutionException paramUri)
    {
      label19:
      break label19;
    }
    n1.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
  }
  
  /* Error */
  private File p()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 207	androidx/camera/core/k1:h	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq +69 -> 75
    //   9: aload_0
    //   10: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   13: invokevirtual 156	androidx/camera/core/z0$p:c	()Ljava/io/File;
    //   16: invokevirtual 212	java/io/File:getParent	()Ljava/lang/String;
    //   19: astore_3
    //   20: new 130	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 214
    //   33: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: invokestatic 220	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   42: invokevirtual 221	java/util/UUID:toString	()Ljava/lang/String;
    //   45: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: ldc 223
    //   53: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: new 209	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: aload 4
    //   64: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: astore 6
    //   72: goto +12 -> 84
    //   75: ldc 214
    //   77: ldc 223
    //   79: invokestatic 229	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   82: astore 6
    //   84: aload_0
    //   85: getfield 31	androidx/camera/core/k1:a	Landroidx/camera/core/e1;
    //   88: astore_3
    //   89: new 231	java/io/FileOutputStream
    //   92: dup
    //   93: aload 6
    //   95: invokespecial 232	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: astore 4
    //   100: aload 4
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 31	androidx/camera/core/k1:a	Landroidx/camera/core/e1;
    //   107: aload_0
    //   108: getfield 37	androidx/camera/core/k1:c	I
    //   111: invokespecial 234	androidx/camera/core/k1:g	(Landroidx/camera/core/e1;I)[B
    //   114: invokevirtual 237	java/io/FileOutputStream:write	([B)V
    //   117: aload 6
    //   119: invokestatic 242	androidx/camera/core/impl/utils/e:h	(Ljava/io/File;)Landroidx/camera/core/impl/utils/e;
    //   122: astore 5
    //   124: aload_0
    //   125: getfield 31	androidx/camera/core/k1:a	Landroidx/camera/core/e1;
    //   128: invokestatic 245	androidx/camera/core/impl/utils/e:j	(Landroidx/camera/core/e1;)Landroidx/camera/core/impl/utils/e;
    //   131: aload 5
    //   133: invokevirtual 248	androidx/camera/core/impl/utils/e:g	(Landroidx/camera/core/impl/utils/e;)V
    //   136: new 250	y/a
    //   139: dup
    //   140: invokespecial 251	y/a:<init>	()V
    //   143: aload_0
    //   144: getfield 31	androidx/camera/core/k1:a	Landroidx/camera/core/e1;
    //   147: invokevirtual 253	y/a:b	(Landroidx/camera/core/e1;)Z
    //   150: ifne +12 -> 162
    //   153: aload 5
    //   155: aload_0
    //   156: getfield 35	androidx/camera/core/k1:b	I
    //   159: invokevirtual 257	androidx/camera/core/impl/utils/e:z	(I)V
    //   162: aload_0
    //   163: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   166: invokevirtual 260	androidx/camera/core/z0$p:d	()Landroidx/camera/core/z0$m;
    //   169: astore 7
    //   171: aload 7
    //   173: invokevirtual 264	androidx/camera/core/z0$m:b	()Z
    //   176: ifeq +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 266	androidx/camera/core/impl/utils/e:l	()V
    //   184: aload 7
    //   186: invokevirtual 268	androidx/camera/core/z0$m:c	()Z
    //   189: ifeq +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 270	androidx/camera/core/impl/utils/e:m	()V
    //   197: aload 7
    //   199: invokevirtual 273	androidx/camera/core/z0$m:a	()Landroid/location/Location;
    //   202: ifnull +18 -> 220
    //   205: aload 5
    //   207: aload_0
    //   208: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   211: invokevirtual 260	androidx/camera/core/z0$p:d	()Landroidx/camera/core/z0$m;
    //   214: invokevirtual 273	androidx/camera/core/z0$m:a	()Landroid/location/Location;
    //   217: invokevirtual 276	androidx/camera/core/impl/utils/e:b	(Landroid/location/Location;)V
    //   220: aload 5
    //   222: invokevirtual 279	androidx/camera/core/impl/utils/e:A	()V
    //   225: aload 4
    //   227: invokevirtual 280	java/io/FileOutputStream:close	()V
    //   230: aload_3
    //   231: ifnull +9 -> 240
    //   234: aload_3
    //   235: invokeinterface 281 1 0
    //   240: aconst_null
    //   241: astore 5
    //   243: aload 5
    //   245: astore_3
    //   246: aload_3
    //   247: astore 4
    //   249: goto +127 -> 376
    //   252: astore 5
    //   254: aload 4
    //   256: invokevirtual 280	java/io/FileOutputStream:close	()V
    //   259: goto +12 -> 271
    //   262: astore 4
    //   264: aload 5
    //   266: aload 4
    //   268: invokevirtual 85	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   271: aload 5
    //   273: athrow
    //   274: astore 4
    //   276: aload_3
    //   277: ifnull +19 -> 296
    //   280: aload_3
    //   281: invokeinterface 281 1 0
    //   286: goto +10 -> 296
    //   289: astore_3
    //   290: aload 4
    //   292: aload_3
    //   293: invokevirtual 85	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: aload 4
    //   298: athrow
    //   299: astore 5
    //   301: getstatic 284	androidx/camera/core/k1$a:a	[I
    //   304: aload 5
    //   306: invokevirtual 287	z/b$a:a	()Lz/b$a$a;
    //   309: invokevirtual 292	java/lang/Enum:ordinal	()I
    //   312: iaload
    //   313: istore_1
    //   314: iload_1
    //   315: iconst_1
    //   316: if_icmpeq +32 -> 348
    //   319: iload_1
    //   320: iconst_2
    //   321: if_icmpeq +15 -> 336
    //   324: getstatic 295	androidx/camera/core/k1$c:d	Landroidx/camera/core/k1$c;
    //   327: astore_3
    //   328: ldc_w 297
    //   331: astore 4
    //   333: goto +43 -> 376
    //   336: getstatic 299	androidx/camera/core/k1$c:c	Landroidx/camera/core/k1$c;
    //   339: astore_3
    //   340: ldc_w 301
    //   343: astore 4
    //   345: goto +31 -> 376
    //   348: getstatic 303	androidx/camera/core/k1$c:b	Landroidx/camera/core/k1$c;
    //   351: astore_3
    //   352: ldc_w 305
    //   355: astore 4
    //   357: goto +19 -> 376
    //   360: astore 5
    //   362: goto +5 -> 367
    //   365: astore 5
    //   367: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   370: astore_3
    //   371: ldc_w 309
    //   374: astore 4
    //   376: aload_3
    //   377: ifnull +20 -> 397
    //   380: aload_0
    //   381: aload_3
    //   382: aload 4
    //   384: aload 5
    //   386: invokespecial 311	androidx/camera/core/k1:n	(Landroidx/camera/core/k1$c;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   389: aload 6
    //   391: invokevirtual 314	java/io/File:delete	()Z
    //   394: pop
    //   395: aconst_null
    //   396: areturn
    //   397: aload 6
    //   399: areturn
    //   400: astore_3
    //   401: aload_0
    //   402: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   405: ldc_w 316
    //   408: aload_3
    //   409: invokespecial 311	androidx/camera/core/k1:n	(Landroidx/camera/core/k1$c;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   412: aconst_null
    //   413: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	k1
    //   313	9	1	i	int
    //   4	2	2	bool	boolean
    //   19	262	3	localObject1	Object
    //   289	4	3	localThrowable1	Throwable
    //   327	55	3	localc	c
    //   400	9	3	localIOException1	java.io.IOException
    //   27	228	4	localObject2	Object
    //   262	5	4	localThrowable2	Throwable
    //   274	23	4	localObject3	Object
    //   331	52	4	str	String
    //   122	122	5	locale	androidx.camera.core.impl.utils.e
    //   252	20	5	localObject4	Object
    //   299	6	5	locala	z.b.a
    //   360	1	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   365	20	5	localIOException2	java.io.IOException
    //   70	328	6	localFile	File
    //   169	29	7	localm	z0.m
    // Exception table:
    //   from	to	target	type
    //   100	162	252	finally
    //   162	184	252	finally
    //   184	197	252	finally
    //   197	220	252	finally
    //   220	225	252	finally
    //   254	259	262	finally
    //   89	100	274	finally
    //   225	230	274	finally
    //   264	271	274	finally
    //   271	274	274	finally
    //   280	286	289	finally
    //   84	89	299	z/b$a
    //   234	240	299	z/b$a
    //   290	296	299	z/b$a
    //   296	299	299	z/b$a
    //   84	89	360	java/lang/IllegalArgumentException
    //   234	240	360	java/lang/IllegalArgumentException
    //   290	296	360	java/lang/IllegalArgumentException
    //   296	299	360	java/lang/IllegalArgumentException
    //   84	89	365	java/io/IOException
    //   234	240	365	java/io/IOException
    //   290	296	365	java/io/IOException
    //   296	299	365	java/io/IOException
    //   0	5	400	java/io/IOException
    //   9	72	400	java/io/IOException
    //   75	84	400	java/io/IOException
  }
  
  private void q(ContentValues paramContentValues, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      paramContentValues.put("is_pending", Integer.valueOf(paramInt));
    }
  }
  
  private void r(Uri paramUri)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      ContentValues localContentValues = new ContentValues();
      q(localContentValues, 0);
      this.d.a().update(paramUri, localContentValues, null, null);
    }
  }
  
  /* Error */
  void d(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 350	x0/h:g	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: invokespecial 352	androidx/camera/core/k1:i	()Z
    //   12: ifeq +121 -> 133
    //   15: aload_0
    //   16: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   19: invokevirtual 162	androidx/camera/core/z0$p:b	()Landroid/content/ContentValues;
    //   22: ifnull +21 -> 43
    //   25: new 333	android/content/ContentValues
    //   28: dup
    //   29: aload_0
    //   30: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   33: invokevirtual 162	androidx/camera/core/z0$p:b	()Landroid/content/ContentValues;
    //   36: invokespecial 355	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   39: astore_2
    //   40: goto +11 -> 51
    //   43: new 333	android/content/ContentValues
    //   46: dup
    //   47: invokespecial 339	android/content/ContentValues:<init>	()V
    //   50: astore_2
    //   51: aload_0
    //   52: aload_2
    //   53: iconst_1
    //   54: invokespecial 341	androidx/camera/core/k1:q	(Landroid/content/ContentValues;I)V
    //   57: aload_0
    //   58: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   61: invokevirtual 91	androidx/camera/core/z0$p:a	()Landroid/content/ContentResolver;
    //   64: aload_0
    //   65: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   68: invokevirtual 159	androidx/camera/core/z0$p:f	()Landroid/net/Uri;
    //   71: aload_2
    //   72: invokevirtual 359	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnonnull +14 -> 93
    //   82: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   85: astore_2
    //   86: ldc_w 361
    //   89: astore_3
    //   90: goto +159 -> 249
    //   93: aload_0
    //   94: aload_1
    //   95: aload 4
    //   97: invokespecial 363	androidx/camera/core/k1:f	(Ljava/io/File;Landroid/net/Uri;)Z
    //   100: ifne +181 -> 281
    //   103: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   106: astore_2
    //   107: ldc_w 365
    //   110: astore_3
    //   111: goto +3 -> 114
    //   114: aload_0
    //   115: aload 4
    //   117: invokespecial 367	androidx/camera/core/k1:r	(Landroid/net/Uri;)V
    //   120: goto +129 -> 249
    //   123: astore 5
    //   125: goto +116 -> 241
    //   128: astore 5
    //   130: goto +111 -> 241
    //   133: aload_0
    //   134: invokespecial 369	androidx/camera/core/k1:j	()Z
    //   137: ifeq +18 -> 155
    //   140: aload_0
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   146: invokevirtual 165	androidx/camera/core/z0$p:e	()Ljava/io/OutputStream;
    //   149: invokespecial 100	androidx/camera/core/k1:e	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   152: goto +63 -> 215
    //   155: aload_0
    //   156: invokespecial 207	androidx/camera/core/k1:h	()Z
    //   159: ifeq +56 -> 215
    //   162: aload_0
    //   163: getfield 33	androidx/camera/core/k1:d	Landroidx/camera/core/z0$p;
    //   166: invokevirtual 156	androidx/camera/core/z0$p:c	()Ljava/io/File;
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 372	java/io/File:exists	()Z
    //   176: ifeq +9 -> 185
    //   179: aload 4
    //   181: invokevirtual 314	java/io/File:delete	()Z
    //   184: pop
    //   185: aload_1
    //   186: aload 4
    //   188: invokevirtual 376	java/io/File:renameTo	(Ljava/io/File;)Z
    //   191: ifne +97 -> 288
    //   194: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   197: astore_2
    //   198: ldc_w 378
    //   201: astore_3
    //   202: goto +3 -> 205
    //   205: aload 4
    //   207: invokestatic 384	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   210: astore 4
    //   212: goto +37 -> 249
    //   215: aconst_null
    //   216: astore 4
    //   218: aload 4
    //   220: astore_2
    //   221: aload_2
    //   222: astore_3
    //   223: goto +26 -> 249
    //   226: astore_2
    //   227: goto +47 -> 274
    //   230: astore_2
    //   231: goto +4 -> 235
    //   234: astore_2
    //   235: aconst_null
    //   236: astore 4
    //   238: aload_2
    //   239: astore 5
    //   241: getstatic 307	androidx/camera/core/k1$c:a	Landroidx/camera/core/k1$c;
    //   244: astore_2
    //   245: ldc_w 386
    //   248: astore_3
    //   249: aload_1
    //   250: invokevirtual 314	java/io/File:delete	()Z
    //   253: pop
    //   254: aload_2
    //   255: ifnull +12 -> 267
    //   258: aload_0
    //   259: aload_2
    //   260: aload_3
    //   261: aload 5
    //   263: invokespecial 311	androidx/camera/core/k1:n	(Landroidx/camera/core/k1$c;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: return
    //   267: aload_0
    //   268: aload 4
    //   270: invokespecial 388	androidx/camera/core/k1:o	(Landroid/net/Uri;)V
    //   273: return
    //   274: aload_1
    //   275: invokevirtual 314	java/io/File:delete	()Z
    //   278: pop
    //   279: aload_2
    //   280: athrow
    //   281: aconst_null
    //   282: astore_2
    //   283: aload_2
    //   284: astore_3
    //   285: goto -171 -> 114
    //   288: aconst_null
    //   289: astore_2
    //   290: aload_2
    //   291: astore_3
    //   292: goto -87 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	k1
    //   0	295	1	paramFile	File
    //   39	183	2	localObject1	Object
    //   226	1	2	localObject2	Object
    //   230	1	2	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   234	5	2	localIOException1	java.io.IOException
    //   244	47	2	localc	c
    //   89	203	3	localObject3	Object
    //   75	194	4	localObject4	Object
    //   6	1	5	localObject5	Object
    //   123	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   128	1	5	localIOException2	java.io.IOException
    //   239	23	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   82	86	123	java/lang/IllegalArgumentException
    //   93	107	123	java/lang/IllegalArgumentException
    //   114	120	123	java/lang/IllegalArgumentException
    //   82	86	128	java/io/IOException
    //   93	107	128	java/io/IOException
    //   114	120	128	java/io/IOException
    //   8	40	226	finally
    //   43	51	226	finally
    //   51	77	226	finally
    //   82	86	226	finally
    //   93	107	226	finally
    //   114	120	226	finally
    //   133	152	226	finally
    //   155	185	226	finally
    //   185	198	226	finally
    //   205	212	226	finally
    //   241	245	226	finally
    //   8	40	230	java/lang/IllegalArgumentException
    //   43	51	230	java/lang/IllegalArgumentException
    //   51	77	230	java/lang/IllegalArgumentException
    //   133	152	230	java/lang/IllegalArgumentException
    //   155	185	230	java/lang/IllegalArgumentException
    //   185	198	230	java/lang/IllegalArgumentException
    //   205	212	230	java/lang/IllegalArgumentException
    //   8	40	234	java/io/IOException
    //   43	51	234	java/io/IOException
    //   51	77	234	java/io/IOException
    //   133	152	234	java/io/IOException
    //   155	185	234	java/io/IOException
    //   185	198	234	java/io/IOException
    //   205	212	234	java/io/IOException
  }
  
  public void run()
  {
    File localFile = p();
    if (localFile != null) {
      this.g.execute(new j1(this, localFile));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(k1.c paramc, String paramString, Throwable paramThrowable);
    
    public abstract void d(z0.q paramq);
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("FILE_IO_FAILED", 0);
      a = localc1;
      c localc2 = new c("ENCODE_FAILED", 1);
      b = localc2;
      c localc3 = new c("CROP_FAILED", 2);
      c = localc3;
      c localc4 = new c("UNKNOWN", 3);
      d = localc4;
      e = new c[] { localc1, localc2, localc3, localc4 };
    }
    
    private c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.k1
 * JD-Core Version:    0.7.0.1
 */