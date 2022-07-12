package s6;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.webrtc.model.AvRoom;
import com.farsunset.hoxin.webrtc.model.RoomMember;
import i3.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import t6.b;
import u3.b0;

public class c
  extends RecyclerView.h<b>
{
  private final List<RoomMember> d = new ArrayList();
  private int e;
  private long f = e.o().longValue();
  
  public c(AvRoom paramAvRoom)
  {
    Iterator localIterator = paramAvRoom.getMember().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      RoomMember localRoomMember = new RoomMember();
      localRoomMember.uid = ((Long)localEntry.getKey()).longValue();
      localRoomMember.name = ((String)localEntry.getValue());
      boolean bool;
      if (localRoomMember.uid == paramAvRoom.getUid()) {
        bool = true;
      } else {
        bool = false;
      }
      localRoomMember.master = bool;
      this.d.add(localRoomMember);
    }
  }
  
  public void I(b paramb, int paramInt)
  {
    paramb.a.setLayoutParams(new RecyclerView.LayoutParams(this.e, -2));
    RoomMember localRoomMember = (RoomMember)this.d.get(paramInt);
    paramb.v.setText(localRoomMember.name);
    View localView = paramb.w;
    boolean bool = localRoomMember.master;
    int i = 0;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    localView = paramb.x;
    if (localRoomMember.uid == this.f) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    paramb.u.p(b0.l(localRoomMember.uid), 2131165495);
  }
  
  public b J(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.e == 0)
    {
      paramInt = ((GridLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager()).V2();
      this.e = (Resources.getSystem().getDisplayMetrics().widthPixels / paramInt);
    }
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427452, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s6.c
 * JD-Core Version:    0.7.0.1
 */