package v7;

public enum u
{
  static
  {
    a locala = new a("DEFAULT", 0);
    a = locala;
    b localb = new b("STRING", 1);
    b = localb;
    c = new u[] { locala, localb };
  }
  
  private u() {}
  
  static enum a
  {
    a()
    {
      super(i, null);
    }
  }
  
  static enum b
  {
    b()
    {
      super(i, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.u
 * JD-Core Version:    0.7.0.1
 */