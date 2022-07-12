package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.n1;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s.r;
import x0.h;

public class g
{
  static final String[] c = { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
  private static final i[] d;
  private static final i[] e;
  private static final i[] f;
  static final i[] g;
  private static final i[] h;
  static final i[][] i;
  static final HashSet<String> j = new HashSet(Arrays.asList(new String[] { "FNumber", "ExposureTime", "GPSTimeStamp" }));
  private final List<Map<String, f>> a;
  private final ByteOrder b;
  
  static
  {
    i[] arrayOfi1 = new i[14];
    arrayOfi1[0] = new i("ImageWidth", 256, 3, 4);
    arrayOfi1[1] = new i("ImageLength", 257, 3, 4);
    arrayOfi1[2] = new i("Make", 271, 2);
    arrayOfi1[3] = new i("Model", 272, 2);
    arrayOfi1[4] = new i("Orientation", 274, 3);
    arrayOfi1[5] = new i("XResolution", 282, 5);
    arrayOfi1[6] = new i("YResolution", 283, 5);
    arrayOfi1[7] = new i("ResolutionUnit", 296, 3);
    arrayOfi1[8] = new i("Software", 305, 2);
    arrayOfi1[9] = new i("DateTime", 306, 2);
    arrayOfi1[10] = new i("YCbCrPositioning", 531, 3);
    arrayOfi1[11] = new i("SubIFDPointer", 330, 4);
    arrayOfi1[12] = new i("ExifIFDPointer", 34665, 4);
    arrayOfi1[13] = new i("GPSInfoIFDPointer", 34853, 4);
    d = arrayOfi1;
    i[] arrayOfi2 = new i[37];
    arrayOfi2[0] = new i("ExposureTime", 33434, 5);
    arrayOfi2[1] = new i("FNumber", 33437, 5);
    arrayOfi2[2] = new i("ExposureProgram", 34850, 3);
    arrayOfi2[3] = new i("PhotographicSensitivity", 34855, 3);
    arrayOfi2[4] = new i("SensitivityType", 34864, 3);
    arrayOfi2[5] = new i("ExifVersion", 36864, 2);
    arrayOfi2[6] = new i("DateTimeOriginal", 36867, 2);
    arrayOfi2[7] = new i("DateTimeDigitized", 36868, 2);
    arrayOfi2[8] = new i("ComponentsConfiguration", 37121, 7);
    arrayOfi2[9] = new i("ShutterSpeedValue", 37377, 10);
    arrayOfi2[10] = new i("ApertureValue", 37378, 5);
    arrayOfi2[11] = new i("BrightnessValue", 37379, 10);
    arrayOfi2[12] = new i("ExposureBiasValue", 37380, 10);
    arrayOfi2[13] = new i("MaxApertureValue", 37381, 5);
    arrayOfi2[14] = new i("MeteringMode", 37383, 3);
    arrayOfi2[15] = new i("LightSource", 37384, 3);
    arrayOfi2[16] = new i("Flash", 37385, 3);
    arrayOfi2[17] = new i("FocalLength", 37386, 5);
    arrayOfi2[18] = new i("SubSecTime", 37520, 2);
    arrayOfi2[19] = new i("SubSecTimeOriginal", 37521, 2);
    arrayOfi2[20] = new i("SubSecTimeDigitized", 37522, 2);
    arrayOfi2[21] = new i("FlashpixVersion", 40960, 7);
    arrayOfi2[22] = new i("ColorSpace", 40961, 3);
    arrayOfi2[23] = new i("PixelXDimension", 40962, 3, 4);
    arrayOfi2[24] = new i("PixelYDimension", 40963, 3, 4);
    arrayOfi2[25] = new i("InteroperabilityIFDPointer", 40965, 4);
    arrayOfi2[26] = new i("FocalPlaneResolutionUnit", 41488, 3);
    arrayOfi2[27] = new i("SensingMethod", 41495, 3);
    arrayOfi2[28] = new i("FileSource", 41728, 7);
    arrayOfi2[29] = new i("SceneType", 41729, 7);
    arrayOfi2[30] = new i("CustomRendered", 41985, 3);
    arrayOfi2[31] = new i("ExposureMode", 41986, 3);
    arrayOfi2[32] = new i("WhiteBalance", 41987, 3);
    arrayOfi2[33] = new i("SceneCaptureType", 41990, 3);
    arrayOfi2[34] = new i("Contrast", 41992, 3);
    arrayOfi2[35] = new i("Saturation", 41993, 3);
    arrayOfi2[36] = new i("Sharpness", 41994, 3);
    e = arrayOfi2;
    i[] arrayOfi3 = new i[13];
    arrayOfi3[0] = new i("GPSVersionID", 0, 1);
    arrayOfi3[1] = new i("GPSLatitudeRef", 1, 2);
    arrayOfi3[2] = new i("GPSLatitude", 2, 5, 10);
    arrayOfi3[3] = new i("GPSLongitudeRef", 3, 2);
    arrayOfi3[4] = new i("GPSLongitude", 4, 5, 10);
    arrayOfi3[5] = new i("GPSAltitudeRef", 5, 1);
    arrayOfi3[6] = new i("GPSAltitude", 6, 5);
    arrayOfi3[7] = new i("GPSTimeStamp", 7, 5);
    arrayOfi3[8] = new i("GPSSpeedRef", 12, 2);
    arrayOfi3[9] = new i("GPSTrackRef", 14, 2);
    arrayOfi3[10] = new i("GPSImgDirectionRef", 16, 2);
    arrayOfi3[11] = new i("GPSDestBearingRef", 23, 2);
    arrayOfi3[12] = new i("GPSDestDistanceRef", 25, 2);
    f = arrayOfi3;
    g = new i[] { new i("SubIFDPointer", 330, 4), new i("ExifIFDPointer", 34665, 4), new i("GPSInfoIFDPointer", 34853, 4), new i("InteroperabilityIFDPointer", 40965, 4) };
    i[] arrayOfi4 = new i[1];
    arrayOfi4[0] = new i("InteroperabilityIndex", 1, 2);
    h = arrayOfi4;
    i = new i[][] { arrayOfi1, arrayOfi2, arrayOfi3, arrayOfi4 };
  }
  
  g(ByteOrder paramByteOrder, List<Map<String, f>> paramList)
  {
    boolean bool;
    if (paramList.size() == i.length) {
      bool = true;
    } else {
      bool = false;
    }
    h.j(bool, "Malformed attributes list. Number of IFDs mismatch.");
    this.b = paramByteOrder;
    this.a = paramList;
  }
  
  public static b a()
  {
    return new b(ByteOrder.BIG_ENDIAN).c("Orientation", String.valueOf(1)).c("XResolution", "72/1").c("YResolution", "72/1").c("ResolutionUnit", String.valueOf(2)).c("YCbCrPositioning", String.valueOf(1)).c("Make", Build.MANUFACTURER).c("Model", Build.MODEL);
  }
  
  Map<String, f> b(int paramInt)
  {
    int k = i.length;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid IFD index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". Index should be between [0, EXIF_TAGS.length] ");
    h.c(paramInt, 0, k, localStringBuilder.toString());
    return (Map)this.a.get(paramInt);
  }
  
