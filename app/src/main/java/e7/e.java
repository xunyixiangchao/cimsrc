package e7;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public class e
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> b = new e();
  private final WeakHashMap<Drawable, Integer> a = new WeakHashMap();
  
  private e()
  {
    super(Integer.class, "drawableAlphaCompat");
  }
  
  public Integer a(Drawable paramDrawable)
  {
    return Integer.valueOf(paramDrawable.getAlpha());
  }
  
  public void b(Drawable paramDrawable, Integer paramInteger)
  {
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.e
 * JD-Core Version:    0.7.0.1
 */