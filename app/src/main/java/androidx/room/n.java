package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import j.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p1.g;
import p1.h;
import p1.k;

public class n
{
  private static final String[] o = { "UPDATE", "DELETE", "INSERT" };
  final HashMap<String, Integer> a;
  final String[] b;
  private Map<String, Set<String>> c;
  a d = null;
  final f0 e;
  AtomicBoolean f;
  private volatile boolean g;
  volatile k h;
  private final b i;
  private final l j;
  @SuppressLint({"RestrictedApi"})
  final b<c, d> k;
  private o l;
  private final Object m;
  Runnable n;
  
  public n(f0 paramf0, Map<String, String> paramMap, Map<String, Set<String>> paramMap1, String... paramVarArgs)
  {
    int i1 = 0;
    this.f = new AtomicBoolean(false);
    this.g = false;
    this.k = new b();
    this.m = new Object();
    this.n = new a();
    this.e = paramf0;
    this.i = new b(paramVarArgs.length);
    this.a = new HashMap();
    this.c = paramMap1;
    this.j = new l(paramf0);
    int i2 = paramVarArgs.length;
    this.b = new String[i2];
    while (i1 < i2)
    {
      paramMap1 = paramVarArgs[i1];
      paramf0 = Locale.US;
      paramMap1 = paramMap1.toLowerCase(paramf0);
      this.a.put(paramMap1, Integer.valueOf(i1));
      String str = (String)paramMap.get(paramVarArgs[i1]);
      if (str != null) {
        this.b[i1] = str.toLowerCase(paramf0);
      } else {
        this.b[i1] = paramMap1;
      }
      i1 += 1;
    }
    paramf0 = paramMap.entrySet().iterator();
    while (paramf0.hasNext())
    {
      paramMap1 = (Map.Entry)paramf0.next();
      paramMap = (String)paramMap1.getValue();
      paramVarArgs = Locale.US;
      paramMap = paramMap.toLowerCase(paramVarArgs);
      if (this.a.containsKey(paramMap))
      {
        paramMap1 = ((String)paramMap1.getKey()).toLowerCase(paramVarArgs);
        paramVarArgs = this.a;
        paramVarArgs.put(paramMap1, (Integer)paramVarArgs.get(paramMap));
      }
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("`");
    paramStringBuilder.append("room_table_modification_trigger_");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("_");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("`");
  }
  
  private static void c(g paramg)
  {
    if (paramg.M())
    {
      paramg.R();
      return;
    }
    paramg.f();
  }
  
  private String[] j(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str1 = paramArrayOfString[i1];
      String str2 = str1.toLowerCase(Locale.US);
      if (this.c.containsKey(str2)) {
        localHashSet.addAll((Collection)this.c.get(str2));
      } else {
        localHashSet.add(str1);
      }
      i1 += 1;
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
  
  private void m(g paramg, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", 0)");
    paramg.p(((StringBuilder)localObject).toString());
    localObject = this.b[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = o;
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      localStringBuilder.setLength(0);
      localStringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
      b(localStringBuilder, (String)localObject, str);
      localStringBuilder.append(" AFTER ");
      localStringBuilder.append(str);
      localStringBuilder.append(" ON `");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("` BEGIN UPDATE ");
      localStringBuilder.append("room_table_modification_log");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 1");
      localStringBuilder.append(" WHERE ");
      localStringBuilder.append("table_id");
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" AND ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 0");
      localStringBuilder.append("; END");
      paramg.p(localStringBuilder.toString());
      i1 += 1;
    }
  }
  
