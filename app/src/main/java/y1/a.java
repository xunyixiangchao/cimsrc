package y1;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  private final File a;
  private final File b;
  private final File c;
  private final File d;
  private final int e;
  private long f;
  private final int g;
  private long h = 0L;
  private Writer i;
  private final LinkedHashMap<String, d> j = new LinkedHashMap(0, 0.75F, true);
  private int k;
  private long l = 0L;
  final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
  private final Callable<Void> n = new a();
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramFile;
    this.e = paramInt1;
    this.b = new File(paramFile, "journal");
    this.c = new File(paramFile, "journal.tmp");
    this.d = new File(paramFile, "journal.bkp");
    this.g = paramInt2;
    this.f = paramLong;
  }
  
  private void g0()
  {
    if (this.i != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  @TargetApi(26)
  private static void h0(Writer paramWriter)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      paramWriter.close();
      return;
    }
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitUnbufferedIo().build());
    try
    {
      paramWriter.close();
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  private void i0(c paramc, boolean paramBoolean)
  {
    for (;;)
    {
      int i2;
      try
      {
        d locald = c.c(paramc);
        if (d.g(locald) == paramc)
        {
          int i3 = 0;
          i2 = i3;
          if (paramBoolean)
          {
            i2 = i3;
            if (!d.e(locald))
            {
              int i1 = 0;
              i2 = i3;
              if (i1 < this.g)
              {
                if (c.d(paramc)[i1] != 0)
                {
                  if (!locald.k(i1).exists())
                  {
                    paramc.a();
                    return;
                  }
                  i1 += 1;
                  continue;
                }
                paramc.a();
                paramc = new StringBuilder();
                paramc.append("Newly created entry didn't create value for index ");
                paramc.append(i1);
                throw new IllegalStateException(paramc.toString());
              }
            }
          }
          long l1;
          if (i2 < this.g)
          {
            paramc = locald.k(i2);
            if (paramBoolean)
            {
              if (paramc.exists())
              {
                File localFile = locald.j(i2);
                paramc.renameTo(localFile);
                l1 = d.a(locald)[i2];
                long l2 = localFile.length();
                d.a(locald)[i2] = l2;
                this.h = (this.h - l1 + l2);
              }
            }
            else {
              k0(paramc);
            }
          }
          else
          {
            this.k += 1;
            d.h(locald, null);
            if ((d.e(locald) | paramBoolean))
            {
              d.f(locald, true);
              this.i.append("CLEAN");
              this.i.append(' ');
              this.i.append(d.b(locald));
              this.i.append(locald.l());
              this.i.append('\n');
              if (paramBoolean)
              {
                l1 = this.l;
                this.l = (1L + l1);
                d.d(locald, l1);
              }
            }
            else
            {
              this.j.remove(d.b(locald));
              this.i.append("REMOVE");
              this.i.append(' ');
              this.i.append(d.b(locald));
              this.i.append('\n');
            }
            n0(this.i);
            if ((this.h > this.f) || (p0())) {
              this.m.submit(this.n);
            }
          }
        }
        else
        {
          throw new IllegalStateException();
        }
      }
      finally {}
      i2 += 1;
    }
  }
  
  private static void k0(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.delete()) {
        return;
      }
      throw new IOException();
    }
  }
  
  private c m0(String paramString, long paramLong)
  {
    try
    {
      g0();
      d locald = (d)this.j.get(paramString);
      if (paramLong != -1L) {
        if (locald != null)
        {
          long l1 = d.c(locald);
          if (l1 == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (locald == null)
      {
        locald = new d(paramString, null);
        this.j.put(paramString, locald);
      }
      else
      {
        localc = d.g(locald);
        if (localc != null) {
          return null;
        }
      }
      c localc = new c(locald, null);
      d.h(locald, localc);
      this.i.append("DIRTY");
      this.i.append(' ');
      this.i.append(paramString);
      this.i.append('\n');
      n0(this.i);
      return localc;
    }
    finally {}
  }
  
  @TargetApi(26)
  private static void n0(Writer paramWriter)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      paramWriter.flush();
      return;
    }
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitUnbufferedIo().build());
    try
    {
      paramWriter.flush();
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  private boolean p0()
  {
    int i1 = this.k;
    return (i1 >= 2000) && (i1 >= this.j.size());
  }
  
  public static a q0(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0)
      {
        Object localObject = new File(paramFile, "journal.bkp");
        if (((File)localObject).exists())
        {
          File localFile = new File(paramFile, "journal");
          if (localFile.exists()) {
            ((File)localObject).delete();
          } else {
            w0((File)localObject, localFile, false);
          }
        }
        localObject = new a(paramFile, paramInt1, paramInt2, paramLong);
        if (((a)localObject).b.exists()) {
          try
          {
            ((a)localObject).s0();
            ((a)localObject).r0();
            return localObject;
          }
          catch (IOException localIOException)
          {
            PrintStream localPrintStream = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("DiskLruCache ");
            localStringBuilder.append(paramFile);
            localStringBuilder.append(" is corrupt: ");
            localStringBuilder.append(localIOException.getMessage());
            localStringBuilder.append(", removing");
            localPrintStream.println(localStringBuilder.toString());
            ((a)localObject).j0();
          }
        }
        paramFile.mkdirs();
        paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.u0();
        return paramFile;
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void r0()
  {
    k0(this.c);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      c localc = d.g(locald);
      int i2 = 0;
      int i1 = 0;
      if (localc == null)
      {
        while (i1 < this.g)
        {
          this.h += d.a(locald)[i1];
          i1 += 1;
        }
      }
      else
      {
        d.h(locald, null);
        i1 = i2;
        while (i1 < this.g)
        {
          k0(locald.j(i1));
          k0(locald.k(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void s0()
  {
    localb = new b(new FileInputStream(this.b), c.a);
    for (;;)
    {
      try
      {
        str1 = localb.i();
        str2 = localb.i();
        localObject2 = localb.i();
        str3 = localb.i();
        str4 = localb.i();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.e).equals(localObject2)) && (Integer.toString(this.g).equals(str3)))
        {
          boolean bool = "".equals(str4);
          if (bool) {
            i1 = 0;
          }
        }
      }
      finally
      {
        String str1;
        String str2;
        Object localObject2;
        String str3;
        String str4;
        int i1;
        c.a(localb);
      }
      try
      {
        t0(localb.i());
        i1 += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.k = (i1 - this.j.size());
    if (localb.h()) {
      u0();
    } else {
      this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), c.a));
    }
    c.a(localb);
    return;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal header: [");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("]");
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void t0(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 != -1)
    {
      int i2 = i1 + 1;
      int i3 = paramString.indexOf(' ', i2);
      if (i3 == -1)
      {
        localObject2 = paramString.substring(i2);
        localObject1 = localObject2;
        if (i1 == 6)
        {
          localObject1 = localObject2;
          if (paramString.startsWith("REMOVE")) {
            this.j.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(i2, i3);
      }
      d locald = (d)this.j.get(localObject1);
      Object localObject2 = locald;
      if (locald == null)
      {
        localObject2 = new d((String)localObject1, null);
        this.j.put(localObject1, localObject2);
      }
      if ((i3 != -1) && (i1 == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        d.f((d)localObject2, true);
        d.h((d)localObject2, null);
        d.i((d)localObject2, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == 5) && (paramString.startsWith("DIRTY")))
      {
        d.h((d)localObject2, new c((d)localObject2, null));
        return;
      }
      if ((i3 == -1) && (i1 == 4) && (paramString.startsWith("READ"))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unexpected journal line: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unexpected journal line: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  /* Error */
  private void u0()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	y1/a:i	Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_1
    //   12: invokestatic 474	y1/a:h0	(Ljava/io/Writer;)V
    //   15: new 420	java/io/BufferedWriter
    //   18: dup
    //   19: new 422	java/io/OutputStreamWriter
    //   22: dup
    //   23: new 424	java/io/FileOutputStream
    //   26: dup
    //   27: aload_0
    //   28: getfield 99	y1/a:c	Ljava/io/File;
    //   31: invokespecial 475	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: getstatic 391	y1/c:a	Ljava/nio/charset/Charset;
    //   37: invokespecial 430	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   40: invokespecial 432	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc_w 398
    //   48: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   51: aload_2
    //   52: ldc_w 480
    //   55: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   58: aload_2
    //   59: ldc_w 406
    //   62: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: ldc_w 480
    //   69: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 86	y1/a:e	I
    //   77: invokestatic 411	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   80: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   83: aload_2
    //   84: ldc_w 480
    //   87: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   90: aload_2
    //   91: aload_0
    //   92: getfield 105	y1/a:g	I
    //   95: invokestatic 411	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   98: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   101: aload_2
    //   102: ldc_w 480
    //   105: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: ldc_w 480
    //   112: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 54	y1/a:j	Ljava/util/LinkedHashMap;
    //   119: invokevirtual 361	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   122: invokeinterface 367 1 0
    //   127: astore_3
    //   128: aload_3
    //   129: invokeinterface 372 1 0
    //   134: ifeq +125 -> 259
    //   137: aload_3
    //   138: invokeinterface 376 1 0
    //   143: checkcast 16	y1/a$d
    //   146: astore_1
    //   147: aload_1
    //   148: invokestatic 187	y1/a$d:g	(Ly1/a$d;)Ly1/a$c;
    //   151: ifnull +53 -> 204
    //   154: new 203	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   161: astore 4
    //   163: aload 4
    //   165: ldc_w 482
    //   168: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: aload_1
    //   175: invokestatic 251	y1/a$d:b	(Ly1/a$d;)Ljava/lang/String;
    //   178: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: bipush 10
    //   186: invokevirtual 485	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore_1
    //   196: aload_2
    //   197: aload_1
    //   198: invokevirtual 478	java/io/Writer:write	(Ljava/lang/String;)V
    //   201: goto -73 -> 128
    //   204: new 203	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   211: astore 4
    //   213: aload 4
    //   215: ldc_w 487
    //   218: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 4
    //   224: aload_1
    //   225: invokestatic 251	y1/a$d:b	(Ly1/a$d;)Ljava/lang/String;
    //   228: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 4
    //   234: aload_1
    //   235: invokevirtual 253	y1/a$d:l	()Ljava/lang/String;
    //   238: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 4
    //   244: bipush 10
    //   246: invokevirtual 485	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 4
    //   252: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore_1
    //   256: goto -60 -> 196
    //   259: aload_2
    //   260: invokestatic 474	y1/a:h0	(Ljava/io/Writer;)V
    //   263: aload_0
    //   264: getfield 95	y1/a:b	Ljava/io/File;
    //   267: invokevirtual 199	java/io/File:exists	()Z
    //   270: ifeq +15 -> 285
    //   273: aload_0
    //   274: getfield 95	y1/a:b	Ljava/io/File;
    //   277: aload_0
    //   278: getfield 103	y1/a:d	Ljava/io/File;
    //   281: iconst_1
    //   282: invokestatic 313	y1/a:w0	(Ljava/io/File;Ljava/io/File;Z)V
    //   285: aload_0
    //   286: getfield 99	y1/a:c	Ljava/io/File;
    //   289: aload_0
    //   290: getfield 95	y1/a:b	Ljava/io/File;
    //   293: iconst_0
    //   294: invokestatic 313	y1/a:w0	(Ljava/io/File;Ljava/io/File;Z)V
    //   297: aload_0
    //   298: getfield 103	y1/a:d	Ljava/io/File;
    //   301: invokevirtual 273	java/io/File:delete	()Z
    //   304: pop
    //   305: aload_0
    //   306: new 420	java/io/BufferedWriter
    //   309: dup
    //   310: new 422	java/io/OutputStreamWriter
    //   313: dup
    //   314: new 424	java/io/FileOutputStream
    //   317: dup
    //   318: aload_0
    //   319: getfield 95	y1/a:b	Ljava/io/File;
    //   322: iconst_1
    //   323: invokespecial 427	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   326: getstatic 391	y1/c:a	Ljava/nio/charset/Charset;
    //   329: invokespecial 430	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   332: invokespecial 432	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   335: putfield 117	y1/a:i	Ljava/io/Writer;
    //   338: aload_0
    //   339: monitorexit
    //   340: return
    //   341: astore_1
    //   342: aload_2
    //   343: invokestatic 474	y1/a:h0	(Ljava/io/Writer;)V
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: aload_0
    //   350: monitorexit
    //   351: aload_1
    //   352: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	a
    //   6	250	1	localObject1	Object
    //   341	6	1	localObject2	Object
    //   348	4	1	localObject3	Object
    //   43	300	2	localBufferedWriter	BufferedWriter
    //   127	11	3	localIterator	Iterator
    //   161	90	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	128	341	finally
    //   128	196	341	finally
    //   196	201	341	finally
    //   204	256	341	finally
    //   2	7	348	finally
    //   11	15	348	finally
    //   15	44	348	finally
    //   259	285	348	finally
    //   285	338	348	finally
    //   342	348	348	finally
  }
  
  private static void w0(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      k0(paramFile2);
    }
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    throw new IOException();
  }
  
  private void x0()
  {
    while (this.h > this.f) {
      v0((String)((Map.Entry)this.j.entrySet().iterator().next()).getKey());
    }
  }
  
  public void close()
  {
    try
    {
      Object localObject1 = this.i;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new ArrayList(this.j.values()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        d locald = (d)((Iterator)localObject1).next();
        if (d.g(locald) != null) {
          d.g(locald).a();
        }
      }
      x0();
      h0(this.i);
      this.i = null;
      return;
    }
    finally {}
  }
  
  public void j0()
  {
    close();
    c.b(this.a);
  }
  
  public c l0(String paramString)
  {
    return m0(paramString, -1L);
  }
  
  public e o0(String paramString)
  {
    try
    {
      g0();
      d locald = (d)this.j.get(paramString);
      if (locald == null) {
        return null;
      }
      boolean bool = d.e(locald);
      if (!bool) {
        return null;
      }
      File[] arrayOfFile = locald.c;
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        bool = arrayOfFile[i1].exists();
        if (!bool) {
          return null;
        }
        i1 += 1;
      }
      this.k += 1;
      this.i.append("READ");
      this.i.append(' ');
      this.i.append(paramString);
      this.i.append('\n');
      if (p0()) {
        this.m.submit(this.n);
      }
      paramString = new e(paramString, d.c(locald), locald.c, d.a(locald), null);
      return paramString;
    }
    finally {}
  }
  
  public boolean v0(String paramString)
  {
    try
    {
      g0();
      d locald = (d)this.j.get(paramString);
      int i1 = 0;
      if ((locald != null) && (d.g(locald) == null))
      {
        while (i1 < this.g)
        {
          File localFile = locald.j(i1);
          if ((localFile.exists()) && (!localFile.delete()))
          {
            paramString = new StringBuilder();
            paramString.append("failed to delete ");
            paramString.append(localFile);
            throw new IOException(paramString.toString());
          }
          this.h -= d.a(locald)[i1];
          d.a(locald)[i1] = 0L;
          i1 += 1;
        }
        this.k += 1;
        this.i.append("REMOVE");
        this.i.append(' ');
        this.i.append(paramString);
        this.i.append('\n');
        this.j.remove(paramString);
        if (p0()) {
          this.m.submit(this.n);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  class a
    implements Callable<Void>
  {
    a() {}
    
    public Void a()
    {
      synchronized (a.this)
      {
        if (a.a(a.this) == null) {
          return null;
        }
        a.h(a.this);
        if (a.d0(a.this))
        {
          a.e0(a.this);
          a.f0(a.this, 0);
        }
        return null;
      }
    }
  }
  
  private static final class b
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      try
      {
        paramRunnable = new Thread(paramRunnable, "glide-disk-lru-cache-thread");
        paramRunnable.setPriority(1);
        return paramRunnable;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
  
  public final class c
  {
    private final a.d a;
    private final boolean[] b;
    private boolean c;
    
    private c(a.d paramd)
    {
      this.a = paramd;
      if (a.d.e(paramd)) {
        this$1 = null;
      } else {
        this$1 = new boolean[a.g(a.this)];
      }
      this.b = a.this;
    }
    
    public void a()
    {
      a.B(a.this, this, false);
    }
    
    public void b()
    {
      if (!this.c) {}
      try
      {
        a();
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public void e()
    {
      a.B(a.this, this, true);
      this.c = true;
    }
    
    public File f(int paramInt)
    {
      synchronized (a.this)
      {
        if (a.d.g(this.a) == this)
        {
          if (!a.d.e(this.a)) {
            this.b[paramInt] = true;
          }
          File localFile = this.a.k(paramInt);
          a.i(a.this).mkdirs();
          return localFile;
        }
        throw new IllegalStateException();
      }
    }
  }
  
  private final class d
  {
    private final String a;
    private final long[] b;
    File[] c;
    File[] d;
    private boolean e;
    private a.c f;
    private long g;
    
    private d(String paramString)
    {
      this.a = paramString;
      this.b = new long[a.g(a.this)];
      this.c = new File[a.g(a.this)];
      this.d = new File[a.g(a.this)];
      paramString = new StringBuilder(paramString);
      paramString.append('.');
      int j = paramString.length();
      int i = 0;
      while (i < a.g(a.this))
      {
        paramString.append(i);
        this.c[i] = new File(a.i(a.this), paramString.toString());
        paramString.append(".tmp");
        this.d[i] = new File(a.i(a.this), paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private IOException m(String[] paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected journal line: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      throw new IOException(localStringBuilder.toString());
    }
    
    private void n(String[] paramArrayOfString)
    {
      int i;
      if (paramArrayOfString.length == a.g(a.this)) {
        i = 0;
      }
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.b[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label40:
        break label40;
      }
      throw m(paramArrayOfString);
      throw m(paramArrayOfString);
    }
    
    public File j(int paramInt)
    {
      return this.c[paramInt];
    }
    
    public File k(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public String l()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ');
        localStringBuilder.append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  public final class e
  {
    private final String a;
    private final long b;
    private final long[] c;
    private final File[] d;
    
    private e(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.a = paramString;
      this.b = paramLong;
      this.d = paramArrayOfFile;
      this.c = paramArrayOfLong;
    }
    
    public File a(int paramInt)
    {
      return this.d[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y1.a
 * JD-Core Version:    0.7.0.1
 */