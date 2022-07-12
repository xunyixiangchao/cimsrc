package o2;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.Log;
import b2.h;
import b2.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import x2.g;
import x2.l;

public class a
  implements j<ByteBuffer, c>
{
  private static final a f = new a();
  private static final b g = new b();
  private final Context a;
  private final List<ImageHeaderParser> b;
  private final b c;
  private final a d;
  private final b e;
  
  public a(Context paramContext, List<ImageHeaderParser> paramList, e2.d paramd, e2.b paramb)
  {
    this(paramContext, paramList, paramd, paramb, g, f);
  }
  
  a(Context paramContext, List<ImageHeaderParser> paramList, e2.d paramd, e2.b paramb, b paramb1, a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramList;
    this.d = parama;
    this.e = new b(paramd, paramb);
    this.c = paramb1;
  }
  
  private e d(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, z1.d paramd, h paramh)
  {
    long l = g.b();
    try
    {
      z1.c localc = paramd.c();
      if ((localc.b() > 0) && (localc.c() == 0))
      {
        if (paramh.c(i.a) == b2.b.b) {
          paramd = Bitmap.Config.RGB_565;
        } else {
          paramd = Bitmap.Config.ARGB_8888;
        }
        int i = e(localc, paramInt1, paramInt2);
        paramByteBuffer = this.d.a(this.e, localc, paramByteBuffer, i);
        paramByteBuffer.f(paramd);
        paramByteBuffer.b();
        paramd = paramByteBuffer.getNextFrame();
        if (paramd == null) {
          return null;
        }
        paramh = j2.c.c();
        paramByteBuffer = new e(new c(this.a, paramByteBuffer, paramh, paramInt1, paramInt2, paramd));
        return paramByteBuffer;
      }
      return null;
    }
    finally
    {
      if (Log.isLoggable("BufferGifDecoder", 2))
      {
        paramd = new StringBuilder();
        paramd.append("Decoded GIF from stream in ");
        paramd.append(g.a(l));
        Log.v("BufferGifDecoder", paramd.toString());
      }
    }
  }
  
  private static int e(z1.c paramc, int paramInt1, int paramInt2)
  {
    int i = Math.min(paramc.a() / paramInt2, paramc.d() / paramInt1);
    if (i == 0) {
      i = 0;
    } else {
      i = Integer.highestOneBit(i);
    }
    i = Math.max(1, i);
    if ((Log.isLoggable("BufferGifDecoder", 2)) && (i > 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Downsampling GIF, sampleSize: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", target dimens: [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], actual dimens: [");
      localStringBuilder.append(paramc.d());
      localStringBuilder.append("x");
      localStringBuilder.append(paramc.a());
      localStringBuilder.append("]");
      Log.v("BufferGifDecoder", localStringBuilder.toString());
    }
    return i;
  }
  
  public e c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, h paramh)
  {
    z1.d locald = this.c.a(paramByteBuffer);
    try
    {
      paramByteBuffer = d(paramByteBuffer, paramInt1, paramInt2, locald, paramh);
      return paramByteBuffer;
    }
    finally
    {
      this.c.b(locald);
    }
  }
  
  public boolean f(ByteBuffer paramByteBuffer, h paramh)
  {
    return (!((Boolean)paramh.c(i.b)).booleanValue()) && (com.bumptech.glide.load.a.g(this.b, paramByteBuffer) == ImageHeaderParser.ImageType.GIF);
  }
  
  static class a
  {
    z1.a a(z1.a.a parama, z1.c paramc, ByteBuffer paramByteBuffer, int paramInt)
    {
      return new z1.e(parama, paramc, paramByteBuffer, paramInt);
    }
  }
  
  static class b
  {
    private final Queue<z1.d> a = l.f(0);
    
    z1.d a(ByteBuffer paramByteBuffer)
    {
      try
      {
        z1.d locald2 = (z1.d)this.a.poll();
        z1.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new z1.d();
        }
        paramByteBuffer = locald1.p(paramByteBuffer);
        return paramByteBuffer;
      }
      finally {}
    }
    
    void b(z1.d paramd)
    {
      try
      {
        paramd.a();
        this.a.offer(paramd);
        return;
      }
      finally
      {
        paramd = finally;
        throw paramd;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.a
 * JD-Core Version:    0.7.0.1
 */