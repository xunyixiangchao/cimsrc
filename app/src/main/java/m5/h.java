package m5;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.content.b;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import j5.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import u3.d;

public class h
  extends e
{
  public void b(Message paramMessage, Bundle paramBundle)
  {
    MessageParser localMessageParser = MessageParserFactory.getMessageParser(paramMessage.action);
    if (localMessageParser == null) {
      return;
    }
    MessageSource localMessageSource = (MessageSource)paramBundle.get(MessageSource.NAME);
    if (localMessageSource == null) {
      return;
    }
    Object localObject2 = (ChatSession)paramBundle.getSerializable("ATTR_CHAT_SESSION");
    Object localObject1 = localMessageParser.getNotificationIntent();
    ((Intent)localObject1).putExtra("ATTR_CHAT_SESSION", (Serializable)localObject2);
    PendingIntent localPendingIntent = PendingIntent.getActivity(HoxinApplication.h(), 1, (Intent)localObject1, 201326592);
    localObject1 = new AtomicReference(Integer.valueOf((int)((ChatSession)localObject2).id));
    NotificationManager localNotificationManager = (NotificationManager)b.h(HoxinApplication.h(), NotificationManager.class);
    Object localObject3 = localMessageParser.getNotificationChannelId(paramMessage);
    localObject3 = new androidx.core.app.h(HoxinApplication.h(), (String)localObject3);
    ((androidx.core.app.h)localObject3).e(true);
    ((androidx.core.app.h)localObject3).n(2131165623);
    ((androidx.core.app.h)localObject3).q(System.currentTimeMillis());
    ((androidx.core.app.h)localObject3).p(1);
    ((androidx.core.app.h)localObject3).f(localPendingIntent);
    if (d.k())
    {
      localObject2 = localMessageParser.getNotificationContent((ChatSession)localObject2, paramMessage);
      ((androidx.core.app.h)localObject3).j((Bitmap)paramBundle.getParcelable("ATTR_LOGO"));
      ((androidx.core.app.h)localObject3).h(localMessageParser.getTitle(localMessageSource, paramMessage));
      ((androidx.core.app.h)localObject3).g((CharSequence)localObject2);
    }
    else
    {
      ((AtomicReference)localObject1).set(Integer.valueOf(725813));
      ((androidx.core.app.h)localObject3).h(HoxinApplication.h().getString(2131690086));
      long l1 = a.o();
      long l2 = a.q();
      ((androidx.core.app.h)localObject3).g(HoxinApplication.h().getString(2131690085, new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
    }
    paramMessage = ((androidx.core.app.h)localObject3).a();
    localNotificationManager.notify(((Integer)((AtomicReference)localObject1).get()).intValue(), paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.h
 * JD-Core Version:    0.7.0.1
 */