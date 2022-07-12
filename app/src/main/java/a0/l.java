package a0;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.camera.core.n1;
import androidx.camera.core.r;
import androidx.camera.core.v2.b;
import androidx.camera.core.z0.i;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import m.b.b;
import m.c;
import m.d;
import r.h;
import s.e1;
import s.m0;
import s.n0;
import s.q0;
import s.s0.a;
import s.t1;

public class l
{
  static final s0.a<Integer> d = s0.a.a("camerax.extensions.imageCaptureConfigProvider.mode", Integer.class);
  private final n a;
  private final Context b;
  private final int c;
  
  public l(int paramInt, n paramn, Context paramContext)
  {
    this.c = paramInt;
    this.a = paramn;
    this.b = paramContext;
  }
  
  public e1 a()
  {
    z0.i locali = new z0.i();
    b(locali, this.c, this.a, this.b);
    return locali.e();
  }
  
  void b(z0.i parami, int paramInt, n paramn, Context paramContext)
  {
    if ((paramn instanceof g))
    {
      ImageCaptureExtenderImpl localImageCaptureExtenderImpl = ((g)paramn).g();
      if (localImageCaptureExtenderImpl != null)
      {
        CaptureProcessorImpl localCaptureProcessorImpl = localImageCaptureExtenderImpl.getCaptureProcessor();
        if (localCaptureProcessorImpl != null) {
          parami.h(new a(localCaptureProcessorImpl));
        }
        if (localImageCaptureExtenderImpl.getMaxCaptureStage() > 0) {
          parami.i(localImageCaptureExtenderImpl.getMaxCaptureStage());
        }
        paramContext = new a(localImageCaptureExtenderImpl, paramContext);
        new b.b(parami).a(new d(new c[] { paramContext }));
        parami.p(paramContext);
        parami.f(paramContext);
      }
      else
      {
        n1.c("ImageCaptureConfigProvider", "ImageCaptureExtenderImpl is null!");
      }
    }
    parami.a().G(d, Integer.valueOf(paramInt));
    parami.j(paramn.b());
  }
  
