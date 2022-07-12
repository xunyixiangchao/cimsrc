package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

abstract class j0
  implements e1
{
  protected final e1 a;
  private final Set<a> b = new HashSet();
  
  protected j0(e1 parame1)
  {
    this.a = parame1;
  }
  
  public Rect C()
  {
    try
    {
      Rect localRect = this.a.C();
      return localRect;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Image J()
  {
    try
    {
      Image localImage = this.a.J();
      return localImage;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(a parama)
  {
    try
    {
      this.b.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      g();
      return;
    }
    finally {}
  }
  
  protected void g()
  {
    try
    {
      Object localObject1 = new HashSet(this.b);
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  public int getFormat()
  {
    try
    {
      int i = this.a.getFormat();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getHeight()
  {
    try
    {
      int i = this.a.getHeight();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getWidth()
  {
    try
    {
      int i = this.a.getWidth();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public e1.a[] j()
  {
    try
    {
      e1.a[] arrayOfa = this.a.j();
      return arrayOfa;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void n(Rect paramRect)
  {
    try
    {
      this.a.n(paramRect);
      return;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  public d1 q()
  {
    try
    {
      d1 locald1 = this.a.q();
      return locald1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(e1 parame1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.j0
 * JD-Core Version:    0.7.0.1
 */