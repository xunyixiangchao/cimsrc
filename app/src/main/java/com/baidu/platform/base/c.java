package com.baidu.platform.base;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.domain.d;
import com.baidu.platform.util.a;

public abstract class c
{
  private boolean a = true;
  private boolean b = true;
  protected a c = new a();
  
  private String a(SearchType paramSearchType, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (SearchType.h == paramSearchType) {
      return a(paramString);
    }
    return paramString;
  }
  
  private String a(String paramString)
  {
    String str = paramString.substring(paramString.indexOf("location=") + 9, paramString.indexOf("&", paramString.indexOf("location=")));
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    Object localObject = new byte[1];
    localObject[0] = 0;
    try
    {
      byte[] arrayOfByte = AlgorithmUtil.setUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), str.getBytes());
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("BaseSearch", "get location failed", localException);
    }
    return paramString.replace(str, Base64.encodeToString((byte[])localObject, 0).trim());
  }
  
  private boolean a(SearchType paramSearchType)
  {
    return SearchType.h == paramSearchType;
  }
  
  protected final String a(PlanNode paramPlanNode)
  {
    if (paramPlanNode == null) {
      return null;
    }
    Object localObject1 = new String("{");
    Object localObject2 = paramPlanNode.getLocation();
    if (localObject2 != null)
    {
      paramPlanNode = new StringBuilder();
      paramPlanNode.append((String)localObject1);
      paramPlanNode.append("\"type\":1,");
      localObject1 = paramPlanNode.toString();
      localObject2 = CoordUtil.ll2point((LatLng)localObject2);
      paramPlanNode = new StringBuilder();
      paramPlanNode.append((String)localObject1);
      paramPlanNode.append("\"xy\":\"");
      paramPlanNode.append(((Point)localObject2).x);
      paramPlanNode.append(",");
      paramPlanNode.append(((Point)localObject2).y);
    }
    for (;;)
    {
      paramPlanNode.append("\"}");
      return paramPlanNode.toString();
      if (paramPlanNode.getName() == null) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\"type\":2,");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("\"keyword\":\"");
      ((StringBuilder)localObject1).append(paramPlanNode.getName());
      paramPlanNode = (PlanNode)localObject1;
    }
    return localObject1;
  }
  
  public abstract String a(com.baidu.platform.domain.c paramc);
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public String b(SearchType paramSearchType)
  {
    String str2 = a(d.a());
    String str1 = HttpClient.getAuthToken();
    Object localObject = str1;
    if (str1 == null)
    {
      Log.e("SearchRequest", "toUrlString get authtoken failed");
      int i = PermissionCheck.permissionCheck();
      if (i != 0)
      {
        paramSearchType = new StringBuilder();
        paramSearchType.append("try permissionCheck result is: ");
        paramSearchType.append(i);
        Log.e("SearchRequest", paramSearchType.toString());
        return null;
      }
      localObject = HttpClient.getAuthToken();
    }
    if (this.a) {
      this.c.a("token", (String)localObject);
    }
    str1 = this.c.a();
    localObject = str1;
    if (a(paramSearchType)) {
      localObject = a(paramSearchType, str1);
    }
    paramSearchType = new StringBuilder();
    paramSearchType.append((String)localObject);
    paramSearchType.append(HttpClient.getPhoneInfo());
    localObject = paramSearchType.toString();
    paramSearchType = (SearchType)localObject;
    if (this.b)
    {
      paramSearchType = new StringBuilder();
      paramSearchType.append((String)localObject);
      paramSearchType.append("&sign=");
      paramSearchType.append(AppMD5.getSignMD5String((String)localObject));
      paramSearchType = paramSearchType.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(paramSearchType);
    return ((StringBuilder)localObject).toString();
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.base.c
 * JD-Core Version:    0.7.0.1
 */