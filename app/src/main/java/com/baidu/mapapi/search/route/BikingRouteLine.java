package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;

public class BikingRouteLine
  extends RouteLine<BikingStep>
{
  public static final Parcelable.Creator<BikingRouteLine> CREATOR = new a();
  
  public BikingRouteLine() {}
  
  protected BikingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<BikingStep> getAllStep()
  {
    return super.getAllStep();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.BIKINGSTEP);
    super.writeToParcel(paramParcel, 1);
  }
  
  public static class BikingStep
    extends RouteStep
  {
    public static final Parcelable.Creator<BikingStep> CREATOR = new a();
    private int d;
    private RouteNode e;
    private RouteNode f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    
    public BikingStep() {}
    
    protected BikingStep(Parcel paramParcel)
    {
      super();
      this.d = paramParcel.readInt();
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.f = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      this.k = paramParcel.readString();
    }
    
    private List<LatLng> a(String paramString)
    {
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString = paramString.split(";");
        if (arrayOfString != null)
        {
          if (arrayOfString.length == 0) {
            return null;
          }
          int n = arrayOfString.length;
          int m = 0;
          while (m < n)
          {
            paramString = arrayOfString[m].split(",");
            if ((paramString != null) && (paramString.length >= 2))
            {
              LatLng localLatLng = new LatLng(Double.valueOf(paramString[1]).doubleValue(), Double.valueOf(paramString[0]).doubleValue());
              paramString = localLatLng;
              if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                paramString = CoordTrans.baiduToGcj(localLatLng);
              }
              localArrayList.add(paramString);
            }
            m += 1;
          }
          return localArrayList;
        }
      }
      return null;
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
    
    public String getTurnType()
    {
      return this.k;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = a(this.g);
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
    
    public void setTurnType(String paramString)
    {
      this.k = paramString;
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
      paramParcel.writeString(this.k);
    }
    
    class a
      implements Parcelable.Creator<BikingRouteLine.BikingStep>
    {
      public BikingRouteLine.BikingStep a(Parcel paramParcel)
      {
        return new BikingRouteLine.BikingStep(paramParcel);
      }
      
      public BikingRouteLine.BikingStep[] a(int paramInt)
      {
        return new BikingRouteLine.BikingStep[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<BikingRouteLine>
  {
    public BikingRouteLine a(Parcel paramParcel)
    {
      return new BikingRouteLine(paramParcel);
    }
    
    public BikingRouteLine[] a(int paramInt)
    {
      return new BikingRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.BikingRouteLine
 * JD-Core Version:    0.7.0.1
 */