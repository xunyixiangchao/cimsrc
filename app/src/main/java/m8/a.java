package m8;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import d2.v;
import e2.d;
import k2.e;

public abstract class a
  implements b2.l<Bitmap>
{
  public final v<Bitmap> a(Context paramContext, v<Bitmap> paramv, int paramInt1, int paramInt2)
  {
    if (x2.l.t(paramInt1, paramInt2))
    {
      d locald = c.c(paramContext).f();
      Bitmap localBitmap = (Bitmap)paramv.get();
      int i = paramInt1;
      if (paramInt1 == -2147483648) {
        i = localBitmap.getWidth();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == -2147483648) {
        paramInt1 = localBitmap.getHeight();
      }
      paramContext = d(paramContext.getApplicationContext(), locald, localBitmap, i, paramInt1);
      if (localBitmap.equals(paramContext)) {
        return paramv;
      }
      return e.f(paramContext, locald);
    }
    paramContext = new StringBuilder();
    paramContext.append("Cannot apply transformation on width: ");
    paramContext.append(paramInt1);
    paramContext.append(" or height: ");
    paramContext.append(paramInt2);
    paramContext.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  void c(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap2.setDensity(paramBitmap1.getDensity());
  }
  
  protected abstract Bitmap d(Context paramContext, d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m8.a
 * JD-Core Version:    0.7.0.1
 */