package s;

public abstract class l2
{
  public static l2 a(b paramb, a parama)
  {
    return new h(paramb, parama);
  }
  
  public abstract a b();
  
  public abstract b c();
  
  public final boolean d(l2 paraml2)
  {
    b localb = paraml2.c();
    return (paraml2.b().a() <= b().a()) && (localb == c());
  }
  
  public static enum a
  {
    final int a;
    
    static
    {
      a locala1 = new a("ANALYSIS", 0, 0);
      b = locala1;
      a locala2 = new a("PREVIEW", 1, 1);
      c = locala2;
      a locala3 = new a("RECORD", 2, 2);
      d = locala3;
      a locala4 = new a("MAXIMUM", 3, 3);
      e = locala4;
      a locala5 = new a("NOT_SUPPORT", 4, 4);
      f = locala5;
      g = new a[] { locala1, locala2, locala3, locala4, locala5 };
    }
    
    private a(int paramInt)
    {
      this.a = paramInt;
    }
    
    int a()
    {
      return this.a;
    }
  }
  
  public static enum b
  {
    static
    {
      b localb1 = new b("PRIV", 0);
      a = localb1;
      b localb2 = new b("YUV", 1);
      b = localb2;
      b localb3 = new b("JPEG", 2);
      c = localb3;
      b localb4 = new b("RAW", 3);
      d = localb4;
      e = new b[] { localb1, localb2, localb3, localb4 };
    }
    
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.l2
 * JD-Core Version:    0.7.0.1
 */