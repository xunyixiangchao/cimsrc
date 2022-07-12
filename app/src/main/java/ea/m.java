package ea;

import a9.g;
import java.lang.reflect.Method;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import l9.d0;
import o8.i;
import o8.i.a;
import o8.o;
import s8.a;
import s8.a<*>;

public final class m
{
  public static final <T> Object a(b<T> paramb, a<? super T> parama)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(t8.b.a(parama), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation(new a(paramb));
    paramb.B(new c(localCancellableContinuation));
    paramb = localCancellableContinuationImpl.getResult();
    if (paramb == t8.b.b()) {
      u8.f.b(parama);
    }
    return paramb;
  }
  
  public static final <T> Object b(b<T> paramb, a<? super T> parama)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(t8.b.a(parama), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation(new b(paramb));
    paramb.B(new d(localCancellableContinuation));
    paramb = localCancellableContinuationImpl.getResult();
    if (paramb == t8.b.b()) {
      u8.f.b(parama);
    }
    return paramb;
  }
  
  public static final <T> Object c(b<T> paramb, a<? super t<T>> parama)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(t8.b.a(parama), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    localCancellableContinuation.invokeOnCancellation(new e(paramb));
    paramb.B(new f(localCancellableContinuation));
    paramb = localCancellableContinuationImpl.getResult();
    if (paramb == t8.b.b()) {
      u8.f.b(parama);
    }
    return paramb;
  }
  
  public static final Object d(final Exception paramException, a<?> parama)
  {
    if ((parama instanceof h))
    {
      localObject1 = (h)parama;
      i = ((h)localObject1).e;
      if ((i & 0x80000000) != 0)
      {
        ((h)localObject1).e = (i + -2147483648);
        parama = (a<?>)localObject1;
        break label46;
      }
    }
    parama = new h(parama);
    label46:
    Object localObject1 = parama.d;
    Object localObject2 = t8.b.b();
    int i = parama.e;
    if (i != 0)
    {
      if (i == 1)
      {
        paramException = (Exception)parama.f;
        o8.j.b(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      o8.j.b(localObject1);
      parama.f = paramException;
      parama.e = 1;
      Dispatchers.getDefault().dispatch(parama.c(), new g(parama, paramException));
      paramException = t8.b.b();
      if (paramException == t8.b.b()) {
        u8.f.b(parama);
      }
      if (paramException == localObject2) {
        return localObject2;
      }
    }
    return o.a;
  }
  
  static final class a
    extends g
    implements z8.b<Throwable, o>
  {
    a(b paramb)
    {
      super();
    }
    
    public final void d(Throwable paramThrowable)
    {
      this.b.cancel();
    }
  }
  
  static final class b
    extends g
    implements z8.b<Throwable, o>
  {
    b(b paramb)
    {
      super();
    }
    
    public final void d(Throwable paramThrowable)
    {
      this.b.cancel();
    }
  }
  
  public static final class c
    implements d<T>
  {
    c(CancellableContinuation paramCancellableContinuation) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramThrowable, "t");
      paramb = (a)this.a;
      i.a locala = i.a;
      paramb.a(i.a(o8.j.a(paramThrowable)));
    }
    
    public void c(b<T> paramb, t<T> paramt)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramt, "response");
      Object localObject;
      if (paramt.d())
      {
        paramt = paramt.a();
        if (paramt == null)
        {
          paramb = paramb.h().i(l.class);
          if (paramb == null) {
            a9.f.p();
          }
          a9.f.b(paramb, "call.request().tag(Invocation::class.java)!!");
          paramb = ((l)paramb).a();
          paramt = new StringBuilder();
          paramt.append("Response from ");
          a9.f.b(paramb, "method");
          localObject = paramb.getDeclaringClass();
          a9.f.b(localObject, "method.declaringClass");
          paramt.append(((Class)localObject).getName());
          paramt.append('.');
          paramt.append(paramb.getName());
          paramt.append(" was null but response body type was declared as non-null");
          paramt = new o8.c(paramt.toString());
          paramb = (a)this.a;
          localObject = i.a;
          paramt = o8.j.a(paramt);
        }
        else
        {
          paramb = (a)this.a;
          localObject = i.a;
        }
      }
      else
      {
        paramb = (a)this.a;
        paramt = new j(paramt);
        localObject = i.a;
        paramt = o8.j.a(paramt);
      }
      paramb.a(i.a(paramt));
    }
  }
  
  public static final class d
    implements d<T>
  {
    d(CancellableContinuation paramCancellableContinuation) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramThrowable, "t");
      paramb = (a)this.a;
      i.a locala = i.a;
      paramb.a(i.a(o8.j.a(paramThrowable)));
    }
    
    public void c(b<T> paramb, t<T> paramt)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramt, "response");
      i.a locala;
      if (paramt.d())
      {
        paramb = (a)this.a;
        paramt = paramt.a();
        locala = i.a;
      }
      else
      {
        paramb = (a)this.a;
        paramt = new j(paramt);
        locala = i.a;
        paramt = o8.j.a(paramt);
      }
      paramb.a(i.a(paramt));
    }
  }
  
  static final class e
    extends g
    implements z8.b<Throwable, o>
  {
    e(b paramb)
    {
      super();
    }
    
    public final void d(Throwable paramThrowable)
    {
      this.b.cancel();
    }
  }
  
  public static final class f
    implements d<T>
  {
    f(CancellableContinuation paramCancellableContinuation) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramThrowable, "t");
      paramb = (a)this.a;
      i.a locala = i.a;
      paramb.a(i.a(o8.j.a(paramThrowable)));
    }
    
    public void c(b<T> paramb, t<T> paramt)
    {
      a9.f.g(paramb, "call");
      a9.f.g(paramt, "response");
      paramb = (a)this.a;
      i.a locala = i.a;
      paramb.a(i.a(paramt));
    }
  }
  
  static final class g
    implements Runnable
  {
    g(a parama, Exception paramException) {}
    
    public final void run()
    {
      a locala = t8.b.a(this.a);
      Exception localException = paramException;
      i.a locala1 = i.a;
      locala.a(i.a(o8.j.a(localException)));
    }
  }
  
  @u8.d(c="retrofit2.KotlinExtensions", f="KotlinExtensions.kt", l={113}, m="suspendAndThrow")
  static final class h
    extends u8.c
  {
    int e;
    Object f;
    
    h(a parama)
    {
      super();
    }
    
    public final Object d(Object paramObject)
    {
      this.d = paramObject;
      this.e |= 0x80000000;
      return m.d(null, this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.m
 * JD-Core Version:    0.7.0.1
 */