package k2;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b2.g;
import b2.g.b;
import b2.h;
import b2.j;
import d2.v;
import e2.d;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class b0<T>
  implements j<T, Bitmap>
{
  public static final g<Long> d = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new a());
  public static final g<Integer> e = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new b());
  private static final e f = new e();
  private final f<T> a;
  private final d b;
  private final e c;
  
  b0(d paramd, f<T> paramf)
  {
    this(paramd, paramf, f);
  }
  
  b0(d paramd, f<T> paramf, e parame)
  {
    this.b = paramd;
    this.a = paramf;
    this.c = parame;
  }
  
  public static j<AssetFileDescriptor, Bitmap> c(d paramd)
  {
    return new b0(paramd, new c(null));
  }
  
  public static j<ByteBuffer, Bitmap> d(d paramd)
  {
    return new b0(paramd, new d());
  }
  
  private static Bitmap e(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, l paraml)
  {
    if ((Build.VERSION.SDK_INT >= 27) && (paramInt2 != -2147483648) && (paramInt3 != -2147483648) && (paraml != l.f)) {
      paraml = g(paramMediaMetadataRetriever, paramLong, paramInt1, paramInt2, paramInt3, paraml);
    } else {
      paraml = null;
    }
    Object localObject = paraml;
    if (paraml == null) {
      localObject = f(paramMediaMetadataRetriever, paramLong, paramInt1);
    }
    if (localObject != null) {
      return localObject;
    }
    throw new h();
  }
  
  private static Bitmap f(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt)
  {
    return paramMediaMetadataRetriever.getFrameAtTime(paramLong, paramInt);
  }
  
  @TargetApi(27)
  private static Bitmap g(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, l paraml)
  {
    for (;;)
    {
      int k;
      int i;
      try
      {
        k = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
        i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
        int n = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(24));
        if (n != 90)
        {
          j = k;
          m = i;
          if (n != 270)
          {
            float f1 = paraml.b(j, m, paramInt2, paramInt3);
            paramMediaMetadataRetriever = paramMediaMetadataRetriever.getScaledFrameAtTime(paramLong, paramInt1, Math.round(j * f1), Math.round(f1 * m));
            return paramMediaMetadataRetriever;
          }
        }
      }
      finally
      {
        if (Log.isLoggable("VideoDecoder", 3)) {
          Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", paramMediaMetadataRetriever);
        }
        return null;
      }
      int j = i;
      int m = k;
    }
  }
  
  public static j<ParcelFileDescriptor, Bitmap> h(d paramd)
  {
    return new b0(paramd, new g());
  }
  
  public v<Bitmap> a(T paramT, int paramInt1, int paramInt2, h paramh)
  {
    long l = ((Long)paramh.c(d)).longValue();
    if ((l < 0L) && (l != -1L))
    {
      paramT = new StringBuilder();
      paramT.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
      paramT.append(l);
      throw new IllegalArgumentException(paramT.toString());
    }
    Object localObject2 = (Integer)paramh.c(e);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Integer.valueOf(2);
    }
    localObject2 = (l)paramh.c(l.h);
    paramh = (h)localObject2;
    if (localObject2 == null) {
      paramh = l.g;
    }
    localObject2 = this.c.a();
    try
    {
      this.a.a((MediaMetadataRetriever)localObject2, paramT);
      paramT = e((MediaMetadataRetriever)localObject2, l, ((Integer)localObject1).intValue(), paramInt1, paramInt2, paramh);
      return e.f(paramT, this.b);
    }
    finally
    {
      if (Build.VERSION.SDK_INT >= 29) {
        ((MediaMetadataRetriever)localObject2).close();
      } else {
        ((MediaMetadataRetriever)localObject2).release();
      }
    }
  }
  
  public boolean b(T paramT, h paramh)
  {
    return true;
  }
  
  class a
    implements g.b<Long>
  {
    private final ByteBuffer a = ByteBuffer.allocate(8);
    
    public void b(byte[] arg1, Long paramLong, MessageDigest paramMessageDigest)
    {
      paramMessageDigest.update(???);
      synchronized (this.a)
      {
        this.a.position(0);
        paramMessageDigest.update(this.a.putLong(paramLong.longValue()).array());
        return;
      }
    }
  }
  
  class b
    implements g.b<Integer>
  {
    private final ByteBuffer a = ByteBuffer.allocate(4);
    
    public void b(byte[] arg1, Integer paramInteger, MessageDigest paramMessageDigest)
    {
      if (paramInteger == null) {
        return;
      }
      paramMessageDigest.update(???);
      synchronized (this.a)
      {
        this.a.position(0);
        paramMessageDigest.update(this.a.putInt(paramInteger.intValue()).array());
        return;
      }
    }
  }
  
  private static final class c
    implements b0.f<AssetFileDescriptor>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, AssetFileDescriptor paramAssetFileDescriptor)
    {
      paramMediaMetadataRetriever.setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getLength());
    }
  }
  
  static final class d
    implements b0.f<ByteBuffer>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, final ByteBuffer paramByteBuffer)
    {
      paramMediaMetadataRetriever.setDataSource(new a(paramByteBuffer));
    }
    
    class a
      extends MediaDataSource
    {
      a(ByteBuffer paramByteBuffer) {}
      
      public void close() {}
      
      public long getSize()
      {
        return paramByteBuffer.limit();
      }
      
      public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        if (paramLong >= paramByteBuffer.limit()) {
          return -1;
        }
        paramByteBuffer.position((int)paramLong);
        paramInt2 = Math.min(paramInt2, paramByteBuffer.remaining());
        paramByteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
        return paramInt2;
      }
    }
  }
  
  static class e
  {
    public MediaMetadataRetriever a()
    {
      return new MediaMetadataRetriever();
    }
  }
  
  static abstract interface f<T>
  {
    public abstract void a(MediaMetadataRetriever paramMediaMetadataRetriever, T paramT);
  }
  
  static final class g
    implements b0.f<ParcelFileDescriptor>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      paramMediaMetadataRetriever.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    }
  }
  
  private static final class h
    extends RuntimeException
  {
    h()
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.b0
 * JD-Core Version:    0.7.0.1
 */