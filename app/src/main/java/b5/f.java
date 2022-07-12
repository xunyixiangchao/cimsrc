package b5;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.friend.ui.ContactSelectorActivity;

public class f
  extends RecyclerView.h<RecyclerView.c0>
  implements View.OnClickListener
{
  private boolean d;
  
  public void I(boolean paramBoolean)
  {
    this.d = paramBoolean;
    k(0);
  }
  
  public int d()
  {
    return 1;
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).startActivityForResult(new Intent(paramView.getContext(), ContactSelectorActivity.class), 8155);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    paramc0.a.findViewById(2131230828).setOnClickListener(this);
    paramc0 = paramc0.a.findViewById(2131230834);
    if (this.d) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    paramc0.setVisibility(paramInt);
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    return new k3.f(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427558, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.f
 * JD-Core Version:    0.7.0.1
 */