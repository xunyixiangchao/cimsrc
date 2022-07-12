package n5;

import android.os.Bundle;
import com.farsunset.hoxin.message.entity.Message;
import m5.e;

public class b
{
  private static final b b = new b();
  private final e a;
  
  private b()
  {
    m5.d locald = new m5.d();
    this.a = locald;
    c localc = new c();
    a locala = new a();
    d locald1 = new d();
    locald.d(localc);
    localc.d(locald1);
    locald1.d(locala);
  }
  
  public static void a(Message paramMessage, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ATTR_ACTION", 1);
    paramMessage.direction = (paramBoolean ^ true);
    b.a.a().b(paramMessage, localBundle);
  }
  
  public static void b(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ATTR_ACTION", -1);
    b.a.a().b(paramMessage, localBundle);
  }
  
  public static void c(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ATTR_ACTION", 0);
    b.a.a().b(paramMessage, localBundle);
  }
  
  public static void d(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ATTR_ACTION", 0);
    b.a.a().b(paramMessage, localBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n5.b
 * JD-Core Version:    0.7.0.1
 */