package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import e2.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import k2.w;

public final class a
{
  public static int a(List<ImageHeaderParser> paramList, ParcelFileDescriptorRewinder paramParcelFileDescriptorRewinder, final b paramb)
  {
    return d(paramList, new f(paramParcelFileDescriptorRewinder, paramb));
  }
  
  public static int b(List<ImageHeaderParser> paramList, InputStream paramInputStream, final b paramb)
  {
    if (paramInputStream == null) {
      return -1;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new w(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    return d(paramList, new e((InputStream)localObject, paramb));
  }
  
  public static int c(List<ImageHeaderParser> paramList, ByteBuffer paramByteBuffer, final b paramb)
  {
    if (paramByteBuffer == null) {
      return -1;
    }
    return d(paramList, new d(paramByteBuffer, paramb));
  }
  
  private static int d(List<ImageHeaderParser> paramList, g paramg)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      int k = paramg.a((ImageHeaderParser)paramList.get(i));
      if (k != -1) {
        return k;
      }
      i += 1;
    }
    return -1;
  }
  
  public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> paramList, ParcelFileDescriptorRewinder paramParcelFileDescriptorRewinder, final b paramb)
  {
    return h(paramList, new c(paramParcelFileDescriptorRewinder, paramb));
  }
  
  public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> paramList, InputStream paramInputStream, b paramb)
  {
    if (paramInputStream == null) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new w(paramInputStream, paramb);
    }
    ((InputStream)localObject).mark(5242880);
    return h(paramList, new a((InputStream)localObject));
  }
  
  public static ImageHeaderParser.ImageType g(List<ImageHeaderParser> paramList, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    return h(paramList, new b(paramByteBuffer));
  }
  
  private static ImageHeaderParser.ImageType h(List<ImageHeaderParser> paramList, h paramh)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ImageHeaderParser.ImageType localImageType = paramh.a((ImageHeaderParser)paramList.get(i));
      if (localImageType != ImageHeaderParser.ImageType.UNKNOWN) {
        return localImageType;
      }
      i += 1;
    }
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  class a
    implements a.h
  {
    a() {}
    
    public ImageHeaderParser.ImageType a(ImageHeaderParser paramImageHeaderParser)
    {
      try
      {
        paramImageHeaderParser = paramImageHeaderParser.d(a.this);
        return paramImageHeaderParser;
      }
      finally
      {
        a.this.reset();
      }
    }
  }
  
  class b
    implements a.h
  {
    b() {}
    
    public ImageHeaderParser.ImageType a(ImageHeaderParser paramImageHeaderParser)
    {
      return paramImageHeaderParser.a(a.this);
    }
  }
  
  class c
    implements a.h
  {
    c(b paramb) {}
    
    /* Error */
    public ImageHeaderParser.ImageType a(ImageHeaderParser paramImageHeaderParser)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: new 30	k2/w
      //   5: dup
      //   6: new 32	java/io/FileInputStream
      //   9: dup
      //   10: aload_0
      //   11: getfield 19	com/bumptech/glide/load/a$c:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   14: invokevirtual 38	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   17: invokevirtual 44	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   20: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
      //   23: aload_0
      //   24: getfield 21	com/bumptech/glide/load/a$c:b	Le2/b;
      //   27: invokespecial 50	k2/w:<init>	(Ljava/io/InputStream;Le2/b;)V
      //   30: astore_3
      //   31: aload_1
      //   32: aload_3
      //   33: invokeinterface 55 2 0
      //   38: astore_1
      //   39: aload_3
      //   40: invokevirtual 60	java/io/InputStream:close	()V
      //   43: aload_0
      //   44: getfield 19	com/bumptech/glide/load/a$c:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   47: invokevirtual 38	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   50: pop
      //   51: aload_1
      //   52: areturn
      //   53: astore_1
      //   54: aload_3
      //   55: astore_2
      //   56: goto +4 -> 60
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +7 -> 68
      //   64: aload_2
      //   65: invokevirtual 60	java/io/InputStream:close	()V
      //   68: aload_0
      //   69: getfield 19	com/bumptech/glide/load/a$c:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   72: invokevirtual 38	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   75: pop
      //   76: aload_1
      //   77: athrow
      //   78: astore_2
      //   79: goto -36 -> 43
      //   82: astore_2
      //   83: goto -15 -> 68
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	c
      //   0	86	1	paramImageHeaderParser	ImageHeaderParser
      //   1	64	2	localObject	Object
      //   78	1	2	localIOException1	java.io.IOException
      //   82	1	2	localIOException2	java.io.IOException
      //   30	25	3	localw	w
      // Exception table:
      //   from	to	target	type
      //   31	39	53	finally
      //   2	31	59	finally
      //   39	43	78	java/io/IOException
      //   64	68	82	java/io/IOException
    }
  }
  
  class d
    implements a.g
  {
    d(b paramb) {}
    
    public int a(ImageHeaderParser paramImageHeaderParser)
    {
      return paramImageHeaderParser.b(a.this, paramb);
    }
  }
  
  class e
    implements a.g
  {
    e(b paramb) {}
    
    public int a(ImageHeaderParser paramImageHeaderParser)
    {
      try
      {
        int i = paramImageHeaderParser.c(a.this, paramb);
        return i;
      }
      finally
      {
        a.this.reset();
      }
    }
  }
  
  class f
    implements a.g
  {
    f(b paramb) {}
    
    /* Error */
    public int a(ImageHeaderParser paramImageHeaderParser)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: new 29	k2/w
      //   5: dup
      //   6: new 31	java/io/FileInputStream
      //   9: dup
      //   10: aload_0
      //   11: getfield 18	com/bumptech/glide/load/a$f:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   14: invokevirtual 37	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   17: invokevirtual 43	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   20: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
      //   23: aload_0
      //   24: getfield 20	com/bumptech/glide/load/a$f:b	Le2/b;
      //   27: invokespecial 49	k2/w:<init>	(Ljava/io/InputStream;Le2/b;)V
      //   30: astore 4
      //   32: aload_1
      //   33: aload 4
      //   35: aload_0
      //   36: getfield 20	com/bumptech/glide/load/a$f:b	Le2/b;
      //   39: invokeinterface 55 3 0
      //   44: istore_2
      //   45: aload 4
      //   47: invokevirtual 60	java/io/InputStream:close	()V
      //   50: aload_0
      //   51: getfield 18	com/bumptech/glide/load/a$f:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   54: invokevirtual 37	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   57: pop
      //   58: iload_2
      //   59: ireturn
      //   60: astore_1
      //   61: aload 4
      //   63: astore_3
      //   64: goto +4 -> 68
      //   67: astore_1
      //   68: aload_3
      //   69: ifnull +7 -> 76
      //   72: aload_3
      //   73: invokevirtual 60	java/io/InputStream:close	()V
      //   76: aload_0
      //   77: getfield 18	com/bumptech/glide/load/a$f:a	Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;
      //   80: invokevirtual 37	com/bumptech/glide/load/data/ParcelFileDescriptorRewinder:d	()Landroid/os/ParcelFileDescriptor;
      //   83: pop
      //   84: aload_1
      //   85: athrow
      //   86: astore_1
      //   87: goto -37 -> 50
      //   90: astore_3
      //   91: goto -15 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	94	0	this	f
      //   0	94	1	paramImageHeaderParser	ImageHeaderParser
      //   44	15	2	i	int
      //   1	72	3	localObject	Object
      //   90	1	3	localIOException	java.io.IOException
      //   30	32	4	localw	w
      // Exception table:
      //   from	to	target	type
      //   32	45	60	finally
      //   2	32	67	finally
      //   45	50	86	java/io/IOException
      //   72	76	90	java/io/IOException
    }
  }
  
  private static abstract interface g
  {
    public abstract int a(ImageHeaderParser paramImageHeaderParser);
  }
  
  private static abstract interface h
  {
    public abstract ImageHeaderParser.ImageType a(ImageHeaderParser paramImageHeaderParser);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.a
 * JD-Core Version:    0.7.0.1
 */