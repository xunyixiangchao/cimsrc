package b5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import d5.d;
import java.util.ArrayList;
import java.util.List;
import s3.y;
import u3.b0;
import u3.l;

public class g
  extends RecyclerView.h<d>
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private final List<ChatSession> d = new ArrayList();
  private y e;
  private final List<ChatSession> f = new ArrayList();
  private boolean g = false;
  private String h;
  
  public void I(List<ChatSession> paramList, String paramString)
  {
    this.h = paramString;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.d.clear();
      this.d.addAll(paramList);
    }
    for (;;)
    {
      super.j();
      return;
      this.d.clear();
    }
  }
  
  public void J(ChatSession paramChatSession)
  {
    this.f.remove(paramChatSession);
  }
  
  public List<ChatSession> K()
  {
    return this.f;
  }
  
  public void L(d paramd, int paramInt)
  {
    ChatSession localChatSession = (ChatSession)this.d.get(paramInt);
    paramd.a.setOnClickListener(this);
    paramd.u.setText(l.U(localChatSession.name, this.h));
    paramd.w.setVisibility(4);
    paramd.w.setTag(localChatSession);
    if (localChatSession.sourceType == 2)
    {
      paramd.v.l(l.A(localChatSession.sourceId));
      paramd.u.setTextColor(b.b(paramd.a.getContext(), 17170450));
    }
    else
    {
      paramd.u.setTextColor(b.b(paramd.a.getContext(), 2131034730));
      paramd.v.p(b0.l(localChatSession.sourceId), 2131165495);
    }
    if (this.g)
    {
      paramd.w.setVisibility(0);
      paramd.w.setOnCheckedChangeListener(null);
      paramd.w.setChecked(this.f.contains(localChatSession));
      paramd.w.setOnCheckedChangeListener(this);
    }
  }
  
  public d M(ViewGroup paramViewGroup, int paramInt)
  {
    return new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427492, paramViewGroup, false));
  }
  
  public void N(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void O(y paramy)
  {
    this.e = paramy;
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return paramInt;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (ChatSession)paramCompoundButton.getTag();
    if (paramBoolean)
    {
      this.f.add(paramCompoundButton);
      this.e.n(paramCompoundButton);
      return;
    }
    this.f.remove(paramCompoundButton);
    this.e.f0(paramCompoundButton);
  }
  
  public void onClick(View paramView)
  {
    paramView = (CheckBox)paramView.findViewById(2131230876);
    if (this.g)
    {
      paramView.setChecked(paramView.isChecked() ^ true);
      return;
    }
    this.e.k((ChatSession)paramView.getTag());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.g
 * JD-Core Version:    0.7.0.1
 */