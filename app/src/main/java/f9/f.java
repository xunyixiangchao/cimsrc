package f9;

import c9.c;

public final class f
{
  private final String a;
  private final c b;
  
  public f(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof f)) {
      return false;
    }
    paramObject = (f)paramObject;
    if (!a9.f.a(this.a, paramObject.a)) {
      return false;
    }
    return a9.f.a(this.b, paramObject.b);
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MatchGroup(value=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", range=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.f
 * JD-Core Version:    0.7.0.1
 */