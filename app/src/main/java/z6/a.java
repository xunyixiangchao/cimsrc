package z6;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.e;
import s3.l;

public class a
  extends com.google.android.material.bottomsheet.a
  implements View.OnClickListener
{
  private l n;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
    setOwnerActivity(paramActivity);
    requestWindowFeature(1);
    setContentView(2131427557);
    findViewById(2131231233).setOnClickListener(this);
    findViewById(2131231207).setOnClickListener(this);
  }
  
  public void o(l paraml)
  {
    this.n = paraml;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (paramView.getId() == 2131231233) {
      this.n.S();
    }
    if (paramView.getId() == 2131231207) {
      this.n.m();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z6.a
 * JD-Core Version:    0.7.0.1
 */