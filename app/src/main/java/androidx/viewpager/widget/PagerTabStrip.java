package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private boolean A;
  private int B;
  private boolean C;
  private float E;
  private float F;
  private int G;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private final Paint w;
  private final Rect x;
  private int y;
  private boolean z;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = new Paint();
    this.w = paramAttributeSet;
    this.x = new Rect();
    this.y = 255;
    this.z = false;
    this.A = false;
    int i = this.n;
    this.q = i;
    paramAttributeSet.setColor(i);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.r = ((int)(3.0F * f + 0.5F));
    this.s = ((int)(6.0F * f + 0.5F));
    this.t = ((int)(64.0F * f));
    this.v = ((int)(16.0F * f + 0.5F));
    this.B = ((int)(1.0F * f + 0.5F));
    this.u = ((int)(f * 32.0F + 0.5F));
    this.G = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.b.setFocusable(true);
    this.b.setOnClickListener(new a());
    this.d.setFocusable(true);
    this.d.setOnClickListener(new b());
    if (getBackground() == null) {
      this.z = true;
    }
  }
  
  void d(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.x;
    int i = getHeight();
    int j = this.c.getLeft();
    int k = this.v;
    int m = this.c.getRight();
    int n = this.v;
    int i1 = i - this.r;
    localRect.set(j - k, i1, m + n, i);
    super.d(paramInt, paramFloat, paramBoolean);
    this.y = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.c.getLeft() - this.v, i1, this.c.getRight() + this.v, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.z;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.u);
  }
  
  public int getTabIndicatorColor()
  {
    return this.q;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.c.getLeft();
    int k = this.v;
    int m = this.c.getRight();
    int n = this.v;
    int i1 = this.r;
    this.w.setColor(this.y << 24 | this.q & 0xFFFFFF);
    float f1 = j - k;
    float f2 = i - i1;
    float f3 = m + n;
    float f4 = i;
    paramCanvas.drawRect(f1, f2, f3, f4, this.w);
    if (this.z)
    {
      this.w.setColor(0xFF000000 | this.q & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.B, getWidth() - getPaddingRight(), f4, this.w);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.C)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if ((Math.abs(f1 - this.E) > this.G) || (Math.abs(f2 - this.F) > this.G))
        {
          this.C = true;
          return true;
        }
      }
      else
      {
        if (f1 < this.c.getLeft() - this.v) {
          paramMotionEvent = this.a;
        }
        for (i = paramMotionEvent.getCurrentItem() - 1;; i = paramMotionEvent.getCurrentItem() + 1)
        {
          paramMotionEvent.setCurrentItem(i);
          return true;
          if (f1 <= this.c.getRight() + this.v) {
            break;
          }
          paramMotionEvent = this.a;
        }
      }
    }
    else
    {
      this.E = f1;
      this.F = f2;
      this.C = false;
    }
    return true;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.A)
    {
      boolean bool;
      if ((paramInt & 0xFF000000) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.z = bool;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.A)
    {
      boolean bool;
      if (paramDrawable == null) {
        bool = true;
      } else {
        bool = false;
      }
      this.z = bool;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.A)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.z = bool;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.z = paramBoolean;
    this.A = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.s;
    int i = paramInt4;
    if (paramInt4 < j) {
      i = j;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.q = paramInt;
    this.w.setColor(paramInt);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.b(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int j = this.t;
    int i = paramInt;
    if (paramInt < j) {
      i = j;
    }
    super.setTextSpacing(i);
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = PagerTabStrip.this.a;
      paramView.setCurrentItem(paramView.getCurrentItem() - 1);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      paramView = PagerTabStrip.this.a;
      paramView.setCurrentItem(paramView.getCurrentItem() + 1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager.widget.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */