package y7;

import b8.b;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import v7.f;
import v7.i;
import v7.l;
import v7.m;
import v7.o;
import v7.q;
import v7.t;
import v7.v;
import v7.w;
import x7.g;

public final class n
{
  public static final v<String> A;
  public static final v<BigDecimal> B;
  public static final v<BigInteger> C;
  public static final w D;
  public static final v<StringBuilder> E;
  public static final w F;
  public static final v<StringBuffer> G;
  public static final w H;
  public static final v<URL> I;
  public static final w J;
  public static final v<URI> K;
  public static final w L;
  public static final v<InetAddress> M;
  public static final w N;
  public static final v<UUID> O;
  public static final w P;
  public static final v<Currency> Q;
  public static final w R;
  public static final w S;
  public static final v<Calendar> T;
  public static final w U;
  public static final v<Locale> V;
  public static final w W;
  public static final v<l> X;
  public static final w Y;
  public static final w Z = new w();
  public static final v<Class> a;
  public static final w b;
  public static final v<BitSet> c;
  public static final w d;
  public static final v<Boolean> e;
  public static final v<Boolean> f;
  public static final w g;
  public static final v<Number> h;
  public static final w i;
  public static final v<Number> j;
  public static final w k;
  public static final v<Number> l;
  public static final w m;
  public static final v<AtomicInteger> n;
  public static final w o;
  public static final v<AtomicBoolean> p;
  public static final w q;
  public static final v<AtomicIntegerArray> r;
  public static final w s;
  public static final v<Number> t;
  public static final v<Number> u;
  public static final v<Number> v;
  public static final v<Number> w;
  public static final w x;
  public static final v<Character> y;
  public static final w z;
  
  static
  {
    Object localObject = new k().a();
    a = (v)localObject;
    b = b(Class.class, (v)localObject);
    localObject = new v().a();
    c = (v)localObject;
    d = b(BitSet.class, (v)localObject);
    localObject = new c0();
    e = (v)localObject;
    f = new d0();
    g = a(Boolean.TYPE, Boolean.class, (v)localObject);
    localObject = new e0();
    h = (v)localObject;
    i = a(Byte.TYPE, Byte.class, (v)localObject);
    localObject = new f0();
    j = (v)localObject;
    k = a(Short.TYPE, Short.class, (v)localObject);
    localObject = new g0();
    l = (v)localObject;
    m = a(Integer.TYPE, Integer.class, (v)localObject);
    localObject = new h0().a();
    n = (v)localObject;
    o = b(AtomicInteger.class, (v)localObject);
    localObject = new i0().a();
    p = (v)localObject;
    q = b(AtomicBoolean.class, (v)localObject);
    localObject = new a().a();
    r = (v)localObject;
    s = b(AtomicIntegerArray.class, (v)localObject);
    t = new b();
    u = new c();
    v = new d();
    localObject = new e();
    w = (v)localObject;
    x = b(Number.class, (v)localObject);
    localObject = new f();
    y = (v)localObject;
    z = a(Character.TYPE, Character.class, (v)localObject);
    localObject = new g();
    A = (v)localObject;
    B = new h();
    C = new i();
    D = b(String.class, (v)localObject);
    localObject = new j();
    E = (v)localObject;
    F = b(StringBuilder.class, (v)localObject);
    localObject = new l();
    G = (v)localObject;
    H = b(StringBuffer.class, (v)localObject);
    localObject = new m();
    I = (v)localObject;
    J = b(URL.class, (v)localObject);
    localObject = new n();
    K = (v)localObject;
    L = b(URI.class, (v)localObject);
    localObject = new o();
    M = (v)localObject;
    N = d(InetAddress.class, (v)localObject);
    localObject = new p();
    O = (v)localObject;
    P = b(UUID.class, (v)localObject);
    localObject = new q().a();
    Q = (v)localObject;
    R = b(Currency.class, (v)localObject);
    S = new r();
    localObject = new s();
    T = (v)localObject;
    U = c(Calendar.class, GregorianCalendar.class, (v)localObject);
    localObject = new t();
    V = (v)localObject;
    W = b(Locale.class, (v)localObject);
    localObject = new u();
    X = (v)localObject;
    Y = d(l.class, (v)localObject);
  }
  
