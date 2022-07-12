package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R.attr;

public class AppCompatImageButton
  extends ImageButton
{
  private final d a;
  private final k b;
  private boolean c = false;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new k(this);
    this.b = paramContext;
    paramContext.g(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.b;
    if (localObject != null) {
      ((k)localObject).c();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    k localk = this.b;
    if (localk != null) {
      return localk.d();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    k localk = this.b;
    if (localk != null) {
      return localk.e();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.b.f()) && (super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.a;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.a;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = this.b;
    if (paramBitmap != null) {
      paramBitmap.c();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    k localk = this.b;
    if ((localk != null) && (paramDrawable != null) && (!this.c)) {
      localk.h(paramDrawable);
    }
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null)
    {
      paramDrawable.c();
      if (!this.c) {
        this.b.b();
      }
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    super.setImageLevel(paramInt);
    this.c = true;
  }
  
  public void setImageResource(int paramInt)
  {
    this.b.i(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.b;
    if (paramUri != null) {
      paramUri.c();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.a;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.a;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    k localk = this.b;
    if (localk != null) {
      localk.j(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    k localk = this.b;
    if (localk != null) {
      localk.k(paramMode);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */