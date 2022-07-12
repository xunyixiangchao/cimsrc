package q0;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import v0.f.b;

public class l
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static ByteBuffer b(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = e(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = c(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = g(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static boolean c(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 41	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 45	q0/l:d	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 47	q0/l:a	(Ljava/io/Closeable;)V
    //   16: iload_3
    //   17: ireturn
    //   18: astore_0
    //   19: goto +6 -> 25
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 47	q0/l:a	(Ljava/io/Closeable;)V
    //   29: aload_0
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	paramFile	File
    //   0	31	1	paramResources	Resources
    //   0	31	2	paramInt	int
    //   11	6	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	18	finally
    //   0	6	22	finally
  }
  
  /* Error */
  public static boolean d(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 53	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: new 55	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: invokespecial 59	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore_3
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 65	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +13 -> 47
    //   37: aload_0
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 69	java/io/FileOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: aload_0
    //   48: invokestatic 47	q0/l:a	(Ljava/io/Closeable;)V
    //   51: aload 5
    //   53: invokestatic 73	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: aload_0
    //   60: astore_3
    //   61: aload_1
    //   62: astore_0
    //   63: goto +72 -> 135
    //   66: astore_1
    //   67: goto +11 -> 78
    //   70: astore_0
    //   71: goto +64 -> 135
    //   74: astore_1
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: new 75	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: ldc 79
    //   95: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: astore_3
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: astore_3
    //   113: ldc 89
    //   115: aload 4
    //   117: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 97	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 47	q0/l:a	(Ljava/io/Closeable;)V
    //   128: aload 5
    //   130: invokestatic 73	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_3
    //   136: invokestatic 47	q0/l:a	(Ljava/io/Closeable;)V
    //   139: aload 5
    //   141: invokestatic 73	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	File
    //   0	146	1	paramInputStream	java.io.InputStream
    //   31	10	2	i	int
    //   9	127	3	localObject	Object
    //   6	110	4	localStringBuilder	StringBuilder
    //   3	137	5	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   20	26	58	finally
    //   26	32	58	finally
    //   37	44	58	finally
    //   20	26	66	java/io/IOException
    //   26	32	66	java/io/IOException
    //   37	44	66	java/io/IOException
    //   10	20	70	finally
    //   80	89	70	finally
    //   91	99	70	finally
    //   101	111	70	finally
    //   113	124	70	finally
    //   10	20	74	java/io/IOException
  }
  
  public static File e(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(".font");
    ((StringBuilder)localObject1).append(Process.myPid());
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(Process.myTid());
    ((StringBuilder)localObject1).append("-");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < 100)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(i);
      localObject2 = new File(paramContext, ((StringBuilder)localObject2).toString());
      try
      {
        boolean bool = ((File)localObject2).createNewFile();
        if (bool) {
          return localObject2;
        }
      }
      catch (IOException localIOException)
      {
        label120:
        break label120;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  public static ByteBuffer f(Context paramContext, CancellationSignal paramCancellationSignal, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 131	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 133
    //   9: aload_1
    //   10: invokevirtual 139	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: ifnull +7 -> 26
    //   22: aload_0
    //   23: invokevirtual 142	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 144	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 148	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 155	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 161	java/nio/channels/FileChannel:size	()J
    //   49: lstore_3
    //   50: aload_2
    //   51: getstatic 167	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   54: lconst_0
    //   55: lload_3
    //   56: invokevirtual 171	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 172	java/io/FileInputStream:close	()V
    //   64: aload_0
    //   65: invokevirtual 142	android/os/ParcelFileDescriptor:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 172	java/io/FileInputStream:close	()V
    //   75: goto +9 -> 84
    //   78: astore_1
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 178	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   84: aload_2
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: invokevirtual 142	android/os/ParcelFileDescriptor:close	()V
    //   91: goto +9 -> 100
    //   94: astore_0
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual 178	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramContext	Context
    //   0	105	1	paramCancellationSignal	CancellationSignal
    //   0	105	2	paramUri	Uri
    //   49	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   40	60	70	finally
    //   71	75	78	finally
    //   28	40	86	finally
    //   60	64	86	finally
    //   79	84	86	finally
    //   84	86	86	finally
    //   87	91	94	finally
    //   5	14	102	java/io/IOException
    //   22	26	102	java/io/IOException
    //   64	68	102	java/io/IOException
    //   95	100	102	java/io/IOException
    //   100	102	102	java/io/IOException
  }
  
  /* Error */
  private static ByteBuffer g(File paramFile)
  {
    // Byte code:
    //   0: new 144	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 155	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 161	java/nio/channels/FileChannel:size	()J
    //   18: lstore_1
    //   19: aload_3
    //   20: getstatic 167	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   23: lconst_0
    //   24: lload_1
    //   25: invokevirtual 171	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   28: astore_3
    //   29: aload_0
    //   30: invokevirtual 172	java/io/FileInputStream:close	()V
    //   33: aload_3
    //   34: areturn
    //   35: astore_3
    //   36: aload_0
    //   37: invokevirtual 172	java/io/FileInputStream:close	()V
    //   40: goto +9 -> 49
    //   43: astore_0
    //   44: aload_3
    //   45: aload_0
    //   46: invokevirtual 178	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   49: aload_3
    //   50: athrow
    //   51: aconst_null
    //   52: areturn
    //   53: astore_0
    //   54: goto -3 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramFile	File
    //   18	7	1	l	long
    //   13	21	3	localObject1	Object
    //   35	15	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   36	40	43	finally
    //   0	9	53	java/io/IOException
    //   29	33	53	java/io/IOException
    //   44	49	53	java/io/IOException
    //   49	51	53	java/io/IOException
  }
  
  public static Map<Uri, ByteBuffer> h(Context paramContext, f.b[] paramArrayOfb, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfb[i];
      if (((f.b)localObject).b() == 0)
      {
        localObject = ((f.b)localObject).d();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, f(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.l
 * JD-Core Version:    0.7.0.1
 */