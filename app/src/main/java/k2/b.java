package k2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import b2.c;
import b2.h;
import b2.k;
import d2.v;
import java.io.File;

public class b
  implements k<BitmapDrawable>
{
  private final e2.d a;
  private final k<Bitmap> b;
  
  public b(e2.d paramd, k<Bitmap> paramk)
  {
    this.a = paramd;
    this.b = paramk;
  }
  
  public c b(h paramh)
  {
    return this.b.b(paramh);
  }
  
  public boolean c(v<BitmapDrawable> paramv, File paramFile, h paramh)
  {
    return this.b.a(new e(((BitmapDrawable)paramv.get()).getBitmap(), this.a), paramFile, paramh);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.b
 * JD-Core Version:    0.7.0.1
 */