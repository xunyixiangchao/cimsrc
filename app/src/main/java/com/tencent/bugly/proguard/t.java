package com.tencent.bugly.proguard;

import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class t
{
  private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
  private final r b = new r();
  
  public static t a()
  {
    return d.a();
  }
  
  private static String a(String paramString, Iterable<b> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      localStringBuilder.append("'");
      localStringBuilder.append(b.a((b)paramIterable.next()));
      localStringBuilder.append("'");
      if (!paramIterable.hasNext()) {
        break;
      }
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private void b(final List<b> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      x.a().a(new a(paramList));
      return;
    }
    c(paramList);
  }
  
  private static List<b> c()
  {
    localCursor = o.a().a(false, "t_sla", new String[] { "_id", "_tm", "_dt" }, null, null, null, null, "_tm", "30", null, true);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.getCount() <= 0)
    {
      localCursor.close();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      while (localCursor.moveToNext())
      {
        b localb = new b();
        localb.a(localCursor.getString(localCursor.getColumnIndex("_id")));
        localb.a(localCursor.getLong(localCursor.getColumnIndex("_tm")));
        localb.b(localCursor.getString(localCursor.getColumnIndex("_dt")));
        y.c(localb.toString(), new Object[0]);
        localArrayList.add(localb);
      }
    }
    finally
    {
      try
      {
        y.b(localThrowable);
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    return localArrayList;
  }
  
  private void c(List<b> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      y.c("sla batch report list size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      Object localObject = paramList;
      if (paramList.size() > 30) {
        localObject = paramList.subList(0, 29);
      }
      paramList = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        paramList.add(((b)localIterator.next()).c());
      }
      paramList = this.b.a(paramList);
      y.c("sla batch report result, rspCode:%s rspMsg:%s", new Object[] { paramList.first, paramList.second });
      if (((Integer)paramList.first).intValue() == 200) {
        e((List)localObject);
      }
      return;
    }
    y.c("sla batch report data is empty", new Object[0]);
  }
  
  /* Error */
  private static void d(List<b> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 201 1 0
    //   6: astore_0
    //   7: aload_0
    //   8: invokeinterface 61 1 0
    //   13: ifeq +112 -> 125
    //   16: aload_0
    //   17: invokeinterface 76 1 0
    //   22: checkcast 8	com/tencent/bugly/proguard/t$b
    //   25: astore_1
    //   26: ldc 227
    //   28: iconst_3
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: invokevirtual 229	com/tencent/bugly/proguard/t$b:a	()Ljava/lang/String;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_1
    //   42: invokevirtual 232	com/tencent/bugly/proguard/t$b:b	()J
    //   45: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: aload_1
    //   52: invokevirtual 203	com/tencent/bugly/proguard/t$b:c	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 172	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: new 239	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 240	android/content/ContentValues:<init>	()V
    //   67: astore_2
    //   68: aload_2
    //   69: ldc 121
    //   71: aload_1
    //   72: invokevirtual 229	com/tencent/bugly/proguard/t$b:a	()Ljava/lang/String;
    //   75: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_2
    //   79: ldc 123
    //   81: aload_1
    //   82: invokevirtual 232	com/tencent/bugly/proguard/t$b:b	()J
    //   85: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokevirtual 247	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   91: aload_2
    //   92: ldc 125
    //   94: aload_1
    //   95: invokevirtual 203	com/tencent/bugly/proguard/t$b:c	()Ljava/lang/String;
    //   98: invokevirtual 244	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: invokestatic 115	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   104: ldc 117
    //   106: aload_2
    //   107: aconst_null
    //   108: iconst_1
    //   109: invokevirtual 250	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;Landroid/content/ContentValues;Lcom/tencent/bugly/proguard/n;Z)J
    //   112: pop2
    //   113: goto -106 -> 7
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic 181	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   121: pop
    //   122: goto -115 -> 7
    //   125: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramList	List<b>
    //   25	70	1	localb	b
    //   116	2	1	localThrowable	Throwable
    //   67	40	2	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   60	113	116	finally
  }
  
  private void e(List<b> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      y.c("sla batch delete list size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("_id in (");
        localStringBuilder.append(a(",", paramList));
        localStringBuilder.append(")");
        paramList = localStringBuilder.toString();
        y.c("sla batch delete where:%s", new Object[] { paramList });
      }
      finally
      {
        y.b(paramList);
        return;
      }
    }
    y.c("sla batch delete list is null", new Object[0]);
  }
  
  public final void a(c paramc)
  {
    if ((paramc != null) && (!TextUtils.isEmpty(paramc.b())))
    {
      y.c("sla report single event", new Object[0]);
      a(Collections.singletonList(paramc));
      return;
    }
    y.d("sla report event is null", new Object[0]);
  }
  
  public final void a(List<c> paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void b()
  {
    List localList = c();
    if ((localList != null) && (!localList.isEmpty()))
    {
      y.c("sla load local data list size:%s", new Object[] { Integer.valueOf(localList.size()) });
      Iterator localIterator = localList.iterator();
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int i;
        if (localb.b() < ab.b() - 604800000L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          y.c("sla local data is expired:%s", new Object[] { localb.c() });
          localArrayList.add(localb);
          localIterator.remove();
        }
      }
      e(localArrayList);
      b(localList);
      return;
    }
    y.c("sla local data is null", new Object[0]);
  }
  
  final class a
    implements Runnable
  {
    a(List paramList) {}
    
    public final void run()
    {
      t.a(t.this, paramList);
    }
  }
  
  public static final class b
  {
    private String a;
    private long b;
    private String c;
    
    public final String a()
    {
      return this.a;
    }
    
    public final void a(long paramLong)
    {
      this.b = paramLong;
    }
    
    public final void a(String paramString)
    {
      this.a = paramString;
    }
    
    public final long b()
    {
      return this.b;
    }
    
    public final void b(String paramString)
    {
      this.c = paramString;
    }
    
    public final String c()
    {
      return this.c;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("SLAData{uuid='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", time=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", data='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static final class c
  {
    private String a;
    private String b;
    private long c;
    private boolean d;
    private long e;
    private String f;
    private String g;
    
    public c() {}
    
    public c(String paramString1, String paramString2, long paramLong1, boolean paramBoolean, long paramLong2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramLong1;
      this.d = paramBoolean;
      this.e = paramLong2;
      this.f = paramString3;
      this.g = paramString4;
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final String b()
    {
      return this.b;
    }
    
    public final long c()
    {
      return this.c;
    }
    
    public final boolean d()
    {
      return this.d;
    }
    
    public final long e()
    {
      return this.e;
    }
    
    public final String f()
    {
      return this.f;
    }
    
    public final String g()
    {
      return this.g;
    }
  }
  
  static final class d
  {
    private static final t a = new t((byte)0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.t
 * JD-Core Version:    0.7.0.1
 */