package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.ui.MapViewActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.model.ChatMap;
import s3.a;
import s3.c;
import s3.d0;
import u3.b0;
import u3.l;

public class ChatMapView
  extends CardView
  implements View.OnClickListener, d0, c
{
  private WebImageView j;
  private TextView k;
  private TextView l;
  private View m;
  private ProgressBar n;
  private final Handler o = new a();
  private ChatMap p;
  
  public ChatMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(float paramFloat)
  {
    this.n.setProgress((int)paramFloat);
    if (paramFloat >= 100.0F)
    {
      this.o.removeMessages(0);
      this.o.sendEmptyMessageDelayed(0, 100L);
    }
  }
  
  public void i(com.farsunset.hoxin.message.entity.Message paramMessage)
  {
    paramMessage = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
    this.p = paramMessage;
    setTag(paramMessage.image);
    this.k.setText(this.p.address);
    this.l.setText(this.p.name);
    paramMessage = b0.c(this.p.image);
    this.m.setVisibility(0);
    this.j.q(paramMessage, 2131165335, this);
  }
  
  public void l0(Object paramObject, ImageView paramImageView)
  {
    ((ChatMapView)paramImageView.getParent()).m.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(getContext(), MapViewActivity.class);
    paramView.putExtra(MapAddress.class.getName(), this.p);
    getContext().startActivity(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.o.removeCallbacksAndMessages(null);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.k = ((TextView)findViewById(2131230797));
    this.j = ((WebImageView)findViewById(2131231072));
    this.l = ((TextView)findViewById(2131231301));
    this.m = findViewById(2131231143);
    this.n = ((ProgressBar)findViewById(2131231601));
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    ((ChatMapView)paramImageView.getParent()).m.setVisibility(8);
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(android.os.Message paramMessage)
    {
      paramMessage = AnimationUtils.loadAnimation(HoxinApplication.h(), 2130772003);
      paramMessage.setAnimationListener(new a());
      ChatMapView.h(ChatMapView.this).startAnimation(paramMessage);
    }
    
    class a
      extends a
    {
      a() {}
      
      public void onAnimationEnd(Animation paramAnimation)
      {
        ChatMapView.h(ChatMapView.this).setVisibility(8);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatMapView
 * JD-Core Version:    0.7.0.1
 */