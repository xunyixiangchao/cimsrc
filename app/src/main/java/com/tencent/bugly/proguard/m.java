package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m
{
  public static final long a = ;
  private static m b;
  private Context c;
  private String d;
  private Map<Integer, Map<String, l>> e;
  private SharedPreferences f;
  
  private m(Context paramContext)
  {
    this.c = paramContext;
    this.e = new HashMap();
    this.d = a.b().d;
    this.f = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static m a()
  {
    try
    {
      m localm = b;
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new m(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private <T extends List<?>> void a(int paramInt, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 38	com/tencent/bugly/proguard/m:c	Landroid/content/Context;
    //   13: ldc 53
    //   15: iconst_0
    //   16: invokevirtual 81	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   19: astore_3
    //   20: new 83	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: iload_1
    //   32: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 90	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: aload 4
    //   43: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_3
    //   50: new 99	java/io/ObjectOutputStream
    //   53: dup
    //   54: new 101	java/io/FileOutputStream
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 107	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_3
    //   70: aload 4
    //   72: aload_2
    //   73: invokevirtual 111	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   76: aload 4
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 114	java/io/ObjectOutputStream:close	()V
    //   83: goto +77 -> 160
    //   86: astore_3
    //   87: aload 4
    //   89: astore_2
    //   90: aload_3
    //   91: astore 4
    //   93: goto +13 -> 106
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_3
    //   99: goto +37 -> 136
    //   102: astore 4
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: astore_3
    //   108: aload 4
    //   110: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   113: aload_2
    //   114: astore_3
    //   115: ldc 119
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 124	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_2
    //   126: ifnull +6 -> 132
    //   129: goto -50 -> 79
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore_2
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 114	java/io/ObjectOutputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: goto +16 -> 163
    //   150: ldc 126
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 128	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   159: pop
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: goto -18 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	m
    //   0	171	1	paramInt	int
    //   0	171	2	paramT	T
    //   19	51	3	localObject1	Object
    //   86	5	3	localIOException1	java.io.IOException
    //   98	43	3	?	T
    //   27	65	4	localObject2	Object
    //   102	7	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   70	76	86	java/io/IOException
    //   50	67	96	finally
    //   50	67	102	java/io/IOException
    //   70	76	135	finally
    //   108	113	135	finally
    //   115	125	135	finally
    //   9	50	146	finally
    //   79	83	146	finally
    //   140	144	146	finally
    //   144	146	146	finally
    //   150	160	146	finally
    //   9	50	167	java/lang/Exception
    //   79	83	167	java/lang/Exception
    //   140	144	167	java/lang/Exception
    //   144	146	167	java/lang/Exception
  }
  
  /* Error */
  private boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 72	com/tencent/bugly/proguard/m:c	(I)Ljava/util/List;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: new 151	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 152	java/util/ArrayList:<init>	()V
    //   29: astore 5
    //   31: new 151	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 152	java/util/ArrayList:<init>	()V
    //   38: astore 6
    //   40: aload 4
    //   42: invokeinterface 158 1 0
    //   47: astore 7
    //   49: aload 7
    //   51: invokeinterface 164 1 0
    //   56: ifeq +84 -> 140
    //   59: aload 7
    //   61: invokeinterface 168 1 0
    //   66: checkcast 136	com/tencent/bugly/proguard/l
    //   69: astore 8
    //   71: aload 8
    //   73: getfield 141	com/tencent/bugly/proguard/l:b	Ljava/lang/String;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +33 -> 113
    //   83: aload 9
    //   85: aload_0
    //   86: getfield 51	com/tencent/bugly/proguard/m:d	Ljava/lang/String;
    //   89: invokevirtual 147	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   92: ifeq +21 -> 113
    //   95: aload 8
    //   97: getfield 171	com/tencent/bugly/proguard/l:d	I
    //   100: ifle +13 -> 113
    //   103: aload 5
    //   105: aload 8
    //   107: invokeinterface 175 2 0
    //   112: pop
    //   113: aload 8
    //   115: getfield 177	com/tencent/bugly/proguard/l:c	J
    //   118: ldc2_w 178
    //   121: ladd
    //   122: lload_2
    //   123: lcmp
    //   124: ifge -75 -> 49
    //   127: aload 6
    //   129: aload 8
    //   131: invokeinterface 175 2 0
    //   136: pop
    //   137: goto -88 -> 49
    //   140: aload 5
    //   142: invokestatic 185	java/util/Collections:sort	(Ljava/util/List;)V
    //   145: aload 5
    //   147: invokeinterface 189 1 0
    //   152: iconst_2
    //   153: if_icmplt +66 -> 219
    //   156: aload 5
    //   158: invokeinterface 189 1 0
    //   163: ifle +52 -> 215
    //   166: aload 5
    //   168: aload 5
    //   170: invokeinterface 189 1 0
    //   175: iconst_1
    //   176: isub
    //   177: invokeinterface 193 2 0
    //   182: checkcast 136	com/tencent/bugly/proguard/l
    //   185: getfield 177	com/tencent/bugly/proguard/l:c	J
    //   188: ldc2_w 178
    //   191: ladd
    //   192: lload_2
    //   193: lcmp
    //   194: ifge +21 -> 215
    //   197: aload 4
    //   199: invokeinterface 196 1 0
    //   204: aload_0
    //   205: iload_1
    //   206: aload 4
    //   208: invokespecial 133	com/tencent/bugly/proguard/m:a	(ILjava/util/List;)V
    //   211: aload_0
    //   212: monitorexit
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_0
    //   216: monitorexit
    //   217: iconst_1
    //   218: ireturn
    //   219: aload 4
    //   221: aload 6
    //   223: invokeinterface 200 2 0
    //   228: pop
    //   229: aload_0
    //   230: iload_1
    //   231: aload 4
    //   233: invokespecial 133	com/tencent/bugly/proguard/m:a	(ILjava/util/List;)V
    //   236: aload_0
    //   237: monitorexit
    //   238: iconst_0
    //   239: ireturn
    //   240: astore 4
    //   242: goto +17 -> 259
    //   245: ldc 202
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 128	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   254: pop
    //   255: aload_0
    //   256: monitorexit
    //   257: iconst_0
    //   258: ireturn
    //   259: aload_0
    //   260: monitorexit
    //   261: aload 4
    //   263: athrow
    //   264: astore 4
    //   266: goto -21 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	m
    //   0	269	1	paramInt	int
    //   21	172	2	l	long
    //   7	225	4	localList	List
    //   240	22	4	localObject	Object
    //   264	1	4	localException	Exception
    //   29	140	5	localArrayList1	ArrayList
    //   38	184	6	localArrayList2	ArrayList
    //   47	13	7	localIterator	Iterator
    //   69	61	8	locall	l
    //   76	8	9	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	240	finally
    //   18	49	240	finally
    //   49	78	240	finally
    //   83	113	240	finally
    //   113	137	240	finally
    //   140	211	240	finally
    //   219	236	240	finally
    //   245	255	240	finally
    //   2	9	264	java/lang/Exception
    //   18	49	264	java/lang/Exception
    //   49	78	264	java/lang/Exception
    //   83	113	264	java/lang/Exception
    //   113	137	264	java/lang/Exception
    //   140	211	264	java/lang/Exception
    //   219	236	264	java/lang/Exception
  }
  
  /* Error */
  private <T extends List<?>> T c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/bugly/proguard/m:c	Landroid/content/Context;
    //   6: ldc 53
    //   8: iconst_0
    //   9: invokevirtual 81	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   12: astore_3
    //   13: new 83	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: iload_1
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 90	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 215	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +7 -> 56
    //   52: aload_0
    //   53: monitorexit
    //   54: aconst_null
    //   55: areturn
    //   56: new 217	java/io/ObjectInputStream
    //   59: dup
    //   60: new 219	java/io/FileInputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 223	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: invokevirtual 226	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 154	java/util/List
    //   84: astore 5
    //   86: aload 4
    //   88: invokevirtual 227	java/io/ObjectInputStream:close	()V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 5
    //   95: areturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore 4
    //   100: goto +64 -> 164
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 4
    //   108: astore_3
    //   109: ldc 229
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 124	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload 4
    //   121: ifnull +69 -> 190
    //   124: aload 4
    //   126: invokevirtual 227	java/io/ObjectInputStream:close	()V
    //   129: goto +61 -> 190
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: astore_3
    //   138: ldc 119
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 124	com/tencent/bugly/proguard/y:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload 4
    //   150: ifnull +40 -> 190
    //   153: goto -29 -> 124
    //   156: astore 5
    //   158: aload_3
    //   159: astore 4
    //   161: aload 5
    //   163: astore_3
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 227	java/io/ObjectInputStream:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto +17 -> 194
    //   180: ldc 231
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 128	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: monitorexit
    //   192: aconst_null
    //   193: areturn
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: goto -19 -> 180
    //   202: astore_3
    //   203: goto -71 -> 132
    //   206: astore_3
    //   207: goto -104 -> 103
    //   210: astore_3
    //   211: goto -76 -> 135
    //   214: astore_3
    //   215: goto -109 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	m
    //   0	218	1	paramInt	int
    //   47	2	2	bool	boolean
    //   12	64	3	localObject1	Object
    //   96	1	3	localObject2	Object
    //   108	67	3	localObject3	Object
    //   176	21	3	localObject4	Object
    //   198	1	3	localException	Exception
    //   202	1	3	localIOException1	java.io.IOException
    //   206	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   210	1	3	localIOException2	java.io.IOException
    //   214	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   20	150	4	localObject5	Object
    //   84	10	5	localList	List
    //   156	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   56	73	96	finally
    //   76	86	156	finally
    //   109	119	156	finally
    //   138	148	156	finally
    //   2	48	176	finally
    //   86	91	176	finally
    //   124	129	176	finally
    //   169	174	176	finally
    //   174	176	176	finally
    //   180	190	176	finally
    //   2	48	198	java/lang/Exception
    //   86	91	198	java/lang/Exception
    //   124	129	198	java/lang/Exception
    //   169	174	198	java/lang/Exception
    //   174	176	198	java/lang/Exception
    //   56	73	202	java/io/IOException
    //   56	73	206	java/lang/ClassNotFoundException
    //   76	86	210	java/io/IOException
    //   76	86	214	java/lang/ClassNotFoundException
  }
  
  public final void a(int paramInt1, final int paramInt2)
  {
    x.a().a(new a(1004, paramInt2));
  }
  
  /* Error */
  public final boolean a(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 61	com/tencent/bugly/proguard/m:f	Landroid/content/SharedPreferences;
    //   10: astore 4
    //   12: iload_3
    //   13: istore_2
    //   14: new 83	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: iload_3
    //   24: istore_2
    //   25: aload 5
    //   27: iload_1
    //   28: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: iload_3
    //   33: istore_2
    //   34: aload 5
    //   36: ldc 246
    //   38: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: iload_3
    //   43: istore_2
    //   44: aload 5
    //   46: aload_0
    //   47: getfield 51	com/tencent/bugly/proguard/m:d	Ljava/lang/String;
    //   50: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: iload_3
    //   55: istore_2
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: iconst_1
    //   64: invokeinterface 255 3 0
    //   69: istore_3
    //   70: iload_3
    //   71: istore_2
    //   72: invokestatic 238	com/tencent/bugly/proguard/x:a	()Lcom/tencent/bugly/proguard/x;
    //   75: new 8	com/tencent/bugly/proguard/m$b
    //   78: dup
    //   79: aload_0
    //   80: iload_1
    //   81: invokespecial 258	com/tencent/bugly/proguard/m$b:<init>	(Lcom/tencent/bugly/proguard/m;I)V
    //   84: invokevirtual 244	com/tencent/bugly/proguard/x:a	(Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_3
    //   91: ireturn
    //   92: astore 4
    //   94: goto +18 -> 112
    //   97: ldc_w 260
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 128	com/tencent/bugly/proguard/y:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_0
    //   109: monitorexit
    //   110: iload_2
    //   111: ireturn
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 4
    //   116: athrow
    //   117: astore 4
    //   119: goto -22 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	m
    //   0	122	1	paramInt	int
    //   5	106	2	bool1	boolean
    //   3	88	3	bool2	boolean
    //   10	47	4	localSharedPreferences	SharedPreferences
    //   92	23	4	localObject	Object
    //   117	1	4	localException	Exception
    //   21	38	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	12	92	finally
    //   14	23	92	finally
    //   25	32	92	finally
    //   34	42	92	finally
    //   44	54	92	finally
    //   56	70	92	finally
    //   72	88	92	finally
    //   97	108	92	finally
    //   6	12	117	java/lang/Exception
    //   14	23	117	java/lang/Exception
    //   25	32	117	java/lang/Exception
    //   34	42	117	java/lang/Exception
    //   44	54	117	java/lang/Exception
    //   56	70	117	java/lang/Exception
    //   72	88	117	java/lang/Exception
  }
  
  final class a
    implements Runnable
  {
    a(int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      try
      {
        if (TextUtils.isEmpty(m.a(m.this))) {
          return;
        }
        Object localObject2 = m.a(m.this, this.a);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        if (m.b(m.this).get(Integer.valueOf(this.a)) == null)
        {
          localObject2 = new HashMap();
          m.b(m.this).put(Integer.valueOf(this.a), localObject2);
        }
        if (((Map)m.b(m.this).get(Integer.valueOf(this.a))).get(m.a(m.this)) == null)
        {
          localObject2 = new l();
          ((l)localObject2).a = this.a;
          ((l)localObject2).g = m.a;
          ((l)localObject2).b = m.a(m.this);
          ((l)localObject2).f = a.b().i;
          ((l)localObject2).e = a.b().f;
          ((l)localObject2).c = System.currentTimeMillis();
          ((l)localObject2).d = paramInt2;
          ((Map)m.b(m.this).get(Integer.valueOf(this.a))).put(m.a(m.this), localObject2);
        }
        else
        {
          localObject2 = (l)((Map)m.b(m.this).get(Integer.valueOf(this.a))).get(m.a(m.this));
          ((l)localObject2).d = paramInt2;
        }
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          l locall = (l)localIterator.next();
          int j = i;
          if (m.a(locall, (l)localObject2))
          {
            j = 1;
            locall.d = ((l)localObject2).d;
          }
          i = j;
          if (m.b(locall, (l)localObject2))
          {
            localArrayList.add(locall);
            i = j;
          }
        }
        ((List)localObject1).removeAll(localArrayList);
        if (i == 0) {
          ((List)localObject1).add(localObject2);
        }
        m.a(m.this, this.a, (List)localObject1);
        return;
      }
      catch (Exception localException)
      {
        label426:
        break label426;
      }
      y.e("saveCrashRecord failed", new Object[0]);
    }
  }
  
  final class b
    implements Runnable
  {
    b(int paramInt) {}
    
    public final void run()
    {
      boolean bool = m.b(m.this, paramInt);
      SharedPreferences.Editor localEditor = m.c(m.this).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(m.a(m.this));
      localEditor.putBoolean(localStringBuilder.toString(), bool ^ true).commit();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.m
 * JD-Core Version:    0.7.0.1
 */