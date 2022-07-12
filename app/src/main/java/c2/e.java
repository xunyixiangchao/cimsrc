package c2;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import e2.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class e
{
  private static final a f = new a();
  private final a a;
  private final d b;
  private final b c;
  private final ContentResolver d;
  private final List<ImageHeaderParser> e;
  
  e(List<ImageHeaderParser> paramList, a parama, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this.a = parama;
    this.b = paramd;
    this.c = paramb;
    this.d = paramContentResolver;
    this.e = paramList;
  }
  
  e(List<ImageHeaderParser> paramList, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this(paramList, f, paramd, paramb, paramContentResolver);
  }
  
  /* Error */
  private String b(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 32	c2/e:b	Lc2/d;
    //   6: aload_1
    //   7: invokeinterface 52 2 0
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +39 -> 53
    //   17: aload_3
    //   18: astore_2
    //   19: aload_3
    //   20: invokeinterface 58 1 0
    //   25: ifeq +28 -> 53
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokeinterface 62 2 0
    //   37: astore 4
    //   39: aload_3
    //   40: invokeinterface 65 1 0
    //   45: aload 4
    //   47: areturn
    //   48: astore 4
    //   50: goto +23 -> 73
    //   53: aload_3
    //   54: ifnull +9 -> 63
    //   57: aload_3
    //   58: invokeinterface 65 1 0
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: goto +76 -> 142
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_3
    //   73: aload_3
    //   74: astore_2
    //   75: ldc 67
    //   77: iconst_3
    //   78: invokestatic 73	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   81: ifeq +48 -> 129
    //   84: aload_3
    //   85: astore_2
    //   86: new 75	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   93: astore 5
    //   95: aload_3
    //   96: astore_2
    //   97: aload 5
    //   99: ldc 78
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: astore_2
    //   107: aload 5
    //   109: aload_1
    //   110: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: ldc 67
    //   118: aload 5
    //   120: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload 4
    //   125: invokestatic 92	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   128: pop
    //   129: aload_3
    //   130: ifnull +9 -> 139
    //   133: aload_3
    //   134: invokeinterface 65 1 0
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: aload_2
    //   143: ifnull +9 -> 152
    //   146: aload_2
    //   147: invokeinterface 65 1 0
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	e
    //   0	154	1	paramUri	Uri
    //   1	146	2	localObject	Object
    //   12	122	3	localCursor	android.database.Cursor
    //   37	9	4	str	String
    //   48	1	4	localSecurityException1	java.lang.SecurityException
    //   69	55	4	localSecurityException2	java.lang.SecurityException
    //   93	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	28	48	java/lang/SecurityException
    //   30	39	48	java/lang/SecurityException
    //   2	13	65	finally
    //   2	13	69	java/lang/SecurityException
    //   19	28	141	finally
    //   30	39	141	finally
    //   75	84	141	finally
    //   86	95	141	finally
    //   97	105	141	finally
    //   107	114	141	finally
    //   116	129	141	finally
  }
  
  private boolean c(File paramFile)
  {
    return (this.a.a(paramFile)) && (0L < this.a.c(paramFile));
  }
  
  /* Error */
  int a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 36	c2/e:d	Landroid/content/ContentResolver;
    //   12: aload_1
    //   13: invokevirtual 109	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   16: astore 6
    //   18: aload 6
    //   20: astore_3
    //   21: aload 6
    //   23: astore 4
    //   25: aload 6
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 38	c2/e:e	Ljava/util/List;
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 34	c2/e:c	Le2/b;
    //   39: invokestatic 114	com/bumptech/glide/load/a:b	(Ljava/util/List;Ljava/io/InputStream;Le2/b;)I
    //   42: istore_2
    //   43: aload 6
    //   45: ifnull +8 -> 53
    //   48: aload 6
    //   50: invokevirtual 117	java/io/InputStream:close	()V
    //   53: iload_2
    //   54: ireturn
    //   55: astore_1
    //   56: goto +87 -> 143
    //   59: astore 6
    //   61: goto +9 -> 70
    //   64: astore 6
    //   66: aload 5
    //   68: astore 4
    //   70: aload 4
    //   72: astore_3
    //   73: ldc 67
    //   75: iconst_3
    //   76: invokestatic 73	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   79: ifeq +52 -> 131
    //   82: aload 4
    //   84: astore_3
    //   85: new 75	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   92: astore 5
    //   94: aload 4
    //   96: astore_3
    //   97: aload 5
    //   99: ldc 119
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: astore_3
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: astore_3
    //   118: ldc 67
    //   120: aload 5
    //   122: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload 6
    //   127: invokestatic 92	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 117	java/io/InputStream:close	()V
    //   141: iconst_m1
    //   142: ireturn
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 117	java/io/InputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: iload_2
    //   155: ireturn
    //   156: astore_1
    //   157: goto -16 -> 141
    //   160: astore_3
    //   161: goto -10 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	e
    //   0	164	1	paramUri	Uri
    //   42	113	2	i	int
    //   7	141	3	localObject1	Object
    //   160	1	3	localIOException1	java.io.IOException
    //   1	136	4	localObject2	Object
    //   4	117	5	localObject3	Object
    //   16	33	6	localInputStream	InputStream
    //   59	1	6	localNullPointerException	NullPointerException
    //   64	62	6	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	18	55	finally
    //   29	43	55	finally
    //   73	82	55	finally
    //   85	94	55	finally
    //   97	105	55	finally
    //   108	115	55	finally
    //   118	131	55	finally
    //   8	18	59	java/lang/NullPointerException
    //   29	43	59	java/lang/NullPointerException
    //   8	18	64	java/io/IOException
    //   29	43	64	java/io/IOException
    //   48	53	153	java/io/IOException
    //   136	141	156	java/io/IOException
    //   147	151	160	java/io/IOException
  }
  
  public InputStream d(Uri paramUri)
  {
    Object localObject = b(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = this.a.b((String)localObject);
    if (!c((File)localObject)) {
      return null;
    }
    localObject = Uri.fromFile((File)localObject);
    try
    {
      InputStream localInputStream = this.d.openInputStream((Uri)localObject);
      return localInputStream;
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NPE opening uri: ");
      localStringBuilder.append(paramUri);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(localObject);
      throw ((FileNotFoundException)new FileNotFoundException(localStringBuilder.toString()).initCause(localNullPointerException));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c2.e
 * JD-Core Version:    0.7.0.1
 */