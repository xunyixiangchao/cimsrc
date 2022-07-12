package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.camera.core.impl.utils.b;
import androidx.camera.core.j3;
import androidx.camera.core.n1;
import androidx.camera.core.u;
import androidx.camera.core.u.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import n.f;
import n.m0;
import n.z;
import p.g;
import s.c2;
import s.e0;
import s.j;
import s.k;

public final class j0
  implements e0
{
  private final String a;
  private final z b;
  private final r.h c;
  private final Object d = new Object();
  private t e;
  private a<Integer> f = null;
  private a<j3> g = null;
  private final a<u> h;
  private List<Pair<k, Executor>> i = null;
  private final c2 j;
  private final j k;
  private final m0 l;
  
  j0(String paramString, m0 paramm0)
  {
    String str = (String)x0.h.g(paramString);
    this.a = str;
    this.l = paramm0;
    paramm0 = paramm0.c(str);
    this.b = paramm0;
    this.c = new r.h(this);
    this.j = g.a(paramString, paramm0);
    this.k = new d(paramString, paramm0);
    this.h = new a(u.a(u.b.e));
  }
  
  private void n()
  {
    o();
  }
  
  private void o()
  {
    int m = l();
    Object localObject;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Unknown value: ");
              ((StringBuilder)localObject).append(m);
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
            }
          }
          else {
            localObject = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
          }
        }
        else {
          localObject = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        }
      }
      else {
        localObject = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
      }
    }
    else {
      localObject = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Device Level: ");
    localStringBuilder.append((String)localObject);
    n1.e("Camera2CameraInfo", localStringBuilder.toString());
  }
  
  public Integer a()
  {
    Integer localInteger = (Integer)this.b.a(CameraCharacteristics.LENS_FACING);
    x0.h.g(localInteger);
    int m = localInteger.intValue();
    if (m != 0)
    {
      if (m != 1) {
        return null;
      }
      return Integer.valueOf(1);
    }
    return Integer.valueOf(0);
  }
  
  public void b(Executor paramExecutor, k paramk)
  {
    synchronized (this.d)
    {
      t localt = this.e;
      if (localt == null)
      {
        if (this.i == null) {
          this.i = new ArrayList();
        }
        this.i.add(new Pair(paramk, paramExecutor));
        return;
      }
      localt.t(paramExecutor, paramk);
      return;
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  public String d()
  {
    if (l() == 2) {
      return "androidx.camera.camera2.legacy";
    }
    return "androidx.camera.camera2";
  }
  
  public int e(int paramInt)
  {
    int m = k();
    paramInt = b.b(paramInt);
    Integer localInteger = a();
    boolean bool = true;
    if ((localInteger == null) || (1 != localInteger.intValue())) {
      bool = false;
    }
    return b.a(paramInt, Integer.valueOf(m).intValue(), bool);
  }
  
  public c2 f()
  {
    return this.j;
  }
  
  public void g(k paramk)
  {
    synchronized (this.d)
    {
      Object localObject2 = this.e;
      if (localObject2 == null)
      {
        localObject2 = this.i;
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((Pair)((Iterator)localObject2).next()).first == paramk) {
            ((Iterator)localObject2).remove();
          }
        }
        return;
      }
      ((t)localObject2).X(paramk);
      return;
    }
  }
  
  public r.h h()
  {
    return this.c;
  }
  
  public z i()
  {
    return this.b;
  }
  
  public Map<String, CameraCharacteristics> j()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(this.a, this.b.d());
    Iterator localIterator = this.b.b().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Objects.equals(str, this.a)) {
        try
        {
          localLinkedHashMap.put(str, this.l.c(str).d());
        }
        catch (f localf)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to get CameraCharacteristics for cameraId ");
          localStringBuilder.append(str);
          n1.d("Camera2CameraInfo", localStringBuilder.toString(), localf);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  int k()
  {
    Integer localInteger = (Integer)this.b.a(CameraCharacteristics.SENSOR_ORIENTATION);
    x0.h.g(localInteger);
    return localInteger.intValue();
  }
  
  int l()
  {
    Integer localInteger = (Integer)this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    x0.h.g(localInteger);
    return localInteger.intValue();
  }
  
  void m(t paramt)
  {
    synchronized (this.d)
    {
      this.e = paramt;
      Object localObject2 = this.g;
      if (localObject2 != null) {
        ((a)localObject2).r(paramt.F().d());
      }
      paramt = this.f;
      if (paramt != null) {
        paramt.r(this.e.D().f());
      }
      paramt = this.i;
      if (paramt != null)
      {
        paramt = paramt.iterator();
        while (paramt.hasNext())
        {
          localObject2 = (Pair)paramt.next();
          this.e.t((Executor)((Pair)localObject2).second, (k)((Pair)localObject2).first);
        }
        this.i = null;
      }
      n();
      return;
    }
  }
  
  void p(LiveData<u> paramLiveData)
  {
    this.h.r(paramLiveData);
  }
  
  static class a<T>
    extends p<T>
  {
    private LiveData<T> m;
    private T n;
    
    a(T paramT)
    {
      this.n = paramT;
    }
    
    public T f()
    {
      LiveData localLiveData = this.m;
      if (localLiveData == null) {
        return this.n;
      }
      return localLiveData.f();
    }
    
    void r(LiveData<T> paramLiveData)
    {
      LiveData localLiveData = this.m;
      if (localLiveData != null) {
        super.q(localLiveData);
      }
      this.m = paramLiveData;
      super.p(paramLiveData, new i0(this));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.j0
 * JD-Core Version:    0.7.0.1
 */