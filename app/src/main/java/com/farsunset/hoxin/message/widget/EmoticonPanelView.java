package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.f;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import s3.e0;
import s3.p;
import w3.a;
import w3.c;

public class EmoticonPanelView
  extends RelativeLayout
  implements r5.d, p<Emoticon>, View.OnClickListener
{
  private r5.d a;
  private e0 b;
  private a c;
  private RecyclerView d;
  private GridLayoutManager e;
  private View f;
  private f g;
  private f h;
  
  public EmoticonPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(long paramLong)
  {
    boolean bool = paramLong < 0L;
    Object localObject = this.d;
    f localf = this.h;
    if (!bool)
    {
      ((RecyclerView)localObject).h(localf);
      this.d.h(this.g);
    }
    else
    {
      ((RecyclerView)localObject).Z0(localf);
      this.d.Z0(this.g);
    }
    this.c.I(d4.d.c().b(paramLong));
    localObject = this.f;
    int i;
    if (!bool) {
      bool = false;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    this.e.c3(d4.d.c().a(paramLong));
    this.d.s1(0);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void c(Emoticon paramEmoticon, View paramView)
  {
    a(paramEmoticon.id.longValue());
  }
  
  public void j(EmoticonItem paramEmoticonItem)
  {
    this.a.j(paramEmoticonItem);
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject = findViewById(2131231200);
    this.f = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.d = ((RecyclerView)findViewById(2131231032));
    localObject = new GridLayoutManager(getContext(), 6, 1, false);
    this.e = ((GridLayoutManager)localObject);
    this.d.setLayoutManager((RecyclerView.p)localObject);
    localObject = new a();
    this.c = ((a)localObject);
    ((a)localObject).N(this);
    this.d.setAdapter(this.c);
    this.h = new f(getContext(), 0);
    this.g = new f(getContext(), 1);
    localObject = (RecyclerView)findViewById(2131231141);
    if ((getContext() instanceof FriendChatActivity))
    {
      ((ViewGroup)localObject).setVisibility(0);
      c localc = new c(d4.d.c().d());
      localc.K(this);
      ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
      ((RecyclerView)localObject).setAdapter(localc);
      return;
    }
    a(0L);
  }
  
  public void setOnEmoticonEventListener(r5.d paramd)
  {
    this.a = paramd;
  }
  
  public void setOnVisibleChangedListener(e0 parame0)
  {
    this.b = parame0;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    e0 locale0 = this.b;
    if (locale0 != null) {
      locale0.a(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.EmoticonPanelView
 * JD-Core Version:    0.7.0.1
 */