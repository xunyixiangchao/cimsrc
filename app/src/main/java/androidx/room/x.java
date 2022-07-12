package androidx.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.Executor;
import p1.g;
import p1.j;
import p1.k;

final class x
  implements g
{
  private final g a;
  private final f0.f b;
  private final Executor c;
  
  x(g paramg, f0.f paramf, Executor paramExecutor)
  {
    this.a = paramg;
    this.b = paramf;
    this.c = paramExecutor;
  }
  
  public String G()
  {
    return this.a.G();
  }
  
  public boolean I()
  {
    return this.a.I();
  }
  
  public boolean M()
  {
    return this.a.M();
  }
  
  public void P()
  {
    this.c.execute(new r(this));
    this.a.P();
  }
  
  public Cursor Q(j paramj, CancellationSignal paramCancellationSignal)
  {
    paramCancellationSignal = new a0();
    paramj.a(paramCancellationSignal);
    this.c.execute(new w(this, paramj, paramCancellationSignal));
    return this.a.x(paramj);
  }
  
  public void R()
  {
    this.c.execute(new q(this));
    this.a.R();
  }
  
  public Cursor a0(String paramString)
  {
    this.c.execute(new u(this, paramString));
    return this.a.a0(paramString);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void e()
  {
    this.c.execute(new p(this));
    this.a.e();
  }
  
  public void f()
  {
    this.c.execute(new s(this));
    this.a.f();
  }
  
  public boolean isOpen()
  {
    return this.a.isOpen();
  }
  
  public List<Pair<String, String>> m()
  {
    return this.a.m();
  }
  
  public void p(String paramString)
  {
    this.c.execute(new t(this, paramString));
    this.a.p(paramString);
  }
  
  public k v(String paramString)
  {
    return new d0(this.a.v(paramString), this.b, paramString, this.c);
  }
  
  public Cursor x(j paramj)
  {
    a0 locala0 = new a0();
    paramj.a(locala0);
    this.c.execute(new v(this, paramj, locala0));
    return this.a.x(paramj);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.x
 * JD-Core Version:    0.7.0.1
 */