package e6;

import android.content.Intent;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.moment.entity.Moment;
import u3.l;

public class e
  extends d
{
  private void d()
  {
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MOMENT_CREATE_ERROR"));
  }
  
  private void e()
  {
    HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MOMENT_CREATE_FINISH"));
  }
  
  public void a(Moment paramMoment, Bundle paramBundle)
  {
    LongResult localLongResult = d6.b.g(paramMoment);
    if (localLongResult == null)
    {
      d();
      return;
    }
    if (paramMoment.type == 2)
    {
      CloudVideo localCloudVideo = (CloudVideo)l.s0(paramMoment.content, CloudVideo.class);
      localCloudVideo.uri = paramBundle.getString("ATTR_URI");
      paramMoment.content = l.H0(localCloudVideo);
    }
    paramMoment.id = localLongResult.data.longValue();
    paramMoment.createTime = Long.valueOf(System.currentTimeMillis());
    g6.b.a(paramMoment);
    e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e6.e
 * JD-Core Version:    0.7.0.1
 */