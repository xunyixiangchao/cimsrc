package com.baidu.mapapi;

public enum CoordType
{
  static
  {
    CoordType localCoordType1 = new CoordType("GCJ02", 0);
    GCJ02 = localCoordType1;
    CoordType localCoordType2 = new CoordType("BD09LL", 1);
    BD09LL = localCoordType2;
    $VALUES = new CoordType[] { localCoordType1, localCoordType2 };
  }
  
  private CoordType() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.CoordType
 * JD-Core Version:    0.7.0.1
 */