package d0;

import android.hardware.camera2.CaptureRequest.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class h
{
  private int a = 1;
  private Map<CaptureRequest.Key<?>, Object> b = new HashMap();
  private List<e> c = new ArrayList();
  
  h a(e parame)
  {
    this.c.add(parame);
    return this;
  }
  
  <T> h b(CaptureRequest.Key<T> paramKey, T paramT)
  {
    this.b.put(paramKey, paramT);
    return this;
  }
  
  g c()
  {
    return new a(this.a, this.b, this.c);
  }
  
  h d(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  private static class a
    implements g
  {
    private final int a;
    private final Map<CaptureRequest.Key<?>, Object> b;
    private final List<e> c;
    
    a(int paramInt, Map<CaptureRequest.Key<?>, Object> paramMap, List<e> paramList)
    {
      this.a = paramInt;
      this.b = paramMap;
      this.c = paramList;
    }
    
    public Map<CaptureRequest.Key<?>, Object> a()
    {
      return this.b;
    }
    
    public int b()
    {
      return this.a;
    }
    
    public List<e> c()
    {
      return this.c;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.h
 * JD-Core Version:    0.7.0.1
 */