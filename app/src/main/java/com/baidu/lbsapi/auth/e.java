package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class e
{
  private Context a;
  private List b = null;
  private a c = null;
  
  protected e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private List a(HashMap paramHashMap, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      i = 0;
    }
    while (i < paramArrayOfString.length)
    {
      Object localObject1 = new HashMap();
      Object localObject2 = paramHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((String)((Iterator)localObject2).next()).toString();
        ((HashMap)localObject1).put(str, paramHashMap.get(str));
      }
      ((HashMap)localObject1).put("mcode", paramArrayOfString[i]);
      localArrayList.add(localObject1);
      i += 1;
      continue;
      paramArrayOfString = new HashMap();
      localObject1 = paramHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((String)((Iterator)localObject1).next()).toString();
        paramArrayOfString.put(localObject2, paramHashMap.get(localObject2));
      }
      localArrayList.add(paramArrayOfString);
    }
    return localArrayList;
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
  
  private void a(List paramList)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("syncConnect start Thread id = ");
    ((StringBuilder)localObject1).append(String.valueOf(Thread.currentThread().getId()));
    a.a(((StringBuilder)localObject1).toString());
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("syncConnect resuest ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("  start!!!");
        a.a(((StringBuilder)localObject1).toString());
        localObject1 = (HashMap)paramList.get(i);
        Object localObject2 = new g(this.a);
        if (((g)localObject2).a())
        {
          localObject2 = ((g)localObject2).a((HashMap)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("syncConnect resuest ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("  result:");
          ((StringBuilder)localObject2).append((String)localObject1);
          a.a(((StringBuilder)localObject2).toString());
          localArrayList.add(localObject1);
        }
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          if ((!((JSONObject)localObject2).has("status")) || (((JSONObject)localObject2).getInt("status") != 0)) {
            break label282;
          }
          a.a("auth end and break");
          a((String)localObject1);
          return;
        }
        catch (JSONException localJSONException)
        {
          label256:
          break label256;
        }
        a.a("continue-------------------------------");
        break label282;
        a.a("Current network is not available.");
        localArrayList.add(ErrorMessage.a("Current network is not available."));
        label282:
        a.a("syncConnect end");
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("--iiiiii:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("<><>paramList.size():");
      ((StringBuilder)localObject1).append(paramList.size());
      ((StringBuilder)localObject1).append("<><>authResults.size():");
      ((StringBuilder)localObject1).append(localArrayList.size());
      a.a(((StringBuilder)localObject1).toString());
      if ((paramList.size() > 0) && (i == paramList.size()) && (localArrayList.size() > 0) && (i == localArrayList.size()))
      {
        i -= 1;
        if (i > 0) {
          try
          {
            paramList = new JSONObject((String)localArrayList.get(i));
            if ((paramList.has("status")) && (paramList.getInt("status") != 0))
            {
              a.a("i-1 result is not 0,return first result");
              a((String)localArrayList.get(0));
              return;
            }
          }
          catch (JSONException paramList)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("JSONException:");
            ((StringBuilder)localObject1).append(paramList.getMessage());
            a(ErrorMessage.a(((StringBuilder)localObject1).toString()));
          }
        }
      }
    }
    else
    {
      a.c("syncConnect failed,params list is null or size is 0");
      return;
    }
  }
  
  protected void a(HashMap paramHashMap, String[] paramArrayOfString, a parama)
  {
    this.b = a(paramHashMap, paramArrayOfString);
    this.c = parama;
    new Thread(new f(this)).start();
  }
  
  static abstract interface a
  {
    public abstract void a(Object paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.e
 * JD-Core Version:    0.7.0.1
 */