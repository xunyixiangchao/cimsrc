package androidx.camera.core;

import android.graphics.Matrix;
import java.util.Objects;
import s.n2;

final class h
  extends l1
{
  private final n2 a;
  private final long b;
  private final int c;
  private final Matrix d;
  
  h(n2 paramn2, long paramLong, int paramInt, Matrix paramMatrix)
  {
    Objects.requireNonNull(paramn2, "Null tagBundle");
    this.a = paramn2;
    this.b = paramLong;
    this.c = paramInt;
    Objects.requireNonNull(paramMatrix, "Null sensorToBufferTransformMatrix");
    this.d = paramMatrix;
  }
  
  public n2 a()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public Matrix d()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof l1))
    {
      paramObject = (l1)paramObject;
      return (this.a.equals(paramObject.a())) && (this.b == paramObject.getTimestamp()) && (this.c == paramObject.c()) && (this.d.equals(paramObject.d()));
    }
    return false;
  }
  
  public long getTimestamp()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    long l = this.b;
    return (((i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ this.c) * 1000003 ^ this.d.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImmutableImageInfo{tagBundle=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", rotationDegrees=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sensorToBufferTransformMatrix=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.h
 * JD-Core Version:    0.7.0.1
 */