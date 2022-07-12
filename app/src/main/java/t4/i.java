package t4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.moment.entity.Moment;
import com.farsunset.hoxin.moment.ui.MomentDetailedActivity;
import i3.e;
import k3.h;
import u3.b0;
import u3.l;
import v4.c;

public class i
  extends a<Moment, c>
{
  public void M(c paramc, Moment paramMoment)
  {
    paramc.u.setText(e.k(paramMoment.uid));
    paramc.y.setText(l.V(paramMoment.createTime.longValue()));
    paramc.v.p(b0.l(paramMoment.uid), 2131165495);
    paramc.x.setText(l.U(paramMoment.text, this.e));
  }
  
  public c N(ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427450, paramViewGroup, false));
  }
  
  public void O(Context paramContext, Moment paramMoment)
  {
    Intent localIntent = new Intent(paramContext, MomentDetailedActivity.class);
    localIntent.putExtra(Moment.class.getName(), paramMoment);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.i
 * JD-Core Version:    0.7.0.1
 */