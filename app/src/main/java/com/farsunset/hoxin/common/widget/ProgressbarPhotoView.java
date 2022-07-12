package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.x;
import com.farsunset.hoxin.common.model.CloudImage;
import com.github.chrisbanes.photoview.PhotoView;
import d7.f;
import s3.c;
import s3.d;
import u3.l;
import u3.r;
import u3.s;

public class ProgressbarPhotoView
  extends RelativeLayout
  implements c
{
  private ProgressBar a;
  private WebPhotoView b;
  private Bitmap c;
  
  public ProgressbarPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void c(final CloudImage paramCloudImage, final c paramc)
  {
    String str = l.w(paramCloudImage);
    paramCloudImage = l.v(paramCloudImage);
    this.b.setTag(str);
    x.K0(this.b, str);
    s.a().g(str, new a(paramc, paramCloudImage));
  }
  
  public Bitmap getBitmap()
  {
    return this.c;
  }
  
  public void l0(Object paramObject, ImageView paramImageView)
  {
    this.a.setVisibility(8);
    this.b.setImageResource(2131165738);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((WebPhotoView)findViewById(2131231072));
    this.a = ((ProgressBar)findViewById(2131231366));
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    this.a.setVisibility(8);
    this.c = paramBitmapDrawable.getBitmap();
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.b.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnPhotoTapListener(f paramf)
  {
    this.b.setOnPhotoTapListener(paramf);
  }
  
  class a
    implements d
  {
    a(c paramc, String paramString) {}
    
    public void D0(Object paramObject, Bitmap paramBitmap)
    {
      if (ProgressbarPhotoView.a(ProgressbarPhotoView.this).d()) {
        return;
      }
      ProgressbarPhotoView.a(ProgressbarPhotoView.this).setImageBitmap(paramBitmap);
      paramc.p(paramObject, ProgressbarPhotoView.a(ProgressbarPhotoView.this), new BitmapDrawable(ProgressbarPhotoView.this.getResources(), paramBitmap));
      ProgressbarPhotoView.a(ProgressbarPhotoView.this).postDelayed(new a(this, paramCloudImage, paramBitmap), 500L);
    }
    
    public void v(Object paramObject)
    {
      D0(paramObject, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.ProgressbarPhotoView
 * JD-Core Version:    0.7.0.1
 */