package q0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.util.concurrent.ConcurrentHashMap;
import p0.e.b;
import v0.f.b;

class k
{
  @SuppressLint({"BanConcurrentHashMap"})
  private ConcurrentHashMap<Long, e.b> a = new ConcurrentHashMap();
  
  private static <T> T e(T[] paramArrayOfT, int paramInt, b<T> paramb)
  {
    int i;
    if ((paramInt & 0x1) == 0) {
      i = 400;
    } else {
      i = 700;
    }
    int i1;
    if ((paramInt & 0x2) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = null;
    int j = 2147483647;
    int n = paramArrayOfT.length;
    paramInt = 0;
    while (paramInt < n)
    {
      T ? = paramArrayOfT[paramInt];
      int m = Math.abs(paramb.a(?) - i);
      int k;
      if (paramb.b(?) == i1) {
        k = 0;
      } else {
        k = 1;
      }
      m = m * 2 + k;
      if (localObject != null)
      {
        k = j;
        if (j <= m) {}
      }
      else
      {
        localObject = ?;
        k = m;
      }
      paramInt += 1;
      j = k;
    }
    return localObject;
  }
  
  public Typeface a(Context paramContext, e.b paramb, Resources paramResources, int paramInt)
  {
    throw null;
  }
  
  public Typeface b(Context paramContext, CancellationSignal paramCancellationSignal, f.b[] paramArrayOfb, int paramInt)
  {
    throw null;
  }
  
  /* Error */
  protected Typeface c(Context paramContext, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 53	q0/l:e	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: invokestatic 57	q0/l:d	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +10 -> 28
    //   21: aload_1
    //   22: invokevirtual 63	java/io/File:delete	()Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_1
    //   29: invokevirtual 67	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokestatic 73	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 63	java/io/File:delete	()Z
    //   40: pop
    //   41: aload_2
    //   42: areturn
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 63	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: athrow
    //   51: aload_1
    //   52: invokevirtual 63	java/io/File:delete	()Z
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: goto -8 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	k
    //   0	62	1	paramContext	Context
    //   0	62	2	paramInputStream	java.io.InputStream
    //   16	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	17	43	finally
    //   28	36	43	finally
    //   11	17	58	java/lang/RuntimeException
    //   28	36	58	java/lang/RuntimeException
  }
  
  /* Error */
  public Typeface d(Context paramContext, Resources paramResources, int paramInt1, java.lang.String paramString, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 53	q0/l:e	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: iload_3
    //   14: invokestatic 77	q0/l:c	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   17: istore 6
    //   19: iload 6
    //   21: ifne +10 -> 31
    //   24: aload_1
    //   25: invokevirtual 63	java/io/File:delete	()Z
    //   28: pop
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 67	java/io/File:getPath	()Ljava/lang/String;
    //   35: invokestatic 73	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 63	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 63	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: athrow
    //   54: aload_1
    //   55: invokevirtual 63	java/io/File:delete	()Z
    //   58: pop
    //   59: aconst_null
    //   60: areturn
    //   61: astore_2
    //   62: goto -8 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	k
    //   0	65	1	paramContext	Context
    //   0	65	2	paramResources	Resources
    //   0	65	3	paramInt1	int
    //   0	65	4	paramString	java.lang.String
    //   0	65	5	paramInt2	int
    //   17	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	19	46	finally
    //   31	39	46	finally
    //   11	19	61	java/lang/RuntimeException
    //   31	39	61	java/lang/RuntimeException
  }
  
  protected f.b f(f.b[] paramArrayOfb, int paramInt)
  {
    return (f.b)e(paramArrayOfb, paramInt, new a());
  }
  
  class a
    implements k.b<f.b>
  {
    a() {}
    
    public int c(f.b paramb)
    {
      return paramb.e();
    }
    
    public boolean d(f.b paramb)
    {
      return paramb.f();
    }
  }
  
  private static abstract interface b<T>
  {
    public abstract int a(T paramT);
    
    public abstract boolean b(T paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.k
 * JD-Core Version:    0.7.0.1
 */