package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager.CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.e.h;
import com.baidu.location.f;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
public class b
{
  public static int a;
  public static int b;
  private static b c;
  private static String k;
  private static Class<?> l;
  private TelephonyManager d = null;
  private a e = new a();
  private a f = null;
  private List<a> g = null;
  private b h = null;
  private boolean i = false;
  private boolean j = false;
  private a m;
  private long n = 0L;
  private Handler o = new Handler();
  private boolean p = false;
  private int q = 30;
  
  private b()
  {
    if (Build.VERSION.SDK_INT >= 30) {
      this.p = h.b("android.telephony.TelephonyManager$CellInfoCallback");
    }
  }
  
  private static int a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 2147483647) {
      i1 = -1;
    }
    return i1;
  }
  
  public static int a(CellIdentityNr paramCellIdentityNr)
  {
    try
    {
      int i1 = h.a(paramCellIdentityNr, "getHwTac");
      return i1;
    }
    finally
    {
      label9:
      break label9;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (paramString.contains("mNrTac"))
      {
        paramString = paramString.replace(" ", "");
        paramString = Pattern.compile("mNrTac=(.+?)\\}").matcher(paramString);
      }
    }
    for (;;)
    {
      i1 = -1;
      for (;;)
      {
        String str;
        if (paramString.find())
        {
          if (paramString.groupCount() < 1) {
            continue;
          }
          str = paramString.group(1);
        }
        try
        {
          i1 = Integer.parseInt(str);
        }
        finally {}
      }
      return i1;
    }
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public static a a(CellInfo paramCellInfo, a parama, TelephonyManager paramTelephonyManager)
  {
    // Byte code:
    //   0: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_3
    //   4: iload_3
    //   5: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8: invokevirtual 164	java/lang/Integer:intValue	()I
    //   11: istore 5
    //   13: aconst_null
    //   14: astore 11
    //   16: iload 5
    //   18: bipush 17
    //   20: if_icmpge +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: new 60	com/baidu/location/c/a
    //   28: dup
    //   29: invokespecial 61	com/baidu/location/c/a:<init>	()V
    //   32: astore 12
    //   34: aload_0
    //   35: instanceof 166
    //   38: ifeq +107 -> 145
    //   41: aload_0
    //   42: checkcast 166	android/telephony/CellInfoGsm
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 170	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   50: astore_2
    //   51: aload 12
    //   53: aload_2
    //   54: invokevirtual 175	android/telephony/CellIdentityGsm:getMcc	()I
    //   57: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   60: putfield 179	com/baidu/location/c/a:c	I
    //   63: aload 12
    //   65: aload_2
    //   66: invokevirtual 182	android/telephony/CellIdentityGsm:getMnc	()I
    //   69: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   72: putfield 184	com/baidu/location/c/a:d	I
    //   75: aload 12
    //   77: aload_2
    //   78: invokevirtual 187	android/telephony/CellIdentityGsm:getLac	()I
    //   81: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   84: putfield 189	com/baidu/location/c/a:a	I
    //   87: aload 12
    //   89: aload_2
    //   90: invokevirtual 192	android/telephony/CellIdentityGsm:getCid	()I
    //   93: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   96: i2l
    //   97: putfield 194	com/baidu/location/c/a:b	J
    //   100: aload 12
    //   102: bipush 103
    //   104: putfield 197	com/baidu/location/c/a:i	C
    //   107: aload 12
    //   109: aload_1
    //   110: invokevirtual 201	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   113: invokevirtual 206	android/telephony/CellSignalStrengthGsm:getAsuLevel	()I
    //   116: putfield 208	com/baidu/location/c/a:h	I
    //   119: aload 12
    //   121: iconst_2
    //   122: putfield 210	com/baidu/location/c/a:k	I
    //   125: iload_3
    //   126: bipush 28
    //   128: if_icmplt +12 -> 140
    //   131: aload 12
    //   133: aload_0
    //   134: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   137: putfield 217	com/baidu/location/c/a:j	I
    //   140: iconst_1
    //   141: istore_3
    //   142: goto +303 -> 445
    //   145: aload_0
    //   146: instanceof 219
    //   149: ifeq +194 -> 343
    //   152: aload_0
    //   153: checkcast 219	android/telephony/CellInfoCdma
    //   156: astore 13
    //   158: aload 13
    //   160: invokevirtual 222	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   163: astore 14
    //   165: aload 12
    //   167: aload 14
    //   169: invokevirtual 227	android/telephony/CellIdentityCdma:getLatitude	()I
    //   172: putfield 229	com/baidu/location/c/a:e	I
    //   175: aload 12
    //   177: aload 14
    //   179: invokevirtual 232	android/telephony/CellIdentityCdma:getLongitude	()I
    //   182: putfield 234	com/baidu/location/c/a:f	I
    //   185: aload 12
    //   187: aload 14
    //   189: invokevirtual 237	android/telephony/CellIdentityCdma:getSystemId	()I
    //   192: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   195: putfield 184	com/baidu/location/c/a:d	I
    //   198: aload 12
    //   200: aload 14
    //   202: invokevirtual 240	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   205: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   208: putfield 189	com/baidu/location/c/a:a	I
    //   211: aload 12
    //   213: aload 14
    //   215: invokevirtual 243	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   218: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   221: i2l
    //   222: putfield 194	com/baidu/location/c/a:b	J
    //   225: aload 12
    //   227: bipush 99
    //   229: putfield 197	com/baidu/location/c/a:i	C
    //   232: aload 12
    //   234: aload 13
    //   236: invokevirtual 246	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   239: invokevirtual 251	android/telephony/CellSignalStrengthCdma:getCdmaDbm	()I
    //   242: putfield 208	com/baidu/location/c/a:h	I
    //   245: aload 12
    //   247: iconst_1
    //   248: putfield 210	com/baidu/location/c/a:k	I
    //   251: iload_3
    //   252: bipush 28
    //   254: if_icmplt +12 -> 266
    //   257: aload 12
    //   259: aload_0
    //   260: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   263: putfield 217	com/baidu/location/c/a:j	I
    //   266: aload_1
    //   267: ifnull +21 -> 288
    //   270: aload_1
    //   271: getfield 179	com/baidu/location/c/a:c	I
    //   274: istore_3
    //   275: iload_3
    //   276: ifle +12 -> 288
    //   279: aload 12
    //   281: iload_3
    //   282: putfield 179	com/baidu/location/c/a:c	I
    //   285: goto -145 -> 140
    //   288: aload_2
    //   289: invokevirtual 257	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +40 -> 334
    //   297: aload_1
    //   298: invokevirtual 260	java/lang/String:length	()I
    //   301: ifle +33 -> 334
    //   304: aload_1
    //   305: invokevirtual 260	java/lang/String:length	()I
    //   308: iconst_3
    //   309: if_icmplt +25 -> 334
    //   312: aload_1
    //   313: iconst_0
    //   314: iconst_3
    //   315: invokevirtual 264	java/lang/String:substring	(II)Ljava/lang/String;
    //   318: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   321: invokevirtual 164	java/lang/Integer:intValue	()I
    //   324: istore 4
    //   326: iload 4
    //   328: istore_3
    //   329: iload 4
    //   331: ifge +5 -> 336
    //   334: iconst_m1
    //   335: istore_3
    //   336: iload_3
    //   337: ifle -197 -> 140
    //   340: goto -61 -> 279
    //   343: aload_0
    //   344: instanceof 269
    //   347: ifeq +96 -> 443
    //   350: aload_0
    //   351: checkcast 269	android/telephony/CellInfoLte
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 272	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   359: astore_2
    //   360: aload 12
    //   362: aload_2
    //   363: invokevirtual 275	android/telephony/CellIdentityLte:getMcc	()I
    //   366: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   369: putfield 179	com/baidu/location/c/a:c	I
    //   372: aload 12
    //   374: aload_2
    //   375: invokevirtual 276	android/telephony/CellIdentityLte:getMnc	()I
    //   378: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   381: putfield 184	com/baidu/location/c/a:d	I
    //   384: aload 12
    //   386: aload_2
    //   387: invokevirtual 279	android/telephony/CellIdentityLte:getTac	()I
    //   390: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   393: putfield 189	com/baidu/location/c/a:a	I
    //   396: aload 12
    //   398: aload_2
    //   399: invokevirtual 282	android/telephony/CellIdentityLte:getCi	()I
    //   402: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   405: i2l
    //   406: putfield 194	com/baidu/location/c/a:b	J
    //   409: aload 12
    //   411: bipush 103
    //   413: putfield 197	com/baidu/location/c/a:i	C
    //   416: aload 12
    //   418: aload_1
    //   419: invokevirtual 285	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   422: invokevirtual 288	android/telephony/CellSignalStrengthLte:getAsuLevel	()I
    //   425: putfield 208	com/baidu/location/c/a:h	I
    //   428: aload 12
    //   430: iconst_3
    //   431: putfield 210	com/baidu/location/c/a:k	I
    //   434: iload_3
    //   435: bipush 28
    //   437: if_icmplt -297 -> 140
    //   440: goto -309 -> 131
    //   443: iconst_0
    //   444: istore_3
    //   445: iload 5
    //   447: bipush 18
    //   449: if_icmplt +594 -> 1043
    //   452: iload_3
    //   453: ifne +590 -> 1043
    //   456: aload_0
    //   457: instanceof 290
    //   460: ifeq +108 -> 568
    //   463: aload_0
    //   464: checkcast 290	android/telephony/CellInfoWcdma
    //   467: invokevirtual 293	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   470: astore_1
    //   471: aload 12
    //   473: aload_1
    //   474: invokevirtual 296	android/telephony/CellIdentityWcdma:getMcc	()I
    //   477: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   480: putfield 179	com/baidu/location/c/a:c	I
    //   483: aload 12
    //   485: aload_1
    //   486: invokevirtual 297	android/telephony/CellIdentityWcdma:getMnc	()I
    //   489: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   492: putfield 184	com/baidu/location/c/a:d	I
    //   495: aload 12
    //   497: aload_1
    //   498: invokevirtual 298	android/telephony/CellIdentityWcdma:getLac	()I
    //   501: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   504: putfield 189	com/baidu/location/c/a:a	I
    //   507: aload 12
    //   509: aload_1
    //   510: invokevirtual 299	android/telephony/CellIdentityWcdma:getCid	()I
    //   513: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   516: i2l
    //   517: putfield 194	com/baidu/location/c/a:b	J
    //   520: aload 12
    //   522: bipush 103
    //   524: putfield 197	com/baidu/location/c/a:i	C
    //   527: aload 12
    //   529: aload_0
    //   530: checkcast 290	android/telephony/CellInfoWcdma
    //   533: invokevirtual 302	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   536: invokevirtual 305	android/telephony/CellSignalStrengthWcdma:getAsuLevel	()I
    //   539: putfield 208	com/baidu/location/c/a:h	I
    //   542: aload 12
    //   544: iconst_4
    //   545: putfield 210	com/baidu/location/c/a:k	I
    //   548: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   551: bipush 28
    //   553: if_icmplt +490 -> 1043
    //   556: aload 12
    //   558: aload_0
    //   559: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   562: putfield 217	com/baidu/location/c/a:j	I
    //   565: goto +478 -> 1043
    //   568: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   571: bipush 29
    //   573: if_icmplt +470 -> 1043
    //   576: aload_0
    //   577: instanceof 307
    //   580: ifeq +123 -> 703
    //   583: aload_0
    //   584: checkcast 307	android/telephony/CellInfoTdscdma
    //   587: invokevirtual 310	android/telephony/CellInfoTdscdma:getCellIdentity	()Landroid/telephony/CellIdentityTdscdma;
    //   590: astore_1
    //   591: aload_1
    //   592: invokevirtual 315	android/telephony/CellIdentityTdscdma:getMccString	()Ljava/lang/String;
    //   595: astore_2
    //   596: aload_2
    //   597: ifnull +18 -> 615
    //   600: aload 12
    //   602: aload_1
    //   603: invokevirtual 315	android/telephony/CellIdentityTdscdma:getMccString	()Ljava/lang/String;
    //   606: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   609: invokevirtual 164	java/lang/Integer:intValue	()I
    //   612: putfield 179	com/baidu/location/c/a:c	I
    //   615: aload_1
    //   616: invokevirtual 318	android/telephony/CellIdentityTdscdma:getMncString	()Ljava/lang/String;
    //   619: astore_2
    //   620: aload_2
    //   621: ifnull +18 -> 639
    //   624: aload 12
    //   626: aload_1
    //   627: invokevirtual 318	android/telephony/CellIdentityTdscdma:getMncString	()Ljava/lang/String;
    //   630: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   633: invokevirtual 164	java/lang/Integer:intValue	()I
    //   636: putfield 184	com/baidu/location/c/a:d	I
    //   639: aload 12
    //   641: aload_1
    //   642: invokevirtual 319	android/telephony/CellIdentityTdscdma:getLac	()I
    //   645: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   648: putfield 189	com/baidu/location/c/a:a	I
    //   651: aload 12
    //   653: aload_1
    //   654: invokevirtual 320	android/telephony/CellIdentityTdscdma:getCid	()I
    //   657: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   660: i2l
    //   661: putfield 194	com/baidu/location/c/a:b	J
    //   664: aload 12
    //   666: bipush 103
    //   668: putfield 197	com/baidu/location/c/a:i	C
    //   671: aload 12
    //   673: aload_0
    //   674: checkcast 307	android/telephony/CellInfoTdscdma
    //   677: invokevirtual 323	android/telephony/CellInfoTdscdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthTdscdma;
    //   680: invokevirtual 326	android/telephony/CellSignalStrengthTdscdma:getAsuLevel	()I
    //   683: putfield 208	com/baidu/location/c/a:h	I
    //   686: aload 12
    //   688: iconst_5
    //   689: putfield 210	com/baidu/location/c/a:k	I
    //   692: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   695: bipush 28
    //   697: if_icmplt +346 -> 1043
    //   700: goto -144 -> 556
    //   703: aload_0
    //   704: instanceof 328
    //   707: istore 6
    //   709: iload 6
    //   711: ifeq +332 -> 1043
    //   714: aload_0
    //   715: checkcast 328	android/telephony/CellInfoNr
    //   718: invokevirtual 331	android/telephony/CellInfoNr:getCellIdentity	()Landroid/telephony/CellIdentity;
    //   721: checkcast 333	android/telephony/CellIdentityNr
    //   724: astore_1
    //   725: goto +11 -> 736
    //   728: astore_1
    //   729: aload_1
    //   730: invokevirtual 338	java/lang/Throwable:printStackTrace	()V
    //   733: aload 11
    //   735: astore_1
    //   736: aload_1
    //   737: ifnull +306 -> 1043
    //   740: aload_1
    //   741: invokevirtual 339	android/telephony/CellIdentityNr:getMccString	()Ljava/lang/String;
    //   744: astore_2
    //   745: aload_2
    //   746: ifnull +18 -> 764
    //   749: aload 12
    //   751: aload_1
    //   752: invokevirtual 339	android/telephony/CellIdentityNr:getMccString	()Ljava/lang/String;
    //   755: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   758: invokevirtual 164	java/lang/Integer:intValue	()I
    //   761: putfield 179	com/baidu/location/c/a:c	I
    //   764: aload_1
    //   765: invokevirtual 340	android/telephony/CellIdentityNr:getMncString	()Ljava/lang/String;
    //   768: astore_2
    //   769: aload_2
    //   770: ifnull +18 -> 788
    //   773: aload 12
    //   775: aload_1
    //   776: invokevirtual 340	android/telephony/CellIdentityNr:getMncString	()Ljava/lang/String;
    //   779: invokestatic 267	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   782: invokevirtual 164	java/lang/Integer:intValue	()I
    //   785: putfield 184	com/baidu/location/c/a:d	I
    //   788: aload_1
    //   789: invokevirtual 341	android/telephony/CellIdentityNr:getTac	()I
    //   792: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   795: istore_3
    //   796: aload 12
    //   798: iload_3
    //   799: putfield 189	com/baidu/location/c/a:a	I
    //   802: iload_3
    //   803: iconst_m1
    //   804: if_icmpne +15 -> 819
    //   807: aload 12
    //   809: aload_1
    //   810: invokestatic 343	com/baidu/location/c/b:a	(Landroid/telephony/CellIdentityNr;)I
    //   813: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   816: putfield 189	com/baidu/location/c/a:a	I
    //   819: aload 12
    //   821: getfield 189	com/baidu/location/c/a:a	I
    //   824: istore_3
    //   825: iload_3
    //   826: iconst_m1
    //   827: if_icmpne +18 -> 845
    //   830: aload 12
    //   832: aload_1
    //   833: invokevirtual 346	android/telephony/CellIdentityNr:toString	()Ljava/lang/String;
    //   836: invokestatic 348	com/baidu/location/c/b:a	(Ljava/lang/String;)I
    //   839: invokestatic 177	com/baidu/location/c/b:a	(I)I
    //   842: putfield 189	com/baidu/location/c/a:a	I
    //   845: aload 12
    //   847: getfield 189	com/baidu/location/c/a:a	I
    //   850: iconst_m1
    //   851: if_icmpne +12 -> 863
    //   854: aload 12
    //   856: aload_1
    //   857: invokevirtual 341	android/telephony/CellIdentityNr:getTac	()I
    //   860: putfield 189	com/baidu/location/c/a:a	I
    //   863: aload_1
    //   864: invokevirtual 352	android/telephony/CellIdentityNr:getNci	()J
    //   867: ldc2_w 353
    //   870: lcmp
    //   871: ifeq +12 -> 883
    //   874: aload 12
    //   876: aload_1
    //   877: invokevirtual 352	android/telephony/CellIdentityNr:getNci	()J
    //   880: putfield 194	com/baidu/location/c/a:b	J
    //   883: aload 12
    //   885: bipush 103
    //   887: putfield 197	com/baidu/location/c/a:i	C
    //   890: aload 12
    //   892: bipush 6
    //   894: putfield 210	com/baidu/location/c/a:k	I
    //   897: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   900: bipush 28
    //   902: if_icmplt +12 -> 914
    //   905: aload 12
    //   907: aload_0
    //   908: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   911: putfield 217	com/baidu/location/c/a:j	I
    //   914: aload_0
    //   915: checkcast 328	android/telephony/CellInfoNr
    //   918: invokevirtual 357	android/telephony/CellInfoNr:getCellSignalStrength	()Landroid/telephony/CellSignalStrength;
    //   921: checkcast 359	android/telephony/CellSignalStrengthNr
    //   924: astore_1
    //   925: aload 12
    //   927: aload_1
    //   928: invokevirtual 360	android/telephony/CellSignalStrengthNr:getAsuLevel	()I
    //   931: putfield 208	com/baidu/location/c/a:h	I
    //   934: aload 12
    //   936: invokevirtual 362	com/baidu/location/c/a:b	()Z
    //   939: ifeq +104 -> 1043
    //   942: aload 12
    //   944: getstatic 368	java/util/Locale:US	Ljava/util/Locale;
    //   947: ldc_w 370
    //   950: bipush 8
    //   952: anewarray 4	java/lang/Object
    //   955: dup
    //   956: iconst_0
    //   957: aload_1
    //   958: invokevirtual 373	android/telephony/CellSignalStrengthNr:getCsiRsrp	()I
    //   961: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   964: aastore
    //   965: dup
    //   966: iconst_1
    //   967: aload_1
    //   968: invokevirtual 376	android/telephony/CellSignalStrengthNr:getCsiRsrq	()I
    //   971: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: aastore
    //   975: dup
    //   976: iconst_2
    //   977: aload_1
    //   978: invokevirtual 379	android/telephony/CellSignalStrengthNr:getCsiSinr	()I
    //   981: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   984: aastore
    //   985: dup
    //   986: iconst_3
    //   987: aload_1
    //   988: invokevirtual 382	android/telephony/CellSignalStrengthNr:getDbm	()I
    //   991: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   994: aastore
    //   995: dup
    //   996: iconst_4
    //   997: aload_1
    //   998: invokevirtual 385	android/telephony/CellSignalStrengthNr:getLevel	()I
    //   1001: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_5
    //   1007: aload_1
    //   1008: invokevirtual 388	android/telephony/CellSignalStrengthNr:getSsRsrp	()I
    //   1011: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1014: aastore
    //   1015: dup
    //   1016: bipush 6
    //   1018: aload_1
    //   1019: invokevirtual 391	android/telephony/CellSignalStrengthNr:getSsRsrq	()I
    //   1022: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1025: aastore
    //   1026: dup
    //   1027: bipush 7
    //   1029: aload_1
    //   1030: invokevirtual 394	android/telephony/CellSignalStrengthNr:getSsSinr	()I
    //   1033: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1036: aastore
    //   1037: invokestatic 398	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1040: putfield 400	com/baidu/location/c/a:o	Ljava/lang/String;
    //   1043: iload 5
    //   1045: bipush 30
    //   1047: if_icmplt +31 -> 1078
    //   1050: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   1053: aload_0
    //   1054: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   1057: lsub
    //   1058: lstore 9
    //   1060: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   1063: lstore 7
    //   1065: aload 12
    //   1067: lload 7
    //   1069: lload 9
    //   1071: lsub
    //   1072: putfield 415	com/baidu/location/c/a:g	J
    //   1075: aload 12
    //   1077: areturn
    //   1078: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   1081: aload_0
    //   1082: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   1085: lsub
    //   1086: ldc2_w 422
    //   1089: ldiv
    //   1090: lstore 9
    //   1092: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   1095: lstore 7
    //   1097: goto -32 -> 1065
    //   1100: aload 12
    //   1102: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   1105: putfield 415	com/baidu/location/c/a:g	J
    //   1108: aload 12
    //   1110: areturn
    //   1111: astore_1
    //   1112: goto -778 -> 334
    //   1115: astore_1
    //   1116: goto -73 -> 1043
    //   1119: astore_2
    //   1120: goto -505 -> 615
    //   1123: astore_2
    //   1124: goto -485 -> 639
    //   1127: astore_2
    //   1128: goto -364 -> 764
    //   1131: astore_2
    //   1132: goto -344 -> 788
    //   1135: astore_2
    //   1136: goto -317 -> 819
    //   1139: astore_2
    //   1140: goto -295 -> 845
    //   1143: astore_0
    //   1144: goto -44 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1147	0	paramCellInfo	CellInfo
    //   0	1147	1	parama	a
    //   0	1147	2	paramTelephonyManager	TelephonyManager
    //   3	825	3	i1	int
    //   324	6	4	i2	int
    //   11	1037	5	i3	int
    //   707	3	6	bool	boolean
    //   1063	33	7	l1	long
    //   1058	33	9	l2	long
    //   14	720	11	localObject	Object
    //   32	1077	12	locala	a
    //   156	79	13	localCellInfoCdma	android.telephony.CellInfoCdma
    //   163	51	14	localCellIdentityCdma	android.telephony.CellIdentityCdma
    // Exception table:
    //   from	to	target	type
    //   714	725	728	finally
    //   288	293	1111	java/lang/Exception
    //   297	326	1111	java/lang/Exception
    //   456	556	1115	java/lang/Exception
    //   556	565	1115	java/lang/Exception
    //   568	596	1115	java/lang/Exception
    //   615	620	1115	java/lang/Exception
    //   639	700	1115	java/lang/Exception
    //   703	709	1115	java/lang/Exception
    //   729	733	1115	java/lang/Exception
    //   740	745	1115	java/lang/Exception
    //   764	769	1115	java/lang/Exception
    //   788	802	1115	java/lang/Exception
    //   819	825	1115	java/lang/Exception
    //   845	863	1115	java/lang/Exception
    //   863	883	1115	java/lang/Exception
    //   883	914	1115	java/lang/Exception
    //   914	1043	1115	java/lang/Exception
    //   600	615	1119	finally
    //   624	639	1123	finally
    //   749	764	1127	finally
    //   773	788	1131	finally
    //   807	819	1135	finally
    //   830	845	1139	finally
    //   1050	1065	1143	java/lang/Error
    //   1065	1075	1143	java/lang/Error
    //   1078	1097	1143	java/lang/Error
  }
  
  private a a(CellLocation paramCellLocation)
  {
    return a(paramCellLocation, false);
  }
  
  private a a(CellLocation paramCellLocation, boolean paramBoolean)
  {
    a locala;
    if (paramCellLocation != null)
    {
      if (this.d == null) {
        return null;
      }
      locala = new a();
      locala.l = 1;
      if (paramBoolean) {
        locala.f();
      }
      locala.g = System.currentTimeMillis();
    }
    try
    {
      localObject = this.d.getNetworkOperator();
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label194;
      }
      i1 = -1;
      if (((String)localObject).length() < 3) {
        break label115;
      }
      i1 = Integer.valueOf(((String)localObject).substring(0, 3)).intValue();
      if (i1 >= 0) {
        break label440;
      }
      i2 = this.e.c;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i1;
        label115:
        char[] arrayOfChar;
        label194:
        label211:
        continue;
        label284:
        label416:
        int i2 = i1;
        label409:
        continue;
        i1 += 1;
      }
    }
    locala.c = i2;
    localObject = ((String)localObject).substring(3);
    if (localObject != null)
    {
      arrayOfChar = ((String)localObject).toCharArray();
      i1 = 0;
      if (i1 < arrayOfChar.length) {
        if (Character.isDigit(arrayOfChar[i1])) {
          break label446;
        }
      }
      i1 = Integer.valueOf(((String)localObject).substring(0, i1)).intValue();
    }
    else
    {
      i2 = i1;
      if (i1 < 0) {
        i2 = this.e.d;
      }
      locala.d = i2;
      a = this.d.getSimState();
      break label211;
      b = 1;
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
        if (l != null) {}
      }
      try
      {
        l = Class.forName("android.telephony.cdma.CdmaCellLocation");
      }
      catch (Exception paramCellLocation)
      {
        break label284;
      }
      l = null;
      return locala;
      localObject = l;
      if ((localObject != null) && (((Class)localObject).isInstance(paramCellLocation))) {}
      try
      {
        i2 = ((CdmaCellLocation)paramCellLocation).getSystemId();
        i1 = i2;
        if (i2 < 0) {
          i1 = this.e.d;
        }
        locala.d = i1;
        locala.b = ((CdmaCellLocation)paramCellLocation).getBaseStationId();
        locala.a = ((CdmaCellLocation)paramCellLocation).getNetworkId();
        i1 = ((CdmaCellLocation)paramCellLocation).getBaseStationLatitude();
        if (i1 < 2147483647) {
          locala.e = i1;
        }
        i1 = ((CdmaCellLocation)paramCellLocation).getBaseStationLongitude();
        if (i1 >= 2147483647) {
          break label416;
        }
        locala.f = i1;
      }
      catch (Exception paramCellLocation)
      {
        break label409;
      }
      b = 3;
      return locala;
      c(locala);
      return locala;
      return null;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static a a(a parama, TelephonyManager paramTelephonyManager, boolean paramBoolean)
  {
    int i1 = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    Object localObject2 = null;
    if (i1 < 17) {
      return null;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        a = paramTelephonyManager.getSimState();
        Object localObject3 = paramTelephonyManager.getAllCellInfo();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((List)localObject3).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = ((List)localObject3).iterator();
            localObject1 = null;
            if (localIterator.hasNext())
            {
              localObject2 = (CellInfo)localIterator.next();
              if (!((CellInfo)localObject2).isRegistered()) {
                continue;
              }
              i1 = 0;
              if (localObject1 != null) {
                i1 = 1;
              }
              localObject3 = a((CellInfo)localObject2, parama, paramTelephonyManager);
              if (localObject3 == null) {
                continue;
              }
              if (!((a)localObject3).b())
              {
                localObject2 = null;
                break label209;
              }
              localObject2 = localObject3;
              if (i1 == 0) {
                break label209;
              }
              localObject2 = localObject3;
              if (localObject1 == null) {
                break label209;
              }
              localObject1.m = ((a)localObject3).i();
              localObject1.n = ((a)localObject3).g();
              localObject2 = localObject3;
              break label209;
            }
            k = a(b(localArrayList));
          }
        }
      }
      finally
      {
        return null;
      }
      label209:
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
    }
  }
  
  public static b a()
  {
    try
    {
      if (c == null) {
        c = new b();
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  /* Error */
  private static e a(CellInfo paramCellInfo, TelephonyManager paramTelephonyManager)
  {
    // Byte code:
    //   0: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_2
    //   4: aload_0
    //   5: instanceof 166
    //   8: istore 4
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 11
    //   16: aconst_null
    //   17: astore 12
    //   19: aconst_null
    //   20: astore 10
    //   22: iload 4
    //   24: ifeq +222 -> 246
    //   27: new 538	com/baidu/location/c/e
    //   30: dup
    //   31: invokespecial 539	com/baidu/location/c/e:<init>	()V
    //   34: astore 9
    //   36: aload_0
    //   37: checkcast 166	android/telephony/CellInfoGsm
    //   40: invokevirtual 170	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   43: astore 11
    //   45: aload 9
    //   47: iconst_1
    //   48: putfield 540	com/baidu/location/c/e:a	I
    //   51: aload_0
    //   52: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   55: ifeq +9 -> 64
    //   58: aload 9
    //   60: iconst_1
    //   61: putfield 541	com/baidu/location/c/e:d	I
    //   64: iload_2
    //   65: bipush 28
    //   67: if_icmplt +35 -> 102
    //   70: aload 9
    //   72: aload 11
    //   74: invokevirtual 542	android/telephony/CellIdentityGsm:getMccString	()Ljava/lang/String;
    //   77: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   80: aload 9
    //   82: aload 11
    //   84: invokevirtual 545	android/telephony/CellIdentityGsm:getMncString	()Ljava/lang/String;
    //   87: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   90: aload 9
    //   92: aload_0
    //   93: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   96: putfield 548	com/baidu/location/c/e:f	I
    //   99: goto +64 -> 163
    //   102: aload 11
    //   104: invokevirtual 175	android/telephony/CellIdentityGsm:getMcc	()I
    //   107: ldc 98
    //   109: if_icmpne +8 -> 117
    //   112: aconst_null
    //   113: astore_1
    //   114: goto +12 -> 126
    //   117: aload 11
    //   119: invokevirtual 175	android/telephony/CellIdentityGsm:getMcc	()I
    //   122: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   125: astore_1
    //   126: aload 9
    //   128: aload_1
    //   129: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   132: aload 11
    //   134: invokevirtual 182	android/telephony/CellIdentityGsm:getMnc	()I
    //   137: ldc 98
    //   139: if_icmpne +9 -> 148
    //   142: aload 10
    //   144: astore_1
    //   145: goto +12 -> 157
    //   148: aload 11
    //   150: invokevirtual 182	android/telephony/CellIdentityGsm:getMnc	()I
    //   153: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   156: astore_1
    //   157: aload 9
    //   159: aload_1
    //   160: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   163: iload_2
    //   164: bipush 30
    //   166: if_icmplt +43 -> 209
    //   169: aload 9
    //   171: astore_1
    //   172: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   175: aload_0
    //   176: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   179: lsub
    //   180: lstore 5
    //   182: aload 9
    //   184: astore_1
    //   185: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   188: lstore 7
    //   190: aload 9
    //   192: astore_1
    //   193: aload 9
    //   195: lload 7
    //   197: lload 5
    //   199: lsub
    //   200: putfield 552	com/baidu/location/c/e:e	J
    //   203: aload 9
    //   205: astore_1
    //   206: goto +38 -> 244
    //   209: aload 9
    //   211: astore_1
    //   212: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   215: aload_0
    //   216: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   219: lsub
    //   220: ldc2_w 422
    //   223: ldiv
    //   224: lstore 5
    //   226: aload 9
    //   228: astore_1
    //   229: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   232: lstore 7
    //   234: goto -44 -> 190
    //   237: aload_1
    //   238: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   241: putfield 552	com/baidu/location/c/e:e	J
    //   244: aload_1
    //   245: areturn
    //   246: aload_0
    //   247: instanceof 219
    //   250: ifeq +189 -> 439
    //   253: new 538	com/baidu/location/c/e
    //   256: dup
    //   257: invokespecial 539	com/baidu/location/c/e:<init>	()V
    //   260: astore 10
    //   262: aload_0
    //   263: checkcast 219	android/telephony/CellInfoCdma
    //   266: invokevirtual 222	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   269: astore 11
    //   271: aload 10
    //   273: iconst_2
    //   274: putfield 540	com/baidu/location/c/e:a	I
    //   277: aload 11
    //   279: invokevirtual 237	android/telephony/CellIdentityCdma:getSystemId	()I
    //   282: ldc 98
    //   284: if_icmpne +6 -> 290
    //   287: goto +13 -> 300
    //   290: aload 11
    //   292: invokevirtual 237	android/telephony/CellIdentityCdma:getSystemId	()I
    //   295: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   298: astore 9
    //   300: aload 10
    //   302: aload 9
    //   304: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   307: aload_0
    //   308: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   311: ifeq +9 -> 320
    //   314: aload 10
    //   316: iconst_1
    //   317: putfield 541	com/baidu/location/c/e:d	I
    //   320: iload_2
    //   321: bipush 28
    //   323: if_icmplt +12 -> 335
    //   326: aload 10
    //   328: aload_0
    //   329: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   332: putfield 548	com/baidu/location/c/e:f	I
    //   335: aload_1
    //   336: invokevirtual 257	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   339: astore_1
    //   340: aload_1
    //   341: invokestatic 557	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne +22 -> 366
    //   347: aload_1
    //   348: invokevirtual 260	java/lang/String:length	()I
    //   351: iconst_3
    //   352: if_icmplt +14 -> 366
    //   355: aload 10
    //   357: aload_1
    //   358: iconst_0
    //   359: iconst_3
    //   360: invokevirtual 264	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   366: iload_2
    //   367: bipush 30
    //   369: if_icmplt +31 -> 400
    //   372: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   375: lstore 5
    //   377: aload_0
    //   378: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   381: lstore 7
    //   383: aload 10
    //   385: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   388: lload 5
    //   390: lload 7
    //   392: lsub
    //   393: lsub
    //   394: putfield 552	com/baidu/location/c/e:e	J
    //   397: goto +39 -> 436
    //   400: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   403: aload_0
    //   404: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   407: lsub
    //   408: ldc2_w 422
    //   411: ldiv
    //   412: lstore 5
    //   414: aload 10
    //   416: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   419: lload 5
    //   421: lsub
    //   422: putfield 552	com/baidu/location/c/e:e	J
    //   425: goto +11 -> 436
    //   428: aload 10
    //   430: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   433: putfield 552	com/baidu/location/c/e:e	J
    //   436: aload 10
    //   438: areturn
    //   439: aload_0
    //   440: instanceof 290
    //   443: ifeq +213 -> 656
    //   446: new 538	com/baidu/location/c/e
    //   449: dup
    //   450: invokespecial 539	com/baidu/location/c/e:<init>	()V
    //   453: astore 9
    //   455: aload_0
    //   456: checkcast 290	android/telephony/CellInfoWcdma
    //   459: invokevirtual 293	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   462: astore 10
    //   464: aload 9
    //   466: iconst_4
    //   467: putfield 540	com/baidu/location/c/e:a	I
    //   470: aload_0
    //   471: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   474: ifeq +9 -> 483
    //   477: aload 9
    //   479: iconst_1
    //   480: putfield 541	com/baidu/location/c/e:d	I
    //   483: iload_2
    //   484: bipush 28
    //   486: if_icmplt +35 -> 521
    //   489: aload 9
    //   491: aload 10
    //   493: invokevirtual 558	android/telephony/CellIdentityWcdma:getMccString	()Ljava/lang/String;
    //   496: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   499: aload 9
    //   501: aload 10
    //   503: invokevirtual 559	android/telephony/CellIdentityWcdma:getMncString	()Ljava/lang/String;
    //   506: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   509: aload 9
    //   511: aload_0
    //   512: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   515: putfield 548	com/baidu/location/c/e:f	I
    //   518: goto +64 -> 582
    //   521: aload 10
    //   523: invokevirtual 296	android/telephony/CellIdentityWcdma:getMcc	()I
    //   526: ldc 98
    //   528: if_icmpne +8 -> 536
    //   531: aconst_null
    //   532: astore_1
    //   533: goto +12 -> 545
    //   536: aload 10
    //   538: invokevirtual 296	android/telephony/CellIdentityWcdma:getMcc	()I
    //   541: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   544: astore_1
    //   545: aload 9
    //   547: aload_1
    //   548: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   551: aload 10
    //   553: invokevirtual 297	android/telephony/CellIdentityWcdma:getMnc	()I
    //   556: ldc 98
    //   558: if_icmpne +9 -> 567
    //   561: aload 11
    //   563: astore_1
    //   564: goto +12 -> 576
    //   567: aload 10
    //   569: invokevirtual 297	android/telephony/CellIdentityWcdma:getMnc	()I
    //   572: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   575: astore_1
    //   576: aload 9
    //   578: aload_1
    //   579: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   582: iload_2
    //   583: bipush 30
    //   585: if_icmplt +43 -> 628
    //   588: aload 9
    //   590: astore_1
    //   591: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   594: aload_0
    //   595: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   598: lsub
    //   599: lstore 5
    //   601: aload 9
    //   603: astore_1
    //   604: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   607: lstore 7
    //   609: aload 9
    //   611: astore_1
    //   612: aload 9
    //   614: lload 7
    //   616: lload 5
    //   618: lsub
    //   619: putfield 552	com/baidu/location/c/e:e	J
    //   622: aload 9
    //   624: astore_1
    //   625: goto -381 -> 244
    //   628: aload 9
    //   630: astore_1
    //   631: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   634: aload_0
    //   635: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   638: lsub
    //   639: ldc2_w 422
    //   642: ldiv
    //   643: lstore 5
    //   645: aload 9
    //   647: astore_1
    //   648: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   651: lstore 7
    //   653: goto -44 -> 609
    //   656: aload_0
    //   657: instanceof 307
    //   660: ifeq +155 -> 815
    //   663: iload_2
    //   664: bipush 28
    //   666: if_icmplt +796 -> 1462
    //   669: new 538	com/baidu/location/c/e
    //   672: dup
    //   673: invokespecial 539	com/baidu/location/c/e:<init>	()V
    //   676: astore 9
    //   678: aload_0
    //   679: checkcast 307	android/telephony/CellInfoTdscdma
    //   682: invokevirtual 310	android/telephony/CellInfoTdscdma:getCellIdentity	()Landroid/telephony/CellIdentityTdscdma;
    //   685: astore_1
    //   686: aload 9
    //   688: iconst_5
    //   689: putfield 540	com/baidu/location/c/e:a	I
    //   692: aload_0
    //   693: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   696: ifeq +9 -> 705
    //   699: aload 9
    //   701: iconst_1
    //   702: putfield 541	com/baidu/location/c/e:d	I
    //   705: aload 9
    //   707: aload_1
    //   708: invokevirtual 315	android/telephony/CellIdentityTdscdma:getMccString	()Ljava/lang/String;
    //   711: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   714: aload 9
    //   716: aload_1
    //   717: invokevirtual 318	android/telephony/CellIdentityTdscdma:getMncString	()Ljava/lang/String;
    //   720: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   723: aload 9
    //   725: aload_0
    //   726: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   729: putfield 548	com/baidu/location/c/e:f	I
    //   732: iload_2
    //   733: bipush 30
    //   735: if_icmplt +40 -> 775
    //   738: aload 9
    //   740: astore_1
    //   741: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   744: aload_0
    //   745: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   748: lsub
    //   749: lstore 5
    //   751: aload 9
    //   753: astore_1
    //   754: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   757: lstore 7
    //   759: aload 9
    //   761: astore_0
    //   762: aload_0
    //   763: astore_1
    //   764: aload_0
    //   765: lload 7
    //   767: lload 5
    //   769: lsub
    //   770: putfield 552	com/baidu/location/c/e:e	J
    //   773: aload_0
    //   774: areturn
    //   775: aload 9
    //   777: astore_1
    //   778: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   781: aload_0
    //   782: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   785: lsub
    //   786: ldc2_w 422
    //   789: ldiv
    //   790: lstore 5
    //   792: aload 9
    //   794: astore_1
    //   795: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   798: lstore 7
    //   800: aload 9
    //   802: astore_0
    //   803: goto -41 -> 762
    //   806: aload_1
    //   807: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   810: putfield 552	com/baidu/location/c/e:e	J
    //   813: aload_1
    //   814: areturn
    //   815: aload_0
    //   816: instanceof 269
    //   819: ifeq +323 -> 1142
    //   822: new 561	com/baidu/location/c/f
    //   825: dup
    //   826: invokespecial 562	com/baidu/location/c/f:<init>	()V
    //   829: astore 9
    //   831: aload_0
    //   832: checkcast 269	android/telephony/CellInfoLte
    //   835: astore 10
    //   837: aload 10
    //   839: invokevirtual 272	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   842: astore_1
    //   843: aload 10
    //   845: invokevirtual 285	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   848: astore 10
    //   850: aload 9
    //   852: iconst_3
    //   853: putfield 540	com/baidu/location/c/e:a	I
    //   856: aload_0
    //   857: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   860: ifeq +9 -> 869
    //   863: aload 9
    //   865: iconst_1
    //   866: putfield 541	com/baidu/location/c/e:d	I
    //   869: aload 9
    //   871: aload_1
    //   872: invokevirtual 282	android/telephony/CellIdentityLte:getCi	()I
    //   875: putfield 563	com/baidu/location/c/f:h	I
    //   878: aload 9
    //   880: aload_1
    //   881: invokevirtual 566	android/telephony/CellIdentityLte:getPci	()I
    //   884: putfield 568	com/baidu/location/c/f:i	I
    //   887: aload 9
    //   889: aload_1
    //   890: invokevirtual 279	android/telephony/CellIdentityLte:getTac	()I
    //   893: putfield 569	com/baidu/location/c/f:j	I
    //   896: aload 9
    //   898: aload 10
    //   900: invokevirtual 572	android/telephony/CellSignalStrengthLte:getTimingAdvance	()I
    //   903: putfield 575	com/baidu/location/c/f:r	I
    //   906: iload_2
    //   907: bipush 28
    //   909: if_icmplt +42 -> 951
    //   912: aload 9
    //   914: aload_1
    //   915: invokevirtual 576	android/telephony/CellIdentityLte:getMccString	()Ljava/lang/String;
    //   918: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   921: aload 9
    //   923: aload_1
    //   924: invokevirtual 577	android/telephony/CellIdentityLte:getMncString	()Ljava/lang/String;
    //   927: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   930: aload 9
    //   932: aload_0
    //   933: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   936: putfield 548	com/baidu/location/c/e:f	I
    //   939: aload 9
    //   941: aload_1
    //   942: invokevirtual 580	android/telephony/CellIdentityLte:getBandwidth	()I
    //   945: putfield 581	com/baidu/location/c/f:l	I
    //   948: goto +45 -> 993
    //   951: aload_1
    //   952: invokevirtual 275	android/telephony/CellIdentityLte:getMcc	()I
    //   955: ldc 98
    //   957: if_icmpeq +15 -> 972
    //   960: aload 9
    //   962: aload_1
    //   963: invokevirtual 275	android/telephony/CellIdentityLte:getMcc	()I
    //   966: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   969: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   972: aload_1
    //   973: invokevirtual 276	android/telephony/CellIdentityLte:getMnc	()I
    //   976: ldc 98
    //   978: if_icmpeq +15 -> 993
    //   981: aload 9
    //   983: aload_1
    //   984: invokevirtual 276	android/telephony/CellIdentityLte:getMnc	()I
    //   987: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   990: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   993: iload_2
    //   994: bipush 24
    //   996: if_icmplt +12 -> 1008
    //   999: aload 9
    //   1001: aload_1
    //   1002: invokevirtual 584	android/telephony/CellIdentityLte:getEarfcn	()I
    //   1005: putfield 585	com/baidu/location/c/f:k	I
    //   1008: iload_2
    //   1009: bipush 29
    //   1011: if_icmplt +16 -> 1027
    //   1014: aload 9
    //   1016: aload 10
    //   1018: invokevirtual 588	android/telephony/CellSignalStrengthLte:getRssi	()I
    //   1021: invokestatic 593	java/lang/Math:abs	(I)I
    //   1024: putfield 595	com/baidu/location/c/f:m	I
    //   1027: iload_2
    //   1028: bipush 26
    //   1030: if_icmplt +59 -> 1089
    //   1033: aload 9
    //   1035: aload 10
    //   1037: invokevirtual 598	android/telephony/CellSignalStrengthLte:getRsrp	()I
    //   1040: invokestatic 593	java/lang/Math:abs	(I)I
    //   1043: putfield 600	com/baidu/location/c/f:n	I
    //   1046: aload 9
    //   1048: aload 10
    //   1050: invokevirtual 598	android/telephony/CellSignalStrengthLte:getRsrp	()I
    //   1053: invokestatic 593	java/lang/Math:abs	(I)I
    //   1056: putfield 602	com/baidu/location/c/e:g	I
    //   1059: aload 9
    //   1061: aload 10
    //   1063: invokevirtual 605	android/telephony/CellSignalStrengthLte:getRsrq	()I
    //   1066: putfield 607	com/baidu/location/c/f:o	I
    //   1069: aload 9
    //   1071: aload 10
    //   1073: invokevirtual 610	android/telephony/CellSignalStrengthLte:getRssnr	()I
    //   1076: putfield 612	com/baidu/location/c/f:p	I
    //   1079: aload 9
    //   1081: aload 10
    //   1083: invokevirtual 615	android/telephony/CellSignalStrengthLte:getCqi	()I
    //   1086: putfield 616	com/baidu/location/c/f:q	I
    //   1089: iload_2
    //   1090: bipush 30
    //   1092: if_icmplt +30 -> 1122
    //   1095: aload 9
    //   1097: astore_1
    //   1098: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   1101: aload_0
    //   1102: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   1105: lsub
    //   1106: lstore 5
    //   1108: aload 9
    //   1110: astore_1
    //   1111: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   1114: lstore 7
    //   1116: aload 9
    //   1118: astore_0
    //   1119: goto -357 -> 762
    //   1122: aload 9
    //   1124: astore_1
    //   1125: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   1128: aload_0
    //   1129: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   1132: lsub
    //   1133: ldc2_w 422
    //   1136: ldiv
    //   1137: lstore 5
    //   1139: goto -31 -> 1108
    //   1142: aload_0
    //   1143: instanceof 328
    //   1146: ifeq +316 -> 1462
    //   1149: iload_2
    //   1150: bipush 29
    //   1152: if_icmplt +310 -> 1462
    //   1155: new 618	com/baidu/location/c/g
    //   1158: dup
    //   1159: invokespecial 619	com/baidu/location/c/g:<init>	()V
    //   1162: astore 9
    //   1164: aload_0
    //   1165: checkcast 328	android/telephony/CellInfoNr
    //   1168: invokevirtual 331	android/telephony/CellInfoNr:getCellIdentity	()Landroid/telephony/CellIdentity;
    //   1171: checkcast 333	android/telephony/CellIdentityNr
    //   1174: astore_1
    //   1175: goto +11 -> 1186
    //   1178: astore_1
    //   1179: aload_1
    //   1180: invokevirtual 338	java/lang/Throwable:printStackTrace	()V
    //   1183: aload 12
    //   1185: astore_1
    //   1186: aload_0
    //   1187: checkcast 328	android/telephony/CellInfoNr
    //   1190: invokevirtual 357	android/telephony/CellInfoNr:getCellSignalStrength	()Landroid/telephony/CellSignalStrength;
    //   1193: checkcast 359	android/telephony/CellSignalStrengthNr
    //   1196: astore 10
    //   1198: aload_1
    //   1199: ifnull +103 -> 1302
    //   1202: aload 9
    //   1204: bipush 6
    //   1206: putfield 540	com/baidu/location/c/e:a	I
    //   1209: aload 9
    //   1211: aload_1
    //   1212: invokevirtual 339	android/telephony/CellIdentityNr:getMccString	()Ljava/lang/String;
    //   1215: putfield 544	com/baidu/location/c/e:b	Ljava/lang/String;
    //   1218: aload 9
    //   1220: aload_1
    //   1221: invokevirtual 340	android/telephony/CellIdentityNr:getMncString	()Ljava/lang/String;
    //   1224: putfield 547	com/baidu/location/c/e:c	Ljava/lang/String;
    //   1227: aload 9
    //   1229: aload_1
    //   1230: invokevirtual 352	android/telephony/CellIdentityNr:getNci	()J
    //   1233: putfield 621	com/baidu/location/c/g:h	J
    //   1236: aload 9
    //   1238: aload_1
    //   1239: invokevirtual 622	android/telephony/CellIdentityNr:getPci	()I
    //   1242: putfield 623	com/baidu/location/c/g:i	I
    //   1245: aload_1
    //   1246: invokevirtual 341	android/telephony/CellIdentityNr:getTac	()I
    //   1249: istore_3
    //   1250: aload 9
    //   1252: iload_3
    //   1253: putfield 624	com/baidu/location/c/g:j	I
    //   1256: iload_3
    //   1257: ldc 98
    //   1259: if_icmpne +12 -> 1271
    //   1262: aload 9
    //   1264: aload_1
    //   1265: invokestatic 343	com/baidu/location/c/b:a	(Landroid/telephony/CellIdentityNr;)I
    //   1268: putfield 624	com/baidu/location/c/g:j	I
    //   1271: aload 9
    //   1273: getfield 624	com/baidu/location/c/g:j	I
    //   1276: ldc 98
    //   1278: if_icmpne +15 -> 1293
    //   1281: aload 9
    //   1283: aload_1
    //   1284: invokevirtual 346	android/telephony/CellIdentityNr:toString	()Ljava/lang/String;
    //   1287: invokestatic 348	com/baidu/location/c/b:a	(Ljava/lang/String;)I
    //   1290: putfield 624	com/baidu/location/c/g:j	I
    //   1293: aload 9
    //   1295: aload_1
    //   1296: invokevirtual 627	android/telephony/CellIdentityNr:getNrarfcn	()I
    //   1299: putfield 628	com/baidu/location/c/g:k	I
    //   1302: aload_0
    //   1303: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   1306: ifeq +9 -> 1315
    //   1309: aload 9
    //   1311: iconst_1
    //   1312: putfield 541	com/baidu/location/c/e:d	I
    //   1315: aload 9
    //   1317: aload_0
    //   1318: invokevirtual 215	android/telephony/CellInfo:getCellConnectionStatus	()I
    //   1321: putfield 548	com/baidu/location/c/e:f	I
    //   1324: aload 9
    //   1326: aload 10
    //   1328: invokevirtual 388	android/telephony/CellSignalStrengthNr:getSsRsrp	()I
    //   1331: invokestatic 593	java/lang/Math:abs	(I)I
    //   1334: putfield 629	com/baidu/location/c/g:l	I
    //   1337: aload 9
    //   1339: aload 10
    //   1341: invokevirtual 388	android/telephony/CellSignalStrengthNr:getSsRsrp	()I
    //   1344: invokestatic 593	java/lang/Math:abs	(I)I
    //   1347: putfield 602	com/baidu/location/c/e:g	I
    //   1350: aload 9
    //   1352: aload 10
    //   1354: invokevirtual 391	android/telephony/CellSignalStrengthNr:getSsRsrq	()I
    //   1357: putfield 630	com/baidu/location/c/g:m	I
    //   1360: aload 9
    //   1362: aload 10
    //   1364: invokevirtual 394	android/telephony/CellSignalStrengthNr:getSsSinr	()I
    //   1367: putfield 631	com/baidu/location/c/g:n	I
    //   1370: aload 9
    //   1372: aload 10
    //   1374: invokevirtual 373	android/telephony/CellSignalStrengthNr:getCsiRsrp	()I
    //   1377: invokestatic 593	java/lang/Math:abs	(I)I
    //   1380: putfield 632	com/baidu/location/c/g:o	I
    //   1383: aload 9
    //   1385: aload 10
    //   1387: invokevirtual 376	android/telephony/CellSignalStrengthNr:getCsiRsrq	()I
    //   1390: putfield 633	com/baidu/location/c/g:p	I
    //   1393: aload 9
    //   1395: aload 10
    //   1397: invokevirtual 379	android/telephony/CellSignalStrengthNr:getCsiSinr	()I
    //   1400: putfield 634	com/baidu/location/c/g:q	I
    //   1403: iload_2
    //   1404: bipush 30
    //   1406: if_icmplt +36 -> 1442
    //   1409: aload 9
    //   1411: astore_1
    //   1412: invokestatic 405	android/os/SystemClock:elapsedRealtime	()J
    //   1415: aload_0
    //   1416: invokevirtual 408	android/telephony/CellInfo:getTimestampMillis	()J
    //   1419: lsub
    //   1420: lstore 5
    //   1422: aload 9
    //   1424: astore_1
    //   1425: aload 9
    //   1427: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   1430: lload 5
    //   1432: lsub
    //   1433: putfield 552	com/baidu/location/c/e:e	J
    //   1436: aload 9
    //   1438: astore_1
    //   1439: goto -1195 -> 244
    //   1442: aload 9
    //   1444: astore_1
    //   1445: invokestatic 418	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   1448: aload_0
    //   1449: invokevirtual 421	android/telephony/CellInfo:getTimeStamp	()J
    //   1452: lsub
    //   1453: ldc2_w 422
    //   1456: ldiv
    //   1457: lstore 5
    //   1459: goto -37 -> 1422
    //   1462: aconst_null
    //   1463: areturn
    //   1464: astore_0
    //   1465: goto -1228 -> 237
    //   1468: astore_1
    //   1469: goto -1103 -> 366
    //   1472: astore_0
    //   1473: goto -1045 -> 428
    //   1476: astore_0
    //   1477: goto -671 -> 806
    //   1480: astore 11
    //   1482: goto -211 -> 1271
    //   1485: astore 11
    //   1487: goto -194 -> 1293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1490	0	paramCellInfo	CellInfo
    //   0	1490	1	paramTelephonyManager	TelephonyManager
    //   3	1404	2	i1	int
    //   1249	11	3	i2	int
    //   8	15	4	bool	boolean
    //   180	1278	5	l1	long
    //   188	927	7	l2	long
    //   11	1432	9	localObject1	Object
    //   20	1376	10	localObject2	Object
    //   14	548	11	localObject3	Object
    //   1480	1	11	localObject4	Object
    //   1485	1	11	localObject5	Object
    //   17	1167	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   1164	1175	1178	finally
    //   172	182	1464	java/lang/Error
    //   185	190	1464	java/lang/Error
    //   193	203	1464	java/lang/Error
    //   212	226	1464	java/lang/Error
    //   229	234	1464	java/lang/Error
    //   591	601	1464	java/lang/Error
    //   604	609	1464	java/lang/Error
    //   612	622	1464	java/lang/Error
    //   631	645	1464	java/lang/Error
    //   648	653	1464	java/lang/Error
    //   1412	1422	1464	java/lang/Error
    //   1425	1436	1464	java/lang/Error
    //   1445	1459	1464	java/lang/Error
    //   335	366	1468	java/lang/Exception
    //   372	397	1472	java/lang/Error
    //   400	425	1472	java/lang/Error
    //   741	751	1476	java/lang/Error
    //   754	759	1476	java/lang/Error
    //   764	773	1476	java/lang/Error
    //   778	792	1476	java/lang/Error
    //   795	800	1476	java/lang/Error
    //   1098	1108	1476	java/lang/Error
    //   1111	1116	1476	java/lang/Error
    //   1125	1139	1476	java/lang/Error
    //   1262	1271	1480	finally
    //   1281	1293	1485	finally
  }
  
  private static String a(List<e> paramList)
  {
    if (paramList != null) {
      paramList.size();
    }
    return null;
  }
  
  private static List<e> b(List<e> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    if (paramList.size() == 1) {
      return paramList;
    }
    Collections.sort(paramList.subList(1, paramList.size()), new c(null));
    return paramList.subList(0, paramList.size());
  }
  
  private void c(a parama)
  {
    if (parama.b())
    {
      a locala = this.e;
      if ((locala == null) || (!locala.a(parama)))
      {
        this.e = parama;
        if (parama.b())
        {
          int i1 = this.g.size();
          if (i1 == 0) {
            parama = null;
          } else {
            parama = (a)this.g.get(i1 - 1);
          }
          if (parama != null)
          {
            long l1 = parama.b;
            locala = this.e;
            if ((l1 == locala.b) && (parama.a == locala.a)) {}
          }
          else
          {
            this.g.add(this.e);
            if (this.g.size() > 3) {
              this.g.remove(0);
            }
            k();
            this.j = false;
          }
        }
        else
        {
          parama = this.g;
          if (parama != null) {
            parama.clear();
          }
        }
      }
    }
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private String d(a parama)
  {
    // Byte code:
    //   0: new 676	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   12: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokevirtual 164	java/lang/Integer:intValue	()I
    //   18: istore_2
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 8
    //   30: astore 7
    //   32: iload_2
    //   33: bipush 17
    //   35: if_icmplt +555 -> 590
    //   38: aload 9
    //   40: astore 5
    //   42: aload_0
    //   43: getfield 58	com/baidu/location/c/b:d	Landroid/telephony/TelephonyManager;
    //   46: invokevirtual 489	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   49: astore 11
    //   51: aload 8
    //   53: astore 7
    //   55: aload 11
    //   57: ifnull +533 -> 590
    //   60: aload 8
    //   62: astore 7
    //   64: aload 9
    //   66: astore 5
    //   68: aload 11
    //   70: invokeinterface 494 1 0
    //   75: ifle +515 -> 590
    //   78: aload 9
    //   80: astore 5
    //   82: aload 10
    //   84: ldc_w 679
    //   87: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 9
    //   93: astore 5
    //   95: aload 11
    //   97: invokeinterface 501 1 0
    //   102: astore 8
    //   104: aload 6
    //   106: astore 7
    //   108: aload 6
    //   110: astore 5
    //   112: aload 8
    //   114: invokeinterface 506 1 0
    //   119: ifeq +471 -> 590
    //   122: aload 6
    //   124: astore 5
    //   126: aload 8
    //   128: invokeinterface 510 1 0
    //   133: checkcast 212	android/telephony/CellInfo
    //   136: astore 7
    //   138: aload 6
    //   140: astore 5
    //   142: aload 7
    //   144: invokevirtual 513	android/telephony/CellInfo:isRegistered	()Z
    //   147: ifeq +6 -> 153
    //   150: goto -46 -> 104
    //   153: aload 6
    //   155: astore 5
    //   157: aload 7
    //   159: aload_0
    //   160: getfield 63	com/baidu/location/c/b:e	Lcom/baidu/location/c/a;
    //   163: aload_0
    //   164: getfield 58	com/baidu/location/c/b:d	Landroid/telephony/TelephonyManager;
    //   167: invokestatic 515	com/baidu/location/c/b:a	(Landroid/telephony/CellInfo;Lcom/baidu/location/c/a;Landroid/telephony/TelephonyManager;)Lcom/baidu/location/c/a;
    //   170: astore 9
    //   172: aload 9
    //   174: ifnonnull +6 -> 180
    //   177: goto -73 -> 104
    //   180: aload 6
    //   182: astore 5
    //   184: aload 9
    //   186: getfield 189	com/baidu/location/c/a:a	I
    //   189: istore_2
    //   190: iload_2
    //   191: iconst_m1
    //   192: if_icmpeq +240 -> 432
    //   195: aload 6
    //   197: astore 5
    //   199: aload 9
    //   201: getfield 194	com/baidu/location/c/a:b	J
    //   204: lstore_3
    //   205: lload_3
    //   206: ldc2_w 684
    //   209: lcmp
    //   210: ifeq +222 -> 432
    //   213: aload_1
    //   214: ifnull +118 -> 332
    //   217: aload 6
    //   219: astore 5
    //   221: aload_1
    //   222: getfield 189	com/baidu/location/c/a:a	I
    //   225: iload_2
    //   226: if_icmpeq +6 -> 232
    //   229: goto +103 -> 332
    //   232: aload 6
    //   234: astore 5
    //   236: new 676	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   243: astore 7
    //   245: aload 6
    //   247: astore 5
    //   249: aload 7
    //   251: ldc_w 687
    //   254: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 6
    //   260: astore 5
    //   262: aload 7
    //   264: aload 9
    //   266: getfield 194	com/baidu/location/c/a:b	J
    //   269: invokevirtual 690	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: astore 5
    //   277: aload 7
    //   279: ldc_w 687
    //   282: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: astore 5
    //   290: aload 7
    //   292: aload 9
    //   294: getfield 208	com/baidu/location/c/a:h	I
    //   297: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 6
    //   303: astore 5
    //   305: aload 7
    //   307: ldc_w 695
    //   310: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 6
    //   316: astore 5
    //   318: aload 10
    //   320: aload 7
    //   322: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: goto +103 -> 432
    //   332: aload 6
    //   334: astore 5
    //   336: new 676	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   343: astore 7
    //   345: aload 6
    //   347: astore 5
    //   349: aload 7
    //   351: aload 9
    //   353: getfield 189	com/baidu/location/c/a:a	I
    //   356: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 6
    //   362: astore 5
    //   364: aload 7
    //   366: ldc_w 687
    //   369: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 6
    //   375: astore 5
    //   377: aload 7
    //   379: aload 9
    //   381: getfield 194	com/baidu/location/c/a:b	J
    //   384: invokevirtual 690	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 6
    //   390: astore 5
    //   392: aload 7
    //   394: ldc_w 687
    //   397: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 6
    //   403: astore 5
    //   405: aload 7
    //   407: aload 9
    //   409: getfield 208	com/baidu/location/c/a:h	I
    //   412: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 6
    //   418: astore 5
    //   420: aload 7
    //   422: ldc_w 695
    //   425: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: goto -115 -> 314
    //   432: aload 6
    //   434: astore 5
    //   436: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   439: bipush 28
    //   441: if_icmple -337 -> 104
    //   444: aload 6
    //   446: astore 5
    //   448: aload 9
    //   450: getfield 210	com/baidu/location/c/a:k	I
    //   453: bipush 6
    //   455: if_icmpne -351 -> 104
    //   458: aload 6
    //   460: astore 5
    //   462: aload 9
    //   464: getfield 400	com/baidu/location/c/a:o	Ljava/lang/String;
    //   467: ifnull -363 -> 104
    //   470: aload 6
    //   472: astore 5
    //   474: aload 9
    //   476: invokevirtual 362	com/baidu/location/c/a:b	()Z
    //   479: ifeq -375 -> 104
    //   482: aload 6
    //   484: astore 7
    //   486: aload 6
    //   488: ifnonnull +39 -> 527
    //   491: aload 6
    //   493: astore 5
    //   495: new 676	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   502: astore 6
    //   504: aload 6
    //   506: ldc_w 698
    //   509: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 6
    //   515: astore 7
    //   517: goto +10 -> 527
    //   520: aload 6
    //   522: astore 7
    //   524: goto +66 -> 590
    //   527: aload 7
    //   529: astore 5
    //   531: aload 7
    //   533: aload 9
    //   535: invokevirtual 521	com/baidu/location/c/a:g	()Ljava/lang/String;
    //   538: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 7
    //   544: astore 5
    //   546: aload 7
    //   548: ldc_w 700
    //   551: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 7
    //   557: astore 5
    //   559: aload 7
    //   561: aload 9
    //   563: getfield 400	com/baidu/location/c/a:o	Ljava/lang/String;
    //   566: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 7
    //   572: astore 5
    //   574: aload 7
    //   576: ldc_w 695
    //   579: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 7
    //   585: astore 6
    //   587: goto -483 -> 104
    //   590: aload 7
    //   592: ifnull +36 -> 628
    //   595: new 676	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   602: astore_1
    //   603: aload_1
    //   604: aload 10
    //   606: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_1
    //   614: aload 7
    //   616: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload_1
    //   624: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: areturn
    //   628: aload 10
    //   630: invokevirtual 696	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: areturn
    //   634: astore_1
    //   635: aload 5
    //   637: astore 7
    //   639: goto -49 -> 590
    //   642: astore_1
    //   643: goto -123 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	this	b
    //   0	646	1	parama	a
    //   18	209	2	i1	int
    //   204	2	3	l1	long
    //   40	596	5	localObject1	Object
    //   26	560	6	localObject2	Object
    //   30	608	7	localObject3	Object
    //   20	107	8	localIterator	Iterator
    //   23	539	9	locala	a
    //   7	622	10	localStringBuilder	StringBuilder
    //   49	47	11	localList	List
    // Exception table:
    //   from	to	target	type
    //   42	51	634	finally
    //   68	78	634	finally
    //   82	91	634	finally
    //   95	104	634	finally
    //   112	122	634	finally
    //   126	138	634	finally
    //   142	150	634	finally
    //   157	172	634	finally
    //   184	190	634	finally
    //   199	205	634	finally
    //   221	229	634	finally
    //   236	245	634	finally
    //   249	258	634	finally
    //   262	273	634	finally
    //   277	286	634	finally
    //   290	301	634	finally
    //   305	314	634	finally
    //   318	329	634	finally
    //   336	345	634	finally
    //   349	360	634	finally
    //   364	373	634	finally
    //   377	388	634	finally
    //   392	401	634	finally
    //   405	416	634	finally
    //   420	429	634	finally
    //   436	444	634	finally
    //   448	458	634	finally
    //   462	470	634	finally
    //   474	482	634	finally
    //   495	504	634	finally
    //   531	542	634	finally
    //   546	555	634	finally
    //   559	570	634	finally
    //   574	583	634	finally
    //   504	513	642	finally
  }
  
  public static String i()
  {
    String str = k;
    if ((str != null) && (str.length() != 0)) {
      return k.replace("\n", "");
    }
    return null;
  }
  
  private void j()
  {
    Object localObject1 = h.f();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("lcvif2.dat");
    localObject1 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject1).exists()) {}
    try
    {
      localObject2 = new RandomAccessFile((File)localObject1, "rw");
      ((RandomAccessFile)localObject2).seek(0L);
      l1 = ((RandomAccessFile)localObject2).readLong();
      if (System.currentTimeMillis() - l1 > 60000L)
      {
        ((RandomAccessFile)localObject2).close();
        ((File)localObject1).delete();
        return;
      }
      ((RandomAccessFile)localObject2).readInt();
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1;
        int i1;
        int i2;
        int i3;
        int i4;
        long l2;
        int i5;
        a locala;
        continue;
        char c1 = '\000';
        if (i5 == 2) {
          c1 = 'c';
        }
        if (l1 == 0L) {
          i1 += 1;
        }
      }
    }
    if (i1 < 3)
    {
      l1 = ((RandomAccessFile)localObject2).readLong();
      i2 = ((RandomAccessFile)localObject2).readInt();
      i3 = ((RandomAccessFile)localObject2).readInt();
      i4 = ((RandomAccessFile)localObject2).readInt();
      l2 = ((RandomAccessFile)localObject2).readLong();
      i5 = ((RandomAccessFile)localObject2).readInt();
      if (i5 == 1)
      {
        c1 = 'g';
        break label260;
        locala = new a(i4, l2, i2, i3, 0, c1, -1);
        locala.g = l1;
        if (!locala.b()) {
          break label276;
        }
        this.j = true;
        this.g.add(locala);
        break label276;
      }
    }
    else
    {
      ((RandomAccessFile)localObject2).close();
      return;
      ((File)localObject1).delete();
      return;
    }
  }
  
  private void k()
  {
    Object localObject = this.g;
    if ((localObject == null) && (this.f == null)) {
      return;
    }
    if ((localObject == null) && (this.f != null))
    {
      localObject = new LinkedList();
      this.g = ((List)localObject);
      ((List)localObject).add(this.f);
    }
    localObject = h.f();
    if (localObject == null) {
      return;
    }
    int i4;
    if (this.g != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("lcvif2.dat");
      localObject = new File(localStringBuilder.toString());
      i4 = this.g.size();
    }
    for (;;)
    {
      int i2;
      try
      {
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).createNewFile();
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(0L);
        ((RandomAccessFile)localObject).writeLong(((a)this.g.get(i4 - 1)).g);
        ((RandomAccessFile)localObject).writeInt(i4);
        int i3 = 0;
        int i1 = 0;
        i2 = i3;
        if (i1 < 3 - i4)
        {
          ((RandomAccessFile)localObject).writeLong(0L);
          ((RandomAccessFile)localObject).writeInt(-1);
          ((RandomAccessFile)localObject).writeInt(-1);
          ((RandomAccessFile)localObject).writeInt(-1);
          ((RandomAccessFile)localObject).writeLong(-1L);
          ((RandomAccessFile)localObject).writeInt(2);
          i1 += 1;
          continue;
        }
        if (i2 < i4)
        {
          ((RandomAccessFile)localObject).writeLong(((a)this.g.get(i2)).g);
          ((RandomAccessFile)localObject).writeInt(((a)this.g.get(i2)).c);
          ((RandomAccessFile)localObject).writeInt(((a)this.g.get(i2)).d);
          ((RandomAccessFile)localObject).writeInt(((a)this.g.get(i2)).a);
          ((RandomAccessFile)localObject).writeLong(((a)this.g.get(i2)).b);
          if (((a)this.g.get(i2)).i == 'g') {
            ((RandomAccessFile)localObject).writeInt(1);
          } else if (((a)this.g.get(i2)).i == 'c') {
            ((RandomAccessFile)localObject).writeInt(2);
          } else {
            ((RandomAccessFile)localObject).writeInt(3);
          }
        }
        else
        {
          ((RandomAccessFile)localObject).close();
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      i2 += 1;
    }
  }
  
  private void l()
  {
    Object localObject1 = a(this.e, this.d, false);
    if (localObject1 != null) {
      c((a)localObject1);
    }
    if ((Build.VERSION.SDK_INT <= 28) && ((localObject1 == null) || (!((a)localObject1).b()))) {}
    try
    {
      localObject1 = this.d.getCellLocation();
    }
    finally
    {
      label52:
      break label52;
    }
    localObject1 = null;
    if (localObject1 != null) {
      a((CellLocation)localObject1);
    }
  }
  
  public String a(a parama)
  {
    String str = "";
    try
    {
      parama = d(parama);
      int i1 = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
      if ((parama != null) && (!parama.equals("")))
      {
        boolean bool = parama.equals("&nc=");
        if (!bool) {
          return parama;
        }
      }
      if (i1 >= 17) {
        return parama;
      }
    }
    finally
    {
      parama.printStackTrace();
      parama = str;
    }
    if ((parama != null) && (parama.equals("&nc="))) {
      return null;
    }
    return parama;
  }
  
  public String b(a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(parama.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[] { Integer.valueOf(parama.c), Integer.valueOf(parama.d), Integer.valueOf(parama.a), Long.valueOf(parama.b), Integer.valueOf(parama.h) }));
    if (parama.e < 2147483647)
    {
      i1 = parama.f;
      if (i1 < 2147483647) {
        localStringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[] { Double.valueOf(i1 / 14400.0D), Double.valueOf(parama.e / 14400.0D) }));
      }
    }
    localStringBuffer.append("&cl_t=");
    localStringBuffer.append(parama.g);
    localStringBuffer.append("&cl_api=");
    localStringBuffer.append(parama.l);
    localStringBuffer.append("&clp=");
    localStringBuffer.append(parama.k);
    if (parama.o != null)
    {
      localStringBuffer.append("&clnrs=");
      localStringBuffer.append(parama.o);
    }
    if ((Build.VERSION.SDK_INT >= 28) && (parama.j != 2147483647))
    {
      localStringBuffer.append("&cl_cs=");
      localStringBuffer.append(parama.j);
    }
    try
    {
      localObject = this.g;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        i2 = this.g.size();
        localStringBuffer.append("&clt=");
        i1 = 0;
        while (i1 < i2)
        {
          localObject = (a)this.g.get(i1);
          if (localObject != null)
          {
            int i3 = ((a)localObject).c;
            if (i3 != parama.c) {
              localStringBuffer.append(i3);
            }
            localStringBuffer.append("|");
            i3 = ((a)localObject).d;
            if (i3 != parama.d) {
              localStringBuffer.append(i3);
            }
            localStringBuffer.append("|");
            i3 = ((a)localObject).a;
            if (i3 != parama.a) {
              localStringBuffer.append(i3);
            }
            localStringBuffer.append("|");
            long l1 = ((a)localObject).b;
            if (l1 != parama.b) {
              localStringBuffer.append(l1);
            }
            localStringBuffer.append("|");
            localStringBuffer.append((System.currentTimeMillis() - ((a)localObject).g) / 1000L);
            localStringBuffer.append(";");
          }
          i1 += 1;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      int i2;
      label520:
      break label520;
    }
    if (a > 100) {
      a = 0;
    }
    int i1 = b;
    i2 = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&cs=");
    ((StringBuilder)localObject).append(i2 + (i1 << 8));
    localStringBuffer.append(((StringBuilder)localObject).toString());
    parama = parama.m;
    if (parama != null) {
      localStringBuffer.append(parama);
    }
    localStringBuffer.append("&cl_list=");
    localStringBuffer.append(i());
    return localStringBuffer.toString();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/baidu/location/c/b:i	Z
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 833	com/baidu/location/f:isServing	Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokestatic 837	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   30: ldc_w 839
    //   33: invokevirtual 845	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 253	android/telephony/TelephonyManager
    //   39: putfield 58	com/baidu/location/c/b:d	Landroid/telephony/TelephonyManager;
    //   42: aload_0
    //   43: new 747	java/util/LinkedList
    //   46: dup
    //   47: invokespecial 748	java/util/LinkedList:<init>	()V
    //   50: putfield 67	com/baidu/location/c/b:g	Ljava/util/List;
    //   53: aload_0
    //   54: new 13	com/baidu/location/c/b$b
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 847	com/baidu/location/c/b$b:<init>	(Lcom/baidu/location/c/b;)V
    //   62: putfield 69	com/baidu/location/c/b:h	Lcom/baidu/location/c/b$b;
    //   65: aload_0
    //   66: invokespecial 849	com/baidu/location/c/b:j	()V
    //   69: aload_0
    //   70: getfield 58	com/baidu/location/c/b:d	Landroid/telephony/TelephonyManager;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +50 -> 125
    //   78: aload_0
    //   79: getfield 69	com/baidu/location/c/b:h	Lcom/baidu/location/c/b$b;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +6 -> 90
    //   87: goto +38 -> 125
    //   90: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   93: aload_0
    //   94: getfield 84	com/baidu/location/c/b:q	I
    //   97: if_icmplt +12 -> 109
    //   100: aload_0
    //   101: getfield 82	com/baidu/location/c/b:p	Z
    //   104: istore_1
    //   105: iload_1
    //   106: ifne +11 -> 117
    //   109: aload_2
    //   110: aload_3
    //   111: sipush 1280
    //   114: invokevirtual 853	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 71	com/baidu/location/c/b:i	Z
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: astore_2
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_2
    //   132: athrow
    //   133: astore_2
    //   134: goto -17 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	b
    //   6	100	1	bool	boolean
    //   73	37	2	localTelephonyManager	TelephonyManager
    //   128	4	2	localObject	Object
    //   133	1	2	localException	Exception
    //   82	29	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	128	finally
    //   15	19	128	finally
    //   26	74	128	finally
    //   78	83	128	finally
    //   90	105	128	finally
    //   109	117	128	finally
    //   117	122	128	finally
    //   109	117	133	java/lang/Exception
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.i;
      if (!bool) {
        return;
      }
      b localb = this.h;
      if (localb != null)
      {
        TelephonyManager localTelephonyManager = this.d;
        if (localTelephonyManager != null) {
          localTelephonyManager.listen(localb, 0);
        }
      }
      this.h = null;
      this.d = null;
      this.g.clear();
      this.g = null;
      k();
      this.i = false;
      return;
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public int e()
  {
    TelephonyManager localTelephonyManager = this.d;
    if (localTelephonyManager == null) {
      return 0;
    }
    try
    {
      int i1 = localTelephonyManager.getNetworkType();
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public a f()
  {
    a locala1 = this.e;
    if (((locala1 == null) || (!locala1.a()) || (!this.e.b())) && (this.d != null)) {}
    try
    {
      l();
      if ((Build.VERSION.SDK_INT >= 29) && (this.p) && (System.currentTimeMillis() - this.n > 30000L))
      {
        this.n = System.currentTimeMillis();
        if (this.m == null) {
          this.m = new a(null);
        }
        this.d.requestCellInfoUpdate(f.getServiceContext().getMainExecutor(), this.m);
      }
    }
    catch (Exception localException)
    {
      label111:
      a locala2;
      break label111;
    }
    locala1 = this.e;
    if ((locala1 != null) && (locala1.e()))
    {
      this.f = null;
      this.f = new a(this.e);
    }
    locala1 = this.e;
    if ((locala1 != null) && (locala1.d()))
    {
      locala1 = this.f;
      if (locala1 != null)
      {
        locala2 = this.e;
        if (locala2.i == 'g')
        {
          locala2.d = locala1.d;
          locala2.c = locala1.c;
        }
      }
    }
    return this.e;
  }
  
  public String g()
  {
    i2 = -1;
    try
    {
      localObject = this.d;
      i1 = i2;
      if (localObject != null) {
        i1 = ((TelephonyManager)localObject).getSimState();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i1 = i2;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&sim=");
    ((StringBuilder)localObject).append(i1);
    return ((StringBuilder)localObject).toString();
  }
  
  public int h()
  {
    return 0;
  }
  
  private class a
    extends TelephonyManager.CellInfoCallback
  {
    private a() {}
    
    public void onCellInfo(List<CellInfo> paramList)
    {
      if (paramList == null) {
        return;
      }
      b.b(b.this).post(new Runnable()
      {
        public void run()
        {
          try
          {
            b.a(b.this);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    
    public void onError(int paramInt, Throwable paramThrowable)
    {
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  private class b
    extends PhoneStateListener
  {
    public b() {}
    
    public void onCellInfoChanged(List<CellInfo> paramList)
    {
      if (paramList == null) {
        return;
      }
      b.b(b.this).post(new Runnable()
      {
        public void run()
        {
          try
          {
            b.a(b.this);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      if (b.c(b.this) != null)
      {
        a locala;
        int i;
        if (b.c(b.this).i == 'g')
        {
          locala = b.c(b.this);
          i = paramSignalStrength.getGsmSignalStrength();
        }
        for (paramSignalStrength = locala;; paramSignalStrength = locala)
        {
          paramSignalStrength.h = i;
          return;
          if (b.c(b.this).i != 'c') {
            break;
          }
          locala = b.c(b.this);
          i = paramSignalStrength.getCdmaDbm();
        }
      }
    }
  }
  
  private static class c
    implements Comparator<e>
  {
    public int a(e parame1, e parame2)
    {
      return parame1.g - parame2.g;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.c.b
 * JD-Core Version:    0.7.0.1
 */