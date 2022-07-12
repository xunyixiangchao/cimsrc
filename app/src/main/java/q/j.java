package q;

import android.util.Size;
import p.l;
import p.o;
import s.l2.b;

public class j
{
  private final o a;
  
  public j()
  {
    this((o)l.a(o.class));
  }
  
  j(o paramo)
  {
    this.a = paramo;
  }
  
  public Size a(Size paramSize)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return paramSize;
    }
    localObject = ((o)localObject).a(l2.b.a);
    if (localObject == null) {
      return paramSize;
    }
    int i;
    if (((Size)localObject).getWidth() * ((Size)localObject).getHeight() > paramSize.getWidth() * paramSize.getHeight()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramSize = (Size)localObject;
    }
    return paramSize;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.j
 * JD-Core Version:    0.7.0.1
 */