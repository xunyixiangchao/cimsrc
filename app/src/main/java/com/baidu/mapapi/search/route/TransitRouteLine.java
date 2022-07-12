package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

public final class TransitRouteLine
  extends RouteLine<TransitStep>
{
  public static final Parcelable.Creator<TransitRouteLine> CREATOR = new a();
  private TaxiInfo h;
  
  public TransitRouteLine() {}
  
  protected TransitRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
    this.h = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public TaxiInfo getTaxitInfo()
  {
    return this.h;
  }
  
  public void setTaxitInfo(TaxiInfo paramTaxiInfo)
  {
    this.h = paramTaxiInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.TRANSITSTEP);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.h, 1);
  }
  
  public static class TransitStep
    extends RouteStep
  {
    public static final Parcelable.Creator<TransitStep> CREATOR = new a();
    private VehicleInfo d;
    private RouteNode e;
    private RouteNode f;
    private TransitRouteStepType g;
    private String h;
    private String i;
    
    public TransitStep() {}
    
    protected TransitStep(Parcel paramParcel)
    {
      super();
      this.d = ((VehicleInfo)paramParcel.readParcelable(VehicleInfo.class.getClassLoader()));
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.f = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      int j = paramParcel.readInt();
      TransitRouteStepType localTransitRouteStepType;
      if (j == -1) {
        localTransitRouteStepType = null;
      } else {
        localTransitRouteStepType = TransitRouteStepType.values()[j];
      }
      this.g = localTransitRouteStepType;
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public RouteNode getEntrance()
    {
      return this.e;
    }
    
    public RouteNode getExit()
    {
      return this.f;
    }
    
    public String getInstructions()
    {
      return this.h;
    }
    
    public TransitRouteStepType getStepType()
    {
      return this.g;
    }
    
    public VehicleInfo getVehicleInfo()
    {
      return this.d;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.i);
      }
      return this.mWayPoints;
    }
    
    public void setEntrace(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }
    
    public void setExit(RouteNode paramRouteNode)
    {
      this.f = paramRouteNode;
    }
    
    public void setInstructions(String paramString)
    {
      this.h = paramString;
    }
    
    public void setPathString(String paramString)
    {
      this.i = paramString;
    }
    
    public void setStepType(TransitRouteStepType paramTransitRouteStepType)
    {
      this.g = paramTransitRouteStepType;
    }
    
    public void setVehicleInfo(VehicleInfo paramVehicleInfo)
    {
      this.d = paramVehicleInfo;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.d, 1);
      paramParcel.writeParcelable(this.e, 1);
      paramParcel.writeParcelable(this.f, 1);
      TransitRouteStepType localTransitRouteStepType = this.g;
      if (localTransitRouteStepType == null) {
        paramInt = -1;
      } else {
        paramInt = localTransitRouteStepType.ordinal();
      }
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
    }
    
    public static enum TransitRouteStepType
    {
      static
      {
        TransitRouteStepType localTransitRouteStepType1 = new TransitRouteStepType("BUSLINE", 0);
        BUSLINE = localTransitRouteStepType1;
        TransitRouteStepType localTransitRouteStepType2 = new TransitRouteStepType("SUBWAY", 1);
        SUBWAY = localTransitRouteStepType2;
        TransitRouteStepType localTransitRouteStepType3 = new TransitRouteStepType("WAKLING", 2);
        WAKLING = localTransitRouteStepType3;
        $VALUES = new TransitRouteStepType[] { localTransitRouteStepType1, localTransitRouteStepType2, localTransitRouteStepType3 };
      }
      
      private TransitRouteStepType() {}
    }
    
    class a
      implements Parcelable.Creator<TransitRouteLine.TransitStep>
    {
      public TransitRouteLine.TransitStep a(Parcel paramParcel)
      {
        return new TransitRouteLine.TransitStep(paramParcel);
      }
      
      public TransitRouteLine.TransitStep[] a(int paramInt)
      {
        return new TransitRouteLine.TransitStep[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<TransitRouteLine>
  {
    public TransitRouteLine a(Parcel paramParcel)
    {
      return new TransitRouteLine(paramParcel);
    }
    
    public TransitRouteLine[] a(int paramInt)
    {
      return new TransitRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRouteLine
 * JD-Core Version:    0.7.0.1
 */