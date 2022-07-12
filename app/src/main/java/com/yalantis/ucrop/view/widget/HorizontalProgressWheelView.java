package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.b;
import com.yalantis.ucrop.R.color;
import com.yalantis.ucrop.R.dimen;

public class HorizontalProgressWheelView
  extends View
{
  private final Rect mCanvasClipBounds = new Rect();
  private float mLastTouchedPosition;
  private int mMiddleLineColor;
  private int mProgressLineHeight;
  private int mProgressLineMargin;
  private Paint mProgressLinePaint;
  private int mProgressLineWidth;
  private Paint mProgressMiddleLinePaint;
  private boolean mScrollStarted;
  private ScrollingListener mScrollingListener;
  private float mTotalScrollDistance;
  
  public HorizontalProgressWheelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HorizontalProgressWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalProgressWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public HorizontalProgressWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void init()
  {
    this.mMiddleLineColor = b.b(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
    this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
    this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
    this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
    Paint localPaint = new Paint(1);
    this.mProgressLinePaint = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    this.mProgressLinePaint.setStrokeWidth(this.mProgressLineWidth);
    this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
    localPaint = new Paint(this.mProgressLinePaint);
    this.mProgressMiddleLinePaint = localPaint;
    localPaint.setColor(this.mMiddleLineColor);
    this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
    this.mProgressMiddleLinePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
  }
  
  private void onScrollEvent(MotionEvent paramMotionEvent, float paramFloat)
  {
    this.mTotalScrollDistance -= paramFloat;
    postInvalidate();
    this.mLastTouchedPosition = paramMotionEvent.getX();
    paramMotionEvent = this.mScrollingListener;
    if (paramMotionEvent != null) {
      paramMotionEvent.onScroll(-paramFloat, this.mTotalScrollDistance);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.getClipBounds(this.mCanvasClipBounds);
    int j = this.mCanvasClipBounds.width();
    int i = this.mProgressLineWidth;
    int k = this.mProgressLineMargin;
    j /= (i + k);
    float f2 = this.mTotalScrollDistance;
    float f3 = k + i;
    i = 0;
    while (i < j)
    {
      k = j / 4;
      if (i < k) {
        localObject = this.mProgressLinePaint;
      }
      for (f1 = i;; f1 = j - i)
      {
        ((Paint)localObject).setAlpha((int)(f1 / k * 255.0F));
        break label145;
        if (i <= j * 3 / 4) {
          break;
        }
        localObject = this.mProgressLinePaint;
      }
      this.mProgressLinePaint.setAlpha(255);
      label145:
      f1 = -(f2 % f3);
      Object localObject = this.mCanvasClipBounds;
      f4 = ((Rect)localObject).left;
      f5 = (this.mProgressLineWidth + this.mProgressLineMargin) * i;
      float f6 = ((Rect)localObject).centerY();
      float f7 = this.mProgressLineHeight / 4.0F;
      localObject = this.mCanvasClipBounds;
      paramCanvas.drawLine(f4 + f1 + f5, f6 - f7, f1 + ((Rect)localObject).left + (this.mProgressLineWidth + this.mProgressLineMargin) * i, ((Rect)localObject).centerY() + this.mProgressLineHeight / 4.0F, this.mProgressLinePaint);
      i += 1;
    }
    float f1 = this.mCanvasClipBounds.centerX();
    f2 = this.mCanvasClipBounds.centerY();
    f3 = this.mProgressLineHeight / 2.0F;
    float f4 = this.mCanvasClipBounds.centerX();
    float f5 = this.mCanvasClipBounds.centerY();
    paramCanvas.drawLine(f1, f2 - f3, f4, this.mProgressLineHeight / 2.0F + f5, this.mProgressMiddleLinePaint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        float f = paramMotionEvent.getX() - this.mLastTouchedPosition;
        if (f != 0.0F)
        {
          if (!this.mScrollStarted)
          {
            this.mScrollStarted = true;
            ScrollingListener localScrollingListener = this.mScrollingListener;
            if (localScrollingListener != null) {
              localScrollingListener.onScrollStart();
            }
          }
          onScrollEvent(paramMotionEvent, f);
          return true;
        }
      }
      else
      {
        paramMotionEvent = this.mScrollingListener;
        if (paramMotionEvent != null)
        {
          this.mScrollStarted = false;
          paramMotionEvent.onScrollEnd();
          return true;
        }
      }
    }
    else {
      this.mLastTouchedPosition = paramMotionEvent.getX();
    }
    return true;
  }
  
  public void setMiddleLineColor(int paramInt)
  {
    this.mMiddleLineColor = paramInt;
    this.mProgressMiddleLinePaint.setColor(paramInt);
    invalidate();
  }
  
  public void setScrollingListener(ScrollingListener paramScrollingListener)
  {
    this.mScrollingListener = paramScrollingListener;
  }
  
  public static abstract interface ScrollingListener
  {
    public abstract void onScroll(float paramFloat1, float paramFloat2);
    
    public abstract void onScrollEnd();
    
    public abstract void onScrollStart();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.widget.HorizontalProgressWheelView
 * JD-Core Version:    0.7.0.1
 */