package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R.color;
import com.yalantis.ucrop.R.dimen;
import com.yalantis.ucrop.R.styleable;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView
  extends View
{
  public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
  public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
  public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
  public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
  public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
  public static final boolean DEFAULT_SHOW_CROP_GRID = true;
  public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
  public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
  public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
  private OverlayViewChangeListener mCallback;
  private boolean mCircleDimmedLayer;
  private Path mCircularPath = new Path();
  private Paint mCropFrameCornersPaint = new Paint(1);
  private Paint mCropFramePaint = new Paint(1);
  protected float[] mCropGridCenter;
  private int mCropGridColumnCount;
  protected float[] mCropGridCorners;
  private Paint mCropGridPaint = new Paint(1);
  private int mCropGridRowCount;
  private int mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
  private int mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
  private final RectF mCropViewRect = new RectF();
  private int mCurrentTouchCornerIndex = -1;
  private int mDimmedColor;
  private Paint mDimmedStrokePaint = new Paint(1);
  private int mFreestyleCropMode = 0;
  private float[] mGridPoints = null;
  private float mPreviousTouchX = -1.0F;
  private float mPreviousTouchY = -1.0F;
  private boolean mShouldSetupCropBounds;
  private boolean mShowCropFrame;
  private boolean mShowCropGrid;
  private float mTargetAspectRatio;
  private final RectF mTempRect = new RectF();
  protected int mThisHeight;
  protected int mThisWidth;
  private int mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int getCurrentTouchIndex(float paramFloat1, float paramFloat2)
  {
    double d1 = this.mTouchPointThreshold;
    int j = -1;
    int i = 0;
    while (i < 8)
    {
      double d3 = Math.sqrt(Math.pow(paramFloat1 - this.mCropGridCorners[i], 2.0D) + Math.pow(paramFloat2 - this.mCropGridCorners[(i + 1)], 2.0D));
      double d2 = d1;
      if (d3 < d1)
      {
        j = i / 2;
        d2 = d3;
      }
      i += 2;
      d1 = d2;
    }
    if ((this.mFreestyleCropMode == 1) && (j < 0) && (this.mCropViewRect.contains(paramFloat1, paramFloat2))) {
      return 4;
    }
    return j;
  }
  
  private void initCropFrameStyle(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
    int j = paramTypedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
    this.mCropFramePaint.setStrokeWidth(i);
    this.mCropFramePaint.setColor(j);
    this.mCropFramePaint.setStyle(Paint.Style.STROKE);
    this.mCropFrameCornersPaint.setStrokeWidth(i * 3);
    this.mCropFrameCornersPaint.setColor(j);
    this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void initCropGridStyle(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
    int j = paramTypedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
    this.mCropGridPaint.setStrokeWidth(i);
    this.mCropGridPaint.setColor(j);
    this.mCropGridRowCount = paramTypedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
    this.mCropGridColumnCount = paramTypedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
  }
  
  private void updateCropViewRect(float paramFloat1, float paramFloat2)
  {
    this.mTempRect.set(this.mCropViewRect);
    int i = this.mCurrentTouchCornerIndex;
    int j = 1;
    RectF localRectF2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              this.mTempRect.offset(paramFloat1 - this.mPreviousTouchX, paramFloat2 - this.mPreviousTouchY);
              if ((this.mTempRect.left > getLeft()) && (this.mTempRect.top > getTop()) && (this.mTempRect.right < getRight()) && (this.mTempRect.bottom < getBottom()))
              {
                this.mCropViewRect.set(this.mTempRect);
                updateGridPoints();
                postInvalidate();
              }
            }
          }
          else
          {
            localRectF1 = this.mTempRect;
            localRectF2 = this.mCropViewRect;
            localRectF1.set(paramFloat1, localRectF2.top, localRectF2.right, paramFloat2);
          }
        }
        else
        {
          localRectF1 = this.mTempRect;
          localRectF2 = this.mCropViewRect;
          localRectF1.set(localRectF2.left, localRectF2.top, paramFloat1, paramFloat2);
        }
      }
      else
      {
        localRectF1 = this.mTempRect;
        localRectF2 = this.mCropViewRect;
        localRectF1.set(localRectF2.left, paramFloat2, paramFloat1, localRectF2.bottom);
      }
    }
    else
    {
      localRectF1 = this.mTempRect;
      localRectF2 = this.mCropViewRect;
      localRectF1.set(paramFloat1, paramFloat2, localRectF2.right, localRectF2.bottom);
    }
    if (this.mTempRect.height() >= this.mCropRectMinSize) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mTempRect.width() < this.mCropRectMinSize) {
      j = 0;
    }
    RectF localRectF1 = this.mCropViewRect;
    if (j != 0) {
      paramFloat1 = this.mTempRect.left;
    } else {
      paramFloat1 = localRectF1.left;
    }
    if (i != 0) {
      paramFloat2 = this.mTempRect.top;
    } else {
      paramFloat2 = localRectF1.top;
    }
    float f1;
    if (j != 0) {
      f1 = this.mTempRect.right;
    } else {
      f1 = localRectF1.right;
    }
    float f2;
    if (i != 0) {
      f2 = this.mTempRect.bottom;
    } else {
      f2 = localRectF1.bottom;
    }
    localRectF1.set(paramFloat1, paramFloat2, f1, f2);
    if ((i != 0) || (j != 0))
    {
      updateGridPoints();
      postInvalidate();
    }
  }
  
  private void updateGridPoints()
  {
    this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
    this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
    this.mGridPoints = null;
    this.mCircularPath.reset();
    this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0F, Path.Direction.CW);
  }
  
  protected void drawCropGrid(Canvas paramCanvas)
  {
    int i;
    Object localObject1;
    if (this.mShowCropGrid)
    {
      if ((this.mGridPoints == null) && (!this.mCropViewRect.isEmpty()))
      {
        this.mGridPoints = new float[this.mCropGridRowCount * 4 + this.mCropGridColumnCount * 4];
        int n = 0;
        int j = 0;
        i = j;
        int k;
        int m;
        Object localObject2;
        float f1;
        float f2;
        float f3;
        for (;;)
        {
          k = n;
          m = i;
          if (j >= this.mCropGridRowCount) {
            break;
          }
          localObject1 = this.mGridPoints;
          k = i + 1;
          localObject2 = this.mCropViewRect;
          localObject1[i] = ((RectF)localObject2).left;
          i = k + 1;
          f1 = ((RectF)localObject2).height();
          f2 = j + 1.0F;
          f3 = f2 / (this.mCropGridRowCount + 1);
          localObject2 = this.mCropViewRect;
          localObject1[k] = (f1 * f3 + ((RectF)localObject2).top);
          localObject1 = this.mGridPoints;
          k = i + 1;
          localObject1[i] = ((RectF)localObject2).right;
          i = k + 1;
          localObject1[k] = (((RectF)localObject2).height() * (f2 / (this.mCropGridRowCount + 1)) + this.mCropViewRect.top);
          j += 1;
        }
        while (k < this.mCropGridColumnCount)
        {
          localObject2 = this.mGridPoints;
          i = m + 1;
          f2 = this.mCropViewRect.width();
          f1 = k + 1.0F;
          f3 = f1 / (this.mCropGridColumnCount + 1);
          localObject1 = this.mCropViewRect;
          localObject2[m] = (f2 * f3 + ((RectF)localObject1).left);
          localObject2 = this.mGridPoints;
          j = i + 1;
          localObject2[i] = ((RectF)localObject1).top;
          i = j + 1;
          f2 = ((RectF)localObject1).width();
          f1 /= (this.mCropGridColumnCount + 1);
          localObject1 = this.mCropViewRect;
          localObject2[j] = (f2 * f1 + ((RectF)localObject1).left);
          localObject2 = this.mGridPoints;
          m = i + 1;
          localObject2[i] = ((RectF)localObject1).bottom;
          k += 1;
        }
      }
      localObject1 = this.mGridPoints;
      if (localObject1 != null) {
        paramCanvas.drawLines((float[])localObject1, this.mCropGridPaint);
      }
    }
    if (this.mShowCropFrame) {
      paramCanvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
    }
    if (this.mFreestyleCropMode != 0)
    {
      paramCanvas.save();
      this.mTempRect.set(this.mCropViewRect);
      localObject1 = this.mTempRect;
      i = this.mCropRectCornerTouchAreaLineLength;
      ((RectF)localObject1).inset(i, -i);
      paramCanvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
      this.mTempRect.set(this.mCropViewRect);
      localObject1 = this.mTempRect;
      i = this.mCropRectCornerTouchAreaLineLength;
      ((RectF)localObject1).inset(-i, i);
      paramCanvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
      paramCanvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
      paramCanvas.restore();
    }
  }
  
  protected void drawDimmedLayer(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.mCircleDimmedLayer) {
      paramCanvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
    } else {
      paramCanvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
    }
    paramCanvas.drawColor(this.mDimmedColor);
    paramCanvas.restore();
    if (this.mCircleDimmedLayer) {
      paramCanvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0F, this.mDimmedStrokePaint);
    }
  }
  
  public RectF getCropViewRect()
  {
    return this.mCropViewRect;
  }
  
  public int getFreestyleCropMode()
  {
    return this.mFreestyleCropMode;
  }
  
  public OverlayViewChangeListener getOverlayViewChangeListener()
  {
    return this.mCallback;
  }
  
  protected void init() {}
  
  @Deprecated
  public boolean isFreestyleCropEnabled()
  {
    return this.mFreestyleCropMode == 1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawDimmedLayer(paramCanvas);
    drawCropGrid(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.mThisWidth = (paramInt3 - paramInt4 - paramInt1);
      this.mThisHeight = (i - j - paramInt2);
      if (this.mShouldSetupCropBounds)
      {
        this.mShouldSetupCropBounds = false;
        setTargetAspectRatio(this.mTargetAspectRatio);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.mCropViewRect.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.mFreestyleCropMode == 0) {
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        int i = getCurrentTouchIndex(f2, f1);
        this.mCurrentTouchCornerIndex = i;
        if (i != -1) {
          bool1 = true;
        }
        if (!bool1)
        {
          this.mPreviousTouchX = -1.0F;
          this.mPreviousTouchY = -1.0F;
          return bool1;
        }
        if (this.mPreviousTouchX < 0.0F)
        {
          this.mPreviousTouchX = f2;
          this.mPreviousTouchY = f1;
        }
        return bool1;
      }
      if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.mCurrentTouchCornerIndex != -1))
      {
        f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
        f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
        updateCropViewRect(f2, f1);
        this.mPreviousTouchX = f2;
        this.mPreviousTouchY = f1;
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 1)
      {
        this.mPreviousTouchX = -1.0F;
        this.mPreviousTouchY = -1.0F;
        this.mCurrentTouchCornerIndex = -1;
        paramMotionEvent = this.mCallback;
        if (paramMotionEvent != null) {
          paramMotionEvent.onCropRectUpdated(this.mCropViewRect);
        }
      }
    }
    return false;
  }
  
  protected void processStyledAttributes(TypedArray paramTypedArray)
  {
    this.mCircleDimmedLayer = paramTypedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
    int i = paramTypedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
    this.mDimmedColor = i;
    this.mDimmedStrokePaint.setColor(i);
    this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
    this.mDimmedStrokePaint.setStrokeWidth(1.0F);
    initCropFrameStyle(paramTypedArray);
    this.mShowCropFrame = paramTypedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
    initCropGridStyle(paramTypedArray);
    this.mShowCropGrid = paramTypedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
  }
  
  public void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.mCircleDimmedLayer = paramBoolean;
  }
  
  public void setCropFrameColor(int paramInt)
  {
    this.mCropFramePaint.setColor(paramInt);
  }
  
  public void setCropFrameStrokeWidth(int paramInt)
  {
    this.mCropFramePaint.setStrokeWidth(paramInt);
  }
  
  public void setCropGridColor(int paramInt)
  {
    this.mCropGridPaint.setColor(paramInt);
  }
  
  public void setCropGridColumnCount(int paramInt)
  {
    this.mCropGridColumnCount = paramInt;
    this.mGridPoints = null;
  }
  
  public void setCropGridCornerColor(int paramInt)
  {
    this.mCropFrameCornersPaint.setColor(paramInt);
  }
  
  public void setCropGridRowCount(int paramInt)
  {
    this.mCropGridRowCount = paramInt;
    this.mGridPoints = null;
  }
  
  public void setCropGridStrokeWidth(int paramInt)
  {
    this.mCropGridPaint.setStrokeWidth(paramInt);
  }
  
  public void setDimmedColor(int paramInt)
  {
    this.mDimmedColor = paramInt;
  }
  
  @Deprecated
  public void setFreestyleCropEnabled(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setFreestyleCropMode(int paramInt)
  {
    this.mFreestyleCropMode = paramInt;
    postInvalidate();
  }
  
  public void setOverlayViewChangeListener(OverlayViewChangeListener paramOverlayViewChangeListener)
  {
    this.mCallback = paramOverlayViewChangeListener;
  }
  
  public void setShowCropFrame(boolean paramBoolean)
  {
    this.mShowCropFrame = paramBoolean;
  }
  
  public void setShowCropGrid(boolean paramBoolean)
  {
    this.mShowCropGrid = paramBoolean;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    this.mTargetAspectRatio = paramFloat;
    if (this.mThisWidth > 0)
    {
      setupCropBounds();
      postInvalidate();
      return;
    }
    this.mShouldSetupCropBounds = true;
  }
  
  public void setupCropBounds()
  {
    int i = this.mThisWidth;
    float f1 = i;
    float f2 = this.mTargetAspectRatio;
    int j = (int)(f1 / f2);
    int k = this.mThisHeight;
    if (j > k)
    {
      j = (int)(k * f2);
      i = (i - j) / 2;
      this.mCropViewRect.set(getPaddingLeft() + i, getPaddingTop(), getPaddingLeft() + j + i, getPaddingTop() + this.mThisHeight);
    }
    else
    {
      i = (k - j) / 2;
      this.mCropViewRect.set(getPaddingLeft(), getPaddingTop() + i, getPaddingLeft() + this.mThisWidth, getPaddingTop() + j + i);
    }
    OverlayViewChangeListener localOverlayViewChangeListener = this.mCallback;
    if (localOverlayViewChangeListener != null) {
      localOverlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
    }
    updateGridPoints();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FreestyleMode {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.OverlayView
 * JD-Core Version:    0.7.0.1
 */