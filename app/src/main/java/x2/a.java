package x2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
  private static final AtomicReference<byte[]> a = new AtomicReference();
  
  /* Error */
  public static ByteBuffer a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 31	java/io/File:length	()J
    //   10: lstore_1
    //   11: lload_1
    //   12: ldc2_w 32
    //   15: lcmp
    //   16: ifgt +80 -> 96
    //   19: lload_1
    //   20: lconst_0
    //   21: lcmp
    //   22: ifeq +64 -> 86
    //   25: new 35	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_0
    //   30: ldc 37
    //   32: invokespecial 40	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload 5
    //   38: astore_0
    //   39: aload_3
    //   40: invokevirtual 44	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   43: astore 4
    //   45: aload 4
    //   47: astore_0
    //   48: aload 4
    //   50: getstatic 50	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   53: lconst_0
    //   54: lload_1
    //   55: invokevirtual 56	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   58: invokevirtual 62	java/nio/MappedByteBuffer:load	()Ljava/nio/MappedByteBuffer;
    //   61: astore 5
    //   63: aload 4
    //   65: invokevirtual 65	java/nio/channels/FileChannel:close	()V
    //   68: aload_3
    //   69: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   72: aload 5
    //   74: areturn
    //   75: astore 5
    //   77: aload_0
    //   78: astore 4
    //   80: aload 5
    //   82: astore_0
    //   83: goto +26 -> 109
    //   86: new 25	java/io/IOException
    //   89: dup
    //   90: ldc 68
    //   92: invokespecial 71	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   95: athrow
    //   96: new 25	java/io/IOException
    //   99: dup
    //   100: ldc 73
    //   102: invokespecial 71	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   105: athrow
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_3
    //   109: aload 4
    //   111: ifnull +8 -> 119
    //   114: aload 4
    //   116: invokevirtual 65	java/nio/channels/FileChannel:close	()V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: goto -62 -> 68
    //   133: astore_0
    //   134: aload 5
    //   136: areturn
    //   137: astore 4
    //   139: goto -20 -> 119
    //   142: astore_3
    //   143: goto -16 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	java.io.File
    //   10	45	1	l	long
    //   35	89	3	localRandomAccessFile	java.io.RandomAccessFile
    //   142	1	3	localIOException1	IOException
    //   1	114	4	localObject	Object
    //   137	1	4	localIOException2	IOException
    //   4	69	5	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   75	60	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   39	45	75	finally
    //   48	63	75	finally
    //   6	11	106	finally
    //   25	36	106	finally
    //   86	96	106	finally
    //   96	106	106	finally
    //   63	68	129	java/io/IOException
    //   68	72	133	java/io/IOException
    //   114	119	137	java/io/IOException
    //   123	127	142	java/io/IOException
  }
  
  public static ByteBuffer b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    byte[] arrayOfByte2 = (byte[])a.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[16384];
    }
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte1);
      if (i < 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte1, 0, i);
    }
    a.set(arrayOfByte1);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    return d(ByteBuffer.allocateDirect(paramInputStream.length).put(paramInputStream));
  }
  
  private static b c(ByteBuffer paramByteBuffer)
  {
    if ((!paramByteBuffer.isReadOnly()) && (paramByteBuffer.hasArray())) {
      return new b(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.limit());
    }
    return null;
  }
  
  public static ByteBuffer d(ByteBuffer paramByteBuffer)
  {
    return (ByteBuffer)paramByteBuffer.position(0);
  }
  
  public static byte[] e(ByteBuffer paramByteBuffer)
  {
    Object localObject = c(paramByteBuffer);
    if ((localObject != null) && (((b)localObject).a == 0) && (((b)localObject).b == ((b)localObject).c.length)) {
      return paramByteBuffer.array();
    }
    paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    localObject = new byte[paramByteBuffer.limit()];
    d(paramByteBuffer);
    paramByteBuffer.get((byte[])localObject);
    return localObject;
  }
  
  /* Error */
  public static void f(ByteBuffer paramByteBuffer, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 117	x2/a:d	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   4: pop
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 4
    //   10: new 35	java/io/RandomAccessFile
    //   13: dup
    //   14: aload_1
    //   15: ldc 164
    //   17: invokespecial 40	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload 4
    //   23: astore_1
    //   24: aload_3
    //   25: invokevirtual 44	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 167	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   36: pop
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: iconst_0
    //   41: invokevirtual 171	java/nio/channels/FileChannel:force	(Z)V
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: invokevirtual 65	java/nio/channels/FileChannel:close	()V
    //   50: aload_2
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   56: aload_2
    //   57: invokevirtual 65	java/nio/channels/FileChannel:close	()V
    //   60: aload_3
    //   61: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   64: return
    //   65: astore_0
    //   66: aload_1
    //   67: astore_2
    //   68: aload_3
    //   69: astore_1
    //   70: goto +6 -> 76
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_2
    //   77: ifnull +7 -> 84
    //   80: aload_2
    //   81: invokevirtual 65	java/nio/channels/FileChannel:close	()V
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: goto -35 -> 60
    //   98: astore_0
    //   99: return
    //   100: astore_2
    //   101: goto -17 -> 84
    //   104: astore_1
    //   105: goto -13 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramByteBuffer	ByteBuffer
    //   0	108	1	paramFile	java.io.File
    //   6	75	2	localObject1	Object
    //   100	1	2	localIOException	IOException
    //   20	49	3	localRandomAccessFile	java.io.RandomAccessFile
    //   8	14	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	29	65	finally
    //   31	37	65	finally
    //   39	44	65	finally
    //   46	50	65	finally
    //   52	56	65	finally
    //   10	21	73	finally
    //   56	60	94	java/io/IOException
    //   60	64	98	java/io/IOException
    //   80	84	100	java/io/IOException
    //   88	92	104	java/io/IOException
  }
  
  public static InputStream g(ByteBuffer paramByteBuffer)
  {
    return new a(paramByteBuffer);
  }
  
  private static class a
    extends InputStream
  {
    private final ByteBuffer a;
    private int b = -1;
    
    a(ByteBuffer paramByteBuffer)
    {
      this.a = paramByteBuffer;
    }
    
    public int available()
    {
      return this.a.remaining();
    }
    
    public void mark(int paramInt)
    {
      try
      {
        this.b = this.a.position();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public boolean markSupported()
    {
      return true;
    }
    
    public int read()
    {
      if (!this.a.hasRemaining()) {
        return -1;
      }
      return this.a.get() & 0xFF;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.a.hasRemaining()) {
        return -1;
      }
      paramInt2 = Math.min(paramInt2, available());
      this.a.get(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt2;
    }
    
    public void reset()
    {
      try
      {
        int i = this.b;
        if (i != -1)
        {
          this.a.position(i);
          return;
        }
        throw new IOException("Cannot reset to unset mark position");
      }
      finally {}
    }
    
    public long skip(long paramLong)
    {
      if (!this.a.hasRemaining()) {
        return -1L;
      }
      paramLong = Math.min(paramLong, available());
      ByteBuffer localByteBuffer = this.a;
      localByteBuffer.position((int)(localByteBuffer.position() + paramLong));
      return paramLong;
    }
  }
  
  static final class b
  {
    final int a;
    final int b;
    final byte[] c;
    
    b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.c = paramArrayOfByte;
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.a
 * JD-Core Version:    0.7.0.1
 */