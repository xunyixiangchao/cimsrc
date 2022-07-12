package com.farsunset.hoxin.moment.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.ui.MapViewActivity;
import com.farsunset.hoxin.common.widget.ExpandableTextView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.model.MomentExtra;
import com.farsunset.hoxin.moment.ui.FriendMomentActivity;
import com.farsunset.hoxin.moment.ui.MineMomentActivity;
import com.farsunset.hoxin.moment.ui.MomentDetailedActivity;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import s3.h0;
import s3.p;
import u3.b0;

public class TimelineMomentView
  extends RelativeLayout
  implements View.OnClickListener, p, s3.l
{
  private Moment a;
  private ExpandableTextView b;
  private WebImageView c;
  private TextView d;
  private TextView e;
  private CommentListView f;
  private User g;
  private j6.a h;
  private i6.a i;
  private View j;
  private TextView k;
  private TextView l;
  private r3.b m;
  
  public TimelineMomentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Comment getHasPraise()
  {
    Iterator localIterator = this.a.getPraiseList().iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if (localComment.uid == this.g.id) {
        return localComment;
      }
    }
    return null;
  }
  
  private void h(long paramLong)
  {
    this.i.a();
    d6.a.b(paramLong, new b());
  }
  
  private void i()
  {
    this.i.a();
    d6.a.d(this.a.id, new a());
  }
  
  public void C0(Object paramObject, View paramView)
  {
    if ((paramObject instanceof Comment))
    {
      paramObject = (Comment)paramObject;
      paramView = (CommentListView)paramView;
      Comment localComment = new Comment();
      localComment.type = "1";
      localComment.momentId = this.a.id;
      localComment.parentId = Long.valueOf(paramObject.id);
      this.h.w0(paramView, this.a, localComment);
      return;
    }
    if (paramView.getId() == 2131230827)
    {
      paramObject = new Comment();
      paramObject.type = "0";
      paramView = this.a;
      paramObject.momentId = paramView.id;
      this.h.w0(this.f, paramView, paramObject);
      return;
    }
    if (paramView.getId() == 2131230833)
    {
      paramObject = getHasPraise();
      if (paramObject != null)
      {
        h(paramObject.id);
        return;
      }
      i();
    }
  }
  
  public void S()
  {
    this.m.dismiss();
  }
  
  public void e(Comment paramComment)
  {
    this.f.c(paramComment);
  }
  
  public void f(Comment paramComment)
  {
    this.f.e(paramComment);
  }
  
  public void g(Moment paramMoment, User paramUser, j6.a parama)
  {
    this.a = paramMoment;
    this.g = paramUser;
    this.h = parama;
    setTag(Long.valueOf(paramMoment.id));
    this.c.p(b0.l(paramMoment.uid), 2131165495);
    this.d.getPaint().setFakeBoldText(true);
    this.d.setText(i3.e.k(paramMoment.uid));
    this.e.setText(u3.l.H(paramMoment.createTime.longValue()));
    parama = (MomentExtra)u3.l.s0(paramMoment.extra, MomentExtra.class);
    this.b.setText(u3.l.W(paramMoment.text));
    ExpandableTextView localExpandableTextView = this.b;
    boolean bool = u3.l.c0(paramMoment.text);
    int i1 = 0;
    int n;
    if (bool) {
      n = 0;
    } else {
      n = 8;
    }
    localExpandableTextView.setVisibility(n);
    if ((parama != null) && (parama.location != null))
    {
      this.k.setVisibility(0);
      this.k.setText(parama.location.name);
      this.k.setTag(parama.location);
      this.k.setOnClickListener(this);
    }
    else
    {
      this.k.setVisibility(8);
    }
    parama = this.l;
    if (paramUser.id == paramMoment.uid) {
      n = 0;
    } else {
      n = 8;
    }
    parama.setVisibility(n);
    this.l.setOnClickListener(this);
    paramUser = this.f;
    if (paramMoment.getAllCount() > 0) {
      n = i1;
    } else {
      n = 8;
    }
    paramUser.setVisibility(n);
    this.f.n(paramMoment);
    this.f.setTag(2131231522, paramMoment);
    this.f.setOnItemClickListener(this);
  }
  
  public void m()
  {
    this.m.dismiss();
    d6.b.c(this.a.id, new c());
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.c)
    {
      paramView = new Intent();
      if (this.g.id == this.a.uid)
      {
        paramView.setClass(getContext(), MineMomentActivity.class);
      }
      else
      {
        paramView.setClass(getContext(), FriendMomentActivity.class);
        paramView.putExtra(Friend.class.getName(), i4.a.l(this.a.uid));
      }
      getContext().startActivity(paramView);
      return;
    }
    Object localObject;
    if (paramView == this.j)
    {
      if (this.i == null)
      {
        paramView = new i6.a(getContext());
        this.i = paramView;
        paramView.c(this);
      }
      paramView = this.i;
      localObject = this.j;
      boolean bool;
      if (getHasPraise() != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.d((View)localObject, bool);
      return;
    }
    if (paramView == this)
    {
      localObject = new Intent(getContext(), MomentDetailedActivity.class);
      ((Intent)localObject).putExtra(Moment.class.getName(), this.a);
      getContext().startActivity((Intent)localObject);
    }
    if (paramView == this.k)
    {
      localObject = new Intent(getContext(), MapViewActivity.class);
      ((Intent)localObject).putExtra(MapAddress.class.getName(), (Serializable)this.k.getTag());
      getContext().startActivity((Intent)localObject);
    }
    if (paramView == this.l)
    {
      paramView = new r3.b(getContext());
      this.m = paramView;
      paramView.k(2131690037);
      this.m.n(this);
      this.m.show();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = ((TextView)findViewById(2131230934));
    this.d = ((TextView)findViewById(2131231301));
    this.b = ((ExpandableTextView)findViewById(2131231528));
    this.c = ((WebImageView)findViewById(2131231053));
    this.e = ((TextView)findViewById(2131231553));
    this.k = ((TextView)findViewById(2131231147));
    this.f = ((CommentListView)findViewById(2131230898));
    this.c.setOnClickListener(this);
    View localView = findViewById(2131230897);
    this.j = localView;
    localView.setOnClickListener(this);
  }
  
  class a
    extends h0<CommentResult>
  {
    a() {}
    
    public void a(CommentResult paramCommentResult)
    {
      TimelineMomentView.a(TimelineMomentView.this).b();
      TimelineMomentView.b(TimelineMomentView.this).e(paramCommentResult.data);
      g6.a.a(paramCommentResult.data);
    }
  }
  
  class b
    extends h0<BaseResult>
  {
    b() {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      TimelineMomentView.a(TimelineMomentView.this).b();
      paramBaseResult = TimelineMomentView.c(TimelineMomentView.this);
      TimelineMomentView.d(TimelineMomentView.this).remove(paramBaseResult);
      TimelineMomentView.b(TimelineMomentView.this).k(paramBaseResult);
      g6.a.c(Long.valueOf(paramBaseResult.id));
    }
  }
  
  class c
    extends h0<BaseResult>
  {
    c() {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      g6.b.c(TimelineMomentView.d(TimelineMomentView.this).id);
      paramBaseResult = new Intent("com.farsunset.hoxin.ACTION_DELETE_MOMENT");
      paramBaseResult.putExtra(Moment.class.getName(), TimelineMomentView.d(TimelineMomentView.this));
      HoxinApplication.t(paramBaseResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.TimelineMomentView
 * JD-Core Version:    0.7.0.1
 */