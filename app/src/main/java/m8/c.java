package m8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import b2.f;
import e2.d;
import java.security.MessageDigest;

public class c
  extends a
{
  public void b(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update("jp.wasabeef.glide.transformations.GrayscaleTransformation.1".getBytes(f.a));
  }
  
  protected Bitmap d(Context paramContext, d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt1 = paramBitmap.getWidth();
    paramInt2 = paramBitmap.getHeight();
    if (paramBitmap.getConfig() != null) {
      paramContext = paramBitmap.getConfig();
    } else {
      paramContext = Bitmap.Config.ARGB_8888;
    }
    paramContext = paramd.c(paramInt1, paramInt2, paramContext);
    c(paramBitmap, paramContext);
    paramd = new Canvas(paramContext);
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    paramd.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return paramContext;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof c;
  }
  
  public int hashCode()
  {
    return -1580689316;
  }
  
  public String toString()
  {
    return "GrayscaleTransformation()";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m8.c
 * JD-Core Version:    0.7.0.1
 */