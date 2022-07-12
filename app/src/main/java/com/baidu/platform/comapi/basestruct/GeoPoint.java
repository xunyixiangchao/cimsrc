package com.baidu.platform.comapi.basestruct;

public class GeoPoint
{
  private double a;
  private double b;
  
  public GeoPoint(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramObject.getClass() == getClass())
    {
      double d = this.a;
      paramObject = (GeoPoint)paramObject;
      bool1 = bool2;
      if (Math.abs(d - paramObject.a) <= 1.0E-006D)
      {
        bool1 = bool2;
        if (Math.abs(this.b - paramObject.b) <= 1.0E-006D) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public double getLatitude()
  {
    return this.a;
  }
  
  public double getLatitudeE6()
  {
    return this.a;
  }
  
  public double getLongitude()
  {
    return this.b;
  }
  
  public double getLongitudeE6()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public void setLatitude(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void setLatitude(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setLatitudeE6(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void setLongitude(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setLongitudeE6(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeoPoint: Latitude: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", Longitude: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.basestruct.GeoPoint
 * JD-Core Version:    0.7.0.1
 */