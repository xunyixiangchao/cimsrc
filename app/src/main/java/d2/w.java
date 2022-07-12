package d2;

import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import h2.n;
import h2.n.a;
import java.io.File;
import java.util.List;

class w
  implements f, d.a<Object>
{
  private final f.a a;
  private final g<?> b;
  private int c;
  private int d = -1;
  private b2.f e;
  private List<n<File, ?>> f;
  private int g;
  private volatile n.a<?> h;
  private File i;
  private x j;
  
  w(g<?> paramg, f.a parama)
  {
    this.b = paramg;
    this.a = parama;
  }
  
  private boolean a()
  {
    return this.g < this.f.size();
  }
  
  public void c(Exception paramException)
  {
    this.a.b(this.j, paramException, this.h.c, a.d);
  }
  
  public void cancel()
  {
    n.a locala = this.h;
    if (locala != null) {
      locala.c.cancel();
    }
  }
  
  public void d(Object paramObject)
  {
    this.a.c(this.e, paramObject, this.h.c, a.d, this.j);
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 93	y2/b:a	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 39	d2/w:b	Ld2/g;
    //   9: invokevirtual 98	d2/g:c	()Ljava/util/List;
    //   12: astore 5
    //   14: aload 5
    //   16: invokeinterface 101 1 0
    //   21: istore 4
    //   23: iconst_0
    //   24: istore_3
    //   25: iload 4
    //   27: ifeq +8 -> 35
    //   30: invokestatic 103	y2/b:e	()V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 39	d2/w:b	Ld2/g;
    //   39: invokevirtual 106	d2/g:m	()Ljava/util/List;
    //   42: astore 6
    //   44: aload 6
    //   46: invokeinterface 101 1 0
    //   51: ifeq +89 -> 140
    //   54: ldc 108
    //   56: aload_0
    //   57: getfield 39	d2/w:b	Ld2/g;
    //   60: invokevirtual 112	d2/g:r	()Ljava/lang/Class;
    //   63: invokevirtual 116	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq +8 -> 76
    //   71: invokestatic 103	y2/b:e	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: new 118	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   83: astore 5
    //   85: aload 5
    //   87: ldc 121
    //   89: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 39	d2/w:b	Ld2/g;
    //   99: invokevirtual 127	d2/g:i	()Ljava/lang/Class;
    //   102: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 5
    //   108: ldc 132
    //   110: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 5
    //   116: aload_0
    //   117: getfield 39	d2/w:b	Ld2/g;
    //   120: invokevirtual 112	d2/g:r	()Ljava/lang/Class;
    //   123: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: new 134	java/lang/IllegalStateException
    //   130: dup
    //   131: aload 5
    //   133: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 140	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   139: athrow
    //   140: aload_0
    //   141: getfield 49	d2/w:f	Ljava/util/List;
    //   144: ifnull +151 -> 295
    //   147: aload_0
    //   148: invokespecial 142	d2/w:a	()Z
    //   151: ifne +6 -> 157
    //   154: goto +141 -> 295
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 60	d2/w:h	Lh2/n$a;
    //   162: iload_3
    //   163: ifne +127 -> 290
    //   166: aload_0
    //   167: invokespecial 142	d2/w:a	()Z
    //   170: ifeq +120 -> 290
    //   173: aload_0
    //   174: getfield 49	d2/w:f	Ljava/util/List;
    //   177: astore 5
    //   179: aload_0
    //   180: getfield 47	d2/w:g	I
    //   183: istore_1
    //   184: aload_0
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: putfield 47	d2/w:g	I
    //   191: aload_0
    //   192: aload 5
    //   194: iload_1
    //   195: invokeinterface 146 2 0
    //   200: checkcast 148	h2/n
    //   203: aload_0
    //   204: getfield 150	d2/w:i	Ljava/io/File;
    //   207: aload_0
    //   208: getfield 39	d2/w:b	Ld2/g;
    //   211: invokevirtual 153	d2/g:t	()I
    //   214: aload_0
    //   215: getfield 39	d2/w:b	Ld2/g;
    //   218: invokevirtual 155	d2/g:f	()I
    //   221: aload_0
    //   222: getfield 39	d2/w:b	Ld2/g;
    //   225: invokevirtual 159	d2/g:k	()Lb2/h;
    //   228: invokeinterface 162 5 0
    //   233: putfield 60	d2/w:h	Lh2/n$a;
    //   236: aload_0
    //   237: getfield 60	d2/w:h	Lh2/n$a;
    //   240: ifnull -78 -> 162
    //   243: aload_0
    //   244: getfield 39	d2/w:b	Ld2/g;
    //   247: aload_0
    //   248: getfield 60	d2/w:h	Lh2/n$a;
    //   251: getfield 65	h2/n$a:c	Lcom/bumptech/glide/load/data/d;
    //   254: invokeinterface 164 1 0
    //   259: invokevirtual 168	d2/g:u	(Ljava/lang/Class;)Z
    //   262: ifeq -100 -> 162
    //   265: aload_0
    //   266: getfield 60	d2/w:h	Lh2/n$a;
    //   269: getfield 65	h2/n$a:c	Lcom/bumptech/glide/load/data/d;
    //   272: aload_0
    //   273: getfield 39	d2/w:b	Ld2/g;
    //   276: invokevirtual 172	d2/g:l	()Lcom/bumptech/glide/h;
    //   279: aload_0
    //   280: invokeinterface 175 3 0
    //   285: iconst_1
    //   286: istore_3
    //   287: goto -125 -> 162
    //   290: invokestatic 103	y2/b:e	()V
    //   293: iload_3
    //   294: ireturn
    //   295: aload_0
    //   296: getfield 37	d2/w:d	I
    //   299: iconst_1
    //   300: iadd
    //   301: istore_1
    //   302: aload_0
    //   303: iload_1
    //   304: putfield 37	d2/w:d	I
    //   307: iload_1
    //   308: aload 6
    //   310: invokeinterface 55 1 0
    //   315: if_icmplt +38 -> 353
    //   318: aload_0
    //   319: getfield 177	d2/w:c	I
    //   322: iconst_1
    //   323: iadd
    //   324: istore_1
    //   325: aload_0
    //   326: iload_1
    //   327: putfield 177	d2/w:c	I
    //   330: aload 5
    //   332: invokeinterface 55 1 0
    //   337: istore_2
    //   338: iload_1
    //   339: iload_2
    //   340: if_icmplt +8 -> 348
    //   343: invokestatic 103	y2/b:e	()V
    //   346: iconst_0
    //   347: ireturn
    //   348: aload_0
    //   349: iconst_0
    //   350: putfield 37	d2/w:d	I
    //   353: aload 5
    //   355: aload_0
    //   356: getfield 177	d2/w:c	I
    //   359: invokeinterface 146 2 0
    //   364: checkcast 179	b2/f
    //   367: astore 7
    //   369: aload 6
    //   371: aload_0
    //   372: getfield 37	d2/w:d	I
    //   375: invokeinterface 146 2 0
    //   380: checkcast 181	java/lang/Class
    //   383: astore 8
    //   385: aload_0
    //   386: getfield 39	d2/w:b	Ld2/g;
    //   389: aload 8
    //   391: invokevirtual 185	d2/g:s	(Ljava/lang/Class;)Lb2/l;
    //   394: astore 9
    //   396: aload_0
    //   397: new 187	d2/x
    //   400: dup
    //   401: aload_0
    //   402: getfield 39	d2/w:b	Ld2/g;
    //   405: invokevirtual 190	d2/g:b	()Le2/b;
    //   408: aload 7
    //   410: aload_0
    //   411: getfield 39	d2/w:b	Ld2/g;
    //   414: invokevirtual 194	d2/g:p	()Lb2/f;
    //   417: aload_0
    //   418: getfield 39	d2/w:b	Ld2/g;
    //   421: invokevirtual 153	d2/g:t	()I
    //   424: aload_0
    //   425: getfield 39	d2/w:b	Ld2/g;
    //   428: invokevirtual 155	d2/g:f	()I
    //   431: aload 9
    //   433: aload 8
    //   435: aload_0
    //   436: getfield 39	d2/w:b	Ld2/g;
    //   439: invokevirtual 159	d2/g:k	()Lb2/h;
    //   442: invokespecial 197	d2/x:<init>	(Le2/b;Lb2/f;Lb2/f;IILb2/l;Ljava/lang/Class;Lb2/h;)V
    //   445: putfield 58	d2/w:j	Ld2/x;
    //   448: aload_0
    //   449: getfield 39	d2/w:b	Ld2/g;
    //   452: invokevirtual 200	d2/g:d	()Lf2/a;
    //   455: aload_0
    //   456: getfield 58	d2/w:j	Ld2/x;
    //   459: invokeinterface 205 2 0
    //   464: astore 8
    //   466: aload_0
    //   467: aload 8
    //   469: putfield 150	d2/w:i	Ljava/io/File;
    //   472: aload 8
    //   474: ifnull -334 -> 140
    //   477: aload_0
    //   478: aload 7
    //   480: putfield 83	d2/w:e	Lb2/f;
    //   483: aload_0
    //   484: aload_0
    //   485: getfield 39	d2/w:b	Ld2/g;
    //   488: aload 8
    //   490: invokevirtual 208	d2/g:j	(Ljava/io/File;)Ljava/util/List;
    //   493: putfield 49	d2/w:f	Ljava/util/List;
    //   496: aload_0
    //   497: iconst_0
    //   498: putfield 47	d2/w:g	I
    //   501: goto -361 -> 140
    //   504: astore 5
    //   506: invokestatic 103	y2/b:e	()V
    //   509: aload 5
    //   511: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	w
    //   183	158	1	k	int
    //   337	4	2	m	int
    //   24	270	3	bool1	boolean
    //   21	5	4	bool2	boolean
    //   12	342	5	localObject1	Object
    //   504	6	5	localObject2	Object
    //   42	328	6	localList	List
    //   367	112	7	localf	b2.f
    //   383	106	8	localObject3	Object
    //   394	38	9	locall	b2.l
    // Exception table:
    //   from	to	target	type
    //   5	23	504	finally
    //   35	67	504	finally
    //   76	140	504	finally
    //   140	154	504	finally
    //   157	162	504	finally
    //   166	285	504	finally
    //   295	338	504	finally
    //   348	353	504	finally
    //   353	472	504	finally
    //   477	501	504	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.w
 * JD-Core Version:    0.7.0.1
 */