package d2;

import b2.a;
import b2.c;

public abstract class j
{
  public static final j a = new a();
  public static final j b = new b();
  public static final j c = new c();
  public static final j d = new d();
  public static final j e = new e();
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean c(a parama);
  
  public abstract boolean d(boolean paramBoolean, a parama, c paramc);
  
  class a
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(a parama)
    {
      return parama == a.b;
    }
    
    public boolean d(boolean paramBoolean, a parama, c paramc)
    {
      return (parama != a.d) && (parama != a.e);
    }
  }
  
  class b
    extends j
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean c(a parama)
    {
      return false;
    }
    
    public boolean d(boolean paramBoolean, a parama, c paramc)
    {
      return false;
    }
  }
  
  class c
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean c(a parama)
    {
      return (parama != a.c) && (parama != a.e);
    }
    
    public boolean d(boolean paramBoolean, a parama, c paramc)
    {
      return false;
    }
  }
  
  class d
    extends j
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(a parama)
    {
      return false;
    }
    
    public boolean d(boolean paramBoolean, a parama, c paramc)
    {
      return (parama != a.d) && (parama != a.e);
    }
  }
  
  class e
    extends j
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean b()
    {
      return true;
    }
    
    public boolean c(a parama)
    {
      return parama == a.b;
    }
    
    public boolean d(boolean paramBoolean, a parama, c paramc)
    {
      return ((paramBoolean) && (parama == a.c)) || ((parama == a.a) && (paramc == c.b));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.j
 * JD-Core Version:    0.7.0.1
 */