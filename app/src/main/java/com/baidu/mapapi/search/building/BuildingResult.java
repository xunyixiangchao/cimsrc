package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class BuildingResult
  extends SearchResult
{
  public static final Parcelable.Creator<BuildingResult> CREATOR = new a();
  private List<BuildingInfo> a;
  
  public BuildingResult() {}
  
  protected BuildingResult(Parcel paramParcel)
  {
    this.a = paramParcel.createTypedArrayList(BuildingInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<BuildingInfo> getBuildingList()
  {
    return this.a;
  }
  
  public void setBuildingList(List<BuildingInfo> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BuidingResult: ");
    Object localObject = this.a;
    int i;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      i = 0;
    }
    while (i < this.a.size())
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(i);
      localStringBuffer.append(" ");
      localObject = (BuildingInfo)this.a.get(i);
      if (localObject == null) {
        localStringBuffer.append("null");
      } else {
        localStringBuffer.append(((BuildingInfo)localObject).toString());
      }
      i += 1;
      continue;
      localStringBuffer.append("null");
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
  }
  
  class a
    implements Parcelable.Creator<BuildingResult>
  {
    public BuildingResult a(Parcel paramParcel)
    {
      return new BuildingResult(paramParcel);
    }
    
    public BuildingResult[] a(int paramInt)
    {
      return new BuildingResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.building.BuildingResult
 * JD-Core Version:    0.7.0.1
 */