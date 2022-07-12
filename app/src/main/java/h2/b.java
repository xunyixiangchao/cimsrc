package h2;

import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data>
  implements n<byte[], Data>
{
  private final b<Data> a;
  
  public b(b<Data> paramb)
  {
    this.a = paramb;
  }
  
  public n.a<Data> c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new w2.b(paramArrayOfByte), new c(paramArrayOfByte, this.a));
  }
  
  public boolean d(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public static class a
    implements o<byte[], ByteBuffer>
  {
    public n<byte[], ByteBuffer> b(r paramr)
    {
      return new b(new a());
    }
    
    public void c() {}
    
    class a
      implements b.b<ByteBuffer>
    {
      a() {}
      
      public Class<ByteBuffer> a()
      {
        return ByteBuffer.class;
      }
      
      public ByteBuffer c(byte[] paramArrayOfByte)
      {
        return ByteBuffer.wrap(paramArrayOfByte);
      }
    }
  }
  
  public static abstract interface b<Data>
  {
    public abstract Class<Data> a();
    
    public abstract Data b(byte[] paramArrayOfByte);
  }
  
  private static class c<Data>
    implements d<Data>
  {
    private final byte[] a;
    private final b.b<Data> b;
    
    c(byte[] paramArrayOfByte, b.b<Data> paramb)
    {
      this.a = paramArrayOfByte;
      this.b = paramb;
    }
    
    public Class<Data> a()
    {
      return this.b.a();
    }
    
    public void b() {}
    
    public void cancel() {}
    
    public a e()
    {
      return a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, d.a<? super Data> parama)
    {
      parama.d(this.b.b(this.a));
    }
  }
  
  public static class d
    implements o<byte[], InputStream>
  {
    public n<byte[], InputStream> b(r paramr)
    {
      return new b(new a());
    }
    
    public void c() {}
    
    class a
      implements b.b<InputStream>
    {
      a() {}
      
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public InputStream c(byte[] paramArrayOfByte)
      {
        return new ByteArrayInputStream(paramArrayOfByte);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.b
 * JD-Core Version:    0.7.0.1
 */