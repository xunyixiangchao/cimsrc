package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class Point
  implements Serializable
{
  public double doubleX;
  public double doubleY;
  public int x;
  public int y;
  
  public Point() {}
  
  public Point(double paramDouble1, double paramDouble2)
  {
    this.x = ((int)paramDouble1);
    this.y = ((int)paramDouble2);
    this.doubleX = paramDouble1;
    this.doubleY = paramDouble2;
  }
  
  public Point(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.doubleX = paramInt1;
    this.doubleY = paramInt2;
  }
  
  public Point(Point paramPoint)
  {
    if (paramPoint != null)
    {
      this.doubleX = paramPoint.getDoubleX();
      this.doubleY = paramPoint.getDoubleY();
      this.x = paramPoint.getIntX();
      this.y = paramPoint.getIntY();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (Point)paramObject;
    if (getDoubleX() == paramObject.getDoubleX())
    {
      if (getIntX() != paramObject.getIntX()) {
        return false;
      }
      if (getDoubleY() == paramObject.getDoubleY())
      {
        if (getIntY() != paramObject.getIntY()) {
          return false;
        }
        return getDoubleY() == paramObject.getDoubleY();
      }
    }
    return false;
  }
  
  public double getDoubleX()
  {
    return this.doubleX;
  }
  
  public double getDoubleY()
  {
    return this.doubleY;
  }
  
  public int getIntX()
  {
    return this.x;
  }
  
  public int getIntY()
  {
    return this.y;
  }
  
  public int getmPtx()
  {
    return this.x;
  }
  
  public int getmPty()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return (getIntX() + 31) * 31 + getIntY();
  }
  
  public void setDoubleX(double paramDouble)
  {
    this.doubleX = paramDouble;
  }
  
  public void setDoubleY(double paramDouble)
  {
    this.doubleY = paramDouble;
  }
  
  public void setIntX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setIntY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setTo(double paramDouble1, double paramDouble2)
  {
    setDoubleX(paramDouble1);
    setDoubleY(paramDouble2);
  }
  
  public void setTo(Point paramPoint)
  {
    if (paramPoint != null)
    {
      setDoubleX(paramPoint.getDoubleX());
      setDoubleY(paramPoint.getDoubleY());
    }
  }
  
  public void setmPtx(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setmPty(int paramInt)
  {
    this.y = paramInt;
  }
  
  public String toQuery()
  {
    return String.format("(%d,%d)", new Object[] { Integer.valueOf(getIntX()), Integer.valueOf(getIntY()) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Point [x=");
    localStringBuilder.append(getDoubleX());
    localStringBuilder.append(", y=");
    localStringBuilder.append(getDoubleY());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.basestruct.Point
 * JD-Core Version:    0.7.0.1
 */