package b6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import k3.g;
import o3.b;
import s3.d;
import u3.l;
import u3.r;
import u3.s;

public class e
  extends RecyclerView.h<g>
  implements View.OnLongClickListener, View.OnClickListener
{
  private s3.p<Void> d;
  private final List<Uri> e = new ArrayList();
  private final Map<Uri, CloudImage> f = new LinkedHashMap();
  private final int g;
  private final int h;
  private final int i = l.p(5.0F);
  private Uri j;
  
  public e()
  {
    int k = Resources.getSystem().getDisplayMetrics().widthPixels / 5;
    this.g = k;
    this.h = k;
  }
  
  public void J(Uri paramUri)
  {
    int k = this.e.size();
    this.e.add(paramUri);
    p(k);
  }
  
  public void K(List<Uri> paramList)
  {
    int k = this.e.size();
    this.e.addAll(paramList);
    s(k, paramList.size());
  }
  
  public CloudImage L()
  {
    return (CloudImage)((Map.Entry)this.f.entrySet().iterator().next()).getValue();
  }
  
  public int M()
  {
    return this.f.size();
  }
  
  public List<CloudImage> N()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add((CloudImage)((Map.Entry)localIterator.next()).getValue());
    }
    return localLinkedList;
  }
  
  public boolean O()
  {
    return this.e.isEmpty();
  }
  
  public void P(g paramg, int paramInt)
  {
    paramg.u.setLayoutParams(new RecyclerView.LayoutParams(this.g, this.h));
    paramg.u.setTag(null);
    if (paramInt == this.e.size())
    {
      paramg.u.setOnClickListener(this);
      paramg.u.setPadding(0, 0, 0, 0);
      paramg.u.setImageResource(2131165435);
      paramg.u.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    paramg.u.setOnLongClickListener(this);
    final Uri localUri = (Uri)this.e.get(paramInt);
    paramg.u.setTag(2131230995, localUri);
    paramg.u.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramg.u.setOnClickListener(null);
    paramg.u.setImageResource(2131034649);
    WebImageView localWebImageView = paramg.u;
    paramInt = this.i;
    localWebImageView.setPadding(paramInt, paramInt, paramInt, paramInt);
    s.a().k(paramg.u, localUri.toString(), 2131034649);
    s.a().j(localUri, new a(localUri));
  }
  
  public g Q(ViewGroup paramViewGroup, int paramInt)
  {
    return new g(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427496, paramViewGroup, false));
  }
  
  public void R()
  {
    int k = this.e.indexOf(this.j);
    if (k >= 0)
    {
      this.e.remove(this.j);
      u(k);
    }
    this.f.remove(this.j);
  }
  
  public void S(s3.p<Void> paramp)
  {
    this.d = paramp;
  }
  
  public int d()
  {
    return this.e.size() + 1;
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    this.d.C0(null, paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.j = ((Uri)paramView.getTag(2131230995));
    return false;
  }
  
  class a
    implements d
  {
    a(Uri paramUri) {}
    
    public void D0(Object paramObject, Bitmap paramBitmap)
    {
      e.I(e.this).put(localUri, u3.p.b(paramBitmap, b.g));
    }
    
    public void v(Object paramObject) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b6.e
 * JD-Core Version:    0.7.0.1
 */