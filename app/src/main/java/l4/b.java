package l4;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.entity.GroupMember;
import java.util.ArrayList;
import java.util.List;
import k3.h;
import s3.p;
import u3.b0;
import u3.j0;
import u3.l;

public class b
  extends RecyclerView.h<h>
  implements View.OnClickListener
{
  private final List<GroupMember> d = new ArrayList();
  private final int e = Resources.getSystem().getDisplayMetrics().widthPixels / 5;
  private p<GroupMember> f;
  private String g;
  
  public void I(List<GroupMember> paramList, String paramString)
  {
    this.g = paramString;
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(h paramh, int paramInt)
  {
    GroupMember localGroupMember = (GroupMember)this.d.get(paramInt);
    paramh.u.setText(l.U(localGroupMember.name, this.g));
    View localView = paramh.w;
    if (localGroupMember.type == 1) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    paramh.a.setLayoutParams(new RelativeLayout.LayoutParams(this.e, -2));
    paramh.v.p(b0.l(localGroupMember.uid), 2131165495);
    paramh.a.setTag(localGroupMember);
    paramh.a.setOnClickListener(this);
  }
  
  public h K(ViewGroup paramViewGroup, int paramInt)
  {
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427494, paramViewGroup, false));
  }
  
  public void L(GroupMember paramGroupMember)
  {
    int i = this.d.indexOf(paramGroupMember);
    if (i >= 0)
    {
      this.d.remove(i);
      u(i);
    }
  }
  
  public void M(p<GroupMember> paramp)
  {
    this.f = paramp;
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    GroupMember localGroupMember = (GroupMember)paramView.getTag();
    p localp = this.f;
    if (localp == null)
    {
      j0.c(paramView.getContext(), localGroupMember);
      return;
    }
    localp.C0(localGroupMember, paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l4.b
 * JD-Core Version:    0.7.0.1
 */