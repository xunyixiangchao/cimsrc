package a0;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.camera.core.n1;
import androidx.camera.core.r;
import androidx.camera.core.v2.b;
import androidx.camera.core.w1.b;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import androidx.camera.extensions.impl.PreviewImageProcessorImpl;
import m.b.b;
import r.h;
import s.a2;
import s.f1;
import s.n0;
import s.p0;
import s.s0.a;
import s.t1;

public class m
{
  static final s0.a<Integer> d = s0.a.a("camerax.extensions.previewConfigProvider.mode", Integer.class);
  private final n a;
  private final Context b;
  private final int c;
  
  public m(int paramInt, n paramn, Context paramContext)
  {
    this.c = paramInt;
    this.a = paramn;
    this.b = paramContext;
  }
  
  public a2 a()
  {
    w1.b localb = new w1.b();
    b(localb, this.c, this.a, this.b);
    return localb.e();
  }
  
  void b(w1.b paramb, int paramInt, n paramn, Context paramContext)
  {
    if ((paramn instanceof g))
    {
      PreviewExtenderImpl localPreviewExtenderImpl = ((g)paramn).i();
      if (localPreviewExtenderImpl != null)
      {
        int i = a.a[localPreviewExtenderImpl.getProcessorType().ordinal()];
        Object localObject;
        if (i != 1)
        {
          if (i != 2)
          {
            paramContext = new b(localPreviewExtenderImpl, paramContext, null);
          }
          else
          {
            localObject = new c((PreviewImageProcessorImpl)localPreviewExtenderImpl.getProcessor());
            paramb.f((p0)localObject);
            paramb.h(true);
            paramContext = new b(localPreviewExtenderImpl, paramContext, (i)localObject);
          }
        }
        else
        {
          localObject = new d(localPreviewExtenderImpl);
          paramb.g((f1)localObject);
          paramContext = new b(localPreviewExtenderImpl, paramContext, (i)localObject);
        }
        new b.b(paramb).a(new m.d(new m.c[] { paramContext }));
        paramb.o(paramContext);
      }
      else
      {
        n1.c("PreviewConfigProvider", "PreviewExtenderImpl is null!");
      }
    }
    else
    {
      paramb.h(true);
    }
    paramb.a().G(d, Integer.valueOf(paramInt));
    paramb.i(paramn.d());
  }
  
