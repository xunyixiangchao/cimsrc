package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import c4.a;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import u3.b0;
import u3.r;
import u3.s;

public class EmoticonGridView
  extends LinearLayout
  implements View.OnLongClickListener
{
  private ImageView a;
  private TextView b;
  private EmoticonItem c;
  private a d;
  private boolean e = false;
  
  public EmoticonGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    if (this.e) {
      return;
    }
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, paramInt));
    this.e = true;
  }
  
  public void b(EmoticonItem paramEmoticonItem)
  {
    this.c = paramEmoticonItem;
    this.b.setText(paramEmoticonItem.name);
    s.a().l(this.a, b0.d(paramEmoticonItem.id.longValue()));
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)getChildAt(0));
    this.b = ((TextView)getChildAt(1));
    setOnLongClickListener(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.c.id == null) {
      return true;
    }
    if (this.d == null) {
      this.d = new a(getContext());
    }
    this.d.a(paramView, this.c);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      a locala = this.d;
      if ((locala != null) && (locala.isShowing())) {
        this.d.dismiss();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.EmoticonGridView
 * JD-Core Version:    0.7.0.1
 */