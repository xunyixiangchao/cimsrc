package n4;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.group.api.request.DeleteMemberRequest;
import java.util.ArrayList;
import java.util.List;
import l3.b.c;
import s3.e;

public class a
  extends l3.b
{
  public static void b(long paramLong, e<BaseResult> parame)
  {
    ((o4.a)l3.b.a(o4.a.class)).a(paramLong).B(new b.c(parame));
  }
  
  public static void c(long paramLong1, long paramLong2, e<BaseResult> parame)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    DeleteMemberRequest localDeleteMemberRequest = new DeleteMemberRequest();
    localDeleteMemberRequest.setGroupId(Long.valueOf(paramLong1));
    localDeleteMemberRequest.setIdList(localArrayList);
    ((o4.a)l3.b.a(o4.a.class)).b(localDeleteMemberRequest).B(new b.c(parame));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n4.a
 * JD-Core Version:    0.7.0.1
 */