package w3;

import a4.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.widget.ListFooterView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import com.farsunset.hoxin.emoticon.ui.EmoticonPackageActivity;
import java.util.ArrayList;
import java.util.List;
import k3.e;
import u3.b0;
import x3.b;

public class d
  extends RecyclerView.h
  implements View.OnClickListener
{
  private final List<Emoticon> d = new ArrayList();
  private ListFooterView e;
  private final int f = 1;
  private final int g = 0;
  
  public d(Context paramContext)
  {
    this.e = ((ListFooterView)LayoutInflater.from(paramContext).inflate(2131427561, null));
  }
  
  public void I(List<Emoticon> paramList)
  {
    this.d.clear();
    this.d.addAll(paramList);
    j();
  }
  
  public void J(List<Emoticon> paramList)
  {
    int i = this.d.size();
    if (this.d.addAll(paramList)) {
      s(i + 1, paramList.size());
    }
  }
  
  public void K()
  {
    this.d.clear();
    j();
  }
  
  public ListFooterView L()
  {
    return this.e;
  }
  
  public void M(Emoticon paramEmoticon)
  {
    int i = this.d.indexOf(paramEmoticon);
    this.d.set(i, paramEmoticon);
    k(i);
  }
  
  public int d()
  {
    return this.d.size() + 1;
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public int f(int paramInt)
  {
    if (paramInt == this.d.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), EmoticonPackageActivity.class);
    localIntent.putExtra(Emoticon.class.getName(), (Emoticon)paramView.getTag());
    ((Activity)paramView.getContext()).startActivityForResult(localIntent, 0);
  }
  
  public void w(RecyclerView.c0 paramc0, int paramInt)
  {
    if (paramInt == d() - 1) {
      return;
    }
    Emoticon localEmoticon = (Emoticon)this.d.get(paramInt);
    paramc0 = (b)paramc0;
    paramc0.a.setTag(localEmoticon);
    paramc0.a.setOnClickListener(this);
    paramc0.w.o(b0.e(localEmoticon.id.longValue()));
    paramc0.v.setText(localEmoticon.name);
    paramc0.u.setTag(localEmoticon);
    paramc0.u.setOnClickListener(this);
    if (a.i(localEmoticon.id.longValue()))
    {
      paramc0.u.setEnabled(false);
      paramc0 = paramc0.u;
      paramInt = 2131689725;
    }
    else
    {
      paramc0.u.setEnabled(true);
      paramc0 = paramc0.u;
      paramInt = 2131689638;
    }
    paramc0.setText(paramInt);
  }
  
  public RecyclerView.c0 y(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427488, paramViewGroup, false));
    }
    return new e(this.e);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w3.d
 * JD-Core Version:    0.7.0.1
 */