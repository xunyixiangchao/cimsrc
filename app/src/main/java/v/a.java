package v;

final class a
  extends f
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  
  a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public float a()
  {
    return this.b;
  }
  
  public float b()
  {
    return this.a;
  }
  
  public float c()
  {
    return this.d;
  }
  
  public float d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      return (Float.floatToIntBits(this.a) == Float.floatToIntBits(paramObject.b())) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(paramObject.a())) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(paramObject.d())) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(paramObject.c()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((Float.floatToIntBits(this.a) ^ 0xF4243) * 1000003 ^ Float.floatToIntBits(this.b)) * 1000003 ^ Float.floatToIntBits(this.c)) * 1000003 ^ Float.floatToIntBits(this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImmutableZoomState{zoomRatio=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxZoomRatio=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", minZoomRatio=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", linearZoom=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v.a
 * JD-Core Version:    0.7.0.1
 */