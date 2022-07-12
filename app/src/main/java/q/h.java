package q;

import androidx.camera.core.n1;
import java.util.Iterator;
import java.util.List;
import p.d0;
import p.j;
import p.z;
import s.c2;
import s.v0;

public class h
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  
  public h(c2 paramc21, c2 paramc22)
  {
    this.a = paramc22.a(d0.class);
    this.b = paramc21.a(z.class);
    this.c = paramc21.a(j.class);
  }
  
  public void a(List<v0> paramList)
  {
    if ((b()) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((v0)paramList.next()).c();
      }
      n1.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
    }
  }
  
  public boolean b()
  {
    return (this.a) || (this.b) || (this.c);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.h
 * JD-Core Version:    0.7.0.1
 */