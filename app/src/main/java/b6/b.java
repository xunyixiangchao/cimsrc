package b6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.moment.entity.Comment;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.widget.DetailedMomentView;
import i3.e;
import java.util.ArrayList;
import java.util.List;
import s3.p;
import u3.b0;
import u3.l;

public class b
  extends RecyclerView.h<RecyclerView.c0>
  implements View.OnClickListener
{
  private final Moment d;
  private final List<Comment> e;
  private p<Comment> f;
  
  public b(Moment paramMoment)
  {
    ArrayList localArrayList = new ArrayList();
    this.e = localArrayList;
    this.d = paramMoment;
    localArrayList.addAll(paramMoment.getTextList());
  }
  
  public void J(Comment paramComment)
  {
    this.e.add(paramComment);
    p(this.e.size());
  }
  
  public void L(p<Comment> paramp)
  {
    this.f = paramp;
  }
  
  public int d()
  {
    return this.e.size() + 1;
  }
  
  public int f(int paramInt)
  {
    if (paramInt == 0) {
      return this.d.type;
    }
    return -1;
  }
  
  public void onClick(View paramView)
  {
    this.f.C0((Comment)paramView.getTag(), paramView);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if ((paramc0 instanceof c6.b))
    {
      paramc0 = (c6.b)paramc0;
      paramc0.u.e(this.d);
      paramc0.u.setOnItemClickedListener(this.f);
      return;
    }
    c6.a locala = (c6.a)paramc0;
    Comment localComment1 = (Comment)this.e.get(paramInt - 1);
    locala.a.setTag(localComment1);
    locala.a.setOnClickListener(this);
    locala.x.setTag(Long.valueOf(localComment1.uid));
    locala.x.setOnClickListener(a.a);
    locala.x.p(b0.l(localComment1.uid), 2131165495);
    locala.w.setText(e.k(localComment1.uid));
    locala.u.setText(l.V(localComment1.createTime.longValue()));
    locala.v.setText(l.t(localComment1.content));
    if ("0".equals(localComment1.type)) {
      return;
    }
    Comment localComment2 = this.d.findOne(localComment1.parentId);
    if (localComment2 == null) {
      return;
    }
    paramc0 = paramc0.a.getContext().getString(2131689693, new Object[] { e.k(localComment2.uid), l.X(localComment1.content) });
    locala.v.setText(l.t(paramc0));
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new c6.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427604, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new c6.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427609, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new c6.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427608, paramViewGroup, false));
    }
    if (paramInt == 0) {
      return new c6.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427606, paramViewGroup, false));
    }
    if (paramInt == 4) {
      return new c6.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427605, paramViewGroup, false));
    }
    return new c6.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427508, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.b
 * JD-Core Version:    0.7.0.1
 */