package j3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import k3.i;
import s3.p;
import u3.l;

public class f
  extends RecyclerView.h<i>
  implements View.OnClickListener, Comparator<PoiInfo>
{
  private final List<PoiInfo> d = new ArrayList();
  private p<PoiInfo> e;
  private View f;
  private PoiInfo g;
  private String h;
  
  public void I(List<PoiInfo> paramList, String paramString)
  {
    this.d.clear();
    this.d.addAll(paramList);
    this.h = paramString;
    this.f = null;
    Collections.sort(this.d, this);
    super.j();
  }
  
  public int J(PoiInfo paramPoiInfo1, PoiInfo paramPoiInfo2)
  {
    return Double.compare(paramPoiInfo1.distance, paramPoiInfo2.distance);
  }
  
  public void K(i parami, int paramInt)
  {
    PoiInfo localPoiInfo = (PoiInfo)this.d.get(paramInt);
    parami.v.setText(parami.a.getContext().getString(2131689739, new Object[] { Float.valueOf(localPoiInfo.getDistance() / 1000.0F), localPoiInfo.getAddress() }));
    Object localObject1 = this.h;
    Object localObject2;
    if ((localObject1 != null) && (localPoiInfo.name.contains((CharSequence)localObject1)))
    {
      localObject1 = parami.u;
      localObject2 = l.U(localPoiInfo.getName(), this.h);
    }
    else
    {
      localObject1 = parami.u;
      localObject2 = localPoiInfo.getName();
    }
    ((TextView)localObject1).setText((CharSequence)localObject2);
    parami.a.setTag(localPoiInfo);
    parami.a.setId(paramInt);
    parami.a.setOnClickListener(this);
    parami.w.setVisibility(8);
    if (this.g == localPoiInfo)
    {
      parami.w.setVisibility(0);
      return;
    }
    if ((paramInt == 0) && (this.f == null))
    {
      parami.w.setVisibility(0);
      this.f = parami.w;
      this.e.C0(localPoiInfo, null);
    }
  }
  
  public i L(ViewGroup paramViewGroup, int paramInt)
  {
    return new i(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427505, paramViewGroup, false));
  }
  
  public void M(p<PoiInfo> paramp)
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
    PoiInfo localPoiInfo = (PoiInfo)paramView.getTag();
    if (localPoiInfo == this.g) {
      return;
    }
    View localView = paramView.findViewById(2131231156);
    localView.setVisibility(0);
    this.e.C0(localPoiInfo, paramView);
    paramView = this.f;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.f = localView;
    this.g = localPoiInfo;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.f
 * JD-Core Version:    0.7.0.1
 */