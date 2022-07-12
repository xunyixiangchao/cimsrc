package s;

import androidx.camera.core.d1;
import androidx.camera.core.e1;
import java.util.Collections;
import java.util.List;
import u.f;
import u7.a;

public final class j2
  implements k1
{
  private final int a;
  private final e1 b;
  
  public j2(e1 parame1, String paramString)
  {
    d1 locald1 = parame1.q();
    if (locald1 != null)
    {
      paramString = (Integer)locald1.a().c(paramString);
      if (paramString != null)
      {
        this.a = paramString.intValue();
        this.b = parame1;
        return;
      }
      throw new IllegalArgumentException("ImageProxy has no associated tag");
    }
    throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
  }
  
  public a<e1> a(int paramInt)
  {
    if (paramInt != this.a) {
      return f.f(new IllegalArgumentException("Capture id does not exist in the bundle"));
    }
    return f.h(this.b);
  }
  
  public List<Integer> b()
  {
    return Collections.singletonList(Integer.valueOf(this.a));
  }
  
  public void c()
  {
    this.b.close();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.j2
 * JD-Core Version:    0.7.0.1
 */