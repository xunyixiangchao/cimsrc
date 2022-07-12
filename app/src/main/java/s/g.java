package s;

import java.util.List;
import java.util.Objects;

final class g
  extends g2.e
{
  private final v0 a;
  private final List<v0> b;
  private final String c;
  private final int d;
  
  private g(v0 paramv0, List<v0> paramList, String paramString, int paramInt)
  {
    this.a = paramv0;
    this.b = paramList;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public List<v0> c()
  {
    return this.b;
  }
  
  public v0 d()
  {
    return this.a;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g2.e))
    {
      paramObject = (g2.e)paramObject;
      if ((this.a.equals(paramObject.d())) && (this.b.equals(paramObject.c())))
      {
        String str = this.c;
        if ((str == null ? paramObject.b() == null : str.equals(paramObject.b())) && (this.d == paramObject.e())) {
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
    int k = this.b.hashCode();
    String str = this.c;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return (((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i) * 1000003 ^ this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OutputConfig{surface=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sharedSurfaces=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", physicalCameraId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", surfaceGroupId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends g2.e.a
  {
    private v0 a;
    private List<v0> b;
    private String c;
    private Integer d;
    
    public g2.e a()
    {
      Object localObject2 = this.a;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" surface");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.b == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" sharedSurfaces");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.d == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" surfaceGroupId");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new g(this.a, this.b, this.c, this.d.intValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public g2.e.a b(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public g2.e.a c(List<v0> paramList)
    {
      Objects.requireNonNull(paramList, "Null sharedSurfaces");
      this.b = paramList;
      return this;
    }
    
    public g2.e.a d(int paramInt)
    {
      this.d = Integer.valueOf(paramInt);
      return this;
    }
    
    public g2.e.a e(v0 paramv0)
    {
      Objects.requireNonNull(paramv0, "Null surface");
      this.a = paramv0;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.g
 * JD-Core Version:    0.7.0.1
 */