package ea;

import aa.b;
import aa.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import l9.a0;
import l9.a0.a;
import l9.a0.c;
import l9.d0.a;
import l9.e0;
import l9.u.a;
import l9.w;
import l9.w.a;
import l9.x;
import l9.x.a;
import l9.z;

final class r
{
  private static final char[] l = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final Pattern m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
  private final String a;
  private final x b;
  @Nullable
  private String c;
  @Nullable
  private x.a d;
  private final d0.a e;
  private final w.a f;
  @Nullable
  private z g;
  private final boolean h;
  @Nullable
  private a0.a i;
  @Nullable
  private u.a j;
  @Nullable
  private e0 k;
  
  r(String paramString1, x paramx, @Nullable String paramString2, @Nullable w paramw, @Nullable z paramz, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramString1;
    this.b = paramx;
    this.c = paramString2;
    this.e = new d0.a();
    this.g = paramz;
    this.h = paramBoolean1;
    if (paramw != null) {
      paramString1 = paramw.d();
    } else {
      paramString1 = new w.a();
    }
    this.f = paramString1;
    if (paramBoolean2)
    {
      this.j = new u.a();
      return;
    }
    if (paramBoolean3)
    {
      paramString1 = new a0.a();
      this.i = paramString1;
      paramString1.d(a0.l);
    }
  }
  
  private static String i(String paramString, boolean paramBoolean)
  {
    int i1 = paramString.length();
    int n = 0;
    for (;;)
    {
      localObject = paramString;
      if (n >= i1) {
        break label113;
      }
      int i2 = paramString.codePointAt(n);
      if ((i2 < 32) || (i2 >= 127) || (" \"<>^`{}|\\?#".indexOf(i2) != -1) || ((!paramBoolean) && ((i2 == 47) || (i2 == 37)))) {
        break;
      }
      n += Character.charCount(i2);
    }
    Object localObject = new b();
    ((b)localObject).O0(paramString, 0, n);
    j((b)localObject, paramString, n, i1, paramBoolean);
    localObject = ((b)localObject).v0();
    label113:
    return localObject;
  }
  
  private static void j(b paramb, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject3;
    for (Object localObject2 = null; paramInt1 < paramInt2; localObject2 = localObject3)
    {
      int n = paramString.codePointAt(paramInt1);
      if (paramBoolean)
      {
        localObject3 = localObject2;
        if (n == 9) {
          break label220;
        }
        localObject3 = localObject2;
        if (n == 10) {
          break label220;
        }
        localObject3 = localObject2;
        if (n == 12) {
          break label220;
        }
        if (n == 13)
        {
          localObject3 = localObject2;
          break label220;
        }
      }
      if ((n >= 32) && (n < 127) && (" \"<>^`{}|\\?#".indexOf(n) == -1) && ((paramBoolean) || ((n != 47) && (n != 37))))
      {
        paramb.P0(n);
        localObject3 = localObject2;
      }
      else
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new b();
        }
        ((b)localObject1).P0(n);
        for (;;)
        {
          localObject3 = localObject1;
          if (((b)localObject1).D()) {
            break;
          }
          int i1 = ((b)localObject1).readByte() & 0xFF;
          paramb.H0(37);
          localObject2 = l;
          paramb.H0(localObject2[(i1 >> 4 & 0xF)]);
          paramb.H0(localObject2[(i1 & 0xF)]);
        }
      }
      label220:
      paramInt1 += Character.charCount(n);
    }
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.b(paramString1, paramString2);
      return;
    }
    this.j.a(paramString1, paramString2);
  }
  
  void b(String paramString1, String paramString2)
  {
    if ("Content-Type".equalsIgnoreCase(paramString1)) {
      try
      {
        this.g = z.b(paramString2);
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Malformed content type: ");
        localStringBuilder.append(paramString2);
        throw new IllegalArgumentException(localStringBuilder.toString(), paramString1);
      }
    }
    this.f.a(paramString1, paramString2);
  }
  
  void c(w paramw)
  {
    this.f.b(paramw);
  }
  
  void d(w paramw, e0 parame0)
  {
    this.i.a(paramw, parame0);
  }
  
  void e(a0.c paramc)
  {
    this.i.b(paramc);
  }
  
  void f(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.c != null)
    {
      String str1 = i(paramString2, paramBoolean);
      String str2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("}");
      paramString1 = str2.replace(localStringBuilder.toString(), str1);
      if (!m.matcher(paramString1).matches())
      {
        this.c = paramString1;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
    }
    throw new AssertionError();
  }
  
  void g(String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = this.b.l((String)localObject);
      this.d = ((x.a)localObject);
      if (localObject != null)
      {
        this.c = null;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("Malformed URL. Base: ");
        paramString1.append(this.b);
        paramString1.append(", Relative: ");
        paramString1.append(this.c);
        throw new IllegalArgumentException(paramString1.toString());
      }
    }
    if (paramBoolean)
    {
      this.d.a(paramString1, paramString2);
      return;
    }
    this.d.b(paramString1, paramString2);
  }
  
  <T> void h(Class<T> paramClass, @Nullable T paramT)
  {
    this.e.n(paramClass, paramT);
  }
  
  d0.a k()
  {
    Object localObject1 = this.d;
    x localx;
    if (localObject1 != null)
    {
      localx = ((x.a)localObject1).c();
    }
    else
    {
      localx = this.b.q(this.c);
      if (localx == null) {
        break label170;
      }
    }
    Object localObject2 = this.k;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.j;
      if (localObject1 != null)
      {
        localObject1 = ((u.a)localObject1).c();
      }
      else
      {
        localObject1 = this.i;
        if (localObject1 != null)
        {
          localObject1 = ((a0.a)localObject1).c();
        }
        else
        {
          localObject1 = localObject2;
          if (this.h) {
            localObject1 = e0.d(null, new byte[0]);
          }
        }
      }
    }
    z localz = this.g;
    localObject2 = localObject1;
    if (localz != null) {
      if (localObject1 != null)
      {
        localObject2 = new a((e0)localObject1, localz);
      }
      else
      {
        this.f.a("Content-Type", localz.toString());
        localObject2 = localObject1;
      }
    }
    return this.e.p(localx).f(this.f.f()).g(this.a, (e0)localObject2);
    label170:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Malformed URL. Base: ");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(", Relative: ");
    ((StringBuilder)localObject1).append(this.c);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  void l(e0 parame0)
  {
    this.k = parame0;
  }
  
  void m(Object paramObject)
  {
    this.c = paramObject.toString();
  }
  
  private static class a
    extends e0
  {
    private final e0 b;
    private final z c;
    
    a(e0 parame0, z paramz)
    {
      this.b = parame0;
      this.c = paramz;
    }
    
    public long a()
    {
      return this.b.a();
    }
    
    public z b()
    {
      return this.c;
    }
    
    public void g(c paramc)
    {
      this.b.g(paramc);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.r
 * JD-Core Version:    0.7.0.1
 */