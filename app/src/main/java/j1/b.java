package j1;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class b
  extends a<Cursor>
{
  final c<Cursor>.a p = new c.a(this);
  Uri q;
  String[] r;
  String s;
  String[] t;
  String u;
  Cursor v;
  u0.b w;
  
  public b(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    super(paramContext);
    this.q = paramUri;
    this.r = paramArrayOfString1;
    this.s = paramString1;
    this.t = paramArrayOfString2;
    this.u = paramString2;
  }
  
  public void A()
  {
    super.A();
    try
    {
      u0.b localb = this.w;
      if (localb != null) {
        localb.a();
      }
      return;
    }
    finally {}
  }
  
  public void I(Cursor paramCursor)
  {
    if (k())
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    Cursor localCursor = this.v;
    this.v = paramCursor;
    if (l()) {
      super.f(paramCursor);
    }
    if ((localCursor != null) && (localCursor != paramCursor) && (!localCursor.isClosed())) {
      localCursor.close();
    }
  }
  
  /* Error */
  public Cursor J()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 90	j1/a:E	()Z
    //   6: ifne +117 -> 123
    //   9: aload_0
    //   10: new 51	u0/b
    //   13: dup
    //   14: invokespecial 92	u0/b:<init>	()V
    //   17: putfield 49	j1/b:w	Lu0/b;
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: invokevirtual 96	j1/c:i	()Landroid/content/Context;
    //   26: invokevirtual 102	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_0
    //   30: getfield 34	j1/b:q	Landroid/net/Uri;
    //   33: aload_0
    //   34: getfield 36	j1/b:r	[Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 38	j1/b:s	Ljava/lang/String;
    //   41: aload_0
    //   42: getfield 40	j1/b:t	[Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 42	j1/b:u	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 49	j1/b:w	Lu0/b;
    //   53: invokestatic 107	androidx/core/content/a:a	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lu0/b;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +32 -> 90
    //   61: aload_1
    //   62: invokeinterface 111 1 0
    //   67: pop
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 32	j1/b:p	Lj1/c$a;
    //   73: invokeinterface 115 2 0
    //   78: goto +12 -> 90
    //   81: astore_2
    //   82: aload_1
    //   83: invokeinterface 72 1 0
    //   88: aload_2
    //   89: athrow
    //   90: aload_0
    //   91: monitorenter
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 49	j1/b:w	Lu0/b;
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 49	j1/b:w	Lu0/b;
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: new 117	u0/e
    //   126: dup
    //   127: invokespecial 118	u0/e:<init>	()V
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	b
    //   56	44	1	localCursor	Cursor
    //   101	4	1	localObject1	Object
    //   106	11	1	localObject2	Object
    //   118	4	1	localObject3	Object
    //   131	4	1	localObject4	Object
    //   81	8	2	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   61	78	81	java/lang/RuntimeException
    //   92	99	101	finally
    //   102	104	101	finally
    //   22	57	106	finally
    //   61	78	106	finally
    //   82	90	106	finally
    //   109	116	118	finally
    //   119	121	118	finally
    //   2	22	131	finally
    //   123	131	131	finally
    //   132	134	131	finally
  }
  
  public void K(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed())) {
      paramCursor.close();
    }
  }
  
  @Deprecated
  public void g(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.g(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.q);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(this.r));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(this.s);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(this.t));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(this.u);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.v);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.h);
  }
  
  protected void q()
  {
    super.q();
    s();
    Cursor localCursor = this.v;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      this.v.close();
    }
    this.v = null;
  }
  
  protected void r()
  {
    Cursor localCursor = this.v;
    if (localCursor != null) {
      I(localCursor);
    }
    if ((y()) || (this.v == null)) {
      h();
    }
  }
  
  protected void s()
  {
    b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j1.b
 * JD-Core Version:    0.7.0.1
 */