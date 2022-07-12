package ca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Objects;

public class a
{
  public static final BigInteger a;
  public static final BigInteger b;
  public static final BigInteger c;
  public static final BigInteger d;
  public static final BigInteger e;
  public static final BigInteger f;
  public static final BigInteger g;
  public static final BigInteger h;
  public static final File[] i = new File[0];
  
  static
  {
    BigInteger localBigInteger1 = BigInteger.valueOf(1024L);
    a = localBigInteger1;
    BigInteger localBigInteger2 = localBigInteger1.multiply(localBigInteger1);
    b = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    c = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    d = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    e = localBigInteger2;
    f = localBigInteger1.multiply(localBigInteger2);
    localBigInteger2 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    g = localBigInteger2;
    h = localBigInteger1.multiply(localBigInteger2);
  }
  
  public static String a(long paramLong)
  {
    return b(BigInteger.valueOf(paramLong));
  }
  
  public static String b(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = f;
    Object localObject2 = paramBigInteger.divide(localBigInteger);
    Object localObject1 = BigInteger.ZERO;
    if (((BigInteger)localObject2).compareTo((BigInteger)localObject1) > 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(String.valueOf(paramBigInteger.divide(localBigInteger)));
      localObject1 = " EB";
      paramBigInteger = (BigInteger)localObject2;
    }
    for (;;)
    {
      paramBigInteger.append((String)localObject1);
      return paramBigInteger.toString();
      localObject2 = e;
      if (paramBigInteger.divide((BigInteger)localObject2).compareTo((BigInteger)localObject1) > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger.divide((BigInteger)localObject2)));
        localObject2 = " PB";
        paramBigInteger = (BigInteger)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = d;
        if (paramBigInteger.divide((BigInteger)localObject2).compareTo((BigInteger)localObject1) > 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger.divide((BigInteger)localObject2)));
          localObject2 = " TB";
          paramBigInteger = (BigInteger)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = c;
          if (paramBigInteger.divide((BigInteger)localObject2).compareTo((BigInteger)localObject1) > 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger.divide((BigInteger)localObject2)));
            localObject2 = " GB";
            paramBigInteger = (BigInteger)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = b;
            if (paramBigInteger.divide((BigInteger)localObject2).compareTo((BigInteger)localObject1) > 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger.divide((BigInteger)localObject2)));
              localObject2 = " MB";
              paramBigInteger = (BigInteger)localObject1;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = a;
              if (paramBigInteger.divide((BigInteger)localObject2).compareTo((BigInteger)localObject1) <= 0) {
                break;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger.divide((BigInteger)localObject2)));
              localObject2 = " KB";
              paramBigInteger = (BigInteger)localObject1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramBigInteger));
    ((StringBuilder)localObject1).append(" bytes");
    return ((StringBuilder)localObject1).toString();
  }
  
  private static void c(File paramFile1, File paramFile2)
  {
    Objects.requireNonNull(paramFile1, "Source must not be null");
    Objects.requireNonNull(paramFile2, "Destination must not be null");
    if (paramFile1.exists()) {
      return;
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' does not exist");
    throw new FileNotFoundException(paramFile2.toString());
  }
  
  public static void d(File paramFile)
  {
    File[] arrayOfFile = s(paramFile);
    int k = arrayOfFile.length;
    paramFile = null;
    int j = 0;
    while (j < k)
    {
      File localFile = arrayOfFile[j];
      try
      {
        m(localFile);
      }
      catch (IOException paramFile) {}
      j += 1;
    }
    if (paramFile == null) {
      return;
    }
    throw paramFile;
  }
  
  /* Error */
  public static long e(File paramFile, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 138	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic 145	ca/c:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   14: lstore_2
    //   15: aload_0
    //   16: invokevirtual 148	java/io/FileInputStream:close	()V
    //   19: lload_2
    //   20: lreturn
    //   21: astore_1
    //   22: aload_1
    //   23: athrow
    //   24: astore 4
    //   26: aload_0
    //   27: invokevirtual 148	java/io/FileInputStream:close	()V
    //   30: goto +9 -> 39
    //   33: astore_0
    //   34: aload_1
    //   35: aload_0
    //   36: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   39: aload 4
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramFile	File
    //   0	42	1	paramOutputStream	java.io.OutputStream
    //   14	6	2	l	long
    //   24	16	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	15	21	finally
    //   22	24	24	finally
    //   26	30	33	finally
  }
  
  public static void f(File paramFile1, File paramFile2)
  {
    g(paramFile1, paramFile2, true);
  }
  
  public static void g(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    c(paramFile1, paramFile2);
    if (!paramFile1.isDirectory())
    {
      if (!paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
      {
        localObject = paramFile2.getParentFile();
        if ((localObject != null) && (!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(localObject);
          paramFile1.append("' directory cannot be created");
          throw new IOException(paramFile1.toString());
        }
        if ((paramFile2.exists()) && (!paramFile2.canWrite()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' exists but is read-only");
          throw new IOException(paramFile1.toString());
        }
        l(paramFile1, paramFile2, paramBoolean);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Source '");
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append("' and destination '");
      ((StringBuilder)localObject).append(paramFile2);
      ((StringBuilder)localObject).append("' are the same");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' exists but is a directory");
    throw new IOException(paramFile2.toString());
  }
  
  /* Error */
  public static void h(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 198	ca/a:i	(Ljava/io/InputStream;Ljava/io/File;)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 201	java/io/InputStream:close	()V
    //   13: return
    //   14: astore_1
    //   15: aload_1
    //   16: athrow
    //   17: astore_2
    //   18: aload_0
    //   19: ifnull +16 -> 35
    //   22: aload_0
    //   23: invokevirtual 201	java/io/InputStream:close	()V
    //   26: goto +9 -> 35
    //   29: astore_0
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramInputStream	java.io.InputStream
    //   0	37	1	paramFile	File
    //   17	19	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	5	14	finally
    //   15	17	17	finally
    //   22	26	29	finally
  }
  
  /* Error */
  public static void i(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 205	ca/a:q	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   4: astore_3
    //   5: aload_0
    //   6: aload_3
    //   7: invokestatic 208	ca/c:e	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   10: pop
    //   11: aload_3
    //   12: ifnull +7 -> 19
    //   15: aload_3
    //   16: invokevirtual 211	java/io/OutputStream:close	()V
    //   19: aload_0
    //   20: ifnull +7 -> 27
    //   23: aload_0
    //   24: invokevirtual 201	java/io/InputStream:close	()V
    //   27: return
    //   28: astore_1
    //   29: aload_1
    //   30: athrow
    //   31: astore_2
    //   32: aload_3
    //   33: ifnull +16 -> 49
    //   36: aload_3
    //   37: invokevirtual 211	java/io/OutputStream:close	()V
    //   40: goto +9 -> 49
    //   43: astore_3
    //   44: aload_1
    //   45: aload_3
    //   46: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   49: aload_2
    //   50: athrow
    //   51: astore_1
    //   52: aload_1
    //   53: athrow
    //   54: astore_2
    //   55: aload_0
    //   56: ifnull +16 -> 72
    //   59: aload_0
    //   60: invokevirtual 201	java/io/InputStream:close	()V
    //   63: goto +9 -> 72
    //   66: astore_0
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramInputStream	java.io.InputStream
    //   0	74	1	paramFile	File
    //   31	19	2	localObject1	Object
    //   54	19	2	localObject2	Object
    //   4	33	3	localFileOutputStream	FileOutputStream
    //   43	3	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	11	28	finally
    //   29	31	31	finally
    //   36	40	43	finally
    //   0	5	51	finally
    //   15	19	51	finally
    //   44	49	51	finally
    //   49	51	51	finally
    //   52	54	54	finally
    //   59	63	66	finally
  }
  
  public static void j(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (!p(paramFile)) {
      d(paramFile);
    }
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  public static boolean k(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        d(paramFile);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          boolean bool = paramFile.delete();
          return bool;
        }
        catch (Exception paramFile) {}
        localException = localException;
      }
    }
    return false;
  }
  
  /* Error */
  private static void l(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 113	java/io/File:exists	()Z
    //   4: ifeq +53 -> 57
    //   7: aload_1
    //   8: invokevirtual 162	java/io/File:isDirectory	()Z
    //   11: ifne +6 -> 17
    //   14: goto +43 -> 57
    //   17: new 68	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc 178
    //   28: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc 195
    //   41: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: new 128	java/io/IOException
    //   48: dup
    //   49: aload_0
    //   50: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 181	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: new 138	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore 9
    //   67: aload 9
    //   69: invokevirtual 232	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   72: astore 10
    //   74: new 234	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore 11
    //   84: aload 11
    //   86: invokevirtual 236	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: astore 12
    //   91: aload 10
    //   93: invokevirtual 242	java/nio/channels/FileChannel:size	()J
    //   96: lstore 7
    //   98: lconst_0
    //   99: lstore_3
    //   100: goto +275 -> 375
    //   103: aload 12
    //   105: aload 10
    //   107: lload_3
    //   108: lload 5
    //   110: invokevirtual 246	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   113: lstore 5
    //   115: lload 5
    //   117: lconst_0
    //   118: lcmp
    //   119: ifne +6 -> 125
    //   122: goto +11 -> 133
    //   125: lload_3
    //   126: lload 5
    //   128: ladd
    //   129: lstore_3
    //   130: goto +245 -> 375
    //   133: aload 12
    //   135: ifnull +8 -> 143
    //   138: aload 12
    //   140: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   143: aload 11
    //   145: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   148: aload 10
    //   150: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   153: aload 9
    //   155: invokevirtual 148	java/io/FileInputStream:close	()V
    //   158: aload_0
    //   159: invokevirtual 251	java/io/File:length	()J
    //   162: lstore_3
    //   163: aload_1
    //   164: invokevirtual 251	java/io/File:length	()J
    //   167: lstore 5
    //   169: lload_3
    //   170: lload 5
    //   172: lcmp
    //   173: ifne +17 -> 190
    //   176: iload_2
    //   177: ifeq +12 -> 189
    //   180: aload_1
    //   181: aload_0
    //   182: invokevirtual 254	java/io/File:lastModified	()J
    //   185: invokevirtual 258	java/io/File:setLastModified	(J)Z
    //   188: pop
    //   189: return
    //   190: new 68	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   197: astore 9
    //   199: aload 9
    //   201: ldc_w 260
    //   204: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 9
    //   210: aload_0
    //   211: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 9
    //   217: ldc_w 262
    //   220: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 9
    //   226: aload_1
    //   227: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 9
    //   233: ldc_w 264
    //   236: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 9
    //   242: lload_3
    //   243: invokevirtual 267	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 9
    //   249: ldc_w 269
    //   252: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 9
    //   258: lload 5
    //   260: invokevirtual 267	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: new 128	java/io/IOException
    //   267: dup
    //   268: aload 9
    //   270: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokespecial 181	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   276: athrow
    //   277: astore_0
    //   278: aload_0
    //   279: athrow
    //   280: astore_1
    //   281: aload 12
    //   283: ifnull +19 -> 302
    //   286: aload 12
    //   288: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   291: goto +11 -> 302
    //   294: astore 12
    //   296: aload_0
    //   297: aload 12
    //   299: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   302: aload_1
    //   303: athrow
    //   304: astore_0
    //   305: aload_0
    //   306: athrow
    //   307: astore_1
    //   308: aload 11
    //   310: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   313: goto +11 -> 324
    //   316: astore 11
    //   318: aload_0
    //   319: aload 11
    //   321: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   324: aload_1
    //   325: athrow
    //   326: astore_0
    //   327: aload_0
    //   328: athrow
    //   329: astore_1
    //   330: aload 10
    //   332: ifnull +19 -> 351
    //   335: aload 10
    //   337: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   340: goto +11 -> 351
    //   343: astore 10
    //   345: aload_0
    //   346: aload 10
    //   348: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   351: aload_1
    //   352: athrow
    //   353: astore_0
    //   354: aload_0
    //   355: athrow
    //   356: astore_1
    //   357: aload 9
    //   359: invokevirtual 148	java/io/FileInputStream:close	()V
    //   362: goto +11 -> 373
    //   365: astore 9
    //   367: aload_0
    //   368: aload 9
    //   370: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   373: aload_1
    //   374: athrow
    //   375: lload_3
    //   376: lload 7
    //   378: lcmp
    //   379: ifge -246 -> 133
    //   382: lload 7
    //   384: lload_3
    //   385: lsub
    //   386: lstore 5
    //   388: lload 5
    //   390: ldc2_w 270
    //   393: lcmp
    //   394: ifle +11 -> 405
    //   397: ldc2_w 270
    //   400: lstore 5
    //   402: goto -299 -> 103
    //   405: goto -302 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramFile1	File
    //   0	408	1	paramFile2	File
    //   0	408	2	paramBoolean	boolean
    //   99	286	3	l1	long
    //   108	1	5	localObject1	Object
    //   113	288	5	l2	long
    //   96	287	7	l3	long
    //   65	293	9	localObject2	Object
    //   365	4	9	localThrowable1	java.lang.Throwable
    //   72	264	10	localFileChannel1	java.nio.channels.FileChannel
    //   343	4	10	localThrowable2	java.lang.Throwable
    //   82	227	11	localFileOutputStream	FileOutputStream
    //   316	4	11	localThrowable3	java.lang.Throwable
    //   89	198	12	localFileChannel2	java.nio.channels.FileChannel
    //   294	4	12	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   91	98	277	finally
    //   103	115	277	finally
    //   278	280	280	finally
    //   286	291	294	finally
    //   84	91	304	finally
    //   138	143	304	finally
    //   296	302	304	finally
    //   302	304	304	finally
    //   305	307	307	finally
    //   308	313	316	finally
    //   74	84	326	finally
    //   143	148	326	finally
    //   318	324	326	finally
    //   324	326	326	finally
    //   327	329	329	finally
    //   335	340	343	finally
    //   67	74	353	finally
    //   148	153	353	finally
    //   345	351	353	finally
    //   351	353	353	finally
    //   354	356	356	finally
    //   357	362	365	finally
  }
  
  public static void m(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      j(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (!paramFile.delete())
    {
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File does not exist: ");
        localStringBuilder.append(paramFile);
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to delete file: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static void n(File paramFile)
  {
    StringBuilder localStringBuilder;
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File ");
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" exists and is not a directory. Unable to create directory.");
      throw new IOException(localStringBuilder.toString());
    }
    if (!paramFile.mkdirs())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to create directory ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static void o(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if (paramFile == null) {
      return;
    }
    n(paramFile);
  }
  
  public static boolean p(File paramFile)
  {
    Objects.requireNonNull(paramFile, "File must not be null");
    return Files.isSymbolicLink(paramFile.toPath());
  }
  
  public static FileOutputStream q(File paramFile)
  {
    return r(paramFile, false);
  }
  
  public static FileOutputStream r(File paramFile, boolean paramBoolean)
  {
    Object localObject;
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (!paramFile.canWrite())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("File '");
          ((StringBuilder)localObject).append(paramFile);
          ((StringBuilder)localObject).append("' cannot be written to");
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' exists but is a directory");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = paramFile.getParentFile();
      if ((localObject != null) && (!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
      {
        paramFile = new StringBuilder();
        paramFile.append("Directory '");
        paramFile.append(localObject);
        paramFile.append("' could not be created");
        throw new IOException(paramFile.toString());
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  private static File[] s(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static void t(File paramFile, byte[] paramArrayOfByte)
  {
    v(paramFile, paramArrayOfByte, false);
  }
  
  /* Error */
  public static void u(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload 4
    //   3: invokestatic 303	ca/a:r	(Ljava/io/File;Z)Ljava/io/FileOutputStream;
    //   6: astore_0
    //   7: aload_0
    //   8: aload_1
    //   9: iload_2
    //   10: iload_3
    //   11: invokevirtual 339	java/io/OutputStream:write	([BII)V
    //   14: aload_0
    //   15: invokevirtual 211	java/io/OutputStream:close	()V
    //   18: return
    //   19: astore_1
    //   20: aload_1
    //   21: athrow
    //   22: astore 5
    //   24: aload_0
    //   25: ifnull +16 -> 41
    //   28: aload_0
    //   29: invokevirtual 211	java/io/OutputStream:close	()V
    //   32: goto +9 -> 41
    //   35: astore_0
    //   36: aload_1
    //   37: aload_0
    //   38: invokevirtual 154	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   41: aload 5
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramFile	File
    //   0	44	1	paramArrayOfByte	byte[]
    //   0	44	2	paramInt1	int
    //   0	44	3	paramInt2	int
    //   0	44	4	paramBoolean	boolean
    //   22	20	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	19	finally
    //   20	22	22	finally
    //   28	32	35	finally
  }
  
  public static void v(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    u(paramFile, paramArrayOfByte, 0, paramArrayOfByte.length, paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ca.a
 * JD-Core Version:    0.7.0.1
 */