  public static <TT> w a(Class<TT> paramClass1, final Class<TT> paramClass2, final v<? super TT> paramv)
  {
    return new y(paramClass1, paramClass2, paramv);
  }
  
  public static <TT> w b(Class<TT> paramClass, final v<TT> paramv)
  {
    return new x(paramClass, paramv);
  }
  
  public static <TT> w c(Class<TT> paramClass, final Class<? extends TT> paramClass1, final v<? super TT> paramv)
  {
    return new z(paramClass, paramClass1, paramv);
  }
  
  public static <T1> w d(Class<T1> paramClass, final v<T1> paramv)
  {
    return new a0(paramClass, paramv);
  }
  
  static final class a
    extends v<AtomicIntegerArray>
  {
    public AtomicIntegerArray e(b8.a parama)
    {
      ArrayList localArrayList = new ArrayList();
      parama.a();
      while (parama.g0()) {
        try
        {
          localArrayList.add(Integer.valueOf(parama.m0()));
        }
        catch (NumberFormatException parama)
        {
          throw new t(parama);
        }
      }
      parama.d0();
      int j = localArrayList.size();
      parama = new AtomicIntegerArray(j);
      int i = 0;
      while (i < j)
      {
        parama.set(i, ((Integer)localArrayList.get(i)).intValue());
        i += 1;
      }
      return parama;
    }
    
    public void f(b8.c paramc, AtomicIntegerArray paramAtomicIntegerArray)
    {
      paramc.h();
      int j = paramAtomicIntegerArray.length();
      int i = 0;
      while (i < j)
      {
        paramc.u0(paramAtomicIntegerArray.get(i));
        i += 1;
      }
      paramc.d0();
    }
  }
  
