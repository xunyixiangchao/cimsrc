package j3;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.Bucket;
import com.farsunset.hoxin.common.widget.WebImageView;
import java.util.ArrayList;
import java.util.List;
import s3.p;
import u3.l;

public class a
  extends RecyclerView.h<k3.a>
  implements View.OnClickListener
{
  private Bucket d;
  private final List<Bucket> e = new ArrayList();
  private p f;
  
  public void I(List<Bucket> paramList)
  {
    this.e.clear();
    this.e.addAll(paramList);
    if ((!paramList.isEmpty()) && (this.d == null)) {
      this.d = ((Bucket)paramList.get(0));
    }
    super.j();
  }
  
  public void J(k3.a parama, int paramInt)
  {
    Bucket localBucket = (Bucket)this.e.get(paramInt);
    parama.a.setOnClickListener(this);
    parama.a.setTag(localBucket);
    Object localObject = localBucket.cover;
    if (localObject == null) {
      parama.u.setImageResource(2131034649);
    } else {
      parama.u.k((Uri)localObject, 2131034649);
    }
    parama.w.setText(localBucket.name);
    localObject = parama.x;
    long l = localBucket.size;
    paramInt = 0;
    ((TextView)localObject).setText(l.J(2131689644, new Object[] { Long.valueOf(l) }));
    parama = parama.v;
    if (localBucket != this.d) {
      paramInt = 8;
    }
    parama.setVisibility(paramInt);
  }
  
  public k3.a K(ViewGroup paramViewGroup, int paramInt)
  {
    return new k3.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427445, paramViewGroup, false));
  }
  
  public void L(p paramp)
  {
    this.f = paramp;
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public void onClick(View paramView)
  {
    this.d = ((Bucket)paramView.getTag());
    this.f.C0(paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.a
 * JD-Core Version:    0.7.0.1
 */