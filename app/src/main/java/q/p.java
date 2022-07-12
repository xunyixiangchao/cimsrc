package q;

import android.util.Size;
import androidx.camera.core.impl.utils.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import p.b0;
import p.l;

public class p
{
  private static final Size b = new Size(320, 240);
  private static final Comparator<Size> c = new c();
  private final b0 a = (b0)l.a(b0.class);
  
  public Size[] a(Size[] paramArrayOfSize)
  {
    Object localObject = paramArrayOfSize;
    if (this.a != null)
    {
      localObject = paramArrayOfSize;
      if (b0.a())
      {
        localObject = new ArrayList();
        int j = paramArrayOfSize.length;
        int i = 0;
        while (i < j)
        {
          Size localSize = paramArrayOfSize[i];
          if (c.compare(localSize, b) >= 0) {
            ((List)localObject).add(localSize);
          }
          i += 1;
        }
        localObject = (Size[])((List)localObject).toArray(new Size[0]);
      }
    }
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.p
 * JD-Core Version:    0.7.0.1
 */