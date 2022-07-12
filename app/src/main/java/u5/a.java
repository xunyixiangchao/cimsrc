package u5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import com.farsunset.hoxin.micro.widget.BaseMicroServerFromView;
import com.farsunset.hoxin.micro.widget.MicroServerToTextView;

public class a
  extends RecyclerView.c0
{
  public MicroServerToTextView u;
  public BaseMicroServerFromView v;
  public final TextView w;
  
  public a(View paramView)
  {
    super(paramView);
    if ((paramView instanceof MicroServerToTextView)) {
      this.u = ((MicroServerToTextView)paramView);
    }
    if ((paramView instanceof BaseMicroServerFromView)) {
      this.v = ((BaseMicroServerFromView)paramView);
    }
    this.w = ((TextView)paramView.findViewById(2131230927));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u5.a
 * JD-Core Version:    0.7.0.1
 */