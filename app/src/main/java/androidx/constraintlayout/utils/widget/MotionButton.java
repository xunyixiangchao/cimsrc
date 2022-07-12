package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R.styleable;

public class MotionButton
  extends AppCompatButton
{
  private float d = 0.0F;
  private float e = (0.0F / 0.0F);
  private Path f;
  ViewOutlineProvider g;
  RectF h;
  
  public MotionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet);
  }
  
  public MotionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    setPadding(0, 0, 0, 0);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ImageFilterView);
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.ImageFilterView_round) {
          setRound(paramContext.getDimension(k, 0.0F));
        } else if (k == R.styleable.ImageFilterView_roundPercent) {
          setRoundPercent(paramContext.getFloat(k, 0.0F));
        }
        i += 1;
      }
      paramContext.recycle();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public float getRound()
  {
    return this.e;
  }
  
  public float getRoundPercent()
  {
    return this.d;
  }
  
  public void setRound(float paramFloat)
  {
    if (Float.isNaN(paramFloat))
    {
      this.e = paramFloat;
      paramFloat = this.d;
      this.d = -1.0F;
      setRoundPercent(paramFloat);
      return;
    }
    int i;
    if (this.e != paramFloat) {
      i = 1;
    } else {
      i = 0;
    }
    this.e = paramFloat;
    if (paramFloat != 0.0F)
    {
      if (this.f == null) {
        this.f = new Path();
      }
      if (this.h == null) {
        this.h = new RectF();
      }
      if (this.g == null)
      {
        localObject = new b();
        this.g = ((ViewOutlineProvider)localObject);
        setOutlineProvider((ViewOutlineProvider)localObject);
      }
      setClipToOutline(true);
      int j = getWidth();
      int k = getHeight();
      this.h.set(0.0F, 0.0F, j, k);
      this.f.reset();
      Object localObject = this.f;
      RectF localRectF = this.h;
      paramFloat = this.e;
      ((Path)localObject).addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    }
    else
    {
      setClipToOutline(false);
    }
    if (i != 0) {
      invalidateOutline();
    }
  }
  
  public void setRoundPercent(float paramFloat)
  {
    int i;
    if (this.d != paramFloat) {
      i = 1;
    } else {
      i = 0;
    }
    this.d = paramFloat;
    if (paramFloat != 0.0F)
    {
      if (this.f == null) {
        this.f = new Path();
      }
      if (this.h == null) {
        this.h = new RectF();
      }
      if (this.g == null)
      {
        a locala = new a();
        this.g = locala;
        setOutlineProvider(locala);
      }
      setClipToOutline(true);
      int j = getWidth();
      int k = getHeight();
      paramFloat = Math.min(j, k) * this.d / 2.0F;
      this.h.set(0.0F, 0.0F, j, k);
      this.f.reset();
      this.f.addRoundRect(this.h, paramFloat, paramFloat, Path.Direction.CW);
    }
    else
    {
      setClipToOutline(false);
    }
    if (i != 0) {
      invalidateOutline();
    }
  }
  
  class a
    extends ViewOutlineProvider
  {
    a() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      int i = MotionButton.this.getWidth();
      int j = MotionButton.this.getHeight();
      paramOutline.setRoundRect(0, 0, i, j, Math.min(i, j) * MotionButton.a(MotionButton.this) / 2.0F);
    }
  }
  
  class b
    extends ViewOutlineProvider
  {
    b() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      paramOutline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.b(MotionButton.this));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.utils.widget.MotionButton
 * JD-Core Version:    0.7.0.1
 */