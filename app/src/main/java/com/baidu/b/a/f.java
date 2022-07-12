package com.baidu.b.a;

class f
{
  public static int a = 5;
  public static int b = 40;
  private b c;
  
  public f()
  {
    b localb = new b(b);
    this.c = localb;
    localb.a(0, b, true);
  }
  
  public void a(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = this.c.c(paramInt1, paramInt1 + paramInt2);
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1) {
        if (paramInt3 != 2)
        {
          if (paramInt3 == 3)
          {
            localb.b(paramb);
            break label72;
          }
        }
        else
        {
          localb.d(paramb);
          break label72;
        }
      }
      localb.c(paramb);
    }
    else
    {
      localb.a(paramb);
    }
    label72:
    paramInt3 = 0;
    while (paramInt3 < paramInt2)
    {
      this.c.a(paramInt1 + paramInt3, localb.c(paramInt3));
      paramInt3 += 1;
    }
  }
  
  public byte[] a()
  {
    return this.c.a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.f
 * JD-Core Version:    0.7.0.1
 */