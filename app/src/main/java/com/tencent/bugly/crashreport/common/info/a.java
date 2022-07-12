package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class a
{
  private static final Map<String, String> F = new HashMap();
  private static a aa = null;
  public HashMap<String, String> A;
  public List<String> B;
  public boolean C;
  public com.tencent.bugly.crashreport.a D;
  public final SharedPreferences E;
  private final Context G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private long N;
  private long O;
  private long P;
  private String Q;
  private String R;
  private Map<String, PlugInBean> S;
  private boolean T;
  private String U;
  private String V;
  private Boolean W;
  private String X;
  private Map<String, PlugInBean> Y;
  private Map<String, PlugInBean> Z;
  public final long a;
  private int ab;
  private int ac;
  private final Map<String, String> ad;
  private final Map<String, String> ae;
  private final Map<String, String> af;
  private SharedPreferences ag;
  private boolean ah;
  private boolean ai;
  private boolean aj;
  private final Object ak;
  private final Object al;
  private final Object am;
  private final Object an;
  private final Object ao;
  private final Object ap;
  private final Object aq;
  private final List<Integer> ar;
  public final byte b;
  public String c;
  public final String d;
  public boolean e;
  public String f;
  public final String g;
  public long h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public List<String> n;
  public String o;
  public long p;
  public long q;
  public long r;
  public long s;
  public boolean t;
  public String u;
  public String v;
  public String w;
  public String x;
  public boolean y;
  public boolean z;
  
  /* Error */
  private a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 103	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_1
    //   6: putfield 105	com/tencent/bugly/crashreport/common/info/a:e	Z
    //   9: aload_0
    //   10: ldc 107
    //   12: putfield 109	com/tencent/bugly/crashreport/common/info/a:f	Ljava/lang/String;
    //   15: aload_0
    //   16: ldc 111
    //   18: putfield 113	com/tencent/bugly/crashreport/common/info/a:K	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 115
    //   24: putfield 117	com/tencent/bugly/crashreport/common/info/a:L	Ljava/lang/String;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 119	com/tencent/bugly/crashreport/common/info/a:M	Ljava/lang/String;
    //   32: aload_0
    //   33: ldc2_w 120
    //   36: putfield 123	com/tencent/bugly/crashreport/common/info/a:N	J
    //   39: aload_0
    //   40: ldc2_w 120
    //   43: putfield 125	com/tencent/bugly/crashreport/common/info/a:O	J
    //   46: aload_0
    //   47: ldc2_w 120
    //   50: putfield 127	com/tencent/bugly/crashreport/common/info/a:P	J
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 129	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/lang/String;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 131	com/tencent/bugly/crashreport/common/info/a:R	Ljava/lang/String;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 133	com/tencent/bugly/crashreport/common/info/a:S	Ljava/util/Map;
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 135	com/tencent/bugly/crashreport/common/info/a:T	Z
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 137	com/tencent/bugly/crashreport/common/info/a:U	Ljava/lang/String;
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 139	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 141	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 143	com/tencent/bugly/crashreport/common/info/a:V	Ljava/lang/String;
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 145	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 147	com/tencent/bugly/crashreport/common/info/a:W	Ljava/lang/Boolean;
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 149	com/tencent/bugly/crashreport/common/info/a:X	Ljava/lang/String;
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 151	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 153	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 155	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 157	com/tencent/bugly/crashreport/common/info/a:Z	Ljava/util/Map;
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 159	com/tencent/bugly/crashreport/common/info/a:n	Ljava/util/List;
    //   133: aload_0
    //   134: iconst_m1
    //   135: putfield 161	com/tencent/bugly/crashreport/common/info/a:ab	I
    //   138: aload_0
    //   139: iconst_m1
    //   140: putfield 163	com/tencent/bugly/crashreport/common/info/a:ac	I
    //   143: aload_0
    //   144: new 93	java/util/HashMap
    //   147: dup
    //   148: invokespecial 96	java/util/HashMap:<init>	()V
    //   151: putfield 165	com/tencent/bugly/crashreport/common/info/a:ad	Ljava/util/Map;
    //   154: aload_0
    //   155: new 93	java/util/HashMap
    //   158: dup
    //   159: invokespecial 96	java/util/HashMap:<init>	()V
    //   162: putfield 167	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
    //   165: aload_0
    //   166: new 93	java/util/HashMap
    //   169: dup
    //   170: invokespecial 96	java/util/HashMap:<init>	()V
    //   173: putfield 169	com/tencent/bugly/crashreport/common/info/a:af	Ljava/util/Map;
    //   176: aload_0
    //   177: ldc 111
    //   179: putfield 171	com/tencent/bugly/crashreport/common/info/a:o	Ljava/lang/String;
    //   182: aload_0
    //   183: lconst_0
    //   184: putfield 173	com/tencent/bugly/crashreport/common/info/a:p	J
    //   187: aload_0
    //   188: lconst_0
    //   189: putfield 175	com/tencent/bugly/crashreport/common/info/a:q	J
    //   192: aload_0
    //   193: lconst_0
    //   194: putfield 177	com/tencent/bugly/crashreport/common/info/a:r	J
    //   197: aload_0
    //   198: lconst_0
    //   199: putfield 179	com/tencent/bugly/crashreport/common/info/a:s	J
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 181	com/tencent/bugly/crashreport/common/info/a:t	Z
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 183	com/tencent/bugly/crashreport/common/info/a:u	Ljava/lang/String;
    //   212: aload_0
    //   213: aconst_null
    //   214: putfield 185	com/tencent/bugly/crashreport/common/info/a:v	Ljava/lang/String;
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 187	com/tencent/bugly/crashreport/common/info/a:w	Ljava/lang/String;
    //   222: aload_0
    //   223: ldc 115
    //   225: putfield 189	com/tencent/bugly/crashreport/common/info/a:x	Ljava/lang/String;
    //   228: aload_0
    //   229: iconst_0
    //   230: putfield 191	com/tencent/bugly/crashreport/common/info/a:y	Z
    //   233: aload_0
    //   234: iconst_0
    //   235: putfield 193	com/tencent/bugly/crashreport/common/info/a:z	Z
    //   238: aload_0
    //   239: new 93	java/util/HashMap
    //   242: dup
    //   243: invokespecial 96	java/util/HashMap:<init>	()V
    //   246: putfield 195	com/tencent/bugly/crashreport/common/info/a:A	Ljava/util/HashMap;
    //   249: aload_0
    //   250: new 197	java/util/ArrayList
    //   253: dup
    //   254: invokespecial 198	java/util/ArrayList:<init>	()V
    //   257: putfield 200	com/tencent/bugly/crashreport/common/info/a:B	Ljava/util/List;
    //   260: aload_0
    //   261: iconst_0
    //   262: putfield 202	com/tencent/bugly/crashreport/common/info/a:C	Z
    //   265: aload_0
    //   266: aconst_null
    //   267: putfield 204	com/tencent/bugly/crashreport/common/info/a:D	Lcom/tencent/bugly/crashreport/a;
    //   270: aload_0
    //   271: iconst_1
    //   272: putfield 206	com/tencent/bugly/crashreport/common/info/a:ah	Z
    //   275: aload_0
    //   276: iconst_1
    //   277: putfield 208	com/tencent/bugly/crashreport/common/info/a:ai	Z
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 210	com/tencent/bugly/crashreport/common/info/a:aj	Z
    //   285: aload_0
    //   286: new 4	java/lang/Object
    //   289: dup
    //   290: invokespecial 103	java/lang/Object:<init>	()V
    //   293: putfield 212	com/tencent/bugly/crashreport/common/info/a:ak	Ljava/lang/Object;
    //   296: aload_0
    //   297: new 4	java/lang/Object
    //   300: dup
    //   301: invokespecial 103	java/lang/Object:<init>	()V
    //   304: putfield 214	com/tencent/bugly/crashreport/common/info/a:al	Ljava/lang/Object;
    //   307: aload_0
    //   308: new 4	java/lang/Object
    //   311: dup
    //   312: invokespecial 103	java/lang/Object:<init>	()V
    //   315: putfield 216	com/tencent/bugly/crashreport/common/info/a:am	Ljava/lang/Object;
    //   318: aload_0
    //   319: new 4	java/lang/Object
    //   322: dup
    //   323: invokespecial 103	java/lang/Object:<init>	()V
    //   326: putfield 218	com/tencent/bugly/crashreport/common/info/a:an	Ljava/lang/Object;
    //   329: aload_0
    //   330: new 4	java/lang/Object
    //   333: dup
    //   334: invokespecial 103	java/lang/Object:<init>	()V
    //   337: putfield 220	com/tencent/bugly/crashreport/common/info/a:ao	Ljava/lang/Object;
    //   340: aload_0
    //   341: new 4	java/lang/Object
    //   344: dup
    //   345: invokespecial 103	java/lang/Object:<init>	()V
    //   348: putfield 222	com/tencent/bugly/crashreport/common/info/a:ap	Ljava/lang/Object;
    //   351: aload_0
    //   352: new 4	java/lang/Object
    //   355: dup
    //   356: invokespecial 103	java/lang/Object:<init>	()V
    //   359: putfield 224	com/tencent/bugly/crashreport/common/info/a:aq	Ljava/lang/Object;
    //   362: aload_0
    //   363: new 197	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 198	java/util/ArrayList:<init>	()V
    //   370: putfield 226	com/tencent/bugly/crashreport/common/info/a:ar	Ljava/util/List;
    //   373: aload_0
    //   374: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   377: putfield 234	com/tencent/bugly/crashreport/common/info/a:a	J
    //   380: aload_0
    //   381: aload_1
    //   382: invokestatic 239	com/tencent/bugly/proguard/ab:a	(Landroid/content/Context;)Landroid/content/Context;
    //   385: putfield 241	com/tencent/bugly/crashreport/common/info/a:G	Landroid/content/Context;
    //   388: aload_0
    //   389: iconst_1
    //   390: putfield 243	com/tencent/bugly/crashreport/common/info/a:b	B
    //   393: aload_1
    //   394: invokestatic 248	com/tencent/bugly/crashreport/common/info/AppInfo:b	(Landroid/content/Context;)Landroid/content/pm/PackageInfo;
    //   397: astore_2
    //   398: aload_2
    //   399: ifnull +44 -> 443
    //   402: aload_2
    //   403: getfield 253	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   406: astore_3
    //   407: aload_0
    //   408: aload_3
    //   409: putfield 139	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   412: aload_0
    //   413: aload_3
    //   414: putfield 183	com/tencent/bugly/crashreport/common/info/a:u	Ljava/lang/String;
    //   417: aload_0
    //   418: aload_2
    //   419: getfield 256	android/content/pm/PackageInfo:versionCode	I
    //   422: invokestatic 262	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   425: putfield 185	com/tencent/bugly/crashreport/common/info/a:v	Ljava/lang/String;
    //   428: goto +15 -> 443
    //   431: astore_2
    //   432: aload_2
    //   433: invokestatic 267	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   436: ifne +7 -> 443
    //   439: aload_2
    //   440: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   443: aload_0
    //   444: aload_1
    //   445: invokestatic 275	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   448: putfield 277	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   451: aload_0
    //   452: invokestatic 283	android/os/Process:myPid	()I
    //   455: invokestatic 285	com/tencent/bugly/crashreport/common/info/AppInfo:a	(I)Ljava/lang/String;
    //   458: putfield 287	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   461: aload_0
    //   462: aload_1
    //   463: invokestatic 289	com/tencent/bugly/crashreport/common/info/AppInfo:c	(Landroid/content/Context;)Ljava/lang/String;
    //   466: putfield 141	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   469: new 291	java/lang/StringBuilder
    //   472: dup
    //   473: ldc_w 293
    //   476: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   479: astore_2
    //   480: aload_2
    //   481: invokestatic 301	com/tencent/bugly/crashreport/common/info/b:b	()Ljava/lang/String;
    //   484: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_2
    //   489: ldc_w 307
    //   492: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_2
    //   497: invokestatic 309	com/tencent/bugly/crashreport/common/info/b:c	()I
    //   500: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload_0
    //   505: aload_2
    //   506: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: putfield 316	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   512: aload_1
    //   513: invokestatic 319	com/tencent/bugly/crashreport/common/info/AppInfo:d	(Landroid/content/Context;)Ljava/util/Map;
    //   516: astore_2
    //   517: aload_2
    //   518: ifnull +197 -> 715
    //   521: aload_0
    //   522: aload_2
    //   523: invokestatic 322	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Ljava/util/Map;)Ljava/util/List;
    //   526: putfield 159	com/tencent/bugly/crashreport/common/info/a:n	Ljava/util/List;
    //   529: aload_2
    //   530: ldc_w 324
    //   533: invokeinterface 330 2 0
    //   538: checkcast 332	java/lang/String
    //   541: astore_3
    //   542: aload_3
    //   543: ifnull +16 -> 559
    //   546: aload_0
    //   547: aload_3
    //   548: putfield 143	com/tencent/bugly/crashreport/common/info/a:V	Ljava/lang/String;
    //   551: aload_0
    //   552: ldc_w 334
    //   555: aload_3
    //   556: invokevirtual 337	com/tencent/bugly/crashreport/common/info/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_2
    //   560: ldc_w 339
    //   563: invokeinterface 330 2 0
    //   568: checkcast 332	java/lang/String
    //   571: astore_3
    //   572: aload_3
    //   573: ifnull +8 -> 581
    //   576: aload_0
    //   577: aload_3
    //   578: putfield 139	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   581: aload_2
    //   582: ldc_w 341
    //   585: invokeinterface 330 2 0
    //   590: checkcast 332	java/lang/String
    //   593: astore_3
    //   594: aload_3
    //   595: ifnull +8 -> 603
    //   598: aload_0
    //   599: aload_3
    //   600: putfield 145	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   603: aload_2
    //   604: ldc_w 343
    //   607: invokeinterface 330 2 0
    //   612: checkcast 332	java/lang/String
    //   615: astore_3
    //   616: aload_3
    //   617: ifnull +14 -> 631
    //   620: aload_0
    //   621: aload_3
    //   622: ldc_w 345
    //   625: invokevirtual 349	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   628: putfield 181	com/tencent/bugly/crashreport/common/info/a:t	Z
    //   631: aload_2
    //   632: ldc_w 351
    //   635: invokeinterface 330 2 0
    //   640: checkcast 332	java/lang/String
    //   643: astore_3
    //   644: aload_3
    //   645: ifnull +8 -> 653
    //   648: aload_0
    //   649: aload_3
    //   650: putfield 187	com/tencent/bugly/crashreport/common/info/a:w	Ljava/lang/String;
    //   653: aload_2
    //   654: ldc_w 353
    //   657: invokeinterface 330 2 0
    //   662: checkcast 332	java/lang/String
    //   665: astore_3
    //   666: aload_3
    //   667: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +8 -> 678
    //   673: aload_3
    //   674: invokestatic 363	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   677: pop
    //   678: aload_2
    //   679: ldc_w 365
    //   682: invokeinterface 330 2 0
    //   687: checkcast 332	java/lang/String
    //   690: astore_2
    //   691: aload_2
    //   692: ifnull +23 -> 715
    //   695: aload_0
    //   696: aload_2
    //   697: putfield 189	com/tencent/bugly/crashreport/common/info/a:x	Ljava/lang/String;
    //   700: goto +15 -> 715
    //   703: astore_2
    //   704: aload_2
    //   705: invokestatic 267	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   708: ifne +7 -> 715
    //   711: aload_2
    //   712: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   715: aload_1
    //   716: ldc_w 367
    //   719: invokevirtual 373	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   722: invokevirtual 379	java/io/File:exists	()Z
    //   725: ifne +33 -> 758
    //   728: aload_0
    //   729: iconst_1
    //   730: putfield 193	com/tencent/bugly/crashreport/common/info/a:z	Z
    //   733: ldc_w 381
    //   736: iconst_0
    //   737: anewarray 4	java/lang/Object
    //   740: invokestatic 384	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   743: pop
    //   744: goto +14 -> 758
    //   747: astore_2
    //   748: getstatic 388	com/tencent/bugly/b:c	Z
    //   751: ifeq +7 -> 758
    //   754: aload_2
    //   755: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   758: aload_0
    //   759: ldc_w 390
    //   762: aload_1
    //   763: invokestatic 393	com/tencent/bugly/proguard/ab:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   766: putfield 395	com/tencent/bugly/crashreport/common/info/a:E	Landroid/content/SharedPreferences;
    //   769: aload_0
    //   770: ldc_w 397
    //   773: aload_1
    //   774: invokestatic 393	com/tencent/bugly/proguard/ab:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   777: putfield 399	com/tencent/bugly/crashreport/common/info/a:ag	Landroid/content/SharedPreferences;
    //   780: aload_0
    //   781: aload_1
    //   782: invokestatic 400	com/tencent/bugly/crashreport/common/info/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   785: putfield 131	com/tencent/bugly/crashreport/common/info/a:R	Ljava/lang/String;
    //   788: aload_0
    //   789: invokespecial 402	com/tencent/bugly/crashreport/common/info/a:J	()V
    //   792: ldc_w 404
    //   795: iconst_0
    //   796: anewarray 4	java/lang/Object
    //   799: invokestatic 384	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   802: pop
    //   803: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	this	a
    //   0	804	1	paramContext	Context
    //   397	22	2	localPackageInfo	android.content.pm.PackageInfo
    //   431	9	2	localThrowable1	Throwable
    //   479	218	2	localObject1	Object
    //   703	9	2	localThrowable2	Throwable
    //   747	8	2	localObject2	Object
    //   406	268	3	str	String
    // Exception table:
    //   from	to	target	type
    //   402	428	431	finally
    //   521	542	703	finally
    //   546	559	703	finally
    //   559	572	703	finally
    //   576	581	703	finally
    //   581	594	703	finally
    //   598	603	703	finally
    //   603	616	703	finally
    //   620	631	703	finally
    //   631	644	703	finally
    //   648	653	703	finally
    //   653	678	703	finally
    //   678	691	703	finally
    //   695	700	703	finally
    //   715	744	747	finally
  }
  
  public static int G()
  {
    return b.c();
  }
  
  @Deprecated
  public static boolean H()
  {
    y.a("Detect if the emulator is unavailable", new Object[0]);
    return false;
  }
  
  @Deprecated
  public static boolean I()
  {
    y.a("Detect if the device hook is unavailable", new Object[0]);
    return false;
  }
  
  private void J()
  {
    try
    {
      Iterator localIterator = this.ag.getAll().entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        y.c("put reserved request data from sp, key:%s value:%s", new Object[] { localEntry.getKey(), localEntry.getValue() });
        a((String)localEntry.getKey(), localEntry.getValue().toString(), false);
      }
      localIterator = F.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        y.c("put reserved request data from cache, key:%s value:%s", new Object[] { localEntry.getKey(), localEntry.getValue() });
        a((String)localEntry.getKey(), (String)localEntry.getValue(), true);
      }
      F.clear();
      return;
    }
    finally
    {
      y.b(localThrowable);
    }
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (aa == null) {
        aa = new a(paramContext);
      }
      paramContext = aa;
      return paramContext;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (ab.a(paramString1))
    {
      y.d("key should not be empty %s", new Object[] { paramString1 });
      return;
    }
    y.c("putExtraRequestData key:%s value:%s save:%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    synchronized (this.aq)
    {
      if (TextUtils.isEmpty(paramString2)) {
        this.ae.remove(paramString1);
      }
      for (paramString1 = this.ag.edit().remove(paramString1);; paramString1 = this.ag.edit().putString(paramString1, paramString2))
      {
        paramString1.apply();
        break;
        this.ae.put(paramString1, paramString2);
        if (!paramBoolean) {
          break;
        }
      }
      return;
    }
  }
  
  public static a b()
  {
    try
    {
      a locala = aa;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static String r()
  {
    return "";
  }
  
  public final Set<String> A()
  {
    synchronized (this.am)
    {
      Set localSet = this.ad.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> B()
  {
    synchronized (this.aq)
    {
      if (this.ae.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ae);
      return localHashMap;
    }
  }
  
  public final Map<String, String> C()
  {
    synchronized (this.an)
    {
      if (this.af.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.af);
      return localHashMap;
    }
  }
  
  public final int D()
  {
    synchronized (this.ao)
    {
      int i1 = this.ab;
      return i1;
    }
  }
  
  public final int E()
  {
    return this.ac;
  }
  
  public final Map<String, PlugInBean> F()
  {
    return null;
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.ao)
    {
      int i1 = this.ab;
      if (i1 != paramInt)
      {
        this.ab = paramInt;
        y.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ab) });
      }
      return;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    y.c("setActivityForeState, hash:%s isFore:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ar.add(Integer.valueOf(paramInt));
    }
    else
    {
      this.ar.remove(Integer.valueOf(paramInt));
      this.ar.remove(Integer.valueOf(0));
    }
    com.tencent.bugly.crashreport.a locala = this.D;
    if (locala != null)
    {
      paramBoolean = bool;
      if (this.ar.size() > 0) {
        paramBoolean = true;
      }
      locala.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final void a(String paramString)
  {
    this.V = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      synchronized (this.al)
      {
        this.A.put(paramString1, paramString2);
        return;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ah = paramBoolean1;
    this.ai = paramBoolean2;
  }
  
  public final boolean a()
  {
    boolean bool;
    if (this.ar.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    y.c("isAppForeground:%s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final void b(int paramInt)
  {
    paramInt = this.ac;
    if (paramInt != 24096)
    {
      this.ac = 24096;
      y.a("server scene tag %d changed to tag %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ac) });
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.ap;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      paramString = new StringBuilder();
      paramString.append(str);
      this.K = paramString.toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((!ab.a(paramString1)) && (!ab.a(paramString2))) {
      synchronized (this.am)
      {
        this.ad.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    y.d("key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
  }
  
  public final void b(boolean paramBoolean)
  {
    this.aj = paramBoolean;
  }
  
  public final String c()
  {
    return this.f;
  }
  
  public final void c(String paramString)
  {
    this.J = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      ab.b("deviceId", paramString);
    }
    synchronized (this.aq)
    {
      this.ae.put("E8", paramString);
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if ((!ab.a(paramString1)) && (!ab.a(paramString2))) {
      synchronized (this.an)
      {
        this.af.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    y.d("server key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
  }
  
  public final void d()
  {
    synchronized (this.ak)
    {
      this.H = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void d(String paramString)
  {
    y.a("change deviceModel，old:%s new:%s", new Object[] { this.I, paramString });
    this.I = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      ab.b("deviceModel", paramString);
    }
  }
  
  public final String e()
  {
    synchronized (this.ak)
    {
      if (this.H == null) {
        synchronized (this.ak)
        {
          this.H = UUID.randomUUID().toString();
        }
      }
      ??? = this.H;
      return ???;
    }
  }
  
  public final void e(String paramString) {}
  
  public final String f()
  {
    if (!ab.a(null)) {
      return null;
    }
    return this.V;
  }
  
  public final void f(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      this.L = localStringBuilder.toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String g()
  {
    synchronized (this.ap)
    {
      String str = this.K;
      return str;
    }
  }
  
  public final void g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.Q = paramString.trim();
    }
  }
  
  public final String h(String paramString)
  {
    if (ab.a(paramString))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      y.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
      return null;
    }
    synchronized (this.am)
    {
      paramString = (String)this.ad.remove(paramString);
      return paramString;
    }
  }
  
  public final boolean h()
  {
    return this.ah;
  }
  
  public final String i(String paramString)
  {
    if (ab.a(paramString))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      y.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
      return null;
    }
    synchronized (this.am)
    {
      paramString = (String)this.ad.get(paramString);
      return paramString;
    }
  }
  
  public final boolean i()
  {
    return this.ai;
  }
  
  public final boolean j()
  {
    return this.aj;
  }
  
  public final String k()
  {
    Object localObject = this.J;
    if (localObject != null) {
      return localObject;
    }
    localObject = ab.c("deviceId", null);
    this.J = ((String)localObject);
    if (localObject != null) {
      return localObject;
    }
    if (TextUtils.isEmpty(this.M)) {
      this.M = ab.c("androidid", null);
    }
    localObject = this.M;
    this.J = ((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      String str = UUID.randomUUID().toString();
      localObject = str;
      if (!ab.a(str)) {
        localObject = str.replaceAll("-", "");
      }
      this.J = ((String)localObject);
    }
    localObject = this.J;
    if (localObject != null)
    {
      ab.b("deviceId", (String)localObject);
      return this.J;
    }
    return "";
  }
  
  public final String l()
  {
    String str = this.I;
    if (str != null) {
      return str;
    }
    str = ab.c("deviceModel", null);
    this.I = str;
    if (str != null)
    {
      y.c("collect device model from sp:%s", new Object[] { str });
      return this.I;
    }
    if (!this.T)
    {
      y.c("not allow collect device model", new Object[0]);
      return "fail";
    }
    str = b.a();
    this.I = str;
    y.c("collect device model:%s", new Object[] { str });
    ab.b("deviceModel", this.I);
    return this.I;
  }
  
  public final String m()
  {
    try
    {
      String str = this.L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long n()
  {
    if (this.N <= 0L) {
      this.N = b.d();
    }
    return this.N;
  }
  
  public final long o()
  {
    if (this.O <= 0L) {
      this.O = b.i();
    }
    return this.O;
  }
  
  public final long p()
  {
    if (this.P <= 0L) {
      this.P = b.k();
    }
    return this.P;
  }
  
  public final String q()
  {
    if (!TextUtils.isEmpty(this.Q))
    {
      y.c("get cpu type from so:%s", new Object[] { this.Q });
      return this.Q;
    }
    if (!TextUtils.isEmpty(this.R))
    {
      y.c("get cpu type from lib dir:%s", new Object[] { this.R });
      return this.R;
    }
    return "unknown";
  }
  
  /* Error */
  public final String s()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 241	com/tencent/bugly/crashreport/common/info/a:G	Landroid/content/Context;
    //   4: ldc_w 609
    //   7: iconst_0
    //   8: invokevirtual 613	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: invokeinterface 418 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 615 1 0
    //   23: ifne +92 -> 115
    //   26: aload_0
    //   27: getfield 214	com/tencent/bugly/crashreport/common/info/a:al	Ljava/lang/Object;
    //   30: astore_1
    //   31: aload_1
    //   32: monitorenter
    //   33: aload_2
    //   34: invokeinterface 422 1 0
    //   39: invokeinterface 428 1 0
    //   44: astore_2
    //   45: aload_2
    //   46: invokeinterface 433 1 0
    //   51: ifeq +48 -> 99
    //   54: aload_2
    //   55: invokeinterface 437 1 0
    //   60: checkcast 439	java/util/Map$Entry
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 195	com/tencent/bugly/crashreport/common/info/a:A	Ljava/util/HashMap;
    //   68: aload_3
    //   69: invokeinterface 444 1 0
    //   74: aload_3
    //   75: invokeinterface 447 1 0
    //   80: invokevirtual 448	java/lang/Object:toString	()Ljava/lang/String;
    //   83: invokevirtual 537	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: goto -42 -> 45
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 267	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   95: pop
    //   96: goto -51 -> 45
    //   99: aload_1
    //   100: monitorexit
    //   101: goto +14 -> 115
    //   104: astore_2
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: aload_1
    //   111: invokestatic 267	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 195	com/tencent/bugly/crashreport/common/info/a:A	Ljava/util/HashMap;
    //   119: invokevirtual 616	java/util/HashMap:isEmpty	()Z
    //   122: ifne +132 -> 254
    //   125: new 291	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 546	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 195	com/tencent/bugly/crashreport/common/info/a:A	Ljava/util/HashMap;
    //   137: invokevirtual 617	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   140: invokeinterface 428 1 0
    //   145: astore_2
    //   146: aload_2
    //   147: invokeinterface 433 1 0
    //   152: ifeq +68 -> 220
    //   155: aload_2
    //   156: invokeinterface 437 1 0
    //   161: checkcast 439	java/util/Map$Entry
    //   164: astore_3
    //   165: aload_1
    //   166: ldc_w 619
    //   169: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: aload_3
    //   175: invokeinterface 444 1 0
    //   180: checkcast 332	java/lang/String
    //   183: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: ldc_w 621
    //   191: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload_3
    //   197: invokeinterface 447 1 0
    //   202: checkcast 332	java/lang/String
    //   205: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: ldc_w 623
    //   213: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: goto -71 -> 146
    //   220: ldc_w 625
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 384	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   237: pop
    //   238: aload_0
    //   239: ldc_w 627
    //   242: aload_1
    //   243: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 337	com/tencent/bugly/crashreport/common/info/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_1
    //   250: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: areturn
    //   254: ldc_w 629
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 384	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   264: pop
    //   265: aconst_null
    //   266: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	a
    //   30	76	1	localObject1	Object
    //   109	2	1	localThrowable1	Throwable
    //   132	118	1	localStringBuilder	StringBuilder
    //   16	39	2	localObject2	Object
    //   104	4	2	localObject3	Object
    //   145	11	2	localIterator	Iterator
    //   63	12	3	localEntry1	Map.Entry
    //   90	2	3	localThrowable2	Throwable
    //   164	33	3	localEntry2	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   64	87	90	finally
    //   33	45	104	finally
    //   45	64	104	finally
    //   91	96	104	finally
    //   99	101	104	finally
    //   0	33	109	finally
    //   105	109	109	finally
  }
  
  public final Map<String, PlugInBean> t()
  {
    return null;
  }
  
  public final String u()
  {
    if (this.U == null) {
      this.U = b.m();
    }
    return this.U;
  }
  
  public final Boolean v()
  {
    if (this.W == null) {
      this.W = Boolean.valueOf(b.n());
    }
    return this.W;
  }
  
  public final String w()
  {
    if (this.X == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b.c(this.G));
      localObject = ((StringBuilder)localObject).toString();
      this.X = ((String)localObject);
      y.a("ROM ID: %s", new Object[] { localObject });
    }
    return this.X;
  }
  
  public final Map<String, String> x()
  {
    synchronized (this.am)
    {
      if (this.ad.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ad);
      return localHashMap;
    }
  }
  
  public final void y()
  {
    synchronized (this.am)
    {
      this.ad.clear();
      return;
    }
  }
  
  public final int z()
  {
    synchronized (this.am)
    {
      int i1 = this.ad.size();
      return i1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */