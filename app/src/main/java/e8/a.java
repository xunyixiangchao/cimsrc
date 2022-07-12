package e8;

import android.content.Context;
import android.content.Intent;
import c8.d;
import c8.e;
import java.io.File;
import l8.c;

abstract class a
  implements b
{
  private c a;
  private File b;
  private d<File> c = new a();
  private c8.a<File> d;
  private c8.a<File> e;
  
  a(c paramc)
  {
    this.a = paramc;
  }
  
  public final b a(File paramFile)
  {
    this.b = paramFile;
    return this;
  }
  
  final void c()
  {
    c8.a locala = this.e;
    if (locala != null) {
      locala.a(this.b);
    }
  }
  
  final void d()
  {
    c8.a locala = this.d;
    if (locala != null) {
      locala.a(this.b);
    }
  }
  
  final void e()
  {
    Intent localIntent = new Intent("android.intent.action.INSTALL_PACKAGE");
    localIntent.setFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(c8.b.b(this.a.c(), this.b), "application/vnd.android.package-archive");
    this.a.i(localIntent);
  }
  
  final void f(e parame)
  {
    this.c.a(this.a.c(), null, parame);
  }
  
  class a
    implements d<File>
  {
    a() {}
    
    public void b(Context paramContext, File paramFile, e parame)
    {
      parame.g();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e8.a
 * JD-Core Version:    0.7.0.1
 */