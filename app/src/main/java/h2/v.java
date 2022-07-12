package h2;

import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import w2.b;

public class v<Model>
  implements n<Model, Model>
{
  private static final v<?> a = new v();
  
  public static <T> v<T> c()
  {
    return a;
  }
  
  public boolean a(Model paramModel)
  {
    return true;
  }
  
  public n.a<Model> b(Model paramModel, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new b(paramModel), new b(paramModel));
  }
  
  public static class a<Model>
    implements o<Model, Model>
  {
    private static final a<?> a = new a();
    
    public static <T> a<T> a()
    {
      return a;
    }
    
    public n<Model, Model> b(r paramr)
    {
      return v.c();
    }
    
    public void c() {}
  }
  
  private static class b<Model>
    implements d<Model>
  {
    private final Model a;
    
    b(Model paramModel)
    {
      this.a = paramModel;
    }
    
    public Class<Model> a()
    {
      return this.a.getClass();
    }
    
    public void b() {}
    
    public void cancel() {}
    
    public a e()
    {
      return a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, d.a<? super Model> parama)
    {
      parama.d(this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.v
 * JD-Core Version:    0.7.0.1
 */