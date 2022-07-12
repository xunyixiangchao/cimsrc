package k2;

import android.graphics.Bitmap;
import b2.h;
import b2.j;
import d2.v;
import e2.b;
import java.io.IOException;
import java.io.InputStream;
import x2.i;

public class y
  implements j<InputStream, Bitmap>
{
  private final m a;
  private final b b;
  
  public y(m paramm, b paramb)
  {
    this.a = paramm;
    this.b = paramb;
  }
  
  public v<Bitmap> c(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
  {
    int i;
    if ((paramInputStream instanceof w))
    {
      paramInputStream = (w)paramInputStream;
      i = 0;
    }
    else
    {
      paramInputStream = new w(paramInputStream, this.b);
      i = 1;
    }
    x2.d locald = x2.d.g(paramInputStream);
    i locali = new i(locald);
    a locala = new a(paramInputStream, locald);
    try
    {
      paramh = this.a.e(locali, paramInt1, paramInt2, paramh, locala);
      return paramh;
    }
    finally
    {
      locald.h();
      if (i != 0) {
        paramInputStream.h();
      }
    }
  }
  
  public boolean d(InputStream paramInputStream, h paramh)
  {
    return this.a.p(paramInputStream);
  }
  
  static class a
    implements m.b
  {
    private final w a;
    private final x2.d b;
    
    a(w paramw, x2.d paramd)
    {
      this.a = paramw;
      this.b = paramd;
    }
    
    public void a(e2.d paramd, Bitmap paramBitmap)
    {
      IOException localIOException = this.b.a();
      if (localIOException != null)
      {
        if (paramBitmap != null) {
          paramd.d(paramBitmap);
        }
        throw localIOException;
      }
    }
    
    public void b()
    {
      this.a.g();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.y
 * JD-Core Version:    0.7.0.1
 */