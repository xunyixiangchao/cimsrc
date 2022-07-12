package com.farsunset.hoxin.message.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatVoice;
import f5.a;
import java.io.File;
import r5.i;
import s3.f;
import u3.a0;
import u3.i0;
import u3.l;
import u3.z;

public class ChatVoiceView
  extends FrameLayout
  implements View.OnClickListener, i, f
{
  private Message a;
  private File b;
  private final int c;
  private TextView d;
  private ChatVoice e;
  private ValueAnimator f;
  
  public ChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.c = ((int)(Resources.getSystem().getDisplayMetrics().widthPixels - (f1 * 160.0F + 0.5F)));
  }
  
  private void c()
  {
    setAlpha(1.0F);
    findViewById(2131231625).setVisibility(0);
    this.d.setVisibility(0);
    ValueAnimator localValueAnimator = this.f;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.f.cancel();
    }
  }
  
  private void e()
  {
    Object localObject = this.e.file;
    if (localObject == null) {
      return;
    }
    setTag(localObject);
    localObject = a0.g(this.e.file);
    this.b = ((File)localObject);
    if (!((File)localObject).exists())
    {
      setOnClickListener(null);
      localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.5F, 1.0F, 0.5F });
      this.f = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setDuration(1200L);
      this.f.setRepeatCount(-1);
      this.f.setRepeatMode(1);
      this.f.start();
      findViewById(2131231625).setVisibility(8);
      this.d.setVisibility(8);
      z.h(o3.b.f, a0.g(this.e.file), this);
      return;
    }
    setOnClickListener(this);
    c();
  }
  
  public void O(File paramFile, String paramString)
  {
    setOnClickListener(this);
    c();
  }
  
  public void a()
  {
    findViewById(2131231625).setVisibility(0);
    findViewById(2131231624).setVisibility(8);
    ((AnimationDrawable)((ImageView)findViewById(2131231624)).getDrawable()).stop();
    if (((getParent() instanceof FromMessageVoiceView)) && (this.a.state.byteValue() != 12))
    {
      this.a.state = Byte.valueOf((byte)12);
      n5.b.d(this.a);
      ((FromMessageVoiceView)getParent()).g();
      a.d(this.a);
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void d(Message paramMessage, boolean paramBoolean)
  {
    this.a = paramMessage;
    this.e = ((ChatVoice)l.s0(paramMessage.content, ChatVoice.class));
    if (getChildCount() == 0)
    {
      paramMessage = LayoutInflater.from(getContext());
      if (paramBoolean) {
        i = 2131427548;
      } else {
        i = 2131427547;
      }
      paramMessage.inflate(i, this);
      this.d = ((TextView)findViewById(2131231133));
    }
    e();
    paramMessage = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e.length);
    localStringBuilder.append("\"");
    paramMessage.setText(localStringBuilder.toString());
    int i = getContext().getResources().getDimensionPixelOffset(2131099740);
    int j = (int)((this.c - i) * ((float)this.e.length / 60.0F));
    getLayoutParams().width = Math.min(i + j, this.c);
  }
  
  public void o0(File paramFile, String paramString)
  {
    paramString = getParent().getParent();
    if (paramString != null)
    {
      paramFile = ((View)paramString).findViewWithTag(paramFile.getName());
      if ((paramFile instanceof ChatVoiceView))
      {
        paramFile = (ChatVoiceView)paramFile;
        paramFile.c();
        paramFile.setOnClickListener(paramFile);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.b.exists())
    {
      findViewById(2131231625).setVisibility(8);
      findViewById(2131231624).setVisibility(0);
      ((AnimationDrawable)((ImageView)findViewById(2131231624)).getDrawable()).start();
      i0.a().d(this.b, this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public void z0(String paramString, float paramFloat) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatVoiceView
 * JD-Core Version:    0.7.0.1
 */