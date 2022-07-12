package q7;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class a
{
  private static final int[] i = new int[3];
  private static final float[] j = { 0.0F, 0.5F, 1.0F };
  private static final int[] k = new int[4];
  private static final float[] l = { 0.0F, 0.0F, 0.5F, 1.0F };
  private final Paint a = new Paint();
  private final Paint b;
  private final Paint c;
  private int d;
  private int e;
  private int f;
  private final Path g = new Path();
  private Paint h = new Paint();
  
  public a()
  {
    this(-16777216);
  }
  
  public a(int paramInt)
  {
    d(paramInt);
    this.h.setColor(0);
    Paint localPaint = new Paint(4);
    this.b = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    this.c = new Paint(localPaint);
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2)
  {
    int m;
    if (paramFloat2 < 0.0F) {
      m = 1;
    } else {
      m = 0;
    }
    Path localPath = this.g;
    if (m != 0)
    {
      localObject = k;
      localObject[0] = 0;
      localObject[1] = this.f;
      localObject[2] = this.e;
      localObject[3] = this.d;
    }
    else
    {
      localPath.rewind();
      localPath.moveTo(paramRectF.centerX(), paramRectF.centerY());
      localPath.arcTo(paramRectF, paramFloat1, paramFloat2);
      localPath.close();
      f1 = -paramInt;
      paramRectF.inset(f1, f1);
      localObject = k;
      localObject[0] = 0;
      localObject[1] = this.d;
      localObject[2] = this.e;
      localObject[3] = this.f;
    }
    float f1 = paramRectF.width() / 2.0F;
    if (f1 <= 0.0F) {
      return;
    }
    float f2 = 1.0F - paramInt / f1;
    float f3 = (1.0F - f2) / 2.0F;
    Object localObject = l;
    localObject[1] = f2;
    localObject[2] = (f3 + f2);
    localObject = new RadialGradient(paramRectF.centerX(), paramRectF.centerY(), f1, k, (float[])localObject, Shader.TileMode.CLAMP);
    this.b.setShader((Shader)localObject);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.scale(1.0F, paramRectF.height() / paramRectF.width());
    if (m == 0)
    {
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath, this.h);
    }
    paramCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, true, this.b);
    paramCanvas.restore();
  }
  
  public void b(Canvas paramCanvas, Matrix paramMatrix, RectF paramRectF, int paramInt)
  {
    paramRectF.bottom += paramInt;
    paramRectF.offset(0.0F, -paramInt);
    int[] arrayOfInt = i;
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = this.e;
    arrayOfInt[2] = this.d;
    Paint localPaint = this.c;
    float f1 = paramRectF.left;
    localPaint.setShader(new LinearGradient(f1, paramRectF.top, f1, paramRectF.bottom, arrayOfInt, j, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.drawRect(paramRectF, this.c);
    paramCanvas.restore();
  }
  
  public Paint c()
  {
    return this.a;
  }
  
  public void d(int paramInt)
  {
    this.d = q0.a.o(paramInt, 68);
    this.e = q0.a.o(paramInt, 20);
    this.f = q0.a.o(paramInt, 0);
    this.a.setColor(this.d);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q7.a
 * JD-Core Version:    0.7.0.1
 */