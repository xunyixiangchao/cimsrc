package s;

public enum p
{
  static
  {
    p localp1 = new p("UNKNOWN", 0);
    a = localp1;
    p localp2 = new p("INACTIVE", 1);
    b = localp2;
    p localp3 = new p("SCANNING", 2);
    c = localp3;
    p localp4 = new p("PASSIVE_FOCUSED", 3);
    d = localp4;
    p localp5 = new p("PASSIVE_NOT_FOCUSED", 4);
    e = localp5;
    p localp6 = new p("LOCKED_FOCUSED", 5);
    f = localp6;
    p localp7 = new p("LOCKED_NOT_FOCUSED", 6);
    g = localp7;
    h = new p[] { localp1, localp2, localp3, localp4, localp5, localp6, localp7 };
  }
  
  private p() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.p
 * JD-Core Version:    0.7.0.1
 */