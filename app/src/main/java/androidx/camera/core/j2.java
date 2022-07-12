package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

final class j2
  extends j0
{
  private final d1 c;
  private Rect d;
  private final int e;
  private final int f;
  
  j2(e1 parame1, Size paramSize, d1 paramd1)
  {
    super(parame1);
    int i;
    if (paramSize == null)
    {
      this.e = super.getWidth();
      i = super.getHeight();
    }
    else
    {
      this.e = paramSize.getWidth();
      i = paramSize.getHeight();
    }
    this.f = i;
    this.c = paramd1;
  }
  
  j2(e1 parame1, d1 paramd1)
  {
    this(parame1, null, paramd1);
  }
  
  public Rect C()
  {
    try
    {
      if (this.d == null)
      {
        localRect = new Rect(0, 0, getWidth(), getHeight());
        return localRect;
      }
      Rect localRect = new Rect(this.d);
      return localRect;
    }
    finally {}
  }
  
  public int getHeight()
  {
    try
    {
      int i = this.f;
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
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void n(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect != null) {}
    label54:
    for (;;)
    {
      try
      {
        localRect = new Rect(paramRect);
        if (localRect.intersect(0, 0, getWidth(), getHeight())) {
          break label54;
        }
        localRect.setEmpty();
      }
      finally {}
      this.d = localRect;
      return;
    }
  }
  
  public d1 q()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.j2
 * JD-Core Version:    0.7.0.1
 */