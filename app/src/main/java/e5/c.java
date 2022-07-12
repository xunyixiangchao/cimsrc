package e5;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import d5.e;
import u3.l;

public class c
  extends f<e>
{
  private final int g;
  private final View.OnClickListener h = b.a;
  
  public c(GridLayoutManager paramGridLayoutManager, r5.b paramb)
  {
    super(paramb);
    this.g = ((Resources.getSystem().getDisplayMetrics().widthPixels - l.p(3.0F)) / paramGridLayoutManager.V2());
  }
  
  public void O(e parame, Message paramMessage)
  {
    paramMessage = (CloudImage)l.s0(paramMessage.content, CloudImage.class);
    parame.y.setOnClickListener(this.h);
    parame.y.setTag(paramMessage);
    parame.y.setTag(2131231522, parame.x);
    paramMessage = l.w(paramMessage);
    parame.x.p(paramMessage, 2131165334);
  }
  
  public e P(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427524, paramViewGroup, false);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, this.g));
    return new e(paramViewGroup);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.c
 * JD-Core Version:    0.7.0.1
 */