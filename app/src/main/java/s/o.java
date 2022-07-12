package s;

public enum o
{
  static
  {
    o localo1 = new o("UNKNOWN", 0);
    a = localo1;
    o localo2 = new o("OFF", 1);
    b = localo2;
    o localo3 = new o("ON_MANUAL_AUTO", 2);
    c = localo3;
    o localo4 = new o("ON_CONTINUOUS_AUTO", 3);
    d = localo4;
    e = new o[] { localo1, localo2, localo3, localo4 };
  }
  
  private o() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.o
 * JD-Core Version:    0.7.0.1
 */