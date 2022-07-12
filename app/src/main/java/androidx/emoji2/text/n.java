package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;

public final class n
  extends h
{
  private static Paint f;
  
  public n(f paramf)
  {
    super(paramf);
  }
  
  private static Paint c()
  {
    if (f == null)
    {
      TextPaint localTextPaint = new TextPaint();
      f = localTextPaint;
      localTextPaint.setColor(d.b().c());
      f.setStyle(Paint.Style.FILL);
    }
    return f;
  }
  
  public void draw(Canvas paramCanvas, @SuppressLint({"UnknownNullness"}) CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (d.b().i()) {
      paramCanvas.drawRect(paramFloat, paramInt3, paramFloat + b(), paramInt5, c());
    }
    a().a(paramCanvas, paramFloat, paramInt4, paramPaint);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.n
 * JD-Core Version:    0.7.0.1
 */