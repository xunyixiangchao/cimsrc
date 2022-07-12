package w2;

import b2.f;
import java.security.MessageDigest;
import x2.k;

public final class b
  implements f
{
  private final Object b;
  
  public b(Object paramObject)
  {
    this.b = k.d(paramObject);
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.b.toString().getBytes(f.a));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObjectKey{object=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w2.b
 * JD-Core Version:    0.7.0.1
 */