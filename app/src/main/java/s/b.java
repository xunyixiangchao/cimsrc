package s;

import android.util.Range;
import android.util.Size;
import java.util.Objects;

final class b
  extends a
{
  private final l2 a;
  private final int b;
  private final Size c;
  private final Range<Integer> d;
  
  b(l2 paraml2, int paramInt, Size paramSize, Range<Integer> paramRange)
  {
    Objects.requireNonNull(paraml2, "Null surfaceConfig");
    this.a = paraml2;
    this.b = paramInt;
    Objects.requireNonNull(paramSize, "Null size");
    this.c = paramSize;
    this.d = paramRange;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public Size c()
  {
    return this.c;
  }
  
  public l2 d()
  {
    return this.a;
  }
  
  public Range<Integer> e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      Object localObject = (a)paramObject;
      if ((this.a.equals(((a)localObject).d())) && (this.b == ((a)localObject).b()) && (this.c.equals(((a)localObject).c())))
      {
        paramObject = this.d;
        localObject = ((a)localObject).e();
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
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b;
    int m = this.c.hashCode();
    Range localRange = this.d;
    int i;
    if (localRange == null) {
      i = 0;
    } else {
      i = localRange.hashCode();
    }
    return (((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AttachedSurfaceInfo{surfaceConfig=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", imageFormat=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", targetFrameRate=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.b
 * JD-Core Version:    0.7.0.1
 */