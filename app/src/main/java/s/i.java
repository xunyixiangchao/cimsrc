package s;

import android.util.Size;
import java.util.Objects;

final class i
  extends m2
{
  private final Size a;
  private final Size b;
  private final Size c;
  
  i(Size paramSize1, Size paramSize2, Size paramSize3)
  {
    Objects.requireNonNull(paramSize1, "Null analysisSize");
    this.a = paramSize1;
    Objects.requireNonNull(paramSize2, "Null previewSize");
    this.b = paramSize2;
    Objects.requireNonNull(paramSize3, "Null recordSize");
    this.c = paramSize3;
  }
  
  public Size b()
  {
    return this.a;
  }
  
  public Size c()
  {
    return this.b;
  }
  
  public Size d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m2))
    {
      paramObject = (m2)paramObject;
      return (this.a.equals(paramObject.b())) && (this.b.equals(paramObject.c())) && (this.c.equals(paramObject.d()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SurfaceSizeDefinition{analysisSize=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", previewSize=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", recordSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.i
 * JD-Core Version:    0.7.0.1
 */