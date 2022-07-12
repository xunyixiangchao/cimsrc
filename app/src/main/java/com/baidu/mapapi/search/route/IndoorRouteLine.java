package com.baidu.mapapi.search.route;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ParcelCreator"})
public class IndoorRouteLine
  extends RouteLine<IndoorRouteStep>
{
  public static final Parcelable.Creator<IndoorRouteLine> CREATOR = new a();
  
  public IndoorRouteLine()
  {
    setType(RouteLine.TYPE.WALKSTEP);
  }
  
  protected IndoorRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<IndoorRouteStep> getAllStep()
  {
    return super.getAllStep();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
  
  public static class IndoorRouteStep
    extends RouteStep
  {
    private RouteNode d;
    private RouteNode e;
    private String f;
    private String g;
    private String h;
    private List<IndoorStepNode> i;
    private List<Double> j;
    
    private List<LatLng> a(List<Double> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      while (k < paramList.size())
      {
        localArrayList.add(new LatLng(((Double)paramList.get(k)).doubleValue(), ((Double)paramList.get(k + 1)).doubleValue()));
        k += 2;
      }
      return localArrayList;
    }
    
    public String getBuildingId()
    {
      return this.h;
    }
    
    public RouteNode getEntrace()
    {
      return this.d;
    }
    
    public RouteNode getExit()
    {
      return this.e;
    }
    
    public String getFloorId()
    {
      return this.g;
    }
    
    public String getInstructions()
    {
      return this.f;
    }
    
    public List<IndoorStepNode> getStepNodes()
    {
      return this.i;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = a(this.j);
      }
      return this.mWayPoints;
    }
    
    public void setBuildingId(String paramString)
    {
      this.h = paramString;
    }
    
    public void setEntrace(RouteNode paramRouteNode)
    {
      this.d = paramRouteNode;
    }
    
    public void setExit(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }
    
    public void setFloorId(String paramString)
    {
      this.g = paramString;
    }
    
    public void setInstructions(String paramString)
    {
      this.f = paramString;
    }
    
    public void setPath(List<Double> paramList)
    {
      this.j = paramList;
    }
    
    public void setStepNodes(List<IndoorStepNode> paramList)
    {
      this.i = paramList;
    }
    
    public static class IndoorStepNode
    {
      private String a;
      private int b;
      private LatLng c;
      private String d;
      
      public String getDetail()
      {
        return this.d;
      }
      
      public LatLng getLocation()
      {
        return this.c;
      }
      
      public String getName()
      {
        return this.a;
      }
      
      public int getType()
      {
        return this.b;
      }
      
      public void setDetail(String paramString)
      {
        this.d = paramString;
      }
      
      public void setLocation(LatLng paramLatLng)
      {
        this.c = paramLatLng;
      }
      
      public void setName(String paramString)
      {
        this.a = paramString;
      }
      
      public void setType(int paramInt)
      {
        this.b = paramInt;
      }
    }
  }
  
  class a
    implements Parcelable.Creator<IndoorRouteLine>
  {
    public IndoorRouteLine a(Parcel paramParcel)
    {
      return new IndoorRouteLine(paramParcel);
    }
    
    public IndoorRouteLine[] a(int paramInt)
    {
      return new IndoorRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.IndoorRouteLine
 * JD-Core Version:    0.7.0.1
 */