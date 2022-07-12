package v;

import android.graphics.Rect;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.d1;
import androidx.camera.core.e1;
import androidx.camera.core.impl.utils.g;
import androidx.camera.core.impl.utils.g.b;
import androidx.camera.core.n1;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import s.p0;
import u.f;
import x0.h;

public class p
  implements p0
{
  private static final Rect k = new Rect(0, 0, 0, 0);
  private final int a;
  private final Object b = new Object();
  private int c;
  private int d = 0;
  private boolean e = false;
  private int f = 0;
  private ImageWriter g;
  private Rect h = k;
  c.a<Void> i;
  private u7.a<Void> j;
  
  public p(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.a = paramInt2;
  }
  
  private static g f(e1 parame1, int paramInt)
  {
    g.b localb = g.a();
    parame1.q().b(localb);
    localb.m(paramInt);
    return localb.j(parame1.getWidth()).i(parame1.getHeight()).a();
  }
  
  public void a(Size paramSize)
  {
    synchronized (this.b)
    {
      this.h = new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
      return;
    }
  }
  
  /* Error */
  public void b(s.k1 paramk1)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 114 1 0
    //   6: astore 10
    //   8: aload 10
    //   10: invokeinterface 119 1 0
    //   15: istore_2
    //   16: iconst_0
    //   17: istore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: iconst_0
    //   23: istore 6
    //   25: iconst_0
    //   26: istore 7
    //   28: iload_2
    //   29: iconst_1
    //   30: if_icmpne +9 -> 39
    //   33: iconst_1
    //   34: istore 9
    //   36: goto +6 -> 42
    //   39: iconst_0
    //   40: istore 9
    //   42: new 121	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   49: astore 11
    //   51: aload 11
    //   53: ldc 124
    //   55: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 11
    //   61: aload 10
    //   63: invokeinterface 119 1 0
    //   68: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: iload 9
    //   74: aload 11
    //   76: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 140	x0/h:b	(ZLjava/lang/Object;)V
    //   82: aload_1
    //   83: aload 10
    //   85: iconst_0
    //   86: invokeinterface 144 2 0
    //   91: checkcast 146	java/lang/Integer
    //   94: invokevirtual 149	java/lang/Integer:intValue	()I
    //   97: invokeinterface 152 2 0
    //   102: astore_1
    //   103: aload_1
    //   104: invokeinterface 158 1 0
    //   109: invokestatic 161	x0/h:a	(Z)V
    //   112: aload_0
    //   113: getfield 44	v/p:b	Ljava/lang/Object;
    //   116: astore 11
    //   118: aload 11
    //   120: monitorenter
    //   121: aload_0
    //   122: getfield 163	v/p:g	Landroid/media/ImageWriter;
    //   125: astore 15
    //   127: aload_0
    //   128: getfield 48	v/p:e	Z
    //   131: ifne +840 -> 971
    //   134: iconst_1
    //   135: istore_2
    //   136: goto +3 -> 139
    //   139: aload_0
    //   140: getfield 52	v/p:h	Landroid/graphics/Rect;
    //   143: astore 10
    //   145: iload_2
    //   146: ifeq +13 -> 159
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 50	v/p:f	I
    //   154: iconst_1
    //   155: iadd
    //   156: putfield 50	v/p:f	I
    //   159: aload_0
    //   160: getfield 54	v/p:c	I
    //   163: istore_3
    //   164: aload_0
    //   165: getfield 46	v/p:d	I
    //   168: istore 8
    //   170: aload 11
    //   172: monitorexit
    //   173: aload_1
    //   174: invokeinterface 166 1 0
    //   179: checkcast 68	androidx/camera/core/e1
    //   182: astore 13
    //   184: iload_2
    //   185: ifne +107 -> 292
    //   188: ldc 168
    //   190: ldc 170
    //   192: invokestatic 175	androidx/camera/core/n1:k	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 13
    //   197: invokeinterface 178 1 0
    //   202: aload_0
    //   203: getfield 44	v/p:b	Ljava/lang/Object;
    //   206: astore_1
    //   207: aload_1
    //   208: monitorenter
    //   209: iload 7
    //   211: istore_3
    //   212: iload_2
    //   213: ifeq +37 -> 250
    //   216: aload_0
    //   217: getfield 50	v/p:f	I
    //   220: istore_2
    //   221: aload_0
    //   222: iload_2
    //   223: iconst_1
    //   224: isub
    //   225: putfield 50	v/p:f	I
    //   228: iload 7
    //   230: istore_3
    //   231: iload_2
    //   232: ifne +18 -> 250
    //   235: iload 7
    //   237: istore_3
    //   238: aload_0
    //   239: getfield 48	v/p:e	Z
    //   242: ifeq +8 -> 250
    //   245: iconst_1
    //   246: istore_3
    //   247: goto +3 -> 250
    //   250: aload_0
    //   251: getfield 99	v/p:i	Landroidx/concurrent/futures/c$a;
    //   254: astore 10
    //   256: aload_1
    //   257: monitorexit
    //   258: iload_3
    //   259: ifeq +27 -> 286
    //   262: aload 15
    //   264: invokevirtual 181	android/media/ImageWriter:close	()V
    //   267: ldc 168
    //   269: ldc 183
    //   271: invokestatic 185	androidx/camera/core/n1:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload 10
    //   276: ifnull +10 -> 286
    //   279: aload 10
    //   281: aconst_null
    //   282: invokevirtual 190	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: return
    //   287: aload_1
    //   288: monitorexit
    //   289: aload 10
    //   291: athrow
    //   292: aload 15
    //   294: invokevirtual 194	android/media/ImageWriter:dequeueInputImage	()Landroid/media/Image;
    //   297: astore 11
    //   299: aload 13
    //   301: astore 14
    //   303: aload 11
    //   305: astore 12
    //   307: aload_1
    //   308: invokeinterface 166 1 0
    //   313: checkcast 68	androidx/camera/core/e1
    //   316: astore_1
    //   317: aload_1
    //   318: invokeinterface 197 1 0
    //   323: bipush 35
    //   325: if_icmpne +656 -> 981
    //   328: iconst_1
    //   329: istore 9
    //   331: goto +3 -> 334
    //   334: iload 9
    //   336: ldc 199
    //   338: invokestatic 202	x0/h:j	(ZLjava/lang/String;)V
    //   341: new 204	android/graphics/YuvImage
    //   344: dup
    //   345: aload_1
    //   346: invokestatic 209	z/b:q	(Landroidx/camera/core/e1;)[B
    //   349: bipush 17
    //   351: aload_1
    //   352: invokeinterface 87 1 0
    //   357: aload_1
    //   358: invokeinterface 92 1 0
    //   363: aconst_null
    //   364: invokespecial 212	android/graphics/YuvImage:<init>	([BIII[I)V
    //   367: astore 12
    //   369: aload 11
    //   371: invokevirtual 218	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   374: iconst_0
    //   375: aaload
    //   376: invokevirtual 224	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   379: astore 13
    //   381: aload 13
    //   383: invokevirtual 229	java/nio/ByteBuffer:position	()I
    //   386: istore 7
    //   388: aload 12
    //   390: aload 10
    //   392: iload_3
    //   393: new 231	androidx/camera/core/impl/utils/h
    //   396: dup
    //   397: new 8	v/p$a
    //   400: dup
    //   401: aload 13
    //   403: invokespecial 234	v/p$a:<init>	(Ljava/nio/ByteBuffer;)V
    //   406: aload_1
    //   407: iload 8
    //   409: invokestatic 236	v/p:f	(Landroidx/camera/core/e1;I)Landroidx/camera/core/impl/utils/g;
    //   412: invokespecial 239	androidx/camera/core/impl/utils/h:<init>	(Ljava/io/OutputStream;Landroidx/camera/core/impl/utils/g;)V
    //   415: invokevirtual 243	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   418: pop
    //   419: aload_1
    //   420: invokeinterface 178 1 0
    //   425: aload 13
    //   427: aload 13
    //   429: invokevirtual 229	java/nio/ByteBuffer:position	()I
    //   432: invokevirtual 247	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   435: pop
    //   436: aload 13
    //   438: iload 7
    //   440: invokevirtual 249	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   443: pop
    //   444: aload 15
    //   446: aload 11
    //   448: invokevirtual 253	android/media/ImageWriter:queueInputImage	(Landroid/media/Image;)V
    //   451: aload_0
    //   452: getfield 44	v/p:b	Ljava/lang/Object;
    //   455: astore 10
    //   457: aload 10
    //   459: monitorenter
    //   460: iload 4
    //   462: istore_3
    //   463: iload_2
    //   464: ifeq +37 -> 501
    //   467: aload_0
    //   468: getfield 50	v/p:f	I
    //   471: istore_2
    //   472: aload_0
    //   473: iload_2
    //   474: iconst_1
    //   475: isub
    //   476: putfield 50	v/p:f	I
    //   479: iload 4
    //   481: istore_3
    //   482: iload_2
    //   483: ifne +18 -> 501
    //   486: iload 4
    //   488: istore_3
    //   489: aload_0
    //   490: getfield 48	v/p:e	Z
    //   493: ifeq +8 -> 501
    //   496: iconst_1
    //   497: istore_3
    //   498: goto +3 -> 501
    //   501: aload_0
    //   502: getfield 99	v/p:i	Landroidx/concurrent/futures/c$a;
    //   505: astore_1
    //   506: aload 10
    //   508: monitorexit
    //   509: iload_3
    //   510: ifeq +449 -> 959
    //   513: aload 15
    //   515: invokevirtual 181	android/media/ImageWriter:close	()V
    //   518: ldc 168
    //   520: ldc 183
    //   522: invokestatic 185	androidx/camera/core/n1:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_1
    //   526: ifnull +433 -> 959
    //   529: aload_1
    //   530: aconst_null
    //   531: invokevirtual 190	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   534: pop
    //   535: return
    //   536: aload 10
    //   538: monitorexit
    //   539: aload_1
    //   540: athrow
    //   541: astore_1
    //   542: aconst_null
    //   543: astore 10
    //   545: aload 11
    //   547: astore 12
    //   549: goto +188 -> 737
    //   552: astore 10
    //   554: aconst_null
    //   555: astore_1
    //   556: goto +71 -> 627
    //   559: astore 12
    //   561: aload_1
    //   562: astore 10
    //   564: aload 12
    //   566: astore_1
    //   567: aload 11
    //   569: astore 12
    //   571: goto +166 -> 737
    //   574: astore 10
    //   576: goto +51 -> 627
    //   579: astore 10
    //   581: aload 13
    //   583: astore_1
    //   584: goto +43 -> 627
    //   587: astore_1
    //   588: aconst_null
    //   589: astore 12
    //   591: aload 13
    //   593: astore 10
    //   595: goto +142 -> 737
    //   598: astore 10
    //   600: aconst_null
    //   601: astore 11
    //   603: aload 13
    //   605: astore_1
    //   606: goto +21 -> 627
    //   609: astore_1
    //   610: aconst_null
    //   611: astore 10
    //   613: aload 10
    //   615: astore 12
    //   617: goto +120 -> 737
    //   620: astore 10
    //   622: aconst_null
    //   623: astore_1
    //   624: aload_1
    //   625: astore 11
    //   627: aload 11
    //   629: astore 12
    //   631: iload_2
    //   632: ifeq +221 -> 853
    //   635: aload_1
    //   636: astore 14
    //   638: aload 11
    //   640: astore 12
    //   642: ldc 168
    //   644: ldc 255
    //   646: aload 10
    //   648: invokestatic 258	androidx/camera/core/n1:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   651: aload_1
    //   652: astore 14
    //   654: aload 11
    //   656: astore 12
    //   658: aload 15
    //   660: invokevirtual 194	android/media/ImageWriter:dequeueInputImage	()Landroid/media/Image;
    //   663: astore 10
    //   665: aload_1
    //   666: astore 14
    //   668: aload 10
    //   670: astore 12
    //   672: aload 10
    //   674: invokevirtual 218	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   677: iconst_0
    //   678: aaload
    //   679: invokevirtual 224	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   682: astore 11
    //   684: aload_1
    //   685: astore 14
    //   687: aload 10
    //   689: astore 12
    //   691: aload 11
    //   693: invokevirtual 262	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   696: pop
    //   697: aload_1
    //   698: astore 14
    //   700: aload 10
    //   702: astore 12
    //   704: aload 11
    //   706: iconst_0
    //   707: invokevirtual 247	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   710: pop
    //   711: aload_1
    //   712: astore 14
    //   714: aload 10
    //   716: astore 12
    //   718: aload 15
    //   720: aload 10
    //   722: invokevirtual 253	android/media/ImageWriter:queueInputImage	(Landroid/media/Image;)V
    //   725: aload 10
    //   727: astore 12
    //   729: goto +124 -> 853
    //   732: astore_1
    //   733: aload 14
    //   735: astore 10
    //   737: aload_0
    //   738: getfield 44	v/p:b	Ljava/lang/Object;
    //   741: astore 11
    //   743: aload 11
    //   745: monitorenter
    //   746: iload 5
    //   748: istore_3
    //   749: iload_2
    //   750: ifeq +37 -> 787
    //   753: aload_0
    //   754: getfield 50	v/p:f	I
    //   757: istore_2
    //   758: aload_0
    //   759: iload_2
    //   760: iconst_1
    //   761: isub
    //   762: putfield 50	v/p:f	I
    //   765: iload 5
    //   767: istore_3
    //   768: iload_2
    //   769: ifne +18 -> 787
    //   772: iload 5
    //   774: istore_3
    //   775: aload_0
    //   776: getfield 48	v/p:e	Z
    //   779: ifeq +8 -> 787
    //   782: iconst_1
    //   783: istore_3
    //   784: goto +3 -> 787
    //   787: aload_0
    //   788: getfield 99	v/p:i	Landroidx/concurrent/futures/c$a;
    //   791: astore 13
    //   793: aload 11
    //   795: monitorexit
    //   796: aload 12
    //   798: ifnull +8 -> 806
    //   801: aload 12
    //   803: invokevirtual 263	android/media/Image:close	()V
    //   806: aload 10
    //   808: ifnull +10 -> 818
    //   811: aload 10
    //   813: invokeinterface 178 1 0
    //   818: iload_3
    //   819: ifeq +27 -> 846
    //   822: aload 15
    //   824: invokevirtual 181	android/media/ImageWriter:close	()V
    //   827: ldc 168
    //   829: ldc 183
    //   831: invokestatic 185	androidx/camera/core/n1:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload 13
    //   836: ifnull +10 -> 846
    //   839: aload 13
    //   841: aconst_null
    //   842: invokevirtual 190	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
    //   845: pop
    //   846: aload_1
    //   847: athrow
    //   848: aload 11
    //   850: monitorexit
    //   851: aload_1
    //   852: athrow
    //   853: aload_0
    //   854: getfield 44	v/p:b	Ljava/lang/Object;
    //   857: astore 11
    //   859: aload 11
    //   861: monitorenter
    //   862: iload 6
    //   864: istore_3
    //   865: iload_2
    //   866: ifeq +37 -> 903
    //   869: aload_0
    //   870: getfield 50	v/p:f	I
    //   873: istore_2
    //   874: aload_0
    //   875: iload_2
    //   876: iconst_1
    //   877: isub
    //   878: putfield 50	v/p:f	I
    //   881: iload 6
    //   883: istore_3
    //   884: iload_2
    //   885: ifne +18 -> 903
    //   888: iload 6
    //   890: istore_3
    //   891: aload_0
    //   892: getfield 48	v/p:e	Z
    //   895: ifeq +8 -> 903
    //   898: iconst_1
    //   899: istore_3
    //   900: goto +3 -> 903
    //   903: aload_0
    //   904: getfield 99	v/p:i	Landroidx/concurrent/futures/c$a;
    //   907: astore 10
    //   909: aload 11
    //   911: monitorexit
    //   912: aload 12
    //   914: ifnull +8 -> 922
    //   917: aload 12
    //   919: invokevirtual 263	android/media/Image:close	()V
    //   922: aload_1
    //   923: ifnull +9 -> 932
    //   926: aload_1
    //   927: invokeinterface 178 1 0
    //   932: iload_3
    //   933: ifeq +26 -> 959
    //   936: aload 15
    //   938: invokevirtual 181	android/media/ImageWriter:close	()V
    //   941: ldc 168
    //   943: ldc 183
    //   945: invokestatic 185	androidx/camera/core/n1:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   948: aload 10
    //   950: ifnull +9 -> 959
    //   953: aload 10
    //   955: astore_1
    //   956: goto -427 -> 529
    //   959: return
    //   960: aload 11
    //   962: monitorexit
    //   963: aload_1
    //   964: athrow
    //   965: astore_1
    //   966: aload 11
    //   968: monitorexit
    //   969: aload_1
    //   970: athrow
    //   971: iconst_0
    //   972: istore_2
    //   973: goto -834 -> 139
    //   976: astore 10
    //   978: goto -691 -> 287
    //   981: iconst_0
    //   982: istore 9
    //   984: goto -650 -> 334
    //   987: astore_1
    //   988: goto -452 -> 536
    //   991: astore_1
    //   992: goto -144 -> 848
    //   995: astore_1
    //   996: goto -36 -> 960
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	999	0	this	p
    //   0	999	1	paramk1	s.k1
    //   15	958	2	m	int
    //   163	770	3	n	int
    //   17	470	4	i1	int
    //   20	753	5	i2	int
    //   23	866	6	i3	int
    //   26	413	7	i4	int
    //   168	240	8	i5	int
    //   34	949	9	bool	boolean
    //   6	538	10	localObject1	Object
    //   552	1	10	localException1	java.lang.Exception
    //   562	1	10	localk1	s.k1
    //   574	1	10	localException2	java.lang.Exception
    //   579	1	10	localException3	java.lang.Exception
    //   593	1	10	localObject2	Object
    //   598	1	10	localException4	java.lang.Exception
    //   611	3	10	localObject3	Object
    //   620	27	10	localException5	java.lang.Exception
    //   663	291	10	localObject4	Object
    //   976	1	10	localObject5	Object
    //   49	918	11	localObject6	Object
    //   305	243	12	localObject7	Object
    //   559	6	12	localObject8	Object
    //   569	349	12	localObject9	Object
    //   182	658	13	localObject10	Object
    //   301	433	14	localObject11	Object
    //   125	812	15	localImageWriter	ImageWriter
    // Exception table:
    //   from	to	target	type
    //   425	451	541	finally
    //   425	451	552	java/lang/Exception
    //   317	328	559	finally
    //   334	425	559	finally
    //   317	328	574	java/lang/Exception
    //   334	425	574	java/lang/Exception
    //   307	317	579	java/lang/Exception
    //   188	202	587	finally
    //   292	299	587	finally
    //   188	202	598	java/lang/Exception
    //   292	299	598	java/lang/Exception
    //   173	184	609	finally
    //   173	184	620	java/lang/Exception
    //   307	317	732	finally
    //   642	651	732	finally
    //   658	665	732	finally
    //   672	684	732	finally
    //   691	697	732	finally
    //   704	711	732	finally
    //   718	725	732	finally
    //   121	134	965	finally
    //   139	145	965	finally
    //   149	159	965	finally
    //   159	173	965	finally
    //   966	969	965	finally
    //   216	228	976	finally
    //   238	245	976	finally
    //   250	258	976	finally
    //   287	289	976	finally
    //   467	479	987	finally
    //   489	496	987	finally
    //   501	509	987	finally
    //   536	539	987	finally
    //   753	765	991	finally
    //   775	782	991	finally
    //   787	796	991	finally
    //   848	851	991	finally
    //   869	881	995	finally
    //   891	898	995	finally
    //   903	912	995	finally
    //   960	963	995	finally
  }
  
  public void c(Surface paramSurface, int paramInt)
  {
    boolean bool;
    if (paramInt == 256) {
      bool = true;
    } else {
      bool = false;
    }
    h.j(bool, "YuvToJpegProcessor only supports JPEG output format.");
    synchronized (this.b)
    {
      if (!this.e)
      {
        if (this.g == null) {
          this.g = w.a.b(paramSurface, this.a, paramInt);
        } else {
          throw new IllegalStateException("Output surface already set.");
        }
      }
      else {
        n1.k("YuvToJpegProcessor", "Cannot set output surface. Processor is closed.");
      }
      return;
    }
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      if (this.e) {
        return;
      }
      this.e = true;
      c.a locala;
      if ((this.f == 0) && (this.g != null))
      {
        n1.a("YuvToJpegProcessor", "No processing in progress. Closing immediately.");
        this.g.close();
        locala = this.i;
      }
      else
      {
        n1.a("YuvToJpegProcessor", "close() called while processing. Will close after completion.");
        locala = null;
      }
      if (locala != null) {
        locala.c(null);
      }
      return;
    }
  }
  
  public u7.a<Void> d()
  {
    synchronized (this.b)
    {
      u7.a locala;
      if ((this.e) && (this.f == 0))
      {
        locala = f.h(null);
      }
      else
      {
        if (this.j == null) {
          this.j = c.a(new o(this));
        }
        locala = f.j(this.j);
      }
      return locala;
    }
  }
  
  public void h(int paramInt)
  {
    synchronized (this.b)
    {
      this.c = paramInt;
      return;
    }
  }
  
  public void i(int paramInt)
  {
    synchronized (this.b)
    {
      this.d = paramInt;
      return;
    }
  }
  
  private static final class a
    extends OutputStream
  {
    private final ByteBuffer a;
    
    a(ByteBuffer paramByteBuffer)
    {
      this.a = paramByteBuffer;
    }
    
    public void write(int paramInt)
    {
      if (this.a.hasRemaining())
      {
        this.a.put((byte)paramInt);
        return;
      }
      throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Objects.requireNonNull(paramArrayOfByte);
      if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramInt2 >= 0))
      {
        int i = paramInt1 + paramInt2;
        if ((i <= paramArrayOfByte.length) && (i >= 0))
        {
          if (paramInt2 == 0) {
            return;
          }
          if (this.a.remaining() >= paramInt2)
          {
            this.a.put(paramArrayOfByte, paramInt1, paramInt2);
            return;
          }
          throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
        }
      }
      throw new IndexOutOfBoundsException();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v.p
 * JD-Core Version:    0.7.0.1
 */