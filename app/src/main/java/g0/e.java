package g0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class e<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int e(K paramK, V paramV)
  {
    int i = f(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected V a(K paramK)
  {
    return null;
  }
  
  protected void b(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  /* Error */
  public final V c(K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 71
    //   3: invokestatic 77	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	g0/e:a	Ljava/util/LinkedHashMap;
    //   13: aload_1
    //   14: invokevirtual 80	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +17 -> 36
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 82	g0/e:g	I
    //   27: iconst_1
    //   28: iadd
    //   29: putfield 82	g0/e:g	I
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 84	g0/e:h	I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 84	g0/e:h	I
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 86	g0/e:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnonnull +5 -> 60
    //   58: aconst_null
    //   59: areturn
    //   60: aload_0
    //   61: monitorenter
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 88	g0/e:e	I
    //   67: iconst_1
    //   68: iadd
    //   69: putfield 88	g0/e:e	I
    //   72: aload_0
    //   73: getfield 31	g0/e:a	Ljava/util/LinkedHashMap;
    //   76: aload_1
    //   77: aload_2
    //   78: invokevirtual 92	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +16 -> 99
    //   86: aload_0
    //   87: getfield 31	g0/e:a	Ljava/util/LinkedHashMap;
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual 92	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: goto +18 -> 114
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 94	g0/e:b	I
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial 96	g0/e:e	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   110: iadd
    //   111: putfield 94	g0/e:b	I
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: ifnull +13 -> 130
    //   120: aload_0
    //   121: iconst_0
    //   122: aload_1
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 98	g0/e:b	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: aload_3
    //   129: areturn
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 23	g0/e:c	I
    //   135: invokevirtual 100	g0/e:g	(I)V
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	e
    //   0	150	1	paramK	K
    //   17	122	2	localObject1	Object
    //   81	48	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	82	140	finally
    //   86	96	140	finally
    //   99	114	140	finally
    //   114	116	140	finally
    //   141	143	140	finally
    //   9	18	145	finally
    //   22	34	145	finally
    //   36	48	145	finally
    //   146	148	145	finally
  }
  
  public final V d(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.b += e(paramK, paramV);
        Object localObject = this.a.put(paramK, paramV);
        if (localObject != null) {
          this.b -= e(paramK, localObject);
        }
        if (localObject != null) {
          b(false, paramK, localObject, paramV);
        }
        g(this.c);
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  protected int f(K paramK, V paramV)
  {
    return 1;
  }
  
  public void g(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b >= 0) && ((!this.a.isEmpty()) || (this.b == 0)))
        {
          if ((this.b > paramInt) && (!this.a.isEmpty()))
          {
            Object localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
            localObject1 = ((Map.Entry)localObject3).getKey();
            localObject3 = ((Map.Entry)localObject3).getValue();
            this.a.remove(localObject1);
            this.b -= e(localObject1, localObject3);
            this.f += 1;
            b(true, localObject1, localObject3, null);
            continue;
          }
          return;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getClass().getName());
        ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      finally {}
    }
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.g;
        int j = this.h + i;
        if (j != 0)
        {
          i = i * 100 / j;
          String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g0.e
 * JD-Core Version:    0.7.0.1
 */