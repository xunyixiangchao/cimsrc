package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import s.k1;
import s.l1;
import s.n2;
import s.p0;
import u.f;
import x0.h;

class h0
  implements p0
{
  private final p0 a;
  private final p0 b;
  private final u7.a<List<Void>> c;
  final Executor d;
  private final int e;
  private l1 f = null;
  private d1 g = null;
  private final Object h = new Object();
  private boolean i = false;
  private boolean j = false;
  c.a<Void> k;
  private u7.a<Void> l;
  
  h0(p0 paramp01, int paramInt, p0 paramp02, Executor paramExecutor)
  {
    this.a = paramp01;
    this.b = paramp02;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramp01.d());
    localArrayList.add(paramp02.d());
    this.c = f.c(localArrayList);
    this.d = paramExecutor;
    this.e = paramInt;
  }
  
  private void j()
  {
    synchronized (this.h)
    {
      boolean bool1 = this.i;
      boolean bool2 = this.j;
      c.a locala = this.k;
      if ((bool1) && (!bool2)) {
        this.f.close();
      }
      if ((bool1) && (!bool2) && (locala != null)) {
        this.c.h(new e0(locala), t.a.a());
      }
      return;
    }
  }
  
  public void a(Size paramSize)
  {
    d locald = new d(ImageReader.newInstance(paramSize.getWidth(), paramSize.getHeight(), 35, this.e));
    this.f = locald;
    this.a.c(locald.getSurface(), 35);
    this.a.a(paramSize);
    this.b.a(paramSize);
    this.f.e(new g0(this), t.a.a());
  }
  
  public void b(k1 paramk1)
  {
    synchronized (this.h)
    {
      if (this.i) {
        return;
      }
      this.j = true;
      ??? = paramk1.a(((Integer)paramk1.b().get(0)).intValue());
      h.a(((Future)???).isDone());
      try
      {
        this.g = ((e1)((Future)???).get()).q();
        this.a.b(paramk1);
        return;
      }
      catch (ExecutionException|InterruptedException paramk1)
      {
        label87:
        break label87;
      }
      throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
    }
  }
  
  public void c(Surface paramSurface, int paramInt)
  {
    this.b.c(paramSurface, paramInt);
  }
  
  public void close()
  {
    synchronized (this.h)
    {
      if (this.i) {
        return;
      }
      this.i = true;
      this.a.close();
      this.b.close();
      j();
      return;
    }
  }
  
  public u7.a<Void> d()
  {
    synchronized (this.h)
    {
      u7.a locala;
      if ((this.i) && (!this.j))
      {
        locala = f.o(this.c, f0.a, t.a.a());
      }
      else
      {
        if (this.l == null) {
          this.l = c.a(new c0(this));
        }
        locala = f.j(this.l);
      }
      return locala;
    }
  }
  
  void p(e1 arg1)
  {
    synchronized (this.h)
    {
      boolean bool = this.i;
      if (!bool)
      {
        Size localSize = new Size(???.getWidth(), ???.getHeight());
        h.g(this.g);
        ??? = (String)this.g.a().d().iterator().next();
        int m = ((Integer)this.g.a().c((String)???)).intValue();
        ??? = new j2(???, localSize, this.g);
        this.g = null;
        ??? = new k2(Collections.singletonList(Integer.valueOf(m)), (String)???);
        ((k2)???).c(???);
        try
        {
          this.b.b((k1)???);
        }
        catch (Exception ???)
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("Post processing image failed! ");
          ((StringBuilder)???).append(???.getMessage());
          n1.c("CaptureProcessorPipeline", ((StringBuilder)???).toString());
        }
      }
      synchronized (this.h)
      {
        this.j = false;
        j();
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.h0
 * JD-Core Version:    0.7.0.1
 */