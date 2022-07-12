package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import com.yalantis.ucrop.R.color;
import com.yalantis.ucrop.R.dimen;
import com.yalantis.ucrop.R.styleable;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView
  extends AppCompatTextView
{
  private final float MARGIN_MULTIPLIER = 1.5F;
  private float mAspectRatio;
  private String mAspectRatioTitle;
  private float mAspectRatioX;
  private float mAspectRatioY;
  private final Rect mCanvasClipBounds = new Rect();
  private Paint mDotPaint;
  private int mDotSize;
  
  public AspectRatioTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AspectRatioTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @TargetApi(21)
  public AspectRatioTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ucrop_AspectRatioTextView));
  }
  
  private void applyActiveColor(int paramInt)
  {
    Object localObject = this.mDotPaint;
    if (localObject != null) {
      ((Paint)localObject).setColor(paramInt);
    }
    localObject = new int[] { 16842913 };
    int[] arrayOfInt = { 0 };
    int i = b.b(getContext(), R.color.ucrop_color_widget);
    setTextColor(new ColorStateList(new int[][] { localObject, arrayOfInt }, new int[] { paramInt, i }));
  }
  
  private void init(TypedArray paramTypedArray)
  {
    setGravity(1);
    this.mAspectRatioTitle = paramTypedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
    this.mAspectRatioX = paramTypedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0F);
    float f1 = paramTypedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0F);
    this.mAspectRatioY = f1;
    float f2 = this.mAspectRatioX;
    if ((f2 != 0.0F) && (f1 != 0.0F)) {
      this.mAspectRatio = (f2 / f1);
    } else {
      this.mAspectRatio = 0.0F;
    }
    this.mDotSize = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
    Paint localPaint = new Paint(1);
    this.mDotPaint = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    setTitle();
    applyActiveColor(getResources().getColor(R.color.ucrop_color_widget_active));
    paramTypedArray.recycle();
  }
  
  private void setTitle()
  {
    String str;
    if (!TextUtils.isEmpty(this.mAspectRatioTitle)) {
      str = this.mAspectRatioTitle;
    } else {
      str = String.format(Locale.US, "%d:%d", new Object[] { Integer.valueOf((int)this.mAspectRatioX), Integer.valueOf((int)this.mAspectRatioY) });
    }
    setText(str);
  }
  
  private void toggleAspectRatio()
  {
    if (this.mAspectRatio != 0.0F)
    {
      float f1 = this.mAspectRatioX;
      float f2 = this.mAspectRatioY;
      this.mAspectRatioX = f2;
      this.mAspectRatioY = f1;
      this.mAspectRatio = (f2 / f1);
    }
  }
  
  public float getAspectRatio(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      toggleAspectRatio();
      setTitle();
    }
    return this.mAspectRatio;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (isSelected())
    {
      paramCanvas.getClipBounds(this.mCanvasClipBounds);
      Rect localRect = this.mCanvasClipBounds;
      float f1 = (localRect.right - localRect.left) / 2.0F;
      float f2 = localRect.bottom;
      float f3 = localRect.top / 2.0F;
      int i = this.mDotSize;
      paramCanvas.drawCircle(f1, f2 - f3 - i * 1.5F, i / 2.0F, this.mDotPaint);
    }
  }
  
  public void setActiveColor(int paramInt)
  {
    applyActiveColor(paramInt);
    invalidate();
  }
  
  public void setAspectRatio(AspectRatio paramAspectRatio)
  {
    this.mAspectRatioTitle = paramAspectRatio.getAspectRatioTitle();
    this.mAspectRatioX = paramAspectRatio.getAspectRatioX();
    float f1 = paramAspectRatio.getAspectRatioY();
    this.mAspectRatioY = f1;
    float f2 = this.mAspectRatioX;
    if ((f2 != 0.0F) && (f1 != 0.0F)) {
      this.mAspectRatio = (f2 / f1);
    } else {
      this.mAspectRatio = 0.0F;
    }
    setTitle();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.widget.AspectRatioTextView
 * JD-Core Version:    0.7.0.1
 */