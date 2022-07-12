package com.baidu.mapapi.search.route;

public class MassTransitRoutePlanOption
{
  public String mCoordType = "bd09ll";
  public PlanNode mFrom = null;
  public int mPageIndex = 1;
  public int mPageSize = 10;
  public TacticsIncity mTacticsIncity = TacticsIncity.ETRANS_SUGGEST;
  public TacticsIntercity mTacticsIntercity = TacticsIntercity.ETRANS_LEAST_TIME;
  public PlanNode mTo = null;
  public TransTypeIntercity mTransTypeIntercity = TransTypeIntercity.ETRANS_TRAIN_FIRST;
  
  @Deprecated
  public MassTransitRoutePlanOption coordType(String paramString)
  {
    this.mCoordType = paramString;
    return this;
  }
  
  public MassTransitRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.mFrom = paramPlanNode;
    return this;
  }
  
  public MassTransitRoutePlanOption pageIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2147483646)) {
      this.mPageIndex = (paramInt + 1);
    }
    return this;
  }
  
  public MassTransitRoutePlanOption pageSize(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 10)) {
      this.mPageSize = paramInt;
    }
    return this;
  }
  
  public MassTransitRoutePlanOption tacticsIncity(TacticsIncity paramTacticsIncity)
  {
    this.mTacticsIncity = paramTacticsIncity;
    return this;
  }
  
  public MassTransitRoutePlanOption tacticsIntercity(TacticsIntercity paramTacticsIntercity)
  {
    this.mTacticsIntercity = paramTacticsIntercity;
    return this;
  }
  
  public MassTransitRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.mTo = paramPlanNode;
    return this;
  }
  
  public MassTransitRoutePlanOption transtypeintercity(TransTypeIntercity paramTransTypeIntercity)
  {
    this.mTransTypeIntercity = paramTransTypeIntercity;
    return this;
  }
  
  public static enum TacticsIncity
  {
    private int a;
    
    static
    {
      TacticsIncity localTacticsIncity1 = new TacticsIncity("ETRANS_SUGGEST", 0, 0);
      ETRANS_SUGGEST = localTacticsIncity1;
      TacticsIncity localTacticsIncity2 = new TacticsIncity("ETRANS_LEAST_TRANSFER", 1, 1);
      ETRANS_LEAST_TRANSFER = localTacticsIncity2;
      TacticsIncity localTacticsIncity3 = new TacticsIncity("ETRANS_LEAST_WALK", 2, 2);
      ETRANS_LEAST_WALK = localTacticsIncity3;
      TacticsIncity localTacticsIncity4 = new TacticsIncity("ETRANS_NO_SUBWAY", 3, 3);
      ETRANS_NO_SUBWAY = localTacticsIncity4;
      TacticsIncity localTacticsIncity5 = new TacticsIncity("ETRANS_LEAST_TIME", 4, 4);
      ETRANS_LEAST_TIME = localTacticsIncity5;
      TacticsIncity localTacticsIncity6 = new TacticsIncity("ETRANS_SUBWAY_FIRST", 5, 5);
      ETRANS_SUBWAY_FIRST = localTacticsIncity6;
      b = new TacticsIncity[] { localTacticsIncity1, localTacticsIncity2, localTacticsIncity3, localTacticsIncity4, localTacticsIncity5, localTacticsIncity6 };
    }
    
    private TacticsIncity(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
  
  public static enum TacticsIntercity
  {
    private int a;
    
    static
    {
      TacticsIntercity localTacticsIntercity1 = new TacticsIntercity("ETRANS_LEAST_TIME", 0, 0);
      ETRANS_LEAST_TIME = localTacticsIntercity1;
      TacticsIntercity localTacticsIntercity2 = new TacticsIntercity("ETRANS_START_EARLY", 1, 1);
      ETRANS_START_EARLY = localTacticsIntercity2;
      TacticsIntercity localTacticsIntercity3 = new TacticsIntercity("ETRANS_LEAST_PRICE", 2, 2);
      ETRANS_LEAST_PRICE = localTacticsIntercity3;
      b = new TacticsIntercity[] { localTacticsIntercity1, localTacticsIntercity2, localTacticsIntercity3 };
    }
    
    private TacticsIntercity(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
  
  public static enum TransTypeIntercity
  {
    private int a;
    
    static
    {
      TransTypeIntercity localTransTypeIntercity1 = new TransTypeIntercity("ETRANS_TRAIN_FIRST", 0, 0);
      ETRANS_TRAIN_FIRST = localTransTypeIntercity1;
      TransTypeIntercity localTransTypeIntercity2 = new TransTypeIntercity("ETRANS_PLANE_FIRST", 1, 1);
      ETRANS_PLANE_FIRST = localTransTypeIntercity2;
      TransTypeIntercity localTransTypeIntercity3 = new TransTypeIntercity("ETRANS_COACH_FIRST", 2, 2);
      ETRANS_COACH_FIRST = localTransTypeIntercity3;
      b = new TransTypeIntercity[] { localTransTypeIntercity1, localTransTypeIntercity2, localTransTypeIntercity3 };
    }
    
    private TransTypeIntercity(int paramInt)
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
 * Qualified Name:     com.baidu.mapapi.search.route.MassTransitRoutePlanOption
 * JD-Core Version:    0.7.0.1
 */