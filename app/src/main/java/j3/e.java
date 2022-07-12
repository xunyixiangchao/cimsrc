package j3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.a;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.ProgressbarPhotoView;
import d7.f;
import java.util.List;
import s3.c;

public class e
  extends a
{
  private final List<CloudImage> c;
  private c d;
  private f e;
  private View.OnLongClickListener f;
  
  public e(List<CloudImage> paramList)
  {
    this.c = paramList;
  }
  
  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int e()
  {
    return this.c.size();
  }
  
  public boolean k(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public CloudImage u(int paramInt)
  {
    return (CloudImage)this.c.get(paramInt);
  }
  
  public View v(ViewGroup paramViewGroup, int paramInt)
  {
    ProgressbarPhotoView localProgressbarPhotoView = (ProgressbarPhotoView)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427574, null);
    CloudImage localCloudImage = (CloudImage)this.c.get(paramInt);
    localProgressbarPhotoView.setTag(Integer.valueOf(paramInt));
    paramViewGroup.addView(localProgressbarPhotoView, -1, -1);
    localProgressbarPhotoView.c(localCloudImage, this.d);
    localProgressbarPhotoView.setOnPhotoTapListener(this.e);
    localProgressbarPhotoView.setOnLongClickListener(this.f);
    return localProgressbarPhotoView;
  }
  
  public void w(c paramc)
  {
    this.d = paramc;
  }
  
  public void x(View.OnLongClickListener paramOnLongClickListener)
  {
    this.f = paramOnLongClickListener;
  }
  
  public void y(f paramf)
  {
    this.e = paramf;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j3.e
 * JD-Core Version:    0.7.0.1
 */