package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a.a;
import com.baidu.platform.comapi.util.a.b;
import com.baidu.vi.VIContext;

public class SysOSUtil
{
  private static SysOSUtil g = new SysOSUtil();
  private b a = null;
  private a b = null;
  private boolean c = false;
  private String d = "";
  private String e = "";
  private String f = "";
  
  public static SysOSUtil getInstance()
  {
    return g;
  }
  
  public String getCompatibleSdcardPath()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.a();
    }
    return "";
  }
  
  public float getDensity()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.a();
    }
    return 1.0F;
  }
  
  public int getDensityDPI()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.b();
    }
    return 1;
  }
  
  public String getExternalFilesDir()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.b();
    }
    return "";
  }
  
  public String getGLRenderer()
  {
    return this.f;
  }
  
  public String getGLVersion()
  {
    return this.e;
  }
  
  public String getNetType()
  {
    return this.d;
  }
  
  public String getOutputCache()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.c();
    }
    return "";
  }
  
  public String getOutputDirPath()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.d();
    }
    return "";
  }
  
  public int getScreenHeight()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.c();
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.d();
    }
    return 0;
  }
  
  public String getSdcardPath()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.e();
    }
    return "";
  }
  
  public void init(b paramb, a parama)
  {
    if (!this.c)
    {
      this.a = paramb;
      this.b = parama;
      if (paramb == null) {
        this.a = new b();
      }
      if (parama == null) {
        this.b = new a();
      }
      this.a.a(VIContext.getContext());
      this.b.a(VIContext.getContext());
      this.d = NetworkUtil.getCurrentNetMode(VIContext.getContext());
      this.c = true;
    }
  }
  
  public void setGLInfo(String paramString1, String paramString2)
  {
    if ((!this.f.equals(paramString2)) || (!this.e.equals(paramString1)))
    {
      this.e = paramString1;
      this.f = paramString2;
    }
  }
  
  public void updateNetType(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.SysOSUtil
 * JD-Core Version:    0.7.0.1
 */