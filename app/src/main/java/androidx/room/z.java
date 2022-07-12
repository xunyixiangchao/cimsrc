package androidx.room;

import java.util.concurrent.Executor;
import p1.h;
import p1.h.b;
import p1.h.c;

final class z
  implements h.c
{
  private final h.c a;
  private final f0.f b;
  private final Executor c;
  
  z(h.c paramc, f0.f paramf, Executor paramExecutor)
  {
    this.a = paramc;
    this.b = paramf;
    this.c = paramExecutor;
  }
  
  public h a(h.b paramb)
  {
    return new y(this.a.a(paramb), this.b, this.c);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.z
 * JD-Core Version:    0.7.0.1
 */