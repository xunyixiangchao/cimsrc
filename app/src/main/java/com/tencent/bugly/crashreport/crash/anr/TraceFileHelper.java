package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.y;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceFileHelper
{
  private static String a(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 3)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
  {
    if (paramBufferedReader != null)
    {
      if (paramVarArgs == null) {
        return null;
      }
      for (;;)
      {
        String str = paramBufferedReader.readLine();
        if (str == null) {
          break;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          Pattern localPattern = paramVarArgs[i];
          if (localPattern.matcher(str).matches()) {
            return new Object[] { localPattern, str };
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static String b(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static a readFirstDumpInfo(String paramString, final boolean paramBoolean)
  {
    if (paramString == null)
    {
      y.e("path:%s", new Object[] { paramString });
      return null;
    }
    a locala = new a();
    readTraceFile(paramString, new d(locala, paramBoolean));
    if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
      return locala;
    }
    paramString = new StringBuilder();
    paramString.append(locala.a);
    paramString.append(" ");
    paramString.append(locala.c);
    paramString.append(" ");
    paramString.append(locala.b);
    y.e("first dump error %s", new Object[] { paramString.toString() });
    return null;
  }
  
  public static a readTargetDumpInfo(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      a locala = new a();
      readTraceFile(paramString2, new c(locala, paramString1, paramBoolean));
      if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
        return locala;
      }
    }
    return null;
  }
  
  /* Error */
  public static void readTraceFile(String paramString, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +694 -> 695
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 112	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 118	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload 7
    //   30: invokevirtual 122	java/io/File:lastModified	()J
    //   33: pop2
    //   34: aload 7
    //   36: invokevirtual 124	java/io/File:length	()J
    //   39: pop2
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore_0
    //   45: new 25	java/io/BufferedReader
    //   48: dup
    //   49: new 126	java/io/FileReader
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 129	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   58: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 7
    //   63: ldc 134
    //   65: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   68: astore 8
    //   70: ldc 140
    //   72: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   75: astore 9
    //   77: ldc 142
    //   79: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   82: astore 10
    //   84: ldc 144
    //   86: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   89: astore 11
    //   91: new 146	java/text/SimpleDateFormat
    //   94: dup
    //   95: ldc 148
    //   97: getstatic 154	java/util/Locale:US	Ljava/util/Locale;
    //   100: invokespecial 157	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   103: astore_0
    //   104: aload 7
    //   106: iconst_1
    //   107: anewarray 48	java/util/regex/Pattern
    //   110: dup
    //   111: iconst_0
    //   112: aload 8
    //   114: aastore
    //   115: invokestatic 159	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   118: astore 13
    //   120: aload 13
    //   122: ifnull +402 -> 524
    //   125: aload 7
    //   127: iconst_1
    //   128: anewarray 48	java/util/regex/Pattern
    //   131: dup
    //   132: iconst_0
    //   133: aload 10
    //   135: aastore
    //   136: invokestatic 159	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   139: astore 12
    //   141: aload 12
    //   143: ifnonnull +32 -> 175
    //   146: ldc 161
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 164	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload 7
    //   158: invokevirtual 167	java/io/BufferedReader:close	()V
    //   161: return
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   167: ifne +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   174: return
    //   175: aload 13
    //   177: iconst_1
    //   178: aaload
    //   179: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
    //   182: ldc 176
    //   184: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   187: astore 13
    //   189: aload 13
    //   191: iconst_2
    //   192: aaload
    //   193: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   196: lstore_2
    //   197: new 31	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   204: astore 14
    //   206: aload 14
    //   208: aload 13
    //   210: iconst_4
    //   211: aaload
    //   212: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 14
    //   218: ldc 99
    //   220: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 14
    //   226: aload 13
    //   228: iconst_5
    //   229: aaload
    //   230: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: aload 14
    //   237: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 190	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   243: invokevirtual 195	java/util/Date:getTime	()J
    //   246: lstore 4
    //   248: aload 10
    //   250: aload 12
    //   252: iconst_1
    //   253: aaload
    //   254: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
    //   257: invokevirtual 52	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   260: astore 12
    //   262: aload 12
    //   264: invokevirtual 198	java/util/regex/Matcher:find	()Z
    //   267: pop
    //   268: aload 12
    //   270: iconst_1
    //   271: invokevirtual 202	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   274: pop
    //   275: aload_1
    //   276: lload_2
    //   277: lload 4
    //   279: aload 12
    //   281: iconst_1
    //   282: invokevirtual 202	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   285: invokeinterface 205 6 0
    //   290: istore 6
    //   292: iload 6
    //   294: ifne +22 -> 316
    //   297: aload 7
    //   299: invokevirtual 167	java/io/BufferedReader:close	()V
    //   302: return
    //   303: astore_0
    //   304: aload_0
    //   305: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   308: ifne +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   315: return
    //   316: aload 7
    //   318: iconst_2
    //   319: anewarray 48	java/util/regex/Pattern
    //   322: dup
    //   323: iconst_0
    //   324: aload 11
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: aload 9
    //   331: aastore
    //   332: invokestatic 159	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   335: astore 12
    //   337: aload 12
    //   339: ifnull +182 -> 521
    //   342: aload 12
    //   344: iconst_0
    //   345: aaload
    //   346: aload 11
    //   348: if_acmpne +124 -> 472
    //   351: aload 12
    //   353: iconst_1
    //   354: aaload
    //   355: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
    //   358: astore 12
    //   360: ldc 207
    //   362: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   365: aload 12
    //   367: invokevirtual 52	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   370: astore 13
    //   372: aload 13
    //   374: invokevirtual 198	java/util/regex/Matcher:find	()Z
    //   377: pop
    //   378: aload 13
    //   380: invokevirtual 209	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   383: astore 13
    //   385: aload 13
    //   387: iconst_1
    //   388: aload 13
    //   390: invokevirtual 67	java/lang/String:length	()I
    //   393: iconst_1
    //   394: isub
    //   395: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   398: astore 13
    //   400: aload 12
    //   402: ldc 215
    //   404: invokevirtual 219	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   407: pop
    //   408: ldc 221
    //   410: invokestatic 138	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   413: aload 12
    //   415: invokevirtual 52	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   418: astore 12
    //   420: aload 12
    //   422: invokevirtual 198	java/util/regex/Matcher:find	()Z
    //   425: pop
    //   426: aload 12
    //   428: invokevirtual 209	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   431: astore 12
    //   433: aload_1
    //   434: aload 13
    //   436: aload 12
    //   438: aload 12
    //   440: ldc 223
    //   442: invokevirtual 227	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   445: iconst_1
    //   446: iadd
    //   447: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   450: invokestatic 234	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   453: aload 7
    //   455: invokestatic 236	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   458: aload 7
    //   460: invokestatic 238	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   463: invokeinterface 241 5 0
    //   468: pop
    //   469: goto -153 -> 316
    //   472: aload_1
    //   473: aload 12
    //   475: iconst_1
    //   476: aaload
    //   477: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
    //   480: ldc 176
    //   482: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   485: iconst_2
    //   486: aaload
    //   487: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   490: invokeinterface 244 3 0
    //   495: istore 6
    //   497: iload 6
    //   499: ifne +22 -> 521
    //   502: aload 7
    //   504: invokevirtual 167	java/io/BufferedReader:close	()V
    //   507: return
    //   508: astore_0
    //   509: aload_0
    //   510: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   513: ifne +7 -> 520
    //   516: aload_0
    //   517: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   520: return
    //   521: goto -417 -> 104
    //   524: aload 7
    //   526: invokevirtual 167	java/io/BufferedReader:close	()V
    //   529: return
    //   530: astore_0
    //   531: aload_0
    //   532: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   535: ifne +7 -> 542
    //   538: aload_0
    //   539: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   542: return
    //   543: astore_1
    //   544: aload 7
    //   546: astore_0
    //   547: goto +123 -> 670
    //   550: astore_0
    //   551: aload 7
    //   553: astore_1
    //   554: aload_0
    //   555: astore 7
    //   557: goto +12 -> 569
    //   560: astore_1
    //   561: goto +109 -> 670
    //   564: astore 7
    //   566: aload 8
    //   568: astore_1
    //   569: aload_1
    //   570: astore_0
    //   571: aload 7
    //   573: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   576: ifne +10 -> 586
    //   579: aload_1
    //   580: astore_0
    //   581: aload 7
    //   583: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   586: aload_1
    //   587: astore_0
    //   588: aload 7
    //   590: invokevirtual 249	java/lang/Object:getClass	()Ljava/lang/Class;
    //   593: invokevirtual 254	java/lang/Class:getName	()Ljava/lang/String;
    //   596: astore 8
    //   598: aload_1
    //   599: astore_0
    //   600: new 31	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   607: astore 9
    //   609: aload_1
    //   610: astore_0
    //   611: aload 9
    //   613: aload 7
    //   615: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_1
    //   623: astore_0
    //   624: ldc_w 259
    //   627: iconst_2
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload 8
    //   635: aastore
    //   636: dup
    //   637: iconst_1
    //   638: aload 9
    //   640: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: aastore
    //   644: invokestatic 164	com/tencent/bugly/proguard/y:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   647: pop
    //   648: aload_1
    //   649: ifnull +20 -> 669
    //   652: aload_1
    //   653: invokevirtual 167	java/io/BufferedReader:close	()V
    //   656: return
    //   657: astore_0
    //   658: aload_0
    //   659: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   662: ifne +7 -> 669
    //   665: aload_0
    //   666: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   669: return
    //   670: aload_0
    //   671: ifnull +22 -> 693
    //   674: aload_0
    //   675: invokevirtual 167	java/io/BufferedReader:close	()V
    //   678: goto +15 -> 693
    //   681: astore_0
    //   682: aload_0
    //   683: invokestatic 170	com/tencent/bugly/proguard/y:a	(Ljava/lang/Throwable;)Z
    //   686: ifne +7 -> 693
    //   689: aload_0
    //   690: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   693: aload_1
    //   694: athrow
    //   695: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	paramString	String
    //   0	696	1	paramb	b
    //   196	81	2	l1	long
    //   246	32	4	l2	long
    //   290	208	6	bool	boolean
    //   17	539	7	localObject1	Object
    //   564	50	7	localException	java.lang.Exception
    //   41	593	8	localObject2	Object
    //   75	564	9	localObject3	Object
    //   82	167	10	localPattern1	Pattern
    //   89	258	11	localPattern2	Pattern
    //   139	335	12	localObject4	Object
    //   118	317	13	localObject5	Object
    //   204	32	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	161	162	java/io/IOException
    //   297	302	303	java/io/IOException
    //   502	507	508	java/io/IOException
    //   524	529	530	java/io/IOException
    //   63	104	543	finally
    //   104	120	543	finally
    //   125	141	543	finally
    //   146	156	543	finally
    //   175	292	543	finally
    //   316	337	543	finally
    //   351	469	543	finally
    //   472	497	543	finally
    //   63	104	550	java/lang/Exception
    //   104	120	550	java/lang/Exception
    //   125	141	550	java/lang/Exception
    //   146	156	550	java/lang/Exception
    //   175	292	550	java/lang/Exception
    //   316	337	550	java/lang/Exception
    //   351	469	550	java/lang/Exception
    //   472	497	550	java/lang/Exception
    //   45	63	560	finally
    //   571	579	560	finally
    //   581	586	560	finally
    //   588	598	560	finally
    //   600	609	560	finally
    //   611	622	560	finally
    //   624	648	560	finally
    //   45	63	564	java/lang/Exception
    //   652	656	657	java/io/IOException
    //   674	678	681	java/io/IOException
  }
  
  public static final class a
  {
    public long a;
    public String b;
    public long c;
    public Map<String, String[]> d;
  }
  
  public static abstract interface b
  {
    public abstract boolean a(long paramLong);
    
    public abstract boolean a(long paramLong1, long paramLong2, String paramString);
    
    public abstract boolean a(String paramString1, int paramInt, String paramString2, String paramString3);
  }
  
  static final class c
    implements TraceFileHelper.b
  {
    c(TraceFileHelper.a parama, String paramString, boolean paramBoolean) {}
    
    public final boolean a(long paramLong)
    {
      y.c("process end %d", new Object[] { Long.valueOf(paramLong) });
      TraceFileHelper.a locala = this.a;
      if ((locala.a > 0L) && (locala.c > 0L)) {
        return paramString1 == null;
      }
      return true;
    }
    
    public final boolean a(long paramLong1, long paramLong2, String paramString)
    {
      y.c("new process %s", new Object[] { paramString });
      if (!paramString.equals(paramString1)) {
        return true;
      }
      TraceFileHelper.a locala = this.a;
      locala.a = paramLong1;
      locala.b = paramString;
      locala.c = paramLong2;
      return paramBoolean;
    }
    
    public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      y.c("new thread %s", new Object[] { paramString1 });
      Object localObject = this.a;
      if ((((TraceFileHelper.a)localObject).a > 0L) && (((TraceFileHelper.a)localObject).c > 0L))
      {
        if (paramString1 == null) {
          return true;
        }
        if (((TraceFileHelper.a)localObject).d == null) {
          ((TraceFileHelper.a)localObject).d = new HashMap();
        }
        localObject = this.a.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        ((Map)localObject).put(paramString1, new String[] { paramString2, paramString3, localStringBuilder.toString() });
      }
      return true;
    }
  }
  
  static final class d
    implements TraceFileHelper.b
  {
    d(TraceFileHelper.a parama, boolean paramBoolean) {}
    
    public final boolean a(long paramLong)
    {
      y.c("process end %d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    
    public final boolean a(long paramLong1, long paramLong2, String paramString)
    {
      y.c("new process %s", new Object[] { paramString });
      TraceFileHelper.a locala = this.a;
      locala.a = paramLong1;
      locala.b = paramString;
      locala.c = paramLong2;
      return paramBoolean;
    }
    
    public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      y.c("new thread %s", new Object[] { paramString1 });
      Object localObject = this.a;
      if (((TraceFileHelper.a)localObject).d == null) {
        ((TraceFileHelper.a)localObject).d = new HashMap();
      }
      localObject = this.a.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      ((Map)localObject).put(paramString1, new String[] { paramString2, paramString3, localStringBuilder.toString() });
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.TraceFileHelper
 * JD-Core Version:    0.7.0.1
 */