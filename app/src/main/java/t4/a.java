package t4;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import java.util.List;
import k3.h;

public abstract class a<T, H extends h>
  extends RecyclerView.h<H>
  implements View.OnClickListener
{
  protected List<T> d;
  protected String e;
  
  public void I(List<T> paramList, String paramString)
  {
    this.d = paramList;
    this.e = paramString;
  }
  
  public final void J(H paramH, int paramInt)
  {
    paramH.a.setOnClickListener(this);
    paramH.a.setTag(this.d.get(paramInt));
    K(paramH, this.d.get(paramInt));
  }
  
  public abstract void K(H paramH, T paramT);
  
  public abstract void L(Context paramContext, T paramT);
  
  public int d()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onClick(View paramView)
  {
    L(paramView.getContext(), paramView.getTag());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t4.a
 * JD-Core Version:    0.7.0.1
 */