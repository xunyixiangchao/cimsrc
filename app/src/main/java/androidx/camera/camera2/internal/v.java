package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.m1;
import androidx.camera.core.n1;
import androidx.camera.core.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.f;
import n.m0;
import n.z;
import s.d0;
import s.k0;

public final class v
  implements d0
{
  private final k0 a;
  private final s.j0 b;
  private final m0 c;
  private final List<String> d;
  private final x1 e;
  private final Map<String, j0> f = new HashMap();
  
  public v(Context paramContext, k0 paramk0, t paramt)
  {
    this.a = paramk0;
    this.b = new s.j0(1);
    this.c = m0.b(paramContext, paramk0.c());
    this.e = x1.b(paramContext);
    this.d = d(j1.b(this, paramt));
  }
  
  private List<String> d(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!str.equals("0")) && (!str.equals("1")) && (!g(str)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Camera ");
        localStringBuilder.append(str);
        localStringBuilder.append(" is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
        n1.a("Camera2CameraFactory", localStringBuilder.toString());
      }
      else
      {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  private boolean g(String paramString)
  {
    if ("robolectric".equals(Build.FINGERPRINT)) {
      return true;
    }
    try
    {
      paramString = (int[])this.c.c(paramString).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString[i] == 0) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (f paramString)
    {
      throw new m1(l1.a(paramString));
    }
  }
  
  public s.g0 a(String paramString)
  {
    if (this.d.contains(paramString)) {
      return new g0(this.c, paramString, e(paramString), this.b, this.a.b(), this.a.c(), this.e);
    }
    throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
  }
  
  public Set<String> c()
  {
    return new LinkedHashSet(this.d);
  }
  
  j0 e(String paramString)
  {
    try
    {
      j0 localj02 = (j0)this.f.get(paramString);
      j0 localj01 = localj02;
      if (localj02 == null)
      {
        localj01 = new j0(paramString, this.c);
        this.f.put(paramString, localj01);
      }
      return localj01;
    }
    catch (f paramString)
    {
      throw l1.a(paramString);
    }
  }
  
  public m0 f()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.v
 * JD-Core Version:    0.7.0.1
 */