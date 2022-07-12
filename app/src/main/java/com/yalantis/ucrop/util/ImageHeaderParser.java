package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import h1.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ImageHeaderParser
{
  private static final int[] BYTES_PER_FORMAT = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private static final int EXIF_MAGIC_NUMBER = 65496;
  private static final int EXIF_SEGMENT_TYPE = 225;
  private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
  private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "";
  private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = "".getBytes(Charset.forName("UTF-8"));
  private static final int MARKER_EOI = 217;
  private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
  private static final int ORIENTATION_TAG_TYPE = 274;
  private static final int SEGMENT_SOS = 218;
  private static final int SEGMENT_START_ID = 255;
  private static final String TAG = "ImageHeaderParser";
  public static final int UNKNOWN_ORIENTATION = -1;
  private final Reader reader;
  
  public ImageHeaderParser(InputStream paramInputStream)
  {
    this.reader = new StreamReader(paramInputStream);
  }
  
  private static int calcTagOffset(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  public static void copyExif(a parama, int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new a(paramString);
        i = 0;
        if (i < 22)
        {
          String str1 = new String[] { "FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance" }[i];
          String str2 = parama.m(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.g0(str1, str2);
          }
        }
        else
        {
          paramString.g0("ImageWidth", String.valueOf(paramInt1));
          paramString.g0("ImageLength", String.valueOf(paramInt2));
          paramString.g0("Orientation", "0");
          paramString.b0();
          return;
        }
      }
      catch (IOException parama)
      {
        Log.d("ImageHeaderParser", parama.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  private static boolean handles(int paramInt)
  {
    return ((paramInt & 0xFFD8) == 65496) || (paramInt == 19789) || (paramInt == 18761);
  }
  
  private boolean hasJpegExifPreamble(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if ((paramArrayOfByte != null) && (paramInt > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramInt = 0;
      for (;;)
      {
        byte[] arrayOfByte = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
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
  
  private int moveToExifSegmentAndGetLength()
  {
    int i;
    Object localObject;
    int j;
    long l1;
    long l2;
    do
    {
      i = this.reader.getUInt8();
      if (i != 255)
      {
        if (Log.isLoggable("ImageHeaderParser", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown segmentId=");
          ((StringBuilder)localObject).append(i);
          Log.d("ImageHeaderParser", ((StringBuilder)localObject).toString());
        }
        return -1;
      }
      i = this.reader.getUInt8();
      if (i == 218) {
        return -1;
      }
      if (i == 217)
      {
        if (Log.isLoggable("ImageHeaderParser", 3)) {
          Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
        }
        return -1;
      }
      j = this.reader.getUInt16() - 2;
      if (i == 225) {
        break;
      }
      localObject = this.reader;
      l1 = j;
      l2 = ((Reader)localObject).skip(l1);
    } while (l2 == l1);
    if (Log.isLoggable("ImageHeaderParser", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to skip enough data, type: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", wanted to skip: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", but actually skipped: ");
      ((StringBuilder)localObject).append(l2);
      Log.d("ImageHeaderParser", ((StringBuilder)localObject).toString());
    }
    return -1;
    return j;
  }
  
  private static int parseExifSegment(RandomAccessReader paramRandomAccessReader)
  {
    int i = paramRandomAccessReader.getInt16(6);
    if (i == 19789) {}
    Object localObject;
    for (;;)
    {
      localObject = ByteOrder.BIG_ENDIAN;
      break;
      if (i == 18761)
      {
        localObject = ByteOrder.LITTLE_ENDIAN;
        break;
      }
      if (Log.isLoggable("ImageHeaderParser", 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown endianness = ");
        ((StringBuilder)localObject).append(i);
        Log.d("ImageHeaderParser", ((StringBuilder)localObject).toString());
      }
    }
    paramRandomAccessReader.order((ByteOrder)localObject);
    int j = paramRandomAccessReader.getInt32(10) + 6;
    int k = paramRandomAccessReader.getInt16(j);
    i = 0;
    while (i < k)
    {
      int n = calcTagOffset(j, i);
      int m = paramRandomAccessReader.getInt16(n);
      if (m == 274)
      {
        int i1 = paramRandomAccessReader.getInt16(n + 2);
        String str;
        if ((i1 >= 1) && (i1 <= 12))
        {
          int i2 = paramRandomAccessReader.getInt32(n + 4);
          if (i2 < 0)
          {
            if (!Log.isLoggable("ImageHeaderParser", 3)) {
              break label534;
            }
            localObject = "Negative tiff component count";
            break label526;
          }
          if (Log.isLoggable("ImageHeaderParser", 3))
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
            Log.d("ImageHeaderParser", ((StringBuilder)localObject).toString());
          }
          i2 += BYTES_PER_FORMAT[i1];
          if (i2 > 4)
          {
            if (!Log.isLoggable("ImageHeaderParser", 3)) {
              break label534;
            }
            localObject = new StringBuilder();
            str = "Got byte count > 4, not orientation, continuing, formatCode=";
          }
          else
          {
            n += 8;
            if ((n >= 0) && (n <= paramRandomAccessReader.length()))
            {
              if ((i2 >= 0) && (i2 + n <= paramRandomAccessReader.length())) {
                return paramRandomAccessReader.getInt16(n);
              }
              if (!Log.isLoggable("ImageHeaderParser", 3)) {
                break label534;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Illegal number of bytes for TI tag data tagType=");
              ((StringBuilder)localObject).append(m);
              break label519;
            }
            if (!Log.isLoggable("ImageHeaderParser", 3)) {
              break label534;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Illegal tagValueOffset=");
            ((StringBuilder)localObject).append(n);
            ((StringBuilder)localObject).append(" tagType=");
            ((StringBuilder)localObject).append(m);
            localObject = ((StringBuilder)localObject).toString();
            break label526;
          }
        }
        else
        {
          if (!Log.isLoggable("ImageHeaderParser", 3)) {
            break label534;
          }
          localObject = new StringBuilder();
          str = "Got invalid format code = ";
        }
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(i1);
        label519:
        localObject = ((StringBuilder)localObject).toString();
        label526:
        Log.d("ImageHeaderParser", (String)localObject);
      }
      label534:
      i += 1;
    }
    return -1;
  }
  
  private int parseExifSegment(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.reader.read(paramArrayOfByte, paramInt);
    if (i != paramInt)
    {
      if (Log.isLoggable("ImageHeaderParser", 3))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Unable to read exif segment data, length: ");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append(", actually read: ");
        paramArrayOfByte.append(i);
        Log.d("ImageHeaderParser", paramArrayOfByte.toString());
      }
      return -1;
    }
    if (hasJpegExifPreamble(paramArrayOfByte, paramInt)) {
      return parseExifSegment(new RandomAccessReader(paramArrayOfByte, paramInt));
    }
    if (Log.isLoggable("ImageHeaderParser", 3)) {
      Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
    }
    return -1;
  }
  
  public int getOrientation()
  {
    int i = this.reader.getUInt16();
    if (!handles(i))
    {
      if (Log.isLoggable("ImageHeaderParser", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Parser doesn't handle magic number: ");
        localStringBuilder.append(i);
        Log.d("ImageHeaderParser", localStringBuilder.toString());
      }
      return -1;
    }
    i = moveToExifSegmentAndGetLength();
    if (i == -1)
    {
      if (Log.isLoggable("ImageHeaderParser", 3)) {
        Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
      }
      return -1;
    }
    return parseExifSegment(new byte[i], i);
  }
  
  private static class RandomAccessReader
  {
    private final ByteBuffer data;
    
    public RandomAccessReader(byte[] paramArrayOfByte, int paramInt)
    {
      this.data = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
    }
    
    public short getInt16(int paramInt)
    {
      return this.data.getShort(paramInt);
    }
    
    public int getInt32(int paramInt)
    {
      return this.data.getInt(paramInt);
    }
    
    public int length()
    {
      return this.data.remaining();
    }
    
    public void order(ByteOrder paramByteOrder)
    {
      this.data.order(paramByteOrder);
    }
  }
  
  private static abstract interface Reader
  {
    public abstract int getUInt16();
    
    public abstract short getUInt8();
    
    public abstract int read(byte[] paramArrayOfByte, int paramInt);
    
    public abstract long skip(long paramLong);
  }
  
  private static class StreamReader
    implements ImageHeaderParser.Reader
  {
    private final InputStream is;
    
    public StreamReader(InputStream paramInputStream)
    {
      this.is = paramInputStream;
    }
    
    public int getUInt16()
    {
      return this.is.read() << 8 & 0xFF00 | this.is.read() & 0xFF;
    }
    
    public short getUInt8()
    {
      return (short)(this.is.read() & 0xFF);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt)
    {
      int i = paramInt;
      while (i > 0)
      {
        int j = this.is.read(paramArrayOfByte, paramInt - i, i);
        if (j == -1) {
          break;
        }
        i -= j;
      }
      return paramInt - i;
    }
    
    public long skip(long paramLong)
    {
      if (paramLong < 0L) {
        return 0L;
      }
      long l1 = paramLong;
      if (l1 > 0L)
      {
        long l2 = this.is.skip(l1);
        if (l2 > 0L) {}
        for (;;)
        {
          l1 -= l2;
          break;
          if (this.is.read() == -1) {
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
 * Qualified Name:     com.yalantis.ucrop.util.ImageHeaderParser
 * JD-Core Version:    0.7.0.1
 */