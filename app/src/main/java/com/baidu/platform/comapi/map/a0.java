package com.baidu.platform.comapi.map;

public class a0
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  static int c(int paramInt)
  {
    return (paramInt & 0xFF0000) >> 16 | 0xFF000000 & paramInt | (paramInt & 0xFF) << 16 | 0xFF00 & paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public a0 a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public a0 b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Style: color:");
    localStringBuilder.append(Integer.toHexString(this.a));
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" fillcolor:");
    localStringBuilder.append(Integer.toHexString(this.c));
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.a0
 * JD-Core Version:    0.7.0.1
 */