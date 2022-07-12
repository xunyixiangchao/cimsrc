package s;

import androidx.camera.core.k;
import androidx.camera.core.r;
import androidx.camera.core.v2;
import androidx.camera.core.v2.d;
import java.util.Collection;

public abstract interface g0
  extends k, v2.d
{
  public abstract void a(boolean paramBoolean);
  
  public abstract r e();
  
  public abstract void f(Collection<v2> paramCollection);
  
  public abstract void g(Collection<v2> paramCollection);
  
  public abstract void h(w paramw);
  
  public abstract e0 i();
  
  public abstract w1<a> l();
  
  public abstract b0 m();
  
  public abstract w n();
  
  public static enum a
  {
    private final boolean a;
    
    static
    {
      a locala1 = new a("PENDING_OPEN", 0, false);
      b = locala1;
      a locala2 = new a("OPENING", 1, true);
      c = locala2;
      a locala3 = new a("OPEN", 2, true);
      d = locala3;
      a locala4 = new a("CLOSING", 3, true);
      e = locala4;
      a locala5 = new a("CLOSED", 4, false);
      f = locala5;
      a locala6 = new a("RELEASING", 5, true);
      g = locala6;
      a locala7 = new a("RELEASED", 6, false);
      h = locala7;
      i = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
    }
    
    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    boolean a()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.g0
 * JD-Core Version:    0.7.0.1
 */