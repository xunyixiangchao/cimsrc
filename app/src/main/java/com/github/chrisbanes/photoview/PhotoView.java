package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import d7.d;
import d7.e;
import d7.f;
import d7.g;
import d7.h;
import d7.i;
import d7.j;
import d7.k;

public class PhotoView
  extends AppCompatImageView
{
  private k a;
  private ImageView.ScaleType b;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.a = new k(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    ImageView.ScaleType localScaleType = this.b;
    if (localScaleType != null)
    {
      setScaleType(localScaleType);
      this.b = null;
    }
  }
  
  public k getAttacher()
  {
    return this.a;
  }
  
  public RectF getDisplayRect()
  {
    return this.a.D();
  }
  
  public Matrix getImageMatrix()
  {
    return this.a.G();
  }
  
  public float getMaximumScale()
  {
    return this.a.J();
  }
  
  public float getMediumScale()
  {
    return this.a.K();
  }
  
  public float getMinimumScale()
  {
    return this.a.L();
  }
  
  public float getScale()
  {
    return this.a.M();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.N();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.a.Q(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.a.n0();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.n0();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    k localk = this.a;
    if (localk != null) {
      localk.n0();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.a;
    if (paramUri != null) {
      paramUri.n0();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.a.S(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.a.T(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.a.U(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.V(paramOnClickListener);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.W(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.X(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(d paramd)
  {
    this.a.Y(paramd);
  }
  
  public void setOnOutsidePhotoTapListener(e parame)
  {
    this.a.Z(parame);
  }
  
  public void setOnPhotoTapListener(f paramf)
  {
    this.a.a0(paramf);
  }
  
  public void setOnScaleChangeListener(g paramg)
  {
    this.a.b0(paramg);
  }
  
  public void setOnSingleFlingListener(h paramh)
  {
    this.a.c0(paramh);
  }
  
  public void setOnViewDragListener(i parami)
  {
    this.a.d0(parami);
  }
  
  public void setOnViewTapListener(j paramj)
  {
    this.a.e0(paramj);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.a.f0(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.a.g0(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.a.h0(paramFloat);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    k localk = this.a;
    if (localk == null)
    {
      this.b = paramScaleType;
      return;
    }
    localk.k0(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.a.l0(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.a.m0(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.github.chrisbanes.photoview.PhotoView
 * JD-Core Version:    0.7.0.1
 */