package e6;

import android.os.Bundle;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import o3.b;
import s3.g0;
import u3.a0;
import u3.c0;
import u3.l;

public class a
  extends d
{
  private void d(CloudImage paramCloudImage)
  {
    b localb = b.g;
    c0.d(localb, a0.g(paramCloudImage.image), g0.a());
    if (Objects.equals(paramCloudImage.image, paramCloudImage.thumb)) {
      return;
    }
    c0.d(localb, a0.g(paramCloudImage.thumb), g0.a());
  }
  
  private void e(List<CloudImage> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      d((CloudImage)paramList.next());
    }
  }
  
  public void a(Moment paramMoment, Bundle paramBundle)
  {
    if (paramMoment.type == 4) {
      e(l.u0(paramMoment.content, CloudImage.class));
    }
    if (paramMoment.type == 0) {
      d((CloudImage)l.s0(paramMoment.content, CloudImage.class));
    }
    super.b(paramMoment, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e6.a
 * JD-Core Version:    0.7.0.1
 */