package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import s3.c;
import s3.d0;
import u3.l;

public class ChatImageView
  extends CardView
  implements View.OnClickListener, d0, c
{
  private WebImageView j;
  private Message k;
  private View l;
  private CircleProgressView m;
  
  public ChatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void h(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      int i = getResources().getDimensionPixelOffset(2131099737);
      WebImageView localWebImageView = this.j;
      FrameLayout.LayoutParams localLayoutParams;
      if (paramInt1 > paramInt2) {
        localLayoutParams = new FrameLayout.LayoutParams(paramInt1 * i / paramInt2, i);
      } else {
        localLayoutParams = new FrameLayout.LayoutParams(i, paramInt2 * i / paramInt1);
      }
      localWebImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(float paramFloat)
  {
    this.m.setProgress((int)paramFloat);
    if (paramFloat >= 100.0F)
    {
      this.m.setVisibility(8);
      return;
    }
    if (paramFloat > 0.0F) {
      this.m.setVisibility(0);
    }
  }
  
  public WebImageView getImageView()
  {
    return this.j;
  }
  
  public void i(CloudImage paramCloudImage, Message paramMessage)
  {
    this.k = paramMessage;
    paramMessage = l.w(paramCloudImage);
    setTag(paramMessage);
    this.l.setVisibility(0);
    h(paramCloudImage.tw, paramCloudImage.th);
    this.j.q(paramMessage, 2131165334, this);
  }
  
  public void j(CloudImage paramCloudImage, Message paramMessage)
  {
    this.k = paramMessage;
    this.l.setVisibility(8);
    h(paramCloudImage.tw, paramCloudImage.th);
  }
  
  public void l0(Object paramObject, ImageView paramImageView)
  {
    p(paramObject, paramImageView, null);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent("com.farsunset.hoxin.ACTION_OPEN_GALLERY");
    paramView.putExtra(Message.NAME, this.k);
    HoxinApplication.t(paramView);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.j = ((WebImageView)findViewById(2131231072));
    this.l = findViewById(2131231143);
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    ((ChatImageView)paramImageView.getParent()).l.setVisibility(8);
  }
  
  public void setUploadProgressView(CircleProgressView paramCircleProgressView)
  {
    this.m = paramCircleProgressView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatImageView
 * JD-Core Version:    0.7.0.1
 */