package t2;

public class l
  implements f, e
{
  private final f a;
  private final Object b;
  private volatile e c;
  private volatile e d;
  private f.a e;
  private f.a f;
  private boolean g;
  
  public l(Object paramObject, f paramf)
  {
    f.a locala = f.a.d;
    this.e = locala;
    this.f = locala;
    this.b = paramObject;
    this.a = paramf;
  }
  
  private boolean l()
  {
    f localf = this.a;
    return (localf == null) || (localf.e(this));
  }
  
  private boolean m()
  {
    f localf = this.a;
    return (localf == null) || (localf.c(this));
  }
  
  private boolean n()
  {
    f localf = this.a;
    return (localf == null) || (localf.d(this));
  }
  
  public void a(e parame)
  {
    synchronized (this.b)
    {
      if (parame.equals(this.d))
      {
        this.f = f.a.e;
        return;
      }
      this.e = f.a.e;
      parame = this.a;
      if (parame != null) {
        parame.a(this);
      }
      if (!this.f.a()) {
        this.d.clear();
      }
      return;
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.d.b()) {
          break label48;
        }
        if (this.c.b())
        {
          break label48;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label48:
      bool = true;
    }
  }
  
  public boolean c(e parame)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if ((m()) && (parame.equals(this.c)) && (!b()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void clear()
  {
    synchronized (this.b)
    {
      this.g = false;
      f.a locala = f.a.d;
      this.e = locala;
      this.f = locala;
      this.d.clear();
      this.c.clear();
      return;
    }
  }
  
  public boolean d(e parame)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (!n()) {
          break label52;
        }
        if (!parame.equals(this.c))
        {
          if (this.e == f.a.e) {
            break label52;
          }
          break label47;
          return bool;
        }
      }
      label47:
      boolean bool = true;
      continue;
      label52:
      bool = false;
    }
  }
  
  public boolean e(e parame)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if ((l()) && (parame.equals(this.c)) && (this.e != f.a.c))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean f()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.e == f.a.d)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public f g()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        f localf = this.a;
        if (localf != null)
        {
          localf = localf.g();
          return localf;
        }
      }
      l locall = this;
    }
  }
  
  public void h(e parame)
  {
    synchronized (this.b)
    {
      if (!parame.equals(this.c))
      {
        this.f = f.a.f;
        return;
      }
      this.e = f.a.f;
      parame = this.a;
      if (parame != null) {
        parame.h(this);
      }
      return;
    }
  }
  
  public void i()
  {
    synchronized (this.b)
    {
      this.g = true;
      try
      {
        f.a locala1;
        f.a locala2;
        if (this.e != f.a.e)
        {
          locala1 = this.f;
          locala2 = f.a.b;
          if (locala1 != locala2)
          {
            this.f = locala2;
            this.d.i();
          }
        }
        if (this.g)
        {
          locala1 = this.e;
          locala2 = f.a.b;
          if (locala1 != locala2)
          {
            this.e = locala2;
            this.c.i();
          }
        }
        this.g = false;
        return;
      }
      finally
      {
        this.g = false;
      }
    }
  }
  
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.e == f.a.b)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.e == f.a.e)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean k(e parame)
  {
    boolean bool3 = parame instanceof l;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      parame = (l)parame;
      if (this.c == null)
      {
        bool1 = bool2;
        if (parame.c != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!this.c.k(parame.c)) {
          return bool1;
        }
      }
      if (this.d == null)
      {
        bool1 = bool2;
        if (parame.d != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!this.d.k(parame.d)) {
          return bool1;
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public void o(e parame1, e parame2)
  {
    this.c = parame1;
    this.d = parame2;
  }
  
  public void pause()
  {
    synchronized (this.b)
    {
      if (!this.f.a())
      {
        this.f = f.a.c;
        this.d.pause();
      }
      if (!this.e.a())
      {
        this.e = f.a.c;
        this.c.pause();
      }
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.l
 * JD-Core Version:    0.7.0.1
 */