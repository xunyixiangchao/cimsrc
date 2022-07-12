package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Objects;
import s.g2;
import s.t2;

final class b
  extends g0.h
{
  private final String a;
  private final Class<?> b;
  private final g2 c;
  private final t2<?> d;
  private final Size e;
  
  b(String paramString, Class<?> paramClass, g2 paramg2, t2<?> paramt2, Size paramSize)
  {
    Objects.requireNonNull(paramString, "Null useCaseId");
    this.a = paramString;
    Objects.requireNonNull(paramClass, "Null useCaseType");
    this.b = paramClass;
    Objects.requireNonNull(paramg2, "Null sessionConfig");
    this.c = paramg2;
    Objects.requireNonNull(paramt2, "Null useCaseConfig");
    this.d = paramt2;
    this.e = paramSize;
  }
  
  g2 c()
  {
    return this.c;
  }
  
  Size d()
  {
    return this.e;
  }
  
  t2<?> e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g0.h))
    {
      Object localObject = (g0.h)paramObject;
      if ((this.a.equals(((g0.h)localObject).f())) && (this.b.equals(((g0.h)localObject).g())) && (this.c.equals(((g0.h)localObject).c())) && (this.d.equals(((g0.h)localObject).e())))
      {
        paramObject = this.e;
        localObject = ((g0.h)localObject).d();
        if (paramObject == null)
        {
          if (localObject == null) {
            return true;
          }
        }
        else if (paramObject.equals(localObject)) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  String f()
  {
    return this.a;
  }
  
  Class<?> g()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    int m = this.c.hashCode();
    int n = this.d.hashCode();
    Size localSize = this.e;
    int i;
    if (localSize == null) {
      i = 0;
    } else {
      i = localSize.hashCode();
    }
    return ((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UseCaseInfo{useCaseId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", useCaseType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sessionConfig=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", useCaseConfig=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", surfaceResolution=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.b
 * JD-Core Version:    0.7.0.1
 */