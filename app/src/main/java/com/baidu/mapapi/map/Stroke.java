package com.baidu.mapapi.map;

import android.os.Bundle;

public final class Stroke
{
  public final int color;
  public final int strokeWidth;
  
  public Stroke(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 5;
    }
    this.strokeWidth = i;
    this.color = paramInt2;
  }
  
  Bundle a(Bundle paramBundle)
  {
    paramBundle.putInt("width", this.strokeWidth);
    Overlay.a(this.color, paramBundle);
    return paramBundle;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Stroke
 * JD-Core Version:    0.7.0.1
 */