package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

class ErrorMessage
{
  static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", paramInt);
      localJSONObject.put("message", paramString);
      label24:
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      break label24;
    }
  }
  
  static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", -1);
      localJSONObject.put("message", paramString);
      label24:
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      break label24;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.ErrorMessage
 * JD-Core Version:    0.7.0.1
 */