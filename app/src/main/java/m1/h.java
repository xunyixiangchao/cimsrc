package m1;

public enum h
{
  static
  {
    h localh1 = new h("ASC", 0);
    a = localh1;
    h localh2 = new h("DESC", 1);
    b = localh2;
    c = new h[] { localh1, localh2 };
  }
  
  private h() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.h
 * JD-Core Version:    0.7.0.1
 */