package k2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import b2.h;
import b2.i;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import d2.v;
import e2.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import x2.k;

public final class m
{
  public static final b2.g<b2.b> f = b2.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b2.b.c);
  public static final b2.g<i> g = b2.g.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
  @Deprecated
  public static final b2.g<l> h = l.h;
  public static final b2.g<Boolean> i;
  public static final b2.g<Boolean> j;
  private static final Set<String> k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
  private static final b l = new a();
  private static final Set<ImageHeaderParser.ImageType> m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
  private static final Queue<BitmapFactory.Options> n = x2.l.f(0);
  private final d a;
  private final DisplayMetrics b;
  private final e2.b c;
  private final List<ImageHeaderParser> d;
  private final r e = r.b();
  
  static
  {
    Boolean localBoolean = Boolean.FALSE;
    i = b2.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", localBoolean);
    j = b2.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", localBoolean);
  }
  
  public m(List<ImageHeaderParser> paramList, DisplayMetrics paramDisplayMetrics, d paramd, e2.b paramb)
  {
    this.d = paramList;
    this.b = ((DisplayMetrics)k.d(paramDisplayMetrics));
    this.a = ((d)k.d(paramd));
    this.c = ((e2.b)k.d(paramb));
  }
  
  private static int a(double paramDouble)
  {
    int i1 = l(paramDouble);
    int i2 = x(i1 * paramDouble);
    return x(paramDouble / (i2 / i1) * i2);
  }
  
  private void b(s params, b2.b paramb, boolean paramBoolean1, boolean paramBoolean2, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if (this.e.i(paramInt1, paramInt2, paramOptions, paramBoolean1, paramBoolean2)) {
      return;
    }
    if (paramb != b2.b.a)
    {
      paramBoolean2 = false;
      try
      {
        paramBoolean1 = params.d().hasAlpha();
      }
      catch (IOException params)
      {
        paramBoolean1 = paramBoolean2;
        if (Log.isLoggable("Downsampler", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot determine whether the image has alpha or not from header, format ");
          localStringBuilder.append(paramb);
          Log.d("Downsampler", localStringBuilder.toString(), params);
          paramBoolean1 = paramBoolean2;
        }
      }
      if (paramBoolean1) {
        params = Bitmap.Config.ARGB_8888;
      } else {
        params = Bitmap.Config.RGB_565;
      }
      paramOptions.inPreferredConfig = params;
      if (params == Bitmap.Config.RGB_565) {
        paramOptions.inDither = true;
      }
      return;
    }
    paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
  }
  
  private static void c(ImageHeaderParser.ImageType paramImageType, s params, b paramb, d paramd, l paraml, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, BitmapFactory.Options paramOptions)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      int i2;
      int i4;
      if (r(paramInt1))
      {
        i2 = paramInt2;
        i4 = paramInt3;
      }
      else
      {
        i4 = paramInt2;
        i2 = paramInt3;
      }
      float f1 = paraml.b(i4, i2, paramInt4, paramInt5);
      if (f1 > 0.0F)
      {
        l.g localg1 = paraml.a(i4, i2, paramInt4, paramInt5);
        if (localg1 != null)
        {
          float f2 = i4;
          int i3 = x(f1 * f2);
          float f3 = i2;
          int i1 = x(f1 * f3);
          i3 = i4 / i3;
          i1 = i2 / i1;
          l.g localg2 = l.g.a;
          if (localg1 == localg2) {
            i1 = Math.max(i3, i1);
          } else {
            i1 = Math.min(i3, i1);
          }
          int i5 = Build.VERSION.SDK_INT;
          if ((i5 <= 23) && (k.contains(paramOptions.outMimeType)))
          {
            i3 = 1;
          }
          else
          {
            i3 = Math.max(1, Integer.highestOneBit(i1));
            i1 = i3;
            if (localg1 == localg2)
            {
              i1 = i3;
              if (i3 < 1.0F / f1) {
                i1 = i3 << 1;
              }
            }
            i3 = i1;
          }
          paramOptions.inSampleSize = i3;
          float f4;
          if (paramImageType == ImageHeaderParser.ImageType.JPEG)
          {
            f4 = Math.min(i3, 8);
            i5 = (int)Math.ceil(f2 / f4);
            i4 = (int)Math.ceil(f3 / f4);
            int i6 = i3 / 8;
            i1 = i4;
            i2 = i5;
            if (i6 > 0)
            {
              i2 = i5 / i6;
              i1 = i4 / i6;
            }
          }
          else
          {
            if ((paramImageType != ImageHeaderParser.ImageType.PNG) && (paramImageType != ImageHeaderParser.ImageType.PNG_A)) {
              if (paramImageType.isWebp())
              {
                if (i5 >= 24)
                {
                  f4 = i3;
                  i2 = Math.round(f2 / f4);
                  i1 = Math.round(f3 / f4);
                  break label477;
                }
              }
              else
              {
                if ((i4 % i3 == 0) && (i2 % i3 == 0))
                {
                  i4 /= i3;
                  i1 = i2 / i3;
                  i2 = i4;
                  break label477;
                }
                paramImageType = m(params, paramOptions, paramb, paramd);
                i2 = paramImageType[0];
                i1 = paramImageType[1];
                break label477;
              }
            }
            f4 = i3;
            i2 = (int)Math.floor(f2 / f4);
            i1 = (int)Math.floor(f3 / f4);
          }
          label477:
          double d1 = paraml.b(i2, i1, paramInt4, paramInt5);
          paramOptions.inTargetDensity = a(d1);
          paramOptions.inDensity = l(d1);
          if (s(paramOptions))
          {
            paramOptions.inScaled = true;
          }
          else
          {
            paramOptions.inTargetDensity = 0;
            paramOptions.inDensity = 0;
          }
          if (Log.isLoggable("Downsampler", 2))
          {
            paramImageType = new StringBuilder();
            paramImageType.append("Calculate scaling, source: [");
            paramImageType.append(paramInt2);
            paramImageType.append("x");
            paramImageType.append(paramInt3);
            paramImageType.append("], degreesToRotate: ");
            paramImageType.append(paramInt1);
            paramImageType.append(", target: [");
            paramImageType.append(paramInt4);
            paramImageType.append("x");
            paramImageType.append(paramInt5);
            paramImageType.append("], power of two scaled: [");
            paramImageType.append(i2);
            paramImageType.append("x");
            paramImageType.append(i1);
            paramImageType.append("], exact scale factor: ");
            paramImageType.append(f1);
            paramImageType.append(", power of 2 sample size: ");
            paramImageType.append(i3);
            paramImageType.append(", adjusted scale factor: ");
            paramImageType.append(d1);
            paramImageType.append(", target density: ");
            paramImageType.append(paramOptions.inTargetDensity);
            paramImageType.append(", density: ");
            paramImageType.append(paramOptions.inDensity);
            Log.v("Downsampler", paramImageType.toString());
          }
          return;
        }
        throw new IllegalArgumentException("Cannot round with null rounding");
      }
      paramImageType = new StringBuilder();
      paramImageType.append("Cannot scale with factor: ");
      paramImageType.append(f1);
      paramImageType.append(" from: ");
      paramImageType.append(paraml);
      paramImageType.append(", source: [");
      paramImageType.append(paramInt2);
      paramImageType.append("x");
      paramImageType.append(paramInt3);
      paramImageType.append("], target: [");
      paramImageType.append(paramInt4);
      paramImageType.append("x");
      paramImageType.append(paramInt5);
      paramImageType.append("]");
      throw new IllegalArgumentException(paramImageType.toString());
    }
    if (Log.isLoggable("Downsampler", 3))
    {
      params = new StringBuilder();
      params.append("Unable to determine dimensions for: ");
      params.append(paramImageType);
      params.append(" with target [");
      params.append(paramInt4);
      params.append("x");
      params.append(paramInt5);
      params.append("]");
      Log.d("Downsampler", params.toString());
    }
  }
  
  private v<Bitmap> g(s params, int paramInt1, int paramInt2, h paramh, b paramb)
  {
    byte[] arrayOfByte = (byte[])this.c.e(65536, [B.class);
    BitmapFactory.Options localOptions = k();
    localOptions.inTempStorage = arrayOfByte;
    b2.b localb = (b2.b)paramh.c(f);
    i locali = (i)paramh.c(g);
    l locall = (l)paramh.c(l.h);
    boolean bool2 = ((Boolean)paramh.c(i)).booleanValue();
    b2.g localg = j;
    boolean bool1;
    if ((paramh.c(localg) != null) && (((Boolean)paramh.c(localg)).booleanValue())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    try
    {
      params = e.f(h(params, localOptions, locall, localb, locali, bool1, paramInt1, paramInt2, bool2, paramb), this.a);
      return params;
    }
    finally
    {
      v(localOptions);
      this.c.d(arrayOfByte);
    }
  }
  
  private Bitmap h(s params, BitmapFactory.Options paramOptions, l paraml, b2.b paramb, i parami, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, b paramb1)
  {
    long l1 = x2.g.b();
    Object localObject = m(params, paramOptions, paramb1, this.a);
    int i5 = 0;
    int i3 = localObject[0];
    int i4 = localObject[1];
    localObject = paramOptions.outMimeType;
    if ((i3 != -1) && (i4 != -1)) {
      break label60;
    }
    paramBoolean1 = false;
    label60:
    int i8 = params.c();
    int i6 = z.g(i8);
    boolean bool = z.j(i8);
    int i1;
    if (paramInt1 == -2147483648)
    {
      if (r(i6)) {
        i1 = i4;
      } else {
        i1 = i3;
      }
    }
    else {
      i1 = paramInt1;
    }
    int i2 = paramInt2;
    if (i2 == -2147483648) {
      if (r(i6)) {
        i2 = i3;
      } else {
        i2 = i4;
      }
    }
    ImageHeaderParser.ImageType localImageType = params.d();
    c(localImageType, params, paramb1, this.a, paraml, i6, i3, i4, i1, i2, paramOptions);
    b(params, paramb, paramBoolean1, bool, paramOptions, i1, i2);
    int i9 = Build.VERSION.SDK_INT;
    i6 = paramOptions.inSampleSize;
    if (z(localImageType))
    {
      if ((i3 < 0) || (i4 < 0) || (!paramBoolean2))
      {
        float f1;
        if (s(paramOptions)) {
          f1 = paramOptions.inTargetDensity / paramOptions.inDensity;
        } else {
          f1 = 1.0F;
        }
        int i10 = paramOptions.inSampleSize;
        float f2 = i3;
        float f3 = i10;
        i2 = (int)Math.ceil(f2 / f3);
        i1 = (int)Math.ceil(i4 / f3);
        i6 = Math.round(i2 * f1);
        int i7 = Math.round(i1 * f1);
        paraml = "Downsampler";
        i1 = i6;
        i2 = i7;
        if (Log.isLoggable(paraml, 2))
        {
          paramb = new StringBuilder();
          paramb.append("Calculated target [");
          paramb.append(i6);
          paramb.append("x");
          paramb.append(i7);
          paramb.append("] for source [");
          paramb.append(i3);
          paramb.append("x");
          paramb.append(i4);
          paramb.append("], sampleSize: ");
          paramb.append(i10);
          paramb.append(", targetDensity: ");
          paramb.append(paramOptions.inTargetDensity);
          paramb.append(", density: ");
          paramb.append(paramOptions.inDensity);
          paramb.append(", density multiplier: ");
          paramb.append(f1);
          Log.v(paraml, paramb.toString());
          i2 = i7;
          i1 = i6;
        }
      }
      if ((i1 > 0) && (i2 > 0)) {
        y(paramOptions, this.a, i1, i2);
      }
    }
    if (parami != null)
    {
      if (i9 >= 28)
      {
        i1 = i5;
        if (parami == i.b)
        {
          paraml = paramOptions.outColorSpace;
          i1 = i5;
          if (paraml != null)
          {
            i1 = i5;
            if (paraml.isWideGamut()) {
              i1 = 1;
            }
          }
        }
        if (i1 != 0)
        {
          paraml = ColorSpace.Named.DISPLAY_P3;
          break label610;
        }
      }
      else
      {
        if (i9 < 26) {
          break label618;
        }
      }
      paraml = ColorSpace.Named.SRGB;
      label610:
      paramOptions.inPreferredColorSpace = ColorSpace.get(paraml);
    }
    label618:
    paraml = i(params, paramOptions, paramb1, this.a);
    paramb1.a(this.a, paraml);
    if (Log.isLoggable("Downsampler", 2)) {
      t(i3, i4, (String)localObject, paramOptions, paraml, paramInt1, paramInt2, l1);
    }
    params = null;
    if (paraml != null)
    {
      paraml.setDensity(this.b.densityDpi);
      paramOptions = z.k(this.a, paraml, i8);
      params = paramOptions;
      if (!paraml.equals(paramOptions))
      {
        this.a.d(paraml);
        params = paramOptions;
      }
    }
    return params;
  }
  
  /* Error */
  private static Bitmap i(s params, BitmapFactory.Options paramOptions, b paramb, d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 509	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   4: ifne +15 -> 19
    //   7: aload_2
    //   8: invokeinterface 511 1 0
    //   13: aload_0
    //   14: invokeinterface 512 1 0
    //   19: aload_1
    //   20: getfield 515	android/graphics/BitmapFactory$Options:outWidth	I
    //   23: istore 4
    //   25: aload_1
    //   26: getfield 518	android/graphics/BitmapFactory$Options:outHeight	I
    //   29: istore 5
    //   31: aload_1
    //   32: getfield 273	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   35: astore 6
    //   37: invokestatic 521	k2/z:f	()Ljava/util/concurrent/locks/Lock;
    //   40: invokeinterface 526 1 0
    //   45: aload_0
    //   46: aload_1
    //   47: invokeinterface 529 2 0
    //   52: astore 7
    //   54: invokestatic 521	k2/z:f	()Ljava/util/concurrent/locks/Lock;
    //   57: invokeinterface 532 1 0
    //   62: aload 7
    //   64: areturn
    //   65: astore_0
    //   66: goto +87 -> 153
    //   69: astore 7
    //   71: aload 7
    //   73: iload 4
    //   75: iload 5
    //   77: aload 6
    //   79: aload_1
    //   80: invokestatic 536	k2/m:u	(Ljava/lang/IllegalArgumentException;IILjava/lang/String;Landroid/graphics/BitmapFactory$Options;)Ljava/io/IOException;
    //   83: astore 6
    //   85: ldc 195
    //   87: iconst_3
    //   88: invokestatic 201	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   91: ifeq +14 -> 105
    //   94: ldc 195
    //   96: ldc_w 538
    //   99: aload 6
    //   101: invokestatic 220	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   104: pop
    //   105: aload_1
    //   106: getfield 542	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   109: astore 7
    //   111: aload 7
    //   113: ifnull +37 -> 150
    //   116: aload_3
    //   117: aload 7
    //   119: invokeinterface 506 2 0
    //   124: aload_1
    //   125: aconst_null
    //   126: putfield 542	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: aload_3
    //   133: invokestatic 481	k2/m:i	(Lk2/s;Landroid/graphics/BitmapFactory$Options;Lk2/m$b;Le2/d;)Landroid/graphics/Bitmap;
    //   136: astore_0
    //   137: invokestatic 521	k2/z:f	()Ljava/util/concurrent/locks/Lock;
    //   140: invokeinterface 532 1 0
    //   145: aload_0
    //   146: areturn
    //   147: aload 6
    //   149: athrow
    //   150: aload 6
    //   152: athrow
    //   153: invokestatic 521	k2/z:f	()Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 532 1 0
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: goto -17 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	params	s
    //   0	167	1	paramOptions	BitmapFactory.Options
    //   0	167	2	paramb	b
    //   0	167	3	paramd	d
    //   23	51	4	i1	int
    //   29	47	5	i2	int
    //   35	116	6	localObject	Object
    //   52	11	7	localBitmap1	Bitmap
    //   69	3	7	localIllegalArgumentException	IllegalArgumentException
    //   109	9	7	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   45	54	65	finally
    //   71	105	65	finally
    //   105	111	65	finally
    //   116	137	65	finally
    //   147	150	65	finally
    //   150	153	65	finally
    //   45	54	69	java/lang/IllegalArgumentException
    //   116	137	163	java/io/IOException
  }
  
  @TargetApi(19)
  private static String j(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(paramBitmap.getAllocationByteCount());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramBitmap.getConfig());
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static BitmapFactory.Options k()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 139	k2/m:n	Ljava/util/Queue;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: invokeinterface 574 1 0
    //   15: checkcast 231	android/graphics/BitmapFactory$Options
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: ifnonnull +15 -> 39
    //   27: new 231	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 575	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore_0
    //   35: aload_0
    //   36: invokestatic 578	k2/m:w	(Landroid/graphics/BitmapFactory$Options;)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	5	0	localObject2	Object
    //   18	6	1	localOptions	BitmapFactory.Options
    //   44	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	44	finally
    //   45	47	44	finally
    //   3	9	49	finally
    //   27	39	49	finally
    //   47	49	49	finally
  }
  
  private static int l(double paramDouble)
  {
    if (paramDouble > 1.0D) {
      paramDouble = 1.0D / paramDouble;
    }
    return (int)Math.round(paramDouble * 2147483647.0D);
  }
  
  private static int[] m(s params, BitmapFactory.Options paramOptions, b paramb, d paramd)
  {
    paramOptions.inJustDecodeBounds = true;
    i(params, paramOptions, paramb, paramd);
    paramOptions.inJustDecodeBounds = false;
    return new int[] { paramOptions.outWidth, paramOptions.outHeight };
  }
  
  private static String n(BitmapFactory.Options paramOptions)
  {
    return j(paramOptions.inBitmap);
  }
  
  private static boolean r(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 270);
  }
  
  private static boolean s(BitmapFactory.Options paramOptions)
  {
    int i1 = paramOptions.inTargetDensity;
    if (i1 > 0)
    {
      int i2 = paramOptions.inDensity;
      if ((i2 > 0) && (i1 != i2)) {
        return true;
      }
    }
    return false;
  }
  
  private static void t(int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions, Bitmap paramBitmap, int paramInt3, int paramInt4, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Decoded ");
    localStringBuilder.append(j(paramBitmap));
    localStringBuilder.append(" from [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" with inBitmap ");
    localStringBuilder.append(n(paramOptions));
    localStringBuilder.append(" for [");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("], sample size: ");
    localStringBuilder.append(paramOptions.inSampleSize);
    localStringBuilder.append(", density: ");
    localStringBuilder.append(paramOptions.inDensity);
    localStringBuilder.append(", target density: ");
    localStringBuilder.append(paramOptions.inTargetDensity);
    localStringBuilder.append(", thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(", duration: ");
    localStringBuilder.append(x2.g.a(paramLong));
    Log.v("Downsampler", localStringBuilder.toString());
  }
  
  private static IOException u(IllegalArgumentException paramIllegalArgumentException, int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception decoding bitmap, outWidth: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", outHeight: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", outMimeType: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", inBitmap: ");
    localStringBuilder.append(n(paramOptions));
    return new IOException(localStringBuilder.toString(), paramIllegalArgumentException);
  }
  
  private static void v(BitmapFactory.Options paramOptions)
  {
    w(paramOptions);
    synchronized (n)
    {
      ???.offer(paramOptions);
      return;
    }
  }
  
  private static void w(BitmapFactory.Options paramOptions)
  {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inDensity = 0;
    paramOptions.inTargetDensity = 0;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramOptions.inPreferredColorSpace = null;
      paramOptions.outColorSpace = null;
      paramOptions.outConfig = null;
    }
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    paramOptions.inBitmap = null;
    paramOptions.inMutable = true;
  }
  
  private static int x(double paramDouble)
  {
    return (int)(paramDouble + 0.5D);
  }
  
  @TargetApi(26)
  private static void y(BitmapFactory.Options paramOptions, d paramd, int paramInt1, int paramInt2)
  {
    Bitmap.Config localConfig1;
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramOptions.inPreferredConfig == Bitmap.Config.HARDWARE) {
        return;
      }
      localConfig1 = paramOptions.outConfig;
    }
    else
    {
      localConfig1 = null;
    }
    Bitmap.Config localConfig2 = localConfig1;
    if (localConfig1 == null) {
      localConfig2 = paramOptions.inPreferredConfig;
    }
    paramOptions.inBitmap = paramd.e(paramInt1, paramInt2, localConfig2);
  }
  
  private boolean z(ImageHeaderParser.ImageType paramImageType)
  {
    return true;
  }
  
  public v<Bitmap> d(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, h paramh)
  {
    return g(new s.c(paramParcelFileDescriptor, this.d, this.c), paramInt1, paramInt2, paramh, l);
  }
  
  public v<Bitmap> e(InputStream paramInputStream, int paramInt1, int paramInt2, h paramh, b paramb)
  {
    return g(new s.b(paramInputStream, this.d, this.c), paramInt1, paramInt2, paramh, paramb);
  }
  
  public v<Bitmap> f(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, h paramh)
  {
    return g(new s.a(paramByteBuffer, this.d, this.c), paramInt1, paramInt2, paramh, l);
  }
  
  public boolean o(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    return ParcelFileDescriptorRewinder.c();
  }
  
  public boolean p(InputStream paramInputStream)
  {
    return true;
  }
  
  public boolean q(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  class a
    implements m.b
  {
    public void a(d paramd, Bitmap paramBitmap) {}
    
    public void b() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(d paramd, Bitmap paramBitmap);
    
    public abstract void b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.m
 * JD-Core Version:    0.7.0.1
 */