package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class x
{
  private final Map<String, Object> a = new HashMap();
  private volatile boolean b = false;
  
  private static void b(Object paramObject)
  {
    if ((paramObject instanceof Closeable)) {
      try
      {
        ((Closeable)paramObject).close();
        return;
      }
      catch (IOException paramObject)
      {
        throw new RuntimeException(paramObject);
      }
    }
  }
  
  final void a()
  {
    this.b = true;
    Map localMap = this.a;
    if (localMap != null) {
      try
      {
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext()) {
          b(localIterator.next());
        }
      }
      finally {}
    }
    d();
  }
  
  <T> T c(String paramString)
  {
    Map localMap = this.a;
    if (localMap == null) {
      return null;
    }
    try
    {
      paramString = this.a.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  protected void d() {}
  
  <T> T e(String paramString, T paramT)
  {
    synchronized (this.a)
    {
      Object localObject = this.a.get(paramString);
      if (localObject == null) {
        this.a.put(paramString, paramT);
      }
      if (localObject == null) {
        paramString = paramT;
      } else {
        paramString = localObject;
      }
      if (this.b) {
        b(paramString);
      }
      return paramString;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.x
 * JD-Core Version:    0.7.0.1
 */