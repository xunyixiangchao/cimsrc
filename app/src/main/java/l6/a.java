package l6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.organization.entity.Department;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import com.farsunset.hoxin.organization.entity.Organization;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p6.b;
import s3.p;
import u3.b0;
import u3.l;

public class a
  extends RecyclerView.h<m6.a>
  implements View.OnClickListener
{
  private final List<Object> d = new ArrayList();
  private p<Department> e;
  private p<Friend> f;
  private final Map<Long, String> g = new HashMap();
  private String h;
  
  public a(Organization paramOrganization)
  {
    paramOrganization = b.e(paramOrganization.id.longValue()).iterator();
    while (paramOrganization.hasNext())
    {
      DepartmentMember localDepartmentMember = (DepartmentMember)paramOrganization.next();
      this.g.put(localDepartmentMember.uid, localDepartmentMember.title);
    }
  }
  
  public void I(String paramString, List<?> paramList)
  {
    this.h = paramString;
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(m6.a parama, int paramInt)
  {
    Object localObject = this.d.get(paramInt);
    if ((localObject instanceof Friend)) {
      K(parama, (Friend)localObject);
    }
    if ((localObject instanceof Department)) {
      L(parama, (Department)localObject);
    }
  }
  
  public void K(m6.a parama, Friend paramFriend)
  {
    parama.w.setText(l.U(paramFriend.name, this.h));
    parama.x.setText((CharSequence)this.g.get(Long.valueOf(paramFriend.id)));
    parama.v.p(b0.l(paramFriend.id), 2131165495);
    parama.a.setTag(paramFriend);
    parama.a.setOnClickListener(this);
  }
  
  public void L(m6.a parama, Department paramDepartment)
  {
    parama.w.setText(l.U(paramDepartment.name, this.h));
    parama.u.setText(paramDepartment.name.substring(0, 1));
    parama.a.setTag(paramDepartment);
    parama.a.setOnClickListener(this);
  }
  
  public m6.a M(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new m6.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427503, paramViewGroup, false));
    }
    return new m6.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427502, paramViewGroup, false));
  }
  
  public void N(p<Department> paramp)
  {
    this.e = paramp;
  }
  
  public void O(p<Friend> paramp)
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
  
  public int f(int paramInt)
  {
    if ((this.d.get(paramInt) instanceof Friend)) {
      return 0;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof Friend)) {
      this.f.C0((Friend)paramView.getTag(), paramView);
    }
    if ((paramView.getTag() instanceof Department)) {
      this.e.C0((Department)paramView.getTag(), paramView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l6.a
 * JD-Core Version:    0.7.0.1
 */