package e4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.j;
import p6.c;
import s3.i;
import u3.b0;
import u3.l;
import u3.q;

public class a
  extends RecyclerView.h
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private i d;
  private final ArrayList<Object> e = new ArrayList();
  private final ArrayList<Friend> f = new ArrayList();
  private boolean g = true;
  private boolean h = false;
  private final Map<Long, String> i;
  private String j;
  
  public a()
  {
    HashMap localHashMap = new HashMap();
    this.i = localHashMap;
    localHashMap.clear();
    localHashMap.putAll(c.f());
  }
  
  private void J(List<Friend> paramList)
  {
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Friend)((Iterator)localObject1).next();
      ((Friend)localObject2).firstPinyin = q.a(((Friend)localObject2).name);
    }
    Collections.sort(paramList, new u4.b());
    if (!this.g)
    {
      this.e.addAll(paramList);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Friend)paramList.next();
      localObject2 = Character.valueOf(((Friend)localObject1).firstPinyin.charAt(0));
      if (!this.e.contains(localObject2)) {
        this.e.add(localObject2);
      }
      this.e.add(localObject1);
    }
  }
  
  private boolean N(Friend paramFriend)
  {
    int k = paramFriend.type;
    boolean bool = true;
    if (k != 2)
    {
      if (k == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void I(Friend paramFriend)
  {
    this.f.add(paramFriend);
  }
  
  public int K(char paramChar)
  {
    return this.e.indexOf(Character.valueOf(paramChar));
  }
  
  public int L()
  {
    return this.f.size();
  }
  
  public ArrayList<Friend> M()
  {
    return this.f;
  }
  
  public void O(f4.b paramb, int paramInt)
  {
    Object localObject = (Friend)this.e.get(paramInt);
    paramb.w.p(b0.l(((Friend)localObject).id), 2131165495);
    paramb.u.setText(l.U(((Friend)localObject).name, this.j));
    paramb.a.setOnClickListener(this);
    paramb.x.setOnCheckedChangeListener(null);
    paramb.x.setChecked(this.f.contains(localObject));
    paramb.x.setOnCheckedChangeListener(this);
    paramb.x.setTag(localObject);
    if (this.h) {
      paramb.x.setVisibility(4);
    }
    boolean bool = N((Friend)localObject);
    paramInt = 0;
    View localView;
    if (bool)
    {
      localView = paramb.y;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    if (!bool)
    {
      localView = paramb.y;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    localObject = (String)this.i.get(Long.valueOf(((Friend)localObject).id));
    paramb.v.setText((CharSequence)localObject);
    paramb = paramb.v;
    if (localObject == null) {
      paramInt = 8;
    }
    paramb.setVisibility(paramInt);
  }
  
  public void P(List<Friend> paramList, String paramString)
  {
    this.e.clear();
    this.j = paramString;
    J(paramList);
    super.j();
  }
  
  public void Q(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void R(i parami)
  {
    this.d = parami;
  }
  
  public void S(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public long e(int paramInt)
  {
    return paramInt;
  }
  
  public int f(int paramInt)
  {
    if ((this.e.get(paramInt) instanceof Friend)) {
      return 2;
    }
    return 1;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Friend localFriend = (Friend)paramCompoundButton.getTag();
    if (paramBoolean)
    {
      this.f.add(localFriend);
      if (!this.d.B((Friend)paramCompoundButton.getTag()))
      {
        paramCompoundButton.setChecked(false);
        this.f.remove(localFriend);
      }
    }
    else
    {
      this.f.remove(localFriend);
      this.d.U((Friend)paramCompoundButton.getTag());
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (CheckBox)paramView.findViewById(2131230876);
    if (this.h)
    {
      paramView = (Friend)paramView.getTag();
      this.d.C(paramView);
      return;
    }
    paramView.setChecked(paramView.isChecked() ^ true);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if ((paramc0 instanceof f4.b))
    {
      O((f4.b)paramc0, paramInt);
      return;
    }
    if (((paramc0 instanceof j)) && ((this.e.get(paramInt) instanceof Character)))
    {
      paramc0 = (j)paramc0;
      String str = this.e.get(paramInt).toString();
      paramc0.u.setText(str);
    }
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new j(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427497, paramViewGroup, false));
    }
    return new f4.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427481, paramViewGroup, false));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e4.a
 * JD-Core Version:    0.7.0.1
 */