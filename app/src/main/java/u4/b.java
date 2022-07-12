package u4;

import com.farsunset.hoxin.friend.entity.Friend;
import java.io.Serializable;
import java.util.Comparator;

public class b
  implements Comparator<Friend>, Serializable
{
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    if ("#".equals(paramFriend2.firstPinyin)) {
      return -1;
    }
    if ("#".equals(paramFriend1.firstPinyin)) {
      return 1;
    }
    if ("☆".equals(paramFriend2.firstPinyin)) {
      return 1;
    }
    if ("☆".equals(paramFriend1.firstPinyin)) {
      return -1;
    }
    return paramFriend1.firstPinyin.compareToIgnoreCase(paramFriend2.firstPinyin);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u4.b
 * JD-Core Version:    0.7.0.1
 */