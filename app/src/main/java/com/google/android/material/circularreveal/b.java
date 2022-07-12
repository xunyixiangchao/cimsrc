package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.view.View;
import l7.a;

public class b
{
  public static final int j = 2;
  private final a a;
  private final View b;
  private final Path c;
  private final Paint d;
  private final Paint e;
  private c.e f;
  private Drawable g;
  private boolean h;
  private boolean i;
  
  public b(a parama)
  {
    this.a = parama;
    parama = (View)parama;
    this.b = parama;
    parama.setWillNotDraw(false);
    this.c = new Path();
    this.d = new Paint(7);
    parama = new Paint(1);
    this.e = parama;
    parama.setColor(0);
  }
  
  private void d(Canvas paramCanvas)
  {
    if (o())
    {
      Rect localRect = this.g.getBounds();
      float f1 = this.f.a - localRect.width() / 2.0F;
      float f2 = this.f.b - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.g.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private float g(c.e parame)
  {
    return a.b(parame.a, parame.b, 0.0F, 0.0F, this.b.getWidth(), this.b.getHeight());
  }
  
  private void i()
  {
    if (j == 1)
    {
      this.c.rewind();
      c.e locale = this.f;
      if (locale != null) {
        this.c.addCircle(locale.a, locale.b, locale.c, Path.Direction.CW);
      }
    }
    this.b.invalidate();
  }
  
  private boolean n()
  {
    c.e locale = this.f;
    boolean bool2 = false;
    int k;
    if ((locale != null) && (!locale.a())) {
      k = 0;
    } else {
      k = 1;
    }
    if (j == 0)
    {
      boolean bool1 = bool2;
      if (k == 0)
      {
        bool1 = bool2;
        if (this.i) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return k ^ 0x1;
  }
  
  private boolean o()
  {
    return (!this.h) && (this.g != null) && (this.f != null);
  }
  
  private boolean p()
  {
    return (!this.h) && (Color.alpha(this.e.getColor()) != 0);
  }
  
  public void a()
  {
    if (j == 0)
    {
      this.h = true;
      this.i = false;
      this.b.buildDrawingCache();
      Object localObject2 = this.b.getDrawingCache();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.b.getWidth() != 0)
        {
          localObject1 = localObject2;
          if (this.b.getHeight() != 0)
          {
            localObject1 = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
            localObject2 = new Canvas((Bitmap)localObject1);
            this.b.draw((Canvas)localObject2);
          }
        }
      }
      if (localObject1 != null)
      {
        localObject2 = this.d;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.h = false;
      this.i = true;
    }
  }
  
  public void b()
  {
    if (j == 0)
    {
      this.i = false;
      this.b.destroyDrawingCache();
      this.d.setShader(null);
      this.b.invalidate();
    }
  }
  
  public void c(Canvas paramCanvas)
  {
    if (n())
    {
      int k = j;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k == 2)
          {
            this.a.d(paramCanvas);
            if (!p()) {
              break label246;
            }
          }
          else
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("Unsupported strategy ");
            paramCanvas.append(k);
            throw new IllegalStateException(paramCanvas.toString());
          }
        }
        else
        {
          k = paramCanvas.save();
          paramCanvas.clipPath(this.c);
          this.a.d(paramCanvas);
          if (p()) {
            paramCanvas.drawRect(0.0F, 0.0F, this.b.getWidth(), this.b.getHeight(), this.e);
          }
          paramCanvas.restoreToCount(k);
          break label246;
        }
      }
      else
      {
        c.e locale = this.f;
        paramCanvas.drawCircle(locale.a, locale.b, locale.c, this.d);
        if (!p()) {
          break label246;
        }
        locale = this.f;
        paramCanvas.drawCircle(locale.a, locale.b, locale.c, this.e);
        break label246;
      }
    }
    else
    {
      this.a.d(paramCanvas);
      if (!p()) {
        break label246;
      }
    }
    paramCanvas.drawRect(0.0F, 0.0F, this.b.getWidth(), this.b.getHeight(), this.e);
    label246:
    d(paramCanvas);
  }
  
  public Drawable e()
  {
    return this.g;
  }
  
  public int f()
  {
    return this.e.getColor();
  }
  
  public c.e h()
  {
    c.e locale = this.f;
    if (locale == null) {
      return null;
    }
    locale = new c.e(locale);
    if (locale.a()) {
      locale.c = g(locale);
    }
    return locale;
  }
  
  public boolean j()
  {
    return (this.a.f()) && (!n());
  }
  
  public void k(Drawable paramDrawable)
  {
    this.g = paramDrawable;
    this.b.invalidate();
  }
  
  public void l(int paramInt)
  {
    this.e.setColor(paramInt);
    this.b.invalidate();
  }
  
  public void m(c.e parame)
  {
    if (parame == null)
    {
      this.f = null;
    }
    else
    {
      c.e locale = this.f;
      if (locale == null) {
        this.f = new c.e(parame);
      } else {
        locale.c(parame);
      }
      if (a.c(parame.c, g(parame), 1.0E-004F)) {
        this.f.c = 3.4028235E+38F;
      }
    }
    i();
  }
  
  public static abstract interface a
  {
    public abstract void d(Canvas paramCanvas);
    
    public abstract boolean f();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */