package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.j;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.t.c;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.crashreport.crash.CrashDetailBean;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private static int a;
  private static final Map<Integer, Pair<String, String>> g = new a();
  private static final ArrayList<g> h = new b();
  private static final Map<Integer, Integer> i = new c();
  private static final Map<Integer, String> j = new d();
  private static final Map<Integer, String> k = new e();
  private Context b;
  private v c;
  private com.tencent.bugly.crashreport.common.strategy.a d;
  private n e;
  private BuglyStrategy.a f;
  
  public b(int paramInt, Context paramContext, v paramv, o paramo, com.tencent.bugly.crashreport.common.strategy.a parama, BuglyStrategy.a parama1, n paramn)
  {
    a = paramInt;
    this.b = paramContext;
    this.c = paramv;
    this.d = parama;
    this.f = parama1;
    this.e = paramn;
  }
  
  private static CrashDetailBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null) {
        return null;
      }
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      paramCursor = (CrashDetailBean)ab.a(arrayOfByte, CrashDetailBean.CREATOR);
      if (paramCursor != null) {
        paramCursor.a = l;
      }
      return paramCursor;
    }
    finally
    {
      if (!y.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramCrashDetailBean;
      }
      Object localObject2 = null;
      Object localObject3 = new ArrayList(10);
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        a locala = (a)((Iterator)localObject1).next();
        if (locala.e) {
          ((List)localObject3).add(locala);
        }
      }
      localObject1 = localObject2;
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = c((List)localObject3);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (!((List)localObject3).isEmpty())
          {
            Collections.sort((List)localObject3);
            localObject1 = (CrashDetailBean)((List)localObject3).get(0);
            a((CrashDetailBean)localObject1, (List)localObject3);
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramCrashDetailBean.j = true;
        paramCrashDetailBean.t = 0;
        paramCrashDetailBean.s = "";
        localObject2 = paramCrashDetailBean;
      }
      b((CrashDetailBean)localObject2, paramList);
      if (((CrashDetailBean)localObject2).r != paramCrashDetailBean.r)
      {
        paramList = ((CrashDetailBean)localObject2).s;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramCrashDetailBean.r);
        if (!paramList.contains(((StringBuilder)localObject1).toString()))
        {
          ((CrashDetailBean)localObject2).t += 1;
          paramList = new StringBuilder();
          paramList.append(((CrashDetailBean)localObject2).s);
          paramList.append(paramCrashDetailBean.r);
          paramList.append("\n");
          ((CrashDetailBean)localObject2).s = paramList.toString();
        }
      }
      return localObject2;
    }
    return paramCrashDetailBean;
  }
  
  /* Error */
  private static ak a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +318 -> 319
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +311 -> 319
    //   11: ldc 233
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new 238	java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: new 238	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual 247	android/content/Context:getCacheDir	()Ljava/io/File;
    //   43: aload_0
    //   44: invokespecial 250	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload 4
    //   50: aload_2
    //   51: sipush 5000
    //   54: invokestatic 253	com/tencent/bugly/proguard/ab:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   57: ifne +15 -> 72
    //   60: ldc 255
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   69: pop
    //   70: aconst_null
    //   71: areturn
    //   72: new 259	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 260	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_1
    //   80: new 262	java/io/FileInputStream
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore_0
    //   89: sipush 4096
    //   92: newarray byte
    //   94: astore 4
    //   96: aload_0
    //   97: aload 4
    //   99: invokevirtual 269	java/io/FileInputStream:read	([B)I
    //   102: istore_3
    //   103: iload_3
    //   104: ifle +18 -> 122
    //   107: aload_1
    //   108: aload 4
    //   110: iconst_0
    //   111: iload_3
    //   112: invokevirtual 273	java/io/ByteArrayOutputStream:write	([BII)V
    //   115: aload_1
    //   116: invokevirtual 276	java/io/ByteArrayOutputStream:flush	()V
    //   119: goto -23 -> 96
    //   122: aload_1
    //   123: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   126: astore_1
    //   127: ldc_w 282
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_1
    //   137: arraylength
    //   138: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: new 290	com/tencent/bugly/proguard/ak
    //   149: dup
    //   150: iconst_2
    //   151: aload_2
    //   152: invokevirtual 293	java/io/File:getName	()Ljava/lang/String;
    //   155: aload_1
    //   156: invokespecial 296	com/tencent/bugly/proguard/ak:<init>	(BLjava/lang/String;[B)V
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 299	java/io/FileInputStream:close	()V
    //   164: goto +15 -> 179
    //   167: astore_0
    //   168: aload_0
    //   169: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   172: ifne +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   179: aload_2
    //   180: invokevirtual 303	java/io/File:exists	()Z
    //   183: ifeq +19 -> 202
    //   186: ldc_w 305
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_2
    //   198: invokevirtual 308	java/io/File:delete	()Z
    //   201: pop
    //   202: aload_1
    //   203: areturn
    //   204: astore_1
    //   205: goto +6 -> 211
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_1
    //   212: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   215: ifne +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   222: aload_0
    //   223: ifnull +22 -> 245
    //   226: aload_0
    //   227: invokevirtual 299	java/io/FileInputStream:close	()V
    //   230: goto +15 -> 245
    //   233: astore_0
    //   234: aload_0
    //   235: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   238: ifne +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   245: aload_2
    //   246: invokevirtual 303	java/io/File:exists	()Z
    //   249: ifeq +19 -> 268
    //   252: ldc_w 305
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   262: pop
    //   263: aload_2
    //   264: invokevirtual 308	java/io/File:delete	()Z
    //   267: pop
    //   268: aconst_null
    //   269: areturn
    //   270: astore_1
    //   271: aload_0
    //   272: ifnull +22 -> 294
    //   275: aload_0
    //   276: invokevirtual 299	java/io/FileInputStream:close	()V
    //   279: goto +15 -> 294
    //   282: astore_0
    //   283: aload_0
    //   284: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   287: ifne +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   294: aload_2
    //   295: invokevirtual 303	java/io/File:exists	()Z
    //   298: ifeq +19 -> 317
    //   301: ldc_w 305
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   311: pop
    //   312: aload_2
    //   313: invokevirtual 308	java/io/File:delete	()Z
    //   316: pop
    //   317: aload_1
    //   318: athrow
    //   319: ldc_w 310
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   329: pop
    //   330: aconst_null
    //   331: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString1	String
    //   0	332	1	paramContext	Context
    //   0	332	2	paramString2	String
    //   102	10	3	m	int
    //   33	76	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   160	164	167	java/io/IOException
    //   89	96	204	finally
    //   96	103	204	finally
    //   107	119	204	finally
    //   122	160	204	finally
    //   80	89	208	finally
    //   226	230	233	java/io/IOException
    //   211	222	270	finally
    //   275	279	282	java/io/IOException
  }
  
  private static List<a> a(List<a> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if ((locala.d) && (locala.b <= l - 86400000L)) {
          localArrayList.add(locala);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private static Map<String, String> a(CrashDetailBean paramCrashDetailBean, com.tencent.bugly.crashreport.common.info.a parama)
  {
    HashMap localHashMap = new HashMap(30);
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.C);
        localHashMap.put("A9", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.D);
        localHashMap.put("A11", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.E);
        localHashMap.put("A10", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.f);
        localHashMap.put("A23", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        parama.getClass();
        localHashMap.put("A7", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(com.tencent.bugly.crashreport.common.info.a.r());
        localHashMap.put("A6", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.q());
        localHashMap.put("A5", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.k());
        localHashMap.put("A22", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.G);
        localHashMap.put("A2", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.F);
        localHashMap.put("A1", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.g);
        localHashMap.put("A24", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.H);
        localHashMap.put("A17", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.k());
        localHashMap.put("A25", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.u());
        localHashMap.put("A15", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(parama.v());
        localHashMap.put("A13", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.A);
        localHashMap.put("A34", localStringBuilder.toString());
        if (parama.w != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.w);
          localHashMap.put("productIdentify", localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(URLEncoder.encode(paramCrashDetailBean.L, "utf-8"));
        localHashMap.put("A26", localStringBuilder.toString());
        int m = paramCrashDetailBean.b;
        bool = true;
        if (m == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramCrashDetailBean.N);
          localHashMap.put("A27", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramCrashDetailBean.M);
          localHashMap.put("A28", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramCrashDetailBean.k);
          localHashMap.put("A29", localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.O);
        localHashMap.put("A30", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCrashDetailBean.P);
        localHashMap.put("A18", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        if (!paramCrashDetailBean.Q)
        {
          localStringBuilder.append(bool);
          localHashMap.put("A36", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.p);
          localHashMap.put("F02", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.q);
          localHashMap.put("F03", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.e());
          localHashMap.put("F04", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.r);
          localHashMap.put("F05", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.o);
          localHashMap.put("F06", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.u);
          localHashMap.put("F08", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.v);
          localHashMap.put("F09", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(parama.s);
          localHashMap.put("F10", localStringBuilder.toString());
          a(localHashMap, paramCrashDetailBean);
          return localHashMap;
        }
      }
      catch (Exception paramCrashDetailBean)
      {
        paramCrashDetailBean.printStackTrace();
        y.a(paramCrashDetailBean);
        return localHashMap;
      }
      boolean bool = false;
    }
  }
  
  private static void a(CrashDetailBean paramCrashDetailBean, List<CrashDetailBean> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int m = 1;
    while (m < paramList.size())
    {
      Object localObject = ((CrashDetailBean)paramList.get(m)).s;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\n");
        if (localObject != null)
        {
          int i1 = localObject.length;
          int n = 0;
          while (n < i1)
          {
            CharSequence localCharSequence = localObject[n];
            if (!paramCrashDetailBean.s.contains(localCharSequence))
            {
              paramCrashDetailBean.t += 1;
              localStringBuilder.append(localCharSequence);
              localStringBuilder.append("\n");
            }
            n += 1;
          }
        }
      }
      m += 1;
    }
    paramList = new StringBuilder();
    paramList.append(paramCrashDetailBean.s);
    paramList.append(localStringBuilder.toString());
    paramCrashDetailBean.s = paramList.toString();
  }
  
  private static void a(CrashDetailBean paramCrashDetailBean, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramCrashDetailBean.R = new LinkedHashMap(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!ab.a((String)localEntry.getKey()))
        {
          String str = (String)localEntry.getKey();
          paramMap = str;
          if (str.length() > 100)
          {
            paramMap = str.substring(0, 100);
            y.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), paramMap });
          }
          if ((!ab.a((String)localEntry.getValue())) && (((String)localEntry.getValue()).length() > 100000))
          {
            str = ((String)localEntry.getValue()).substring(((String)localEntry.getValue()).length() - 100000);
            y.d("setted %s value length is over limit %d substring", new Object[] { paramMap, Integer.valueOf(100000) });
          }
          else
          {
            str = (String)localEntry.getValue();
          }
          paramCrashDetailBean.R.put(paramMap, str);
          y.a("add setted key %s value size:%d", new Object[] { paramMap, Integer.valueOf(str.length()) });
        }
      }
      return;
    }
    y.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null) {
      return;
    }
    y.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    y.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    y.e("# PKG NAME: %s", new Object[] { locala.c });
    y.e("# APP VER: %s", new Object[] { locala.i });
    y.e("# SDK VER: %s", new Object[] { locala.f });
    y.e("# LAUNCH TIME: %s", new Object[] { ab.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)) });
    y.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    y.e("# CRASH TIME: %s", new Object[] { paramString2 });
    y.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    y.e("# CRASH FOREGROUND: %s", new Object[] { Boolean.valueOf(locala.a()) });
    y.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null)
    {
      y.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = locala.l();
      if (locala.v().booleanValue()) {
        paramString1 = "ROOTED";
      } else {
        paramString1 = "UNROOT";
      }
      y.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      y.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      y.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (!ab.a(paramCrashDetailBean.N))
      {
        y.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.N, paramCrashDetailBean.M });
      }
      else if (paramCrashDetailBean.b == 3)
      {
        if (paramCrashDetailBean.S == null)
        {
          paramString1 = "null";
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)paramCrashDetailBean.S.get("BUGLY_CR_01"));
          paramString1 = paramString1.toString();
        }
        y.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { paramString1 });
      }
    }
    if (!ab.a(paramString5))
    {
      y.e("# CRASH STACK: ", new Object[0]);
      y.e(paramString5, new Object[0]);
    }
    y.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
  }
  
  private static void a(ArrayList<ak> paramArrayList, CrashDetailBean paramCrashDetailBean)
  {
    if (!paramCrashDetailBean.j) {
      return;
    }
    String str = paramCrashDetailBean.s;
    if ((str != null) && (str.length() > 0)) {
      try
      {
        paramArrayList.add(new ak((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        y.a(paramArrayList);
      }
    }
  }
  
  private static void a(ArrayList<ak> paramArrayList, CrashDetailBean paramCrashDetailBean, Context paramContext)
  {
    if (paramCrashDetailBean.b != 3) {
      return;
    }
    y.c("crashBean.anrMessages:%s", new Object[] { paramCrashDetailBean.S });
    try
    {
      Map localMap = paramCrashDetailBean.S;
      if ((localMap != null) && (localMap.containsKey("BUGLY_CR_01")))
      {
        if (!TextUtils.isEmpty((CharSequence)paramCrashDetailBean.S.get("BUGLY_CR_01")))
        {
          paramArrayList.add(new ak((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.S.get("BUGLY_CR_01")).getBytes("utf-8")));
          y.c("attach anr message", new Object[0]);
        }
        paramCrashDetailBean.S.remove("BUGLY_CR_01");
      }
      paramCrashDetailBean = paramCrashDetailBean.v;
      if (paramCrashDetailBean != null)
      {
        paramCrashDetailBean = a("trace.zip", paramContext, paramCrashDetailBean);
        if (paramCrashDetailBean != null)
        {
          y.c("attach traces", new Object[0]);
          paramArrayList.add(paramCrashDetailBean);
        }
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      y.a(paramArrayList);
    }
  }
  
  private static void a(ArrayList<ak> paramArrayList, String paramString)
  {
    if (paramString != null) {
      try
      {
        paramArrayList.add(new ak((byte)1, "log.txt", paramString.getBytes("utf-8")));
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        y.a(paramArrayList);
      }
    }
  }
  
  private static void a(ArrayList<ak> paramArrayList, String paramString, Context paramContext)
  {
    if (paramString != null) {
      try
      {
        paramString = a("backupRecord.zip", paramContext, paramString);
        if (paramString != null)
        {
          y.c("attach backup record", new Object[0]);
          paramArrayList.add(paramString);
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        y.a(paramArrayList);
      }
    }
  }
  
  private static void a(ArrayList<ak> paramArrayList, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append((String)paramList.next());
      }
      try
      {
        paramArrayList.add(new ak((byte)1, "martianlog.txt", localStringBuilder.toString().getBytes("utf-8")));
        y.c("attach pageTracingList", new Object[0]);
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
  }
  
  private static void a(ArrayList<ak> paramArrayList, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramArrayOfByte = new ak((byte)2, "buglylog.zip", paramArrayOfByte);
        y.c("attach user log", new Object[0]);
        paramArrayList.add(paramArrayOfByte);
        return;
      }
      catch (Exception paramArrayList)
      {
        y.a(paramArrayList);
      }
    }
  }
  
  private static void a(Map<String, String> paramMap, CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean.T >= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramCrashDetailBean.T);
      paramMap.put("C01", ((StringBuilder)localObject1).toString());
    }
    if (paramCrashDetailBean.U >= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramCrashDetailBean.U);
      paramMap.put("C02", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramCrashDetailBean.V;
    Object localObject2;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = paramCrashDetailBean.V.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder("C03_");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        paramMap.put(localStringBuilder.toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    localObject1 = paramCrashDetailBean.W;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      paramCrashDetailBean = paramCrashDetailBean.W.entrySet().iterator();
      while (paramCrashDetailBean.hasNext())
      {
        localObject1 = (Map.Entry)paramCrashDetailBean.next();
        localObject2 = new StringBuilder("C04_");
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
        paramMap.put(((StringBuilder)localObject2).toString(), ((Map.Entry)localObject1).getValue());
      }
    }
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      y.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      Iterator localIterator = paramList.iterator();
      CrashDetailBean localCrashDetailBean;
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        y.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
        int m = localCrashDetailBean.l + 1;
        localCrashDetailBean.l = m;
        localCrashDetailBean.d = paramBoolean;
        y.c("set uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(m), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
      }
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        c.a().a(localCrashDetailBean);
      }
      y.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    }
    if (!paramBoolean) {
      y.b("[crash] upload fail.", new Object[0]);
    }
  }
  
  private static boolean a(CrashDetailBean paramCrashDetailBean, List<a> paramList1, List<a> paramList2)
  {
    paramList1 = paramList1.iterator();
    boolean bool = false;
    while (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      if (paramCrashDetailBean.u.equals(locala.c))
      {
        if (locala.e) {
          bool = true;
        }
        paramList2.add(locala);
      }
    }
    return bool;
  }
  
  private static boolean a(String paramString)
  {
    String str = c.o;
    if ((str != null) && (!str.isEmpty())) {
      try
      {
        y.c("Crash regular filter for crash stack is: %s", new Object[] { c.o });
        if (Pattern.compile(c.o).matcher(paramString).find())
        {
          y.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
          return true;
        }
      }
      catch (Exception paramString)
      {
        y.a(paramString);
        paramString = new StringBuilder("Failed to compile ");
        paramString.append(c.o);
        y.d(paramString.toString(), new Object[0]);
      }
    }
    return false;
  }
  
  private static a b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        a locala = new a();
        locala.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        locala.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        locala.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
        int m = paramCursor.getInt(paramCursor.getColumnIndex("_up"));
        boolean bool2 = false;
        if (m == 1)
        {
          bool1 = true;
          locala.d = bool1;
          bool1 = bool2;
          if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) == 1) {
            bool1 = true;
          }
          locala.e = bool1;
          locala.f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
          return locala;
        }
      }
      finally
      {
        if (!y.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
        return null;
      }
      boolean bool1 = false;
    }
  }
  
  /* Error */
  private List<a> b()
  {
    // Byte code:
    //   0: new 147	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 321	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   14: ldc_w 835
    //   17: bipush 6
    //   19: anewarray 217	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 110
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 810
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc_w 812
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc_w 817
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 823
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc_w 825
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokevirtual 838	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/n;Z)Landroid/database/Cursor;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnonnull +17 -> 85
    //   71: aload 4
    //   73: ifnull +10 -> 83
    //   76: aload 4
    //   78: invokeinterface 839 1 0
    //   83: aconst_null
    //   84: areturn
    //   85: aload 4
    //   87: invokeinterface 842 1 0
    //   92: istore_1
    //   93: iload_1
    //   94: ifgt +13 -> 107
    //   97: aload 4
    //   99: invokeinterface 839 1 0
    //   104: aload 6
    //   106: areturn
    //   107: new 206	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   114: astore 5
    //   116: aload 5
    //   118: ldc_w 844
    //   121: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 5
    //   127: ldc_w 846
    //   130: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: iconst_0
    //   135: istore_1
    //   136: aload 4
    //   138: invokeinterface 849 1 0
    //   143: istore_2
    //   144: iload_2
    //   145: ifeq +77 -> 222
    //   148: aload 4
    //   150: invokestatic 851	com/tencent/bugly/crashreport/crash/b:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/a;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +15 -> 170
    //   158: aload 6
    //   160: aload_3
    //   161: invokeinterface 172 2 0
    //   166: pop
    //   167: goto -31 -> 136
    //   170: aload 5
    //   172: aload 4
    //   174: aload 4
    //   176: ldc 110
    //   178: invokeinterface 104 2 0
    //   183: invokeinterface 114 2 0
    //   188: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: ldc_w 853
    //   197: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: iload_1
    //   202: iconst_1
    //   203: iadd
    //   204: istore_1
    //   205: goto -69 -> 136
    //   208: ldc_w 855
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   218: pop
    //   219: goto -83 -> 136
    //   222: aload 5
    //   224: astore_3
    //   225: aload 5
    //   227: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: ldc_w 853
    //   233: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifeq +25 -> 261
    //   239: new 206	java/lang/StringBuilder
    //   242: dup
    //   243: aload 5
    //   245: iconst_0
    //   246: aload 5
    //   248: ldc_w 853
    //   251: invokevirtual 858	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   254: invokevirtual 859	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   257: invokespecial 744	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: astore_3
    //   261: aload_3
    //   262: ldc_w 861
    //   265: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 5
    //   275: aload_3
    //   276: iconst_0
    //   277: invokevirtual 864	java/lang/StringBuilder:setLength	(I)V
    //   280: iload_1
    //   281: ifle +40 -> 321
    //   284: ldc_w 866
    //   287: iconst_2
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: ldc_w 835
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   302: ldc_w 835
    //   305: aload 5
    //   307: aconst_null
    //   308: aconst_null
    //   309: iconst_1
    //   310: invokevirtual 869	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/n;Z)I
    //   313: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: aastore
    //   317: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   320: pop
    //   321: aload 4
    //   323: invokeinterface 839 1 0
    //   328: aload 6
    //   330: areturn
    //   331: astore 5
    //   333: aload 4
    //   335: astore_3
    //   336: aload 5
    //   338: astore 4
    //   340: goto +5 -> 345
    //   343: astore 4
    //   345: aload 4
    //   347: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   350: ifne +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   358: aload_3
    //   359: ifnull +9 -> 368
    //   362: aload_3
    //   363: invokeinterface 839 1 0
    //   368: aload 6
    //   370: areturn
    //   371: astore 4
    //   373: aload_3
    //   374: ifnull +9 -> 383
    //   377: aload_3
    //   378: invokeinterface 839 1 0
    //   383: aload 4
    //   385: athrow
    //   386: astore_3
    //   387: goto -179 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	b
    //   92	189	1	m	int
    //   143	2	2	bool	boolean
    //   10	368	3	localObject1	Object
    //   386	1	3	localObject2	Object
    //   64	275	4	localObject3	Object
    //   343	11	4	localThrowable	Throwable
    //   371	13	4	localObject4	Object
    //   114	192	5	localObject5	Object
    //   331	6	5	localObject6	Object
    //   7	362	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   85	93	331	finally
    //   107	134	331	finally
    //   136	144	331	finally
    //   148	154	331	finally
    //   158	167	331	finally
    //   208	219	331	finally
    //   225	261	331	finally
    //   261	280	331	finally
    //   284	321	331	finally
    //   11	66	343	finally
    //   345	358	371	finally
    //   170	201	386	finally
  }
  
  private static void b(CrashDetailBean paramCrashDetailBean, List<a> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((!locala.e) && (!locala.d))
      {
        String str = paramCrashDetailBean.s;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(locala.b);
        if (!str.contains(localStringBuilder2.toString()))
        {
          paramCrashDetailBean.t += 1;
          localStringBuilder1.append(locala.b);
          localStringBuilder1.append("\n");
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append(paramCrashDetailBean.s);
    paramList.append(localStringBuilder1.toString());
    paramCrashDetailBean.s = paramList.toString();
  }
  
  private static void b(ArrayList<ak> paramArrayList, CrashDetailBean paramCrashDetailBean, Context paramContext)
  {
    if (paramCrashDetailBean.b != 1) {
      return;
    }
    paramCrashDetailBean = paramCrashDetailBean.v;
    if (paramCrashDetailBean != null) {
      try
      {
        paramCrashDetailBean = a("tomb.zip", paramContext, paramCrashDetailBean);
        if (paramCrashDetailBean != null)
        {
          y.c("attach tombs", new Object[0]);
          paramArrayList.add(paramCrashDetailBean);
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        y.a(paramArrayList);
      }
    }
  }
  
  private static void b(ArrayList<ak> paramArrayList, String paramString)
  {
    if (paramString != null) {
      try
      {
        paramArrayList.add(new ak((byte)1, "jniLog.txt", paramString.getBytes("utf-8")));
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        y.a(paramArrayList);
      }
    }
  }
  
  private static void b(ArrayList<ak> paramArrayList, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramArrayList.add(new ak((byte)1, "userExtraByteData", paramArrayOfByte));
        y.c("attach extraData", new Object[0]);
        return;
      }
      catch (Exception paramArrayList)
      {
        y.a(paramArrayList);
      }
    }
  }
  
  private void b(List<a> paramList)
  {
    Object localObject = c(paramList);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      paramList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CrashDetailBean localCrashDetailBean = (CrashDetailBean)((Iterator)localObject).next();
        String str = (String)k.get(Integer.valueOf(localCrashDetailBean.b));
        if (!TextUtils.isEmpty(str))
        {
          y.c("find expired data,crashId:%s eventType:%s", new Object[] { localCrashDetailBean.c, str });
          paramList.add(new t.c(localCrashDetailBean.c, str, localCrashDetailBean.r, false, 0L, "expired", null));
        }
      }
      t.a().a(paramList);
    }
  }
  
  private boolean b(CrashDetailBean paramCrashDetailBean, List<a> paramList1, List<a> paramList2)
  {
    int n = paramCrashDetailBean.b;
    int m;
    if ((n != 0) && (n != 1)) {
      m = 0;
    } else {
      m = 1;
    }
    if (n == 3) {
      n = 1;
    } else {
      n = 0;
    }
    boolean bool;
    if (!com.tencent.bugly.b.c)
    {
      if ((n == 0) && (m == 0)) {
        bool = true;
      } else {
        bool = c.d;
      }
    }
    else {
      bool = false;
    }
    if (!bool) {
      return false;
    }
    Object localObject = new ArrayList(10);
    if (!a(paramCrashDetailBean, paramList1, (List)localObject)) {}
    try
    {
      if (((List)localObject).size() >= c.c)
      {
        y.a("same crash occur too much do merged!", new Object[0]);
        paramCrashDetailBean = a((List)localObject, paramCrashDetailBean);
        paramList1 = ((List)localObject).iterator();
        while (paramList1.hasNext())
        {
          localObject = (a)paramList1.next();
          if (((a)localObject).a != paramCrashDetailBean.a) {
            paramList2.add(localObject);
          }
        }
        e(paramCrashDetailBean);
        d(paramList2);
        y.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
      }
    }
    catch (Exception paramCrashDetailBean)
    {
      y.a(paramCrashDetailBean);
      y.d("Failed to merge crash.", new Object[0]);
    }
    return false;
  }
  
  /* Error */
  private List<CrashDetailBean> c(List<a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +423 -> 424
    //   4: aload_1
    //   5: invokeinterface 314 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 206	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 844
    //   27: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: ldc_w 846
    //   35: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: invokeinterface 154 1 0
    //   45: astore_1
    //   46: aload_1
    //   47: invokeinterface 159 1 0
    //   52: ifeq +31 -> 83
    //   55: aload_3
    //   56: aload_1
    //   57: invokeinterface 163 1 0
    //   62: checkcast 165	com/tencent/bugly/crashreport/crash/a
    //   65: getfield 808	com/tencent/bugly/crashreport/crash/a:a	J
    //   68: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: ldc_w 853
    //   76: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -34 -> 46
    //   83: aload_3
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: ldc_w 853
    //   92: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +23 -> 118
    //   98: new 206	java/lang/StringBuilder
    //   101: dup
    //   102: aload_3
    //   103: iconst_0
    //   104: aload_3
    //   105: ldc_w 853
    //   108: invokevirtual 858	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   111: invokevirtual 859	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   114: invokespecial 744	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: astore_1
    //   118: aload_1
    //   119: ldc_w 861
    //   122: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_3
    //   131: aload_1
    //   132: iconst_0
    //   133: invokevirtual 864	java/lang/StringBuilder:setLength	(I)V
    //   136: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   139: ldc_w 835
    //   142: aconst_null
    //   143: aload_3
    //   144: aconst_null
    //   145: aconst_null
    //   146: iconst_1
    //   147: invokevirtual 838	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/n;Z)Landroid/database/Cursor;
    //   150: astore 4
    //   152: aload 4
    //   154: ifnonnull +17 -> 171
    //   157: aload 4
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: invokeinterface 839 1 0
    //   169: aconst_null
    //   170: areturn
    //   171: new 147	java/util/ArrayList
    //   174: dup
    //   175: invokespecial 321	java/util/ArrayList:<init>	()V
    //   178: astore 5
    //   180: aload_1
    //   181: ldc_w 844
    //   184: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: ldc_w 846
    //   192: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: iconst_0
    //   197: istore_2
    //   198: aload 4
    //   200: invokeinterface 849 1 0
    //   205: ifeq +75 -> 280
    //   208: aload 4
    //   210: invokestatic 909	com/tencent/bugly/crashreport/crash/b:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +15 -> 230
    //   218: aload 5
    //   220: aload_3
    //   221: invokeinterface 172 2 0
    //   226: pop
    //   227: goto -29 -> 198
    //   230: aload_1
    //   231: aload 4
    //   233: aload 4
    //   235: ldc 110
    //   237: invokeinterface 104 2 0
    //   242: invokeinterface 114 2 0
    //   247: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: ldc_w 853
    //   255: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: iload_2
    //   260: iconst_1
    //   261: iadd
    //   262: istore_2
    //   263: goto -65 -> 198
    //   266: ldc_w 855
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   276: pop
    //   277: goto -79 -> 198
    //   280: aload_1
    //   281: astore_3
    //   282: aload_1
    //   283: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: ldc_w 853
    //   289: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +23 -> 315
    //   295: new 206	java/lang/StringBuilder
    //   298: dup
    //   299: aload_1
    //   300: iconst_0
    //   301: aload_1
    //   302: ldc_w 853
    //   305: invokevirtual 858	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   308: invokevirtual 859	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   311: invokespecial 744	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: astore_3
    //   315: aload_3
    //   316: ldc_w 861
    //   319: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_3
    //   324: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore_1
    //   328: iload_2
    //   329: ifle +39 -> 368
    //   332: ldc_w 866
    //   335: iconst_2
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: ldc_w 835
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   350: ldc_w 835
    //   353: aload_1
    //   354: aconst_null
    //   355: aconst_null
    //   356: iconst_1
    //   357: invokevirtual 869	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/n;Z)I
    //   360: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: aastore
    //   364: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   367: pop
    //   368: aload 4
    //   370: invokeinterface 839 1 0
    //   375: aload 5
    //   377: areturn
    //   378: astore_3
    //   379: aload 4
    //   381: astore_1
    //   382: goto +6 -> 388
    //   385: astore_3
    //   386: aconst_null
    //   387: astore_1
    //   388: aload_3
    //   389: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   392: ifne +7 -> 399
    //   395: aload_3
    //   396: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   399: aload_1
    //   400: ifnull +9 -> 409
    //   403: aload_1
    //   404: invokeinterface 839 1 0
    //   409: aconst_null
    //   410: areturn
    //   411: astore_3
    //   412: aload_1
    //   413: ifnull +9 -> 422
    //   416: aload_1
    //   417: invokeinterface 839 1 0
    //   422: aload_3
    //   423: athrow
    //   424: aconst_null
    //   425: areturn
    //   426: astore_3
    //   427: goto -161 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	b
    //   0	430	1	paramList	List<a>
    //   197	132	2	m	int
    //   22	302	3	localObject1	Object
    //   378	1	3	localObject2	Object
    //   385	11	3	localThrowable	Throwable
    //   411	12	3	localObject3	Object
    //   426	1	3	localObject4	Object
    //   150	230	4	localCursor	Cursor
    //   178	198	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   171	196	378	finally
    //   198	214	378	finally
    //   218	227	378	finally
    //   266	277	378	finally
    //   282	315	378	finally
    //   315	328	378	finally
    //   332	368	378	finally
    //   136	152	385	finally
    //   388	399	411	finally
    //   230	259	426	finally
  }
  
  private static void c(ArrayList<ak> paramArrayList, String paramString)
  {
    if (!ab.a(paramString)) {
      try
      {
        paramString = new ak((byte)1, "crashInfos.txt", paramString.getBytes("utf-8"));
        y.c("attach crash infos", new Object[0]);
        paramArrayList.add(paramString);
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        y.a(paramArrayList);
      }
    }
  }
  
  private static void d(List<a> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_id in ");
      ((StringBuilder)localObject).append("(");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((StringBuilder)localObject).append(((a)paramList.next()).a);
        ((StringBuilder)localObject).append(",");
      }
      paramList = new StringBuilder(((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(",")));
      paramList.append(")");
      localObject = paramList.toString();
      paramList.setLength(0);
      try
      {
        y.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(o.a().a("t_cr", (String)localObject, null, null, true)) });
        return;
      }
      finally
      {
        if (!y.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private static void e(List<CrashDetailBean> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CrashDetailBean)paramList.next();
          localStringBuilder.append(" or _id");
          localStringBuilder.append(" = ");
          localStringBuilder.append(((CrashDetailBean)localObject).a);
        }
        Object localObject = localStringBuilder.toString();
        paramList = (List<CrashDetailBean>)localObject;
        if (((String)localObject).length() > 0) {
          paramList = ((String)localObject).substring(4);
        }
        localStringBuilder.setLength(0);
        y.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(o.a().a("t_cr", paramList, null, null, true)) });
        return;
      }
      finally
      {
        if (!y.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private static ContentValues f(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        long l = paramCrashDetailBean.a;
        if (l > 0L) {
          localContentValues.put("_id", Long.valueOf(l));
        }
        localContentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
        localContentValues.put("_s1", paramCrashDetailBean.u);
        boolean bool = paramCrashDetailBean.d;
        int n = 1;
        if (bool)
        {
          m = 1;
          localContentValues.put("_up", Integer.valueOf(m));
          if (!paramCrashDetailBean.j) {
            break label166;
          }
          m = n;
          localContentValues.put("_me", Integer.valueOf(m));
          localContentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
          localContentValues.put("_dt", ab.a(paramCrashDetailBean));
          return localContentValues;
        }
      }
      finally
      {
        if (!y.a(paramCrashDetailBean)) {
          paramCrashDetailBean.printStackTrace();
        }
        return null;
      }
      int m = 0;
      continue;
      label166:
      m = 0;
    }
  }
  
  private static String g(CrashDetailBean paramCrashDetailBean)
  {
    try
    {
      Pair localPair = (Pair)g.get(Integer.valueOf(paramCrashDetailBean.b));
      if (localPair == null)
      {
        y.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
        return "";
      }
      if (paramCrashDetailBean.j) {
        return (String)localPair.first;
      }
      paramCrashDetailBean = (String)localPair.second;
      return paramCrashDetailBean;
    }
    catch (Exception paramCrashDetailBean)
    {
      y.a(paramCrashDetailBean);
    }
    return "";
  }
  
  private static ArrayList<ai> h(CrashDetailBean paramCrashDetailBean)
  {
    Object localObject = paramCrashDetailBean.h;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = new ArrayList(paramCrashDetailBean.h.size());
      paramCrashDetailBean = paramCrashDetailBean.h.entrySet().iterator();
      while (paramCrashDetailBean.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCrashDetailBean.next();
        ai localai = new ai();
        localai.a = ((PlugInBean)localEntry.getValue()).a;
        localai.b = ((PlugInBean)localEntry.getValue()).c;
        localai.c = ((PlugInBean)localEntry.getValue()).b;
        ((ArrayList)localObject).add(localai);
      }
      return localObject;
    }
    return null;
  }
  
  public final List<CrashDetailBean> a()
  {
    Object localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if (localObject1 == null)
    {
      y.d("have not synced remote!", new Object[0]);
      return null;
    }
    if (!((StrategyBean)localObject1).e)
    {
      y.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      y.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      return null;
    }
    long l1 = System.currentTimeMillis();
    long l2 = ab.b();
    localObject1 = b();
    y.c("Size of crash list loaded from DB: %s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    if (((List)localObject1).size() <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    localArrayList.addAll(a((List)localObject1));
    ((List)localObject1).removeAll(localArrayList);
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject3;
    label293:
    while (localIterator.hasNext())
    {
      localObject3 = (a)localIterator.next();
      long l3 = ((a)localObject3).b;
      if (l3 < l2 - c.g)
      {
        ((List)localObject2).add(localObject3);
        localIterator.remove();
        localArrayList.add(localObject3);
      }
      else if (((a)localObject3).d)
      {
        if (l3 >= l1 - 86400000L) {
          localIterator.remove();
        } else if (((a)localObject3).e) {}
      }
      else
      {
        for (;;)
        {
          break;
          if ((((a)localObject3).f < 3L) || (l3 >= l1 - 86400000L)) {
            break label293;
          }
        }
      }
    }
    b((List)localObject2);
    if (localArrayList.size() > 0) {
      d(localArrayList);
    }
    localArrayList = new ArrayList();
    localObject1 = c((List)localObject1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = com.tencent.bugly.crashreport.common.info.a.b().i;
      localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (CrashDetailBean)localIterator.next();
        if (!((String)localObject2).equals(((CrashDetailBean)localObject3).f))
        {
          localIterator.remove();
          localArrayList.add(localObject3);
        }
      }
    }
    if (localArrayList.size() > 0) {
      e(localArrayList);
    }
    return localObject1;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = c.l;
    boolean bool1 = false;
    if (bool2)
    {
      y.a("try to upload right now", new Object[0]);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramCrashDetailBean);
      if (paramCrashDetailBean.b == 7) {
        bool1 = true;
      }
      a(localArrayList, 3000L, paramBoolean, bool1, paramBoolean);
      return;
    }
    y.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
  }
  
  public final void a(List<CrashDetailBean> paramList, long paramLong, final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!com.tencent.bugly.crashreport.common.info.a.a(this.b).e)
    {
      y.d("warn: not upload process", new Object[0]);
      return;
    }
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      y.d("warn: upload manager is null", new Object[0]);
      return;
    }
    if ((!paramBoolean3) && (!((v)localObject1).b(c.a)))
    {
      y.d("warn: not crashHappen or not should upload", new Object[0]);
      return;
    }
    localObject1 = this.d.c();
    if (!((StrategyBean)localObject1).e)
    {
      y.d("remote report is disable!", new Object[0]);
      y.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
      return;
    }
    if ((paramList != null) && (paramList.size() != 0)) {}
    for (;;)
    {
      try
      {
        String str1 = ((StrategyBean)localObject1).q;
        String str2 = StrategyBean.b;
        Context localContext = this.b;
        com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
        CrashDetailBean localCrashDetailBean;
        ArrayList localArrayList;
        al localal;
        Object localObject2;
        Object localObject3;
        if ((localContext != null) && (paramList.size() != 0) && (locala != null))
        {
          localObject1 = new am();
          ((am)localObject1).a = new ArrayList();
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break label1248;
          }
          localCrashDetailBean = (CrashDetailBean)localIterator.next();
          localArrayList = ((am)localObject1).a;
          if (localCrashDetailBean != null)
          {
            localal = new al();
            localal.a = g(localCrashDetailBean);
            localal.b = localCrashDetailBean.r;
            localal.c = localCrashDetailBean.n;
            localal.d = localCrashDetailBean.o;
            localal.e = localCrashDetailBean.p;
            localal.g = localCrashDetailBean.q;
            localal.h = localCrashDetailBean.z;
            localal.i = localCrashDetailBean.c;
            localal.j = null;
            localal.l = localCrashDetailBean.m;
            localal.m = localCrashDetailBean.e;
            localal.f = localCrashDetailBean.B;
            localal.n = null;
            localal.p = h(localCrashDetailBean);
            y.c("libInfo %s", new Object[] { localal.o });
            localObject2 = new ArrayList(20);
            a((ArrayList)localObject2, localCrashDetailBean);
            a((ArrayList)localObject2, localCrashDetailBean.w);
            b((ArrayList)localObject2, localCrashDetailBean.x);
            c((ArrayList)localObject2, localCrashDetailBean.Y);
            a((ArrayList)localObject2, localCrashDetailBean.Z, localContext);
            a((ArrayList)localObject2, localCrashDetailBean.y);
            a((ArrayList)localObject2, localCrashDetailBean, localContext);
            b((ArrayList)localObject2, localCrashDetailBean, localContext);
            a((ArrayList)localObject2, locala.B);
            b((ArrayList)localObject2, localCrashDetailBean.X);
            localal.q = ((ArrayList)localObject2);
            if (localCrashDetailBean.j) {
              localal.k = localCrashDetailBean.t;
            }
            localal.r = a(localCrashDetailBean, locala);
            localal.s = new HashMap();
            localObject2 = localCrashDetailBean.R;
            if ((localObject2 != null) && (((Map)localObject2).size() > 0))
            {
              localal.s.putAll(localCrashDetailBean.R);
              y.a("setted message size %d", new Object[] { Integer.valueOf(localal.s.size()) });
            }
            localObject2 = localal.s;
            localObject3 = new StringBuilder("pss:");
            ((StringBuilder)localObject3).append(localCrashDetailBean.I);
            ((StringBuilder)localObject3).append(" vss:");
            ((StringBuilder)localObject3).append(localCrashDetailBean.J);
            ((StringBuilder)localObject3).append(" javaHeap:");
            ((StringBuilder)localObject3).append(localCrashDetailBean.K);
            y.c(((StringBuilder)localObject3).toString(), new Object[0]);
            localObject3 = new StringBuilder();
          }
        }
        try
        {
          ((StringBuilder)localObject3).append(localCrashDetailBean.I);
          ((Map)localObject2).put("SDK_UPLOAD_U1", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localCrashDetailBean.J);
          ((Map)localObject2).put("SDK_UPLOAD_U2", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localCrashDetailBean.K);
          ((Map)localObject2).put("SDK_UPLOAD_U3", ((StringBuilder)localObject3).toString());
          localObject2 = localCrashDetailBean.n;
          localObject3 = localCrashDetailBean.c;
          String str3 = locala.e();
          long l = (localCrashDetailBean.r - localCrashDetailBean.P) / 1000L;
          boolean bool1 = localCrashDetailBean.k;
          boolean bool2 = localCrashDetailBean.Q;
          boolean bool3 = localCrashDetailBean.j;
          if (localCrashDetailBean.b != 1) {
            break label1242;
          }
          paramBoolean3 = true;
          y.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { localObject2, localObject3, str3, Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean3), Integer.valueOf(localCrashDetailBean.t), localCrashDetailBean.s, Boolean.valueOf(localCrashDetailBean.d), Integer.valueOf(localal.r.size()) });
          continue;
          y.d("enExp args == null", new Object[0]);
          localal = null;
          localArrayList.add(localal);
          continue;
        }
        finally
        {
          m = 1;
          break label1194;
        }
        m = 0;
        y.d("enEXPPkg args == null!", new Object[0]);
        localObject1 = null;
        if (localObject1 == null)
        {
          y.d("create eupPkg fail!", new Object[m]);
          return;
        }
        localObject1 = com.tencent.bugly.proguard.a.a((j)localObject1);
        if (localObject1 == null)
        {
          y.d("send encode fail!", new Object[0]);
          return;
        }
        localObject1 = com.tencent.bugly.proguard.a.a(this.b, 830, (byte[])localObject1);
        if (localObject1 == null)
        {
          y.d("request package is null.", new Object[0]);
          return;
        }
        paramList = new f(System.currentTimeMillis(), paramList, paramBoolean1);
        if (paramBoolean1)
        {
          this.c.a(a, (an)localObject1, str1, str2, paramList, paramLong, paramBoolean2);
          return;
        }
        this.c.a(a, (an)localObject1, str1, str2, paramList, false);
        return;
      }
      finally
      {
        m = 1;
      }
      label1194:
      localObject1 = new Object[m];
      localObject1[0] = paramList.toString();
      y.e("req cr error %s", (Object[])localObject1);
      if (!y.b(paramList)) {
        paramList.printStackTrace();
      }
      return;
      y.d("warn: crashList is null or crashList num is 0", new Object[0]);
      return;
      label1242:
      paramBoolean3 = false;
      continue;
      label1248:
      int m = 0;
    }
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean)
  {
    return b(paramCrashDetailBean);
  }
  
  /* Error */
  public final boolean b(CrashDetailBean paramCrashDetailBean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +16 -> 17
    //   4: ldc_w 1219
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: iconst_1
    //   16: ireturn
    //   17: aload_1
    //   18: getfield 1070	com/tencent/bugly/crashreport/crash/CrashDetailBean:q	Ljava/lang/String;
    //   21: astore_3
    //   22: getstatic 1220	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +54 -> 83
    //   32: aload 4
    //   34: invokevirtual 784	java/lang/String:isEmpty	()Z
    //   37: ifne +46 -> 83
    //   40: ldc_w 1222
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: getstatic 1220	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_3
    //   58: getstatic 1220	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   61: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +19 -> 83
    //   67: ldc_w 1224
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 257	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   77: pop
    //   78: iconst_1
    //   79: istore_2
    //   80: goto +5 -> 85
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: ifeq +5 -> 91
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_1
    //   92: getfield 1070	com/tencent/bugly/crashreport/crash/CrashDetailBean:q	Ljava/lang/String;
    //   95: invokestatic 1225	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;)Z
    //   98: ifeq +5 -> 103
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_1
    //   104: getfield 440	com/tencent/bugly/crashreport/crash/CrashDetailBean:b	I
    //   107: iconst_2
    //   108: if_icmpeq +69 -> 177
    //   111: new 1227	com/tencent/bugly/proguard/q
    //   114: dup
    //   115: invokespecial 1228	com/tencent/bugly/proguard/q:<init>	()V
    //   118: astore_3
    //   119: aload_3
    //   120: iconst_1
    //   121: putfield 1229	com/tencent/bugly/proguard/q:b	I
    //   124: aload_3
    //   125: aload_1
    //   126: getfield 418	com/tencent/bugly/crashreport/crash/CrashDetailBean:A	Ljava/lang/String;
    //   129: putfield 1230	com/tencent/bugly/proguard/q:c	Ljava/lang/String;
    //   132: aload_3
    //   133: aload_1
    //   134: getfield 1088	com/tencent/bugly/crashreport/crash/CrashDetailBean:B	Ljava/lang/String;
    //   137: putfield 1231	com/tencent/bugly/proguard/q:d	Ljava/lang/String;
    //   140: aload_3
    //   141: aload_1
    //   142: getfield 204	com/tencent/bugly/crashreport/crash/CrashDetailBean:r	J
    //   145: putfield 1233	com/tencent/bugly/proguard/q:e	J
    //   148: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   151: iconst_1
    //   152: invokevirtual 1235	com/tencent/bugly/proguard/o:b	(I)V
    //   155: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   158: aload_3
    //   159: invokevirtual 1238	com/tencent/bugly/proguard/o:a	(Lcom/tencent/bugly/proguard/q;)Z
    //   162: pop
    //   163: ldc_w 1240
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 774	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto +14 -> 188
    //   177: ldc_w 1242
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 774	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_0
    //   189: invokespecial 990	com/tencent/bugly/crashreport/crash/b:b	()Ljava/util/List;
    //   192: astore 4
    //   194: new 147	java/util/ArrayList
    //   197: dup
    //   198: bipush 10
    //   200: invokespecial 150	java/util/ArrayList:<init>	(I)V
    //   203: astore_3
    //   204: aload 4
    //   206: ifnull +202 -> 408
    //   209: aload 4
    //   211: invokeinterface 314 1 0
    //   216: ifle +192 -> 408
    //   219: aload_3
    //   220: aload 4
    //   222: invokestatic 994	com/tencent/bugly/crashreport/crash/b:a	(Ljava/util/List;)Ljava/util/List;
    //   225: invokeinterface 998 2 0
    //   230: pop
    //   231: aload 4
    //   233: aload_3
    //   234: invokeinterface 1001 2 0
    //   239: pop
    //   240: aload 4
    //   242: invokeinterface 314 1 0
    //   247: i2l
    //   248: ldc2_w 1243
    //   251: lcmp
    //   252: ifle +143 -> 395
    //   255: new 206	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload 5
    //   266: ldc_w 844
    //   269: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 5
    //   275: ldc_w 846
    //   278: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 5
    //   284: ldc_w 1246
    //   287: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 5
    //   293: ldc_w 1248
    //   296: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 5
    //   302: ldc_w 1250
    //   305: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 5
    //   311: ldc_w 1252
    //   314: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 5
    //   320: ldc_w 861
    //   323: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 5
    //   329: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: astore 6
    //   334: aload 5
    //   336: iconst_0
    //   337: invokevirtual 864	java/lang/StringBuilder:setLength	(I)V
    //   340: ldc_w 1254
    //   343: iconst_2
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc_w 835
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: invokestatic 833	com/tencent/bugly/proguard/o:a	()Lcom/tencent/bugly/proguard/o;
    //   358: ldc_w 835
    //   361: aload 6
    //   363: aconst_null
    //   364: aconst_null
    //   365: iconst_1
    //   366: invokevirtual 869	com/tencent/bugly/proguard/o:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/n;Z)I
    //   369: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   372: aastore
    //   373: invokestatic 236	com/tencent/bugly/proguard/y:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   376: pop
    //   377: goto +18 -> 395
    //   380: astore 5
    //   382: aload 5
    //   384: invokestatic 133	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   387: ifne +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   395: aload_0
    //   396: aload_1
    //   397: aload 4
    //   399: aload_3
    //   400: invokespecial 1256	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;Ljava/util/List;Ljava/util/List;)Z
    //   403: ifeq +5 -> 408
    //   406: iconst_1
    //   407: ireturn
    //   408: aload_0
    //   409: aload_1
    //   410: invokevirtual 901	com/tencent/bugly/crashreport/crash/b:e	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   413: getstatic 77	com/tencent/bugly/crashreport/crash/b:j	Ljava/util/Map;
    //   416: aload_1
    //   417: getfield 440	com/tencent/bugly/crashreport/crash/CrashDetailBean:b	I
    //   420: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: invokeinterface 568 2 0
    //   428: checkcast 217	java/lang/String
    //   431: astore 4
    //   433: aload 4
    //   435: invokestatic 572	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   438: ifne +32 -> 470
    //   441: invokestatic 584	com/tencent/bugly/proguard/t:a	()Lcom/tencent/bugly/proguard/t;
    //   444: new 574	com/tencent/bugly/proguard/t$c
    //   447: dup
    //   448: aload_1
    //   449: getfield 576	com/tencent/bugly/crashreport/crash/CrashDetailBean:c	Ljava/lang/String;
    //   452: aload 4
    //   454: aload_1
    //   455: getfield 204	com/tencent/bugly/crashreport/crash/CrashDetailBean:r	J
    //   458: iconst_1
    //   459: lconst_0
    //   460: ldc_w 1258
    //   463: aconst_null
    //   464: invokespecial 579	com/tencent/bugly/proguard/t$c:<init>	(Ljava/lang/String;Ljava/lang/String;JZJLjava/lang/String;Ljava/lang/String;)V
    //   467: invokevirtual 1261	com/tencent/bugly/proguard/t:a	(Lcom/tencent/bugly/proguard/t$c;)V
    //   470: aload_3
    //   471: invokestatic 903	com/tencent/bugly/crashreport/crash/b:d	(Ljava/util/List;)V
    //   474: ldc_w 1263
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokestatic 774	com/tencent/bugly/proguard/y:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   484: pop
    //   485: iconst_0
    //   486: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	b
    //   0	487	1	paramCrashDetailBean	CrashDetailBean
    //   79	7	2	m	int
    //   21	450	3	localObject1	Object
    //   25	428	4	localObject2	Object
    //   262	73	5	localStringBuilder	StringBuilder
    //   380	11	5	localThrowable	Throwable
    //   332	30	6	str	String
    // Exception table:
    //   from	to	target	type
    //   340	377	380	finally
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean)
  {
    int m = paramCrashDetailBean.b;
    if (m != 0)
    {
      if (m != 1)
      {
        if ((m != 3) || (c.a().r())) {}
      }
      else if (c.a().q()) {}
    }
    else if (!c.a().q()) {
      return;
    }
    if (this.e != null) {
      y.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
    }
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return;
    }
    if ((this.f == null) && (this.e == null)) {
      return;
    }
    Object localObject = h.iterator();
    g localg;
    while (((Iterator)localObject).hasNext())
    {
      localg = (g)((Iterator)localObject).next();
      if (g.b(localg, paramCrashDetailBean))
      {
        bool = localg.a();
        break label72;
      }
    }
    boolean bool = false;
    label72:
    if (!bool)
    {
      y.c("Should not call back.", new Object[0]);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = i;
        if (!((Map)localObject).containsKey(Integer.valueOf(paramCrashDetailBean.b)))
        {
          localObject = new StringBuilder("Cannot get crash type for crashBean type:");
          ((StringBuilder)localObject).append(paramCrashDetailBean.b);
          y.d(((StringBuilder)localObject).toString(), new Object[0]);
          return;
        }
        int m = ((Integer)((Map)localObject).get(Integer.valueOf(paramCrashDetailBean.b))).intValue();
        int n = paramCrashDetailBean.b;
        localObject = this.e;
        localg = null;
        if (localObject != null)
        {
          y.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
          y.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
          String str = this.e.b();
          if (str == null) {
            break label561;
          }
          localObject = new HashMap(1);
          ((Map)localObject).put("userData", str);
        }
        else
        {
          if (this.f == null) {
            break label561;
          }
          y.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
          localObject = this.f.onCrashHandleStart(m, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
        }
        a(paramCrashDetailBean, (Map)localObject);
        y.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
        if (this.e != null)
        {
          y.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
          localObject = this.e.a();
        }
        else
        {
          localObject = localg;
          if (this.f != null)
          {
            y.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
            localObject = this.f.onCrashHandleStart2GetExtraDatas(m, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
          }
        }
        if (localObject == null)
        {
          y.d("extra user byte is null. CrashBean won't have userExtraByteDatas.", new Object[0]);
        }
        else
        {
          if (localObject.length <= 100000)
          {
            paramCrashDetailBean.X = ((byte[])localObject);
          }
          else
          {
            y.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(100000) });
            paramCrashDetailBean.X = Arrays.copyOf((byte[])localObject, 100000);
          }
          y.a("add extra bytes %d ", new Object[] { Integer.valueOf(localObject.length) });
        }
        if (this.e != null)
        {
          y.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
          if (!this.e.c()) {
            y.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
          }
        }
        return;
      }
      finally
      {
        y.d("crash handle callback something wrong! %s", new Object[] { paramCrashDetailBean.getClass().getName() });
        if (!y.a(paramCrashDetailBean)) {
          paramCrashDetailBean.printStackTrace();
        }
        return;
      }
      label561:
      localObject = null;
    }
  }
  
  public final void e(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return;
    }
    ContentValues localContentValues = f(paramCrashDetailBean);
    if (localContentValues != null)
    {
      long l = o.a().a("t_cr", localContentValues, null, true);
      if (l >= 0L)
      {
        y.c("insert %s success!", new Object[] { "t_cr" });
        paramCrashDetailBean.a = l;
      }
    }
  }
  
  static final class a
    extends HashMap<Integer, Pair<String, String>>
  {
    a()
    {
      put(Integer.valueOf(3), new Pair("203", "103"));
      put(Integer.valueOf(7), new Pair("208", "108"));
      put(Integer.valueOf(0), new Pair("200", "100"));
      put(Integer.valueOf(1), new Pair("201", "101"));
      put(Integer.valueOf(2), new Pair("202", "102"));
      put(Integer.valueOf(4), new Pair("204", "104"));
      put(Integer.valueOf(6), new Pair("206", "106"));
      put(Integer.valueOf(5), new Pair("207", "107"));
    }
  }
  
  static final class b
    extends ArrayList<b.g>
  {
    b()
    {
      add(new b.h((byte)0));
      add(new b.i((byte)0));
      add(new b.j((byte)0));
      add(new b.k((byte)0));
      add(new b.n((byte)0));
      add(new b.o((byte)0));
      add(new b.l((byte)0));
      add(new b.m((byte)0));
    }
  }
  
  static final class c
    extends HashMap<Integer, Integer>
  {
    c()
    {
      Integer localInteger1 = Integer.valueOf(3);
      Integer localInteger2 = Integer.valueOf(4);
      put(localInteger1, localInteger2);
      Integer localInteger3 = Integer.valueOf(7);
      put(localInteger3, localInteger3);
      localInteger3 = Integer.valueOf(2);
      Integer localInteger4 = Integer.valueOf(1);
      put(localInteger3, localInteger4);
      Integer localInteger5 = Integer.valueOf(0);
      put(localInteger5, localInteger5);
      put(localInteger4, localInteger3);
      put(localInteger2, localInteger1);
      localInteger1 = Integer.valueOf(5);
      put(localInteger1, localInteger1);
      localInteger1 = Integer.valueOf(6);
      put(localInteger1, localInteger1);
    }
  }
  
  static final class d
    extends HashMap<Integer, String>
  {
    d()
    {
      put(Integer.valueOf(3), "BuglyAnrCrash");
      put(Integer.valueOf(0), "BuglyJavaCrash");
      put(Integer.valueOf(1), "BuglyNativeCrash");
    }
  }
  
  static final class e
    extends HashMap<Integer, String>
  {
    e()
    {
      put(Integer.valueOf(3), "BuglyAnrCrashReport");
      put(Integer.valueOf(0), "BuglyJavaCrashReport");
      put(Integer.valueOf(1), "BuglyNativeCrashReport");
    }
  }
  
  final class f
    implements u
  {
    f(long paramLong, List paramList, boolean paramBoolean) {}
    
    public final void a(boolean paramBoolean, String paramString)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a;
      b localb = b.this;
      List localList = paramBoolean1;
      String str;
      if (this.c) {
        str = "realtime";
      } else {
        str = "cache";
      }
      b.a(localb, localList, paramBoolean, l1 - l2, str, paramString);
      b.a(paramBoolean, paramBoolean1);
    }
  }
  
  static abstract class g
  {
    private final int a;
    
    private g(int paramInt)
    {
      this.a = paramInt;
    }
    
    abstract boolean a();
  }
  
  static final class h
    extends b.g
  {
    private h()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().r();
    }
  }
  
  static final class i
    extends b.g
  {
    private i()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return true;
    }
  }
  
  static final class j
    extends b.g
  {
    private j()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return true;
    }
  }
  
  static final class k
    extends b.g
  {
    private k()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().q();
    }
  }
  
  static final class l
    extends b.g
  {
    private l()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().t();
    }
  }
  
  static final class m
    extends b.g
  {
    private m()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().u();
    }
  }
  
  static final class n
    extends b.g
  {
    private n()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().q();
    }
  }
  
  static final class o
    extends b.g
  {
    private o()
    {
      super((byte)0);
    }
    
    final boolean a()
    {
      return c.a().s();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.b
 * JD-Core Version:    0.7.0.1
 */