package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;

public class u
{
  public static t a(SurfaceView paramSurfaceView, a parama, boolean paramBoolean, Context paramContext)
  {
    paramSurfaceView = new f(paramSurfaceView);
    paramSurfaceView.a(2);
    int j;
    int i;
    if (!paramBoolean)
    {
      j = 0;
      i = j;
    }
    else
    {
      i = 4;
      j = 1;
    }
    try
    {
      if (com.baidu.platform.comapi.util.f.a(8, 8, 8, 8, 24, 8)) {
        paramSurfaceView.a(8, 8, 8, 8, 24, 8, j, i);
      } else {
        paramSurfaceView.a(true);
      }
    }
    catch (IllegalArgumentException parama)
    {
      label83:
      break label83;
    }
    paramSurfaceView.a(true);
    paramSurfaceView.b(true);
    return paramSurfaceView;
  }
  
  public static enum a
  {
    static
    {
      a locala1 = new a("OPENGL_ES", 0);
      a = locala1;
      a locala2 = new a("VULKAN", 1);
      b = locala2;
      a locala3 = new a("AUTO", 2);
      c = locala3;
      d = new a[] { locala1, locala2, locala3 };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.u
 * JD-Core Version:    0.7.0.1
 */