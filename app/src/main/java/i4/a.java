package i4;

import android.text.TextUtils;
import com.farsunset.hoxin.friend.entity.Friend;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  private static j4.a a;
  
  public static void a(Friend paramFriend, byte paramByte)
  {
    Friend localFriend = l(paramFriend.id);
    if (localFriend == null)
    {
      paramFriend.type = paramByte;
      a.w(paramFriend);
      return;
    }
    int i = localFriend.type;
    if ((i == 0) && (paramByte == 1))
    {
      a.n(Long.valueOf(paramFriend.id), (byte)2);
      return;
    }
    if ((i == 1) && (paramByte == 0))
    {
      a.n(Long.valueOf(paramFriend.id), (byte)2);
      return;
    }
    if ((i == 3) && (paramByte == 0))
    {
      a.n(Long.valueOf(paramFriend.id), (byte)0);
      return;
    }
    if ((i == 3) && (paramByte == 1)) {
      a.n(Long.valueOf(paramFriend.id), (byte)1);
    }
  }
  
  public static void b(List<Friend> paramList, byte paramByte)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((Friend)paramList.next(), paramByte);
      }
    }
  }
  
  public static void c(Long paramLong, byte paramByte)
  {
    Friend localFriend = l(paramLong.longValue());
    if (localFriend == null) {
      return;
    }
    if (localFriend.type == 0) {
      a.n(paramLong, (byte)3);
    }
    if (localFriend.type == 1) {
      a.n(paramLong, (byte)3);
    }
    if ((localFriend.type == 2) && (paramByte == 0)) {
      a.n(paramLong, (byte)1);
    }
    if ((localFriend.type == 2) && (paramByte == 1)) {
      a.n(paramLong, (byte)0);
    }
  }
  
  public static void d()
  {
    a.q((byte)1, (byte)3);
    a.q((byte)2, (byte)0);
  }
  
  public static boolean e(long paramLong)
  {
    return a.f(Long.valueOf(paramLong));
  }
  
  public static List<Friend> f()
  {
    return a.e();
  }
  
  public static List<Friend> g(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return Collections.emptyList();
    }
    j4.a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.d(localStringBuilder.toString());
  }
  
  public static List<Friend> h(String paramString, boolean paramBoolean, List<Long> paramList)
  {
    if (paramBoolean)
    {
      locala = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("%");
      localStringBuilder.append(paramString);
      localStringBuilder.append("%");
      return locala.j(localStringBuilder.toString(), paramList);
    }
    j4.a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.i(localStringBuilder.toString(), paramList);
  }
  
  public static List<Friend> i(List<Long> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.v(paramList);
    }
    return a.s(paramList);
  }
  
  public static List<Friend> j(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.r(paramArrayOfLong);
    }
    return a.t(paramArrayOfLong);
  }
  
  public static String k(long paramLong)
  {
    return a.k(Long.valueOf(paramLong));
  }
  
  public static Friend l(long paramLong)
  {
    return a.c(Long.valueOf(paramLong));
  }
  
  public static List<Long> m(byte paramByte)
  {
    return a.u(paramByte);
  }
  
  public static boolean n(long paramLong)
  {
    return (a.l(Long.valueOf(paramLong))) || (!e(paramLong));
  }
  
  public static boolean o(long paramLong)
  {
    return a.p(Long.valueOf(paramLong));
  }
  
  public static boolean p(long paramLong)
  {
    return (e(paramLong)) && (a.o(paramLong));
  }
  
  public static List<Friend> q(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return Collections.emptyList();
    }
    j4.a locala = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return locala.h(localStringBuilder.toString());
  }
  
  public static void r(j4.a parama)
  {
    a = parama;
  }
  
  public static void s(Long paramLong, String paramString)
  {
    a.m(paramLong, paramString);
  }
  
  public static void t(Long paramLong, String paramString)
  {
    a.g(paramLong, paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i4.a
 * JD-Core Version:    0.7.0.1
 */