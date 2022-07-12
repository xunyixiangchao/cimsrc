package r3;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.e;
import com.google.android.material.bottomsheet.a;
import s3.u;

public class d
  extends a
  implements View.OnClickListener
{
  private u<Integer> n;
  
  public d(Context paramContext)
  {
    super(paramContext);
    setContentView(2131427438);
    findViewById(2131231245).setOnClickListener(this);
    findViewById(2131231238).setOnClickListener(this);
  }
  
  public void o(u<Integer> paramu)
  {
    this.n = paramu;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    this.n.K(Integer.valueOf(paramView.getId()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r3.d
 * JD-Core Version:    0.7.0.1
 */