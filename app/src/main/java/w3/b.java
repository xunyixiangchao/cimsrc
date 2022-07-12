package w3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import java.util.List;
import u3.b0;
import x3.d;

public class b
  extends RecyclerView.h<d>
  implements CompoundButton.OnCheckedChangeListener
{
  private final List<Emoticon> d;
  
  public b(List<Emoticon> paramList)
  {
    this.d = paramList;
  }
  
  public void I(d paramd, int paramInt)
  {
    Emoticon localEmoticon = (Emoticon)this.d.get(paramInt);
    paramd.a.setTag(localEmoticon);
    paramd.w.o(b0.e(localEmoticon.id.longValue()));
    paramd.v.setText(localEmoticon.name);
    paramd.u.setTag(localEmoticon);
    paramd.u.setOnCheckedChangeListener(null);
    paramd.u.setChecked(localEmoticon.isEnable());
    paramd.u.setOnCheckedChangeListener(this);
  }
  
  public d J(ViewGroup paramViewGroup, int paramInt)
  {
    return new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427489, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (Emoticon)paramCompoundButton.getTag();
    if (paramBoolean)
    {
      paramCompoundButton.state = 0;
      y3.a.d(paramCompoundButton.id.longValue());
      a4.a.d(paramCompoundButton.id.longValue());
      return;
    }
    paramCompoundButton.state = 1;
    y3.a.c(paramCompoundButton.id.longValue());
    a4.a.c(paramCompoundButton.id.longValue());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w3.b
 * JD-Core Version:    0.7.0.1
 */