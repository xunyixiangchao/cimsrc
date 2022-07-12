package q;

import android.hardware.camera2.CaptureRequest;
import java.util.Iterator;
import java.util.List;
import p.c0;
import p.l;

public class o
{
  private final boolean a;
  
  public o()
  {
    boolean bool;
    if ((c0)l.a(c0.class) != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
  }
  
  public boolean a(List<CaptureRequest> paramList, boolean paramBoolean)
  {
    if (this.a)
    {
      if (!paramBoolean) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)((CaptureRequest)paramList.next()).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
        if ((i == 2) || (i == 3)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.o
 * JD-Core Version:    0.7.0.1
 */