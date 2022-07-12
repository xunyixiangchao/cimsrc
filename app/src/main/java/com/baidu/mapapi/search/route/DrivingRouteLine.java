package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

public class DrivingRouteLine
  extends RouteLine<DrivingStep>
{
  public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new a();
  private boolean h;
  private List<RouteNode> i;
  private int j;
  private int k;
  private int l;
  
  public DrivingRouteLine() {}
  
  protected DrivingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    ArrayList localArrayList = new ArrayList();
    this.i = localArrayList;
    paramParcel.readList(localArrayList, RouteNode.class.getClassLoader());
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCongestionDistance()
  {
    return this.j;
  }
  
  public int getLightNum()
  {
    return this.k;
  }
  
  public int getToll()
  {
    return this.l;
  }
  
  public List<RouteNode> getWayPoints()
  {
    return this.i;
  }
  
  @Deprecated
  public boolean isSupportTraffic()
  {
    return this.h;
  }
  
  public void setCongestionDistance(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setLightNum(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setSupportTraffic(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setToll(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setWayPoints(List<RouteNode> paramList)
  {
    this.i = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static class DrivingStep
    extends RouteStep
  {
    public static final Parcelable.Creator<DrivingStep> CREATOR = new a();
    private int d;
    private RouteNode e;
    private RouteNode f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    List<LatLng> l;
    int[] m;
    private int n;
    private String o;
    
    public DrivingStep() {}
    
    protected DrivingStep(Parcel paramParcel)
    {
      super();
      this.d = paramParcel.readInt();
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.f = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      this.k = paramParcel.readInt();
      this.l = paramParcel.createTypedArrayList(LatLng.CREATOR);
      this.m = paramParcel.createIntArray();
      this.n = paramParcel.readInt();
      this.o = paramParcel.readString();
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
    
    public int getNumTurns()
    {
      return this.k;
    }
    
    public int getRoadLevel()
    {
      return this.n;
    }
    
    public String getRoadName()
    {
      return this.o;
    }
    
    public int[] getTrafficList()
    {
      return this.m;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.g);
      }
      return this.l;
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
    
    public void setNumTurns(int paramInt)
    {
      this.k = paramInt;
    }
    
    public void setPathList(List<LatLng> paramList)
    {
      this.l = paramList;
    }
    
    public void setPathString(String paramString)
    {
      this.g = paramString;
    }
    
    public void setRoadLevel(int paramInt)
    {
      this.n = paramInt;
    }
    
    public void setRoadName(String paramString)
    {
      this.o = paramString;
    }
    
    public void setTrafficList(int[] paramArrayOfInt)
    {
      this.m = paramArrayOfInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.d);
      paramParcel.writeParcelable(this.e, 1);
      paramParcel.writeParcelable(this.f, 1);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.j);
      paramParcel.writeInt(this.k);
      paramParcel.writeTypedList(this.l);
      paramParcel.writeIntArray(this.m);
      paramParcel.writeInt(this.n);
      paramParcel.writeString(this.o);
    }
    
    class a
      implements Parcelable.Creator<DrivingRouteLine.DrivingStep>
    {
      public DrivingRouteLine.DrivingStep a(Parcel paramParcel)
      {
        return new DrivingRouteLine.DrivingStep(paramParcel);
      }
      
      public DrivingRouteLine.DrivingStep[] a(int paramInt)
      {
        return new DrivingRouteLine.DrivingStep[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<DrivingRouteLine>
  {
    public DrivingRouteLine a(Parcel paramParcel)
    {
      return new DrivingRouteLine(paramParcel);
    }
    
    public DrivingRouteLine[] a(int paramInt)
    {
      return new DrivingRouteLine[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.DrivingRouteLine
 * JD-Core Version:    0.7.0.1
 */