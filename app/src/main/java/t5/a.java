package t5;

import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.io.Serializable;
import java.util.Comparator;

public class a
  implements Comparator<MicroServerMenu>, Serializable
{
  public int a(MicroServerMenu paramMicroServerMenu1, MicroServerMenu paramMicroServerMenu2)
  {
    return Integer.compare(paramMicroServerMenu1.sort, paramMicroServerMenu2.sort);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t5.a
 * JD-Core Version:    0.7.0.1
 */