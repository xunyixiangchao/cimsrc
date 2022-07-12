package i3;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.k;
import q2.e;
import q2.h;
import t2.i;

public class d
  extends k
{
  public d(com.bumptech.glide.c paramc, e parame, h paramh, Context paramContext)
  {
    super(paramc, parame, paramh, paramContext);
  }
  
  public c<Bitmap> A()
  {
    return (c)super.h();
  }
  
  public c<o2.c> B()
  {
    return (c)super.m();
  }
  
  protected void v(i parami)
  {
    if (!(parami instanceof b)) {
      parami = new b().r0(parami);
    }
    super.v(parami);
  }
  
  public <ResourceType> c<ResourceType> z(Class<ResourceType> paramClass)
  {
    return new c(this.a, this, paramClass, this.b);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i3.d
 * JD-Core Version:    0.7.0.1
 */