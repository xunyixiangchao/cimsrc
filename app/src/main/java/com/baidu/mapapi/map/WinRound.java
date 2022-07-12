package com.baidu.mapapi.map;

public class WinRound
{
  public int bottom = 0;
  public int left = 0;
  public int right = 0;
  public int top = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinRound{left=");
    localStringBuilder.append(this.left);
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.right);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.top);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(this.bottom);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.WinRound
 * JD-Core Version:    0.7.0.1
 */