package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.message.entity.Message;
import s3.c;
import u3.c0;
import u3.l;
import u3.r;
import u3.s;

public class ToMessageImageView
  extends BaseToMessageView<ChatImageView>
  implements c
{
  private CircleProgressView h;
  
  public ToMessageImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void r(CloudImage paramCloudImage)
  {
    setVisibility(0);
    this.h.setVisibility(8);
    ((ChatImageView)this.f).setTag(paramCloudImage.uri);
    paramCloudImage = this.f;
    ((ChatImageView)paramCloudImage).setOnClickListener((View.OnClickListener)paramCloudImage);
    i(2);
    ((ChatImageView)this.f).setUploadProgressView(this.h);
  }
  
  public void b(Message paramMessage)
  {
    super.b(paramMessage);
    paramMessage = l.w((CloudImage)l.s0(this.e.content, CloudImage.class));
    ((ChatImageView)this.f).setTag(paramMessage);
  }
  
  public void f()
  {
    CloudImage localCloudImage = (CloudImage)l.s0(this.e.content, CloudImage.class);
    if ((this.e.state.byteValue() != 0) && (localCloudImage.uri == null))
    {
      setVisibility(0);
      r(localCloudImage);
      ((ChatImageView)this.f).i(localCloudImage, this.e);
      return;
    }
    setVisibility(8);
    if (this.e.state.byteValue() == 0) {
      this.e.state = Byte.valueOf((byte)3);
    }
    s.a().h(((ChatImageView)this.f).getImageView(), localCloudImage.uri, this);
  }
  
  protected void j()
  {
    CloudImage localCloudImage = (CloudImage)l.s0(this.e.content, CloudImage.class);
    o3.b localb = o3.b.f;
    c0.e(localb, localCloudImage.thumb);
    c0.e(localb, localCloudImage.image);
  }
  
  public void l0(Object paramObject, ImageView paramImageView) {}
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = ((CircleProgressView)findViewById(2131230885));
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    setVisibility(0);
    paramObject = (CloudImage)l.s0(this.e.content, CloudImage.class);
    if (this.e.state.byteValue() == 3)
    {
      this.e.state = Byte.valueOf((byte)0);
      n5.b.d(this.e);
      paramObject.tw = paramBitmapDrawable.getBitmap().getWidth();
      paramObject.th = paramBitmapDrawable.getBitmap().getHeight();
    }
    r(paramObject);
    ((ChatImageView)this.f).j(paramObject, this.e);
    h();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageImageView
 * JD-Core Version:    0.7.0.1
 */