package j5;

import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.message.entity.ChatSession;
import java.util.LinkedList;
import java.util.List;
import o3.c;

public class a
{
  private static k5.a a;
  
  public static void a(ChatSession paramChatSession)
  {
    paramChatSession.id = a.f(paramChatSession);
  }
  
  public static void b(ChatSession paramChatSession)
  {
    paramChatSession.priority = 0L;
    a.q(paramChatSession.id);
  }
  
  public static void c(long paramLong)
  {
    k5.a locala = a;
    int i = c.b.a();
    locala.l(new Long[] { Long.valueOf(paramLong) }, i);
  }
  
  public static void d(List<Long> paramList)
  {
    a.l((Long[])paramList.toArray(new Long[0]), c.b.a());
  }
  
  public static long e(long paramLong, int paramInt)
  {
    Long localLong = a.o(paramLong, paramInt);
    if (localLong == null) {
      return 0L;
    }
    return localLong.longValue();
  }
  
  public static long f(MessageSource paramMessageSource)
  {
    return e(paramMessageSource.getId().longValue(), paramMessageSource.getType());
  }
  
  public static List<Long> g(List<Long> paramList, int paramInt)
  {
    if (paramList.isEmpty()) {
      return new LinkedList();
    }
    return a.g((Long[])paramList.toArray(new Long[0]), paramInt);
  }
  
  public static List<ChatSession> h()
  {
    return a.e();
  }
  
  public static List<ChatSession> i(int[] paramArrayOfInt)
  {
    return a.p(paramArrayOfInt);
  }
  
  public static List<ChatSession> j(int[] paramArrayOfInt, String paramString)
  {
    k5.a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.m(paramArrayOfInt, localStringBuilder.toString());
  }
  
  public static ChatSession k(long paramLong)
  {
    return a.a(paramLong);
  }
  
  public static ChatSession l(long paramLong, int paramInt)
  {
    return a.c(paramLong, paramInt);
  }
  
  public static ChatSession m(MessageSource paramMessageSource)
  {
    return n(paramMessageSource, c.c);
  }
  
  public static ChatSession n(MessageSource paramMessageSource, c paramc)
  {
    if (paramMessageSource == null) {
      return null;
    }
    paramMessageSource = r(paramMessageSource);
    paramMessageSource.visible = paramc.a();
    return paramMessageSource;
  }
  
  public static int o()
  {
    return (int)a.k();
  }
  
  public static int p(long paramLong)
  {
    return (int)a.r(paramLong);
  }
  
  public static int q()
  {
    return (int)a.i();
  }
  
  private static ChatSession r(MessageSource paramMessageSource)
  {
    ChatSession localChatSession = l(paramMessageSource.getId().longValue(), paramMessageSource.getType());
    if (localChatSession != null) {
      return localChatSession;
    }
    localChatSession = new ChatSession();
    localChatSession.sourceType = paramMessageSource.getType();
    localChatSession.sourceId = paramMessageSource.getId().longValue();
    localChatSession.name = paramMessageSource.getName();
    localChatSession.timestamp = System.currentTimeMillis();
    a(localChatSession);
    return localChatSession;
  }
  
  public static void s(ChatSession paramChatSession)
  {
    long l = System.currentTimeMillis();
    paramChatSession.priority = l;
    a.d(paramChatSession.id, l);
  }
  
  public static void t(long paramLong, int paramInt)
  {
    a.n(paramLong, paramInt);
  }
  
  public static void u(k5.a parama)
  {
    a = parama;
  }
  
  public static void v(long paramLong, int paramInt, String paramString)
  {
    a.j(paramLong, paramInt, paramString);
  }
  
  public static void w(long paramLong, int paramInt)
  {
    a.h(paramLong, paramInt);
  }
  
  public static void x(ChatSession paramChatSession)
  {
    a.s(paramChatSession);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j5.a
 * JD-Core Version:    0.7.0.1
 */