package j5;

import android.text.TextUtils;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.MessageSearchHit;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k5.c;

public class b
{
  private static c a;
  
  public static void A(c paramc)
  {
    a = paramc;
    paramc.w();
  }
  
  public static void B(long paramLong, Long paramLong1)
  {
    a.m(Long.valueOf(paramLong), paramLong1);
  }
  
  public static void C(long paramLong, Byte paramByte)
  {
    a.k(Long.valueOf(paramLong), paramByte);
  }
  
  public static void D(long paramLong, String paramString, Byte paramByte)
  {
    a.l(Long.valueOf(paramLong), paramString, paramByte);
  }
  
  public static void E(Message paramMessage)
  {
    a.k(Long.valueOf(paramMessage.id), paramMessage.state);
  }
  
  public static void a(Message paramMessage)
  {
    a.g(paramMessage);
  }
  
  public static long b(String paramString)
  {
    return a.z(paramString, (byte)10);
  }
  
  public static long c(String[] paramArrayOfString)
  {
    return a.x(paramArrayOfString, (byte)10);
  }
  
  public static void d(long paramLong)
  {
    a.a(Long.valueOf(paramLong));
  }
  
  public static void e(Long paramLong, String paramString)
  {
    a.B(paramLong, paramString);
  }
  
  public static void f(Long paramLong, String paramString1, String paramString2)
  {
    a.h(paramLong, paramString1, paramString2);
  }
  
  public static void g(String paramString)
  {
    a.s(paramString);
  }
  
  public static void h(long paramLong)
  {
    i(Collections.singletonList(Long.valueOf(paramLong)));
  }
  
  public static void i(List<Long> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    a.t(paramList);
  }
  
  public static boolean j(long paramLong)
  {
    return a.i(paramLong);
  }
  
  public static Message k(Long paramLong, long paramLong1)
  {
    return a.r(paramLong.longValue(), paramLong1);
  }
  
  public static Message l(Long paramLong)
  {
    return a.n(paramLong);
  }
  
  public static List<Message> m(String paramString)
  {
    return a.d(paramString);
  }
  
  public static List<Message> n(Long paramLong, long paramLong1)
  {
    List localList = a.o(paramLong.longValue(), paramLong1);
    paramLong1 = localList.size();
    if (paramLong1 < 10L) {
      localList.addAll(r(paramLong, paramLong1, 10L - paramLong1));
    }
    return localList;
  }
  
  public static Message o(long paramLong)
  {
    return a.c(Long.valueOf(paramLong));
  }
  
  public static Message p()
  {
    return a.p("500");
  }
  
  public static List<Message> q(Long paramLong)
  {
    return a.e(paramLong.longValue());
  }
  
  public static List<Message> r(Long paramLong, long paramLong1, long paramLong2)
  {
    return a.j(paramLong.longValue(), paramLong1, paramLong2);
  }
  
  public static List<Message> s()
  {
    return a.v(i5.a.a);
  }
  
  public static List<Message> t()
  {
    return a.f(i5.a.a, Byte.valueOf((byte)10), 3L);
  }
  
  public static void u(long paramLong)
  {
    a.k(Long.valueOf(paramLong), Byte.valueOf((byte)11));
  }
  
  public static void v(String paramString)
  {
    a.y(paramString, Byte.valueOf((byte)11));
  }
  
  public static void w(String[] paramArrayOfString)
  {
    a.A(paramArrayOfString, Byte.valueOf((byte)11));
  }
  
  public static List<Message> x(Long paramLong, byte paramByte)
  {
    return y(paramLong, paramByte, null);
  }
  
  public static List<Message> y(Long paramLong, byte paramByte, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 13;
    int[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 6;
    tmp12_7;
    if (TextUtils.isEmpty(paramString)) {
      return a.b(paramLong.longValue(), paramByte, arrayOfInt);
    }
    c localc = a;
    long l = paramLong.longValue();
    paramLong = new StringBuilder();
    paramLong.append("%");
    paramLong.append(paramString);
    paramLong.append("%");
    return localc.u(l, paramByte, paramLong.toString(), arrayOfInt);
  }
  
  public static List<MessageSearchHit> z(String[] paramArrayOfString, byte paramByte, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return Collections.emptyList();
    }
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    paramArrayOfString = ((c)localObject).q(paramArrayOfString, paramByte, localStringBuilder.toString(), new int[] { 13, 6 });
    paramString = paramArrayOfString.iterator();
    while (paramString.hasNext())
    {
      localObject = (MessageSearchHit)paramString.next();
      ((MessageSearchHit)localObject).session = a.k(((MessageSearchHit)localObject).sessionId);
    }
    return paramArrayOfString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j5.b
 * JD-Core Version:    0.7.0.1
 */