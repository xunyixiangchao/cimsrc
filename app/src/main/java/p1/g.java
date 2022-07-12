package p1;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

public abstract interface g
  extends Closeable
{
  public abstract String G();
  
  public abstract boolean I();
  
  public abstract boolean M();
  
  public abstract void P();
  
  public abstract Cursor Q(j paramj, CancellationSignal paramCancellationSignal);
  
  public abstract void R();
  
  public abstract Cursor a0(String paramString);
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract boolean isOpen();
  
  public abstract List<Pair<String, String>> m();
  
  public abstract void p(String paramString);
  
  public abstract k v(String paramString);
  
  public abstract Cursor x(j paramj);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.g
 * JD-Core Version:    0.7.0.1
 */