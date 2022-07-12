package ea;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class e
  extends c.a
{
  static final c.a a = new e();
  
  @Nullable
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, u paramu)
  {
    if (c.a.c(paramType) != CompletableFuture.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = c.a.b(0, (ParameterizedType)paramType);
      if (c.a.c(paramType) != t.class) {
        return new a(paramType);
      }
      if ((paramType instanceof ParameterizedType)) {
        return new c(c.a.b(0, (ParameterizedType)paramType));
      }
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
    throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
  }
  
  @IgnoreJRERequirement
  private static final class a<R>
    implements c<R, CompletableFuture<R>>
  {
    private final Type a;
    
    a(Type paramType)
    {
      this.a = paramType;
    }
    
    public Type a()
    {
      return this.a;
    }
    
    public CompletableFuture<R> c(b<R> paramb)
    {
      e.b localb = new e.b(paramb);
      paramb.B(new a(localb));
      return localb;
    }
    
    @IgnoreJRERequirement
    private class a
      implements d<R>
    {
      private final CompletableFuture<R> a;
      
      public a()
      {
        Object localObject;
        this.a = localObject;
      }
      
      public void a(b<R> paramb, Throwable paramThrowable)
      {
        this.a.completeExceptionally(paramThrowable);
      }
      
      public void c(b<R> paramb, t<R> paramt)
      {
        if (paramt.d())
        {
          this.a.complete(paramt.a());
          return;
        }
        this.a.completeExceptionally(new j(paramt));
      }
    }
  }
  
  @IgnoreJRERequirement
  private static final class b<T>
    extends CompletableFuture<T>
  {
    private final b<?> a;
    
    b(b<?> paramb)
    {
      this.a = paramb;
    }
    
    public boolean cancel(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.a.cancel();
      }
      return super.cancel(paramBoolean);
    }
  }
  
  @IgnoreJRERequirement
  private static final class c<R>
    implements c<R, CompletableFuture<t<R>>>
  {
    private final Type a;
    
    c(Type paramType)
    {
      this.a = paramType;
    }
    
    public Type a()
    {
      return this.a;
    }
    
    public CompletableFuture<t<R>> c(b<R> paramb)
    {
      e.b localb = new e.b(paramb);
      paramb.B(new a(localb));
      return localb;
    }
    
    @IgnoreJRERequirement
    private class a
      implements d<R>
    {
      private final CompletableFuture<t<R>> a;
      
      public a()
      {
        Object localObject;
        this.a = localObject;
      }
      
      public void a(b<R> paramb, Throwable paramThrowable)
      {
        this.a.completeExceptionally(paramThrowable);
      }
      
      public void c(b<R> paramb, t<R> paramt)
      {
        this.a.complete(paramt);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.e
 * JD-Core Version:    0.7.0.1
 */