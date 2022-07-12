package com.baidu.mapapi.map;

public enum MapLanguage
{
  static
  {
    MapLanguage localMapLanguage1 = new MapLanguage("CHINESE", 0);
    CHINESE = localMapLanguage1;
    MapLanguage localMapLanguage2 = new MapLanguage("ENGLISH", 1);
    ENGLISH = localMapLanguage2;
    a = new MapLanguage[] { localMapLanguage1, localMapLanguage2 };
  }
  
  private MapLanguage() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapLanguage
 * JD-Core Version:    0.7.0.1
 */