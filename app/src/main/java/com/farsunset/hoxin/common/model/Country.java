package com.farsunset.hoxin.common.model;

import android.app.Application;
import com.farsunset.hoxin.HoxinApplication;
import g0.a;
import g0.g;
import java.io.Serializable;

public class Country
  implements Serializable
{
  private static final transient a<String, Integer> ICON_MAP;
  public static final Country NORMAL;
  public String code;
  public int icon;
  public String id;
  public String name;
  
  static
  {
    Country localCountry = new Country();
    NORMAL = localCountry;
    a locala = new a();
    ICON_MAP = locala;
    localCountry.code = "+86";
    localCountry.id = "CN";
    localCountry.icon = 2131165472;
    localCountry.name = HoxinApplication.h().getString(2131689786);
    locala.put("CN", Integer.valueOf(2131165472));
    locala.put("HK", Integer.valueOf(2131165473));
    locala.put("TW", Integer.valueOf(2131165475));
    locala.put("MO", Integer.valueOf(2131165474));
    locala.put("AU", Integer.valueOf(2131165468));
    locala.put("BE", Integer.valueOf(2131165469));
    locala.put("BR", Integer.valueOf(2131165470));
    locala.put("CA", Integer.valueOf(2131165471));
    locala.put("DE", Integer.valueOf(2131165476));
    locala.put("ES", Integer.valueOf(2131165477));
    locala.put("FR", Integer.valueOf(2131165478));
    locala.put("GB", Integer.valueOf(2131165479));
    locala.put("ID", Integer.valueOf(2131165480));
    locala.put("IN", Integer.valueOf(2131165481));
    locala.put("IT", Integer.valueOf(2131165482));
    locala.put("JP", Integer.valueOf(2131165483));
    locala.put("KR", Integer.valueOf(2131165484));
    locala.put("MX", Integer.valueOf(2131165485));
    locala.put("MY", Integer.valueOf(2131165486));
    locala.put("NZ", Integer.valueOf(2131165487));
    locala.put("PH", Integer.valueOf(2131165488));
    locala.put("RU", Integer.valueOf(2131165489));
    locala.put("SE", Integer.valueOf(2131165490));
    locala.put("SG", Integer.valueOf(2131165491));
    locala.put("TH", Integer.valueOf(2131165492));
    locala.put("US", Integer.valueOf(2131165493));
    locala.put("VN", Integer.valueOf(2131165494));
  }
  
  public static int getIcon(String paramString)
  {
    return ((Integer)ICON_MAP.getOrDefault(paramString, Integer.valueOf(NORMAL.icon))).intValue();
  }
  
  public String format(String paramString)
  {
    return paramString.replace(this.code, "");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.Country
 * JD-Core Version:    0.7.0.1
 */