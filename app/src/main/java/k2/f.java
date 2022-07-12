package k2;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import d2.v;
import e2.d;

public abstract class f
  implements b2.l<Bitmap>
{
  public final v<Bitmap> a(Context paramContext, v<Bitmap> paramv, int paramInt1, int paramInt2)
  {
    if (x2.l.t(paramInt1, paramInt2))
    {
      paramContext = c.c(paramContext).f();
      Bitmap localBitmap1 = (Bitmap)paramv.get();
      int i = paramInt1;
      if (paramInt1 == -2147483648) {
        i = localBitmap1.getWidth();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == -2147483648) {
        paramInt1 = localBitmap1.getHeight();
      }
      Bitmap localBitmap2 = c(paramContext, localBitmap1, i, paramInt1);
      if (localBitmap1.equals(localBitmap2)) {
        return paramv;
      }
      return e.f(localBitmap2, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("Cannot apply transformation on width: ");
    paramContext.append(paramInt1);
    paramContext.append(" or height: ");
    paramContext.append(paramInt2);
    paramContext.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  protected abstract Bitmap c(d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.f
 * JD-Core Version:    0.7.0.1
 */