  private static class a
    extends c
    implements v2.b, m0
  {
    private final ImageCaptureExtenderImpl a;
    private final Context b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private final Object d = new Object();
    private volatile int e = 0;
    private volatile boolean f = false;
    
    a(ImageCaptureExtenderImpl paramImageCaptureExtenderImpl, Context paramContext)
    {
      this.a = paramImageCaptureExtenderImpl;
      this.b = paramContext;
    }
    
    private void h()
    {
      if (this.c.get())
      {
        this.a.onDeInit();
        this.c.set(false);
      }
    }
    
    public void a()
    {
      synchronized (this.d)
      {
        this.f = true;
        if (this.e == 0) {
          h();
        }
        return;
      }
    }
    
    public void b(r paramr)
    {
      if (this.c.get())
      {
        String str = h.b(paramr).e();
        paramr = h.a(paramr);
        this.a.onInit(str, paramr, this.b);
      }
    }
    
    public List<q0> c()
    {
      if (this.c.get())
      {
        Object localObject = this.a.getCaptureStages();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(new b((CaptureStageImpl)((Iterator)localObject).next()));
          }
          return localArrayList;
        }
      }
      return null;
    }
    
    /* Error */
    public n0 d()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	a0/l$a:c	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   4: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   7: ifeq +73 -> 80
      //   10: aload_0
      //   11: getfield 45	a0/l$a:a	Landroidx/camera/extensions/impl/ImageCaptureExtenderImpl;
      //   14: invokeinterface 122 1 0
      //   19: astore_1
      //   20: aload_1
      //   21: ifnull +59 -> 80
      //   24: new 102	a0/b
      //   27: dup
      //   28: aload_1
      //   29: invokespecial 111	a0/b:<init>	(Landroidx/camera/extensions/impl/CaptureStageImpl;)V
      //   32: invokevirtual 124	a0/b:a	()Ls/n0;
      //   35: astore_2
      //   36: aload_0
      //   37: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   40: astore_1
      //   41: aload_1
      //   42: monitorenter
      //   43: aload_0
      //   44: aload_0
      //   45: getfield 41	a0/l$a:e	I
      //   48: iconst_1
      //   49: isub
      //   50: putfield 41	a0/l$a:e	I
      //   53: aload_0
      //   54: getfield 41	a0/l$a:e	I
      //   57: ifne +14 -> 71
      //   60: aload_0
      //   61: getfield 43	a0/l$a:f	Z
      //   64: ifeq +7 -> 71
      //   67: aload_0
      //   68: invokespecial 63	a0/l$a:h	()V
      //   71: aload_1
      //   72: monitorexit
      //   73: aload_2
      //   74: areturn
      //   75: astore_2
      //   76: aload_1
      //   77: monitorexit
      //   78: aload_2
      //   79: athrow
      //   80: aload_0
      //   81: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   84: astore_1
      //   85: aload_1
      //   86: monitorenter
      //   87: aload_0
      //   88: aload_0
      //   89: getfield 41	a0/l$a:e	I
      //   92: iconst_1
      //   93: isub
      //   94: putfield 41	a0/l$a:e	I
      //   97: aload_0
      //   98: getfield 41	a0/l$a:e	I
      //   101: ifne +14 -> 115
      //   104: aload_0
      //   105: getfield 43	a0/l$a:f	Z
      //   108: ifeq +7 -> 115
      //   111: aload_0
      //   112: invokespecial 63	a0/l$a:h	()V
      //   115: aload_1
      //   116: monitorexit
      //   117: aconst_null
      //   118: areturn
      //   119: astore_2
      //   120: aload_1
      //   121: monitorexit
      //   122: aload_2
      //   123: athrow
      //   124: astore_2
      //   125: aload_0
      //   126: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   129: astore_1
      //   130: aload_1
      //   131: monitorenter
      //   132: aload_0
      //   133: aload_0
      //   134: getfield 41	a0/l$a:e	I
      //   137: iconst_1
      //   138: isub
      //   139: putfield 41	a0/l$a:e	I
      //   142: aload_0
      //   143: getfield 41	a0/l$a:e	I
      //   146: ifne +14 -> 160
      //   149: aload_0
      //   150: getfield 43	a0/l$a:f	Z
      //   153: ifeq +7 -> 160
      //   156: aload_0
      //   157: invokespecial 63	a0/l$a:h	()V
      //   160: aload_1
      //   161: monitorexit
      //   162: aload_2
      //   163: athrow
      //   164: astore_2
      //   165: aload_1
      //   166: monitorexit
      //   167: aload_2
      //   168: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	169	0	this	a
      //   35	39	2	localn0	n0
      //   75	4	2	localObject2	Object
      //   119	4	2	localObject3	Object
      //   124	39	2	localObject4	Object
      //   164	4	2	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   43	71	75	finally
      //   71	73	75	finally
      //   76	78	75	finally
      //   87	115	119	finally
      //   115	117	119	finally
      //   120	122	119	finally
      //   0	20	124	finally
      //   24	36	124	finally
      //   132	160	164	finally
      //   160	162	164	finally
      //   165	167	164	finally
    }
    
    /* Error */
    public n0 e()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	a0/l$a:c	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   4: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   7: ifeq +55 -> 62
      //   10: aload_0
      //   11: getfield 45	a0/l$a:a	Landroidx/camera/extensions/impl/ImageCaptureExtenderImpl;
      //   14: invokeinterface 127 1 0
      //   19: astore_1
      //   20: aload_1
      //   21: ifnull +41 -> 62
      //   24: new 102	a0/b
      //   27: dup
      //   28: aload_1
      //   29: invokespecial 111	a0/b:<init>	(Landroidx/camera/extensions/impl/CaptureStageImpl;)V
      //   32: invokevirtual 124	a0/b:a	()Ls/n0;
      //   35: astore_2
      //   36: aload_0
      //   37: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   40: astore_1
      //   41: aload_1
      //   42: monitorenter
      //   43: aload_0
      //   44: aload_0
      //   45: getfield 41	a0/l$a:e	I
      //   48: iconst_1
      //   49: iadd
      //   50: putfield 41	a0/l$a:e	I
      //   53: aload_1
      //   54: monitorexit
      //   55: aload_2
      //   56: areturn
      //   57: astore_2
      //   58: aload_1
      //   59: monitorexit
      //   60: aload_2
      //   61: athrow
      //   62: aload_0
      //   63: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   66: astore_1
      //   67: aload_1
      //   68: monitorenter
      //   69: aload_0
      //   70: aload_0
      //   71: getfield 41	a0/l$a:e	I
      //   74: iconst_1
      //   75: iadd
      //   76: putfield 41	a0/l$a:e	I
      //   79: aload_1
      //   80: monitorexit
      //   81: aconst_null
      //   82: areturn
      //   83: astore_2
      //   84: aload_1
      //   85: monitorexit
      //   86: aload_2
      //   87: athrow
      //   88: astore_2
      //   89: aload_0
      //   90: getfield 39	a0/l$a:d	Ljava/lang/Object;
      //   93: astore_1
      //   94: aload_1
      //   95: monitorenter
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 41	a0/l$a:e	I
      //   101: iconst_1
      //   102: iadd
      //   103: putfield 41	a0/l$a:e	I
      //   106: aload_1
      //   107: monitorexit
      //   108: aload_2
      //   109: athrow
      //   110: astore_2
      //   111: aload_1
      //   112: monitorexit
      //   113: aload_2
      //   114: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	115	0	this	a
      //   19	93	1	localObject1	Object
      //   35	21	2	localn0	n0
      //   57	4	2	localObject2	Object
      //   83	4	2	localObject3	Object
      //   88	21	2	localObject4	Object
      //   110	4	2	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   43	55	57	finally
      //   58	60	57	finally
      //   69	81	83	finally
      //   84	86	83	finally
      //   0	20	88	finally
      //   24	36	88	finally
      //   96	108	110	finally
      //   111	113	110	finally
    }
    
    public n0 f()
    {
      if (this.c.get())
      {
        CaptureStageImpl localCaptureStageImpl = this.a.onPresetSession();
        if (localCaptureStageImpl != null)
        {
          if (Build.VERSION.SDK_INT >= 28) {
            return new b(localCaptureStageImpl).a();
          }
          n1.k("ImageCaptureConfigProvider", "The CaptureRequest parameters returned from onPresetSession() will be passed to the camera device as part of the capture session via SessionConfiguration#setSessionParameters(CaptureRequest) which only supported from API level 28!");
        }
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.l
 * JD-Core Version:    0.7.0.1
 */