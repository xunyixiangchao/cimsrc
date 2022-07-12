package b3;

import android.util.Log;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class a
{
  private boolean a = true;
  
  public static a d()
  {
    return b.a();
  }
  
  private String e(SocketChannel paramSocketChannel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSocketChannel == null) {
      return "";
    }
    localStringBuilder.append(" [");
    localStringBuilder.append("id:");
    localStringBuilder.append(paramSocketChannel.hashCode());
    try
    {
      if (paramSocketChannel.socket().getLocalAddress() != null)
      {
        localStringBuilder.append(" L:");
        localStringBuilder.append(paramSocketChannel.socket().getLocalAddress());
        localStringBuilder.append(":");
        localStringBuilder.append(paramSocketChannel.socket().getLocalPort());
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          if (paramSocketChannel.socket().getRemoteSocketAddress() != null)
          {
            localStringBuilder.append(" R:");
            localStringBuilder.append(paramSocketChannel.socket().getRemoteSocketAddress().toString());
          }
          label118:
          localStringBuilder.append("]");
          return localStringBuilder.toString();
          localException = localException;
        }
      }
      catch (Exception paramSocketChannel)
      {
        break label118;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CONNECT FAILURE, TRY RECONNECT AFTER ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("ms");
      Log.d("CIM", localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CONNECTED:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" STOPPED:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" DESTROYED:");
      localStringBuilder.append(paramBoolean3);
      Log.d("CIM", localStringBuilder.toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void f(String paramString, int paramInt)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INVALID SOCKET ADDRESS -> HOST:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" PORT:");
      localStringBuilder.append(paramInt);
      Log.d("CIM", localStringBuilder.toString());
    }
  }
  
  public void g(SocketChannel paramSocketChannel, Object paramObject)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[RECEIVED]");
      localStringBuilder.append(e(paramSocketChannel));
      localStringBuilder.append("\n");
      localStringBuilder.append(paramObject);
      Log.i("CIM", localStringBuilder.toString());
    }
  }
  
  public void h(SocketChannel paramSocketChannel, Object paramObject)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[  SENT  ]");
      localStringBuilder.append(e(paramSocketChannel));
      localStringBuilder.append("\n");
      localStringBuilder.append(paramObject);
      Log.i("CIM", localStringBuilder.toString());
    }
  }
  
  public void i(SocketChannel paramSocketChannel)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ CLOSED ] ID = ");
      localStringBuilder.append(paramSocketChannel.hashCode());
      Log.w("CIM", localStringBuilder.toString());
    }
  }
  
  public void j(SocketChannel paramSocketChannel)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ OPENED ]");
      localStringBuilder.append(e(paramSocketChannel));
      Log.i("CIM", localStringBuilder.toString());
    }
  }
  
  public void k(SocketChannel paramSocketChannel)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[  IDLE  ]");
      localStringBuilder.append(e(paramSocketChannel));
      Log.d("CIM", localStringBuilder.toString());
    }
  }
  
  public void l(String paramString, int paramInt)
  {
    if (this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("START CONNECT REMOTE HOST:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" PORT:");
      localStringBuilder.append(paramInt);
      Log.i("CIM", localStringBuilder.toString());
    }
  }
  
  private static class b
  {
    private static final a a = new a(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b3.a
 * JD-Core Version:    0.7.0.1
 */