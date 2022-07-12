package com.baidu.platform.comapi.e;

import com.baidu.platform.comapi.c.c;
import org.json.JSONObject;

public class a
{
  private static JSONObject b;
  public static a c;
  private c a = null;
  
  public static a a()
  {
    if (c == null) {
      c = new a();
    }
    if (b == null) {
      b = new JSONObject();
    }
    return c;
  }
  
  private void b()
  {
    b = null;
    b = new JSONObject();
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.a == null) {
        this.a = c.a();
      }
      boolean bool = false;
      if (this.a != null)
      {
        JSONObject localJSONObject = b;
        if ((localJSONObject != null) && (localJSONObject.length() > 0)) {
          bool = this.a.a(1100, 1, paramString, b.toString());
        } else {
          bool = this.a.a(1100, 1, paramString, null);
        }
        b();
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.e.a
 * JD-Core Version:    0.7.0.1
 */