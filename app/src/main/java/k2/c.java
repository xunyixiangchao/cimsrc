package k2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import b2.g;
import b2.h;
import b2.k;
import e2.b;

public class c
  implements k<Bitmap>
{
  public static final g<Integer> b = g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
  public static final g<Bitmap.CompressFormat> c = g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
  private final b a;
  
  public c(b paramb)
  {
    this.a = paramb;
  }
  
  private Bitmap.CompressFormat d(Bitmap paramBitmap, h paramh)
  {
    paramh = (Bitmap.CompressFormat)paramh.c(c);
    if (paramh != null) {
      return paramh;
    }
    if (paramBitmap.hasAlpha()) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public b2.c b(h paramh)
  {
    return b2.c.b;
  }
  
  /* Error */
  public boolean c(d2.v<Bitmap> paramv, java.io.File paramFile, h paramh)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 87 1 0
    //   6: checkcast 58	android/graphics/Bitmap
    //   9: astore 11
    //   11: aload_0
    //   12: aload 11
    //   14: aload_3
    //   15: invokespecial 89	k2/c:d	(Landroid/graphics/Bitmap;Lb2/h;)Landroid/graphics/Bitmap$CompressFormat;
    //   18: astore 12
    //   20: ldc 91
    //   22: aload 11
    //   24: invokevirtual 95	android/graphics/Bitmap:getWidth	()I
    //   27: invokestatic 24	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aload 11
    //   32: invokevirtual 98	android/graphics/Bitmap:getHeight	()I
    //   35: invokestatic 24	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aload 12
    //   40: invokestatic 103	y2/b:d	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: invokestatic 108	x2/g:b	()J
    //   46: lstore 5
    //   48: aload_3
    //   49: getstatic 32	k2/c:b	Lb2/g;
    //   52: invokevirtual 54	b2/h:c	(Lb2/g;)Ljava/lang/Object;
    //   55: checkcast 20	java/lang/Integer
    //   58: invokevirtual 111	java/lang/Integer:intValue	()I
    //   61: istore 4
    //   63: iconst_0
    //   64: istore 7
    //   66: iconst_0
    //   67: istore 8
    //   69: aconst_null
    //   70: astore 10
    //   72: aconst_null
    //   73: astore 9
    //   75: new 113	java/io/FileOutputStream
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 47	k2/c:a	Le2/b;
    //   88: ifnull +21 -> 109
    //   91: new 118	com/bumptech/glide/load/data/c
    //   94: dup
    //   95: aload_1
    //   96: aload_0
    //   97: getfield 47	k2/c:a	Le2/b;
    //   100: invokespecial 121	com/bumptech/glide/load/data/c:<init>	(Ljava/io/OutputStream;Le2/b;)V
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: goto +3 -> 109
    //   109: aload_1
    //   110: astore 9
    //   112: aload_1
    //   113: astore 10
    //   115: aload 11
    //   117: aload 12
    //   119: iload 4
    //   121: aload_1
    //   122: invokevirtual 125	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload_1
    //   127: astore 9
    //   129: aload_1
    //   130: astore 10
    //   132: aload_1
    //   133: invokevirtual 130	java/io/OutputStream:close	()V
    //   136: iconst_1
    //   137: istore 7
    //   139: aload_1
    //   140: invokevirtual 130	java/io/OutputStream:close	()V
    //   143: goto +59 -> 202
    //   146: astore_2
    //   147: aload_1
    //   148: astore 9
    //   150: aload_2
    //   151: astore_1
    //   152: goto +167 -> 319
    //   155: astore_2
    //   156: goto +11 -> 167
    //   159: astore_1
    //   160: goto +159 -> 319
    //   163: astore_2
    //   164: aload 10
    //   166: astore_1
    //   167: aload_1
    //   168: astore 9
    //   170: ldc 132
    //   172: iconst_3
    //   173: invokestatic 138	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   176: ifeq +15 -> 191
    //   179: aload_1
    //   180: astore 9
    //   182: ldc 132
    //   184: ldc 140
    //   186: aload_2
    //   187: invokestatic 143	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aload_1
    //   192: ifnull +10 -> 202
    //   195: iload 8
    //   197: istore 7
    //   199: goto -60 -> 139
    //   202: ldc 132
    //   204: iconst_2
    //   205: invokestatic 138	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   208: ifeq +105 -> 313
    //   211: new 145	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   218: astore_1
    //   219: aload_1
    //   220: ldc 148
    //   222: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: aload 12
    //   229: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc 157
    //   236: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: aload 11
    //   243: invokestatic 163	x2/l:h	(Landroid/graphics/Bitmap;)I
    //   246: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: ldc 168
    //   253: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: lload 5
    //   260: invokestatic 171	x2/g:a	(J)D
    //   263: invokevirtual 174	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc 176
    //   270: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload_3
    //   276: getstatic 40	k2/c:c	Lb2/g;
    //   279: invokevirtual 54	b2/h:c	(Lb2/g;)Ljava/lang/Object;
    //   282: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: ldc 178
    //   289: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: aload 11
    //   296: invokevirtual 62	android/graphics/Bitmap:hasAlpha	()Z
    //   299: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 132
    //   305: aload_1
    //   306: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 189	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: invokestatic 191	y2/b:e	()V
    //   316: iload 7
    //   318: ireturn
    //   319: aload 9
    //   321: ifnull +8 -> 329
    //   324: aload 9
    //   326: invokevirtual 130	java/io/OutputStream:close	()V
    //   329: aload_1
    //   330: athrow
    //   331: astore_1
    //   332: invokestatic 191	y2/b:e	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: goto -136 -> 202
    //   341: astore_2
    //   342: goto -13 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	c
    //   0	345	1	paramv	d2.v<Bitmap>
    //   0	345	2	paramFile	java.io.File
    //   0	345	3	paramh	h
    //   61	59	4	i	int
    //   46	213	5	l	long
    //   64	253	7	bool1	boolean
    //   67	129	8	bool2	boolean
    //   73	252	9	localv1	d2.v<Bitmap>
    //   70	95	10	localv2	d2.v<Bitmap>
    //   9	286	11	localBitmap	Bitmap
    //   18	210	12	localCompressFormat	Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   84	104	146	finally
    //   84	104	155	java/io/IOException
    //   75	84	159	finally
    //   115	126	159	finally
    //   132	136	159	finally
    //   170	179	159	finally
    //   182	191	159	finally
    //   75	84	163	java/io/IOException
    //   115	126	163	java/io/IOException
    //   132	136	163	java/io/IOException
    //   43	63	331	finally
    //   139	143	331	finally
    //   202	313	331	finally
    //   324	329	331	finally
    //   329	331	331	finally
    //   139	143	337	java/io/IOException
    //   324	329	341	java/io/IOException
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.c
 * JD-Core Version:    0.7.0.1
 */