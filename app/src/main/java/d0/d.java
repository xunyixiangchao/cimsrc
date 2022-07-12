package d0;

import android.view.Surface;
import java.util.List;
import java.util.Objects;

final class d
  extends m
{
  private final int a;
  private final int b;
  private final String c;
  private final List<e> d;
  private final Surface e;
  
  d(int paramInt1, int paramInt2, String paramString, List<e> paramList, Surface paramSurface)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
    Objects.requireNonNull(paramList, "Null surfaceSharingOutputConfigs");
    this.d = paramList;
    Objects.requireNonNull(paramSurface, "Null surface");
    this.e = paramSurface;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public List<e> b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.b;
  }
  
  Surface e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      if ((this.a == paramObject.getId()) && (this.b == paramObject.c()))
      {
        String str = this.c;
        if ((str == null ? paramObject.a() == null : str.equals(paramObject.a())) && (this.d.equals(paramObject.b())) && (this.e.equals(paramObject.e()))) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public int getId()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    int j = this.a;
    int k = this.b;
    String str = this.c;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return ((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SurfaceOutputConfig{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", surfaceGroupId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", physicalCameraId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", surfaceSharingOutputConfigs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", surface=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.d
 * JD-Core Version:    0.7.0.1
 */