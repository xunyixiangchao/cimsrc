package com.farsunset.cim.sdk.android;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.farsunset.cim.sdk.android.model.BinaryBody;
import com.farsunset.cim.sdk.android.model.Ping;
import com.farsunset.cim.sdk.android.model.Pong;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.SentBody;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class g
{
  private static g j;
  private static final b3.a k = ;
  private SocketChannel a;
  private final Context b;
  private final ByteBuffer c = ByteBuffer.allocate(3);
  private final ExecutorService d = Executors.newFixedThreadPool(1, e.a);
  private final ExecutorService e = Executors.newFixedThreadPool(1, d.a);
  private final a3.b f = new a3.b();
  private final a3.a g = new a3.a();
  private final Random h = new Random();
  private final Handler i = new a();
  
  private g(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void h()
  {
    this.i.removeMessages(0);
    this.i.sendEmptyMessageDelayed(0, 120000L);
  }
  
  public static g j(Context paramContext)
  {
    try
    {
      if (j == null) {
        j = new g(paramContext);
      }
      paramContext = j;
      return paramContext;
    }
    finally {}
  }
  
  private void k()
  {
    long l = this.h.nextInt(7001) + 3000;
    k.a(l);
    Intent localIntent = new Intent();
    localIntent.setPackage(this.b.getPackageName());
    localIntent.setAction("com.farsunset.cim.CONNECT_FAILED");
    localIntent.putExtra("interval", l);
    this.b.sendBroadcast(localIntent);
  }
  
  private void l()
  {
    h();
    w();
  }
  
  private void m()
  {
    g();
  }
  
  private void n()
  {
    h();
    Object localObject = this.g.a(this.c, this.a);
    k.g(this.a, localObject);
    if ((localObject instanceof Ping))
    {
      y(Pong.getInstance());
      return;
    }
    t(localObject);
  }
  
  private void t(Object paramObject)
  {
    Intent localIntent;
    if ((paramObject instanceof com.farsunset.cim.sdk.android.model.Message))
    {
      localIntent = new Intent();
      localIntent.setPackage(this.b.getPackageName());
      localIntent.setAction("com.farsunset.cim.MESSAGE_RECEIVED");
      localIntent.putExtra(com.farsunset.cim.sdk.android.model.Message.class.getName(), (com.farsunset.cim.sdk.android.model.Message)paramObject);
      this.b.sendBroadcast(localIntent);
    }
    if ((paramObject instanceof ReplyBody))
    {
      localIntent = new Intent();
      localIntent.setPackage(this.b.getPackageName());
      localIntent.setAction("com.farsunset.cim.REPLY_RECEIVED");
      localIntent.putExtra(ReplyBody.class.getName(), (ReplyBody)paramObject);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  private void u(Object paramObject)
  {
    k.h(this.a, paramObject);
    if ((paramObject instanceof SentBody))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.b.getPackageName());
      localIntent.setAction("com.farsunset.cim.SEND_FINISHED");
      localIntent.putExtra(SentBody.class.getName(), (SentBody)paramObject);
      this.b.sendBroadcast(localIntent);
    }
  }
  
  private void v()
  {
    this.i.removeMessages(0);
    k.i(this.a);
    Intent localIntent = new Intent();
    localIntent.setPackage(this.b.getPackageName());
    localIntent.setAction("com.farsunset.cim.CONNECTION_CLOSED");
    this.b.sendBroadcast(localIntent);
  }
  
  private void w()
  {
    k.j(this.a);
    Intent localIntent = new Intent();
    localIntent.setPackage(this.b.getPackageName());
    localIntent.setAction("com.farsunset.cim.CONNECT_FINISHED");
    this.b.sendBroadcast(localIntent);
  }
  
  private void x()
  {
    k.k(this.a);
    g();
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 207	com/farsunset/cim/sdk/android/g:o	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 176	com/farsunset/cim/sdk/android/g:a	Ljava/nio/channels/SocketChannel;
    //   12: invokevirtual 325	java/nio/channels/SocketChannel:close	()V
    //   15: goto +10 -> 25
    //   18: astore_1
    //   19: aload_0
    //   20: invokespecial 327	com/farsunset/cim/sdk/android/g:v	()V
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: invokespecial 327	com/farsunset/cim/sdk/android/g:v	()V
    //   29: return
    //   30: astore_1
    //   31: goto -6 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	g
    //   18	6	1	localObject	Object
    //   30	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	15	18	finally
    //   8	15	30	java/io/IOException
  }
  
  public void i(String paramString, int paramInt)
  {
    if (!h.m(this.b))
    {
      paramString = new Intent();
      paramString.setPackage(this.b.getPackageName());
      paramString.setAction("com.farsunset.cim.CONNECT_FAILED");
      this.b.sendBroadcast(paramString);
      return;
    }
    if (o()) {
      return;
    }
    this.e.execute(new c(this, paramString, paramInt));
  }
  
  public boolean o()
  {
    SocketChannel localSocketChannel = this.a;
    return (localSocketChannel != null) && (localSocketChannel.isConnected());
  }
  
  public void y(BinaryBody paramBinaryBody)
  {
    if (!o()) {
      return;
    }
    this.d.execute(new b(this, paramBinaryBody));
  }
  
  public void z()
  {
    y(Pong.getInstance());
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(android.os.Message paramMessage)
    {
      g.e(g.this).execute(new f(this));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.cim.sdk.android.g
 * JD-Core Version:    0.7.0.1
 */