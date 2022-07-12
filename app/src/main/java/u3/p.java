package u3;

import android.graphics.Bitmap;
import com.farsunset.hoxin.common.model.CloudImage;
import java.io.File;
import o3.b;

public class p
{
  /* Error */
  private static Bitmap a(int paramInt, long paramLong, Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 14	android/graphics/Bitmap:getRowBytes	()I
    //   4: aload_3
    //   5: invokevirtual 17	android/graphics/Bitmap:getHeight	()I
    //   8: imul
    //   9: i2l
    //   10: lstore 7
    //   12: bipush 100
    //   14: istore 6
    //   16: lload 7
    //   18: lload_1
    //   19: lcmp
    //   20: ifle +142 -> 162
    //   23: new 19	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore 9
    //   32: aload_3
    //   33: invokevirtual 26	android/graphics/Bitmap:getWidth	()I
    //   36: aload_3
    //   37: invokevirtual 17	android/graphics/Bitmap:getHeight	()I
    //   40: if_icmple +29 -> 69
    //   43: aload_3
    //   44: invokevirtual 26	android/graphics/Bitmap:getWidth	()I
    //   47: iload_0
    //   48: invokestatic 32	java/lang/Math:min	(II)I
    //   51: istore 5
    //   53: aload_3
    //   54: invokevirtual 17	android/graphics/Bitmap:getHeight	()I
    //   57: iload 5
    //   59: imul
    //   60: aload_3
    //   61: invokevirtual 26	android/graphics/Bitmap:getWidth	()I
    //   64: idiv
    //   65: istore_0
    //   66: goto +25 -> 91
    //   69: aload_3
    //   70: invokevirtual 17	android/graphics/Bitmap:getHeight	()I
    //   73: iload_0
    //   74: invokestatic 32	java/lang/Math:min	(II)I
    //   77: istore_0
    //   78: aload_3
    //   79: invokevirtual 26	android/graphics/Bitmap:getWidth	()I
    //   82: iload_0
    //   83: imul
    //   84: aload_3
    //   85: invokevirtual 17	android/graphics/Bitmap:getHeight	()I
    //   88: idiv
    //   89: istore 5
    //   91: aload_3
    //   92: iload 5
    //   94: iload_0
    //   95: iconst_1
    //   96: invokestatic 36	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   99: astore_3
    //   100: iload 6
    //   102: istore_0
    //   103: aload 9
    //   105: invokevirtual 39	java/io/ByteArrayOutputStream:reset	()V
    //   108: iload_0
    //   109: iconst_5
    //   110: isub
    //   111: istore_0
    //   112: aload_3
    //   113: getstatic 45	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   116: iload_0
    //   117: aload 9
    //   119: invokevirtual 49	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   122: pop
    //   123: aload 9
    //   125: invokevirtual 53	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   128: arraylength
    //   129: i2l
    //   130: lload_1
    //   131: lcmp
    //   132: ifgt -29 -> 103
    //   135: aload 4
    //   137: aload 9
    //   139: invokevirtual 53	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: invokestatic 59	ca/a:t	(Ljava/io/File;[B)V
    //   145: goto +10 -> 155
    //   148: astore 4
    //   150: aload 4
    //   152: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   155: aload 9
    //   157: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   160: aload_3
    //   161: areturn
    //   162: aload 4
    //   164: invokestatic 74	u3/l:n	(Ljava/io/File;)V
    //   167: new 76	java/io/FileOutputStream
    //   170: dup
    //   171: aload 4
    //   173: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   176: astore 4
    //   178: aload 4
    //   180: astore 9
    //   182: aload_3
    //   183: getstatic 81	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   186: bipush 100
    //   188: aload 4
    //   190: invokevirtual 49	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   193: pop
    //   194: aload 4
    //   196: astore 9
    //   198: aload 4
    //   200: invokevirtual 84	java/io/FileOutputStream:flush	()V
    //   203: goto +29 -> 232
    //   206: astore 10
    //   208: goto +15 -> 223
    //   211: astore_3
    //   212: aconst_null
    //   213: astore 9
    //   215: goto +25 -> 240
    //   218: astore 10
    //   220: aconst_null
    //   221: astore 4
    //   223: aload 4
    //   225: astore 9
    //   227: aload 10
    //   229: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   232: aload 4
    //   234: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   237: aload_3
    //   238: areturn
    //   239: astore_3
    //   240: aload 9
    //   242: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   245: aload_3
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramInt	int
    //   0	247	1	paramLong	long
    //   0	247	3	paramBitmap	Bitmap
    //   0	247	4	paramFile	File
    //   51	42	5	i	int
    //   14	87	6	j	int
    //   10	7	7	l	long
    //   30	211	9	localObject	Object
    //   206	1	10	localIOException1	java.io.IOException
    //   218	10	10	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   135	145	148	java/io/IOException
    //   182	194	206	java/io/IOException
    //   198	203	206	java/io/IOException
    //   162	178	211	finally
    //   162	178	218	java/io/IOException
    //   182	194	239	finally
    //   198	203	239	finally
    //   227	232	239	finally
  }
  
