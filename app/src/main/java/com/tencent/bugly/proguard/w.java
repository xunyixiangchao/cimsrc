package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class w
  implements Runnable
{
  private int a = 2;
  private int b = 30000;
  private final Context c;
  private final int d;
  private final byte[] e;
  private final com.tencent.bugly.crashreport.common.info.a f;
  private final com.tencent.bugly.crashreport.common.strategy.a g;
  private final s h;
  private final v i;
  private final int j;
  private final u k;
  private final u l;
  private String m = null;
  private final String n;
  private final Map<String, String> o;
  private int p = 0;
  private long q = 0L;
  private long r = 0L;
  private boolean s = false;
  
  public w(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, u paramu, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.c = paramContext;
    this.f = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.e = paramArrayOfByte;
    this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.h = s.a(paramContext);
    this.i = v.a();
    this.j = paramInt1;
    this.m = paramString1;
    this.n = paramString2;
    this.k = paramu;
    this.l = null;
    this.d = paramInt2;
    if (paramInt3 > 0) {
      this.a = paramInt3;
    }
    if (paramInt4 > 0) {
      this.b = paramInt4;
    }
    this.s = paramBoolean;
    this.o = paramMap;
  }
  
  public w(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, u paramu, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramu, 2, 30000, paramBoolean2, null);
  }
  
  private Pair<Boolean, Boolean> a(Map<String, String> paramMap)
  {
    Object localObject = Integer.valueOf(1);
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      if (!paramMap.containsKey("status"))
      {
        y.d("[Upload] Headers does not contain %s", new Object[] { "status" });
      }
      else if (!paramMap.containsKey("Bugly-Version"))
      {
        y.d("[Upload] Headers does not contain %s", new Object[] { "Bugly-Version" });
      }
      else
      {
        String str = (String)paramMap.get("Bugly-Version");
        if (!str.contains("bugly"))
        {
          y.d("[Upload] Bugly version is not valid: %s", new Object[] { str });
        }
        else
        {
          y.c("[Upload] Bugly version from headers is: %s", new Object[] { str });
          i1 = 1;
          break label153;
        }
      }
    }
    else {
      y.d("[Upload] Headers is empty.", new Object[0]);
    }
    int i1 = 0;
    label153:
    if (i1 == 0)
    {
      y.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      y.e("[Upload] Failed to upload(%d): %s", new Object[] { localObject, "[Upload] Failed to upload for no status header." });
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          y.c(String.format("[key]: %s, [value]: %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() }), new Object[0]);
        }
      }
      y.c("[Upload] Failed to upload for no status header.", new Object[0]);
      return new Pair(Boolean.FALSE, Boolean.TRUE);
    }
    i1 = -1;
    try
    {
      int i2 = Integer.parseInt((String)paramMap.get("status"));
      i1 = i2;
      y.c("[Upload] Status from server is %d (pid=%d | tid=%d).", new Object[] { Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      if (i2 != 0)
      {
        paramMap = new StringBuilder("status of server is ");
        paramMap.append(i2);
        a(null, false, 1, paramMap.toString());
        paramMap = Boolean.FALSE;
        return new Pair(paramMap, paramMap);
      }
      paramMap = Boolean.TRUE;
      return new Pair(paramMap, paramMap);
    }
    finally
    {
      label418:
      break label418;
    }
    paramMap = new StringBuilder("[Upload] Failed to upload for format of status header is invalid: ");
    paramMap.append(Integer.toString(i1));
    y.e("[Upload] Failed to upload(%d): %s", new Object[] { localObject, paramMap.toString() });
    return new Pair(Boolean.FALSE, Boolean.TRUE);
  }
  
  private Pair<Boolean, Boolean> a(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    if (paramArrayOfByte == null)
    {
      y.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "Failed to upload for no response!" });
      return new Pair(Boolean.FALSE, Boolean.TRUE);
    }
    y.c("[Upload] Received %d bytes", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (paramArrayOfByte.length == 0)
    {
      a(null, false, 1, "response data from server is empty");
      if (paramMap != null)
      {
        paramArrayOfByte = paramMap.entrySet().iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramMap = (Map.Entry)paramArrayOfByte.next();
          y.c("[Upload] HTTP headers from server: key = %s, value = %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        }
      }
      paramArrayOfByte = Boolean.FALSE;
      return new Pair(paramArrayOfByte, paramArrayOfByte);
    }
    paramArrayOfByte = Boolean.TRUE;
    return new Pair(paramArrayOfByte, paramArrayOfByte);
  }
  
  private static String a(String paramString)
  {
    if (ab.a(paramString)) {
      return paramString;
    }
    try
    {
      String str = String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
      return str;
    }
    finally
    {
      y.a(localThrowable);
    }
    return paramString;
  }
  
  private void a(ao paramao, boolean paramBoolean, int paramInt, String paramString)
  {
    int i1 = this.d;
    if (i1 != 630)
    {
      if (i1 != 640)
      {
        if (i1 == 830) {
          break label54;
        }
        if (i1 != 840)
        {
          paramao = String.valueOf(i1);
          break label58;
        }
      }
      paramao = "userinfo";
      break label58;
    }
    label54:
    paramao = "crash";
    label58:
    if (paramBoolean) {
      y.a("[Upload] Success: %s", new Object[] { paramao });
    } else {
      y.e("[Upload] Failed to upload(%d) %s: %s", new Object[] { Integer.valueOf(paramInt), paramao, paramString });
    }
    if (this.q + this.r > 0L)
    {
      long l1 = this.i.a(this.s);
      long l2 = this.q;
      long l3 = this.r;
      this.i.a(l1 + l2 + l3, this.s);
    }
    paramao = this.k;
    if (paramao != null) {
      paramao.a(paramBoolean, paramString);
    }
    paramao = this.l;
    if (paramao != null) {
      paramao.a(paramBoolean, paramString);
    }
  }
  
  /* Error */
  private static boolean a(ao paramao, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: ldc_w 306
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 133	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 311	com/tencent/bugly/proguard/ao:a	B
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq +23 -> 46
    //   26: ldc_w 313
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_3
    //   36: invokestatic 318	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   39: aastore
    //   40: invokestatic 171	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   43: pop
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 320	com/tencent/bugly/proguard/ao:e	Ljava/lang/String;
    //   50: invokestatic 268	com/tencent/bugly/proguard/ab:a	(Ljava/lang/String;)Z
    //   53: ifne +63 -> 116
    //   56: invokestatic 323	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   59: invokevirtual 325	com/tencent/bugly/crashreport/common/info/a:m	()Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 320	com/tencent/bugly/proguard/ao:e	Ljava/lang/String;
    //   66: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +47 -> 116
    //   72: invokestatic 333	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   75: getstatic 334	com/tencent/bugly/crashreport/common/strategy/a:a	I
    //   78: ldc_w 336
    //   81: aload_0
    //   82: getfield 320	com/tencent/bugly/proguard/ao:e	Ljava/lang/String;
    //   85: ldc_w 338
    //   88: invokevirtual 342	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   91: aconst_null
    //   92: iconst_1
    //   93: invokevirtual 345	com/tencent/bugly/proguard/o:a	(ILjava/lang/String;[BLcom/tencent/bugly/proguard/n;Z)Z
    //   96: pop
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 320	com/tencent/bugly/proguard/ao:e	Ljava/lang/String;
    //   102: invokevirtual 347	com/tencent/bugly/crashreport/common/info/a:f	(Ljava/lang/String;)V
    //   105: goto +11 -> 116
    //   108: astore 5
    //   110: aload 5
    //   112: invokestatic 280	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   115: pop
    //   116: aload_1
    //   117: aload_0
    //   118: getfield 349	com/tencent/bugly/proguard/ao:d	J
    //   121: putfield 351	com/tencent/bugly/crashreport/common/info/a:h	J
    //   124: aload_0
    //   125: getfield 352	com/tencent/bugly/proguard/ao:b	I
    //   128: istore 4
    //   130: iload 4
    //   132: sipush 510
    //   135: if_icmpne +76 -> 211
    //   138: aload_0
    //   139: getfield 354	com/tencent/bugly/proguard/ao:c	[B
    //   142: astore_1
    //   143: aload_1
    //   144: ifnonnull +24 -> 168
    //   147: ldc_w 356
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: iload 4
    //   158: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: invokestatic 171	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   165: pop
    //   166: iconst_0
    //   167: ireturn
    //   168: aload_1
    //   169: ldc_w 358
    //   172: invokestatic 363	com/tencent/bugly/proguard/a:a	([BLjava/lang/Class;)Lcom/tencent/bugly/proguard/j;
    //   175: checkcast 358	com/tencent/bugly/proguard/aq
    //   178: astore_1
    //   179: aload_1
    //   180: ifnonnull +26 -> 206
    //   183: ldc_w 365
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_0
    //   193: getfield 352	com/tencent/bugly/proguard/ao:b	I
    //   196: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: invokestatic 171	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   203: pop
    //   204: iconst_0
    //   205: ireturn
    //   206: aload_2
    //   207: aload_1
    //   208: invokevirtual 368	com/tencent/bugly/crashreport/common/strategy/a:a	(Lcom/tencent/bugly/proguard/aq;)V
    //   211: iconst_1
    //   212: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramao	ao
    //   0	213	1	parama	com.tencent.bugly.crashreport.common.info.a
    //   0	213	2	parama1	com.tencent.bugly.crashreport.common.strategy.a
    //   21	15	3	b1	byte
    //   128	29	4	i1	int
    //   108	3	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	105	108	finally
  }
  
  public final void a(long paramLong)
  {
    this.p += 1;
    this.q += paramLong;
  }
  
  public final void b(long paramLong)
  {
    this.r += paramLong;
  }
  
  public final void run()
  {
    for (;;)
    {
      int i3;
      Object localObject3;
      try
      {
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        if (b.b(this.c) == null)
        {
          localObject1 = "network is not available";
        }
        else
        {
          localObject1 = this.e;
          if ((localObject1 == null) || (localObject1.length == 0)) {
            break label878;
          }
          if ((this.c == null) || (this.f == null)) {
            break label870;
          }
          localObject1 = this.g;
          if ((localObject1 == null) || (this.h == null)) {
            break label870;
          }
          if (((com.tencent.bugly.crashreport.common.strategy.a)localObject1).c() != null) {
            break label864;
          }
          localObject1 = "illegal local strategy";
        }
        if (localObject1 != null)
        {
          a(null, false, 0, (String)localObject1);
          return;
        }
        byte[] arrayOfByte = ab.a(this.e, 2);
        if (arrayOfByte == null)
        {
          a(null, false, 0, "failed to zip request body");
          return;
        }
        HashMap localHashMap = new HashMap(10);
        localHashMap.put("tls", "1");
        localHashMap.put("prodId", this.f.f());
        localHashMap.put("bundleId", this.f.c);
        localHashMap.put("appVer", this.f.i);
        Object localObject1 = this.o;
        if (localObject1 != null) {
          localHashMap.putAll((Map)localObject1);
        }
        localHashMap.put("cmd", Integer.toString(this.d));
        localHashMap.put("platformId", Byte.toString((byte)1));
        localHashMap.put("sdkVer", this.f.f);
        localHashMap.put("strategylastUpdateTime", Long.toString(this.g.c().n));
        this.i.a(this.j, System.currentTimeMillis());
        localObject1 = this.k;
        localObject1 = this.l;
        localObject1 = this.m;
        this.g.c();
        i1 = 0;
        i2 = i1;
        i3 = i1 + 1;
        if (i1 < this.a)
        {
          localObject3 = localObject1;
          if (i3 > 1)
          {
            y.d("[Upload] Failed to upload last time, wait and try(%d) again.", new Object[] { Integer.valueOf(i3) });
            ab.b(this.b);
            localObject3 = localObject1;
            if (i3 == this.a)
            {
              y.d("[Upload] Use the back-up url at the last time: %s", new Object[] { this.n });
              localObject3 = this.n;
            }
          }
          y.c("[Upload] Send %d bytes", new Object[] { Integer.valueOf(arrayOfByte.length) });
          localObject3 = a((String)localObject3);
          y.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", new Object[] { localObject3, Integer.valueOf(this.d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          localObject1 = this.h.a((String)localObject3, arrayOfByte, this, localHashMap);
          Object localObject4 = this.h.a;
          Pair localPair = a((byte[])localObject1, (Map)localObject4);
          if (!((Boolean)localPair.first).booleanValue())
          {
            localObject1 = (Boolean)localPair.second;
            bool = ((Boolean)localObject1).booleanValue();
            break label889;
          }
          localObject4 = a((Map)localObject4);
          if (!((Boolean)((Pair)localObject4).first).booleanValue())
          {
            localObject1 = (Boolean)((Pair)localObject4).second;
            continue;
          }
          localObject4 = ab.b((byte[])localObject1, 2);
          if (localObject4 != null) {
            localObject1 = localObject4;
          }
          localObject1 = a.b((byte[])localObject1);
          if (localObject1 == null)
          {
            a(null, false, 1, "failed to decode response package");
            localObject1 = Boolean.FALSE;
            localObject1 = new Pair(localObject1, localObject1);
          }
          else
          {
            i2 = ((ao)localObject1).b;
            localObject4 = ((ao)localObject1).c;
            if (localObject4 == null) {
              i1 = 0;
            } else {
              i1 = localObject4.length;
            }
            y.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
            if (!a((ao)localObject1, this.f, this.g))
            {
              a((ao)localObject1, false, 2, "failed to process response package");
              localObject1 = Boolean.FALSE;
              localObject1 = new Pair(localObject1, localObject1);
            }
            else
            {
              a((ao)localObject1, true, 2, "successfully uploaded");
              localObject1 = Boolean.TRUE;
              localObject1 = new Pair(localObject1, localObject1);
            }
          }
          if (((Boolean)((Pair)localObject1).first).booleanValue()) {
            break label886;
          }
          localObject1 = (Boolean)((Pair)localObject1).second;
          continue;
        }
        a(null, false, i2, "failed after many attempts");
        return;
      }
      finally
      {
        if (!y.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        return;
      }
      label864:
      Object localObject2 = null;
      continue;
      label870:
      localObject2 = "illegal access error";
      continue;
      label878:
      localObject2 = "request package is empty!";
      continue;
      label886:
      boolean bool = false;
      label889:
      if (!bool) {
        break;
      }
      int i2 = 1;
      int i1 = i3;
      localObject2 = localObject3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.w
 * JD-Core Version:    0.7.0.1
 */