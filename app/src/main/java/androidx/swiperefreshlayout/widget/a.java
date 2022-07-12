package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import androidx.core.view.x;

class a
  extends ImageView
{
  private Animation.AnimationListener a;
  int b;
  
  a(Context paramContext, int paramInt)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.b = ((int)(3.5F * f));
    if (a())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      x.y0(this, f * 4.0F);
    }
    else
    {
      paramContext = new ShapeDrawable(new a(this.b));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.b, j, i, 503316480);
      i = this.b;
      setPadding(i, i, i, i);
    }
    paramContext.getPaint().setColor(paramInt);
    x.u0(this, paramContext);
  }
  
  private boolean a()
  {
    return true;
  }
  
  public void b(Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a()) {
      setMeasuredDimension(getMeasuredWidth() + this.b * 2, getMeasuredHeight() + this.b * 2);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  private class a
    extends OvalShape
  {
    private RadialGradient a;
    private Paint b = new Paint();
    
    a(int paramInt)
    {
      a.this.b = paramInt;
      a((int)rect().width());
    }
    
    private void a(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = a.this.b;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, (Shader.TileMode)localObject);
      this.a = ((RadialGradient)localObject);
      this.b.setShader((Shader)localObject);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int j = a.this.getWidth();
      int i = a.this.getHeight();
      j /= 2;
      float f1 = j;
      float f2 = i / 2;
      paramCanvas.drawCircle(f1, f2, f1, this.b);
      paramCanvas.drawCircle(f1, f2, j - a.this.b, paramPaint);
    }
    
    protected void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      a((int)paramFloat1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.swiperefreshlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */