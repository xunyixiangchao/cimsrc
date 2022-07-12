package t2;

public final class b
  implements f, e
{
  private final Object a;
  private final f b;
  private volatile e c;
  private volatile e d;
  private f.a e;
  private f.a f;
  
  public b(Object paramObject, f paramf)
  {
    f.a locala = f.a.d;
    this.e = locala;
    this.f = locala;
    this.a = paramObject;
    this.b = paramf;
  }
  
  private boolean l(e parame)
  {
    return (parame.equals(this.c)) || ((this.e == f.a.f) && (parame.equals(this.d)));
  }
  
  private boolean m()
  {
    f localf = this.b;
    return (localf == null) || (localf.e(this));
  }
  
  private boolean n()
  {
    f localf = this.b;
    return (localf == null) || (localf.c(this));
  }
  
  private boolean o()
  {
    f localf = this.b;
    return (localf == null) || (localf.d(this));
  }
  
  public void a(e parame)
  {
    synchronized (this.a)
    {
      if (parame.equals(this.c)) {
        this.e = f.a.e;
      } else if (parame.equals(this.d)) {
        this.f = f.a.e;
      }
      parame = this.b;
      if (parame != null) {
        parame.a(this);
      }
      return;
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.c.b()) {
          break label48;
        }
        if (this.d.b())
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
      synchronized (this.a)
      {
        if ((n()) && (l(parame)))
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
    synchronized (this.a)
    {
      f.a locala = f.a.d;
      this.e = locala;
      this.c.clear();
      if (this.f != locala)
      {
        this.f = locala;
        this.d.clear();
      }
      return;
    }
  }
  
  public boolean d(e parame)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if ((o()) && (l(parame)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean e(e parame)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if ((m()) && (l(parame)))
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
      synchronized (this.a)
      {
        f.a locala1 = this.e;
        f.a locala2 = f.a.d;
        if ((locala1 == locala2) && (this.f == locala2))
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
      synchronized (this.a)
      {
        f localf = this.b;
        if (localf != null)
        {
          localf = localf.g();
          return localf;
        }
      }
      b localb = this;
    }
  }
  
  public void h(e parame)
  {
    synchronized (this.a)
    {
      if (!parame.equals(this.d))
      {
        this.e = f.a.f;
        parame = this.f;
        f.a locala = f.a.b;
        if (parame != locala)
        {
          this.f = locala;
          this.d.i();
        }
        return;
      }
      this.f = f.a.f;
      parame = this.b;
      if (parame != null) {
        parame.h(this);
      }
      return;
    }
  }
  
  public void i()
  {
    synchronized (this.a)
    {
      f.a locala1 = this.e;
      f.a locala2 = f.a.b;
      if (locala1 != locala2)
      {
        this.e = locala2;
        this.c.i();
      }
      return;
    }
  }
  
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        f.a locala1 = this.e;
        f.a locala2 = f.a.b;
        if (locala1 == locala2) {
          break label49;
        }
        if (this.f == locala2)
        {
          break label49;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label49:
      bool = true;
    }
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        f.a locala1 = this.e;
        f.a locala2 = f.a.e;
        if (locala1 == locala2) {
          break label49;
        }
        if (this.f == locala2)
        {
          break label49;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label49:
      bool = true;
    }
  }
  
  public boolean k(e parame)
  {
    boolean bool3 = parame instanceof b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      parame = (b)parame;
      bool1 = bool2;
      if (this.c.k(parame.c))
      {
        bool1 = bool2;
        if (this.d.k(parame.d)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void p(e parame1, e parame2)
  {
    this.c = parame1;
    this.d = parame2;
  }
  
  public void pause()
  {
    synchronized (this.a)
    {
      f.a locala1 = this.e;
      f.a locala2 = f.a.b;
      if (locala1 == locala2)
      {
        this.e = f.a.c;
        this.c.pause();
      }
      if (this.f == locala2)
      {
        this.f = f.a.c;
        this.d.pause();
      }
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.b
 * JD-Core Version:    0.7.0.1
 */