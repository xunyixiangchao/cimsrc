package f2;

import android.util.Log;
import b2.f;
import java.io.File;
import java.io.IOException;
import y1.a.e;

public class e
  implements a
{
  private final k a;
  private final File b;
  private final long c;
  private final c d = new c();
  private y1.a e;
  
  @Deprecated
  protected e(File paramFile, long paramLong)
  {
    this.b = paramFile;
    this.c = paramLong;
    this.a = new k();
  }
  
  public static a c(File paramFile, long paramLong)
  {
    return new e(paramFile, paramLong);
  }
  
  private y1.a d()
  {
    try
    {
      if (this.e == null) {
        this.e = y1.a.q0(this.b, 1, 1, this.c);
      }
      y1.a locala = this.e;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public void a(f paramf, a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	f2/e:a	Lf2/k;
    //   4: aload_1
    //   5: invokevirtual 56	f2/k:b	(Lb2/f;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 27	f2/e:d	Lf2/c;
    //   13: aload_3
    //   14: invokevirtual 59	f2/c:a	(Ljava/lang/String;)V
    //   17: ldc 61
    //   19: iconst_2
    //   20: invokestatic 67	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   23: ifeq +53 -> 76
    //   26: new 69	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 72
    //   39: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 78
    //   54: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload_1
    //   61: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 61
    //   67: aload 4
    //   69: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 89	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aload_0
    //   77: invokespecial 91	f2/e:d	()Ly1/a;
    //   80: astore_1
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 95	y1/a:o0	(Ljava/lang/String;)Ly1/a$e;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull +12 -> 102
    //   93: aload_0
    //   94: getfield 27	f2/e:d	Lf2/c;
    //   97: aload_3
    //   98: invokevirtual 97	f2/c:b	(Ljava/lang/String;)V
    //   101: return
    //   102: aload_1
    //   103: aload_3
    //   104: invokevirtual 101	y1/a:l0	(Ljava/lang/String;)Ly1/a$c;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +35 -> 144
    //   112: aload_2
    //   113: aload_1
    //   114: iconst_0
    //   115: invokevirtual 107	y1/a$c:f	(I)Ljava/io/File;
    //   118: invokeinterface 112 2 0
    //   123: ifeq +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 114	y1/a$c:e	()V
    //   130: aload_1
    //   131: invokevirtual 116	y1/a$c:b	()V
    //   134: goto +62 -> 196
    //   137: astore_2
    //   138: aload_1
    //   139: invokevirtual 116	y1/a$c:b	()V
    //   142: aload_2
    //   143: athrow
    //   144: new 69	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc 118
    //   155: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: aload_3
    //   161: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new 120	java/lang/IllegalStateException
    //   168: dup
    //   169: aload_1
    //   170: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 122	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_1
    //   178: ldc 61
    //   180: iconst_5
    //   181: invokestatic 67	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   184: ifeq +12 -> 196
    //   187: ldc 61
    //   189: ldc 124
    //   191: aload_1
    //   192: invokestatic 128	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   195: pop
    //   196: aload_0
    //   197: getfield 27	f2/e:d	Lf2/c;
    //   200: aload_3
    //   201: invokevirtual 97	f2/c:b	(Ljava/lang/String;)V
    //   204: return
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 27	f2/e:d	Lf2/c;
    //   210: aload_3
    //   211: invokevirtual 97	f2/c:b	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	e
    //   0	216	1	paramf	f
    //   0	216	2	paramb	a.b
    //   8	203	3	str	String
    //   33	56	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	130	137	finally
    //   76	88	177	java/io/IOException
    //   102	108	177	java/io/IOException
    //   130	134	177	java/io/IOException
    //   138	144	177	java/io/IOException
    //   144	177	177	java/io/IOException
    //   17	76	205	finally
    //   76	88	205	finally
    //   102	108	205	finally
    //   130	134	205	finally
    //   138	144	205	finally
    //   144	177	205	finally
    //   178	196	205	finally
  }
  
  public File b(f paramf)
  {
    String str = this.a.b(paramf);
    if (Log.isLoggable("DiskLruCacheWrapper", 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get: Obtained: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" for for Key: ");
      localStringBuilder.append(paramf);
      Log.v("DiskLruCacheWrapper", localStringBuilder.toString());
    }
    try
    {
      paramf = d().o0(str);
      if (paramf != null)
      {
        paramf = paramf.a(0);
        return paramf;
      }
    }
    catch (IOException paramf)
    {
      if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", paramf);
      }
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.e
 * JD-Core Version:    0.7.0.1
 */