package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

public class MapBound
  implements Serializable
{
  public Point leftBottomPt = new Point();
  public Point rightTopPt = new Point();
  
  public MapBound() {}
  
  public MapBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setLeftBottomPt(paramInt1, paramInt2);
    setRightTopPt(paramInt3, paramInt4);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MapBound)) {
      return false;
    }
    paramObject = (MapBound)paramObject;
    Point localPoint = this.leftBottomPt;
    if (localPoint != null)
    {
      if (!localPoint.equals(paramObject.leftBottomPt)) {
        return false;
      }
    }
    else if (paramObject.leftBottomPt != null) {
      return false;
    }
    localPoint = this.rightTopPt;
    paramObject = paramObject.rightTopPt;
    if (localPoint != null)
    {
      if (localPoint.equals(paramObject)) {
        return bool;
      }
    }
    else if (paramObject == null) {
      return true;
    }
    bool = false;
    return bool;
  }
  
  public Point getCenterPt()
  {
    return new Point((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2, (this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2);
  }
  
  public int hashCode()
  {
    Point localPoint = this.leftBottomPt;
    int j = 0;
    int i;
    if (localPoint != null) {
      i = localPoint.hashCode();
    } else {
      i = 0;
    }
    localPoint = this.rightTopPt;
    if (localPoint != null) {
      j = localPoint.hashCode();
    }
    return i * 31 + j;
  }
  
  public void setLeftBottomPt(int paramInt1, int paramInt2)
  {
    this.leftBottomPt.setTo(paramInt1, paramInt2);
  }
  
  public void setLeftBottomPt(Point paramPoint)
  {
    this.leftBottomPt.setTo(paramPoint);
  }
  
  public void setRightTopPt(int paramInt1, int paramInt2)
  {
    this.rightTopPt.setTo(paramInt1, paramInt2);
  }
  
  public void setRightTopPt(Point paramPoint)
  {
    this.rightTopPt.setTo(paramPoint);
  }
  
  public String toQuery()
  {
    return String.format("(%d,%d;%d,%d)", new Object[] { Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY()) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MapBound{leftBottomPt=");
    localStringBuilder.append(this.leftBottomPt);
    localStringBuilder.append(", rightTopPt=");
    localStringBuilder.append(this.rightTopPt);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.basestruct.MapBound
 * JD-Core Version:    0.7.0.1
 */