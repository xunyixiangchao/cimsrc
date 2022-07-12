package l9;

import a9.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

public final class l
{
  public static final b e = new b(null);
  private static final i[] f;
  private static final i[] g;
  public static final l h;
  public static final l i;
  public static final l j;
  public static final l k = new a(false).a();
  private final boolean a;
  private final boolean b;
  private final String[] c;
  private final String[] d;
  
  static
  {
    Object localObject1 = new i[9];
    Object localObject2 = i.o1;
    localObject1[0] = localObject2;
    Object localObject3 = i.p1;
    localObject1[1] = localObject3;
    i locali1 = i.q1;
    localObject1[2] = locali1;
    i locali2 = i.a1;
    localObject1[3] = locali2;
    i locali3 = i.e1;
    localObject1[4] = locali3;
    i locali4 = i.b1;
    localObject1[5] = locali4;
    i locali5 = i.f1;
    localObject1[6] = locali5;
    i locali6 = i.l1;
    localObject1[7] = locali6;
    i locali7 = i.k1;
    localObject1[8] = locali7;
    f = (i[])localObject1;
    i[] arrayOfi = new i[16];
    arrayOfi[0] = localObject2;
    arrayOfi[1] = localObject3;
    arrayOfi[2] = locali1;
    arrayOfi[3] = locali2;
    arrayOfi[4] = locali3;
    arrayOfi[5] = locali4;
    arrayOfi[6] = locali5;
    arrayOfi[7] = locali6;
    arrayOfi[8] = locali7;
    arrayOfi[9] = i.L0;
    arrayOfi[10] = i.M0;
    arrayOfi[11] = i.j0;
    arrayOfi[12] = i.k0;
    arrayOfi[13] = i.H;
    arrayOfi[14] = i.L;
    arrayOfi[15] = i.l;
    g = arrayOfi;
    localObject1 = new a(true).c((i[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    localObject2 = i0.c;
    localObject3 = i0.d;
    h = ((a)localObject1).j(new i0[] { localObject2, localObject3 }).h(true).a();
    i = new a(true).c((i[])Arrays.copyOf(arrayOfi, arrayOfi.length)).j(new i0[] { localObject2, localObject3 }).h(true).a();
    j = new a(true).c((i[])Arrays.copyOf(arrayOfi, arrayOfi.length)).j(new i0[] { localObject2, localObject3, i0.e, i0.f }).h(true).a();
  }
  
  public l(boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
  
  private final l g(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    f.e(arrayOfString1, "socketEnabledCipherSuites");
    String[] arrayOfString2 = m9.a.c(this, arrayOfString1);
    if (this.d != null)
    {
      arrayOfString1 = paramSSLSocket.getEnabledProtocols();
      f.e(arrayOfString1, "sslSocket.enabledProtocols");
      arrayOfString1 = m9.l.w(arrayOfString1, this.d, r8.a.b());
    }
    else
    {
      arrayOfString1 = paramSSLSocket.getEnabledProtocols();
    }
    String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
    f.e(arrayOfString3, "supportedCipherSuites");
    int m = m9.l.o(arrayOfString3, "TLS_FALLBACK_SCSV", i.b.c());
    paramSSLSocket = arrayOfString2;
    if (paramBoolean)
    {
      paramSSLSocket = arrayOfString2;
      if (m != -1)
      {
        paramSSLSocket = arrayOfString3[m];
        f.e(paramSSLSocket, "supportedCipherSuites[indexOfFallbackScsv]");
        paramSSLSocket = m9.l.g(arrayOfString2, paramSSLSocket);
      }
    }
    paramSSLSocket = new a(this).b((String[])Arrays.copyOf(paramSSLSocket, paramSSLSocket.length));
    f.e(arrayOfString1, "tlsVersionsIntersection");
    return paramSSLSocket.i((String[])Arrays.copyOf(arrayOfString1, arrayOfString1.length)).a();
  }
  
  public final void b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    f.f(paramSSLSocket, "sslSocket");
    l locall = g(paramSSLSocket, paramBoolean);
    if (locall.i() != null) {
      paramSSLSocket.setEnabledProtocols(locall.d);
    }
    if (locall.c() != null) {
      paramSSLSocket.setEnabledCipherSuites(locall.c);
    }
  }
  
  public final List<i> c()
  {
    String[] arrayOfString = this.c;
    if (arrayOfString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(arrayOfString.length);
    int m = 0;
    int n = arrayOfString.length;
    while (m < n)
    {
      String str = arrayOfString[m];
      m += 1;
      localArrayList.add(i.b.b(str));
    }
    return p8.l.J(localArrayList);
  }
  
  public final String[] d()
  {
    return this.c;
  }
  
  public final boolean e(SSLSocket paramSSLSocket)
  {
    f.f(paramSSLSocket, "socket");
    if (!this.a) {
      return false;
    }
    String[] arrayOfString = this.d;
    if ((arrayOfString != null) && (!m9.l.n(arrayOfString, paramSSLSocket.getEnabledProtocols(), r8.a.b()))) {
      return false;
    }
    arrayOfString = this.c;
    return (arrayOfString == null) || (m9.l.n(arrayOfString, paramSSLSocket.getEnabledCipherSuites(), i.b.c()));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof l)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    boolean bool = this.a;
    paramObject = (l)paramObject;
    if (bool != paramObject.a) {
      return false;
    }
    if (bool)
    {
      if (!Arrays.equals(this.c, paramObject.c)) {
        return false;
      }
      if (!Arrays.equals(this.d, paramObject.d)) {
        return false;
      }
      if (this.b != paramObject.b) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean f()
  {
    return this.a;
  }
  
  public final boolean h()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    if (this.a)
    {
      String[] arrayOfString = this.c;
      int n = 0;
      int m;
      if (arrayOfString == null) {
        m = 0;
      } else {
        m = Arrays.hashCode(arrayOfString);
      }
      arrayOfString = this.d;
      if (arrayOfString != null) {
        n = Arrays.hashCode(arrayOfString);
      }
      return ((527 + m) * 31 + n) * 31 + (this.b ^ true);
    }
    return 17;
  }
  
  public final List<i0> i()
  {
    String[] arrayOfString = this.d;
    if (arrayOfString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(arrayOfString.length);
    int m = 0;
    int n = arrayOfString.length;
    while (m < n)
    {
      String str = arrayOfString[m];
      m += 1;
      localArrayList.add(i0.b.a(str));
    }
    return p8.l.J(localArrayList);
  }
  
  public String toString()
  {
    if (!this.a) {
      return "ConnectionSpec()";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionSpec(cipherSuites=");
    localStringBuilder.append(Objects.toString(c(), "[all enabled]"));
    localStringBuilder.append(", tlsVersions=");
    localStringBuilder.append(Objects.toString(i(), "[all enabled]"));
    localStringBuilder.append(", supportsTlsExtensions=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private boolean a;
    private String[] b;
    private String[] c;
    private boolean d;
    
    public a(l paraml)
    {
      this.a = paraml.f();
      this.b = paraml.d();
      this.c = l.a(paraml);
      this.d = paraml.h();
    }
    
    public a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public final l a()
    {
      return new l(this.a, this.d, this.b, this.c);
    }
    
    public final a b(String... paramVarArgs)
    {
      f.f(paramVarArgs, "cipherSuites");
      if (d())
      {
        int i;
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          e((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one cipher suite is required".toString());
      }
      throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }
    
    public final a c(i... paramVarArgs)
    {
      f.f(paramVarArgs, "cipherSuites");
      if (d())
      {
        ArrayList localArrayList = new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          i locali = paramVarArgs[i];
          i += 1;
          localArrayList.add(locali.c());
        }
        paramVarArgs = localArrayList.toArray(new String[0]);
        Objects.requireNonNull(paramVarArgs, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        paramVarArgs = (String[])paramVarArgs;
        return b((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      }
      throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }
    
    public final boolean d()
    {
      return this.a;
    }
    
    public final void e(String[] paramArrayOfString)
    {
      this.b = paramArrayOfString;
    }
    
    public final void f(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
    
    public final void g(String[] paramArrayOfString)
    {
      this.c = paramArrayOfString;
    }
    
    public final a h(boolean paramBoolean)
    {
      if (d())
      {
        f(paramBoolean);
        return this;
      }
      throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
    }
    
    public final a i(String... paramVarArgs)
    {
      f.f(paramVarArgs, "tlsVersions");
      if (d())
      {
        int i;
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          g((String[])paramVarArgs.clone());
          return this;
        }
        throw new IllegalArgumentException("At least one TLS version is required".toString());
      }
      throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }
    
    public final a j(i0... paramVarArgs)
    {
      f.f(paramVarArgs, "tlsVersions");
      if (d())
      {
        ArrayList localArrayList = new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          i0 locali0 = paramVarArgs[i];
          i += 1;
          localArrayList.add(locali0.b());
        }
        paramVarArgs = localArrayList.toArray(new String[0]);
        Objects.requireNonNull(paramVarArgs, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        paramVarArgs = (String[])paramVarArgs;
        return i((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      }
      throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }
  }
  
  public static final class b {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.l
 * JD-Core Version:    0.7.0.1
 */