package j1;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import x0.b;

public class c<D>
{
  int a;
  c<D> b;
  b<D> c;
  Context d;
  boolean e = false;
  boolean f = false;
  boolean g = true;
  boolean h = false;
  boolean i = false;
  
  public c(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  public void a()
  {
    this.f = true;
    m();
  }
  
  public boolean b()
  {
    return n();
  }
  
  public void c()
  {
    this.i = false;
  }
  
  public String d(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    b.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void e()
  {
    b localb = this.c;
    if (localb != null) {
      localb.a(this);
    }
  }
  
  public void f(D paramD)
  {
    c localc = this.b;
    if (localc != null) {
      localc.a(this, paramD);
    }
  }
  
  @Deprecated
  public void g(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if ((this.e) || (this.h) || (this.i))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.h);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.i);
    }
    if ((this.f) || (this.g))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.f);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.g);
    }
  }
  
  public void h()
  {
    p();
  }
  
  public Context i()
  {
    return this.d;
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.g;
  }
  
  public boolean l()
  {
    return this.e;
  }
  
  protected void m() {}
  
  protected boolean n()
  {
    throw null;
  }
  
  public void o()
  {
    if (this.e)
    {
      h();
      return;
    }
    this.h = true;
  }
  
  protected void p() {}
  
  protected void q() {}
  
  protected void r()
  {
    throw null;
  }
  
  protected void s()
  {
    throw null;
  }
  
  public void t(int paramInt, c<D> paramc)
  {
    if (this.b == null)
    {
      this.b = paramc;
      this.a = paramInt;
      return;
    }
    throw new IllegalStateException("There is already a listener registered");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    b.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void u()
  {
    q();
    this.g = true;
    this.e = false;
    this.f = false;
    this.h = false;
    this.i = false;
  }
  
  public void v()
  {
    if (this.i) {
      o();
    }
  }
  
  public final void w()
  {
    this.e = true;
    this.g = false;
    this.f = false;
    r();
  }
  
  public void x()
  {
    this.e = false;
    s();
  }
  
  public boolean y()
  {
    boolean bool = this.h;
    this.h = false;
    this.i |= bool;
    return bool;
  }
  
  public void z(c<D> paramc)
  {
    c localc = this.b;
    if (localc != null)
    {
      if (localc == paramc)
      {
        this.b = null;
        return;
      }
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    throw new IllegalStateException("No listener register");
  }
  
  public final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      c.this.o();
    }
  }
  
  public static abstract interface b<D>
  {
    public abstract void a(c<D> paramc);
  }
  
  public static abstract interface c<D>
  {
    public abstract void a(c<D> paramc, D paramD);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j1.c
 * JD-Core Version:    0.7.0.1
 */