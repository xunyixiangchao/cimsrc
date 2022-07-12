package com.tencent.bugly;

import android.content.Context;
import android.util.Log;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public static boolean a = true;
  public static List<a> b = new ArrayList();
  public static boolean c;
  private static o d;
  private static boolean e;
  
  public static void a(Context paramContext)
  {
    try
    {
      a(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    try
    {
      if (e)
      {
        y.d("[init] initial Multi-times, ignore this.", new Object[0]);
        return;
      }
      if (paramContext == null)
      {
        Log.w(y.a, "[init] context of init() is null, check it.");
        return;
      }
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      if (a(locala))
      {
        a = false;
        return;
      }
      String str = locala.f();
      if (str == null)
      {
        Log.e(y.a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        return;
      }
      a(paramContext, str, locala.t, paramBuglyStrategy);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/tencent/bugly/b:e	Z
    //   6: ifeq +17 -> 23
    //   9: ldc 32
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: ifnonnull +16 -> 40
    //   27: getstatic 40	com/tencent/bugly/proguard/y:a	Ljava/lang/String;
    //   30: ldc 76
    //   32: invokestatic 48	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: aload_1
    //   41: ifnonnull +16 -> 57
    //   44: getstatic 40	com/tencent/bugly/proguard/y:a	Ljava/lang/String;
    //   47: ldc 78
    //   49: invokestatic 66	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   52: pop
    //   53: ldc 2
    //   55: monitorexit
    //   56: return
    //   57: iconst_1
    //   58: putstatic 30	com/tencent/bugly/b:e	Z
    //   61: iload_2
    //   62: ifeq +91 -> 153
    //   65: iconst_1
    //   66: putstatic 80	com/tencent/bugly/b:c	Z
    //   69: iconst_1
    //   70: putstatic 82	com/tencent/bugly/proguard/y:b	Z
    //   73: ldc 84
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   82: pop
    //   83: ldc 86
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 88	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: ldc 90
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   102: pop
    //   103: ldc 92
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   112: pop
    //   113: ldc 94
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: ldc 96
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: ldc 86
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 88	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   142: pop
    //   143: ldc 98
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 100	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: ldc 102
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   162: pop
    //   163: ldc 106
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 100	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: ldc 108
    //   175: iconst_1
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: ldc 110
    //   183: aastore
    //   184: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_0
    //   189: invokestatic 115	com/tencent/bugly/proguard/ab:a	(Landroid/content/Context;)Landroid/content/Context;
    //   192: astore 8
    //   194: aload 8
    //   196: invokestatic 53	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   199: astore 10
    //   201: aload 10
    //   203: invokevirtual 118	com/tencent/bugly/crashreport/common/info/a:s	()Ljava/lang/String;
    //   206: pop
    //   207: aload 8
    //   209: invokestatic 122	com/tencent/bugly/proguard/aa:a	(Landroid/content/Context;)V
    //   212: aload 8
    //   214: getstatic 23	com/tencent/bugly/b:b	Ljava/util/List;
    //   217: invokestatic 127	com/tencent/bugly/proguard/o:a	(Landroid/content/Context;Ljava/util/List;)Lcom/tencent/bugly/proguard/o;
    //   220: putstatic 129	com/tencent/bugly/b:d	Lcom/tencent/bugly/proguard/o;
    //   223: aload 8
    //   225: invokestatic 134	com/tencent/bugly/proguard/v:a	(Landroid/content/Context;)Lcom/tencent/bugly/proguard/v;
    //   228: pop
    //   229: aload 8
    //   231: getstatic 23	com/tencent/bugly/b:b	Ljava/util/List;
    //   234: invokestatic 139	com/tencent/bugly/crashreport/common/strategy/a:a	(Landroid/content/Context;Ljava/util/List;)Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   237: pop
    //   238: aload 8
    //   240: invokestatic 144	com/tencent/bugly/proguard/m:a	(Landroid/content/Context;)Lcom/tencent/bugly/proguard/m;
    //   243: astore 9
    //   245: aload 10
    //   247: invokestatic 56	com/tencent/bugly/b:a	(Lcom/tencent/bugly/crashreport/common/info/a;)Z
    //   250: ifeq +11 -> 261
    //   253: iconst_0
    //   254: putstatic 58	com/tencent/bugly/b:a	Z
    //   257: ldc 2
    //   259: monitorexit
    //   260: return
    //   261: aload 10
    //   263: aload_1
    //   264: invokevirtual 147	com/tencent/bugly/crashreport/common/info/a:a	(Ljava/lang/String;)V
    //   267: ldc 149
    //   269: iconst_1
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload_1
    //   276: aastore
    //   277: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload_3
    //   282: ifnull +580 -> 862
    //   285: aload_3
    //   286: invokevirtual 154	com/tencent/bugly/BuglyStrategy:getAppVersion	()Ljava/lang/String;
    //   289: astore_1
    //   290: aload_1
    //   291: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifne +71 -> 365
    //   297: aload_1
    //   298: astore_0
    //   299: aload_1
    //   300: invokevirtual 166	java/lang/String:length	()I
    //   303: bipush 100
    //   305: if_icmple +37 -> 342
    //   308: aload_1
    //   309: iconst_0
    //   310: bipush 100
    //   312: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   315: astore_0
    //   316: ldc 172
    //   318: iconst_3
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload_1
    //   325: aastore
    //   326: dup
    //   327: iconst_1
    //   328: bipush 100
    //   330: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: dup
    //   335: iconst_2
    //   336: aload_0
    //   337: aastore
    //   338: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 10
    //   344: aload_0
    //   345: putfield 181	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   348: ldc 183
    //   350: iconst_1
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload_3
    //   357: invokevirtual 154	com/tencent/bugly/BuglyStrategy:getAppVersion	()Ljava/lang/String;
    //   360: aastore
    //   361: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_3
    //   366: invokevirtual 187	com/tencent/bugly/BuglyStrategy:isReplaceOldChannel	()Z
    //   369: ifeq +87 -> 456
    //   372: aload_3
    //   373: invokevirtual 190	com/tencent/bugly/BuglyStrategy:getAppChannel	()Ljava/lang/String;
    //   376: astore_1
    //   377: aload_1
    //   378: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifne +120 -> 501
    //   384: aload_1
    //   385: astore_0
    //   386: aload_1
    //   387: invokevirtual 166	java/lang/String:length	()I
    //   390: bipush 100
    //   392: if_icmple +37 -> 429
    //   395: aload_1
    //   396: iconst_0
    //   397: bipush 100
    //   399: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   402: astore_0
    //   403: ldc 192
    //   405: iconst_3
    //   406: anewarray 4	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload_1
    //   412: aastore
    //   413: dup
    //   414: iconst_1
    //   415: bipush 100
    //   417: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: dup
    //   422: iconst_2
    //   423: aload_0
    //   424: aastore
    //   425: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   428: pop
    //   429: getstatic 129	com/tencent/bugly/b:d	Lcom/tencent/bugly/proguard/o;
    //   432: sipush 556
    //   435: ldc 194
    //   437: aload_0
    //   438: invokevirtual 198	java/lang/String:getBytes	()[B
    //   441: aconst_null
    //   442: iconst_0
    //   443: invokevirtual 201	com/tencent/bugly/proguard/o:a	(ILjava/lang/String;[BLcom/tencent/bugly/proguard/n;Z)Z
    //   446: pop
    //   447: aload 10
    //   449: aload_0
    //   450: putfield 204	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   453: goto +48 -> 501
    //   456: getstatic 129	com/tencent/bugly/b:d	Lcom/tencent/bugly/proguard/o;
    //   459: sipush 556
    //   462: aconst_null
    //   463: iconst_1
    //   464: invokevirtual 207	com/tencent/bugly/proguard/o:a	(ILcom/tencent/bugly/proguard/n;Z)Ljava/util/Map;
    //   467: astore_0
    //   468: aload_0
    //   469: ifnull +32 -> 501
    //   472: aload_0
    //   473: ldc 194
    //   475: invokeinterface 213 2 0
    //   480: checkcast 215	[B
    //   483: astore_0
    //   484: aload_0
    //   485: ifnull +16 -> 501
    //   488: aload 10
    //   490: new 162	java/lang/String
    //   493: dup
    //   494: aload_0
    //   495: invokespecial 218	java/lang/String:<init>	([B)V
    //   498: putfield 204	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   501: ldc 220
    //   503: iconst_1
    //   504: anewarray 4	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload 10
    //   511: getfield 204	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   514: aastore
    //   515: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   518: pop
    //   519: goto +14 -> 533
    //   522: astore_0
    //   523: getstatic 80	com/tencent/bugly/b:c	Z
    //   526: ifeq +7 -> 533
    //   529: aload_0
    //   530: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   533: aload_3
    //   534: invokevirtual 226	com/tencent/bugly/BuglyStrategy:getAppPackageName	()Ljava/lang/String;
    //   537: astore_1
    //   538: aload_1
    //   539: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   542: ifne +71 -> 613
    //   545: aload_1
    //   546: astore_0
    //   547: aload_1
    //   548: invokevirtual 166	java/lang/String:length	()I
    //   551: bipush 100
    //   553: if_icmple +37 -> 590
    //   556: aload_1
    //   557: iconst_0
    //   558: bipush 100
    //   560: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   563: astore_0
    //   564: ldc 228
    //   566: iconst_3
    //   567: anewarray 4	java/lang/Object
    //   570: dup
    //   571: iconst_0
    //   572: aload_1
    //   573: aastore
    //   574: dup
    //   575: iconst_1
    //   576: bipush 100
    //   578: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: dup
    //   583: iconst_2
    //   584: aload_0
    //   585: aastore
    //   586: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   589: pop
    //   590: aload 10
    //   592: aload_0
    //   593: putfield 230	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   596: ldc 232
    //   598: iconst_1
    //   599: anewarray 4	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload_3
    //   605: invokevirtual 226	com/tencent/bugly/BuglyStrategy:getAppPackageName	()Ljava/lang/String;
    //   608: aastore
    //   609: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   612: pop
    //   613: aload_3
    //   614: invokevirtual 235	com/tencent/bugly/BuglyStrategy:getDeviceID	()Ljava/lang/String;
    //   617: astore_1
    //   618: aload_1
    //   619: ifnull +68 -> 687
    //   622: aload_1
    //   623: astore_0
    //   624: aload_1
    //   625: invokevirtual 166	java/lang/String:length	()I
    //   628: bipush 100
    //   630: if_icmple +37 -> 667
    //   633: aload_1
    //   634: iconst_0
    //   635: bipush 100
    //   637: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   640: astore_0
    //   641: ldc 237
    //   643: iconst_3
    //   644: anewarray 4	java/lang/Object
    //   647: dup
    //   648: iconst_0
    //   649: aload_1
    //   650: aastore
    //   651: dup
    //   652: iconst_1
    //   653: bipush 100
    //   655: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   658: aastore
    //   659: dup
    //   660: iconst_2
    //   661: aload_0
    //   662: aastore
    //   663: invokestatic 37	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   666: pop
    //   667: aload 10
    //   669: aload_0
    //   670: invokevirtual 239	com/tencent/bugly/crashreport/common/info/a:c	(Ljava/lang/String;)V
    //   673: ldc 241
    //   675: iconst_1
    //   676: anewarray 4	java/lang/Object
    //   679: dup
    //   680: iconst_0
    //   681: aload_0
    //   682: aastore
    //   683: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   686: pop
    //   687: aload_3
    //   688: invokevirtual 244	com/tencent/bugly/BuglyStrategy:getDeviceModel	()Ljava/lang/String;
    //   691: astore_0
    //   692: aload_0
    //   693: ifnull +23 -> 716
    //   696: aload 10
    //   698: aload_0
    //   699: invokevirtual 246	com/tencent/bugly/crashreport/common/info/a:d	(Ljava/lang/String;)V
    //   702: ldc 248
    //   704: iconst_1
    //   705: anewarray 4	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: aload_0
    //   711: aastore
    //   712: invokestatic 104	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   715: pop
    //   716: aload 10
    //   718: aload_3
    //   719: invokevirtual 251	com/tencent/bugly/BuglyStrategy:isUploadProcess	()Z
    //   722: putfield 252	com/tencent/bugly/crashreport/common/info/a:e	Z
    //   725: aload_3
    //   726: invokevirtual 255	com/tencent/bugly/BuglyStrategy:isBuglyLogUpload	()Z
    //   729: putstatic 256	com/tencent/bugly/proguard/aa:a	Z
    //   732: goto +130 -> 862
    //   735: getstatic 23	com/tencent/bugly/b:b	Ljava/util/List;
    //   738: invokeinterface 261 1 0
    //   743: istore 5
    //   745: iload 4
    //   747: iload 5
    //   749: if_icmpge +65 -> 814
    //   752: aload 9
    //   754: getstatic 23	com/tencent/bugly/b:b	Ljava/util/List;
    //   757: iload 4
    //   759: invokeinterface 264 2 0
    //   764: checkcast 266	com/tencent/bugly/a
    //   767: getfield 270	com/tencent/bugly/a:id	I
    //   770: invokevirtual 273	com/tencent/bugly/proguard/m:a	(I)Z
    //   773: ifeq +95 -> 868
    //   776: getstatic 23	com/tencent/bugly/b:b	Ljava/util/List;
    //   779: iload 4
    //   781: invokeinterface 264 2 0
    //   786: checkcast 266	com/tencent/bugly/a
    //   789: aload 8
    //   791: iload_2
    //   792: aload_3
    //   793: invokevirtual 277	com/tencent/bugly/a:init	(Landroid/content/Context;ZLcom/tencent/bugly/BuglyStrategy;)V
    //   796: goto +72 -> 868
    //   799: astore_0
    //   800: aload_0
    //   801: invokestatic 280	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   804: ifne +64 -> 868
    //   807: aload_0
    //   808: invokevirtual 283	java/lang/Throwable:printStackTrace	()V
    //   811: goto +57 -> 868
    //   814: aload 8
    //   816: aload_3
    //   817: invokestatic 286	com/tencent/bugly/crashreport/biz/b:a	(Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V
    //   820: aload_3
    //   821: ifnull +56 -> 877
    //   824: aload_3
    //   825: invokevirtual 290	com/tencent/bugly/BuglyStrategy:getAppReportDelay	()J
    //   828: lstore 6
    //   830: goto +3 -> 833
    //   833: invokestatic 293	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   836: lload 6
    //   838: invokevirtual 296	com/tencent/bugly/crashreport/common/strategy/a:a	(J)V
    //   841: ldc_w 298
    //   844: iconst_0
    //   845: anewarray 4	java/lang/Object
    //   848: invokestatic 100	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   851: pop
    //   852: ldc 2
    //   854: monitorexit
    //   855: return
    //   856: astore_0
    //   857: ldc 2
    //   859: monitorexit
    //   860: aload_0
    //   861: athrow
    //   862: iconst_0
    //   863: istore 4
    //   865: goto -130 -> 735
    //   868: iload 4
    //   870: iconst_1
    //   871: iadd
    //   872: istore 4
    //   874: goto -139 -> 735
    //   877: lconst_0
    //   878: lstore 6
    //   880: goto -47 -> 833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	883	0	paramContext	Context
    //   0	883	1	paramString	String
    //   0	883	2	paramBoolean	boolean
    //   0	883	3	paramBuglyStrategy	BuglyStrategy
    //   745	128	4	i	int
    //   743	7	5	j	int
    //   828	51	6	l	long
    //   192	623	8	localContext	Context
    //   243	510	9	localm	com.tencent.bugly.proguard.m
    //   199	518	10	locala	com.tencent.bugly.crashreport.common.info.a
    // Exception table:
    //   from	to	target	type
    //   365	384	522	java/lang/Exception
    //   386	429	522	java/lang/Exception
    //   429	453	522	java/lang/Exception
    //   456	468	522	java/lang/Exception
    //   472	484	522	java/lang/Exception
    //   488	501	522	java/lang/Exception
    //   501	519	522	java/lang/Exception
    //   752	796	799	finally
    //   3	19	856	finally
    //   27	36	856	finally
    //   44	53	856	finally
    //   57	61	856	finally
    //   65	153	856	finally
    //   153	257	856	finally
    //   261	281	856	finally
    //   285	297	856	finally
    //   299	342	856	finally
    //   342	365	856	finally
    //   365	384	856	finally
    //   386	429	856	finally
    //   429	453	856	finally
    //   456	468	856	finally
    //   472	484	856	finally
    //   488	501	856	finally
    //   501	519	856	finally
    //   523	533	856	finally
    //   533	545	856	finally
    //   547	590	856	finally
    //   590	613	856	finally
    //   613	618	856	finally
    //   624	667	856	finally
    //   667	687	856	finally
    //   687	692	856	finally
    //   696	716	856	finally
    //   716	732	856	finally
    //   735	745	856	finally
    //   800	811	856	finally
    //   814	820	856	finally
    //   824	830	856	finally
    //   833	852	856	finally
  }
  
  public static void a(a parama)
  {
    try
    {
      if (!b.contains(parama)) {
        b.add(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private static boolean a(com.tencent.bugly.crashreport.common.info.a parama)
  {
    parama = parama.n;
    return (parama != null) && (parama.contains("bugly"));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.b
 * JD-Core Version:    0.7.0.1
 */