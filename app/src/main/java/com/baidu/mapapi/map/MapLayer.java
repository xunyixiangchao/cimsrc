package com.baidu.mapapi.map;

public enum MapLayer
{
  static
  {
    MapLayer localMapLayer1 = new MapLayer("MAP_LAYER_OVERLAY", 0);
    MAP_LAYER_OVERLAY = localMapLayer1;
    MapLayer localMapLayer2 = new MapLayer("MAP_LAYER_LOCATION", 1);
    MAP_LAYER_LOCATION = localMapLayer2;
    MapLayer localMapLayer3 = new MapLayer("MAP_LAYER_POI_MARKER", 2);
    MAP_LAYER_POI_MARKER = localMapLayer3;
    MapLayer localMapLayer4 = new MapLayer("MAP_LAYER_INDOOR_POI", 3);
    MAP_LAYER_INDOOR_POI = localMapLayer4;
    a = new MapLayer[] { localMapLayer1, localMapLayer2, localMapLayer3, localMapLayer4 };
  }
  
  private MapLayer() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapLayer
 * JD-Core Version:    0.7.0.1
 */