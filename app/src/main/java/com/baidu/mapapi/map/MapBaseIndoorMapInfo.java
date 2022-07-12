package com.baidu.mapapi.map;

import java.util.ArrayList;

public final class MapBaseIndoorMapInfo
{
  String a;
  String b;
  ArrayList<String> c;
  
  public MapBaseIndoorMapInfo() {}
  
  public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo paramMapBaseIndoorMapInfo)
  {
    this.a = paramMapBaseIndoorMapInfo.a;
    this.b = paramMapBaseIndoorMapInfo.b;
    this.c = paramMapBaseIndoorMapInfo.c;
  }
  
  public MapBaseIndoorMapInfo(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
  }
  
  public String getCurFloor()
  {
    return this.b;
  }
  
  public ArrayList<String> getFloors()
  {
    return this.c;
  }
  
  public String getID()
  {
    return this.a;
  }
  
  public static enum SwitchFloorError
  {
    static
    {
      SwitchFloorError localSwitchFloorError1 = new SwitchFloorError("SWITCH_OK", 0);
      SWITCH_OK = localSwitchFloorError1;
      SwitchFloorError localSwitchFloorError2 = new SwitchFloorError("FLOOR_INFO_ERROR", 1);
      FLOOR_INFO_ERROR = localSwitchFloorError2;
      SwitchFloorError localSwitchFloorError3 = new SwitchFloorError("FLOOR_OVERLFLOW", 2);
      FLOOR_OVERLFLOW = localSwitchFloorError3;
      SwitchFloorError localSwitchFloorError4 = new SwitchFloorError("FOCUSED_ID_ERROR", 3);
      FOCUSED_ID_ERROR = localSwitchFloorError4;
      SwitchFloorError localSwitchFloorError5 = new SwitchFloorError("SWITCH_ERROR", 4);
      SWITCH_ERROR = localSwitchFloorError5;
      a = new SwitchFloorError[] { localSwitchFloorError1, localSwitchFloorError2, localSwitchFloorError3, localSwitchFloorError4, localSwitchFloorError5 };
    }
    
    private SwitchFloorError() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapBaseIndoorMapInfo
 * JD-Core Version:    0.7.0.1
 */