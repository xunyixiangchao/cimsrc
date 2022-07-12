package k4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.UserDetailedActivity;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.message.ui.FriendChatActivity;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.farsunset.hoxin.moment.ui.MomentRuleActivity;
import s3.h0;

public class b
  extends com.google.android.material.bottomsheet.a
  implements View.OnClickListener, s3.l
{
  private final Friend n;
  
  public b(Activity paramActivity, Friend paramFriend)
  {
    super(paramActivity);
    this.n = paramFriend;
    setOwnerActivity(paramActivity);
    requestWindowFeature(1);
    setContentView(2131427433);
    findViewById(2131231247).setOnClickListener(this);
    findViewById(2131231223).setOnClickListener(this);
    findViewById(2131231200).setOnClickListener(this);
    findViewById(2131231243).setOnClickListener(this);
    boolean bool = i4.a.p(paramFriend.id);
    paramActivity = findViewById(2131231200);
    if (bool) {
      paramActivity.setVisibility(0);
    } else {
      paramActivity.setVisibility(8);
    }
    findViewById(2131231247).setVisibility(0);
    if (w4.a.b(Long.valueOf(paramFriend.id)))
    {
      ((TextView)findViewById(2131231539)).setText(u3.l.I(2131689828));
      findViewById(2131231066).setSelected(true);
      return;
    }
    ((TextView)findViewById(2131231539)).setText(u3.l.I(2131689641));
    findViewById(2131231066).setSelected(false);
  }
  
  private void p()
  {
    dismiss();
    r3.b localb = new r3.b(getContext());
    localb.k(2131690034);
    localb.n(this);
    localb.h(true);
    localb.show();
  }
  
  private void q()
  {
    dismiss();
    Intent localIntent = new Intent(getContext(), MomentRuleActivity.class);
    localIntent.putExtra(MessageSource.NAME, this.n);
    getContext().startActivity(localIntent);
  }
  
  private void r()
  {
    Message localMessage = new Message();
    localMessage.sender = i3.e.o();
    localMessage.format = 14;
    Object localObject = new ChatProfile();
    ((ChatProfile)localObject).id = Long.valueOf(this.n.id);
    ((ChatProfile)localObject).name = this.n.name;
    localMessage.content = u3.l.H0(localObject);
    localObject = new Intent(getContext(), MessageForwardActivity.class);
    ((Intent)localObject).putExtra(Message.NAME, localMessage);
    ((Intent)localObject).setFlags(268435456);
    HoxinApplication.h().startActivity((Intent)localObject);
    dismiss();
  }
  
  private void s()
  {
    if (w4.a.b(Long.valueOf(this.n.id))) {
      w4.a.a(this.n.id);
    } else {
      w4.a.d(Long.valueOf(this.n.id));
    }
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
    dismiss();
  }
  
  public void S() {}
  
  public void m()
  {
    g4.a.d(this.n.id, new a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231247) {
      s();
    }
    if (paramView.getId() == 2131231223) {
      q();
    }
    if (paramView.getId() == 2131231200) {
      p();
    }
    if (paramView.getId() == 2131231243) {
      r();
    }
  }
  
  class a
    extends h0<BaseResult>
  {
    a() {}
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      u3.l.z0(b.this.getContext(), 2131690053);
      i4.a.c(Long.valueOf(b.o(b.this).id), (byte)0);
      if (b.o(b.this).type == 2) {
        return;
      }
      g6.b.e(b.o(b.this).id);
      long l = j5.a.f(b.o(b.this));
      j5.a.c(l);
      j5.b.h(l);
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_RELOAD_CONTACTS"));
      i3.a.a(UserDetailedActivity.class);
      i3.a.a(FriendChatActivity.class);
      paramBaseResult = new Intent("com.farsunset.hoxin.ACTION_RECENT_DELETE_CHAT");
      paramBaseResult.putExtra("ATTR_CHAT_SESSION", ChatSession.of(b.o(b.this)));
      HoxinApplication.t(paramBaseResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k4.b
 * JD-Core Version:    0.7.0.1
 */