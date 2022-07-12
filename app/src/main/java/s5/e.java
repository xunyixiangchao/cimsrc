package s5;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.List;
import s3.p;
import u3.l;

public class e
  extends RecyclerView.h<u5.b>
  implements View.OnClickListener
{
  private List<MicroServerMenu> d;
  private p<MicroServerMenu> e;
  private int f;
  
  public e(List<MicroServerMenu> paramList, p<MicroServerMenu> paramp)
  {
    this.d = paramList;
    this.e = paramp;
  }
  
  public void I(u5.b paramb, int paramInt)
  {
    MicroServerMenu localMicroServerMenu = (MicroServerMenu)this.d.get(paramInt);
    paramb.u.setText(localMicroServerMenu.name);
    if (localMicroServerMenu.hasSubMenu())
    {
      Drawable localDrawable = androidx.core.content.b.d(paramb.a.getContext(), 2131165634);
      localDrawable.setBounds(0, 0, l.p(8.0F), l.p(8.0F));
      paramb.u.setCompoundDrawables(localDrawable, null, null, null);
    }
    paramb.a.getLayoutParams().width = this.f;
    paramb.a.setTag(2131231082, Integer.valueOf(paramInt));
    paramb.a.setOnClickListener(this);
    paramb.a.setTag(localMicroServerMenu);
  }
  
  public u5.b J(ViewGroup paramViewGroup, int paramInt)
  {
    this.f = (paramViewGroup.getMeasuredWidth() / d());
    return new u5.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427571, paramViewGroup, false));
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
    this.e.C0((MicroServerMenu)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s5.e
 * JD-Core Version:    0.7.0.1
 */