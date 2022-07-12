package m2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import d2.r;
import d2.v;
import x2.k;

public abstract class c<T extends Drawable>
  implements v<T>, r
{
  protected final T a;
  
  public c(T paramT)
  {
    this.a = ((Drawable)k.d(paramT));
  }
  
  public void b()
  {
    Object localObject = this.a;
    if ((localObject instanceof BitmapDrawable)) {}
    for (localObject = ((BitmapDrawable)localObject).getBitmap();; localObject = ((o2.c)localObject).e())
    {
      ((Bitmap)localObject).prepareToDraw();
      return;
      if (!(localObject instanceof o2.c)) {
        break;
      }
    }
  }
  
  public final T e()
  {
    Drawable.ConstantState localConstantState = this.a.getConstantState();
    if (localConstantState == null) {
      return this.a;
    }
    return localConstantState.newDrawable();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m2.c
 * JD-Core Version:    0.7.0.1
 */