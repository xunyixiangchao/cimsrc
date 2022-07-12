package aa;

import a9.f;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

final class w
  extends a
{
  private final Socket m;
  
  public w(Socket paramSocket)
  {
    this.m = paramSocket;
  }
  
  protected IOException v(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void z()
  {
    try
    {
      this.m.close();
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (!l.c(localAssertionError)) {
        throw localAssertionError;
      }
    }
    catch (Exception localException)
    {
      m.a().log(Level.WARNING, f.m("Failed to close timed out socket ", this.m), localException);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.w
 * JD-Core Version:    0.7.0.1
 */