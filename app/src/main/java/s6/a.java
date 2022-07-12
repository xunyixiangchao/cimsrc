package s6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;
import i3.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import s3.p;
import u3.b0;
import u3.l;

public class a
  extends RecyclerView.h<t6.a>
  implements View.OnClickListener, View.OnLongClickListener
{
  private final List<GroupCallLog> d = new ArrayList();
  private final Map<String, Map<Long, String>> e = new HashMap();
  private final p<GroupCallLog> f;
  private final long g;
  private GroupCallLog h;
  
  public a(p<GroupCallLog> paramp)
  {
    this.f = paramp;
    this.g = e.o().longValue();
  }
  
  public void I(List<GroupCallLog> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GroupCallLog localGroupCallLog = (GroupCallLog)paramList.next();
      this.e.put(localGroupCallLog.tag, (Map)l.t0(localGroupCallLog.content, new a().getType()));
    }
    j();
  }
  
  public GroupCallLog J()
  {
    return this.h;
  }
  
  public void K(t6.a parama, int paramInt)
  {
    GroupCallLog localGroupCallLog = (GroupCallLog)this.d.get(paramInt);
    Map localMap = (Map)this.e.get(localGroupCallLog.tag);
    parama.u.o(b0.l(localGroupCallLog.uid));
    long l1;
    long l2;
    if (localGroupCallLog.type == 11)
    {
      parama.y.setImageResource(2131165442);
      l1 = this.g;
      l2 = localGroupCallLog.uid;
      if (l1 != l2) {
        parama.v.setText(l.J(2131689669, new Object[] { localMap.get(Long.valueOf(l2)) }));
      } else {
        parama.v.setText(2131689670);
      }
    }
    if (localGroupCallLog.type == 10)
    {
      parama.y.setImageResource(2131165443);
      l1 = this.g;
      l2 = localGroupCallLog.uid;
      if (l1 != l2) {
        parama.v.setText(l.J(2131689671, new Object[] { localMap.get(Long.valueOf(l2)) }));
      } else {
        parama.v.setText(2131689672);
      }
    }
    parama.v.setText(l.J(2131689671, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)((Map.Entry)localIterator.next()).getValue());
      localStringBuilder.append("、");
    }
    parama.x.setText(l.H(localGroupCallLog.timestamp.longValue()));
    parama.w.setText(l.J(2131689664, new Object[] { Integer.valueOf(localMap.size()), localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString() }));
    if (localGroupCallLog.state == 1)
    {
      parama.z.setBackgroundResource(2131165333);
      parama.z.setText(l.J(2131689662, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
      parama.z.setTextColor(b.b(parama.a.getContext(), 2131034168));
    }
    if (localGroupCallLog.state == 2)
    {
      parama.z.setText(l.J(2131689667, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
      parama.z.setBackgroundResource(2131165333);
      parama.z.setTextColor(b.b(parama.a.getContext(), 2131034168));
    }
    if (localGroupCallLog.state == 0)
    {
      parama.z.setText(l.J(2131689663, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
      parama.z.setBackgroundResource(2131165414);
      parama.z.setTextColor(b.b(parama.a.getContext(), 17170443));
    }
    if (localGroupCallLog.state == 3)
    {
      parama.z.setText(l.J(2131689661, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
      parama.z.setBackgroundResource(2131165284);
      parama.z.setTextColor(b.b(parama.a.getContext(), 17170443));
    }
    if (localGroupCallLog.state == 4)
    {
      parama.z.setText(l.J(2131689665, new Object[] { localMap.get(Long.valueOf(localGroupCallLog.uid)) }));
      parama.z.setBackgroundResource(2131165284);
      parama.z.setTextColor(b.b(parama.a.getContext(), 17170443));
    }
    parama.a.setTag(localGroupCallLog);
    parama.a.setOnClickListener(this);
    parama.a.setOnLongClickListener(this);
  }
  
  public t6.a L(ViewGroup paramViewGroup, int paramInt)
  {
    return new t6.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427522, paramViewGroup, false));
  }
  
  public void M(GroupCallLog paramGroupCallLog)
  {
    int i = this.d.indexOf(paramGroupCallLog);
    if (i < 0) {
      return;
    }
    this.d.remove(i);
    u(i);
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    this.f.C0((GroupCallLog)paramView.getTag(), paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.h = ((GroupCallLog)paramView.getTag());
    return false;
  }
  
  class a
    extends com.google.gson.reflect.a<Map<Long, String>>
  {
    a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s6.a
 * JD-Core Version:    0.7.0.1
 */