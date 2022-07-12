package androidx.appcompat.widget;

class c0
{
  private int a = 0;
  private int b = 0;
  private int c = -2147483648;
  private int d = -2147483648;
  private int e = 0;
  private int f = 0;
  private boolean g = false;
  private boolean h = false;
  
  public int a()
  {
    if (this.g) {
      return this.a;
    }
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    if (this.g) {
      return this.b;
    }
    return this.a;
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    this.h = false;
    if (paramInt1 != -2147483648)
    {
      this.e = paramInt1;
      this.a = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.f = paramInt2;
      this.b = paramInt2;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.g) {
      return;
    }
    this.g = paramBoolean;
    if (this.h)
    {
      if (paramBoolean)
      {
        i = this.d;
        if (i == -2147483648) {
          i = this.e;
        }
        this.a = i;
        i = this.c;
        if (i != -2147483648) {
          break label114;
        }
      }
      else
      {
        i = this.c;
        if (i == -2147483648) {
          i = this.e;
        }
        this.a = i;
        i = this.d;
        if (i != -2147483648) {
          break label114;
        }
      }
    }
    else {
      this.a = this.e;
    }
    int i = this.f;
    label114:
    this.b = i;
  }
  
  public void g(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = true;
    if (this.g)
    {
      if (paramInt2 != -2147483648) {
        this.a = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.b = paramInt1;
      }
    }
    else
    {
      if (paramInt1 != -2147483648) {
        this.a = paramInt1;
      }
      if (paramInt2 != -2147483648) {
        this.b = paramInt2;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.c0
 * JD-Core Version:    0.7.0.1
 */