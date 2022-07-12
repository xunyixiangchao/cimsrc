package k0;

import h0.c;
import h0.i.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import l0.o;

public class d
{
  private HashSet<d> a = null;
  private int b;
  private boolean c;
  public final e d;
  public final b e;
  public d f;
  public int g = 0;
  int h = -2147483648;
  h0.i i;
  
  public d(e parame, b paramb)
  {
    this.d = parame;
    this.e = paramb;
  }
  
  public boolean a(d paramd, int paramInt)
  {
    return b(paramd, paramInt, -2147483648, false);
  }
  
  public boolean b(d paramd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramd == null)
    {
      q();
      return true;
    }
    if ((!paramBoolean) && (!p(paramd))) {
      return false;
    }
    this.f = paramd;
    if (paramd.a == null) {
      paramd.a = new HashSet();
    }
    paramd = this.f.a;
    if (paramd != null) {
      paramd.add(this);
    }
    this.g = paramInt1;
    this.h = paramInt2;
    return true;
  }
  
  public void c(int paramInt, ArrayList<o> paramArrayList, o paramo)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        l0.i.a(((d)((Iterator)localObject).next()).d, paramInt, paramArrayList, paramo);
      }
    }
  }
  
  public HashSet<d> d()
  {
    return this.a;
  }
  
  public int e()
  {
    if (!this.c) {
      return 0;
    }
    return this.b;
  }
  
  public int f()
  {
    if (this.d.X() == 8) {
      return 0;
    }
    if (this.h != -2147483648)
    {
      d locald = this.f;
      if ((locald != null) && (locald.d.X() == 8)) {
        return this.h;
      }
    }
    return this.g;
  }
  
  public final d g()
  {
    switch (a.a[this.e.ordinal()])
    {
    default: 
      throw new AssertionError(this.e.name());
    case 5: 
      return this.d.R;
    case 4: 
      return this.d.T;
    case 3: 
      return this.d.Q;
    case 2: 
      return this.d.S;
    }
    return null;
  }
  
  public e h()
  {
    return this.d;
  }
  
  public h0.i i()
  {
    return this.i;
  }
  
  public d j()
  {
    return this.f;
  }
  
  public b k()
  {
    return this.e;
  }
  
  public boolean l()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((d)((Iterator)localObject).next()).g().o()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean m()
  {
    HashSet localHashSet = this.a;
    boolean bool = false;
    if (localHashSet == null) {
      return false;
    }
    if (localHashSet.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean n()
  {
    return this.c;
  }
  
  public boolean o()
  {
    return this.f != null;
  }
  
  public boolean p(d paramd)
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramd == null) {
      return false;
    }
    b localb1 = paramd.k();
    b localb2 = this.e;
    if (localb1 == localb2) {
      return (localb2 != b.f) || ((paramd.h().b0()) && (h().b0()));
    }
    switch (a.a[localb2.ordinal()])
    {
    default: 
      throw new AssertionError(this.e.name());
    case 7: 
    case 8: 
    case 9: 
      return false;
    case 6: 
      if (localb1 != b.b) {
        return localb1 != b.d;
      }
      return false;
    case 4: 
    case 5: 
      if ((localb1 != b.c) && (localb1 != b.e)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if ((paramd.h() instanceof h))
      {
        if (!bool1)
        {
          bool1 = bool3;
          if (localb1 != b.i) {}
        }
        else
        {
          bool1 = true;
        }
        bool2 = bool1;
      }
      return bool2;
    case 2: 
    case 3: 
      if ((localb1 != b.b) && (localb1 != b.d)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if ((paramd.h() instanceof h))
      {
        if (!bool1)
        {
          bool1 = bool4;
          if (localb1 != b.h) {}
        }
        else
        {
          bool1 = true;
        }
        bool2 = bool1;
      }
      return bool2;
    }
    boolean bool1 = bool2;
    if (localb1 != b.f)
    {
      bool1 = bool2;
      if (localb1 != b.h)
      {
        bool1 = bool2;
        if (localb1 != b.i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void q()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((d)localObject).a;
      if (localObject != null)
      {
        ((HashSet)localObject).remove(this);
        if (this.f.a.size() == 0) {
          this.f.a = null;
        }
      }
    }
    this.a = null;
    this.f = null;
    this.g = 0;
    this.h = -2147483648;
    this.c = false;
    this.b = 0;
  }
  
  public void r()
  {
    this.c = false;
    this.b = 0;
  }
  
  public void s(c paramc)
  {
    paramc = this.i;
    if (paramc == null)
    {
      this.i = new h0.i(i.a.a, null);
      return;
    }
    paramc.e();
  }
  
  public void t(int paramInt)
  {
    this.b = paramInt;
    this.c = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.v());
    localStringBuilder.append(":");
    localStringBuilder.append(this.e.toString());
    return localStringBuilder.toString();
  }
  
  public void u(int paramInt)
  {
    if (o()) {
      this.h = paramInt;
    }
  }
  
  public static enum b
  {
    static
    {
      b localb1 = new b("NONE", 0);
      a = localb1;
      b localb2 = new b("LEFT", 1);
      b = localb2;
      b localb3 = new b("TOP", 2);
      c = localb3;
      b localb4 = new b("RIGHT", 3);
      d = localb4;
      b localb5 = new b("BOTTOM", 4);
      e = localb5;
      b localb6 = new b("BASELINE", 5);
      f = localb6;
      b localb7 = new b("CENTER", 6);
      g = localb7;
      b localb8 = new b("CENTER_X", 7);
      h = localb8;
      b localb9 = new b("CENTER_Y", 8);
      i = localb9;
      j = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.d
 * JD-Core Version:    0.7.0.1
 */