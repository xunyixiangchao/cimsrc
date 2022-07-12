package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R.styleable;

public class MotionTelltales
  extends MockView
{
  private Paint l = new Paint();
  MotionLayout m;
  float[] n = new float[2];
  Matrix o = new Matrix();
  int p = 0;
  int q = -65281;
  float r = 0.25F;
  
  public MotionTelltales(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public MotionTelltales(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MotionTelltales);
      int j = paramContext.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.MotionTelltales_telltales_tailColor) {
          this.q = paramContext.getColor(k, this.q);
        } else if (k == R.styleable.MotionTelltales_telltales_velocityMode) {
          this.p = paramContext.getInt(k, this.p);
        } else if (k == R.styleable.MotionTelltales_telltales_tailScale) {
          this.r = paramContext.getFloat(k, this.r);
        }
        i += 1;
      }
      paramContext.recycle();
    }
    this.l.setColor(this.q);
    this.l.setStrokeWidth(5.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    getMatrix().invert(this.o);
    if (this.m == null)
    {
      paramCanvas = getParent();
      if ((paramCanvas instanceof MotionLayout)) {
        this.m = ((MotionLayout)paramCanvas);
      }
      return;
    }
    int k = getWidth();
    int i1 = getHeight();
    float[] arrayOfFloat1 = new float[5];
    float[] tmp64_62 = arrayOfFloat1;
    tmp64_62[0] = 0.1F;
    float[] tmp69_64 = tmp64_62;
    tmp69_64[1] = 0.25F;
    float[] tmp74_69 = tmp69_64;
    tmp74_69[2] = 0.5F;
    float[] tmp79_74 = tmp74_69;
    tmp79_74[3] = 0.75F;
    float[] tmp84_79 = tmp79_74;
    tmp84_79[4] = 0.9F;
    tmp84_79;
    int i = 0;
    while (i < 5)
    {
      float f1 = arrayOfFloat1[i];
      int j = 0;
      while (j < 5)
      {
        float f2 = arrayOfFloat1[j];
        this.m.p0(this, f2, f1, this.n, this.p);
        this.o.mapVectors(this.n);
        f2 = k * f2;
        float f3 = i1 * f1;
        float[] arrayOfFloat2 = this.n;
        float f4 = arrayOfFloat2[0];
        float f5 = this.r;
        float f6 = arrayOfFloat2[1];
        this.o.mapVectors(arrayOfFloat2);
        paramCanvas.drawLine(f2, f3, f2 - f4 * f5, f3 - f6 * f5, this.l);
        j += 1;
      }
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    postInvalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence.toString();
    requestLayout();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.MotionTelltales
 * JD-Core Version:    0.7.0.1
 */