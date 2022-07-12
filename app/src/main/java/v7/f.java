package v7;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import y7.g;
import y7.i;
import y7.j;

public final class f
{
  private static final com.google.gson.reflect.a<?> v = com.google.gson.reflect.a.get(Object.class);
  private final ThreadLocal<Map<com.google.gson.reflect.a<?>, f<?>>> a = new ThreadLocal();
  private final Map<com.google.gson.reflect.a<?>, v<?>> b = new ConcurrentHashMap();
  private final x7.c c;
  private final y7.d d;
  final List<w> e;
  final x7.d f;
  final e g;
  final Map<Type, h<?>> h;
  final boolean i;
  final boolean j;
  final boolean k;
  final boolean l;
  final boolean m;
  final boolean n;
  final boolean o;
  final String p;
  final int q;
  final int r;
  final u s;
  final List<w> t;
  final List<w> u;
  
  public f()
  {
    this(x7.d.g, d.a, Collections.emptyMap(), false, false, false, true, false, false, false, u.a, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
  }
  
  f(x7.d paramd, e parame, Map<Type, h<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, u paramu, String paramString, int paramInt1, int paramInt2, List<w> paramList1, List<w> paramList2, List<w> paramList3)
  {
    this.f = paramd;
    this.g = parame;
    this.h = paramMap;
    paramMap = new x7.c(paramMap);
    this.c = paramMap;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramBoolean3;
    this.l = paramBoolean4;
    this.m = paramBoolean5;
    this.n = paramBoolean6;
    this.o = paramBoolean7;
    this.s = paramu;
    this.p = paramString;
    this.q = paramInt1;
    this.r = paramInt2;
    this.t = paramList1;
    this.u = paramList2;
    paramString = new ArrayList();
    paramString.add(y7.n.Y);
    paramString.add(y7.h.b);
    paramString.add(paramd);
    paramString.addAll(paramList3);
    paramString.add(y7.n.D);
    paramString.add(y7.n.m);
    paramString.add(y7.n.g);
    paramString.add(y7.n.i);
    paramString.add(y7.n.k);
    paramu = n(paramu);
    paramString.add(y7.n.a(Long.TYPE, Long.class, paramu));
    paramString.add(y7.n.a(Double.TYPE, Double.class, e(paramBoolean7)));
    paramString.add(y7.n.a(Float.TYPE, Float.class, f(paramBoolean7)));
    paramString.add(y7.n.x);
    paramString.add(y7.n.o);
    paramString.add(y7.n.q);
    paramString.add(y7.n.b(AtomicLong.class, b(paramu)));
    paramString.add(y7.n.b(AtomicLongArray.class, c(paramu)));
    paramString.add(y7.n.s);
    paramString.add(y7.n.z);
    paramString.add(y7.n.F);
    paramString.add(y7.n.H);
    paramString.add(y7.n.b(BigDecimal.class, y7.n.B));
    paramString.add(y7.n.b(BigInteger.class, y7.n.C));
    paramString.add(y7.n.J);
    paramString.add(y7.n.L);
    paramString.add(y7.n.P);
    paramString.add(y7.n.R);
    paramString.add(y7.n.W);
    paramString.add(y7.n.N);
    paramString.add(y7.n.d);
    paramString.add(y7.c.b);
    paramString.add(y7.n.U);
    paramString.add(y7.k.b);
    paramString.add(j.b);
    paramString.add(y7.n.S);
    paramString.add(y7.a.c);
    paramString.add(y7.n.b);
    paramString.add(new y7.b(paramMap));
    paramString.add(new g(paramMap, paramBoolean2));
    paramu = new y7.d(paramMap);
    this.d = paramu;
    paramString.add(paramu);
    paramString.add(y7.n.Z);
    paramString.add(new i(paramMap, parame, paramd, paramu));
    this.e = Collections.unmodifiableList(paramString);
  }
  
  private static void a(Object paramObject, b8.a parama)
  {
    if (paramObject != null) {
      try
      {
        if (parama.u0() == b8.b.j) {
          return;
        }
        throw new m("JSON document was not fully consumed.");
      }
      catch (IOException paramObject)
      {
        throw new m(paramObject);
      }
      catch (b8.d paramObject)
      {
        throw new t(paramObject);
      }
    }
  }
  
  private static v<AtomicLong> b(v<Number> paramv)
  {
    return new d(paramv).a();
  }
  
  private static v<AtomicLongArray> c(v<Number> paramv)
  {
    return new e(paramv).a();
  }
  
  static void d(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private v<Number> e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return y7.n.v;
    }
    return new a();
  }
  
  private v<Number> f(boolean paramBoolean)
  {
    if (paramBoolean) {
      return y7.n.u;
    }
    return new b();
  }
  
  private static v<Number> n(u paramu)
  {
    if (paramu == u.a) {
      return y7.n.t;
    }
    return new c();
  }
  
