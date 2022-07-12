package d2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class y
{
  private boolean a;
  private final Handler b = new Handler(Looper.getMainLooper(), new a());
  
  void a(v<?> paramv, boolean paramBoolean)
  {
    try
    {
      if ((!this.a) && (!paramBoolean))
      {
        this.a = true;
        paramv.a();
        this.a = false;
      }
      else
      {
        this.b.obtainMessage(1, paramv).sendToTarget();
      }
      return;
    }
    finally {}
  }
  
  private static final class a
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        ((v)paramMessage.obj).a();
        return true;
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.y
 * JD-Core Version:    0.7.0.1
 */