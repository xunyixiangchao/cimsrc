package s;

public enum q
{
  static
  {
    q localq1 = new q("UNKNOWN", 0);
    a = localq1;
    q localq2 = new q("INACTIVE", 1);
    b = localq2;
    q localq3 = new q("METERING", 2);
    c = localq3;
    q localq4 = new q("CONVERGED", 3);
    d = localq4;
    q localq5 = new q("LOCKED", 4);
    e = localq5;
    f = new q[] { localq1, localq2, localq3, localq4, localq5 };
  }
  
  private q() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.q
 * JD-Core Version:    0.7.0.1
 */