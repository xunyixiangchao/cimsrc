package t2;

public abstract interface f
{
  public abstract void a(e parame);
  
  public abstract boolean b();
  
  public abstract boolean c(e parame);
  
  public abstract boolean d(e parame);
  
  public abstract boolean e(e parame);
  
  public abstract f g();
  
  public abstract void h(e parame);
  
  public static enum a
  {
    private final boolean a;
    
    static
    {
      a locala1 = new a("RUNNING", 0, false);
      b = locala1;
      a locala2 = new a("PAUSED", 1, false);
      c = locala2;
      a locala3 = new a("CLEARED", 2, false);
      d = locala3;
      a locala4 = new a("SUCCESS", 3, true);
      e = locala4;
      a locala5 = new a("FAILED", 4, true);
      f = locala5;
      g = new a[] { locala1, locala2, locala3, locala4, locala5 };
    }
    
    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    boolean a()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.f
 * JD-Core Version:    0.7.0.1
 */