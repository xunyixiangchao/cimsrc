package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  private Context a;
  private HashMap b = null;
  private a c = null;
  
  protected c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private HashMap a(HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      paramString = (String)localObject;
      if (((JSONObject)localObject).has("status")) {
        break label66;
      }
      ((JSONObject)localObject).put("status", -1);
      paramString = (String)localObject;
    }
    catch (JSONException paramString)
    {
      label42:
      a locala;
      break label42;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("status", -1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    label66:
    locala = this.c;
    if (locala != null) {
      locala.a(paramString.toString());
    }
  }
  
  protected void a(HashMap paramHashMap, a parama)
  {
    this.b = a(paramHashMap);
    this.c = parama;
    new Thread(new d(this)).start();
  }
  
  static abstract interface a
  {
    public abstract void a(Object paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.c
 * JD-Core Version:    0.7.0.1
 */