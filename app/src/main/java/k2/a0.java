package k2;

import android.graphics.Bitmap;
import b2.h;
import b2.j;
import d2.v;
import x2.l;

public final class a0
  implements j<Bitmap, Bitmap>
{
  public v<Bitmap> c(Bitmap paramBitmap, int paramInt1, int paramInt2, h paramh)
  {
    return new a(paramBitmap);
  }
  
  public boolean d(Bitmap paramBitmap, h paramh)
  {
    return true;
  }
  
  private static final class a
    implements v<Bitmap>
  {
    private final Bitmap a;
    
    a(Bitmap paramBitmap)
    {
      this.a = paramBitmap;
    }
    
    public void a() {}
    
    public Bitmap b()
    {
      return this.a;
    }
    
    public int c()
    {
      return l.h(this.a);
    }
    
    public Class<Bitmap> d()
    {
      return Bitmap.class;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.a0
 * JD-Core Version:    0.7.0.1
 */