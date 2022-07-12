package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView
  extends ImageView
{
  private final d mBackgroundTintHelper;
  private boolean mHasLevel = false;
  private final k mImageHelper;
  
  public AppCompatImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.mBackgroundTintHelper = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new k(this);
    this.mImageHelper = paramContext;
    paramContext.g(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.mImageHelper;
    if (localObject != null) {
      ((k)localObject).c();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    k localk = this.mImageHelper;
    if (localk != null) {
      return localk.d();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    k localk = this.mImageHelper;
    if (localk != null) {
      return localk.e();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.mImageHelper.f()) && (super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = this.mImageHelper;
    if (paramBitmap != null) {
      paramBitmap.c();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    k localk = this.mImageHelper;
    if ((localk != null) && (paramDrawable != null) && (!this.mHasLevel)) {
      localk.h(paramDrawable);
    }
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.mImageHelper;
    if (paramDrawable != null)
    {
      paramDrawable.c();
      if (!this.mHasLevel) {
        this.mImageHelper.b();
      }
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    super.setImageLevel(paramInt);
    this.mHasLevel = true;
  }
  
  public void setImageResource(int paramInt)
  {
    k localk = this.mImageHelper;
    if (localk != null) {
      localk.i(paramInt);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.mImageHelper;
    if (paramUri != null) {
      paramUri.c();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    k localk = this.mImageHelper;
    if (localk != null) {
      localk.j(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    k localk = this.mImageHelper;
    if (localk != null) {
      localk.k(paramMode);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageView
 * JD-Core Version:    0.7.0.1
 */