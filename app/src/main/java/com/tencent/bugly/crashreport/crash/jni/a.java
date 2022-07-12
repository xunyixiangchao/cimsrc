package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements NativeExceptionHandler
{
  private final Context a;
  private final com.tencent.bugly.crashreport.crash.b b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  private static Map<String, String> a(String[] paramArrayOfString)
  {
    int i;
    if (paramArrayOfString == null) {
      i = 1;
    } else {
      i = paramArrayOfString.length;
    }
    HashMap localHashMap = new HashMap(i);
    if (paramArrayOfString != null)
    {
      i = 0;
      while (i < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i];
        if (str != null)
        {
          y.a("Extra message[%d]: %s", new Object[] { Integer.valueOf(i), str });
          String[] arrayOfString = str.split("=");
          if (arrayOfString.length == 2) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          } else {
            y.d("bad extraMsg %s", new Object[] { str });
          }
        }
        i += 1;
      }
    }
    y.c("not found extraMsg", new Object[0]);
    return localHashMap;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    y.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  /* Error */
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 81
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 47	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: iload 11
    //   12: ifle +837 -> 849
    //   15: new 83	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   22: astore 16
    //   24: aload 16
    //   26: aload 7
    //   28: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 16
    //   34: ldc 90
    //   36: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 16
    //   42: aload 12
    //   44: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 16
    //   50: ldc 92
    //   52: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 16
    //   58: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 16
    //   63: goto +3 -> 66
    //   66: aload 9
    //   68: invokestatic 101	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 21
    //   73: aload 18
    //   75: invokestatic 103	com/tencent/bugly/crashreport/crash/jni/a:a	([Ljava/lang/String;)Ljava/util/Map;
    //   78: astore 9
    //   80: aload 9
    //   82: ldc 105
    //   84: invokeinterface 109 2 0
    //   89: checkcast 51	java/lang/String
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +760 -> 856
    //   99: aload 7
    //   101: ldc 111
    //   103: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +750 -> 856
    //   109: ldc 117
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 47	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: iconst_1
    //   120: istore 19
    //   122: goto +3 -> 125
    //   125: aload_0
    //   126: getfield 25	com/tencent/bugly/crashreport/crash/jni/a:c	Lcom/tencent/bugly/crashreport/common/info/a;
    //   129: astore 7
    //   131: aload 9
    //   133: ldc 119
    //   135: invokeinterface 109 2 0
    //   140: checkcast 51	java/lang/String
    //   143: astore 18
    //   145: aload 18
    //   147: ifnull +32 -> 179
    //   150: aload 18
    //   152: invokevirtual 123	java/lang/String:length	()I
    //   155: ifne +6 -> 161
    //   158: goto +21 -> 179
    //   161: ldc 125
    //   163: iconst_1
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 18
    //   171: aastore
    //   172: invokestatic 69	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   175: pop
    //   176: goto +10 -> 186
    //   179: aload 7
    //   181: getfield 130	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   184: astore 18
    //   186: aload 9
    //   188: ldc 132
    //   190: invokeinterface 109 2 0
    //   195: checkcast 51	java/lang/String
    //   198: astore 22
    //   200: ldc 134
    //   202: iconst_2
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 22
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: iload_2
    //   214: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 69	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   221: pop
    //   222: aload 22
    //   224: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifeq +61 -> 288
    //   230: invokestatic 146	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   233: astore 22
    //   235: new 83	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   242: astore 7
    //   244: aload 7
    //   246: aload 22
    //   248: invokevirtual 149	java/lang/Thread:getName	()Ljava/lang/String;
    //   251: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 7
    //   257: ldc 90
    //   259: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 7
    //   265: iload_2
    //   266: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 7
    //   272: ldc 92
    //   274: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 7
    //   280: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: astore 22
    //   285: goto +46 -> 331
    //   288: new 83	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: aload 7
    //   299: aload 22
    //   301: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 7
    //   307: ldc 90
    //   309: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 7
    //   315: iload_2
    //   316: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 7
    //   322: ldc 92
    //   324: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: goto -50 -> 278
    //   331: lload 5
    //   333: ldc2_w 153
    //   336: ldiv
    //   337: lstore 5
    //   339: aload 9
    //   341: ldc 156
    //   343: invokeinterface 109 2 0
    //   348: checkcast 51	java/lang/String
    //   351: astore 23
    //   353: aload 9
    //   355: ldc 158
    //   357: invokeinterface 109 2 0
    //   362: checkcast 51	java/lang/String
    //   365: astore 24
    //   367: aload_0
    //   368: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   371: invokevirtual 163	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   374: ifne +13 -> 387
    //   377: ldc 165
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 65	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   386: pop
    //   387: aload_0
    //   388: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   391: invokevirtual 168	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   394: getfield 174	com/tencent/bugly/crashreport/common/strategy/StrategyBean:e	Z
    //   397: istore 20
    //   399: iload 20
    //   401: ifne +461 -> 862
    //   404: aload_0
    //   405: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   408: invokevirtual 163	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   411: ifeq +451 -> 862
    //   414: ldc 176
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 178	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   423: pop
    //   424: invokestatic 182	com/tencent/bugly/proguard/ab:a	()Ljava/lang/String;
    //   427: astore 7
    //   429: new 83	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   436: astore 9
    //   438: aload 9
    //   440: aload 16
    //   442: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 9
    //   448: ldc 184
    //   450: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 9
    //   456: aload 8
    //   458: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 9
    //   464: ldc 184
    //   466: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 9
    //   472: aload 21
    //   474: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: ldc 186
    //   480: aload 7
    //   482: aload 18
    //   484: aload 22
    //   486: aload 9
    //   488: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: aconst_null
    //   492: invokestatic 191	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   495: aload 10
    //   497: invokestatic 194	com/tencent/bugly/proguard/ab:b	(Ljava/lang/String;)V
    //   500: return
    //   501: ldc 196
    //   503: astore 7
    //   505: aload 7
    //   507: astore 9
    //   509: iload 11
    //   511: ifgt +83 -> 594
    //   514: iload 13
    //   516: ifle +10 -> 526
    //   519: iload 13
    //   521: invokestatic 201	com/tencent/bugly/crashreport/common/info/AppInfo:a	(I)Ljava/lang/String;
    //   524: astore 7
    //   526: aload 7
    //   528: astore 9
    //   530: aload 7
    //   532: iload 13
    //   534: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   537: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   540: ifne +54 -> 594
    //   543: new 83	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   550: astore 9
    //   552: aload 9
    //   554: aload 7
    //   556: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 9
    //   562: ldc 90
    //   564: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 9
    //   570: iload 13
    //   572: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 9
    //   578: ldc 92
    //   580: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 9
    //   586: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: astore 7
    //   591: goto +7 -> 598
    //   594: aload 9
    //   596: astore 7
    //   598: aload_0
    //   599: aload 18
    //   601: aload 22
    //   603: lload 5
    //   605: lload_3
    //   606: ldc2_w 153
    //   609: lmul
    //   610: ladd
    //   611: aload 16
    //   613: aload 8
    //   615: aload 21
    //   617: aload 12
    //   619: aload 7
    //   621: aload 10
    //   623: aload 23
    //   625: aload 24
    //   627: aload 17
    //   629: aconst_null
    //   630: aconst_null
    //   631: iconst_1
    //   632: iload 19
    //   634: invokevirtual 207	com/tencent/bugly/crashreport/crash/jni/a:packageCrashDatas	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;ZZ)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   637: astore 9
    //   639: aload 9
    //   641: ifnonnull +14 -> 655
    //   644: ldc 209
    //   646: iconst_0
    //   647: anewarray 4	java/lang/Object
    //   650: invokestatic 178	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   653: pop
    //   654: return
    //   655: invokestatic 182	com/tencent/bugly/proguard/ab:a	()Ljava/lang/String;
    //   658: astore 7
    //   660: new 83	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   667: astore 10
    //   669: aload 10
    //   671: aload 16
    //   673: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: ldc 184
    //   681: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 10
    //   687: aload 8
    //   689: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 10
    //   695: ldc 184
    //   697: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 10
    //   703: aload 21
    //   705: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: ldc 186
    //   711: aload 7
    //   713: aload 18
    //   715: aload 22
    //   717: aload 10
    //   719: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: aload 9
    //   724: invokestatic 191	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   727: aload_0
    //   728: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   731: astore 7
    //   733: aload 7
    //   735: ifnonnull +14 -> 749
    //   738: ldc 211
    //   740: iconst_0
    //   741: anewarray 4	java/lang/Object
    //   744: invokestatic 65	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   747: pop
    //   748: return
    //   749: aload 7
    //   751: aload 9
    //   753: invokevirtual 214	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   756: ifne +121 -> 877
    //   759: iconst_1
    //   760: istore_1
    //   761: goto +3 -> 764
    //   764: aconst_null
    //   765: astore 7
    //   767: invokestatic 220	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getInstance	()Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   770: astore 8
    //   772: aload 8
    //   774: ifnull +10 -> 784
    //   777: aload 8
    //   779: invokevirtual 223	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getDumpFilePath	()Ljava/lang/String;
    //   782: astore 7
    //   784: iconst_1
    //   785: aload 7
    //   787: invokestatic 226	com/tencent/bugly/crashreport/crash/jni/b:a	(ZLjava/lang/String;)V
    //   790: iload_1
    //   791: ifeq +16 -> 807
    //   794: aload_0
    //   795: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   798: aload 9
    //   800: ldc2_w 227
    //   803: iconst_1
    //   804: invokevirtual 231	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   807: aload_0
    //   808: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   811: aload 9
    //   813: invokevirtual 234	com/tencent/bugly/crashreport/crash/b:c	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   816: invokestatic 239	com/tencent/bugly/crashreport/crash/c:a	()Lcom/tencent/bugly/crashreport/crash/c;
    //   819: invokevirtual 241	com/tencent/bugly/crashreport/crash/c:e	()V
    //   822: return
    //   823: astore 7
    //   825: goto +10 -> 835
    //   828: astore 7
    //   830: goto +5 -> 835
    //   833: astore 7
    //   835: aload 7
    //   837: invokestatic 244	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   840: ifne +8 -> 848
    //   843: aload 7
    //   845: invokevirtual 249	java/lang/Throwable:printStackTrace	()V
    //   848: return
    //   849: aload 7
    //   851: astore 16
    //   853: goto -787 -> 66
    //   856: iconst_0
    //   857: istore 19
    //   859: goto -734 -> 125
    //   862: iload 11
    //   864: ifle +10 -> 874
    //   867: ldc 251
    //   869: astore 12
    //   871: goto -370 -> 501
    //   874: goto -373 -> 501
    //   877: iconst_0
    //   878: istore_1
    //   879: goto -115 -> 764
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	a
    //   0	882	1	paramInt1	int
    //   0	882	2	paramInt2	int
    //   0	882	3	paramLong1	long
    //   0	882	5	paramLong2	long
    //   0	882	7	paramString1	String
    //   0	882	8	paramString2	String
    //   0	882	9	paramString3	String
    //   0	882	10	paramString4	String
    //   0	882	11	paramInt3	int
    //   0	882	12	paramString5	String
    //   0	882	13	paramInt4	int
    //   0	882	14	paramInt5	int
    //   0	882	15	paramInt6	int
    //   0	882	16	paramString6	String
    //   0	882	17	paramString7	String
    //   0	882	18	paramArrayOfString	String[]
    //   120	738	19	bool1	boolean
    //   397	3	20	bool2	boolean
    //   71	633	21	str1	String
    //   198	518	22	localObject	Object
    //   351	273	23	str2	String
    //   365	261	24	str3	String
    // Exception table:
    //   from	to	target	type
    //   727	733	823	finally
    //   738	748	823	finally
    //   749	759	823	finally
    //   767	772	823	finally
    //   777	784	823	finally
    //   784	790	823	finally
    //   794	807	823	finally
    //   807	822	823	finally
    //   598	639	828	finally
    //   644	654	828	finally
    //   655	727	828	finally
    //   15	63	833	finally
    //   66	94	833	finally
    //   99	119	833	finally
    //   125	145	833	finally
    //   150	158	833	finally
    //   161	176	833	finally
    //   179	186	833	finally
    //   186	278	833	finally
    //   278	285	833	finally
    //   288	328	833	finally
    //   331	387	833	finally
    //   387	399	833	finally
    //   404	500	833	finally
    //   519	526	833	finally
    //   530	591	833	finally
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = c.a().m();
    if (paramBoolean2) {
      y.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.b = 1;
    localCrashDetailBean.e = this.c.k();
    Object localObject = this.c;
    localCrashDetailBean.f = ((com.tencent.bugly.crashreport.common.info.a)localObject).i;
    localCrashDetailBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).u();
    localCrashDetailBean.m = this.c.g();
    localCrashDetailBean.n = paramString3;
    localObject = "";
    if (paramBoolean2) {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      paramString3 = "";
    }
    localCrashDetailBean.o = paramString3;
    localCrashDetailBean.p = paramString4;
    if (paramString5 == null) {
      paramString5 = (String)localObject;
    }
    localCrashDetailBean.q = paramString5;
    localCrashDetailBean.r = paramLong;
    localCrashDetailBean.u = ab.a(paramString5.getBytes());
    localCrashDetailBean.A = paramString1;
    localCrashDetailBean.B = paramString2;
    localCrashDetailBean.L = this.c.w();
    localCrashDetailBean.h = this.c.t();
    localCrashDetailBean.i = this.c.F();
    localCrashDetailBean.v = paramString8;
    paramString2 = NativeCrashHandler.getInstance();
    if (paramString2 != null) {
      paramString2 = paramString2.getDumpFilePath();
    } else {
      paramString2 = null;
    }
    paramString3 = b.a(paramString2, paramString8);
    if (!ab.a(paramString3)) {
      localCrashDetailBean.Y = paramString3;
    }
    localCrashDetailBean.Z = b.b(paramString2);
    localCrashDetailBean.w = b.a(paramString9, c.e, null, false);
    localCrashDetailBean.x = b.a(paramString10, c.e, null, true);
    localCrashDetailBean.M = paramString7;
    localCrashDetailBean.N = paramString6;
    localCrashDetailBean.O = paramString11;
    localCrashDetailBean.F = this.c.o();
    localCrashDetailBean.G = this.c.n();
    localCrashDetailBean.H = this.c.p();
    localCrashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
    localCrashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
    localCrashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
    if (paramBoolean1)
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
      if (localCrashDetailBean.w == null) {
        localCrashDetailBean.w = ab.a(c.e, null);
      }
      localCrashDetailBean.y = aa.a();
      paramString2 = this.c;
      localCrashDetailBean.P = paramString2.a;
      localCrashDetailBean.Q = paramString2.a();
      localCrashDetailBean.z = ab.a(this.c.h(), c.f, false);
      int i = localCrashDetailBean.q.indexOf("java:\n");
      if (i > 0)
      {
        i += 6;
        if (i < localCrashDetailBean.q.length())
        {
          paramString2 = localCrashDetailBean.q;
          paramString2 = paramString2.substring(i, paramString2.length() - 1);
          if ((paramString2.length() > 0) && (localCrashDetailBean.z.containsKey(localCrashDetailBean.B)))
          {
            paramString3 = (String)localCrashDetailBean.z.get(localCrashDetailBean.B);
            int j = paramString3.indexOf(paramString2);
            if (j > 0)
            {
              paramString2 = paramString3.substring(j);
              localCrashDetailBean.z.put(localCrashDetailBean.B, paramString2);
              localCrashDetailBean.q = localCrashDetailBean.q.substring(0, i);
              paramString3 = new StringBuilder();
              paramString3.append(localCrashDetailBean.q);
              paramString3.append(paramString2);
              localCrashDetailBean.q = paramString3.toString();
            }
          }
        }
      }
      if (paramString1 == null) {
        localCrashDetailBean.A = this.c.d;
      }
      this.b.d(localCrashDetailBean);
      localCrashDetailBean.T = this.c.D();
      localCrashDetailBean.U = this.c.E();
      localCrashDetailBean.V = this.c.x();
      localCrashDetailBean.W = this.c.C();
      return localCrashDetailBean;
    }
    localCrashDetailBean.C = -1L;
    localCrashDetailBean.D = -1L;
    localCrashDetailBean.E = -1L;
    if (localCrashDetailBean.w == null) {
      localCrashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
    }
    localCrashDetailBean.P = -1L;
    localCrashDetailBean.T = -1;
    localCrashDetailBean.U = -1;
    localCrashDetailBean.V = paramMap;
    localCrashDetailBean.W = this.c.C();
    localCrashDetailBean.z = null;
    if (paramString1 == null) {
      localCrashDetailBean.A = "unknown(record)";
    }
    if (paramArrayOfByte != null) {
      localCrashDetailBean.y = paramArrayOfByte;
    }
    return localCrashDetailBean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.a
 * JD-Core Version:    0.7.0.1
 */