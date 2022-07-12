package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.e.d;
import com.baidu.location.e.f;
import com.baidu.location.e.h;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  private static String q = "BDLocConfigManager";
  public boolean a = false;
  public int b = 16;
  public double c = 0.75D;
  public int d = 0;
  public int e = 1;
  public double f = -0.1000000014901161D;
  public int g = 0;
  public int h = 1;
  public int i = 1;
  public int j = 10;
  public int k = 3;
  public int l = 40;
  public double[] m;
  public int n = 1;
  public int o = 0;
  public int p = 1;
  private SharedPreferences r = null;
  private long s = 300L;
  private String t = null;
  private a u = null;
  private boolean v = false;
  private String w = null;
  private String x = null;
  private String y = null;
  
  public static a a()
  {
    return b.a;
  }
  
  private void a(LocationClientOption paramLocationClientOption)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&ver=");
    ((StringBuilder)localObject1).append(h.x);
    ((StringBuilder)localObject1).append("&usr=");
    ((StringBuilder)localObject1).append(c());
    ((StringBuilder)localObject1).append("&app=");
    ((StringBuilder)localObject1).append(this.w);
    ((StringBuilder)localObject1).append("&prod=");
    ((StringBuilder)localObject1).append(paramLocationClientOption.prodName);
    ((StringBuilder)localObject1).append("&newwf=1");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = Build.VERSION.RELEASE;
    paramLocationClientOption = (LocationClientOption)localObject1;
    if (localObject1 != null)
    {
      paramLocationClientOption = (LocationClientOption)localObject1;
      if (((String)localObject1).length() > 6) {
        paramLocationClientOption = ((String)localObject1).substring(0, 6);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("&sv=");
    ((StringBuilder)localObject1).append(paramLocationClientOption);
    paramLocationClientOption = ((StringBuilder)localObject1).toString();
    localObject2 = h.c("ro.miui.ui.version.name");
    localObject1 = paramLocationClientOption;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLocationClientOption);
      ((StringBuilder)localObject1).append("&miui=");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = h.j();
    paramLocationClientOption = (LocationClientOption)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramLocationClientOption = new StringBuilder();
      paramLocationClientOption.append((String)localObject1);
      paramLocationClientOption.append("&mtk=");
      paramLocationClientOption.append((String)localObject2);
      paramLocationClientOption = paramLocationClientOption.toString();
    }
    localObject1 = this.r;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(q);
    ((StringBuilder)localObject2).append("_loc");
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    localObject1 = paramLocationClientOption;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLocationClientOption);
      ((StringBuilder)localObject1).append("&loc=");
      ((StringBuilder)localObject1).append(new String(Base64.decode((String)localObject2, 0), "UTF-8"));
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.u == null) {
        this.u = new a();
      }
      this.u.a((String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LocationClientOption localLocationClientOption = paramLocationClientOption;
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((localJSONObject.has("is_check_Per")) && (localJSONObject.getInt("is_check_Per") > 0)) {
        this.a = true;
      }
      if (localJSONObject.has("wfnum")) {
        this.b = localJSONObject.getInt("wfnum");
      }
      if (localJSONObject.has("freq")) {
        this.s = localJSONObject.getLong("freq");
      }
      if (localJSONObject.has("wfsm")) {
        this.c = localJSONObject.getDouble("wfsm");
      }
      if (localJSONObject.has("idmoc")) {
        this.d = localJSONObject.getInt("idmoc");
      }
      if (localJSONObject.has("gnmcrm")) {
        this.f = localJSONObject.getDouble("gnmcrm");
      }
      if (localJSONObject.has("gnmcon")) {
        this.g = localJSONObject.getInt("gnmcon");
      }
      if (localJSONObject.has("lpcs")) {
        this.e = localJSONObject.getInt("lpcs");
      }
      if (localJSONObject.has("iupl")) {
        this.h = localJSONObject.getInt("iupl");
      }
      if (localJSONObject.has("opetco")) {
        this.i = localJSONObject.getInt("opetco");
      }
      if (localJSONObject.has("ct")) {
        this.j = localJSONObject.getInt("ct");
      }
      if (localJSONObject.has("suci")) {
        this.k = localJSONObject.getInt("suci");
      }
      if (localJSONObject.has("smn")) {
        this.l = localJSONObject.getInt("smn");
      }
      if (localJSONObject.has("bcar")) {
        a(localJSONObject);
      }
      if (localJSONObject.has("ums")) {
        this.n = localJSONObject.getInt("ums");
      }
      if (localJSONObject.has("hpdts")) {
        this.o = localJSONObject.getInt("hpdts");
      }
      if (localJSONObject.has("oldts")) {
        this.p = localJSONObject.getInt("oldts");
      }
      this.t = paramString;
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v9.303|");
    localStringBuilder.append(this.x);
    localStringBuilder.append("|");
    String str = Build.MODEL;
    localStringBuilder.append(str);
    localStringBuilder.append("&cu=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("&mb=");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void a(double paramDouble1, double paramDouble2, String paramString)
  {
    Object localObject;
    double d2;
    double d1;
    StringBuilder localStringBuilder;
    label196:
    label201:
    try
    {
      localObject = this.y;
      if ((localObject != null) || (paramString == null)) {}
    }
    finally {}
    try
    {
      if (!paramString.equals("bd09"))
      {
        d2 = paramDouble1;
        d1 = paramDouble2;
        if (!paramString.equals("wgs84mc")) {}
      }
      else
      {
        paramString = Jni.coorEncrypt(paramDouble2, paramDouble1, "bd092gcj");
        paramDouble1 = paramString[1];
        d1 = paramString[0];
        d2 = paramDouble1;
      }
      paramString = String.format(Locale.US, "%.5f|%.5f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
      this.y = paramString;
      paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 0);
      if (paramString == null) {
        break label201;
      }
      localObject = this.r;
      if (localObject == null) {
        break label201;
      }
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(q);
      localStringBuilder.append("_loc");
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
      ((SharedPreferences.Editor)localObject).apply();
    }
    catch (Exception paramString)
    {
      break label196;
    }
    this.y = null;
  }
  
  public void a(Context paramContext, LocationClientOption paramLocationClientOption, String paramString)
  {
    label59:
    try
    {
      if ((!this.v) && (paramContext != null))
      {
        this.v = true;
        paramString = paramLocationClientOption;
        if (paramLocationClientOption == null) {
          paramString = new LocationClientOption();
        }
        this.w = paramContext.getPackageName();
      }
    }
    finally {}
    try
    {
      this.x = LBSAuthManager.getInstance(paramContext).getCUID();
      break label59;
    }
    finally {}
    this.x = null;
    if (this.r == null)
    {
      paramLocationClientOption = new StringBuilder();
      paramLocationClientOption.append(q);
      paramLocationClientOption.append("BDLocConfig");
      this.r = paramContext.getSharedPreferences(paramLocationClientOption.toString(), 0);
    }
    paramContext = this.r;
    if (paramContext != null)
    {
      paramLocationClientOption = new StringBuilder();
      paramLocationClientOption.append(q);
      paramLocationClientOption.append("_lastCheckTime");
      long l1 = paramContext.getLong(paramLocationClientOption.toString(), 0L);
      paramContext = this.r;
      paramLocationClientOption = new StringBuilder();
      paramLocationClientOption.append(q);
      paramLocationClientOption.append("_config");
      paramContext = paramContext.getString(paramLocationClientOption.toString(), "");
      paramLocationClientOption = this.r;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(q);
      localStringBuilder.append("_newConfig");
      paramLocationClientOption = paramLocationClientOption.getString(localStringBuilder.toString(), "");
      if (!TextUtils.isEmpty(paramLocationClientOption))
      {
        a(new String(h.b(Base64.decode(paramLocationClientOption, 0))));
      }
      else if (!TextUtils.isEmpty(paramContext))
      {
        a(paramContext);
        paramContext = this.r.edit();
        paramLocationClientOption = new StringBuilder();
        paramLocationClientOption.append(q);
        paramLocationClientOption.append("_config");
        paramContext.remove(paramLocationClientOption.toString());
        paramContext.apply();
      }
      if (Math.abs(System.currentTimeMillis() / 1000L - l1) > this.s)
      {
        l1 = System.currentTimeMillis() / 1000L;
        paramContext = this.r.edit();
        paramLocationClientOption = new StringBuilder();
        paramLocationClientOption.append(q);
        paramLocationClientOption.append("_lastCheckTime");
        paramContext.putLong(paramLocationClientOption.toString(), l1);
        paramContext.apply();
        a(paramString);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    double[] arrayOfDouble;
    if (paramJSONObject != null)
    {
      arrayOfDouble = this.m;
      if ((arrayOfDouble != null) && (arrayOfDouble.length > 0)) {
        this.m = null;
      }
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("bcar"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("bcar");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            if (this.m != null) {
              break label197;
            }
            this.m = new double[paramJSONObject.length() * 4];
            break label197;
            if (i1 < paramJSONObject.length())
            {
              arrayOfDouble = this.m;
              int i3 = i2 + 1;
              arrayOfDouble[i2] = paramJSONObject.getJSONObject(i1).getDouble("x1");
              arrayOfDouble = this.m;
              i2 = i3 + 1;
              arrayOfDouble[i3] = paramJSONObject.getJSONObject(i1).getDouble("y1");
              arrayOfDouble = this.m;
              i3 = i2 + 1;
              arrayOfDouble[i2] = paramJSONObject.getJSONObject(i1).getDouble("x2");
              this.m[i3] = paramJSONObject.getJSONObject(i1).getDouble("y2");
              i1 += 1;
              i2 = i3 + 1;
              continue;
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      label197:
      int i1 = 0;
      int i2 = 0;
    }
  }
  
  class a
    extends f
  {
    String a = null;
    boolean b = false;
    
    public a()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      this.h = 2;
      String str = Jni.encode(this.a);
      this.a = null;
      this.j.put("qt", "conf");
      this.j.put("req", str);
    }
    
    public void a(String paramString)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      this.a = paramString;
      b(d.d);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.i != null)) {
        try
        {
          new JSONObject(this.i);
          if (a.a(a.this) != null)
          {
            SharedPreferences.Editor localEditor = a.a(a.this).edit();
            String str = Base64.encodeToString(h.a(this.i.getBytes()), 0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(a.b());
            localStringBuilder.append("_newConfig");
            localEditor.putString(localStringBuilder.toString(), str);
            localEditor.apply();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Map localMap = this.j;
      if (localMap != null) {
        localMap.clear();
      }
      this.b = false;
    }
  }
  
  private static class b
  {
    public static final a a = new a(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.a
 * JD-Core Version:    0.7.0.1
 */