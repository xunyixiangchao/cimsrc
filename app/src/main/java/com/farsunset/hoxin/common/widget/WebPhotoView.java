package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;
import s3.c;
import u3.r;
import u3.s;

public class WebPhotoView
  extends PhotoView
{
  private boolean c = false;
  
  public WebPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(String paramString, Bitmap paramBitmap, c paramc)
  {
    if (paramBitmap == null)
    {
      s.a().h(this, paramString, paramc);
      return;
    }
    s.a().e(this, paramString, paramBitmap, paramc);
  }
  
  public void b(String paramString, c paramc)
  {
    s.a().h(this, paramString, paramc);
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = false;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.WebPhotoView
 * JD-Core Version:    0.7.0.1
 */