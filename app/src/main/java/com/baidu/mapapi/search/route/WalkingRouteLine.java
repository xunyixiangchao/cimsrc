package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

public class WalkingRouteLine
  extends RouteLine<WalkingStep>
{
  public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new a();
  
  public WalkingRouteLine() {}
  
  protected WalkingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<WalkingStep> getAllStep()
  {
    return super.getAllStep();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.WALKSTEP);
    super.writeToParcel(paramParcel, 1);
  }
  
  public static class WalkingStep
    extends RouteStep
  {
    public static final Parcelable.Creator<WalkingStep> CREATOR = new a();
    private int d;
    private RouteNode e;
    private RouteNode f;
    private String g;
    private String h;
    private String i;
    private String j;
    
    public WalkingStep() {}
    
    protected WalkingStep(Parcel paramParcel)
    {
      super();
      this.d = paramParcel.readInt();
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.f = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getDirection()
    {
      return this.d;
    }
    
    public RouteNode getEntrance()
    {
      return this.e;
    }
    
    public String getEntranceInstructions()
    {
      return this.h;
    }
    
    public RouteNode getExit()
    {
      return this.f;
    }
    
    public String getExitInstructions()
    {
      return this.i;
    }
    
    public String getInstructions()
    {
      return this.j;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.g);
      }
      return this.mWayPoints;
    }
    
    public void setDirection(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void setEntrance(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }
    
    public void setEntranceInstructions(String paramString)
    {
      this.h = paramString;
    }
    
    public void setExit(RouteNode paramRouteNode)
    {
      this.f = paramRouteNode;
    }
    
    public void setExitInstructions(String paramString)
    {
      this.i = paramString;
    }
    
    public void setInstructions(String paramString)
    {
      this.j = paramString;
    }
    
    public void setPathString(String paramString)
    {
      this.g = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, 1);
      paramParcel.writeInt(this.d);
      paramParcel.writeParcelable(this.e, 1);
      paramParcel.writeParcelable(this.f, 1);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.j);
    }
    
    class a
      implements Parcelable.Creator<WalkingRouteLine.WalkingStep>
    {
      public WalkingRouteLine.WalkingStep a(Parcel paramParcel)
      {
        return new WalkingRouteLine.WalkingStep(paramParcel);
      }
      
      public WalkingRouteLine.WalkingStep[] a(int paramInt)
      {
        return new WalkingRouteLine.WalkingStep[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<WalkingRouteLine>
  {
    public WalkingRouteLine a(Parcel paramParcel)
    {
      return new WalkingRouteLine(paramParcel);
    }
    
    public WalkingRouteLine[] a(int paramInt)
    {
      return new WalkingRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRouteLine
 * JD-Core Version:    0.7.0.1
 */