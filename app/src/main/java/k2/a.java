package k2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import b2.h;
import b2.j;
import d2.v;
import x2.k;

public class a<DataType>
  implements j<DataType, BitmapDrawable>
{
  private final j<DataType, Bitmap> a;
  private final Resources b;
  
  public a(Resources paramResources, j<DataType, Bitmap> paramj)
  {
    this.b = ((Resources)k.d(paramResources));
    this.a = ((j)k.d(paramj));
  }
  
  public v<BitmapDrawable> a(DataType paramDataType, int paramInt1, int paramInt2, h paramh)
  {
    paramDataType = this.a.a(paramDataType, paramInt1, paramInt2, paramh);
    return u.f(this.b, paramDataType);
  }
  
  public boolean b(DataType paramDataType, h paramh)
  {
    return this.a.b(paramDataType, paramh);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.a
 * JD-Core Version:    0.7.0.1
 */