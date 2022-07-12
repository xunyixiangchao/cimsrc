package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.List;
import java.util.Map;

public final class a
{
  public static int a = 1000;
  private static a b;
  private static String h;
  private final List<com.tencent.bugly.a> c;
  private final x d;
  private final StrategyBean e;
  private StrategyBean f = null;
  private Context g;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    this.g = paramContext;
    if (com.tencent.bugly.crashreport.common.info.a.a(paramContext) != null)
    {
      paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext).x;
      if ("oversea".equals(paramContext)) {}
      for (paramContext = "https://astat.bugly.qcloud.com/rqd/async";; paramContext = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async")
      {
        StrategyBean.a = paramContext;
        StrategyBean.b = paramContext;
        break;
        if (!"na_https".equals(paramContext)) {
          break;
        }
      }
    }
    this.e = new StrategyBean();
    this.c = paramList;
    this.d = x.a();
  }
  
  public static a a()
  {
    try
    {
      a locala = b;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (b == null) {
        b = new a(paramContext, paramList);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((!ab.a(paramString)) && (ab.c(paramString)))
    {
      h = paramString;
      return;
    }
    y.d("URL user set is invalid.", new Object[0]);
  }
  
  public static StrategyBean d()
  {
    Object localObject = o.a().a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((q)((List)localObject).get(0)).g;
      if (localObject != null) {
        return (StrategyBean)ab.a((byte[])localObject, StrategyBean.CREATOR);
      }
    }
    return null;
  }
  
  public final void a(long paramLong)
  {
    this.d.a(new a(), paramLong);
  }
  
  /* Error */
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 145
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc 147
    //   10: invokevirtual 152	java/lang/Class:getName	()Ljava/lang/String;
    //   13: aastore
    //   14: invokestatic 154	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aload_1
    //   19: iload_2
    //   20: invokestatic 156	com/tencent/bugly/crashreport/biz/b:a	(Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;Z)V
    //   23: aload_0
    //   24: getfield 67	com/tencent/bugly/crashreport/common/strategy/a:c	Ljava/util/List;
    //   27: invokeinterface 160 1 0
    //   32: astore_3
    //   33: aload_3
    //   34: invokeinterface 166 1 0
    //   39: ifeq +62 -> 101
    //   42: aload_3
    //   43: invokeinterface 170 1 0
    //   48: checkcast 172	com/tencent/bugly/a
    //   51: astore 4
    //   53: ldc 145
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload 4
    //   63: invokevirtual 176	java/lang/Object:getClass	()Ljava/lang/Class;
    //   66: invokevirtual 152	java/lang/Class:getName	()Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 154	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload 4
    //   76: aload_1
    //   77: invokevirtual 180	com/tencent/bugly/a:onServerStrategyChanged	(Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;)V
    //   80: goto -47 -> 33
    //   83: astore 4
    //   85: aload 4
    //   87: invokestatic 183	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   90: ifne -57 -> 33
    //   93: aload 4
    //   95: invokevirtual 188	java/lang/Throwable:printStackTrace	()V
    //   98: goto -65 -> 33
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	paramStrategyBean	StrategyBean
    //   0	102	2	paramBoolean	boolean
    //   32	11	3	localIterator	java.util.Iterator
    //   51	24	4	locala	com.tencent.bugly.a
    //   83	11	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	80	83	finally
  }
  
  public final void a(aq paramaq)
  {
    if (paramaq == null) {
      return;
    }
    StrategyBean localStrategyBean = this.f;
    if ((localStrategyBean != null) && (paramaq.h == localStrategyBean.n)) {
      return;
    }
    localStrategyBean = new StrategyBean();
    localStrategyBean.e = paramaq.a;
    localStrategyBean.g = paramaq.c;
    localStrategyBean.f = paramaq.b;
    if ((ab.a(h)) || (!ab.c(h)))
    {
      if (ab.c(paramaq.d))
      {
        y.c("[Strategy] Upload url changes to %s", new Object[] { paramaq.d });
        localStrategyBean.p = paramaq.d;
      }
      if (ab.c(paramaq.e))
      {
        y.c("[Strategy] Exception upload url changes to %s", new Object[] { paramaq.e });
        localStrategyBean.q = paramaq.e;
      }
    }
    Object localObject = paramaq.f;
    if ((localObject != null) && (!ab.a(((ap)localObject).a))) {
      localStrategyBean.r = paramaq.f.a;
    }
    long l = paramaq.h;
    if (l != 0L) {
      localStrategyBean.n = l;
    }
    localObject = paramaq.g;
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      localObject = paramaq.g;
      localStrategyBean.s = ((Map)localObject);
      localObject = (String)((Map)localObject).get("B11");
      boolean bool;
      if ((localObject != null) && (((String)localObject).equals("1"))) {
        bool = true;
      } else {
        bool = false;
      }
      localStrategyBean.h = bool;
      localObject = (String)paramaq.g.get("B3");
      if (localObject != null) {
        localStrategyBean.v = Long.parseLong((String)localObject);
      }
      int i = paramaq.i;
      localStrategyBean.o = i;
      localStrategyBean.u = i;
      localObject = (String)paramaq.g.get("B27");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        try
        {
          i = Integer.parseInt((String)localObject);
          if (i > 0) {
            localStrategyBean.t = i;
          }
        }
        catch (Exception localException)
        {
          if (!y.a(localException)) {
            localException.printStackTrace();
          }
        }
      }
      String str = (String)paramaq.g.get("B25");
      if ((str != null) && (str.equals("1"))) {
        bool = true;
      } else {
        bool = false;
      }
      localStrategyBean.j = bool;
    }
    y.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.e), Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.f), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.l), Boolean.valueOf(localStrategyBean.m), Long.valueOf(localStrategyBean.o), Boolean.valueOf(localStrategyBean.j), Long.valueOf(localStrategyBean.n) });
    this.f = localStrategyBean;
    if (!ab.c(paramaq.d))
    {
      y.c("[Strategy] download url is null", new Object[0]);
      this.f.p = "";
    }
    if (!ab.c(paramaq.e))
    {
      y.c("[Strategy] download crashurl is null", new Object[0]);
      this.f.q = "";
    }
    o.a().b(2);
    paramaq = new q();
    paramaq.b = 2;
    paramaq.a = localStrategyBean.c;
    paramaq.e = localStrategyBean.d;
    paramaq.g = ab.a(localStrategyBean);
    o.a().a(paramaq);
    a(localStrategyBean, true);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/bugly/crashreport/common/strategy/a:f	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localStrategyBean	StrategyBean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    StrategyBean localStrategyBean = this.f;
    if (localStrategyBean != null)
    {
      if (!ab.c(localStrategyBean.p)) {
        this.f.p = StrategyBean.a;
      }
      if (!ab.c(this.f.q)) {
        this.f.q = StrategyBean.b;
      }
      return this.f;
    }
    if ((!ab.a(h)) && (ab.c(h)))
    {
      localStrategyBean = this.e;
      String str = h;
      localStrategyBean.p = str;
      localStrategyBean.q = str;
    }
    return this.e;
  }
  
  final class a
    extends Thread
  {
    a() {}
    
    public final void run()
    {
      try
      {
        Object localObject2 = o.a().a(a.a, null, true);
        Object localObject1;
        if (localObject2 != null)
        {
          localObject1 = (byte[])((Map)localObject2).get("device");
          localObject2 = (byte[])((Map)localObject2).get("gateway");
          if (localObject1 != null) {
            com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).f(new String((byte[])localObject1));
          }
          if (localObject2 != null) {
            com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).e(new String((byte[])localObject2));
          }
        }
        a.a(a.this, a.d());
        if (a.b(a.this) != null)
        {
          if ((!ab.a(a.e())) && (ab.c(a.e())))
          {
            a.b(a.this).p = a.e();
            localObject1 = a.b(a.this);
          }
          for (localObject2 = a.e();; localObject2 = StrategyBean.b)
          {
            ((StrategyBean)localObject1).q = ((String)localObject2);
            break;
            a.b(a.this).p = StrategyBean.a;
            localObject1 = a.b(a.this);
          }
        }
        a locala;
        return;
      }
      finally
      {
        if (!y.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        locala = a.this;
        locala.a(a.b(locala), false);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a
 * JD-Core Version:    0.7.0.1
 */