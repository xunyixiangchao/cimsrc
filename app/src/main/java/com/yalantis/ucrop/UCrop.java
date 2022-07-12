package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class UCrop
{
  public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
  public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
  public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
  public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
  public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
  public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
  public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
  public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
  public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
  public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
  public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
  public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
  private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
  public static final int MIN_SIZE = 10;
  public static final int REQUEST_CROP = 69;
  public static final int RESULT_ERROR = 96;
  private Intent mCropIntent = new Intent();
  private Bundle mCropOptionsBundle;
  
  private UCrop(Uri paramUri1, Uri paramUri2)
  {
    Bundle localBundle = new Bundle();
    this.mCropOptionsBundle = localBundle;
    localBundle.putParcelable("com.yalantis.ucrop.InputUri", paramUri1);
    this.mCropOptionsBundle.putParcelable("com.yalantis.ucrop.OutputUri", paramUri2);
  }
  
  public static Throwable getError(Intent paramIntent)
  {
    return (Throwable)paramIntent.getSerializableExtra("com.yalantis.ucrop.Error");
  }
  
  public static Uri getOutput(Intent paramIntent)
  {
    return (Uri)paramIntent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
  }
  
  public static float getOutputCropAspectRatio(Intent paramIntent)
  {
    return paramIntent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0F);
  }
  
  public static int getOutputImageHeight(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.yalantis.ucrop.ImageHeight", -1);
  }
  
  public static int getOutputImageWidth(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.yalantis.ucrop.ImageWidth", -1);
  }
  
  public static UCrop of(Uri paramUri1, Uri paramUri2)
  {
    return new UCrop(paramUri1, paramUri2);
  }
  
  public UCropFragment getFragment()
  {
    return UCropFragment.newInstance(this.mCropOptionsBundle);
  }
  
  public UCropFragment getFragment(Bundle paramBundle)
  {
    this.mCropOptionsBundle = paramBundle;
    return getFragment();
  }
  
  public Intent getIntent(Context paramContext)
  {
    this.mCropIntent.setClass(paramContext, UCropActivity.class);
    this.mCropIntent.putExtras(this.mCropOptionsBundle);
    return this.mCropIntent;
  }
  
  public void start(Activity paramActivity)
  {
    start(paramActivity, 69);
  }
  
  public void start(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(getIntent(paramActivity), paramInt);
  }
  
  public void start(Context paramContext, android.app.Fragment paramFragment)
  {
    start(paramContext, paramFragment, 69);
  }
  
  @TargetApi(11)
  public void start(Context paramContext, android.app.Fragment paramFragment, int paramInt)
  {
    paramFragment.startActivityForResult(getIntent(paramContext), paramInt);
  }
  
  public void start(Context paramContext, androidx.fragment.app.Fragment paramFragment)
  {
    start(paramContext, paramFragment, 69);
  }
  
  public void start(Context paramContext, androidx.fragment.app.Fragment paramFragment, int paramInt)
  {
    paramFragment.startActivityForResult(getIntent(paramContext), paramInt);
  }
  
  public UCrop useSourceImageAspectRatio()
  {
    this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0F);
    this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0F);
    return this;
  }
  
  public UCrop withAspectRatio(float paramFloat1, float paramFloat2)
  {
    this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioX", paramFloat1);
    this.mCropOptionsBundle.putFloat("com.yalantis.ucrop.AspectRatioY", paramFloat2);
    return this;
  }
  
  public UCrop withMaxResultSize(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 10) {
      i = 10;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 10) {
      paramInt1 = 10;
    }
    this.mCropOptionsBundle.putInt("com.yalantis.ucrop.MaxSizeX", i);
    this.mCropOptionsBundle.putInt("com.yalantis.ucrop.MaxSizeY", paramInt1);
    return this;
  }
  
  public UCrop withOptions(Options paramOptions)
  {
    this.mCropOptionsBundle.putAll(paramOptions.getOptionBundle());
    return this;
  }
  
  public static class Options
  {
    public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
    public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
    public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
    public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
    public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
    public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
    public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
    public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
    public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
    public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
    public static final String EXTRA_CROP_GRID_CORNER_COLOR = "com.yalantis.ucrop.CropGridCornerColor";
    public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
    public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
    public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
    public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
    public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
    public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
    public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
    public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
    public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
    public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
    public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
    public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
    public static final String EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorControlsWidgetActive";
    public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
    public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
    public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
    public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
    public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
    public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCropDrawable";
    private final Bundle mOptionBundle = new Bundle();
    
    public Bundle getOptionBundle()
    {
      return this.mOptionBundle;
    }
    
    public void setActiveControlsWidgetColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", paramInt);
    }
    
    public void setAllowedGestures(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mOptionBundle.putIntArray("com.yalantis.ucrop.AllowedGestures", new int[] { paramInt1, paramInt2, paramInt3 });
    }
    
    public void setAspectRatioOptions(int paramInt, AspectRatio... paramVarArgs)
    {
      if (paramInt < paramVarArgs.length)
      {
        this.mOptionBundle.putInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", paramInt);
        this.mOptionBundle.putParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions", new ArrayList(Arrays.asList(paramVarArgs)));
        return;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] (0-based) cannot be higher or equal than aspect ratio options count [count = %d].", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVarArgs.length) }));
    }
    
    public void setCircleDimmedLayer(boolean paramBoolean)
    {
      this.mOptionBundle.putBoolean("com.yalantis.ucrop.CircleDimmedLayer", paramBoolean);
    }
    
    public void setCompressionFormat(Bitmap.CompressFormat paramCompressFormat)
    {
      this.mOptionBundle.putString("com.yalantis.ucrop.CompressionFormatName", paramCompressFormat.name());
    }
    
    public void setCompressionQuality(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CompressionQuality", paramInt);
    }
    
    public void setCropFrameColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropFrameColor", paramInt);
    }
    
    public void setCropFrameStrokeWidth(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropFrameStrokeWidth", paramInt);
    }
    
    public void setCropGridColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridColor", paramInt);
    }
    
    public void setCropGridColumnCount(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridColumnCount", paramInt);
    }
    
    public void setCropGridCornerColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridCornerColor", paramInt);
    }
    
    public void setCropGridRowCount(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridRowCount", paramInt);
    }
    
    public void setCropGridStrokeWidth(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.CropGridStrokeWidth", paramInt);
    }
    
    public void setDimmedLayerColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.DimmedLayerColor", paramInt);
    }
    
    public void setFreeStyleCropEnabled(boolean paramBoolean)
    {
      this.mOptionBundle.putBoolean("com.yalantis.ucrop.FreeStyleCrop", paramBoolean);
    }
    
    public void setHideBottomControls(boolean paramBoolean)
    {
      this.mOptionBundle.putBoolean("com.yalantis.ucrop.HideBottomControls", paramBoolean);
    }
    
    public void setImageToCropBoundsAnimDuration(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", paramInt);
    }
    
    public void setLogoColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropLogoColor", paramInt);
    }
    
    public void setMaxBitmapSize(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.MaxBitmapSize", paramInt);
    }
    
    public void setMaxScaleMultiplier(float paramFloat)
    {
      this.mOptionBundle.putFloat("com.yalantis.ucrop.MaxScaleMultiplier", paramFloat);
    }
    
    public void setRootViewBackgroundColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", paramInt);
    }
    
    public void setShowCropFrame(boolean paramBoolean)
    {
      this.mOptionBundle.putBoolean("com.yalantis.ucrop.ShowCropFrame", paramBoolean);
    }
    
    public void setShowCropGrid(boolean paramBoolean)
    {
      this.mOptionBundle.putBoolean("com.yalantis.ucrop.ShowCropGrid", paramBoolean);
    }
    
    public void setStatusBarColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.StatusBarColor", paramInt);
    }
    
    public void setToolbarCancelDrawable(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropToolbarCancelDrawable", paramInt);
    }
    
    public void setToolbarColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.ToolbarColor", paramInt);
    }
    
    public void setToolbarCropDrawable(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropToolbarCropDrawable", paramInt);
    }
    
    public void setToolbarTitle(String paramString)
    {
      this.mOptionBundle.putString("com.yalantis.ucrop.UcropToolbarTitleText", paramString);
    }
    
    public void setToolbarWidgetColor(int paramInt)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", paramInt);
    }
    
    public void useSourceImageAspectRatio()
    {
      this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0F);
      this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0F);
    }
    
    public void withAspectRatio(float paramFloat1, float paramFloat2)
    {
      this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioX", paramFloat1);
      this.mOptionBundle.putFloat("com.yalantis.ucrop.AspectRatioY", paramFloat2);
    }
    
    public void withMaxResultSize(int paramInt1, int paramInt2)
    {
      this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeX", paramInt1);
      this.mOptionBundle.putInt("com.yalantis.ucrop.MaxSizeY", paramInt2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.UCrop
 * JD-Core Version:    0.7.0.1
 */