package com.farsunset.hoxin.moment.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.common.widget.AutoGridLayoutView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;
import i3.e;
import java.util.Iterator;
import java.util.List;
import s3.h0;
import s3.p;
import u3.b0;
import u3.j0;
import u3.l;

public class DetailedMomentView
  extends RelativeLayout
  implements View.OnClickListener, p<Void>
{
  protected Moment a;
  private TextView b;
  private WebImageView c;
  private TextView d;
  private TextView e;
  private User f;
  private View g;
  private AutoGridLayoutView h;
  private i6.a i;
  private View j;
  private p<Void> k;
  
  public DetailedMomentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d(Comment paramComment)
  {
    WebImageView localWebImageView = new WebImageView(getContext());
    localWebImageView.p(b0.l(paramComment.uid), 2131165495);
    localWebImageView.setOnClickListener(this);
    localWebImageView.setTag(Long.valueOf(paramComment.uid));
    this.h.addView(localWebImageView);
    this.a.add(paramComment);
    this.g.setVisibility(0);
  }
  
  private void f()
  {
    Object localObject = this.a.getPraiseList();
    if (((List)localObject).isEmpty())
    {
      this.g.setVisibility(8);
      return;
    }
    this.h.removeAllViews();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Comment localComment = (Comment)((Iterator)localObject).next();
      WebImageView localWebImageView = new WebImageView(getContext());
      localWebImageView.setTag(Long.valueOf(localComment.uid));
      localWebImageView.setId(2131231053);
      localWebImageView.setOnClickListener(this);
      localWebImageView.p(b0.l(localComment.uid), 2131165495);
      this.h.addView(localWebImageView);
    }
  }
  
  private Comment getHasPraise()
  {
    Iterator localIterator = this.a.getPraiseList().iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if (localComment.uid == this.f.id) {
        return localComment;
      }
    }
    return null;
  }
  
  private void h(Comment paramComment)
  {
    if (paramComment == null) {
      return;
    }
    int m = this.a.getPraiseList().indexOf(paramComment);
    if (m >= 0)
    {
      this.a.remove(paramComment);
      this.h.removeViewAt(m);
    }
    if (this.a.getPraiseList().isEmpty()) {
      this.g.setVisibility(8);
    }
  }
  
  public void e(Moment paramMoment)
  {
    this.a = paramMoment;
    this.c.p(b0.l(paramMoment.uid), 2131165495);
    this.c.setTag(Long.valueOf(paramMoment.uid));
    this.c.setOnClickListener(this);
    this.d.getPaint().setFakeBoldText(true);
    this.d.setText(e.k(paramMoment.uid));
    this.e.setText(l.H(paramMoment.createTime.longValue()));
    TextView localTextView = this.b;
    int m;
    if (l.c0(paramMoment.text)) {
      m = 0;
    } else {
      m = 8;
    }
    localTextView.setVisibility(m);
    this.b.setText(l.W(paramMoment.text));
    if ((!i4.a.o(paramMoment.uid)) && (e.o().longValue() != paramMoment.uid))
    {
      this.j.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    f();
  }
  
  public void g(Void paramVoid, View paramView)
  {
    if (paramView.getId() == 2131230827) {
      this.k.C0(null, paramView);
    }
    if (paramView.getId() == 2131230833)
    {
      paramVoid = getHasPraise();
      if (paramVoid != null)
      {
        d6.a.b(paramVoid.id, new a());
        return;
      }
      d6.a.d(this.a.id, new b());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231053)
    {
      long l = ((Long)paramView.getTag()).longValue();
      j0.a(paramView.getContext(), l);
    }
    View localView = this.j;
    if (paramView == localView)
    {
      paramView = this.i;
      boolean bool;
      if (getHasPraise() != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.d(localView, bool);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = e.g();
    this.d = ((TextView)findViewById(2131231301));
    this.b = ((TextView)findViewById(2131231528));
    this.c = ((WebImageView)findViewById(2131231053));
    this.e = ((TextView)findViewById(2131231553));
    this.g = findViewById(2131231361);
    this.h = ((AutoGridLayoutView)findViewById(2131231360));
    Object localObject = findViewById(2131230897);
    this.j = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = new i6.a(getContext());
    this.i = ((i6.a)localObject);
    ((i6.a)localObject).c(this);
  }
  
  public void setOnItemClickedListener(p paramp)
  {
    this.k = paramp;
  }
  
  class a
    extends h0<BaseResult>
  {
    a() {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      paramBaseResult = DetailedMomentView.a(DetailedMomentView.this);
      DetailedMomentView.b(DetailedMomentView.this, paramBaseResult);
      g6.a.c(Long.valueOf(paramBaseResult.id));
    }
  }
  
  class b
    extends h0<CommentResult>
  {
    b() {}
    
    public void a(CommentResult paramCommentResult)
    {
      DetailedMomentView.c(DetailedMomentView.this, paramCommentResult.data);
      g6.a.a(paramCommentResult.data);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.DetailedMomentView
 * JD-Core Version:    0.7.0.1
 */