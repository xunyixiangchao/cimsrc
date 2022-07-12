package k2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b2.f;
import b2.l;
import com.bumptech.glide.c;
import d2.v;
import e2.d;
import java.security.MessageDigest;

public class o
  implements l<Drawable>
{
  private final l<Bitmap> b;
  private final boolean c;
  
  public o(l<Bitmap> paraml, boolean paramBoolean)
  {
    this.b = paraml;
    this.c = paramBoolean;
  }
  
  private v<Drawable> d(Context paramContext, v<Bitmap> paramv)
  {
    return u.f(paramContext.getResources(), paramv);
  }
  
  public v<Drawable> a(Context paramContext, v<Drawable> paramv, int paramInt1, int paramInt2)
  {
    Object localObject2 = c.c(paramContext).f();
    Object localObject1 = (Drawable)paramv.get();
    localObject2 = n.a((d)localObject2, (Drawable)localObject1, paramInt1, paramInt2);
    if (localObject2 == null)
    {
      if (!this.c) {
        return paramv;
      }
      paramContext = new StringBuilder();
      paramContext.append("Unable to convert ");
      paramContext.append(localObject1);
      paramContext.append(" to a Bitmap");
      throw new IllegalArgumentException(paramContext.toString());
    }
    localObject1 = this.b.a(paramContext, (v)localObject2, paramInt1, paramInt2);
    if (localObject1.equals(localObject2))
    {
      ((v)localObject1).a();
      return paramv;
    }
    return d(paramContext, (v)localObject1);
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
  }
  
  public l<BitmapDrawable> c()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof o))
    {
      paramObject = (o)paramObject;
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
 * Qualified Name:     k2.o
 * JD-Core Version:    0.7.0.1
 */