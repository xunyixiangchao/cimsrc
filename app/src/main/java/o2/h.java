package o2;

import android.graphics.Bitmap;
import b2.j;
import d2.v;
import e2.d;
import k2.e;
import z1.a;

public final class h
  implements j<a, Bitmap>
{
  private final d a;
  
  public h(d paramd)
  {
    this.a = paramd;
  }
  
  public v<Bitmap> c(a parama, int paramInt1, int paramInt2, b2.h paramh)
  {
    return e.f(parama.getNextFrame(), this.a);
  }
  
  public boolean d(a parama, b2.h paramh)
  {
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.h
 * JD-Core Version:    0.7.0.1
 */