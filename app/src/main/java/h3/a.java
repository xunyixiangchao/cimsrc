package h3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import java.util.Random;

public class a
  extends View
  implements Animation.AnimationListener
{
  private final Paint a;
  private final int b;
  private final int c;
  private final int d;
  private int e;
  private int f;
  private TranslateAnimation g;
  private int h;
  private final boolean i;
  private int j;
  private int k;
  private int l;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, 20);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    super(paramContext, null);
    paramContext = new Paint();
    this.a = paramContext;
    paramContext.setAntiAlias(true);
    paramContext.setStyle(Paint.Style.FILL);
    this.d = paramInt3;
    this.b = paramInt1;
    this.c = paramInt2;
    paramContext.setColor(paramInt4);
    this.i = paramBoolean;
    this.h = ((int)(Resources.getSystem().getDisplayMetrics().density * 5.0F));
    this.l = paramInt5;
  }
  
  private void c()
  {
    int m = new Random().nextInt(this.h);
    int n = this.h;
    m = (int)(getX() + (m * -1 + n));
    n = new Random().nextInt(this.h);
    int i1 = this.h;
    n = (int)(getY() + (n * -1 + i1));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.e, m, this.f, n);
    this.g = localTranslateAnimation;
    localTranslateAnimation.setDuration(2000);
    this.g.setRepeatCount(0);
    this.g.setAnimationListener(this);
    this.g.setFillAfter(true);
    startAnimation(this.g);
    this.f = n;
    this.e = m;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    invalidate();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ((FrameLayout.LayoutParams)getLayoutParams()).setMargins(paramInt1, paramInt2, 0, 0);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TranslateAnimation localTranslateAnimation = this.g;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.j != 0) && (this.k != 0))
    {
      localPaint = this.a;
      float f1 = this.b;
      float f2 = this.c;
      int m = this.d;
      localPaint.setShader(new LinearGradient(f1, f2, m, m, this.j, this.k, Shader.TileMode.MIRROR));
    }
    Paint localPaint = this.a;
    localPaint.setShadowLayer(this.l, 0.0F, 0.0F, localPaint.getColor());
    paramCanvas.drawCircle(this.b, this.c, this.d, this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.i))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      c();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h3.a
 * JD-Core Version:    0.7.0.1
 */