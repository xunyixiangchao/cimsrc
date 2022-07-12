package com.baidu.b;

import android.text.TextUtils;
import com.baidu.b.c.a.g;
import com.baidu.b.d.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public String a;
  public String b;
  public int c = 2;
  private int d = 0;
  
  public static f a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      f localf = new f();
      localf.a = paramString1;
      int i;
      if (TextUtils.isEmpty(paramString2)) {
        i = 0;
      } else {
        i = paramString2.length();
      }
      localf.d = i;
      if (i < 14)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "0";
        }
        localf.b = paramString1;
      }
      return localf;
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt >= 14;
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.isEmpty(paramString);
  }
  
  public static f b(String paramString)
  {
    return c(e(paramString));
  }
  
  private static f c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    label216:
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        Object localObject2 = ((JSONObject)localObject1).keys();
        String str1 = "0";
        paramString = "0";
        boolean bool = ((Iterator)localObject2).hasNext();
        if (bool)
        {
          String str2 = (String)((Iterator)localObject2).next();
          if ((d("ZGV2aWNlaWQ=").equals(str2)) || (d("dmVy").equals(str2))) {
            continue;
          }
          paramString = ((JSONObject)localObject1).optString(str2, "0");
          continue;
        }
        localObject2 = ((JSONObject)localObject1).getString(d("ZGV2aWNlaWQ="));
        int j = ((JSONObject)localObject1).getInt(d("dmVy"));
        int i;
        if (TextUtils.isEmpty(paramString)) {
          i = 0;
        } else {
          i = paramString.length();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new f();
          ((f)localObject1).a = ((String)localObject2);
          ((f)localObject1).c = j;
          ((f)localObject1).d = i;
          if (i < 14)
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label216;
            }
            paramString = str1;
            ((f)localObject1).b = paramString;
          }
          ((f)localObject1).c();
          return localObject1;
        }
      }
      catch (JSONException paramString)
      {
        com.baidu.b.f.c.a(paramString);
      }
      return null;
    }
  }
  
  private static String d(String paramString)
  {
    return new String(a.a(paramString.getBytes()));
  }
  
  private static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = g.a();
      paramString = new String(com.baidu.b.c.a.c.a(arrayOfByte, arrayOfByte, a.a(paramString.getBytes())));
      return paramString;
    }
    catch (Exception paramString)
    {
      com.baidu.b.f.c.a(paramString);
    }
    return "";
  }
  
  boolean a()
  {
    return a(this.b);
  }
  
  boolean b()
  {
    return a(this.d);
  }
  
  boolean c()
  {
    if (b()) {}
    for (String str = "O";; str = "0")
    {
      this.b = str;
      return true;
      if (!a()) {
        break;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.f
 * JD-Core Version:    0.7.0.1
 */