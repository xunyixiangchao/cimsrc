package t4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.UserDetailedActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.j;
import p6.c;
import u3.b0;
import u3.q;
import w4.a;

public class d
  extends RecyclerView.h
  implements View.OnClickListener
{
  private final List<Object> d = new ArrayList();
  private final List<Long> e = new ArrayList();
  private int f;
  private final Map<Long, String> g = new HashMap();
  
  private void I(List<Friend> paramList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Friend localFriend = (Friend)((Iterator)localObject2).next();
      localFriend.firstPinyin = q.a(localFriend.name);
      if (this.e.contains(Long.valueOf(localFriend.id)))
      {
        localFriend = localFriend.clone();
        localFriend.firstPinyin = String.valueOf('☆');
        ((List)localObject1).add(localFriend);
      }
    }
    paramList.addAll((Collection)localObject1);
    Collections.sort(paramList, new u4.b());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Friend)paramList.next();
      localObject2 = Character.valueOf(((Friend)localObject1).firstPinyin.charAt(0));
      if (!this.d.contains(localObject2)) {
        this.d.add(localObject2);
      }
      this.d.add(localObject1);
    }
  }
  
  public int J()
  {
    return this.f;
  }
  
  public int K(char paramChar)
  {
    return this.d.indexOf(Character.valueOf(paramChar));
  }
  
  public void L(Friend paramFriend)
  {
    int i = this.d.indexOf(paramFriend);
    if (i >= 0) {
      k(i);
    }
  }
  
  public void M(List<Friend> paramList)
  {
    this.d.clear();
    this.e.clear();
    this.e.addAll(a.c());
    this.f = paramList.size();
    I(paramList);
    this.g.clear();
    this.g.putAll(c.f());
    super.j();
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public int f(int paramInt)
  {
    if ((this.d.get(paramInt) instanceof Friend)) {
      return 2;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    Friend localFriend = (Friend)paramView.getTag();
    Intent localIntent = new Intent(paramView.getContext(), UserDetailedActivity.class);
    localIntent.putExtra(Friend.class.getName(), localFriend);
    paramView.getContext().startActivity(localIntent);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if ((paramc0 instanceof f4.b))
    {
      Object localObject = (Friend)this.d.get(paramInt);
      paramc0 = (f4.b)paramc0;
      paramc0.w.p(b0.l(((Friend)localObject).id), 2131165495);
      paramc0.u.setText(((Friend)localObject).name);
      paramc0.a.setTag(localObject);
      paramc0.a.setOnClickListener(this);
      View localView = paramc0.y;
      paramInt = ((Friend)localObject).type;
      int i = 8;
      if ((paramInt != 2) && (paramInt != 1)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      localView.setVisibility(paramInt);
      localObject = (String)this.g.get(Long.valueOf(((Friend)localObject).id));
      paramc0.v.setText((CharSequence)localObject);
      paramc0 = paramc0.v;
      if (localObject == null) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      paramc0.setVisibility(paramInt);
      return;
    }
    if (((paramc0 instanceof j)) && ((this.d.get(paramInt) instanceof Character))) {
      ((j)paramc0).u.setText(this.d.get(paramInt).toString());
    }
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new j(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427497, paramViewGroup, false));
    }
    return new f4.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427499, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.d
 * JD-Core Version:    0.7.0.1
 */