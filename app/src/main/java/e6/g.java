package e6;

import android.net.Uri;
import android.os.Bundle;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.moment.entity.Moment;
import o3.b;
import s3.g0;
import u3.a0;
import u3.c0;
import u3.l;

public class g
  extends d
{
  public void a(Moment paramMoment, Bundle paramBundle)
  {
    if (paramMoment.type == 2)
    {
      CloudVideo localCloudVideo = (CloudVideo)l.s0(paramMoment.content, CloudVideo.class);
      b localb = b.g;
      c0.d(localb, a0.g(localCloudVideo.image), g0.a());
      c0.c(FileResource.of(localb, localCloudVideo.video, Uri.parse(localCloudVideo.uri)), g0.a());
      paramBundle.putString("ATTR_URI", localCloudVideo.uri);
      localCloudVideo.uri = null;
      paramMoment.content = l.H0(localCloudVideo);
    }
    super.b(paramMoment, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e6.g
 * JD-Core Version:    0.7.0.1
 */