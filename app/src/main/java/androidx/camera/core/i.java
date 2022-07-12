package androidx.camera.core;

import android.view.Surface;
import java.util.Objects;

final class i
  extends u2.f
{
  private final int a;
  private final Surface b;
  
  i(int paramInt, Surface paramSurface)
  {
    this.a = paramInt;
    Objects.requireNonNull(paramSurface, "Null surface");
    this.b = paramSurface;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public Surface b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof u2.f))
    {
      paramObject = (u2.f)paramObject;
      return (this.a == paramObject.a()) && (this.b.equals(paramObject.b()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result{resultCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", surface=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.i
 * JD-Core Version:    0.7.0.1
 */