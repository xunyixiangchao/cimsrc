package com.baidu.platform.comapi.c;

import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  private NALogStatistics a = null;
  private ArrayList<b> b = new ArrayList();
  
  private c()
  {
    b();
  }
  
  public static c a()
  {
    return b.a();
  }
  
  private boolean b()
  {
    if (this.a == null) {
      this.a = new NALogStatistics();
    }
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      if ((com.baidu.platform.comapi.b.e()) || (com.baidu.platform.comapi.b.d())) {
        a(new a(paramInt1, paramInt2, paramString1, paramString2));
      }
      return this.a.a(paramInt1, paramInt2, SysOSUtil.getInstance().getNetType(), paramString1, paramString2);
    }
    return false;
  }
  
  public boolean a(a parama)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(parama);
      }
    }
    return false;
  }
  
  private static class b
  {
    private static final c a = new c(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.c.c
 * JD-Core Version:    0.7.0.1
 */