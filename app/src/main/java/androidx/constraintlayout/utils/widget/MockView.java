package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.constraintlayout.widget.R.styleable;

public class MockView
  extends View
{
  private Paint a = new Paint();
  private Paint b = new Paint();
  private Paint c = new Paint();
  private boolean d = true;
  private boolean e = true;
  protected String f = null;
  private Rect g = new Rect();
  private int h = Color.argb(255, 0, 0, 0);
  private int i = Color.argb(255, 200, 200, 200);
  private int j = Color.argb(255, 50, 50, 50);
  private int k = 4;
  
  public MockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public MockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MockView);
      int n = paramAttributeSet.getIndexCount();
      int m = 0;
      while (m < n)
      {
        int i1 = paramAttributeSet.getIndex(m);
        if (i1 == R.styleable.MockView_mock_label) {
          this.f = paramAttributeSet.getString(i1);
        } else if (i1 == R.styleable.MockView_mock_showDiagonals) {
          this.d = paramAttributeSet.getBoolean(i1, this.d);
        } else if (i1 == R.styleable.MockView_mock_diagonalsColor) {
          this.h = paramAttributeSet.getColor(i1, this.h);
        } else if (i1 == R.styleable.MockView_mock_labelBackgroundColor) {
          this.j = paramAttributeSet.getColor(i1, this.j);
        } else if (i1 == R.styleable.MockView_mock_labelColor) {
          this.i = paramAttributeSet.getColor(i1, this.i);
        } else if (i1 == R.styleable.MockView_mock_showLabel) {
          this.e = paramAttributeSet.getBoolean(i1, this.e);
        }
        m += 1;
      }
      paramAttributeSet.recycle();
    }
    if (this.f == null) {}
    try
    {
      this.f = paramContext.getResources().getResourceEntryName(getId());
      label210:
      this.a.setColor(this.h);
      this.a.setAntiAlias(true);
      this.b.setColor(this.i);
      this.b.setAntiAlias(true);
      this.c.setColor(this.j);
      this.k = Math.round(this.k * (getResources().getDisplayMetrics().xdpi / 160.0F));
      return;
    }
    catch (Exception paramContext)
    {
      break label210;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = getWidth();
    int i1 = getHeight();
    int n = i2;
    int m = i1;
    float f1;
    float f2;
    if (this.d)
    {
      n = i2 - 1;
      m = i1 - 1;
      f1 = n;
      f2 = m;
      paramCanvas.drawLine(0.0F, 0.0F, f1, f2, this.a);
      paramCanvas.drawLine(0.0F, f2, f1, 0.0F, this.a);
      paramCanvas.drawLine(0.0F, 0.0F, f1, 0.0F, this.a);
      paramCanvas.drawLine(f1, 0.0F, f1, f2, this.a);
      paramCanvas.drawLine(f1, f2, 0.0F, f2, this.a);
      paramCanvas.drawLine(0.0F, f2, 0.0F, 0.0F, this.a);
    }
    Object localObject = this.f;
    if ((localObject != null) && (this.e))
    {
      this.b.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.g);
      f1 = (n - this.g.width()) / 2.0F;
      f2 = (m - this.g.height()) / 2.0F + this.g.height();
      this.g.offset((int)f1, (int)f2);
      localObject = this.g;
      m = ((Rect)localObject).left;
      n = this.k;
      ((Rect)localObject).set(m - n, ((Rect)localObject).top - n, ((Rect)localObject).right + n, ((Rect)localObject).bottom + n);
      paramCanvas.drawRect(this.g, this.c);
      paramCanvas.drawText(this.f, f1, f2, this.b);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.MockView
 * JD-Core Version:    0.7.0.1
 */