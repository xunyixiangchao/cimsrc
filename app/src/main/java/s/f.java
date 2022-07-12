package s;

import android.util.Size;
import android.view.Surface;
import java.util.Objects;

final class f
  extends z1
{
  private final Surface a;
  private final Size b;
  private final int c;
  
  f(Surface paramSurface, Size paramSize, int paramInt)
  {
    Objects.requireNonNull(paramSurface, "Null surface");
    this.a = paramSurface;
    Objects.requireNonNull(paramSize, "Null size");
    this.b = paramSize;
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public Size c()
  {
    return this.b;
  }
  
  public Surface d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof z1))
    {
      paramObject = (z1)paramObject;
      return (this.a.equals(paramObject.d())) && (this.b.equals(paramObject.c())) && (this.c == paramObject.b());
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OutputSurface{surface=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", imageFormat=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.f
 * JD-Core Version:    0.7.0.1
 */