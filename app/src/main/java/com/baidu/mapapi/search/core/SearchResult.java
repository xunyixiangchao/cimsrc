package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchResult
  implements Parcelable
{
  public ERRORNO error;
  public int status = 0;
  
  public SearchResult()
  {
    this.error = ERRORNO.NO_ERROR;
  }
  
  protected SearchResult(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramParcel = null;
    } else {
      paramParcel = ERRORNO.values()[i];
    }
    this.error = paramParcel;
  }
  
  public SearchResult(ERRORNO paramERRORNO)
  {
    this.error = paramERRORNO;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ERRORNO localERRORNO = this.error;
    if (localERRORNO == null) {
      paramInt = -1;
    } else {
      paramInt = localERRORNO.ordinal();
    }
    paramParcel.writeInt(paramInt);
  }
  
  public static enum ERRORNO
  {
    static
    {
      ERRORNO localERRORNO1 = new ERRORNO("NO_ERROR", 0);
      NO_ERROR = localERRORNO1;
      ERRORNO localERRORNO2 = new ERRORNO("RESULT_NOT_FOUND", 1);
      RESULT_NOT_FOUND = localERRORNO2;
      ERRORNO localERRORNO3 = new ERRORNO("AMBIGUOUS_KEYWORD", 2);
      AMBIGUOUS_KEYWORD = localERRORNO3;
      ERRORNO localERRORNO4 = new ERRORNO("AMBIGUOUS_ROURE_ADDR", 3);
      AMBIGUOUS_ROURE_ADDR = localERRORNO4;
      ERRORNO localERRORNO5 = new ERRORNO("NOT_SUPPORT_BUS", 4);
      NOT_SUPPORT_BUS = localERRORNO5;
      ERRORNO localERRORNO6 = new ERRORNO("NOT_SUPPORT_BUS_2CITY", 5);
      NOT_SUPPORT_BUS_2CITY = localERRORNO6;
      ERRORNO localERRORNO7 = new ERRORNO("ST_EN_TOO_NEAR", 6);
      ST_EN_TOO_NEAR = localERRORNO7;
      ERRORNO localERRORNO8 = new ERRORNO("KEY_ERROR", 7);
      KEY_ERROR = localERRORNO8;
      ERRORNO localERRORNO9 = new ERRORNO("PERMISSION_UNFINISHED", 8);
      PERMISSION_UNFINISHED = localERRORNO9;
      ERRORNO localERRORNO10 = new ERRORNO("NETWORK_TIME_OUT", 9);
      NETWORK_TIME_OUT = localERRORNO10;
      ERRORNO localERRORNO11 = new ERRORNO("NETWORK_ERROR", 10);
      NETWORK_ERROR = localERRORNO11;
      ERRORNO localERRORNO12 = new ERRORNO("POIINDOOR_BID_ERROR", 11);
      POIINDOOR_BID_ERROR = localERRORNO12;
      ERRORNO localERRORNO13 = new ERRORNO("POIINDOOR_FLOOR_ERROR", 12);
      POIINDOOR_FLOOR_ERROR = localERRORNO13;
      ERRORNO localERRORNO14 = new ERRORNO("POIINDOOR_SERVER_ERROR", 13);
      POIINDOOR_SERVER_ERROR = localERRORNO14;
      ERRORNO localERRORNO15 = new ERRORNO("INDOOR_ROUTE_NO_IN_BUILDING", 14);
      INDOOR_ROUTE_NO_IN_BUILDING = localERRORNO15;
      ERRORNO localERRORNO16 = new ERRORNO("INDOOR_ROUTE_NO_IN_SAME_BUILDING", 15);
      INDOOR_ROUTE_NO_IN_SAME_BUILDING = localERRORNO16;
      ERRORNO localERRORNO17 = new ERRORNO("MASS_TRANSIT_SERVER_ERROR", 16);
      MASS_TRANSIT_SERVER_ERROR = localERRORNO17;
      ERRORNO localERRORNO18 = new ERRORNO("MASS_TRANSIT_OPTION_ERROR", 17);
      MASS_TRANSIT_OPTION_ERROR = localERRORNO18;
      ERRORNO localERRORNO19 = new ERRORNO("MASS_TRANSIT_NO_POI_ERROR", 18);
      MASS_TRANSIT_NO_POI_ERROR = localERRORNO19;
      ERRORNO localERRORNO20 = new ERRORNO("SEARCH_SERVER_INTERNAL_ERROR", 19);
      SEARCH_SERVER_INTERNAL_ERROR = localERRORNO20;
      ERRORNO localERRORNO21 = new ERRORNO("SEARCH_OPTION_ERROR", 20);
      SEARCH_OPTION_ERROR = localERRORNO21;
      ERRORNO localERRORNO22 = new ERRORNO("REQUEST_ERROR", 21);
      REQUEST_ERROR = localERRORNO22;
      ERRORNO localERRORNO23 = new ERRORNO("NO_ADVANCED_PERMISSION", 22);
      NO_ADVANCED_PERMISSION = localERRORNO23;
      ERRORNO localERRORNO24 = new ERRORNO("INVALID_DISTRICT_ID", 23);
      INVALID_DISTRICT_ID = localERRORNO24;
      ERRORNO localERRORNO25 = new ERRORNO("NO_DATA_FOR_LATLNG", 24);
      NO_DATA_FOR_LATLNG = localERRORNO25;
      ERRORNO localERRORNO26 = new ERRORNO("PARAMER_ERROR", 25);
      PARAMER_ERROR = localERRORNO26;
      $VALUES = new ERRORNO[] { localERRORNO1, localERRORNO2, localERRORNO3, localERRORNO4, localERRORNO5, localERRORNO6, localERRORNO7, localERRORNO8, localERRORNO9, localERRORNO10, localERRORNO11, localERRORNO12, localERRORNO13, localERRORNO14, localERRORNO15, localERRORNO16, localERRORNO17, localERRORNO18, localERRORNO19, localERRORNO20, localERRORNO21, localERRORNO22, localERRORNO23, localERRORNO24, localERRORNO25, localERRORNO26 };
    }
    
    private ERRORNO() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.SearchResult
 * JD-Core Version:    0.7.0.1
 */