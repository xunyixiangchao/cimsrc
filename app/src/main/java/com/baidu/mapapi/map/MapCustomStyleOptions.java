package com.baidu.mapapi.map;

public class MapCustomStyleOptions
{
  private String a;
  private String b;
  
  public MapCustomStyleOptions customStyleId(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String getCustomMapStyleId()
  {
    return this.b;
  }
  
  public String getLocalCustomStyleFilePath()
  {
    return this.a;
  }
  
  public MapCustomStyleOptions localCustomStylePath(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapCustomStyleOptions
 * JD-Core Version:    0.7.0.1
 */