  static final class a0
    implements w
  {
    a0(Class paramClass, v paramv) {}
    
    public <T2> v<T2> a(final f paramf, com.google.gson.reflect.a<T2> parama)
    {
      paramf = parama.getRawType();
      if (!this.a.isAssignableFrom(paramf)) {
        return null;
      }
      return new a(paramf);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Factory[typeHierarchy=");
      localStringBuilder.append(this.a.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(paramv);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    
    class a
      extends v<T1>
    {
      a(Class paramClass) {}
      
      public T1 b(b8.a parama)
      {
        parama = n.a0.this.b.b(parama);
        if (parama != null)
        {
          if (paramf.isInstance(parama)) {
            return parama;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Expected a ");
          localStringBuilder.append(paramf.getName());
          localStringBuilder.append(" but was ");
          localStringBuilder.append(parama.getClass().getName());
          throw new t(localStringBuilder.toString());
        }
        return parama;
      }
      
      public void d(b8.c paramc, T1 paramT1)
      {
        n.a0.this.b.d(paramc, paramT1);
      }
    }
  }
  
  static final class b
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        long l = parama.n0();
        return Long.valueOf(l);
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class c
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return Float.valueOf((float)parama.l0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class c0
    extends v<Boolean>
  {
    public Boolean e(b8.a parama)
    {
      b localb = parama.u0();
      if (localb == b.i)
      {
        parama.q0();
        return null;
      }
      if (localb == b.f) {
        return Boolean.valueOf(Boolean.parseBoolean(parama.s0()));
      }
      return Boolean.valueOf(parama.k0());
    }
    
    public void f(b8.c paramc, Boolean paramBoolean)
    {
      paramc.v0(paramBoolean);
    }
  }
  
  static final class d
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return Double.valueOf(parama.l0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class d0
    extends v<Boolean>
  {
    public Boolean e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return Boolean.valueOf(parama.s0());
    }
    
    public void f(b8.c paramc, Boolean paramBoolean)
    {
      if (paramBoolean == null) {
        paramBoolean = "null";
      } else {
        paramBoolean = paramBoolean.toString();
      }
      paramc.x0(paramBoolean);
    }
  }
  
  static final class e
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      b localb = parama.u0();
      int i = n.b0.a[localb.ordinal()];
      if ((i != 1) && (i != 3))
      {
        if (i == 4)
        {
          parama.q0();
          return null;
        }
        parama = new StringBuilder();
        parama.append("Expecting number, got: ");
        parama.append(localb);
        throw new t(parama.toString());
      }
      return new g(parama.s0());
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class e0
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        byte b = (byte)parama.m0();
        return Byte.valueOf(b);
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class f
    extends v<Character>
  {
    public Character e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      parama = parama.s0();
      if (parama.length() == 1) {
        return Character.valueOf(parama.charAt(0));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expecting character, got: ");
      localStringBuilder.append(parama);
      throw new t(localStringBuilder.toString());
    }
    
    public void f(b8.c paramc, Character paramCharacter)
    {
      if (paramCharacter == null) {
        paramCharacter = null;
      } else {
        paramCharacter = String.valueOf(paramCharacter);
      }
      paramc.x0(paramCharacter);
    }
  }
  
  static final class f0
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        short s = (short)parama.m0();
        return Short.valueOf(s);
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class g
    extends v<String>
  {
    public String e(b8.a parama)
    {
      b localb = parama.u0();
      if (localb == b.i)
      {
        parama.q0();
        return null;
      }
      if (localb == b.h) {
        return Boolean.toString(parama.k0());
      }
      return parama.s0();
    }
    
    public void f(b8.c paramc, String paramString)
    {
      paramc.x0(paramString);
    }
  }
  
  static final class g0
    extends v<Number>
  {
    public Number e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        int i = parama.m0();
        return Integer.valueOf(i);
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, Number paramNumber)
    {
      paramc.w0(paramNumber);
    }
  }
  
  static final class h
    extends v<BigDecimal>
  {
    public BigDecimal e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        parama = new BigDecimal(parama.s0());
        return parama;
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, BigDecimal paramBigDecimal)
    {
      paramc.w0(paramBigDecimal);
    }
  }
  
  static final class h0
    extends v<AtomicInteger>
  {
    public AtomicInteger e(b8.a parama)
    {
      try
      {
        parama = new AtomicInteger(parama.m0());
        return parama;
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, AtomicInteger paramAtomicInteger)
    {
      paramc.u0(paramAtomicInteger.get());
    }
  }
  
  static final class i
    extends v<BigInteger>
  {
    public BigInteger e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        parama = new BigInteger(parama.s0());
        return parama;
      }
      catch (NumberFormatException parama)
      {
        throw new t(parama);
      }
    }
    
    public void f(b8.c paramc, BigInteger paramBigInteger)
    {
      paramc.w0(paramBigInteger);
    }
  }
  
  static final class i0
    extends v<AtomicBoolean>
  {
    public AtomicBoolean e(b8.a parama)
    {
      return new AtomicBoolean(parama.k0());
    }
    
    public void f(b8.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      paramc.y0(paramAtomicBoolean.get());
    }
  }
  
  static final class j
    extends v<StringBuilder>
  {
    public StringBuilder e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return new StringBuilder(parama.s0());
    }
    
    public void f(b8.c paramc, StringBuilder paramStringBuilder)
    {
      if (paramStringBuilder == null) {
        paramStringBuilder = null;
      } else {
        paramStringBuilder = paramStringBuilder.toString();
      }
      paramc.x0(paramStringBuilder);
    }
  }
  
  private static final class j0<T extends Enum<T>>
    extends v<T>
  {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();
    
    public j0(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (w7.c)paramClass.getField((String)localObject1).getAnnotation(w7.c.class);
          if (localObject2 != null)
          {
            String str = ((w7.c)localObject2).value();
            localObject2 = ((w7.c)localObject2).alternate();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.a.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.a.put(localObject1, localEnum);
          this.b.put(localEnum, localObject1);
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public T e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return (Enum)this.a.get(parama.s0());
    }
    
    public void f(b8.c paramc, T paramT)
    {
      if (paramT == null) {
        paramT = null;
      } else {
        paramT = (String)this.b.get(paramT);
      }
      paramc.x0(paramT);
    }
  }
  
  static final class k
    extends v<Class>
  {
    public Class e(b8.a parama)
    {
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
    
    public void f(b8.c paramc, Class paramClass)
    {
      paramc = new StringBuilder();
      paramc.append("Attempted to serialize java.lang.Class: ");
      paramc.append(paramClass.getName());
      paramc.append(". Forgot to register a type adapter?");
      throw new UnsupportedOperationException(paramc.toString());
    }
  }
  
  static final class l
    extends v<StringBuffer>
  {
    public StringBuffer e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return new StringBuffer(parama.s0());
    }
    
    public void f(b8.c paramc, StringBuffer paramStringBuffer)
    {
      if (paramStringBuffer == null) {
        paramStringBuffer = null;
      } else {
        paramStringBuffer = paramStringBuffer.toString();
      }
      paramc.x0(paramStringBuffer);
    }
  }
  
  static final class m
    extends v<URL>
  {
    public URL e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      parama = parama.s0();
      if ("null".equals(parama)) {
        return null;
      }
      return new URL(parama);
    }
    
    public void f(b8.c paramc, URL paramURL)
    {
      if (paramURL == null) {
        paramURL = null;
      } else {
        paramURL = paramURL.toExternalForm();
      }
      paramc.x0(paramURL);
    }
  }
  
  static final class n
    extends v<URI>
  {
    public URI e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      try
      {
        parama = parama.s0();
        if ("null".equals(parama)) {
          return null;
        }
        parama = new URI(parama);
        return parama;
      }
      catch (URISyntaxException parama)
      {
        throw new m(parama);
      }
    }
    
    public void f(b8.c paramc, URI paramURI)
    {
      if (paramURI == null) {
        paramURI = null;
      } else {
        paramURI = paramURI.toASCIIString();
      }
      paramc.x0(paramURI);
    }
  }
  