  private static class b
    extends m.c
    implements v2.b
  {
    final PreviewExtenderImpl a;
    private final Context b;
    final i c;
    volatile boolean d = true;
    final Object e = new Object();
    private volatile int f = 0;
    private volatile boolean g = false;
    
    b(PreviewExtenderImpl paramPreviewExtenderImpl, Context paramContext, i parami)
    {
      this.a = paramPreviewExtenderImpl;
      this.b = paramContext;
      this.c = parami;
    }
    
    private void h()
    {
      synchronized (this.e)
      {
        if (this.d)
        {
          i locali = this.c;
          if (locali != null) {
            locali.close();
          }
          this.a.onDeInit();
          this.d = false;
        }
        return;
      }
    }
    
    public void a()
    {
      synchronized (this.e)
      {
        this.g = true;
        if (this.f == 0) {
          h();
        }
        return;
      }
    }
    
    public void b(r paramr)
    {
      synchronized (this.e)
      {
        if (this.d)
        {
          String str = h.b(paramr).e();
          paramr = h.a(paramr);
          this.a.onInit(str, paramr, this.b);
        }
        return;
      }
    }
    
    /* Error */
    public n0 d()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 28	a0/m$b:d	Z
      //   11: ifeq +75 -> 86
      //   14: aload_0
      //   15: getfield 39	a0/m$b:a	Landroidx/camera/extensions/impl/PreviewExtenderImpl;
      //   18: invokeinterface 78 1 0
      //   23: astore_2
      //   24: aload_2
      //   25: ifnull +61 -> 86
      //   28: new 80	a0/b
      //   31: dup
      //   32: aload_2
      //   33: invokespecial 83	a0/b:<init>	(Landroidx/camera/extensions/impl/CaptureStageImpl;)V
      //   36: invokevirtual 85	a0/b:a	()Ls/n0;
      //   39: astore_2
      //   40: aload_1
      //   41: monitorexit
      //   42: aload_0
      //   43: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   46: astore_1
      //   47: aload_1
      //   48: monitorenter
      //   49: aload_0
      //   50: aload_0
      //   51: getfield 35	a0/m$b:f	I
      //   54: iconst_1
      //   55: isub
      //   56: putfield 35	a0/m$b:f	I
      //   59: aload_0
      //   60: getfield 35	a0/m$b:f	I
      //   63: ifne +14 -> 77
      //   66: aload_0
      //   67: getfield 37	a0/m$b:g	Z
      //   70: ifeq +7 -> 77
      //   73: aload_0
      //   74: invokespecial 57	a0/m$b:h	()V
      //   77: aload_1
      //   78: monitorexit
      //   79: aload_2
      //   80: areturn
      //   81: astore_2
      //   82: aload_1
      //   83: monitorexit
      //   84: aload_2
      //   85: athrow
      //   86: aload_1
      //   87: monitorexit
      //   88: aload_0
      //   89: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   92: astore_1
      //   93: aload_1
      //   94: monitorenter
      //   95: aload_0
      //   96: aload_0
      //   97: getfield 35	a0/m$b:f	I
      //   100: iconst_1
      //   101: isub
      //   102: putfield 35	a0/m$b:f	I
      //   105: aload_0
      //   106: getfield 35	a0/m$b:f	I
      //   109: ifne +14 -> 123
      //   112: aload_0
      //   113: getfield 37	a0/m$b:g	Z
      //   116: ifeq +7 -> 123
      //   119: aload_0
      //   120: invokespecial 57	a0/m$b:h	()V
      //   123: aload_1
      //   124: monitorexit
      //   125: aconst_null
      //   126: areturn
      //   127: astore_2
      //   128: aload_1
      //   129: monitorexit
      //   130: aload_2
      //   131: athrow
      //   132: astore_2
      //   133: aload_1
      //   134: monitorexit
      //   135: aload_2
      //   136: athrow
      //   137: astore_2
      //   138: aload_0
      //   139: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   142: astore_1
      //   143: aload_1
      //   144: monitorenter
      //   145: aload_0
      //   146: aload_0
      //   147: getfield 35	a0/m$b:f	I
      //   150: iconst_1
      //   151: isub
      //   152: putfield 35	a0/m$b:f	I
      //   155: aload_0
      //   156: getfield 35	a0/m$b:f	I
      //   159: ifne +14 -> 173
      //   162: aload_0
      //   163: getfield 37	a0/m$b:g	Z
      //   166: ifeq +7 -> 173
      //   169: aload_0
      //   170: invokespecial 57	a0/m$b:h	()V
      //   173: aload_1
      //   174: monitorexit
      //   175: aload_2
      //   176: athrow
      //   177: astore_2
      //   178: aload_1
      //   179: monitorexit
      //   180: aload_2
      //   181: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	182	0	this	b
      //   23	57	2	localObject2	Object
      //   81	4	2	localObject3	Object
      //   127	4	2	localObject4	Object
      //   132	4	2	localObject5	Object
      //   137	39	2	localObject6	Object
      //   177	4	2	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   49	77	81	finally
      //   77	79	81	finally
      //   82	84	81	finally
      //   95	123	127	finally
      //   123	125	127	finally
      //   128	130	127	finally
      //   7	24	132	finally
      //   28	42	132	finally
      //   86	88	132	finally
      //   133	135	132	finally
      //   0	7	137	finally
      //   135	137	137	finally
      //   145	173	177	finally
      //   173	175	177	finally
      //   178	180	177	finally
    }
    
