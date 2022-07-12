package h1;

import android.content.res.AssetManager.AssetInputStream;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class a
{
  public static final int[] A;
  static final byte[] B;
  private static final byte[] C;
  private static final byte[] D;
  private static final byte[] E;
  private static final byte[] F;
  private static final byte[] G;
  private static final byte[] H;
  private static final byte[] I;
  private static final byte[] J;
  private static final byte[] K;
  private static final byte[] L;
  private static final byte[] M;
  private static final byte[] N;
  private static final byte[] O;
  private static final byte[] P;
  private static final byte[] Q;
  private static final byte[] R;
  private static final byte[] S;
  private static final byte[] T;
  private static SimpleDateFormat U;
  private static SimpleDateFormat V;
  static final String[] W;
  static final int[] X;
  static final byte[] Y;
  private static final e[] Z;
  private static final e[] a0;
  private static final e[] b0;
  private static final e[] c0;
  private static final e[] d0;
  private static final e e0;
  private static final e[] f0;
  private static final e[] g0;
  private static final e[] h0;
  private static final e[] i0;
  static final e[][] j0;
  private static final e[] k0;
  private static final e l0;
  private static final e m0;
  private static final HashMap<Integer, e>[] n0;
  private static final HashMap<String, e>[] o0;
  private static final HashSet<String> p0;
  private static final HashMap<Integer, Integer> q0;
  static final Charset r0;
  static final byte[] s0;
  private static final byte[] t0;
  private static final Pattern u0 = Pattern.compile(".*[1-9].*");
  private static final boolean v;
  private static final Pattern v0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
  private static final List<Integer> w;
  private static final Pattern w0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
  private static final List<Integer> x;
  private static final Pattern x0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
  public static final int[] y;
  public static final int[] z;
  private String a;
  private FileDescriptor b;
  private AssetManager.AssetInputStream c;
  private int d;
  private boolean e;
  private final HashMap<String, d>[] f;
  private Set<Integer> g;
  private ByteOrder h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private byte[] n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(3);
    v = Log.isLoggable("ExifInterface", 3);
    Integer localInteger2 = Integer.valueOf(1);
    Integer localInteger3 = Integer.valueOf(2);
    Integer localInteger4 = Integer.valueOf(8);
    w = Arrays.asList(new Integer[] { localInteger2, Integer.valueOf(6), localInteger1, localInteger4 });
    Integer localInteger5 = Integer.valueOf(7);
    Integer localInteger6 = Integer.valueOf(5);
    x = Arrays.asList(new Integer[] { localInteger3, localInteger5, Integer.valueOf(4), localInteger6 });
    y = new int[] { 8, 8, 8 };
    z = new int[] { 4 };
    A = new int[] { 8 };
    B = new byte[] { -1, -40, -1 };
    C = new byte[] { 102, 116, 121, 112 };
    D = new byte[] { 109, 105, 102, 49 };
    E = new byte[] { 104, 101, 105, 99 };
    F = new byte[] { 79, 76, 89, 77, 80, 0 };
    G = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    H = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
    I = new byte[] { 101, 88, 73, 102 };
    J = new byte[] { 73, 72, 68, 82 };
    K = new byte[] { 73, 69, 78, 68 };
    L = new byte[] { 82, 73, 70, 70 };
    M = new byte[] { 87, 69, 66, 80 };
    N = new byte[] { 69, 88, 73, 70 };
    O = new byte[] { -99, 1, 42 };
    P = "VP8X".getBytes(Charset.defaultCharset());
    Q = "VP8L".getBytes(Charset.defaultCharset());
    R = "VP8 ".getBytes(Charset.defaultCharset());
    S = "ANIM".getBytes(Charset.defaultCharset());
    T = "ANMF".getBytes(Charset.defaultCharset());
    W = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
    X = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
    Y = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    Object localObject1 = new e[42];
    localObject1[0] = new e("NewSubfileType", 254, 4);
    localObject1[1] = new e("SubfileType", 255, 4);
    localObject1[2] = new e("ImageWidth", 256, 3, 4);
    localObject1[3] = new e("ImageLength", 257, 3, 4);
    localObject1[4] = new e("BitsPerSample", 258, 3);
    localObject1[5] = new e("Compression", 259, 3);
    localObject1[6] = new e("PhotometricInterpretation", 262, 3);
    localObject1[7] = new e("ImageDescription", 270, 2);
    localObject1[8] = new e("Make", 271, 2);
    localObject1[9] = new e("Model", 272, 2);
    localObject1[10] = new e("StripOffsets", 273, 3, 4);
    localObject1[11] = new e("Orientation", 274, 3);
    localObject1[12] = new e("SamplesPerPixel", 277, 3);
    localObject1[13] = new e("RowsPerStrip", 278, 3, 4);
    localObject1[14] = new e("StripByteCounts", 279, 3, 4);
    localObject1[15] = new e("XResolution", 282, 5);
    localObject1[16] = new e("YResolution", 283, 5);
    localObject1[17] = new e("PlanarConfiguration", 284, 3);
    localObject1[18] = new e("ResolutionUnit", 296, 3);
    localObject1[19] = new e("TransferFunction", 301, 3);
    localObject1[20] = new e("Software", 305, 2);
    localObject1[21] = new e("DateTime", 306, 2);
    localObject1[22] = new e("Artist", 315, 2);
    localObject1[23] = new e("WhitePoint", 318, 5);
    localObject1[24] = new e("PrimaryChromaticities", 319, 5);
    localObject1[25] = new e("SubIFDPointer", 330, 4);
    localObject1[26] = new e("JPEGInterchangeFormat", 513, 4);
    localObject1[27] = new e("JPEGInterchangeFormatLength", 514, 4);
    localObject1[28] = new e("YCbCrCoefficients", 529, 5);
    localObject1[29] = new e("YCbCrSubSampling", 530, 3);
    localObject1[30] = new e("YCbCrPositioning", 531, 3);
    localObject1[31] = new e("ReferenceBlackWhite", 532, 5);
    localObject1[32] = new e("Copyright", 33432, 2);
    localObject1[33] = new e("ExifIFDPointer", 34665, 4);
    localObject1[34] = new e("GPSInfoIFDPointer", 34853, 4);
    localObject1[35] = new e("SensorTopBorder", 4, 4);
    localObject1[36] = new e("SensorLeftBorder", 5, 4);
    localObject1[37] = new e("SensorBottomBorder", 6, 4);
    localObject1[38] = new e("SensorRightBorder", 7, 4);
    localObject1[39] = new e("ISO", 23, 3);
    localObject1[40] = new e("JpgFromRaw", 46, 7);
    localObject1[41] = new e("Xmp", 700, 1);
    Z = (e[])localObject1;
    Object localObject2 = new e[74];
    localObject2[0] = new e("ExposureTime", 33434, 5);
    localObject2[1] = new e("FNumber", 33437, 5);
    localObject2[2] = new e("ExposureProgram", 34850, 3);
    localObject2[3] = new e("SpectralSensitivity", 34852, 2);
    localObject2[4] = new e("PhotographicSensitivity", 34855, 3);
    localObject2[5] = new e("OECF", 34856, 7);
    localObject2[6] = new e("SensitivityType", 34864, 3);
    localObject2[7] = new e("StandardOutputSensitivity", 34865, 4);
    localObject2[8] = new e("RecommendedExposureIndex", 34866, 4);
    localObject2[9] = new e("ISOSpeed", 34867, 4);
    localObject2[10] = new e("ISOSpeedLatitudeyyy", 34868, 4);
    localObject2[11] = new e("ISOSpeedLatitudezzz", 34869, 4);
    localObject2[12] = new e("ExifVersion", 36864, 2);
    localObject2[13] = new e("DateTimeOriginal", 36867, 2);
    localObject2[14] = new e("DateTimeDigitized", 36868, 2);
    localObject2[15] = new e("OffsetTime", 36880, 2);
    localObject2[16] = new e("OffsetTimeOriginal", 36881, 2);
    localObject2[17] = new e("OffsetTimeDigitized", 36882, 2);
    localObject2[18] = new e("ComponentsConfiguration", 37121, 7);
    localObject2[19] = new e("CompressedBitsPerPixel", 37122, 5);
    localObject2[20] = new e("ShutterSpeedValue", 37377, 10);
    localObject2[21] = new e("ApertureValue", 37378, 5);
    localObject2[22] = new e("BrightnessValue", 37379, 10);
    localObject2[23] = new e("ExposureBiasValue", 37380, 10);
    localObject2[24] = new e("MaxApertureValue", 37381, 5);
    localObject2[25] = new e("SubjectDistance", 37382, 5);
    localObject2[26] = new e("MeteringMode", 37383, 3);
    localObject2[27] = new e("LightSource", 37384, 3);
    localObject2[28] = new e("Flash", 37385, 3);
    localObject2[29] = new e("FocalLength", 37386, 5);
    localObject2[30] = new e("SubjectArea", 37396, 3);
    localObject2[31] = new e("MakerNote", 37500, 7);
    localObject2[32] = new e("UserComment", 37510, 7);
    localObject2[33] = new e("SubSecTime", 37520, 2);
    localObject2[34] = new e("SubSecTimeOriginal", 37521, 2);
    localObject2[35] = new e("SubSecTimeDigitized", 37522, 2);
    localObject2[36] = new e("FlashpixVersion", 40960, 7);
    localObject2[37] = new e("ColorSpace", 40961, 3);
    localObject2[38] = new e("PixelXDimension", 40962, 3, 4);
    localObject2[39] = new e("PixelYDimension", 40963, 3, 4);
    localObject2[40] = new e("RelatedSoundFile", 40964, 2);
    localObject2[41] = new e("InteroperabilityIFDPointer", 40965, 4);
    localObject2[42] = new e("FlashEnergy", 41483, 5);
    localObject2[43] = new e("SpatialFrequencyResponse", 41484, 7);
    localObject2[44] = new e("FocalPlaneXResolution", 41486, 5);
    localObject2[45] = new e("FocalPlaneYResolution", 41487, 5);
    localObject2[46] = new e("FocalPlaneResolutionUnit", 41488, 3);
    localObject2[47] = new e("SubjectLocation", 41492, 3);
    localObject2[48] = new e("ExposureIndex", 41493, 5);
    localObject2[49] = new e("SensingMethod", 41495, 3);
    localObject2[50] = new e("FileSource", 41728, 7);
    localObject2[51] = new e("SceneType", 41729, 7);
    localObject2[52] = new e("CFAPattern", 41730, 7);
    localObject2[53] = new e("CustomRendered", 41985, 3);
    localObject2[54] = new e("ExposureMode", 41986, 3);
    localObject2[55] = new e("WhiteBalance", 41987, 3);
    localObject2[56] = new e("DigitalZoomRatio", 41988, 5);
    localObject2[57] = new e("FocalLengthIn35mmFilm", 41989, 3);
    localObject2[58] = new e("SceneCaptureType", 41990, 3);
    localObject2[59] = new e("GainControl", 41991, 3);
    localObject2[60] = new e("Contrast", 41992, 3);
    localObject2[61] = new e("Saturation", 41993, 3);
    localObject2[62] = new e("Sharpness", 41994, 3);
    localObject2[63] = new e("DeviceSettingDescription", 41995, 7);
    localObject2[64] = new e("SubjectDistanceRange", 41996, 3);
    localObject2[65] = new e("ImageUniqueID", 42016, 2);
    localObject2[66] = new e("CameraOwnerName", 42032, 2);
    localObject2[67] = new e("BodySerialNumber", 42033, 2);
    localObject2[68] = new e("LensSpecification", 42034, 5);
    localObject2[69] = new e("LensMake", 42035, 2);
    localObject2[70] = new e("LensModel", 42036, 2);
    localObject2[71] = new e("Gamma", 42240, 5);
    localObject2[72] = new e("DNGVersion", 50706, 1);
    localObject2[73] = new e("DefaultCropSize", 50720, 3, 4);
    a0 = (e[])localObject2;
    e[] arrayOfe1 = new e[32];
    arrayOfe1[0] = new e("GPSVersionID", 0, 1);
    arrayOfe1[1] = new e("GPSLatitudeRef", 1, 2);
    arrayOfe1[2] = new e("GPSLatitude", 2, 5, 10);
    arrayOfe1[3] = new e("GPSLongitudeRef", 3, 2);
    arrayOfe1[4] = new e("GPSLongitude", 4, 5, 10);
    arrayOfe1[5] = new e("GPSAltitudeRef", 5, 1);
    arrayOfe1[6] = new e("GPSAltitude", 6, 5);
    arrayOfe1[7] = new e("GPSTimeStamp", 7, 5);
    arrayOfe1[8] = new e("GPSSatellites", 8, 2);
    arrayOfe1[9] = new e("GPSStatus", 9, 2);
    arrayOfe1[10] = new e("GPSMeasureMode", 10, 2);
    arrayOfe1[11] = new e("GPSDOP", 11, 5);
    arrayOfe1[12] = new e("GPSSpeedRef", 12, 2);
    arrayOfe1[13] = new e("GPSSpeed", 13, 5);
    arrayOfe1[14] = new e("GPSTrackRef", 14, 2);
    arrayOfe1[15] = new e("GPSTrack", 15, 5);
    arrayOfe1[16] = new e("GPSImgDirectionRef", 16, 2);
    arrayOfe1[17] = new e("GPSImgDirection", 17, 5);
    arrayOfe1[18] = new e("GPSMapDatum", 18, 2);
    arrayOfe1[19] = new e("GPSDestLatitudeRef", 19, 2);
    arrayOfe1[20] = new e("GPSDestLatitude", 20, 5);
    arrayOfe1[21] = new e("GPSDestLongitudeRef", 21, 2);
    arrayOfe1[22] = new e("GPSDestLongitude", 22, 5);
    arrayOfe1[23] = new e("GPSDestBearingRef", 23, 2);
    arrayOfe1[24] = new e("GPSDestBearing", 24, 5);
    arrayOfe1[25] = new e("GPSDestDistanceRef", 25, 2);
    arrayOfe1[26] = new e("GPSDestDistance", 26, 5);
    arrayOfe1[27] = new e("GPSProcessingMethod", 27, 7);
    arrayOfe1[28] = new e("GPSAreaInformation", 28, 7);
    arrayOfe1[29] = new e("GPSDateStamp", 29, 2);
    arrayOfe1[30] = new e("GPSDifferential", 30, 3);
    arrayOfe1[31] = new e("GPSHPositioningError", 31, 5);
    b0 = arrayOfe1;
    e[] arrayOfe2 = new e[1];
    arrayOfe2[0] = new e("InteroperabilityIndex", 1, 2);
    c0 = arrayOfe2;
    e[] arrayOfe3 = new e[37];
    arrayOfe3[0] = new e("NewSubfileType", 254, 4);
    arrayOfe3[1] = new e("SubfileType", 255, 4);
    arrayOfe3[2] = new e("ThumbnailImageWidth", 256, 3, 4);
    arrayOfe3[3] = new e("ThumbnailImageLength", 257, 3, 4);
    arrayOfe3[4] = new e("BitsPerSample", 258, 3);
    arrayOfe3[5] = new e("Compression", 259, 3);
    arrayOfe3[6] = new e("PhotometricInterpretation", 262, 3);
    arrayOfe3[7] = new e("ImageDescription", 270, 2);
    arrayOfe3[8] = new e("Make", 271, 2);
    arrayOfe3[9] = new e("Model", 272, 2);
    arrayOfe3[10] = new e("StripOffsets", 273, 3, 4);
    arrayOfe3[11] = new e("ThumbnailOrientation", 274, 3);
    arrayOfe3[12] = new e("SamplesPerPixel", 277, 3);
    arrayOfe3[13] = new e("RowsPerStrip", 278, 3, 4);
    arrayOfe3[14] = new e("StripByteCounts", 279, 3, 4);
    arrayOfe3[15] = new e("XResolution", 282, 5);
    arrayOfe3[16] = new e("YResolution", 283, 5);
    arrayOfe3[17] = new e("PlanarConfiguration", 284, 3);
    arrayOfe3[18] = new e("ResolutionUnit", 296, 3);
    arrayOfe3[19] = new e("TransferFunction", 301, 3);
    arrayOfe3[20] = new e("Software", 305, 2);
    arrayOfe3[21] = new e("DateTime", 306, 2);
    arrayOfe3[22] = new e("Artist", 315, 2);
    arrayOfe3[23] = new e("WhitePoint", 318, 5);
    arrayOfe3[24] = new e("PrimaryChromaticities", 319, 5);
    arrayOfe3[25] = new e("SubIFDPointer", 330, 4);
    arrayOfe3[26] = new e("JPEGInterchangeFormat", 513, 4);
    arrayOfe3[27] = new e("JPEGInterchangeFormatLength", 514, 4);
    arrayOfe3[28] = new e("YCbCrCoefficients", 529, 5);
    arrayOfe3[29] = new e("YCbCrSubSampling", 530, 3);
    arrayOfe3[30] = new e("YCbCrPositioning", 531, 3);
    arrayOfe3[31] = new e("ReferenceBlackWhite", 532, 5);
    arrayOfe3[32] = new e("Copyright", 33432, 2);
    arrayOfe3[33] = new e("ExifIFDPointer", 34665, 4);
    arrayOfe3[34] = new e("GPSInfoIFDPointer", 34853, 4);
    arrayOfe3[35] = new e("DNGVersion", 50706, 1);
    arrayOfe3[36] = new e("DefaultCropSize", 50720, 3, 4);
    d0 = arrayOfe3;
    e0 = new e("StripOffsets", 273, 3);
    e[] arrayOfe4 = new e[3];
    arrayOfe4[0] = new e("ThumbnailImage", 256, 7);
    arrayOfe4[1] = new e("CameraSettingsIFDPointer", 8224, 4);
    arrayOfe4[2] = new e("ImageProcessingIFDPointer", 8256, 4);
    f0 = arrayOfe4;
    e[] arrayOfe5 = new e[2];
    arrayOfe5[0] = new e("PreviewImageStart", 257, 4);
    arrayOfe5[1] = new e("PreviewImageLength", 258, 4);
    g0 = arrayOfe5;
    e[] arrayOfe6 = new e[1];
    arrayOfe6[0] = new e("AspectFrame", 4371, 3);
    h0 = arrayOfe6;
    e[] arrayOfe7 = new e[1];
    arrayOfe7[0] = new e("ColorSpace", 55, 3);
    i0 = arrayOfe7;
    e[][] arrayOfe; = new e[10][];
    arrayOfe;[0] = localObject1;
    arrayOfe;[1] = localObject2;
    arrayOfe;[2] = arrayOfe1;
    arrayOfe;[3] = arrayOfe2;
    arrayOfe;[4] = arrayOfe3;
    arrayOfe;[5] = localObject1;
    arrayOfe;[6] = arrayOfe4;
    arrayOfe;[7] = arrayOfe5;
    arrayOfe;[8] = arrayOfe6;
    arrayOfe;[9] = arrayOfe7;
    j0 = arrayOfe;;
    k0 = new e[] { new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1) };
    l0 = new e("JPEGInterchangeFormat", 513, 4);
    m0 = new e("JPEGInterchangeFormatLength", 514, 4);
    n0 = new HashMap[arrayOfe;.length];
    o0 = new HashMap[arrayOfe;.length];
    p0 = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    q0 = new HashMap();
    localObject1 = Charset.forName("US-ASCII");
    r0 = (Charset)localObject1;
    s0 = "".getBytes((Charset)localObject1);
    t0 = "".getBytes((Charset)localObject1);
    localObject2 = Locale.US;
    localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", (Locale)localObject2);
    U = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", (Locale)localObject2);
    V = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    int i1 = 0;
    for (;;)
    {
      localObject1 = j0;
      if (i1 >= localObject1.length) {
        break;
      }
      n0[i1] = new HashMap();
      o0[i1] = new HashMap();
      localObject1 = localObject1[i1];
      int i3 = localObject1.length;
      int i2 = 0;
      while (i2 < i3)
      {
        localObject2 = localObject1[i2];
        n0[i1].put(Integer.valueOf(((e)localObject2).a), localObject2);
        o0[i1].put(((e)localObject2).b, localObject2);
        i2 += 1;
      }
      i1 += 1;
    }
    localObject1 = q0;
    localObject2 = k0;
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[0].a), localInteger6);
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[1].a), localInteger2);
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[2].a), localInteger3);
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[3].a), localInteger1);
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[4].a), localInteger5);
    ((HashMap)localObject1).put(Integer.valueOf(localObject2[5].a), localInteger4);
  }
  
  public a(InputStream paramInputStream)
  {
    this(paramInputStream, 0);
  }
  
  public a(InputStream paramInputStream, int paramInt)
  {
    Object localObject = j0;
    this.f = new HashMap[localObject.length];
    this.g = new HashSet(localObject.length);
    this.h = ByteOrder.BIG_ENDIAN;
    Objects.requireNonNull(paramInputStream, "inputStream cannot be null");
    this.a = null;
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramInputStream = new BufferedInputStream(paramInputStream, 5000);
      if (!H(paramInputStream))
      {
        Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
        return;
      }
      this.e = true;
      this.c = null;
      this.b = null;
    }
    else
    {
      if ((paramInputStream instanceof AssetManager.AssetInputStream)) {}
      for (this.c = ((AssetManager.AssetInputStream)paramInputStream);; this.c = null)
      {
        this.b = null;
        break;
        if ((paramInputStream instanceof FileInputStream))
        {
          localObject = (FileInputStream)paramInputStream;
          if (O(((FileInputStream)localObject).getFD()))
          {
            this.c = null;
            this.b = ((FileInputStream)localObject).getFD();
            break;
          }
        }
      }
    }
    T(paramInputStream);
  }
  
  public a(String paramString)
  {
    e[][] arrayOfe = j0;
    this.f = new HashMap[arrayOfe.length];
    this.g = new HashSet(arrayOfe.length);
    this.h = ByteOrder.BIG_ENDIAN;
    Objects.requireNonNull(paramString, "filename cannot be null");
    G(paramString);
  }
  
  private void C(b paramb)
  {
    Object localObject;
    if (v)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWebpAttributes starting with: ");
      ((StringBuilder)localObject).append(paramb);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    paramb.mark(0);
    paramb.B(ByteOrder.LITTLE_ENDIAN);
    paramb.skipBytes(L.length);
    int i3 = paramb.readInt() + 8;
    int i1 = paramb.skipBytes(M.length) + 8;
    try
    {
      for (;;)
      {
        localObject = new byte[4];
        if (paramb.read((byte[])localObject) != 4) {
          break label274;
        }
        int i2 = paramb.readInt();
        int i4 = i1 + 4 + 4;
        if (Arrays.equals(N, (byte[])localObject))
        {
          byte[] arrayOfByte = new byte[i2];
          if (paramb.read(arrayOfByte) == i2)
          {
            this.p = i4;
            X(arrayOfByte, 0);
            j0(new b(arrayOfByte));
            return;
          }
          paramb = new StringBuilder();
          paramb.append("Failed to read given length for given PNG chunk type: ");
          paramb.append(b((byte[])localObject));
          throw new IOException(paramb.toString());
        }
        i1 = i2;
        if (i2 % 2 == 1) {
          i1 = i2 + 1;
        }
        i2 = i4 + i1;
        if (i2 == i3) {
          return;
        }
        if (i2 > i3) {
          break label263;
        }
        i2 = paramb.skipBytes(i1);
        if (i2 != i1) {
          break;
        }
        i1 = i4 + i2;
      }
      throw new IOException("Encountered WebP file with invalid chunk size");
      label263:
      throw new IOException("Encountered WebP file with invalid chunk size");
      label274:
      throw new IOException("Encountered invalid length while parsing WebP chunktype");
    }
    catch (EOFException paramb)
    {
      label285:
      break label285;
    }
    throw new IOException("Encountered corrupt WebP file.");
  }
  
  private static Pair<Integer, Integer> D(String paramString)
  {
    boolean bool = paramString.contains(",");
    int i1 = 1;
    Integer localInteger1 = Integer.valueOf(2);
    Integer localInteger2 = Integer.valueOf(-1);
    Object localObject;
    if (bool)
    {
      String[] arrayOfString = paramString.split(",", -1);
      localObject = D(arrayOfString[0]);
      paramString = (String)localObject;
      if (((Integer)((Pair)localObject).first).intValue() == 2) {
        return localObject;
      }
      while (i1 < arrayOfString.length)
      {
        localObject = D(arrayOfString[i1]);
        int i2;
        if ((!((Integer)((Pair)localObject).first).equals(paramString.first)) && (!((Integer)((Pair)localObject).second).equals(paramString.first))) {
          i2 = -1;
        } else {
          i2 = ((Integer)paramString.first).intValue();
        }
        int i3;
        if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)((Pair)localObject).first).equals(paramString.second)) || (((Integer)((Pair)localObject).second).equals(paramString.second)))) {
          i3 = ((Integer)paramString.second).intValue();
        } else {
          i3 = -1;
        }
        if ((i2 == -1) && (i3 == -1)) {
          return new Pair(localInteger1, localInteger2);
        }
        if (i2 == -1) {
          paramString = new Pair(Integer.valueOf(i3), localInteger2);
        } else if (i3 == -1) {
          paramString = new Pair(Integer.valueOf(i2), localInteger2);
        }
        i1 += 1;
      }
      return paramString;
    }
    if (paramString.contains("/"))
    {
      paramString = paramString.split("/", -1);
      if (paramString.length != 2) {}
    }
    try
    {
      l1 = Double.parseDouble(paramString[0]);
      l2 = Double.parseDouble(paramString[1]);
      if (l1 < 0L) {
        break label368;
      }
      if (l2 >= 0L) {
        break label534;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1;
        long l2;
        label368:
        label509:
        continue;
        label487:
        if (l1 <= 2147483647L) {
          if (l2 <= 2147483647L) {}
        }
      }
    }
    return new Pair(Integer.valueOf(10), Integer.valueOf(5));
    return new Pair(Integer.valueOf(5), localInteger2);
    paramString = new Pair(Integer.valueOf(10), localInteger2);
    return paramString;
    return new Pair(localInteger1, localInteger2);
    try
    {
      localObject = Long.valueOf(Long.parseLong(paramString));
      if ((((Long)localObject).longValue() >= 0L) && (((Long)localObject).longValue() <= 65535L)) {
        return new Pair(Integer.valueOf(3), Integer.valueOf(4));
      }
      if (((Long)localObject).longValue() < 0L) {
        return new Pair(Integer.valueOf(9), localInteger2);
      }
      localObject = new Pair(Integer.valueOf(4), localInteger2);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label487;
    }
    try
    {
      Double.parseDouble(paramString);
      paramString = new Pair(Integer.valueOf(12), localInteger2);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      break label509;
    }
    return new Pair(localInteger1, localInteger2);
  }
  
  private void E(b paramb, HashMap paramHashMap)
  {
    d locald = (d)paramHashMap.get("JPEGInterchangeFormat");
    paramHashMap = (d)paramHashMap.get("JPEGInterchangeFormatLength");
    if ((locald != null) && (paramHashMap != null))
    {
      int i2 = locald.m(this.h);
      int i3 = paramHashMap.m(this.h);
      int i1 = i2;
      if (this.d == 7) {
        i1 = i2 + this.q;
      }
      i2 = Math.min(i3, paramb.a() - i1);
      if ((i1 > 0) && (i2 > 0))
      {
        this.i = true;
        if ((this.a == null) && (this.c == null) && (this.b == null))
        {
          paramHashMap = new byte[i2];
          paramb.skip(i1);
          paramb.read(paramHashMap);
          this.n = paramHashMap;
        }
        this.l = i1;
        this.m = i2;
      }
      if (v)
      {
        paramb = new StringBuilder();
        paramb.append("Setting thumbnail attributes with offset: ");
        paramb.append(i1);
        paramb.append(", length: ");
        paramb.append(i2);
        Log.d("ExifInterface", paramb.toString());
      }
    }
  }
  
  private void F(b paramb, HashMap paramHashMap)
  {
    Object localObject1 = (d)paramHashMap.get("StripOffsets");
    Object localObject2 = (d)paramHashMap.get("StripByteCounts");
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramHashMap = g(((d)localObject1).o(this.h));
      localObject1 = g(((d)localObject2).o(this.h));
      if ((paramHashMap != null) && (paramHashMap.length != 0))
      {
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          if (paramHashMap.length != localObject1.length)
          {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
          }
          long l1 = 0L;
          int i2 = localObject1.length;
          int i1 = 0;
          while (i1 < i2)
          {
            l1 += localObject1[i1];
            i1 += 1;
          }
          int i5 = (int)l1;
          localObject2 = new byte[i5];
          this.k = true;
          this.j = true;
          this.i = true;
          int i4 = 0;
          i1 = i4;
          i2 = i1;
          int i3 = i1;
          i1 = i4;
          while (i1 < paramHashMap.length)
          {
            int i6 = (int)paramHashMap[i1];
            i4 = (int)localObject1[i1];
            if ((i1 < paramHashMap.length - 1) && (i6 + i4 != paramHashMap[(i1 + 1)])) {
              this.k = false;
            }
            i6 -= i3;
            if (i6 < 0)
            {
              Log.d("ExifInterface", "Invalid strip offset value");
              return;
            }
            l1 = i6;
            if (paramb.skip(l1) != l1)
            {
              paramb = new StringBuilder();
              paramb.append("Failed to skip ");
              paramb.append(i6);
              paramb.append(" bytes.");
              Log.d("ExifInterface", paramb.toString());
              return;
            }
            byte[] arrayOfByte = new byte[i4];
            if (paramb.read(arrayOfByte) != i4)
            {
              paramb = new StringBuilder();
              paramb.append("Failed to read ");
              paramb.append(i4);
              paramb.append(" bytes.");
              Log.d("ExifInterface", paramb.toString());
              return;
            }
            i3 = i3 + i6 + i4;
            System.arraycopy(arrayOfByte, 0, localObject2, i2, i4);
            i2 += i4;
            i1 += 1;
          }
          this.n = ((byte[])localObject2);
          if (this.k)
          {
            this.l = ((int)paramHashMap[0]);
            this.m = i5;
          }
        }
        else
        {
          Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
        }
      }
      else {
        Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
      }
    }
  }
  
  /* Error */
  private void G(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 871
    //   4: invokestatic 836	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 853	h1/a:c	Landroid/content/res/AssetManager$AssetInputStream;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 838	h1/a:a	Ljava/lang/String;
    //   20: new 859	java/io/FileInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 1076	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 863	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   33: invokestatic 866	h1/a:O	(Ljava/io/FileDescriptor;)Z
    //   36: ifeq +14 -> 50
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 863	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   44: putfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   47: goto +8 -> 55
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 868	h1/a:T	(Ljava/io/InputStream;)V
    //   60: aload_1
    //   61: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   64: return
    //   65: astore_2
    //   66: goto +6 -> 72
    //   69: astore_2
    //   70: aload_3
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	a
    //   0	78	1	paramString	String
    //   65	1	2	localObject1	Object
    //   69	8	2	localObject2	Object
    //   9	62	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	47	65	finally
    //   50	55	65	finally
    //   55	60	65	finally
    //   20	29	69	finally
  }
  
  private static boolean H(BufferedInputStream paramBufferedInputStream)
  {
    byte[] arrayOfByte = s0;
    paramBufferedInputStream.mark(arrayOfByte.length);
    arrayOfByte = new byte[arrayOfByte.length];
    paramBufferedInputStream.read(arrayOfByte);
    paramBufferedInputStream.reset();
    int i1 = 0;
    for (;;)
    {
      paramBufferedInputStream = s0;
      if (i1 >= paramBufferedInputStream.length) {
        break;
      }
      if (arrayOfByte[i1] != paramBufferedInputStream[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  /* Error */
  private boolean I(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 13
    //   6: new 8	h1/a$b
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 929	h1/a$b:<init>	([B)V
    //   14: astore 14
    //   16: aload 14
    //   18: invokevirtual 911	h1/a$b:readInt	()I
    //   21: i2l
    //   22: lstore 6
    //   24: iconst_4
    //   25: newarray byte
    //   27: astore 13
    //   29: aload 14
    //   31: aload 13
    //   33: invokevirtual 917	java/io/InputStream:read	([B)I
    //   36: pop
    //   37: aload 13
    //   39: getstatic 161	h1/a:C	[B
    //   42: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   45: istore 12
    //   47: iload 12
    //   49: ifne +10 -> 59
    //   52: aload 14
    //   54: invokevirtual 1090	java/io/InputStream:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: ldc2_w 1091
    //   62: lstore 8
    //   64: lload 6
    //   66: lconst_1
    //   67: lcmp
    //   68: ifne +30 -> 98
    //   71: aload 14
    //   73: invokevirtual 1095	h1/a$b:readLong	()J
    //   76: lstore 10
    //   78: lload 10
    //   80: lstore 6
    //   82: lload 10
    //   84: ldc2_w 1091
    //   87: lcmp
    //   88: ifge +15 -> 103
    //   91: aload 14
    //   93: invokevirtual 1090	java/io/InputStream:close	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: ldc2_w 1096
    //   101: lstore 8
    //   103: lload 6
    //   105: lstore 10
    //   107: lload 6
    //   109: aload_1
    //   110: arraylength
    //   111: i2l
    //   112: lcmp
    //   113: ifle +10 -> 123
    //   116: aload_1
    //   117: arraylength
    //   118: istore_2
    //   119: iload_2
    //   120: i2l
    //   121: lstore 10
    //   123: lload 10
    //   125: lload 8
    //   127: lsub
    //   128: lstore 8
    //   130: lload 8
    //   132: ldc2_w 1096
    //   135: lcmp
    //   136: ifge +10 -> 146
    //   139: aload 14
    //   141: invokevirtual 1090	java/io/InputStream:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: iconst_4
    //   147: newarray byte
    //   149: astore_1
    //   150: lconst_0
    //   151: lstore 6
    //   153: iconst_0
    //   154: istore_2
    //   155: iload_2
    //   156: istore_3
    //   157: lload 6
    //   159: lload 8
    //   161: ldc2_w 1098
    //   164: ldiv
    //   165: lcmp
    //   166: ifge +115 -> 281
    //   169: aload 14
    //   171: aload_1
    //   172: invokevirtual 917	java/io/InputStream:read	([B)I
    //   175: istore 4
    //   177: iload 4
    //   179: iconst_4
    //   180: if_icmpeq +10 -> 190
    //   183: aload 14
    //   185: invokevirtual 1090	java/io/InputStream:close	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: lload 6
    //   192: lconst_1
    //   193: lcmp
    //   194: ifne +9 -> 203
    //   197: iload_3
    //   198: istore 5
    //   200: goto +69 -> 269
    //   203: aload_1
    //   204: getstatic 166	h1/a:D	[B
    //   207: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   210: ifeq +9 -> 219
    //   213: iconst_1
    //   214: istore 4
    //   216: goto +25 -> 241
    //   219: aload_1
    //   220: getstatic 171	h1/a:E	[B
    //   223: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   226: istore 12
    //   228: iload_2
    //   229: istore 4
    //   231: iload 12
    //   233: ifeq +8 -> 241
    //   236: iconst_1
    //   237: istore_3
    //   238: iload_2
    //   239: istore 4
    //   241: iload 4
    //   243: istore_2
    //   244: iload_3
    //   245: istore 5
    //   247: iload 4
    //   249: ifeq +20 -> 269
    //   252: iload 4
    //   254: istore_2
    //   255: iload_3
    //   256: istore 5
    //   258: iload_3
    //   259: ifeq +10 -> 269
    //   262: aload 14
    //   264: invokevirtual 1090	java/io/InputStream:close	()V
    //   267: iconst_1
    //   268: ireturn
    //   269: lload 6
    //   271: lconst_1
    //   272: ladd
    //   273: lstore 6
    //   275: iload 5
    //   277: istore_3
    //   278: goto -121 -> 157
    //   281: aload 14
    //   283: invokevirtual 1090	java/io/InputStream:close	()V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore_1
    //   289: aload 14
    //   291: astore 13
    //   293: goto +57 -> 350
    //   296: astore 13
    //   298: aload 14
    //   300: astore_1
    //   301: aload 13
    //   303: astore 14
    //   305: goto +12 -> 317
    //   308: astore_1
    //   309: goto +41 -> 350
    //   312: astore 14
    //   314: aload 15
    //   316: astore_1
    //   317: aload_1
    //   318: astore 13
    //   320: getstatic 135	h1/a:v	Z
    //   323: ifeq +17 -> 340
    //   326: aload_1
    //   327: astore 13
    //   329: ldc 127
    //   331: ldc_w 1101
    //   334: aload 14
    //   336: invokestatic 1104	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   339: pop
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 1090	java/io/InputStream:close	()V
    //   348: iconst_0
    //   349: ireturn
    //   350: aload 13
    //   352: ifnull +8 -> 360
    //   355: aload 13
    //   357: invokevirtual 1090	java/io/InputStream:close	()V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	a
    //   0	362	1	paramArrayOfByte	byte[]
    //   118	137	2	i1	int
    //   156	122	3	i2	int
    //   175	78	4	i3	int
    //   198	78	5	i4	int
    //   22	252	6	l1	long
    //   62	98	8	l2	long
    //   76	48	10	l3	long
    //   45	187	12	bool	boolean
    //   4	288	13	localObject1	Object
    //   296	6	13	localException1	Exception
    //   318	38	13	arrayOfByte	byte[]
    //   14	290	14	localObject2	Object
    //   312	23	14	localException2	Exception
    //   1	314	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	47	288	finally
    //   71	78	288	finally
    //   107	119	288	finally
    //   146	150	288	finally
    //   157	177	288	finally
    //   203	213	288	finally
    //   219	228	288	finally
    //   16	47	296	java/lang/Exception
    //   71	78	296	java/lang/Exception
    //   107	119	296	java/lang/Exception
    //   146	150	296	java/lang/Exception
    //   157	177	296	java/lang/Exception
    //   203	213	296	java/lang/Exception
    //   219	228	296	java/lang/Exception
    //   6	16	308	finally
    //   320	326	308	finally
    //   329	340	308	finally
    //   6	16	312	java/lang/Exception
  }
  
  private static boolean J(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    for (;;)
    {
      byte[] arrayOfByte = B;
      if (i1 >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i1] != arrayOfByte[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  /* Error */
  private boolean K(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 8	h1/a$b
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 929	h1/a$b:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 1107	h1/a:W	(Lh1/a$b;)Ljava/nio/ByteOrder;
    //   22: astore 4
    //   24: aload_0
    //   25: aload 4
    //   27: putfield 828	h1/a:h	Ljava/nio/ByteOrder;
    //   30: aload_1
    //   31: aload 4
    //   33: invokevirtual 903	h1/a$b:B	(Ljava/nio/ByteOrder;)V
    //   36: aload_1
    //   37: invokevirtual 1111	h1/a$b:readShort	()S
    //   40: istore_2
    //   41: iload_2
    //   42: sipush 20306
    //   45: if_icmpeq +10 -> 55
    //   48: iload_2
    //   49: sipush 21330
    //   52: if_icmpne +5 -> 57
    //   55: iconst_1
    //   56: istore_3
    //   57: aload_1
    //   58: invokevirtual 1090	java/io/InputStream:close	()V
    //   61: iload_3
    //   62: ireturn
    //   63: astore 4
    //   65: goto +11 -> 76
    //   68: goto +19 -> 87
    //   71: astore 4
    //   73: aload 5
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 1090	java/io/InputStream:close	()V
    //   84: aload 4
    //   86: athrow
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 1090	java/io/InputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_1
    //   98: aload 4
    //   100: astore_1
    //   101: goto -14 -> 87
    //   104: astore 4
    //   106: goto -38 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramArrayOfByte	byte[]
    //   40	13	2	i1	int
    //   1	61	3	bool	boolean
    //   3	29	4	localByteOrder	ByteOrder
    //   63	1	4	localObject1	Object
    //   71	28	4	localObject2	Object
    //   104	1	4	localException	Exception
    //   6	68	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	41	63	finally
    //   8	17	71	finally
    //   8	17	97	java/lang/Exception
    //   17	41	104	java/lang/Exception
  }
  
  private boolean L(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    for (;;)
    {
      byte[] arrayOfByte = H;
      if (i1 >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i1] != arrayOfByte[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean M(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
    int i1 = 0;
    while (i1 < arrayOfByte.length)
    {
      if (paramArrayOfByte[i1] != arrayOfByte[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  /* Error */
  private boolean N(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 8	h1/a$b
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 929	h1/a$b:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 1107	h1/a:W	(Lh1/a$b;)Ljava/nio/ByteOrder;
    //   22: astore 4
    //   24: aload_0
    //   25: aload 4
    //   27: putfield 828	h1/a:h	Ljava/nio/ByteOrder;
    //   30: aload_1
    //   31: aload 4
    //   33: invokevirtual 903	h1/a$b:B	(Ljava/nio/ByteOrder;)V
    //   36: aload_1
    //   37: invokevirtual 1111	h1/a$b:readShort	()S
    //   40: istore_2
    //   41: iload_2
    //   42: bipush 85
    //   44: if_icmpne +5 -> 49
    //   47: iconst_1
    //   48: istore_3
    //   49: aload_1
    //   50: invokevirtual 1090	java/io/InputStream:close	()V
    //   53: iload_3
    //   54: ireturn
    //   55: astore 4
    //   57: goto +11 -> 68
    //   60: goto +19 -> 79
    //   63: astore 4
    //   65: aload 5
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 1090	java/io/InputStream:close	()V
    //   76: aload 4
    //   78: athrow
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 1090	java/io/InputStream:close	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_1
    //   90: aload 4
    //   92: astore_1
    //   93: goto -14 -> 79
    //   96: astore 4
    //   98: goto -38 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramArrayOfByte	byte[]
    //   40	5	2	i1	int
    //   1	53	3	bool	boolean
    //   3	29	4	localByteOrder	ByteOrder
    //   55	1	4	localObject1	Object
    //   63	28	4	localObject2	Object
    //   96	1	4	localException	Exception
    //   6	60	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	41	55	finally
    //   8	17	63	finally
    //   8	17	89	java/lang/Exception
    //   17	41	96	java/lang/Exception
  }
  
  private static boolean O(FileDescriptor paramFileDescriptor)
  {
    try
    {
      Os.lseek(paramFileDescriptor, 0L, OsConstants.SEEK_CUR);
      return true;
    }
    catch (Exception paramFileDescriptor)
    {
      label11:
      break label11;
    }
    if (v) {
      Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
    }
    return false;
  }
  
  private boolean P(HashMap paramHashMap)
  {
    Object localObject = (d)paramHashMap.get("BitsPerSample");
    if (localObject != null)
    {
      localObject = (int[])((d)localObject).o(this.h);
      int[] arrayOfInt = y;
      if (Arrays.equals(arrayOfInt, (int[])localObject)) {
        return true;
      }
      if (this.d == 3)
      {
        paramHashMap = (d)paramHashMap.get("PhotometricInterpretation");
        if (paramHashMap != null)
        {
          int i1 = paramHashMap.m(this.h);
          if (((i1 == 1) && (Arrays.equals((int[])localObject, A))) || ((i1 == 6) && (Arrays.equals((int[])localObject, arrayOfInt)))) {
            return true;
          }
        }
      }
    }
    if (v) {
      Log.d("ExifInterface", "Unsupported data type value");
    }
    return false;
  }
  
  private boolean Q()
  {
    int i1 = this.d;
    return (i1 == 4) || (i1 == 13) || (i1 == 14);
  }
  
  private boolean R(HashMap paramHashMap)
  {
    d locald = (d)paramHashMap.get("ImageLength");
    paramHashMap = (d)paramHashMap.get("ImageWidth");
    if ((locald != null) && (paramHashMap != null))
    {
      int i1 = locald.m(this.h);
      int i2 = paramHashMap.m(this.h);
      if ((i1 <= 512) && (i2 <= 512)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean S(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = L;
      if (i1 >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i1] != arrayOfByte[i1]) {
        return false;
      }
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      arrayOfByte = M;
      if (i1 >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[(L.length + i1 + 4)] != arrayOfByte[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  /* Error */
  private void T(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 1136
    //   4: invokestatic 836	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: getstatic 708	h1/a:j0	[[Lh1/a$e;
    //   14: arraylength
    //   15: if_icmpge +23 -> 38
    //   18: aload_0
    //   19: getfield 816	h1/a:f	[Ljava/util/HashMap;
    //   22: iload_2
    //   23: new 716	java/util/HashMap
    //   26: dup
    //   27: invokespecial 729	java/util/HashMap:<init>	()V
    //   30: aastore
    //   31: iload_2
    //   32: iconst_1
    //   33: iadd
    //   34: istore_2
    //   35: goto -25 -> 10
    //   38: aload_1
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 851	h1/a:e	Z
    //   45: ifne +26 -> 71
    //   48: new 840	java/io/BufferedInputStream
    //   51: dup
    //   52: aload_1
    //   53: sipush 5000
    //   56: invokespecial 841	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   59: astore 4
    //   61: aload_0
    //   62: aload_0
    //   63: aload 4
    //   65: invokespecial 1139	h1/a:t	(Ljava/io/BufferedInputStream;)I
    //   68: putfield 1016	h1/a:d	I
    //   71: new 8	h1/a$b
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 1141	h1/a$b:<init>	(Ljava/io/InputStream;)V
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 851	h1/a:e	Z
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: getfield 1016	h1/a:d	I
    //   92: tableswitch	default:+286 -> 378, 0:+194->286, 1:+194->286, 2:+194->286, 3:+194->286, 4:+172->264, 5:+194->286, 6:+194->286, 7:+164->256, 8:+194->286, 9:+144->236, 10:+124->216, 11:+194->286, 12:+116->208, 13:+96->188, 14:+76->168
    //   169: aload_1
    //   170: invokespecial 1143	h1/a:C	(Lh1/a$b;)V
    //   173: aload_0
    //   174: invokespecial 1145	h1/a:a	()V
    //   177: getstatic 135	h1/a:v	Z
    //   180: ifeq +7 -> 187
    //   183: aload_0
    //   184: invokespecial 1147	h1/a:V	()V
    //   187: return
    //   188: aload_0
    //   189: aload_1
    //   190: invokespecial 1149	h1/a:v	(Lh1/a$b;)V
    //   193: aload_0
    //   194: invokespecial 1145	h1/a:a	()V
    //   197: getstatic 135	h1/a:v	Z
    //   200: ifeq +7 -> 207
    //   203: aload_0
    //   204: invokespecial 1147	h1/a:V	()V
    //   207: return
    //   208: aload_0
    //   209: aload_1
    //   210: invokespecial 1151	h1/a:q	(Lh1/a$b;)V
    //   213: goto +86 -> 299
    //   216: aload_0
    //   217: aload_1
    //   218: invokespecial 1153	h1/a:y	(Lh1/a$b;)V
    //   221: aload_0
    //   222: invokespecial 1145	h1/a:a	()V
    //   225: getstatic 135	h1/a:v	Z
    //   228: ifeq +7 -> 235
    //   231: aload_0
    //   232: invokespecial 1147	h1/a:V	()V
    //   235: return
    //   236: aload_0
    //   237: aload_1
    //   238: invokespecial 1155	h1/a:w	(Lh1/a$b;)V
    //   241: aload_0
    //   242: invokespecial 1145	h1/a:a	()V
    //   245: getstatic 135	h1/a:v	Z
    //   248: ifeq +7 -> 255
    //   251: aload_0
    //   252: invokespecial 1147	h1/a:V	()V
    //   255: return
    //   256: aload_0
    //   257: aload_1
    //   258: invokespecial 1157	h1/a:u	(Lh1/a$b;)V
    //   261: goto +38 -> 299
    //   264: aload_0
    //   265: aload_1
    //   266: iconst_0
    //   267: iconst_0
    //   268: invokespecial 1160	h1/a:r	(Lh1/a$b;II)V
    //   271: aload_0
    //   272: invokespecial 1145	h1/a:a	()V
    //   275: getstatic 135	h1/a:v	Z
    //   278: ifeq +7 -> 285
    //   281: aload_0
    //   282: invokespecial 1147	h1/a:V	()V
    //   285: return
    //   286: aload_0
    //   287: aload_1
    //   288: invokespecial 1162	h1/a:x	(Lh1/a$b;)V
    //   291: goto +8 -> 299
    //   294: aload_0
    //   295: aload_1
    //   296: invokespecial 1164	h1/a:z	(Lh1/a$b;)V
    //   299: aload_1
    //   300: aload_0
    //   301: getfield 923	h1/a:p	I
    //   304: i2l
    //   305: invokevirtual 1167	h1/a$b:i	(J)V
    //   308: aload_0
    //   309: aload_1
    //   310: invokespecial 931	h1/a:j0	(Lh1/a$b;)V
    //   313: aload_0
    //   314: invokespecial 1145	h1/a:a	()V
    //   317: getstatic 135	h1/a:v	Z
    //   320: ifeq +41 -> 361
    //   323: goto +34 -> 357
    //   326: astore_1
    //   327: goto +35 -> 362
    //   330: astore_1
    //   331: getstatic 135	h1/a:v	Z
    //   334: istore_3
    //   335: iload_3
    //   336: ifeq +13 -> 349
    //   339: ldc 127
    //   341: ldc_w 1169
    //   344: aload_1
    //   345: invokestatic 1171	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   348: pop
    //   349: aload_0
    //   350: invokespecial 1145	h1/a:a	()V
    //   353: iload_3
    //   354: ifeq +7 -> 361
    //   357: aload_0
    //   358: invokespecial 1147	h1/a:V	()V
    //   361: return
    //   362: aload_0
    //   363: invokespecial 1145	h1/a:a	()V
    //   366: getstatic 135	h1/a:v	Z
    //   369: ifeq +7 -> 376
    //   372: aload_0
    //   373: invokespecial 1147	h1/a:V	()V
    //   376: aload_1
    //   377: athrow
    //   378: goto -79 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	a
    //   0	381	1	paramInputStream	InputStream
    //   9	26	2	i1	int
    //   334	20	3	bool	boolean
    //   39	37	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	31	326	finally
    //   41	71	326	finally
    //   71	168	326	finally
    //   168	173	326	finally
    //   188	193	326	finally
    //   208	213	326	finally
    //   216	221	326	finally
    //   236	241	326	finally
    //   256	261	326	finally
    //   264	271	326	finally
    //   286	291	326	finally
    //   294	299	326	finally
    //   299	313	326	finally
    //   331	335	326	finally
    //   339	349	326	finally
    //   10	31	330	java/io/IOException
    //   41	71	330	java/io/IOException
    //   71	168	330	java/io/IOException
    //   168	173	330	java/io/IOException
    //   188	193	330	java/io/IOException
    //   208	213	330	java/io/IOException
    //   216	221	330	java/io/IOException
    //   236	241	330	java/io/IOException
    //   256	261	330	java/io/IOException
    //   264	271	330	java/io/IOException
    //   286	291	330	java/io/IOException
    //   294	299	330	java/io/IOException
    //   299	313	330	java/io/IOException
  }
  
  private void U(b paramb, int paramInt)
  {
    ByteOrder localByteOrder = W(paramb);
    this.h = localByteOrder;
    paramb.B(localByteOrder);
    int i1 = paramb.readUnsignedShort();
    int i2 = this.d;
    if ((i2 != 7) && (i2 != 10) && (i1 != 42))
    {
      paramb = new StringBuilder();
      paramb.append("Invalid start code: ");
      paramb.append(Integer.toHexString(i1));
      throw new IOException(paramb.toString());
    }
    i1 = paramb.readInt();
    if ((i1 >= 8) && (i1 < paramInt))
    {
      paramInt = i1 - 8;
      if (paramInt > 0)
      {
        if (paramb.skipBytes(paramInt) == paramInt) {
          return;
        }
        paramb = new StringBuilder();
        paramb.append("Couldn't jump to first Ifd: ");
        paramb.append(paramInt);
        throw new IOException(paramb.toString());
      }
      return;
    }
    paramb = new StringBuilder();
    paramb.append("Invalid first Ifd offset: ");
    paramb.append(i1);
    throw new IOException(paramb.toString());
  }
  
  private void V()
  {
    int i1 = 0;
    while (i1 < this.f.length)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("The size of tag group[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("]: ");
      ((StringBuilder)localObject).append(this.f[i1].size());
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
      localObject = this.f[i1].entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        d locald = (d)localEntry.getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tagName: ");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(", tagType: ");
        localStringBuilder.append(locald.toString());
        localStringBuilder.append(", tagValue: '");
        localStringBuilder.append(locald.n(this.h));
        localStringBuilder.append("'");
        Log.d("ExifInterface", localStringBuilder.toString());
      }
      i1 += 1;
    }
  }
  
  private ByteOrder W(b paramb)
  {
    int i1 = paramb.readShort();
    if (i1 != 18761)
    {
      if (i1 == 19789)
      {
        if (v) {
          Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
      }
      paramb = new StringBuilder();
      paramb.append("Invalid byte order: ");
      paramb.append(Integer.toHexString(i1));
      throw new IOException(paramb.toString());
    }
    if (v) {
      Log.d("ExifInterface", "readExifSegment: Byte Align II");
    }
    return ByteOrder.LITTLE_ENDIAN;
  }
  
  private void X(byte[] paramArrayOfByte, int paramInt)
  {
    b localb = new b(paramArrayOfByte);
    U(localb, paramArrayOfByte.length);
    Y(localb, paramInt);
  }
  
  private void Y(b paramb, int paramInt)
  {
    this.g.add(Integer.valueOf(paramb.d));
    if (paramb.d + 2 > paramb.c) {
      return;
    }
    int i3 = paramb.readShort();
    boolean bool = v;
    Object localObject1 = "ExifInterface";
    Object localObject2;
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("numberOfDirectoryEntry: ");
      ((StringBuilder)localObject2).append(i3);
      Log.d("ExifInterface", ((StringBuilder)localObject2).toString());
    }
    if (paramb.d + i3 * 12 <= paramb.c)
    {
      if (i3 <= 0) {
        return;
      }
      int i4 = 0;
      long l1;
      for (;;)
      {
        int i5 = paramInt;
        if (i4 >= i3) {
          break;
        }
        int i8 = paramb.readUnsignedShort();
        int i2 = paramb.readUnsignedShort();
        int i7 = paramb.readInt();
        long l3 = paramb.g() + 4L;
        Object localObject3 = (e)n0[i5].get(Integer.valueOf(i8));
        bool = v;
        if (bool)
        {
          if (localObject3 != null) {
            localObject2 = ((e)localObject3).b;
          } else {
            localObject2 = null;
          }
          Log.d((String)localObject1, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i8), localObject2, Integer.valueOf(i2), Integer.valueOf(i7) }));
        }
        if (localObject3 == null) {
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Skip the tag entry since tag number is not defined: ");
            ((StringBuilder)localObject2).append(i8);
          }
        }
        for (;;)
        {
          Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
          do
          {
            break label548;
            if (i2 <= 0) {
              break label506;
            }
            localObject2 = X;
            if (i2 >= localObject2.length) {
              break label506;
            }
            if (((e)localObject3).a(i2)) {
              break;
            }
          } while (!bool);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Skip the tag entry since data format (");
          ((StringBuilder)localObject2).append(W[i2]);
          ((StringBuilder)localObject2).append(") is unexpected for tag: ");
          ((StringBuilder)localObject2).append(((e)localObject3).b);
        }
        int i1 = i2;
        if (i2 == 7) {
          i1 = ((e)localObject3).c;
        }
        long l2 = i7 * localObject2[i1];
        if ((l2 >= 0L) && (l2 <= 2147483647L))
        {
          i2 = 1;
          l1 = l2;
        }
        else
        {
          l1 = l2;
          i2 = i1;
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Skip the tag entry since the number of components is invalid: ");
            ((StringBuilder)localObject2).append(i7);
            Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
            l1 = l2;
            i2 = i1;
            break label551;
            label506:
            if (bool)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Skip the tag entry since data format is invalid: ");
              ((StringBuilder)localObject2).append(i2);
              Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
            }
            label548:
            l1 = 0L;
          }
          label551:
          int i6 = 0;
          i1 = i2;
          i2 = i6;
        }
        localObject2 = localObject1;
        if (i2 == 0)
        {
          paramb.i(l3);
        }
        else
        {
          Object localObject4;
          if (l1 > 4L)
          {
            i2 = paramb.readInt();
            if (bool)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("seek to data offset: ");
              ((StringBuilder)localObject1).append(i2);
              Log.d((String)localObject2, ((StringBuilder)localObject1).toString());
            }
            if (this.d == 7) {
              if ("MakerNote".equals(((e)localObject3).b))
              {
                this.q = i2;
              }
              else if ((i5 == 6) && ("ThumbnailImage".equals(((e)localObject3).b)))
              {
                this.r = i2;
                this.s = i7;
                localObject1 = d.j(6, this.h);
                localObject4 = d.f(this.r, this.h);
                d locald = d.f(this.s, this.h);
                this.f[4].put("Compression", localObject1);
                this.f[4].put("JPEGInterchangeFormat", localObject4);
                this.f[4].put("JPEGInterchangeFormatLength", locald);
              }
            }
            l2 = i2;
            if (l2 + l1 <= paramb.c)
            {
              paramb.i(l2);
            }
            else if (bool)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Skip the tag entry since data offset is invalid: ");
              ((StringBuilder)localObject1).append(i2);
              localObject1 = ((StringBuilder)localObject1).toString();
              Log.d((String)localObject2, (String)localObject1);
            }
          }
          label1027:
          label1186:
          label1227:
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  paramb.i(l3);
                  break label1403;
                  localObject1 = (Integer)q0.get(Integer.valueOf(i8));
                  if (bool)
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("nextIfdType: ");
                    ((StringBuilder)localObject4).append(localObject1);
                    ((StringBuilder)localObject4).append(" byteCount: ");
                    ((StringBuilder)localObject4).append(l1);
                    Log.d((String)localObject2, ((StringBuilder)localObject4).toString());
                  }
                  if (localObject1 == null) {
                    break label1227;
                  }
                  l1 = -1L;
                  if (i1 != 3)
                  {
                    if (i1 != 4)
                    {
                      if (i1 != 8)
                      {
                        if ((i1 != 9) && (i1 != 13)) {
                          break label1027;
                        }
                        i1 = paramb.readInt();
                      }
                      else
                      {
                        i1 = paramb.readShort();
                      }
                    }
                    else
                    {
                      l1 = paramb.h();
                      break label1027;
                    }
                  }
                  else {
                    i1 = paramb.readUnsignedShort();
                  }
                  l1 = i1;
                  if (bool) {
                    Log.d((String)localObject2, String.format("Offset: %d, tagName: %s", new Object[] { Long.valueOf(l1), ((e)localObject3).b }));
                  }
                  if ((l1 <= 0L) || (l1 >= paramb.c)) {
                    break label1186;
                  }
                  if (this.g.contains(Integer.valueOf((int)l1))) {
                    break;
                  }
                  paramb.i(l1);
                  Y(paramb, ((Integer)localObject1).intValue());
                }
              } while (!bool);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Skip jump into the IFD since it has already been read: IfdType ");
              ((StringBuilder)localObject3).append(localObject1);
              ((StringBuilder)localObject3).append(" (at ");
              ((StringBuilder)localObject3).append(l1);
              ((StringBuilder)localObject3).append(")");
              localObject1 = ((StringBuilder)localObject3).toString();
              break;
            } while (!bool);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Skip jump into the IFD since its offset is invalid: ");
            ((StringBuilder)localObject1).append(l1);
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
            i2 = paramb.g();
            i5 = this.p;
            localObject1 = new byte[(int)l1];
            paramb.readFully((byte[])localObject1);
            localObject1 = new d(i1, i7, i2 + i5, (byte[])localObject1);
            this.f[paramInt].put(((e)localObject3).b, localObject1);
            if ("DNGVersion".equals(((e)localObject3).b)) {
              this.d = 3;
            }
            if (((!"Make".equals(((e)localObject3).b)) && (!"Model".equals(((e)localObject3).b))) || ((((d)localObject1).n(this.h).contains("PENTAX")) || (("Compression".equals(((e)localObject3).b)) && (((d)localObject1).m(this.h) == 65535)))) {
              this.d = 8;
            }
          } while (paramb.g() != l3);
        }
        label1403:
        i4 = (short)(i4 + 1);
        localObject1 = localObject2;
      }
      if (paramb.g() + 4 <= paramb.c)
      {
        paramInt = paramb.readInt();
        bool = v;
        if (bool) {
          Log.d((String)localObject1, String.format("nextIfdOffset: %d", new Object[] { Integer.valueOf(paramInt) }));
        }
        l1 = paramInt;
        if ((l1 > 0L) && (paramInt < paramb.c))
        {
          if (!this.g.contains(Integer.valueOf(paramInt)))
          {
            paramb.i(l1);
            if (this.f[4].isEmpty())
            {
              Y(paramb, 4);
              return;
            }
            if (!this.f[5].isEmpty()) {
              return;
            }
            Y(paramb, 5);
            return;
          }
          if (!bool) {
            return;
          }
          paramb = new StringBuilder();
          localObject2 = "Stop reading file since re-reading an IFD may cause an infinite loop: ";
        }
        else
        {
          if (!bool) {
            return;
          }
          paramb = new StringBuilder();
          localObject2 = "Stop reading file since a wrong offset may cause an infinite loop: ";
        }
        paramb.append((String)localObject2);
        paramb.append(paramInt);
        Log.d((String)localObject1, paramb.toString());
      }
    }
  }
  
  private void Z(String paramString)
  {
    int i1 = 0;
    while (i1 < j0.length)
    {
      this.f[i1].remove(paramString);
      i1 += 1;
    }
  }
  
  private void a()
  {
    String str = m("DateTimeOriginal");
    if ((str != null) && (m("DateTime") == null)) {
      this.f[0].put("DateTime", d.e(str));
    }
    if (m("ImageWidth") == null) {
      this.f[0].put("ImageWidth", d.f(0L, this.h));
    }
    if (m("ImageLength") == null) {
      this.f[0].put("ImageLength", d.f(0L, this.h));
    }
    if (m("Orientation") == null) {
      this.f[0].put("Orientation", d.f(0L, this.h));
    }
    if (m("LightSource") == null) {
      this.f[1].put("LightSource", d.f(0L, this.h));
    }
  }
  
  private void a0(b paramb, int paramInt)
  {
    Object localObject = (d)this.f[paramInt].get("ImageLength");
    d locald = (d)this.f[paramInt].get("ImageWidth");
    if ((localObject == null) || (locald == null))
    {
      localObject = (d)this.f[paramInt].get("JPEGInterchangeFormat");
      locald = (d)this.f[paramInt].get("JPEGInterchangeFormatLength");
      if ((localObject != null) && (locald != null))
      {
        int i1 = ((d)localObject).m(this.h);
        int i2 = ((d)localObject).m(this.h);
        paramb.i(i1);
        localObject = new byte[i2];
        paramb.read((byte[])localObject);
        r(new b((byte[])localObject), i1, paramInt);
      }
    }
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i1]) }));
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void c(FileDescriptor paramFileDescriptor)
  {
    try
    {
      Os.close(paramFileDescriptor);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      label5:
      break label5;
    }
    Log.e("ExifInterface", "Error closing fd.");
  }
  
  private void c0(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (v)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveJpegAttributes starting with (inputStream: ");
      ((StringBuilder)localObject).append(paramInputStream);
      ((StringBuilder)localObject).append(", outputStream: ");
      ((StringBuilder)localObject).append(paramOutputStream);
      ((StringBuilder)localObject).append(")");
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    Object localObject = new DataInputStream(paramInputStream);
    c localc = new c(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (((DataInputStream)localObject).readByte() == -1)
    {
      localc.g(-1);
      if (((DataInputStream)localObject).readByte() == -40)
      {
        localc.g(-40);
        paramOutputStream = null;
        paramInputStream = paramOutputStream;
        if (m("Xmp") != null)
        {
          paramInputStream = paramOutputStream;
          if (this.u) {
            paramInputStream = (d)this.f[0].remove("Xmp");
          }
        }
        localc.g(-1);
        localc.g(-31);
        o0(localc);
        if (paramInputStream != null) {
          this.f[0].put("Xmp", paramInputStream);
        }
        paramInputStream = new byte[4096];
        while (((DataInputStream)localObject).readByte() == -1)
        {
          int i1 = ((DataInputStream)localObject).readByte();
          if ((i1 != -39) && (i1 != -38))
          {
            int i2;
            if (i1 != -31)
            {
              localc.g(-1);
              localc.g(i1);
              i1 = ((DataInputStream)localObject).readUnsignedShort();
              localc.d0(i1);
              i1 -= 2;
              if (i1 >= 0) {
                for (;;)
                {
                  if (i1 <= 0) {
                    break label310;
                  }
                  i2 = ((DataInputStream)localObject).read(paramInputStream, 0, Math.min(i1, 4096));
                  if (i2 < 0) {
                    break;
                  }
                  localc.write(paramInputStream, 0, i2);
                  i1 -= i2;
                }
              } else {
                label310:
                throw new IOException("Invalid length");
              }
            }
            else
            {
              i2 = ((DataInputStream)localObject).readUnsignedShort() - 2;
              if (i2 >= 0)
              {
                paramOutputStream = new byte[6];
                if (i2 >= 6) {
                  if (((DataInputStream)localObject).read(paramOutputStream) == 6)
                  {
                    if (Arrays.equals(paramOutputStream, s0))
                    {
                      i1 = i2 - 6;
                      if (((DataInputStream)localObject).skipBytes(i1) == i1) {
                        continue;
                      }
                      throw new IOException("Invalid length");
                    }
                  }
                  else {
                    throw new IOException("Invalid exif");
                  }
                }
                localc.g(-1);
                localc.g(i1);
                localc.d0(i2 + 2);
                i1 = i2;
                if (i2 >= 6)
                {
                  i1 = i2 - 6;
                  localc.write(paramOutputStream);
                }
                for (;;)
                {
                  if (i1 <= 0) {
                    break label494;
                  }
                  i2 = ((DataInputStream)localObject).read(paramInputStream, 0, Math.min(i1, 4096));
                  if (i2 < 0) {
                    break;
                  }
                  localc.write(paramInputStream, 0, i2);
                  i1 -= i2;
                }
              }
              else
              {
                label494:
                throw new IOException("Invalid length");
              }
            }
          }
          else
          {
            localc.g(-1);
            localc.g(i1);
            h((InputStream)localObject, localc);
            return;
          }
        }
        throw new IOException("Invalid marker");
      }
      throw new IOException("Invalid marker");
    }
    throw new IOException("Invalid marker");
  }
  
  private static void d(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private void d0(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: getstatic 135	h1/a:v	Z
    //   3: ifeq +64 -> 67
    //   6: new 878	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 879	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 1403
    //   20: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 888	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc_w 1356
    //   36: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_2
    //   43: invokevirtual 888	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc_w 1307
    //   52: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 127
    //   58: aload 4
    //   60: invokevirtual 892	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 894	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: new 1358	java/io/DataInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 1359	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore 4
    //   77: getstatic 826	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   80: astore 6
    //   82: new 11	h1/a$c
    //   85: dup
    //   86: aload_2
    //   87: aload 6
    //   89: invokespecial 1362	h1/a$c:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   92: astore 5
    //   94: getstatic 192	h1/a:H	[B
    //   97: astore_1
    //   98: aload 4
    //   100: aload 5
    //   102: aload_1
    //   103: arraylength
    //   104: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   107: aload_0
    //   108: getfield 923	h1/a:p	I
    //   111: istore_3
    //   112: iload_3
    //   113: ifne +30 -> 143
    //   116: aload 4
    //   118: invokevirtual 1407	java/io/DataInputStream:readInt	()I
    //   121: istore_3
    //   122: aload 5
    //   124: iload_3
    //   125: invokevirtual 1409	h1/a$c:h	(I)V
    //   128: aload 4
    //   130: aload 5
    //   132: iload_3
    //   133: iconst_4
    //   134: iadd
    //   135: iconst_4
    //   136: iadd
    //   137: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   140: goto +33 -> 173
    //   143: aload 4
    //   145: aload 5
    //   147: iload_3
    //   148: aload_1
    //   149: arraylength
    //   150: isub
    //   151: iconst_4
    //   152: isub
    //   153: iconst_4
    //   154: isub
    //   155: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   158: aload 4
    //   160: aload 4
    //   162: invokevirtual 1407	java/io/DataInputStream:readInt	()I
    //   165: iconst_4
    //   166: iadd
    //   167: iconst_4
    //   168: iadd
    //   169: invokevirtual 1387	java/io/DataInputStream:skipBytes	(I)I
    //   172: pop
    //   173: aconst_null
    //   174: astore_2
    //   175: new 1411	java/io/ByteArrayOutputStream
    //   178: dup
    //   179: invokespecial 1412	java/io/ByteArrayOutputStream:<init>	()V
    //   182: astore_1
    //   183: new 11	h1/a$c
    //   186: dup
    //   187: aload_1
    //   188: aload 6
    //   190: invokespecial 1362	h1/a$c:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   193: astore_2
    //   194: aload_0
    //   195: aload_2
    //   196: invokespecial 1373	h1/a:o0	(Lh1/a$c;)I
    //   199: pop
    //   200: aload_2
    //   201: getfield 1415	h1/a$c:a	Ljava/io/OutputStream;
    //   204: checkcast 1411	java/io/ByteArrayOutputStream
    //   207: invokevirtual 1419	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   210: astore_2
    //   211: aload 5
    //   213: aload_2
    //   214: invokevirtual 1391	h1/a$c:write	([B)V
    //   217: new 1421	java/util/zip/CRC32
    //   220: dup
    //   221: invokespecial 1422	java/util/zip/CRC32:<init>	()V
    //   224: astore 6
    //   226: aload 6
    //   228: aload_2
    //   229: iconst_4
    //   230: aload_2
    //   231: arraylength
    //   232: iconst_4
    //   233: isub
    //   234: invokevirtual 1425	java/util/zip/CRC32:update	([BII)V
    //   237: aload 5
    //   239: aload 6
    //   241: invokevirtual 1427	java/util/zip/CRC32:getValue	()J
    //   244: l2i
    //   245: invokevirtual 1409	h1/a$c:h	(I)V
    //   248: aload_1
    //   249: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   252: aload 4
    //   254: aload 5
    //   256: invokestatic 1394	h1/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   259: pop
    //   260: return
    //   261: astore_2
    //   262: goto +10 -> 272
    //   265: astore 4
    //   267: aload_2
    //   268: astore_1
    //   269: aload 4
    //   271: astore_2
    //   272: aload_1
    //   273: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   276: aload_2
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	a
    //   0	278	1	paramInputStream	InputStream
    //   0	278	2	paramOutputStream	OutputStream
    //   111	40	3	i1	int
    //   13	240	4	localObject1	Object
    //   265	5	4	localObject2	Object
    //   92	163	5	localc	c
    //   80	160	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   183	248	261	finally
    //   175	183	265	finally
  }
  
  private String e(double paramDouble)
  {
    long l1 = paramDouble;
    paramDouble -= l1;
    long l2 = (paramDouble * 60.0D);
    long l3 = Math.round((paramDouble - l2 / 60.0D) * 3600.0D * 10000000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("/1,");
    localStringBuilder.append(l2);
    localStringBuilder.append("/1,");
    localStringBuilder.append(l3);
    localStringBuilder.append("/10000000");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void e0(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: getstatic 135	h1/a:v	Z
    //   3: ifeq +64 -> 67
    //   6: new 878	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 879	java/lang/StringBuilder:<init>	()V
    //   13: astore 10
    //   15: aload 10
    //   17: ldc_w 1444
    //   20: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 10
    //   26: aload_1
    //   27: invokevirtual 888	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 10
    //   33: ldc_w 1356
    //   36: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 10
    //   42: aload_2
    //   43: invokevirtual 888	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 10
    //   49: ldc_w 1307
    //   52: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 127
    //   58: aload 10
    //   60: invokevirtual 892	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 894	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: getstatic 900	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   70: astore 14
    //   72: new 8	h1/a$b
    //   75: dup
    //   76: aload_1
    //   77: aload 14
    //   79: invokespecial 1447	h1/a$b:<init>	(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V
    //   82: astore 12
    //   84: new 11	h1/a$c
    //   87: dup
    //   88: aload_2
    //   89: aload 14
    //   91: invokespecial 1362	h1/a$c:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   94: astore 13
    //   96: getstatic 206	h1/a:L	[B
    //   99: astore 15
    //   101: aload 12
    //   103: aload 13
    //   105: aload 15
    //   107: arraylength
    //   108: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   111: getstatic 210	h1/a:M	[B
    //   114: astore 16
    //   116: aload 12
    //   118: aload 16
    //   120: arraylength
    //   121: iconst_4
    //   122: iadd
    //   123: invokevirtual 907	h1/a$b:skipBytes	(I)I
    //   126: pop
    //   127: aconst_null
    //   128: astore 11
    //   130: aconst_null
    //   131: astore_2
    //   132: new 1411	java/io/ByteArrayOutputStream
    //   135: dup
    //   136: invokespecial 1412	java/io/ByteArrayOutputStream:<init>	()V
    //   139: astore 10
    //   141: new 11	h1/a$c
    //   144: dup
    //   145: aload 10
    //   147: aload 14
    //   149: invokespecial 1362	h1/a$c:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   152: astore_2
    //   153: aload_0
    //   154: getfield 923	h1/a:p	I
    //   157: istore_3
    //   158: iload_3
    //   159: ifeq +51 -> 210
    //   162: aload 12
    //   164: aload_2
    //   165: iload_3
    //   166: aload 15
    //   168: arraylength
    //   169: iconst_4
    //   170: iadd
    //   171: aload 16
    //   173: arraylength
    //   174: iadd
    //   175: isub
    //   176: iconst_4
    //   177: isub
    //   178: iconst_4
    //   179: isub
    //   180: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   183: aload 12
    //   185: iconst_4
    //   186: invokevirtual 907	h1/a$b:skipBytes	(I)I
    //   189: pop
    //   190: aload 12
    //   192: aload 12
    //   194: invokevirtual 911	h1/a$b:readInt	()I
    //   197: invokevirtual 907	h1/a$b:skipBytes	(I)I
    //   200: pop
    //   201: aload_0
    //   202: aload_2
    //   203: invokespecial 1373	h1/a:o0	(Lh1/a$c;)I
    //   206: pop
    //   207: goto +607 -> 814
    //   210: iconst_4
    //   211: newarray byte
    //   213: astore 11
    //   215: aload 12
    //   217: aload 11
    //   219: invokevirtual 917	java/io/InputStream:read	([B)I
    //   222: iconst_4
    //   223: if_icmpne +636 -> 859
    //   226: getstatic 233	h1/a:P	[B
    //   229: astore 14
    //   231: aload 11
    //   233: aload 14
    //   235: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   238: istore 9
    //   240: iconst_1
    //   241: istore 5
    //   243: iload 9
    //   245: ifeq +156 -> 401
    //   248: aload 12
    //   250: invokevirtual 911	h1/a$b:readInt	()I
    //   253: istore 4
    //   255: iload 4
    //   257: iconst_2
    //   258: irem
    //   259: iconst_1
    //   260: if_icmpne +650 -> 910
    //   263: iload 4
    //   265: iconst_1
    //   266: iadd
    //   267: istore_3
    //   268: goto +3 -> 271
    //   271: iload_3
    //   272: newarray byte
    //   274: astore 11
    //   276: aload 12
    //   278: aload 11
    //   280: invokevirtual 917	java/io/InputStream:read	([B)I
    //   283: pop
    //   284: aload 11
    //   286: iconst_0
    //   287: bipush 8
    //   289: aload 11
    //   291: iconst_0
    //   292: baload
    //   293: ior
    //   294: i2b
    //   295: bastore
    //   296: aload 11
    //   298: iconst_0
    //   299: baload
    //   300: iconst_1
    //   301: ishr
    //   302: iconst_1
    //   303: iand
    //   304: iconst_1
    //   305: if_icmpne +611 -> 916
    //   308: iload 5
    //   310: istore_3
    //   311: goto +3 -> 314
    //   314: aload_2
    //   315: aload 14
    //   317: invokevirtual 1391	h1/a$c:write	([B)V
    //   320: aload_2
    //   321: iload 4
    //   323: invokevirtual 1409	h1/a$c:h	(I)V
    //   326: aload_2
    //   327: aload 11
    //   329: invokevirtual 1391	h1/a$c:write	([B)V
    //   332: iload_3
    //   333: ifeq +52 -> 385
    //   336: aload_0
    //   337: aload 12
    //   339: aload_2
    //   340: getstatic 245	h1/a:S	[B
    //   343: aconst_null
    //   344: invokespecial 1450	h1/a:j	(Lh1/a$b;Lh1/a$c;[B[B)V
    //   347: iconst_4
    //   348: newarray byte
    //   350: astore 11
    //   352: aload_1
    //   353: aload 11
    //   355: invokevirtual 917	java/io/InputStream:read	([B)I
    //   358: pop
    //   359: aload 11
    //   361: getstatic 249	h1/a:T	[B
    //   364: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   367: ifne +6 -> 373
    //   370: goto -169 -> 201
    //   373: aload_0
    //   374: aload 12
    //   376: aload_2
    //   377: aload 11
    //   379: invokespecial 1453	h1/a:k	(Lh1/a$b;Lh1/a$c;[B)V
    //   382: goto -35 -> 347
    //   385: aload_0
    //   386: aload 12
    //   388: aload_2
    //   389: getstatic 241	h1/a:R	[B
    //   392: getstatic 237	h1/a:Q	[B
    //   395: invokespecial 1450	h1/a:j	(Lh1/a$b;Lh1/a$c;[B[B)V
    //   398: goto -197 -> 201
    //   401: getstatic 241	h1/a:R	[B
    //   404: astore_1
    //   405: aload 11
    //   407: aload_1
    //   408: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   411: ifne +14 -> 425
    //   414: aload 11
    //   416: getstatic 237	h1/a:Q	[B
    //   419: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   422: ifeq +392 -> 814
    //   425: aload 12
    //   427: invokevirtual 911	h1/a$b:readInt	()I
    //   430: istore 8
    //   432: iload 8
    //   434: iconst_2
    //   435: irem
    //   436: iconst_1
    //   437: if_icmpne +484 -> 921
    //   440: iload 8
    //   442: iconst_1
    //   443: iadd
    //   444: istore_3
    //   445: goto +3 -> 448
    //   448: iconst_3
    //   449: newarray byte
    //   451: astore 15
    //   453: aload 11
    //   455: aload_1
    //   456: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   459: ifeq +86 -> 545
    //   462: aload 12
    //   464: aload 15
    //   466: invokevirtual 917	java/io/InputStream:read	([B)I
    //   469: pop
    //   470: iconst_3
    //   471: newarray byte
    //   473: astore 16
    //   475: aload 12
    //   477: aload 16
    //   479: invokevirtual 917	java/io/InputStream:read	([B)I
    //   482: iconst_3
    //   483: if_icmpne +51 -> 534
    //   486: getstatic 217	h1/a:O	[B
    //   489: aload 16
    //   491: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   494: ifeq +40 -> 534
    //   497: aload 12
    //   499: invokevirtual 911	h1/a$b:readInt	()I
    //   502: istore 4
    //   504: iload 4
    //   506: bipush 18
    //   508: ishl
    //   509: bipush 18
    //   511: ishr
    //   512: istore 5
    //   514: iload 4
    //   516: iconst_2
    //   517: ishl
    //   518: bipush 18
    //   520: ishr
    //   521: istore 6
    //   523: iload_3
    //   524: bipush 10
    //   526: isub
    //   527: istore_3
    //   528: iconst_0
    //   529: istore 7
    //   531: goto +90 -> 621
    //   534: new 938	java/io/IOException
    //   537: dup
    //   538: ldc_w 1455
    //   541: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   544: athrow
    //   545: aload 11
    //   547: getstatic 237	h1/a:Q	[B
    //   550: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   553: ifeq +374 -> 927
    //   556: aload 12
    //   558: invokevirtual 1456	h1/a$b:readByte	()B
    //   561: bipush 47
    //   563: if_icmpne +47 -> 610
    //   566: aload 12
    //   568: invokevirtual 911	h1/a$b:readInt	()I
    //   571: istore 4
    //   573: iload 4
    //   575: bipush 8
    //   577: iand
    //   578: istore 7
    //   580: iload_3
    //   581: iconst_5
    //   582: isub
    //   583: istore_3
    //   584: iload 4
    //   586: iconst_4
    //   587: ishl
    //   588: bipush 18
    //   590: ishr
    //   591: iconst_1
    //   592: iadd
    //   593: istore 6
    //   595: iload 4
    //   597: bipush 18
    //   599: ishl
    //   600: bipush 18
    //   602: ishr
    //   603: iconst_1
    //   604: iadd
    //   605: istore 5
    //   607: goto +14 -> 621
    //   610: new 938	java/io/IOException
    //   613: dup
    //   614: ldc_w 1458
    //   617: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   620: athrow
    //   621: aload_2
    //   622: aload 14
    //   624: invokevirtual 1391	h1/a$c:write	([B)V
    //   627: aload_2
    //   628: bipush 10
    //   630: invokevirtual 1409	h1/a$c:h	(I)V
    //   633: bipush 10
    //   635: newarray byte
    //   637: astore 14
    //   639: aload 14
    //   641: iconst_0
    //   642: aload 14
    //   644: iconst_0
    //   645: baload
    //   646: bipush 8
    //   648: ior
    //   649: i2b
    //   650: bastore
    //   651: aload 14
    //   653: iconst_0
    //   654: aload 14
    //   656: iconst_0
    //   657: baload
    //   658: iload 7
    //   660: iconst_4
    //   661: ishl
    //   662: ior
    //   663: i2b
    //   664: bastore
    //   665: iload 5
    //   667: iconst_1
    //   668: isub
    //   669: istore 5
    //   671: iload 6
    //   673: iconst_1
    //   674: isub
    //   675: istore 6
    //   677: aload 14
    //   679: iconst_4
    //   680: iload 5
    //   682: i2b
    //   683: bastore
    //   684: aload 14
    //   686: iconst_5
    //   687: iload 5
    //   689: bipush 8
    //   691: ishr
    //   692: i2b
    //   693: bastore
    //   694: aload 14
    //   696: bipush 6
    //   698: iload 5
    //   700: bipush 16
    //   702: ishr
    //   703: i2b
    //   704: bastore
    //   705: aload 14
    //   707: bipush 7
    //   709: iload 6
    //   711: i2b
    //   712: bastore
    //   713: aload 14
    //   715: bipush 8
    //   717: iload 6
    //   719: bipush 8
    //   721: ishr
    //   722: i2b
    //   723: bastore
    //   724: aload 14
    //   726: bipush 9
    //   728: iload 6
    //   730: bipush 16
    //   732: ishr
    //   733: i2b
    //   734: bastore
    //   735: aload_2
    //   736: aload 14
    //   738: invokevirtual 1391	h1/a$c:write	([B)V
    //   741: aload_2
    //   742: aload 11
    //   744: invokevirtual 1391	h1/a$c:write	([B)V
    //   747: aload_2
    //   748: iload 8
    //   750: invokevirtual 1409	h1/a$c:h	(I)V
    //   753: aload 11
    //   755: aload_1
    //   756: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   759: ifeq +25 -> 784
    //   762: aload_2
    //   763: aload 15
    //   765: invokevirtual 1391	h1/a$c:write	([B)V
    //   768: aload_2
    //   769: getstatic 217	h1/a:O	[B
    //   772: invokevirtual 1391	h1/a$c:write	([B)V
    //   775: aload_2
    //   776: iload 4
    //   778: invokevirtual 1409	h1/a$c:h	(I)V
    //   781: goto +23 -> 804
    //   784: aload 11
    //   786: getstatic 237	h1/a:Q	[B
    //   789: invokestatic 921	java/util/Arrays:equals	([B[B)Z
    //   792: ifeq +12 -> 804
    //   795: aload_2
    //   796: bipush 47
    //   798: invokevirtual 1462	java/io/FilterOutputStream:write	(I)V
    //   801: goto -26 -> 775
    //   804: aload 12
    //   806: aload_2
    //   807: iload_3
    //   808: invokestatic 1406	h1/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   811: goto -610 -> 201
    //   814: aload 12
    //   816: aload_2
    //   817: invokestatic 1394	h1/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   820: pop
    //   821: aload 10
    //   823: invokevirtual 1463	java/io/ByteArrayOutputStream:size	()I
    //   826: istore_3
    //   827: getstatic 210	h1/a:M	[B
    //   830: astore_1
    //   831: aload 13
    //   833: iload_3
    //   834: aload_1
    //   835: arraylength
    //   836: iadd
    //   837: invokevirtual 1409	h1/a$c:h	(I)V
    //   840: aload 13
    //   842: aload_1
    //   843: invokevirtual 1391	h1/a$c:write	([B)V
    //   846: aload 10
    //   848: aload 13
    //   850: invokevirtual 1467	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   853: aload 10
    //   855: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   858: return
    //   859: new 938	java/io/IOException
    //   862: dup
    //   863: ldc_w 1469
    //   866: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   869: athrow
    //   870: astore_1
    //   871: aload 10
    //   873: astore_2
    //   874: goto +30 -> 904
    //   877: astore_1
    //   878: aload 10
    //   880: astore_2
    //   881: goto +11 -> 892
    //   884: astore_1
    //   885: goto +19 -> 904
    //   888: astore_1
    //   889: aload 11
    //   891: astore_2
    //   892: new 938	java/io/IOException
    //   895: dup
    //   896: ldc_w 1471
    //   899: aload_1
    //   900: invokespecial 1474	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   903: athrow
    //   904: aload_2
    //   905: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   908: aload_1
    //   909: athrow
    //   910: iload 4
    //   912: istore_3
    //   913: goto -642 -> 271
    //   916: iconst_0
    //   917: istore_3
    //   918: goto -604 -> 314
    //   921: iload 8
    //   923: istore_3
    //   924: goto -476 -> 448
    //   927: iconst_0
    //   928: istore 4
    //   930: iload 4
    //   932: istore 5
    //   934: iload 5
    //   936: istore 6
    //   938: iload 6
    //   940: istore 7
    //   942: goto -321 -> 621
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	this	a
    //   0	945	1	paramInputStream	InputStream
    //   0	945	2	paramOutputStream	OutputStream
    //   157	767	3	i1	int
    //   253	678	4	i2	int
    //   241	694	5	i3	int
    //   521	418	6	i4	int
    //   529	412	7	i5	int
    //   430	492	8	i6	int
    //   238	6	9	bool	boolean
    //   13	866	10	localObject1	Object
    //   128	762	11	arrayOfByte1	byte[]
    //   82	733	12	localb	b
    //   94	755	13	localc	c
    //   70	667	14	localObject2	Object
    //   99	665	15	arrayOfByte2	byte[]
    //   114	376	16	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   141	158	870	finally
    //   162	201	870	finally
    //   201	207	870	finally
    //   210	240	870	finally
    //   248	255	870	finally
    //   271	284	870	finally
    //   314	332	870	finally
    //   336	347	870	finally
    //   347	370	870	finally
    //   373	382	870	finally
    //   385	398	870	finally
    //   401	425	870	finally
    //   425	432	870	finally
    //   448	504	870	finally
    //   534	545	870	finally
    //   545	573	870	finally
    //   610	621	870	finally
    //   621	639	870	finally
    //   735	775	870	finally
    //   775	781	870	finally
    //   784	801	870	finally
    //   804	811	870	finally
    //   814	853	870	finally
    //   859	870	870	finally
    //   141	158	877	java/lang/Exception
    //   162	201	877	java/lang/Exception
    //   201	207	877	java/lang/Exception
    //   210	240	877	java/lang/Exception
    //   248	255	877	java/lang/Exception
    //   271	284	877	java/lang/Exception
    //   314	332	877	java/lang/Exception
    //   336	347	877	java/lang/Exception
    //   347	370	877	java/lang/Exception
    //   373	382	877	java/lang/Exception
    //   385	398	877	java/lang/Exception
    //   401	425	877	java/lang/Exception
    //   425	432	877	java/lang/Exception
    //   448	504	877	java/lang/Exception
    //   534	545	877	java/lang/Exception
    //   545	573	877	java/lang/Exception
    //   610	621	877	java/lang/Exception
    //   621	639	877	java/lang/Exception
    //   735	775	877	java/lang/Exception
    //   775	781	877	java/lang/Exception
    //   784	801	877	java/lang/Exception
    //   804	811	877	java/lang/Exception
    //   814	853	877	java/lang/Exception
    //   859	870	877	java/lang/Exception
    //   132	141	884	finally
    //   892	904	884	finally
    //   132	141	888	java/lang/Exception
  }
  
  private static double f(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(",", -1);
      String[] arrayOfString = paramString1[0].split("/", -1);
      double d1 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      arrayOfString = paramString1[1].split("/", -1);
      double d2 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      paramString1 = paramString1[2].split("/", -1);
      double d3 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
      d1 = d1 + d2 / 60.0D + d3 / 3600.0D;
      if ((!paramString2.equals("S")) && (!paramString2.equals("W")))
      {
        if (!paramString2.equals("N"))
        {
          if (paramString2.equals("E")) {
            return d1;
          }
          throw new IllegalArgumentException();
        }
        return d1;
      }
      return -d1;
    }
    catch (NumberFormatException|ArrayIndexOutOfBoundsException paramString1)
    {
      label184:
      break label184;
    }
    throw new IllegalArgumentException();
  }
  
  private static long[] g(Object paramObject)
  {
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      long[] arrayOfLong = new long[paramObject.length];
      int i1 = 0;
      while (i1 < paramObject.length)
      {
        arrayOfLong[i1] = paramObject[i1];
        i1 += 1;
      }
      return arrayOfLong;
    }
    if ((paramObject instanceof long[])) {
      return (long[])paramObject;
    }
    return null;
  }
  
  private static int h(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    int i1 = 0;
    for (;;)
    {
      int i2 = paramInputStream.read(arrayOfByte);
      if (i2 == -1) {
        break;
      }
      i1 += i2;
      paramOutputStream.write(arrayOfByte, 0, i2);
    }
    return i1;
  }
  
  private static void i(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[8192];
    while (paramInt > 0)
    {
      int i2 = Math.min(paramInt, 8192);
      int i1 = paramInputStream.read(arrayOfByte, 0, i2);
      if (i1 == i2)
      {
        paramInt -= i1;
        paramOutputStream.write(arrayOfByte, 0, i1);
      }
      else
      {
        throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
      }
    }
  }
  
  private void j(b paramb, c paramc, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte;
    do
    {
      arrayOfByte = new byte[4];
      if (paramb.read(arrayOfByte) != 4)
      {
        paramc = new StringBuilder();
        paramc.append("Encountered invalid length while copying WebP chunks up tochunk type ");
        paramb = r0;
        paramc.append(new String(paramArrayOfByte1, paramb));
        if (paramArrayOfByte2 == null)
        {
          paramb = "";
        }
        else
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append(" or ");
          paramArrayOfByte1.append(new String(paramArrayOfByte2, paramb));
          paramb = paramArrayOfByte1.toString();
        }
        paramc.append(paramb);
        throw new IOException(paramc.toString());
      }
      k(paramb, paramc, arrayOfByte);
    } while ((!Arrays.equals(arrayOfByte, paramArrayOfByte1)) && ((paramArrayOfByte2 == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte2))));
  }
  
  private void j0(b paramb)
  {
    HashMap localHashMap = this.f[4];
    d locald = (d)localHashMap.get("Compression");
    if (locald != null)
    {
      int i1 = locald.m(this.h);
      this.o = i1;
      if (i1 != 1)
      {
        if (i1 == 6) {
          break label78;
        }
        if (i1 != 7) {
          return;
        }
      }
      if (!P(localHashMap)) {
        return;
      }
      F(paramb, localHashMap);
    }
    else
    {
      this.o = 6;
    }
    label78:
    E(paramb, localHashMap);
  }
  
  private void k(b paramb, c paramc, byte[] paramArrayOfByte)
  {
    int i2 = paramb.readInt();
    paramc.write(paramArrayOfByte);
    paramc.h(i2);
    int i1 = i2;
    if (i2 % 2 == 1) {
      i1 = i2 + 1;
    }
    i(paramb, paramc, i1);
  }
  
  private static boolean k0(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramArrayOfByte2.length)
      {
        if (paramArrayOfByte1[i1] != paramArrayOfByte2[i1]) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    return false;
  }
  
  private void l0(int paramInt1, int paramInt2)
  {
    if ((!this.f[paramInt1].isEmpty()) && (!this.f[paramInt2].isEmpty()))
    {
      Object localObject = (d)this.f[paramInt1].get("ImageLength");
      d locald1 = (d)this.f[paramInt1].get("ImageWidth");
      d locald2 = (d)this.f[paramInt2].get("ImageLength");
      d locald3 = (d)this.f[paramInt2].get("ImageWidth");
      if ((localObject != null) && (locald1 != null))
      {
        if ((locald2 != null) && (locald3 != null))
        {
          int i1 = ((d)localObject).m(this.h);
          int i2 = locald1.m(this.h);
          int i3 = locald2.m(this.h);
          int i4 = locald3.m(this.h);
          if ((i1 >= i3) || (i2 >= i4)) {
            break label237;
          }
          localObject = this.f;
          locald1 = localObject[paramInt1];
          localObject[paramInt1] = localObject[paramInt2];
          localObject[paramInt2] = locald1;
          return;
        }
        if (!v) {
          break label237;
        }
        localObject = "Second image does not contain valid size information";
      }
      else
      {
        if (!v) {
          break label237;
        }
        localObject = "First image does not contain valid size information";
      }
      Log.d("ExifInterface", (String)localObject);
      label237:
      return;
    }
    if (v) {
      Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
    }
  }
  
  private void m0(b paramb, int paramInt)
  {
    Object localObject1 = (d)this.f[paramInt].get("DefaultCropSize");
    Object localObject2 = (d)this.f[paramInt].get("SensorTopBorder");
    d locald1 = (d)this.f[paramInt].get("SensorLeftBorder");
    d locald2 = (d)this.f[paramInt].get("SensorBottomBorder");
    d locald3 = (d)this.f[paramInt].get("SensorRightBorder");
    if (localObject1 != null)
    {
      if (((d)localObject1).a == 5)
      {
        localObject2 = (f[])((d)localObject1).o(this.h);
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          paramb = d.h(localObject2[0], this.h);
          localObject1 = d.h(localObject2[1], this.h);
          break label253;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid crop size values. cropSize=");
      }
      for (paramb = Arrays.toString((Object[])localObject2);; paramb = Arrays.toString((int[])localObject2))
      {
        ((StringBuilder)localObject1).append(paramb);
        Log.w("ExifInterface", ((StringBuilder)localObject1).toString());
        return;
        localObject2 = (int[])((d)localObject1).o(this.h);
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          paramb = d.j(localObject2[0], this.h);
          localObject1 = d.j(localObject2[1], this.h);
          label253:
          this.f[paramInt].put("ImageWidth", paramb);
          this.f[paramInt].put("ImageLength", localObject1);
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid crop size values. cropSize=");
      }
    }
    if ((localObject2 != null) && (locald1 != null) && (locald2 != null) && (locald3 != null))
    {
      int i1 = ((d)localObject2).m(this.h);
      int i2 = locald2.m(this.h);
      int i3 = locald3.m(this.h);
      int i4 = locald1.m(this.h);
      if ((i2 > i1) && (i3 > i4))
      {
        paramb = d.j(i2 - i1, this.h);
        localObject1 = d.j(i3 - i4, this.h);
        this.f[paramInt].put("ImageLength", paramb);
        this.f[paramInt].put("ImageWidth", localObject1);
      }
    }
    else
    {
      a0(paramb, paramInt);
    }
  }
  
  private void n0()
  {
    l0(0, 5);
    l0(0, 4);
    l0(5, 4);
    Object localObject = (d)this.f[1].get("PixelXDimension");
    d locald = (d)this.f[1].get("PixelYDimension");
    if ((localObject != null) && (locald != null))
    {
      this.f[0].put("ImageWidth", localObject);
      this.f[0].put("ImageLength", locald);
    }
    if ((this.f[4].isEmpty()) && (R(this.f[5])))
    {
      localObject = this.f;
      localObject[4] = localObject[5];
      localObject[5] = new HashMap();
    }
    if (!R(this.f[4])) {
      Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }
  }
  
  private int o0(c paramc)
  {
    Object localObject1 = j0;
    int[] arrayOfInt = new int[localObject1.length];
    localObject1 = new int[localObject1.length];
    Object localObject2 = k0;
    int i2 = localObject2.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Z(localObject2[i1].b);
      i1 += 1;
    }
    Z(l0.b);
    Z(m0.b);
    i1 = 0;
    int i3;
    while (i1 < j0.length)
    {
      localObject2 = this.f[i1].entrySet().toArray();
      i3 = localObject2.length;
      i2 = 0;
      while (i2 < i3)
      {
        Map.Entry localEntry = (Map.Entry)localObject2[i2];
        if (localEntry.getValue() == null) {
          this.f[i1].remove(localEntry.getKey());
        }
        i2 += 1;
      }
      i1 += 1;
    }
    if (!this.f[1].isEmpty()) {
      this.f[0].put(k0[1].b, d.f(0L, this.h));
    }
    if (!this.f[2].isEmpty()) {
      this.f[0].put(k0[2].b, d.f(0L, this.h));
    }
    if (!this.f[3].isEmpty()) {
      this.f[1].put(k0[3].b, d.f(0L, this.h));
    }
    if (this.i)
    {
      this.f[4].put(l0.b, d.f(0L, this.h));
      this.f[4].put(m0.b, d.f(this.m, this.h));
    }
    i1 = 0;
    while (i1 < j0.length)
    {
      localObject2 = this.f[i1].entrySet().iterator();
      i2 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        i3 = ((d)((Map.Entry)((Iterator)localObject2).next()).getValue()).p();
        if (i3 > 4) {
          i2 += i3;
        }
      }
      localObject1[i1] += i2;
      i1 += 1;
    }
    i1 = 8;
    i2 = 0;
    while (i2 < j0.length)
    {
      i3 = i1;
      if (!this.f[i2].isEmpty())
      {
        arrayOfInt[i2] = i1;
        i3 = i1 + (this.f[i2].size() * 12 + 2 + 4 + localObject1[i2]);
      }
      i2 += 1;
      i1 = i3;
    }
    i2 = i1;
    if (this.i)
    {
      this.f[4].put(l0.b, d.f(i1, this.h));
      this.l = i1;
      i2 = i1 + this.m;
    }
    i1 = i2;
    if (this.d == 4) {
      i1 = i2 + 8;
    }
    if (v)
    {
      i2 = 0;
      while (i2 < j0.length)
      {
        Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(arrayOfInt[i2]), Integer.valueOf(this.f[i2].size()), Integer.valueOf(localObject1[i2]), Integer.valueOf(i1) }));
        i2 += 1;
      }
    }
    if (!this.f[1].isEmpty()) {
      this.f[0].put(k0[1].b, d.f(arrayOfInt[1], this.h));
    }
    if (!this.f[2].isEmpty()) {
      this.f[0].put(k0[2].b, d.f(arrayOfInt[2], this.h));
    }
    if (!this.f[3].isEmpty()) {
      this.f[1].put(k0[3].b, d.f(arrayOfInt[3], this.h));
    }
    i2 = this.d;
    if (i2 != 4)
    {
      if (i2 != 13)
      {
        if (i2 == 14)
        {
          paramc.write(N);
          paramc.h(i1);
        }
      }
      else
      {
        paramc.h(i1);
        paramc.write(I);
      }
    }
    else
    {
      paramc.d0(i1);
      paramc.write(s0);
    }
    short s1;
    if (this.h == ByteOrder.BIG_ENDIAN) {
      s1 = 19789;
    } else {
      s1 = 18761;
    }
    paramc.i(s1);
    paramc.a(this.h);
    paramc.d0(42);
    paramc.B(8L);
    i2 = 0;
    while (i2 < j0.length)
    {
      if (!this.f[i2].isEmpty())
      {
        paramc.d0(this.f[i2].size());
        i3 = arrayOfInt[i2] + 2 + this.f[i2].size() * 12 + 4;
        localObject1 = this.f[i2].entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          int i5 = ((e)o0[i2].get(((Map.Entry)localObject2).getKey())).a;
          localObject2 = (d)((Map.Entry)localObject2).getValue();
          int i4 = ((d)localObject2).p();
          paramc.d0(i5);
          paramc.d0(((d)localObject2).a);
          paramc.h(((d)localObject2).b);
          if (i4 > 4)
          {
            paramc.B(i3);
            i3 += i4;
          }
          else
          {
            paramc.write(((d)localObject2).d);
            if (i4 < 4) {
              while (i4 < 4)
              {
                paramc.g(0);
                i4 += 1;
              }
            }
          }
        }
        if ((i2 == 0) && (!this.f[4].isEmpty())) {
          paramc.B(arrayOfInt[4]);
        } else {
          paramc.B(0L);
        }
        localObject1 = this.f[i2].entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((d)((Map.Entry)((Iterator)localObject1).next()).getValue()).d;
          if (localObject2.length > 4) {
            paramc.write((byte[])localObject2, 0, localObject2.length);
          }
        }
      }
      i2 += 1;
    }
    if (this.i) {
      paramc.write(B());
    }
    if ((this.d == 14) && (i1 % 2 == 1)) {
      paramc.g(0);
    }
    paramc.a(ByteOrder.BIG_ENDIAN);
    return i1;
  }
  
  private d p(String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString))
    {
      if (v) {
        Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
      }
      str = "PhotographicSensitivity";
    }
    int i1 = 0;
    while (i1 < j0.length)
    {
      paramString = (d)this.f[i1].get(str);
      if (paramString != null) {
        return paramString;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void q(final b paramb)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(new a(paramb));
        Object localObject2 = localMediaMetadataRetriever.extractMetadata(33);
        String str3 = localMediaMetadataRetriever.extractMetadata(34);
        localObject1 = localMediaMetadataRetriever.extractMetadata(26);
        str1 = localMediaMetadataRetriever.extractMetadata(17);
        boolean bool = "yes".equals(localObject1);
        String str2 = null;
        if (bool)
        {
          str2 = localMediaMetadataRetriever.extractMetadata(29);
          str1 = localMediaMetadataRetriever.extractMetadata(30);
          localObject1 = localMediaMetadataRetriever.extractMetadata(31);
        }
        else
        {
          if (!"yes".equals(str1)) {
            break label492;
          }
          str2 = localMediaMetadataRetriever.extractMetadata(18);
          str1 = localMediaMetadataRetriever.extractMetadata(19);
          localObject1 = localMediaMetadataRetriever.extractMetadata(24);
        }
        if (str2 != null) {
          this.f[0].put("ImageWidth", d.j(Integer.parseInt(str2), this.h));
        }
        if (str1 != null) {
          this.f[0].put("ImageLength", d.j(Integer.parseInt(str1), this.h));
        }
        int i2;
        if (localObject1 != null)
        {
          i1 = 1;
          i2 = Integer.parseInt((String)localObject1);
          if (i2 == 90) {
            break label513;
          }
          if (i2 == 180) {
            break label508;
          }
          if (i2 == 270) {
            break label502;
          }
          this.f[0].put("Orientation", d.j(i1, this.h));
        }
        if ((localObject2 != null) && (str3 != null))
        {
          i1 = Integer.parseInt((String)localObject2);
          i2 = Integer.parseInt(str3);
          if (i2 > 6)
          {
            paramb.i(i1);
            localObject2 = new byte[6];
            if (paramb.read((byte[])localObject2) == 6)
            {
              i2 -= 6;
              if (Arrays.equals((byte[])localObject2, s0))
              {
                localObject2 = new byte[i2];
                if (paramb.read((byte[])localObject2) == i2)
                {
                  this.p = (i1 + 6);
                  X((byte[])localObject2, 0);
                }
                else
                {
                  throw new IOException("Can't read exif");
                }
              }
              else
              {
                throw new IOException("Invalid identifier");
              }
            }
            else
            {
              throw new IOException("Can't read identifier");
            }
          }
          else
          {
            throw new IOException("Invalid exif length");
          }
        }
        if (v)
        {
          paramb = new StringBuilder();
          paramb.append("Heif meta: ");
          paramb.append(str2);
          paramb.append("x");
          paramb.append(str1);
          paramb.append(", rotation ");
          paramb.append((String)localObject1);
          Log.d("ExifInterface", paramb.toString());
        }
        return;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      label492:
      String str1 = null;
      Object localObject1 = str1;
      continue;
      label502:
      int i1 = 8;
      continue;
      label508:
      i1 = 3;
      continue;
      label513:
      i1 = 6;
    }
  }
  
  private void r(b paramb, int paramInt1, int paramInt2)
  {
    boolean bool = v;
    String str = "ExifInterface";
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJpegAttributes starting with: ");
      ((StringBuilder)localObject).append(paramb);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    paramb.mark(0);
    paramb.B(ByteOrder.BIG_ENDIAN);
    int i1 = paramb.readByte();
    if (i1 == -1)
    {
      if (paramb.readByte() == -40)
      {
        int i2;
        for (i1 = 2;; i1 = i2 + i1)
        {
          i2 = paramb.readByte();
          if (i2 != -1) {
            break label796;
          }
          int i4 = paramb.readByte();
          bool = v;
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Found JPEG segment indicator: ");
            ((StringBuilder)localObject).append(Integer.toHexString(i4 & 0xFF));
            Log.d(str, ((StringBuilder)localObject).toString());
          }
          if ((i4 == -39) || (i4 == -38)) {
            break label787;
          }
          int i3 = paramb.readUnsignedShort() - 2;
          i2 = i1 + 1 + 1 + 2;
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("JPEG segment: ");
            ((StringBuilder)localObject).append(Integer.toHexString(i4 & 0xFF));
            ((StringBuilder)localObject).append(" (length: ");
            ((StringBuilder)localObject).append(i3 + 2);
            ((StringBuilder)localObject).append(")");
            Log.d(str, ((StringBuilder)localObject).toString());
          }
          if (i3 < 0) {
            break label776;
          }
          if (i4 != -31)
          {
            if (i4 != -2) {
              switch (i4)
              {
              default: 
                switch (i4)
                {
                default: 
                  switch (i4)
                  {
                  default: 
                    switch (i4)
                    {
                    default: 
                      i1 = i3;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
            }
            for (;;)
            {
              break label728;
              if (paramb.skipBytes(1) == 1)
              {
                this.f[paramInt2].put("ImageLength", d.f(paramb.readUnsignedShort(), this.h));
                this.f[paramInt2].put("ImageWidth", d.f(paramb.readUnsignedShort(), this.h));
                i1 = i3 - 5;
              }
              else
              {
                throw new IOException("Invalid SOFx");
                localObject = new byte[i3];
                if (paramb.read((byte[])localObject) != i3) {
                  break;
                }
                if (m("UserComment") == null) {
                  this.f[1].put("UserComment", d.e(new String((byte[])localObject, r0)));
                }
                i1 = 0;
              }
            }
            throw new IOException("Invalid exif");
          }
          localObject = new byte[i3];
          paramb.readFully((byte[])localObject);
          byte[] arrayOfByte = s0;
          if (k0((byte[])localObject, arrayOfByte))
          {
            localObject = Arrays.copyOfRange((byte[])localObject, arrayOfByte.length, i3);
            this.p = (paramInt1 + i2 + arrayOfByte.length);
            X((byte[])localObject, paramInt2);
            j0(new b((byte[])localObject));
          }
          else
          {
            arrayOfByte = t0;
            if (k0((byte[])localObject, arrayOfByte))
            {
              i1 = arrayOfByte.length;
              localObject = Arrays.copyOfRange((byte[])localObject, arrayOfByte.length, i3);
              if (m("Xmp") == null)
              {
                this.f[0].put("Xmp", new d(1, localObject.length, i2 + i1, (byte[])localObject));
                this.u = true;
              }
            }
          }
          i2 += i3;
          i1 = 0;
          label728:
          if (i1 < 0) {
            break label765;
          }
          if (paramb.skipBytes(i1) != i1) {
            break;
          }
        }
        throw new IOException("Invalid JPEG segment");
        label765:
        throw new IOException("Invalid length");
        label776:
        throw new IOException("Invalid length");
        label787:
        paramb.B(this.h);
        return;
        label796:
        paramb = new StringBuilder();
        paramb.append("Invalid marker:");
        paramb.append(Integer.toHexString(i2 & 0xFF));
        throw new IOException(paramb.toString());
      }
      paramb = new StringBuilder();
      paramb.append("Invalid marker: ");
      paramb.append(Integer.toHexString(i1 & 0xFF));
      throw new IOException(paramb.toString());
    }
    paramb = new StringBuilder();
    paramb.append("Invalid marker: ");
    paramb.append(Integer.toHexString(i1 & 0xFF));
    throw new IOException(paramb.toString());
  }
  
  private int t(BufferedInputStream paramBufferedInputStream)
  {
    paramBufferedInputStream.mark(5000);
    byte[] arrayOfByte = new byte[5000];
    paramBufferedInputStream.read(arrayOfByte);
    paramBufferedInputStream.reset();
    if (J(arrayOfByte)) {
      return 4;
    }
    if (M(arrayOfByte)) {
      return 9;
    }
    if (I(arrayOfByte)) {
      return 12;
    }
    if (K(arrayOfByte)) {
      return 7;
    }
    if (N(arrayOfByte)) {
      return 10;
    }
    if (L(arrayOfByte)) {
      return 13;
    }
    if (S(arrayOfByte)) {
      return 14;
    }
    return 0;
  }
  
  private void u(b paramb)
  {
    x(paramb);
    paramb = (d)this.f[1].get("MakerNote");
    if (paramb != null)
    {
      paramb = new b(paramb.d);
      paramb.B(this.h);
      Object localObject = F;
      byte[] arrayOfByte1 = new byte[localObject.length];
      paramb.readFully(arrayOfByte1);
      paramb.i(0L);
      byte[] arrayOfByte2 = G;
      byte[] arrayOfByte3 = new byte[arrayOfByte2.length];
      paramb.readFully(arrayOfByte3);
      if (Arrays.equals(arrayOfByte1, (byte[])localObject)) {}
      for (long l1 = 8L;; l1 = 12L)
      {
        paramb.i(l1);
        break;
        if (!Arrays.equals(arrayOfByte3, arrayOfByte2)) {
          break;
        }
      }
      Y(paramb, 6);
      paramb = (d)this.f[7].get("PreviewImageStart");
      localObject = (d)this.f[7].get("PreviewImageLength");
      if ((paramb != null) && (localObject != null))
      {
        this.f[5].put("JPEGInterchangeFormat", paramb);
        this.f[5].put("JPEGInterchangeFormatLength", localObject);
      }
      paramb = (d)this.f[8].get("AspectFrame");
      if (paramb != null)
      {
        paramb = (int[])paramb.o(this.h);
        if ((paramb != null) && (paramb.length == 4))
        {
          if ((paramb[2] > paramb[0]) && (paramb[3] > paramb[1]))
          {
            int i4 = paramb[2] - paramb[0] + 1;
            int i3 = paramb[3] - paramb[1] + 1;
            int i2 = i4;
            int i1 = i3;
            if (i4 < i3)
            {
              i2 = i4 + i3;
              i1 = i2 - i3;
              i2 -= i1;
            }
            paramb = d.j(i2, this.h);
            localObject = d.j(i1, this.h);
            this.f[0].put("ImageWidth", paramb);
            this.f[0].put("ImageLength", localObject);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid aspect frame values. frame=");
          ((StringBuilder)localObject).append(Arrays.toString(paramb));
          Log.w("ExifInterface", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void v(b paramb)
  {
    if (v)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPngAttributes starting with: ");
      ((StringBuilder)localObject).append(paramb);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    paramb.mark(0);
    paramb.B(ByteOrder.BIG_ENDIAN);
    Object localObject = H;
    paramb.skipBytes(localObject.length);
    int i1 = localObject.length + 0;
    try
    {
      for (;;)
      {
        int i2 = paramb.readInt();
        localObject = new byte[4];
        if (paramb.read((byte[])localObject) != 4) {
          break;
        }
        i1 = i1 + 4 + 4;
        if ((i1 == 16) && (!Arrays.equals((byte[])localObject, J))) {
          throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
        }
        if (Arrays.equals((byte[])localObject, K)) {
          return;
        }
        if (Arrays.equals((byte[])localObject, I))
        {
          byte[] arrayOfByte = new byte[i2];
          if (paramb.read(arrayOfByte) == i2)
          {
            i2 = paramb.readInt();
            paramb = new CRC32();
            paramb.update((byte[])localObject);
            paramb.update(arrayOfByte);
            if ((int)paramb.getValue() == i2)
            {
              this.p = i1;
              X(arrayOfByte, 0);
              n0();
              j0(new b(arrayOfByte));
              return;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
            ((StringBuilder)localObject).append(i2);
            ((StringBuilder)localObject).append(", calculated CRC value: ");
            ((StringBuilder)localObject).append(paramb.getValue());
            throw new IOException(((StringBuilder)localObject).toString());
          }
          paramb = new StringBuilder();
          paramb.append("Failed to read given length for given PNG chunk type: ");
          paramb.append(b((byte[])localObject));
          throw new IOException(paramb.toString());
        }
        i2 += 4;
        paramb.skipBytes(i2);
        i1 += i2;
      }
      throw new IOException("Encountered invalid length while parsing PNG chunktype");
    }
    catch (EOFException paramb)
    {
      label355:
      break label355;
    }
    throw new IOException("Encountered corrupt PNG file.");
  }
  
  private void w(b paramb)
  {
    boolean bool = v;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRafAttributes starting with: ");
      ((StringBuilder)localObject).append(paramb);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    paramb.mark(0);
    paramb.skipBytes(84);
    Object localObject = new byte[4];
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    paramb.read((byte[])localObject);
    paramb.read(arrayOfByte1);
    paramb.read(arrayOfByte2);
    int i1 = ByteBuffer.wrap((byte[])localObject).getInt();
    int i2 = ByteBuffer.wrap(arrayOfByte1).getInt();
    int i3 = ByteBuffer.wrap(arrayOfByte2).getInt();
    localObject = new byte[i2];
    paramb.i(i1);
    paramb.read((byte[])localObject);
    r(new b((byte[])localObject), i1, 5);
    paramb.i(i3);
    paramb.B(ByteOrder.BIG_ENDIAN);
    i2 = paramb.readInt();
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("numberOfDirectoryEntry: ");
      ((StringBuilder)localObject).append(i2);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    i1 = 0;
    while (i1 < i2)
    {
      i3 = paramb.readUnsignedShort();
      int i4 = paramb.readUnsignedShort();
      if (i3 == e0.a)
      {
        i1 = paramb.readShort();
        i2 = paramb.readShort();
        paramb = d.j(i1, this.h);
        localObject = d.j(i2, this.h);
        this.f[0].put("ImageLength", paramb);
        this.f[0].put("ImageWidth", localObject);
        if (v)
        {
          paramb = new StringBuilder();
          paramb.append("Updated to length: ");
          paramb.append(i1);
          paramb.append(", width: ");
          paramb.append(i2);
          Log.d("ExifInterface", paramb.toString());
        }
        return;
      }
      paramb.skipBytes(i4);
      i1 += 1;
    }
  }
  
  private void x(b paramb)
  {
    U(paramb, paramb.available());
    Y(paramb, 0);
    m0(paramb, 0);
    m0(paramb, 5);
    m0(paramb, 4);
    n0();
    if (this.d == 8)
    {
      paramb = (d)this.f[1].get("MakerNote");
      if (paramb != null)
      {
        paramb = new b(paramb.d);
        paramb.B(this.h);
        paramb.i(6L);
        Y(paramb, 9);
        paramb = (d)this.f[9].get("ColorSpace");
        if (paramb != null) {
          this.f[1].put("ColorSpace", paramb);
        }
      }
    }
  }
  
  private void y(b paramb)
  {
    if (v)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRw2Attributes starting with: ");
      ((StringBuilder)localObject).append(paramb);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    x(paramb);
    paramb = (d)this.f[0].get("JpgFromRaw");
    if (paramb != null) {
      r(new b(paramb.d), (int)paramb.c, 5);
    }
    paramb = (d)this.f[0].get("ISO");
    Object localObject = (d)this.f[1].get("PhotographicSensitivity");
    if ((paramb != null) && (localObject == null)) {
      this.f[1].put("PhotographicSensitivity", paramb);
    }
  }
  
  private void z(b paramb)
  {
    byte[] arrayOfByte1 = s0;
    paramb.skipBytes(arrayOfByte1.length);
    byte[] arrayOfByte2 = new byte[paramb.available()];
    paramb.readFully(arrayOfByte2);
    this.p = arrayOfByte1.length;
    X(arrayOfByte2, 0);
  }
  
  public byte[] A()
  {
    int i1 = this.o;
    if ((i1 != 6) && (i1 != 7)) {
      return null;
    }
    return B();
  }
  
  /* Error */
  public byte[] B()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1028	h1/a:i	Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: iload_3
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_0
    //   15: getfield 1034	h1/a:n	[B
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull +6 -> 28
    //   25: aload 6
    //   27: areturn
    //   28: aload_0
    //   29: getfield 853	h1/a:c	Landroid/content/res/AssetManager$AssetInputStream;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnull +51 -> 87
    //   39: aload 6
    //   41: invokevirtual 1688	java/io/InputStream:markSupported	()Z
    //   44: ifeq +11 -> 55
    //   47: aload 6
    //   49: invokevirtual 1689	java/io/InputStream:reset	()V
    //   52: goto +380 -> 432
    //   55: ldc 127
    //   57: ldc_w 1691
    //   60: invokestatic 894	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload 6
    //   66: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: astore 7
    //   73: aconst_null
    //   74: astore 10
    //   76: goto +338 -> 414
    //   79: astore 8
    //   81: aconst_null
    //   82: astore 7
    //   84: goto +288 -> 372
    //   87: aload_0
    //   88: getfield 838	h1/a:a	Ljava/lang/String;
    //   91: ifnull +19 -> 110
    //   94: new 859	java/io/FileInputStream
    //   97: dup
    //   98: aload_0
    //   99: getfield 838	h1/a:a	Ljava/lang/String;
    //   102: invokespecial 1076	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   105: astore 6
    //   107: goto +325 -> 432
    //   110: aload_0
    //   111: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   114: invokestatic 1695	android/system/Os:dup	(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
    //   117: astore 6
    //   119: aload 6
    //   121: lconst_0
    //   122: getstatic 1698	android/system/OsConstants:SEEK_SET	I
    //   125: invokestatic 1124	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   128: pop2
    //   129: new 859	java/io/FileInputStream
    //   132: dup
    //   133: aload 6
    //   135: invokespecial 1700	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   138: astore 7
    //   140: aload 7
    //   142: astore 8
    //   144: aload 6
    //   146: astore 7
    //   148: aload 8
    //   150: astore 6
    //   152: aload 6
    //   154: astore 9
    //   156: aload 7
    //   158: astore 10
    //   160: aload 6
    //   162: aload_0
    //   163: getfield 1036	h1/a:l	I
    //   166: aload_0
    //   167: getfield 923	h1/a:p	I
    //   170: iadd
    //   171: i2l
    //   172: invokevirtual 1032	java/io/InputStream:skip	(J)J
    //   175: lstore 4
    //   177: aload 6
    //   179: astore 9
    //   181: aload 7
    //   183: astore 10
    //   185: aload_0
    //   186: getfield 1036	h1/a:l	I
    //   189: istore_1
    //   190: aload 6
    //   192: astore 9
    //   194: aload 7
    //   196: astore 10
    //   198: aload_0
    //   199: getfield 923	h1/a:p	I
    //   202: istore_2
    //   203: lload 4
    //   205: iload_1
    //   206: iload_2
    //   207: iadd
    //   208: i2l
    //   209: lcmp
    //   210: ifne +92 -> 302
    //   213: aload 6
    //   215: astore 9
    //   217: aload 7
    //   219: astore 10
    //   221: aload_0
    //   222: getfield 1038	h1/a:m	I
    //   225: newarray byte
    //   227: astore 8
    //   229: aload 6
    //   231: astore 9
    //   233: aload 7
    //   235: astore 10
    //   237: aload 6
    //   239: aload 8
    //   241: invokevirtual 917	java/io/InputStream:read	([B)I
    //   244: aload_0
    //   245: getfield 1038	h1/a:m	I
    //   248: if_icmpne +35 -> 283
    //   251: aload 6
    //   253: astore 9
    //   255: aload 7
    //   257: astore 10
    //   259: aload_0
    //   260: aload 8
    //   262: putfield 1034	h1/a:n	[B
    //   265: aload 6
    //   267: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   270: aload 7
    //   272: ifnull +8 -> 280
    //   275: aload 7
    //   277: invokestatic 1702	h1/a:c	(Ljava/io/FileDescriptor;)V
    //   280: aload 8
    //   282: areturn
    //   283: aload 6
    //   285: astore 9
    //   287: aload 7
    //   289: astore 10
    //   291: new 938	java/io/IOException
    //   294: dup
    //   295: ldc_w 1704
    //   298: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   301: athrow
    //   302: aload 6
    //   304: astore 9
    //   306: aload 7
    //   308: astore 10
    //   310: new 938	java/io/IOException
    //   313: dup
    //   314: ldc_w 1704
    //   317: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   320: athrow
    //   321: astore 8
    //   323: goto +49 -> 372
    //   326: astore 7
    //   328: aload 6
    //   330: astore 10
    //   332: aload 8
    //   334: astore 6
    //   336: goto +78 -> 414
    //   339: astore 8
    //   341: aload 6
    //   343: astore 7
    //   345: aconst_null
    //   346: astore 6
    //   348: goto +24 -> 372
    //   351: astore 7
    //   353: aconst_null
    //   354: astore 10
    //   356: aload 8
    //   358: astore 6
    //   360: goto +54 -> 414
    //   363: astore 8
    //   365: aconst_null
    //   366: astore 6
    //   368: aload 6
    //   370: astore 7
    //   372: aload 6
    //   374: astore 9
    //   376: aload 7
    //   378: astore 10
    //   380: ldc 127
    //   382: ldc_w 1706
    //   385: aload 8
    //   387: invokestatic 1104	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   390: pop
    //   391: aload 6
    //   393: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   396: aload 7
    //   398: ifnull +8 -> 406
    //   401: aload 7
    //   403: invokestatic 1702	h1/a:c	(Ljava/io/FileDescriptor;)V
    //   406: aconst_null
    //   407: areturn
    //   408: astore 7
    //   410: aload 9
    //   412: astore 6
    //   414: aload 6
    //   416: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   419: aload 10
    //   421: ifnull +8 -> 429
    //   424: aload 10
    //   426: invokestatic 1702	h1/a:c	(Ljava/io/FileDescriptor;)V
    //   429: aload 7
    //   431: athrow
    //   432: aconst_null
    //   433: astore 7
    //   435: goto -283 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	a
    //   189	19	1	i1	int
    //   202	6	2	i2	int
    //   4	5	3	bool	boolean
    //   175	29	4	l1	long
    //   18	397	6	localObject1	Object
    //   71	1	7	localObject2	Object
    //   82	225	7	localObject3	Object
    //   326	1	7	localObject4	Object
    //   343	1	7	localObject5	Object
    //   351	1	7	localObject6	Object
    //   370	32	7	localObject7	Object
    //   408	22	7	localObject8	Object
    //   433	1	7	localObject9	Object
    //   6	1	8	localObject10	Object
    //   79	1	8	localException1	Exception
    //   142	139	8	localObject11	Object
    //   321	12	8	localException2	Exception
    //   339	18	8	localException3	Exception
    //   363	23	8	localException4	Exception
    //   154	257	9	localObject12	Object
    //   74	351	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   39	52	71	finally
    //   55	64	71	finally
    //   39	52	79	java/lang/Exception
    //   55	64	79	java/lang/Exception
    //   160	177	321	java/lang/Exception
    //   185	190	321	java/lang/Exception
    //   198	203	321	java/lang/Exception
    //   221	229	321	java/lang/Exception
    //   237	251	321	java/lang/Exception
    //   259	265	321	java/lang/Exception
    //   291	302	321	java/lang/Exception
    //   310	321	321	java/lang/Exception
    //   119	140	326	finally
    //   119	140	339	java/lang/Exception
    //   28	34	351	finally
    //   87	107	351	finally
    //   110	119	351	finally
    //   28	34	363	java/lang/Exception
    //   87	107	363	java/lang/Exception
    //   110	119	363	java/lang/Exception
    //   160	177	408	finally
    //   185	190	408	finally
    //   198	203	408	finally
    //   221	229	408	finally
    //   237	251	408	finally
    //   259	265	408	finally
    //   291	302	408	finally
    //   310	321	408	finally
    //   380	391	408	finally
  }
  
  /* Error */
  public void b0()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1708	h1/a:Q	()Z
    //   4: ifeq +924 -> 928
    //   7: aload_0
    //   8: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   11: ifnonnull +24 -> 35
    //   14: aload_0
    //   15: getfield 838	h1/a:a	Ljava/lang/String;
    //   18: ifnull +6 -> 24
    //   21: goto +14 -> 35
    //   24: new 938	java/io/IOException
    //   27: dup
    //   28: ldc_w 1710
    //   31: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 1712	h1/a:t	Z
    //   40: aload_0
    //   41: aload_0
    //   42: invokevirtual 1714	h1/a:A	()[B
    //   45: putfield 1034	h1/a:n	[B
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 6
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 8
    //   60: ldc_w 1716
    //   63: ldc_w 1718
    //   66: invokestatic 1724	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   69: astore 14
    //   71: aload_0
    //   72: getfield 838	h1/a:a	Ljava/lang/String;
    //   75: ifnull +23 -> 98
    //   78: new 859	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: getfield 838	h1/a:a	Ljava/lang/String;
    //   86: invokespecial 1076	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   89: astore 9
    //   91: aload 9
    //   93: astore 6
    //   95: goto +32 -> 127
    //   98: aload_0
    //   99: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   102: lconst_0
    //   103: getstatic 1698	android/system/OsConstants:SEEK_SET	I
    //   106: invokestatic 1124	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   109: pop2
    //   110: new 859	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   118: invokespecial 1700	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   121: astore 9
    //   123: aload 9
    //   125: astore 6
    //   127: new 1726	java/io/FileOutputStream
    //   130: dup
    //   131: aload 14
    //   133: invokespecial 1729	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore 7
    //   138: aload 6
    //   140: aload 7
    //   142: invokestatic 1394	h1/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   145: pop
    //   146: aload 6
    //   148: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   151: aload 7
    //   153: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   156: iconst_0
    //   157: istore_3
    //   158: iconst_0
    //   159: istore 4
    //   161: iconst_0
    //   162: istore_1
    //   163: iconst_0
    //   164: istore 5
    //   166: iconst_0
    //   167: istore_2
    //   168: new 859	java/io/FileInputStream
    //   171: dup
    //   172: aload 14
    //   174: invokespecial 1730	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   177: astore 6
    //   179: aload_0
    //   180: getfield 838	h1/a:a	Ljava/lang/String;
    //   183: ifnull +19 -> 202
    //   186: new 1726	java/io/FileOutputStream
    //   189: dup
    //   190: aload_0
    //   191: getfield 838	h1/a:a	Ljava/lang/String;
    //   194: invokespecial 1731	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   197: astore 8
    //   199: goto +28 -> 227
    //   202: aload_0
    //   203: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   206: lconst_0
    //   207: getstatic 1698	android/system/OsConstants:SEEK_SET	I
    //   210: invokestatic 1124	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   213: pop2
    //   214: new 1726	java/io/FileOutputStream
    //   217: dup
    //   218: aload_0
    //   219: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   222: invokespecial 1732	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   225: astore 8
    //   227: new 840	java/io/BufferedInputStream
    //   230: dup
    //   231: aload 6
    //   233: invokespecial 1733	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   236: astore 9
    //   238: new 1735	java/io/BufferedOutputStream
    //   241: dup
    //   242: aload 8
    //   244: invokespecial 1737	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   247: astore 12
    //   249: iload 4
    //   251: istore_1
    //   252: aload 9
    //   254: astore 7
    //   256: aload 12
    //   258: astore 11
    //   260: aload_0
    //   261: getfield 1016	h1/a:d	I
    //   264: istore 5
    //   266: iload 5
    //   268: iconst_4
    //   269: if_icmpne +25 -> 294
    //   272: iload 4
    //   274: istore_1
    //   275: aload 9
    //   277: astore 7
    //   279: aload 12
    //   281: astore 11
    //   283: aload_0
    //   284: aload 9
    //   286: aload 12
    //   288: invokespecial 1739	h1/a:c0	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   291: goto +58 -> 349
    //   294: iload 5
    //   296: bipush 13
    //   298: if_icmpne +25 -> 323
    //   301: iload 4
    //   303: istore_1
    //   304: aload 9
    //   306: astore 7
    //   308: aload 12
    //   310: astore 11
    //   312: aload_0
    //   313: aload 9
    //   315: aload 12
    //   317: invokespecial 1741	h1/a:d0	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   320: goto +29 -> 349
    //   323: iload 5
    //   325: bipush 14
    //   327: if_icmpne +22 -> 349
    //   330: iload 4
    //   332: istore_1
    //   333: aload 9
    //   335: astore 7
    //   337: aload 12
    //   339: astore 11
    //   341: aload_0
    //   342: aload 9
    //   344: aload 12
    //   346: invokespecial 1743	h1/a:e0	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   349: aload 9
    //   351: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   354: aload 12
    //   356: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   359: aload 14
    //   361: invokevirtual 1746	java/io/File:delete	()Z
    //   364: pop
    //   365: aload_0
    //   366: aconst_null
    //   367: putfield 1034	h1/a:n	[B
    //   370: return
    //   371: astore 10
    //   373: aload 6
    //   375: astore 7
    //   377: aload 8
    //   379: astore 6
    //   381: aload 12
    //   383: astore 8
    //   385: goto +106 -> 491
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 11
    //   393: aload 9
    //   395: astore 7
    //   397: goto +413 -> 810
    //   400: astore 10
    //   402: aconst_null
    //   403: astore 11
    //   405: aload 6
    //   407: astore 7
    //   409: aload 8
    //   411: astore 6
    //   413: aload 11
    //   415: astore 8
    //   417: goto +74 -> 491
    //   420: astore 10
    //   422: aconst_null
    //   423: astore 11
    //   425: aload 11
    //   427: astore 9
    //   429: aload 6
    //   431: astore 7
    //   433: aload 8
    //   435: astore 6
    //   437: aload 11
    //   439: astore 8
    //   441: goto +50 -> 491
    //   444: astore 8
    //   446: aload 6
    //   448: astore 7
    //   450: aload 8
    //   452: astore 6
    //   454: goto +24 -> 478
    //   457: astore 6
    //   459: aconst_null
    //   460: astore 11
    //   462: aload 10
    //   464: astore 7
    //   466: iload 5
    //   468: istore_1
    //   469: goto +341 -> 810
    //   472: astore 6
    //   474: aload 8
    //   476: astore 7
    //   478: aconst_null
    //   479: astore 8
    //   481: aconst_null
    //   482: astore 9
    //   484: aload 6
    //   486: astore 10
    //   488: aconst_null
    //   489: astore 6
    //   491: new 859	java/io/FileInputStream
    //   494: dup
    //   495: aload 14
    //   497: invokespecial 1730	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   500: astore 12
    //   502: aload 6
    //   504: astore 7
    //   506: aload 6
    //   508: astore 11
    //   510: aload_0
    //   511: getfield 838	h1/a:a	Ljava/lang/String;
    //   514: ifnonnull +47 -> 561
    //   517: aload 6
    //   519: astore 7
    //   521: aload 6
    //   523: astore 11
    //   525: aload_0
    //   526: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   529: lconst_0
    //   530: getstatic 1698	android/system/OsConstants:SEEK_SET	I
    //   533: invokestatic 1124	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   536: pop2
    //   537: aload 6
    //   539: astore 7
    //   541: aload 6
    //   543: astore 11
    //   545: new 1726	java/io/FileOutputStream
    //   548: dup
    //   549: aload_0
    //   550: getfield 855	h1/a:b	Ljava/io/FileDescriptor;
    //   553: invokespecial 1732	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   556: astore 6
    //   558: goto +24 -> 582
    //   561: aload 6
    //   563: astore 7
    //   565: aload 6
    //   567: astore 11
    //   569: new 1726	java/io/FileOutputStream
    //   572: dup
    //   573: aload_0
    //   574: getfield 838	h1/a:a	Ljava/lang/String;
    //   577: invokespecial 1731	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   580: astore 6
    //   582: aload 6
    //   584: astore 7
    //   586: aload 6
    //   588: astore 11
    //   590: aload 12
    //   592: aload 6
    //   594: invokestatic 1394	h1/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   597: pop
    //   598: iload 4
    //   600: istore_1
    //   601: aload 9
    //   603: astore 7
    //   605: aload 8
    //   607: astore 11
    //   609: aload 12
    //   611: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   614: iload 4
    //   616: istore_1
    //   617: aload 9
    //   619: astore 7
    //   621: aload 8
    //   623: astore 11
    //   625: aload 6
    //   627: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   630: iload 4
    //   632: istore_1
    //   633: aload 9
    //   635: astore 7
    //   637: aload 8
    //   639: astore 11
    //   641: new 938	java/io/IOException
    //   644: dup
    //   645: ldc_w 1748
    //   648: aload 10
    //   650: invokespecial 1474	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   653: athrow
    //   654: astore 6
    //   656: aload 12
    //   658: astore 10
    //   660: goto +93 -> 753
    //   663: astore 10
    //   665: aload 11
    //   667: astore 6
    //   669: aload 12
    //   671: astore 7
    //   673: goto +20 -> 693
    //   676: astore 10
    //   678: aload 7
    //   680: astore 12
    //   682: iload_3
    //   683: istore_2
    //   684: aload 6
    //   686: astore 13
    //   688: goto +77 -> 765
    //   691: astore 10
    //   693: new 878	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 879	java/lang/StringBuilder:<init>	()V
    //   700: astore 11
    //   702: aload 11
    //   704: ldc_w 1750
    //   707: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 11
    //   713: aload 14
    //   715: invokevirtual 1753	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   718: invokevirtual 885	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: new 938	java/io/IOException
    //   725: dup
    //   726: aload 11
    //   728: invokevirtual 892	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: aload 10
    //   733: invokespecial 1474	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   736: athrow
    //   737: astore 11
    //   739: iconst_1
    //   740: istore_2
    //   741: aload 7
    //   743: astore 10
    //   745: aload 6
    //   747: astore 7
    //   749: aload 11
    //   751: astore 6
    //   753: aload 7
    //   755: astore 13
    //   757: aload 10
    //   759: astore 12
    //   761: aload 6
    //   763: astore 10
    //   765: iload_2
    //   766: istore_1
    //   767: aload 9
    //   769: astore 7
    //   771: aload 8
    //   773: astore 11
    //   775: aload 12
    //   777: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   780: iload_2
    //   781: istore_1
    //   782: aload 9
    //   784: astore 7
    //   786: aload 8
    //   788: astore 11
    //   790: aload 13
    //   792: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   795: iload_2
    //   796: istore_1
    //   797: aload 9
    //   799: astore 7
    //   801: aload 8
    //   803: astore 11
    //   805: aload 10
    //   807: athrow
    //   808: astore 6
    //   810: aload 7
    //   812: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   815: aload 11
    //   817: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   820: iload_1
    //   821: ifne +9 -> 830
    //   824: aload 14
    //   826: invokevirtual 1746	java/io/File:delete	()Z
    //   829: pop
    //   830: aload 6
    //   832: athrow
    //   833: astore 8
    //   835: goto +13 -> 848
    //   838: astore 8
    //   840: goto +28 -> 868
    //   843: astore 8
    //   845: aconst_null
    //   846: astore 7
    //   848: aload 6
    //   850: astore 9
    //   852: aload 8
    //   854: astore 6
    //   856: aload 9
    //   858: astore 8
    //   860: goto +55 -> 915
    //   863: astore 8
    //   865: aconst_null
    //   866: astore 7
    //   868: goto +24 -> 892
    //   871: astore 6
    //   873: aconst_null
    //   874: astore 9
    //   876: aload 7
    //   878: astore 8
    //   880: aload 9
    //   882: astore 7
    //   884: goto +31 -> 915
    //   887: astore 8
    //   889: aconst_null
    //   890: astore 7
    //   892: new 938	java/io/IOException
    //   895: dup
    //   896: ldc_w 1755
    //   899: aload 8
    //   901: invokespecial 1474	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   904: athrow
    //   905: astore 9
    //   907: aload 6
    //   909: astore 8
    //   911: aload 9
    //   913: astore 6
    //   915: aload 8
    //   917: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   920: aload 7
    //   922: invokestatic 1079	h1/a:d	(Ljava/io/Closeable;)V
    //   925: aload 6
    //   927: athrow
    //   928: new 938	java/io/IOException
    //   931: dup
    //   932: ldc_w 1757
    //   935: invokespecial 940	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   938: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	939	0	this	a
    //   162	659	1	i1	int
    //   167	629	2	i2	int
    //   157	526	3	i3	int
    //   159	472	4	i4	int
    //   164	303	5	i5	int
    //   52	328	6	localObject1	Object
    //   388	18	6	localObject2	Object
    //   411	42	6	localObject3	Object
    //   457	1	6	localObject4	Object
    //   472	13	6	localException1	Exception
    //   489	137	6	localFileOutputStream	java.io.FileOutputStream
    //   654	1	6	localObject5	Object
    //   667	95	6	localObject6	Object
    //   808	41	6	localObject7	Object
    //   854	1	6	localObject8	Object
    //   871	37	6	localObject9	Object
    //   913	13	6	localObject10	Object
    //   55	866	7	localObject11	Object
    //   58	382	8	localObject12	Object
    //   444	31	8	localException2	Exception
    //   479	323	8	localObject13	Object
    //   833	1	8	localObject14	Object
    //   838	1	8	localException3	Exception
    //   843	10	8	localObject15	Object
    //   858	1	8	localObject16	Object
    //   863	1	8	localException4	Exception
    //   878	1	8	localObject17	Object
    //   887	13	8	localException5	Exception
    //   909	7	8	localObject18	Object
    //   89	792	9	localObject19	Object
    //   905	7	9	localObject20	Object
    //   49	1	10	localObject21	Object
    //   371	1	10	localException6	Exception
    //   400	1	10	localException7	Exception
    //   420	43	10	localException8	Exception
    //   486	173	10	localObject22	Object
    //   663	1	10	localException9	Exception
    //   676	1	10	localObject23	Object
    //   691	41	10	localException10	Exception
    //   743	63	10	localObject24	Object
    //   258	469	11	localObject25	Object
    //   737	13	11	localObject26	Object
    //   773	43	11	localObject27	Object
    //   247	529	12	localObject28	Object
    //   686	105	13	localObject29	Object
    //   69	756	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   260	266	371	java/lang/Exception
    //   283	291	371	java/lang/Exception
    //   312	320	371	java/lang/Exception
    //   341	349	371	java/lang/Exception
    //   238	249	388	finally
    //   238	249	400	java/lang/Exception
    //   227	238	420	java/lang/Exception
    //   179	199	444	java/lang/Exception
    //   202	227	444	java/lang/Exception
    //   168	179	457	finally
    //   179	199	457	finally
    //   202	227	457	finally
    //   227	238	457	finally
    //   168	179	472	java/lang/Exception
    //   510	517	654	finally
    //   525	537	654	finally
    //   545	558	654	finally
    //   569	582	654	finally
    //   590	598	654	finally
    //   510	517	663	java/lang/Exception
    //   525	537	663	java/lang/Exception
    //   545	558	663	java/lang/Exception
    //   569	582	663	java/lang/Exception
    //   590	598	663	java/lang/Exception
    //   491	502	676	finally
    //   491	502	691	java/lang/Exception
    //   693	737	737	finally
    //   260	266	808	finally
    //   283	291	808	finally
    //   312	320	808	finally
    //   341	349	808	finally
    //   609	614	808	finally
    //   625	630	808	finally
    //   641	654	808	finally
    //   775	780	808	finally
    //   790	795	808	finally
    //   805	808	808	finally
    //   138	146	833	finally
    //   138	146	838	java/lang/Exception
    //   127	138	843	finally
    //   127	138	863	java/lang/Exception
    //   60	91	871	finally
    //   98	123	871	finally
    //   60	91	887	java/lang/Exception
    //   98	123	887	java/lang/Exception
    //   892	905	905	finally
  }
  
  public void f0(double paramDouble)
  {
    String str;
    if (paramDouble >= 0.0D) {
      str = "0";
    } else {
      str = "1";
    }
    g0("GPSAltitude", new f(Math.abs(paramDouble)).toString());
    g0("GPSAltitudeRef", str);
  }
  
  public void g0(String paramString1, String paramString2)
  {
    Object localObject2 = paramString1;
    Object localObject1 = paramString2;
    Objects.requireNonNull(localObject2, "tag shouldn't be null");
    if ((!"DateTime".equals(localObject2)) && (!"DateTimeOriginal".equals(localObject2)))
    {
      paramString1 = (String)localObject1;
      if (!"DateTimeDigitized".equals(localObject2)) {}
    }
    else
    {
      paramString1 = (String)localObject1;
      if (localObject1 != null)
      {
        boolean bool1 = w0.matcher((CharSequence)localObject1).find();
        boolean bool2 = x0.matcher((CharSequence)localObject1).find();
        if ((paramString2.length() == 19) && ((bool1) || (bool2)))
        {
          paramString1 = (String)localObject1;
          if (bool2) {
            paramString1 = ((String)localObject1).replaceAll("-", ":");
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString2 = (String)localObject1;
          localObject1 = localObject2;
        }
      }
    }
    int i1;
    for (;;)
    {
      paramString1.append("Invalid value for ");
      paramString1.append((String)localObject1);
      paramString1.append(" : ");
      paramString1.append(paramString2);
      Log.w("ExifInterface", paramString1.toString());
      return;
      localObject1 = localObject2;
      if ("ISOSpeedRatings".equals(localObject2))
      {
        if (v) {
          Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
        }
        localObject1 = "PhotographicSensitivity";
      }
      i1 = 1;
      localObject2 = paramString1;
      if (paramString1 == null) {
        break;
      }
      localObject2 = paramString1;
      if (!p0.contains(localObject1)) {
        break;
      }
      if (((String)localObject1).equals("GPSTimeStamp"))
      {
        paramString2 = v0.matcher(paramString1);
        if (!paramString2.find())
        {
          localObject2 = new StringBuilder();
          paramString2 = paramString1;
          paramString1 = (String)localObject2;
          continue;
        }
        paramString1 = new StringBuilder();
        paramString1.append(Integer.parseInt(paramString2.group(1)));
        paramString1.append("/1,");
        paramString1.append(Integer.parseInt(paramString2.group(2)));
        paramString1.append("/1,");
        paramString1.append(Integer.parseInt(paramString2.group(3)));
        paramString1.append("/1");
        localObject2 = paramString1.toString();
        break;
      }
      try
      {
        localObject2 = new f(Double.parseDouble(paramString1)).toString();
      }
      catch (NumberFormatException paramString2)
      {
        label385:
        int i3;
        break label385;
      }
      localObject2 = new StringBuilder();
      paramString2 = paramString1;
      paramString1 = (String)localObject2;
    }
    i3 = 0;
    while (i3 < j0.length)
    {
      if ((i3 != 4) || (this.i))
      {
        paramString1 = (e)o0[i3].get(localObject1);
        if (paramString1 != null) {
          if (localObject2 == null)
          {
            this.f[i3].remove(localObject1);
          }
          else
          {
            Pair localPair = D((String)localObject2);
            int i2;
            Object localObject3;
            if ((paramString1.c != ((Integer)localPair.first).intValue()) && (paramString1.c != ((Integer)localPair.second).intValue()))
            {
              i2 = paramString1.d;
              if ((i2 != -1) && ((i2 == ((Integer)localPair.first).intValue()) || (paramString1.d == ((Integer)localPair.second).intValue())))
              {
                i2 = paramString1.d;
              }
              else
              {
                i2 = paramString1.c;
                if ((i2 != i1) && (i2 != 7) && (i2 != 2))
                {
                  if (!v) {
                    break label1465;
                  }
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("Given tag (");
                  ((StringBuilder)localObject3).append((String)localObject1);
                  ((StringBuilder)localObject3).append(") value didn't match with one of expected formats: ");
                  String[] arrayOfString = W;
                  ((StringBuilder)localObject3).append(arrayOfString[paramString1.c]);
                  i2 = paramString1.d;
                  paramString2 = "";
                  if (i2 == -1)
                  {
                    paramString1 = "";
                  }
                  else
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append(", ");
                    localStringBuilder.append(arrayOfString[paramString1.d]);
                    paramString1 = localStringBuilder.toString();
                  }
                  ((StringBuilder)localObject3).append(paramString1);
                  ((StringBuilder)localObject3).append(" (guess: ");
                  ((StringBuilder)localObject3).append(arrayOfString[((Integer)localPair.first).intValue()]);
                  if (((Integer)localPair.second).intValue() == -1)
                  {
                    paramString1 = paramString2;
                  }
                  else
                  {
                    paramString1 = new StringBuilder();
                    paramString1.append(", ");
                    paramString1.append(arrayOfString[((Integer)localPair.second).intValue()]);
                    paramString1 = paramString1.toString();
                  }
                  ((StringBuilder)localObject3).append(paramString1);
                  ((StringBuilder)localObject3).append(")");
                  Log.d("ExifInterface", ((StringBuilder)localObject3).toString());
                  break label1465;
                }
              }
            }
            else
            {
              i2 = paramString1.c;
            }
            switch (i2)
            {
            case 6: 
            case 8: 
            case 11: 
            default: 
              int i4 = i1;
              i1 = i4;
              if (!v) {
                break label1465;
              }
              paramString1 = new StringBuilder();
              paramString1.append("Data format isn't one of expected formats: ");
              paramString1.append(i2);
              Log.d("ExifInterface", paramString1.toString());
              i1 = i4;
              break;
            case 12: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new double[paramString1.length];
              i2 = 0;
              while (i2 < paramString1.length)
              {
                paramString2[i2] = Double.parseDouble(paramString1[i2]);
                i2 += 1;
              }
              this.f[i3].put(localObject1, d.b(paramString2, this.h));
              break;
            case 10: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new f[paramString1.length];
              i2 = 0;
              while (i2 < paramString1.length)
              {
                localObject3 = paramString1[i2].split("/", -1);
                paramString2[i2] = new f(Double.parseDouble(localObject3[0]), Double.parseDouble(localObject3[i1]));
                i2 += 1;
                i1 = 1;
              }
              paramString1 = this.f[i3];
              paramString2 = d.d(paramString2, this.h);
              break;
            case 9: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new int[paramString1.length];
              i1 = 0;
              while (i1 < paramString1.length)
              {
                paramString2[i1] = Integer.parseInt(paramString1[i1]);
                i1 += 1;
              }
              paramString1 = this.f[i3];
              paramString2 = d.c(paramString2, this.h);
              paramString1.put(localObject1, paramString2);
              i1 = 1;
              break;
            case 5: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new f[paramString1.length];
              i1 = 0;
              while (i1 < paramString1.length)
              {
                localObject3 = paramString1[i1].split("/", -1);
                paramString2[i1] = new f(Double.parseDouble(localObject3[0]), Double.parseDouble(localObject3[1]));
                i1 += 1;
              }
              i1 = 1;
              paramString1 = this.f[i3];
              paramString2 = d.i(paramString2, this.h);
              break;
            case 4: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new long[paramString1.length];
              i2 = 0;
              while (i2 < paramString1.length)
              {
                paramString2[i2] = Long.parseLong(paramString1[i2]);
                i2 += 1;
              }
              paramString1 = this.f[i3];
              paramString2 = d.g(paramString2, this.h);
              break;
            case 3: 
              paramString1 = ((String)localObject2).split(",", -1);
              paramString2 = new int[paramString1.length];
              i2 = 0;
              while (i2 < paramString1.length)
              {
                paramString2[i2] = Integer.parseInt(paramString1[i2]);
                i2 += 1;
              }
              paramString1 = this.f[i3];
              paramString2 = d.k(paramString2, this.h);
              break;
            case 2: 
            case 7: 
              paramString1 = this.f[i3];
              paramString2 = d.e((String)localObject2);
              break;
            }
            paramString1 = this.f[i3];
            paramString2 = d.a((String)localObject2);
            paramString1.put(localObject1, paramString2);
          }
        }
      }
      label1465:
      i3 += 1;
    }
  }
  
  public void h0(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    g0("GPSProcessingMethod", paramLocation.getProvider());
    i0(paramLocation.getLatitude(), paramLocation.getLongitude());
    f0(paramLocation.getAltitude());
    g0("GPSSpeedRef", "K");
    g0("GPSSpeed", new f(paramLocation.getSpeed() * (float)TimeUnit.HOURS.toSeconds(1L) / 1000.0F).toString());
    paramLocation = U.format(new Date(paramLocation.getTime())).split("\\s+", -1);
    g0("GPSDateStamp", paramLocation[0]);
    g0("GPSTimeStamp", paramLocation[1]);
  }
  
  public void i0(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 >= -90.0D) && (paramDouble1 <= 90.0D) && (!Double.isNaN(paramDouble1)))
    {
      if ((paramDouble2 >= -180.0D) && (paramDouble2 <= 180.0D) && (!Double.isNaN(paramDouble2)))
      {
        if (paramDouble1 >= 0.0D) {
          localObject = "N";
        } else {
          localObject = "S";
        }
        g0("GPSLatitudeRef", (String)localObject);
        g0("GPSLatitude", e(Math.abs(paramDouble1)));
        if (paramDouble2 >= 0.0D) {
          localObject = "E";
        } else {
          localObject = "W";
        }
        g0("GPSLongitudeRef", (String)localObject);
        g0("GPSLongitude", e(Math.abs(paramDouble2)));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Longitude value ");
      ((StringBuilder)localObject).append(paramDouble2);
      ((StringBuilder)localObject).append(" is not valid.");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Latitude value ");
    ((StringBuilder)localObject).append(paramDouble1);
    ((StringBuilder)localObject).append(" is not valid.");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public double l(double paramDouble)
  {
    double d1 = n("GPSAltitude", -1.0D);
    int i1 = -1;
    int i2 = o("GPSAltitudeRef", -1);
    if ((d1 >= 0.0D) && (i2 >= 0))
    {
      if (i2 != 1) {
        i1 = 1;
      }
      return d1 * i1;
    }
    return paramDouble;
  }
  
  public String m(String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    Object localObject = p(paramString);
    if (localObject != null)
    {
      if (!p0.contains(paramString)) {
        return ((d)localObject).n(this.h);
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        int i1 = ((d)localObject).a;
        if ((i1 != 5) && (i1 != 10))
        {
          paramString = new StringBuilder();
          paramString.append("GPS Timestamp format is not rational. format=");
          paramString.append(((d)localObject).a);
        }
        for (paramString = paramString.toString();; paramString = ((StringBuilder)localObject).toString())
        {
          Log.w("ExifInterface", paramString);
          return null;
          paramString = (f[])((d)localObject).o(this.h);
          if ((paramString != null) && (paramString.length == 3)) {
            return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].a / (float)paramString[0].b)), Integer.valueOf((int)((float)paramString[1].a / (float)paramString[1].b)), Integer.valueOf((int)((float)paramString[2].a / (float)paramString[2].b)) });
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid GPS Timestamp array. array=");
          ((StringBuilder)localObject).append(Arrays.toString(paramString));
        }
      }
    }
    try
    {
      paramString = Double.toString(((d)localObject).l(this.h));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
    return null;
  }
  
  public double n(String paramString, double paramDouble)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    paramString = p(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d1 = paramString.l(this.h);
      return d1;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public int o(String paramString, int paramInt)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    paramString = p(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i1 = paramString.m(this.h);
      return i1;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public double[] s()
  {
    String str1 = m("GPSLatitude");
    String str2 = m("GPSLatitudeRef");
    String str3 = m("GPSLongitude");
    String str4 = m("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {}
    try
    {
      double d1 = f(str1, str2);
      double d2 = f(str3, str4);
      return new double[] { d1, d2 };
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label84:
      StringBuilder localStringBuilder;
      break label84;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Latitude/longitude values are not parsable. ");
    localStringBuilder.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[] { str1, str2, str3, str4 }));
    Log.w("ExifInterface", localStringBuilder.toString());
    return null;
  }
  
  class a
    extends MediaDataSource
  {
    long a;
    
    a(a.b paramb) {}
    
    public void close() {}
    
    public long getSize()
    {
      return -1L;
    }
    
    public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return 0;
      }
      if (paramLong < 0L) {
        return -1;
      }
      try
      {
        long l = this.a;
        if (l != paramLong)
        {
          if ((l >= 0L) && (paramLong >= l + paramb.available())) {
            return -1;
          }
          paramb.i(paramLong);
          this.a = paramLong;
        }
        int i = paramInt2;
        if (paramInt2 > paramb.available()) {
          i = paramb.available();
        }
        paramInt1 = paramb.read(paramArrayOfByte, paramInt1, i);
        if (paramInt1 >= 0)
        {
          this.a += paramInt1;
          return paramInt1;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        label125:
        break label125;
      }
      this.a = -1L;
      return -1;
    }
  }
  
  private static class b
    extends InputStream
    implements DataInput
  {
    private static final ByteOrder e = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder f = ByteOrder.BIG_ENDIAN;
    private DataInputStream a;
    private ByteOrder b = ByteOrder.BIG_ENDIAN;
    final int c;
    int d;
    
    public b(InputStream paramInputStream)
    {
      this(paramInputStream, ByteOrder.BIG_ENDIAN);
    }
    
    b(InputStream paramInputStream, ByteOrder paramByteOrder)
    {
      paramInputStream = new DataInputStream(paramInputStream);
      this.a = paramInputStream;
      int i = paramInputStream.available();
      this.c = i;
      this.d = 0;
      this.a.mark(i);
      this.b = paramByteOrder;
    }
    
    public b(byte[] paramArrayOfByte)
    {
      this(new ByteArrayInputStream(paramArrayOfByte));
    }
    
    public void B(ByteOrder paramByteOrder)
    {
      this.b = paramByteOrder;
    }
    
    public int a()
    {
      return this.c;
    }
    
    public int available()
    {
      return this.a.available();
    }
    
    public int g()
    {
      return this.d;
    }
    
    public long h()
    {
      return readInt() & 0xFFFFFFFF;
    }
    
    public void i(long paramLong)
    {
      int i = this.d;
      if (i > paramLong)
      {
        this.d = 0;
        this.a.reset();
        this.a.mark(this.c);
      }
      else
      {
        paramLong -= i;
      }
      i = (int)paramLong;
      if (skipBytes(i) == i) {
        return;
      }
      throw new IOException("Couldn't seek up to the byteCount");
    }
    
    public void mark(int paramInt)
    {
      try
      {
        this.a.mark(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public int read()
    {
      this.d += 1;
      return this.a.read();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      this.d += paramInt1;
      return paramInt1;
    }
    
    public boolean readBoolean()
    {
      this.d += 1;
      return this.a.readBoolean();
    }
    
    public byte readByte()
    {
      int i = this.d + 1;
      this.d = i;
      if (i <= this.c)
      {
        i = this.a.read();
        if (i >= 0) {
          return (byte)i;
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public char readChar()
    {
      this.d += 2;
      return this.a.readChar();
    }
    
    public double readDouble()
    {
      return Double.longBitsToDouble(readLong());
    }
    
    public float readFloat()
    {
      return Float.intBitsToFloat(readInt());
    }
    
    public void readFully(byte[] paramArrayOfByte)
    {
      int i = this.d + paramArrayOfByte.length;
      this.d = i;
      if (i <= this.c)
      {
        if (this.a.read(paramArrayOfByte, 0, paramArrayOfByte.length) == paramArrayOfByte.length) {
          return;
        }
        throw new IOException("Couldn't read up to the length of buffer");
      }
      throw new EOFException();
    }
    
    public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = this.d + paramInt2;
      this.d = i;
      if (i <= this.c)
      {
        if (this.a.read(paramArrayOfByte, paramInt1, paramInt2) == paramInt2) {
          return;
        }
        throw new IOException("Couldn't read up to the length of buffer");
      }
      throw new EOFException();
    }
    
    public int readInt()
    {
      int i = this.d + 4;
      this.d = i;
      if (i <= this.c)
      {
        i = this.a.read();
        int j = this.a.read();
        int k = this.a.read();
        int m = this.a.read();
        if ((i | j | k | m) >= 0)
        {
          Object localObject = this.b;
          if (localObject == e) {
            return (m << 24) + (k << 16) + (j << 8) + i;
          }
          if (localObject == f) {
            return (i << 24) + (j << 16) + (k << 8) + m;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.b);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public String readLine()
    {
      Log.d("ExifInterface", "Currently unsupported");
      return null;
    }
    
    public long readLong()
    {
      int i = this.d + 8;
      this.d = i;
      if (i <= this.c)
      {
        i = this.a.read();
        int j = this.a.read();
        int k = this.a.read();
        int m = this.a.read();
        int n = this.a.read();
        int i1 = this.a.read();
        int i2 = this.a.read();
        int i3 = this.a.read();
        if ((i | j | k | m | n | i1 | i2 | i3) >= 0)
        {
          Object localObject = this.b;
          if (localObject == e) {
            return (i3 << 56) + (i2 << 48) + (i1 << 40) + (n << 32) + (m << 24) + (k << 16) + (j << 8) + i;
          }
          if (localObject == f) {
            return (i << 56) + (j << 48) + (k << 40) + (m << 32) + (n << 24) + (i1 << 16) + (i2 << 8) + i3;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.b);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public short readShort()
    {
      int i = this.d + 2;
      this.d = i;
      if (i <= this.c)
      {
        i = this.a.read();
        int j = this.a.read();
        if ((i | j) >= 0)
        {
          Object localObject = this.b;
          if (localObject == e) {
            return (short)((j << 8) + i);
          }
          if (localObject == f) {
            return (short)((i << 8) + j);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.b);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public String readUTF()
    {
      this.d += 2;
      return this.a.readUTF();
    }
    
    public int readUnsignedByte()
    {
      this.d += 1;
      return this.a.readUnsignedByte();
    }
    
    public int readUnsignedShort()
    {
      int i = this.d + 2;
      this.d = i;
      if (i <= this.c)
      {
        i = this.a.read();
        int j = this.a.read();
        if ((i | j) >= 0)
        {
          Object localObject = this.b;
          if (localObject == e) {
            return (j << 8) + i;
          }
          if (localObject == f) {
            return (i << 8) + j;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.b);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public int skipBytes(int paramInt)
    {
      int i = Math.min(paramInt, this.c - this.d);
      paramInt = 0;
      while (paramInt < i) {
        paramInt += this.a.skipBytes(i - paramInt);
      }
      this.d += paramInt;
      return paramInt;
    }
  }
  
  private static class c
    extends FilterOutputStream
  {
    final OutputStream a;
    private ByteOrder b;
    
    public c(OutputStream paramOutputStream, ByteOrder paramByteOrder)
    {
      super();
      this.a = paramOutputStream;
      this.b = paramByteOrder;
    }
    
    public void B(long paramLong)
    {
      h((int)paramLong);
    }
    
    public void a(ByteOrder paramByteOrder)
    {
      this.b = paramByteOrder;
    }
    
    public void d0(int paramInt)
    {
      i((short)paramInt);
    }
    
    public void g(int paramInt)
    {
      this.a.write(paramInt);
    }
    
    public void h(int paramInt)
    {
      Object localObject = this.b;
      if (localObject == ByteOrder.LITTLE_ENDIAN)
      {
        this.a.write(paramInt >>> 0 & 0xFF);
        this.a.write(paramInt >>> 8 & 0xFF);
        this.a.write(paramInt >>> 16 & 0xFF);
        localObject = this.a;
        paramInt >>>= 24;
      }
      for (;;)
      {
        ((OutputStream)localObject).write(paramInt & 0xFF);
        return;
        if (localObject != ByteOrder.BIG_ENDIAN) {
          break;
        }
        this.a.write(paramInt >>> 24 & 0xFF);
        this.a.write(paramInt >>> 16 & 0xFF);
        this.a.write(paramInt >>> 8 & 0xFF);
        localObject = this.a;
        paramInt >>>= 0;
      }
    }
    
    public void i(short paramShort)
    {
      Object localObject = this.b;
      if (localObject == ByteOrder.LITTLE_ENDIAN)
      {
        this.a.write(paramShort >>> 0 & 0xFF);
        localObject = this.a;
        paramShort >>>= 8;
      }
      for (;;)
      {
        ((OutputStream)localObject).write(paramShort & 0xFF);
        return;
        if (localObject != ByteOrder.BIG_ENDIAN) {
          break;
        }
        this.a.write(paramShort >>> 8 & 0xFF);
        localObject = this.a;
        paramShort >>>= 0;
      }
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      this.a.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static class d
  {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;
    
    d(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramLong;
      this.d = paramArrayOfByte;
    }
    
    d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this(paramInt1, paramInt2, -1L, paramArrayOfByte);
    }
    
    public static d a(String paramString)
    {
      if ((paramString.length() == 1) && (paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '1')) {
        return new d(1, 1, new byte[] { (byte)(paramString.charAt(0) - '0') });
      }
      paramString = paramString.getBytes(a.r0);
      return new d(1, paramString.length, paramString);
    }
    
    public static d b(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[12] * paramArrayOfDouble.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putDouble(paramArrayOfDouble[i]);
        i += 1;
      }
      return new d(12, paramArrayOfDouble.length, localByteBuffer.array());
    }
    
    public static d c(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[9] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt(paramArrayOfInt[i]);
        i += 1;
      }
      return new d(9, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public static d d(a.f[] paramArrayOff, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[10] * paramArrayOff.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOff.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOff[i];
        localByteBuffer.putInt((int)paramByteOrder.a);
        localByteBuffer.putInt((int)paramByteOrder.b);
        i += 1;
      }
      return new d(10, paramArrayOff.length, localByteBuffer.array());
    }
    
    public static d e(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('\000');
      paramString = localStringBuilder.toString().getBytes(a.r0);
      return new d(2, paramString.length, paramString);
    }
    
    public static d f(long paramLong, ByteOrder paramByteOrder)
    {
      return g(new long[] { paramLong }, paramByteOrder);
    }
    
    public static d g(long[] paramArrayOfLong, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[4] * paramArrayOfLong.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt((int)paramArrayOfLong[i]);
        i += 1;
      }
      return new d(4, paramArrayOfLong.length, localByteBuffer.array());
    }
    
    public static d h(a.f paramf, ByteOrder paramByteOrder)
    {
      return i(new a.f[] { paramf }, paramByteOrder);
    }
    
    public static d i(a.f[] paramArrayOff, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[5] * paramArrayOff.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOff.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOff[i];
        localByteBuffer.putInt((int)paramByteOrder.a);
        localByteBuffer.putInt((int)paramByteOrder.b);
        i += 1;
      }
      return new d(5, paramArrayOff.length, localByteBuffer.array());
    }
    
    public static d j(int paramInt, ByteOrder paramByteOrder)
    {
      return k(new int[] { paramInt }, paramByteOrder);
    }
    
    public static d k(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.X[3] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putShort((short)paramArrayOfInt[i]);
        i += 1;
      }
      return new d(3, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public double l(ByteOrder paramByteOrder)
    {
      paramByteOrder = o(paramByteOrder);
      if (paramByteOrder != null)
      {
        if ((paramByteOrder instanceof String)) {
          return Double.parseDouble((String)paramByteOrder);
        }
        if ((paramByteOrder instanceof long[]))
        {
          paramByteOrder = (long[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof int[]))
        {
          paramByteOrder = (int[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof double[]))
        {
          paramByteOrder = (double[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof a.f[]))
        {
          paramByteOrder = (a.f[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0].a();
          }
          throw new NumberFormatException("There are more than one component");
        }
        throw new NumberFormatException("Couldn't find a double value");
      }
      throw new NumberFormatException("NULL can't be converted to a double value");
    }
    
    public int m(ByteOrder paramByteOrder)
    {
      paramByteOrder = o(paramByteOrder);
      if (paramByteOrder != null)
      {
        if ((paramByteOrder instanceof String)) {
          return Integer.parseInt((String)paramByteOrder);
        }
        if ((paramByteOrder instanceof long[]))
        {
          paramByteOrder = (long[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return (int)paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof int[]))
        {
          paramByteOrder = (int[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        throw new NumberFormatException("Couldn't find a integer value");
      }
      throw new NumberFormatException("NULL can't be converted to a integer value");
    }
    
    public String n(ByteOrder paramByteOrder)
    {
      Object localObject = o(paramByteOrder);
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      paramByteOrder = new StringBuilder();
      boolean bool = localObject instanceof long[];
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      if (bool)
      {
        localObject = (long[])localObject;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          j = i + 1;
          i = j;
          if (j != localObject.length)
          {
            paramByteOrder.append(",");
            i = j;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof int[]))
      {
        localObject = (int[])localObject;
        i = j;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          j = i + 1;
          i = j;
          if (j != localObject.length)
          {
            paramByteOrder.append(",");
            i = j;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof double[]))
      {
        localObject = (double[])localObject;
        i = k;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          j = i + 1;
          i = j;
          if (j != localObject.length)
          {
            paramByteOrder.append(",");
            i = j;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof a.f[]))
      {
        localObject = (a.f[])localObject;
        i = m;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i].a);
          paramByteOrder.append('/');
          paramByteOrder.append(localObject[i].b);
          j = i + 1;
          i = j;
          if (j != localObject.length)
          {
            paramByteOrder.append(",");
            i = j;
          }
        }
        return paramByteOrder.toString();
      }
      return null;
    }
    
    /* Error */
    Object o(ByteOrder paramByteOrder)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 13
      //   3: new 185	h1/a$b
      //   6: dup
      //   7: aload_0
      //   8: getfield 26	h1/a$d:d	[B
      //   11: invokespecial 188	h1/a$b:<init>	([B)V
      //   14: astore 14
      //   16: aload 14
      //   18: astore 13
      //   20: aload 14
      //   22: aload_1
      //   23: invokevirtual 192	h1/a$b:B	(Ljava/nio/ByteOrder;)V
      //   26: aload 14
      //   28: astore 13
      //   30: aload_0
      //   31: getfield 20	h1/a$d:a	I
      //   34: istore 12
      //   36: iconst_1
      //   37: istore 5
      //   39: iconst_0
      //   40: istore_3
      //   41: iconst_0
      //   42: istore 6
      //   44: iconst_0
      //   45: istore 7
      //   47: iconst_0
      //   48: istore 8
      //   50: iconst_0
      //   51: istore 9
      //   53: iconst_0
      //   54: istore 10
      //   56: iconst_0
      //   57: istore 11
      //   59: iconst_0
      //   60: istore 4
      //   62: iconst_0
      //   63: istore_2
      //   64: iload 12
      //   66: tableswitch	default:+1014 -> 1080, 1:+797->863, 2:+615->681, 3:+549->615, 4:+483->549, 5:+404->470, 6:+797->863, 7:+615->681, 8:+338->404, 9:+272->338, 10:+191->257, 11:+125->191, 12:+62->128
      //   129: dconst_0
      //   130: astore 13
      //   132: aload_0
      //   133: getfield 22	h1/a$d:b	I
      //   136: newarray double
      //   138: astore_1
      //   139: aload 14
      //   141: astore 13
      //   143: iload_2
      //   144: aload_0
      //   145: getfield 22	h1/a$d:b	I
      //   148: if_icmpge +22 -> 170
      //   151: aload 14
      //   153: astore 13
      //   155: aload_1
      //   156: iload_2
      //   157: aload 14
      //   159: invokevirtual 195	h1/a$b:readDouble	()D
      //   162: dastore
      //   163: iload_2
      //   164: iconst_1
      //   165: iadd
      //   166: istore_2
      //   167: goto -28 -> 139
      //   170: aload 14
      //   172: invokevirtual 200	java/io/InputStream:close	()V
      //   175: aload_1
      //   176: areturn
      //   177: astore 13
      //   179: ldc 202
      //   181: ldc 204
      //   183: aload 13
      //   185: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   188: pop
      //   189: aload_1
      //   190: areturn
      //   191: aload 14
      //   193: astore 13
      //   195: aload_0
      //   196: getfield 22	h1/a$d:b	I
      //   199: newarray double
      //   201: astore_1
      //   202: iload_3
      //   203: istore_2
      //   204: aload 14
      //   206: astore 13
      //   208: iload_2
      //   209: aload_0
      //   210: getfield 22	h1/a$d:b	I
      //   213: if_icmpge +23 -> 236
      //   216: aload 14
      //   218: astore 13
      //   220: aload_1
      //   221: iload_2
      //   222: aload 14
      //   224: invokevirtual 213	h1/a$b:readFloat	()F
      //   227: f2d
      //   228: dastore
      //   229: iload_2
      //   230: iconst_1
      //   231: iadd
      //   232: istore_2
      //   233: goto -29 -> 204
      //   236: aload 14
      //   238: invokevirtual 200	java/io/InputStream:close	()V
      //   241: aload_1
      //   242: areturn
      //   243: astore 13
      //   245: ldc 202
      //   247: ldc 204
      //   249: aload 13
      //   251: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   254: pop
      //   255: aload_1
      //   256: areturn
      //   257: aload 14
      //   259: astore 13
      //   261: aload_0
      //   262: getfield 22	h1/a$d:b	I
      //   265: anewarray 84	h1/a$f
      //   268: astore_1
      //   269: iload 6
      //   271: istore_2
      //   272: aload 14
      //   274: astore 13
      //   276: iload_2
      //   277: aload_0
      //   278: getfield 22	h1/a$d:b	I
      //   281: if_icmpge +36 -> 317
      //   284: aload 14
      //   286: astore 13
      //   288: aload_1
      //   289: iload_2
      //   290: new 84	h1/a$f
      //   293: dup
      //   294: aload 14
      //   296: invokevirtual 216	h1/a$b:readInt	()I
      //   299: i2l
      //   300: aload 14
      //   302: invokevirtual 216	h1/a$b:readInt	()I
      //   305: i2l
      //   306: invokespecial 219	h1/a$f:<init>	(JJ)V
      //   309: aastore
      //   310: iload_2
      //   311: iconst_1
      //   312: iadd
      //   313: istore_2
      //   314: goto -42 -> 272
      //   317: aload 14
      //   319: invokevirtual 200	java/io/InputStream:close	()V
      //   322: aload_1
      //   323: areturn
      //   324: astore 13
      //   326: ldc 202
      //   328: ldc 204
      //   330: aload 13
      //   332: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   335: pop
      //   336: aload_1
      //   337: areturn
      //   338: aload 14
      //   340: astore 13
      //   342: aload_0
      //   343: getfield 22	h1/a$d:b	I
      //   346: newarray int
      //   348: astore_1
      //   349: iload 7
      //   351: istore_2
      //   352: aload 14
      //   354: astore 13
      //   356: iload_2
      //   357: aload_0
      //   358: getfield 22	h1/a$d:b	I
      //   361: if_icmpge +22 -> 383
      //   364: aload 14
      //   366: astore 13
      //   368: aload_1
      //   369: iload_2
      //   370: aload 14
      //   372: invokevirtual 216	h1/a$b:readInt	()I
      //   375: iastore
      //   376: iload_2
      //   377: iconst_1
      //   378: iadd
      //   379: istore_2
      //   380: goto -28 -> 352
      //   383: aload 14
      //   385: invokevirtual 200	java/io/InputStream:close	()V
      //   388: aload_1
      //   389: areturn
      //   390: astore 13
      //   392: ldc 202
      //   394: ldc 204
      //   396: aload 13
      //   398: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   401: pop
      //   402: aload_1
      //   403: areturn
      //   404: aload 14
      //   406: astore 13
      //   408: aload_0
      //   409: getfield 22	h1/a$d:b	I
      //   412: newarray int
      //   414: astore_1
      //   415: iload 8
      //   417: istore_2
      //   418: aload 14
      //   420: astore 13
      //   422: iload_2
      //   423: aload_0
      //   424: getfield 22	h1/a$d:b	I
      //   427: if_icmpge +22 -> 449
      //   430: aload 14
      //   432: astore 13
      //   434: aload_1
      //   435: iload_2
      //   436: aload 14
      //   438: invokevirtual 223	h1/a$b:readShort	()S
      //   441: iastore
      //   442: iload_2
      //   443: iconst_1
      //   444: iadd
      //   445: istore_2
      //   446: goto -28 -> 418
      //   449: aload 14
      //   451: invokevirtual 200	java/io/InputStream:close	()V
      //   454: aload_1
      //   455: areturn
      //   456: astore 13
      //   458: ldc 202
      //   460: ldc 204
      //   462: aload 13
      //   464: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   467: pop
      //   468: aload_1
      //   469: areturn
      //   470: aload 14
      //   472: astore 13
      //   474: aload_0
      //   475: getfield 22	h1/a$d:b	I
      //   478: anewarray 84	h1/a$f
      //   481: astore_1
      //   482: iload 9
      //   484: istore_2
      //   485: aload 14
      //   487: astore 13
      //   489: iload_2
      //   490: aload_0
      //   491: getfield 22	h1/a$d:b	I
      //   494: if_icmpge +34 -> 528
      //   497: aload 14
      //   499: astore 13
      //   501: aload_1
      //   502: iload_2
      //   503: new 84	h1/a$f
      //   506: dup
      //   507: aload 14
      //   509: invokevirtual 226	h1/a$b:h	()J
      //   512: aload 14
      //   514: invokevirtual 226	h1/a$b:h	()J
      //   517: invokespecial 219	h1/a$f:<init>	(JJ)V
      //   520: aastore
      //   521: iload_2
      //   522: iconst_1
      //   523: iadd
      //   524: istore_2
      //   525: goto -40 -> 485
      //   528: aload 14
      //   530: invokevirtual 200	java/io/InputStream:close	()V
      //   533: aload_1
      //   534: areturn
      //   535: astore 13
      //   537: ldc 202
      //   539: ldc 204
      //   541: aload 13
      //   543: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   546: pop
      //   547: aload_1
      //   548: areturn
      //   549: aload 14
      //   551: astore 13
      //   553: aload_0
      //   554: getfield 22	h1/a$d:b	I
      //   557: newarray long
      //   559: astore_1
      //   560: iload 10
      //   562: istore_2
      //   563: aload 14
      //   565: astore 13
      //   567: iload_2
      //   568: aload_0
      //   569: getfield 22	h1/a$d:b	I
      //   572: if_icmpge +22 -> 594
      //   575: aload 14
      //   577: astore 13
      //   579: aload_1
      //   580: iload_2
      //   581: aload 14
      //   583: invokevirtual 226	h1/a$b:h	()J
      //   586: lastore
      //   587: iload_2
      //   588: iconst_1
      //   589: iadd
      //   590: istore_2
      //   591: goto -28 -> 563
      //   594: aload 14
      //   596: invokevirtual 200	java/io/InputStream:close	()V
      //   599: aload_1
      //   600: areturn
      //   601: astore 13
      //   603: ldc 202
      //   605: ldc 204
      //   607: aload 13
      //   609: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   612: pop
      //   613: aload_1
      //   614: areturn
      //   615: aload 14
      //   617: astore 13
      //   619: aload_0
      //   620: getfield 22	h1/a$d:b	I
      //   623: newarray int
      //   625: astore_1
      //   626: iload 11
      //   628: istore_2
      //   629: aload 14
      //   631: astore 13
      //   633: iload_2
      //   634: aload_0
      //   635: getfield 22	h1/a$d:b	I
      //   638: if_icmpge +22 -> 660
      //   641: aload 14
      //   643: astore 13
      //   645: aload_1
      //   646: iload_2
      //   647: aload 14
      //   649: invokevirtual 229	h1/a$b:readUnsignedShort	()I
      //   652: iastore
      //   653: iload_2
      //   654: iconst_1
      //   655: iadd
      //   656: istore_2
      //   657: goto -28 -> 629
      //   660: aload 14
      //   662: invokevirtual 200	java/io/InputStream:close	()V
      //   665: aload_1
      //   666: areturn
      //   667: astore 13
      //   669: ldc 202
      //   671: ldc 204
      //   673: aload 13
      //   675: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   678: pop
      //   679: aload_1
      //   680: areturn
      //   681: iload 4
      //   683: istore_2
      //   684: aload 14
      //   686: astore 13
      //   688: aload_0
      //   689: getfield 22	h1/a$d:b	I
      //   692: getstatic 232	h1/a:Y	[B
      //   695: arraylength
      //   696: if_icmplt +61 -> 757
      //   699: iconst_0
      //   700: istore_2
      //   701: aload 14
      //   703: astore 13
      //   705: getstatic 232	h1/a:Y	[B
      //   708: astore_1
      //   709: iload 5
      //   711: istore_3
      //   712: aload 14
      //   714: astore 13
      //   716: iload_2
      //   717: aload_1
      //   718: arraylength
      //   719: if_icmpge +24 -> 743
      //   722: aload 14
      //   724: astore 13
      //   726: aload_0
      //   727: getfield 26	h1/a$d:d	[B
      //   730: iload_2
      //   731: baload
      //   732: aload_1
      //   733: iload_2
      //   734: baload
      //   735: if_icmpeq +348 -> 1083
      //   738: iconst_0
      //   739: istore_3
      //   740: goto +3 -> 743
      //   743: iload 4
      //   745: istore_2
      //   746: iload_3
      //   747: ifeq +10 -> 757
      //   750: aload 14
      //   752: astore 13
      //   754: aload_1
      //   755: arraylength
      //   756: istore_2
      //   757: aload 14
      //   759: astore 13
      //   761: new 91	java/lang/StringBuilder
      //   764: dup
      //   765: invokespecial 92	java/lang/StringBuilder:<init>	()V
      //   768: astore_1
      //   769: aload 14
      //   771: astore 13
      //   773: iload_2
      //   774: aload_0
      //   775: getfield 22	h1/a$d:b	I
      //   778: if_icmpge +55 -> 833
      //   781: aload 14
      //   783: astore 13
      //   785: aload_0
      //   786: getfield 26	h1/a$d:d	[B
      //   789: iload_2
      //   790: baload
      //   791: istore_3
      //   792: iload_3
      //   793: ifne +6 -> 799
      //   796: goto +37 -> 833
      //   799: iload_3
      //   800: bipush 32
      //   802: if_icmplt +17 -> 819
      //   805: aload 14
      //   807: astore 13
      //   809: aload_1
      //   810: iload_3
      //   811: i2c
      //   812: invokevirtual 99	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   815: pop
      //   816: goto +274 -> 1090
      //   819: aload 14
      //   821: astore 13
      //   823: aload_1
      //   824: bipush 63
      //   826: invokevirtual 99	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   829: pop
      //   830: goto +260 -> 1090
      //   833: aload 14
      //   835: astore 13
      //   837: aload_1
      //   838: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   841: astore_1
      //   842: aload 14
      //   844: invokevirtual 200	java/io/InputStream:close	()V
      //   847: aload_1
      //   848: areturn
      //   849: astore 13
      //   851: ldc 202
      //   853: ldc 204
      //   855: aload 13
      //   857: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   860: pop
      //   861: aload_1
      //   862: areturn
      //   863: aload 14
      //   865: astore 13
      //   867: aload_0
      //   868: getfield 26	h1/a$d:d	[B
      //   871: astore_1
      //   872: aload 14
      //   874: astore 13
      //   876: aload_1
      //   877: arraylength
      //   878: iconst_1
      //   879: if_icmpne +62 -> 941
      //   882: aload_1
      //   883: iconst_0
      //   884: baload
      //   885: iflt +56 -> 941
      //   888: aload_1
      //   889: iconst_0
      //   890: baload
      //   891: iconst_1
      //   892: if_icmpgt +49 -> 941
      //   895: aload 14
      //   897: astore 13
      //   899: new 35	java/lang/String
      //   902: dup
      //   903: iconst_1
      //   904: newarray char
      //   906: dup
      //   907: iconst_0
      //   908: aload_1
      //   909: iconst_0
      //   910: baload
      //   911: bipush 48
      //   913: iadd
      //   914: i2c
      //   915: castore
      //   916: invokespecial 235	java/lang/String:<init>	([C)V
      //   919: astore_1
      //   920: aload 14
      //   922: invokevirtual 200	java/io/InputStream:close	()V
      //   925: aload_1
      //   926: areturn
      //   927: astore 13
      //   929: ldc 202
      //   931: ldc 204
      //   933: aload 13
      //   935: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   938: pop
      //   939: aload_1
      //   940: areturn
      //   941: aload 14
      //   943: astore 13
      //   945: new 35	java/lang/String
      //   948: dup
      //   949: aload_1
      //   950: getstatic 49	h1/a:r0	Ljava/nio/charset/Charset;
      //   953: invokespecial 238	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   956: astore_1
      //   957: aload 14
      //   959: invokevirtual 200	java/io/InputStream:close	()V
      //   962: aload_1
      //   963: areturn
      //   964: astore 13
      //   966: ldc 202
      //   968: ldc 204
      //   970: aload 13
      //   972: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   975: pop
      //   976: aload_1
      //   977: areturn
      //   978: aload 14
      //   980: invokevirtual 200	java/io/InputStream:close	()V
      //   983: aconst_null
      //   984: areturn
      //   985: astore_1
      //   986: ldc 202
      //   988: ldc 204
      //   990: aload_1
      //   991: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   994: pop
      //   995: aconst_null
      //   996: areturn
      //   997: astore 13
      //   999: aload 14
      //   1001: astore_1
      //   1002: aload 13
      //   1004: astore 14
      //   1006: goto +11 -> 1017
      //   1009: astore_1
      //   1010: goto +43 -> 1053
      //   1013: astore 14
      //   1015: aconst_null
      //   1016: astore_1
      //   1017: aload_1
      //   1018: astore 13
      //   1020: ldc 202
      //   1022: ldc 240
      //   1024: aload 14
      //   1026: invokestatic 243	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1029: pop
      //   1030: aload_1
      //   1031: ifnull +19 -> 1050
      //   1034: aload_1
      //   1035: invokevirtual 200	java/io/InputStream:close	()V
      //   1038: aconst_null
      //   1039: areturn
      //   1040: astore_1
      //   1041: ldc 202
      //   1043: ldc 204
      //   1045: aload_1
      //   1046: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1049: pop
      //   1050: aconst_null
      //   1051: areturn
      //   1052: astore_1
      //   1053: aload 13
      //   1055: ifnull +23 -> 1078
      //   1058: aload 13
      //   1060: invokevirtual 200	java/io/InputStream:close	()V
      //   1063: goto +15 -> 1078
      //   1066: astore 13
      //   1068: ldc 202
      //   1070: ldc 204
      //   1072: aload 13
      //   1074: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1077: pop
      //   1078: aload_1
      //   1079: athrow
      //   1080: goto -102 -> 978
      //   1083: iload_2
      //   1084: iconst_1
      //   1085: iadd
      //   1086: istore_2
      //   1087: goto -386 -> 701
      //   1090: iload_2
      //   1091: iconst_1
      //   1092: iadd
      //   1093: istore_2
      //   1094: goto -325 -> 769
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1097	0	this	d
      //   0	1097	1	paramByteOrder	ByteOrder
      //   63	1031	2	i	int
      //   40	771	3	j	int
      //   60	684	4	k	int
      //   37	673	5	m	int
      //   42	228	6	n	int
      //   45	305	7	i1	int
      //   48	368	8	i2	int
      //   51	432	9	i3	int
      //   54	507	10	i4	int
      //   57	570	11	i5	int
      //   34	31	12	i6	int
      //   1	153	13	localObject1	Object
      //   177	7	13	localIOException1	IOException
      //   193	26	13	localObject2	Object
      //   243	7	13	localIOException2	IOException
      //   259	28	13	localObject3	Object
      //   324	7	13	localIOException3	IOException
      //   340	27	13	localObject4	Object
      //   390	7	13	localIOException4	IOException
      //   406	27	13	localObject5	Object
      //   456	7	13	localIOException5	IOException
      //   472	28	13	localObject6	Object
      //   535	7	13	localIOException6	IOException
      //   551	27	13	localObject7	Object
      //   601	7	13	localIOException7	IOException
      //   617	27	13	localObject8	Object
      //   667	7	13	localIOException8	IOException
      //   686	150	13	localObject9	Object
      //   849	7	13	localIOException9	IOException
      //   865	33	13	localObject10	Object
      //   927	7	13	localIOException10	IOException
      //   943	1	13	localObject11	Object
      //   964	7	13	localIOException11	IOException
      //   997	6	13	localIOException12	IOException
      //   1018	41	13	localByteOrder	ByteOrder
      //   1066	7	13	localIOException13	IOException
      //   14	991	14	localObject12	Object
      //   1013	12	14	localIOException14	IOException
      // Exception table:
      //   from	to	target	type
      //   170	175	177	java/io/IOException
      //   236	241	243	java/io/IOException
      //   317	322	324	java/io/IOException
      //   383	388	390	java/io/IOException
      //   449	454	456	java/io/IOException
      //   528	533	535	java/io/IOException
      //   594	599	601	java/io/IOException
      //   660	665	667	java/io/IOException
      //   842	847	849	java/io/IOException
      //   920	925	927	java/io/IOException
      //   957	962	964	java/io/IOException
      //   978	983	985	java/io/IOException
      //   20	26	997	java/io/IOException
      //   30	36	997	java/io/IOException
      //   132	139	997	java/io/IOException
      //   143	151	997	java/io/IOException
      //   155	163	997	java/io/IOException
      //   195	202	997	java/io/IOException
      //   208	216	997	java/io/IOException
      //   220	229	997	java/io/IOException
      //   261	269	997	java/io/IOException
      //   276	284	997	java/io/IOException
      //   288	310	997	java/io/IOException
      //   342	349	997	java/io/IOException
      //   356	364	997	java/io/IOException
      //   368	376	997	java/io/IOException
      //   408	415	997	java/io/IOException
      //   422	430	997	java/io/IOException
      //   434	442	997	java/io/IOException
      //   474	482	997	java/io/IOException
      //   489	497	997	java/io/IOException
      //   501	521	997	java/io/IOException
      //   553	560	997	java/io/IOException
      //   567	575	997	java/io/IOException
      //   579	587	997	java/io/IOException
      //   619	626	997	java/io/IOException
      //   633	641	997	java/io/IOException
      //   645	653	997	java/io/IOException
      //   688	699	997	java/io/IOException
      //   705	709	997	java/io/IOException
      //   716	722	997	java/io/IOException
      //   726	738	997	java/io/IOException
      //   754	757	997	java/io/IOException
      //   761	769	997	java/io/IOException
      //   773	781	997	java/io/IOException
      //   785	792	997	java/io/IOException
      //   809	816	997	java/io/IOException
      //   823	830	997	java/io/IOException
      //   837	842	997	java/io/IOException
      //   867	872	997	java/io/IOException
      //   876	882	997	java/io/IOException
      //   899	920	997	java/io/IOException
      //   945	957	997	java/io/IOException
      //   3	16	1009	finally
      //   3	16	1013	java/io/IOException
      //   1034	1038	1040	java/io/IOException
      //   20	26	1052	finally
      //   30	36	1052	finally
      //   132	139	1052	finally
      //   143	151	1052	finally
      //   155	163	1052	finally
      //   195	202	1052	finally
      //   208	216	1052	finally
      //   220	229	1052	finally
      //   261	269	1052	finally
      //   276	284	1052	finally
      //   288	310	1052	finally
      //   342	349	1052	finally
      //   356	364	1052	finally
      //   368	376	1052	finally
      //   408	415	1052	finally
      //   422	430	1052	finally
      //   434	442	1052	finally
      //   474	482	1052	finally
      //   489	497	1052	finally
      //   501	521	1052	finally
      //   553	560	1052	finally
      //   567	575	1052	finally
      //   579	587	1052	finally
      //   619	626	1052	finally
      //   633	641	1052	finally
      //   645	653	1052	finally
      //   688	699	1052	finally
      //   705	709	1052	finally
      //   716	722	1052	finally
      //   726	738	1052	finally
      //   754	757	1052	finally
      //   761	769	1052	finally
      //   773	781	1052	finally
      //   785	792	1052	finally
      //   809	816	1052	finally
      //   823	830	1052	finally
      //   837	842	1052	finally
      //   867	872	1052	finally
      //   876	882	1052	finally
      //   899	920	1052	finally
      //   945	957	1052	finally
      //   1020	1030	1052	finally
      //   1058	1063	1066	java/io/IOException
    }
    
    public int p()
    {
      return a.X[this.a] * this.b;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(a.W[this.a]);
      localStringBuilder.append(", data length:");
      localStringBuilder.append(this.d.length);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  static class e
  {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    
    e(String paramString, int paramInt1, int paramInt2)
    {
      this.b = paramString;
      this.a = paramInt1;
      this.c = paramInt2;
      this.d = -1;
    }
    
    e(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.b = paramString;
      this.a = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
    }
    
    boolean a(int paramInt)
    {
      int i = this.c;
      if (i != 7)
      {
        if (paramInt == 7) {
          return true;
        }
        if (i != paramInt)
        {
          int j = this.d;
          if (j == paramInt) {
            return true;
          }
          if (((i == 4) || (j == 4)) && (paramInt == 3)) {
            return true;
          }
          if (((i == 9) || (j == 9)) && (paramInt == 8)) {
            return true;
          }
          return ((i == 12) || (j == 12)) && (paramInt == 11);
        }
      }
      return true;
    }
  }
  
  private static class f
  {
    public final long a;
    public final long b;
    
    f(double paramDouble)
    {
      this((paramDouble * 10000.0D), 10000L);
    }
    
    f(long paramLong1, long paramLong2)
    {
      if (paramLong2 == 0L)
      {
        this.a = 0L;
        this.b = 1L;
        return;
      }
      this.a = paramLong1;
      this.b = paramLong2;
    }
    
    public double a()
    {
      return this.a / this.b;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("/");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h1.a
 * JD-Core Version:    0.7.0.1
 */