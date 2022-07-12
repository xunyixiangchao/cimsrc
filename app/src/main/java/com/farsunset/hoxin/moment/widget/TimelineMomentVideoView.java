package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.moment.entity.Moment;
import j6.a;
import java.io.File;
import o3.b;
import s3.c;
import u3.a0;
import u3.b0;
import u3.l;

public class TimelineMomentVideoView
  extends TimelineMomentView
  implements c
{
  private WebImageView n;
  private CloudVideo o;
  
  public TimelineMomentVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void j(int paramInt1, int paramInt2)
  {
    int i = getResources().getDimensionPixelOffset(2131100244);
    WebImageView localWebImageView = this.n;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt1 > paramInt2) {
      localLayoutParams = new FrameLayout.LayoutParams(paramInt1 * i / paramInt2, i);
    } else {
      localLayoutParams = new FrameLayout.LayoutParams(i, paramInt2 * i / paramInt1);
    }
    localWebImageView.setLayoutParams(localLayoutParams);
  }
  
  public void g(Moment paramMoment, User paramUser, a parama)
  {
    super.g(paramMoment, paramUser, parama);
    paramMoment = (CloudVideo)l.s0(paramMoment.content, CloudVideo.class);
    this.o = paramMoment;
    int i;
    if (paramMoment.mode == 0)
    {
      this.n.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131100243);
      paramMoment = this.n.getLayoutParams();
      i = getContext().getResources().getDimensionPixelOffset(2131100244);
    }
    else
    {
      this.n.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131100244);
      paramMoment = this.n.getLayoutParams();
      i = getContext().getResources().getDimensionPixelOffset(2131100243);
    }
    paramMoment.height = i;
    this.n.requestLayout();
    paramMoment = this.o.image;
    if (paramMoment == null) {
      return;
    }
    paramMoment = a0.g(paramMoment);
    if (paramMoment.exists())
    {
      this.n.n(paramMoment, this);
      return;
    }
    paramMoment = b0.h(this.o.image);
    this.n.r(paramMoment, this);
  }
  
  public void l0(Object paramObject, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.n.getParent())
    {
      this.o.bucket = b.g.a();
      HoxinApplication.h().C(getContext(), this.o, (View)this.n.getParent());
      return;
    }
    super.onClick(paramView);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    WebImageView localWebImageView = (WebImageView)findViewById(2131231552);
    this.n = localWebImageView;
    ((ViewGroup)localWebImageView.getParent()).setOnClickListener(this);
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    j(paramBitmapDrawable.getBitmap().getWidth(), paramBitmapDrawable.getBitmap().getHeight());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentVideoView
 * JD-Core Version:    0.7.0.1
 */