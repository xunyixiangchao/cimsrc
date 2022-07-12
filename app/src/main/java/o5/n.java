package o5;

import android.net.Uri;
import android.os.Bundle;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.message.entity.Message;
import o3.b;
import s3.g0;
import u3.a0;
import u3.c0;
import u3.l;

public class n
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!paramMessage.isVideoFormat())
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    CloudVideo localCloudVideo = (CloudVideo)l.s0(paramMessage.content, CloudVideo.class);
    paramBundle.putString("ATTR_URI", localCloudVideo.uri);
    try
    {
      b localb = b.f;
      c0.d(localb, a0.g(localCloudVideo.image), g0.a());
      c0.g(FileResource.of(localb, localCloudVideo.video, Uri.parse(localCloudVideo.uri)), this.b);
      localCloudVideo.uri = null;
      paramMessage.content = l.H0(localCloudVideo);
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.n
 * JD-Core Version:    0.7.0.1
 */