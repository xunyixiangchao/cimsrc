package androidx.camera.camera2.internal;

import m.b.a;
import q.i;
import s.e1;
import s.n0.a;
import s.t2;

final class c2
  extends l0
{
  static final c2 c = new c2(new i());
  private final i b;
  
  private c2(i parami)
  {
    this.b = parami;
  }
  
  public void a(t2<?> paramt2, n0.a parama)
  {
    super.a(paramt2, parama);
    if ((paramt2 instanceof e1))
    {
      paramt2 = (e1)paramt2;
      b.a locala = new b.a();
      if (paramt2.R()) {
        this.b.a(paramt2.J(), locala);
      }
      parama.e(locala.c());
      return;
    }
    throw new IllegalArgumentException("config is not ImageCaptureConfig");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.c2
 * JD-Core Version:    0.7.0.1
 */