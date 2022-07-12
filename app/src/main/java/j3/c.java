package j3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.Country;
import com.farsunset.hoxin.common.model.Region;
import g3.a;
import java.util.List;
import s3.p;

public class c
  extends RecyclerView.h<k3.c>
  implements View.OnClickListener
{
  private final List<Region> d = a.a().b();
  private p<Country> e;
  
  private ViewGroup I(GridLayout paramGridLayout, int paramInt)
  {
    if (paramGridLayout.getChildCount() >= paramInt + 1) {
      return (ViewGroup)paramGridLayout.getChildAt(paramInt);
    }
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramGridLayout.getContext()).inflate(2131427483, paramGridLayout, false);
    paramGridLayout.addView(localViewGroup);
    return localViewGroup;
  }
  
  public void J(k3.c paramc, int paramInt)
  {
    Object localObject = (Region)this.d.get(paramInt);
    paramc.u.setText(((Region)localObject).name);
    localObject = ((Region)localObject).countryList;
    paramc = paramc.v;
    paramInt = 0;
    while (paramInt < ((List)localObject).size())
    {
      Country localCountry = (Country)((List)localObject).get(paramInt);
      ViewGroup localViewGroup = I(paramc, paramInt);
      localViewGroup.setVisibility(0);
      localViewGroup.setTag(localCountry);
      localViewGroup.setOnClickListener(this);
      ((ImageView)localViewGroup.getChildAt(0)).setImageResource(localCountry.icon);
      ((TextView)localViewGroup.getChildAt(1)).setText(localCountry.code);
      ((TextView)localViewGroup.getChildAt(2)).setText(localCountry.name);
      paramInt += 1;
    }
    paramInt = ((List)localObject).size();
    while (paramInt < paramc.getChildCount())
    {
      paramc.getChildAt(paramInt).setVisibility(8);
      paramInt += 1;
    }
  }
  
  public k3.c K(ViewGroup paramViewGroup, int paramInt)
  {
    return new k3.c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427482, paramViewGroup, false));
  }
  
  public void L(p<Country> paramp)
  {
    this.e = paramp;
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public void onClick(View paramView)
  {
    this.e.C0((Country)paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.c
 * JD-Core Version:    0.7.0.1
 */