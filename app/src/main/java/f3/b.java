package f3;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.k;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.home.ui.HomeActivity;
import com.farsunset.hoxin.home.ui.MixedSettingActivity;
import s3.l;

public class b
  extends com.google.android.material.bottomsheet.a
  implements View.OnClickListener, l
{
  private final r3.b n;
  
  public b(Activity paramActivity)
  {
    super(paramActivity);
    setOwnerActivity(paramActivity);
    requestWindowFeature(1);
    setContentView(2131427575);
    findViewById(2131231215).setOnClickListener(this);
    findViewById(2131231206).setOnClickListener(this);
    r3.b localb = new r3.b(paramActivity);
    this.n = localb;
    localb.setOwnerActivity(paramActivity);
    localb.n(this);
  }
  
  private void o()
  {
    h.f(HoxinApplication.h());
    i3.a.a(MixedSettingActivity.class);
    i3.a.a(HomeActivity.class);
  }
  
  private void p()
  {
    d3.b.e();
    i3.e.t();
    h.w(HoxinApplication.h());
    i3.a.a(HomeActivity.class);
    i3.a.a(MixedSettingActivity.class);
    HoxinApplication.h().r();
    k.e(getContext()).d();
  }
  
  public void S()
  {
    this.n.dismiss();
  }
  
  public void m()
  {
    this.n.dismiss();
    if (this.n.e().equals(Integer.valueOf(2131231215))) {
      p();
    }
    if (this.n.e().equals(Integer.valueOf(2131231206))) {
      o();
    }
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (paramView.getId() == 2131231215)
    {
      this.n.k(2131689734);
      this.n.o(Integer.valueOf(2131231215));
      this.n.show();
    }
    if (paramView.getId() == 2131231206)
    {
      this.n.k(2131689730);
      this.n.o(Integer.valueOf(2131231206));
      this.n.show();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f3.b
 * JD-Core Version:    0.7.0.1
 */