package u3;

import java.security.MessageDigest;

public class k0
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static MessageDigest c = null;
  
  public static String a(String paramString)
  {
    try
    {
      paramString = b(paramString.getBytes());
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private static String b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	u3/k0:c	Ljava/security/MessageDigest;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +11 -> 21
    //   13: ldc 54
    //   15: invokestatic 60	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   18: putstatic 39	u3/k0:c	Ljava/security/MessageDigest;
    //   21: getstatic 39	u3/k0:c	Ljava/security/MessageDigest;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +82 -> 110
    //   31: aload 5
    //   33: invokevirtual 63	java/security/MessageDigest:reset	()V
    //   36: getstatic 39	u3/k0:c	Ljava/security/MessageDigest;
    //   39: aload_0
    //   40: invokevirtual 67	java/security/MessageDigest:update	([B)V
    //   43: getstatic 39	u3/k0:c	Ljava/security/MessageDigest;
    //   46: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   49: astore_0
    //   50: new 72	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   57: astore 5
    //   59: aload_0
    //   60: arraylength
    //   61: istore 4
    //   63: iconst_0
    //   64: istore_1
    //   65: goto +62 -> 127
    //   68: iload_2
    //   69: bipush 16
    //   71: if_icmpge +11 -> 82
    //   74: aload 5
    //   76: ldc 77
    //   78: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 5
    //   84: iload_2
    //   85: invokestatic 87	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   88: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: iload_1
    //   93: iconst_1
    //   94: iadd
    //   95: istore_1
    //   96: goto +31 -> 127
    //   99: aload 5
    //   101: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: areturn
    //   110: ldc 2
    //   112: monitorexit
    //   113: ldc 93
    //   115: areturn
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: astore 5
    //   124: goto -103 -> 21
    //   127: iload_1
    //   128: iload 4
    //   130: if_icmpge -31 -> 99
    //   133: aload_0
    //   134: iload_1
    //   135: baload
    //   136: istore_3
    //   137: iload_3
    //   138: istore_2
    //   139: iload_3
    //   140: ifge -72 -> 68
    //   143: iload_3
    //   144: sipush 256
    //   147: iadd
    //   148: istore_2
    //   149: goto -81 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramArrayOfByte	byte[]
    //   64	71	1	i	int
    //   68	81	2	j	int
    //   136	12	3	k	int
    //   61	70	4	m	int
    //   6	94	5	localObject	Object
    //   122	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	8	116	finally
    //   13	21	116	finally
    //   21	26	116	finally
    //   31	63	116	finally
    //   74	82	116	finally
    //   82	92	116	finally
    //   99	105	116	finally
    //   13	21	122	java/lang/Exception
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.k0
 * JD-Core Version:    0.7.0.1
 */