package androidx.camera.core;

import android.graphics.Rect;
import java.util.Objects;

final class j
  extends u2.g
{
  private final Rect a;
  private final int b;
  private final int c;
  
  j(Rect paramRect, int paramInt1, int paramInt2)
  {
    Objects.requireNonNull(paramRect, "Null cropRect");
    this.a = paramRect;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public Rect a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof u2.g))
    {
      paramObject = (u2.g)paramObject;
      return (this.a.equals(paramObject.a())) && (this.b == paramObject.b()) && (this.c == paramObject.c());
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b) * 1000003 ^ this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransformationInfo{cropRect=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", rotationDegrees=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", targetRotation=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.j
 * JD-Core Version:    0.7.0.1
 */