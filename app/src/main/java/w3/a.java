package w3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.message.widget.EmoticonGridView;
import java.util.ArrayList;
import java.util.List;
import r5.d;

public class a
  extends RecyclerView.h<x3.a>
  implements View.OnClickListener
{
  private final List<EmoticonItem> d = new ArrayList();
  private d e;
  private int f;
  
  private void L(EmoticonGridView paramEmoticonGridView, EmoticonItem paramEmoticonItem)
  {
    paramEmoticonGridView.b(paramEmoticonItem);
    paramEmoticonGridView.a(this.f);
  }
  
  private void M(ImageView paramImageView, EmoticonItem paramEmoticonItem)
  {
    paramImageView.setImageDrawable((Drawable)paramEmoticonItem.image);
    paramImageView.setLayoutParams(new RecyclerView.LayoutParams(-2, this.f));
  }
  
  public void I(List<EmoticonItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.d.clear();
      this.d.addAll(paramList);
      j();
    }
  }
  
  public void J(x3.a parama, int paramInt)
  {
    EmoticonItem localEmoticonItem = (EmoticonItem)this.d.get(paramInt);
    parama.a.setTag(localEmoticonItem);
    parama.a.setOnClickListener(this);
    View localView = parama.a;
    if ((localView instanceof EmoticonGridView)) {
      L((EmoticonGridView)localView, localEmoticonItem);
    }
    parama = parama.a;
    if ((parama instanceof ImageView)) {
      M((ImageView)parama, localEmoticonItem);
    }
  }
  
  public x3.a K(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.f == 0)
    {
      int i = ((GridLayoutManager)((RecyclerView)paramViewGroup).getLayoutManager()).V2();
      this.f = (Resources.getSystem().getDisplayMetrics().widthPixels / i);
    }
    if (paramInt == 1) {
      return new x3.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427487, paramViewGroup, false));
    }
    return new x3.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427486, paramViewGroup, false));
  }
  
  public void N(d paramd)
  {
    this.e = paramd;
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
    if (((EmoticonItem)this.d.get(paramInt)).id == null) {
      return 1;
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    d locald = this.e;
    if (locald != null) {
      locald.j((EmoticonItem)paramView.getTag());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w3.a
 * JD-Core Version:    0.7.0.1
 */