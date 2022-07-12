package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class RecommendStopResult
  extends SearchResult
{
  public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();
  private List<RecommendStopInfo> a;
  
  public RecommendStopResult() {}
  
  protected RecommendStopResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.createTypedArrayList(RecommendStopInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<RecommendStopInfo> getRecommendStopInfoList()
  {
    return this.a;
  }
  
  public void setRecommendStopInfoList(List<RecommendStopInfo> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("RecommendStopResult: ");
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
      localObject = (RecommendStopInfo)this.a.get(i);
      if (localObject == null) {
        localStringBuffer.append("null");
      } else {
        localStringBuffer.append(((RecommendStopInfo)localObject).toString());
      }
      i += 1;
      continue;
      localStringBuffer.append("null");
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
  
  class a
    implements Parcelable.Creator<RecommendStopResult>
  {
    public RecommendStopResult a(Parcel paramParcel)
    {
      return new RecommendStopResult(paramParcel);
    }
    
    public RecommendStopResult[] a(int paramInt)
    {
      return new RecommendStopResult[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.recommendstop.RecommendStopResult
 * JD-Core Version:    0.7.0.1
 */