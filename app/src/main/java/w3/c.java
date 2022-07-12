package w3;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import java.util.List;
import s3.p;
import u3.r;
import u3.s;

public class c
  extends RecyclerView.h<x3.c>
  implements View.OnClickListener
{
  private final List<Emoticon> d;
  private p<Emoticon> e;
  private View f;
  
  public c(List<Emoticon> paramList)
  {
    this.d = paramList;
  }
  
  public void I(x3.c paramc, int paramInt)
  {
    Emoticon localEmoticon = (Emoticon)this.d.get(paramInt);
    paramc.u.setTag(localEmoticon);
    paramc.u.setOnClickListener(this);
    Object localObject = localEmoticon.icon;
    if ((localObject instanceof Drawable)) {
      paramc.u.setImageDrawable((Drawable)localObject);
    } else {
      s.a().l(paramc.u, localEmoticon.icon.toString());
    }
    if (paramInt == 0)
    {
      localObject = paramc.a;
      this.f = ((View)localObject);
      ((View)localObject).setSelected(true);
      this.e.C0(localEmoticon, paramc.u);
    }
  }
  
  public x3.c J(ViewGroup paramViewGroup, int paramInt)
  {
    return new x3.c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427490, paramViewGroup, false));
  }
  
  public void K(p<Emoticon> paramp)
  {
    this.e = paramp;
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
    View localView = this.f;
    if ((localView != null) && (localView == paramView)) {
      return;
    }
    paramView.setSelected(true);
    localView = this.f;
    if (localView != null) {
      localView.setSelected(false);
    }
    this.f = paramView;
    this.e.C0((Emoticon)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w3.c
 * JD-Core Version:    0.7.0.1
 */