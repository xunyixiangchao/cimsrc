package com.baidu.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.baidu.b.b.a.c;
import com.baidu.b.b.a.d;
import com.baidu.b.b.a.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private static boolean b = false;
  c a;
  private Context c;
  private com.baidu.b.e.a.a d;
  private com.baidu.b.b.c e;
  
  public h(Context paramContext, com.baidu.b.e.a parama, c paramc)
  {
    Objects.requireNonNull(paramContext, "context should not be null!!!");
    this.c = paramContext.getApplicationContext();
    paramContext = parama.b().a("bohrium");
    this.d = paramContext;
    paramContext.a();
    this.a = paramc;
    a(parama);
  }
  
  public static a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("dik", "");
      String str1 = ((JSONObject)localObject).optString("cck", "");
      long l = ((JSONObject)localObject).optLong("ctk", 0L);
      int i = ((JSONObject)localObject).optInt("vsk", 1);
      String str2 = ((JSONObject)localObject).optString("ek", "");
      localObject = ((JSONObject)localObject).optString("v270fk", "V");
      if (!TextUtils.isEmpty(paramString))
      {
        a locala = new a();
        a.a(locala, paramString);
        a.b(locala, str1);
        a.a(locala, l);
        a.a(locala, i);
        a.c(locala, str2);
        a.d(locala, (String)localObject);
        return locala;
      }
    }
    catch (Exception paramString)
    {
      com.baidu.b.f.c.a(paramString);
    }
    return null;
  }
  
  public static a a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        String str = c(paramString1);
        long l = System.currentTimeMillis();
        a locala = new a();
        a.a(locala, paramString1);
        a.b(locala, str);
        a.a(locala, l);
        a.a(locala, 1);
        a.c(locala, paramString3);
        a.d(locala, paramString2);
        return locala;
      }
      catch (Exception paramString1)
      {
        com.baidu.b.f.c.a(paramString1);
      }
    }
    return null;
  }
  
  private String a(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private void a(com.baidu.b.e.a parama)
  {
    com.baidu.b.b.c localc = new com.baidu.b.b.c(new a());
    com.baidu.b.b.a.a locala = new com.baidu.b.b.a.a();
    locala.a = this.c;
    locala.b = parama;
    parama = new a.c();
    Iterator localIterator = localc.a().iterator();
    while (localIterator.hasNext())
    {
      com.baidu.b.b.a locala1 = (com.baidu.b.b.a)localIterator.next();
      locala1.a(locala);
      locala1.a(parama);
    }
    this.e = localc;
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = new com.baidu.b.a.a().a(paramString.getBytes("UTF-8"));
      paramString = new com.baidu.b.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public a a()
  {
    a.d locald = new a.d();
    locald.a = true;
    List localList = this.e.a();
    Collections.sort(localList, com.baidu.b.b.a.c);
    Object localObject1 = this.a.b(this.c);
    if (localObject1 != null)
    {
      Object localObject2;
      do
      {
        do
        {
          localObject1 = ((List)localObject1).iterator();
          b localb;
          Iterator localIterator;
          while (!localIterator.hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localb = (b)((Iterator)localObject1).next();
            } while ((localb.d) || (!localb.c));
            localIterator = localList.iterator();
          }
          localObject2 = ((com.baidu.b.b.a)localIterator.next()).a(localb.a.packageName, locald);
        } while ((localObject2 == null) || (!((a.e)localObject2).a()));
        localObject2 = ((a.e)localObject2).a;
      } while (localObject2 == null);
      return localObject2;
    }
    return null;
  }
  
  public a a(f paramf)
  {
    a locala;
    if (paramf != null)
    {
      locala = new a();
      a.a(locala, System.currentTimeMillis());
      a.a(locala, 1);
    }
    try
    {
      Object localObject = paramf.b;
      int j = 0;
      a.d(locala, ((String)localObject).substring(0, 1));
      a.a(locala, paramf.a);
      a.b(locala, c(paramf.a));
      localObject = a.a;
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        if (localObject[i].equals(a.a(locala)))
        {
          i = j;
          break label120;
        }
        i += 1;
      }
      i = 1;
      label120:
      if (i != 0)
      {
        localObject = paramf.b;
        if ((localObject != null) && (((String)localObject).length() >= 2)) {
          a.c(locala, paramf.b.substring(1));
        }
      }
      return locala;
    }
    catch (Exception paramf)
    {
      label161:
      break label161;
    }
    return null;
    throw new IllegalArgumentException("arg non-nullable is expected");
  }
  
  public a b(String paramString)
  {
    paramString = a(this.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("com.baidu");
    ((StringBuilder)localObject).append(paramString);
    paramString = com.baidu.b.d.b.a(((StringBuilder)localObject).toString().getBytes(), true);
    localObject = new a();
    a.a((a)localObject, System.currentTimeMillis());
    a.a((a)localObject, 1);
    a.a((a)localObject, paramString);
    a.d((a)localObject, "E");
    a.b((a)localObject, c(paramString));
    a.c((a)localObject, "RO");
    return localObject;
  }
  
  public static class a
  {
    public static final String[] a = { "V", "O", "0" };
    private String b;
    private String c;
    private String d;
    private long e;
    private String f;
    private int g = 1;
    
    public String a()
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("dik", this.b);
        ((JSONObject)localObject).put("v270fk", this.c);
        ((JSONObject)localObject).put("cck", this.d);
        ((JSONObject)localObject).put("vsk", this.g);
        ((JSONObject)localObject).put("ctk", this.e);
        ((JSONObject)localObject).put("ek", this.f);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        com.baidu.b.f.c.a(localJSONException);
      }
      return null;
    }
    
    public String b()
    {
      Object localObject2 = this.c;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "0";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append((String)localObject1);
      if ("V".equals(localObject1)) {
        ((StringBuilder)localObject2).append(this.d);
      }
      if (!TextUtils.isEmpty(this.f)) {
        ((StringBuilder)localObject2).append(this.f);
      }
      return ((StringBuilder)localObject2).toString().trim();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        Object localObject = (a)paramObject;
        if ((this.g == ((a)localObject).g) && (this.b.equals(((a)localObject).b)) && (this.c.equals(((a)localObject).c)) && (this.d.equals(((a)localObject).d)))
        {
          paramObject = this.f;
          localObject = ((a)localObject).f;
          if (paramObject == localObject) {
            break label115;
          }
          if ((paramObject != null) && (paramObject.equals(localObject))) {
            return true;
          }
        }
        bool = false;
        label115:
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Object[] { this.b, this.c, this.d, this.f, Integer.valueOf(this.g) });
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.h
 * JD-Core Version:    0.7.0.1
 */