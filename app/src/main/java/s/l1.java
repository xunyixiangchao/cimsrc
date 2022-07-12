package s;

import android.view.Surface;
import androidx.camera.core.e1;
import java.util.concurrent.Executor;

public abstract interface l1
{
  public abstract e1 b();
  
  public abstract int c();
  
  public abstract void close();
  
  public abstract void d();
  
  public abstract void e(a parama, Executor paramExecutor);
  
  public abstract int f();
  
  public abstract e1 g();
  
  public abstract int getHeight();
  
  public abstract Surface getSurface();
  
  public abstract int getWidth();
  
  public static abstract interface a
  {
    public abstract void a(l1 paraml1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.l1
 * JD-Core Version:    0.7.0.1
 */