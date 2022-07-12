package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import u3.l;

public class RecordingHintView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private RecordingColorView c;
  private boolean d = true;
  
  public RecordingHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean getRecording()
  {
    return this.d;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(2131231387));
    this.a = ((TextView)findViewById(2131231389));
    l.p0(this.b);
    l.p0(this.a);
    this.c = ((RecordingColorView)findViewById(2131231386));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.setMargins(0, (int)((this.c.getRealHeight() - this.a.getMeasuredHeight()) / 2.5D), 0, 0);
    this.a.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.setMargins(0, this.c.getRealHeight() - this.b.getMeasuredHeight() * 2, 0, 0);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void setHintText(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setTimeText(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void setTouchOutSide(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131689676;
    } else {
      i = 2131689675;
    }
    setHintText(i);
    this.c.setTouchOutSide(paramBoolean);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.c.setTouchOutSide(false);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecordingHintView
 * JD-Core Version:    0.7.0.1
 */