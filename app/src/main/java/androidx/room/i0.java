package androidx.room;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import p1.h;
import p1.h.a;
import p1.h.b;
import p1.h.c;

class i0
  implements h.c
{
  private final String a;
  private final File b;
  private final Callable<InputStream> c;
  private final h.c d;
  
  i0(String paramString, File paramFile, Callable<InputStream> paramCallable, h.c paramc)
  {
    this.a = paramString;
    this.b = paramFile;
    this.c = paramCallable;
    this.d = paramc;
  }
  
  public h a(h.b paramb)
  {
    return new h0(paramb.a, this.a, this.b, this.c, paramb.c.a, this.d.a(paramb));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.i0
 * JD-Core Version:    0.7.0.1
 */