package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import java.util.List;

public final class p
  extends SQLiteOpenHelper
{
  public static String a = "bugly_db";
  private static int b = 16;
  private Context c;
  private List<a> d;
  
  public p(Context paramContext, List<a> paramList)
  {
    super(paramContext, localStringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        String str = new String[] { "t_lr", "t_ui", "t_pf" }[i];
        StringBuilder localStringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        localStringBuilder.append(str);
        paramSQLiteDatabase.execSQL(localStringBuilder.toString(), new String[0]);
        i += 1;
      }
      finally
      {
        paramSQLiteDatabase = finally;
        try
        {
          if (y.b(paramSQLiteDatabase)) {
            break label85;
          }
          paramSQLiteDatabase.printStackTrace();
          return false;
        }
        finally
        {
          paramSQLiteDatabase = finally;
          throw paramSQLiteDatabase;
        }
      }
    }
    return true;
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    Object localObject1 = null;
    int i = 0;
    while ((localObject1 == null) && (i < 5))
    {
      i += 1;
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
          localObject1 = localSQLiteDatabase2;
          break;
        }
        finally
        {
          localObject2 = finally;
          continue;
        }
        try
        {
          for (;;)
          {
            y.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
            if (i == 5) {
              y.e("[Database] Failed to get db.", new Object[0]);
            }
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
        }
        finally {}
      }
    }
    return localSQLiteDatabase1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if ((localObject1 == null) && (i < 5)) {
        i += 1;
      }
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
          localObject1 = localSQLiteDatabase2;
          break;
        }
        finally
        {
          localObject2 = finally;
          continue;
        }
        try
        {
          for (;;)
          {
            y.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
            if (i == 5) {
              y.e("[Database] Failed to get db.", new Object[0]);
            }
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          break;
        }
        finally {}
      }
    }
    if (localObject1 == null) {
      y.d("[Database] db error delay error record 1min.", new Object[0]);
    }
    return localSQLiteDatabase1;
  }
  
  /* Error */
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   15: aload_2
    //   16: ldc 133
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc 135
    //   25: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc 137
    //   32: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 139
    //   39: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc 141
    //   46: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc 143
    //   53: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc 141
    //   60: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc 145
    //   67: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc 141
    //   74: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 147
    //   81: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc 149
    //   88: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc 151
    //   95: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc 153
    //   102: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: ldc 155
    //   109: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 40	java/lang/Object
    //   121: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_1
    //   126: aload_2
    //   127: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray 62	java/lang/String
    //   134: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: iconst_0
    //   139: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   142: aload_2
    //   143: ldc 159
    //   145: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc 135
    //   152: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc 137
    //   159: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: ldc 145
    //   166: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: ldc 141
    //   173: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: ldc 139
    //   180: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: ldc 141
    //   187: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: ldc 151
    //   194: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: ldc 153
    //   201: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc 161
    //   208: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: ldc 153
    //   215: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: ldc 147
    //   222: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc 149
    //   229: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc 155
    //   236: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray 40	java/lang/Object
    //   248: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload_1
    //   253: aload_2
    //   254: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 62	java/lang/String
    //   261: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: iconst_0
    //   266: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   269: aload_2
    //   270: ldc 163
    //   272: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc 135
    //   279: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc 165
    //   286: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_2
    //   291: ldc 145
    //   293: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: ldc 153
    //   300: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: ldc 139
    //   307: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc 141
    //   314: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_2
    //   319: ldc 147
    //   321: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: ldc 149
    //   328: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_2
    //   333: ldc 167
    //   335: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_2
    //   340: ldc 169
    //   342: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_2
    //   347: ldc 171
    //   349: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: iconst_0
    //   358: anewarray 40	java/lang/Object
    //   361: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_1
    //   366: aload_2
    //   367: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 62	java/lang/String
    //   374: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_2
    //   378: iconst_0
    //   379: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   382: aload_2
    //   383: ldc 173
    //   385: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: ldc 135
    //   392: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc 137
    //   399: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_2
    //   404: ldc 139
    //   406: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: ldc 141
    //   413: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc 175
    //   420: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_2
    //   425: ldc 153
    //   427: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: ldc 177
    //   434: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: ldc 141
    //   441: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: ldc 179
    //   448: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: ldc 141
    //   455: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_2
    //   460: ldc 181
    //   462: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_2
    //   467: ldc 141
    //   469: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: ldc 147
    //   476: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_2
    //   481: ldc 149
    //   483: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_2
    //   488: ldc 155
    //   490: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: iconst_0
    //   499: anewarray 40	java/lang/Object
    //   502: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_1
    //   507: aload_2
    //   508: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray 62	java/lang/String
    //   515: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_2
    //   519: iconst_0
    //   520: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   523: aload_2
    //   524: ldc 183
    //   526: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: ldc 185
    //   533: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: ldc 187
    //   540: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: ldc 189
    //   547: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_2
    //   552: ldc 191
    //   554: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_2
    //   559: ldc 193
    //   561: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_2
    //   566: ldc 195
    //   568: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_2
    //   573: ldc 197
    //   575: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc 199
    //   582: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_2
    //   587: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: iconst_0
    //   591: anewarray 40	java/lang/Object
    //   594: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: aload_1
    //   599: aload_2
    //   600: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: iconst_0
    //   604: anewarray 62	java/lang/String
    //   607: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload_2
    //   611: iconst_0
    //   612: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   615: aload_2
    //   616: ldc 201
    //   618: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc 185
    //   625: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: ldc 203
    //   632: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_2
    //   637: ldc 205
    //   639: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_2
    //   644: ldc 207
    //   646: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_2
    //   651: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: iconst_0
    //   655: anewarray 40	java/lang/Object
    //   658: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload_1
    //   663: aload_2
    //   664: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: iconst_0
    //   668: anewarray 62	java/lang/String
    //   671: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_2
    //   675: iconst_0
    //   676: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   679: aload_2
    //   680: ldc 209
    //   682: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_2
    //   687: ldc 135
    //   689: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_2
    //   694: ldc 165
    //   696: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload_2
    //   701: ldc 145
    //   703: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: ldc 153
    //   710: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: ldc 139
    //   717: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_2
    //   722: ldc 141
    //   724: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_2
    //   729: ldc 147
    //   731: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_2
    //   736: ldc 149
    //   738: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_2
    //   743: ldc 167
    //   745: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_2
    //   750: ldc 169
    //   752: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_2
    //   757: ldc 171
    //   759: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_2
    //   764: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: iconst_0
    //   768: anewarray 40	java/lang/Object
    //   771: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   774: pop
    //   775: aload_1
    //   776: aload_2
    //   777: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: iconst_0
    //   781: anewarray 62	java/lang/String
    //   784: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: aload_2
    //   788: iconst_0
    //   789: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   792: aload_2
    //   793: ldc 211
    //   795: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload_2
    //   800: ldc 135
    //   802: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload_2
    //   807: ldc 213
    //   809: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload_2
    //   814: ldc 215
    //   816: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload_2
    //   821: ldc 217
    //   823: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_2
    //   828: ldc 219
    //   830: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload_2
    //   835: ldc 155
    //   837: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload_2
    //   842: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: astore_2
    //   846: aload_2
    //   847: iconst_0
    //   848: anewarray 40	java/lang/Object
    //   851: invokestatic 157	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   854: pop
    //   855: aload_1
    //   856: aload_2
    //   857: iconst_0
    //   858: anewarray 62	java/lang/String
    //   861: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   864: goto +15 -> 879
    //   867: astore_2
    //   868: aload_2
    //   869: invokestatic 84	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   872: ifne +7 -> 879
    //   875: aload_2
    //   876: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   879: aload_0
    //   880: getfield 57	com/tencent/bugly/proguard/p:d	Ljava/util/List;
    //   883: astore_2
    //   884: aload_2
    //   885: ifnonnull +6 -> 891
    //   888: aload_0
    //   889: monitorexit
    //   890: return
    //   891: aload_2
    //   892: invokeinterface 225 1 0
    //   897: astore_2
    //   898: aload_2
    //   899: invokeinterface 231 1 0
    //   904: ifeq +36 -> 940
    //   907: aload_2
    //   908: invokeinterface 235 1 0
    //   913: checkcast 237	com/tencent/bugly/a
    //   916: astore_3
    //   917: aload_3
    //   918: aload_1
    //   919: invokevirtual 240	com/tencent/bugly/a:onDbCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   922: goto -24 -> 898
    //   925: astore_3
    //   926: aload_3
    //   927: invokestatic 84	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   930: ifne -32 -> 898
    //   933: aload_3
    //   934: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   937: goto -39 -> 898
    //   940: aload_0
    //   941: monitorexit
    //   942: return
    //   943: astore_1
    //   944: aload_0
    //   945: monitorexit
    //   946: aload_1
    //   947: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	p
    //   0	948	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	848	2	localObject1	Object
    //   867	9	2	localThrowable1	Throwable
    //   883	25	2	localObject2	Object
    //   916	2	3	locala	a
    //   925	9	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	864	867	finally
    //   917	922	925	finally
    //   868	879	943	finally
    //   879	884	943	finally
    //   891	898	943	finally
    //   898	917	943	finally
    //   926	937	943	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 250	com/tencent/bugly/crashreport/common/info/b:c	()I
    //   5: bipush 11
    //   7: if_icmplt +152 -> 159
    //   10: ldc 252
    //   12: iconst_2
    //   13: anewarray 40	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_2
    //   19: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_3
    //   26: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic 106	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield 57	com/tencent/bugly/proguard/p:d	Ljava/util/List;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +63 -> 105
    //   45: aload 4
    //   47: invokeinterface 225 1 0
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 231 1 0
    //   61: ifeq +44 -> 105
    //   64: aload 4
    //   66: invokeinterface 235 1 0
    //   71: checkcast 237	com/tencent/bugly/a
    //   74: astore 5
    //   76: aload 5
    //   78: aload_1
    //   79: iload_2
    //   80: iload_3
    //   81: invokevirtual 255	com/tencent/bugly/a:onDbDowngrade	(Landroid/database/sqlite/SQLiteDatabase;II)V
    //   84: goto -30 -> 54
    //   87: astore 5
    //   89: aload 5
    //   91: invokestatic 84	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   94: ifne -40 -> 54
    //   97: aload 5
    //   99: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   102: goto -48 -> 54
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial 257	com/tencent/bugly/proguard/p:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   110: ifeq +11 -> 121
    //   113: aload_0
    //   114: aload_1
    //   115: invokevirtual 259	com/tencent/bugly/proguard/p:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: ldc_w 261
    //   124: iconst_0
    //   125: anewarray 40	java/lang/Object
    //   128: invokestatic 106	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 55	com/tencent/bugly/proguard/p:c	Landroid/content/Context;
    //   136: getstatic 27	com/tencent/bugly/proguard/p:a	Ljava/lang/String;
    //   139: invokevirtual 267	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +15 -> 159
    //   147: aload_1
    //   148: invokevirtual 272	java/io/File:canWrite	()Z
    //   151: ifeq +8 -> 159
    //   154: aload_1
    //   155: invokevirtual 275	java/io/File:delete	()Z
    //   158: pop
    //   159: aload_0
    //   160: monitorexit
    //   161: return
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	p
    //   0	167	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	167	2	paramInt1	int
    //   0	167	3	paramInt2	int
    //   38	27	4	localObject	Object
    //   74	3	5	locala	a
    //   87	11	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   76	84	87	finally
    //   2	40	162	finally
    //   45	54	162	finally
    //   54	76	162	finally
    //   89	102	162	finally
    //   105	118	162	finally
    //   121	143	162	finally
    //   147	159	162	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 279
    //   5: iconst_2
    //   6: anewarray 40	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_2
    //   12: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iload_3
    //   19: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 106	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 57	com/tencent/bugly/proguard/p:d	Ljava/util/List;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +63 -> 98
    //   38: aload 4
    //   40: invokeinterface 225 1 0
    //   45: astore 4
    //   47: aload 4
    //   49: invokeinterface 231 1 0
    //   54: ifeq +44 -> 98
    //   57: aload 4
    //   59: invokeinterface 235 1 0
    //   64: checkcast 237	com/tencent/bugly/a
    //   67: astore 5
    //   69: aload 5
    //   71: aload_1
    //   72: iload_2
    //   73: iload_3
    //   74: invokevirtual 282	com/tencent/bugly/a:onDbUpgrade	(Landroid/database/sqlite/SQLiteDatabase;II)V
    //   77: goto -30 -> 47
    //   80: astore 5
    //   82: aload 5
    //   84: invokestatic 84	com/tencent/bugly/proguard/y:b	(Ljava/lang/Throwable;)Z
    //   87: ifne -40 -> 47
    //   90: aload 5
    //   92: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   95: goto -48 -> 47
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 257	com/tencent/bugly/proguard/p:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   103: ifeq +11 -> 114
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 259	com/tencent/bugly/proguard/p:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: ldc_w 261
    //   117: iconst_0
    //   118: anewarray 40	java/lang/Object
    //   121: invokestatic 106	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_0
    //   126: getfield 55	com/tencent/bugly/proguard/p:c	Landroid/content/Context;
    //   129: getstatic 27	com/tencent/bugly/proguard/p:a	Ljava/lang/String;
    //   132: invokevirtual 267	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +15 -> 152
    //   140: aload_1
    //   141: invokevirtual 272	java/io/File:canWrite	()Z
    //   144: ifeq +8 -> 152
    //   147: aload_1
    //   148: invokevirtual 275	java/io/File:delete	()Z
    //   151: pop
    //   152: aload_0
    //   153: monitorexit
    //   154: return
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	p
    //   0	160	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	160	2	paramInt1	int
    //   0	160	3	paramInt2	int
    //   31	27	4	localObject	Object
    //   67	3	5	locala	a
    //   80	11	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   69	77	80	finally
    //   2	33	155	finally
    //   38	47	155	finally
    //   47	69	155	finally
    //   82	95	155	finally
    //   98	111	155	finally
    //   114	136	155	finally
    //   140	152	155	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.p
 * JD-Core Version:    0.7.0.1
 */