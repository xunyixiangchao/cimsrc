package n4;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.group.api.request.GroupCreateRequest;
import com.farsunset.hoxin.group.api.request.GroupInviteRequest;
import com.farsunset.hoxin.group.api.response.GroupResult;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.group.entity.GroupMember;
import ea.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l3.b.c;
import s3.h0;

public class b
  extends l3.b
{
  public static void b(long paramLong, s3.e<BaseResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).e(paramLong).B(new b.c(parame));
  }
  
  public static void c(GroupCreateRequest paramGroupCreateRequest, final s3.e<GroupResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).f(paramGroupCreateRequest).B(new b.c(new a(parame)));
  }
  
  public static void d(long paramLong, s3.e<BaseResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).g(paramLong).B(new b.c(parame));
  }
  
  public static Group e(long paramLong)
  {
    Object localObject = (o4.b)l3.b.a(o4.b.class);
    try
    {
      localObject = ((o4.b)localObject).a(paramLong).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((GroupResult)((t)localObject).a()).data;
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public static void f(final long paramLong, List<Long> paramList, s3.e<BaseResult> parame)
  {
    GroupInviteRequest localGroupInviteRequest = new GroupInviteRequest();
    localGroupInviteRequest.setGroupId(Long.valueOf(paramLong));
    localGroupInviteRequest.setIdList(paramList);
    ((o4.b)l3.b.a(o4.b.class)).c(localGroupInviteRequest).B(new b.c(new b(localGroupInviteRequest, paramLong, parame)));
  }
  
  public static void g(long paramLong, s3.e<BaseResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).d(paramLong).B(new b.c(parame));
  }
  
  public static void h(long paramLong, String paramString, s3.e<BaseResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).b(paramLong, paramString).B(new b.c(parame));
  }
  
  public static void i(long paramLong, String paramString, s3.e<BaseResult> parame)
  {
    ((o4.b)l3.b.a(o4.b.class)).h(paramLong, paramString).B(new b.c(parame));
  }
  
  class a
    extends h0<LongResult>
  {
    a(s3.e parame) {}
    
    public void a(LongResult paramLongResult)
    {
      Group localGroup = new Group();
      localGroup.id = paramLongResult.data.longValue();
      localGroup.name = b.this.getName();
      localGroup.uid = i3.e.o().longValue();
      localGroup.memberList = new ArrayList();
      Object localObject = new GroupMember();
      ((GroupMember)localObject).groupId = localGroup.id;
      ((GroupMember)localObject).uid = i3.e.o().longValue();
      ((GroupMember)localObject).name = i3.e.j();
      ((GroupMember)localObject).type = 1;
      localGroup.memberList.add(localObject);
      localObject = b.this.getIdList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        GroupMember localGroupMember = new GroupMember();
        localGroupMember.groupId = localGroup.id;
        localGroupMember.uid = localLong.longValue();
        localGroupMember.type = 0;
        localGroupMember.name = i4.a.k(localLong.longValue());
        localGroup.memberList.add(localGroupMember);
      }
      p4.a.a(localGroup);
      localObject = new GroupResult();
      ((GroupResult)localObject).data = localGroup;
      ((BaseResult)localObject).code = paramLongResult.code;
      parame.onHttpResponse((BaseResult)localObject);
    }
    
    public void onHttpException(Exception paramException)
    {
      parame.onHttpException(paramException);
    }
  }
  
  class b
    extends h0<BaseResult>
  {
    b(long paramLong, s3.e parame) {}
    
    public void onHttpException(Exception paramException)
    {
      this.c.onHttpException(paramException);
    }
    
    public void onHttpResponse(BaseResult paramBaseResult)
    {
      Iterator localIterator = b.this.getIdList().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        GroupMember localGroupMember = new GroupMember();
        localGroupMember.groupId = paramLong;
        localGroupMember.uid = localLong.longValue();
        localGroupMember.type = 0;
        localGroupMember.name = i4.a.k(localLong.longValue());
        p4.b.a(localGroupMember);
      }
      this.c.onHttpResponse(paramBaseResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n4.b
 * JD-Core Version:    0.7.0.1
 */