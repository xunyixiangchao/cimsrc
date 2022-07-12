package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MassTransitRouteLine
  extends RouteLine<TransitStep>
{
  public static final Parcelable.Creator<MassTransitRouteLine> CREATOR = new a();
  private String h;
  private double i;
  private List<PriceInfo> j;
  private List<List<TransitStep>> k = null;
  
  public MassTransitRouteLine() {}
  
  protected MassTransitRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
    int n = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readDouble();
    this.j = paramParcel.createTypedArrayList(PriceInfo.CREATOR);
    if (n > 0)
    {
      this.k = new ArrayList();
      int m = 0;
      while (m < n)
      {
        this.k.add(paramParcel.createTypedArrayList(TransitStep.CREATOR));
        m += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getArriveTime()
  {
    return this.h;
  }
  
  public List<List<TransitStep>> getNewSteps()
  {
    return this.k;
  }
  
  public double getPrice()
  {
    return this.i;
  }
  
  public List<PriceInfo> getPriceInfo()
  {
    return this.j;
  }
  
  public void setArriveTime(String paramString)
  {
    this.h = paramString;
  }
  
  public void setNewSteps(List<List<TransitStep>> paramList)
  {
    this.k = paramList;
  }
  
  public void setPrice(double paramDouble)
  {
    this.i = paramDouble;
  }
  
  public void setPriceInfo(List<PriceInfo> paramList)
  {
    this.j = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    Object localObject = this.k;
    if (localObject == null) {
      paramInt = 0;
    } else {
      paramInt = ((List)localObject).size();
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeString(this.h);
    paramParcel.writeDouble(this.i);
    paramParcel.writeTypedList(this.j);
    localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParcel.writeTypedList((List)((Iterator)localObject).next());
    }
  }
  
  public static class TransitStep
    extends RouteStep
  {
    public static final Parcelable.Creator<TransitStep> CREATOR = new a();
    private List<TrafficCondition> d;
    private LatLng e;
    private LatLng f;
    private TrainInfo g;
    private PlaneInfo h;
    private CoachInfo i;
    private BusInfo j;
    private StepVehicleInfoType k;
    private String l;
    private String m;
    
    public TransitStep() {}
    
    protected TransitStep(Parcel paramParcel)
    {
      super();
      this.d = paramParcel.createTypedArrayList(TrafficCondition.CREATOR);
      this.e = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
      this.f = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
      this.g = ((TrainInfo)paramParcel.readParcelable(TrainInfo.class.getClassLoader()));
      this.h = ((PlaneInfo)paramParcel.readParcelable(PlaneInfo.class.getClassLoader()));
      this.i = ((CoachInfo)paramParcel.readParcelable(CoachInfo.class.getClassLoader()));
      this.j = ((BusInfo)paramParcel.readParcelable(BusInfo.class.getClassLoader()));
      StepVehicleInfoType localStepVehicleInfoType;
      switch (paramParcel.readInt())
      {
      default: 
        break;
      case 6: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_COACH;
        break;
      case 5: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_WALK;
        break;
      case 4: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_DRIVING;
        break;
      case 3: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_BUS;
        break;
      case 2: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_PLANE;
        break;
      case 1: 
        localStepVehicleInfoType = StepVehicleInfoType.ESTEP_TRAIN;
      }
      this.k = localStepVehicleInfoType;
      this.l = paramParcel.readString();
      this.m = paramParcel.readString();
    }
    
    private List<LatLng> a(String paramString)
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = paramString.split(";");
      if (arrayOfString != null)
      {
        int n = 0;
        while (n < arrayOfString.length)
        {
          if ((arrayOfString[n] != null) && (arrayOfString[n] != ""))
          {
            paramString = arrayOfString[n].split(",");
            if ((paramString != null) && (paramString[1] != "") && (paramString[0] != ""))
            {
              LatLng localLatLng = new LatLng(Double.parseDouble(paramString[1]), Double.parseDouble(paramString[0]));
              paramString = localLatLng;
              if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                paramString = CoordTrans.baiduToGcj(localLatLng);
              }
              localArrayList.add(paramString);
            }
          }
          n += 1;
        }
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public BusInfo getBusInfo()
    {
      return this.j;
    }
    
    public CoachInfo getCoachInfo()
    {
      return this.i;
    }
    
    public LatLng getEndLocation()
    {
      return this.f;
    }
    
    public String getInstructions()
    {
      return this.l;
    }
    
    public PlaneInfo getPlaneInfo()
    {
      return this.h;
    }
    
    public LatLng getStartLocation()
    {
      return this.e;
    }
    
    public List<TrafficCondition> getTrafficConditions()
    {
      return this.d;
    }
    
    public TrainInfo getTrainInfo()
    {
      return this.g;
    }
    
    public StepVehicleInfoType getVehileType()
    {
      return this.k;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = a(this.m);
      }
      return this.mWayPoints;
    }
    
    public void setBusInfo(BusInfo paramBusInfo)
    {
      this.j = paramBusInfo;
    }
    
    public void setCoachInfo(CoachInfo paramCoachInfo)
    {
      this.i = paramCoachInfo;
    }
    
    public void setEndLocation(LatLng paramLatLng)
    {
      this.f = paramLatLng;
    }
    
    public void setInstructions(String paramString)
    {
      this.l = paramString;
    }
    
    public void setPathString(String paramString)
    {
      this.m = paramString;
    }
    
    public void setPlaneInfo(PlaneInfo paramPlaneInfo)
    {
      this.h = paramPlaneInfo;
    }
    
    public void setStartLocation(LatLng paramLatLng)
    {
      this.e = paramLatLng;
    }
    
    public void setTrafficConditions(List<TrafficCondition> paramList)
    {
      this.d = paramList;
    }
    
    public void setTrainInfo(TrainInfo paramTrainInfo)
    {
      this.g = paramTrainInfo;
    }
    
    public void setVehileType(StepVehicleInfoType paramStepVehicleInfoType)
    {
      this.k = paramStepVehicleInfoType;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeTypedList(this.d);
      paramParcel.writeParcelable(this.e, paramInt);
      paramParcel.writeParcelable(this.f, paramInt);
      paramParcel.writeParcelable(this.g, paramInt);
      paramParcel.writeParcelable(this.h, paramInt);
      paramParcel.writeParcelable(this.i, paramInt);
      paramParcel.writeParcelable(this.j, paramInt);
      paramParcel.writeInt(this.k.getInt());
      paramParcel.writeString(this.l);
      paramParcel.writeString(this.m);
    }
    
    public static enum StepVehicleInfoType
    {
      private int a;
      
      static
      {
        StepVehicleInfoType localStepVehicleInfoType1 = new StepVehicleInfoType("ESTEP_TRAIN", 0, 1);
        ESTEP_TRAIN = localStepVehicleInfoType1;
        StepVehicleInfoType localStepVehicleInfoType2 = new StepVehicleInfoType("ESTEP_PLANE", 1, 2);
        ESTEP_PLANE = localStepVehicleInfoType2;
        StepVehicleInfoType localStepVehicleInfoType3 = new StepVehicleInfoType("ESTEP_BUS", 2, 3);
        ESTEP_BUS = localStepVehicleInfoType3;
        StepVehicleInfoType localStepVehicleInfoType4 = new StepVehicleInfoType("ESTEP_DRIVING", 3, 4);
        ESTEP_DRIVING = localStepVehicleInfoType4;
        StepVehicleInfoType localStepVehicleInfoType5 = new StepVehicleInfoType("ESTEP_WALK", 4, 5);
        ESTEP_WALK = localStepVehicleInfoType5;
        StepVehicleInfoType localStepVehicleInfoType6 = new StepVehicleInfoType("ESTEP_COACH", 5, 6);
        ESTEP_COACH = localStepVehicleInfoType6;
        $VALUES = new StepVehicleInfoType[] { localStepVehicleInfoType1, localStepVehicleInfoType2, localStepVehicleInfoType3, localStepVehicleInfoType4, localStepVehicleInfoType5, localStepVehicleInfoType6 };
      }
      
      private StepVehicleInfoType(int paramInt)
      {
        this.a = paramInt;
      }
      
      public int getInt()
      {
        return this.a;
      }
    }
    
    public static class TrafficCondition
      implements Parcelable
    {
      public static final Parcelable.Creator<TrafficCondition> CREATOR = new a();
      private int a;
      private int b;
      
      public TrafficCondition() {}
      
      protected TrafficCondition(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readInt();
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public int getTrafficGeoCnt()
      {
        return this.b;
      }
      
      public int getTrafficStatus()
      {
        return this.a;
      }
      
      public void setTrafficGeoCnt(int paramInt)
      {
        this.b = paramInt;
      }
      
      public void setTrafficStatus(int paramInt)
      {
        this.a = paramInt;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        paramParcel.writeInt(this.b);
      }
      
      class a
        implements Parcelable.Creator<MassTransitRouteLine.TransitStep.TrafficCondition>
      {
        public MassTransitRouteLine.TransitStep.TrafficCondition a(Parcel paramParcel)
        {
          return new MassTransitRouteLine.TransitStep.TrafficCondition(paramParcel);
        }
        
        public MassTransitRouteLine.TransitStep.TrafficCondition[] a(int paramInt)
        {
          return new MassTransitRouteLine.TransitStep.TrafficCondition[paramInt];
        }
      }
    }
    
    class a
      implements Parcelable.Creator<MassTransitRouteLine.TransitStep>
    {
      public MassTransitRouteLine.TransitStep a(Parcel paramParcel)
      {
        return new MassTransitRouteLine.TransitStep(paramParcel);
      }
      
      public MassTransitRouteLine.TransitStep[] a(int paramInt)
      {
        return new MassTransitRouteLine.TransitStep[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<MassTransitRouteLine>
  {
    public MassTransitRouteLine a(Parcel paramParcel)
    {
      return new MassTransitRouteLine(paramParcel);
    }
    
    public MassTransitRouteLine[] a(int paramInt)
    {
      return new MassTransitRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.MassTransitRouteLine
 * JD-Core Version:    0.7.0.1
 */