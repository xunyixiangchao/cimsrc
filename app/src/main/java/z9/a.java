package z9;

import a9.f;
import aa.b;
import c9.g;
import java.io.EOFException;

public final class a
{
  public static final boolean a(b paramb)
  {
    f.f(paramb, "<this>");
    try
    {
      b localb = new b();
      paramb.h0(localb, 0L, g.d(paramb.z0(), 64L));
      int i = 0;
      while (i < 16)
      {
        int j = i + 1;
        if (!localb.D())
        {
          int k = localb.x0();
          i = j;
          if (Character.isISOControl(k))
          {
            boolean bool = Character.isWhitespace(k);
            i = j;
            if (!bool) {
              return false;
            }
          }
        }
      }
      return true;
    }
    catch (EOFException paramb) {}
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z9.a
 * JD-Core Version:    0.7.0.1
 */