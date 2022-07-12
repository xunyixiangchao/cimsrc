package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.h;

public class GlobalEmptyView
  extends FrameLayout
{
  private TextView a;
  private ImageView b;
  
  public GlobalEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(RecyclerView.h paramh)
  {
    int i;
    if (paramh.d() > 0) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    LayoutInflater.from(getContext()).inflate(2131427556, this);
    this.a = ((TextView)findViewById(2131231554));
    this.b = ((ImageView)findViewById(2131231053));
  }
  
  public void setIcon(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }
  
  public void setTips(int paramInt)
  {
    this.a.setText(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.GlobalEmptyView
 * JD-Core Version:    0.7.0.1
 */