package androidx.camera.core.impl.utils;

final class j
{
  private final long a;
  private final long b;
  
  j(double paramDouble)
  {
    this((paramDouble * 10000.0D), 10000L);
  }
  
  j(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  long a()
  {
    return this.b;
  }
  
  long b()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("/");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.j
 * JD-Core Version:    0.7.0.1
 */