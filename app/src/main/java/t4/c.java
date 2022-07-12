package t4;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.farsunset.hoxin.friend.ui.NewFriendActivity;
import com.farsunset.hoxin.group.ui.GroupListActivity;
import com.farsunset.hoxin.micro.ui.MicroServerListActivity;
import com.farsunset.hoxin.organization.entity.Organization;
import com.farsunset.hoxin.organization.ui.OrganizationActivity;
import f4.a;
import j5.b;

public class c
  implements View.OnClickListener
{
  private final a a;
  
  public c(View paramView)
  {
    this.a = new a(paramView);
  }
  
  public void a()
  {
    this.a.w.setOnClickListener(this);
    this.a.v.setOnClickListener(this);
    this.a.y.setOnClickListener(this);
    this.a.u.setOnClickListener(this);
    long l = b.b("105");
    if (l == 0L)
    {
      this.a.x.setVisibility(8);
    }
    else
    {
      this.a.x.setText(String.valueOf(l));
      this.a.x.setVisibility(0);
    }
    Organization localOrganization = p6.c.c();
    if (localOrganization != null)
    {
      ((TextView)this.a.y.findViewById(2131231301)).setText(localOrganization.name);
      this.a.y.setVisibility(0);
      return;
    }
    this.a.y.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    if (paramView.getId() == 2131230772)
    {
      localObject2 = paramView.getContext();
      localObject1 = new Intent(paramView.getContext(), MicroServerListActivity.class);
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramView.startActivity((Intent)localObject1);
      return;
      if (paramView.getId() == 2131231033)
      {
        localObject1 = paramView.getContext();
        localObject2 = new Intent(paramView.getContext(), GroupListActivity.class);
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else if (paramView.getId() == 2131231313)
      {
        paramView.findViewById(2131231317).setVisibility(8);
        localObject1 = paramView.getContext();
        localObject2 = new Intent(paramView.getContext(), NewFriendActivity.class);
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if (paramView.getId() != 2131231335) {
          break;
        }
        localObject1 = paramView.getContext();
        localObject2 = new Intent(paramView.getContext(), OrganizationActivity.class);
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.c
 * JD-Core Version:    0.7.0.1
 */