package k2;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e2.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class k
  implements ImageHeaderParser
{
  static final byte[] a = "".getBytes(Charset.forName("UTF-8"));
  private static final int[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  
  private static int e(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private int f(c paramc, b paramb)
  {
    try
    {
      int i = paramc.getUInt16();
      boolean bool = h(i);
      if (!bool)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          paramc = new StringBuilder();
          paramc.append("Parser doesn't handle magic number: ");
          paramc.append(i);
          Log.d("DfltImageHeaderParser", paramc.toString());
          return -1;
        }
      }
      else
      {
        i = j(paramc);
        if (i == -1)
        {
          if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
            break label139;
          }
          Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
          return -1;
        }
        byte[] arrayOfByte = (byte[])paramb.e(i, [B.class);
        try
        {
          i = l(paramc, arrayOfByte, i);
          return i;
        }
        finally
        {
          paramb.d(arrayOfByte);
        }
      }
      return -1;
    }
    catch (k.c.a paramc)
    {
      return -1;
    }
    label139:
    return -1;
  }
  
  private ImageHeaderParser.ImageType g(c paramc)
  {
    label276:
    try
    {
      i = paramc.getUInt16();
      if (i == 65496) {
        return ImageHeaderParser.ImageType.JPEG;
      }
      i = i << 8 | paramc.getUInt8();
      if (i == 4671814) {
        return ImageHeaderParser.ImageType.GIF;
      }
      i = i << 8 | paramc.getUInt8();
      if (i == -1991225785) {
        paramc.skip(21L);
      }
    }
    catch (k.c.a paramc)
    {
      int i;
      label87:
      break label276;
    }
    try
    {
      if (paramc.getUInt8() >= 3) {
        return ImageHeaderParser.ImageType.PNG_A;
      }
      paramc = ImageHeaderParser.ImageType.PNG;
      return paramc;
    }
    catch (k.c.a paramc)
    {
      break label87;
    }
    return ImageHeaderParser.ImageType.PNG;
    if (i != 1380533830)
    {
      if (m(paramc, i)) {
        return ImageHeaderParser.ImageType.AVIF;
      }
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    paramc.skip(4L);
    if ((paramc.getUInt16() << 16 | paramc.getUInt16()) != 1464156752) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    i = paramc.getUInt16() << 16 | paramc.getUInt16();
    if ((i & 0xFFFFFF00) != 1448097792) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    i &= 0xFF;
    if (i == 88)
    {
      paramc.skip(4L);
      i = paramc.getUInt8();
      if ((i & 0x2) != 0) {
        return ImageHeaderParser.ImageType.ANIMATED_WEBP;
      }
      if ((i & 0x10) != 0) {
        return ImageHeaderParser.ImageType.WEBP_A;
      }
      return ImageHeaderParser.ImageType.WEBP;
    }
    if (i == 76)
    {
      paramc.skip(4L);
      if ((paramc.getUInt8() & 0x8) != 0) {
        return ImageHeaderParser.ImageType.WEBP_A;
      }
      return ImageHeaderParser.ImageType.WEBP;
    }
    paramc = ImageHeaderParser.ImageType.WEBP;
    return paramc;
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  private static boolean h(int paramInt)
  {
    return ((paramInt & 0xFFD8) == 65496) || (paramInt == 19789) || (paramInt == 18761);
  }
  
  private boolean i(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if ((paramArrayOfByte != null) && (paramInt > a.length)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramInt = 0;
      for (;;)
      {
        byte[] arrayOfByte = a;
        if (paramInt >= arrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[paramInt] != arrayOfByte[paramInt]) {
          return false;
        }
        paramInt += 1;
      }
    }
    return bool;
  }
  
  private int j(c paramc)
  {
    int i;
    int j;
    long l1;
    long l2;
    do
    {
      i = paramc.getUInt8();
      if (i != 255)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          paramc = new StringBuilder();
          paramc.append("Unknown segmentId=");
          paramc.append(i);
          Log.d("DfltImageHeaderParser", paramc.toString());
        }
        return -1;
      }
      i = paramc.getUInt8();
      if (i == 218) {
        return -1;
      }
      if (i == 217)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
        }
        return -1;
      }
      j = paramc.getUInt16() - 2;
      if (i == 225) {
        break;
      }
      l1 = j;
      l2 = paramc.skip(l1);
    } while (l2 == l1);
    if (Log.isLoggable("DfltImageHeaderParser", 3))
    {
      paramc = new StringBuilder();
      paramc.append("Unable to skip enough data, type: ");
      paramc.append(i);
      paramc.append(", wanted to skip: ");
      paramc.append(j);
      paramc.append(", but actually skipped: ");
      paramc.append(l2);
      Log.d("DfltImageHeaderParser", paramc.toString());
    }
    return -1;
    return j;
  }
  
  private static int k(b paramb)
  {
    int i = paramb.a(6);
    Object localObject;
    if (i != 18761)
    {
      if ((i != 19789) && (Log.isLoggable("DfltImageHeaderParser", 3)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown endianness = ");
        ((StringBuilder)localObject).append(i);
        Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
      }
      localObject = ByteOrder.BIG_ENDIAN;
    }
    else
    {
      localObject = ByteOrder.LITTLE_ENDIAN;
    }
    paramb.e((ByteOrder)localObject);
    int j = paramb.b(10) + 6;
    int k = paramb.a(j);
    i = 0;
    while (i < k)
    {
      int n = e(j, i);
      int m = paramb.a(n);
      if (m == 274)
      {
        int i1 = paramb.a(n + 2);
        String str;
        if ((i1 >= 1) && (i1 <= 12))
        {
          int i2 = paramb.b(n + 4);
          if (i2 < 0)
          {
            if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
              break label525;
            }
            localObject = "Negative tiff component count";
            break label517;
          }
          if (Log.isLoggable("DfltImageHeaderParser", 3))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Got tagIndex=");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" tagType=");
            ((StringBuilder)localObject).append(m);
            ((StringBuilder)localObject).append(" formatCode=");
            ((StringBuilder)localObject).append(i1);
            ((StringBuilder)localObject).append(" componentCount=");
            ((StringBuilder)localObject).append(i2);
            Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
          }
          i2 += b[i1];
          if (i2 > 4)
          {
            if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
              break label525;
            }
            localObject = new StringBuilder();
            str = "Got byte count > 4, not orientation, continuing, formatCode=";
          }
          else
          {
            n += 8;
            if ((n >= 0) && (n <= paramb.d()))
            {
              if ((i2 >= 0) && (i2 + n <= paramb.d())) {
                return paramb.a(n);
              }
              if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                break label525;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Illegal number of bytes for TI tag data tagType=");
              ((StringBuilder)localObject).append(m);
              break label510;
            }
            if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
              break label525;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Illegal tagValueOffset=");
            ((StringBuilder)localObject).append(n);
            ((StringBuilder)localObject).append(" tagType=");
            ((StringBuilder)localObject).append(m);
            localObject = ((StringBuilder)localObject).toString();
            break label517;
          }
        }
        else
        {
          if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
            break label525;
          }
          localObject = new StringBuilder();
          str = "Got invalid format code = ";
        }
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(i1);
        label510:
        localObject = ((StringBuilder)localObject).toString();
        label517:
        Log.d("DfltImageHeaderParser", (String)localObject);
      }
      label525:
      i += 1;
    }
    return -1;
  }
  
  private int l(c paramc, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramc.read(paramArrayOfByte, paramInt);
    if (i != paramInt)
    {
      if (Log.isLoggable("DfltImageHeaderParser", 3))
      {
        paramc = new StringBuilder();
        paramc.append("Unable to read exif segment data, length: ");
        paramc.append(paramInt);
        paramc.append(", actually read: ");
        paramc.append(i);
        Log.d("DfltImageHeaderParser", paramc.toString());
      }
      return -1;
    }
    if (i(paramArrayOfByte, paramInt)) {
      return k(new b(paramArrayOfByte, paramInt));
    }
    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
      Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
    }
    return -1;
  }
  
  private boolean m(c paramc, int paramInt)
  {
    if ((paramc.getUInt16() << 16 | paramc.getUInt16()) != 1718909296) {
      return false;
    }
    int i = paramc.getUInt16() << 16 | paramc.getUInt16();
    if (i != 1635150182)
    {
      if (i == 1635150195) {
        return true;
      }
      paramc.skip(4L);
      paramInt -= 16;
      if (paramInt % 4 != 0) {
        return false;
      }
      i = 0;
      while ((i < 5) && (paramInt > 0))
      {
        int j = paramc.getUInt16() << 16 | paramc.getUInt16();
        if (j != 1635150182)
        {
          if (j == 1635150195) {
            return true;
          }
          i += 1;
          paramInt -= 4;
        }
        else
        {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public ImageHeaderParser.ImageType a(ByteBuffer paramByteBuffer)
  {
    return g(new a((ByteBuffer)x2.k.d(paramByteBuffer)));
  }
  
  public int b(ByteBuffer paramByteBuffer, b paramb)
  {
    return f(new a((ByteBuffer)x2.k.d(paramByteBuffer)), (b)x2.k.d(paramb));
  }
  
  public int c(InputStream paramInputStream, b paramb)
  {
    return f(new d((InputStream)x2.k.d(paramInputStream)), (b)x2.k.d(paramb));
  }
  
  public ImageHeaderParser.ImageType d(InputStream paramInputStream)
  {
    return g(new d((InputStream)x2.k.d(paramInputStream)));
  }
  
  private static final class a
    implements k.c
  {
    private final ByteBuffer a;
    
    a(ByteBuffer paramByteBuffer)
    {
      this.a = paramByteBuffer;
      paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
    
    public int getUInt16()
    {
      return getUInt8() << 8 | getUInt8();
    }
    
    public short getUInt8()
    {
      if (this.a.remaining() >= 1) {
        return (short)(this.a.get() & 0xFF);
      }
      throw new k.c.a();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt)
    {
      paramInt = Math.min(paramInt, this.a.remaining());
      if (paramInt == 0) {
        return -1;
      }
      this.a.get(paramArrayOfByte, 0, paramInt);
      return paramInt;
    }
    
    public long skip(long paramLong)
    {
      int i = (int)Math.min(this.a.remaining(), paramLong);
      ByteBuffer localByteBuffer = this.a;
      localByteBuffer.position(localByteBuffer.position() + i);
      return i;
    }
  }
  
  private static final class b
  {
    private final ByteBuffer a;
    
    b(byte[] paramArrayOfByte, int paramInt)
    {
      this.a = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
    }
    
    private boolean c(int paramInt1, int paramInt2)
    {
      return this.a.remaining() - paramInt1 >= paramInt2;
    }
    
    short a(int paramInt)
    {
      if (c(paramInt, 2)) {
        return this.a.getShort(paramInt);
      }
      return -1;
    }
    
    int b(int paramInt)
    {
      if (c(paramInt, 4)) {
        return this.a.getInt(paramInt);
      }
      return -1;
    }
    
    int d()
    {
      return this.a.remaining();
    }
    
    void e(ByteOrder paramByteOrder)
    {
      this.a.order(paramByteOrder);
    }
  }
  
  private static abstract interface c
  {
    public abstract int getUInt16();
    
    public abstract short getUInt8();
    
    public abstract int read(byte[] paramArrayOfByte, int paramInt);
    
    public abstract long skip(long paramLong);
    
    public static final class a
      extends IOException
    {
      a()
      {
        super();
      }
    }
  }
  
  private static final class d
    implements k.c
  {
    private final InputStream a;
    
    d(InputStream paramInputStream)
    {
      this.a = paramInputStream;
    }
    
    public int getUInt16()
    {
      return getUInt8() << 8 | getUInt8();
    }
    
    public short getUInt8()
    {
      int i = this.a.read();
      if (i != -1) {
        return (short)i;
      }
      throw new k.c.a();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt)
    {
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j >= paramInt) {
          break;
        }
        i = this.a.read(paramArrayOfByte, j, paramInt - j);
        k = i;
        if (i == -1) {
          break;
        }
        j += i;
      }
      if (j == 0)
      {
        if (k != -1) {
          return j;
        }
        throw new k.c.a();
      }
      return j;
    }
    
    public long skip(long paramLong)
    {
      if (paramLong < 0L) {
        return 0L;
      }
      long l1 = paramLong;
      if (l1 > 0L)
      {
        long l2 = this.a.skip(l1);
        if (l2 > 0L) {}
        for (;;)
        {
          l1 -= l2;
          break;
          if (this.a.read() == -1) {
            break label61;
          }
          l2 = 1L;
        }
      }
      label61:
      return paramLong - l1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.k
 * JD-Core Version:    0.7.0.1
 */