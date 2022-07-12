package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher
{
  private final Runnable a;
  final ArrayDeque<b> b = new ArrayDeque();
  
  public OnBackPressedDispatcher(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  @SuppressLint({"LambdaLast"})
  public void a(l paraml, b paramb)
  {
    paraml = paraml.getLifecycle();
    if (paraml.b() == h.c.a) {
      return;
    }
    paramb.a(new LifecycleOnBackPressedCancellable(paraml, paramb));
  }
  
  a b(b paramb)
  {
    this.b.add(paramb);
    a locala = new a(paramb);
    paramb.a(locala);
    return locala;
  }
  
  public void c()
  {
    Object localObject = this.b.descendingIterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.c())
      {
        localb.b();
        return;
      }
    }
    localObject = this.a;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
  
  private class LifecycleOnBackPressedCancellable
    implements j, a
  {
    private final h a;
    private final b b;
    private a c;
    
    LifecycleOnBackPressedCancellable(h paramh, b paramb)
    {
      this.a = paramh;
      this.b = paramb;
      paramh.a(this);
    }
    
    public void cancel()
    {
      this.a.c(this);
      this.b.e(this);
      a locala = this.c;
      if (locala != null)
      {
        locala.cancel();
        this.c = null;
      }
    }
    
    public void d(l paraml, h.b paramb)
    {
      if (paramb == h.b.ON_START)
      {
        this.c = OnBackPressedDispatcher.this.b(this.b);
        return;
      }
      if (paramb == h.b.ON_STOP)
      {
        paraml = this.c;
        if (paraml != null) {
          paraml.cancel();
        }
      }
      else if (paramb == h.b.ON_DESTROY)
      {
        cancel();
      }
    }
  }
  
  private class a
    implements a
  {
    private final b a;
    
    a(b paramb)
    {
      this.a = paramb;
    }
    
    public void cancel()
    {
      OnBackPressedDispatcher.this.b.remove(this.a);
      this.a.e(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher
 * JD-Core Version:    0.7.0.1
 */