  /* Error */
  public <T> T g(b8.a parama, Type paramType)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 403	b8/a:h0	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore_3
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 407	b8/a:z0	(Z)V
    //   13: aload_1
    //   14: invokevirtual 323	b8/a:u0	()Lb8/b;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 410	com/google/gson/reflect/a:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/a;
    //   25: invokevirtual 413	v7/f:k	(Lcom/google/gson/reflect/a;)Lv7/v;
    //   28: aload_1
    //   29: invokevirtual 416	v7/v:b	(Lb8/a;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 407	b8/a:z0	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +88 -> 130
    //   45: astore_2
    //   46: new 362	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 418
    //   60: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 5
    //   66: aload_2
    //   67: invokevirtual 421	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   70: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: new 399	java/lang/AssertionError
    //   77: dup
    //   78: aload 5
    //   80: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokespecial 424	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: astore_2
    //   89: new 340	v7/t
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 341	v7/t:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: astore_2
    //   99: new 340	v7/t
    //   102: dup
    //   103: aload_2
    //   104: invokespecial 341	v7/t:<init>	(Ljava/lang/Throwable;)V
    //   107: athrow
    //   108: astore_2
    //   109: iload_3
    //   110: ifeq +11 -> 121
    //   113: aload_1
    //   114: iload 4
    //   116: invokevirtual 407	b8/a:z0	(Z)V
    //   119: aconst_null
    //   120: areturn
    //   121: new 340	v7/t
    //   124: dup
    //   125: aload_2
    //   126: invokespecial 341	v7/t:<init>	(Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: aload_1
    //   131: iload 4
    //   133: invokevirtual 407	b8/a:z0	(Z)V
    //   136: aload_2
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	f
    //   0	138	1	parama	b8.a
    //   0	138	2	paramType	Type
    //   7	103	3	i1	int
    //   4	128	4	bool	boolean
    //   53	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   20	33	41	finally
    //   46	88	41	finally
    //   89	98	41	finally
    //   99	108	41	finally
    //   121	130	41	finally
    //   13	18	45	java/lang/AssertionError
    //   20	33	45	java/lang/AssertionError
    //   13	18	88	java/io/IOException
    //   20	33	88	java/io/IOException
    //   13	18	98	java/lang/IllegalStateException
    //   20	33	98	java/lang/IllegalStateException
    //   13	18	108	java/io/EOFException
    //   20	33	108	java/io/EOFException
  }
  
  public <T> T h(Reader paramReader, Type paramType)
  {
    paramReader = o(paramReader);
    paramType = g(paramReader, paramType);
    a(paramType, paramReader);
    return paramType;
  }
  
  public <T> T i(String paramString, Class<T> paramClass)
  {
    paramString = j(paramString, paramClass);
    return x7.k.c(paramClass).cast(paramString);
  }
  
  public <T> T j(String paramString, Type paramType)
  {
    if (paramString == null) {
      return null;
    }
    return h(new StringReader(paramString), paramType);
  }
  
  public <T> v<T> k(com.google.gson.reflect.a<T> parama)
  {
    Object localObject2 = this.b;
    if (parama == null) {
      localObject1 = v;
    } else {
      localObject1 = parama;
    }
    Object localObject1 = (v)((Map)localObject2).get(localObject1);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject2 = (Map)this.a.get();
    int i1 = 0;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      this.a.set(localObject1);
      i1 = 1;
    }
    localObject2 = (f)((Map)localObject1).get(parama);
    if (localObject2 != null) {
      return localObject2;
    }
    try
    {
      localObject2 = new f();
      ((Map)localObject1).put(parama, localObject2);
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        v localv = ((w)localIterator.next()).a(this, parama);
        if (localv != null)
        {
          ((f)localObject2).e(localv);
          this.b.put(parama, localv);
          return localv;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GSON (2.8.5) cannot handle ");
      ((StringBuilder)localObject2).append(parama);
      throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    }
    finally
    {
      ((Map)localObject1).remove(parama);
      if (i1 != 0) {
        this.a.remove();
      }
    }
  }
  
  public <T> v<T> l(Class<T> paramClass)
  {
    return k(com.google.gson.reflect.a.get(paramClass));
  }
  
  public <T> v<T> m(w paramw, com.google.gson.reflect.a<T> parama)
  {
    Object localObject1 = paramw;
    if (!this.e.contains(paramw)) {
      localObject1 = this.d;
    }
    int i1 = 0;
    paramw = this.e.iterator();
    while (paramw.hasNext())
    {
      Object localObject2 = (w)paramw.next();
      if (i1 == 0)
      {
        if (localObject2 == localObject1) {
          i1 = 1;
        }
      }
      else
      {
        localObject2 = ((w)localObject2).a(this, parama);
        if (localObject2 != null) {
          return localObject2;
        }
      }
    }
    paramw = new StringBuilder();
    paramw.append("GSON cannot serialize ");
    paramw.append(parama);
    throw new IllegalArgumentException(paramw.toString());
  }
  
  public b8.a o(Reader paramReader)
  {
    paramReader = new b8.a(paramReader);
    paramReader.z0(this.n);
    return paramReader;
  }
  
  public b8.c p(Writer paramWriter)
  {
    if (this.k) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new b8.c(paramWriter);
    if (this.m) {
      paramWriter.q0("  ");
    }
    paramWriter.s0(this.i);
    return paramWriter;
  }
  
  public String q(Object paramObject)
  {
    if (paramObject == null) {
      return s(n.a);
    }
    return r(paramObject, paramObject.getClass());
  }
  
  public String r(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    u(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String s(l paraml)
  {
    StringWriter localStringWriter = new StringWriter();
    w(paraml, localStringWriter);
    return localStringWriter.toString();
  }
  
  /* Error */
  public void t(Object paramObject, Type paramType, b8.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 410	com/google/gson/reflect/a:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/a;
    //   5: invokevirtual 413	v7/f:k	(Lcom/google/gson/reflect/a;)Lv7/v;
    //   8: astore_2
    //   9: aload_3
    //   10: invokevirtual 567	b8/c:h0	()Z
    //   13: istore 4
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 570	b8/c:r0	(Z)V
    //   20: aload_3
    //   21: invokevirtual 573	b8/c:g0	()Z
    //   24: istore 5
    //   26: aload_3
    //   27: aload_0
    //   28: getfield 126	v7/f:l	Z
    //   31: invokevirtual 576	b8/c:p0	(Z)V
    //   34: aload_3
    //   35: invokevirtual 579	b8/c:f0	()Z
    //   38: istore 6
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 120	v7/f:i	Z
    //   45: invokevirtual 538	b8/c:s0	(Z)V
    //   48: aload_2
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 582	v7/v:d	(Lb8/c;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: iload 4
    //   57: invokevirtual 570	b8/c:r0	(Z)V
    //   60: aload_3
    //   61: iload 5
    //   63: invokevirtual 576	b8/c:p0	(Z)V
    //   66: aload_3
    //   67: iload 6
    //   69: invokevirtual 538	b8/c:s0	(Z)V
    //   72: return
    //   73: astore_1
    //   74: goto +52 -> 126
    //   77: astore_1
    //   78: new 362	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   85: astore_2
    //   86: aload_2
    //   87: ldc_w 418
    //   90: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: aload_1
    //   96: invokevirtual 421	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   99: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 399	java/lang/AssertionError
    //   106: dup
    //   107: aload_2
    //   108: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokespecial 424	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: astore_1
    //   117: new 330	v7/m
    //   120: dup
    //   121: aload_1
    //   122: invokespecial 338	v7/m:<init>	(Ljava/lang/Throwable;)V
    //   125: athrow
    //   126: aload_3
    //   127: iload 4
    //   129: invokevirtual 570	b8/c:r0	(Z)V
    //   132: aload_3
    //   133: iload 5
    //   135: invokevirtual 576	b8/c:p0	(Z)V
    //   138: aload_3
    //   139: iload 6
    //   141: invokevirtual 538	b8/c:s0	(Z)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	f
    //   0	146	1	paramObject	Object
    //   0	146	2	paramType	Type
    //   0	146	3	paramc	b8.c
    //   13	115	4	bool1	boolean
    //   24	110	5	bool2	boolean
    //   38	102	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   48	54	73	finally
    //   78	116	73	finally
    //   117	126	73	finally
    //   48	54	77	java/lang/AssertionError
    //   48	54	116	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",factories:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void u(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      t(paramObject, paramType, p(x7.l.c(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new m(paramObject);
    }
  }
  
  /* Error */
  public void v(l paraml, b8.c paramc)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 567	b8/c:h0	()Z
    //   4: istore_3
    //   5: aload_2
    //   6: iconst_1
    //   7: invokevirtual 570	b8/c:r0	(Z)V
    //   10: aload_2
    //   11: invokevirtual 573	b8/c:g0	()Z
    //   14: istore 4
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 126	v7/f:l	Z
    //   21: invokevirtual 576	b8/c:p0	(Z)V
    //   24: aload_2
    //   25: invokevirtual 579	b8/c:f0	()Z
    //   28: istore 5
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 120	v7/f:i	Z
    //   35: invokevirtual 538	b8/c:s0	(Z)V
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 606	x7/l:b	(Lv7/l;Lb8/c;)V
    //   43: aload_2
    //   44: iload_3
    //   45: invokevirtual 570	b8/c:r0	(Z)V
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 576	b8/c:p0	(Z)V
    //   54: aload_2
    //   55: iload 5
    //   57: invokevirtual 538	b8/c:s0	(Z)V
    //   60: return
    //   61: astore_1
    //   62: goto +56 -> 118
    //   65: astore_1
    //   66: new 362	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   73: astore 6
    //   75: aload 6
    //   77: ldc_w 418
    //   80: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: aload_1
    //   87: invokevirtual 421	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: new 399	java/lang/AssertionError
    //   97: dup
    //   98: aload 6
    //   100: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_1
    //   104: invokespecial 424	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: athrow
    //   108: astore_1
    //   109: new 330	v7/m
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 338	v7/m:<init>	(Ljava/lang/Throwable;)V
    //   117: athrow
    //   118: aload_2
    //   119: iload_3
    //   120: invokevirtual 570	b8/c:r0	(Z)V
    //   123: aload_2
    //   124: iload 4
    //   126: invokevirtual 576	b8/c:p0	(Z)V
    //   129: aload_2
    //   130: iload 5
    //   132: invokevirtual 538	b8/c:s0	(Z)V
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	f
    //   0	137	1	paraml	l
    //   0	137	2	paramc	b8.c
    //   4	116	3	bool1	boolean
    //   14	111	4	bool2	boolean
    //   28	103	5	bool3	boolean
    //   73	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	61	finally
    //   66	108	61	finally
    //   109	118	61	finally
    //   38	43	65	java/lang/AssertionError
    //   38	43	108	java/io/IOException
  }
  
  public void w(l paraml, Appendable paramAppendable)
  {
    try
    {
      v(paraml, p(x7.l.c(paramAppendable)));
      return;
    }
    catch (IOException paraml)
    {
      throw new m(paraml);
    }
  }
  
  class a
    extends v<Number>
  {
    a() {}
    
    public Double e(b8.a parama)
    {
      if (parama.u0() == b8.b.i)
      {
        parama.q0();
        return null;
      }
      return Double.valueOf(parama.l0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      if (paramNumber == null)
      {
        paramc.k0();
        return;
      }
      f.d(paramNumber.doubleValue());
      paramc.w0(paramNumber);
    }
  }
  
  class b
    extends v<Number>
  {
    b() {}
    
    public Float e(b8.a parama)
    {
      if (parama.u0() == b8.b.i)
      {
        parama.q0();
        return null;
      }
      return Float.valueOf((float)parama.l0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      if (paramNumber == null)
      {
        paramc.k0();
        return;
      }
      f.d(paramNumber.floatValue());
      paramc.w0(paramNumber);
    }
  }
  
  static final class c
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b8.b.i)
      {
        parama.q0();
        return null;
      }
      return Long.valueOf(parama.n0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      if (paramNumber == null)
      {
        paramc.k0();
        return;
      }
      paramc.x0(paramNumber.toString());
    }
  }
  
  static final class d
    extends v<AtomicLong>
  {
    d(v paramv) {}
    
    public AtomicLong e(b8.a parama)
    {
      return new AtomicLong(((Number)this.a.b(parama)).longValue());
    }
    
    public void f(b8.c paramc, AtomicLong paramAtomicLong)
    {
      this.a.d(paramc, Long.valueOf(paramAtomicLong.get()));
    }
  }
  
  static final class e
    extends v<AtomicLongArray>
  {
    e(v paramv) {}
    
    public AtomicLongArray e(b8.a parama)
    {
      ArrayList localArrayList = new ArrayList();
      parama.a();
      while (parama.g0()) {
        localArrayList.add(Long.valueOf(((Number)this.a.b(parama)).longValue()));
      }
      parama.d0();
      int j = localArrayList.size();
      parama = new AtomicLongArray(j);
      int i = 0;
      while (i < j)
      {
        parama.set(i, ((Long)localArrayList.get(i)).longValue());
        i += 1;
      }
      return parama;
    }
    
    public void f(b8.c paramc, AtomicLongArray paramAtomicLongArray)
    {
      paramc.h();
      int j = paramAtomicLongArray.length();
      int i = 0;
      while (i < j)
      {
        this.a.d(paramc, Long.valueOf(paramAtomicLongArray.get(i)));
        i += 1;
      }
      paramc.d0();
    }
  }
  
  static class f<T>
    extends v<T>
  {
    private v<T> a;
    
    public T b(b8.a parama)
    {
      v localv = this.a;
      if (localv != null) {
        return localv.b(parama);
      }
      throw new IllegalStateException();
    }
    
    public void d(b8.c paramc, T paramT)
    {
      v localv = this.a;
      if (localv != null)
      {
        localv.d(paramc, paramT);
        return;
      }
      throw new IllegalStateException();
    }
    
    public void e(v<T> paramv)
    {
      if (this.a == null)
      {
        this.a = paramv;
        return;
      }
      throw new AssertionError();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.f
 * JD-Core Version:    0.7.0.1
 */