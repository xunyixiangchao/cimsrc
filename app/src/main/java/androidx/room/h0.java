package androidx.room;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Objects;
import java.util.concurrent.Callable;
import o1.d;
import p1.g;

class h0
  implements p1.h, i
{
  private final Context a;
  private final String b;
  private final File c;
  private final Callable<InputStream> d;
  private final int e;
  private final p1.h f;
  private h g;
  private boolean h;
  
  h0(Context paramContext, String paramString, File paramFile, Callable<InputStream> paramCallable, int paramInt, p1.h paramh)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramFile;
    this.d = paramCallable;
    this.e = paramInt;
    this.f = paramh;
  }
  
  /* Error */
  private void B(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	androidx/room/h0:getDatabaseName	()Ljava/lang/String;
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 32	androidx/room/h0:a	Landroid/content/Context;
    //   10: aload 6
    //   12: invokevirtual 59	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   15: astore 7
    //   17: aload_0
    //   18: getfield 61	androidx/room/h0:g	Landroidx/room/h;
    //   21: astore 5
    //   23: aload 5
    //   25: ifnull +20 -> 45
    //   28: aload 5
    //   30: getfield 66	androidx/room/h:l	Z
    //   33: ifeq +6 -> 39
    //   36: goto +9 -> 45
    //   39: iconst_0
    //   40: istore 4
    //   42: goto +6 -> 48
    //   45: iconst_1
    //   46: istore 4
    //   48: new 68	o1/a
    //   51: dup
    //   52: aload 6
    //   54: aload_0
    //   55: getfield 32	androidx/room/h0:a	Landroid/content/Context;
    //   58: invokevirtual 72	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: iload 4
    //   63: invokespecial 75	o1/a:<init>	(Ljava/lang/String;Ljava/io/File;Z)V
    //   66: astore 5
    //   68: aload 5
    //   70: invokevirtual 77	o1/a:b	()V
    //   73: aload 7
    //   75: invokevirtual 83	java/io/File:exists	()Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifne +30 -> 112
    //   85: aload_0
    //   86: aload 7
    //   88: iload_1
    //   89: invokespecial 86	androidx/room/h0:g	(Ljava/io/File;Z)V
    //   92: aload 5
    //   94: invokevirtual 88	o1/a:c	()V
    //   97: return
    //   98: astore 6
    //   100: new 90	java/lang/RuntimeException
    //   103: dup
    //   104: ldc 92
    //   106: aload 6
    //   108: invokespecial 95	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: athrow
    //   112: aload_0
    //   113: getfield 61	androidx/room/h0:g	Landroidx/room/h;
    //   116: astore 8
    //   118: aload 8
    //   120: ifnonnull +9 -> 129
    //   123: aload 5
    //   125: invokevirtual 88	o1/a:c	()V
    //   128: return
    //   129: aload 7
    //   131: invokestatic 100	o1/c:c	(Ljava/io/File;)I
    //   134: istore_2
    //   135: aload_0
    //   136: getfield 40	androidx/room/h0:e	I
    //   139: istore_3
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmpne +9 -> 151
    //   145: aload 5
    //   147: invokevirtual 88	o1/a:c	()V
    //   150: return
    //   151: aload_0
    //   152: getfield 61	androidx/room/h0:g	Landroidx/room/h;
    //   155: iload_2
    //   156: iload_3
    //   157: invokevirtual 103	androidx/room/h:a	(II)Z
    //   160: istore 4
    //   162: iload 4
    //   164: ifeq +9 -> 173
    //   167: aload 5
    //   169: invokevirtual 88	o1/a:c	()V
    //   172: return
    //   173: aload_0
    //   174: getfield 32	androidx/room/h0:a	Landroid/content/Context;
    //   177: aload 6
    //   179: invokevirtual 107	android/content/Context:deleteDatabase	(Ljava/lang/String;)Z
    //   182: istore 4
    //   184: iload 4
    //   186: ifeq +28 -> 214
    //   189: aload_0
    //   190: aload 7
    //   192: iload_1
    //   193: invokespecial 86	androidx/room/h0:g	(Ljava/io/File;Z)V
    //   196: goto +62 -> 258
    //   199: astore 6
    //   201: ldc 109
    //   203: ldc 92
    //   205: aload 6
    //   207: invokestatic 115	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   210: pop
    //   211: goto +47 -> 258
    //   214: new 117	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   221: astore 7
    //   223: aload 7
    //   225: ldc 120
    //   227: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 7
    //   233: aload 6
    //   235: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 7
    //   241: ldc 126
    //   243: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 109
    //   249: aload 7
    //   251: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 132	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload 5
    //   260: invokevirtual 88	o1/a:c	()V
    //   263: return
    //   264: astore 6
    //   266: ldc 109
    //   268: ldc 134
    //   270: aload 6
    //   272: invokestatic 115	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   275: pop
    //   276: aload 5
    //   278: invokevirtual 88	o1/a:c	()V
    //   281: return
    //   282: astore 6
    //   284: aload 5
    //   286: invokevirtual 88	o1/a:c	()V
    //   289: aload 6
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	h0
    //   0	292	1	paramBoolean	boolean
    //   134	22	2	i	int
    //   139	18	3	j	int
    //   40	145	4	bool	boolean
    //   21	264	5	localObject1	Object
    //   4	49	6	str	String
    //   98	80	6	localIOException1	IOException
    //   199	35	6	localIOException2	IOException
    //   264	7	6	localIOException3	IOException
    //   282	8	6	localObject2	Object
    //   15	235	7	localObject3	Object
    //   116	3	8	localh	h
    // Exception table:
    //   from	to	target	type
    //   85	92	98	java/io/IOException
    //   189	196	199	java/io/IOException
    //   129	135	264	java/io/IOException
    //   68	80	282	finally
    //   85	92	282	finally
    //   100	112	282	finally
    //   112	118	282	finally
    //   129	135	282	finally
    //   135	140	282	finally
    //   151	162	282	finally
    //   173	184	282	finally
    //   189	196	282	finally
    //   201	211	282	finally
    //   214	258	282	finally
    //   266	276	282	finally
  }
  
  private void g(File paramFile, boolean paramBoolean)
  {
    if (this.b != null) {
      localObject = this.a.getAssets().open(this.b);
    }
    for (;;)
    {
      localObject = Channels.newChannel((InputStream)localObject);
      break label77;
      if (this.c != null)
      {
        localObject = new FileInputStream(this.c).getChannel();
      }
      else
      {
        localObject = this.d;
        if (localObject == null) {
          break;
        }
      }
      try
      {
        localObject = (InputStream)((Callable)localObject).call();
      }
      catch (Exception paramFile)
      {
        label77:
        File localFile;
        throw new IOException("inputStreamCallable exception on call", paramFile);
      }
    }
    localFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
    localFile.deleteOnExit();
    d.a((ReadableByteChannel)localObject, new FileOutputStream(localFile).getChannel());
    Object localObject = paramFile.getParentFile();
    if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to create directories for ");
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      throw new IOException(((StringBuilder)localObject).toString());
    }
    h(localFile, paramBoolean);
    if (localFile.renameTo(paramFile)) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to move intermediate file (");
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    ((StringBuilder)localObject).append(") to destination (");
    ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
    ((StringBuilder)localObject).append(").");
    throw new IOException(((StringBuilder)localObject).toString());
    throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
  }
  
  private void h(File paramFile, boolean paramBoolean)
  {
    paramFile = this.g;
    if (paramFile != null) {
      Objects.requireNonNull(paramFile);
    }
  }
  
  public g X()
  {
    try
    {
      if (!this.h)
      {
        B(true);
        this.h = true;
      }
      g localg = this.f.X();
      return localg;
    }
    finally {}
  }
  
  public p1.h a()
  {
    return this.f;
  }
  
  public void close()
  {
    try
    {
      this.f.close();
      this.h = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDatabaseName()
  {
    return this.f.getDatabaseName();
  }
  
  void i(h paramh)
  {
    this.g = paramh;
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    this.f.setWriteAheadLoggingEnabled(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.h0
 * JD-Core Version:    0.7.0.1
 */