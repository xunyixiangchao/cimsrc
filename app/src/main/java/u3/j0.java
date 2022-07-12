package u3;

import android.content.Context;
import android.content.Intent;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.friend.ui.UserDetailedActivity;
import com.farsunset.hoxin.group.entity.GroupMember;
import i4.a;

public class j0
{
  public static void a(Context paramContext, long paramLong)
  {
    Friend localFriend = a.l(paramLong);
    if (localFriend != null) {
      b(paramContext, localFriend);
    }
  }
  
  public static void b(Context paramContext, Friend paramFriend)
  {
    Intent localIntent = new Intent(paramContext, UserDetailedActivity.class);
    localIntent.putExtra(Friend.class.getName(), paramFriend);
    paramContext.startActivity(localIntent);
  }
  
  public static void c(Context paramContext, GroupMember paramGroupMember)
  {
    Friend localFriend = a.l(paramGroupMember.uid);
    if (localFriend != null)
    {
      b(paramContext, localFriend);
      return;
    }
    localFriend = new Friend();
    localFriend.id = paramGroupMember.uid;
    localFriend.name = paramGroupMember.name;
    b(paramContext, localFriend);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.j0
 * JD-Core Version:    0.7.0.1
 */