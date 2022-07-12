package com.baidu.location.b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager.CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.c.b;
import com.baidu.location.e.f;
import com.baidu.location.e.h;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.WifiConfiguration;>;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class d
{
  private static char[] q = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
  String a;
  String b;
  c c;
  private Context d;
  private TelephonyManager e;
  private com.baidu.location.c.a f;
  private WifiManager g;
  private e h;
  private String i;
  private String j;
  private LocationClientOption k;
  private b l;
  private String m;
  private String n;
  private String o;
  private boolean p;
  private boolean r;
  private final Object s;
  private f t;
  private boolean u;
  private boolean v;
  private long w;
  private boolean x;
  
  /* Error */
  public d(Context paramContext, LocationClientOption paramLocationClientOption, b paramb, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 79	java/lang/Object:<init>	()V
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 83	com/baidu/location/b/d:e	Landroid/telephony/TelephonyManager;
    //   17: aload_0
    //   18: new 85	com/baidu/location/c/a
    //   21: dup
    //   22: invokespecial 86	com/baidu/location/c/a:<init>	()V
    //   25: putfield 88	com/baidu/location/b/d:f	Lcom/baidu/location/c/a;
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 90	com/baidu/location/b/d:g	Landroid/net/wifi/WifiManager;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 92	com/baidu/location/b/d:h	Lcom/baidu/location/b/d$e;
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 96	com/baidu/location/b/d:j	Ljava/lang/String;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 98	com/baidu/location/b/d:m	Ljava/lang/String;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 100	com/baidu/location/b/d:n	Ljava/lang/String;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 102	com/baidu/location/b/d:o	Ljava/lang/String;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 104	com/baidu/location/b/d:a	Ljava/lang/String;
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 108	com/baidu/location/b/d:p	Z
    //   78: aload_0
    //   79: new 14	com/baidu/location/b/d$c
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 111	com/baidu/location/b/d$c:<init>	(Lcom/baidu/location/b/d;)V
    //   87: putfield 113	com/baidu/location/b/d:c	Lcom/baidu/location/b/d$c;
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 115	com/baidu/location/b/d:r	Z
    //   95: aload_0
    //   96: new 4	java/lang/Object
    //   99: dup
    //   100: invokespecial 79	java/lang/Object:<init>	()V
    //   103: putfield 117	com/baidu/location/b/d:s	Ljava/lang/Object;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 119	com/baidu/location/b/d:t	Lcom/baidu/location/b/d$f;
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 121	com/baidu/location/b/d:u	Z
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 123	com/baidu/location/b/d:v	Z
    //   121: aload_0
    //   122: lconst_0
    //   123: putfield 125	com/baidu/location/b/d:w	J
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 127	com/baidu/location/b/d:x	Z
    //   131: aload_1
    //   132: invokevirtual 133	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: putfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   141: aload_1
    //   142: invokevirtual 137	android/content/Context:getPackageName	()Ljava/lang/String;
    //   145: putstatic 142	com/baidu/location/e/h:aw	Ljava/lang/String;
    //   148: aload_0
    //   149: iconst_1
    //   150: putfield 108	com/baidu/location/b/d:p	Z
    //   153: aload_0
    //   154: new 144	com/baidu/location/LocationClientOption
    //   157: dup
    //   158: aload_2
    //   159: invokespecial 147	com/baidu/location/LocationClientOption:<init>	(Lcom/baidu/location/LocationClientOption;)V
    //   162: putfield 149	com/baidu/location/b/d:k	Lcom/baidu/location/LocationClientOption;
    //   165: aload_0
    //   166: aload_3
    //   167: putfield 151	com/baidu/location/b/d:l	Lcom/baidu/location/b/d$b;
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   175: invokevirtual 137	android/content/Context:getPackageName	()Ljava/lang/String;
    //   178: putfield 104	com/baidu/location/b/d:a	Ljava/lang/String;
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   191: ldc 153
    //   193: invokevirtual 157	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   196: checkcast 159	android/telephony/TelephonyManager
    //   199: putfield 83	com/baidu/location/b/d:e	Landroid/telephony/TelephonyManager;
    //   202: aload_0
    //   203: aload_0
    //   204: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   207: invokevirtual 133	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   210: ldc 161
    //   212: invokevirtual 157	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   215: checkcast 163	android/net/wifi/WifiManager
    //   218: putfield 90	com/baidu/location/b/d:g	Landroid/net/wifi/WifiManager;
    //   221: aload_0
    //   222: getfield 149	com/baidu/location/b/d:k	Lcom/baidu/location/LocationClientOption;
    //   225: astore_1
    //   226: aload_1
    //   227: getfield 167	com/baidu/location/LocationClientOption:firstLocType	Lcom/baidu/location/LocationClientOption$FirstLocType;
    //   230: getstatic 172	com/baidu/location/LocationClientOption$FirstLocType:ACCURACY_IN_FIRST_LOC	Lcom/baidu/location/LocationClientOption$FirstLocType;
    //   233: if_acmpne +61 -> 294
    //   236: aload_1
    //   237: getfield 176	com/baidu/location/LocationClientOption:priority	I
    //   240: iconst_4
    //   241: if_icmpeq +36 -> 277
    //   244: new 27	com/baidu/location/b/d$f
    //   247: dup
    //   248: aload_0
    //   249: aconst_null
    //   250: invokespecial 179	com/baidu/location/b/d$f:<init>	(Lcom/baidu/location/b/d;Lcom/baidu/location/b/d$1;)V
    //   253: astore_1
    //   254: aload_0
    //   255: aload_1
    //   256: putfield 119	com/baidu/location/b/d:t	Lcom/baidu/location/b/d$f;
    //   259: aload_0
    //   260: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   263: aload_1
    //   264: new 181	android/content/IntentFilter
    //   267: dup
    //   268: ldc 183
    //   270: invokespecial 186	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   273: invokevirtual 190	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   276: pop
    //   277: getstatic 195	android/os/Build$VERSION:SDK_INT	I
    //   280: bipush 30
    //   282: if_icmplt +12 -> 294
    //   285: aload_0
    //   286: ldc 197
    //   288: invokestatic 200	com/baidu/location/e/h:b	(Ljava/lang/String;)Z
    //   291: putfield 123	com/baidu/location/b/d:v	Z
    //   294: new 202	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   301: astore_1
    //   302: aload_1
    //   303: ldc 205
    //   305: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_1
    //   310: aload_0
    //   311: getfield 104	com/baidu/location/b/d:a	Ljava/lang/String;
    //   314: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_1
    //   319: ldc 205
    //   321: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_1
    //   326: aconst_null
    //   327: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_0
    //   332: aload_1
    //   333: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: putfield 96	com/baidu/location/b/d:j	Ljava/lang/String;
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   344: invokestatic 218	com/baidu/lbsapi/auth/LBSAuthManager:getInstance	(Landroid/content/Context;)Lcom/baidu/lbsapi/auth/LBSAuthManager;
    //   347: invokevirtual 221	com/baidu/lbsapi/auth/LBSAuthManager:getCUID	()Ljava/lang/String;
    //   350: putfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   353: goto +18 -> 371
    //   356: aload_0
    //   357: aconst_null
    //   358: putfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   361: aload_0
    //   362: aconst_null
    //   363: putfield 83	com/baidu/location/b/d:e	Landroid/telephony/TelephonyManager;
    //   366: aload_0
    //   367: aconst_null
    //   368: putfield 90	com/baidu/location/b/d:g	Landroid/net/wifi/WifiManager;
    //   371: aload_0
    //   372: getfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   375: ifnull +92 -> 467
    //   378: new 202	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   385: astore_1
    //   386: aload_1
    //   387: ldc 223
    //   389: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_1
    //   394: aload_0
    //   395: getfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   398: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_1
    //   403: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: putstatic 224	com/baidu/location/e/h:n	Ljava/lang/String;
    //   409: new 202	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   416: astore_1
    //   417: aload_1
    //   418: ldc 226
    //   420: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_1
    //   425: aload_0
    //   426: getfield 149	com/baidu/location/b/d:k	Lcom/baidu/location/LocationClientOption;
    //   429: getfield 229	com/baidu/location/LocationClientOption:prodName	Ljava/lang/String;
    //   432: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: ldc 231
    //   439: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_1
    //   444: aload_0
    //   445: getfield 104	com/baidu/location/b/d:a	Ljava/lang/String;
    //   448: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: ldc 233
    //   455: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_0
    //   460: getfield 106	com/baidu/location/b/d:b	Ljava/lang/String;
    //   463: astore_3
    //   464: goto +56 -> 520
    //   467: new 202	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   474: astore_1
    //   475: aload_1
    //   476: ldc 226
    //   478: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_1
    //   483: aload_0
    //   484: getfield 149	com/baidu/location/b/d:k	Lcom/baidu/location/LocationClientOption;
    //   487: getfield 229	com/baidu/location/LocationClientOption:prodName	Ljava/lang/String;
    //   490: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_1
    //   495: ldc 231
    //   497: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: aload_0
    //   503: getfield 104	com/baidu/location/b/d:a	Ljava/lang/String;
    //   506: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_1
    //   511: ldc 235
    //   513: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 4
    //   519: astore_3
    //   520: aload_1
    //   521: aload_3
    //   522: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_1
    //   527: ldc 237
    //   529: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_1
    //   534: aload_2
    //   535: invokevirtual 240	com/baidu/location/LocationClientOption:getCoorType	()Ljava/lang/String;
    //   538: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_0
    //   543: aload_1
    //   544: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   550: new 242	java/lang/StringBuffer
    //   553: dup
    //   554: sipush 256
    //   557: invokespecial 245	java/lang/StringBuffer:<init>	(I)V
    //   560: astore_1
    //   561: aload_1
    //   562: ldc 247
    //   564: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   567: pop
    //   568: aload_1
    //   569: ldc 252
    //   571: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   574: pop
    //   575: aload_1
    //   576: ldc 254
    //   578: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   581: pop
    //   582: aload_1
    //   583: ldc 252
    //   585: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   588: pop
    //   589: aload_1
    //   590: ldc_w 256
    //   593: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   596: pop
    //   597: aload_1
    //   598: ldc_w 258
    //   601: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   604: pop
    //   605: aload_1
    //   606: getstatic 263	android/os/Build:MODEL	Ljava/lang/String;
    //   609: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   612: pop
    //   613: aload_1
    //   614: ldc_w 265
    //   617: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   620: pop
    //   621: aload_1
    //   622: ldc_w 267
    //   625: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   628: pop
    //   629: aload_2
    //   630: invokevirtual 270	com/baidu/location/LocationClientOption:getAddrType	()Ljava/lang/String;
    //   633: pop
    //   634: aload_2
    //   635: invokevirtual 270	com/baidu/location/LocationClientOption:getAddrType	()Ljava/lang/String;
    //   638: ifnull +64 -> 702
    //   641: aload_2
    //   642: invokevirtual 270	com/baidu/location/LocationClientOption:getAddrType	()Ljava/lang/String;
    //   645: ldc_w 272
    //   648: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   651: ifeq +51 -> 702
    //   654: new 202	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   661: astore_3
    //   662: aload_3
    //   663: aload_0
    //   664: getfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   667: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_3
    //   672: ldc_w 278
    //   675: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_0
    //   680: aload_3
    //   681: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   687: aload_2
    //   688: getfield 281	com/baidu/location/LocationClientOption:isNeedNewVersionRgc	Z
    //   691: ifeq +11 -> 702
    //   694: aload_1
    //   695: ldc_w 283
    //   698: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   701: pop
    //   702: aload_2
    //   703: getfield 286	com/baidu/location/LocationClientOption:isNeedAptag	Z
    //   706: iconst_1
    //   707: if_icmpeq +11 -> 718
    //   710: aload_2
    //   711: getfield 289	com/baidu/location/LocationClientOption:isNeedAptagd	Z
    //   714: iconst_1
    //   715: if_icmpne +140 -> 855
    //   718: new 202	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   725: astore_3
    //   726: aload_3
    //   727: aload_0
    //   728: getfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   731: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_3
    //   736: ldc_w 291
    //   739: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload_0
    //   744: aload_3
    //   745: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   751: aload_2
    //   752: getfield 286	com/baidu/location/LocationClientOption:isNeedAptag	Z
    //   755: iconst_1
    //   756: if_icmpne +36 -> 792
    //   759: new 202	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   766: astore_3
    //   767: aload_3
    //   768: aload_0
    //   769: getfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   772: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload_3
    //   777: ldc_w 293
    //   780: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload_0
    //   785: aload_3
    //   786: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   792: aload_2
    //   793: getfield 289	com/baidu/location/LocationClientOption:isNeedAptagd	Z
    //   796: iconst_1
    //   797: if_icmpne +36 -> 833
    //   800: new 202	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   807: astore_2
    //   808: aload_2
    //   809: aload_0
    //   810: getfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   813: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload_2
    //   818: ldc_w 295
    //   821: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload_0
    //   826: aload_2
    //   827: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   833: aload_0
    //   834: aload_0
    //   835: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   838: invokestatic 300	com/baidu/location/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   841: putfield 100	com/baidu/location/b/d:n	Ljava/lang/String;
    //   844: aload_0
    //   845: aload_0
    //   846: getfield 81	com/baidu/location/b/d:d	Landroid/content/Context;
    //   849: invokestatic 302	com/baidu/location/a/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   852: putfield 102	com/baidu/location/b/d:o	Ljava/lang/String;
    //   855: aload_1
    //   856: ldc_w 304
    //   859: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   862: pop
    //   863: aload_1
    //   864: ldc_w 306
    //   867: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   870: pop
    //   871: aload_1
    //   872: getstatic 309	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   875: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   878: pop
    //   879: new 202	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   886: astore_2
    //   887: aload_2
    //   888: aload_0
    //   889: getfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   892: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload_2
    //   897: aload_1
    //   898: invokevirtual 310	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   901: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload_0
    //   906: aload_2
    //   907: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: putfield 94	com/baidu/location/b/d:i	Ljava/lang/String;
    //   913: return
    //   914: astore_1
    //   915: goto -767 -> 148
    //   918: astore_1
    //   919: goto -698 -> 221
    //   922: astore_1
    //   923: goto -646 -> 277
    //   926: astore_1
    //   927: goto -571 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	930	0	this	d
    //   0	930	1	paramContext	Context
    //   0	930	2	paramLocationClientOption	LocationClientOption
    //   0	930	3	paramb	b
    //   0	930	4	paramString	String
    // Exception table:
    //   from	to	target	type
    //   141	148	914	java/lang/Exception
    //   186	221	918	java/lang/Exception
    //   259	277	922	java/lang/Exception
    //   339	353	926	finally
  }
  
  public static com.baidu.location.c.a a(CellLocation paramCellLocation, TelephonyManager paramTelephonyManager, com.baidu.location.c.a parama)
  {
    com.baidu.location.c.a locala = null;
    if (paramCellLocation != null)
    {
      if (paramTelephonyManager == null) {
        return null;
      }
      locala = new com.baidu.location.c.a();
      locala.l = 1;
      paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
      if ((paramTelephonyManager == null) || (paramTelephonyManager.length() <= 0)) {}
    }
    for (;;)
    {
      int i1;
      try
      {
        if (paramTelephonyManager.length() >= 3)
        {
          i2 = Integer.valueOf(paramTelephonyManager.substring(0, 3)).intValue();
          i1 = i2;
          if (i2 < 0) {
            i1 = parama.c;
          }
          locala.c = i1;
        }
        paramTelephonyManager = paramTelephonyManager.substring(3);
        if (paramTelephonyManager != null)
        {
          char[] arrayOfChar = paramTelephonyManager.toCharArray();
          i1 = 0;
          if (i1 < arrayOfChar.length) {
            if (Character.isDigit(arrayOfChar[i1])) {
              break label345;
            }
          }
          i2 = Integer.valueOf(paramTelephonyManager.substring(0, i1)).intValue();
          i1 = i2;
          if (i2 < 0) {
            i1 = parama.d;
          }
          locala.d = i1;
        }
      }
      catch (Exception paramTelephonyManager)
      {
        int i2;
        continue;
      }
      if ((paramCellLocation instanceof GsmCellLocation))
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        locala.a = paramCellLocation.getLac();
        locala.b = paramCellLocation.getCid();
        locala.i = 'g';
      }
      else if ((paramCellLocation instanceof CdmaCellLocation))
      {
        locala.i = 'c';
      }
      try
      {
        paramTelephonyManager = Class.forName("android.telephony.cdma.CdmaCellLocation");
        if (!paramTelephonyManager.isInstance(paramCellLocation)) {}
      }
      catch (Exception paramCellLocation)
      {
        return null;
      }
      try
      {
        i2 = ((CdmaCellLocation)paramCellLocation).getSystemId();
        i1 = i2;
        if (i2 < 0) {
          i1 = -1;
        }
        locala.d = i1;
        locala.b = ((CdmaCellLocation)paramCellLocation).getBaseStationId();
        locala.a = ((CdmaCellLocation)paramCellLocation).getNetworkId();
        i1 = ((CdmaCellLocation)paramCellLocation).getBaseStationLatitude();
        if (i1 < 2147483647) {
          locala.e = i1;
        }
        i1 = ((CdmaCellLocation)paramCellLocation).getBaseStationLongitude();
        if (i1 < 2147483647) {
          locala.f = i1;
        }
      }
      catch (Exception paramCellLocation)
      {
        continue;
      }
      if (!locala.b()) {
        return null;
      }
      return locala;
      label345:
      i1 += 1;
    }
  }
  
  private Object a(Object paramObject, String paramString)
  {
    return paramObject.getClass().getField(paramString).get(paramObject);
  }
  
  private String a(int paramInt)
  {
    label273:
    label275:
    try
    {
      localObject5 = b.a(this.f, this.e, true);
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        if (!((com.baidu.location.c.a)localObject5).b()) {}
      }
      for (;;)
      {
        this.f = ((com.baidu.location.c.a)localObject1);
        break;
        if (Build.VERSION.SDK_INT > 28) {
          break;
        }
        localObject1 = a(this.e.getCellLocation(), this.e, this.f);
      }
      localObject1 = this.f;
      if ((localObject1 != null) && (((com.baidu.location.c.a)localObject1).b())) {
        localObject5 = this.f.h();
      } else {
        localObject5 = null;
      }
      localObject1 = localObject5;
    }
    finally
    {
      Object localObject1;
      label162:
      label164:
      break label162;
    }
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label164;
      }
      localObject7 = this.f;
      localObject1 = localObject5;
      if (localObject7 == null) {
        break label164;
      }
      localObject1 = localObject5;
      if (((com.baidu.location.c.a)localObject7).m == null) {
        break label164;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject5);
      ((StringBuilder)localObject1).append(this.f.m);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    finally
    {
      localObject4 = localObject5;
      break label164;
    }
    localObject1 = null;
    try
    {
      this.h = null;
      if ((a(this.g)) && (this.k.priority != 4))
      {
        localObject5 = new e(this.g.getScanResults());
        this.h = ((e)localObject5);
        localObject7 = ((e)localObject5).a(paramInt, b(this.g), this.r, a.a().b);
      }
    }
    catch (Exception localException1)
    {
      LocationClientOption localLocationClientOption;
      Object localObject4;
      break label273;
    }
    try
    {
      localLocationClientOption = this.k;
      localObject5 = localObject7;
      if (localLocationClientOption == null) {
        break label275;
      }
      localObject5 = localObject7;
      if (!localLocationClientOption.isOnceLocation()) {
        break label275;
      }
      this.g.startScan();
      localObject5 = localObject7;
    }
    catch (Exception localException2)
    {
      Object localObject6 = localObject7;
      break label275;
    }
    localObject5 = null;
    if ((localObject1 == null) && (localObject5 == null))
    {
      this.m = null;
      return null;
    }
    localObject7 = localObject1;
    if (localObject5 != null) {
      if (localObject1 == null)
      {
        localObject7 = localObject5;
      }
      else
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append((String)localObject1);
        ((StringBuilder)localObject7).append((String)localObject5);
        localObject7 = ((StringBuilder)localObject7).toString();
      }
    }
    if (localObject7 == null) {
      return null;
    }
    this.m = ((String)localObject7);
    if (this.i != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.m);
      ((StringBuilder)localObject1).append(this.i);
      this.m = ((StringBuilder)localObject1).toString();
    }
    g();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject7);
    ((StringBuilder)localObject1).append(this.i);
    return ((StringBuilder)localObject1).toString();
  }
  
  private String a(List<WifiConfiguration> paramList)
  {
    int i2 = 0;
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject1 = new ArrayList();
      localIterator = paramList.iterator();
      for (;;)
      {
        paramList = (List<WifiConfiguration>)localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WifiConfiguration)localIterator.next();
        paramList = ((WifiConfiguration)localObject2).SSID;
        try
        {
          i1 = ((Integer)a(localObject2, "numAssociation")).intValue();
        }
        finally
        {
          int i1;
          label82:
          break label82;
        }
        i1 = 0;
        if ((i1 > 0) && (!TextUtils.isEmpty(paramList))) {
          ((List)localObject1).add(new d(paramList, i1));
        }
      }
    }
    paramList = null;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() > 1) {
        Collections.sort(paramList, new Comparator()
        {
          public int a(d.d paramAnonymousd1, d.d paramAnonymousd2)
          {
            int i = paramAnonymousd1.b;
            int j = paramAnonymousd2.b;
            if (i > j) {
              return -1;
            }
            if (i == j) {
              return 0;
            }
            return 1;
          }
        });
      }
      localObject1 = new StringBuffer(200);
      localIterator = paramList.iterator();
      i1 = i2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (d)localIterator.next();
        ((StringBuffer)localObject1).append(((d)localObject2).a);
        ((StringBuffer)localObject1).append(",");
        ((StringBuffer)localObject1).append(((d)localObject2).b);
        ((StringBuffer)localObject1).append("|");
        i2 = i1 + 1;
        i1 = i2;
      } while (i2 != 4);
      if (paramList.size() >= 5)
      {
        ((StringBuffer)localObject1).append(((d)paramList.get(4)).a);
        ((StringBuffer)localObject1).append(",");
        ((StringBuffer)localObject1).append(((d)paramList.get(4)).b);
      }
      return ((StringBuffer)localObject1).toString();
    }
    return null;
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("content");
      paramString = null;
      if (localJSONObject.has("ideocfre")) {
        paramString = localJSONObject.getString("ideocfre");
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("|")))
      {
        paramString = paramString.split("\\|");
        if ((paramString != null) && (paramString.length >= 2))
        {
          int i1 = Integer.parseInt(paramString[0]);
          long l1 = Long.parseLong(paramString[1]);
          paramString = this.d.getSharedPreferences("cuidRelate", 0).edit();
          paramString.putInt("cuidoc", i1);
          paramString.putLong("cuidfreq", l1);
          paramString.apply();
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a(WifiManager paramWifiManager)
  {
    try
    {
      if (!paramWifiManager.isWifiEnabled())
      {
        boolean bool = paramWifiManager.isScanAlwaysAvailable();
        if (bool) {
          break label27;
        }
      }
    }
    finally
    {
      return false;
    }
    label27:
    return true;
  }
  
  public static String b(WifiManager paramWifiManager)
  {
    if (paramWifiManager == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramWifiManager = paramWifiManager.getConnectionInfo();
        if (paramWifiManager == null) {
          return null;
        }
        paramWifiManager = paramWifiManager.getBSSID();
        if (paramWifiManager != null)
        {
          paramWifiManager = paramWifiManager.replace(":", "");
          if ((paramWifiManager != null) && (paramWifiManager.length() != 12)) {
            return null;
          }
          paramWifiManager = new String(paramWifiManager);
          return paramWifiManager;
        }
      }
      catch (Exception paramWifiManager)
      {
        return null;
      }
      paramWifiManager = null;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.k.isOnceLocation())
    {
      BDLocation localBDLocation = new BDLocation();
      localBDLocation.setLocType(paramInt);
      Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(";");
      localStringBuilder.append(this.b);
      localStringBuilder.append(";");
      localStringBuilder.append((String)localObject);
      localBDLocation.setLocationID(Jni.en1(localStringBuilder.toString()));
      localObject = this.l;
      if (localObject != null) {
        ((b)localObject).onReceiveLocation(localBDLocation);
      }
    }
  }
  
  private boolean f()
  {
    if (a.a().d == 0) {
      return false;
    }
    SharedPreferences localSharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
    if (!localSharedPreferences.contains("isInstalled"))
    {
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (h.b(this.d, "com.baidu.map.location"))
      {
        localEditor.putInt("isInstalled", 1);
        localEditor.apply();
      }
      else
      {
        localEditor.putInt("isInstalled", 0);
        return false;
      }
    }
    else if (localSharedPreferences.getInt("isInstalled", -1) == 0)
    {
      return false;
    }
    if (localSharedPreferences.getInt("cuidoc", 1) == 0) {
      return false;
    }
    if ((System.currentTimeMillis() - localSharedPreferences.getLong("reqtime", 0L)) / 1000L < localSharedPreferences.getLong("cuidfreq", 60L)) {
      return false;
    }
    if (h.b(this.d) < 2) {
      return false;
    }
    if (a(this.g)) {
      return this.h.a() > 3;
    }
    return false;
  }
  
  private void g()
  {
    if (f())
    {
      this.r = true;
      int i1 = this.h.a();
      String str = null;
      if (i1 >= 10)
      {
        localObject1 = this.h.a(9, b(this.g), this.r, a.a().b);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = h.a(((String)localObject1).getBytes(), false);
          break label126;
        }
      }
      else
      {
        localObject1 = this.h;
        localObject1 = ((e)localObject1).a(((e)localObject1).a(), b(this.g), this.r, a.a().b);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = h.a(((String)localObject1).getBytes(), false);
          break label126;
        }
      }
      Object localObject1 = null;
      label126:
      Object localObject2 = a(h());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        str = h.a(((String)localObject2).getBytes(), false);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.m);
        ((StringBuilder)localObject2).append("&swf5=");
        ((StringBuilder)localObject2).append((String)localObject1);
        this.m = ((StringBuilder)localObject2).toString();
        this.r = true;
      }
      else
      {
        this.r = false;
      }
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.m);
        ((StringBuilder)localObject1).append("&hwf5=");
        ((StringBuilder)localObject1).append(str);
        this.m = ((StringBuilder)localObject1).toString();
        this.r = true;
      }
    }
    else
    {
      this.r = false;
    }
  }
  
  private List<WifiConfiguration> h()
  {
    List localList = null;
    try
    {
      WifiManager localWifiManager = this.g;
      if (localWifiManager != null) {
        localList = localWifiManager.getConfiguredNetworks();
      }
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a()
  {
    b();
  }
  
  public String b()
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
  
  public void c()
  {
    String str = this.m;
    if (str == null)
    {
      b(62);
      return;
    }
    if (!this.p) {
      return;
    }
    this.c.a(str);
  }
  
  public void d()
  {
    if (((this.g.isWifiEnabled()) || (this.g.isScanAlwaysAvailable())) && (this.k.priority != 4)) {
      this.g.startScan();
    }
    if ((h.a(this.d, "android.permission.ACCESS_FINE_LOCATION") == 1) && (Build.VERSION.SDK_INT >= 29) && (this.v))
    {
      ??? = new a(null);
      this.e.requestCellInfoUpdate(this.d.getMainExecutor(), (TelephonyManager.CellInfoCallback)???);
    }
    try
    {
      synchronized (this.s)
      {
        this.s.wait(3000L);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label117:
      break label117;
    }
    return;
    throw localObject2;
  }
  
  public void e()
  {
    try
    {
      f localf = this.t;
      if (localf != null) {
        this.d.unregisterReceiver(localf);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  @TargetApi(29)
  private class a
    extends TelephonyManager.CellInfoCallback
  {
    private a() {}
    
    public void onCellInfo(List<CellInfo> arg1)
    {
      if (??? == null) {
        return;
      }
      ??? = d.this;
      d.b(???, d.g(???) ^ true);
      if ((d.g(d.this)) || (d.c(d.this).priority == 4)) {
        synchronized (d.i(d.this))
        {
          d.i(d.this).notifyAll();
          return;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onReceiveLocation(BDLocation paramBDLocation);
  }
  
  class c
    extends f
  {
    String a = null;
    LocationManager b;
    a c;
    boolean d = false;
    
    c()
    {
      this.j = new HashMap();
    }
    
    private void b()
    {
      try
      {
        this.b = ((LocationManager)d.f(d.this).getSystemService("location"));
        a locala = new a(null);
        this.c = locala;
        LocationManager localLocationManager = this.b;
        if (localLocationManager != null) {
          try
          {
            localLocationManager.requestLocationUpdates("network", 1000L, 0.0F, locala, Looper.getMainLooper());
            return;
          }
          catch (SecurityException localSecurityException)
          {
            localSecurityException.printStackTrace();
          }
        }
        return;
      }
      finally {}
    }
    
    private void c()
    {
      a locala = this.c;
      LocationManager localLocationManager;
      if (locala != null)
      {
        localLocationManager = this.b;
        if (localLocationManager == null) {}
      }
      try
      {
        localLocationManager.removeUpdates(locala);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void a()
    {
      if ((d.a(d.this) != null) && (d.b(d.this) != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[] { d.a(d.this), d.b(d.this) }));
        this.a = ((StringBuilder)localObject).toString();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("&enc=2");
      localObject = ((StringBuilder)localObject).toString();
      this.a = ((String)localObject);
      localObject = Jni.encodeTp4((String)localObject);
      this.a = null;
      this.j.put("bloc", localObject);
      localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.j.put("trtm", localObject);
    }
    
    public void a(final String paramString)
    {
      this.a = paramString;
      b(com.baidu.location.e.d.c);
      if (d.e(d.this))
      {
        b();
        paramString = new Timer();
        paramString.schedule(new TimerTask()
        {
          public void run()
          {
            d.c localc = d.c.this;
            if (!localc.d) {
              d.c.a(localc);
            }
            paramString.cancel();
            paramString.purge();
          }
        }, 10000L);
        paramString = d.f(d.this).getSharedPreferences("cuidRelate", 0).edit();
        paramString.putLong("reqtime", System.currentTimeMillis());
        paramString.apply();
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject3 = this.i;
        if (localObject3 != null) {
          try
          {
            paramBoolean = ((String)localObject3).contains("\"enc\"");
            Object localObject1 = localObject3;
            if (paramBoolean) {
              try
              {
                JSONObject localJSONObject = new JSONObject((String)localObject3);
                localObject1 = localObject3;
                if (localJSONObject.has("enc"))
                {
                  localObject1 = localJSONObject.getString("enc");
                  localObject1 = i.a().b((String)localObject1);
                }
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                localObject2 = localObject3;
              }
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            label96:
            d.a(d.this, 63);
            localException2.printStackTrace();
          }
        }
      }
      try
      {
        localObject3 = new BDLocation((String)localObject2);
        d.a(d.this, (String)localObject2);
        localObject2 = localObject3;
      }
      catch (Exception localException3)
      {
        Map localMap;
        break label96;
      }
      localObject2 = new BDLocation();
      ((BDLocation)localObject2).setLocType(63);
      if (((BDLocation)localObject2).getLocType() == 161)
      {
        ((BDLocation)localObject2).setCoorType(d.c(d.this).coorType);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(d.this.a);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(d.this.b);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append(((BDLocation)localObject2).getTime());
        ((BDLocation)localObject2).setLocationID(Jni.en1(((StringBuilder)localObject3).toString()));
        ((BDLocation)localObject2).setRoadLocString(0.0F, 0.0F, null);
        d.a(d.this, true);
        d.d(d.this).onReceiveLocation((BDLocation)localObject2);
      }
      else
      {
        d.a(d.this, ((BDLocation)localObject2).getLocType());
        break label274;
        d.a(d.this, 63);
      }
      label274:
      localMap = this.j;
      if (localMap != null) {
        localMap.clear();
      }
    }
    
    private class a
      implements LocationListener
    {
      private a() {}
      
      public void onLocationChanged(Location paramLocation)
      {
        d.c.a(d.c.this);
        d.c.this.d = true;
      }
      
      public void onProviderDisabled(String paramString) {}
      
      public void onProviderEnabled(String paramString) {}
      
      public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
    }
  }
  
  private class d
  {
    public String a;
    public int b;
    
    d(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
  
  public static class e
  {
    public List<ScanResult> a;
    public String b = null;
    private long c = 0L;
    private String d = null;
    private int e = 16;
    
    public e(List<ScanResult> paramList)
    {
      this.a = paramList;
      this.c = System.currentTimeMillis();
      try
      {
        b();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
    
    private void b()
    {
      if (a() < 1) {
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
    
    /* Error */
    public String a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 50	com/baidu/location/b/d$e:a	()I
      //   4: iconst_1
      //   5: if_icmpge +5 -> 10
      //   8: aconst_null
      //   9: areturn
      //   10: aload_0
      //   11: iload 4
      //   13: putfield 31	com/baidu/location/b/d$e:e	I
      //   16: new 73	java/util/ArrayList
      //   19: dup
      //   20: invokespecial 74	java/util/ArrayList:<init>	()V
      //   23: astore 25
      //   25: invokestatic 79	android/os/SystemClock:elapsedRealtimeNanos	()J
      //   28: ldc2_w 80
      //   31: ldiv
      //   32: lstore 21
      //   34: goto +6 -> 40
      //   37: lconst_0
      //   38: lstore 21
      //   40: lload 21
      //   42: lconst_0
      //   43: lcmp
      //   44: ifle +9 -> 53
      //   47: iconst_1
      //   48: istore 8
      //   50: goto +6 -> 56
      //   53: iconst_0
      //   54: istore 8
      //   56: new 83	java/lang/StringBuffer
      //   59: dup
      //   60: sipush 512
      //   63: invokespecial 86	java/lang/StringBuffer:<init>	(I)V
      //   66: astore 24
      //   68: aload_0
      //   69: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   72: invokeinterface 55 1 0
      //   77: istore 14
      //   79: iconst_1
      //   80: istore 5
      //   82: lconst_0
      //   83: lstore 15
      //   85: iconst_0
      //   86: istore 9
      //   88: iconst_0
      //   89: istore 12
      //   91: iconst_0
      //   92: istore 7
      //   94: iconst_0
      //   95: istore 4
      //   97: aload_2
      //   98: astore 23
      //   100: iload 9
      //   102: iload 14
      //   104: if_icmpge +363 -> 467
      //   107: iload 12
      //   109: istore 13
      //   111: iload 5
      //   113: istore 11
      //   115: iload 7
      //   117: istore 10
      //   119: iload 4
      //   121: istore 6
      //   123: lload 15
      //   125: lstore 17
      //   127: aload_0
      //   128: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   131: iload 9
      //   133: invokeinterface 59 2 0
      //   138: ifnull +300 -> 438
      //   141: aload_0
      //   142: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   145: iload 9
      //   147: invokeinterface 59 2 0
      //   152: checkcast 61	android/net/wifi/ScanResult
      //   155: getfield 64	android/net/wifi/ScanResult:level	I
      //   158: ifne +26 -> 184
      //   161: iload 12
      //   163: istore 13
      //   165: iload 5
      //   167: istore 11
      //   169: iload 7
      //   171: istore 10
      //   173: iload 4
      //   175: istore 6
      //   177: lload 15
      //   179: lstore 17
      //   181: goto +257 -> 438
      //   184: iload 12
      //   186: iconst_1
      //   187: iadd
      //   188: istore 10
      //   190: iload 5
      //   192: ifeq +17 -> 209
      //   195: aload 24
      //   197: ldc 88
      //   199: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   202: pop
      //   203: iconst_0
      //   204: istore 5
      //   206: goto +11 -> 217
      //   209: aload 24
      //   211: ldc 94
      //   213: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   216: pop
      //   217: aload_0
      //   218: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   221: iload 9
      //   223: invokeinterface 59 2 0
      //   228: checkcast 61	android/net/wifi/ScanResult
      //   231: getfield 97	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
      //   234: ldc 99
      //   236: ldc 101
      //   238: invokevirtual 107	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   241: astore 26
      //   243: aload 24
      //   245: aload 26
      //   247: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   250: pop
      //   251: iload 4
      //   253: istore 6
      //   255: aload 23
      //   257: ifnull +21 -> 278
      //   260: iload 4
      //   262: istore 6
      //   264: aload 26
      //   266: aload 23
      //   268: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   271: ifeq +7 -> 278
      //   274: iload 10
      //   276: istore 6
      //   278: aload_0
      //   279: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   282: iload 9
      //   284: invokeinterface 59 2 0
      //   289: checkcast 61	android/net/wifi/ScanResult
      //   292: getfield 64	android/net/wifi/ScanResult:level	I
      //   295: istore 11
      //   297: iload 11
      //   299: istore 4
      //   301: iload 11
      //   303: ifge +8 -> 311
      //   306: iload 11
      //   308: ineg
      //   309: istore 4
      //   311: aload 24
      //   313: getstatic 117	java/util/Locale:CHINA	Ljava/util/Locale;
      //   316: ldc 119
      //   318: iconst_1
      //   319: anewarray 4	java/lang/Object
      //   322: dup
      //   323: iconst_0
      //   324: iload 4
      //   326: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   329: aastore
      //   330: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   333: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   336: pop
      //   337: iload 7
      //   339: iconst_1
      //   340: iadd
      //   341: istore 4
      //   343: lload 15
      //   345: lstore 17
      //   347: iload 8
      //   349: ifeq +64 -> 413
      //   352: lload 21
      //   354: aload_0
      //   355: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   358: iload 9
      //   360: invokeinterface 59 2 0
      //   365: checkcast 61	android/net/wifi/ScanResult
      //   368: getfield 132	android/net/wifi/ScanResult:timestamp	J
      //   371: lsub
      //   372: ldc2_w 133
      //   375: ldiv
      //   376: lstore 19
      //   378: goto +6 -> 384
      //   381: lconst_0
      //   382: lstore 19
      //   384: aload 25
      //   386: lload 19
      //   388: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   391: invokeinterface 142 2 0
      //   396: pop
      //   397: lload 15
      //   399: lstore 17
      //   401: lload 19
      //   403: lload 15
      //   405: lcmp
      //   406: ifle +7 -> 413
      //   409: lload 19
      //   411: lstore 17
      //   413: iload 4
      //   415: iload_1
      //   416: if_icmple +10 -> 426
      //   419: lload 17
      //   421: lstore 15
      //   423: goto +52 -> 475
      //   426: iload 10
      //   428: istore 13
      //   430: iload 4
      //   432: istore 10
      //   434: iload 5
      //   436: istore 11
      //   438: iload 9
      //   440: iconst_1
      //   441: iadd
      //   442: istore 9
      //   444: iload 13
      //   446: istore 12
      //   448: iload 11
      //   450: istore 5
      //   452: iload 10
      //   454: istore 7
      //   456: iload 6
      //   458: istore 4
      //   460: lload 17
      //   462: lstore 15
      //   464: goto -367 -> 97
      //   467: iload 4
      //   469: istore 6
      //   471: iload 7
      //   473: istore 4
      //   475: ldc 101
      //   477: astore_2
      //   478: iload_3
      //   479: ifeq +9 -> 488
      //   482: aload 24
      //   484: invokevirtual 146	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   487: areturn
      //   488: iload 6
      //   490: ifle +19 -> 509
      //   493: aload 24
      //   495: ldc 148
      //   497: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   500: pop
      //   501: aload 24
      //   503: iload 6
      //   505: invokevirtual 151	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
      //   508: pop
      //   509: aload_2
      //   510: astore 23
      //   512: iload 4
      //   514: iload_1
      //   515: if_icmple +161 -> 676
      //   518: aload_2
      //   519: astore 23
      //   521: aload_0
      //   522: getfield 31	com/baidu/location/b/d$e:e	I
      //   525: iload_1
      //   526: iconst_1
      //   527: iadd
      //   528: if_icmple +148 -> 676
      //   531: iload 4
      //   533: istore_1
      //   534: aload_2
      //   535: astore 23
      //   537: iload_1
      //   538: iload 14
      //   540: if_icmpge +136 -> 676
      //   543: iload_1
      //   544: iload 4
      //   546: if_icmpne +14 -> 560
      //   549: aload 24
      //   551: ldc 153
      //   553: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   556: pop
      //   557: goto +11 -> 568
      //   560: aload 24
      //   562: ldc 94
      //   564: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   567: pop
      //   568: aload_0
      //   569: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   572: iload_1
      //   573: invokeinterface 59 2 0
      //   578: checkcast 61	android/net/wifi/ScanResult
      //   581: getfield 97	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
      //   584: astore 23
      //   586: aload 24
      //   588: aload 23
      //   590: ldc 99
      //   592: aload_2
      //   593: invokevirtual 107	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   596: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   599: pop
      //   600: aload_0
      //   601: getfield 33	com/baidu/location/b/d$e:a	Ljava/util/List;
      //   604: iload_1
      //   605: invokeinterface 59 2 0
      //   610: checkcast 61	android/net/wifi/ScanResult
      //   613: getfield 64	android/net/wifi/ScanResult:level	I
      //   616: istore 7
      //   618: iload 7
      //   620: istore 6
      //   622: iload 7
      //   624: ifge +8 -> 632
      //   627: iload 7
      //   629: ineg
      //   630: istore 6
      //   632: aload 24
      //   634: getstatic 117	java/util/Locale:CHINA	Ljava/util/Locale;
      //   637: ldc 119
      //   639: iconst_1
      //   640: anewarray 4	java/lang/Object
      //   643: dup
      //   644: iconst_0
      //   645: iload 6
      //   647: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   650: aastore
      //   651: invokestatic 129	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   654: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   657: pop
      //   658: iload_1
      //   659: aload_0
      //   660: getfield 31	com/baidu/location/b/d$e:e	I
      //   663: if_icmplt +6 -> 669
      //   666: goto +13 -> 679
      //   669: iload_1
      //   670: iconst_1
      //   671: iadd
      //   672: istore_1
      //   673: goto -139 -> 534
      //   676: aload 23
      //   678: astore_2
      //   679: iconst_1
      //   680: istore_1
      //   681: iload 5
      //   683: ifeq +5 -> 688
      //   686: aconst_null
      //   687: areturn
      //   688: lload 15
      //   690: ldc2_w 154
      //   693: lcmp
      //   694: ifle +200 -> 894
      //   697: aload 25
      //   699: invokeinterface 55 1 0
      //   704: ifle +190 -> 894
      //   707: aload 25
      //   709: iconst_0
      //   710: invokeinterface 59 2 0
      //   715: checkcast 136	java/lang/Long
      //   718: invokevirtual 158	java/lang/Long:longValue	()J
      //   721: lconst_0
      //   722: lcmp
      //   723: ifle +171 -> 894
      //   726: new 83	java/lang/StringBuffer
      //   729: dup
      //   730: sipush 128
      //   733: invokespecial 86	java/lang/StringBuffer:<init>	(I)V
      //   736: astore 23
      //   738: aload 23
      //   740: ldc 160
      //   742: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   745: pop
      //   746: aload 25
      //   748: iconst_0
      //   749: invokeinterface 59 2 0
      //   754: checkcast 136	java/lang/Long
      //   757: astore 26
      //   759: aload 25
      //   761: invokeinterface 164 1 0
      //   766: astore 25
      //   768: aload 25
      //   770: invokeinterface 170 1 0
      //   775: ifeq +108 -> 883
      //   778: aload 25
      //   780: invokeinterface 174 1 0
      //   785: checkcast 136	java/lang/Long
      //   788: invokevirtual 158	java/lang/Long:longValue	()J
      //   791: lstore 15
      //   793: iload_1
      //   794: ifeq +17 -> 811
      //   797: aload 23
      //   799: lload 15
      //   801: invokevirtual 177	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
      //   804: pop
      //   805: iconst_0
      //   806: istore 4
      //   808: goto +61 -> 869
      //   811: lload 15
      //   813: aload 26
      //   815: invokevirtual 158	java/lang/Long:longValue	()J
      //   818: lsub
      //   819: lstore 15
      //   821: iload_1
      //   822: istore 4
      //   824: lload 15
      //   826: lconst_0
      //   827: lcmp
      //   828: ifeq +41 -> 869
      //   831: new 179	java/lang/StringBuilder
      //   834: dup
      //   835: invokespecial 180	java/lang/StringBuilder:<init>	()V
      //   838: astore 27
      //   840: aload 27
      //   842: aload_2
      //   843: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   846: pop
      //   847: aload 27
      //   849: lload 15
      //   851: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   854: pop
      //   855: aload 23
      //   857: aload 27
      //   859: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   862: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   865: pop
      //   866: iload_1
      //   867: istore 4
      //   869: aload 23
      //   871: ldc 94
      //   873: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   876: pop
      //   877: iload 4
      //   879: istore_1
      //   880: goto -112 -> 768
      //   883: aload 24
      //   885: aload 23
      //   887: invokevirtual 146	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   890: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   893: pop
      //   894: aload 24
      //   896: invokevirtual 146	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   899: areturn
      //   900: astore 23
      //   902: goto -865 -> 37
      //   905: astore 23
      //   907: goto -526 -> 381
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	910	0	this	e
      //   0	910	1	paramInt1	int
      //   0	910	2	paramString	String
      //   0	910	3	paramBoolean	boolean
      //   0	910	4	paramInt2	int
      //   80	602	5	i	int
      //   121	525	6	j	int
      //   92	536	7	k	int
      //   48	300	8	m	int
      //   86	357	9	n	int
      //   117	336	10	i1	int
      //   113	336	11	i2	int
      //   89	358	12	i3	int
      //   109	336	13	i4	int
      //   77	464	14	i5	int
      //   83	767	15	l1	long
      //   125	336	17	l2	long
      //   376	34	19	l3	long
      //   32	321	21	l4	long
      //   98	788	23	localObject1	Object
      //   900	1	23	localError	java.lang.Error
      //   905	1	23	localObject2	Object
      //   66	829	24	localStringBuffer	StringBuffer
      //   23	756	25	localObject3	Object
      //   241	573	26	localObject4	Object
      //   838	20	27	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   25	34	900	java/lang/Error
      //   352	378	905	finally
    }
  }
  
  private class f
    extends BroadcastReceiver
  {
    private f() {}
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      if (??? != null)
      {
        if (paramIntent == null) {
          return;
        }
        ??? = paramIntent.getAction();
        paramIntent = d.this;
        d.b(paramIntent, d.g(paramIntent) ^ true);
        if (((???.equals("android.net.wifi.SCAN_RESULTS")) && (d.g(d.this))) || (Build.VERSION.SDK_INT < 29) || (!d.h(d.this))) {
          synchronized (d.i(d.this))
          {
            d.i(d.this).notifyAll();
            return;
          }
        }
      }
      else {}
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.d
 * JD-Core Version:    0.7.0.1
 */