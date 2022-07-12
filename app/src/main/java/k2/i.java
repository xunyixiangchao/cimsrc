package k2;

import android.graphics.Bitmap;
import e2.d;
import java.security.MessageDigest;

public class i
  extends f
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(b2.f.a);
  
  public void b(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
  }
  
  protected Bitmap c(d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return z.b(paramd, paramBitmap, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof i;
  }
  
  public int hashCode()
  {
    return -599754482;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.i
 * JD-Core Version:    0.7.0.1
 */