package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.widget.AppCompatImageView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.ui.MineMomentActivity;
import com.farsunset.hoxin.moment.ui.MomentMessageActivity;
import g6.a;
import java.util.List;
import s3.d;
import u3.b0;
import u3.r;
import u3.s;

public class TimelineMomentHeaderView
  extends LinearLayout
  implements View.OnClickListener
{
  private ViewGroup a;
  private WebImageView b;
  
  public TimelineMomentHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b(String paramString)
  {
    ((WebImageView)findViewById(2131231053)).p(paramString, 2131165495);
  }
  
  public void c(String paramString)
  {
    s.a().g(paramString, new a());
  }
  
  public void d(List<Message> paramList)
  {
    this.a = ((ViewGroup)findViewById(2131231454));
    if (paramList.isEmpty())
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setOnClickListener(this);
    Object localObject = this.a;
    int i = 0;
    ((ViewGroup)localObject).setVisibility(0);
    while ((i < paramList.size()) && (i < this.a.getChildCount()))
    {
      localObject = a.h(Long.parseLong(((Message)paramList.get(i)).content));
      if (localObject == null) {
        return;
      }
      ((WebImageView)this.a.getChildAt(i)).p(b0.l(((Comment)localObject).uid), 2131165495);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a)
    {
      getContext().startActivity(new Intent(getContext(), MomentMessageActivity.class));
      this.a.setVisibility(8);
    }
    if (paramView.getId() == 2131231056) {
      getContext().startActivity(new Intent(getContext(), MineMomentActivity.class));
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131231056).setOnClickListener(this);
    this.b = ((WebImageView)findViewById(2131231623));
    int i = (int)(Resources.getSystem().getDisplayMetrics().widthPixels / 1.8D);
    this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
  }
  
  class a
    implements d
  {
    a() {}
    
    public void D0(Object paramObject, Bitmap paramBitmap)
    {
      TimelineMomentHeaderView.a(TimelineMomentHeaderView.this).setImageBitmap(paramBitmap);
    }
    
    public void v(Object paramObject) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentHeaderView
 * JD-Core Version:    0.7.0.1
 */