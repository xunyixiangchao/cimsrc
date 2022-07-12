package okhttp3.internal.publicsuffix;

import a9.f;
import java.net.IDN;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase
{
  public static final a e = new a(null);
  public static final String f = f.m(PublicSuffixDatabase.class.getSimpleName(), ".gz");
  private static final byte[] g = { (byte)42 };
  private static final List<String> h = p8.l.d("*");
  private static final PublicSuffixDatabase i = new PublicSuffixDatabase();
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final CountDownLatch b = new CountDownLatch(1);
  private byte[] c;
  private byte[] d;
  
  private final List<String> b(List<String> paramList)
  {
    if ((!this.a.get()) && (this.a.compareAndSet(false, true))) {
      e();
    }
    try
    {
      this.b.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      label39:
      int j;
      int k;
      byte[][] arrayOfByte;
      Object localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      int m;
      a locala;
      break label39;
    }
    Thread.currentThread().interrupt();
    if (this.c != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      k = paramList.size();
      arrayOfByte = new byte[k][];
      j = 0;
      while (j < k)
      {
        localObject1 = ((String)paramList.get(j)).getBytes(f9.d.b);
        f.e(localObject1, "this as java.lang.String).getBytes(charset)");
        arrayOfByte[j] = localObject1;
        j += 1;
      }
      j = 0;
      for (;;)
      {
        localObject3 = null;
        if (j >= k) {
          break;
        }
        localObject2 = e;
        localObject1 = this.c;
        paramList = (List<String>)localObject1;
        if (localObject1 == null)
        {
          f.t("publicSuffixListBytes");
          paramList = null;
        }
        paramList = a.a((a)localObject2, paramList, arrayOfByte, j);
        if (paramList != null) {
          break label183;
        }
        j += 1;
      }
      paramList = null;
      label183:
      if (k > 1)
      {
        localObject4 = (byte[][])arrayOfByte.clone();
        m = localObject4.length;
        j = 0;
        while (j < m - 1)
        {
          localObject4[j] = g;
          locala = e;
          localObject2 = this.c;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            f.t("publicSuffixListBytes");
            localObject1 = null;
          }
          localObject1 = a.a(locala, (byte[])localObject1, (byte[][])localObject4, j);
          if (localObject1 != null) {
            break label278;
          }
          j += 1;
        }
      }
      localObject1 = null;
      label278:
      if (localObject1 != null)
      {
        j = 0;
        while (j < k - 1)
        {
          locala = e;
          localObject4 = this.d;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            f.t("publicSuffixExceptionListBytes");
            localObject2 = null;
          }
          localObject2 = a.a(locala, (byte[])localObject2, arrayOfByte, j);
          if (localObject2 != null) {
            break label350;
          }
          j += 1;
        }
      }
      localObject2 = null;
      label350:
      if (localObject2 != null) {
        return f9.l.i0(f.m("!", localObject2), new char[] { '.' }, false, 0, 6, null);
      }
      if ((paramList == null) && (localObject1 == null)) {
        return h;
      }
      if (paramList == null) {
        paramList = null;
      } else {
        paramList = f9.l.i0(paramList, new char[] { '.' }, false, 0, 6, null);
      }
      localObject2 = paramList;
      if (paramList == null) {
        localObject2 = p8.l.h();
      }
      if (localObject1 == null) {
        paramList = localObject3;
      } else {
        paramList = f9.l.i0((CharSequence)localObject1, new char[] { '.' }, false, 0, 6, null);
      }
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = p8.l.h();
      }
      if (((List)localObject2).size() > ((List)localObject1).size()) {
        return localObject2;
      }
      return localObject1;
    }
    paramList = new StringBuilder();
    paramList.append("Unable to load ");
    paramList.append(f);
    paramList.append(" resource from the classpath.");
    throw new IllegalStateException(paramList.toString().toString());
  }
  
  /* Error */
  private final void d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: getstatic 47	okhttp3/internal/publicsuffix/PublicSuffixDatabase:f	Ljava/lang/String;
    //   5: invokevirtual 187	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 189	aa/i
    //   17: dup
    //   18: aload_1
    //   19: invokestatic 194	aa/l:f	(Ljava/io/InputStream;)Laa/x;
    //   22: invokespecial 197	aa/i:<init>	(Laa/x;)V
    //   25: invokestatic 200	aa/l:b	(Laa/x;)Laa/d;
    //   28: astore_1
    //   29: aload_1
    //   30: aload_1
    //   31: invokeinterface 205 1 0
    //   36: i2l
    //   37: invokeinterface 209 3 0
    //   42: astore_2
    //   43: aload_1
    //   44: aload_1
    //   45: invokeinterface 205 1 0
    //   50: i2l
    //   51: invokeinterface 209 3 0
    //   56: astore_3
    //   57: getstatic 214	o8/o:a	Lo8/o;
    //   60: astore 4
    //   62: aload_1
    //   63: aconst_null
    //   64: invokestatic 219	y8/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_2
    //   70: invokestatic 222	a9/f:c	(Ljava/lang/Object;)V
    //   73: aload_0
    //   74: aload_2
    //   75: putfield 106	okhttp3/internal/publicsuffix/PublicSuffixDatabase:c	[B
    //   78: aload_3
    //   79: invokestatic 222	a9/f:c	(Ljava/lang/Object;)V
    //   82: aload_0
    //   83: aload_3
    //   84: putfield 149	okhttp3/internal/publicsuffix/PublicSuffixDatabase:d	[B
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_0
    //   90: getfield 78	okhttp3/internal/publicsuffix/PublicSuffixDatabase:b	Ljava/util/concurrent/CountDownLatch;
    //   93: invokevirtual 225	java/util/concurrent/CountDownLatch:countDown	()V
    //   96: return
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_2
    //   103: aload_2
    //   104: athrow
    //   105: astore_3
    //   106: aload_1
    //   107: aload_2
    //   108: invokestatic 219	y8/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	PublicSuffixDatabase
    //   8	55	1	localObject1	Object
    //   97	10	1	localCloseable	java.io.Closeable
    //   42	33	2	arrayOfByte1	byte[]
    //   102	6	2	localThrowable	java.lang.Throwable
    //   56	28	3	arrayOfByte2	byte[]
    //   105	7	3	localObject2	Object
    //   60	1	4	localo	o8.o
    // Exception table:
    //   from	to	target	type
    //   69	87	97	finally
    //   29	62	102	finally
    //   103	105	105	finally
  }
  
  /* Error */
  private final void e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 231	okhttp3/internal/publicsuffix/PublicSuffixDatabase:d	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 104	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: goto +37 -> 55
    //   21: astore_2
    //   22: getstatic 236	u9/h:a	Lu9/h$a;
    //   25: invokevirtual 241	u9/h$a:g	()Lu9/h;
    //   28: ldc 243
    //   30: iconst_5
    //   31: aload_2
    //   32: invokevirtual 247	u9/h:j	(Ljava/lang/String;ILjava/lang/Throwable;)V
    //   35: iload_1
    //   36: ifeq +9 -> 45
    //   39: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   42: invokevirtual 104	java/lang/Thread:interrupt	()V
    //   45: return
    //   46: invokestatic 250	java/lang/Thread:interrupted	()Z
    //   49: pop
    //   50: iconst_1
    //   51: istore_1
    //   52: goto -50 -> 2
    //   55: iload_1
    //   56: ifeq +9 -> 65
    //   59: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   62: invokevirtual 104	java/lang/Thread:interrupt	()V
    //   65: aload_2
    //   66: athrow
    //   67: astore_2
    //   68: goto -22 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	PublicSuffixDatabase
    //   1	55	1	j	int
    //   17	1	2	localObject	Object
    //   21	45	2	localIOException	java.io.IOException
    //   67	1	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	finally
    //   22	35	17	finally
    //   46	50	17	finally
    //   2	6	21	java/io/IOException
    //   2	6	67	java/io/InterruptedIOException
  }
  
  private final List<String> f(String paramString)
  {
    List localList = f9.l.i0(paramString, new char[] { '.' }, false, 0, 6, null);
    paramString = localList;
    if (f.a(p8.l.C(localList), "")) {
      paramString = p8.l.v(localList, 1);
    }
    return paramString;
  }
  
  public final String c(String paramString)
  {
    f.f(paramString, "domain");
    Object localObject = IDN.toUnicode(paramString);
    f.e(localObject, "unicodeDomain");
    localObject = f((String)localObject);
    List localList = b((List)localObject);
    if ((((List)localObject).size() == localList.size()) && (((String)localList.get(0)).charAt(0) != '!')) {
      return null;
    }
    int m = ((String)localList.get(0)).charAt(0);
    int k = ((List)localObject).size();
    int j = localList.size();
    if (m != 33) {
      j += 1;
    }
    return e9.d.e(e9.d.b(p8.l.u(f(paramString)), k - j), ".", null, null, 0, null, null, 62, null);
  }
  
  public static final class a
  {
    private final String b(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
    {
      int n = paramArrayOfByte.length;
      int m = 0;
      if (m < n)
      {
        int i = (m + n) / 2;
        while ((i > -1) && (paramArrayOfByte[i] != (byte)10)) {
          i -= 1;
        }
        int i3 = i + 1;
        i = 1;
        int i4;
        for (;;)
        {
          i4 = i3 + i;
          if (paramArrayOfByte[i4] == (byte)10) {
            break;
          }
          i += 1;
        }
        int i5 = i4 - i3;
        int i1 = paramInt;
        int j = 0;
        i = 0;
        int k = 0;
        label316:
        label331:
        for (;;)
        {
          int i2;
          if (j != 0)
          {
            i2 = 46;
            j = 0;
          }
          else
          {
            i2 = m9.l.b(paramArrayOfByte1[i1][i], 255);
          }
          i2 -= m9.l.b(paramArrayOfByte[(i3 + k)], 255);
          if (i2 == 0)
          {
            k += 1;
            i += 1;
            if (k != i5)
            {
              if (paramArrayOfByte1[i1].length != i) {
                break label331;
              }
              if (i1 != paramArrayOfByte1.length - 1) {
                break label316;
              }
            }
          }
          if (i2 < 0)
          {
            label204:
            n = i3 - 1;
            break;
          }
          if (i2 > 0) {}
          do
          {
            m = i4 + 1;
            break;
            k = i5 - k;
            j = paramArrayOfByte1[i1].length - i;
            i = i1 + 1;
            i1 = paramArrayOfByte1.length;
            while (i < i1)
            {
              j += paramArrayOfByte1[i].length;
              i += 1;
            }
            if (j < k) {
              break label204;
            }
          } while (j > k);
          return new String(paramArrayOfByte, i3, i5, f9.d.b);
          i1 += 1;
          i = -1;
          j = 1;
        }
      }
      return null;
    }
    
    public final PublicSuffixDatabase c()
    {
      return PublicSuffixDatabase.a();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     okhttp3.internal.publicsuffix.PublicSuffixDatabase
 * JD-Core Version:    0.7.0.1
 */