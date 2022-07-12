package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.r;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.TransformImageView.TransformImageListener;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropFragment
  extends Fragment
{
  public static final int ALL = 3;
  private static final long CONTROLS_ANIMATION_DURATION = 50L;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
  public static final int DEFAULT_COMPRESS_QUALITY = 90;
  public static final int NONE = 0;
  public static final int ROTATE = 2;
  private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
  public static final int SCALE = 1;
  private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
  private static final int TABS_COUNT = 3;
  public static final String TAG = "UCropFragment";
  private UCropFragmentCallback callback;
  private int mActiveControlsWidgetColor;
  private int[] mAllowedGestures = { 1, 2, 3 };
  private View mBlockingView;
  private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
  private int mCompressQuality = 90;
  private Transition mControlsTransition;
  private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
  private GestureCropImageView mGestureCropImageView;
  private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener()
  {
    public void onLoadComplete()
    {
      UCropFragment.this.mUCropView.animate().alpha(1.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator());
      UCropFragment.this.mBlockingView.setClickable(false);
      UCropFragment.this.callback.loadingProgress(false);
    }
    
    public void onLoadFailure(Exception paramAnonymousException)
    {
      UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(paramAnonymousException));
    }
    
    public void onRotate(float paramAnonymousFloat)
    {
      UCropFragment.this.setAngleText(paramAnonymousFloat);
    }
    
    public void onScale(float paramAnonymousFloat)
    {
      UCropFragment.this.setScaleText(paramAnonymousFloat);
    }
  };
  private ViewGroup mLayoutAspectRatio;
  private ViewGroup mLayoutRotate;
  private ViewGroup mLayoutScale;
  private int mLogoColor;
  private OverlayView mOverlayView;
  private int mRootViewBackgroundColor;
  private boolean mShowBottomControls;
  private final View.OnClickListener mStateClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!paramAnonymousView.isSelected()) {
        UCropFragment.this.setWidgetState(paramAnonymousView.getId());
      }
    }
  };
  private TextView mTextViewRotateAngle;
  private TextView mTextViewScalePercent;
  private UCropView mUCropView;
  private ViewGroup mWrapperStateAspectRatio;
  private ViewGroup mWrapperStateRotate;
  private ViewGroup mWrapperStateScale;
  
  static
  {
    d.D(true);
  }
  
  private void addBlockingView(View paramView)
  {
    if (this.mBlockingView == null)
    {
      this.mBlockingView = new View(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.mBlockingView.setLayoutParams(localLayoutParams);
      this.mBlockingView.setClickable(true);
    }
    ((RelativeLayout)paramView.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
  }
  
  private void changeSelectedTab(int paramInt)
  {
    if (getView() != null) {
      r.a((ViewGroup)getView().findViewById(R.id.ucrop_photobox), this.mControlsTransition);
    }
    View localView = this.mWrapperStateScale.findViewById(R.id.text_view_scale);
    int i = R.id.state_scale;
    int j = 0;
    if (paramInt == i) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    localView = this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop);
    if (paramInt == R.id.state_aspect_ratio) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    localView = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
    if (paramInt == R.id.state_rotate) {
      paramInt = j;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
  }
  
  private void initiateRootViews(View paramView)
  {
    UCropView localUCropView = (UCropView)paramView.findViewById(R.id.ucrop);
    this.mUCropView = localUCropView;
    this.mGestureCropImageView = localUCropView.getCropImageView();
    this.mOverlayView = this.mUCropView.getOverlayView();
    this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
    ((ImageView)paramView.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
    paramView.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
  }
  
  public static UCropFragment newInstance(Bundle paramBundle)
  {
    UCropFragment localUCropFragment = new UCropFragment();
    localUCropFragment.setArguments(paramBundle);
    return localUCropFragment;
  }
  
  private void processOptions(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("com.yalantis.ucrop.CompressionFormatName");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = Bitmap.CompressFormat.valueOf((String)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = DEFAULT_COMPRESS_FORMAT;
    }
    this.mCompressFormat = ((Bitmap.CompressFormat)localObject2);
    this.mCompressQuality = paramBundle.getInt("com.yalantis.ucrop.CompressionQuality", 90);
    localObject1 = paramBundle.getIntArray("com.yalantis.ucrop.AllowedGestures");
    if ((localObject1 != null) && (localObject1.length == 3)) {
      this.mAllowedGestures = ((int[])localObject1);
    }
    this.mGestureCropImageView.setMaxBitmapSize(paramBundle.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
    this.mGestureCropImageView.setMaxScaleMultiplier(paramBundle.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0F));
    this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(paramBundle.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
    this.mOverlayView.setFreestyleCropEnabled(paramBundle.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
    this.mOverlayView.setDimmedColor(paramBundle.getInt("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
    this.mOverlayView.setCircleDimmedLayer(paramBundle.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
    this.mOverlayView.setShowCropFrame(paramBundle.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
    this.mOverlayView.setCropFrameColor(paramBundle.getInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
    this.mOverlayView.setCropFrameStrokeWidth(paramBundle.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
    this.mOverlayView.setShowCropGrid(paramBundle.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
    this.mOverlayView.setCropGridRowCount(paramBundle.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
    this.mOverlayView.setCropGridColumnCount(paramBundle.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
    this.mOverlayView.setCropGridColor(paramBundle.getInt("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
    this.mOverlayView.setCropGridStrokeWidth(paramBundle.getInt("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
    float f1 = paramBundle.getFloat("com.yalantis.ucrop.AspectRatioX", -1.0F);
    float f3 = paramBundle.getFloat("com.yalantis.ucrop.AspectRatioY", -1.0F);
    int i = paramBundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
    localObject1 = paramBundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
    float f2 = 0.0F;
    if ((f1 >= 0.0F) && (f3 >= 0.0F))
    {
      localObject1 = this.mWrapperStateAspectRatio;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
      f3 = f1 / f3;
      localObject2 = this.mGestureCropImageView;
      f1 = f3;
      localObject1 = localObject2;
      if (Float.isNaN(f3))
      {
        localObject1 = localObject2;
        f1 = f2;
      }
    }
    else
    {
      if ((localObject1 == null) || (i >= ((ArrayList)localObject1).size())) {
        break label544;
      }
      f3 = ((AspectRatio)((ArrayList)localObject1).get(i)).getAspectRatioX() / ((AspectRatio)((ArrayList)localObject1).get(i)).getAspectRatioY();
      localObject2 = this.mGestureCropImageView;
      f1 = f3;
      localObject1 = localObject2;
      if (Float.isNaN(f3))
      {
        localObject1 = localObject2;
        f1 = f2;
      }
    }
    ((CropImageView)localObject1).setTargetAspectRatio(f1);
    break label552;
    label544:
    this.mGestureCropImageView.setTargetAspectRatio(0.0F);
    label552:
    i = paramBundle.getInt("com.yalantis.ucrop.MaxSizeX", 0);
    int j = paramBundle.getInt("com.yalantis.ucrop.MaxSizeY", 0);
    if ((i > 0) && (j > 0))
    {
      this.mGestureCropImageView.setMaxResultImageSizeX(i);
      this.mGestureCropImageView.setMaxResultImageSizeY(j);
    }
  }
  
  private void resetRotation()
  {
    GestureCropImageView localGestureCropImageView = this.mGestureCropImageView;
    localGestureCropImageView.postRotate(-localGestureCropImageView.getCurrentAngle());
    this.mGestureCropImageView.setImageToWrapCropBounds();
  }
  
  private void rotateByAngle(int paramInt)
  {
    this.mGestureCropImageView.postRotate(paramInt);
    this.mGestureCropImageView.setImageToWrapCropBounds();
  }
  
  private void setAllowedGestures(int paramInt)
  {
    GestureCropImageView localGestureCropImageView = this.mGestureCropImageView;
    int[] arrayOfInt = this.mAllowedGestures;
    int i = arrayOfInt[paramInt];
    boolean bool2 = false;
    boolean bool1;
    if ((i != 3) && (arrayOfInt[paramInt] != 1)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localGestureCropImageView.setScaleEnabled(bool1);
    localGestureCropImageView = this.mGestureCropImageView;
    arrayOfInt = this.mAllowedGestures;
    if (arrayOfInt[paramInt] != 3)
    {
      bool1 = bool2;
      if (arrayOfInt[paramInt] != 2) {}
    }
    else
    {
      bool1 = true;
    }
    localGestureCropImageView.setRotateEnabled(bool1);
  }
  
  private void setAngleText(float paramFloat)
  {
    TextView localTextView = this.mTextViewRotateAngle;
    if (localTextView != null) {
      localTextView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[] { Float.valueOf(paramFloat) }));
    }
  }
  
  private void setAngleTextColor(int paramInt)
  {
    TextView localTextView = this.mTextViewRotateAngle;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  private void setImageData(Bundle paramBundle)
  {
    Uri localUri1 = (Uri)paramBundle.getParcelable("com.yalantis.ucrop.InputUri");
    Uri localUri2 = (Uri)paramBundle.getParcelable("com.yalantis.ucrop.OutputUri");
    processOptions(paramBundle);
    if ((localUri1 != null) && (localUri2 != null)) {
      try
      {
        this.mGestureCropImageView.setImageUri(localUri1, localUri2);
        return;
      }
      catch (Exception paramBundle)
      {
        this.callback.onCropFinish(getError(paramBundle));
        return;
      }
    }
    this.callback.onCropFinish(getError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
  }
  
  private void setInitialState()
  {
    if (this.mShowBottomControls)
    {
      int i;
      if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
        i = R.id.state_aspect_ratio;
      } else {
        i = R.id.state_scale;
      }
      setWidgetState(i);
      return;
    }
    setAllowedGestures(0);
  }
  
  private void setScaleText(float paramFloat)
  {
    TextView localTextView = this.mTextViewScalePercent;
    if (localTextView != null) {
      localTextView.setText(String.format(Locale.getDefault(), "%d%%", new Object[] { Integer.valueOf((int)(paramFloat * 100.0F)) }));
    }
  }
  
  private void setScaleTextColor(int paramInt)
  {
    TextView localTextView = this.mTextViewScalePercent;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  private void setWidgetState(int paramInt)
  {
    if (!this.mShowBottomControls) {
      return;
    }
    ViewGroup localViewGroup = this.mWrapperStateAspectRatio;
    int i = R.id.state_aspect_ratio;
    boolean bool;
    if (paramInt == i) {
      bool = true;
    } else {
      bool = false;
    }
    localViewGroup.setSelected(bool);
    localViewGroup = this.mWrapperStateRotate;
    int k = R.id.state_rotate;
    if (paramInt == k) {
      bool = true;
    } else {
      bool = false;
    }
    localViewGroup.setSelected(bool);
    localViewGroup = this.mWrapperStateScale;
    int m = R.id.state_scale;
    if (paramInt == m) {
      bool = true;
    } else {
      bool = false;
    }
    localViewGroup.setSelected(bool);
    localViewGroup = this.mLayoutAspectRatio;
    int j = 8;
    if (paramInt == i) {
      i = 0;
    } else {
      i = 8;
    }
    localViewGroup.setVisibility(i);
    localViewGroup = this.mLayoutRotate;
    if (paramInt == k) {
      i = 0;
    } else {
      i = 8;
    }
    localViewGroup.setVisibility(i);
    localViewGroup = this.mLayoutScale;
    i = j;
    if (paramInt == m) {
      i = 0;
    }
    localViewGroup.setVisibility(i);
    changeSelectedTab(paramInt);
    if (paramInt == m)
    {
      setAllowedGestures(0);
      return;
    }
    if (paramInt == k)
    {
      setAllowedGestures(1);
      return;
    }
    setAllowedGestures(2);
  }
  
  private void setupAspectRatioWidget(Bundle paramBundle, View paramView)
  {
    int i = paramBundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
    Object localObject = paramBundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!((ArrayList)localObject).isEmpty()) {}
    }
    else
    {
      i = 2;
      paramBundle = new ArrayList();
      paramBundle.add(new AspectRatio(null, 1.0F, 1.0F));
      paramBundle.add(new AspectRatio(null, 3.0F, 4.0F));
      paramBundle.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0F, 0.0F));
      paramBundle.add(new AspectRatio(null, 3.0F, 2.0F));
      paramBundle.add(new AspectRatio(null, 16.0F, 9.0F));
    }
    paramView = (LinearLayout)paramView.findViewById(R.id.layout_aspect_ratio);
    localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      AspectRatio localAspectRatio = (AspectRatio)paramBundle.next();
      FrameLayout localFrameLayout = (FrameLayout)getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AspectRatioTextView localAspectRatioTextView = (AspectRatioTextView)localFrameLayout.getChildAt(0);
      localAspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
      localAspectRatioTextView.setAspectRatio(localAspectRatio);
      paramView.addView(localFrameLayout);
      this.mCropAspectRatioViews.add(localFrameLayout);
    }
    ((ViewGroup)this.mCropAspectRatioViews.get(i)).setSelected(true);
    paramBundle = this.mCropAspectRatioViews.iterator();
    while (paramBundle.hasNext()) {
      ((ViewGroup)paramBundle.next()).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UCropFragment.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)paramAnonymousView).getChildAt(0)).getAspectRatio(paramAnonymousView.isSelected()));
          UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
          if (!paramAnonymousView.isSelected())
          {
            Iterator localIterator = UCropFragment.this.mCropAspectRatioViews.iterator();
            while (localIterator.hasNext())
            {
              ViewGroup localViewGroup = (ViewGroup)localIterator.next();
              boolean bool;
              if (localViewGroup == paramAnonymousView) {
                bool = true;
              } else {
                bool = false;
              }
              localViewGroup.setSelected(bool);
            }
          }
        }
      });
    }
  }
  
  private void setupRotateWidget(View paramView)
  {
    this.mTextViewRotateAngle = ((TextView)paramView.findViewById(R.id.text_view_rotate));
    int i = R.id.rotate_scroll_wheel;
    ((HorizontalProgressWheelView)paramView.findViewById(i)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener()
    {
      public void onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        UCropFragment.this.mGestureCropImageView.postRotate(paramAnonymousFloat1 / 42.0F);
      }
      
      public void onScrollEnd()
      {
        UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
      }
      
      public void onScrollStart()
      {
        UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
      }
    });
    ((HorizontalProgressWheelView)paramView.findViewById(i)).setMiddleLineColor(this.mActiveControlsWidgetColor);
    paramView.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UCropFragment.this.resetRotation();
      }
    });
    paramView.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UCropFragment.this.rotateByAngle(90);
      }
    });
    setAngleTextColor(this.mActiveControlsWidgetColor);
  }
  
  private void setupScaleWidget(View paramView)
  {
    this.mTextViewScalePercent = ((TextView)paramView.findViewById(R.id.text_view_scale));
    int i = R.id.scale_scroll_wheel;
    ((HorizontalProgressWheelView)paramView.findViewById(i)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener()
    {
      public void onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramAnonymousFloat1 > 0.0F)
        {
          UCropFragment.this.mGestureCropImageView.zoomInImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + paramAnonymousFloat1 * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0F));
          return;
        }
        UCropFragment.this.mGestureCropImageView.zoomOutImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + paramAnonymousFloat1 * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0F));
      }
      
      public void onScrollEnd()
      {
        UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
      }
      
      public void onScrollStart()
      {
        UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
      }
    });
    ((HorizontalProgressWheelView)paramView.findViewById(i)).setMiddleLineColor(this.mActiveControlsWidgetColor);
    setScaleTextColor(this.mActiveControlsWidgetColor);
  }
  
  private void setupStatesWrapper(View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(R.id.image_view_state_scale);
    ImageView localImageView2 = (ImageView)paramView.findViewById(R.id.image_view_state_rotate);
    paramView = (ImageView)paramView.findViewById(R.id.image_view_state_aspect_ratio);
    localImageView1.setImageDrawable(new SelectedStateListDrawable(localImageView1.getDrawable(), this.mActiveControlsWidgetColor));
    localImageView2.setImageDrawable(new SelectedStateListDrawable(localImageView2.getDrawable(), this.mActiveControlsWidgetColor));
    paramView.setImageDrawable(new SelectedStateListDrawable(paramView.getDrawable(), this.mActiveControlsWidgetColor));
  }
  
  public void cropAndSaveImage()
  {
    this.mBlockingView.setClickable(true);
    this.callback.loadingProgress(true);
    this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback()
    {
      public void onBitmapCropped(Uri paramAnonymousUri, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        UCropFragmentCallback localUCropFragmentCallback = UCropFragment.this.callback;
        UCropFragment localUCropFragment = UCropFragment.this;
        localUCropFragmentCallback.onCropFinish(localUCropFragment.getResult(paramAnonymousUri, localUCropFragment.mGestureCropImageView.getTargetAspectRatio(), paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        UCropFragment.this.callback.loadingProgress(false);
      }
      
      public void onCropFailure(Throwable paramAnonymousThrowable)
      {
        UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(paramAnonymousThrowable));
      }
    });
  }
  
  protected UCropResult getError(Throwable paramThrowable)
  {
    return new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", paramThrowable));
  }
  
  protected UCropResult getResult(Uri paramUri, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new UCropResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", paramUri).putExtra("com.yalantis.ucrop.CropAspectRatio", paramFloat).putExtra("com.yalantis.ucrop.ImageWidth", paramInt3).putExtra("com.yalantis.ucrop.ImageHeight", paramInt4).putExtra("com.yalantis.ucrop.OffsetX", paramInt1).putExtra("com.yalantis.ucrop.OffsetY", paramInt2));
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((getParentFragment() instanceof UCropFragmentCallback)) {
      paramContext = getParentFragment();
    }
    while ((paramContext instanceof UCropFragmentCallback))
    {
      this.callback = ((UCropFragmentCallback)paramContext);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.toString());
    localStringBuilder.append(" must implement UCropFragmentCallback");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.ucrop_fragment_photobox, paramViewGroup, false);
    paramViewGroup = getArguments();
    setupViews(paramLayoutInflater, paramViewGroup);
    setImageData(paramViewGroup);
    setInitialState();
    addBlockingView(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void setCallback(UCropFragmentCallback paramUCropFragmentCallback)
  {
    this.callback = paramUCropFragmentCallback;
  }
  
  public void setupViews(View paramView, Bundle paramBundle)
  {
    this.mActiveControlsWidgetColor = paramBundle.getInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", b.b(getContext(), R.color.ucrop_color_widget_active));
    this.mLogoColor = paramBundle.getInt("com.yalantis.ucrop.UcropLogoColor", b.b(getContext(), R.color.ucrop_color_default_logo));
    this.mShowBottomControls = (paramBundle.getBoolean("com.yalantis.ucrop.HideBottomControls", false) ^ true);
    this.mRootViewBackgroundColor = paramBundle.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", b.b(getContext(), R.color.ucrop_color_crop_background));
    initiateRootViews(paramView);
    this.callback.loadingProgress(true);
    if (this.mShowBottomControls)
    {
      Object localObject = (ViewGroup)paramView.findViewById(R.id.controls_wrapper);
      ((ViewGroup)localObject).setVisibility(0);
      LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, (ViewGroup)localObject, true);
      localObject = new AutoTransition();
      this.mControlsTransition = ((Transition)localObject);
      ((Transition)localObject).b0(50L);
      localObject = (ViewGroup)paramView.findViewById(R.id.state_aspect_ratio);
      this.mWrapperStateAspectRatio = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      localObject = (ViewGroup)paramView.findViewById(R.id.state_rotate);
      this.mWrapperStateRotate = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      localObject = (ViewGroup)paramView.findViewById(R.id.state_scale);
      this.mWrapperStateScale = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      this.mLayoutAspectRatio = ((ViewGroup)paramView.findViewById(R.id.layout_aspect_ratio));
      this.mLayoutRotate = ((ViewGroup)paramView.findViewById(R.id.layout_rotate_wheel));
      this.mLayoutScale = ((ViewGroup)paramView.findViewById(R.id.layout_scale_wheel));
      setupAspectRatioWidget(paramBundle, paramView);
      setupRotateWidget(paramView);
      setupScaleWidget(paramView);
      setupStatesWrapper(paramView);
      return;
    }
    int i = R.id.ucrop_frame;
    ((RelativeLayout.LayoutParams)paramView.findViewById(i).getLayoutParams()).bottomMargin = 0;
    paramView.findViewById(i).requestLayout();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GestureTypes {}
  
  public class UCropResult
  {
    public int mResultCode;
    public Intent mResultData;
    
    public UCropResult(int paramInt, Intent paramIntent)
    {
      this.mResultCode = paramInt;
      this.mResultData = paramIntent;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.UCropFragment
 * JD-Core Version:    0.7.0.1
 */