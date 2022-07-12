package s6;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.model.RoomMember;
import com.farsunset.hoxin.webrtc.widget.RoomMemberView;
import i3.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.webrtc.SurfaceViewRenderer;
import u3.l;

public class b
  extends RecyclerView.h<t6.c>
  implements View.OnClickListener
{
  private final List<RoomMember> d = new ArrayList();
  private final long e;
  private final long f;
  private int g;
  private int h;
  private final a7.c i;
  
  public b(AvRoom paramAvRoom, a7.c paramc)
  {
    this.i = paramc;
    this.e = e.o().longValue();
    this.f = paramAvRoom.getUid();
    paramc = paramAvRoom.getMember().entrySet().iterator();
    while (paramc.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramc.next();
      RoomMember localRoomMember = new RoomMember();
      localRoomMember.uid = ((Long)localEntry.getKey()).longValue();
      localRoomMember.name = ((String)localEntry.getValue());
      long l1 = localRoomMember.uid;
      long l2 = paramAvRoom.getUid();
      int j = 1;
      boolean bool;
      if (l1 == l2) {
        bool = true;
      } else {
        bool = false;
      }
      localRoomMember.master = bool;
      if (this.e != ((Long)localEntry.getKey()).longValue()) {
        j = 0;
      }
      localRoomMember.state = j;
      this.d.add(localRoomMember);
    }
  }
  
  public void I(Map<Long, String> paramMap)
  {
    int j = this.d.size();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      RoomMember localRoomMember = new RoomMember();
      localRoomMember.uid = ((Long)localEntry.getKey()).longValue();
      localRoomMember.state = 0;
      localRoomMember.name = ((String)localEntry.getValue());
      if (!this.d.contains(localRoomMember)) {
        this.d.add(localRoomMember);
      }
    }
    int k = this.d.size() - j;
    if (k == 0) {
      return;
    }
    s(j, k);
  }
  
  public void J(long paramLong)
  {
    int j = this.d.indexOf(RoomMember.of(paramLong));
    if (j >= 0)
    {
      ((RoomMember)this.d.get(j)).microphoneEnable = false;
      k(j);
    }
  }
  
  public void K(t6.c paramc, int paramInt)
  {
    RoomMember localRoomMember = (RoomMember)this.d.get(paramInt);
    paramc.u.g(this.e, this.f, localRoomMember, this);
  }
  
  public t6.c L(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.g == 0)
    {
      paramInt = ((GridLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager()).V2();
      this.g = ((Resources.getSystem().getDisplayMetrics().widthPixels - (paramInt - 1) * l.p(2.0F)) / paramInt);
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427451, paramViewGroup, false);
    if (this.h == 0)
    {
      l.p0(paramViewGroup);
      this.h = paramViewGroup.getMeasuredHeight();
    }
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(this.g, -2));
    paramViewGroup.findViewById(2131231393).setLayoutParams(new RelativeLayout.LayoutParams(this.g, this.h));
    return new t6.c(paramViewGroup);
  }
  
  public void M(long paramLong, int paramInt)
  {
    int j = this.d.indexOf(RoomMember.of(paramLong));
    if (j >= 0)
    {
      RoomMember localRoomMember = (RoomMember)this.d.get(j);
      localRoomMember.state = paramInt;
      localRoomMember.microphoneEnable = false;
      localRoomMember.cameraEnable = false;
      localRoomMember.videoMode = false;
      k(j);
    }
  }
  
  public void N(long paramLong, boolean paramBoolean)
  {
    int j = this.d.indexOf(RoomMember.of(paramLong));
    if (j >= 0)
    {
      RoomMember localRoomMember = (RoomMember)this.d.get(j);
      localRoomMember.cameraEnable = paramBoolean;
      localRoomMember.videoMode = paramBoolean;
      localRoomMember.state = 1;
      k(j);
    }
  }
  
  public void O(long paramLong, boolean paramBoolean)
  {
    int j = this.d.indexOf(RoomMember.of(paramLong));
    if (j >= 0)
    {
      RoomMember localRoomMember = (RoomMember)this.d.get(j);
      localRoomMember.microphoneEnable = paramBoolean;
      localRoomMember.state = 1;
      k(j);
    }
  }
  
  public void P(long paramLong, boolean paramBoolean)
  {
    int j = this.d.indexOf(RoomMember.of(paramLong));
    if (j >= 0)
    {
      ((RoomMember)this.d.get(j)).videoMode = paramBoolean;
      ((RoomMember)this.d.get(j)).state = 1;
      k(j);
    }
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
    long l;
    if (paramView.getId() == 2131231393)
    {
      l = ((Long)paramView.getTag()).longValue();
      this.i.W(l, (SurfaceViewRenderer)paramView);
    }
    if (paramView.getId() == 2131231092)
    {
      l = ((Long)paramView.getTag(2131231522)).longValue();
      M(l, 0);
      this.i.x(l);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s6.b
 * JD-Core Version:    0.7.0.1
 */