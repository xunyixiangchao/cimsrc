package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.proguard.q;>;
import java.util.Map;

public final class o
{
  private static o a;
  private static p b;
  private static boolean c = false;
  
  private o(Context paramContext, List<a> paramList)
  {
    b = new p(paramContext, paramList);
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, n paramn)
  {
    int j = 0;
    int i;
    try
    {
      paramn = b.getWritableDatabase();
      i = j;
      if (paramn != null) {
        i = paramn.delete(paramString1, paramString2, paramArrayOfString);
      }
    }
    finally
    {
      i = j;
    }
    try
    {
      if (!y.a(paramString1))
      {
        paramString1.printStackTrace();
        i = j;
      }
      return i;
    }
    finally
    {
      paramString1 = finally;
      try
      {
        throw paramString1;
      }
      finally {}
    }
  }
  
  private long a(String paramString, ContentValues paramContentValues, n paramn)
  {
    long l2 = -1L;
    long l1;
    try
    {
      paramn = b.getWritableDatabase();
      l1 = l2;
      if (paramn != null)
      {
        l1 = l2;
        if (paramContentValues != null)
        {
          l1 = paramn.replace(paramString, "_id", paramContentValues);
          if (l1 >= 0L) {
            y.c("[Database] insert %s success.", new Object[] { paramString });
          } else {
            y.d("[Database] replace %s error.", new Object[] { paramString });
          }
        }
      }
    }
    finally
    {
      l1 = l2;
    }
    try
    {
      if (!y.a(paramString))
      {
        paramString.printStackTrace();
        l1 = l2;
      }
      return l1;
    }
    finally
    {
      paramString = finally;
      try
      {
        throw paramString;
      }
      finally {}
    }
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, n paramn)
  {
    Object localObject = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      paramn = localObject;
      if (localSQLiteDatabase != null) {
        paramn = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      }
    }
    finally
    {
      paramn = localObject;
    }
    try
    {
      if (!y.a(paramString1))
      {
        paramString1.printStackTrace();
        paramn = localObject;
      }
      return paramn;
    }
    finally
    {
      paramString1 = finally;
      try
      {
        throw paramString1;
      }
      finally {}
    }
  }
  
  public static o a()
  {
    try
    {
      o localo = a;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static o a(Context paramContext, List<a> paramList)
  {
    try
    {
      if (a == null) {
        a = new o(paramContext, paramList);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static q a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      q localq = new q();
      localq.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localq.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
      localq.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
      localq.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
      localq.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localq.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localq;
    }
    finally
    {
      if (!y.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private Map<String, byte[]> a(int paramInt, n paramn)
  {
    Iterator localIterator = null;
    q localq = null;
    Object localObject3;
    try
    {
      Object localObject4 = c(paramInt);
      if (localObject4 != null)
      {
        paramn = new HashMap();
        try
        {
          localIterator = ((List)localObject4).iterator();
          while (localIterator.hasNext())
          {
            localq = (q)localIterator.next();
            localObject4 = localq.g;
            if (localObject4 != null) {
              paramn.put(localq.f, localObject4);
            }
          }
          return paramn;
        }
        finally {}
        localn = paramn;
      }
    }
    finally
    {
      paramn = localObject2;
      localObject3 = localObject1;
    }
    try
    {
      n localn;
      if (!y.a(localObject3))
      {
        localObject3.printStackTrace();
        localn = paramn;
      }
      return localn;
    }
    finally {}
  }
  
  private boolean a(int paramInt, String paramString, n paramn)
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      paramn = b.getWritableDatabase();
      bool1 = bool2;
      if (paramn != null)
      {
        if (ab.a(paramString))
        {
          paramString = new StringBuilder("_id = ");
          paramString.append(paramInt);
          paramString = paramString.toString();
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder("_id = ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" and _tp");
          localStringBuilder.append(" = \"");
          localStringBuilder.append(paramString);
          localStringBuilder.append("\"");
          paramString = localStringBuilder.toString();
        }
        paramInt = paramn.delete("t_pf", paramString, null);
        y.c("[Database] deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
        bool1 = bool2;
        if (paramInt > 0) {
          bool1 = true;
        }
      }
    }
    finally
    {
      bool1 = bool2;
    }
    try
    {
      if (!y.a(paramString))
      {
        paramString.printStackTrace();
        bool1 = bool2;
      }
      return bool1;
    }
    finally
    {
      paramString = finally;
      try
      {
        throw paramString;
      }
      finally {}
    }
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, n paramn)
  {
    try
    {
      paramn = new q();
      paramn.a = paramInt;
      paramn.f = paramString;
      paramn.e = System.currentTimeMillis();
      paramn.g = paramArrayOfByte;
      boolean bool = b(paramn);
      return bool;
    }
    finally
    {
      try
      {
        if (!y.a(paramString)) {
          paramString.printStackTrace();
        }
        return false;
      }
      finally {}
    }
  }
  
  private static q b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      q localq = new q();
      localq.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localq.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localq.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
      localq.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localq;
    }
    finally
    {
      if (!y.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private boolean b(q paramq)
  {
    if (paramq == null) {
      return false;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        ContentValues localContentValues = d(paramq);
        if (localContentValues != null)
        {
          long l = localSQLiteDatabase.replace("t_pf", "_id", localContentValues);
          if (l >= 0L)
          {
            y.c("[Database] insert %s success.", new Object[] { "t_pf" });
            paramq.a = l;
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      try
      {
        if (!y.a(paramq)) {
          paramq.printStackTrace();
        }
        return false;
      }
      finally
      {
        paramq = finally;
        try
        {
          throw paramq;
        }
        finally {}
      }
    }
  }
  
  private static ContentValues c(q paramq)
  {
    if (paramq == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      long l = paramq.a;
      if (l > 0L) {
        localContentValues.put("_id", Long.valueOf(l));
      }
      localContentValues.put("_tp", Integer.valueOf(paramq.b));
      localContentValues.put("_pc", paramq.c);
      localContentValues.put("_th", paramq.d);
      localContentValues.put("_tm", Long.valueOf(paramq.e));
      paramq = paramq.g;
      if (paramq != null) {
        localContentValues.put("_dt", paramq);
      }
      return localContentValues;
    }
    finally
    {
      if (!y.a(paramq)) {
        paramq.printStackTrace();
      }
    }
    return null;
  }
  
  private List<q> c(int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localObject1 = new StringBuilder("_id = ");
          ((StringBuilder)localObject1).append(paramInt);
          str = ((StringBuilder)localObject1).toString();
          localObject1 = localSQLiteDatabase.query("t_pf", null, str, null, null, null, null);
          if (localObject1 == null) {
            if (localObject1 == null) {}
          }
        }
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase;
        String str;
        StringBuilder localStringBuilder;
        ArrayList localArrayList;
        Object localObject5;
        localObject1 = null;
      }
      try
      {
        ((Cursor)localObject1).close();
        return null;
      }
      finally {}
      try
      {
        localStringBuilder = new StringBuilder();
        localArrayList = new ArrayList();
        if (((Cursor)localObject1).moveToNext())
        {
          localObject5 = b((Cursor)localObject1);
          if (localObject5 != null) {
            localArrayList.add(localObject5);
          }
        }
      }
      finally {}
      try
      {
        localObject5 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_tp"));
        localStringBuilder.append(" or _tp");
        localStringBuilder.append(" = ");
        localStringBuilder.append((String)localObject5);
        continue;
      }
      finally {}
      y.d("[Database] unknown id.", new Object[0]);
      continue;
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.append(" and _id");
        localStringBuilder.append(" = ");
        localStringBuilder.append(paramInt);
        y.d("[Database] deleted %s illegal data %d.", new Object[] { "t_pf", Integer.valueOf(localSQLiteDatabase.delete("t_pf", str.substring(4), null)) });
      }
      ((Cursor)localObject1).close();
      return localArrayList;
    }
    try
    {
      if (!y.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      return null;
    }
    finally
    {
      localObject4 = finally;
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      throw localObject4;
    }
  }
  
  private static ContentValues d(q paramq)
  {
    if (paramq != null)
    {
      if (ab.a(paramq.f)) {
        return null;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        long l = paramq.a;
        if (l > 0L) {
          localContentValues.put("_id", Long.valueOf(l));
        }
        localContentValues.put("_tp", paramq.f);
        localContentValues.put("_tm", Long.valueOf(paramq.e));
        paramq = paramq.g;
        if (paramq != null) {
          localContentValues.put("_dt", paramq);
        }
        return localContentValues;
      }
      finally
      {
        if (!y.a(paramq)) {
          paramq.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, n paramn, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, n paramn, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, n paramn, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null, true);
  }
  
  public final Cursor a(boolean paramBoolean1, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, n paramn, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      paramString3 = new a(3, paramn);
      paramString3.b(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString5, paramString6);
      x.a().a(paramString3);
      return null;
    }
    return a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString5, paramString6, paramn);
  }
  
  /* Error */
  public final List<q> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 26	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   5: invokevirtual 36	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +298 -> 310
    //   15: iload_1
    //   16: iflt +318 -> 334
    //   19: new 186	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 318
    //   26: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: iload_1
    //   34: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 4
    //   45: goto +3 -> 48
    //   48: aload 5
    //   50: ldc_w 320
    //   53: aconst_null
    //   54: aload 4
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 260	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +19 -> 86
    //   70: aload 4
    //   72: ifnull +10 -> 82
    //   75: aload 4
    //   77: invokeinterface 263 1 0
    //   82: aload_0
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: new 186	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   93: astore 7
    //   95: new 266	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 267	java/util/ArrayList:<init>	()V
    //   102: astore 6
    //   104: aload 4
    //   106: invokeinterface 270 1 0
    //   111: ifeq +87 -> 198
    //   114: aload 4
    //   116: invokestatic 322	com/tencent/bugly/proguard/o:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/q;
    //   119: astore 8
    //   121: aload 8
    //   123: ifnull +16 -> 139
    //   126: aload 6
    //   128: aload 8
    //   130: invokeinterface 276 2 0
    //   135: pop
    //   136: goto -32 -> 104
    //   139: aload 4
    //   141: aload 4
    //   143: ldc 60
    //   145: invokeinterface 98 2 0
    //   150: invokeinterface 102 2 0
    //   155: lstore_2
    //   156: aload 7
    //   158: ldc_w 324
    //   161: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: ldc_w 280
    //   170: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 7
    //   176: lload_2
    //   177: invokevirtual 327	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: goto -77 -> 104
    //   184: ldc_w 282
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 74	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -91 -> 104
    //   198: aload 7
    //   200: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore 7
    //   205: aload 7
    //   207: invokevirtual 328	java/lang/String:length	()I
    //   210: ifle +41 -> 251
    //   213: ldc_w 330
    //   216: iconst_2
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc_w 320
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 5
    //   230: ldc_w 320
    //   233: aload 7
    //   235: iconst_4
    //   236: invokevirtual 295	java/lang/String:substring	(I)Ljava/lang/String;
    //   239: aconst_null
    //   240: invokevirtual 42	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   243: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: invokestatic 74	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload 4
    //   253: invokeinterface 263 1 0
    //   258: aload_0
    //   259: monitorexit
    //   260: aload 6
    //   262: areturn
    //   263: astore 5
    //   265: aload 5
    //   267: invokestatic 47	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   270: ifne +8 -> 278
    //   273: aload 5
    //   275: invokevirtual 52	java/lang/Throwable:printStackTrace	()V
    //   278: aload 4
    //   280: ifnull +30 -> 310
    //   283: aload 4
    //   285: invokeinterface 263 1 0
    //   290: goto +20 -> 310
    //   293: astore 5
    //   295: aload 4
    //   297: ifnull +10 -> 307
    //   300: aload 4
    //   302: invokeinterface 263 1 0
    //   307: aload 5
    //   309: athrow
    //   310: aload_0
    //   311: monitorexit
    //   312: aconst_null
    //   313: areturn
    //   314: astore 4
    //   316: aload_0
    //   317: monitorexit
    //   318: aload 4
    //   320: athrow
    //   321: astore 8
    //   323: goto -139 -> 184
    //   326: astore 5
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -66 -> 265
    //   334: aconst_null
    //   335: astore 4
    //   337: goto -289 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	o
    //   0	340	1	paramInt	int
    //   155	22	2	l	long
    //   29	272	4	localObject1	Object
    //   314	5	4	localObject2	Object
    //   329	7	4	localObject3	Object
    //   8	221	5	localSQLiteDatabase	SQLiteDatabase
    //   263	11	5	localThrowable	Throwable
    //   293	15	5	localObject4	Object
    //   326	1	5	localObject5	Object
    //   102	159	6	localArrayList	ArrayList
    //   93	141	7	localObject6	Object
    //   119	10	8	localq	q
    //   321	1	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   86	104	263	finally
    //   104	121	263	finally
    //   126	136	263	finally
    //   184	195	263	finally
    //   198	251	263	finally
    //   265	278	293	finally
    //   2	10	314	finally
    //   75	82	314	finally
    //   251	258	314	finally
    //   283	290	314	finally
    //   300	307	314	finally
    //   307	310	314	finally
    //   139	181	321	finally
    //   19	45	326	finally
    //   48	65	326	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, n paramn, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  public final void a(List<q> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
          if (localSQLiteDatabase != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (q)paramList.next();
              localStringBuilder.append(" or _id");
              localStringBuilder.append(" = ");
              localStringBuilder.append(((q)localObject).a);
            }
            Object localObject = localStringBuilder.toString();
            paramList = (List<q>)localObject;
            if (((String)localObject).length() > 0) {
              paramList = ((String)localObject).substring(4);
            }
            localStringBuilder.setLength(0);
            try
            {
              y.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", paramList, null)) });
              return;
            }
            finally
            {
              paramList = finally;
              try
              {
                if (!y.a(paramList)) {
                  paramList.printStackTrace();
                }
                return;
              }
              finally
              {
                paramList = finally;
                throw paramList;
              }
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, n paramn, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramn = new a(4, null);
      paramn.a(paramInt, paramString, paramArrayOfByte);
      x.a().a(paramn);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  public final boolean a(q paramq)
  {
    if (paramq == null) {
      return false;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        ContentValues localContentValues = c(paramq);
        if (localContentValues != null)
        {
          long l = localSQLiteDatabase.replace("t_lr", "_id", localContentValues);
          if (l >= 0L)
          {
            y.c("[Database] insert %s success.", new Object[] { "t_lr" });
            paramq.a = l;
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      try
      {
        if (!y.a(paramq)) {
          paramq.printStackTrace();
        }
        return false;
      }
      finally
      {
        paramq = finally;
        try
        {
          throw paramq;
        }
        finally {}
      }
    }
  }
  
  public final void b(int paramInt)
  {
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      Object localObject1;
      try
      {
        localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase != null) {
          if (paramInt < 0) {
            break label105;
          }
        }
      }
      finally {}
      try
      {
        localObject1 = new StringBuilder("_tp = ");
        ((StringBuilder)localObject1).append(paramInt);
        localObject1 = ((StringBuilder)localObject1).toString();
        y.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", (String)localObject1, null)) });
        return;
      }
      finally
      {
        continue;
      }
      try
      {
        if (!y.a((Throwable)localObject1)) {
          ((Throwable)localObject1).printStackTrace();
        }
        return;
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
      return;
      label105:
      Object localObject5 = null;
    }
  }
  
  final class a
    extends Thread
  {
    private int a;
    private n b;
    private String c;
    private ContentValues d;
    private boolean e;
    private String[] f;
    private String g;
    private String[] h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String[] n;
    private int o;
    private String p;
    private byte[] q;
    
    public a(int paramInt, n paramn)
    {
      this.a = paramInt;
      this.b = paramn;
    }
    
    public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
    {
      this.o = paramInt;
      this.p = paramString;
      this.q = paramArrayOfByte;
    }
    
    public final void b(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.e = paramBoolean;
      this.c = paramString1;
      this.f = paramArrayOfString1;
      this.g = paramString2;
      this.h = paramArrayOfString2;
      this.i = paramString3;
      this.j = paramString4;
      this.k = paramString5;
      this.l = paramString6;
    }
    
    public final void run()
    {
      switch (this.a)
      {
      default: 
      case 6: 
        o.a(o.this, this.o, this.p, this.b);
        return;
      case 5: 
        o.a(o.this, this.o, this.b);
        return;
      case 4: 
        o.a(o.this, this.o, this.p, this.q, this.b);
        return;
      case 3: 
        Cursor localCursor = o.a(o.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        if (localCursor != null)
        {
          localCursor.close();
          return;
        }
        break;
      case 2: 
        o.a(o.this, this.c, this.m, this.n, this.b);
        return;
      case 1: 
        o.a(o.this, this.c, this.d, this.b);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.o
 * JD-Core Version:    0.7.0.1
 */