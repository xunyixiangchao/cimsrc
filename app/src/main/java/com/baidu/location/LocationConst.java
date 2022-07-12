package com.baidu.location;

public class LocationConst
{
  public static class SceneType
  {
    public static final int SCENE_TYPE_RECOGNITION_SUBWAY = 1;
    public static final int SCENE_TYPE_RECOGNITION_TRAFFIC_TYPE = 2;
  }
  
  public class SubWayErrorCode
  {
    public static final int SUBWAY_ERROR_LOC_ENGINE_INTERNAL = -5;
    public static final int SUBWAY_ERROR_LOC_ENGINE_MISS_DATA = -4;
    public static final int SUBWAY_ERROR_LOC_KNOWN = -6;
    public static final int SUBWAY_ERROR_NONSUPPORT_PRESSURE = -2;
    public static final int SUBWAY_ERROR_SWITCH_CLOSE = -1;
    public static final int SUBWAY_LOC_SDK_ERROR = -3;
    
    public SubWayErrorCode() {}
  }
  
  public class TrafficStatus
  {
    public static final int TRAFFIC_ERROR_LOC_ENGINE_INTERNAL = -6;
    public static final int TRAFFIC_ERROR_LOC_ENGINE_MISS_DATA = -5;
    public static final int TRAFFIC_ERROR_LOC_KNOWN = -7;
    public static final int TRAFFIC_ERROR_LOC_SDK = -4;
    public static final int TRAFFIC_ERROR_MODEL_LOAD_FAILED = -8;
    public static final int TRAFFIC_ERROR_NONSUPPORT_BLUETOOTH = -2;
    public static final int TRAFFIC_ERROR_NON_OPEN_BLUETOOTH = -3;
    public static final int TRAFFIC_ERROR_PREDICT_GPS_NO_DATA = 112;
    public static final int TRAFFIC_ERROR_PREDICT_MODEL_CUL_FAILED = 113;
    public static final int TRAFFIC_ERROR_SWITCH_CLOSE = -1;
    public static final int TRAFFIC_SCAN_BLUETOOTH_FINISH = 101;
    public static final int TRAFFIC_SCAN_BLUETOOTH_NO_DATA = 102;
    public static final int TRAFFIC_STATUS_BUS = 2;
    public static final int TRAFFIC_STATUS_DRIVE = 0;
    public static final int TRAFFIC_STATUS_SUBWAY = 3;
    public static final int TRAFFIC_STATUS_WALK = 1;
    
    public TrafficStatus() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.LocationConst
 * JD-Core Version:    0.7.0.1
 */