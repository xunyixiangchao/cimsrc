package l3;

import com.farsunset.hoxin.friend.api.response.FriendListResult;
import com.farsunset.hoxin.friend.api.response.FriendResult;
import com.farsunset.hoxin.friend.entity.Friend;
import ea.t;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import m3.c;
import s3.e;
import s3.h0;

public class h
  extends b
{
  public static List<Friend> b(List<Long> paramList)
  {
    return c((Long[])paramList.toArray(new Long[0]));
  }
  
  public static List<Friend> c(Long[] paramArrayOfLong)
  {
    c localc;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
      localc = (c)b.a(c.class);
    }
    try
    {
      paramArrayOfLong = localc.b(paramArrayOfLong).g();
      if ((paramArrayOfLong.d()) && (paramArrayOfLong.a() != null))
      {
        paramArrayOfLong = ((FriendListResult)paramArrayOfLong.a()).data;
        return paramArrayOfLong;
      }
    }
    catch (IOException paramArrayOfLong)
    {
      label61:
      break label61;
    }
    return Collections.emptyList();
    return Collections.emptyList();
  }
  
  public static List<Friend> d(String[] paramArrayOfString)
  {
    LinkedList localLinkedList = new LinkedList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList.add(Long.valueOf(Long.parseLong(paramArrayOfString[i])));
      i += 1;
    }
    return b(localLinkedList);
  }
  
  public static Friend e(long paramLong)
  {
    Object localObject = ((c)b.a(c.class)).a(paramLong);
    try
    {
      localObject = ((ea.b)localObject).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((FriendResult)((t)localObject).a()).data;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public static void f(long paramLong, e<FriendResult> parame)
  {
    ((c)b.a(c.class)).a(paramLong).B(new b.c(new a(parame)));
  }
  
  public static void g(String paramString, e<FriendResult> parame)
  {
    ((c)b.a(c.class)).c(paramString).B(new b.c(parame));
  }
  
  class a
    extends h0<FriendResult>
  {
    a() {}
    
    public void a(FriendResult paramFriendResult)
    {
      h.this.onHttpResponse(paramFriendResult);
    }
    
    public void onHttpException(Exception paramException)
    {
      h.this.onHttpException(paramException);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l3.h
 * JD-Core Version:    0.7.0.1
 */