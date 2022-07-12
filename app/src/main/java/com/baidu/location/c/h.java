package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{
  public List<ScanResult> a;
  private long b;
  private long c = 0L;
  private boolean d = false;
  private boolean e;
  
  public h(List<ScanResult> paramList, long paramLong)
  {
    this.b = paramLong;
    this.a = paramList;
    this.c = System.currentTimeMillis();
    try
    {
      n();
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("wpa|wep", 2).matcher(paramString).find();
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      if (!paramString.contains("&"))
      {
        str = paramString;
        if (!paramString.contains(";")) {}
      }
      else
      {
        str = paramString.replace("&", "_").replace(";", "_");
      }
    }
    return str;
  }
  
  private int m()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  private void n()
  {
    if (m() < 1) {
      return;
    }
    int j = this.a.size() - 1;
    int i = 1;
    while ((j >= 1) && (i != 0))
    {
      int k = 0;
      int m;
      for (i = 0; k < j; i = m)
      {
        m = i;
        if (this.a.get(k) != null)
        {
          Object localObject = this.a;
          int n = k + 1;
          m = i;
          if (((List)localObject).get(n) != null)
          {
            m = i;
            if (((ScanResult)this.a.get(k)).level < ((ScanResult)this.a.get(n)).level)
            {
              localObject = (ScanResult)this.a.get(n);
              List localList = this.a;
              localList.set(n, localList.get(k));
              this.a.set(k, localObject);
              m = 1;
            }
          }
        }
        k += 1;
      }
      j -= 1;
    }
  }
  
  public int a()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public String a(int paramInt)
  {
    return a(paramInt, false, false);
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 118	com/baidu/location/c/h:a	()I
    //   4: iconst_1
    //   5: if_icmpge +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: new 120	java/util/Random
    //   13: dup
    //   14: invokespecial 121	java/util/Random:<init>	()V
    //   17: astore 31
    //   19: new 123	java/lang/StringBuffer
    //   22: dup
    //   23: sipush 512
    //   26: invokespecial 126	java/lang/StringBuffer:<init>	(I)V
    //   29: astore 29
    //   31: new 128	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 129	java/util/ArrayList:<init>	()V
    //   38: astore 30
    //   40: invokestatic 134	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   43: invokevirtual 138	com/baidu/location/c/i:k	()Landroid/net/wifi/WifiInfo;
    //   46: astore 26
    //   48: aload 26
    //   50: ifnull +73 -> 123
    //   53: aload 26
    //   55: invokevirtual 144	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   58: ifnull +65 -> 123
    //   61: aload 26
    //   63: invokevirtual 144	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   66: ldc 146
    //   68: ldc 148
    //   70: invokevirtual 84	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   73: astore 25
    //   75: aload 26
    //   77: invokevirtual 151	android/net/wifi/WifiInfo:getRssi	()I
    //   80: istore 4
    //   82: invokestatic 134	com/baidu/location/c/i:a	()Lcom/baidu/location/c/i;
    //   85: invokevirtual 153	com/baidu/location/c/i:m	()Ljava/lang/String;
    //   88: astore 28
    //   90: iload 4
    //   92: istore 6
    //   94: aload 25
    //   96: astore 27
    //   98: aload 28
    //   100: astore 26
    //   102: iload 4
    //   104: ifge +29 -> 133
    //   107: iload 4
    //   109: ineg
    //   110: istore 6
    //   112: aload 25
    //   114: astore 27
    //   116: aload 28
    //   118: astore 26
    //   120: goto +13 -> 133
    //   123: aconst_null
    //   124: astore 27
    //   126: aload 27
    //   128: astore 26
    //   130: iconst_m1
    //   131: istore 6
    //   133: invokestatic 158	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   136: ldc2_w 159
    //   139: ldiv
    //   140: lstore 19
    //   142: goto +6 -> 148
    //   145: lconst_0
    //   146: lstore 19
    //   148: lload 19
    //   150: lconst_0
    //   151: lcmp
    //   152: ifle +9 -> 161
    //   155: iconst_1
    //   156: istore 4
    //   158: goto +6 -> 164
    //   161: iconst_0
    //   162: istore 4
    //   164: iload 4
    //   166: istore 7
    //   168: iload 4
    //   170: ifeq +21 -> 191
    //   173: iload 4
    //   175: ifeq +13 -> 188
    //   178: iload_2
    //   179: ifeq +9 -> 188
    //   182: iconst_1
    //   183: istore 7
    //   185: goto +6 -> 191
    //   188: iconst_0
    //   189: istore 7
    //   191: aload_0
    //   192: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   195: invokeinterface 91 1 0
    //   200: istore 4
    //   202: iload 4
    //   204: istore 9
    //   206: iload 4
    //   208: iload_1
    //   209: if_icmple +26 -> 235
    //   212: getstatic 165	com/baidu/location/e/h:ay	I
    //   215: istore 4
    //   217: iload_1
    //   218: iload 4
    //   220: if_icmpge +12 -> 232
    //   223: iconst_1
    //   224: istore 14
    //   226: iload_1
    //   227: istore 9
    //   229: goto +9 -> 238
    //   232: iload_1
    //   233: istore 9
    //   235: iconst_0
    //   236: istore 14
    //   238: iconst_1
    //   239: istore 5
    //   241: iconst_0
    //   242: istore 8
    //   244: iconst_0
    //   245: istore 15
    //   247: aconst_null
    //   248: astore 25
    //   250: lconst_0
    //   251: lstore 17
    //   253: iconst_0
    //   254: istore_1
    //   255: iconst_0
    //   256: istore 10
    //   258: iconst_0
    //   259: istore 4
    //   261: lload 19
    //   263: lstore 23
    //   265: aload 26
    //   267: astore 28
    //   269: iload 15
    //   271: iload 9
    //   273: if_icmpge +1569 -> 1842
    //   276: aload_0
    //   277: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   280: iload 15
    //   282: invokeinterface 97 2 0
    //   287: ifnull +1518 -> 1805
    //   290: aload_0
    //   291: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   294: iload 15
    //   296: invokeinterface 97 2 0
    //   301: checkcast 99	android/net/wifi/ScanResult
    //   304: getfield 103	android/net/wifi/ScanResult:level	I
    //   307: istore 11
    //   309: iload 11
    //   311: ifne +6 -> 317
    //   314: goto +1491 -> 1805
    //   317: iload 7
    //   319: ifeq +71 -> 390
    //   322: aload_0
    //   323: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   326: iload 15
    //   328: invokeinterface 97 2 0
    //   333: checkcast 99	android/net/wifi/ScanResult
    //   336: astore 26
    //   338: lload 23
    //   340: aload 26
    //   342: getfield 168	android/net/wifi/ScanResult:timestamp	J
    //   345: lsub
    //   346: ldc2_w 169
    //   349: ldiv
    //   350: lstore 21
    //   352: goto +6 -> 358
    //   355: lconst_0
    //   356: lstore 21
    //   358: aload 30
    //   360: lload 21
    //   362: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: invokeinterface 180 2 0
    //   370: pop
    //   371: lload 17
    //   373: lstore 19
    //   375: lload 21
    //   377: lload 17
    //   379: lcmp
    //   380: ifle +14 -> 394
    //   383: lload 21
    //   385: lstore 19
    //   387: goto +7 -> 394
    //   390: lload 17
    //   392: lstore 19
    //   394: aload 25
    //   396: astore 26
    //   398: aload_0
    //   399: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   402: iload 15
    //   404: invokeinterface 97 2 0
    //   409: checkcast 99	android/net/wifi/ScanResult
    //   412: invokevirtual 183	android/net/wifi/ScanResult:is80211mcResponder	()Z
    //   415: ifeq +63 -> 478
    //   418: aload 25
    //   420: ifnonnull +19 -> 439
    //   423: new 123	java/lang/StringBuffer
    //   426: dup
    //   427: invokespecial 184	java/lang/StringBuffer:<init>	()V
    //   430: astore 26
    //   432: aload 26
    //   434: astore 25
    //   436: goto +3 -> 439
    //   439: aload 25
    //   441: iload 15
    //   443: invokevirtual 188	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   446: pop
    //   447: aload 25
    //   449: ldc 190
    //   451: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   454: pop
    //   455: aload 25
    //   457: astore 26
    //   459: goto +19 -> 478
    //   462: astore 26
    //   464: goto +5 -> 469
    //   467: astore 26
    //   469: aload 26
    //   471: invokevirtual 196	java/lang/Throwable:printStackTrace	()V
    //   474: aload 25
    //   476: astore 26
    //   478: iload 5
    //   480: ifeq +17 -> 497
    //   483: aload 29
    //   485: ldc 198
    //   487: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   490: pop
    //   491: iconst_0
    //   492: istore 5
    //   494: goto +11 -> 505
    //   497: aload 29
    //   499: ldc 190
    //   501: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   504: pop
    //   505: aload_0
    //   506: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   509: iload 15
    //   511: invokeinterface 97 2 0
    //   516: checkcast 99	android/net/wifi/ScanResult
    //   519: getfield 202	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   522: astore 25
    //   524: aload 25
    //   526: ifnull +1268 -> 1794
    //   529: aload 25
    //   531: ldc 146
    //   533: ldc 148
    //   535: invokevirtual 84	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   538: astore 25
    //   540: aload 29
    //   542: aload 25
    //   544: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   547: pop
    //   548: aload_0
    //   549: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   552: iload 15
    //   554: invokeinterface 97 2 0
    //   559: checkcast 99	android/net/wifi/ScanResult
    //   562: getfield 103	android/net/wifi/ScanResult:level	I
    //   565: istore 12
    //   567: iload 12
    //   569: istore 11
    //   571: iload 12
    //   573: ifge +8 -> 581
    //   576: iload 12
    //   578: ineg
    //   579: istore 11
    //   581: aload 29
    //   583: getstatic 208	java/util/Locale:CHINA	Ljava/util/Locale;
    //   586: ldc 210
    //   588: iconst_1
    //   589: anewarray 4	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: iload 11
    //   596: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aastore
    //   600: invokestatic 219	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   603: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   606: pop
    //   607: iload 10
    //   609: iconst_1
    //   610: iadd
    //   611: istore 10
    //   613: aload 27
    //   615: ifnull +47 -> 662
    //   618: aload 27
    //   620: aload 25
    //   622: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifeq +37 -> 662
    //   628: aload_0
    //   629: aload_0
    //   630: aload_0
    //   631: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   634: iload 15
    //   636: invokeinterface 97 2 0
    //   641: checkcast 99	android/net/wifi/ScanResult
    //   644: getfield 225	android/net/wifi/ScanResult:capabilities	Ljava/lang/String;
    //   647: invokespecial 227	com/baidu/location/c/h:a	(Ljava/lang/String;)Z
    //   650: putfield 229	com/baidu/location/c/h:e	Z
    //   653: iload 10
    //   655: istore_1
    //   656: iconst_1
    //   657: istore 11
    //   659: goto +6 -> 665
    //   662: iconst_0
    //   663: istore 11
    //   665: iload 11
    //   667: ifne +345 -> 1012
    //   670: iload 4
    //   672: istore 16
    //   674: iload 16
    //   676: ifne +157 -> 833
    //   679: aload 26
    //   681: astore 25
    //   683: lload 19
    //   685: lstore 17
    //   687: iload 5
    //   689: istore 11
    //   691: iload_1
    //   692: istore 12
    //   694: iload 10
    //   696: istore 13
    //   698: aload 31
    //   700: bipush 10
    //   702: invokevirtual 233	java/util/Random:nextInt	(I)I
    //   705: iconst_2
    //   706: if_icmpne +1110 -> 1816
    //   709: aload 26
    //   711: astore 25
    //   713: lload 19
    //   715: lstore 17
    //   717: iload 5
    //   719: istore 11
    //   721: iload_1
    //   722: istore 12
    //   724: iload 10
    //   726: istore 13
    //   728: aload_0
    //   729: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   732: iload 15
    //   734: invokeinterface 97 2 0
    //   739: checkcast 99	android/net/wifi/ScanResult
    //   742: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   745: ifnull +1071 -> 1816
    //   748: aload 26
    //   750: astore 25
    //   752: lload 19
    //   754: lstore 17
    //   756: iload 5
    //   758: istore 11
    //   760: iload_1
    //   761: istore 12
    //   763: iload 10
    //   765: istore 13
    //   767: aload_0
    //   768: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   771: iload 15
    //   773: invokeinterface 97 2 0
    //   778: checkcast 99	android/net/wifi/ScanResult
    //   781: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   784: invokevirtual 239	java/lang/String:length	()I
    //   787: bipush 30
    //   789: if_icmpge +1027 -> 1816
    //   792: aload 29
    //   794: aload_0
    //   795: aload_0
    //   796: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   799: iload 15
    //   801: invokeinterface 97 2 0
    //   806: checkcast 99	android/net/wifi/ScanResult
    //   809: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   812: invokespecial 241	com/baidu/location/c/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   815: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   818: pop
    //   819: iconst_1
    //   820: istore 4
    //   822: aload 26
    //   824: astore 25
    //   826: lload 19
    //   828: lstore 17
    //   830: goto +997 -> 1827
    //   833: aload 26
    //   835: astore 25
    //   837: lload 19
    //   839: lstore 17
    //   841: iload 5
    //   843: istore 11
    //   845: iload_1
    //   846: istore 12
    //   848: iload 10
    //   850: istore 13
    //   852: iload 16
    //   854: iconst_1
    //   855: if_icmpne +961 -> 1816
    //   858: aload 26
    //   860: astore 25
    //   862: lload 19
    //   864: lstore 17
    //   866: iload 5
    //   868: istore 11
    //   870: iload_1
    //   871: istore 12
    //   873: iload 10
    //   875: istore 13
    //   877: aload 31
    //   879: bipush 20
    //   881: invokevirtual 233	java/util/Random:nextInt	(I)I
    //   884: iconst_1
    //   885: if_icmpne +931 -> 1816
    //   888: aload 26
    //   890: astore 25
    //   892: lload 19
    //   894: lstore 17
    //   896: iload 5
    //   898: istore 11
    //   900: iload_1
    //   901: istore 12
    //   903: iload 10
    //   905: istore 13
    //   907: aload_0
    //   908: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   911: iload 15
    //   913: invokeinterface 97 2 0
    //   918: checkcast 99	android/net/wifi/ScanResult
    //   921: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   924: ifnull +892 -> 1816
    //   927: aload 26
    //   929: astore 25
    //   931: lload 19
    //   933: lstore 17
    //   935: iload 5
    //   937: istore 11
    //   939: iload_1
    //   940: istore 12
    //   942: iload 10
    //   944: istore 13
    //   946: aload_0
    //   947: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   950: iload 15
    //   952: invokeinterface 97 2 0
    //   957: checkcast 99	android/net/wifi/ScanResult
    //   960: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   963: invokevirtual 239	java/lang/String:length	()I
    //   966: bipush 30
    //   968: if_icmpge +848 -> 1816
    //   971: aload 29
    //   973: aload_0
    //   974: aload_0
    //   975: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   978: iload 15
    //   980: invokeinterface 97 2 0
    //   985: checkcast 99	android/net/wifi/ScanResult
    //   988: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   991: invokespecial 241	com/baidu/location/c/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   994: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   997: pop
    //   998: iconst_2
    //   999: istore 4
    //   1001: aload 26
    //   1003: astore 25
    //   1005: lload 19
    //   1007: lstore 17
    //   1009: goto +818 -> 1827
    //   1012: aload 29
    //   1014: aload_0
    //   1015: aload_0
    //   1016: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1019: iload 15
    //   1021: invokeinterface 97 2 0
    //   1026: checkcast 99	android/net/wifi/ScanResult
    //   1029: getfield 236	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   1032: invokespecial 241	com/baidu/location/c/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1038: pop
    //   1039: aload 26
    //   1041: astore 25
    //   1043: lload 19
    //   1045: lstore 17
    //   1047: iload 5
    //   1049: istore 11
    //   1051: iload_1
    //   1052: istore 12
    //   1054: iload 10
    //   1056: istore 13
    //   1058: goto +758 -> 1816
    //   1061: iload 7
    //   1063: aload_0
    //   1064: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1067: invokeinterface 91 1 0
    //   1072: if_icmpge +194 -> 1266
    //   1075: iload 8
    //   1077: iconst_1
    //   1078: iadd
    //   1079: istore 10
    //   1081: iload 4
    //   1083: istore 9
    //   1085: aload_0
    //   1086: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1089: iload 7
    //   1091: invokeinterface 97 2 0
    //   1096: ifnull +761 -> 1857
    //   1099: aload_0
    //   1100: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1103: iload 7
    //   1105: invokeinterface 97 2 0
    //   1110: checkcast 99	android/net/wifi/ScanResult
    //   1113: getfield 103	android/net/wifi/ScanResult:level	I
    //   1116: ifne +10 -> 1126
    //   1119: iload 4
    //   1121: istore 9
    //   1123: goto +734 -> 1857
    //   1126: iload 4
    //   1128: ifeq +17 -> 1145
    //   1131: aload 29
    //   1133: ldc 243
    //   1135: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1138: pop
    //   1139: iconst_0
    //   1140: istore 4
    //   1142: goto +11 -> 1153
    //   1145: aload 29
    //   1147: ldc 190
    //   1149: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1152: pop
    //   1153: aload_0
    //   1154: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1157: iload 7
    //   1159: invokeinterface 97 2 0
    //   1164: checkcast 99	android/net/wifi/ScanResult
    //   1167: getfield 202	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   1170: astore 26
    //   1172: aload 26
    //   1174: ifnull +77 -> 1251
    //   1177: aload 29
    //   1179: aload 26
    //   1181: ldc 146
    //   1183: ldc 148
    //   1185: invokevirtual 84	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1188: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1191: pop
    //   1192: aload_0
    //   1193: getfield 28	com/baidu/location/c/h:a	Ljava/util/List;
    //   1196: iload 7
    //   1198: invokeinterface 97 2 0
    //   1203: checkcast 99	android/net/wifi/ScanResult
    //   1206: getfield 103	android/net/wifi/ScanResult:level	I
    //   1209: istore 9
    //   1211: iload 9
    //   1213: istore 8
    //   1215: iload 9
    //   1217: ifge +8 -> 1225
    //   1220: iload 9
    //   1222: ineg
    //   1223: istore 8
    //   1225: aload 29
    //   1227: getstatic 208	java/util/Locale:CHINA	Ljava/util/Locale;
    //   1230: ldc 210
    //   1232: iconst_1
    //   1233: anewarray 4	java/lang/Object
    //   1236: dup
    //   1237: iconst_0
    //   1238: iload 8
    //   1240: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1243: aastore
    //   1244: invokestatic 219	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1247: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1250: pop
    //   1251: iload 4
    //   1253: istore 9
    //   1255: iload 10
    //   1257: getstatic 165	com/baidu/location/e/h:ay	I
    //   1260: if_icmplt +597 -> 1857
    //   1263: goto +3 -> 1266
    //   1266: iload 5
    //   1268: ifne +457 -> 1725
    //   1271: new 245	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1278: astore 26
    //   1280: aload 26
    //   1282: ldc 248
    //   1284: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload 26
    //   1290: iload_1
    //   1291: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: aload 29
    //   1297: aload 26
    //   1299: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1305: pop
    //   1306: aload 25
    //   1308: ifnull +23 -> 1331
    //   1311: aload 29
    //   1313: ldc_w 259
    //   1316: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1319: pop
    //   1320: aload 29
    //   1322: aload 25
    //   1324: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1327: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1330: pop
    //   1331: aload 27
    //   1333: ifnull +46 -> 1379
    //   1336: iload 6
    //   1338: iconst_m1
    //   1339: if_icmpeq +40 -> 1379
    //   1342: new 245	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1349: astore 25
    //   1351: aload 25
    //   1353: ldc_w 262
    //   1356: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 25
    //   1362: iload 6
    //   1364: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: pop
    //   1368: aload 29
    //   1370: aload 25
    //   1372: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1375: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1378: pop
    //   1379: lload 17
    //   1381: ldc2_w 263
    //   1384: lcmp
    //   1385: ifle +489 -> 1874
    //   1388: aload 30
    //   1390: invokeinterface 91 1 0
    //   1395: ifle +479 -> 1874
    //   1398: aload 30
    //   1400: iconst_0
    //   1401: invokeinterface 97 2 0
    //   1406: checkcast 172	java/lang/Long
    //   1409: invokevirtual 267	java/lang/Long:longValue	()J
    //   1412: lconst_0
    //   1413: lcmp
    //   1414: ifle +460 -> 1874
    //   1417: new 123	java/lang/StringBuffer
    //   1420: dup
    //   1421: sipush 128
    //   1424: invokespecial 126	java/lang/StringBuffer:<init>	(I)V
    //   1427: astore 25
    //   1429: aload 25
    //   1431: ldc_w 269
    //   1434: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1437: pop
    //   1438: aload 30
    //   1440: iconst_0
    //   1441: invokeinterface 97 2 0
    //   1446: checkcast 172	java/lang/Long
    //   1449: astore 26
    //   1451: aload 30
    //   1453: invokeinterface 273 1 0
    //   1458: astore 27
    //   1460: iconst_1
    //   1461: istore 4
    //   1463: aload 27
    //   1465: invokeinterface 278 1 0
    //   1470: ifeq +116 -> 1586
    //   1473: aload 27
    //   1475: invokeinterface 282 1 0
    //   1480: checkcast 172	java/lang/Long
    //   1483: astore 30
    //   1485: iload 4
    //   1487: ifeq +20 -> 1507
    //   1490: aload 25
    //   1492: aload 30
    //   1494: invokevirtual 267	java/lang/Long:longValue	()J
    //   1497: invokevirtual 285	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   1500: pop
    //   1501: iconst_0
    //   1502: istore 5
    //   1504: goto +67 -> 1571
    //   1507: aload 30
    //   1509: invokevirtual 267	java/lang/Long:longValue	()J
    //   1512: aload 26
    //   1514: invokevirtual 267	java/lang/Long:longValue	()J
    //   1517: lsub
    //   1518: lstore 17
    //   1520: iload 4
    //   1522: istore 5
    //   1524: lload 17
    //   1526: lconst_0
    //   1527: lcmp
    //   1528: ifeq +43 -> 1571
    //   1531: new 245	java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1538: astore 30
    //   1540: aload 30
    //   1542: ldc 148
    //   1544: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload 30
    //   1550: lload 17
    //   1552: invokevirtual 288	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 25
    //   1558: aload 30
    //   1560: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1563: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1566: pop
    //   1567: iload 4
    //   1569: istore 5
    //   1571: aload 25
    //   1573: ldc 190
    //   1575: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1578: pop
    //   1579: iload 5
    //   1581: istore 4
    //   1583: goto -120 -> 1463
    //   1586: aload 29
    //   1588: aload 25
    //   1590: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1593: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1596: pop
    //   1597: goto +3 -> 1600
    //   1600: aload 29
    //   1602: ldc_w 290
    //   1605: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1608: pop
    //   1609: aload 29
    //   1611: aload_0
    //   1612: getfield 26	com/baidu/location/c/h:b	J
    //   1615: invokevirtual 285	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   1618: pop
    //   1619: aload 29
    //   1621: ldc_w 292
    //   1624: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1627: pop
    //   1628: aload 29
    //   1630: aload_0
    //   1631: getfield 22	com/baidu/location/c/h:c	J
    //   1634: invokevirtual 285	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   1637: pop
    //   1638: aload 29
    //   1640: ldc_w 294
    //   1643: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1646: pop
    //   1647: aload 29
    //   1649: getstatic 296	com/baidu/location/c/i:a	J
    //   1652: invokevirtual 285	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   1655: pop
    //   1656: iload_1
    //   1657: ifle +36 -> 1693
    //   1660: aload_0
    //   1661: iconst_1
    //   1662: putfield 24	com/baidu/location/c/h:d	Z
    //   1665: aload 29
    //   1667: ldc_w 298
    //   1670: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1673: pop
    //   1674: aload_0
    //   1675: getfield 229	com/baidu/location/c/h:e	Z
    //   1678: ifeq +199 -> 1877
    //   1681: iconst_1
    //   1682: istore_1
    //   1683: goto +3 -> 1686
    //   1686: aload 29
    //   1688: iload_1
    //   1689: invokevirtual 188	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   1692: pop
    //   1693: aload 28
    //   1695: ifnull +20 -> 1715
    //   1698: aload 29
    //   1700: ldc_w 300
    //   1703: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1706: pop
    //   1707: aload 29
    //   1709: aload 28
    //   1711: invokevirtual 193	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1714: pop
    //   1715: aload 29
    //   1717: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1720: astore 25
    //   1722: aload 25
    //   1724: areturn
    //   1725: aconst_null
    //   1726: areturn
    //   1727: aconst_null
    //   1728: areturn
    //   1729: aconst_null
    //   1730: areturn
    //   1731: aconst_null
    //   1732: areturn
    //   1733: aconst_null
    //   1734: areturn
    //   1735: astore 25
    //   1737: goto -4 -> 1733
    //   1740: astore 25
    //   1742: goto -11 -> 1731
    //   1745: astore 25
    //   1747: goto -1602 -> 145
    //   1750: astore 25
    //   1752: goto -23 -> 1729
    //   1755: astore 25
    //   1757: goto -30 -> 1727
    //   1760: astore 26
    //   1762: goto -1407 -> 355
    //   1765: astore 26
    //   1767: goto -1412 -> 355
    //   1770: astore 25
    //   1772: aload 26
    //   1774: astore 25
    //   1776: lload 19
    //   1778: lstore 17
    //   1780: iload 5
    //   1782: istore 11
    //   1784: iload_1
    //   1785: istore 12
    //   1787: iload 10
    //   1789: istore 13
    //   1791: goto +25 -> 1816
    //   1794: aload 26
    //   1796: astore 25
    //   1798: lload 19
    //   1800: lstore 17
    //   1802: goto +25 -> 1827
    //   1805: iload 10
    //   1807: istore 13
    //   1809: iload_1
    //   1810: istore 12
    //   1812: iload 5
    //   1814: istore 11
    //   1816: iload 13
    //   1818: istore 10
    //   1820: iload 12
    //   1822: istore_1
    //   1823: iload 11
    //   1825: istore 5
    //   1827: iload 15
    //   1829: iconst_1
    //   1830: iadd
    //   1831: istore 15
    //   1833: iload 8
    //   1835: iconst_1
    //   1836: iadd
    //   1837: istore 8
    //   1839: goto -1570 -> 269
    //   1842: iload 14
    //   1844: ifeq -578 -> 1266
    //   1847: iload 9
    //   1849: istore 7
    //   1851: iconst_1
    //   1852: istore 4
    //   1854: goto -793 -> 1061
    //   1857: iload 7
    //   1859: iconst_1
    //   1860: iadd
    //   1861: istore 7
    //   1863: iload 10
    //   1865: istore 8
    //   1867: iload 9
    //   1869: istore 4
    //   1871: goto -810 -> 1061
    //   1874: goto -274 -> 1600
    //   1877: iconst_0
    //   1878: istore_1
    //   1879: goto -193 -> 1686
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1882	0	this	h
    //   0	1882	1	paramInt	int
    //   0	1882	2	paramBoolean1	boolean
    //   0	1882	3	paramBoolean2	boolean
    //   80	1790	4	i	int
    //   239	1587	5	j	int
    //   92	1271	6	k	int
    //   166	1696	7	m	int
    //   242	1624	8	n	int
    //   204	1664	9	i1	int
    //   256	1608	10	i2	int
    //   307	1517	11	i3	int
    //   565	1256	12	i4	int
    //   696	1121	13	i5	int
    //   224	1619	14	i6	int
    //   245	1587	15	i7	int
    //   672	184	16	i8	int
    //   251	1550	17	l1	long
    //   140	1659	19	l2	long
    //   350	34	21	l3	long
    //   263	76	23	l4	long
    //   73	1650	25	localObject1	Object
    //   1735	1	25	localError1	Error
    //   1740	1	25	localException1	Exception
    //   1745	1	25	localError2	Error
    //   1750	1	25	localError3	Error
    //   1755	1	25	localException2	Exception
    //   1770	1	25	localException3	Exception
    //   1774	23	25	localException4	Exception
    //   46	412	26	localObject2	Object
    //   462	1	26	localObject3	Object
    //   467	3	26	localObject4	Object
    //   476	1037	26	localObject5	Object
    //   1760	1	26	localException5	Exception
    //   1765	30	26	localException6	Exception
    //   96	1378	27	localObject6	Object
    //   88	1622	28	localObject7	Object
    //   29	1687	29	localStringBuffer	StringBuffer
    //   38	1521	30	localObject8	Object
    //   17	861	31	localRandom	java.util.Random
    // Exception table:
    //   from	to	target	type
    //   439	455	462	finally
    //   398	418	467	finally
    //   423	432	467	finally
    //   10	48	1735	java/lang/Error
    //   53	90	1735	java/lang/Error
    //   10	48	1740	java/lang/Exception
    //   53	90	1740	java/lang/Exception
    //   133	142	1740	java/lang/Exception
    //   133	142	1745	java/lang/Error
    //   191	202	1750	java/lang/Error
    //   212	217	1750	java/lang/Error
    //   276	309	1750	java/lang/Error
    //   322	338	1750	java/lang/Error
    //   338	352	1750	java/lang/Error
    //   358	371	1750	java/lang/Error
    //   469	474	1750	java/lang/Error
    //   483	491	1750	java/lang/Error
    //   497	505	1750	java/lang/Error
    //   505	524	1750	java/lang/Error
    //   529	567	1750	java/lang/Error
    //   581	607	1750	java/lang/Error
    //   618	653	1750	java/lang/Error
    //   698	709	1750	java/lang/Error
    //   728	748	1750	java/lang/Error
    //   767	819	1750	java/lang/Error
    //   877	888	1750	java/lang/Error
    //   907	927	1750	java/lang/Error
    //   946	998	1750	java/lang/Error
    //   1012	1039	1750	java/lang/Error
    //   1061	1075	1750	java/lang/Error
    //   1085	1119	1750	java/lang/Error
    //   1131	1139	1750	java/lang/Error
    //   1145	1153	1750	java/lang/Error
    //   1153	1172	1750	java/lang/Error
    //   1177	1211	1750	java/lang/Error
    //   1225	1251	1750	java/lang/Error
    //   1255	1263	1750	java/lang/Error
    //   1271	1306	1750	java/lang/Error
    //   1311	1331	1750	java/lang/Error
    //   1342	1379	1750	java/lang/Error
    //   1388	1460	1750	java/lang/Error
    //   1463	1485	1750	java/lang/Error
    //   1490	1501	1750	java/lang/Error
    //   1507	1520	1750	java/lang/Error
    //   1531	1567	1750	java/lang/Error
    //   1571	1579	1750	java/lang/Error
    //   1586	1597	1750	java/lang/Error
    //   1600	1656	1750	java/lang/Error
    //   1660	1681	1750	java/lang/Error
    //   1686	1693	1750	java/lang/Error
    //   1698	1715	1750	java/lang/Error
    //   1715	1722	1750	java/lang/Error
    //   191	202	1755	java/lang/Exception
    //   212	217	1755	java/lang/Exception
    //   276	309	1755	java/lang/Exception
    //   358	371	1755	java/lang/Exception
    //   469	474	1755	java/lang/Exception
    //   483	491	1755	java/lang/Exception
    //   497	505	1755	java/lang/Exception
    //   505	524	1755	java/lang/Exception
    //   529	567	1755	java/lang/Exception
    //   581	607	1755	java/lang/Exception
    //   618	653	1755	java/lang/Exception
    //   1012	1039	1755	java/lang/Exception
    //   1061	1075	1755	java/lang/Exception
    //   1085	1119	1755	java/lang/Exception
    //   1131	1139	1755	java/lang/Exception
    //   1145	1153	1755	java/lang/Exception
    //   1153	1172	1755	java/lang/Exception
    //   1177	1211	1755	java/lang/Exception
    //   1225	1251	1755	java/lang/Exception
    //   1255	1263	1755	java/lang/Exception
    //   1271	1306	1755	java/lang/Exception
    //   1311	1331	1755	java/lang/Exception
    //   1342	1379	1755	java/lang/Exception
    //   1388	1460	1755	java/lang/Exception
    //   1463	1485	1755	java/lang/Exception
    //   1490	1501	1755	java/lang/Exception
    //   1507	1520	1755	java/lang/Exception
    //   1531	1567	1755	java/lang/Exception
    //   1571	1579	1755	java/lang/Exception
    //   1586	1597	1755	java/lang/Exception
    //   1600	1656	1755	java/lang/Exception
    //   1660	1681	1755	java/lang/Exception
    //   1686	1693	1755	java/lang/Exception
    //   1698	1715	1755	java/lang/Exception
    //   1715	1722	1755	java/lang/Exception
    //   322	338	1760	java/lang/Exception
    //   338	352	1765	java/lang/Exception
    //   698	709	1770	java/lang/Exception
    //   728	748	1770	java/lang/Exception
    //   767	819	1770	java/lang/Exception
    //   877	888	1770	java/lang/Exception
    //   907	927	1770	java/lang/Exception
    //   946	998	1770	java/lang/Exception
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      l2 = SystemClock.elapsedRealtimeNanos() / 1000L;
    }
    catch (Error|Exception localError)
    {
      long l2;
      label12:
      boolean bool;
      int i;
      List localList;
      int k;
      int j;
      long l4;
      long l3;
      label198:
      break label12;
    }
    l2 = 0L;
    bool = true;
    if (l2 > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    localList = this.a;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return false;
      }
      k = this.a.size();
      j = k;
      if (k > 16) {
        j = 16;
      }
      l4 = 0L;
      l3 = l4;
      k = 0;
      while (k < j)
      {
        long l5 = l4;
        long l6 = l3;
        if (this.a.get(k) != null) {
          if (((ScanResult)this.a.get(k)).level == 0)
          {
            l5 = l4;
            l6 = l3;
          }
          else
          {
            l5 = l4;
            l6 = l3;
            if (i == 0) {}
          }
        }
        try
        {
          l1 = (l2 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
        }
        catch (Exception|Error localException)
        {
          long l1;
          break label198;
        }
        l1 = 0L;
        l4 += l1;
        l5 = l4;
        l6 = l3;
        if (l1 > l3)
        {
          l6 = l1;
          l5 = l4;
        }
        k += 1;
        l4 = l5;
        l3 = l6;
      }
      l1 = l4 / j;
      if (l3 * 1000L <= paramLong)
      {
        if (l1 * 1000L > paramLong) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    else
    {
      return false;
    }
  }
  
  public boolean a(h paramh)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramh != null) && (paramh.a != null))
    {
      if (((List)localObject).size() < paramh.a.size()) {
        localObject = this.a;
      } else {
        localObject = paramh.a;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        if (this.a.get(i) != null)
        {
          localObject = ((ScanResult)this.a.get(i)).BSSID;
          String str = ((ScanResult)paramh.a.get(i)).BSSID;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(str))) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public String b()
  {
    try
    {
      String str = a(com.baidu.location.e.h.N, true, true);
      return str;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  public String b(int paramInt)
  {
    if (paramInt != 0)
    {
      int i = a();
      int n = 1;
      if (i >= 1)
      {
        StringBuffer localStringBuffer = new StringBuffer(256);
        i = this.a.size();
        int j = com.baidu.location.e.h.N;
        int k = i;
        if (i > j) {
          k = j;
        }
        int m = 0;
        i = 0;
        while (m < k)
        {
          if (this.a.get(m) != null)
          {
            j = i;
            if ((n & paramInt) != 0)
            {
              j = i;
              if (((ScanResult)this.a.get(m)).BSSID != null)
              {
                String str;
                if (i == 0) {
                  str = "&ssid=";
                } else {
                  str = "|";
                }
                localStringBuffer.append(str);
                localStringBuffer.append(((ScanResult)this.a.get(m)).BSSID.replace(":", ""));
                localStringBuffer.append(";");
                localStringBuffer.append(b(((ScanResult)this.a.get(m)).SSID));
                j = i + 1;
              }
            }
            n <<= 1;
            i = j;
          }
          m += 1;
        }
        return localStringBuffer.toString();
      }
    }
    return null;
  }
  
  public boolean b(h paramh)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramh != null) && (paramh.a != null))
    {
      if (((List)localObject).size() < paramh.a.size()) {
        localObject = this.a;
      } else {
        localObject = paramh.a;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        if (this.a.get(i) != null)
        {
          localObject = ((ScanResult)this.a.get(i)).BSSID;
          int k = ((ScanResult)this.a.get(i)).level;
          String str = ((ScanResult)paramh.a.get(i)).BSSID;
          int m = ((ScanResult)paramh.a.get(i)).level;
          if (((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(str))) || (k != m)) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public String c()
  {
    try
    {
      String str = a(com.baidu.location.e.h.N, true, false);
      return str;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  public boolean c(h paramh)
  {
    return i.a(paramh, this);
  }
  
  public String d()
  {
    try
    {
      String str = a(15);
      return str;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public boolean e()
  {
    return a(com.baidu.location.e.h.af);
  }
  
  @SuppressLint({"NewApi"})
  public long f()
  {
    List localList = this.a;
    long l1 = 0L;
    long l2;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return 0L;
      }
      l2 = 2147483647L;
    }
    try
    {
      l3 = SystemClock.elapsedRealtimeNanos() / 1000L;
    }
    catch (Error|Exception localError)
    {
      long l3;
      label43:
      int m;
      int i;
      int n;
      int k;
      int j;
      long l4;
      break label43;
    }
    l3 = 0L;
    m = 0;
    if (l3 > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0L;
    }
    n = this.a.size();
    l1 = l2;
    k = m;
    j = n;
    if (n > 16)
    {
      j = 16;
      k = m;
    }
    for (l1 = l2; k < j; l1 = l4)
    {
      l4 = l1;
      if (this.a.get(k) != null) {
        if (((ScanResult)this.a.get(k)).level == 0)
        {
          l4 = l1;
        }
        else
        {
          l4 = l1;
          if (i == 0) {}
        }
      }
      try
      {
        l2 = (l3 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
      }
      catch (Exception|Error localException)
      {
        label191:
        break label191;
      }
      l2 = 0L;
      l4 = l1;
      if (l2 < l1) {
        l4 = l2;
      }
      k += 1;
    }
    if (i == 0) {
      l1 = 0L;
    }
    if (l1 < 0L) {
      return 0L;
    }
    return l1;
  }
  
  @SuppressLint({"NewApi"})
  public long g()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0)) {}
    try
    {
      l3 = SystemClock.elapsedRealtimeNanos() / 1000L;
    }
    catch (Error|Exception localError)
    {
      long l3;
      label36:
      int k;
      int i;
      int m;
      int j;
      long l5;
      long l1;
      long l4;
      long l6;
      break label36;
    }
    l3 = 0L;
    k = 0;
    if (l3 > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0L;
    }
    m = this.a.size();
    j = m;
    if (m > 16) {
      j = 16;
    }
    l5 = 0L;
    l1 = l5;
    for (l4 = l1; k < j; l4 = l6)
    {
      long l7 = l5;
      long l8 = l1;
      l6 = l4;
      if (this.a.get(k) != null) {
        if (((ScanResult)this.a.get(k)).level == 0)
        {
          l7 = l5;
          l8 = l1;
          l6 = l4;
        }
        else
        {
          l7 = l5;
          l8 = l1;
          l6 = l4;
          if (i == 0) {}
        }
      }
      try
      {
        l2 = (l3 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
      }
      catch (Exception|Error localException)
      {
        long l2;
        label204:
        break label204;
      }
      l2 = 0L;
      l4 += l2;
      l5 += 1L;
      l7 = l5;
      l8 = l1;
      l6 = l4;
      if (l2 > l1)
      {
        l6 = l4;
        l8 = l2;
        l7 = l5;
      }
      k += 1;
      l5 = l7;
      l1 = l8;
    }
    l2 = l1;
    if (l5 > 1L) {
      l2 = (l4 - l1) / (l5 - 1L);
    }
    return l2;
    return 0L;
  }
  
  public int h()
  {
    int i = 0;
    while (i < a())
    {
      if (this.a.get(i) != null)
      {
        int j = -((ScanResult)this.a.get(i)).level;
        if (j > 0) {
          return j;
        }
      }
      i += 1;
    }
    return 0;
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public boolean j()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean k()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean l()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.b < 5000L);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.h
 * JD-Core Version:    0.7.0.1
 */