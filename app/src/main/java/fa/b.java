package fa;

import b8.c;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import l9.e0;
import l9.z;
import v7.v;

final class b<T>
  implements ea.f<T, e0>
{
  private static final z c = z.b("application/json; charset=UTF-8");
  private static final Charset d = Charset.forName("UTF-8");
  private final v7.f a;
  private final v<T> b;
  
  b(v7.f paramf, v<T> paramv)
  {
    this.a = paramf;
    this.b = paramv;
  }
  
  public e0 a(T paramT)
  {
    aa.b localb = new aa.b();
    Object localObject = new OutputStreamWriter(localb.m0(), d);
    localObject = this.a.p((Writer)localObject);
    this.b.d((c)localObject, paramT);
    ((c)localObject).close();
    return e0.c(c, localb.p0());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     fa.b
 * JD-Core Version:    0.7.0.1
 */