package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import s3.c0;

public class CharSelectorBar
  extends View
{
  private static final char[] e = { 9734, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 35 };
  private c0 a;
  private int b = -1;
  private final Paint c = new Paint();
  private TextView d;
  
  public CharSelectorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getY() / getHeight();
    char[] arrayOfChar = e;
    int i = (int)(f * arrayOfChar.length);
    if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3))
    {
      if (paramMotionEvent.getAction() == 0) {
        return true;
      }
      if ((paramMotionEvent.getAction() == 2) && (this.b != i) && (i >= 0) && (i < arrayOfChar.length))
      {
        char c1 = arrayOfChar[i];
        this.a.E0(arrayOfChar[i]);
        this.d.setText(String.valueOf(c1));
        this.d.setVisibility(0);
        this.b = i;
      }
      return true;
    }
    this.b = -1;
    this.d.setVisibility(4);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    int k = i / e.length;
    i = 0;
    for (;;)
    {
      Object localObject = e;
      if (i >= localObject.length) {
        break;
      }
      this.c.setColor(b.b(getContext(), 2131034730));
      this.c.setTypeface(Typeface.DEFAULT_BOLD);
      this.c.setAntiAlias(true);
      int m = getResources().getDimensionPixelOffset(2131100245);
      this.c.setTextSize(m);
      localObject = String.valueOf(localObject[i]);
      paramCanvas.drawText((String)localObject, j / 2 - this.c.measureText((String)localObject) / 2.0F, k * i + k, this.c);
      this.c.reset();
      i += 1;
    }
  }
  
  public void setOnTouchMoveCharListener(c0 paramc0)
  {
    this.a = paramc0;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.d = paramTextView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.CharSelectorBar
 * JD-Core Version:    0.7.0.1
 */