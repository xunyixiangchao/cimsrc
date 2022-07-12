package androidx.camera.extensions;

import s.c1;
import s.h2;
import s.s0;
import s.s0.a;
import s.u1;
import s.u2;
import s.w;

class b
  implements w
{
  public static final s0.a<Integer> B = s0.a.a("camerax.extensions.extensionMode", Integer.TYPE);
  private final s0 A;
  
  b(s0 params0)
  {
    this.A = params0;
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public c1 s()
  {
    return (c1)a(w.b);
  }
  
  static final class a
  {
    private final u1 a = u1.M();
    
    b a()
    {
      return new b(this.a);
    }
    
    public a b(c1 paramc1)
    {
      this.a.G(w.b, paramc1);
      return this;
    }
    
    public a c(int paramInt)
    {
      this.a.G(b.B, Integer.valueOf(paramInt));
      return this;
    }
    
    public a d(h2 paramh2)
    {
      this.a.G(w.d, paramh2);
      return this;
    }
    
    public a e(int paramInt)
    {
      this.a.G(w.c, Integer.valueOf(paramInt));
      return this;
    }
    
    public a f(u2 paramu2)
    {
      this.a.G(w.a, paramu2);
      return this;
    }
    
    public a g(boolean paramBoolean)
    {
      this.a.G(w.e, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.extensions.b
 * JD-Core Version:    0.7.0.1
 */