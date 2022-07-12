package o2;

import android.util.Log;
import b2.h;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.a;
import d2.v;
import e2.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j
  implements b2.j<InputStream, c>
{
  private final List<ImageHeaderParser> a;
  private final b2.j<ByteBuffer, c> b;
  private final b c;
  
  public j(List<ImageHeaderParser> paramList, b2.j<ByteBuffer, c> paramj, b paramb)
  {
    this.a = paramList;
    this.b = paramj;
    this.c = paramb;
  }
  
  private static byte[] e(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      byte[] arrayOfByte = new byte[16384];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      if (Log.isLoggable("StreamGifDecoder", 5)) {
        Log.w("StreamGifDecoder", "Error reading data from stream", paramInputStream);
      }
    }
    return null;
  }
  
  public v<c> c(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh)
  {
    paramInputStream = e(paramInputStream);
    if (paramInputStream == null) {
      return null;
    }
    paramInputStream = ByteBuffer.wrap(paramInputStream);
    return this.b.a(paramInputStream, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(InputStream paramInputStream, h paramh)
  {
    return (!((Boolean)paramh.c(i.b)).booleanValue()) && (a.f(this.a, paramInputStream, this.c) == ImageHeaderParser.ImageType.GIF);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.j
 * JD-Core Version:    0.7.0.1
 */