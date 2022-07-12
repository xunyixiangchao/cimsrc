package androidx.camera.camera2.internal;

import androidx.camera.core.n1;
import n.z;
import p.e;
import p.g;
import q.c;
import s.c2;
import s.j;

public class d
  implements j
{
  private final boolean a;
  private final int b;
  private final c c;
  
  public d(String paramString, z paramz)
  {
    try
    {
      i = Integer.parseInt(paramString);
      bool = true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      boolean bool;
      label15:
      StringBuilder localStringBuilder;
      break label15;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Camera id is not an integer: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", unable to create CamcorderProfileProvider");
    n1.k("Camera2CamcorderProfileProvider", localStringBuilder.toString());
    bool = false;
    i = -1;
    this.a = bool;
    this.b = i;
    this.c = new c((e)g.a(paramString, paramz).b(e.class));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.d
 * JD-Core Version:    0.7.0.1
 */