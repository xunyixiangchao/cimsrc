package com.baidu.location.b;

import android.location.Location;
import android.os.Build.VERSION;
import com.baidu.location.Jni;
import com.baidu.location.c.b;
import com.baidu.location.c.i;
import com.baidu.location.e.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class r
{
  private static r A = null;
  private static long C = 0L;
  private static ArrayList<String> b = new ArrayList();
  private static ArrayList<String> c = new ArrayList();
  private static ArrayList<String> d = new ArrayList();
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static File j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static double o;
  private static double p;
  private static double q;
  private static double r;
  private static int s;
  private static int t;
  private static int u;
  private static Location v;
  private static Location w;
  private static Location x;
  private static com.baidu.location.c.h y;
  private int B = 0;
  long a = 0L;
  private a z = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.a);
    localStringBuilder.append("/yo.dat");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.a);
    localStringBuilder.append("/yoh.dat");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.a);
    localStringBuilder.append("/yom.dat");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.a);
    localStringBuilder.append("/yol.dat");
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.a);
    localStringBuilder.append("/yor.dat");
    i = localStringBuilder.toString();
    j = null;
    k = 8;
    l = 8;
    m = 16;
    n = 2048;
    o = 0.0D;
    p = 0.1D;
    q = 30.0D;
    r = 100.0D;
    s = 0;
    t = 64;
    u = 128;
    v = null;
    w = null;
    x = null;
    y = null;
  }
  
  private r()
  {
    if (Build.VERSION.SDK_INT > 28)
    {
      String str = com.baidu.location.e.h.i();
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/yo2.dat");
        e = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/yoh2.dat");
        f = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/yom2.dat");
        g = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/yol2.dat");
        h = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/yor2.dat");
        i = localStringBuilder.toString();
      }
    }
  }
  
  /* Error */
  private static int a(List<String> paramList, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +355 -> 359
    //   7: iload_1
    //   8: sipush 256
    //   11: if_icmpgt +348 -> 359
    //   14: iload_1
    //   15: ifge +6 -> 21
    //   18: goto +341 -> 359
    //   21: getstatic 96	com/baidu/location/b/r:j	Ljava/io/File;
    //   24: ifnonnull +38 -> 62
    //   27: new 171	java/io/File
    //   30: dup
    //   31: getstatic 78	com/baidu/location/b/r:e	Ljava/lang/String;
    //   34: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 13
    //   39: aload 13
    //   41: putstatic 96	com/baidu/location/b/r:j	Ljava/io/File;
    //   44: aload 13
    //   46: invokevirtual 178	java/io/File:exists	()Z
    //   49: ifne +13 -> 62
    //   52: aconst_null
    //   53: putstatic 96	com/baidu/location/b/r:j	Ljava/io/File;
    //   56: ldc 2
    //   58: monitorexit
    //   59: bipush 254
    //   61: ireturn
    //   62: new 180	java/io/RandomAccessFile
    //   65: dup
    //   66: getstatic 96	com/baidu/location/b/r:j	Ljava/io/File;
    //   69: ldc 182
    //   71: invokespecial 185	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 14
    //   76: aload 14
    //   78: invokevirtual 189	java/io/RandomAccessFile:length	()J
    //   81: lconst_1
    //   82: lcmp
    //   83: ifge +14 -> 97
    //   86: aload 14
    //   88: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   91: ldc 2
    //   93: monitorexit
    //   94: bipush 253
    //   96: ireturn
    //   97: iload_1
    //   98: i2l
    //   99: lstore 11
    //   101: aload 14
    //   103: lload 11
    //   105: invokevirtual 196	java/io/RandomAccessFile:seek	(J)V
    //   108: aload 14
    //   110: invokevirtual 200	java/io/RandomAccessFile:readInt	()I
    //   113: istore_3
    //   114: aload 14
    //   116: invokevirtual 200	java/io/RandomAccessFile:readInt	()I
    //   119: istore_2
    //   120: aload 14
    //   122: invokevirtual 200	java/io/RandomAccessFile:readInt	()I
    //   125: istore 4
    //   127: aload 14
    //   129: invokevirtual 200	java/io/RandomAccessFile:readInt	()I
    //   132: istore 5
    //   134: aload 14
    //   136: invokevirtual 203	java/io/RandomAccessFile:readLong	()J
    //   139: lstore 9
    //   141: lload 9
    //   143: lstore 7
    //   145: iload_3
    //   146: iload_2
    //   147: iload 4
    //   149: iload 5
    //   151: lload 9
    //   153: invokestatic 206	com/baidu/location/b/r:a	(IIIIJ)Z
    //   156: ifeq +172 -> 328
    //   159: iload_2
    //   160: iconst_1
    //   161: if_icmpge +6 -> 167
    //   164: goto +164 -> 328
    //   167: getstatic 104	com/baidu/location/b/r:n	I
    //   170: newarray byte
    //   172: astore 13
    //   174: getstatic 98	com/baidu/location/b/r:k	I
    //   177: istore_1
    //   178: iload_1
    //   179: ifle +93 -> 272
    //   182: iload_2
    //   183: ifle +89 -> 272
    //   186: aload 14
    //   188: iload_3
    //   189: iload_2
    //   190: iadd
    //   191: iconst_1
    //   192: isub
    //   193: iload 4
    //   195: irem
    //   196: iload 5
    //   198: imul
    //   199: i2l
    //   200: lload 7
    //   202: ladd
    //   203: invokevirtual 196	java/io/RandomAccessFile:seek	(J)V
    //   206: aload 14
    //   208: invokevirtual 200	java/io/RandomAccessFile:readInt	()I
    //   211: istore 6
    //   213: iload 6
    //   215: ifle +149 -> 364
    //   218: iload 6
    //   220: iload 5
    //   222: if_icmpge +142 -> 364
    //   225: aload 14
    //   227: aload 13
    //   229: iconst_0
    //   230: iload 6
    //   232: invokevirtual 210	java/io/RandomAccessFile:read	([BII)I
    //   235: pop
    //   236: iload 6
    //   238: iconst_1
    //   239: isub
    //   240: istore 6
    //   242: aload 13
    //   244: iload 6
    //   246: baload
    //   247: ifne +117 -> 364
    //   250: aload_0
    //   251: new 212	java/lang/String
    //   254: dup
    //   255: aload 13
    //   257: iconst_0
    //   258: iload 6
    //   260: invokespecial 215	java/lang/String:<init>	([BII)V
    //   263: invokeinterface 221 2 0
    //   268: pop
    //   269: goto +95 -> 364
    //   272: aload 14
    //   274: lload 11
    //   276: invokevirtual 196	java/io/RandomAccessFile:seek	(J)V
    //   279: aload 14
    //   281: iload_3
    //   282: invokevirtual 225	java/io/RandomAccessFile:writeInt	(I)V
    //   285: aload 14
    //   287: iload_2
    //   288: invokevirtual 225	java/io/RandomAccessFile:writeInt	(I)V
    //   291: aload 14
    //   293: iload 4
    //   295: invokevirtual 225	java/io/RandomAccessFile:writeInt	(I)V
    //   298: aload 14
    //   300: iload 5
    //   302: invokevirtual 225	java/io/RandomAccessFile:writeInt	(I)V
    //   305: aload 14
    //   307: lload 7
    //   309: invokevirtual 228	java/io/RandomAccessFile:writeLong	(J)V
    //   312: aload 14
    //   314: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   317: getstatic 98	com/baidu/location/b/r:k	I
    //   320: istore_2
    //   321: ldc 2
    //   323: monitorexit
    //   324: iload_2
    //   325: iload_1
    //   326: isub
    //   327: ireturn
    //   328: aload 14
    //   330: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   333: ldc 2
    //   335: monitorexit
    //   336: bipush 252
    //   338: ireturn
    //   339: astore_0
    //   340: goto +14 -> 354
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   348: ldc 2
    //   350: monitorexit
    //   351: bipush 251
    //   353: ireturn
    //   354: ldc 2
    //   356: monitorexit
    //   357: aload_0
    //   358: athrow
    //   359: ldc 2
    //   361: monitorexit
    //   362: iconst_m1
    //   363: ireturn
    //   364: iload_1
    //   365: iconst_1
    //   366: isub
    //   367: istore_1
    //   368: iload_2
    //   369: iconst_1
    //   370: isub
    //   371: istore_2
    //   372: goto -194 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramList	List<String>
    //   0	375	1	paramInt	int
    //   119	253	2	i1	int
    //   113	169	3	i2	int
    //   125	169	4	i3	int
    //   132	169	5	i4	int
    //   211	48	6	i5	int
    //   143	165	7	l1	long
    //   139	13	9	l2	long
    //   99	176	11	l3	long
    //   37	219	13	localObject	Object
    //   74	255	14	localRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   21	56	339	finally
    //   62	91	339	finally
    //   101	141	339	finally
    //   145	159	339	finally
    //   167	178	339	finally
    //   186	213	339	finally
    //   225	236	339	finally
    //   250	269	339	finally
    //   272	321	339	finally
    //   328	333	339	finally
    //   344	348	339	finally
    //   21	56	343	java/lang/Exception
    //   62	91	343	java/lang/Exception
    //   101	141	343	java/lang/Exception
    //   145	159	343	java/lang/Exception
    //   167	178	343	java/lang/Exception
    //   186	213	343	java/lang/Exception
    //   225	236	343	java/lang/Exception
    //   250	269	343	java/lang/Exception
    //   272	321	343	java/lang/Exception
    //   328	333	343	java/lang/Exception
  }
  
  public static r a()
  {
    try
    {
      if (A == null) {
        A = new r();
      }
      r localr = A;
      return localr;
    }
    finally {}
  }
  
  /* Error */
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_0
    //   3: iconst_1
    //   4: if_icmpne +14 -> 18
    //   7: getstatic 82	com/baidu/location/b/r:f	Ljava/lang/String;
    //   10: astore_2
    //   11: getstatic 55	com/baidu/location/b/r:b	Ljava/util/ArrayList;
    //   14: astore_1
    //   15: goto +47 -> 62
    //   18: iload_0
    //   19: iconst_2
    //   20: if_icmpne +14 -> 34
    //   23: getstatic 86	com/baidu/location/b/r:g	Ljava/lang/String;
    //   26: astore_2
    //   27: getstatic 57	com/baidu/location/b/r:c	Ljava/util/ArrayList;
    //   30: astore_1
    //   31: goto +31 -> 62
    //   34: iload_0
    //   35: iconst_3
    //   36: if_icmpne +14 -> 50
    //   39: getstatic 90	com/baidu/location/b/r:h	Ljava/lang/String;
    //   42: astore_2
    //   43: getstatic 59	com/baidu/location/b/r:d	Ljava/util/ArrayList;
    //   46: astore_1
    //   47: goto +15 -> 62
    //   50: iload_0
    //   51: iconst_4
    //   52: if_icmpne +82 -> 134
    //   55: getstatic 94	com/baidu/location/b/r:i	Ljava/lang/String;
    //   58: astore_2
    //   59: goto -16 -> 43
    //   62: aload_1
    //   63: ifnonnull +5 -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: aload_1
    //   69: invokeinterface 239 1 0
    //   74: iconst_1
    //   75: if_icmpge +9 -> 84
    //   78: aload_2
    //   79: aload_1
    //   80: invokestatic 242	com/baidu/location/b/r:a	(Ljava/lang/String;Ljava/util/List;)Z
    //   83: pop
    //   84: ldc 2
    //   86: monitorenter
    //   87: aload_1
    //   88: invokeinterface 239 1 0
    //   93: istore_0
    //   94: aload_3
    //   95: astore_2
    //   96: iload_0
    //   97: ifle +26 -> 123
    //   100: iload_0
    //   101: iconst_1
    //   102: isub
    //   103: istore_0
    //   104: aload_1
    //   105: iload_0
    //   106: invokeinterface 246 2 0
    //   111: checkcast 212	java/lang/String
    //   114: astore_2
    //   115: aload_1
    //   116: iload_0
    //   117: invokeinterface 249 2 0
    //   122: pop
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_2
    //   127: areturn
    //   128: astore_1
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aconst_null
    //   135: areturn
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: goto -16 -> 123
    //   142: astore_1
    //   143: goto -20 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramInt	int
    //   14	102	1	localArrayList	ArrayList
    //   128	5	1	localObject1	Object
    //   136	1	1	localException1	Exception
    //   142	1	1	localException2	Exception
    //   10	129	2	localObject2	Object
    //   1	137	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   87	94	128	finally
    //   104	115	128	finally
    //   115	123	128	finally
    //   123	126	128	finally
    //   129	132	128	finally
    //   104	115	136	java/lang/Exception
    //   115	123	142	java/lang/Exception
  }
  
  private static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    if (paramInt == 1)
    {
      localObject2 = f;
      if (paramBoolean) {
        return;
      }
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = b;
      break label106;
      if (paramInt != 2) {
        break label56;
      }
      localObject1 = g;
      localObject2 = localObject1;
      if (!paramBoolean) {
        break;
      }
      localObject2 = localObject1;
    }
    for (;;)
    {
      localObject1 = c;
      break label106;
      label56:
      if (paramInt != 3) {
        break label89;
      }
      localObject1 = h;
      localObject2 = localObject1;
      if (!paramBoolean) {
        break;
      }
      localObject2 = localObject1;
    }
    for (;;)
    {
      localObject1 = d;
      break;
      label89:
      if (paramInt != 4) {
        break label483;
      }
      localObject2 = i;
      if (!paramBoolean) {
        break label483;
      }
    }
    label106:
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      d((String)localObject2);
    }
    for (;;)
    {
      int i3;
      int i1;
      try
      {
        localObject2 = new RandomAccessFile((File)localObject3, "rw");
        ((RandomAccessFile)localObject2).seek(4L);
        int i8 = ((RandomAccessFile)localObject2).readInt();
        int i9 = ((RandomAccessFile)localObject2).readInt();
        int i4 = ((RandomAccessFile)localObject2).readInt();
        i5 = ((RandomAccessFile)localObject2).readInt();
        i2 = ((RandomAccessFile)localObject2).readInt();
        i3 = ((List)localObject1).size();
        int i10 = l;
        int i7 = 0;
        i6 = 0;
        i1 = i2;
        if (i3 > i10)
        {
          i1 = i2;
          if (paramBoolean) {
            i1 = i2 + 1;
          }
          if (i4 < i8)
          {
            ((RandomAccessFile)localObject2).seek(i9 * i4 + 128);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)((List)localObject1).get(0));
            ((StringBuilder)localObject3).append('\000');
            localObject3 = ((StringBuilder)localObject3).toString().getBytes();
            ((RandomAccessFile)localObject2).writeInt(localObject3.length);
            ((RandomAccessFile)localObject2).write((byte[])localObject3, 0, localObject3.length);
            ((List)localObject1).remove(0);
            i4 += 1;
            break label490;
          }
          if (!paramBoolean) {
            break label501;
          }
          ((RandomAccessFile)localObject2).seek(i5 * i9 + 128);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)((List)localObject1).get(0));
          ((StringBuilder)localObject3).append('\000');
          localObject3 = ((StringBuilder)localObject3).toString().getBytes();
          ((RandomAccessFile)localObject2).writeInt(localObject3.length);
          ((RandomAccessFile)localObject2).write((byte[])localObject3, 0, localObject3.length);
          ((List)localObject1).remove(0);
          i2 = i5 + 1;
          if (i2 > i4) {
            i2 = i7;
          }
        }
        else
        {
          ((RandomAccessFile)localObject2).seek(12L);
          ((RandomAccessFile)localObject2).writeInt(i4);
          ((RandomAccessFile)localObject2).writeInt(i5);
          ((RandomAccessFile)localObject2).writeInt(i1);
          ((RandomAccessFile)localObject2).close();
          if ((i6 != 0) && (paramInt < 4)) {
            a(paramInt + 1, true);
          }
          label483:
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i5 = i2;
      label490:
      i3 -= 1;
      int i2 = i1;
      continue;
      label501:
      int i6 = 1;
    }
  }
  
  public static void a(com.baidu.location.c.a parama, com.baidu.location.c.h paramh, Location paramLocation, String paramString)
  {
    if ((com.baidu.location.e.h.u == 3) && (!a(paramLocation, paramh)) && (!a(paramLocation, false))) {
      return;
    }
    if (parama != null)
    {
      if (parama.c()) {
        return;
      }
      Object localObject;
      if (parama.a())
      {
        localObject = paramh;
        if (!a(paramLocation, paramh)) {
          localObject = null;
        }
        paramh = com.baidu.location.e.h.a(parama, (com.baidu.location.c.h)localObject, paramLocation, paramString, 1);
        if (paramh != null)
        {
          if (Build.VERSION.SDK_INT > 28)
          {
            parama = Jni.encodeTp4(paramh);
          }
          else
          {
            parama = Jni.encodeTp4(paramh);
            if ((parama == null) || (parama.length() >= 1000)) {
              parama = Jni.encode(paramh);
            }
          }
          a(parama);
          w = paramLocation;
          v = paramLocation;
          if (localObject != null) {
            y = (com.baidu.location.c.h)localObject;
          }
        }
        return;
      }
      if ((paramh != null) && (paramh.l()) && (a(paramLocation, paramh)))
      {
        if ((!a(paramLocation)) && (!b.a().d()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("&cfr=1");
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
          break;
          if ((!a(paramLocation)) && (b.a().d()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("&cfr=3");
            ((StringBuilder)localObject).append(paramString);
            localObject = ((StringBuilder)localObject).toString();
            break;
          }
          localObject = paramString;
          if (!b.a().d()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("&cfr=2");
        }
        paramString = com.baidu.location.e.h.a(parama, paramh, paramLocation, (String)localObject, 2);
        if (paramString != null)
        {
          if (Build.VERSION.SDK_INT > 28)
          {
            parama = Jni.encodeTp4(paramString);
          }
          else
          {
            parama = Jni.encodeTp4(paramString);
            if ((parama == null) || (parama.length() >= 1000)) {
              parama = Jni.encode(paramString);
            }
          }
          b(parama);
          x = paramLocation;
          v = paramLocation;
          y = paramh;
        }
        return;
      }
      if ((!a(paramLocation)) && (!b.a().d()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&cfr=1");
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        break;
        if ((!a(paramLocation)) && (b.a().d()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("&cfr=3");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
          break;
        }
        localObject = paramString;
        if (!b.a().d()) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&cfr=2");
      }
      paramString = paramh;
      if (!a(paramLocation, paramh)) {
        paramString = null;
      }
      paramh = com.baidu.location.e.h.a(parama, paramString, paramLocation, (String)localObject, 3);
      if (paramh != null)
      {
        if (Build.VERSION.SDK_INT > 28)
        {
          parama = Jni.encodeTp4(paramh);
        }
        else
        {
          parama = Jni.encodeTp4(paramh);
          if ((parama == null) || (parama.length() >= 1000)) {
            parama = Jni.encode(paramh);
          }
        }
        c(parama);
        v = paramLocation;
        if (paramString != null) {
          y = paramString;
        }
      }
    }
  }
  
  private static void a(String paramString)
  {
    e(paramString);
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= paramInt3) {
        return false;
      }
      if (paramInt2 >= 0)
      {
        if (paramInt2 > paramInt3) {
          return false;
        }
        if (paramInt3 >= 0)
        {
          if (paramInt3 > 1024) {
            return false;
          }
          if (paramInt4 >= 128) {
            return paramInt4 <= 1024;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean a(Location paramLocation)
  {
    boolean bool = false;
    if (paramLocation == null) {
      return false;
    }
    Location localLocation = w;
    if ((localLocation != null) && (v != null))
    {
      double d1 = paramLocation.distanceTo(localLocation);
      double d2 = com.baidu.location.e.h.S;
      double d3 = com.baidu.location.e.h.T;
      double d4 = com.baidu.location.e.h.U;
      if (paramLocation.distanceTo(v) > d2 * d1 * d1 + d3 * d1 + d4) {
        bool = true;
      }
      return bool;
    }
    w = paramLocation;
    return true;
  }
  
  private static boolean a(Location paramLocation, com.baidu.location.c.h paramh)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLocation != null)
    {
      bool1 = bool2;
      if (paramh != null)
      {
        List localList = paramh.a;
        bool1 = bool2;
        if (localList != null)
        {
          if (localList.isEmpty()) {
            return false;
          }
          if (paramh.b(y)) {
            return false;
          }
          paramh = x;
          bool2 = true;
          bool1 = bool2;
          if (paramh == null)
          {
            x = paramLocation;
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Location paramLocation, boolean paramBoolean)
  {
    return com.baidu.location.c.d.a(v, paramLocation, paramBoolean);
  }
  
  private static boolean a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    int i2;
    int i4;
    int i1;
    boolean bool1;
    int i3;
    boolean bool2;
    label225:
    for (;;)
    {
      try
      {
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(8L);
        i5 = paramString.readInt();
        i2 = paramString.readInt();
        i4 = paramString.readInt();
        arrayOfByte = new byte[n];
        i1 = l;
        i1 += 1;
        bool1 = false;
        if ((i1 > 0) && (i2 > 0))
        {
          i3 = i4;
          if (i2 < i4) {
            i3 = 0;
          }
          l1 = (i2 - 1) * i5 + 128;
        }
      }
      catch (Exception paramString)
      {
        int i5;
        byte[] arrayOfByte;
        long l1;
        return false;
      }
      try
      {
        paramString.seek(l1);
        i4 = paramString.readInt();
        bool2 = bool1;
        if (i4 <= 0) {
          break label225;
        }
        bool2 = bool1;
        if (i4 >= i5) {
          break label225;
        }
        paramString.read(arrayOfByte, 0, i4);
        i4 -= 1;
        bool2 = bool1;
        if (arrayOfByte[i4] != 0) {
          break label225;
        }
        paramList.add(0, new String(arrayOfByte, 0, i4));
        bool2 = true;
      }
      catch (Exception paramString)
      {
        continue;
        i1 -= 1;
        i2 -= 1;
        i4 = i3;
        bool1 = bool2;
      }
      paramString.seek(12L);
      paramString.writeInt(i2);
      paramString.writeInt(i4);
      paramString.close();
      return bool1;
      return bool1;
    }
  }
  
  public static String b()
  {
    return f();
  }
  
  private static void b(String paramString)
  {
    e(paramString);
  }
  
  private static void c(String paramString)
  {
    e(paramString);
  }
  
  public static void d()
  {
    l = 0;
    a(1, false);
    a(2, false);
    a(3, false);
    l = 8;
  }
  
  private static void d(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        paramString = new File(g.a);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        paramString = localFile;
        if (!localFile.createNewFile()) {
          paramString = null;
        }
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(0L);
        paramString.writeInt(32);
        paramString.writeInt(2048);
        paramString.writeInt(5120);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.close();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static String e()
  {
    Object localObject5 = new File(g);
    boolean bool = ((File)localObject5).exists();
    localObject3 = null;
    Object localObject1 = localObject3;
    if (bool) {}
    try
    {
      localObject5 = new RandomAccessFile((File)localObject5, "rw");
      ((RandomAccessFile)localObject5).seek(20L);
      i1 = ((RandomAccessFile)localObject5).readInt();
      if (i1 > 128)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&p1=");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i1;
        label108:
        label118:
        localObject2 = localObject3;
      }
    }
    try
    {
      ((RandomAccessFile)localObject5).seek(20L);
      ((RandomAccessFile)localObject5).writeInt(0);
      ((RandomAccessFile)localObject5).close();
      return localObject1;
    }
    catch (Exception localException5)
    {
      break label108;
    }
    break label118;
    ((RandomAccessFile)localObject5).close();
    localObject1 = localObject3;
    localObject5 = new File(h);
    localObject3 = localObject1;
    if (((File)localObject5).exists()) {}
    try
    {
      localObject5 = new RandomAccessFile((File)localObject5, "rw");
      ((RandomAccessFile)localObject5).seek(20L);
      i1 = ((RandomAccessFile)localObject5).readInt();
      if (i1 > 256)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("&p2=");
        ((StringBuilder)localObject3).append(i1);
        localObject3 = ((StringBuilder)localObject3).toString();
      }
    }
    catch (Exception localException6)
    {
      for (;;)
      {
        label222:
        localObject4 = localObject2;
      }
    }
    try
    {
      ((RandomAccessFile)localObject5).seek(20L);
      ((RandomAccessFile)localObject5).writeInt(0);
      ((RandomAccessFile)localObject5).close();
      return localObject3;
    }
    catch (Exception localException2)
    {
      break label222;
    }
    break label232;
    ((RandomAccessFile)localObject5).close();
    localObject3 = localObject1;
    label232:
    localObject1 = new File(i);
    if (((File)localObject1).exists()) {}
    try
    {
      localObject1 = new RandomAccessFile((File)localObject1, "rw");
      ((RandomAccessFile)localObject1).seek(20L);
      i1 = ((RandomAccessFile)localObject1).readInt();
      if (i1 > 512)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("&p3=");
        ((StringBuilder)localObject5).append(i1);
        localObject5 = ((StringBuilder)localObject5).toString();
      }
    }
    catch (Exception localException3)
    {
      label331:
      Object localObject2;
      Object localObject4;
      return localObject4;
    }
    try
    {
      ((RandomAccessFile)localObject1).seek(20L);
      ((RandomAccessFile)localObject1).writeInt(0);
      ((RandomAccessFile)localObject1).close();
      return localObject5;
    }
    catch (Exception localException4)
    {
      break label331;
    }
    return localObject5;
    ((RandomAccessFile)localObject1).close();
    return localObject3;
  }
  
  private static void e(String paramString)
  {
    try
    {
      boolean bool = paramString.contains("err!");
      if (bool) {
        return;
      }
      int i1 = com.baidu.location.e.h.p;
      ArrayList localArrayList;
      if (i1 == 1)
      {
        localArrayList = b;
      }
      else if (i1 == 2)
      {
        localArrayList = c;
      }
      else
      {
        if (i1 != 3) {
          break label128;
        }
        localArrayList = d;
      }
      if (localArrayList == null) {
        return;
      }
      if (localArrayList.size() <= m) {
        localArrayList.add(paramString);
      }
      if (localArrayList.size() >= m) {
        a(i1, false);
      }
      while (localArrayList.size() > m) {
        localArrayList.remove(0);
      }
      return;
      label128:
      return;
    }
    finally {}
  }
  
  private static String f()
  {
    int i1 = 1;
    String str = null;
    while (i1 < 5)
    {
      str = a(i1);
      if (str != null) {
        return str;
      }
      i1 += 1;
    }
    a(d, t);
    if (d.size() > 0)
    {
      str = (String)d.get(0);
      d.remove(0);
    }
    if (str != null) {
      return str;
    }
    a(d, s);
    if (d.size() > 0)
    {
      str = (String)d.get(0);
      d.remove(0);
    }
    if (str != null) {
      return str;
    }
    a(d, u);
    if (d.size() > 0)
    {
      str = (String)d.get(0);
      d.remove(0);
    }
    return str;
  }
  
  public void c()
  {
    if (!i.a().i()) {
      return;
    }
    if (!com.baidu.location.e.h.b()) {
      this.z.b();
    }
  }
  
  private class a
    extends com.baidu.location.e.f
  {
    boolean a = false;
    int b = 0;
    int c = 0;
    private ArrayList<String> e = new ArrayList();
    private boolean p = true;
    
    public a()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      if (this.b != 1) {
        this.g = com.baidu.location.e.h.d();
      }
      this.h = 2;
      if (this.e != null)
      {
        int i = 0;
        while (i < this.e.size())
        {
          StringBuilder localStringBuilder;
          String str;
          if (this.b == 1)
          {
            localObject = this.j;
            localStringBuilder = new StringBuilder();
            str = "cldc[";
          }
          else
          {
            localObject = this.j;
            localStringBuilder = new StringBuilder();
            str = "cltr[";
          }
          localStringBuilder.append(str);
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          ((Map)localObject).put(localStringBuilder.toString(), this.e.get(i));
          i += 1;
        }
        Object localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        this.j.put("trtm", localObject);
        if (this.b != 1) {
          this.j.put("qt", "cltrg");
        }
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.i != null))
      {
        Object localObject = this.e;
        if (localObject != null) {
          ((ArrayList)localObject).clear();
        }
        try
        {
          localObject = new JSONObject(this.i);
          if ((((JSONObject)localObject).has("ison")) && (((JSONObject)localObject).getInt("ison") == 0)) {
            this.p = false;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Map localMap = this.j;
      if (localMap != null) {
        localMap.clear();
      }
      this.a = false;
    }
    
    public void b()
    {
      int i;
      int j;
      label124:
      do
      {
        do
        {
          try
          {
            boolean bool = this.a;
            if (bool) {
              return;
            }
            i = com.baidu.location.e.f.o;
            if (i > 4)
            {
              j = this.c;
              if (j < i)
              {
                this.c = (j + 1);
                return;
              }
            }
            this.c = 0;
            this.a = true;
            this.b = 0;
          }
          finally {}
          try
          {
            localObject1 = this.e;
            if ((localObject1 != null) && (((ArrayList)localObject1).size() >= 1)) {
              break;
            }
            if (this.e == null) {
              this.e = new ArrayList();
            }
            this.b = 0;
            i = 0;
            j = this.b;
            str = null;
            if (j >= 2) {
              break label374;
            }
            localObject1 = r.b();
          }
          catch (Exception localException1)
          {
            break label334;
            Object localObject3 = null;
            break label124;
            if (localObject3 != null) {
              continue;
            }
            break;
          }
          if ((localObject1 == null) && (this.b != 1) && (this.p)) {
            this.b = 2;
          }
          try
          {
            localObject1 = f.a();
          }
          catch (Exception localException2)
          {
            localObject3 = str;
          }
          this.b = 1;
          break label380;
        } while (((String)localObject1).contains("err!"));
        this.e.add(localObject1);
        j = i + ((String)localObject1).length();
        i = j;
      } while (j < com.baidu.location.e.a.h);
      Object localObject1 = this.e;
      if (localObject1 != null)
      {
        i = ((ArrayList)localObject1).size();
        if (i >= 1)
        {
          if (this.b != 1)
          {
            localObject1 = p.a().c();
            if (localObject1 != null)
            {
              str = com.baidu.location.e.h.d();
              a((ExecutorService)localObject1, str);
              break label307;
            }
          }
          for (localObject1 = com.baidu.location.e.h.d();; localObject1 = com.baidu.location.e.d.c)
          {
            b((String)localObject1);
            break label307;
            localObject1 = p.a().c();
            if (localObject1 != null)
            {
              str = com.baidu.location.e.d.c;
              break;
            }
          }
          label307:
          return;
        }
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((ArrayList)localObject1).clear();
      }
      this.a = false;
      return;
      label334:
      localObject1 = this.e;
      if (localObject1 != null) {
        ((ArrayList)localObject1).clear();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.r
 * JD-Core Version:    0.7.0.1
 */