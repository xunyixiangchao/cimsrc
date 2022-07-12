package x2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class l
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static final char[] b = new char[64];
  private static volatile Handler c;
  
  public static void a()
  {
    if (q()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on a background thread");
  }
  
  public static void b()
  {
    if (r()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on the main thread");
  }
  
  public static boolean c(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    if ((paramObject1 instanceof h2.l)) {
      return ((h2.l)paramObject1).a(paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean d(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static String e(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar = a;
      paramArrayOfChar[k] = arrayOfChar[(j >>> 4)];
      paramArrayOfChar[(k + 1)] = arrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(paramArrayOfChar);
  }
  
  public static <T> Queue<T> f(int paramInt)
  {
    return new ArrayDeque(paramInt);
  }
  
  public static int g(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * i(paramConfig);
  }
  
  @TargetApi(19)
  public static int h(Bitmap paramBitmap)
  {
    if (!paramBitmap.isRecycled()) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      label14:
      StringBuilder localStringBuilder;
      break label14;
    }
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot obtain size for recycled Bitmap: ");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append("[");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramBitmap.getConfig());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static int i(Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.ARGB_8888;
    }
    int i = a.a[localConfig.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 4) {
          return 4;
        }
        return 8;
      }
      return 2;
    }
    return 1;
  }
  
  public static <T> List<T> j(Collection<T> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private static Handler k()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return c;
  }
  
  public static int l(float paramFloat)
  {
    return m(paramFloat, 17);
  }
  
  public static int m(float paramFloat, int paramInt)
  {
    return n(Float.floatToIntBits(paramFloat), paramInt);
  }
  
  public static int n(int paramInt1, int paramInt2)
  {
    return paramInt2 * 31 + paramInt1;
  }
  
  public static int o(Object paramObject, int paramInt)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return n(i, paramInt);
  }
  
  public static int p(boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean q()
  {
    return r() ^ true;
  }
  
  public static boolean r()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private static boolean s(int paramInt)
  {
    return (paramInt > 0) || (paramInt == -2147483648);
  }
  
  public static boolean t(int paramInt1, int paramInt2)
  {
    return (s(paramInt1)) && (s(paramInt2));
  }
  
  public static void u(Runnable paramRunnable)
  {
    k().post(paramRunnable);
  }
  
  public static void v(Runnable paramRunnable)
  {
    k().removeCallbacks(paramRunnable);
  }
  
  public static String w(byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      paramArrayOfByte = e(paramArrayOfByte, ???);
      return paramArrayOfByte;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.l
 * JD-Core Version:    0.7.0.1
 */