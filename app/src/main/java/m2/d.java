package m2;

import android.graphics.drawable.Drawable;
import d2.v;

final class d
  extends c<Drawable>
{
  private d(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  static v<Drawable> f(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      return new d(paramDrawable);
    }
    return null;
  }
  
  public void a() {}
  
  public int c()
  {
    return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
  }
  
  public Class<Drawable> d()
  {
    return this.a.getClass();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m2.d
 * JD-Core Version:    0.7.0.1
 */