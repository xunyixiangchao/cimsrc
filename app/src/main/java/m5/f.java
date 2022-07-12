package m5;

import android.app.Application;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.ArrayMap;
import ca.c;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.handler.MessageHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class f
  extends e
{
  private static final Properties b;
  private static final Map<String, MessageHandler> c;
  
  static
  {
    Properties localProperties = new Properties();
    b = localProperties;
    c = new ArrayMap();
    try
    {
      InputStream localInputStream = HoxinApplication.h().getAssets().open("properties/handler.properties");
      localProperties.load(localInputStream);
      c.b(localInputStream);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private MessageHandler e(String paramString)
  {
    Map localMap = c;
    MessageHandler localMessageHandler = (MessageHandler)localMap.get(paramString);
    if (localMessageHandler != null) {
      return localMessageHandler;
    }
    try
    {
      localMessageHandler = (MessageHandler)Class.forName(b.getProperty(paramString)).newInstance();
      localMap.put(paramString, localMessageHandler);
      return localMessageHandler;
    }
    catch (Exception paramString)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public void b(Message paramMessage, Bundle paramBundle)
  {
    MessageHandler localMessageHandler = e(paramMessage.action);
    if (localMessageHandler != null)
    {
      localMessageHandler.handle(paramMessage, paramBundle, this);
      return;
    }
    super.c(paramMessage, paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m5.f
 * JD-Core Version:    0.7.0.1
 */