  private void o(g paramg, int paramInt)
  {
    String str1 = this.b[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = o;
    int i1 = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i1)
    {
      String str2 = arrayOfString[paramInt];
      localStringBuilder.setLength(0);
      localStringBuilder.append("DROP TRIGGER IF EXISTS ");
      b(localStringBuilder, str1, str2);
      paramg.p(localStringBuilder.toString());
      paramInt += 1;
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void a(c paramc)
  {
    ??? = j(paramc.a);
    int[] arrayOfInt = new int[???.length];
    int i2 = ???.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject2 = (Integer)this.a.get(???[i1].toLowerCase(Locale.US));
      if (localObject2 != null)
      {
        arrayOfInt[i1] = ((Integer)localObject2).intValue();
        i1 += 1;
      }
      else
      {
        paramc = new StringBuilder();
        paramc.append("There is no table with name ");
        paramc.append(???[i1]);
        throw new IllegalArgumentException(paramc.toString());
      }
    }
    Object localObject2 = new d(paramc, arrayOfInt, (String[])???);
    synchronized (this.k)
    {
      paramc = (d)this.k.g(paramc, localObject2);
      if ((paramc == null) && (this.i.b(arrayOfInt))) {
        p();
      }
      return;
    }
  }
  
  boolean d()
  {
    if (!this.e.w()) {
      return false;
    }
    if (!this.g) {
      this.e.m().X();
    }
    if (!this.g)
    {
      Log.e("ROOM", "database is not initialized even though it is open");
      return false;
    }
    return true;
  }
  
  void e(g paramg)
  {
    try
    {
      if (this.g)
      {
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
        return;
      }
      paramg.p("PRAGMA temp_store = MEMORY;");
      paramg.p("PRAGMA recursive_triggers='ON';");
      paramg.p("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
      q(paramg);
      this.h = paramg.v("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
      this.g = true;
      return;
    }
    finally {}
  }
  
  public void f(String... paramVarArgs)
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((c)localEntry.getKey()).a()) {
          ((d)localEntry.getValue()).b(paramVarArgs);
        }
      }
      return;
    }
  }
  
  void g()
  {
    try
    {
      this.g = false;
      this.i.d();
      return;
    }
    finally {}
  }
  
  public void h()
  {
    if (this.f.compareAndSet(false, true))
    {
      a locala = this.d;
      if (locala != null) {
        locala.e();
      }
      this.e.n().execute(this.n);
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void i(c paramc)
  {
    synchronized (this.k)
    {
      paramc = (d)this.k.h(paramc);
      if ((paramc != null) && (this.i.c(paramc.a))) {
        p();
      }
      return;
    }
  }
  
  void k(a parama)
  {
    this.d = parama;
    parama.h(new m(this));
  }
  
  void l(Context paramContext, String paramString, Intent paramIntent)
  {
    this.l = new o(paramContext, paramString, paramIntent, this, this.e.n());
  }
  
  void n()
  {
    o localo = this.l;
    if (localo != null)
    {
      localo.a();
      this.l = null;
    }
  }
  
  void p()
  {
    if (!this.e.w()) {
      return;
    }
    q(this.e.m().X());
  }
  
  /* Error */
  void q(g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 392 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 89	androidx/room/n:e	Landroidx/room/f0;
    //   14: invokevirtual 395	androidx/room/f0:l	()Ljava/util/concurrent/locks/Lock;
    //   17: astore 5
    //   19: aload 5
    //   21: invokeinterface 400 1 0
    //   26: aload_0
    //   27: getfield 82	androidx/room/n:m	Ljava/lang/Object;
    //   30: astore 6
    //   32: aload 6
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 94	androidx/room/n:i	Landroidx/room/n$b;
    //   39: invokevirtual 403	androidx/room/n$b:a	()[I
    //   42: astore 7
    //   44: aload 7
    //   46: ifnonnull +14 -> 60
    //   49: aload 6
    //   51: monitorexit
    //   52: aload 5
    //   54: invokeinterface 406 1 0
    //   59: return
    //   60: aload 7
    //   62: arraylength
    //   63: istore_3
    //   64: aload_1
    //   65: invokestatic 408	androidx/room/n:c	(Lp1/g;)V
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: iload_3
    //   72: if_icmpge +42 -> 114
    //   75: aload 7
    //   77: iload_2
    //   78: iaload
    //   79: istore 4
    //   81: iload 4
    //   83: iconst_1
    //   84: if_icmpeq +21 -> 105
    //   87: iload 4
    //   89: iconst_2
    //   90: if_icmpeq +6 -> 96
    //   93: goto +88 -> 181
    //   96: aload_0
    //   97: aload_1
    //   98: iload_2
    //   99: invokespecial 410	androidx/room/n:o	(Lp1/g;I)V
    //   102: goto +79 -> 181
    //   105: aload_0
    //   106: aload_1
    //   107: iload_2
    //   108: invokespecial 412	androidx/room/n:m	(Lp1/g;I)V
    //   111: goto +70 -> 181
    //   114: aload_1
    //   115: invokeinterface 415 1 0
    //   120: aload_1
    //   121: invokeinterface 417 1 0
    //   126: aload 6
    //   128: monitorexit
    //   129: aload 5
    //   131: invokeinterface 406 1 0
    //   136: return
    //   137: astore 7
    //   139: aload_1
    //   140: invokeinterface 417 1 0
    //   145: aload 7
    //   147: athrow
    //   148: astore_1
    //   149: aload 6
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aload 5
    //   157: invokeinterface 406 1 0
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: goto +4 -> 169
    //   168: astore_1
    //   169: ldc_w 311
    //   172: ldc_w 419
    //   175: aload_1
    //   176: invokestatic 422	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   179: pop
    //   180: return
    //   181: iload_2
    //   182: iconst_1
    //   183: iadd
    //   184: istore_2
    //   185: goto -115 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	n
    //   0	188	1	paramg	g
    //   69	116	2	i1	int
    //   63	10	3	i2	int
    //   79	12	4	i3	int
    //   17	139	5	localLock	java.util.concurrent.locks.Lock
    //   42	34	7	arrayOfInt	int[]
    //   137	9	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   96	102	137	finally
    //   105	111	137	finally
    //   114	120	137	finally
    //   35	44	148	finally
    //   49	52	148	finally
    //   60	68	148	finally
    //   120	129	148	finally
    //   139	148	148	finally
    //   149	152	148	finally
    //   26	35	154	finally
    //   152	154	154	finally
    //   10	26	164	android/database/sqlite/SQLiteException
    //   52	59	164	android/database/sqlite/SQLiteException
    //   129	136	164	android/database/sqlite/SQLiteException
    //   155	164	164	android/database/sqlite/SQLiteException
    //   10	26	168	java/lang/IllegalStateException
    //   52	59	168	java/lang/IllegalStateException
    //   129	136	168	java/lang/IllegalStateException
    //   155	164	168	java/lang/IllegalStateException
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    private Set<Integer> a()
    {
      HashSet localHashSet = new HashSet();
      Cursor localCursor = n.this.e.z(new p1.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
      try
      {
        while (localCursor.moveToNext()) {
          localHashSet.add(Integer.valueOf(localCursor.getInt(0)));
        }
        localCursor.close();
        if (!localHashSet.isEmpty()) {
          n.this.h.u();
        }
        return localHashSet;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   4: getfield 26	androidx/room/n:e	Landroidx/room/f0;
      //   7: invokevirtual 86	androidx/room/f0:l	()Ljava/util/concurrent/locks/Lock;
      //   10: astore 7
      //   12: aload 7
      //   14: invokeinterface 91 1 0
      //   19: aconst_null
      //   20: astore_2
      //   21: aconst_null
      //   22: astore 6
      //   24: aconst_null
      //   25: astore 5
      //   27: aload_2
      //   28: astore 4
      //   30: aload 6
      //   32: astore_3
      //   33: aload_0
      //   34: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   37: invokevirtual 94	androidx/room/n:d	()Z
      //   40: istore_1
      //   41: iload_1
      //   42: ifne +27 -> 69
      //   45: aload 7
      //   47: invokeinterface 97 1 0
      //   52: aload_0
      //   53: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   56: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   59: astore_2
      //   60: aload_2
      //   61: ifnull +7 -> 68
      //   64: aload_2
      //   65: invokevirtual 105	androidx/room/a:b	()V
      //   68: return
      //   69: aload_2
      //   70: astore 4
      //   72: aload 6
      //   74: astore_3
      //   75: aload_0
      //   76: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   79: getfield 109	androidx/room/n:f	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   82: iconst_1
      //   83: iconst_0
      //   84: invokevirtual 115	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   87: istore_1
      //   88: iload_1
      //   89: ifne +27 -> 116
      //   92: aload 7
      //   94: invokeinterface 97 1 0
      //   99: aload_0
      //   100: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   103: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   106: astore_2
      //   107: aload_2
      //   108: ifnull +7 -> 115
      //   111: aload_2
      //   112: invokevirtual 105	androidx/room/a:b	()V
      //   115: return
      //   116: aload_2
      //   117: astore 4
      //   119: aload 6
      //   121: astore_3
      //   122: aload_0
      //   123: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   126: getfield 26	androidx/room/n:e	Landroidx/room/f0;
      //   129: invokevirtual 118	androidx/room/f0:q	()Z
      //   132: istore_1
      //   133: iload_1
      //   134: ifeq +27 -> 161
      //   137: aload 7
      //   139: invokeinterface 97 1 0
      //   144: aload_0
      //   145: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   148: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   151: astore_2
      //   152: aload_2
      //   153: ifnull +7 -> 160
      //   156: aload_2
      //   157: invokevirtual 105	androidx/room/a:b	()V
      //   160: return
      //   161: aload_2
      //   162: astore 4
      //   164: aload 6
      //   166: astore_3
      //   167: aload_0
      //   168: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   171: getfield 26	androidx/room/n:e	Landroidx/room/f0;
      //   174: invokevirtual 122	androidx/room/f0:m	()Lp1/h;
      //   177: invokeinterface 128 1 0
      //   182: astore 8
      //   184: aload_2
      //   185: astore 4
      //   187: aload 6
      //   189: astore_3
      //   190: aload 8
      //   192: invokeinterface 133 1 0
      //   197: aload_0
      //   198: invokespecial 135	androidx/room/n$a:a	()Ljava/util/Set;
      //   201: astore_2
      //   202: aload_2
      //   203: astore 5
      //   205: aload 8
      //   207: invokeinterface 138 1 0
      //   212: aload_2
      //   213: astore 4
      //   215: aload_2
      //   216: astore_3
      //   217: aload 8
      //   219: invokeinterface 140 1 0
      //   224: aload 7
      //   226: invokeinterface 97 1 0
      //   231: aload_0
      //   232: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   235: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   238: astore_3
      //   239: aload_2
      //   240: astore 4
      //   242: aload_3
      //   243: ifnull +92 -> 335
      //   246: aload_3
      //   247: astore 4
      //   249: aload 4
      //   251: invokevirtual 105	androidx/room/a:b	()V
      //   254: aload_2
      //   255: astore 4
      //   257: goto +78 -> 335
      //   260: astore_2
      //   261: aload 5
      //   263: astore 4
      //   265: aload 5
      //   267: astore_3
      //   268: aload 8
      //   270: invokeinterface 140 1 0
      //   275: aload 5
      //   277: astore 4
      //   279: aload 5
      //   281: astore_3
      //   282: aload_2
      //   283: athrow
      //   284: astore_2
      //   285: goto +129 -> 414
      //   288: astore_2
      //   289: aload 4
      //   291: astore_3
      //   292: goto +4 -> 296
      //   295: astore_2
      //   296: ldc 142
      //   298: ldc 144
      //   300: aload_2
      //   301: invokestatic 149	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   304: pop
      //   305: aload 7
      //   307: invokeinterface 97 1 0
      //   312: aload_0
      //   313: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   316: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   319: astore_2
      //   320: aload_3
      //   321: astore 4
      //   323: aload_2
      //   324: ifnull +11 -> 335
      //   327: aload_2
      //   328: astore 4
      //   330: aload_3
      //   331: astore_2
      //   332: goto -83 -> 249
      //   335: aload 4
      //   337: ifnull +76 -> 413
      //   340: aload 4
      //   342: invokeinterface 152 1 0
      //   347: ifne +66 -> 413
      //   350: aload_0
      //   351: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   354: getfield 156	androidx/room/n:k	Lj/b;
      //   357: astore_2
      //   358: aload_2
      //   359: monitorenter
      //   360: aload_0
      //   361: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   364: getfield 156	androidx/room/n:k	Lj/b;
      //   367: invokevirtual 162	j/b:iterator	()Ljava/util/Iterator;
      //   370: astore_3
      //   371: aload_3
      //   372: invokeinterface 167 1 0
      //   377: ifeq +28 -> 405
      //   380: aload_3
      //   381: invokeinterface 171 1 0
      //   386: checkcast 173	java/util/Map$Entry
      //   389: invokeinterface 176 1 0
      //   394: checkcast 178	androidx/room/n$d
      //   397: aload 4
      //   399: invokevirtual 181	androidx/room/n$d:a	(Ljava/util/Set;)V
      //   402: goto -31 -> 371
      //   405: aload_2
      //   406: monitorexit
      //   407: return
      //   408: astore_3
      //   409: aload_2
      //   410: monitorexit
      //   411: aload_3
      //   412: athrow
      //   413: return
      //   414: aload 7
      //   416: invokeinterface 97 1 0
      //   421: aload_0
      //   422: getfield 14	androidx/room/n$a:a	Landroidx/room/n;
      //   425: getfield 100	androidx/room/n:d	Landroidx/room/a;
      //   428: astore_3
      //   429: aload_3
      //   430: ifnull +7 -> 437
      //   433: aload_3
      //   434: invokevirtual 105	androidx/room/a:b	()V
      //   437: aload_2
      //   438: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	439	0	this	a
      //   40	94	1	bool	boolean
      //   20	235	2	localObject1	Object
      //   260	23	2	localObject2	Object
      //   284	1	2	localObject3	Object
      //   288	1	2	localSQLiteException	android.database.sqlite.SQLiteException
      //   295	6	2	localIllegalStateException	java.lang.IllegalStateException
      //   319	119	2	localObject4	Object
      //   32	349	3	localObject5	Object
      //   408	4	3	localObject6	Object
      //   428	6	3	locala	a
      //   28	370	4	localObject7	Object
      //   25	255	5	localObject8	Object
      //   22	166	6	localObject9	Object
      //   10	405	7	localLock	java.util.concurrent.locks.Lock
      //   182	87	8	localg	g
      // Exception table:
      //   from	to	target	type
      //   197	202	260	finally
      //   205	212	260	finally
      //   33	41	284	finally
      //   75	88	284	finally
      //   122	133	284	finally
      //   167	184	284	finally
      //   190	197	284	finally
      //   217	224	284	finally
      //   268	275	284	finally
      //   282	284	284	finally
      //   296	305	284	finally
      //   33	41	288	android/database/sqlite/SQLiteException
      //   75	88	288	android/database/sqlite/SQLiteException
      //   122	133	288	android/database/sqlite/SQLiteException
      //   167	184	288	android/database/sqlite/SQLiteException
      //   190	197	288	android/database/sqlite/SQLiteException
      //   217	224	288	android/database/sqlite/SQLiteException
      //   268	275	288	android/database/sqlite/SQLiteException
      //   282	284	288	android/database/sqlite/SQLiteException
      //   33	41	295	java/lang/IllegalStateException
      //   75	88	295	java/lang/IllegalStateException
      //   122	133	295	java/lang/IllegalStateException
      //   167	184	295	java/lang/IllegalStateException
      //   190	197	295	java/lang/IllegalStateException
      //   217	224	295	java/lang/IllegalStateException
      //   268	275	295	java/lang/IllegalStateException
      //   282	284	295	java/lang/IllegalStateException
      //   360	371	408	finally
      //   371	402	408	finally
      //   405	407	408	finally
      //   409	411	408	finally
    }
  }
  
  static class b
  {
    final long[] a;
    final boolean[] b;
    final int[] c;
    boolean d;
    
    b(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      this.a = arrayOfLong;
      boolean[] arrayOfBoolean = new boolean[paramInt];
      this.b = arrayOfBoolean;
      this.c = new int[paramInt];
      Arrays.fill(arrayOfLong, 0L);
      Arrays.fill(arrayOfBoolean, false);
    }
    
    int[] a()
    {
      for (;;)
      {
        int i;
        int[] arrayOfInt;
        try
        {
          if (!this.d) {
            return null;
          }
          int k = this.a.length;
          i = 0;
          Object localObject1;
          if (i < k)
          {
            long l = this.a[i];
            j = 1;
            if (l > 0L)
            {
              m = 1;
              localObject1 = this.b;
              if (m != localObject1[i])
              {
                arrayOfInt = this.c;
                if (m == 0) {
                  break label123;
                }
                break label125;
              }
              this.c[i] = 0;
              break label130;
            }
          }
          else
          {
            this.d = false;
            localObject1 = (int[])this.c.clone();
            return localObject1;
          }
        }
        finally {}
        int m = 0;
        continue;
        label123:
        int j = 2;
        label125:
        arrayOfInt[i] = j;
        label130:
        localObject2[i] = m;
        i += 1;
      }
    }
    
    boolean b(int... paramVarArgs)
    {
      for (;;)
      {
        int i;
        try
        {
          int j = paramVarArgs.length;
          i = 0;
          boolean bool = false;
          if (i < j)
          {
            int k = paramVarArgs[i];
            long[] arrayOfLong = this.a;
            long l = arrayOfLong[k];
            arrayOfLong[k] = (1L + l);
            if (l == 0L)
            {
              this.d = true;
              bool = true;
            }
          }
          else
          {
            return bool;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    boolean c(int... paramVarArgs)
    {
      for (;;)
      {
        int i;
        try
        {
          int j = paramVarArgs.length;
          i = 0;
          boolean bool = false;
          if (i < j)
          {
            int k = paramVarArgs[i];
            long[] arrayOfLong = this.a;
            long l = arrayOfLong[k];
            arrayOfLong[k] = (l - 1L);
            if (l == 1L)
            {
              this.d = true;
              bool = true;
            }
          }
          else
          {
            return bool;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    void d()
    {
      try
      {
        Arrays.fill(this.b, false);
        this.d = true;
        return;
      }
      finally {}
    }
  }
  
  public static abstract class c
  {
    final String[] a;
    
    public c(String[] paramArrayOfString)
    {
      this.a = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    }
    
    boolean a()
    {
      return false;
    }
    
    public abstract void b(Set<String> paramSet);
  }
  
  static class d
  {
    final int[] a;
    private final String[] b;
    final n.c c;
    private final Set<String> d;
    
    d(n.c paramc, int[] paramArrayOfInt, String[] paramArrayOfString)
    {
      this.c = paramc;
      this.a = paramArrayOfInt;
      this.b = paramArrayOfString;
      if (paramArrayOfInt.length == 1)
      {
        paramc = new HashSet();
        paramc.add(paramArrayOfString[0]);
        paramc = Collections.unmodifiableSet(paramc);
      }
      else
      {
        paramc = null;
      }
      this.d = paramc;
    }
    
    void a(Set<Integer> paramSet)
    {
      int j = this.a.length;
      Object localObject1 = null;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1;
        if (paramSet.contains(Integer.valueOf(this.a[i]))) {
          if (j == 1)
          {
            localObject2 = this.d;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new HashSet(j);
            }
            ((Set)localObject2).add(this.b[i]);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        this.c.b(localObject1);
      }
    }
    
    void b(String[] paramArrayOfString)
    {
      int i = this.b.length;
      Object localObject2 = null;
      int j;
      if (i == 1)
      {
        j = paramArrayOfString.length;
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          if (paramArrayOfString[i].equalsIgnoreCase(this.b[0]))
          {
            localObject1 = this.d;
            break;
          }
          i += 1;
        }
      }
      HashSet localHashSet = new HashSet();
      int k = paramArrayOfString.length;
      i = 0;
      while (i < k)
      {
        localObject1 = paramArrayOfString[i];
        String[] arrayOfString = this.b;
        int m = arrayOfString.length;
        j = 0;
        while (j < m)
        {
          String str = arrayOfString[j];
          if (str.equalsIgnoreCase((String)localObject1))
          {
            localHashSet.add(str);
            break;
          }
          j += 1;
        }
        i += 1;
      }
      Object localObject1 = localObject2;
      if (localHashSet.size() > 0) {
        localObject1 = localHashSet;
      }
      if (localObject1 != null) {
        this.c.b((Set)localObject1);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.n
 * JD-Core Version:    0.7.0.1
 */