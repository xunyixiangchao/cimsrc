package o;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class g
{
  private final c a;
  
  public g(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
  {
    if (Build.VERSION.SDK_INT < 28) {
      paramList = new b(paramInt, paramList, paramExecutor, paramStateCallback);
    } else {
      paramList = new a(paramInt, paramList, paramExecutor, paramStateCallback);
    }
    this.a = paramList;
  }
  
  public static List<OutputConfiguration> h(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((OutputConfiguration)((b)paramList.next()).f());
    }
    return localArrayList;
  }
  
  static List<b> i(List<OutputConfiguration> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(b.g((OutputConfiguration)paramList.next()));
    }
    return localArrayList;
  }
  
  public Executor a()
  {
    return this.a.c();
  }
  
  public a b()
  {
    return this.a.b();
  }
  
  public List<b> c()
  {
    return this.a.g();
  }
  
  public int d()
  {
    return this.a.f();
  }
  
  public CameraCaptureSession.StateCallback e()
  {
    return this.a.a();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {
      return false;
    }
    return this.a.equals(((g)paramObject).a);
  }
  
  public void f(a parama)
  {
    this.a.e(parama);
  }
  
  public void g(CaptureRequest paramCaptureRequest)
  {
    this.a.h(paramCaptureRequest);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Object j()
  {
    return this.a.d();
  }
  
  private static final class a
    implements g.c
  {
    private final SessionConfiguration a;
    private final List<b> b;
    
    a(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      this(new SessionConfiguration(paramInt, g.h(paramList), paramExecutor, paramStateCallback));
    }
    
    a(Object paramObject)
    {
      paramObject = (SessionConfiguration)paramObject;
      this.a = paramObject;
      this.b = Collections.unmodifiableList(g.i(paramObject.getOutputConfigurations()));
    }
    
    public CameraCaptureSession.StateCallback a()
    {
      return this.a.getStateCallback();
    }
    
    public a b()
    {
      return a.b(this.a.getInputConfiguration());
    }
    
    public Executor c()
    {
      return this.a.getExecutor();
    }
    
    public Object d()
    {
      return this.a;
    }
    
    public void e(a parama)
    {
      this.a.setInputConfiguration((InputConfiguration)parama.a());
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      return Objects.equals(this.a, ((a)paramObject).a);
    }
    
    public int f()
    {
      return this.a.getSessionType();
    }
    
    public List<b> g()
    {
      return this.b;
    }
    
    public void h(CaptureRequest paramCaptureRequest)
    {
      this.a.setSessionParameters(paramCaptureRequest);
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
  
  private static final class b
    implements g.c
  {
    private final List<b> a;
    private final CameraCaptureSession.StateCallback b;
    private final Executor c;
    private int d;
    private a e = null;
    private CaptureRequest f = null;
    
    b(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      this.d = paramInt;
      this.a = Collections.unmodifiableList(new ArrayList(paramList));
      this.b = paramStateCallback;
      this.c = paramExecutor;
    }
    
    public CameraCaptureSession.StateCallback a()
    {
      return this.b;
    }
    
    public a b()
    {
      return this.e;
    }
    
    public Executor c()
    {
      return this.c;
    }
    
    public Object d()
    {
      return null;
    }
    
    public void e(a parama)
    {
      if (this.d != 1)
      {
        this.e = parama;
        return;
      }
      throw new UnsupportedOperationException("Method not supported for high speed session types");
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Objects.equals(this.e, paramObject.e)) && (this.d == paramObject.d))
        {
          if (this.a.size() != paramObject.a.size()) {
            return false;
          }
          int i = 0;
          while (i < this.a.size())
          {
            if (!((b)this.a.get(i)).equals(paramObject.a.get(i))) {
              return false;
            }
            i += 1;
          }
          return true;
        }
      }
      return false;
    }
    
    public int f()
    {
      return this.d;
    }
    
    public List<b> g()
    {
      return this.a;
    }
    
    public void h(CaptureRequest paramCaptureRequest)
    {
      this.f = paramCaptureRequest;
    }
    
    public int hashCode()
    {
      int j = this.a.hashCode() ^ 0x1F;
      a locala = this.e;
      int i;
      if (locala == null) {
        i = 0;
      } else {
        i = locala.hashCode();
      }
      i ^= (j << 5) - j;
      return this.d ^ (i << 5) - i;
    }
  }
  
  private static abstract interface c
  {
    public abstract CameraCaptureSession.StateCallback a();
    
    public abstract a b();
    
    public abstract Executor c();
    
    public abstract Object d();
    
    public abstract void e(a parama);
    
    public abstract int f();
    
    public abstract List<b> g();
    
    public abstract void h(CaptureRequest paramCaptureRequest);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o.g
 * JD-Core Version:    0.7.0.1
 */