package s;

public enum n
{
  static
  {
    n localn1 = new n("UNKNOWN", 0);
    a = localn1;
    n localn2 = new n("INACTIVE", 1);
    b = localn2;
    n localn3 = new n("SEARCHING", 2);
    c = localn3;
    n localn4 = new n("FLASH_REQUIRED", 3);
    d = localn4;
    n localn5 = new n("CONVERGED", 4);
    e = localn5;
    n localn6 = new n("LOCKED", 5);
    f = localn6;
    g = new n[] { localn1, localn2, localn3, localn4, localn5, localn6 };
  }
  
  private n() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.n
 * JD-Core Version:    0.7.0.1
 */