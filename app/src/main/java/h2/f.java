package h2;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import w2.b;

public class f<Data>
  implements n<File, Data>
{
  private final d<Data> a;
  
  public f(d<Data> paramd)
  {
    this.a = paramd;
  }
  
  public n.a<Data> c(File paramFile, int paramInt1, int paramInt2, b2.h paramh)
  {
    return new n.a(new b(paramFile), new c(paramFile, this.a));
  }
  
  public boolean d(File paramFile)
  {
    return true;
  }
  
  public static class a<Data>
    implements o<File, Data>
  {
    private final f.d<Data> a;
    
    public a(f.d<Data> paramd)
    {
      this.a = paramd;
    }
    
    public final n<File, Data> b(r paramr)
    {
      return new f(this.a);
    }
    
    public final void c() {}
  }
  
  public static class b
    extends f.a<ParcelFileDescriptor>
  {
    public b()
    {
      super();
    }
    
    class a
      implements f.d<ParcelFileDescriptor>
    {
      public Class<ParcelFileDescriptor> a()
      {
        return ParcelFileDescriptor.class;
      }
      
      public void d(ParcelFileDescriptor paramParcelFileDescriptor)
      {
        paramParcelFileDescriptor.close();
      }
      
      public ParcelFileDescriptor e(File paramFile)
      {
        return ParcelFileDescriptor.open(paramFile, 268435456);
      }
    }
  }
  
  private static final class c<Data>
    implements d<Data>
  {
    private final File a;
    private final f.d<Data> b;
    private Data c;
    
    c(File paramFile, f.d<Data> paramd)
    {
      this.a = paramFile;
      this.b = paramd;
    }
    
    public Class<Data> a()
    {
      return this.b.a();
    }
    
    public void b()
    {
      Object localObject = this.c;
      if (localObject != null) {}
      try
      {
        this.b.b(localObject);
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
      catch (FileNotFoundException paramh)
      {
        if (Log.isLoggable("FileLoader", 3)) {
          Log.d("FileLoader", "Failed to open file", paramh);
        }
        parama.c(paramh);
      }
    }
  }
  
  public static abstract interface d<Data>
  {
    public abstract Class<Data> a();
    
    public abstract void b(Data paramData);
    
    public abstract Data c(File paramFile);
  }
  
  public static class e
    extends f.a<InputStream>
  {
    public e()
    {
      super();
    }
    
    class a
      implements f.d<InputStream>
    {
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public void d(InputStream paramInputStream)
      {
        paramInputStream.close();
      }
      
      public InputStream e(File paramFile)
      {
        return new FileInputStream(paramFile);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.f
 * JD-Core Version:    0.7.0.1
 */