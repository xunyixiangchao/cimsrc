package u2;

import android.graphics.drawable.Drawable;
import t2.e;
import x2.l;

public abstract class c<T>
  implements h<T>
{
  private final int a;
  private final int b;
  private e c;
  
  public c()
  {
    this(-2147483648, -2147483648);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    if (l.t(paramInt1, paramInt2))
    {
      this.a = paramInt1;
      this.b = paramInt2;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" and height: ");
    localStringBuilder.append(paramInt2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void a() {}
  
  public final void b(g paramg) {}
  
  public void c(Drawable paramDrawable) {}
  
  public void d() {}
  
  public void g(Drawable paramDrawable) {}
  
  public final void i(g paramg)
  {
    paramg.e(this.a, this.b);
  }
  
  public final e j()
  {
    return this.c;
  }
  
  public final void l(e parame)
  {
    this.c = parame;
  }
  
  public void onDestroy() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u2.c
 * JD-Core Version:    0.7.0.1
 */