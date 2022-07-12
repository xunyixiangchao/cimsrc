package d0;

import android.util.Size;
import java.util.List;
import java.util.Objects;

final class b
  extends i
{
  private final int a;
  private final int b;
  private final String c;
  private final List<e> d;
  private final Size e;
  private final int f;
  private final int g;
  
  b(int paramInt1, int paramInt2, String paramString, List<e> paramList, Size paramSize, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
    Objects.requireNonNull(paramList, "Null surfaceSharingOutputConfigs");
    this.d = paramList;
    Objects.requireNonNull(paramSize, "Null size");
    this.e = paramSize;
    this.f = paramInt3;
    this.g = paramInt4;
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
  
  int e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      if ((this.a == paramObject.getId()) && (this.b == paramObject.c()))
      {
        String str = this.c;
        if ((str == null ? paramObject.a() == null : str.equals(paramObject.a())) && (this.d.equals(paramObject.b())) && (this.e.equals(paramObject.g())) && (this.f == paramObject.e()) && (this.g == paramObject.f())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  int f()
  {
    return this.g;
  }
  
  Size g()
  {
    return this.e;
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
    return ((((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode()) * 1000003 ^ this.f) * 1000003 ^ this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageReaderOutputConfig{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", surfaceGroupId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", physicalCameraId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", surfaceSharingOutputConfigs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", imageFormat=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", maxImages=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.b
 * JD-Core Version:    0.7.0.1
 */