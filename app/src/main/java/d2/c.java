package d2;

import b2.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import h2.n;
import h2.n.a;
import java.io.File;
import java.util.List;

class c
  implements f, d.a<Object>
{
  private final List<b2.f> a;
  private final g<?> b;
  private final f.a c;
  private int d = -1;
  private b2.f e;
  private List<n<File, ?>> f;
  private int g;
  private volatile n.a<?> h;
  private File i;
  
  c(g<?> paramg, f.a parama)
  {
    this(paramg.c(), paramg, parama);
  }
  
  c(List<b2.f> paramList, g<?> paramg, f.a parama)
  {
    this.a = paramList;
    this.b = paramg;
    this.c = parama;
  }
  
  private boolean a()
  {
    return this.g < this.f.size();
  }
  
  public void c(Exception paramException)
  {
    this.c.b(this.e, paramException, this.h.c, a.c);
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
    this.c.c(this.e, paramObject, this.h.c, a.c, this.e);
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 101	y2/b:a	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 59	d2/c:f	Ljava/util/List;
    //   9: astore 4
    //   11: iconst_0
    //   12: istore_3
    //   13: aload 4
    //   15: ifnull +151 -> 166
    //   18: aload_0
    //   19: invokespecial 103	d2/c:a	()Z
    //   22: ifne +6 -> 28
    //   25: goto +141 -> 166
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 70	d2/c:h	Lh2/n$a;
    //   33: iload_3
    //   34: ifne +127 -> 161
    //   37: aload_0
    //   38: invokespecial 103	d2/c:a	()Z
    //   41: ifeq +120 -> 161
    //   44: aload_0
    //   45: getfield 59	d2/c:f	Ljava/util/List;
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 57	d2/c:g	I
    //   54: istore_1
    //   55: aload_0
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: putfield 57	d2/c:g	I
    //   62: aload_0
    //   63: aload 4
    //   65: iload_1
    //   66: invokeinterface 107 2 0
    //   71: checkcast 109	h2/n
    //   74: aload_0
    //   75: getfield 111	d2/c:i	Ljava/io/File;
    //   78: aload_0
    //   79: getfield 51	d2/c:b	Ld2/g;
    //   82: invokevirtual 114	d2/g:t	()I
    //   85: aload_0
    //   86: getfield 51	d2/c:b	Ld2/g;
    //   89: invokevirtual 116	d2/g:f	()I
    //   92: aload_0
    //   93: getfield 51	d2/c:b	Ld2/g;
    //   96: invokevirtual 120	d2/g:k	()Lb2/h;
    //   99: invokeinterface 123 5 0
    //   104: putfield 70	d2/c:h	Lh2/n$a;
    //   107: aload_0
    //   108: getfield 70	d2/c:h	Lh2/n$a;
    //   111: ifnull -78 -> 33
    //   114: aload_0
    //   115: getfield 51	d2/c:b	Ld2/g;
    //   118: aload_0
    //   119: getfield 70	d2/c:h	Lh2/n$a;
    //   122: getfield 75	h2/n$a:c	Lcom/bumptech/glide/load/data/d;
    //   125: invokeinterface 126 1 0
    //   130: invokevirtual 130	d2/g:u	(Ljava/lang/Class;)Z
    //   133: ifeq -100 -> 33
    //   136: aload_0
    //   137: getfield 70	d2/c:h	Lh2/n$a;
    //   140: getfield 75	h2/n$a:c	Lcom/bumptech/glide/load/data/d;
    //   143: aload_0
    //   144: getfield 51	d2/c:b	Ld2/g;
    //   147: invokevirtual 134	d2/g:l	()Lcom/bumptech/glide/h;
    //   150: aload_0
    //   151: invokeinterface 137 3 0
    //   156: iconst_1
    //   157: istore_3
    //   158: goto -125 -> 33
    //   161: invokestatic 139	y2/b:e	()V
    //   164: iload_3
    //   165: ireturn
    //   166: aload_0
    //   167: getfield 47	d2/c:d	I
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: aload_0
    //   174: iload_1
    //   175: putfield 47	d2/c:d	I
    //   178: aload_0
    //   179: getfield 49	d2/c:a	Ljava/util/List;
    //   182: invokeinterface 65 1 0
    //   187: istore_2
    //   188: iload_1
    //   189: iload_2
    //   190: if_icmplt +8 -> 198
    //   193: invokestatic 139	y2/b:e	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_0
    //   199: getfield 49	d2/c:a	Ljava/util/List;
    //   202: aload_0
    //   203: getfield 47	d2/c:d	I
    //   206: invokeinterface 107 2 0
    //   211: checkcast 141	b2/f
    //   214: astore 4
    //   216: new 143	d2/d
    //   219: dup
    //   220: aload 4
    //   222: aload_0
    //   223: getfield 51	d2/c:b	Ld2/g;
    //   226: invokevirtual 147	d2/g:p	()Lb2/f;
    //   229: invokespecial 150	d2/d:<init>	(Lb2/f;Lb2/f;)V
    //   232: astore 5
    //   234: aload_0
    //   235: getfield 51	d2/c:b	Ld2/g;
    //   238: invokevirtual 153	d2/g:d	()Lf2/a;
    //   241: aload 5
    //   243: invokeinterface 158 2 0
    //   248: astore 5
    //   250: aload_0
    //   251: aload 5
    //   253: putfield 111	d2/c:i	Ljava/io/File;
    //   256: aload 5
    //   258: ifnull -253 -> 5
    //   261: aload_0
    //   262: aload 4
    //   264: putfield 68	d2/c:e	Lb2/f;
    //   267: aload_0
    //   268: aload_0
    //   269: getfield 51	d2/c:b	Ld2/g;
    //   272: aload 5
    //   274: invokevirtual 162	d2/g:j	(Ljava/io/File;)Ljava/util/List;
    //   277: putfield 59	d2/c:f	Ljava/util/List;
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 57	d2/c:g	I
    //   285: goto -280 -> 5
    //   288: astore 4
    //   290: invokestatic 139	y2/b:e	()V
    //   293: aload 4
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	c
    //   54	137	1	j	int
    //   187	4	2	k	int
    //   12	153	3	bool	boolean
    //   9	254	4	localObject1	Object
    //   288	6	4	localObject2	Object
    //   232	41	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	288	finally
    //   18	25	288	finally
    //   28	33	288	finally
    //   37	156	288	finally
    //   166	188	288	finally
    //   198	256	288	finally
    //   261	285	288	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.c
 * JD-Core Version:    0.7.0.1
 */