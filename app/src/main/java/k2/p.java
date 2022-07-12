package k2;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e2.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class p
  implements ImageHeaderParser
{
  public ImageHeaderParser.ImageType a(ByteBuffer paramByteBuffer)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public int b(ByteBuffer paramByteBuffer, b paramb)
  {
    return c(x2.a.g(paramByteBuffer), paramb);
  }
  
  public int c(InputStream paramInputStream, b paramb)
  {
    int j = new h1.a(paramInputStream).o("Orientation", 1);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    return i;
  }
  
  public ImageHeaderParser.ImageType d(InputStream paramInputStream)
  {
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.p
 * JD-Core Version:    0.7.0.1
 */