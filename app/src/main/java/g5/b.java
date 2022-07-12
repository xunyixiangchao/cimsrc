package g5;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.message.entity.Message;
import java.util.ArrayList;

public class b
  extends BaseResult
{
  public ArrayList<Message> a;
  
  public boolean isNotEmpty()
  {
    ArrayList localArrayList = this.a;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g5.b
 * JD-Core Version:    0.7.0.1
 */