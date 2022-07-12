package a0;

import java.util.Objects;

final class f
  extends o
{
  private final int e;
  private final int f;
  private final int g;
  private final String h;
  
  f(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    Objects.requireNonNull(paramString, "Null description");
    this.h = paramString;
  }
  
  String d()
  {
    return this.h;
  }
  
  public int e()
  {
    return this.e;
  }
  
  int f()
  {
    return this.f;
  }
  
  int g()
  {
    return this.g;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.f
 * JD-Core Version:    0.7.0.1
 */