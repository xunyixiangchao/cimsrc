package m9;

import a9.f;
import c9.g;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import l9.b0;
import l9.e0;
import l9.f0;
import l9.g0;
import l9.g0.b;
import l9.t;
import l9.t.c;
import l9.w;
import l9.w.a;
import l9.x.b;
import p8.a0;
import p8.c0;
import t9.c;

public final class o
{
  public static final w a = ;
  public static final e0 b = l.l();
  public static final g0 c = g0.b.d(g0.b, l.a, null, 1, null);
  public static final TimeZone d;
  public static final boolean e;
  public static final String f;
  
  static
  {
    Object localObject = TimeZone.getTimeZone("GMT");
    f.c(localObject);
    d = (TimeZone)localObject;
    e = false;
    localObject = b0.class.getName();
    f.e(localObject, "OkHttpClient::class.java.name");
    f = f9.l.e0(f9.l.d0((String)localObject, "okhttp3."), "Client");
  }
  
  public static final t.c c(t paramt)
  {
    f.f(paramt, "<this>");
    return new n(paramt);
  }
  
  private static final t d(t paramt, l9.e parame)
  {
    f.f(paramt, "$this_asFactory");
    f.f(parame, "it");
    return paramt;
  }
  
  public static final boolean e(l9.x paramx1, l9.x paramx2)
  {
    f.f(paramx1, "<this>");
    f.f(paramx2, "other");
    return (f.a(paramx1.i(), paramx2.i())) && (paramx1.n() == paramx2.n()) && (f.a(paramx1.r(), paramx2.r()));
  }
  
