package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
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

public class UCropActivity
  extends AppCompatActivity
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
  private static final String TAG = "UCropActivity";
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
      UCropActivity.this.mUCropView.animate().alpha(1.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator());
      UCropActivity.this.mBlockingView.setClickable(false);
      UCropActivity.access$402(UCropActivity.this, false);
      UCropActivity.this.supportInvalidateOptionsMenu();
    }
    
    public void onLoadFailure(Exception paramAnonymousException)
    {
      UCropActivity.this.setResultError(paramAnonymousException);
      UCropActivity.this.finish();
    }
    
    public void onRotate(float paramAnonymousFloat)
    {
      UCropActivity.this.setAngleText(paramAnonymousFloat);
    }
    
    public void onScale(float paramAnonymousFloat)
    {
      UCropActivity.this.setScaleText(paramAnonymousFloat);
    }
  };
  private ViewGroup mLayoutAspectRatio;
  private ViewGroup mLayoutRotate;
  private ViewGroup mLayoutScale;
  private int mLogoColor;
  private OverlayView mOverlayView;
  private int mRootViewBackgroundColor;
  private boolean mShowBottomControls;
  private boolean mShowLoader = true;
  private final View.OnClickListener mStateClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!paramAnonymousView.isSelected()) {
        UCropActivity.this.setWidgetState(paramAnonymousView.getId());
      }
    }
  };
  private int mStatusBarColor;
  private TextView mTextViewRotateAngle;
  private TextView mTextViewScalePercent;
  private int mToolbarCancelDrawable;
  private int mToolbarColor;
  private int mToolbarCropDrawable;
  private String mToolbarTitle;
  private int mToolbarWidgetColor;
  private UCropView mUCropView;
  private ViewGroup mWrapperStateAspectRatio;
  private ViewGroup mWrapperStateRotate;
  private ViewGroup mWrapperStateScale;
  
  static
  {
    d.D(true);
  }
  
  private void addBlockingView()
  {
    if (this.mBlockingView == null)
    {
      this.mBlockingView = new View(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, R.id.toolbar);
      this.mBlockingView.setLayoutParams(localLayoutParams);
      this.mBlockingView.setClickable(true);
    }
    ((RelativeLayout)findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
  }
  
  private void changeSelectedTab(int paramInt)
  {
    r.a((ViewGroup)findViewById(R.id.ucrop_photobox), this.mControlsTransition);
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
  
  private void initiateRootViews()
  {
    UCropView localUCropView = (UCropView)findViewById(R.id.ucrop);
    this.mUCropView = localUCropView;
    this.mGestureCropImageView = localUCropView.getCropImageView();
    this.mOverlayView = this.mUCropView.getOverlayView();
    this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
    ((ImageView)findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
    int i = R.id.ucrop_frame;
    findViewById(i).setBackgroundColor(this.mRootViewBackgroundColor);
    if (!this.mShowBottomControls)
    {
      ((RelativeLayout.LayoutParams)findViewById(i).getLayoutParams()).bottomMargin = 0;
      findViewById(i).requestLayout();
    }
  }
  
  private void processOptions(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
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
    this.mCompressQuality = paramIntent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
    localObject1 = paramIntent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
    if ((localObject1 != null) && (localObject1.length == 3)) {
      this.mAllowedGestures = ((int[])localObject1);
    }
    this.mGestureCropImageView.setMaxBitmapSize(paramIntent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
    this.mGestureCropImageView.setMaxScaleMultiplier(paramIntent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0F));
    this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(paramIntent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
    this.mOverlayView.setFreestyleCropEnabled(paramIntent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
    this.mOverlayView.setDimmedColor(paramIntent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
    this.mOverlayView.setCircleDimmedLayer(paramIntent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
    this.mOverlayView.setShowCropFrame(paramIntent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
    this.mOverlayView.setCropFrameColor(paramIntent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
    this.mOverlayView.setCropFrameStrokeWidth(paramIntent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
    this.mOverlayView.setShowCropGrid(paramIntent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
    this.mOverlayView.setCropGridRowCount(paramIntent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
    this.mOverlayView.setCropGridColumnCount(paramIntent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
    localObject1 = this.mOverlayView;
    localObject2 = getResources();
    int i = R.color.ucrop_color_default_crop_grid;
    ((OverlayView)localObject1).setCropGridColor(paramIntent.getIntExtra("com.yalantis.ucrop.CropGridColor", ((Resources)localObject2).getColor(i)));
    this.mOverlayView.setCropGridCornerColor(paramIntent.getIntExtra("com.yalantis.ucrop.CropGridCornerColor", getResources().getColor(i)));
    this.mOverlayView.setCropGridStrokeWidth(paramIntent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
    float f1 = paramIntent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", -1.0F);
    float f3 = paramIntent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", -1.0F);
    i = paramIntent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
    localObject1 = paramIntent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
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
        break label579;
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
    break label587;
    label579:
    this.mGestureCropImageView.setTargetAspectRatio(0.0F);
    label587:
    i = paramIntent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
    int j = paramIntent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
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
  
  private void setImageData(Intent paramIntent)
  {
    Uri localUri1 = (Uri)paramIntent.getParcelableExtra("com.yalantis.ucrop.InputUri");
    Uri localUri2 = (Uri)paramIntent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    processOptions(paramIntent);
    if ((localUri1 != null) && (localUri2 != null)) {
      try
      {
        this.mGestureCropImageView.setImageUri(localUri1, localUri2);
        return;
      }
      catch (Exception paramIntent) {}
    } else {
      paramIntent = new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent));
    }
    setResultError(paramIntent);
    finish();
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
  
  @TargetApi(21)
  private void setStatusBarColor(int paramInt)
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
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
  
  private void setupAppBar()
  {
    setStatusBarColor(this.mStatusBarColor);
    Object localObject1 = (Toolbar)findViewById(R.id.toolbar);
    ((ViewGroup)localObject1).setBackgroundColor(this.mToolbarColor);
    ((Toolbar)localObject1).setTitleTextColor(this.mToolbarWidgetColor);
    Object localObject2 = (TextView)((ViewGroup)localObject1).findViewById(R.id.toolbar_title);
    ((TextView)localObject2).setTextColor(this.mToolbarWidgetColor);
    ((TextView)localObject2).setText(this.mToolbarTitle);
    localObject2 = b.d(this, this.mToolbarCancelDrawable).mutate();
    ((Drawable)localObject2).setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
    ((Toolbar)localObject1).setNavigationIcon((Drawable)localObject2);
    setSupportActionBar((Toolbar)localObject1);
    localObject1 = getSupportActionBar();
    if (localObject1 != null) {
      ((ActionBar)localObject1).u(false);
    }
  }
  
  private void setupAspectRatioWidget(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
    Object localObject = paramIntent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
    if (localObject != null)
    {
      paramIntent = (Intent)localObject;
      if (!((ArrayList)localObject).isEmpty()) {}
    }
    else
    {
      i = 2;
      paramIntent = new ArrayList();
      paramIntent.add(new AspectRatio(null, 1.0F, 1.0F));
      paramIntent.add(new AspectRatio(null, 3.0F, 4.0F));
      paramIntent.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0F, 0.0F));
      paramIntent.add(new AspectRatio(null, 3.0F, 2.0F));
      paramIntent.add(new AspectRatio(null, 16.0F, 9.0F));
    }
    localObject = (LinearLayout)findViewById(R.id.layout_aspect_ratio);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      AspectRatio localAspectRatio = (AspectRatio)paramIntent.next();
      FrameLayout localFrameLayout = (FrameLayout)getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
      localFrameLayout.setLayoutParams(localLayoutParams);
      AspectRatioTextView localAspectRatioTextView = (AspectRatioTextView)localFrameLayout.getChildAt(0);
      localAspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
      localAspectRatioTextView.setAspectRatio(localAspectRatio);
      ((LinearLayout)localObject).addView(localFrameLayout);
      this.mCropAspectRatioViews.add(localFrameLayout);
    }
    ((ViewGroup)this.mCropAspectRatioViews.get(i)).setSelected(true);
    paramIntent = this.mCropAspectRatioViews.iterator();
    while (paramIntent.hasNext()) {
      ((ViewGroup)paramIntent.next()).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)paramAnonymousView).getChildAt(0)).getAspectRatio(paramAnonymousView.isSelected()));
          UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
          if (!paramAnonymousView.isSelected())
          {
            Iterator localIterator = UCropActivity.this.mCropAspectRatioViews.iterator();
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
  
  private void setupRotateWidget()
  {
    this.mTextViewRotateAngle = ((TextView)findViewById(R.id.text_view_rotate));
    int i = R.id.rotate_scroll_wheel;
    ((HorizontalProgressWheelView)findViewById(i)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener()
    {
      public void onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        UCropActivity.this.mGestureCropImageView.postRotate(paramAnonymousFloat1 / 42.0F);
      }
      
      public void onScrollEnd()
      {
        UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
      }
      
      public void onScrollStart()
      {
        UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
      }
    });
    ((HorizontalProgressWheelView)findViewById(i)).setMiddleLineColor(this.mActiveControlsWidgetColor);
    findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UCropActivity.this.resetRotation();
      }
    });
    findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UCropActivity.this.rotateByAngle(90);
      }
    });
    setAngleTextColor(this.mActiveControlsWidgetColor);
  }
  
  private void setupScaleWidget()
  {
    this.mTextViewScalePercent = ((TextView)findViewById(R.id.text_view_scale));
    int i = R.id.scale_scroll_wheel;
    ((HorizontalProgressWheelView)findViewById(i)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener()
    {
      public void onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramAnonymousFloat1 > 0.0F)
        {
          UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + paramAnonymousFloat1 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0F));
          return;
        }
        UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + paramAnonymousFloat1 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0F));
      }
      
      public void onScrollEnd()
      {
        UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
      }
      
      public void onScrollStart()
      {
        UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
      }
    });
    ((HorizontalProgressWheelView)findViewById(i)).setMiddleLineColor(this.mActiveControlsWidgetColor);
    setScaleTextColor(this.mActiveControlsWidgetColor);
  }
  
  private void setupStatesWrapper()
  {
    ImageView localImageView1 = (ImageView)findViewById(R.id.image_view_state_scale);
    ImageView localImageView2 = (ImageView)findViewById(R.id.image_view_state_rotate);
    ImageView localImageView3 = (ImageView)findViewById(R.id.image_view_state_aspect_ratio);
    localImageView1.setImageDrawable(new SelectedStateListDrawable(localImageView1.getDrawable(), this.mActiveControlsWidgetColor));
    localImageView2.setImageDrawable(new SelectedStateListDrawable(localImageView2.getDrawable(), this.mActiveControlsWidgetColor));
    localImageView3.setImageDrawable(new SelectedStateListDrawable(localImageView3.getDrawable(), this.mActiveControlsWidgetColor));
  }
  
  private void setupViews(Intent paramIntent)
  {
    this.mStatusBarColor = paramIntent.getIntExtra("com.yalantis.ucrop.StatusBarColor", b.b(this, R.color.ucrop_color_statusbar));
    this.mToolbarColor = paramIntent.getIntExtra("com.yalantis.ucrop.ToolbarColor", b.b(this, R.color.ucrop_color_toolbar));
    this.mActiveControlsWidgetColor = paramIntent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", b.b(this, R.color.ucrop_color_active_controls_color));
    this.mToolbarWidgetColor = paramIntent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", b.b(this, R.color.ucrop_color_toolbar_widget));
    this.mToolbarCancelDrawable = paramIntent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
    this.mToolbarCropDrawable = paramIntent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
    Object localObject = paramIntent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
    this.mToolbarTitle = ((String)localObject);
    if (localObject == null) {
      localObject = getResources().getString(R.string.ucrop_label_edit_photo);
    }
    this.mToolbarTitle = ((String)localObject);
    this.mLogoColor = paramIntent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", b.b(this, R.color.ucrop_color_default_logo));
    this.mShowBottomControls = (paramIntent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false) ^ true);
    this.mRootViewBackgroundColor = paramIntent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", b.b(this, R.color.ucrop_color_crop_background));
    setupAppBar();
    initiateRootViews();
    if (this.mShowBottomControls)
    {
      localObject = (ViewGroup)((ViewGroup)findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
      ((ViewGroup)localObject).setVisibility(0);
      LayoutInflater.from(this).inflate(R.layout.ucrop_controls, (ViewGroup)localObject, true);
      localObject = new AutoTransition();
      this.mControlsTransition = ((Transition)localObject);
      ((Transition)localObject).b0(50L);
      localObject = (ViewGroup)findViewById(R.id.state_aspect_ratio);
      this.mWrapperStateAspectRatio = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      localObject = (ViewGroup)findViewById(R.id.state_rotate);
      this.mWrapperStateRotate = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      localObject = (ViewGroup)findViewById(R.id.state_scale);
      this.mWrapperStateScale = ((ViewGroup)localObject);
      ((ViewGroup)localObject).setOnClickListener(this.mStateClickListener);
      this.mLayoutAspectRatio = ((ViewGroup)findViewById(R.id.layout_aspect_ratio));
      this.mLayoutRotate = ((ViewGroup)findViewById(R.id.layout_rotate_wheel));
      this.mLayoutScale = ((ViewGroup)findViewById(R.id.layout_scale_wheel));
      setupAspectRatioWidget(paramIntent);
      setupRotateWidget();
      setupScaleWidget();
      setupStatesWrapper();
    }
  }
  
  protected void cropAndSaveImage()
  {
    this.mBlockingView.setClickable(true);
    this.mShowLoader = true;
    supportInvalidateOptionsMenu();
    this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback()
    {
      public void onBitmapCropped(Uri paramAnonymousUri, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        UCropActivity localUCropActivity = UCropActivity.this;
        localUCropActivity.setResultUri(paramAnonymousUri, localUCropActivity.mGestureCropImageView.getTargetAspectRatio(), paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        UCropActivity.this.finish();
      }
      
      public void onCropFailure(Throwable paramAnonymousThrowable)
      {
        UCropActivity.this.setResultError(paramAnonymousThrowable);
        UCropActivity.this.finish();
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.ucrop_activity_photobox);
    paramBundle = getIntent();
    setupViews(paramBundle);
    setImageData(paramBundle);
    setInitialState();
    addBlockingView();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.ucrop_menu_activity, paramMenu);
    Object localObject = paramMenu.findItem(R.id.menu_loader);
    Drawable localDrawable = ((MenuItem)localObject).getIcon();
    if (localDrawable != null)
    {
      try
      {
        localDrawable.mutate();
        localDrawable.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        ((MenuItem)localObject).setIcon(localDrawable);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.i("UCropActivity", String.format("%s - %s", new Object[] { localIllegalStateException.getMessage(), getString(R.string.ucrop_mutate_exception_hint) }));
      }
      ((Animatable)((MenuItem)localObject).getIcon()).start();
    }
    paramMenu = paramMenu.findItem(R.id.menu_crop);
    localObject = b.d(this, this.mToolbarCropDrawable);
    if (localObject != null)
    {
      ((Drawable)localObject).mutate();
      ((Drawable)localObject).setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
      paramMenu.setIcon((Drawable)localObject);
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_crop)
    {
      cropAndSaveImage();
      return true;
    }
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.findItem(R.id.menu_crop).setVisible(this.mShowLoader ^ true);
    paramMenu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onStop()
  {
    super.onStop();
    GestureCropImageView localGestureCropImageView = this.mGestureCropImageView;
    if (localGestureCropImageView != null) {
      localGestureCropImageView.cancelAllAnimations();
    }
  }
  
  protected void setResultError(Throwable paramThrowable)
  {
    setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", paramThrowable));
  }
  
  protected void setResultUri(Uri paramUri, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", paramUri).putExtra("com.yalantis.ucrop.CropAspectRatio", paramFloat).putExtra("com.yalantis.ucrop.ImageWidth", paramInt3).putExtra("com.yalantis.ucrop.ImageHeight", paramInt4).putExtra("com.yalantis.ucrop.OffsetX", paramInt1).putExtra("com.yalantis.ucrop.OffsetY", paramInt2));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GestureTypes {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.UCropActivity
 * JD-Core Version:    0.7.0.1
 */