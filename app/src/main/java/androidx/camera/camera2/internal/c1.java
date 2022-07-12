package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Size;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.m0;
import s.a;
import s.c0;
import s.l2;
import s.t2;
import x0.h;

public final class c1
  implements c0
{
  private final Map<String, k2> a = new HashMap();
  private final c b;
  
  c1(Context paramContext, c paramc, Object paramObject, Set<String> paramSet)
  {
    h.g(paramc);
    this.b = paramc;
    if ((paramObject instanceof m0)) {
      paramc = (m0)paramObject;
    } else {
      paramc = m0.a(paramContext);
    }
    c(paramContext, paramc, paramSet);
  }
  
  public c1(Context paramContext, Object paramObject, Set<String> paramSet)
  {
    this(paramContext, new a(), paramObject, paramSet);
  }
  
  private void c(Context paramContext, m0 paramm0, Set<String> paramSet)
  {
    h.g(paramContext);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.a.put(str, new k2(paramContext, str, paramm0, this.b));
    }
  }
  
  public l2 a(String paramString, int paramInt, Size paramSize)
  {
    paramString = (k2)this.a.get(paramString);
    if (paramString != null) {
      return paramString.L(paramInt, paramSize);
    }
    return null;
  }
  
  public Map<t2<?>, Size> b(String paramString, List<a> paramList, List<t2<?>> paramList1)
  {
    h.b(paramList1.isEmpty() ^ true, "No new use cases to be bound.");
    k2 localk2 = (k2)this.a.get(paramString);
    if (localk2 != null) {
      return localk2.y(paramList, paramList1);
    }
    paramList = new StringBuilder();
    paramList.append("No such camera id in supported combination list: ");
    paramList.append(paramString);
    throw new IllegalArgumentException(paramList.toString());
  }
  
  class a
    implements c
  {
    public CamcorderProfile a(int paramInt1, int paramInt2)
    {
      return CamcorderProfile.get(paramInt1, paramInt2);
    }
    
    public boolean b(int paramInt1, int paramInt2)
    {
      return CamcorderProfile.hasProfile(paramInt1, paramInt2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.c1
 * JD-Core Version:    0.7.0.1
 */