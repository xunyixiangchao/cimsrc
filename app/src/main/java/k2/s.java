package k2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import e2.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

abstract interface s
{
  public abstract Bitmap a(BitmapFactory.Options paramOptions);
  
  public abstract void b();
  
  public abstract int c();
  
  public abstract ImageHeaderParser.ImageType d();
  
  public static final class a
    implements s
  {
    private final ByteBuffer a;
    private final List<ImageHeaderParser> b;
    private final b c;
    
    a(ByteBuffer paramByteBuffer, List<ImageHeaderParser> paramList, b paramb)
    {
      this.a = paramByteBuffer;
      this.b = paramList;
      this.c = paramb;
    }
    
    private InputStream e()
    {
      return x2.a.g(x2.a.d(this.a));
    }
    
    public Bitmap a(BitmapFactory.Options paramOptions)
    {
      return BitmapFactory.decodeStream(e(), null, paramOptions);
    }
    
    public void b() {}
    
    public int c()
    {
      return com.bumptech.glide.load.a.c(this.b, x2.a.d(this.a), this.c);
    }
    
    public ImageHeaderParser.ImageType d()
    {
      return com.bumptech.glide.load.a.g(this.b, x2.a.d(this.a));
    }
  }
  
  public static final class b
    implements s
  {
    private final com.bumptech.glide.load.data.k a;
    private final b b;
    private final List<ImageHeaderParser> c;
    
    b(InputStream paramInputStream, List<ImageHeaderParser> paramList, b paramb)
    {
      this.b = ((b)x2.k.d(paramb));
      this.c = ((List)x2.k.d(paramList));
      this.a = new com.bumptech.glide.load.data.k(paramInputStream, paramb);
    }
    
    public Bitmap a(BitmapFactory.Options paramOptions)
    {
      return BitmapFactory.decodeStream(this.a.d(), null, paramOptions);
    }
    
    public void b()
    {
      this.a.c();
    }
    
    public int c()
    {
      return com.bumptech.glide.load.a.b(this.c, this.a.d(), this.b);
    }
    
    public ImageHeaderParser.ImageType d()
    {
      return com.bumptech.glide.load.a.f(this.c, this.a.d(), this.b);
    }
  }
  
  public static final class c
    implements s
  {
    private final b a;
    private final List<ImageHeaderParser> b;
    private final ParcelFileDescriptorRewinder c;
    
    c(ParcelFileDescriptor paramParcelFileDescriptor, List<ImageHeaderParser> paramList, b paramb)
    {
      this.a = ((b)x2.k.d(paramb));
      this.b = ((List)x2.k.d(paramList));
      this.c = new ParcelFileDescriptorRewinder(paramParcelFileDescriptor);
    }
    
    public Bitmap a(BitmapFactory.Options paramOptions)
    {
      return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), null, paramOptions);
    }
    
    public void b() {}
    
    public int c()
    {
      return com.bumptech.glide.load.a.a(this.b, this.c, this.a);
    }
    
    public ImageHeaderParser.ImageType d()
    {
      return com.bumptech.glide.load.a.e(this.b, this.c, this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.s
 * JD-Core Version:    0.7.0.1
 */