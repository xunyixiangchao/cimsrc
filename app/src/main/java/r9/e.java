package r9;

import a9.f;
import aa.b;
import aa.e.a;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l9.d0;
import l9.f0;
import l9.o.a;
import l9.p;
import l9.w;
import l9.x;
import p8.c0;
import u9.h.a;

public final class e
{
  private static final aa.e a;
  private static final aa.e b;
  
  static
  {
    e.a locala = aa.e.d;
    a = locala.c("\"\\");
    b = locala.c("\t ,=");
  }
  
  public static final List<l9.h> a(w paramw, String paramString)
  {
    f.f(paramw, "<this>");
    f.f(paramString, "headerName");
    ArrayList localArrayList = new ArrayList();
    int j = paramw.size();
    int i = 0;
    while (i < j)
    {
      if (f9.l.l(paramString, paramw.c(i), true))
      {
        b localb = new b().N0(paramw.f(i));
        try
        {
          c(localb, localArrayList);
        }
        catch (EOFException localEOFException)
        {
          u9.h.a.g().j("Unable to parse challenge", 5, localEOFException);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static final boolean b(f0 paramf0)
  {
    f.f(paramf0, "<this>");
    if (f.a(paramf0.q0().g(), "HEAD")) {
      return false;
    }
    int i = paramf0.B();
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
      return true;
    }
    if (m9.o.j(paramf0) == -1L) {
      return f9.l.l("chunked", f0.h0(paramf0, "Transfer-Encoding", null, 2, null), true);
    }
    return true;
  }
  
  private static final void c(b paramb, List<l9.h> paramList)
  {
    Object localObject1;
    Object localObject2;
    String str;
    byte b1;
    int i;
    for (;;)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        g(paramb);
        localObject1 = e(paramb);
        localObject2 = localObject1;
        if (localObject1 == null) {
          return;
        }
      }
      boolean bool1 = g(paramb);
      str = e(paramb);
      if (str == null)
      {
        if (!paramb.D()) {
          return;
        }
        paramList.add(new l9.h(localObject2, c0.c()));
        return;
      }
      b1 = (byte)61;
      i = m9.l.B(paramb, b1);
      boolean bool2 = g(paramb);
      if ((bool1) || ((!bool2) && (!paramb.D()))) {
        break;
      }
      localObject1 = Collections.singletonMap(null, f.m(str, f9.l.p("=", i)));
      f.e(localObject1, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
      paramList.add(new l9.h(localObject2, (Map)localObject1));
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    i += m9.l.B(paramb, b1);
    for (;;)
    {
      localObject1 = str;
      if (str == null)
      {
        localObject1 = e(paramb);
        if (!g(paramb)) {
          i = m9.l.B(paramb, b1);
        }
      }
      else
      {
        if (i != 0) {
          break label229;
        }
      }
      paramList.add(new l9.h(localObject2, localLinkedHashMap));
      break;
      label229:
      if (i > 1) {
        return;
      }
      if (g(paramb)) {
        return;
      }
      if (h(paramb, (byte)34)) {
        str = d(paramb);
      } else {
        str = e(paramb);
      }
      if (str == null) {
        return;
      }
      if ((String)localLinkedHashMap.put(localObject1, str) != null) {
        return;
      }
      if ((!g(paramb)) && (!paramb.D())) {
        return;
      }
      str = null;
    }
  }
  
  private static final String d(b paramb)
  {
    int i = paramb.readByte();
    int j = (byte)34;
    if (i == j) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      b localb = new b();
      for (;;)
      {
        long l = paramb.k0(a);
        if (l == -1L) {
          return null;
        }
        if (paramb.i0(l) == j)
        {
          localb.L(paramb, l);
          paramb.readByte();
          return localb.v0();
        }
        if (paramb.z0() == l + 1L) {
          return null;
        }
        localb.L(paramb, l);
        paramb.readByte();
        localb.L(paramb, 1L);
      }
    }
    throw new IllegalArgumentException("Failed requirement.".toString());
  }
  
  private static final String e(b paramb)
  {
    long l2 = paramb.k0(b);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = paramb.z0();
    }
    if (l1 != 0L) {
      return paramb.w0(l1);
    }
    return null;
  }
  
  public static final void f(p paramp, x paramx, w paramw)
  {
    f.f(paramp, "<this>");
    f.f(paramx, "url");
    f.f(paramw, "headers");
    if (paramp == p.b) {
      return;
    }
    paramw = l9.o.j.e(paramx, paramw);
    if (paramw.isEmpty()) {
      return;
    }
    paramp.b(paramx, paramw);
  }
  
  private static final boolean g(b paramb)
  {
    boolean bool = false;
    while (!paramb.D())
    {
      int i = paramb.i0(0L);
      if (i == (byte)44)
      {
        paramb.readByte();
        bool = true;
      }
      else
      {
        if (i == (byte)32) {}
        while (i == (byte)9)
        {
          i = 1;
          break;
        }
        i = 0;
        if (i == 0) {
          break;
        }
        paramb.readByte();
      }
    }
    return bool;
  }
  
  private static final boolean h(b paramb, byte paramByte)
  {
    return (!paramb.D()) && (paramb.i0(0L) == paramByte);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.e
 * JD-Core Version:    0.7.0.1
 */