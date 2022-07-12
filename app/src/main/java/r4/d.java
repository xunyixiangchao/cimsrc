package r4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.ui.GroupDetailedActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.ui.GroupChatActivity;
import s3.k;

public class d
  extends com.google.android.material.bottomsheet.a
  implements View.OnClickListener, s3.e<BaseResult>
{
  private Group n;
  private e o;
  private f p;
  private k<Group> q;
  
  public d(Activity paramActivity, Group paramGroup)
  {
    super(paramActivity);
    this.n = paramGroup;
    setOwnerActivity(paramActivity);
    int i = 1;
    requestWindowFeature(1);
    setContentView(2131427435);
    findViewById(2131231225).setOnClickListener(this);
    findViewById(2131231226).setOnClickListener(this);
    findViewById(2131231190).setOnClickListener(this);
    findViewById(2131231253).setOnClickListener(this);
    findViewById(2131231233).setOnClickListener(this);
    findViewById(2131231203).setOnClickListener(this);
    if (paramGroup.uid != i3.e.o().longValue()) {
      i = 0;
    }
    if ((i == 0) && (!p4.a.j(Long.valueOf(paramGroup.id))))
    {
      findViewById(2131231233).setVisibility(0);
      return;
    }
    findViewById(2131231225).setVisibility(0);
    findViewById(2131231226).setVisibility(0);
    findViewById(2131231203).setVisibility(0);
    if (p4.a.i(Long.valueOf(paramGroup.id))) {
      localObject = findViewById(2131231253);
    } else {
      localObject = findViewById(2131231190);
    }
    ((View)localObject).setVisibility(0);
    Object localObject = new e(paramActivity);
    this.o = ((e)localObject);
    ((e)localObject).f(paramGroup.name);
    this.o.e(2131689553);
    this.o.g(new c(this));
    paramActivity = new f(paramActivity);
    this.p = paramActivity;
    paramActivity.f(paramGroup.notice);
    this.p.e(new b(this));
  }
  
  private void A(final String paramString)
  {
    E(u3.l.I(2131690121));
    n4.b.i(this.n.id, paramString, new b(paramString));
  }
  
  private void B()
  {
    D(2131690065);
    n4.b.g(this.n.id, new f());
  }
  
  private void D(int paramInt)
  {
    ((BaseActivity)getOwnerActivity()).U0(u3.l.I(paramInt));
  }
  
  private void E(String paramString)
  {
    ((BaseActivity)getOwnerActivity()).U0(paramString);
  }
  
  private void F(String paramString)
  {
    ((BaseActivity)getOwnerActivity()).Y0(paramString);
  }
  
  private void v()
  {
    ((BaseActivity)getOwnerActivity()).J0();
  }
  
  private void w()
  {
    D(2131690065);
    n4.b.b(this.n.id, new e());
  }
  
  private void x()
  {
    final r3.b localb = new r3.b(getContext());
    localb.n(new c(localb));
    localb.l(u3.l.I(2131690040));
    localb.i(2131689520, 2131689522);
    localb.show();
  }
  
  private void y()
  {
    final r3.b localb = new r3.b(getContext());
    localb.n(new d(localb));
    localb.l(u3.l.I(2131690110));
    localb.i(2131689520, 2131689522);
    localb.show();
  }
  
  private void z(final String paramString)
  {
    E(u3.l.I(2131690121));
    n4.b.h(this.n.id, paramString, new a(paramString));
  }
  
  public void C(k<Group> paramk)
  {
    this.q = paramk;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (paramView.getId() == 2131231190) {
      w();
    }
    if (paramView.getId() == 2131231225) {
      this.o.h(this.n.id);
    }
    if (paramView.getId() == 2131231226) {
      this.p.g(this.n.id);
    }
    if (paramView.getId() == 2131231253) {
      B();
    }
    if (paramView.getId() == 2131231233) {
      y();
    }
    if (paramView.getId() == 2131231203) {
      x();
    }
  }
  
  public void onHttpException(Exception paramException)
  {
    v();
  }
  
  public void onHttpResponse(BaseResult paramBaseResult)
  {
    v();
    p4.a.l(Long.valueOf(this.n.id));
    p4.b.e(this.n.id);
    long l = j5.a.f(this.n);
    j5.a.c(l);
    j5.b.h(l);
    paramBaseResult = new Intent("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
    paramBaseResult.putExtra("ATTR_CHAT_SESSION", ChatSession.of(this.n));
    HoxinApplication.t(paramBaseResult);
    i3.a.a(GroupDetailedActivity.class);
    i3.a.a(GroupChatActivity.class);
  }
  
  class a
    implements s3.e<BaseResult>
  {
    a(String paramString) {}
    
    public void onHttpException(Exception paramException)
    {
      d.q(d.this);
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      d.q(d.this);
      p4.a.p(Long.valueOf(d.r(d.this).id), paramString);
      d.this.dismiss();
      d.r(d.this).name = paramString;
      d.s(d.this).Z(d.r(d.this));
    }
  }
  
  class b
    implements s3.e<BaseResult>
  {
    b(String paramString) {}
    
    public void onHttpException(Exception paramException)
    {
      d.q(d.this);
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      d.q(d.this);
      p4.a.q(Long.valueOf(d.r(d.this).id), paramString);
      d.this.dismiss();
      d.r(d.this).notice = paramString;
      d.s(d.this).Z(d.r(d.this));
    }
  }
  
  class c
    implements s3.l
  {
    c(r3.b paramb) {}
    
    public void S()
    {
      localb.dismiss();
    }
    
    public void m()
    {
      localb.dismiss();
      d.t(d.this, 2131690065);
      n4.b.d(d.r(d.this).id, d.this);
    }
  }
  
  class d
    implements s3.l
  {
    d(r3.b paramb) {}
    
    public void S()
    {
      localb.dismiss();
    }
    
    public void m()
    {
      localb.dismiss();
      d.t(d.this, 2131690065);
      n4.a.b(d.r(d.this).id, d.this);
    }
  }
  
  class e
    implements s3.e<BaseResult>
  {
    e() {}
    
    public void onHttpException(Exception paramException)
    {
      d.q(d.this);
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      d.q(d.this);
      p4.a.c(Long.valueOf(d.r(d.this).id));
      d.u(d.this, u3.l.I(2131690056));
      i3.a.a(GroupDetailedActivity.class);
    }
  }
  
  class f
    implements s3.e<BaseResult>
  {
    f() {}
    
    public void onHttpException(Exception paramException)
    {
      d.q(d.this);
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      d.q(d.this);
      p4.a.o(Long.valueOf(d.r(d.this).id));
      d.u(d.this, u3.l.I(2131690057));
      i3.a.a(GroupDetailedActivity.class);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r4.d
 * JD-Core Version:    0.7.0.1
 */