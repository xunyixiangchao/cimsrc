package s;

public enum r
{
  static
  {
    r localr1 = new r("UNKNOWN", 0);
    a = localr1;
    r localr2 = new r("NONE", 1);
    b = localr2;
    r localr3 = new r("READY", 2);
    c = localr3;
    r localr4 = new r("FIRED", 3);
    d = localr4;
    e = new r[] { localr1, localr2, localr3, localr4 };
  }
  
  private r() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.r
 * JD-Core Version:    0.7.0.1
 */