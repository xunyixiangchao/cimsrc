package t4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.ui.GroupDetailedActivity;
import k3.h;
import u3.l;

public class f
  extends a<Group, h>
{
  public void M(h paramh, Group paramGroup)
  {
    paramh.v.l(l.A(paramGroup.id));
    paramh.u.setText(l.U(paramGroup.name, this.e));
  }
  
  public h N(ViewGroup paramViewGroup, int paramInt)
  {
    return new h(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427447, paramViewGroup, false));
  }
  
  public void O(Context paramContext, Group paramGroup)
  {
    Intent localIntent = new Intent(paramContext, GroupDetailedActivity.class);
    localIntent.putExtra(Group.NAME, paramGroup);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.f
 * JD-Core Version:    0.7.0.1
 */