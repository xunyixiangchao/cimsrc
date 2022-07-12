package com.baidu.platform.comapi.basestruct;

import java.util.ArrayList;

public class a
{
  public int a;
  public Point b;
  public Point c;
  public ArrayList<ArrayList<Point>> d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComplexPt [eType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mLL=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mRu=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mGeoPt=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.basestruct.a
 * JD-Core Version:    0.7.0.1
 */