package d2;

import b2.f;
import java.security.MessageDigest;

final class d
  implements f
{
  private final f b;
  private final f c;
  
  d(f paramf1, f paramf2)
  {
    this.b = paramf1;
    this.c = paramf2;
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
    this.c.b(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof d;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.c.equals(paramObject.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.b.hashCode() * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataCacheKey{sourceKey=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.d
 * JD-Core Version:    0.7.0.1
 */