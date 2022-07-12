package k2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import d2.v;
import e2.d;
import java.util.concurrent.locks.Lock;

final class n
{
  private static final d a = new a();
  
  static v<Bitmap> a(d paramd, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = paramDrawable.getCurrent();
    boolean bool = paramDrawable instanceof BitmapDrawable;
    int i = 0;
    if (bool)
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      paramInt1 = i;
    }
    else if (!(paramDrawable instanceof Animatable))
    {
      paramDrawable = b(paramd, paramDrawable, paramInt1, paramInt2);
      paramInt1 = 1;
    }
    else
    {
      paramDrawable = null;
      paramInt1 = i;
    }
    if (paramInt1 == 0) {
      paramd = a;
    }
    return e.f(paramDrawable, paramd);
  }
  
  private static Bitmap b(d paramd, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -2147483648) && (paramDrawable.getIntrinsicWidth() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        paramd = new StringBuilder();
        paramd.append("Unable to draw ");
        paramd.append(paramDrawable);
        paramd.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        Log.w("DrawableToBitmap", paramd.toString());
      }
      return null;
    }
    if ((paramInt2 == -2147483648) && (paramDrawable.getIntrinsicHeight() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        paramd = new StringBuilder();
        paramd.append("Unable to draw ");
        paramd.append(paramDrawable);
        paramd.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
        Log.w("DrawableToBitmap", paramd.toString());
      }
      return null;
    }
    if (paramDrawable.getIntrinsicWidth() > 0) {
      paramInt1 = paramDrawable.getIntrinsicWidth();
    }
    if (paramDrawable.getIntrinsicHeight() > 0) {
      paramInt2 = paramDrawable.getIntrinsicHeight();
    }
    Lock localLock = z.f();
    localLock.lock();
    paramd = paramd.c(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    try
    {
      Canvas localCanvas = new Canvas(paramd);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(localCanvas);
      localCanvas.setBitmap(null);
      return paramd;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  class a
    extends e2.e
  {
    public void d(Bitmap paramBitmap) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.n
 * JD-Core Version:    0.7.0.1
 */