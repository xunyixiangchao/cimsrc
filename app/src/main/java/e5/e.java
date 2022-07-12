package e5;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatMap;
import r5.b;
import u3.b0;
import u3.l;

public class e
  extends f<d5.f>
{
  private final int g;
  private final View.OnClickListener h = d.a;
  
  public e(GridLayoutManager paramGridLayoutManager, b paramb)
  {
    super(paramb);
    this.g = ((Resources.getSystem().getDisplayMetrics().widthPixels - l.p(3.0F)) / paramGridLayoutManager.V2());
  }
  
  public void O(d5.f paramf, Message paramMessage)
  {
    paramMessage = (ChatMap)l.s0(paramMessage.content, ChatMap.class);
    paramf.z.setText(l.U(paramMessage.name, this.e));
    paramf.A.setText(l.U(paramMessage.address, this.e));
    String str = b0.c(paramMessage.image);
    paramf.x.p(str, 2131165334);
    paramf.y.setOnClickListener(this.h);
    paramf.y.setTag(paramMessage);
  }
  
  public d5.f P(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427525, paramViewGroup, false);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, this.g));
    return new d5.f(paramViewGroup);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.e
 * JD-Core Version:    0.7.0.1
 */