  public static final int f(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    f.f(paramString, "name");
    boolean bool = paramLong < 0L;
    int j = 1;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramTimeUnit != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= 2147483647L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = j;
          if (paramLong == 0L) {
            if (!bool) {
              i = j;
            } else {
              i = 0;
            }
          }
          if (i != 0) {
            return (int)paramLong;
          }
          throw new IllegalArgumentException(f.m(paramString, " too small.").toString());
        }
        throw new IllegalArgumentException(f.m(paramString, " too large.").toString());
      }
      throw new IllegalStateException("unit == null".toString());
    }
    throw new IllegalStateException(f.m(paramString, " < 0").toString());
  }
  
  public static final void g(Socket paramSocket)
  {
    f.f(paramSocket, "<this>");
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      if (f.a(paramSocket.getMessage(), "bio == null")) {
        return;
      }
      throw paramSocket;
    }
    catch (AssertionError paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static final boolean h(aa.x paramx, int paramInt, TimeUnit paramTimeUnit)
  {
    f.f(paramx, "<this>");
    f.f(paramTimeUnit, "timeUnit");
    try
    {
      boolean bool = n(paramx, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramx)
    {
      label21:
      break label21;
    }
    return false;
  }
  
  public static final String i(String paramString, Object... paramVarArgs)
  {
    f.f(paramString, "format");
    f.f(paramVarArgs, "args");
    Object localObject = a9.l.a;
    localObject = Locale.US;
    paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
    paramString = String.format((Locale)localObject, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    f.e(paramString, "format(locale, format, *args)");
    return paramString;
  }
  
  public static final long j(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    paramf0 = paramf0.i0().a("Content-Length");
    if (paramf0 == null) {
      return -1L;
    }
    return l.C(paramf0, -1L);
  }
  
  @SafeVarargs
  public static final <T> List<T> k(T... paramVarArgs)
  {
    f.f(paramVarArgs, "elements");
    paramVarArgs = (Object[])paramVarArgs.clone();
    paramVarArgs = Collections.unmodifiableList(p8.l.k(Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
    f.e(paramVarArgs, "unmodifiableList(listOf(*elements.clone()))");
    return paramVarArgs;
  }
  
  public static final boolean l(Socket paramSocket, aa.d paramd)
  {
    f.f(paramSocket, "<this>");
    f.f(paramd, "source");
    try
    {
      int i = paramSocket.getSoTimeout();
      try
      {
        paramSocket.setSoTimeout(1);
        boolean bool = paramd.D();
        return bool ^ true;
      }
      finally
      {
        paramSocket.setSoTimeout(i);
      }
    }
    catch (SocketTimeoutException paramSocket)
    {
      return true;
    }
    catch (IOException paramSocket)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  public static final Charset m(aa.d paramd, Charset paramCharset)
  {
    f.f(paramd, "<this>");
    f.f(paramCharset, "default");
    int i = paramd.E(l.m());
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4) {
                return f9.d.a.b();
              }
              throw new AssertionError();
            }
            return f9.d.a.a();
          }
          return f9.d.e;
        }
        return f9.d.d;
      }
      paramCharset = f9.d.b;
    }
    return paramCharset;
  }
  
  /* Error */
  public static final boolean n(aa.x paramx, int paramInt, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 103
    //   3: invokestatic 105	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 191
    //   9: invokestatic 105	a9/f:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: invokestatic 322	java/lang/System:nanoTime	()J
    //   15: lstore 5
    //   17: aload_0
    //   18: invokeinterface 327 1 0
    //   23: invokevirtual 331	aa/y:e	()Z
    //   26: ifeq +19 -> 45
    //   29: aload_0
    //   30: invokeinterface 327 1 0
    //   35: invokevirtual 333	aa/y:c	()J
    //   38: lload 5
    //   40: lsub
    //   41: lstore_3
    //   42: goto +7 -> 49
    //   45: ldc2_w 334
    //   48: lstore_3
    //   49: aload_0
    //   50: invokeinterface 327 1 0
    //   55: lload_3
    //   56: aload_2
    //   57: iload_1
    //   58: i2l
    //   59: invokevirtual 338	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   62: invokestatic 344	java/lang/Math:min	(JJ)J
    //   65: lload 5
    //   67: ladd
    //   68: invokevirtual 347	aa/y:d	(J)Laa/y;
    //   71: pop
    //   72: new 349	aa/b
    //   75: dup
    //   76: invokespecial 350	aa/b:<init>	()V
    //   79: astore_2
    //   80: aload_0
    //   81: aload_2
    //   82: ldc2_w 351
    //   85: invokeinterface 355 4 0
    //   90: ldc2_w 237
    //   93: lcmp
    //   94: ifeq +10 -> 104
    //   97: aload_2
    //   98: invokevirtual 357	aa/b:a	()V
    //   101: goto -21 -> 80
    //   104: iconst_1
    //   105: istore 7
    //   107: iconst_1
    //   108: istore 8
    //   110: lload_3
    //   111: ldc2_w 334
    //   114: lcmp
    //   115: ifne +20 -> 135
    //   118: iload 8
    //   120: istore 7
    //   122: aload_0
    //   123: invokeinterface 327 1 0
    //   128: invokevirtual 359	aa/y:a	()Laa/y;
    //   131: pop
    //   132: iload 7
    //   134: ireturn
    //   135: aload_0
    //   136: invokeinterface 327 1 0
    //   141: lload 5
    //   143: lload_3
    //   144: ladd
    //   145: invokevirtual 347	aa/y:d	(J)Laa/y;
    //   148: pop
    //   149: iload 7
    //   151: ireturn
    //   152: astore_2
    //   153: aload_0
    //   154: invokeinterface 327 1 0
    //   159: astore_0
    //   160: lload_3
    //   161: ldc2_w 334
    //   164: lcmp
    //   165: ifne +11 -> 176
    //   168: aload_0
    //   169: invokevirtual 359	aa/y:a	()Laa/y;
    //   172: pop
    //   173: goto +12 -> 185
    //   176: aload_0
    //   177: lload 5
    //   179: lload_3
    //   180: ladd
    //   181: invokevirtual 347	aa/y:d	(J)Laa/y;
    //   184: pop
    //   185: aload_2
    //   186: athrow
    //   187: iconst_0
    //   188: istore 7
    //   190: iconst_0
    //   191: istore 8
    //   193: lload_3
    //   194: ldc2_w 334
    //   197: lcmp
    //   198: ifne -63 -> 135
    //   201: iload 8
    //   203: istore 7
    //   205: goto -83 -> 122
    //   208: astore_2
    //   209: goto -22 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramx	aa.x
    //   0	212	1	paramInt	int
    //   0	212	2	paramTimeUnit	TimeUnit
    //   41	153	3	l1	long
    //   15	163	5	l2	long
    //   105	99	7	bool1	boolean
    //   108	94	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   72	80	152	finally
    //   80	101	152	finally
    //   72	80	208	java/io/InterruptedIOException
    //   80	101	208	java/io/InterruptedIOException
  }
  
  public static final ThreadFactory o(String paramString, boolean paramBoolean)
  {
    f.f(paramString, "name");
    return new m(paramString, paramBoolean);
  }
  
  private static final Thread p(String paramString, boolean paramBoolean, Runnable paramRunnable)
  {
    f.f(paramString, "$name");
    paramString = new Thread(paramRunnable, paramString);
    paramString.setDaemon(paramBoolean);
    return paramString;
  }
  
  public static final List<c> q(w paramw)
  {
    f.f(paramw, "<this>");
    Object localObject = g.i(0, paramw.size());
    ArrayList localArrayList = new ArrayList(p8.l.q((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((a0)localObject).a();
      localArrayList.add(new c(paramw.c(i), paramw.f(i)));
    }
    return localArrayList;
  }
  
  public static final w r(List<c> paramList)
  {
    f.f(paramList, "<this>");
    w.a locala = new w.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (c)paramList.next();
      aa.e locale = ((c)localObject).a();
      localObject = ((c)localObject).b();
      locala.d(locale.u(), ((aa.e)localObject).u());
    }
    return locala.f();
  }
  
  public static final String s(l9.x paramx, boolean paramBoolean)
  {
    f.f(paramx, "<this>");
    Object localObject1;
    if (f9.l.C(paramx.i(), ":", false, 2, null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('[');
      ((StringBuilder)localObject1).append(paramx.i());
      ((StringBuilder)localObject1).append(']');
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramx.i();
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = localObject1;
      if (paramx.n() == l9.x.k.c(paramx.r())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(':');
      ((StringBuilder)localObject2).append(paramx.n());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public static final <T> List<T> u(List<? extends T> paramList)
  {
    f.f(paramList, "<this>");
    paramList = Collections.unmodifiableList(p8.l.L(paramList));
    f.e(paramList, "unmodifiableList(toMutableList())");
    return paramList;
  }
  
  public static final <K, V> Map<K, V> v(Map<K, ? extends V> paramMap)
  {
    f.f(paramMap, "<this>");
    if (paramMap.isEmpty()) {
      return c0.c();
    }
    paramMap = Collections.unmodifiableMap(new LinkedHashMap(paramMap));
    f.e(paramMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
    return paramMap;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.o
 * JD-Core Version:    0.7.0.1
 */