package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.l;
import j1.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a
{
  public static <T extends l,  extends a0> a c(T paramT)
  {
    return new b(paramT, ((a0)paramT).getViewModelStore());
  }
  
  public abstract void a(int paramInt);
  
  @Deprecated
  public abstract void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract <D> c<D> d(int paramInt, Bundle paramBundle, a<D> parama);
  
  public abstract void e();
  
  public static abstract interface a<D>
  {
    public abstract void a(c<D> paramc, D paramD);
    
    public abstract c<D> b(int paramInt, Bundle paramBundle);
    
    public abstract void c(c<D> paramc);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.loader.app.a
 * JD-Core Version:    0.7.0.1
 */