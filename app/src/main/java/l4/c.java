package l4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.entity.GroupMember;
import f4.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s3.p;
import u3.b0;
import u3.l;

public class c
  extends RecyclerView.h<b>
  implements View.OnClickListener
{
  private final List<GroupMember> d = new ArrayList();
  private p<GroupMember> e;
  private final Map<Long, String> f;
  private String g;
  
  public c()
  {
    HashMap localHashMap = new HashMap();
    this.f = localHashMap;
    localHashMap.clear();
    localHashMap.putAll(p6.c.f());
  }
  
  public void I(List<GroupMember> paramList, String paramString)
  {
    this.g = paramString;
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(b paramb, int paramInt)
  {
    Object localObject = (GroupMember)this.d.get(paramInt);
    paramb.u.setText(l.U(((GroupMember)localObject).name, this.g));
    paramb.w.p(b0.l(((GroupMember)localObject).uid), 2131165495);
    paramb.a.setTag(localObject);
    paramb.a.setOnClickListener(this);
    localObject = (String)this.f.get(Long.valueOf(((GroupMember)localObject).uid));
    View localView = paramb.y;
    int i = 0;
    if (localObject != null) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    paramb.v.setText((CharSequence)localObject);
    paramb = paramb.v;
    paramInt = i;
    if (localObject == null) {
      paramInt = 8;
    }
    paramb.setVisibility(paramInt);
  }
  
  public b K(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427499, paramViewGroup, false));
  }
  
  public void L(p<GroupMember> paramp)
  {
    this.e = paramp;
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
    this.e.C0(localGroupMember, paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l4.c
 * JD-Core Version:    0.7.0.1
 */