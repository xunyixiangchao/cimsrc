package androidx.camera.lifecycle;

import androidx.lifecycle.l;
import java.util.Objects;
import v.e.b;

final class a
  extends LifecycleCameraRepository.a
{
  private final l a;
  private final e.b b;
  
  a(l paraml, e.b paramb)
  {
    Objects.requireNonNull(paraml, "Null lifecycleOwner");
    this.a = paraml;
    Objects.requireNonNull(paramb, "Null cameraId");
    this.b = paramb;
  }
  
  public e.b b()
  {
    return this.b;
  }
  
  public l c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof LifecycleCameraRepository.a))
    {
      paramObject = (LifecycleCameraRepository.a)paramObject;
      return (this.a.equals(paramObject.c())) && (this.b.equals(paramObject.b()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key{lifecycleOwner=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cameraId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.lifecycle.a
 * JD-Core Version:    0.7.0.1
 */