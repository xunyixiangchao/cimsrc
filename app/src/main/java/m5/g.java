package m5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.message.entity.Message;
import java.io.File;
import u3.l;
import u3.r;
import u3.s;

public class g
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    MessageSource localMessageSource = (MessageSource)paramBundle.get(MessageSource.NAME);
    if (localMessageSource == null) {
      return;
    }
    if (((localMessageSource instanceof Group)) && (l.S(localMessageSource.getId().longValue())))
    {
      paramBundle.putParcelable("ATTR_LOGO", BitmapFactory.decodeFile(l.A(localMessageSource.getId().longValue()).getAbsolutePath()));
      super.c(paramMessage, paramBundle);
      return;
    }
    Bitmap localBitmap = s.a().n(localMessageSource.getWebIcon());
    if (localBitmap != null) {
      paramBundle.putParcelable("ATTR_LOGO", localBitmap);
    } else {
      paramBundle.putParcelable("ATTR_LOGO", BitmapFactory.decodeResource(Resources.getSystem(), localMessageSource.getNotifyIcon()));
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.g
 * JD-Core Version:    0.7.0.1
 */