package o2;

import android.content.Context;
import android.graphics.Bitmap;
import b2.l;
import d2.v;
import e2.d;
import java.security.MessageDigest;
import k2.e;
import x2.k;

public class f
  implements l<c>
{
  private final l<Bitmap> b;
  
  public f(l<Bitmap> paraml)
  {
    this.b = ((l)k.d(paraml));
  }
  
  public v<c> a(Context paramContext, v<c> paramv, int paramInt1, int paramInt2)
  {
    c localc = (c)paramv.get();
    Object localObject = com.bumptech.glide.c.c(paramContext).f();
    localObject = new e(localc.e(), (d)localObject);
    paramContext = this.b.a(paramContext, (v)localObject, paramInt1, paramInt2);
    if (!localObject.equals(paramContext)) {
      ((v)localObject).a();
    }
    paramContext = (Bitmap)paramContext.get();
    localc.m(this.b, paramContext);
    return paramv;
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.f
 * JD-Core Version:    0.7.0.1
 */