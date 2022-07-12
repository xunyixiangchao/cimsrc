package com.farsunset.hoxin.moment.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.widget.AutoGridLayoutView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.widget.EmoticonTextView;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.List;
import r3.b;
import s3.h0;
import s3.p;
import u3.b0;
import u3.j0;

public class CommentListView
  extends LinearLayout
  implements s3.l, View.OnLongClickListener, View.OnClickListener
{
  private Moment a;
  private p<Comment> b;
  private b c;
  private Comment d;
  private int e;
  private AutoGridLayoutView f;
  private LinearLayout g;
  private RelativeLayout h;
  private View i;
  
  public CommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d(Comment paramComment, int paramInt)
  {
    Object localObject = h(paramInt);
    ((View)localObject).setVisibility(0);
    ((View)localObject).setOnClickListener(this);
    ((View)localObject).setTag(paramComment);
    ((View)localObject).setOnLongClickListener(this);
    localObject = (EmoticonTextView)localObject;
    String str1 = i3.e.k(paramComment.uid);
    String str2 = u3.l.W(paramComment.content);
    if ("1".equals(paramComment.type))
    {
      paramComment = paramComment.parentId;
      if (paramComment != null)
      {
        paramComment = g6.a.h(paramComment.longValue());
        if (paramComment != null) {
          paramComment = i3.e.k(paramComment.uid);
        }
      }
    }
    for (paramComment = getResources().getString(2131689779, new Object[] { str1, paramComment, u3.l.X(str2) });; paramComment = getResources().getString(2131689778, new Object[] { str1, u3.l.X(str2) }))
    {
      ((TextView)localObject).setText(u3.l.t(paramComment));
      return;
    }
  }
  
  private void f(Comment paramComment, int paramInt)
  {
    WebImageView localWebImageView = i(paramInt);
    localWebImageView.setVisibility(0);
    localWebImageView.setTag(paramComment);
    localWebImageView.p(b0.l(paramComment.uid), 2131165495);
  }
  
  private void g()
  {
    if (this.c == null)
    {
      b localb = new b(getContext());
      this.c = localb;
      localb.n(this);
      this.c.l(u3.l.I(2131690033));
      this.c.j(u3.l.I(2131689520), getContext().getString(2131689528));
    }
  }
  
  private View h(int paramInt)
  {
    if (this.g.getChildCount() >= paramInt + 1) {
      return this.g.getChildAt(paramInt);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131427510, null);
    this.g.addView(localView);
    return localView;
  }
  
  private WebImageView i(int paramInt)
  {
    if (this.f.getChildCount() >= paramInt + 1) {
      return (WebImageView)this.f.getChildAt(paramInt);
    }
    WebImageView localWebImageView = new WebImageView(getContext());
    localWebImageView.setId(2131231053);
    localWebImageView.setOnClickListener(this);
    this.f.addView(localWebImageView);
    return localWebImageView;
  }
  
  private void j(Comment paramComment)
  {
    this.a.remove(paramComment);
    int j = 0;
    while (j < this.g.getChildCount())
    {
      View localView = this.g.getChildAt(j);
      if (paramComment.equals(localView.getTag()))
      {
        u3.l.B0(localView, 2130772003);
        this.g.removeViewAt(j);
      }
      j += 1;
    }
    g6.a.c(Long.valueOf(paramComment.id));
    if (this.a.getAllCount() == 0) {
      setVisibility(8);
    }
    p();
  }
  
  private void l()
  {
    List localList = this.a.getTextList();
    LinearLayout localLinearLayout = this.g;
    boolean bool = localList.isEmpty();
    int k = 0;
    if (bool) {
      j = 8;
    } else {
      j = 0;
    }
    localLinearLayout.setVisibility(j);
    int j = k;
    while (j < localList.size())
    {
      d((Comment)localList.get(j), j);
      j += 1;
    }
    j = localList.size();
    while (j < this.g.getChildCount())
    {
      this.g.getChildAt(j).setVisibility(8);
      j += 1;
    }
  }
  
  private void o()
  {
    List localList = this.a.getPraiseList();
    RelativeLayout localRelativeLayout = this.h;
    boolean bool = localList.isEmpty();
    int k = 0;
    if (bool) {
      j = 8;
    } else {
      j = 0;
    }
    localRelativeLayout.setVisibility(j);
    p();
    int j = k;
    while (j < localList.size())
    {
      f((Comment)localList.get(j), j);
      j += 1;
    }
    j = localList.size();
    while (j < this.f.getChildCount())
    {
      this.f.getChildAt(j).setVisibility(8);
      j += 1;
    }
  }
  
  private void p()
  {
    if ((this.a.getTextCount() > 0) && (this.a.getPraiseCount() > 0)) {
      this.i.setVisibility(0);
    }
    if (this.a.getTextCount() == 0) {
      this.i.setVisibility(8);
    }
  }
  
  public void S()
  {
    this.c.dismiss();
  }
  
  public void c(Comment paramComment)
  {
    this.a.add(paramComment);
    setVisibility(0);
    this.g.setVisibility(0);
    int j = this.a.getTextCount() - 1;
    d(paramComment, j);
    u3.l.B0(this.g.getChildAt(j), 2130771986);
    p();
  }
  
  public void e(Comment paramComment)
  {
    this.a.add(paramComment);
    f(paramComment, this.a.getPraiseCount() - 1);
    this.h.setVisibility(0);
    setVisibility(0);
    p();
  }
  
  public int getLastTouchY()
  {
    return this.e;
  }
  
  public int getOnScreenY()
  {
    int[] arrayOfInt = new int[2];
    int j;
    if ((getChildCount() != 0) && (getVisibility() != 8))
    {
      getLocationOnScreen(arrayOfInt);
      j = arrayOfInt[1];
    }
    View localView;
    for (int k = getMeasuredHeight();; k = localView.getMeasuredHeight())
    {
      return j + k;
      localView = (View)getParent();
      localView.getLocationOnScreen(arrayOfInt);
      j = arrayOfInt[1];
    }
  }
  
  public void k(Comment paramComment)
  {
    this.a.remove(paramComment);
    int k = 0;
    int j = 0;
    while (j < this.f.getChildCount())
    {
      View localView = this.f.getChildAt(j);
      if (paramComment.equals(localView.getTag()))
      {
        u3.l.B0(localView, 2130772003);
        this.f.removeViewAt(j);
      }
      j += 1;
    }
    paramComment = this.h;
    j = k;
    if (this.a.getPraiseCount() == 0) {
      j = 8;
    }
    paramComment.setVisibility(j);
    if (this.a.getAllCount() == 0) {
      setVisibility(8);
    }
  }
  
  public void m()
  {
    this.c.dismiss();
    d6.a.b(this.d.id, new a());
  }
  
  public void n(Moment paramMoment)
  {
    this.a = paramMoment;
    o();
    l();
  }
  
  public void onClick(View paramView)
  {
    Comment localComment = (Comment)paramView.getTag();
    if (paramView.getId() == 2131231053)
    {
      j0.a(paramView.getContext(), localComment.uid);
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.e = (arrayOfInt[1] + paramView.getMeasuredHeight());
    if (!i3.e.o().equals(Long.valueOf(localComment.uid))) {
      this.b.C0(localComment, this);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.g = ((LinearLayout)findViewById(2131230899));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231359);
    this.h = localRelativeLayout;
    this.f = ((AutoGridLayoutView)localRelativeLayout.findViewById(2131231031));
    this.i = this.h.findViewById(2131230953);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (Comment)paramView.getTag();
    if ((paramView.uid == i3.e.o().longValue()) && (paramView.id != 0L))
    {
      this.d = paramView;
      g();
      u3.l.J0(20);
      this.c.show();
    }
    return false;
  }
  
  public void setOnItemClickListener(p<Comment> paramp)
  {
    this.b = paramp;
  }
  
  class a
    extends h0<BaseResult>
  {
    a() {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      paramBaseResult = CommentListView.this;
      CommentListView.b(paramBaseResult, CommentListView.a(paramBaseResult));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.widget.CommentListView
 * JD-Core Version:    0.7.0.1
 */