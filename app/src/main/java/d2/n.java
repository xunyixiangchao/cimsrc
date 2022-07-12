package d2;

import b2.f;
import b2.h;
import b2.l;
import java.security.MessageDigest;
import java.util.Map;
import x2.k;

class n
  implements f
{
  private final Object b;
  private final int c;
  private final int d;
  private final Class<?> e;
  private final Class<?> f;
  private final f g;
  private final Map<Class<?>, l<?>> h;
  private final h i;
  private int j;
  
  n(Object paramObject, f paramf, int paramInt1, int paramInt2, Map<Class<?>, l<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, h paramh)
  {
    this.b = k.d(paramObject);
    this.g = ((f)k.e(paramf, "Signature must not be null"));
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = ((Map)k.d(paramMap));
    this.e = ((Class)k.e(paramClass1, "Resource class must not be null"));
    this.f = ((Class)k.e(paramClass2, "Transcode class must not be null"));
    this.i = ((h)k.d(paramh));
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof n;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (n)paramObject;
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.g.equals(paramObject.g))
        {
          bool1 = bool2;
          if (this.d == paramObject.d)
          {
            bool1 = bool2;
            if (this.c == paramObject.c)
            {
              bool1 = bool2;
              if (this.h.equals(paramObject.h))
              {
                bool1 = bool2;
                if (this.e.equals(paramObject.e))
                {
                  bool1 = bool2;
                  if (this.f.equals(paramObject.f))
                  {
                    bool1 = bool2;
                    if (this.i.equals(paramObject.i)) {
                      bool1 = true;
                    }
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
    if (this.j == 0)
    {
      int k = this.b.hashCode();
      this.j = k;
      k = ((k * 31 + this.g.hashCode()) * 31 + this.c) * 31 + this.d;
      this.j = k;
      k = k * 31 + this.h.hashCode();
      this.j = k;
      k = k * 31 + this.e.hashCode();
      this.j = k;
      k = k * 31 + this.f.hashCode();
      this.j = k;
      this.j = (k * 31 + this.i.hashCode());
    }
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineKey{model=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", resourceClass=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", transcodeClass=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", hashCode=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", transformations=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.n
 * JD-Core Version:    0.7.0.1
 */