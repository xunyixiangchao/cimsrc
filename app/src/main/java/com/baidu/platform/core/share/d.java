package com.baidu.platform.core.share;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.util.a;

public class d
  extends com.baidu.platform.base.c
{
  public d(RouteShareURLOption paramRouteShareURLOption)
  {
    a(paramRouteShareURLOption);
  }
  
  private void a(RouteShareURLOption paramRouteShareURLOption)
  {
    a locala = new a();
    Object localObject1 = CoordUtil.ll2point(paramRouteShareURLOption.mFrom.getLocation());
    Point localPoint = CoordUtil.ll2point(paramRouteShareURLOption.mTo.getLocation());
    Object localObject3 = "2$$$$$$";
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1$$$$");
      ((StringBuilder)localObject2).append(((Point)localObject1).x);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(((Point)localObject1).y);
      ((StringBuilder)localObject2).append("$$");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = "2$$$$$$";
    }
    Object localObject5 = paramRouteShareURLOption.mFrom.getName();
    Object localObject4 = "";
    if (localObject5 != null)
    {
      localObject2 = localObject5;
      if (!((String)localObject5).equals("")) {}
    }
    else
    {
      localObject2 = "起点";
    }
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("$$0$$$$");
    String str = ((StringBuilder)localObject5).toString();
    localObject1 = localObject3;
    if (localPoint != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("1$$$$");
      ((StringBuilder)localObject1).append(localPoint.x);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localPoint.y);
      ((StringBuilder)localObject1).append("$$");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject5 = paramRouteShareURLOption.mTo.getName();
    if (localObject5 != null)
    {
      localObject3 = localObject5;
      if (!((String)localObject5).equals("")) {}
    }
    else
    {
      localObject3 = "终点";
    }
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("$$0$$$$");
    localObject5 = ((StringBuilder)localObject5).toString();
    int i = paramRouteShareURLOption.mMode.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            localObject1 = "";
            paramRouteShareURLOption = (RouteShareURLOption)localObject4;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&i=");
            ((StringBuilder)localObject1).append(paramRouteShareURLOption.mPn);
            ((StringBuilder)localObject1).append(",1,1&sharecallbackflag=busRoute");
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramRouteShareURLOption.mCityCode);
            ((StringBuilder)localObject4).append("");
            locala.a("c", ((StringBuilder)localObject4).toString());
            localObject4 = "bt";
            paramRouteShareURLOption = (RouteShareURLOption)localObject1;
            localObject1 = localObject4;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mFrom.getCity()));
          ((StringBuilder)localObject1).append("");
          locala.a("sc", ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mTo.getCity()));
          ((StringBuilder)localObject1).append("");
          locala.a("ec", ((StringBuilder)localObject1).toString());
          paramRouteShareURLOption = "&sharecallbackflag=cycleRoute";
          localObject1 = "cycle";
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mFrom.getCity()));
        ((StringBuilder)localObject1).append("");
        locala.a("sc", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mTo.getCity()));
        ((StringBuilder)localObject1).append("");
        locala.a("ec", ((StringBuilder)localObject1).toString());
        paramRouteShareURLOption = "&sharecallbackflag=footRoute";
        localObject1 = "walk";
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mFrom.getCity()));
      ((StringBuilder)localObject1).append("");
      locala.a("sc", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b(paramRouteShareURLOption.mTo.getCity()));
      ((StringBuilder)localObject1).append("");
      locala.a("ec", ((StringBuilder)localObject1).toString());
      paramRouteShareURLOption = "&sharecallbackflag=carRoute";
      localObject1 = "nav";
    }
    locala.a("sn", str);
    locala.a("en", (String)localObject5);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("&start=");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("&end=");
    ((StringBuilder)localObject4).append((String)localObject3);
    Object localObject2 = ((StringBuilder)localObject4).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("&");
    ((StringBuilder)localObject3).append(locala.a());
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(AppMD5.encodeUrlParamsValue((String)localObject2));
    ((StringBuilder)localObject3).append(paramRouteShareURLOption);
    paramRouteShareURLOption = ((StringBuilder)localObject3).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("http://map.baidu.com/?newmap=1&s=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramRouteShareURLOption);
    paramRouteShareURLOption = ((StringBuilder)localObject2).toString();
    this.c.a("url", paramRouteShareURLOption);
    this.c.a("from", "android_map_sdk");
  }
  
  private int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.o();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.d
 * JD-Core Version:    0.7.0.1
 */