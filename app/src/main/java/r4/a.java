package r4;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.entity.GroupMember;
import s3.q;
import u3.j0;

public class a
  extends com.google.android.material.bottomsheet.a
  implements View.OnClickListener
{
  private GroupMember n;
  private Group o;
  private q<GroupMember> p;
  
  public a(Activity paramActivity, Group paramGroup, GroupMember paramGroupMember)
  {
    super(paramActivity);
    this.o = paramGroup;
    this.n = paramGroupMember;
    setOwnerActivity(paramActivity);
    int i = 1;
    requestWindowFeature(1);
    setContentView(2131427434);
    findViewById(2131231216).setOnClickListener(this);
    findViewById(2131231251).setOnClickListener(this);
    findViewById(2131231235).setOnClickListener(this);
    if (paramGroup.uid != i3.e.o().longValue()) {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    findViewById(2131231235).setVisibility(0);
  }
  
  private void u()
  {
    ((BaseActivity)getOwnerActivity()).J0();
  }
  
  private void v()
  {
    r3.b localb = new r3.b(getContext());
    localb.k(2131690035);
    localb.h(true);
    localb.n(new a());
    localb.show();
  }
  
  private void x(int paramInt)
  {
    ((BaseActivity)getOwnerActivity()).U0(u3.l.I(paramInt));
  }
  
  private void y(String paramString)
  {
    ((BaseActivity)getOwnerActivity()).Y0(paramString);
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (paramView.getId() == 2131231235) {
      v();
    }
    if (paramView.getId() == 2131231216) {
      j0.c(getContext(), this.n);
    }
  }
  
  public void w(q<GroupMember> paramq)
  {
    this.p = paramq;
  }
  
  class a
    implements s3.l
  {
    a() {}
    
    public void S() {}
    
    public void m()
    {
      a.o(a.this, 2131690065);
      n4.a.c(a.p(a.this).id, a.q(a.this).uid, new a());
    }
    
    class a
      implements s3.e<BaseResult>
    {
      a() {}
      
      public void onHttpException(Exception paramException)
      {
        a.r(a.this);
      }
      
      public void onHttpResponse(BaseResult paramBaseResult)
      {
        a.r(a.this);
        p4.b.p(Long.valueOf(a.p(a.this).id), Long.valueOf(a.q(a.this).uid));
        a.s(a.this, u3.l.I(2131690061));
        a.t(a.this).M(a.q(a.this));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r4.a
 * JD-Core Version:    0.7.0.1
 */