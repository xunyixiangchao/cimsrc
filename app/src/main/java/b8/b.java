package b8;

public enum b
{
  static
  {
    b localb1 = new b("BEGIN_ARRAY", 0);
    a = localb1;
    b localb2 = new b("END_ARRAY", 1);
    b = localb2;
    b localb3 = new b("BEGIN_OBJECT", 2);
    c = localb3;
    b localb4 = new b("END_OBJECT", 3);
    d = localb4;
    b localb5 = new b("NAME", 4);
    e = localb5;
    b localb6 = new b("STRING", 5);
    f = localb6;
    b localb7 = new b("NUMBER", 6);
    g = localb7;
    b localb8 = new b("BOOLEAN", 7);
    h = localb8;
    b localb9 = new b("NULL", 8);
    i = localb9;
    b localb10 = new b("END_DOCUMENT", 9);
    j = localb10;
    k = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10 };
  }
  
  private b() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b8.b
 * JD-Core Version:    0.7.0.1
 */