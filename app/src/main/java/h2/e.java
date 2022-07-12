package h2;

import android.util.Base64;
import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import w2.b;

public final class e<Model, Data>
  implements n<Model, Data>
{
  private final a<Data> a;
  
  public e(a<Data> parama)
  {
    this.a = parama;
  }
  
  public boolean a(Model paramModel)
  {
    return paramModel.toString().startsWith("data:image");
  }
  
  public n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new b(paramModel), new b(paramModel.toString(), this.a));
  }
  
  public static abstract interface a<Data>
  {
    public abstract Class<Data> a();
    
    public abstract void b(Data paramData);
    
    public abstract Data c(String paramString);
  }
  
  private static final class b<Data>
    implements d<Data>
  {
    private final String a;
    private final e.a<Data> b;
    private Data c;
    
    b(String paramString, e.a<Data> parama)
    {
      this.a = paramString;
      this.b = parama;
    }
    
    public Class<Data> a()
    {
      return this.b.a();
    }
    
    public void b()
    {
      try
      {
        this.b.b(this.c);
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public void cancel() {}
    
    public a e()
    {
      return a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, d.a<? super Data> parama)
    {
      try
      {
        paramh = this.b.c(this.a);
        this.c = paramh;
        parama.d(paramh);
        return;
      }
      catch (IllegalArgumentException paramh)
      {
        parama.c(paramh);
      }
    }
  }
  
  public static final class c<Model>
    implements o<Model, InputStream>
  {
    private final e.a<InputStream> a = new a();
    
    public n<Model, InputStream> b(r paramr)
    {
      return new e(this.a);
    }
    
    public void c() {}
    
    class a
      implements e.a<InputStream>
    {
      a() {}
      
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public void d(InputStream paramInputStream)
      {
        paramInputStream.close();
      }
      
      public InputStream e(String paramString)
      {
        if (paramString.startsWith("data:image"))
        {
          int i = paramString.indexOf(',');
          if (i != -1)
          {
            if (paramString.substring(0, i).endsWith(";base64")) {
              return new ByteArrayInputStream(Base64.decode(paramString.substring(i + 1), 0));
            }
            throw new IllegalArgumentException("Not a base64 image data URL.");
          }
          throw new IllegalArgumentException("Missing comma in data URL.");
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.e
 * JD-Core Version:    0.7.0.1
 */