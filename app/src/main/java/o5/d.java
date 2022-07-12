package o5;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.FileResource;
import com.farsunset.hoxin.message.entity.Message;
import java.io.IOException;
import o3.b;
import s3.g0;
import u3.a0;
import u3.c0;
import u3.l;
import u3.p;
import u3.r;
import u3.s;

public class d
  extends i
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    if (!paramMessage.isImageFormat())
    {
      super.d(paramMessage, paramBundle);
      return;
    }
    CloudImage localCloudImage = (CloudImage)l.s0(paramMessage.content, CloudImage.class);
    Object localObject2 = s.a().n(localCloudImage.uri);
    Object localObject1 = b.f;
    localObject2 = p.b((Bitmap)localObject2, (b)localObject1);
    localCloudImage.ow = ((CloudImage)localObject2).ow;
    localCloudImage.oh = ((CloudImage)localObject2).oh;
    localCloudImage.th = ((CloudImage)localObject2).th;
    localCloudImage.tw = ((CloudImage)localObject2).tw;
    localCloudImage.thumb = ((CloudImage)localObject2).thumb;
    localCloudImage.image = ((CloudImage)localObject2).image;
    paramBundle.putString("ATTR_URI", localCloudImage.uri);
    if (!localCloudImage.thumb.equals(localCloudImage.image)) {
      c0.d((b)localObject1, a0.g(localCloudImage.thumb), g0.a());
    }
    localObject2 = localCloudImage.image;
    localObject1 = FileResource.of((b)localObject1, (String)localObject2, a0.g((String)localObject2));
    try
    {
      c0.g((FileResource)localObject1, this.b);
      localCloudImage.uri = null;
      paramMessage.content = l.H0(localCloudImage);
    }
    catch (IOException localIOException)
    {
      label193:
      break label193;
    }
    paramBundle.putBoolean("ATTR_HANDLE_FAILURE", true);
    super.d(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o5.d
 * JD-Core Version:    0.7.0.1
 */