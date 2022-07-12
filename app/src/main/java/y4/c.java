package y4;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.google.android.material.bottomsheet.a;
import u3.d;
import z4.b;

public class c
  extends a
  implements View.OnClickListener
{
  private b n;
  private RadioButton o;
  private RadioButton p;
  private RadioButton q;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setContentView(2131427440);
    findViewById(2131231105).setOnClickListener(this);
    findViewById(2131231108).setOnClickListener(this);
    findViewById(2131231099).setOnClickListener(this);
    this.o = ((RadioButton)findViewById(2131231134));
    this.p = ((RadioButton)findViewById(2131231319));
    this.q = ((RadioButton)findViewById(2131230818));
  }
  
  public void o(b paramb)
  {
    this.n = paramb;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (paramView.getId() == 2131231105) {
      this.n.v0(1, ((TextView)paramView).getText().toString());
    }
    if (paramView.getId() == 2131231108) {
      this.n.v0(2, ((TextView)paramView).getText().toString());
    }
    if (paramView.getId() == 2131231099) {
      this.n.v0(-1, ((TextView)paramView).getText().toString());
    }
  }
  
  public void show()
  {
    this.o.setVisibility(8);
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    int i = d.m();
    if (i == 1) {
      this.o.setVisibility(0);
    }
    if (i == 2) {
      this.p.setVisibility(0);
    }
    if (i == -1) {
      this.q.setVisibility(0);
    }
    super.show();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y4.c
 * JD-Core Version:    0.7.0.1
 */