package v5;

import android.content.Intent;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.micro.api.response.MicroServerListResult;
import com.farsunset.hoxin.micro.api.response.MicroServerMenuListResult;
import com.farsunset.hoxin.micro.api.response.MicroServerResponse;
import com.farsunset.hoxin.micro.api.response.MicroServerResult;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import com.farsunset.hoxin.micro.model.MenuEvent;
import ea.d;
import ea.t;
import l3.b.c;
import m5.k;

public class b
  extends l3.b
{
  public static void b(long paramLong, s3.e<MicroServerMenuListResult> parame)
  {
    ((w5.b)l3.b.a(w5.b.class)).e(paramLong).B(new b.c(parame));
  }
  
  public static void c(long paramLong, s3.e<MicroServerResult> parame)
  {
    ((w5.b)l3.b.a(w5.b.class)).a(paramLong).B(new b.c(parame));
  }
  
  public static void d(final MicroServer paramMicroServer, Message paramMessage)
  {
    final MenuEvent localMenuEvent = new MenuEvent();
    localMenuEvent.action = "text";
    localMenuEvent.content = paramMessage.content;
    localMenuEvent.uid = i3.e.o().toString();
    ((w5.b)l3.b.a(w5.b.class)).b(paramMicroServer.url, localMenuEvent).B(new a(paramMessage, localMenuEvent, paramMicroServer));
  }
  
  public static void e(final MicroServer paramMicroServer, MicroServerMenu paramMicroServerMenu)
  {
    MenuEvent localMenuEvent = new MenuEvent();
    localMenuEvent.action = "menu";
    localMenuEvent.content = paramMicroServerMenu.code;
    localMenuEvent.uid = i3.e.o().toString();
    ((w5.b)l3.b.a(w5.b.class)).b(paramMicroServer.url, localMenuEvent).B(new b(localMenuEvent, paramMicroServer));
  }
  
  public static void f(long paramLong, int paramInt, String paramString, s3.e<MicroServerListResult> parame)
  {
    ((w5.b)l3.b.a(w5.b.class)).d(paramLong, paramInt, paramString).B(new b.c(parame));
  }
  
  public static void g(long paramLong, s3.e<BaseResult> parame)
  {
    ((w5.b)l3.b.a(w5.b.class)).c(paramLong).B(new b.c(parame));
  }
  
  public static void h(long paramLong, s3.e<BaseResult> parame)
  {
    ((w5.b)l3.b.a(w5.b.class)).f(paramLong).B(new b.c(parame));
  }
  
  class a
    implements d<MicroServerResponse>
  {
    a(MenuEvent paramMenuEvent, MicroServer paramMicroServer) {}
    
    public void a(ea.b<MicroServerResponse> paramb, Throwable paramThrowable)
    {
      b.this.state = Byte.valueOf((byte)2);
      n5.b.d(b.this);
      paramb = new Intent("com.farsunset.hoxin.ACTION_WINDOW_REFRESH_MESSAGE");
      paramb.putExtra(Message.NAME, b.this);
      HoxinApplication.t(paramb);
    }
    
    public void c(ea.b<MicroServerResponse> paramb, t<MicroServerResponse> paramt)
    {
      b.this.state = Byte.valueOf((byte)4);
      n5.b.d(b.this);
      paramb = new Intent("com.farsunset.hoxin.ACTION_WINDOW_REFRESH_MESSAGE");
      paramb.putExtra(Message.NAME, b.this);
      HoxinApplication.t(paramb);
      if ((paramt.d()) && (paramt.a() != null))
      {
        if (((MicroServerResponse)paramt.a()).content == null) {
          return;
        }
        paramb = new Message();
        paramb.id = System.currentTimeMillis();
        paramb.receiver = Long.valueOf(Long.parseLong(localMenuEvent.uid));
        paramb.sender = Long.valueOf(paramMicroServer.id);
        paramb.action = "200";
        paramb.createTime = Long.valueOf(System.currentTimeMillis());
        paramb.content = ((MicroServerResponse)paramt.a()).getContent();
        paramb.format = ((MicroServerResponse)paramt.a()).format;
        paramb.state = Byte.valueOf((byte)10);
        k.c(paramb);
      }
    }
  }
  
  class b
    implements d<MicroServerResponse>
  {
    b(MicroServer paramMicroServer) {}
    
    public void a(ea.b<MicroServerResponse> paramb, Throwable paramThrowable)
    {
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MICRO_SERVER_INVOKED"));
    }
    
    public void c(ea.b<MicroServerResponse> paramb, t<MicroServerResponse> paramt)
    {
      HoxinApplication.t(new Intent("com.farsunset.hoxin.ACTION_MICRO_SERVER_INVOKED"));
      if ((paramt.d()) && (paramt.a() != null))
      {
        if (((MicroServerResponse)paramt.a()).content == null) {
          return;
        }
        paramb = new Message();
        paramb.id = System.currentTimeMillis();
        paramb.receiver = Long.valueOf(Long.parseLong(b.this.uid));
        paramb.sender = Long.valueOf(paramMicroServer.id);
        paramb.action = "200";
        paramb.createTime = Long.valueOf(System.currentTimeMillis());
        paramb.content = ((MicroServerResponse)paramt.a()).getContent();
        paramb.format = ((MicroServerResponse)paramt.a()).format;
        paramb.state = Byte.valueOf((byte)10);
        k.c(paramb);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v5.b
 * JD-Core Version:    0.7.0.1
 */