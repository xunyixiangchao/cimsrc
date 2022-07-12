package s;

import androidx.camera.core.q;
import androidx.camera.core.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0.h;

public class n1
  implements q
{
  private int b;
  
  public n1(int paramInt)
  {
    this.b = paramInt;
  }
  
  public List<r> b(List<r> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      r localr = (r)paramList.next();
      h.b(localr instanceof e0, "The camera info doesn't contain internal implementation.");
      Integer localInteger = ((e0)localr).a();
      if ((localInteger != null) && (localInteger.intValue() == this.b)) {
        localArrayList.add(localr);
      }
    }
    return localArrayList;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.n1
 * JD-Core Version:    0.7.0.1
 */