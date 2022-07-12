package d2;

import b2.f;
import e2.b;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class x
  implements f
{
  private static final x2.h<Class<?>, byte[]> j = new x2.h(50L);
  private final b b;
  private final f c;
  private final f d;
  private final int e;
  private final int f;
  private final Class<?> g;
  private final b2.h h;
  private final b2.l<?> i;
  
  x(b paramb, f paramf1, f paramf2, int paramInt1, int paramInt2, b2.l<?> paraml, Class<?> paramClass, b2.h paramh)
  {
    this.b = paramb;
    this.c = paramf1;
    this.d = paramf2;
    this.e = paramInt1;
    this.f = paramInt2;
    this.i = paraml;
    this.g = paramClass;
    this.h = paramh;
  }
  
  private byte[] c()
  {
    x2.h localh = j;
    byte[] arrayOfByte2 = (byte[])localh.g(this.g);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.g.getName().getBytes(f.a);
      localh.k(this.g, arrayOfByte1);
    }
    return arrayOfByte1;
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    byte[] arrayOfByte = (byte[])this.b.c(8, [B.class);
    ByteBuffer.wrap(arrayOfByte).putInt(this.e).putInt(this.f).array();
    this.d.b(paramMessageDigest);
    this.c.b(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte);
    b2.l locall = this.i;
    if (locall != null) {
      locall.b(paramMessageDigest);
    }
    this.h.b(paramMessageDigest);
    paramMessageDigest.update(c());
    this.b.d(arrayOfByte);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof x;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (x)paramObject;
      bool1 = bool2;
      if (this.f == paramObject.f)
      {
        bool1 = bool2;
        if (this.e == paramObject.e)
        {
          bool1 = bool2;
          if (x2.l.d(this.i, paramObject.i))
          {
            bool1 = bool2;
            if (this.g.equals(paramObject.g))
            {
              bool1 = bool2;
              if (this.c.equals(paramObject.c))
              {
                bool1 = bool2;
                if (this.d.equals(paramObject.d))
                {
                  bool1 = bool2;
                  if (this.h.equals(paramObject.h)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int m = ((this.c.hashCode() * 31 + this.d.hashCode()) * 31 + this.e) * 31 + this.f;
    b2.l locall = this.i;
    int k = m;
    if (locall != null) {
      k = m * 31 + locall.hashCode();
    }
    return (k * 31 + this.g.hashCode()) * 31 + this.h.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResourceCacheKey{sourceKey=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", decodedResourceClass=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", transformation='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.x
 * JD-Core Version:    0.7.0.1
 */