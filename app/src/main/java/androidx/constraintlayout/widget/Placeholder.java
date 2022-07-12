package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import k0.e;
import k0.e.b;

public class Placeholder
  extends View
{
  private int a = -1;
  private View b = null;
  private int c = 4;
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    super.setVisibility(this.c);
    this.a = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_placeholder_content) {
          this.a = paramAttributeSet.getResourceId(k, this.a);
        } else if (k == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
          this.c = paramAttributeSet.getInt(k, this.c);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void b(ConstraintLayout paramConstraintLayout)
  {
    if (this.b == null) {
      return;
    }
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.v0.n1(0);
    e.b localb1 = paramConstraintLayout.v0.C();
    e.b localb2 = e.b.a;
    if (localb1 != localb2) {
      paramConstraintLayout.v0.o1(localLayoutParams.v0.Y());
    }
    if (paramConstraintLayout.v0.V() != localb2) {
      paramConstraintLayout.v0.P0(localLayoutParams.v0.z());
    }
    localLayoutParams.v0.n1(8);
  }
  
  public void c(ConstraintLayout paramConstraintLayout)
  {
    if ((this.a == -1) && (!isInEditMode())) {
      setVisibility(this.c);
    }
    paramConstraintLayout = paramConstraintLayout.findViewById(this.a);
    this.b = paramConstraintLayout;
    if (paramConstraintLayout != null)
    {
      ((ConstraintLayout.LayoutParams)paramConstraintLayout.getLayoutParams()).j0 = true;
      this.b.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public View getContent()
  {
    return this.b;
  }
  
  public int getEmptyVisibility()
  {
    return this.c;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, 1, localRect);
      paramCanvas.drawText("?", j / 2.0F - localRect.width() / 2.0F - localRect.left, i / 2.0F + localRect.height() / 2.0F - localRect.bottom, localPaint);
    }
  }
  
  public void setContentId(int paramInt)
  {
    if (this.a == paramInt) {
      return;
    }
    View localView = this.b;
    if (localView != null)
    {
      localView.setVisibility(0);
      ((ConstraintLayout.LayoutParams)this.b.getLayoutParams()).j0 = false;
      this.b = null;
    }
    this.a = paramInt;
    if (paramInt != -1)
    {
      localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.Placeholder
 * JD-Core Version:    0.7.0.1
 */