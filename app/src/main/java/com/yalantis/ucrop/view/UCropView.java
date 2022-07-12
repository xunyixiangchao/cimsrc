package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R.id;
import com.yalantis.ucrop.R.layout;
import com.yalantis.ucrop.R.styleable;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

public class UCropView
  extends FrameLayout
{
  private GestureCropImageView mGestureCropImageView;
  private final OverlayView mViewOverlay;
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.ucrop_view, this, true);
    this.mGestureCropImageView = ((GestureCropImageView)findViewById(R.id.image_view_crop));
    OverlayView localOverlayView = (OverlayView)findViewById(R.id.view_overlay);
    this.mViewOverlay = localOverlayView;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ucrop_UCropView);
    localOverlayView.processStyledAttributes(paramContext);
    this.mGestureCropImageView.processStyledAttributes(paramContext);
    paramContext.recycle();
    setListenersToViews();
  }
  
  private void setListenersToViews()
  {
    this.mGestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener()
    {
      public void onCropAspectRatioChanged(float paramAnonymousFloat)
      {
        UCropView.this.mViewOverlay.setTargetAspectRatio(paramAnonymousFloat);
      }
    });
    this.mViewOverlay.setOverlayViewChangeListener(new OverlayViewChangeListener()
    {
      public void onCropRectUpdated(RectF paramAnonymousRectF)
      {
        UCropView.this.mGestureCropImageView.setCropRect(paramAnonymousRectF);
      }
    });
  }
  
  public GestureCropImageView getCropImageView()
  {
    return this.mGestureCropImageView;
  }
  
  public OverlayView getOverlayView()
  {
    return this.mViewOverlay;
  }
  
  public void resetCropImageView()
  {
    removeView(this.mGestureCropImageView);
    this.mGestureCropImageView = new GestureCropImageView(getContext());
    setListenersToViews();
    this.mGestureCropImageView.setCropRect(getOverlayView().getCropViewRect());
    addView(this.mGestureCropImageView, 0);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.view.UCropView
 * JD-Core Version:    0.7.0.1
 */