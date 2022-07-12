package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.route.BikingRouteLine.BikingStep;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import java.util.List;

public class RouteLine<T extends RouteStep>
  implements Parcelable
{
  private RouteNode a;
  private RouteNode b;
  private String c;
  private List<T> d;
  private int e;
  private int f;
  TYPE g;
  
  protected RouteLine() {}
  
  protected RouteLine(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.a = ((RouteNode)paramParcel.readValue(RouteNode.class.getClassLoader()));
    this.b = ((RouteNode)paramParcel.readValue(RouteNode.class.getClassLoader()));
    this.c = paramParcel.readString();
    Parcelable.Creator localCreator;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label105;
          }
          localCreator = BikingRouteLine.BikingStep.CREATOR;
        }
        else
        {
          localCreator = WalkingRouteLine.WalkingStep.CREATOR;
        }
      }
      else {
        localCreator = TransitRouteLine.TransitStep.CREATOR;
      }
    }
    else {
      localCreator = DrivingRouteLine.DrivingStep.CREATOR;
    }
    this.d = paramParcel.createTypedArrayList(localCreator);
    label105:
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<T> getAllStep()
  {
    return this.d;
  }
  
  public int getDistance()
  {
    return this.e;
  }
  
  public int getDuration()
  {
    return this.f;
  }
  
  public RouteNode getStarting()
  {
    return this.a;
  }
  
  public RouteNode getTerminal()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.c;
  }
  
  protected TYPE getType()
  {
    return this.g;
  }
  
  public void setDistance(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setStarting(RouteNode paramRouteNode)
  {
    this.a = paramRouteNode;
  }
  
  public void setSteps(List<T> paramList)
  {
    this.d = paramList;
  }
  
  public void setTerminal(RouteNode paramRouteNode)
  {
    this.b = paramRouteNode;
  }
  
  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
  
  protected void setType(TYPE paramTYPE)
  {
    this.g = paramTYPE;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    TYPE localTYPE = this.g;
    if (localTYPE != null) {
      paramInt = TYPE.a(localTYPE);
    } else {
      paramInt = 10;
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeValue(this.a);
    paramParcel.writeValue(this.b);
    paramParcel.writeString(this.c);
    if (this.g != null) {
      paramParcel.writeTypedList(this.d);
    }
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
  }
  
  protected static enum TYPE
  {
    private int a;
    
    static
    {
      TYPE localTYPE1 = new TYPE("DRIVESTEP", 0, 0);
      DRIVESTEP = localTYPE1;
      TYPE localTYPE2 = new TYPE("TRANSITSTEP", 1, 1);
      TRANSITSTEP = localTYPE2;
      TYPE localTYPE3 = new TYPE("WALKSTEP", 2, 2);
      WALKSTEP = localTYPE3;
      TYPE localTYPE4 = new TYPE("BIKINGSTEP", 3, 3);
      BIKINGSTEP = localTYPE4;
      b = new TYPE[] { localTYPE1, localTYPE2, localTYPE3, localTYPE4 };
    }
    
    private TYPE(int paramInt)
    {
      this.a = paramInt;
    }
    
    private int a()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.core.RouteLine
 * JD-Core Version:    0.7.0.1
 */