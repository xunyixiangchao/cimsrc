package com.baidu.location.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.c.a;
import com.baidu.location.c.i;
import com.baidu.location.e.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
{
  private static Object c = new Object();
  private static g d;
  private static final String e;
  a a = null;
  a b = null;
  private SQLiteDatabase f = null;
  private boolean g = false;
  private String h = null;
  private int i = -2;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.baidu.location.e.h.g());
    localStringBuilder.append("/hst.db");
    e = localStringBuilder.toString();
  }
  
  public static g a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new g();
      }
      g localg = d;
      return localg;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    Object localObject = com.baidu.location.c.b.a().f();
    com.baidu.location.c.h localh = i.a().o();
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((localObject != null) && (((a)localObject).b())) {
      localStringBuffer.append(((a)localObject).h());
    }
    if ((localh != null) && (localh.a() > 1))
    {
      localObject = localh.a(15);
    }
    else
    {
      if (i.a().l() == null) {
        break label93;
      }
      localObject = i.a().l();
    }
    localStringBuffer.append((String)localObject);
    label93:
    if (paramBoolean) {
      localStringBuffer.append("&imo=1");
    }
    localStringBuffer.append(com.baidu.location.c.d.a().m());
    localStringBuffer.append(com.baidu.location.e.b.a().a(false));
    localStringBuffer.append(b.a().c());
    return localStringBuffer.toString();
  }
  
  private void a(Bundle paramBundle)
  {
    b.a().a(paramBundle, 406);
  }
  
  private void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("hotspot", -1);
    a(localBundle);
  }
  
  public void a(String paramString)
  {
    if (this.g) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("content"))
        {
          paramString = paramString.getJSONObject("content");
          if ((paramString != null) && (paramString.has("imo")))
          {
            Long localLong = Long.valueOf(paramString.getJSONObject("imo").getString("mac"));
            int j = paramString.getJSONObject("imo").getInt("mv");
            paramString = new ContentValues();
            paramString.put("tt", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
            paramString.put("hst", Integer.valueOf(j));
            SQLiteDatabase localSQLiteDatabase = this.f;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("id = \"");
            localStringBuilder.append(localLong);
            localStringBuilder.append("\"");
            if (localSQLiteDatabase.update("hstdata", paramString, localStringBuilder.toString(), null) <= 0)
            {
              paramString.put("id", localLong);
              this.f.insert("hstdata", null, paramString);
            }
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      paramString = null;
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject = new File(e);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (!((File)localObject).exists()) {
        break label62;
      }
      localObject = SQLiteDatabase.openOrCreateDatabase((File)localObject, null);
      this.f = ((SQLiteDatabase)localObject);
      ((SQLiteDatabase)localObject).execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
      this.f.setVersion(1);
      return;
    }
    catch (Exception localException)
    {
      label57:
      label62:
      break label57;
    }
    this.f = null;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +23 -> 29
    //   9: aload_1
    //   10: invokevirtual 265	android/database/sqlite/SQLiteDatabase:close	()V
    //   13: goto +11 -> 24
    //   16: astore_1
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   22: aload_1
    //   23: athrow
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   29: return
    //   30: astore_1
    //   31: goto -7 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	g
    //   4	6	1	localSQLiteDatabase	SQLiteDatabase
    //   16	7	1	localObject	Object
    //   30	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	13	16	finally
    //   9	13	30	java/lang/Exception
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: bipush 253
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 53	com/baidu/location/b/g:g	Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifeq +8 -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: bipush 253
    //   20: ireturn
    //   21: iload_2
    //   22: istore_1
    //   23: iload_2
    //   24: istore_3
    //   25: invokestatic 80	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   28: invokevirtual 267	com/baidu/location/c/i:i	()Z
    //   31: ifeq +388 -> 419
    //   34: iload_2
    //   35: istore_1
    //   36: iload_2
    //   37: istore_3
    //   38: aload_0
    //   39: getfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   42: ifnull +377 -> 419
    //   45: iload_2
    //   46: istore_3
    //   47: invokestatic 80	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   50: invokevirtual 271	com/baidu/location/c/i:k	()Landroid/net/wifi/WifiInfo;
    //   53: astore 5
    //   55: iload_2
    //   56: istore_1
    //   57: aload 5
    //   59: ifnull +360 -> 419
    //   62: iload_2
    //   63: istore_1
    //   64: iload_2
    //   65: istore_3
    //   66: aload 5
    //   68: invokevirtual 276	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   71: ifnull +348 -> 419
    //   74: iload_2
    //   75: istore_3
    //   76: aload 5
    //   78: invokevirtual 276	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   81: ldc_w 278
    //   84: ldc_w 280
    //   87: invokevirtual 286	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   90: astore 9
    //   92: iload_2
    //   93: istore_3
    //   94: aload 9
    //   96: invokestatic 291	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
    //   99: astore 10
    //   101: iload_2
    //   102: istore_3
    //   103: aload_0
    //   104: getfield 59	com/baidu/location/b/g:h	Ljava/lang/String;
    //   107: astore 5
    //   109: aload 5
    //   111: ifnull +31 -> 142
    //   114: iload_2
    //   115: istore_3
    //   116: aload 9
    //   118: aload 5
    //   120: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifeq +19 -> 142
    //   126: iload_2
    //   127: istore_3
    //   128: aload_0
    //   129: getfield 61	com/baidu/location/b/g:i	I
    //   132: istore_1
    //   133: iload_1
    //   134: bipush 254
    //   136: if_icmple +6 -> 142
    //   139: goto +280 -> 419
    //   142: aconst_null
    //   143: astore 8
    //   145: aconst_null
    //   146: astore 6
    //   148: iload_2
    //   149: istore_1
    //   150: aload 6
    //   152: astore 7
    //   154: iload_2
    //   155: istore_3
    //   156: aload 8
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   164: astore 11
    //   166: iload_2
    //   167: istore_1
    //   168: aload 6
    //   170: astore 7
    //   172: iload_2
    //   173: istore_3
    //   174: aload 8
    //   176: astore 5
    //   178: new 31	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   185: astore 12
    //   187: iload_2
    //   188: istore_1
    //   189: aload 6
    //   191: astore 7
    //   193: iload_2
    //   194: istore_3
    //   195: aload 8
    //   197: astore 5
    //   199: aload 12
    //   201: ldc_w 297
    //   204: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: iload_2
    //   209: istore_1
    //   210: aload 6
    //   212: astore 7
    //   214: iload_2
    //   215: istore_3
    //   216: aload 8
    //   218: astore 5
    //   220: aload 12
    //   222: aload 10
    //   224: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: iload_2
    //   229: istore_1
    //   230: aload 6
    //   232: astore 7
    //   234: iload_2
    //   235: istore_3
    //   236: aload 8
    //   238: astore 5
    //   240: aload 12
    //   242: ldc_w 299
    //   245: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: iload_2
    //   250: istore_1
    //   251: aload 6
    //   253: astore 7
    //   255: iload_2
    //   256: istore_3
    //   257: aload 8
    //   259: astore 5
    //   261: aload 11
    //   263: aload 12
    //   265: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aconst_null
    //   269: invokevirtual 303	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   272: astore 6
    //   274: aload 6
    //   276: ifnull +84 -> 360
    //   279: iload_2
    //   280: istore_1
    //   281: aload 6
    //   283: astore 7
    //   285: iload_2
    //   286: istore_3
    //   287: aload 6
    //   289: astore 5
    //   291: aload 6
    //   293: invokeinterface 308 1 0
    //   298: ifeq +62 -> 360
    //   301: iload_2
    //   302: istore_1
    //   303: aload 6
    //   305: astore 7
    //   307: iload_2
    //   308: istore_3
    //   309: aload 6
    //   311: astore 5
    //   313: aload 6
    //   315: iconst_1
    //   316: invokeinterface 311 2 0
    //   321: istore_2
    //   322: iload_2
    //   323: istore_1
    //   324: aload 6
    //   326: astore 7
    //   328: iload_2
    //   329: istore_3
    //   330: aload 6
    //   332: astore 5
    //   334: aload_0
    //   335: aload 9
    //   337: putfield 59	com/baidu/location/b/g:h	Ljava/lang/String;
    //   340: iload_2
    //   341: istore_1
    //   342: aload 6
    //   344: astore 7
    //   346: iload_2
    //   347: istore_3
    //   348: aload 6
    //   350: astore 5
    //   352: aload_0
    //   353: iload_2
    //   354: putfield 61	com/baidu/location/b/g:i	I
    //   357: goto +6 -> 363
    //   360: bipush 254
    //   362: istore_2
    //   363: iload_2
    //   364: istore_1
    //   365: aload 6
    //   367: ifnull +52 -> 419
    //   370: aload 6
    //   372: astore 5
    //   374: iload_2
    //   375: istore_1
    //   376: iload_1
    //   377: istore_3
    //   378: aload 5
    //   380: invokeinterface 312 1 0
    //   385: goto +34 -> 419
    //   388: astore 5
    //   390: aload 7
    //   392: ifnull +10 -> 402
    //   395: aload 7
    //   397: invokeinterface 312 1 0
    //   402: iload_1
    //   403: istore_3
    //   404: aload 5
    //   406: athrow
    //   407: iload_3
    //   408: istore_1
    //   409: aload 5
    //   411: ifnull +8 -> 419
    //   414: iload_3
    //   415: istore_1
    //   416: goto -40 -> 376
    //   419: aload_0
    //   420: iload_1
    //   421: putfield 61	com/baidu/location/b/g:i	I
    //   424: aload_0
    //   425: monitorexit
    //   426: iload_1
    //   427: ireturn
    //   428: astore 5
    //   430: aload_0
    //   431: monitorexit
    //   432: aload 5
    //   434: athrow
    //   435: astore 5
    //   437: iload_3
    //   438: istore_1
    //   439: goto -20 -> 419
    //   442: astore 6
    //   444: goto -37 -> 407
    //   447: astore 6
    //   449: goto -47 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	g
    //   22	417	1	j	int
    //   4	371	2	k	int
    //   24	414	3	m	int
    //   9	3	4	bool	boolean
    //   53	326	5	localObject1	Object
    //   388	22	5	localObject2	Object
    //   428	5	5	localObject3	Object
    //   435	1	5	localException1	Exception
    //   146	225	6	localCursor1	android.database.Cursor
    //   442	1	6	localException2	Exception
    //   447	1	6	localException3	Exception
    //   152	244	7	localCursor2	android.database.Cursor
    //   143	115	8	localObject4	Object
    //   90	246	9	str	String
    //   99	124	10	localLong	Long
    //   164	98	11	localSQLiteDatabase	SQLiteDatabase
    //   185	79	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   160	166	388	finally
    //   178	187	388	finally
    //   199	208	388	finally
    //   220	228	388	finally
    //   240	249	388	finally
    //   261	274	388	finally
    //   291	301	388	finally
    //   313	322	388	finally
    //   334	340	388	finally
    //   352	357	388	finally
    //   5	11	428	finally
    //   25	34	428	finally
    //   38	45	428	finally
    //   47	55	428	finally
    //   66	74	428	finally
    //   76	92	428	finally
    //   94	101	428	finally
    //   103	109	428	finally
    //   116	126	428	finally
    //   128	133	428	finally
    //   378	385	428	finally
    //   395	402	428	finally
    //   404	407	428	finally
    //   419	424	428	finally
    //   25	34	435	java/lang/Exception
    //   38	45	435	java/lang/Exception
    //   47	55	435	java/lang/Exception
    //   66	74	435	java/lang/Exception
    //   76	92	435	java/lang/Exception
    //   94	101	435	java/lang/Exception
    //   103	109	435	java/lang/Exception
    //   116	126	435	java/lang/Exception
    //   128	133	435	java/lang/Exception
    //   378	385	435	java/lang/Exception
    //   404	407	435	java/lang/Exception
    //   160	166	442	java/lang/Exception
    //   178	187	442	java/lang/Exception
    //   199	208	442	java/lang/Exception
    //   220	228	442	java/lang/Exception
    //   240	249	442	java/lang/Exception
    //   261	274	442	java/lang/Exception
    //   291	301	442	java/lang/Exception
    //   313	322	442	java/lang/Exception
    //   334	340	442	java/lang/Exception
    //   352	357	442	java/lang/Exception
    //   395	402	447	java/lang/Exception
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/baidu/location/b/g:g	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 80	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   11: invokevirtual 267	com/baidu/location/c/i:i	()Z
    //   14: ifeq +418 -> 432
    //   17: aload_0
    //   18: getfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   21: ifnull +411 -> 432
    //   24: invokestatic 80	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   27: invokevirtual 271	com/baidu/location/c/i:k	()Landroid/net/wifi/WifiInfo;
    //   30: astore 6
    //   32: aload 6
    //   34: ifnull +398 -> 432
    //   37: aload 6
    //   39: invokevirtual 276	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   42: ifnull +390 -> 432
    //   45: aload 6
    //   47: invokevirtual 276	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   50: ldc_w 278
    //   53: ldc_w 280
    //   56: invokevirtual 286	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   59: astore 10
    //   61: aload 10
    //   63: invokestatic 291	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
    //   66: astore 11
    //   68: iconst_0
    //   69: istore_1
    //   70: iconst_0
    //   71: istore_3
    //   72: iconst_0
    //   73: istore_2
    //   74: aconst_null
    //   75: astore 9
    //   77: aconst_null
    //   78: astore 7
    //   80: aload 7
    //   82: astore 8
    //   84: aload 9
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 51	com/baidu/location/b/g:f	Landroid/database/sqlite/SQLiteDatabase;
    //   92: astore 12
    //   94: aload 7
    //   96: astore 8
    //   98: aload 9
    //   100: astore 6
    //   102: new 31	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   109: astore 13
    //   111: aload 7
    //   113: astore 8
    //   115: aload 9
    //   117: astore 6
    //   119: aload 13
    //   121: ldc_w 297
    //   124: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 7
    //   130: astore 8
    //   132: aload 9
    //   134: astore 6
    //   136: aload 13
    //   138: aload 11
    //   140: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: astore 8
    //   148: aload 9
    //   150: astore 6
    //   152: aload 13
    //   154: ldc_w 299
    //   157: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 7
    //   163: astore 8
    //   165: aload 9
    //   167: astore 6
    //   169: aload 12
    //   171: aload 13
    //   173: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aconst_null
    //   177: invokevirtual 303	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   180: astore 7
    //   182: aload 7
    //   184: ifnull +159 -> 343
    //   187: aload 7
    //   189: astore 8
    //   191: aload 7
    //   193: astore 6
    //   195: aload 7
    //   197: invokeinterface 308 1 0
    //   202: ifeq +141 -> 343
    //   205: aload 7
    //   207: astore 8
    //   209: aload 7
    //   211: astore 6
    //   213: aload 7
    //   215: iconst_1
    //   216: invokeinterface 311 2 0
    //   221: istore 4
    //   223: aload 7
    //   225: astore 8
    //   227: aload 7
    //   229: astore 6
    //   231: aload 7
    //   233: iconst_2
    //   234: invokeinterface 311 2 0
    //   239: istore 5
    //   241: aload 7
    //   243: astore 8
    //   245: aload 7
    //   247: astore 6
    //   249: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   252: ldc2_w 205
    //   255: ldiv
    //   256: iload 5
    //   258: i2l
    //   259: lsub
    //   260: ldc2_w 313
    //   263: lcmp
    //   264: ifle +6 -> 270
    //   267: goto +76 -> 343
    //   270: aload 7
    //   272: astore 8
    //   274: aload 7
    //   276: astore 6
    //   278: new 149	android/os/Bundle
    //   281: dup
    //   282: invokespecial 150	android/os/Bundle:<init>	()V
    //   285: astore 9
    //   287: aload 7
    //   289: astore 8
    //   291: aload 7
    //   293: astore 6
    //   295: aload 9
    //   297: ldc 177
    //   299: aload 10
    //   301: invokevirtual 318	java/lang/String:getBytes	()[B
    //   304: invokevirtual 322	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   307: aload 7
    //   309: astore 8
    //   311: aload 7
    //   313: astore 6
    //   315: aload 9
    //   317: ldc 152
    //   319: iload 4
    //   321: invokevirtual 156	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   324: aload 7
    //   326: astore 8
    //   328: aload 7
    //   330: astore 6
    //   332: aload_0
    //   333: aload 9
    //   335: invokespecial 142	com/baidu/location/b/g:a	(Landroid/os/Bundle;)V
    //   338: iload_2
    //   339: istore_1
    //   340: goto +5 -> 345
    //   343: iconst_1
    //   344: istore_1
    //   345: iload_1
    //   346: istore_2
    //   347: aload 7
    //   349: ifnull +36 -> 385
    //   352: aload 7
    //   354: astore 6
    //   356: aload 6
    //   358: invokeinterface 312 1 0
    //   363: iload_1
    //   364: istore_2
    //   365: goto +20 -> 385
    //   368: astore 6
    //   370: aload 8
    //   372: ifnull +10 -> 382
    //   375: aload 8
    //   377: invokeinterface 312 1 0
    //   382: aload 6
    //   384: athrow
    //   385: iload_2
    //   386: ifeq +50 -> 436
    //   389: aload_0
    //   390: getfield 55	com/baidu/location/b/g:a	Lcom/baidu/location/b/g$a;
    //   393: ifnonnull +15 -> 408
    //   396: aload_0
    //   397: new 6	com/baidu/location/b/g$a
    //   400: dup
    //   401: aload_0
    //   402: invokespecial 324	com/baidu/location/b/g$a:<init>	(Lcom/baidu/location/b/g;)V
    //   405: putfield 55	com/baidu/location/b/g:a	Lcom/baidu/location/b/g$a;
    //   408: aload_0
    //   409: getfield 55	com/baidu/location/b/g:a	Lcom/baidu/location/b/g$a;
    //   412: astore 6
    //   414: aload 6
    //   416: ifnull +20 -> 436
    //   419: aload 6
    //   421: aload 10
    //   423: aload_0
    //   424: iconst_1
    //   425: invokespecial 325	com/baidu/location/b/g:a	(Z)Ljava/lang/String;
    //   428: invokevirtual 328	com/baidu/location/b/g$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: return
    //   432: aload_0
    //   433: invokespecial 146	com/baidu/location/b/g:f	()V
    //   436: return
    //   437: astore 6
    //   439: return
    //   440: astore 7
    //   442: goto +15 -> 457
    //   445: astore 6
    //   447: iload_1
    //   448: istore_2
    //   449: goto -64 -> 385
    //   452: astore 7
    //   454: goto -72 -> 382
    //   457: iload_3
    //   458: istore_2
    //   459: aload 6
    //   461: ifnull -76 -> 385
    //   464: goto -108 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	g
    //   69	379	1	j	int
    //   73	386	2	k	int
    //   71	387	3	m	int
    //   221	99	4	n	int
    //   239	18	5	i1	int
    //   30	327	6	localObject1	Object
    //   368	15	6	localObject2	Object
    //   412	8	6	locala	a
    //   437	1	6	localException1	Exception
    //   445	15	6	localException2	Exception
    //   78	275	7	localCursor1	android.database.Cursor
    //   440	1	7	localException3	Exception
    //   452	1	7	localException4	Exception
    //   82	294	8	localCursor2	android.database.Cursor
    //   75	259	9	localBundle	Bundle
    //   59	363	10	str	String
    //   66	73	11	localLong	Long
    //   92	78	12	localSQLiteDatabase	SQLiteDatabase
    //   109	63	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   88	94	368	finally
    //   102	111	368	finally
    //   119	128	368	finally
    //   136	144	368	finally
    //   152	161	368	finally
    //   169	182	368	finally
    //   195	205	368	finally
    //   213	223	368	finally
    //   231	241	368	finally
    //   249	267	368	finally
    //   278	287	368	finally
    //   295	307	368	finally
    //   315	324	368	finally
    //   332	338	368	finally
    //   8	32	437	java/lang/Exception
    //   37	68	437	java/lang/Exception
    //   382	385	437	java/lang/Exception
    //   389	408	437	java/lang/Exception
    //   408	414	437	java/lang/Exception
    //   419	431	437	java/lang/Exception
    //   432	436	437	java/lang/Exception
    //   88	94	440	java/lang/Exception
    //   102	111	440	java/lang/Exception
    //   119	128	440	java/lang/Exception
    //   136	144	440	java/lang/Exception
    //   152	161	440	java/lang/Exception
    //   169	182	440	java/lang/Exception
    //   195	205	440	java/lang/Exception
    //   213	223	440	java/lang/Exception
    //   231	241	440	java/lang/Exception
    //   249	267	440	java/lang/Exception
    //   278	287	440	java/lang/Exception
    //   295	307	440	java/lang/Exception
    //   315	324	440	java/lang/Exception
    //   332	338	440	java/lang/Exception
    //   356	363	445	java/lang/Exception
    //   375	382	452	java/lang/Exception
  }
  
  class a
    extends f
  {
    private String b = null;
    private String c = null;
    private boolean d = true;
    private boolean e = false;
    
    a()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      this.h = 1;
      String str = Jni.encodeTp4(this.c);
      this.c = null;
      this.j.put("bloc", str);
    }
    
    public void a(String paramString1, String paramString2)
    {
      if (!g.c(g.this))
      {
        g.a(g.this, true);
        this.b = paramString1;
        this.c = paramString2;
        paramString1 = p.a().c();
        if (paramString1 != null)
        {
          a(paramString1, com.baidu.location.e.d.c);
          return;
        }
        b(com.baidu.location.e.d.c);
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localObject1 = this.i;
        if (localObject1 == null) {}
      }
      try
      {
        if (!this.d) {
          break label278;
        }
        localObject1 = new JSONObject((String)localObject1);
        if (!((JSONObject)localObject1).has("content")) {
          break label311;
        }
        localObject1 = ((JSONObject)localObject1).getJSONObject("content");
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            Long localLong;
            int i;
            SQLiteDatabase localSQLiteDatabase = g.a(g.this);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("id = \"");
            localStringBuilder.append(localLong);
            localStringBuilder.append("\"");
            if (localSQLiteDatabase.update("hstdata", (ContentValues)localObject1, localStringBuilder.toString(), null) <= 0)
            {
              ((ContentValues)localObject1).put("id", localLong);
              g.a(g.this).insert("hstdata", null, (ContentValues)localObject1);
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putByteArray("mac", this.b.getBytes());
            ((Bundle)localObject1).putInt("hotspot", i);
            g.a(g.this, (Bundle)localObject1);
            continue;
            if (this.d) {
              g.b(g.this);
            }
            localObject1 = this.j;
            if (localObject1 != null) {
              ((Map)localObject1).clear();
            }
            g.a(g.this, false);
            return;
            localException1 = localException1;
            continue;
          }
          catch (Exception localException2)
          {
            continue;
          }
          Object localObject2 = null;
        }
      }
      if ((localObject1 != null) && (((JSONObject)localObject1).has("imo")))
      {
        localLong = Long.valueOf(((JSONObject)localObject1).getJSONObject("imo").getString("mac"));
        i = ((JSONObject)localObject1).getJSONObject("imo").getInt("mv");
        if (Jni.encode3(this.b).longValue() == localLong.longValue())
        {
          localObject1 = new ContentValues();
          ((ContentValues)localObject1).put("tt", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          ((ContentValues)localObject1).put("hst", Integer.valueOf(i));
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.g
 * JD-Core Version:    0.7.0.1
 */