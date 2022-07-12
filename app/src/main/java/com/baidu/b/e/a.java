package com.baidu.b.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private Context a;
  private a b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    c().mkdirs();
  }
  
  /* Error */
  public static String a(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 34	com/baidu/b/e/a:a	(Ljava/io/File;)V
    //   4: new 23	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aconst_null
    //   15: astore_1
    //   16: new 39	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 40	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore 5
    //   25: new 42	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: sipush 8192
    //   37: newarray byte
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 48	java/io/FileInputStream:read	([B)I
    //   45: istore 4
    //   47: iload 4
    //   49: ifle +15 -> 64
    //   52: aload 5
    //   54: aload_1
    //   55: iconst_0
    //   56: iload 4
    //   58: invokevirtual 52	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -21 -> 40
    //   64: aload 5
    //   66: invokevirtual 56	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   69: astore 6
    //   71: aload 6
    //   73: astore_1
    //   74: iload_3
    //   75: ifeq +16 -> 91
    //   78: new 58	com/baidu/b/c/b/c
    //   81: dup
    //   82: invokespecial 59	com/baidu/b/c/b/c:<init>	()V
    //   85: aload 6
    //   87: invokevirtual 62	com/baidu/b/c/b/c:b	([B)[B
    //   90: astore_1
    //   91: new 64	java/lang/String
    //   94: dup
    //   95: aload_1
    //   96: aload_2
    //   97: invokespecial 67	java/lang/String:<init>	([BLjava/lang/String;)V
    //   100: astore_1
    //   101: aload_0
    //   102: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   105: aload 5
    //   107: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: goto +18 -> 131
    //   116: goto +31 -> 147
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: goto +9 -> 131
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: astore 5
    //   131: aload_0
    //   132: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   135: aload 5
    //   137: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   140: aload_1
    //   141: athrow
    //   142: aconst_null
    //   143: astore 5
    //   145: aload_1
    //   146: astore_0
    //   147: aload_0
    //   148: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   151: aload 5
    //   153: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   156: ldc 74
    //   158: areturn
    //   159: astore_0
    //   160: goto -18 -> 142
    //   163: astore_0
    //   164: aload_1
    //   165: astore_0
    //   166: goto -19 -> 147
    //   169: astore_1
    //   170: goto -54 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	File
    //   0	173	1	paramString1	String
    //   0	173	2	paramString2	String
    //   0	173	3	paramBoolean	boolean
    //   45	12	4	i	int
    //   23	129	5	localObject	Object
    //   69	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	40	112	finally
    //   40	47	112	finally
    //   52	61	112	finally
    //   64	71	112	finally
    //   78	91	112	finally
    //   91	101	112	finally
    //   25	34	119	finally
    //   16	25	125	finally
    //   16	25	159	java/lang/Exception
    //   25	34	163	java/lang/Exception
    //   34	40	169	java/lang/Exception
    //   40	47	169	java/lang/Exception
    //   52	61	169	java/lang/Exception
    //   64	71	169	java/lang/Exception
    //   78	91	169	java/lang/Exception
    //   91	101	169	java/lang/Exception
  }
  
  public static void a(File paramFile)
  {
    paramFile.mkdirs();
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 34	com/baidu/b/e/a:a	(Ljava/io/File;)V
    //   4: new 23	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aconst_null
    //   15: astore_1
    //   16: new 77	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: iload 4
    //   27: ifeq +24 -> 51
    //   30: aload_0
    //   31: new 58	com/baidu/b/c/b/c
    //   34: dup
    //   35: invokespecial 59	com/baidu/b/c/b/c:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 81	java/lang/String:getBytes	()[B
    //   42: invokevirtual 83	com/baidu/b/c/b/c:a	([B)[B
    //   45: invokevirtual 86	java/io/FileOutputStream:write	([B)V
    //   48: goto +12 -> 60
    //   51: aload_0
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 89	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   57: invokevirtual 86	java/io/FileOutputStream:write	([B)V
    //   60: aload_0
    //   61: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_1
    //   67: aload_0
    //   68: astore_2
    //   69: goto +11 -> 80
    //   72: goto +14 -> 86
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_0
    //   79: astore_1
    //   80: aload_2
    //   81: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   84: aload_1
    //   85: athrow
    //   86: aload_0
    //   87: invokestatic 72	com/baidu/b/f/c:a	(Ljava/io/Closeable;)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_0
    //   93: aload_1
    //   94: astore_0
    //   95: goto -9 -> 86
    //   98: astore_1
    //   99: goto -27 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   0	102	1	paramString1	String
    //   0	102	2	paramString2	String
    //   0	102	3	paramString3	String
    //   0	102	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   30	48	66	finally
    //   51	60	66	finally
    //   16	25	75	finally
    //   16	25	92	java/lang/Exception
    //   30	48	98	java/lang/Exception
    //   51	60	98	java/lang/Exception
  }
  
  private File c()
  {
    return new File(a(), ".cesium");
  }
  
  public File a()
  {
    return new File(this.a.getApplicationInfo().dataDir);
  }
  
  public a b()
  {
    try
    {
      if (this.b == null) {
        this.b = new a(".cesium", null);
      }
      a locala = this.b;
      return locala;
    }
    finally {}
  }
  
  public final class a
  {
    private File b;
    private String c;
    private a d;
    private boolean e;
    
    a(File paramFile)
    {
      this.e = true;
      this.b = paramFile;
      this.c = paramFile.getName();
    }
    
    a(String paramString, a parama)
    {
      this.c = paramString;
      this.d = parama;
      this.e = false;
    }
    
    public a a(File paramFile)
    {
      if (!this.e)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject = this;
        a locala;
        do
        {
          localArrayList.add(((a)localObject).c());
          locala = ((a)localObject).d();
          localObject = locala;
        } while (locala != null);
        int i = localArrayList.size() - 1;
        while (i >= 0)
        {
          paramFile = new File(paramFile, (String)localArrayList.get(i));
          i -= 1;
        }
        return new a(a.this, paramFile);
      }
      throw new IllegalStateException("isolate session is not support");
    }
    
    public a a(String paramString)
    {
      return new a(a.this, paramString, this);
    }
    
    public String a(String paramString, boolean paramBoolean)
    {
      return a.a(b(), paramString, "UTF-8", paramBoolean);
    }
    
    public void a()
    {
      b().mkdirs();
    }
    
    public boolean a(String paramString1, String paramString2, boolean paramBoolean)
    {
      return a.a(b(), paramString1, paramString2, "UTF-8", paramBoolean);
    }
    
    public File b()
    {
      File localFile = this.b;
      if (localFile != null) {
        return localFile;
      }
      if (this.d == null) {
        localFile = new File(a.this.a(), this.c);
      } else {
        localFile = new File(this.d.b(), this.c);
      }
      this.b = localFile;
      return localFile;
    }
    
    public String c()
    {
      return this.c;
    }
    
    public a d()
    {
      return this.d;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.e.a
 * JD-Core Version:    0.7.0.1
 */