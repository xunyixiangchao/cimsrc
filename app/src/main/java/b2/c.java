package b2;

public enum c
{
  static
  {
    c localc1 = new c("SOURCE", 0);
    a = localc1;
    c localc2 = new c("TRANSFORMED", 1);
    b = localc2;
    c localc3 = new c("NONE", 2);
    c = localc3;
    d = new c[] { localc1, localc2, localc3 };
  }
  
  private c() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.c
 * JD-Core Version:    0.7.0.1
 */