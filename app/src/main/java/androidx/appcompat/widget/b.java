package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b
  extends Drawable
{
  final ActionBarContainer a;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.a = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.a;
    if (((ActionBarContainer)localObject).h)
    {
      localObject = ((ActionBarContainer)localObject).g;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else
    {
      localObject = ((ActionBarContainer)localObject).e;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = this.a;
      Drawable localDrawable = ((ActionBarContainer)localObject).f;
      if ((localDrawable != null) && (((ActionBarContainer)localObject).i)) {
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Object localObject = this.a;
    if (((ActionBarContainer)localObject).h)
    {
      localObject = ((ActionBarContainer)localObject).g;
      if (localObject == null) {
        return;
      }
    }
    else
    {
      localObject = ((ActionBarContainer)localObject).e;
      if (localObject == null) {
        return;
      }
    }
    ((Drawable)localObject).getOutline(paramOutline);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.b
 * JD-Core Version:    0.7.0.1
 */