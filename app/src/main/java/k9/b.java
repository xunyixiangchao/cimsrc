package k9;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;

public class b
{
  private Hashtable<String, b> a = new Hashtable();
  private String b;
  private b c;
  
  public b a(String paramString)
  {
    return (b)this.a.get(paramString);
  }
  
  public b b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.b;
  }
  
  /* Error */
  public void d(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 36	java/io/InputStreamReader
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   10: astore_3
    //   11: new 40	java/io/BufferedReader
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 43	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +48 -> 74
    //   29: aload_1
    //   30: ldc 48
    //   32: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore_1
    //   36: aload_1
    //   37: arraylength
    //   38: iconst_2
    //   39: if_icmpeq +6 -> 45
    //   42: goto -22 -> 20
    //   45: new 2	k9/b
    //   48: dup
    //   49: invokespecial 55	k9/b:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: aload_1
    //   57: iconst_1
    //   58: aaload
    //   59: putfield 32	k9/b:b	Ljava/lang/String;
    //   62: aload_0
    //   63: aload_1
    //   64: iconst_0
    //   65: aaload
    //   66: aload 4
    //   68: invokevirtual 59	k9/b:g	(Ljava/lang/String;Lk9/b;)V
    //   71: goto -51 -> 20
    //   74: aload_3
    //   75: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   78: aload_2
    //   79: invokevirtual 63	java/io/BufferedReader:close	()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_1
    //   86: goto +14 -> 100
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_3
    //   101: ifnull +10 -> 111
    //   104: aload_3
    //   105: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   108: goto +3 -> 111
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 63	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: goto -5 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	b
    //   0	129	1	paramInputStream	java.io.InputStream
    //   19	97	2	localObject	Object
    //   10	95	3	localInputStreamReader	java.io.InputStreamReader
    //   52	15	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   20	25	85	finally
    //   29	42	85	finally
    //   45	71	85	finally
    //   11	20	89	finally
    //   2	11	95	finally
    //   74	82	125	finally
    //   104	108	125	finally
    //   115	119	125	finally
    //   119	121	125	finally
  }
  
  /* Error */
  public void e(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 36	java/io/InputStreamReader
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   10: astore 4
    //   12: new 40	java/io/BufferedReader
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 43	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 5
    //   23: aload 5
    //   25: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +180 -> 210
    //   33: aload_1
    //   34: ldc 48
    //   36: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: arraylength
    //   42: iconst_2
    //   43: if_icmpeq +6 -> 49
    //   46: goto -23 -> 23
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_3
    //   52: iconst_0
    //   53: aaload
    //   54: astore_1
    //   55: aload_3
    //   56: iconst_1
    //   57: aaload
    //   58: astore 7
    //   60: aload_1
    //   61: invokevirtual 68	java/lang/String:toCharArray	()[C
    //   64: astore 8
    //   66: aload_0
    //   67: astore_1
    //   68: iload_2
    //   69: aload 8
    //   71: arraylength
    //   72: if_icmpge -49 -> 23
    //   75: aload 8
    //   77: iload_2
    //   78: caload
    //   79: invokestatic 74	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   82: invokevirtual 77	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   85: astore 9
    //   87: aload_1
    //   88: aload 9
    //   90: invokevirtual 79	k9/b:a	(Ljava/lang/String;)Lk9/b;
    //   93: astore 6
    //   95: aload 6
    //   97: astore_3
    //   98: aload 6
    //   100: ifnonnull +23 -> 123
    //   103: aload_1
    //   104: aload 9
    //   106: new 2	k9/b
    //   109: dup
    //   110: invokespecial 55	k9/b:<init>	()V
    //   113: invokevirtual 59	k9/b:g	(Ljava/lang/String;Lk9/b;)V
    //   116: aload_1
    //   117: aload 9
    //   119: invokevirtual 79	k9/b:a	(Ljava/lang/String;)Lk9/b;
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 81	k9/b:b	()Lk9/b;
    //   127: astore 6
    //   129: aload 8
    //   131: arraylength
    //   132: iconst_1
    //   133: isub
    //   134: iload_2
    //   135: if_icmpne +12 -> 147
    //   138: aload_3
    //   139: aload 7
    //   141: putfield 32	k9/b:b	Ljava/lang/String;
    //   144: goto -121 -> 23
    //   147: aload 6
    //   149: ifnonnull +51 -> 200
    //   152: aload 8
    //   154: arraylength
    //   155: iconst_1
    //   156: isub
    //   157: iload_2
    //   158: if_icmpeq +45 -> 203
    //   161: new 2	k9/b
    //   164: dup
    //   165: invokespecial 55	k9/b:<init>	()V
    //   168: astore_1
    //   169: aload_3
    //   170: aload_1
    //   171: invokevirtual 85	k9/b:h	(Lk9/b;)V
    //   174: aload_1
    //   175: aload 8
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: caload
    //   181: invokestatic 74	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   184: invokevirtual 77	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   187: new 2	k9/b
    //   190: dup
    //   191: invokespecial 55	k9/b:<init>	()V
    //   194: invokevirtual 59	k9/b:g	(Ljava/lang/String;Lk9/b;)V
    //   197: goto +6 -> 203
    //   200: aload 6
    //   202: astore_1
    //   203: iload_2
    //   204: iconst_1
    //   205: iadd
    //   206: istore_2
    //   207: goto -139 -> 68
    //   210: aload 4
    //   212: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   215: aload 5
    //   217: invokevirtual 63	java/io/BufferedReader:close	()V
    //   220: aload_0
    //   221: monitorexit
    //   222: return
    //   223: astore_1
    //   224: aload 5
    //   226: astore_3
    //   227: goto +16 -> 243
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_3
    //   233: goto +10 -> 243
    //   236: astore_1
    //   237: aconst_null
    //   238: astore 4
    //   240: aload 4
    //   242: astore_3
    //   243: aload 4
    //   245: ifnull +11 -> 256
    //   248: aload 4
    //   250: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   253: goto +3 -> 256
    //   256: aload_3
    //   257: ifnull +7 -> 264
    //   260: aload_3
    //   261: invokevirtual 63	java/io/BufferedReader:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: aload_0
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: goto -5 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	b
    //   0	274	1	paramInputStream	java.io.InputStream
    //   50	157	2	i	int
    //   39	222	3	localObject1	Object
    //   10	239	4	localInputStreamReader	java.io.InputStreamReader
    //   21	204	5	localBufferedReader	java.io.BufferedReader
    //   93	108	6	localb	b
    //   58	82	7	localObject2	Object
    //   64	112	8	arrayOfChar	char[]
    //   85	33	9	str	String
    // Exception table:
    //   from	to	target	type
    //   23	29	223	finally
    //   33	46	223	finally
    //   60	66	223	finally
    //   68	95	223	finally
    //   103	123	223	finally
    //   123	144	223	finally
    //   152	197	223	finally
    //   12	23	230	finally
    //   2	12	236	finally
    //   210	220	270	finally
    //   248	253	270	finally
    //   260	264	270	finally
    //   264	266	270	finally
  }
  
  public void f()
  {
    Object localObject = a.a;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        e(new FileInputStream((File)localObject));
      }
    }
  }
  
  public void g(String paramString, b paramb)
  {
    this.a.put(paramString, paramb);
  }
  
  public void h(b paramb)
  {
    this.c = paramb;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k9.b
 * JD-Core Version:    0.7.0.1
 */