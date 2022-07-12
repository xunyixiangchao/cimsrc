package d1;

import android.content.Context;
import android.net.Uri;

class b
{
  private static void a(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
      return;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    return f(paramContext, paramUri, "_display_name", null);
  }
  
  public static long c(Context paramContext, Uri paramUri)
  {
    return e(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long d(Context paramContext, Uri paramUri)
  {
    return e(paramContext, paramUri, "_size", 0L);
  }
  
  /* Error */
  private static long e(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 8
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 44	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 50	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: astore 7
    //   34: aload_1
    //   35: invokeinterface 56 1 0
    //   40: ifeq +39 -> 79
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: astore 7
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 60 2 0
    //   55: ifne +24 -> 79
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: astore 7
    //   63: aload_1
    //   64: iconst_0
    //   65: invokeinterface 64 2 0
    //   70: lstore 5
    //   72: aload_1
    //   73: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   76: lload 5
    //   78: lreturn
    //   79: aload_1
    //   80: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   83: lload_3
    //   84: lreturn
    //   85: astore_1
    //   86: goto +54 -> 140
    //   89: astore_1
    //   90: aload 7
    //   92: astore_0
    //   93: new 68	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   100: astore_2
    //   101: aload 7
    //   103: astore_0
    //   104: aload_2
    //   105: ldc 73
    //   107: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 7
    //   113: astore_0
    //   114: aload_2
    //   115: aload_1
    //   116: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 7
    //   122: astore_0
    //   123: ldc 82
    //   125: aload_2
    //   126: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 92	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload 7
    //   135: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   138: lload_3
    //   139: lreturn
    //   140: aload_0
    //   141: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   0	146	1	paramUri	Uri
    //   0	146	2	paramString	String
    //   0	146	3	paramLong	long
    //   70	7	5	l	long
    //   7	127	7	localUri	Uri
    //   4	8	8	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   11	29	85	finally
    //   34	43	85	finally
    //   48	58	85	finally
    //   63	72	85	finally
    //   93	101	85	finally
    //   104	111	85	finally
    //   114	120	85	finally
    //   123	133	85	finally
    //   11	29	89	java/lang/Exception
    //   34	43	89	java/lang/Exception
    //   48	58	89	java/lang/Exception
    //   63	72	89	java/lang/Exception
  }
  
  /* Error */
  private static String f(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 5
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 44	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 50	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: astore 4
    //   34: aload_1
    //   35: invokeinterface 56 1 0
    //   40: ifeq +37 -> 77
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 60 2 0
    //   55: ifne +22 -> 77
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: astore 4
    //   63: aload_1
    //   64: iconst_0
    //   65: invokeinterface 96 2 0
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   75: aload_2
    //   76: areturn
    //   77: aload_1
    //   78: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   81: aload_3
    //   82: areturn
    //   83: astore_1
    //   84: goto +54 -> 138
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: new 68	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload 4
    //   101: astore_0
    //   102: aload_2
    //   103: ldc 73
    //   105: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: astore_0
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: astore_0
    //   121: ldc 82
    //   123: aload_2
    //   124: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 92	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload 4
    //   133: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   136: aload_3
    //   137: areturn
    //   138: aload_0
    //   139: invokestatic 66	d1/b:a	(Ljava/lang/AutoCloseable;)V
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramUri	Uri
    //   0	144	2	paramString1	String
    //   0	144	3	paramString2	String
    //   7	125	4	localUri	Uri
    //   4	8	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   11	29	83	finally
    //   34	43	83	finally
    //   48	58	83	finally
    //   63	71	83	finally
    //   91	99	83	finally
    //   102	109	83	finally
    //   112	118	83	finally
    //   121	131	83	finally
    //   11	29	87	java/lang/Exception
    //   34	43	87	java/lang/Exception
    //   48	58	87	java/lang/Exception
    //   63	71	87	java/lang/Exception
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d1.b
 * JD-Core Version:    0.7.0.1
 */