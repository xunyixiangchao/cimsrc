package s;

public class m
{
  private final a a;
  
  public m(a parama)
  {
    this.a = parama;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public static enum a
  {
    static
    {
      a locala = new a("ERROR", 0);
      a = locala;
      b = new a[] { locala };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.m
 * JD-Core Version:    0.7.0.1
 */