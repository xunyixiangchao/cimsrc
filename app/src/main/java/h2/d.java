package h2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import w2.b;

public class d
  implements n<File, ByteBuffer>
{
  public n.a<ByteBuffer> c(File paramFile, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new b(paramFile), new a(paramFile));
  }
  
  public boolean d(File paramFile)
  {
    return true;
  }
  
  private static final class a
    implements com.bumptech.glide.load.data.d<ByteBuffer>
  {
    private final File a;
    
    a(File paramFile)
    {
      this.a = paramFile;
    }
    
    public Class<ByteBuffer> a()
    {
      return ByteBuffer.class;
    }
    
    public void b() {}
    
    public void cancel() {}
    
    public b2.a e()
    {
      return b2.a.a;
    }
    
    public void f(com.bumptech.glide.h paramh, com.bumptech.glide.load.data.d.a<? super ByteBuffer> parama)
    {
      try
      {
        parama.d(x2.a.a(this.a));
        return;
      }
      catch (IOException paramh)
      {
        if (Log.isLoggable("ByteBufferFileLoader", 3)) {
          Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", paramh);
        }
        parama.c(paramh);
      }
    }
  }
  
  public static class b
    implements o<File, ByteBuffer>
  {
    public n<File, ByteBuffer> b(r paramr)
    {
      return new d();
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.d
 * JD-Core Version:    0.7.0.1
 */