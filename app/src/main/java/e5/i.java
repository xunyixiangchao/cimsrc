package e5;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.c0;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import d5.k;
import r5.b;
import u3.b0;
import u3.l;

public class i
  extends f<k>
{
  private final int g;
  private final View.OnClickListener h = h.a;
  
  public i(GridLayoutManager paramGridLayoutManager, b paramb)
  {
    super(paramb);
    this.g = ((Resources.getSystem().getDisplayMetrics().widthPixels - l.p(3.0F)) / paramGridLayoutManager.V2());
  }
  
  public void O(k paramk, Message paramMessage)
  {
    paramMessage = (CloudVideo)l.s0(paramMessage.content, CloudVideo.class);
    paramk.y.setTag(paramMessage);
    paramk.y.setTag(2131231522, paramk.x);
    paramk.y.setOnClickListener(this.h);
    String str = b0.f(paramMessage.bucket, paramMessage.image);
    paramk.x.p(str, 2131165334);
    paramk.z.setText(paramk.a.getContext().getString(2131689896, new Object[] { Integer.valueOf((int)paramMessage.duration) }));
  }
  
  public k P(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427527, paramViewGroup, false);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, this.g));
    return new k(paramViewGroup);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e5.i
 * JD-Core Version:    0.7.0.1
 */