  public ByteOrder c()
  {
    return this.b;
  }
  
  public static final class b
  {
    private static final Pattern c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    static final List<HashMap<String, i>> f = Collections.list(new a());
    final List<Map<String, f>> a = Collections.list(new b());
    private final ByteOrder b;
    
    b(ByteOrder paramByteOrder)
    {
      this.b = paramByteOrder;
    }
    
    private static Pair<Integer, Integer> b(String paramString)
    {
      boolean bool2 = paramString.contains(",");
      int i = 1;
      Integer localInteger1 = Integer.valueOf(2);
      Integer localInteger2 = Integer.valueOf(-1);
      Pair localPair;
      if (bool2)
      {
        String[] arrayOfString = paramString.split(",", -1);
        localPair = b(arrayOfString[0]);
        paramString = localPair;
        if (((Integer)localPair.first).intValue() == 2) {
          return localPair;
        }
        while (i < arrayOfString.length)
        {
          localPair = b(arrayOfString[i]);
          int j;
          if ((!((Integer)localPair.first).equals(paramString.first)) && (!((Integer)localPair.second).equals(paramString.first))) {
            j = -1;
          } else {
            j = ((Integer)paramString.first).intValue();
          }
          int k;
          if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)localPair.first).equals(paramString.second)) || (((Integer)localPair.second).equals(paramString.second)))) {
            k = ((Integer)paramString.second).intValue();
          } else {
            k = -1;
          }
          if ((j == -1) && (k == -1)) {
            return new Pair(localInteger1, localInteger2);
          }
          if (j == -1) {
            paramString = new Pair(Integer.valueOf(k), localInteger2);
          } else if (k == -1) {
            paramString = new Pair(Integer.valueOf(j), localInteger2);
          }
          i += 1;
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
          break label364;
        }
        if (l2 >= 0L) {
          break label517;
        }
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          long l1;
          long l2;
          label364:
          label492:
          continue;
          label470:
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
        l1 = Long.parseLong(paramString);
        boolean bool1 = l1 < 0L;
        if ((!bool1) && (l1 <= 65535L)) {
          return new Pair(Integer.valueOf(3), Integer.valueOf(4));
        }
        if (bool1) {
          return new Pair(Integer.valueOf(9), localInteger2);
        }
        localPair = new Pair(Integer.valueOf(4), localInteger2);
        return localPair;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label470;
      }
      try
      {
        Double.parseDouble(paramString);
        paramString = new Pair(Integer.valueOf(12), localInteger2);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        break label492;
      }
      return new Pair(localInteger1, localInteger2);
    }
    
    private void d(String paramString1, String paramString2, List<Map<String, f>> paramList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((Map)localIterator.next()).containsKey(paramString1)) {
          return;
        }
      }
      e(paramString1, paramString2, paramList);
    }
    
    private void e(String paramString1, String paramString2, List<Map<String, f>> paramList)
    {
      Object localObject = this;
      String str1 = paramString1;
      String str2 = paramString2;
      if ((!"DateTime".equals(str1)) && (!"DateTimeOriginal".equals(str1)))
      {
        paramString1 = str2;
        if (!"DateTimeDigitized".equals(str1)) {}
      }
      else
      {
        paramString1 = str2;
        if (str2 != null)
        {
          boolean bool1 = d.matcher(str2).find();
          boolean bool2 = e.matcher(str2).find();
          if ((paramString2.length() == 19) && ((bool1) || (bool2)))
          {
            paramString1 = str2;
            if (bool2) {
              paramString1 = str2.replaceAll("-", ":");
            }
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("Invalid value for ");
            paramString1.append(str1);
            paramString1.append(" : ");
            paramString1.append(str2);
            n1.k("ExifData", paramString1.toString());
            return;
          }
        }
      }
      str2 = str1;
      if ("ISOSpeedRatings".equals(str1)) {
        str2 = "PhotographicSensitivity";
      }
      int j = 1;
      str1 = paramString1;
      if (paramString1 != null)
      {
        str1 = paramString1;
        if (g.j.contains(str2)) {
          if (str2.equals("GPSTimeStamp"))
          {
            paramString2 = c.matcher(paramString1);
            if (!paramString2.find())
            {
              paramString2 = new StringBuilder();
              paramString2.append("Invalid value for ");
              paramString2.append(str2);
              paramString2.append(" : ");
              paramString2.append(paramString1);
              n1.k("ExifData", paramString2.toString());
              return;
            }
            paramString1 = new StringBuilder();
            paramString1.append(Integer.parseInt((String)h.g(paramString2.group(1))));
            paramString1.append("/1,");
            paramString1.append(Integer.parseInt((String)h.g(paramString2.group(2))));
            paramString1.append("/1,");
            paramString1.append(Integer.parseInt((String)h.g(paramString2.group(3))));
            paramString1.append("/1");
            str1 = paramString1.toString();
          }
          else
          {
            try
            {
              str1 = new j(Double.parseDouble(paramString1)).toString();
            }
            catch (NumberFormatException paramString2)
            {
              paramList = new StringBuilder();
              paramList.append("Invalid value for ");
              paramList.append(str2);
              paramList.append(" : ");
              paramList.append(paramString1);
              n1.l("ExifData", paramList.toString(), paramString2);
              return;
            }
          }
        }
      }
      int i = 0;
      while (i < g.i.length)
      {
        paramString1 = (i)((HashMap)f.get(i)).get(str2);
        if (paramString1 != null) {
          if (str1 == null)
          {
            ((Map)paramList.get(i)).remove(str2);
          }
          else
          {
            paramString2 = b(str1);
            int k;
            if ((paramString1.c != ((Integer)paramString2.first).intValue()) && (paramString1.c != ((Integer)paramString2.second).intValue()))
            {
              k = paramString1.d;
              if ((k != -1) && ((k == ((Integer)paramString2.first).intValue()) || (paramString1.d == ((Integer)paramString2.second).intValue())))
              {
                k = paramString1.d;
              }
              else
              {
                int m = paramString1.c;
                k = m;
                if (m != j)
                {
                  k = m;
                  if (m != 7)
                  {
                    if (m != 2) {
                      break label1277;
                    }
                    k = m;
                  }
                }
              }
            }
            else
            {
              k = paramString1.c;
            }
            paramString1 = "/";
            String[] arrayOfString1;
            switch (k)
            {
            case 6: 
            case 8: 
            case 11: 
            default: 
              break;
            case 12: 
              paramString1 = str1.split(",", -1);
              paramString2 = new double[paramString1.length];
              k = 0;
              while (k < paramString1.length)
              {
                paramString2[k] = Double.parseDouble(paramString1[k]);
                k += 1;
              }
              ((Map)paramList.get(i)).put(str2, f.b(paramString2, ((b)localObject).b));
              break;
            case 10: 
              localObject = str1.split(",", -1);
              paramString2 = new j[localObject.length];
              k = 0;
              while (k < localObject.length)
              {
                arrayOfString1 = localObject[k].split(paramString1, -1);
                paramString2[k] = new j(Double.parseDouble(arrayOfString1[0]), Double.parseDouble(arrayOfString1[j]));
                k += 1;
                j = 1;
              }
              paramString1 = (Map)paramList.get(i);
              localObject = this;
              paramString2 = f.d(paramString2, ((b)localObject).b);
              break;
            case 9: 
              paramString1 = str1.split(",", -1);
              paramString2 = new int[paramString1.length];
              j = 0;
              while (j < paramString1.length)
              {
                paramString2[j] = Integer.parseInt(paramString1[j]);
                j += 1;
              }
              paramString1 = (Map)paramList.get(i);
              paramString2 = f.c(paramString2, ((b)localObject).b);
              paramString1.put(str2, paramString2);
              j = 1;
              break;
            case 5: 
              paramString1 = "/";
              arrayOfString1 = str1.split(",", -1);
              paramString2 = new j[arrayOfString1.length];
              j = 0;
              while (j < arrayOfString1.length)
              {
                String[] arrayOfString2 = arrayOfString1[j].split(paramString1, -1);
                paramString2[j] = new j(Double.parseDouble(arrayOfString2[0]), Double.parseDouble(arrayOfString2[1]));
                j += 1;
              }
              j = 1;
              paramString1 = (Map)paramList.get(i);
              paramString2 = f.h(paramString2, ((b)localObject).b);
              break;
            case 4: 
              paramString1 = str1.split(",", -1);
              paramString2 = new long[paramString1.length];
              k = 0;
              while (k < paramString1.length)
              {
                paramString2[k] = Long.parseLong(paramString1[k]);
                k += 1;
              }
              paramString1 = (Map)paramList.get(i);
              paramString2 = f.g(paramString2, ((b)localObject).b);
              break;
            case 3: 
              paramString1 = str1.split(",", -1);
              paramString2 = new int[paramString1.length];
              k = 0;
              while (k < paramString1.length)
              {
                paramString2[k] = Integer.parseInt(paramString1[k]);
                k += 1;
              }
              paramString1 = (Map)paramList.get(i);
              paramString2 = f.i(paramString2, ((b)localObject).b);
              break;
            case 2: 
            case 7: 
              paramString1 = (Map)paramList.get(i);
              paramString2 = f.e(str1);
              break;
            }
            paramString1 = (Map)paramList.get(i);
            paramString2 = f.a(str1);
            paramString1.put(str2, paramString2);
          }
        }
        label1277:
        i += 1;
      }
    }
    
    public g a()
    {
      ArrayList localArrayList = Collections.list(new c());
      if (!((Map)localArrayList.get(1)).isEmpty())
      {
        d("ExposureProgram", String.valueOf(0), localArrayList);
        d("ExifVersion", "0230", localArrayList);
        d("ComponentsConfiguration", "1,2,3,0", localArrayList);
        d("MeteringMode", String.valueOf(0), localArrayList);
        d("LightSource", String.valueOf(0), localArrayList);
        d("FlashpixVersion", "0100", localArrayList);
        d("FocalPlaneResolutionUnit", String.valueOf(2), localArrayList);
        d("FileSource", String.valueOf(3), localArrayList);
        d("SceneType", String.valueOf(1), localArrayList);
        d("CustomRendered", String.valueOf(0), localArrayList);
        d("SceneCaptureType", String.valueOf(0), localArrayList);
        d("Contrast", String.valueOf(0), localArrayList);
        d("Saturation", String.valueOf(0), localArrayList);
        d("Sharpness", String.valueOf(0), localArrayList);
      }
      if (!((Map)localArrayList.get(2)).isEmpty())
      {
        d("GPSVersionID", "2300", localArrayList);
        d("GPSSpeedRef", "K", localArrayList);
        d("GPSTrackRef", "T", localArrayList);
        d("GPSImgDirectionRef", "T", localArrayList);
        d("GPSDestBearingRef", "T", localArrayList);
        d("GPSDestDistanceRef", "K", localArrayList);
      }
      return new g(this.b, localArrayList);
    }
    
    public b c(String paramString1, String paramString2)
    {
      e(paramString1, paramString2, this.a);
      return this;
    }
    
    public b f(long paramLong)
    {
      return c("ExposureTime", String.valueOf(paramLong / TimeUnit.SECONDS.toNanos(1L)));
    }
    
    public b g(r paramr)
    {
      if (paramr == r.a) {
        return this;
      }
      int i = g.a.a[paramr.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown flash state: ");
            localStringBuilder.append(paramr);
            n1.k("ExifData", localStringBuilder.toString());
            return this;
          }
          i = 1;
        }
        else
        {
          i = 32;
        }
      }
      else {
        i = 0;
      }
      if ((i & 0x1) == 1) {
        c("LightSource", String.valueOf(4));
      }
      return c("Flash", String.valueOf(i));
    }
    
    public b h(float paramFloat)
    {
      return c("FocalLength", new j((paramFloat * 1000.0F), 1000L).toString());
    }
    
    public b i(int paramInt)
    {
      return c("ImageLength", String.valueOf(paramInt));
    }
    
    public b j(int paramInt)
    {
      return c("ImageWidth", String.valueOf(paramInt));
    }
    
    public b k(int paramInt)
    {
      return c("SensitivityType", String.valueOf(3)).c("PhotographicSensitivity", String.valueOf(Math.min(65535, paramInt)));
    }
    
    public b l(float paramFloat)
    {
      return c("FNumber", String.valueOf(paramFloat));
    }
    
    public b m(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 90)
        {
          if (paramInt != 180)
          {
            if (paramInt != 270)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected orientation value: ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(". Must be one of 0, 90, 180, 270.");
              n1.k("ExifData", localStringBuilder.toString());
              paramInt = 0;
            }
            else
            {
              paramInt = 8;
            }
          }
          else {
            paramInt = 3;
          }
        }
        else {
          paramInt = 6;
        }
      }
      else {
        paramInt = 1;
      }
      return c("Orientation", String.valueOf(paramInt));
    }
    
    public b n(g.c paramc)
    {
      int i = g.a.b[paramc.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          paramc = null;
        } else {
          paramc = String.valueOf(1);
        }
      }
      else {
        paramc = String.valueOf(0);
      }
      return c("WhiteBalance", paramc);
    }
    
    class a
      implements Enumeration<HashMap<String, i>>
    {
      int a = 0;
      
      public HashMap<String, i> a()
      {
        HashMap localHashMap = new HashMap();
        i[] arrayOfi = g.i[this.a];
        int j = arrayOfi.length;
        int i = 0;
        while (i < j)
        {
          i locali = arrayOfi[i];
          localHashMap.put(locali.b, locali);
          i += 1;
        }
        this.a += 1;
        return localHashMap;
      }
      
      public boolean hasMoreElements()
      {
        return this.a < g.i.length;
      }
    }
    
    class b
      implements Enumeration<Map<String, f>>
    {
      int a = 0;
      
      b() {}
      
      public Map<String, f> a()
      {
        this.a += 1;
        return new HashMap();
      }
      
      public boolean hasMoreElements()
      {
        return this.a < g.i.length;
      }
    }
    
    class c
      implements Enumeration<Map<String, f>>
    {
      final Enumeration<Map<String, f>> a = Collections.enumeration(g.b.this.a);
      
      c() {}
      
      public Map<String, f> a()
      {
        return new HashMap((Map)this.a.nextElement());
      }
      
      public boolean hasMoreElements()
      {
        return this.a.hasMoreElements();
      }
    }
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("AUTO", 0);
      a = localc1;
      c localc2 = new c("MANUAL", 1);
      b = localc2;
      c = new c[] { localc1, localc2 };
    }
    
    private c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.g
 * JD-Core Version:    0.7.0.1
 */