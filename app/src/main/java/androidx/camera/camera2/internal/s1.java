package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.n1;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import m.d.a;
import o.g;
import q.o;
import q.r;
import s.g2;
import s.g2.e;
import s.k;
import s.n0;
import s.n0.a;
import s.s0;
import s.s0.a;
import s.u1;
import s.v0;
import s.y1;
import u.f;
import x0.h;

final class s1
  implements t1
{
  final Object a = new Object();
  private final List<n0> b = new ArrayList();
  private final CameraCaptureSession.CaptureCallback c = new a();
  private final f d = new f();
  x2 e;
  l2 f;
  g2 g;
  s0 h = y1.J();
  m.d i = m.d.e();
  private final Map<v0, Surface> j = new HashMap();
  List<v0> k = Collections.emptyList();
  e l = e.a;
  u7.a<Void> m;
  c.a<Void> n;
  final o o = new o();
  final r p = new r();
  
  private CameraCaptureSession.CaptureCallback k(List<k> paramList, CameraCaptureSession.CaptureCallback... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + paramVarArgs.length);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(o1.a((k)paramList.next()));
    }
    Collections.addAll(localArrayList, paramVarArgs);
    return k0.a(localArrayList);
  }
  
  private o.b m(g2.e parame, Map<v0, Surface> paramMap, String paramString)
  {
    Object localObject = (Surface)paramMap.get(parame.d());
    h.h(localObject, "Surface in OutputConfig not found in configuredSurfaceMap.");
    localObject = new o.b(parame.e(), (Surface)localObject);
    if (paramString == null) {
      paramString = parame.b();
    }
    ((o.b)localObject).e(paramString);
    if (!parame.c().isEmpty())
    {
      ((o.b)localObject).b();
      parame = parame.c().iterator();
      while (parame.hasNext())
      {
        paramString = (Surface)paramMap.get((v0)parame.next());
        h.h(paramString, "Surface in OutputConfig not found in configuredSurfaceMap.");
        ((o.b)localObject).a(paramString);
      }
    }
    return localObject;
  }
  
  private List<o.b> n(List<o.b> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o.b localb = (o.b)paramList.next();
      if (!localArrayList1.contains(localb.d()))
      {
        localArrayList1.add(localb.d());
        localArrayList2.add(localb);
      }
    }
    return localArrayList2;
  }
  
  private static s0 u(List<n0> paramList)
  {
    u1 localu1 = u1.M();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      s0 locals0 = ((n0)paramList.next()).d();
      Iterator localIterator = locals0.c().iterator();
      while (localIterator.hasNext())
      {
        s0.a locala = (s0.a)localIterator.next();
        Object localObject1 = locals0.e(locala, null);
        if (localu1.b(locala))
        {
          Object localObject2 = localu1.e(locala, null);
          if (!Objects.equals(localObject2, localObject1))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Detect conflicting option ");
            localStringBuilder.append(locala.c());
            localStringBuilder.append(" : ");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(" != ");
            localStringBuilder.append(localObject2);
            n1.a("CaptureSession", localStringBuilder.toString());
          }
        }
        else
        {
          localu1.G(locala, localObject1);
        }
      }
    }
    return localu1;
  }
  
  private u7.a<Void> v(List<Surface> paramList, g2 paramg2, CameraDevice paramCameraDevice)
  {
    synchronized (this.a)
    {
      int i1 = d.a[this.l.ordinal()];
      if ((i1 != 1) && (i1 != 2)) {
        if (i1 != 3)
        {
          if (i1 != 5)
          {
            paramList = new StringBuilder();
            paramList.append("openCaptureSession() not execute in state: ");
            paramList.append(this.l);
            paramList = f.f(new CancellationException(paramList.toString()));
            return paramList;
          }
        }
        else
        {
          this.j.clear();
          i1 = 0;
          while (i1 < paramList.size())
          {
            this.j.put((v0)this.k.get(i1), (Surface)paramList.get(i1));
            i1 += 1;
          }
          this.l = e.d;
          n1.a("CaptureSession", "Opening capture session.");
          paramList = y2.v(new l2.a[] { this.d, new y2.a(paramg2.i()) });
          Object localObject3 = new m.b(paramg2.d());
          Object localObject2 = ((m.b)localObject3).J(m.d.e());
          this.i = ((m.d)localObject2);
          Object localObject4 = ((m.d)localObject2).d().c();
          localObject2 = n0.a.k(paramg2.h());
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((n0.a)localObject2).e(((n0)((Iterator)localObject4).next()).d());
          }
          localObject4 = new ArrayList();
          localObject3 = ((m.b)localObject3).O(null);
          Iterator localIterator = paramg2.f().iterator();
          while (localIterator.hasNext()) {
            ((List)localObject4).add(m((g2.e)localIterator.next(), this.j, (String)localObject3));
          }
          localObject3 = n((List)localObject4);
          paramList = this.e.a(0, (List)localObject3, paramList);
          if ((paramg2.l() == 5) && (paramg2.e() != null)) {
            paramList.f(o.a.b(paramg2.e()));
          }
          try
          {
            paramg2 = b1.c(((n0.a)localObject2).h(), paramCameraDevice);
            if (paramg2 != null) {
              paramList.g(paramg2);
            }
            paramList = this.e.c(paramCameraDevice, paramList, this.k);
            return paramList;
          }
          catch (CameraAccessException paramList)
          {
            paramList = f.f(paramList);
            return paramList;
          }
        }
      }
      paramList = new StringBuilder();
      paramList.append("openCaptureSession() should not be possible in state: ");
      paramList.append(this.l);
      paramList = f.f(new IllegalStateException(paramList.toString()));
      return paramList;
    }
  }
  
  public u7.a<Void> a(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        switch (d.a[this.l.ordinal()])
        {
        case 5: 
        case 6: 
          l2 locall2 = this.f;
          if (locall2 != null)
          {
            if (paramBoolean) {
              try
              {
                locall2.k();
              }
              catch (CameraAccessException localCameraAccessException)
              {
                n1.d("CaptureSession", "Unable to abort captures.", localCameraAccessException);
              }
            }
            this.f.close();
          }
        case 4: 
          this.l = e.g;
          localObject2 = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("The Opener shouldn't null in state:");
          localStringBuilder.append(this.l);
          h.h(localObject2, localStringBuilder.toString());
          if (this.e.e()) {
            l();
          }
          break;
        case 7: 
          if (this.m == null) {
            this.m = androidx.concurrent.futures.c.a(new q1(this));
          }
          localObject2 = this.m;
          return localObject2;
        case 3: 
          localObject2 = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("The Opener shouldn't null in state:");
          localStringBuilder.append(this.l);
          h.h(localObject2, localStringBuilder.toString());
          this.e.e();
        case 2: 
          this.l = e.h;
          break;
        case 1: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("release() should not be possible in state: ");
          ((StringBuilder)localObject2).append(this.l);
          throw new IllegalStateException(((StringBuilder)localObject2).toString());
          return f.h(null);
        }
      }
    }
  }
  
  public List<n0> b()
  {
    synchronized (this.a)
    {
      List localList = Collections.unmodifiableList(this.b);
      return localList;
    }
  }
  
  /* Error */
  public void c(List<n0> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	androidx/camera/camera2/internal/s1:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: getstatic 331	androidx/camera/camera2/internal/s1$d:a	[I
    //   10: aload_0
    //   11: getfield 102	androidx/camera/camera2/internal/s1:l	Landroidx/camera/camera2/internal/s1$e;
    //   14: invokevirtual 336	java/lang/Enum:ordinal	()I
    //   17: iaload
    //   18: tableswitch	default:+134 -> 152, 1:+89->107, 2:+75->93, 3:+75->93, 4:+75->93, 5:+57->75, 6:+46->64, 7:+46->64, 8:+46->64
    //   65: aconst_null
    //   66: instanceof 22803
    //   69: aconst_null
    //   70: <illegal opcode>
    //   71: invokespecial 450	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: aload_0
    //   76: getfield 65	androidx/camera/camera2/internal/s1:b	Ljava/util/List;
    //   79: aload_1
    //   80: invokeinterface 501 2 0
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 503	androidx/camera/camera2/internal/s1:p	()V
    //   90: goto +54 -> 144
    //   93: aload_0
    //   94: getfield 65	androidx/camera/camera2/internal/s1:b	Ljava/util/List;
    //   97: aload_1
    //   98: invokeinterface 501 2 0
    //   103: pop
    //   104: goto +40 -> 144
    //   107: new 255	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   114: astore_1
    //   115: aload_1
    //   116: ldc_w 505
    //   119: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload_0
    //   125: getfield 102	androidx/camera/camera2/internal/s1:l	Landroidx/camera/camera2/internal/s1$e;
    //   128: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: new 449	java/lang/IllegalStateException
    //   135: dup
    //   136: aload_1
    //   137: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 450	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   143: athrow
    //   144: aload_2
    //   145: monitorexit
    //   146: return
    //   147: astore_1
    //   148: aload_2
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: goto -8 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	s1
    //   0	155	1	paramList	List<n0>
    //   4	145	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	64	147	finally
    //   64	75	147	finally
    //   75	90	147	finally
    //   93	104	147	finally
    //   107	144	147	finally
    //   144	146	147	finally
    //   148	150	147	finally
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      int i1 = d.a[this.l.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          StringBuilder localStringBuilder;
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 != 5) {
                break label232;
              }
              if (this.g != null)
              {
                List localList = this.i.d().a();
                boolean bool = localList.isEmpty();
                if (!bool) {
                  try
                  {
                    c(w(localList));
                  }
                  catch (IllegalStateException localIllegalStateException)
                  {
                    n1.d("CaptureSession", "Unable to issue the request before close the capture session", localIllegalStateException);
                  }
                }
              }
            }
            localObject2 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("The Opener shouldn't null in state:");
            localStringBuilder.append(this.l);
            h.h(localObject2, localStringBuilder.toString());
            this.e.e();
            this.l = e.f;
            this.g = null;
          }
          else
          {
            localObject2 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("The Opener shouldn't null in state:");
            localStringBuilder.append(this.l);
            h.h(localObject2, localStringBuilder.toString());
            this.e.e();
          }
        }
        else
        {
          this.l = e.h;
        }
        label232:
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("close() should not be possible in state: ");
      ((StringBuilder)localObject2).append(this.l);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
  }
  
  public g2 d()
  {
    synchronized (this.a)
    {
      g2 localg2 = this.g;
      return localg2;
    }
  }
  
  /* Error */
  public void e(g2 paramg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	androidx/camera/camera2/internal/s1:a	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: getstatic 331	androidx/camera/camera2/internal/s1$d:a	[I
    //   10: aload_0
    //   11: getfield 102	androidx/camera/camera2/internal/s1:l	Landroidx/camera/camera2/internal/s1$e;
    //   14: invokevirtual 336	java/lang/Enum:ordinal	()I
    //   17: iaload
    //   18: tableswitch	default:+176 -> 194, 1:+131->149, 2:+123->141, 3:+123->141, 4:+123->141, 5:+57->75, 6:+46->64, 7:+46->64, 8:+46->64
    //   65: aconst_null
    //   66: instanceof 22803
    //   69: iconst_m1
    //   70: fconst_0
    //   71: invokespecial 450	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 238	androidx/camera/camera2/internal/s1:g	Ls/g2;
    //   80: aload_1
    //   81: ifnonnull +6 -> 87
    //   84: aload_2
    //   85: monitorexit
    //   86: return
    //   87: aload_0
    //   88: getfield 90	androidx/camera/camera2/internal/s1:j	Ljava/util/Map;
    //   91: invokeinterface 526 1 0
    //   96: aload_1
    //   97: invokevirtual 528	s/g2:k	()Ljava/util/List;
    //   100: invokeinterface 531 2 0
    //   105: ifne +15 -> 120
    //   108: ldc_w 316
    //   111: ldc_w 533
    //   114: invokestatic 535	androidx/camera/core/n1:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_2
    //   118: monitorexit
    //   119: return
    //   120: ldc_w 316
    //   123: ldc_w 537
    //   126: invokestatic 321	androidx/camera/core/n1:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 238	androidx/camera/camera2/internal/s1:g	Ls/g2;
    //   134: invokevirtual 242	androidx/camera/camera2/internal/s1:q	(Ls/g2;)I
    //   137: pop
    //   138: goto +48 -> 186
    //   141: aload_0
    //   142: aload_1
    //   143: putfield 238	androidx/camera/camera2/internal/s1:g	Ls/g2;
    //   146: goto +40 -> 186
    //   149: new 255	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: ldc_w 539
    //   161: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_0
    //   167: getfield 102	androidx/camera/camera2/internal/s1:l	Landroidx/camera/camera2/internal/s1$e;
    //   170: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: new 449	java/lang/IllegalStateException
    //   177: dup
    //   178: aload_1
    //   179: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 450	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   185: athrow
    //   186: aload_2
    //   187: monitorexit
    //   188: return
    //   189: astore_1
    //   190: aload_2
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: goto -8 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	s1
    //   0	197	1	paramg2	g2
    //   4	187	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	64	189	finally
    //   64	75	189	finally
    //   75	80	189	finally
    //   84	86	189	finally
    //   87	119	189	finally
    //   120	138	189	finally
    //   141	146	189	finally
    //   149	186	189	finally
    //   186	188	189	finally
    //   190	192	189	finally
  }
  
  public void f()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (!this.b.isEmpty())
        {
          Object localObject1 = new ArrayList(this.b);
          this.b.clear();
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ??? = ((n0)((Iterator)localObject1).next()).b().iterator();
              if (((Iterator)???).hasNext())
              {
                ((k)((Iterator)???).next()).a();
                continue;
              }
              continue;
            }
          }
          return;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public u7.a<Void> g(g2 paramg2, CameraDevice paramCameraDevice, x2 paramx2)
  {
    synchronized (this.a)
    {
      if (d.a[this.l.ordinal()] != 2)
      {
        paramg2 = new StringBuilder();
        paramg2.append("Open not allowed in state: ");
        paramg2.append(this.l);
        n1.c("CaptureSession", paramg2.toString());
        paramg2 = new StringBuilder();
        paramg2.append("open() should not allow the state: ");
        paramg2.append(this.l);
        paramg2 = f.f(new IllegalStateException(paramg2.toString()));
        return paramg2;
      }
      this.l = e.c;
      ArrayList localArrayList = new ArrayList(paramg2.k());
      this.k = localArrayList;
      this.e = paramx2;
      paramg2 = u.d.a(paramx2.d(localArrayList, 5000L)).e(new r1(this, paramg2, paramCameraDevice), this.e.b());
      f.b(paramg2, new b(), this.e.b());
      paramg2 = f.j(paramg2);
      return paramg2;
    }
  }
  
  void l()
  {
    Object localObject = this.l;
    e locale = e.h;
    if (localObject == locale)
    {
      n1.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
      return;
    }
    this.l = locale;
    this.f = null;
    localObject = this.n;
    if (localObject != null)
    {
      ((c.a)localObject).c(null);
      this.n = null;
    }
  }
  
  int o(List<n0> paramList)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (paramList.isEmpty()) {
          return -1;
        }
        try
        {
          localObject2 = new g1();
          ArrayList localArrayList = new ArrayList();
          n1.a("CaptureSession", "Issuing capture request.");
          paramList = paramList.iterator();
          boolean bool = false;
          if (paramList.hasNext())
          {
            Object localObject3 = (n0)paramList.next();
            if (((n0)localObject3).e().isEmpty())
            {
              n1.a("CaptureSession", "Skipping issuing empty capture request.");
              continue;
            }
            Object localObject5 = ((n0)localObject3).e().iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break label573;
            }
            Object localObject4 = (v0)((Iterator)localObject5).next();
            if (this.j.containsKey(localObject4)) {
              continue;
            }
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("Skipping capture request with invalid surface: ");
            ((StringBuilder)localObject5).append(localObject4);
            n1.a("CaptureSession", ((StringBuilder)localObject5).toString());
            i1 = 0;
            break label575;
            if (((n0)localObject3).g() == 2) {
              bool = true;
            }
            localObject4 = n0.a.k((n0)localObject3);
            if ((((n0)localObject3).g() == 5) && (((n0)localObject3).c() != null)) {
              ((n0.a)localObject4).n(((n0)localObject3).c());
            }
            localObject5 = this.g;
            if (localObject5 != null) {
              ((n0.a)localObject4).e(((g2)localObject5).h().d());
            }
            ((n0.a)localObject4).e(this.h);
            ((n0.a)localObject4).e(((n0)localObject3).d());
            localObject4 = b1.b(((n0.a)localObject4).h(), this.f.l(), this.j);
            if (localObject4 == null)
            {
              n1.a("CaptureSession", "Skipping issuing request without surface.");
              return -1;
            }
            localObject5 = new ArrayList();
            localObject3 = ((n0)localObject3).b().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              o1.b((k)((Iterator)localObject3).next(), (List)localObject5);
              continue;
            }
            ((g1)localObject2).a((CaptureRequest)localObject4, (List)localObject5);
            localArrayList.add(localObject4);
            continue;
          }
          if (!localArrayList.isEmpty())
          {
            if (this.o.a(localArrayList, bool))
            {
              this.f.e();
              ((g1)localObject2).c(new p1(this));
            }
            if (this.p.b(localArrayList, bool)) {
              ((g1)localObject2).a((CaptureRequest)localArrayList.get(localArrayList.size() - 1), Collections.singletonList(new c()));
            }
            i1 = this.f.g(localArrayList, (CameraCaptureSession.CaptureCallback)localObject2);
            return i1;
          }
          n1.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
        }
        catch (CameraAccessException paramList)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Unable to access camera: ");
          ((StringBuilder)localObject2).append(paramList.getMessage());
          n1.c("CaptureSession", ((StringBuilder)localObject2).toString());
          Thread.dumpStack();
        }
        return -1;
      }
      label573:
      int i1 = 1;
      label575:
      if (i1 != 0) {}
    }
  }
  
  void p()
  {
    if (this.b.isEmpty()) {
      return;
    }
    try
    {
      o(this.b);
      return;
    }
    finally
    {
      this.b.clear();
    }
  }
  
  int q(g2 paramg2)
  {
    localObject1 = this.a;
    if (paramg2 == null) {}
    Object localObject2;
    try
    {
      n1.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
      return -1;
    }
    finally {}
    paramg2 = paramg2.h();
    if (paramg2.e().isEmpty())
    {
      n1.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
      try
      {
        this.f.e();
      }
      catch (CameraAccessException paramg2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unable to access camera: ");
        ((StringBuilder)localObject2).append(paramg2.getMessage());
        n1.c("CaptureSession", ((StringBuilder)localObject2).toString());
        Thread.dumpStack();
      }
      return -1;
    }
    try
    {
      n1.a("CaptureSession", "Issuing request for session.");
      localObject2 = n0.a.k(paramg2);
      s0 locals0 = u(this.i.d().d());
      this.h = locals0;
      ((n0.a)localObject2).e(locals0);
      localObject2 = b1.b(((n0.a)localObject2).h(), this.f.l(), this.j);
      if (localObject2 == null)
      {
        n1.a("CaptureSession", "Skipping issuing empty request for session.");
        return -1;
      }
      paramg2 = k(paramg2.b(), new CameraCaptureSession.CaptureCallback[] { this.c });
      int i1 = this.f.m((CaptureRequest)localObject2, paramg2);
      return i1;
    }
    catch (CameraAccessException paramg2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unable to access camera: ");
      ((StringBuilder)localObject2).append(paramg2.getMessage());
      n1.c("CaptureSession", ((StringBuilder)localObject2).toString());
      Thread.dumpStack();
      return -1;
    }
  }
  
  List<n0> w(List<n0> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      n0.a locala = n0.a.k((n0)paramList.next());
      locala.p(1);
      Iterator localIterator = this.g.h().e().iterator();
      while (localIterator.hasNext()) {
        locala.f((v0)localIterator.next());
      }
      localArrayList.add(locala.h());
    }
    return localArrayList;
  }
  
  class a
    extends CameraCaptureSession.CaptureCallback
  {
    a() {}
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult) {}
  }
  
  class b
    implements u.c<Void>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
    {
      synchronized (s1.this.a)
      {
        s1.this.e.e();
        int i = s1.d.a[s1.this.l.ordinal()];
        if (((i == 4) || (i == 6) || (i == 7)) && (!(paramThrowable instanceof CancellationException)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Opening session with fail ");
          localStringBuilder.append(s1.this.l);
          n1.l("CaptureSession", localStringBuilder.toString(), paramThrowable);
          s1.this.l();
        }
        return;
      }
    }
    
    public void c(Void paramVoid) {}
  }
  
  class c
    extends CameraCaptureSession.CaptureCallback
  {
    c() {}
    
    public void onCaptureCompleted(CameraCaptureSession arg1, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      synchronized (s1.this.a)
      {
        paramCaptureRequest = s1.this.g;
        if (paramCaptureRequest == null) {
          return;
        }
        paramCaptureRequest = paramCaptureRequest.h();
        n1.a("CaptureSession", "Submit FLASH_MODE_OFF request");
        paramTotalCaptureResult = s1.this;
        paramTotalCaptureResult.c(Collections.singletonList(paramTotalCaptureResult.p.a(paramCaptureRequest)));
        return;
      }
    }
  }
  
  static enum e
  {
    static
    {
      e locale1 = new e("UNINITIALIZED", 0);
      a = locale1;
      e locale2 = new e("INITIALIZED", 1);
      b = locale2;
      e locale3 = new e("GET_SURFACE", 2);
      c = locale3;
      e locale4 = new e("OPENING", 3);
      d = locale4;
      e locale5 = new e("OPENED", 4);
      e = locale5;
      e locale6 = new e("CLOSED", 5);
      f = locale6;
      e locale7 = new e("RELEASING", 6);
      g = locale7;
      e locale8 = new e("RELEASED", 7);
      h = locale8;
      i = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8 };
    }
    
    private e() {}
  }
  
  final class f
    extends l2.a
  {
    f() {}
    
    public void q(l2 arg1)
    {
      for (;;)
      {
        synchronized (s1.this.a)
        {
          switch (s1.d.a[s1.this.l.ordinal()])
          {
          case 8: 
            n1.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
            break;
          case 4: 
          case 6: 
          case 7: 
            s1.this.l();
            break;
          case 1: 
          case 2: 
          case 3: 
          case 5: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onConfigureFailed() should not be possible in state: ");
            localStringBuilder.append(s1.this.l);
            throw new IllegalStateException(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("CameraCaptureSession.onConfigureFailed() ");
            localStringBuilder.append(s1.this.l);
            n1.c("CaptureSession", localStringBuilder.toString());
            return;
          }
        }
      }
    }
    
    public void r(l2 paraml2)
    {
      for (;;)
      {
        synchronized (s1.this.a)
        {
          switch (s1.d.a[s1.this.l.ordinal()])
          {
          case 7: 
            paraml2.close();
            break;
          case 6: 
            s1.this.f = paraml2;
            break;
          case 4: 
            s1 locals1 = s1.this;
            locals1.l = s1.e.e;
            locals1.f = paraml2;
            if (locals1.g != null)
            {
              paraml2 = locals1.i.d().b();
              if (!paraml2.isEmpty())
              {
                locals1 = s1.this;
                locals1.o(locals1.w(paraml2));
              }
            }
            n1.a("CaptureSession", "Attempting to send capture request onConfigured");
            paraml2 = s1.this;
            paraml2.q(paraml2.g);
            s1.this.p();
            break;
          case 1: 
          case 2: 
          case 3: 
          case 5: 
          case 8: 
            paraml2 = new StringBuilder();
            paraml2.append("onConfigured() should not be possible in state: ");
            paraml2.append(s1.this.l);
            throw new IllegalStateException(paraml2.toString());
            paraml2 = new StringBuilder();
            paraml2.append("CameraCaptureSession.onConfigured() mState=");
            paraml2.append(s1.this.l);
            n1.a("CaptureSession", paraml2.toString());
            return;
          }
        }
      }
    }
    
    public void s(l2 arg1)
    {
      synchronized (s1.this.a)
      {
        if (s1.d.a[s1.this.l.ordinal()] != 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("CameraCaptureSession.onReady() ");
          localStringBuilder.append(s1.this.l);
          n1.a("CaptureSession", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReady() should not be possible in state: ");
        localStringBuilder.append(s1.this.l);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    
    public void t(l2 arg1)
    {
      synchronized (s1.this.a)
      {
        if (s1.this.l != s1.e.a)
        {
          n1.a("CaptureSession", "onSessionFinished()");
          s1.this.l();
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSessionFinished() should not be possible in state: ");
        localStringBuilder.append(s1.this.l);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.s1
 * JD-Core Version:    0.7.0.1
 */