  static final class o
    extends v<InetAddress>
  {
    public InetAddress e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return InetAddress.getByName(parama.s0());
    }
    
    public void f(b8.c paramc, InetAddress paramInetAddress)
    {
      if (paramInetAddress == null) {
        paramInetAddress = null;
      } else {
        paramInetAddress = paramInetAddress.getHostAddress();
      }
      paramc.x0(paramInetAddress);
    }
  }
  
  static final class p
    extends v<UUID>
  {
    public UUID e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      return UUID.fromString(parama.s0());
    }
    
    public void f(b8.c paramc, UUID paramUUID)
    {
      if (paramUUID == null) {
        paramUUID = null;
      } else {
        paramUUID = paramUUID.toString();
      }
      paramc.x0(paramUUID);
    }
  }
  
  static final class q
    extends v<Currency>
  {
    public Currency e(b8.a parama)
    {
      return Currency.getInstance(parama.s0());
    }
    
    public void f(b8.c paramc, Currency paramCurrency)
    {
      paramc.x0(paramCurrency.getCurrencyCode());
    }
  }
  
  static final class r
    implements w
  {
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      if (parama.getRawType() != Timestamp.class) {
        return null;
      }
      return new a(paramf.l(Date.class));
    }
    
    class a
      extends v<Timestamp>
    {
      a(v paramv) {}
      
      public Timestamp e(b8.a parama)
      {
        parama = (Date)this.a.b(parama);
        if (parama != null) {
          return new Timestamp(parama.getTime());
        }
        return null;
      }
      
      public void f(b8.c paramc, Timestamp paramTimestamp)
      {
        this.a.d(paramc, paramTimestamp);
      }
    }
  }
  
  static final class s
    extends v<Calendar>
  {
    public Calendar e(b8.a parama)
    {
      if (parama.u0() == b.i)
      {
        parama.q0();
        return null;
      }
      parama.g();
      int i2 = 0;
      int i = i2;
      int j = i;
      int k = j;
      int m = k;
      int n = m;
      int i1 = i;
      while (parama.u0() != b.d)
      {
        String str = parama.o0();
        i = parama.m0();
        if ("year".equals(str)) {
          i2 = i;
        } else if ("month".equals(str)) {
          i1 = i;
        } else if ("dayOfMonth".equals(str)) {
          j = i;
        } else if ("hourOfDay".equals(str)) {
          k = i;
        } else if ("minute".equals(str)) {
          m = i;
        } else if ("second".equals(str)) {
          n = i;
        }
      }
      parama.e0();
      return new GregorianCalendar(i2, i1, j, k, m, n);
    }
    
    public void f(b8.c paramc, Calendar paramCalendar)
    {
      if (paramCalendar == null)
      {
        paramc.k0();
        return;
      }
      paramc.i();
      paramc.i0("year");
      paramc.u0(paramCalendar.get(1));
      paramc.i0("month");
      paramc.u0(paramCalendar.get(2));
      paramc.i0("dayOfMonth");
      paramc.u0(paramCalendar.get(5));
      paramc.i0("hourOfDay");
      paramc.u0(paramCalendar.get(11));
      paramc.i0("minute");
      paramc.u0(paramCalendar.get(12));
      paramc.i0("second");
      paramc.u0(paramCalendar.get(13));
      paramc.e0();
    }
  }
  
  static final class t
    extends v<Locale>
  {
    public Locale e(b8.a parama)
    {
      Object localObject1 = parama.u0();
      Object localObject2 = b.i;
      String str = null;
      if (localObject1 == localObject2)
      {
        parama.q0();
        return null;
      }
      localObject2 = new StringTokenizer(parama.s0(), "_");
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        parama = ((StringTokenizer)localObject2).nextToken();
      } else {
        parama = null;
      }
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        localObject1 = ((StringTokenizer)localObject2).nextToken();
      } else {
        localObject1 = null;
      }
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        str = ((StringTokenizer)localObject2).nextToken();
      }
      if ((localObject1 == null) && (str == null)) {
        return new Locale(parama);
      }
      if (str == null)
      {
        parama = new Locale(parama, (String)localObject1);
        return parama;
      }
      parama = new Locale(parama, (String)localObject1, str);
      return parama;
    }
    
    public void f(b8.c paramc, Locale paramLocale)
    {
      if (paramLocale == null) {
        paramLocale = null;
      } else {
        paramLocale = paramLocale.toString();
      }
      paramc.x0(paramLocale);
    }
  }
  
  static final class u
    extends v<l>
  {
    public l e(b8.a parama)
    {
      Object localObject;
      switch (n.b0.a[parama.u0().ordinal()])
      {
      default: 
        throw new IllegalArgumentException();
      case 6: 
        localObject = new o();
        parama.g();
        while (parama.g0()) {
          ((o)localObject).h(parama.o0(), e(parama));
        }
        parama.e0();
        return localObject;
      case 5: 
        localObject = new i();
        parama.a();
        while (parama.g0()) {
          ((i)localObject).h(e(parama));
        }
        parama.d0();
        return localObject;
      case 4: 
        parama.q0();
        return v7.n.a;
      case 3: 
        return new q(parama.s0());
      case 2: 
        return new q(Boolean.valueOf(parama.k0()));
      }
      return new q(new g(parama.s0()));
    }
    
    public void f(b8.c paramc, l paraml)
    {
      if ((paraml != null) && (!paraml.e()))
      {
        if (paraml.g())
        {
          paraml = paraml.c();
          if (paraml.q())
          {
            paramc.w0(paraml.m());
            return;
          }
          if (paraml.o())
          {
            paramc.y0(paraml.h());
            return;
          }
          paramc.x0(paraml.n());
          return;
        }
        if (paraml.d())
        {
          paramc.h();
          paraml = paraml.a().iterator();
          while (paraml.hasNext()) {
            f(paramc, (l)paraml.next());
          }
          paramc.d0();
          return;
        }
        if (paraml.f())
        {
          paramc.i();
          paraml = paraml.b().i().iterator();
          while (paraml.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paraml.next();
            paramc.i0((String)localEntry.getKey());
            f(paramc, (l)localEntry.getValue());
          }
          paramc.e0();
          return;
        }
        paramc = new StringBuilder();
        paramc.append("Couldn't write ");
        paramc.append(paraml.getClass());
        throw new IllegalArgumentException(paramc.toString());
      }
      paramc.k0();
    }
  }
  
  static final class v
    extends v<BitSet>
  {
    public BitSet e(b8.a parama)
    {
      BitSet localBitSet = new BitSet();
      parama.a();
      Object localObject = parama.u0();
      int i = 0;
      while (localObject != b.b)
      {
        int j = n.b0.a[localObject.ordinal()];
        boolean bool = true;
        if (j != 1) {
          if (j != 2) {
            if (j == 3) {
              localObject = parama.s0();
            }
          }
        }
        label82:
        while (parama.m0() == 0)
        {
          try
          {
            j = Integer.parseInt((String)localObject);
            if (j != 0) {
              break;
            }
            bool = false;
          }
          catch (NumberFormatException parama)
          {
            break label82;
          }
          parama = new StringBuilder();
          parama.append("Error: Expecting: bitset number value (1, 0), Found: ");
          parama.append((String)localObject);
          throw new t(parama.toString());
          parama = new StringBuilder();
          parama.append("Invalid bitset value type: ");
          parama.append(localObject);
          throw new t(parama.toString());
          bool = parama.k0();
          break;
        }
        if (bool) {
          localBitSet.set(i);
        }
        i += 1;
        localObject = parama.u0();
      }
      parama.d0();
      return localBitSet;
    }
    
    public void f(b8.c paramc, BitSet paramBitSet)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class w
    implements w
  {
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      parama = parama.getRawType();
      if ((Enum.class.isAssignableFrom(parama)) && (parama != Enum.class))
      {
        paramf = parama;
        if (!parama.isEnum()) {
          paramf = parama.getSuperclass();
        }
        return new n.j0(paramf);
      }
      return null;
    }
  }
  
  static final class x
    implements w
  {
    x(Class paramClass, v paramv) {}
    
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      if (parama.getRawType() == this.a) {
        return paramv;
      }
      return null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Factory[type=");
      localStringBuilder.append(this.a.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(paramv);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class y
    implements w
  {
    y(Class paramClass1, Class paramClass2, v paramv) {}
    
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      paramf = parama.getRawType();
      if ((paramf != this.a) && (paramf != paramClass2)) {
        return null;
      }
      return paramv;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Factory[type=");
      localStringBuilder.append(paramClass2.getName());
      localStringBuilder.append("+");
      localStringBuilder.append(this.a.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(paramv);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class z
    implements w
  {
    z(Class paramClass1, Class paramClass2, v paramv) {}
    
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      paramf = parama.getRawType();
      if ((paramf != this.a) && (paramf != paramClass1)) {
        return null;
      }
      return paramv;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Factory[type=");
      localStringBuilder.append(this.a.getName());
      localStringBuilder.append("+");
      localStringBuilder.append(paramClass1.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(paramv);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.n
 * JD-Core Version:    0.7.0.1
 */