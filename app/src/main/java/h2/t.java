package h2;

import b2.d;
import e2.b;
import java.io.InputStream;

public class t
  implements d<InputStream>
{
  private final b a;
  
  public t(b paramb)
  {
    this.a = paramb;
  }
  
  /* Error */
  public boolean c(InputStream paramInputStream, java.io.File paramFile, b2.h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	h2/t:a	Le2/b;
    //   4: ldc 27
    //   6: ldc 29
    //   8: invokeinterface 35 3 0
    //   13: checkcast 29	[B
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 7
    //   21: iconst_0
    //   22: istore 6
    //   24: aconst_null
    //   25: astore 8
    //   27: aconst_null
    //   28: astore_3
    //   29: new 37	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 40	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 44	java/io/InputStream:read	([B)I
    //   44: istore 4
    //   46: iload 4
    //   48: iconst_m1
    //   49: if_icmpeq +15 -> 64
    //   52: aload_2
    //   53: aload 9
    //   55: iconst_0
    //   56: iload 4
    //   58: invokevirtual 50	java/io/OutputStream:write	([BII)V
    //   61: goto -23 -> 38
    //   64: aload_2
    //   65: invokevirtual 53	java/io/OutputStream:close	()V
    //   68: iconst_1
    //   69: istore 5
    //   71: iconst_1
    //   72: istore 6
    //   74: aload_2
    //   75: invokevirtual 53	java/io/OutputStream:close	()V
    //   78: iload 6
    //   80: istore 5
    //   82: goto +67 -> 149
    //   85: astore_1
    //   86: aload_2
    //   87: astore_3
    //   88: goto +75 -> 163
    //   91: astore_3
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: goto +11 -> 107
    //   99: astore_1
    //   100: goto +63 -> 163
    //   103: astore_2
    //   104: aload 8
    //   106: astore_1
    //   107: aload_1
    //   108: astore_3
    //   109: ldc 55
    //   111: iconst_3
    //   112: invokestatic 61	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   115: ifeq +14 -> 129
    //   118: aload_1
    //   119: astore_3
    //   120: ldc 55
    //   122: ldc 63
    //   124: aload_2
    //   125: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   128: pop
    //   129: iload 6
    //   131: istore 5
    //   133: aload_1
    //   134: ifnull +15 -> 149
    //   137: iload 7
    //   139: istore 5
    //   141: aload_1
    //   142: invokevirtual 53	java/io/OutputStream:close	()V
    //   145: iload 6
    //   147: istore 5
    //   149: aload_0
    //   150: getfield 16	h2/t:a	Le2/b;
    //   153: aload 9
    //   155: invokeinterface 70 2 0
    //   160: iload 5
    //   162: ireturn
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 53	java/io/OutputStream:close	()V
    //   171: aload_0
    //   172: getfield 16	h2/t:a	Le2/b;
    //   175: aload 9
    //   177: invokeinterface 70 2 0
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: goto -36 -> 149
    //   188: astore_2
    //   189: goto -18 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	t
    //   0	192	1	paramInputStream	InputStream
    //   0	192	2	paramFile	java.io.File
    //   0	192	3	paramh	b2.h
    //   44	13	4	i	int
    //   69	92	5	bool1	boolean
    //   22	124	6	bool2	boolean
    //   19	119	7	bool3	boolean
    //   25	80	8	localObject	Object
    //   16	160	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	46	85	finally
    //   52	61	85	finally
    //   64	68	85	finally
    //   38	46	91	java/io/IOException
    //   52	61	91	java/io/IOException
    //   64	68	91	java/io/IOException
    //   29	38	99	finally
    //   109	118	99	finally
    //   120	129	99	finally
    //   29	38	103	java/io/IOException
    //   74	78	184	java/io/IOException
    //   141	145	184	java/io/IOException
    //   167	171	188	java/io/IOException
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.t
 * JD-Core Version:    0.7.0.1
 */