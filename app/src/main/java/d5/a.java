package d5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import com.farsunset.hoxin.message.widget.BaseFromMessageView;
import com.farsunset.hoxin.message.widget.BaseToMessageView;
import com.farsunset.hoxin.message.widget.ChattingTipsMessageView;

public class a
  extends RecyclerView.c0
{
  public final BaseToMessageView<?> u;
  public final BaseFromMessageView<?> v;
  public final TextView w;
  public final ChattingTipsMessageView x;
  
  public a(View paramView)
  {
    super(paramView);
    this.w = ((TextView)paramView.findViewById(2131230927));
    this.x = ((ChattingTipsMessageView)paramView.findViewById(2131231555));
    this.u = ((BaseToMessageView)paramView.findViewById(2131231560));
    this.v = ((BaseFromMessageView)paramView.findViewById(2131231022));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d5.a
 * JD-Core Version:    0.7.0.1
 */