package h2;

import b2.f;
import b2.h;
import com.bumptech.glide.load.data.d;
import java.util.Collections;
import java.util.List;
import x2.k;

public abstract interface n<Model, Data>
{
  public abstract boolean a(Model paramModel);
  
  public abstract a<Data> b(Model paramModel, int paramInt1, int paramInt2, h paramh);
  
  public static class a<Data>
  {
    public final f a;
    public final List<f> b;
    public final d<Data> c;
    
    public a(f paramf, d<Data> paramd)
    {
      this(paramf, Collections.emptyList(), paramd);
    }
    
    public a(f paramf, List<f> paramList, d<Data> paramd)
    {
      this.a = ((f)k.d(paramf));
      this.b = ((List)k.d(paramList));
      this.c = ((d)k.d(paramd));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.n
 * JD-Core Version:    0.7.0.1
 */