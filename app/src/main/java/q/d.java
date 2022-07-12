package q;

import android.util.Size;
import java.util.ArrayList;
import java.util.List;
import p.l;
import p.n;

public class d
{
  private final String a;
  
  public d(String paramString)
  {
    this.a = paramString;
  }
  
  public List<Size> a(int paramInt)
  {
    n localn = (n)l.a(n.class);
    if (localn == null) {
      return new ArrayList();
    }
    return localn.a(this.a, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.d
 * JD-Core Version:    0.7.0.1
 */