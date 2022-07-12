package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l9.d0;

final class g
  extends c.a
{
  @Nullable
  private final Executor a;
  
  g(@Nullable Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  @Nullable
  public c<?, ?> a(final Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
  {
    Object localObject = c.a.c(paramType);
    paramu = null;
    if (localObject != b.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      localObject = y.g(0, (ParameterizedType)paramType);
      if (y.l(paramArrayOfAnnotation, w.class)) {
        paramType = paramu;
      } else {
        paramType = this.a;
      }
      return new a((Type)localObject, paramType);
    }
    throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
  }
  
  class a
    implements c<Object, b<?>>
  {
    public Type a()
    {
      return this.a;
    }
    
    public b<Object> c(b<Object> paramb)
    {
      Executor localExecutor = paramType;
      if (localExecutor == null) {
        return paramb;
      }
      return new g.b(localExecutor, paramb);
    }
  }
  
  static final class b<T>
    implements b<T>
  {
    final Executor a;
    final b<T> b;
    
    b(Executor paramExecutor, b<T> paramb)
    {
      this.a = paramExecutor;
      this.b = paramb;
    }
    
    public void B(final d<T> paramd)
    {
      Objects.requireNonNull(paramd, "callback == null");
      this.b.B(new a(paramd));
    }
    
    public void cancel()
    {
      this.b.cancel();
    }
    
    public b<T> clone()
    {
      return new b(this.a, this.b.clone());
    }
    
    public t<T> g()
    {
      return this.b.g();
    }
    
    public d0 h()
    {
      return this.b.h();
    }
    
    public boolean i()
    {
      return this.b.i();
    }
    
    class a
      implements d<T>
    {
      public void a(b<T> paramb, Throwable paramThrowable)
      {
        this.b.a.execute(new i(this, paramd, paramThrowable));
      }
      
      public void c(b<T> paramb, t<T> paramt)
      {
        this.b.a.execute(new h(this, paramd, paramt));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.g
 * JD-Core Version:    0.7.0.1
 */