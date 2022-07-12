package com.baidu.mapapi.search.route;

public class TransitRoutePlanOption
{
  public String mCityName = null;
  public PlanNode mFrom = null;
  public TransitPolicy mPolicy = TransitPolicy.EBUS_TIME_FIRST;
  public PlanNode mTo = null;
  
  public TransitRoutePlanOption city(String paramString)
  {
    this.mCityName = paramString;
    return this;
  }
  
  public TransitRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public TransitRoutePlanOption policy(TransitPolicy paramTransitPolicy)
  {
    this.mPolicy = paramTransitPolicy;
    return this;
  }
  
  public TransitRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
  
  public static enum TransitPolicy
  {
    private int a;
    
    static
    {
      TransitPolicy localTransitPolicy1 = new TransitPolicy("EBUS_TIME_FIRST", 0, 0);
      EBUS_TIME_FIRST = localTransitPolicy1;
      TransitPolicy localTransitPolicy2 = new TransitPolicy("EBUS_TRANSFER_FIRST", 1, 2);
      EBUS_TRANSFER_FIRST = localTransitPolicy2;
      TransitPolicy localTransitPolicy3 = new TransitPolicy("EBUS_WALK_FIRST", 2, 3);
      EBUS_WALK_FIRST = localTransitPolicy3;
      TransitPolicy localTransitPolicy4 = new TransitPolicy("EBUS_NO_SUBWAY", 3, 4);
      EBUS_NO_SUBWAY = localTransitPolicy4;
      b = new TransitPolicy[] { localTransitPolicy1, localTransitPolicy2, localTransitPolicy3, localTransitPolicy4 };
    }
    
    private TransitPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */