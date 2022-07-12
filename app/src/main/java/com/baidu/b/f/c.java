package com.baidu.b.f;

import java.io.Closeable;
import java.io.IOException;

public final class c
{
  /* Error */
  public static java.lang.String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 10	java/io/FileReader
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 14	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: sipush 8192
    //   16: newarray char
    //   18: astore_3
    //   19: aload_2
    //   20: astore_0
    //   21: new 16	java/io/CharArrayWriter
    //   24: dup
    //   25: invokespecial 19	java/io/CharArrayWriter:<init>	()V
    //   28: astore 4
    //   30: aload_2
    //   31: astore_0
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual 23	java/io/FileReader:read	([C)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle +16 -> 55
    //   42: aload_2
    //   43: astore_0
    //   44: aload 4
    //   46: aload_3
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 27	java/io/CharArrayWriter:write	([CII)V
    //   52: goto -22 -> 30
    //   55: aload_2
    //   56: astore_0
    //   57: aload 4
    //   59: invokevirtual 31	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 34	java/io/FileReader:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokestatic 37	com/baidu/b/f/c:a	(Ljava/lang/Throwable;)V
    //   74: aload_3
    //   75: areturn
    //   76: astore_3
    //   77: goto +12 -> 89
    //   80: astore_0
    //   81: aload_3
    //   82: astore_2
    //   83: goto +34 -> 117
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_0
    //   91: aload_3
    //   92: invokestatic 37	com/baidu/b/f/c:a	(Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: ifnull +14 -> 110
    //   99: aload_2
    //   100: invokevirtual 34	java/io/FileReader:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokestatic 37	com/baidu/b/f/c:a	(Ljava/lang/Throwable;)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_3
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: astore_0
    //   117: aload_2
    //   118: ifnull +15 -> 133
    //   121: aload_2
    //   122: invokevirtual 34	java/io/FileReader:close	()V
    //   125: goto +8 -> 133
    //   128: astore_2
    //   129: aload_2
    //   130: invokestatic 37	com/baidu/b/f/c:a	(Ljava/lang/Throwable;)V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	java.io.File
    //   37	12	1	i	int
    //   10	112	2	localObject1	Object
    //   128	2	2	localException1	java.lang.Exception
    //   1	74	3	localObject2	Object
    //   76	6	3	localException2	java.lang.Exception
    //   86	6	3	localException3	java.lang.Exception
    //   112	4	3	localObject3	Object
    //   28	30	4	localCharArrayWriter	java.io.CharArrayWriter
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/lang/Exception
    //   13	19	76	java/lang/Exception
    //   21	30	76	java/lang/Exception
    //   32	38	76	java/lang/Exception
    //   44	52	76	java/lang/Exception
    //   57	63	76	java/lang/Exception
    //   2	11	80	finally
    //   2	11	86	java/lang/Exception
    //   99	103	105	java/lang/Exception
    //   13	19	112	finally
    //   21	30	112	finally
    //   32	38	112	finally
    //   44	52	112	finally
    //   57	63	112	finally
    //   91	95	112	finally
    //   121	125	128	java/lang/Exception
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        a(paramCloseable);
      }
    }
  }
  
  public static void a(Throwable paramThrowable) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.f.c
 * JD-Core Version:    0.7.0.1
 */