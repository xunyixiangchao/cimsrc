package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class g
{
  private Context a;
  private String b = null;
  private HashMap c = null;
  private String d = null;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a(Context paramContext)
  {
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    try
    {
      localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject1 == null) {
        return null;
      }
      int i = Build.VERSION.SDK_INT;
      paramContext = "wifi";
      Object localObject2;
      boolean bool1;
      if (i >= 29)
      {
        localObject2 = ((ConnectivityManager)localObject1).getNetworkCapabilities(((ConnectivityManager)localObject1).getActiveNetwork());
        localObject1 = paramContext;
        if (localObject2 == null) {
          break label297;
        }
        bool1 = ((NetworkCapabilities)localObject2).hasTransport(1);
        bool2 = ((NetworkCapabilities)localObject2).hasTransport(0);
        bool3 = ((NetworkCapabilities)localObject2).hasTransport(3);
        bool4 = ((NetworkCapabilities)localObject2).hasTransport(6);
        bool5 = ((NetworkCapabilities)localObject2).hasTransport(4);
        bool6 = ((NetworkCapabilities)localObject2).hasTransport(5);
        if (bool1) {
          return "WIFI";
        }
      }
      else
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject1 != null)
        {
          if (!((NetworkInfo)localObject1).isAvailable()) {
            return null;
          }
          localObject2 = ((NetworkInfo)localObject1).getExtraInfo();
          localObject1 = paramContext;
          if (localObject2 != null) {
            if ((!((String)localObject2).trim().toLowerCase().equals("cmwap")) && (!((String)localObject2).trim().toLowerCase().equals("uniwap")) && (!((String)localObject2).trim().toLowerCase().equals("3gwap")))
            {
              localObject1 = paramContext;
              if (!((String)localObject2).trim().toLowerCase().equals("ctwap")) {}
            }
            else
            {
              bool1 = ((String)localObject2).trim().toLowerCase().equals("ctwap");
              if (bool1) {
                return "ctwap";
              }
              localObject1 = "cmwap";
            }
          }
          return localObject1;
        }
        return null;
      }
    }
    catch (Exception paramContext)
    {
      if (a.a) {
        paramContext.printStackTrace();
      }
      return null;
    }
    if (bool2) {
      return "CELLULAR";
    }
    if (bool3) {
      return "ETHERNET";
    }
    if (bool4) {
      return "LoWPAN";
    }
    if (bool5) {
      return "VPN";
    }
    Object localObject1 = paramContext;
    if (bool6) {
      localObject1 = "WifiAware";
    }
    label297:
    return localObject1;
  }
  
  /* Error */
  private void a(HttpsURLConnection paramHttpsURLConnection)
  {
    // Byte code:
    //   0: new 121	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: ldc 124
    //   13: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 8
    //   19: aload_0
    //   20: getfield 18	com/baidu/lbsapi/auth/g:b	Ljava/lang/String;
    //   23: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 8
    //   29: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 20	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   39: ifnonnull +13 -> 52
    //   42: aload_0
    //   43: ldc 136
    //   45: invokestatic 141	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   48: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   51: return
    //   52: iconst_1
    //   53: istore 7
    //   55: aconst_null
    //   56: astore 11
    //   58: aconst_null
    //   59: astore 13
    //   61: aconst_null
    //   62: astore 8
    //   64: aconst_null
    //   65: astore 12
    //   67: aconst_null
    //   68: astore 14
    //   70: aconst_null
    //   71: astore 15
    //   73: aconst_null
    //   74: astore 10
    //   76: iconst_0
    //   77: istore 6
    //   79: aload_1
    //   80: invokevirtual 147	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   83: astore 9
    //   85: new 149	java/io/BufferedWriter
    //   88: dup
    //   89: new 151	java/io/OutputStreamWriter
    //   92: dup
    //   93: aload 9
    //   95: ldc 153
    //   97: invokespecial 156	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   100: invokespecial 159	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_0
    //   108: getfield 20	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   111: invokestatic 162	com/baidu/lbsapi/auth/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   114: invokevirtual 165	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield 20	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   121: invokestatic 162	com/baidu/lbsapi/auth/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   124: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   127: aload 8
    //   129: invokevirtual 168	java/io/BufferedWriter:flush	()V
    //   132: aload 8
    //   134: invokevirtual 171	java/io/BufferedWriter:close	()V
    //   137: aload_1
    //   138: invokevirtual 174	javax/net/ssl/HttpsURLConnection:connect	()V
    //   141: aload_1
    //   142: invokevirtual 178	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   145: astore 12
    //   147: aload_1
    //   148: invokevirtual 182	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   151: istore_2
    //   152: aload 10
    //   154: astore 8
    //   156: sipush 200
    //   159: iload_2
    //   160: if_icmpne +90 -> 250
    //   163: new 184	java/io/BufferedReader
    //   166: dup
    //   167: new 186	java/io/InputStreamReader
    //   170: dup
    //   171: aload 12
    //   173: ldc 153
    //   175: invokespecial 189	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   178: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   181: astore 8
    //   183: new 194	java/lang/StringBuffer
    //   186: dup
    //   187: invokespecial 195	java/lang/StringBuffer:<init>	()V
    //   190: astore 10
    //   192: aload 8
    //   194: invokevirtual 198	java/io/BufferedReader:read	()I
    //   197: istore_3
    //   198: iload_3
    //   199: iconst_m1
    //   200: if_icmpeq +14 -> 214
    //   203: aload 10
    //   205: iload_3
    //   206: i2c
    //   207: invokevirtual 201	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   210: pop
    //   211: goto -19 -> 192
    //   214: aload_0
    //   215: aload 10
    //   217: invokevirtual 202	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   220: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   223: goto +27 -> 250
    //   226: astore 10
    //   228: goto +83 -> 311
    //   231: astore 11
    //   233: aload 8
    //   235: astore 10
    //   237: goto +92 -> 329
    //   240: astore 10
    //   242: goto +66 -> 308
    //   245: astore 11
    //   247: goto +79 -> 326
    //   250: aload 12
    //   252: ifnull +34 -> 286
    //   255: aload 8
    //   257: ifnull +29 -> 286
    //   260: iload_2
    //   261: istore_3
    //   262: iload_2
    //   263: istore 4
    //   265: iload_2
    //   266: istore 5
    //   268: aload 8
    //   270: invokevirtual 203	java/io/BufferedReader:close	()V
    //   273: iload_2
    //   274: istore_3
    //   275: iload_2
    //   276: istore 4
    //   278: iload_2
    //   279: istore 5
    //   281: aload 12
    //   283: invokevirtual 206	java/io/InputStream:close	()V
    //   286: iload_2
    //   287: istore_3
    //   288: iload_2
    //   289: istore 4
    //   291: iload_2
    //   292: istore 5
    //   294: aload_1
    //   295: invokevirtual 209	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   298: iload 7
    //   300: istore_3
    //   301: goto +203 -> 504
    //   304: astore 10
    //   306: iconst_m1
    //   307: istore_2
    //   308: aconst_null
    //   309: astore 8
    //   311: aload 12
    //   313: astore 11
    //   315: aload 8
    //   317: astore 12
    //   319: goto +229 -> 548
    //   322: astore 11
    //   324: iconst_m1
    //   325: istore_2
    //   326: aconst_null
    //   327: astore 10
    //   329: aload 12
    //   331: astore 8
    //   333: goto +32 -> 365
    //   336: astore 10
    //   338: iconst_m1
    //   339: istore_2
    //   340: aconst_null
    //   341: astore 12
    //   343: aload 13
    //   345: astore 11
    //   347: goto +201 -> 548
    //   350: astore 12
    //   352: iconst_m1
    //   353: istore_2
    //   354: aconst_null
    //   355: astore 10
    //   357: aload 11
    //   359: astore 8
    //   361: aload 12
    //   363: astore 11
    //   365: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   368: ifeq +44 -> 412
    //   371: aload 11
    //   373: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   376: new 121	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   383: astore 12
    //   385: aload 12
    //   387: ldc 212
    //   389: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 12
    //   395: aload 11
    //   397: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 12
    //   406: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   412: new 121	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   419: astore 12
    //   421: aload 12
    //   423: ldc 217
    //   425: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 12
    //   431: aload 11
    //   433: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   436: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_0
    //   441: bipush 245
    //   443: aload 12
    //   445: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   451: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   454: aload 8
    //   456: ifnull +34 -> 490
    //   459: aload 10
    //   461: ifnull +29 -> 490
    //   464: iload_2
    //   465: istore_3
    //   466: iload_2
    //   467: istore 4
    //   469: iload_2
    //   470: istore 5
    //   472: aload 10
    //   474: invokevirtual 203	java/io/BufferedReader:close	()V
    //   477: iload_2
    //   478: istore_3
    //   479: iload_2
    //   480: istore 4
    //   482: iload_2
    //   483: istore 5
    //   485: aload 8
    //   487: invokevirtual 206	java/io/InputStream:close	()V
    //   490: iload_2
    //   491: istore_3
    //   492: iload_2
    //   493: istore 4
    //   495: iload_2
    //   496: istore 5
    //   498: aload_1
    //   499: invokevirtual 209	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   502: iconst_0
    //   503: istore_3
    //   504: aload 9
    //   506: ifnull +22 -> 528
    //   509: aload 9
    //   511: invokevirtual 223	java/io/OutputStream:close	()V
    //   514: goto +14 -> 528
    //   517: astore_1
    //   518: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   521: ifeq +7 -> 528
    //   524: aload_1
    //   525: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   528: iload_3
    //   529: istore 4
    //   531: goto +516 -> 1047
    //   534: astore 13
    //   536: aload 10
    //   538: astore 12
    //   540: aload 8
    //   542: astore 11
    //   544: aload 13
    //   546: astore 10
    //   548: aload 11
    //   550: ifnull +34 -> 584
    //   553: aload 12
    //   555: ifnull +29 -> 584
    //   558: iload_2
    //   559: istore_3
    //   560: iload_2
    //   561: istore 4
    //   563: iload_2
    //   564: istore 5
    //   566: aload 12
    //   568: invokevirtual 203	java/io/BufferedReader:close	()V
    //   571: iload_2
    //   572: istore_3
    //   573: iload_2
    //   574: istore 4
    //   576: iload_2
    //   577: istore 5
    //   579: aload 11
    //   581: invokevirtual 206	java/io/InputStream:close	()V
    //   584: iload_2
    //   585: istore_3
    //   586: iload_2
    //   587: istore 4
    //   589: iload_2
    //   590: istore 5
    //   592: aload_1
    //   593: invokevirtual 209	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   596: iload_2
    //   597: istore_3
    //   598: iload_2
    //   599: istore 4
    //   601: iload_2
    //   602: istore 5
    //   604: aload 10
    //   606: athrow
    //   607: astore 8
    //   609: goto +31 -> 640
    //   612: astore 8
    //   614: iload 4
    //   616: istore_3
    //   617: goto +37 -> 654
    //   620: astore 8
    //   622: iload 5
    //   624: istore_3
    //   625: goto +43 -> 668
    //   628: astore_1
    //   629: aload 9
    //   631: astore 8
    //   633: goto +544 -> 1177
    //   636: astore 8
    //   638: iconst_m1
    //   639: istore_3
    //   640: aload 9
    //   642: astore_1
    //   643: aload 8
    //   645: astore 9
    //   647: goto +42 -> 689
    //   650: astore 8
    //   652: iconst_m1
    //   653: istore_3
    //   654: aload 9
    //   656: astore_1
    //   657: aload 8
    //   659: astore 9
    //   661: goto +155 -> 816
    //   664: astore 8
    //   666: iconst_m1
    //   667: istore_3
    //   668: aload 9
    //   670: astore_1
    //   671: aload 8
    //   673: astore 9
    //   675: goto +260 -> 935
    //   678: astore_1
    //   679: goto +498 -> 1177
    //   682: astore 9
    //   684: iconst_m1
    //   685: istore_3
    //   686: aload 12
    //   688: astore_1
    //   689: aload_1
    //   690: astore 8
    //   692: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   695: ifeq +11 -> 706
    //   698: aload_1
    //   699: astore 8
    //   701: aload 9
    //   703: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   706: aload_1
    //   707: astore 8
    //   709: new 121	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   716: astore 10
    //   718: aload_1
    //   719: astore 8
    //   721: aload 10
    //   723: ldc 225
    //   725: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload_1
    //   730: astore 8
    //   732: aload 10
    //   734: aload 9
    //   736: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   739: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload_1
    //   744: astore 8
    //   746: aload_0
    //   747: bipush 245
    //   749: aload 10
    //   751: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   757: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   760: iload 6
    //   762: istore 4
    //   764: iload_3
    //   765: istore_2
    //   766: aload_1
    //   767: ifnull +280 -> 1047
    //   770: aload_1
    //   771: invokevirtual 223	java/io/OutputStream:close	()V
    //   774: iload 6
    //   776: istore 4
    //   778: iload_3
    //   779: istore_2
    //   780: goto +267 -> 1047
    //   783: astore_1
    //   784: iload 6
    //   786: istore 4
    //   788: iload_3
    //   789: istore_2
    //   790: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   793: ifeq +254 -> 1047
    //   796: iload_3
    //   797: istore_2
    //   798: aload_1
    //   799: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   802: iload 6
    //   804: istore 4
    //   806: goto +241 -> 1047
    //   809: astore 9
    //   811: iconst_m1
    //   812: istore_3
    //   813: aload 14
    //   815: astore_1
    //   816: aload_1
    //   817: astore 8
    //   819: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   822: ifeq +11 -> 833
    //   825: aload_1
    //   826: astore 8
    //   828: aload 9
    //   830: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   833: aload_1
    //   834: astore 8
    //   836: new 121	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   843: astore 10
    //   845: aload_1
    //   846: astore 8
    //   848: aload 10
    //   850: ldc 217
    //   852: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload_1
    //   857: astore 8
    //   859: aload 10
    //   861: aload 9
    //   863: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   866: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload_1
    //   871: astore 8
    //   873: aload_0
    //   874: bipush 245
    //   876: aload 10
    //   878: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   884: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   887: iload 6
    //   889: istore 4
    //   891: iload_3
    //   892: istore_2
    //   893: aload_1
    //   894: ifnull +153 -> 1047
    //   897: aload_1
    //   898: invokevirtual 223	java/io/OutputStream:close	()V
    //   901: iload 6
    //   903: istore 4
    //   905: iload_3
    //   906: istore_2
    //   907: goto +140 -> 1047
    //   910: astore_1
    //   911: iload 6
    //   913: istore 4
    //   915: iload_3
    //   916: istore_2
    //   917: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   920: ifeq +127 -> 1047
    //   923: iload_3
    //   924: istore_2
    //   925: goto -127 -> 798
    //   928: astore 9
    //   930: iconst_m1
    //   931: istore_3
    //   932: aload 15
    //   934: astore_1
    //   935: aload_1
    //   936: astore 8
    //   938: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   941: ifeq +11 -> 952
    //   944: aload_1
    //   945: astore 8
    //   947: aload 9
    //   949: invokevirtual 227	java/net/MalformedURLException:printStackTrace	()V
    //   952: aload_1
    //   953: astore 8
    //   955: new 121	java/lang/StringBuilder
    //   958: dup
    //   959: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   962: astore 10
    //   964: aload_1
    //   965: astore 8
    //   967: aload 10
    //   969: ldc 229
    //   971: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload_1
    //   976: astore 8
    //   978: aload 10
    //   980: aload 9
    //   982: invokevirtual 230	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   985: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload_1
    //   990: astore 8
    //   992: aload_0
    //   993: bipush 245
    //   995: aload 10
    //   997: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   1003: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   1006: iload 6
    //   1008: istore 4
    //   1010: iload_3
    //   1011: istore_2
    //   1012: aload_1
    //   1013: ifnull +34 -> 1047
    //   1016: aload_1
    //   1017: invokevirtual 223	java/io/OutputStream:close	()V
    //   1020: iload 6
    //   1022: istore 4
    //   1024: iload_3
    //   1025: istore_2
    //   1026: goto +21 -> 1047
    //   1029: astore_1
    //   1030: iload 6
    //   1032: istore 4
    //   1034: iload_3
    //   1035: istore_2
    //   1036: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   1039: ifeq +8 -> 1047
    //   1042: iload_3
    //   1043: istore_2
    //   1044: goto -246 -> 798
    //   1047: iload 4
    //   1049: ifeq +73 -> 1122
    //   1052: sipush 200
    //   1055: iload_2
    //   1056: if_icmpeq +66 -> 1122
    //   1059: new 121	java/lang/StringBuilder
    //   1062: dup
    //   1063: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1066: astore_1
    //   1067: aload_1
    //   1068: ldc 232
    //   1070: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload_1
    //   1075: iload_2
    //   1076: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload_1
    //   1081: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   1087: new 121	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1094: astore_1
    //   1095: aload_1
    //   1096: ldc 232
    //   1098: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload_1
    //   1103: iload_2
    //   1104: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload_0
    //   1109: bipush 245
    //   1111: aload_1
    //   1112: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   1118: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   1121: return
    //   1122: aload_0
    //   1123: getfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   1126: ifnonnull +19 -> 1145
    //   1129: ldc 237
    //   1131: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   1134: aload_0
    //   1135: iconst_m1
    //   1136: ldc 239
    //   1138: invokestatic 220	com/baidu/lbsapi/auth/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   1141: putfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   1144: return
    //   1145: new 121	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1152: astore_1
    //   1153: aload_1
    //   1154: ldc 241
    //   1156: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: pop
    //   1160: aload_1
    //   1161: aload_0
    //   1162: getfield 22	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   1165: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload_1
    //   1170: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 134	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   1176: return
    //   1177: aload 8
    //   1179: ifnull +24 -> 1203
    //   1182: aload 8
    //   1184: invokevirtual 223	java/io/OutputStream:close	()V
    //   1187: goto +16 -> 1203
    //   1190: astore 8
    //   1192: getstatic 101	com/baidu/lbsapi/auth/a:a	Z
    //   1195: ifeq +8 -> 1203
    //   1198: aload 8
    //   1200: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   1203: aload_1
    //   1204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1205	0	this	g
    //   0	1205	1	paramHttpsURLConnection	HttpsURLConnection
    //   151	953	2	i	int
    //   197	846	3	j	int
    //   263	785	4	k	int
    //   266	357	5	m	int
    //   77	954	6	n	int
    //   53	246	7	i1	int
    //   7	534	8	localObject1	Object
    //   607	1	8	localException1	Exception
    //   612	1	8	localIOException1	java.io.IOException
    //   620	1	8	localMalformedURLException1	MalformedURLException
    //   631	1	8	localObject2	Object
    //   636	8	8	localException2	Exception
    //   650	8	8	localIOException2	java.io.IOException
    //   664	8	8	localMalformedURLException2	MalformedURLException
    //   690	493	8	localHttpsURLConnection	HttpsURLConnection
    //   1190	9	8	localIOException3	java.io.IOException
    //   83	591	9	localObject3	Object
    //   682	53	9	localException3	Exception
    //   809	53	9	localIOException4	java.io.IOException
    //   928	53	9	localMalformedURLException3	MalformedURLException
    //   74	142	10	localStringBuffer	java.lang.StringBuffer
    //   226	1	10	localObject4	Object
    //   235	1	10	localObject5	Object
    //   240	1	10	localObject6	Object
    //   304	1	10	localObject7	Object
    //   327	1	10	localObject8	Object
    //   336	1	10	localObject9	Object
    //   355	641	10	localObject10	Object
    //   56	1	11	localObject11	Object
    //   231	1	11	localIOException5	java.io.IOException
    //   245	1	11	localIOException6	java.io.IOException
    //   313	1	11	localObject12	Object
    //   322	1	11	localIOException7	java.io.IOException
    //   345	235	11	localObject13	Object
    //   65	277	12	localObject14	Object
    //   350	12	12	localIOException8	java.io.IOException
    //   383	304	12	localObject15	Object
    //   59	285	13	localObject16	Object
    //   534	11	13	localObject17	Object
    //   68	746	14	localObject18	Object
    //   71	862	15	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   183	192	226	finally
    //   192	198	226	finally
    //   203	211	226	finally
    //   214	223	226	finally
    //   183	192	231	java/io/IOException
    //   192	198	231	java/io/IOException
    //   203	211	231	java/io/IOException
    //   214	223	231	java/io/IOException
    //   163	183	240	finally
    //   163	183	245	java/io/IOException
    //   147	152	304	finally
    //   147	152	322	java/io/IOException
    //   141	147	336	finally
    //   141	147	350	java/io/IOException
    //   509	514	517	java/io/IOException
    //   365	412	534	finally
    //   412	454	534	finally
    //   268	273	607	java/lang/Exception
    //   281	286	607	java/lang/Exception
    //   294	298	607	java/lang/Exception
    //   472	477	607	java/lang/Exception
    //   485	490	607	java/lang/Exception
    //   498	502	607	java/lang/Exception
    //   566	571	607	java/lang/Exception
    //   579	584	607	java/lang/Exception
    //   592	596	607	java/lang/Exception
    //   604	607	607	java/lang/Exception
    //   268	273	612	java/io/IOException
    //   281	286	612	java/io/IOException
    //   294	298	612	java/io/IOException
    //   472	477	612	java/io/IOException
    //   485	490	612	java/io/IOException
    //   498	502	612	java/io/IOException
    //   566	571	612	java/io/IOException
    //   579	584	612	java/io/IOException
    //   592	596	612	java/io/IOException
    //   604	607	612	java/io/IOException
    //   268	273	620	java/net/MalformedURLException
    //   281	286	620	java/net/MalformedURLException
    //   294	298	620	java/net/MalformedURLException
    //   472	477	620	java/net/MalformedURLException
    //   485	490	620	java/net/MalformedURLException
    //   498	502	620	java/net/MalformedURLException
    //   566	571	620	java/net/MalformedURLException
    //   579	584	620	java/net/MalformedURLException
    //   592	596	620	java/net/MalformedURLException
    //   604	607	620	java/net/MalformedURLException
    //   85	141	628	finally
    //   268	273	628	finally
    //   281	286	628	finally
    //   294	298	628	finally
    //   472	477	628	finally
    //   485	490	628	finally
    //   498	502	628	finally
    //   566	571	628	finally
    //   579	584	628	finally
    //   592	596	628	finally
    //   604	607	628	finally
    //   85	141	636	java/lang/Exception
    //   85	141	650	java/io/IOException
    //   85	141	664	java/net/MalformedURLException
    //   79	85	678	finally
    //   692	698	678	finally
    //   701	706	678	finally
    //   709	718	678	finally
    //   721	729	678	finally
    //   732	743	678	finally
    //   746	760	678	finally
    //   819	825	678	finally
    //   828	833	678	finally
    //   836	845	678	finally
    //   848	856	678	finally
    //   859	870	678	finally
    //   873	887	678	finally
    //   938	944	678	finally
    //   947	952	678	finally
    //   955	964	678	finally
    //   967	975	678	finally
    //   978	989	678	finally
    //   992	1006	678	finally
    //   79	85	682	java/lang/Exception
    //   770	774	783	java/io/IOException
    //   79	85	809	java/io/IOException
    //   897	901	910	java/io/IOException
    //   79	85	928	java/net/MalformedURLException
    //   1016	1020	1029	java/io/IOException
    //   1182	1187	1190	java/io/IOException
  }
  
  private static String b(HashMap paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 1;
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      if (i != 0) {
        i = 0;
      } else {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
    }
    return localStringBuilder.toString();
  }
  
  private HttpsURLConnection b()
  {
    try
    {
      Object localObject1 = new URL(this.b);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https URL: ");
      ((StringBuilder)localObject2).append(this.b);
      a.a(((StringBuilder)localObject2).toString());
      localObject2 = a(this.a);
      if ((localObject2 != null) && (!((String)localObject2).equals("")))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNetwork = ");
        localStringBuilder.append((String)localObject2);
        a.a(localStringBuilder.toString());
        if (((String)localObject2).equals("cmwap")) {
          localObject1 = ((URL)localObject1).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
        }
        for (;;)
        {
          localObject1 = (HttpsURLConnection)localObject1;
          break;
          if (((String)localObject2).equals("ctwap")) {
            localObject1 = ((URL)localObject1).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
          } else {
            localObject1 = ((URL)localObject1).openConnection();
          }
        }
        ((HttpsURLConnection)localObject1).setHostnameVerifier(new h(this));
        ((HttpsURLConnection)localObject1).setDoInput(true);
        ((HttpsURLConnection)localObject1).setDoOutput(true);
        ((HttpsURLConnection)localObject1).setRequestMethod("POST");
        ((HttpsURLConnection)localObject1).setConnectTimeout(50000);
        ((HttpsURLConnection)localObject1).setReadTimeout(50000);
        return localObject1;
      }
      a.c("Current network is not available.");
      this.d = ErrorMessage.a(-10, "Current network is not available.");
      return null;
    }
    catch (Exception localException)
    {
      if (a.a)
      {
        localException.printStackTrace();
        a.a(localException.getMessage());
      }
      String str1 = "Init httpsurlconnection failed.";
      this.d = ErrorMessage.a(-11, str1);
      return null;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (a.a)
        {
          localMalformedURLException.printStackTrace();
          a.a(localMalformedURLException.getMessage());
        }
        String str2 = "Auth server could not be parsed as a URL.";
      }
    }
  }
  
  private HashMap c(HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }
  
  protected String a(HashMap paramHashMap)
  {
    paramHashMap = c(paramHashMap);
    this.c = paramHashMap;
    this.b = ((String)paramHashMap.get("url"));
    paramHashMap = b();
    if (paramHashMap == null) {
      a.c("syncConnect failed,httpsURLConnection is null");
    }
    for (;;)
    {
      return this.d;
      a(paramHashMap);
    }
  }
  
  protected boolean a()
  {
    a.a("checkNetwork start");
    try
    {
      Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkCapabilities(((ConnectivityManager)localObject).getActiveNetwork());
        if ((localObject != null) && (((NetworkCapabilities)localObject).hasCapability(12)) && (((NetworkCapabilities)localObject).hasCapability(16))) {
          return true;
        }
      }
      else
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null)
        {
          boolean bool = ((NetworkInfo)localObject).isAvailable();
          if (!bool) {
            return false;
          }
          a.a("checkNetwork end");
          return true;
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      if (a.a) {
        localException.printStackTrace();
      }
      return false;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.g
 * JD-Core Version:    0.7.0.1
 */