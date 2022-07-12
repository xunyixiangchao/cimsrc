package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.e1;
import androidx.camera.core.e1.a;
import androidx.camera.core.n1;
import h1.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class e
{
  private static final String c = "e";
  private static final ThreadLocal<SimpleDateFormat> d = new a();
  private static final ThreadLocal<SimpleDateFormat> e = new b();
  private static final ThreadLocal<SimpleDateFormat> f = new c();
  private static final List<String> g = n();
  private static final List<String> h = Arrays.asList(new String[] { "ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation" });
  private final a a;
  private boolean b = false;
  
  private e(a parama)
  {
    this.a = parama;
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    String str = f(l);
    this.a.g0("DateTime", str);
    try
    {
      str = Long.toString(l - d(str).getTime());
      this.a.g0("SubSecTime", str);
      return;
    }
    catch (ParseException localParseException) {}
  }
  
  private static Date c(String paramString)
  {
    return ((SimpleDateFormat)d.get()).parse(paramString);
  }
  
  private static Date d(String paramString)
  {
    return ((SimpleDateFormat)f.get()).parse(paramString);
  }
  
  private static Date e(String paramString)
  {
    return ((SimpleDateFormat)e.get()).parse(paramString);
  }
  
  private static String f(long paramLong)
  {
    return ((SimpleDateFormat)f.get()).format(new Date(paramLong));
  }
  
  public static e h(File paramFile)
  {
    return i(paramFile.toString());
  }
  
  public static e i(String paramString)
  {
    return new e(new a(paramString));
  }
  
  public static e j(e1 parame1)
  {
    parame1 = parame1.j()[0].b();
    parame1.rewind();
    byte[] arrayOfByte = new byte[parame1.capacity()];
    parame1.get(arrayOfByte);
    return k(new ByteArrayInputStream(arrayOfByte));
  }
  
  public static e k(InputStream paramInputStream)
  {
    return new e(new a(paramInputStream));
  }
  
  public static List<String> n()
  {
    return Arrays.asList(new String[] { "ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType" });
  }
  
  private long x(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = d(paramString).getTime();
      return l;
    }
    catch (ParseException paramString) {}
    return -1L;
  }
  
  /* Error */
  private long y(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: aload_2
    //   5: ifnonnull +7 -> 12
    //   8: ldc2_w 477
    //   11: lreturn
    //   12: aload_2
    //   13: ifnonnull +13 -> 26
    //   16: aload_1
    //   17: invokestatic 482	androidx/camera/core/impl/utils/e:c	(Ljava/lang/String;)Ljava/util/Date;
    //   20: invokevirtual 113	java/util/Date:getTime	()J
    //   23: lstore_3
    //   24: lload_3
    //   25: lreturn
    //   26: aload_1
    //   27: ifnonnull +13 -> 40
    //   30: aload_2
    //   31: invokestatic 484	androidx/camera/core/impl/utils/e:e	(Ljava/lang/String;)Ljava/util/Date;
    //   34: invokevirtual 113	java/util/Date:getTime	()J
    //   37: lstore_3
    //   38: lload_3
    //   39: lreturn
    //   40: new 486	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 487	java/lang/StringBuilder:<init>	()V
    //   47: astore 5
    //   49: aload 5
    //   51: aload_1
    //   52: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 5
    //   58: ldc_w 493
    //   61: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: aload_2
    //   68: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: aload 5
    //   75: invokevirtual 494	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 496	androidx/camera/core/impl/utils/e:x	(Ljava/lang/String;)J
    //   81: lreturn
    //   82: astore_1
    //   83: ldc2_w 477
    //   86: lreturn
    //   87: astore_1
    //   88: ldc2_w 477
    //   91: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	e
    //   0	92	1	paramString1	String
    //   0	92	2	paramString2	String
    //   23	16	3	l	long
    //   47	27	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	24	82	java/text/ParseException
    //   30	38	87	java/text/ParseException
  }
  
  public void A()
  {
    if (!this.b) {
      a();
    }
    this.a.b0();
  }
  
  public void b(Location paramLocation)
  {
    this.a.h0(paramLocation);
  }
  
  public void g(e parame)
  {
    Object localObject = new ArrayList(g);
    ((List)localObject).removeAll(h);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = this.a.m(str1);
      if (str2 != null) {
        parame.a.g0(str1, str2);
      }
    }
  }
  
  public void l()
  {
    int i;
    switch (r())
    {
    default: 
      i = 2;
      break;
    case 8: 
      i = 7;
      break;
    case 7: 
      i = 8;
      break;
    case 6: 
      i = 5;
      break;
    case 5: 
      i = 6;
      break;
    case 4: 
      i = 3;
      break;
    case 3: 
      i = 4;
      break;
    case 2: 
      i = 1;
    }
    this.a.g0("Orientation", String.valueOf(i));
  }
  
  public void m()
  {
    int i;
    switch (r())
    {
    default: 
      i = 4;
      break;
    case 8: 
      i = 5;
      break;
    case 7: 
      i = 6;
      break;
    case 6: 
      i = 7;
      break;
    case 5: 
      i = 8;
      break;
    case 4: 
      i = 1;
      break;
    case 3: 
      i = 2;
      break;
    case 2: 
      i = 3;
    }
    this.a.g0("Orientation", String.valueOf(i));
  }
  
  public String o()
  {
    return this.a.m("ImageDescription");
  }
  
  public int p()
  {
    return this.a.o("ImageLength", 0);
  }
  
  public Location q()
  {
    String str = this.a.m("GPSProcessingMethod");
    double[] arrayOfDouble = this.a.s();
    double d1 = this.a.l(0.0D);
    double d2 = this.a.n("GPSSpeed", 0.0D);
    Object localObject2 = this.a.m("GPSSpeedRef");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "K";
    }
    long l = y(this.a.m("GPSDateStamp"), this.a.m("GPSTimeStamp"));
    if (arrayOfDouble == null) {
      return null;
    }
    localObject2 = str;
    if (str == null) {
      localObject2 = c;
    }
    localObject2 = new Location((String)localObject2);
    ((Location)localObject2).setLatitude(arrayOfDouble[0]);
    ((Location)localObject2).setLongitude(arrayOfDouble[1]);
    if (d1 != 0.0D) {
      ((Location)localObject2).setAltitude(d1);
    }
    if (d2 != 0.0D)
    {
      int i = -1;
      int j = ((String)localObject1).hashCode();
      if (j != 75)
      {
        if (j != 77)
        {
          if ((j == 78) && (((String)localObject1).equals("N"))) {
            i = 1;
          }
        }
        else if (((String)localObject1).equals("M")) {
          i = 0;
        }
      }
      else if (((String)localObject1).equals("K")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1) {
          localObject1 = d.a(d2);
        } else {
          localObject1 = d.b(d2);
        }
      }
      else {
        localObject1 = d.c(d2);
      }
      ((Location)localObject2).setSpeed((float)((e.d.a)localObject1).a());
    }
    if (l != -1L) {
      ((Location)localObject2).setTime(l);
    }
    return localObject2;
  }
  
  public int r()
  {
    return this.a.o("Orientation", 0);
  }
  
  public int s()
  {
    switch (r())
    {
    default: 
      return 0;
    case 8: 
      return 270;
    case 6: 
    case 7: 
      return 90;
    case 5: 
      return 270;
    }
    return 180;
  }
  
  public long t()
  {
    long l2 = x(this.a.m("DateTimeOriginal"));
    if (l2 == -1L) {
      return -1L;
    }
    String str = this.a.m("SubSecTimeOriginal");
    long l1 = l2;
    if (str != null) {}
    try
    {
      for (l1 = Long.parseLong(str); l1 > 1000L; l1 /= 10L) {}
      l1 = l2 + l1;
      return l1;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return l2;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[] { Integer.valueOf(u()), Integer.valueOf(p()), Integer.valueOf(s()), Boolean.valueOf(w()), Boolean.valueOf(v()), q(), Long.valueOf(t()), o() });
  }
  
  public int u()
  {
    return this.a.o("ImageWidth", 0);
  }
  
  public boolean v()
  {
    return r() == 2;
  }
  
  public boolean w()
  {
    int i = r();
    return (i == 4) || (i == 5) || (i == 7);
  }
  
  public void z(int paramInt)
  {
    a locala;
    if (paramInt % 90 != 0)
    {
      n1.k(c, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", new Object[] { Integer.valueOf(paramInt) }));
      locala = this.a;
    }
    int i;
    for (String str = String.valueOf(0);; str = String.valueOf(i))
    {
      locala.g0("Orientation", str);
      return;
      int j = paramInt % 360;
      paramInt = r();
      int k;
      for (;;)
      {
        i = paramInt;
        k = j;
        if (j >= 0) {
          break;
        }
        j += 90;
        switch (paramInt)
        {
        default: 
          paramInt = 8;
          break;
        case 7: 
          paramInt = 2;
          break;
        case 6: 
          paramInt = 1;
          break;
        case 5: 
          paramInt = 4;
          break;
        case 4: 
          paramInt = 7;
          break;
        case 3: 
        case 8: 
          paramInt = 6;
          break;
        case 2: 
          paramInt = 5;
        }
      }
      while (k > 0)
      {
        k -= 90;
        switch (i)
        {
        default: 
          i = 6;
          break;
        case 8: 
          i = 1;
          break;
        case 7: 
          i = 4;
          break;
        case 6: 
          i = 3;
          break;
        case 5: 
          i = 2;
          break;
        case 4: 
          i = 5;
          break;
        case 3: 
          i = 8;
          break;
        case 2: 
          i = 7;
        }
      }
      locala = this.a;
    }
  }
  
  class a
    extends ThreadLocal<SimpleDateFormat>
  {
    public SimpleDateFormat a()
    {
      return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
    }
  }
  
  class b
    extends ThreadLocal<SimpleDateFormat>
  {
    public SimpleDateFormat a()
    {
      return new SimpleDateFormat("HH:mm:ss", Locale.US);
    }
  }
  
  class c
    extends ThreadLocal<SimpleDateFormat>
  {
    public SimpleDateFormat a()
    {
      return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
    }
  }
  
  private static final class d
  {
    static a a(double paramDouble)
    {
      return new a(paramDouble * 0.621371D);
    }
    
    static a b(double paramDouble)
    {
      return new a(paramDouble * 1.15078D);
    }
    
    static a c(double paramDouble)
    {
      return new a(paramDouble);
    }
    
    static final class a
    {
      final double a;
      
      a(double paramDouble)
      {
        this.a = paramDouble;
      }
      
      double a()
      {
        return this.a / 2.23694D;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.e
 * JD-Core Version:    0.7.0.1
 */