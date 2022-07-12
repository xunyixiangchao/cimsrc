package q;

import android.hardware.camera2.CaptureRequest;
import java.util.Iterator;
import java.util.List;
import m.b.a;
import p.e0;
import p.l;
import s.n0;
import s.n0.a;
import s.v0;

public class r
{
  private final boolean a;
  
  public r()
  {
    boolean bool;
    if (l.a(e0.class) != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
  }
  
  public n0 a(n0 paramn0)
  {
    n0.a locala = new n0.a();
    locala.p(paramn0.g());
    Iterator localIterator = paramn0.e().iterator();
    while (localIterator.hasNext()) {
      locala.f((v0)localIterator.next());
    }
    locala.e(paramn0.d());
    paramn0 = new b.a();
    paramn0.e(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    locala.e(paramn0.c());
    return locala.h();
  }
  
  public boolean b(List<CaptureRequest> paramList, boolean paramBoolean)
  {
    if ((this.a) && (paramBoolean))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)((CaptureRequest)paramList.next()).get(CaptureRequest.FLASH_MODE);
        if ((localInteger != null) && (localInteger.intValue() == 2)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.r
 * JD-Core Version:    0.7.0.1
 */