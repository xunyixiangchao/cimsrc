package z;

public final class d
{
  /* Error */
  public static java.lang.String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 10	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 12
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 18	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_0
    //   23: aload_0
    //   24: astore 4
    //   26: aload_0
    //   27: astore_3
    //   28: aload_0
    //   29: invokestatic 24	x0/h:g	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 26	android/database/Cursor
    //   35: astore_0
    //   36: aload_0
    //   37: ldc 12
    //   39: invokeinterface 30 2 0
    //   44: istore_2
    //   45: aload_0
    //   46: invokeinterface 34 1 0
    //   51: pop
    //   52: aload_0
    //   53: iload_2
    //   54: invokeinterface 38 2 0
    //   59: astore_3
    //   60: aload_0
    //   61: invokeinterface 42 1 0
    //   66: aload_3
    //   67: areturn
    //   68: astore_1
    //   69: aload_0
    //   70: astore_3
    //   71: aload_1
    //   72: astore_0
    //   73: goto +60 -> 133
    //   76: astore_3
    //   77: aload_0
    //   78: astore 4
    //   80: aload_3
    //   81: astore_0
    //   82: goto +4 -> 86
    //   85: astore_0
    //   86: aload 4
    //   88: astore_3
    //   89: ldc 44
    //   91: ldc 46
    //   93: iconst_2
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_1
    //   100: invokevirtual 52	android/net/Uri:toString	()Ljava/lang/String;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_0
    //   107: invokevirtual 53	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 57	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokestatic 63	androidx/camera/core/n1:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 4
    //   119: ifnull +10 -> 129
    //   122: aload 4
    //   124: invokeinterface 42 1 0
    //   129: ldc 65
    //   131: areturn
    //   132: astore_0
    //   133: aload_3
    //   134: ifnull +9 -> 143
    //   137: aload_3
    //   138: invokeinterface 42 1 0
    //   143: aload_0
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContentResolver	android.content.ContentResolver
    //   0	145	1	paramUri	android.net.Uri
    //   44	10	2	i	int
    //   1	70	3	localObject1	Object
    //   76	5	3	localRuntimeException	java.lang.RuntimeException
    //   88	50	3	localObject2	Object
    //   3	120	4	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   36	60	68	finally
    //   36	60	76	java/lang/RuntimeException
    //   5	23	85	java/lang/RuntimeException
    //   28	36	85	java/lang/RuntimeException
    //   5	23	132	finally
    //   28	36	132	finally
    //   89	117	132	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z.d
 * JD-Core Version:    0.7.0.1
 */