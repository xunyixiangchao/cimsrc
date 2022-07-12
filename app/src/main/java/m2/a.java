package m2;

import android.graphics.Bitmap.Config;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.Source;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import b2.h;
import b2.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import d2.v;
import e2.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import x2.l;

public final class a
{
  private final List<ImageHeaderParser> a;
  private final b b;
  
  private a(List<ImageHeaderParser> paramList, b paramb)
  {
    this.a = paramList;
    this.b = paramb;
  }
  
  public static j<ByteBuffer, Drawable> a(List<ImageHeaderParser> paramList, b paramb)
  {
    return new b(new a(paramList, paramb));
  }
  
  private boolean e(ImageHeaderParser.ImageType paramImageType)
  {
    return paramImageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
  }
  
  public static j<InputStream, Drawable> f(List<ImageHeaderParser> paramList, b paramb)
  {
    return new c(new a(paramList, paramb));
  }
  
  v<Drawable> b(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, h paramh)
  {
    paramSource = ImageDecoder.decodeDrawable(paramSource, new j2.a(paramInt1, paramInt2, paramh));
    if ((paramSource instanceof AnimatedImageDrawable)) {
      return new a((AnimatedImageDrawable)paramSource);
    }
    paramh = new StringBuilder();
    paramh.append("Received unexpected drawable type for animated webp, failing: ");
    paramh.append(paramSource);
    throw new IOException(paramh.toString());
  }
  
  boolean c(InputStream paramInputStream)
  {
    return e(com.bumptech.glide.load.a.f(this.a, paramInputStream, this.b));
  }
  
  boolean d(ByteBuffer paramByteBuffer)
  {
    return e(com.bumptech.glide.load.a.g(this.a, paramByteBuffer));
  }
  
  private static final class a
    implements v<Drawable>
  {
    private final AnimatedImageDrawable a;
    
    a(AnimatedImageDrawable paramAnimatedImageDrawable)
    {
      this.a = paramAnimatedImageDrawable;
    }
    
    public void a()
    {
      this.a.stop();
      this.a.clearAnimationCallbacks();
    }
    
    public AnimatedImageDrawable b()
    {
      return this.a;
    }
    
    public int c()
    {
      return this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * l.i(Bitmap.Config.ARGB_8888) * 2;
    }
    
    public Class<Drawable> d()
    {
      return Drawable.class;
    }
  }
  
  private static final class b
    implements j<ByteBuffer, Drawable>
  {
    private final a a;
    
    b(a parama)
    {
      this.a = parama;
    }
    
    public v<Drawable> c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, h paramh)
    {
      paramByteBuffer = ImageDecoder.createSource(paramByteBuffer);
      return this.a.b(paramByteBuffer, paramInt1, paramInt2, paramh);
    }
    
    public boolean d(ByteBuffer paramByteBuffer, h paramh)
    {
      return this.a.d(paramByteBuffer);
    }
  }
  
  private static final class c
    implements j<InputStream, Drawable>
  {
    private final a a;
    
    c(a parama)
    {
      this.a = parama;
    }
    
    public v<Drawable> c(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
    {
      paramInputStream = ImageDecoder.createSource(x2.a.b(paramInputStream));
      return this.a.b(paramInputStream, paramInt1, paramInt2, paramh);
    }
    
    public boolean d(InputStream paramInputStream, h paramh)
    {
      return this.a.c(paramInputStream);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m2.a
 * JD-Core Version:    0.7.0.1
 */