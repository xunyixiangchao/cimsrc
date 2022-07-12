package com.baidu.mapapi.model.inner;

import com.baidu.platform.comapi.basestruct.Point;
import java.io.Serializable;

public class MapBound
  implements Serializable
{
  public Point ptLB;
  public Point ptRT;
  
  public MapBound()
  {
    if (this.ptLB == null) {
      this.ptLB = new Point();
    }
    if (this.ptRT == null) {
      this.ptRT = new Point();
    }
  }
  
  public Point getPtLB()
  {
    return this.ptLB;
  }
  
  public Point getPtRT()
  {
    return this.ptRT;
  }
  
  public void setPtLB(Point paramPoint)
  {
    this.ptLB = paramPoint;
  }
  
  public void setPtRT(Point paramPoint)
  {
    this.ptRT = paramPoint;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.model.inner.MapBound
 * JD-Core Version:    0.7.0.1
 */