    /* Error */
    public n0 e()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 28	a0/m$b:d	Z
      //   11: ifeq +57 -> 68
      //   14: aload_0
      //   15: getfield 39	a0/m$b:a	Landroidx/camera/extensions/impl/PreviewExtenderImpl;
      //   18: invokeinterface 88 1 0
      //   23: astore_2
      //   24: aload_2
      //   25: ifnull +43 -> 68
      //   28: new 80	a0/b
      //   31: dup
      //   32: aload_2
      //   33: invokespecial 83	a0/b:<init>	(Landroidx/camera/extensions/impl/CaptureStageImpl;)V
      //   36: invokevirtual 85	a0/b:a	()Ls/n0;
      //   39: astore_2
      //   40: aload_1
      //   41: monitorexit
      //   42: aload_0
      //   43: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   46: astore_1
      //   47: aload_1
      //   48: monitorenter
      //   49: aload_0
      //   50: aload_0
      //   51: getfield 35	a0/m$b:f	I
      //   54: iconst_1
      //   55: iadd
      //   56: putfield 35	a0/m$b:f	I
      //   59: aload_1
      //   60: monitorexit
      //   61: aload_2
      //   62: areturn
      //   63: astore_2
      //   64: aload_1
      //   65: monitorexit
      //   66: aload_2
      //   67: athrow
      //   68: aload_1
      //   69: monitorexit
      //   70: aload_0
      //   71: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   74: astore_1
      //   75: aload_1
      //   76: monitorenter
      //   77: aload_0
      //   78: aload_0
      //   79: getfield 35	a0/m$b:f	I
      //   82: iconst_1
      //   83: iadd
      //   84: putfield 35	a0/m$b:f	I
      //   87: aload_1
      //   88: monitorexit
      //   89: aconst_null
      //   90: areturn
      //   91: astore_2
      //   92: aload_1
      //   93: monitorexit
      //   94: aload_2
      //   95: athrow
      //   96: astore_2
      //   97: aload_1
      //   98: monitorexit
      //   99: aload_2
      //   100: athrow
      //   101: astore_2
      //   102: aload_0
      //   103: getfield 33	a0/m$b:e	Ljava/lang/Object;
      //   106: astore_1
      //   107: aload_1
      //   108: monitorenter
      //   109: aload_0
      //   110: aload_0
      //   111: getfield 35	a0/m$b:f	I
      //   114: iconst_1
      //   115: iadd
      //   116: putfield 35	a0/m$b:f	I
      //   119: aload_1
      //   120: monitorexit
      //   121: aload_2
      //   122: athrow
      //   123: astore_2
      //   124: aload_1
      //   125: monitorexit
      //   126: aload_2
      //   127: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	128	0	this	b
      //   4	121	1	localObject1	Object
      //   23	39	2	localObject2	Object
      //   63	4	2	localObject3	Object
      //   91	4	2	localObject4	Object
      //   96	4	2	localObject5	Object
      //   101	21	2	localObject6	Object
      //   123	4	2	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   49	61	63	finally
      //   64	66	63	finally
      //   77	89	91	finally
      //   92	94	91	finally
      //   7	24	96	finally
      //   28	42	96	finally
      //   68	70	96	finally
      //   97	99	96	finally
      //   0	7	101	finally
      //   99	101	101	finally
      //   109	121	123	finally
      //   124	126	123	finally
    }
    
    public n0 f()
    {
      synchronized (this.e)
      {
        Object localObject2 = this.a.onPresetSession();
        if (localObject2 != null)
        {
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject2 = new b((CaptureStageImpl)localObject2).a();
            return localObject2;
          }
          n1.k("PreviewConfigProvider", "The CaptureRequest parameters returned from onPresetSession() will be passed to the camera device as part of the capture session via SessionConfiguration#setSessionParameters(CaptureRequest) which only supported from API level 28!");
        }
        return null;
      }
    }
    
    public n0 g()
    {
      synchronized (this.e)
      {
        if (this.d)
        {
          Object localObject2 = this.a.getCaptureStage();
          if (localObject2 != null)
          {
            localObject2 = new b((CaptureStageImpl)localObject2).a();
            return localObject2;
          }
        }
        return null;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.m
 * JD-Core Version:    0.7.0.1
 */