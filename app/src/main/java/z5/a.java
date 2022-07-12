package z5;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.List;
import s3.u;
import s5.d;

public class a
  extends PopupWindow
  implements u<MicroServerMenu>
{
  private u<MicroServerMenu> a;
  private RecyclerView b;
  private final int c;
  private final int d;
  
  public a(Context paramContext)
  {
    super(paramContext);
    RecyclerView localRecyclerView = (RecyclerView)LayoutInflater.from(paramContext).inflate(2131427570, null);
    this.b = localRecyclerView;
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext));
    this.b.h(new f(paramContext, 1));
    int i = Resources.getSystem().getDisplayMetrics().widthPixels;
    this.d = i;
    i = (int)(i / 2.5D);
    this.c = i;
    setContentView(this.b);
    setWidth(i);
    setHeight(-2);
    setBackgroundDrawable(null);
    setOutsideTouchable(true);
    setFocusable(true);
  }
  
  public void a(MicroServerMenu paramMicroServerMenu)
  {
    dismiss();
    this.a.K(paramMicroServerMenu);
  }
  
  public void b(u<MicroServerMenu> paramu)
  {
    this.a = paramu;
  }
  
  public void c(View paramView, List<MicroServerMenu> paramList)
  {
    int i = paramView.getMeasuredWidth();
    int j = this.d;
    int k = ((View)paramView.getParent()).getMeasuredWidth();
    this.b.setAdapter(new d(paramList, this));
    super.showAtLocation(paramView, 8388691, j - k + ((Integer)paramView.getTag(2131231082)).intValue() * i + (i - this.c) / 2, paramView.getMeasuredHeight());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z5.a
 * JD-Core Version:    0.7.0.1
 */