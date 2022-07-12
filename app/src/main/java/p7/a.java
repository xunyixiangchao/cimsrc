package p7;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import r7.h;
import r7.m;
import r7.p;

public class a
  extends Drawable
  implements p
{
  private b a;
  
  private a(b paramb)
  {
    this.a = paramb;
  }
  
  public a(m paramm)
  {
    this(new b(new h(paramm)));
  }
  
  public a a()
  {
    this.a = new b(this.a);
    return this;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b localb = this.a;
    if (localb.b) {
      localb.a.draw(paramCanvas);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return this.a.a.getOpacity();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.a.setBounds(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    if (this.a.a.setState(paramArrayOfInt)) {
      bool1 = true;
    }
    boolean bool2 = b.e(paramArrayOfInt);
    paramArrayOfInt = this.a;
    if (paramArrayOfInt.b != bool2)
    {
      paramArrayOfInt.b = bool2;
      return true;
    }
    return bool1;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.a.setColorFilter(paramColorFilter);
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    this.a.a.setShapeAppearanceModel(paramm);
  }
  
  public void setTint(int paramInt)
  {
    this.a.a.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.a.a.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.a.a.setTintMode(paramMode);
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    h a;
    boolean b;
    
    public b(b paramb)
    {
      this.a = ((h)paramb.a.getConstantState().newDrawable());
      this.b = paramb.b;
    }
    
    public b(h paramh)
    {
      this.a = paramh;
      this.b = false;
    }
    
    public a a()
    {
      return new a(new b(this), null);
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p7.a
 * JD-Core Version:    0.7.0.1
 */