  public static CloudImage b(Bitmap paramBitmap, b paramb)
  {
    String str = l.K();
    paramBitmap = a(1920, 307200L, paramBitmap, a0.g(str));
    CloudImage localCloudImage = new CloudImage();
    localCloudImage.ow = paramBitmap.getWidth();
    localCloudImage.oh = paramBitmap.getHeight();
    localCloudImage.image = str;
    localCloudImage.bucket = paramb.a();
    paramb = a0.g(l.K());
    Bitmap localBitmap = c(paramBitmap, paramb);
    localCloudImage.tw = localBitmap.getWidth();
    localCloudImage.th = localBitmap.getHeight();
    if (localBitmap != paramBitmap)
    {
      localCloudImage.thumb = paramb.getName();
      return localCloudImage;
    }
    localCloudImage.thumb = str;
    return localCloudImage;
  }
  
  private static Bitmap c(Bitmap paramBitmap, File paramFile)
  {
    return a(480, 65536L, paramBitmap, paramFile);
  }
  
  public static void d(Bitmap paramBitmap, File paramFile)
  {
    a(480, 65536L, paramBitmap, paramFile);
  }
  
  /* Error */
  public static void e(Bitmap paramBitmap, File paramFile, android.graphics.Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload_1
    //   10: invokestatic 74	u3/l:n	(Ljava/io/File;)V
    //   13: aload 5
    //   15: astore_3
    //   16: new 76	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore_1
    //   25: aload_0
    //   26: aload_2
    //   27: bipush 100
    //   29: aload_1
    //   30: invokevirtual 49	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_1
    //   35: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   38: return
    //   39: astore_0
    //   40: aload_1
    //   41: astore_3
    //   42: goto +30 -> 72
    //   45: astore_2
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: goto +11 -> 61
    //   53: astore_0
    //   54: goto +18 -> 72
    //   57: astore_1
    //   58: aload 4
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: invokevirtual 148	java/io/FileNotFoundException:printStackTrace	()V
    //   67: aload_0
    //   68: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   71: return
    //   72: aload_3
    //   73: invokestatic 68	ca/c:c	(Ljava/io/OutputStream;)V
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	Bitmap
    //   0	78	1	paramFile	File
    //   0	78	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   8	65	3	localObject1	Object
    //   1	58	4	localObject2	Object
    //   4	10	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	34	39	finally
    //   25	34	45	java/io/FileNotFoundException
    //   9	13	53	finally
    //   16	25	53	finally
    //   63	67	53	finally
    //   9	13	57	java/io/FileNotFoundException
    //   16	25	57	java/io/FileNotFoundException
  }
  
  static void f(Bitmap paramBitmap, File paramFile)
  {
    a(480, 65536L, paramBitmap, paramFile);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.p
 * JD-Core Version:    0.7.0.1
 */