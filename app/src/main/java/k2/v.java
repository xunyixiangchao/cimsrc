package k2;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import b2.h;
import b2.j;

public final class v
  implements j<ParcelFileDescriptor, Bitmap>
{
  private final m a;
  
  public v(m paramm)
  {
    this.a = paramm;
  }
  
  private boolean e(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    String str = Build.MANUFACTURER;
    if ((!"HUAWEI".equalsIgnoreCase(str)) && (!"HONOR".equalsIgnoreCase(str))) {
      return true;
    }
    return paramParcelFileDescriptor.getStatSize() <= 536870912L;
  }
  
  public d2.v<Bitmap> c(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, h paramh)
  {
    return this.a.d(paramParcelFileDescriptor, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(ParcelFileDescriptor paramParcelFileDescriptor, h paramh)
  {
    return (e(paramParcelFileDescriptor)) && (this.a.o(paramParcelFileDescriptor));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.v
 * JD-Core Version:    0.7.0.1
 */