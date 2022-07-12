package e2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class e
  implements d
{
  public void a() {}
  
  public void b(int paramInt) {}
  
  public Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  public void d(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
  
  public Bitmap e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return c(paramInt1, paramInt2, paramConfig);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.e
 * JD-Core Version:    0.7.0.1
 */