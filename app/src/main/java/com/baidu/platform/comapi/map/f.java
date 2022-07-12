package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

class f
  implements t
{
  private static final k n = new k(null);
  private WeakReference<SurfaceView> a;
  private int b = 60;
  private final WeakReference<f> c = new WeakReference(this);
  private j d;
  private b0 e;
  private boolean f;
  private f g;
  private g h;
  private h i;
  private l j;
  private int k;
  private int l;
  private boolean m;
  
  public f(SurfaceView paramSurfaceView)
  {
    this.a = new WeakReference(paramSurfaceView);
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10, Bitmap.Config paramConfig)
  {
    int i1 = paramInt3 * paramInt4;
    int[] arrayOfInt1 = new int[i1];
    int[] arrayOfInt2 = new int[i1];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    for (;;)
    {
      try
      {
        paramGL10.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
        paramInt1 = 0;
      }
      catch (GLException paramGL10)
      {
        continue;
        if (paramInt1 >= paramInt4) {
          continue;
        }
        paramInt2 = 0;
        continue;
      }
      if (paramInt2 >= paramInt3) {
        continue;
      }
      i1 = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
      arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
      paramInt2 += 1;
    }
    paramInt1 += 1;
    break label158;
    if (paramConfig == null) {
      return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    }
    return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, paramConfig);
    return null;
  }
  
  private void b()
  {
    if (this.d == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  public void a(int paramInt)
  {
    b();
    this.l = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a(new c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8));
  }
  
  public void a(f paramf)
  {
    b();
    this.g = paramf;
  }
  
  public void a(g paramg)
  {
    b();
    this.h = paramg;
  }
  
  public void a(boolean paramBoolean)
  {
    a(new n(paramBoolean));
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public int c()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public Bitmap captureImageFromSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Bitmap.Config paramConfig)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, (GL10)paramObject, paramConfig);
  }
  
  public SurfaceHolder d()
  {
    SurfaceView localSurfaceView = (SurfaceView)this.a.get();
    if (localSurfaceView != null) {
      return localSurfaceView.getHolder();
    }
    return null;
  }
  
  public int e()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      return localView.getWidth();
    }
    return 0;
  }
  
  protected void finalize()
  {
    try
    {
      j localj = this.d;
      if (localj != null) {
        localj.g();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.k;
  }
  
  public int getFPS()
  {
    return this.b;
  }
  
  public int getRenderMode()
  {
    return this.d.b();
  }
  
  public u.a getViewType()
  {
    return u.a.a;
  }
  
  public void onAttachedToWindow()
  {
    if ((this.f) && (this.e != null))
    {
      j localj = this.d;
      int i1;
      if (localj != null) {
        i1 = localj.b();
      } else {
        i1 = 1;
      }
      localj = new j(this.c);
      this.d = localj;
      if (i1 != 1) {
        localj.a(i1);
      }
      this.d.start();
    }
    this.f = false;
  }
  
  public void onDetachedFromWindow()
  {
    j localj = this.d;
    if (localj != null) {
      localj.g();
    }
    this.f = true;
  }
  
  public void onPause()
  {
    this.d.d();
  }
  
  public void onResume()
  {
    this.d.e();
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.d.a(paramRunnable);
  }
  
  public void requestRender()
  {
    this.d.h();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setFPS(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int i1 = paramInt;
    if (paramInt > 60) {
      i1 = 60;
    }
    this.b = i1;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setRenderer(b0 paramb0)
  {
    b();
    if (this.g == null) {
      this.g = new n(true);
    }
    if (this.h == null) {
      this.h = new d(null);
    }
    if (this.i == null) {
      this.i = new e(null);
    }
    this.e = paramb0;
    paramb0 = new j(this.c);
    this.d = paramb0;
    paramb0.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.d.k();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.d.l();
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    paramSurfaceHolder = this.d;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.b(paramRunnable);
    }
  }
  
  private abstract class b
    implements f.f
  {
    protected int[] a = a(paramArrayOfInt);
    
    public b(int[] paramArrayOfInt) {}
    
    private int[] a(int[] paramArrayOfInt)
    {
      if ((f.b(f.this) != 2) && (f.b(f.this) != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      int j = i - 1;
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
      arrayOfInt[j] = 12352;
      if (f.b(f.this) == 2) {
        arrayOfInt[i] = 4;
      } else {
        arrayOfInt[i] = 64;
      }
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
    }
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, null, 0, arrayOfInt))
      {
        int i = arrayOfInt[0];
        if (i > 0)
        {
          EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
          if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt))
          {
            paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
            if (paramEGL10 != null) {
              return paramEGL10;
            }
            throw new IllegalArgumentException("No config chosen");
          }
          throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("No configs match configSpec");
      }
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
  }
  
  private class c
    extends f.b
  {
    private int[] c = new int[1];
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12338, paramInt7, 12337, paramInt8, 12344 });
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
      this.g = paramInt4;
      this.h = paramInt5;
      this.i = paramInt6;
      this.j = paramInt8;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.c)) {
        return this.c[0];
      }
      return paramInt2;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int n = paramArrayOfEGLConfig.length;
      Object localObject1 = null;
      int m = 0;
      while (m < n)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[m];
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        Object localObject2 = localObject1;
        if (i1 >= this.h)
        {
          localObject2 = localObject1;
          if (i2 >= this.i)
          {
            i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
            i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
            int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
            int i4 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
            localObject2 = localObject1;
            if (i1 == this.d)
            {
              localObject2 = localObject1;
              if (i2 == this.e)
              {
                localObject2 = localObject1;
                if (i3 == this.f)
                {
                  localObject2 = localObject1;
                  if (i4 == this.g)
                  {
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = localEGLConfig;
                    }
                    if (a(paramEGL10, paramEGLDisplay, localEGLConfig, 12337, 0) == this.j) {
                      return localEGLConfig;
                    }
                  }
                }
              }
            }
          }
        }
        m += 1;
        localObject1 = localObject2;
      }
      return localObject1;
    }
  }
  
  private class d
    implements f.g
  {
    private int a = 12440;
    
    private d() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.a;
      arrayOfInt[1] = f.b(f.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (f.b(f.this) == 0) {
        arrayOfInt = null;
      }
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      Log.e("DefaultContextFactory", localStringBuilder.toString());
      f.i.b("eglDestroyContex", paramEGL10.eglGetError());
      throw null;
    }
  }
  
  private static class e
    implements f.h
  {
    public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        Log.e("GLRenderControl", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  static abstract interface f
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  static abstract interface g
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  static abstract interface h
  {
    public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  private static class i
  {
    private WeakReference<f> a;
    EGL10 b;
    EGLDisplay c;
    EGLSurface d;
    EGLConfig e;
    EGLContext f;
    
    public i(WeakReference<f> paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    private static String a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return b(paramInt);
      case 12302: 
        return "EGL_CONTEXT_LOST";
      case 12301: 
        return "EGL_BAD_SURFACE";
      case 12300: 
        return "EGL_BAD_PARAMETER";
      case 12299: 
        return "EGL_BAD_NATIVE_WINDOW";
      case 12298: 
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12297: 
        return "EGL_BAD_MATCH";
      case 12296: 
        return "EGL_BAD_DISPLAY";
      case 12295: 
        return "EGL_BAD_CURRENT_SURFACE";
      case 12294: 
        return "EGL_BAD_CONTEXT";
      case 12293: 
        return "EGL_BAD_CONFIG";
      case 12292: 
        return "EGL_BAD_ATTRIBUTE";
      case 12291: 
        return "EGL_BAD_ALLOC";
      case 12290: 
        return "EGL_BAD_ACCESS";
      case 12289: 
        return "EGL_NOT_INITIALIZED";
      }
      return "EGL_SUCCESS";
    }
    
    public static String a(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" failed: ");
      localStringBuilder.append(a(paramInt));
      return localStringBuilder.toString();
    }
    
    private void a(String paramString)
    {
      b(paramString, this.b.eglGetError());
      throw null;
    }
    
    public static void a(String paramString1, String paramString2, int paramInt)
    {
      Log.w(paramString1, a(paramString2, paramInt));
    }
    
    private static String b(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      return localStringBuilder.toString();
    }
    
    public static void b(String paramString, int paramInt)
    {
      throw new RuntimeException(a(paramString, paramInt));
    }
    
    private void d()
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        if (localObject != localEGLSurface)
        {
          this.b.eglMakeCurrent(this.c, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
          localObject = (f)this.a.get();
          if (localObject != null) {
            f.e((f)localObject).destroySurface(this.b, this.c, this.d);
          }
          this.d = null;
        }
      }
    }
    
    GL a()
    {
      GL localGL2 = this.f.getGL();
      f localf = (f)this.a.get();
      Object localObject = localGL2;
      if (localf != null)
      {
        GL localGL1 = localGL2;
        if (f.f(localf) != null) {
          localGL1 = f.f(localf).a(localGL2);
        }
        localObject = localGL1;
        if ((f.g(localf) & 0x3) != 0)
        {
          int i = 0;
          localObject = null;
          if ((f.g(localf) & 0x1) != 0) {
            i = 1;
          }
          if ((f.g(localf) & 0x2) != 0) {
            localObject = new f.m();
          }
          localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        }
      }
      return localObject;
    }
    
    public boolean b()
    {
      if (this.b != null)
      {
        if (this.c != null)
        {
          if (this.e != null)
          {
            d();
            Object localObject = (f)this.a.get();
            if (localObject != null) {
              localObject = f.e((f)localObject).createWindowSurface(this.b, this.c, this.e, ((f)localObject).d());
            } else {
              localObject = null;
            }
            this.d = ((EGLSurface)localObject);
            localObject = this.d;
            if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
            {
              if (!this.b.eglMakeCurrent(this.c, (EGLSurface)localObject, (EGLSurface)localObject, this.f))
              {
                a("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
                return false;
              }
              return true;
            }
            if (this.b.eglGetError() == 12299) {
              Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
          }
          throw new RuntimeException("mEglConfig not initialized");
        }
        throw new RuntimeException("eglDisplay not initialized");
      }
      throw new RuntimeException("egl not initialized");
    }
    
    public void c()
    {
      d();
    }
    
    public void e()
    {
      if (this.f != null)
      {
        localObject = (f)this.a.get();
        if (localObject != null) {
          f.d((f)localObject).destroyContext(this.b, this.c, this.f);
        }
        this.f = null;
      }
      Object localObject = this.c;
      if (localObject != null)
      {
        this.b.eglTerminate((EGLDisplay)localObject);
        this.c = null;
      }
    }
    
    public void f()
    {
      Object localObject = (EGL10)EGLContext.getEGL();
      this.b = ((EGL10)localObject);
      localObject = ((EGL10)localObject).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      this.c = ((EGLDisplay)localObject);
      if (localObject != EGL10.EGL_NO_DISPLAY)
      {
        int[] arrayOfInt = new int[2];
        if (this.b.eglInitialize((EGLDisplay)localObject, arrayOfInt))
        {
          localObject = (f)this.a.get();
          if (localObject == null)
          {
            this.e = null;
            this.f = null;
          }
          else
          {
            this.e = f.c((f)localObject).chooseConfig(this.b, this.c);
            this.f = f.d((f)localObject).createContext(this.b, this.c, this.e);
          }
          localObject = this.f;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_CONTEXT))
          {
            this.d = null;
            return;
          }
          this.f = null;
          a("createContext");
          throw null;
        }
        throw new RuntimeException("eglInitialize failed");
      }
      throw new RuntimeException("eglGetDisplay failed");
    }
    
    public int g()
    {
      if (!this.b.eglSwapBuffers(this.c, this.d)) {
        return this.b.eglGetError();
      }
      return 12288;
    }
  }
  
  static class j
    extends Thread
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p = false;
    private boolean q;
    private ArrayList<Runnable> r = new ArrayList();
    private boolean s = true;
    private Runnable t = null;
    private f.i u;
    private WeakReference<f> v;
    
    j(WeakReference<f> paramWeakReference)
    {
      this.v = paramWeakReference;
      setPriority(10);
    }
    
    /* Error */
    private void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: astore 29
      //   3: aload 29
      //   5: new 76	com/baidu/platform/comapi/map/f$i
      //   8: dup
      //   9: aload 29
      //   11: getfield 62	com/baidu/platform/comapi/map/f$j:v	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 78	com/baidu/platform/comapi/map/f$i:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 80	com/baidu/platform/comapi/map/f$j:u	Lcom/baidu/platform/comapi/map/f$i;
      //   20: aload 29
      //   22: iconst_0
      //   23: putfield 82	com/baidu/platform/comapi/map/f$j:h	Z
      //   26: aload 29
      //   28: iconst_0
      //   29: putfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   32: aload 29
      //   34: iconst_0
      //   35: putfield 60	com/baidu/platform/comapi/map/f$j:p	Z
      //   38: iconst_0
      //   39: istore 5
      //   41: iload 5
      //   43: istore_3
      //   44: iload_3
      //   45: istore 8
      //   47: iload 8
      //   49: istore 6
      //   51: iload 6
      //   53: istore 7
      //   55: iload 7
      //   57: istore 4
      //   59: iload 4
      //   61: istore_2
      //   62: iload_2
      //   63: istore_1
      //   64: iload_1
      //   65: istore 13
      //   67: iload 13
      //   69: istore 12
      //   71: aconst_null
      //   72: astore 27
      //   74: aconst_null
      //   75: astore 30
      //   77: aconst_null
      //   78: astore 32
      //   80: iload_1
      //   81: istore 14
      //   83: iload 8
      //   85: istore_1
      //   86: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   89: astore 33
      //   91: aload 33
      //   93: monitorenter
      //   94: iload 5
      //   96: istore 8
      //   98: aload 29
      //   100: getfield 89	com/baidu/platform/comapi/map/f$j:a	Z
      //   103: ifeq +34 -> 137
      //   106: aload 33
      //   108: monitorexit
      //   109: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   112: astore 27
      //   114: aload 27
      //   116: monitorenter
      //   117: aload_0
      //   118: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   121: aload_0
      //   122: invokespecial 93	com/baidu/platform/comapi/map/f$j:i	()V
      //   125: aload 27
      //   127: monitorexit
      //   128: return
      //   129: astore 28
      //   131: aload 27
      //   133: monitorexit
      //   134: aload 28
      //   136: athrow
      //   137: aload 29
      //   139: getfield 46	com/baidu/platform/comapi/map/f$j:r	Ljava/util/ArrayList;
      //   142: invokevirtual 97	java/util/ArrayList:isEmpty	()Z
      //   145: ifne +30 -> 175
      //   148: aload 29
      //   150: getfield 46	com/baidu/platform/comapi/map/f$j:r	Ljava/util/ArrayList;
      //   153: iconst_0
      //   154: invokevirtual 101	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   157: checkcast 103	java/lang/Runnable
      //   160: astore 31
      //   162: iload 8
      //   164: istore 5
      //   166: iload_1
      //   167: istore 8
      //   169: iload 14
      //   171: istore_1
      //   172: goto +593 -> 765
      //   175: aload 29
      //   177: getfield 105	com/baidu/platform/comapi/map/f$j:d	Z
      //   180: istore 22
      //   182: aload 29
      //   184: getfield 107	com/baidu/platform/comapi/map/f$j:c	Z
      //   187: istore 21
      //   189: iload 22
      //   191: iload 21
      //   193: if_icmpeq +1234 -> 1427
      //   196: aload 29
      //   198: iload 21
      //   200: putfield 105	com/baidu/platform/comapi/map/f$j:d	Z
      //   203: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   206: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   209: goto +3 -> 212
      //   212: aload 29
      //   214: getfield 114	com/baidu/platform/comapi/map/f$j:k	Z
      //   217: ifeq +19 -> 236
      //   220: aload_0
      //   221: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   224: aload_0
      //   225: invokespecial 93	com/baidu/platform/comapi/map/f$j:i	()V
      //   228: aload 29
      //   230: iconst_0
      //   231: putfield 114	com/baidu/platform/comapi/map/f$j:k	Z
      //   234: iconst_1
      //   235: istore_1
      //   236: iload 8
      //   238: istore 15
      //   240: iload 8
      //   242: ifeq +14 -> 256
      //   245: aload_0
      //   246: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   249: aload_0
      //   250: invokespecial 93	com/baidu/platform/comapi/map/f$j:i	()V
      //   253: iconst_0
      //   254: istore 15
      //   256: iload 21
      //   258: ifeq +15 -> 273
      //   261: aload 29
      //   263: getfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   266: ifeq +7 -> 273
      //   269: aload_0
      //   270: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   273: iload 21
      //   275: ifeq +51 -> 326
      //   278: aload 29
      //   280: getfield 82	com/baidu/platform/comapi/map/f$j:h	Z
      //   283: ifeq +43 -> 326
      //   286: aload 29
      //   288: getfield 62	com/baidu/platform/comapi/map/f$j:v	Ljava/lang/ref/WeakReference;
      //   291: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   294: checkcast 6	com/baidu/platform/comapi/map/f
      //   297: astore 28
      //   299: aload 28
      //   301: ifnonnull +9 -> 310
      //   304: iconst_0
      //   305: istore 21
      //   307: goto +10 -> 317
      //   310: aload 28
      //   312: invokestatic 123	com/baidu/platform/comapi/map/f:h	(Lcom/baidu/platform/comapi/map/f;)Z
      //   315: istore 21
      //   317: iload 21
      //   319: ifne +7 -> 326
      //   322: aload_0
      //   323: invokespecial 93	com/baidu/platform/comapi/map/f$j:i	()V
      //   326: aload 29
      //   328: getfield 125	com/baidu/platform/comapi/map/f$j:e	Z
      //   331: ifne +41 -> 372
      //   334: aload 29
      //   336: getfield 127	com/baidu/platform/comapi/map/f$j:g	Z
      //   339: ifne +33 -> 372
      //   342: aload 29
      //   344: getfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   347: ifeq +7 -> 354
      //   350: aload_0
      //   351: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   354: aload 29
      //   356: iconst_1
      //   357: putfield 127	com/baidu/platform/comapi/map/f$j:g	Z
      //   360: aload 29
      //   362: iconst_0
      //   363: putfield 129	com/baidu/platform/comapi/map/f$j:f	Z
      //   366: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   369: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   372: aload 29
      //   374: getfield 125	com/baidu/platform/comapi/map/f$j:e	Z
      //   377: ifeq +23 -> 400
      //   380: aload 29
      //   382: getfield 127	com/baidu/platform/comapi/map/f$j:g	Z
      //   385: ifeq +15 -> 400
      //   388: aload 29
      //   390: iconst_0
      //   391: putfield 127	com/baidu/platform/comapi/map/f$j:g	Z
      //   394: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   397: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   400: iload_3
      //   401: istore 16
      //   403: iload_3
      //   404: ifeq +24 -> 428
      //   407: aload 29
      //   409: iconst_0
      //   410: putfield 60	com/baidu/platform/comapi/map/f$j:p	Z
      //   413: aload 29
      //   415: iconst_1
      //   416: putfield 131	com/baidu/platform/comapi/map/f$j:q	Z
      //   419: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   422: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   425: iconst_0
      //   426: istore 16
      //   428: aload 29
      //   430: getfield 50	com/baidu/platform/comapi/map/f$j:t	Ljava/lang/Runnable;
      //   433: astore 31
      //   435: aload 27
      //   437: astore 28
      //   439: aload 31
      //   441: ifnull +13 -> 454
      //   444: aload 29
      //   446: aconst_null
      //   447: putfield 50	com/baidu/platform/comapi/map/f$j:t	Ljava/lang/Runnable;
      //   450: aload 31
      //   452: astore 28
      //   454: aload_0
      //   455: invokespecial 133	com/baidu/platform/comapi/map/f$j:f	()Z
      //   458: ifeq +829 -> 1287
      //   461: aload 29
      //   463: getfield 82	com/baidu/platform/comapi/map/f$j:h	Z
      //   466: istore 21
      //   468: iload_1
      //   469: istore 9
      //   471: iload 6
      //   473: istore 10
      //   475: iload 21
      //   477: ifne +59 -> 536
      //   480: iload_1
      //   481: ifeq +13 -> 494
      //   484: iconst_0
      //   485: istore 9
      //   487: iload 6
      //   489: istore 10
      //   491: goto +45 -> 536
      //   494: aload 29
      //   496: getfield 80	com/baidu/platform/comapi/map/f$j:u	Lcom/baidu/platform/comapi/map/f$i;
      //   499: invokevirtual 135	com/baidu/platform/comapi/map/f$i:f	()V
      //   502: aload 29
      //   504: iconst_1
      //   505: putfield 82	com/baidu/platform/comapi/map/f$j:h	Z
      //   508: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   511: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   514: iconst_1
      //   515: istore 10
      //   517: iload_1
      //   518: istore 9
      //   520: goto +16 -> 536
      //   523: astore 27
      //   525: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   528: aload 29
      //   530: invokevirtual 140	com/baidu/platform/comapi/map/f$k:a	(Lcom/baidu/platform/comapi/map/f$j;)V
      //   533: aload 27
      //   535: athrow
      //   536: iload 7
      //   538: istore_3
      //   539: iload 4
      //   541: istore 11
      //   543: iload_2
      //   544: istore_1
      //   545: aload 29
      //   547: getfield 82	com/baidu/platform/comapi/map/f$j:h	Z
      //   550: ifeq +33 -> 583
      //   553: iload 7
      //   555: istore_3
      //   556: iload 4
      //   558: istore 11
      //   560: iload_2
      //   561: istore_1
      //   562: aload 29
      //   564: getfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   567: ifne +16 -> 583
      //   570: aload 29
      //   572: iconst_1
      //   573: putfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   576: iconst_1
      //   577: istore_3
      //   578: iconst_1
      //   579: istore 11
      //   581: iconst_1
      //   582: istore_1
      //   583: iload 9
      //   585: istore 5
      //   587: aload 28
      //   589: astore 27
      //   591: iload 10
      //   593: istore 17
      //   595: iload_3
      //   596: istore 18
      //   598: iload 11
      //   600: istore 19
      //   602: iload_1
      //   603: istore 20
      //   605: aload 29
      //   607: getfield 84	com/baidu/platform/comapi/map/f$j:i	Z
      //   610: ifeq +740 -> 1350
      //   613: aload 29
      //   615: getfield 48	com/baidu/platform/comapi/map/f$j:s	Z
      //   618: ifeq +815 -> 1433
      //   621: aload 29
      //   623: getfield 52	com/baidu/platform/comapi/map/f$j:l	I
      //   626: istore 19
      //   628: aload 29
      //   630: getfield 54	com/baidu/platform/comapi/map/f$j:m	I
      //   633: istore 20
      //   635: aload 29
      //   637: iconst_1
      //   638: putfield 60	com/baidu/platform/comapi/map/f$j:p	Z
      //   641: aload 29
      //   643: iconst_0
      //   644: putfield 48	com/baidu/platform/comapi/map/f$j:s	Z
      //   647: iconst_1
      //   648: istore 17
      //   650: iconst_1
      //   651: istore 18
      //   653: goto +3 -> 656
      //   656: aload 29
      //   658: iconst_0
      //   659: putfield 56	com/baidu/platform/comapi/map/f$j:o	Z
      //   662: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   665: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   668: iload 15
      //   670: istore 5
      //   672: iload 16
      //   674: istore_3
      //   675: iload 9
      //   677: istore 8
      //   679: aload 28
      //   681: astore 27
      //   683: iload 10
      //   685: istore 6
      //   687: iload 17
      //   689: istore 7
      //   691: iload 11
      //   693: istore 4
      //   695: iload 18
      //   697: istore_2
      //   698: iload 14
      //   700: istore_1
      //   701: iload 19
      //   703: istore 13
      //   705: iload 20
      //   707: istore 12
      //   709: aload 32
      //   711: astore 31
      //   713: aload 29
      //   715: getfield 60	com/baidu/platform/comapi/map/f$j:p	Z
      //   718: ifeq +47 -> 765
      //   721: iconst_1
      //   722: istore_1
      //   723: aload 32
      //   725: astore 31
      //   727: iload 20
      //   729: istore 12
      //   731: iload 19
      //   733: istore 13
      //   735: iload 18
      //   737: istore_2
      //   738: iload 11
      //   740: istore 4
      //   742: iload 17
      //   744: istore 7
      //   746: iload 10
      //   748: istore 6
      //   750: aload 28
      //   752: astore 27
      //   754: iload 9
      //   756: istore 8
      //   758: iload 16
      //   760: istore_3
      //   761: iload 15
      //   763: istore 5
      //   765: aload 33
      //   767: monitorexit
      //   768: aload 31
      //   770: ifnull +13 -> 783
      //   773: aload 31
      //   775: invokeinterface 143 1 0
      //   780: goto -703 -> 77
      //   783: iload 7
      //   785: istore 9
      //   787: iload 7
      //   789: ifeq +94 -> 883
      //   792: aload 29
      //   794: getfield 80	com/baidu/platform/comapi/map/f$j:u	Lcom/baidu/platform/comapi/map/f$i;
      //   797: invokevirtual 145	com/baidu/platform/comapi/map/f$i:b	()Z
      //   800: ifeq +40 -> 840
      //   803: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   806: astore 28
      //   808: aload 28
      //   810: monitorenter
      //   811: aload 29
      //   813: iconst_1
      //   814: putfield 147	com/baidu/platform/comapi/map/f$j:j	Z
      //   817: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   820: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   823: aload 28
      //   825: monitorexit
      //   826: iconst_0
      //   827: istore 9
      //   829: goto +54 -> 883
      //   832: astore 27
      //   834: aload 28
      //   836: monitorexit
      //   837: aload 27
      //   839: athrow
      //   840: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   843: astore 28
      //   845: aload 28
      //   847: monitorenter
      //   848: aload 29
      //   850: iconst_1
      //   851: putfield 147	com/baidu/platform/comapi/map/f$j:j	Z
      //   854: aload 29
      //   856: iconst_1
      //   857: putfield 129	com/baidu/platform/comapi/map/f$j:f	Z
      //   860: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   863: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   866: aload 28
      //   868: monitorexit
      //   869: iload_1
      //   870: istore 14
      //   872: goto +402 -> 1274
      //   875: astore 27
      //   877: aload 28
      //   879: monitorexit
      //   880: aload 27
      //   882: athrow
      //   883: iload 4
      //   885: istore 7
      //   887: iload 4
      //   889: ifeq +19 -> 908
      //   892: aload 29
      //   894: getfield 80	com/baidu/platform/comapi/map/f$j:u	Lcom/baidu/platform/comapi/map/f$i;
      //   897: invokevirtual 150	com/baidu/platform/comapi/map/f$i:a	()Ljavax/microedition/khronos/opengles/GL;
      //   900: checkcast 152	javax/microedition/khronos/opengles/GL10
      //   903: astore 30
      //   905: iconst_0
      //   906: istore 7
      //   908: iload 6
      //   910: ifeq +546 -> 1456
      //   913: aload 29
      //   915: getfield 62	com/baidu/platform/comapi/map/f$j:v	Ljava/lang/ref/WeakReference;
      //   918: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   921: checkcast 6	com/baidu/platform/comapi/map/f
      //   924: astore 28
      //   926: aload 28
      //   928: ifnull +522 -> 1450
      //   931: aload 28
      //   933: invokestatic 155	com/baidu/platform/comapi/map/f:a	(Lcom/baidu/platform/comapi/map/f;)Lcom/baidu/platform/comapi/map/b0;
      //   936: aconst_null
      //   937: aload 28
      //   939: invokevirtual 158	com/baidu/platform/comapi/map/f:e	()I
      //   942: aload 28
      //   944: invokevirtual 160	com/baidu/platform/comapi/map/f:c	()I
      //   947: iconst_0
      //   948: invokeinterface 165 5 0
      //   953: ldc 167
      //   955: ldc 169
      //   957: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   960: pop
      //   961: goto +489 -> 1450
      //   964: astore 27
      //   966: ldc 167
      //   968: ldc 169
      //   970: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   973: pop
      //   974: aload 27
      //   976: athrow
      //   977: iload 5
      //   979: istore 10
      //   981: iload_3
      //   982: istore 4
      //   984: iload_2
      //   985: istore_3
      //   986: iload_2
      //   987: ifeq +59 -> 1046
      //   990: aload 29
      //   992: getfield 62	com/baidu/platform/comapi/map/f$j:v	Ljava/lang/ref/WeakReference;
      //   995: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   998: checkcast 6	com/baidu/platform/comapi/map/f
      //   1001: astore 28
      //   1003: aload 28
      //   1005: ifnull +454 -> 1459
      //   1008: aload 28
      //   1010: invokestatic 155	com/baidu/platform/comapi/map/f:a	(Lcom/baidu/platform/comapi/map/f;)Lcom/baidu/platform/comapi/map/b0;
      //   1013: iload 13
      //   1015: iload 12
      //   1017: invokeinterface 177 3 0
      //   1022: ldc 167
      //   1024: ldc 179
      //   1026: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   1029: pop
      //   1030: goto +429 -> 1459
      //   1033: astore 27
      //   1035: ldc 167
      //   1037: ldc 179
      //   1039: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   1042: pop
      //   1043: aload 27
      //   1045: athrow
      //   1046: invokestatic 185	java/lang/System:currentTimeMillis	()J
      //   1049: lstore 23
      //   1051: aload 29
      //   1053: getfield 62	com/baidu/platform/comapi/map/f$j:v	Ljava/lang/ref/WeakReference;
      //   1056: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1059: checkcast 6	com/baidu/platform/comapi/map/f
      //   1062: astore 32
      //   1064: aload 32
      //   1066: ifnull +398 -> 1464
      //   1069: aload 32
      //   1071: invokestatic 155	com/baidu/platform/comapi/map/f:a	(Lcom/baidu/platform/comapi/map/f;)Lcom/baidu/platform/comapi/map/b0;
      //   1074: aload 30
      //   1076: invokeinterface 188 2 0
      //   1081: aload 27
      //   1083: astore 28
      //   1085: aload 27
      //   1087: ifnull +13 -> 1100
      //   1090: aload 27
      //   1092: invokeinterface 143 1 0
      //   1097: aconst_null
      //   1098: astore 28
      //   1100: aload 32
      //   1102: invokevirtual 191	com/baidu/platform/comapi/map/f:getFPS	()I
      //   1105: istore 5
      //   1107: aload 28
      //   1109: astore 27
      //   1111: goto +8 -> 1119
      //   1114: astore 27
      //   1116: aload 27
      //   1118: athrow
      //   1119: aload 29
      //   1121: getfield 80	com/baidu/platform/comapi/map/f$j:u	Lcom/baidu/platform/comapi/map/f$i;
      //   1124: invokevirtual 193	com/baidu/platform/comapi/map/f$i:g	()I
      //   1127: istore_2
      //   1128: iload_2
      //   1129: sipush 12288
      //   1132: if_icmpeq +344 -> 1476
      //   1135: iload_2
      //   1136: sipush 12302
      //   1139: if_icmpeq +332 -> 1471
      //   1142: ldc 195
      //   1144: ldc 197
      //   1146: iload_2
      //   1147: invokestatic 200	com/baidu/platform/comapi/map/f$i:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1150: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1153: astore 28
      //   1155: aload 28
      //   1157: monitorenter
      //   1158: aload 29
      //   1160: iconst_1
      //   1161: putfield 129	com/baidu/platform/comapi/map/f$j:f	Z
      //   1164: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1167: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   1170: aload 28
      //   1172: monitorexit
      //   1173: iload 10
      //   1175: istore_2
      //   1176: goto +303 -> 1479
      //   1179: astore 27
      //   1181: aload 28
      //   1183: monitorexit
      //   1184: aload 27
      //   1186: athrow
      //   1187: invokestatic 185	java/lang/System:currentTimeMillis	()J
      //   1190: lstore 25
      //   1192: iload 5
      //   1194: bipush 60
      //   1196: if_icmpge +60 -> 1256
      //   1199: iload 5
      //   1201: ifle +55 -> 1256
      //   1204: sipush 1000
      //   1207: iload 5
      //   1209: idiv
      //   1210: i2l
      //   1211: lload 25
      //   1213: lload 23
      //   1215: lsub
      //   1216: lsub
      //   1217: lstore 23
      //   1219: lload 23
      //   1221: lconst_1
      //   1222: lcmp
      //   1223: ifle +33 -> 1256
      //   1226: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1229: astore 28
      //   1231: aload 28
      //   1233: monitorenter
      //   1234: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1237: lload 23
      //   1239: invokevirtual 204	java/lang/Object:wait	(J)V
      //   1242: aload 28
      //   1244: monitorexit
      //   1245: goto +11 -> 1256
      //   1248: astore 27
      //   1250: aload 28
      //   1252: monitorexit
      //   1253: aload 27
      //   1255: athrow
      //   1256: iload 4
      //   1258: istore_1
      //   1259: iload_2
      //   1260: istore 5
      //   1262: iload_3
      //   1263: istore_2
      //   1264: iload 7
      //   1266: istore 4
      //   1268: iload 9
      //   1270: istore 7
      //   1272: iload_1
      //   1273: istore_3
      //   1274: aload_0
      //   1275: astore 29
      //   1277: iload 8
      //   1279: istore_1
      //   1280: aload 31
      //   1282: astore 32
      //   1284: goto -1198 -> 86
      //   1287: iload_1
      //   1288: istore 5
      //   1290: aload 28
      //   1292: astore 27
      //   1294: iload 6
      //   1296: istore 17
      //   1298: iload 7
      //   1300: istore 18
      //   1302: iload 4
      //   1304: istore 19
      //   1306: iload_2
      //   1307: istore 20
      //   1309: aload 28
      //   1311: ifnull +39 -> 1350
      //   1314: ldc 167
      //   1316: ldc 206
      //   1318: invokestatic 209	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1321: pop
      //   1322: aload 28
      //   1324: invokeinterface 143 1 0
      //   1329: aconst_null
      //   1330: astore 27
      //   1332: iload_2
      //   1333: istore 20
      //   1335: iload 4
      //   1337: istore 19
      //   1339: iload 7
      //   1341: istore 18
      //   1343: iload 6
      //   1345: istore 17
      //   1347: iload_1
      //   1348: istore 5
      //   1350: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1353: invokevirtual 211	java/lang/Object:wait	()V
      //   1356: aload_0
      //   1357: astore 29
      //   1359: iload 15
      //   1361: istore 8
      //   1363: iload 16
      //   1365: istore_3
      //   1366: iload 5
      //   1368: istore_1
      //   1369: iload 17
      //   1371: istore 6
      //   1373: iload 18
      //   1375: istore 7
      //   1377: iload 19
      //   1379: istore 4
      //   1381: iload 20
      //   1383: istore_2
      //   1384: goto -1286 -> 98
      //   1387: astore 27
      //   1389: aload 33
      //   1391: monitorexit
      //   1392: aload 27
      //   1394: athrow
      //   1395: astore 28
      //   1397: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   1400: astore 27
      //   1402: aload 27
      //   1404: monitorenter
      //   1405: aload_0
      //   1406: invokespecial 91	com/baidu/platform/comapi/map/f$j:j	()V
      //   1409: aload_0
      //   1410: invokespecial 93	com/baidu/platform/comapi/map/f$j:i	()V
      //   1413: aload 27
      //   1415: monitorexit
      //   1416: aload 28
      //   1418: athrow
      //   1419: astore 28
      //   1421: aload 27
      //   1423: monitorexit
      //   1424: aload 28
      //   1426: athrow
      //   1427: iconst_0
      //   1428: istore 21
      //   1430: goto -1218 -> 212
      //   1433: iload_3
      //   1434: istore 17
      //   1436: iload_1
      //   1437: istore 18
      //   1439: iload 13
      //   1441: istore 19
      //   1443: iload 12
      //   1445: istore 20
      //   1447: goto -791 -> 656
      //   1450: iconst_0
      //   1451: istore 6
      //   1453: goto -476 -> 977
      //   1456: goto -479 -> 977
      //   1459: iconst_0
      //   1460: istore_3
      //   1461: goto -415 -> 1046
      //   1464: bipush 60
      //   1466: istore 5
      //   1468: goto -349 -> 1119
      //   1471: iconst_1
      //   1472: istore_2
      //   1473: goto +6 -> 1479
      //   1476: iload 10
      //   1478: istore_2
      //   1479: iload_1
      //   1480: istore 14
      //   1482: iload_1
      //   1483: ifeq -296 -> 1187
      //   1486: iconst_1
      //   1487: istore 4
      //   1489: iconst_0
      //   1490: istore 14
      //   1492: goto -305 -> 1187
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1495	0	this	j
      //   63	1420	1	i1	int
      //   61	1418	2	i2	int
      //   43	1418	3	i3	int
      //   57	1431	4	i4	int
      //   39	1428	5	i5	int
      //   49	1403	6	i6	int
      //   53	1323	7	i7	int
      //   45	1317	8	i8	int
      //   469	800	9	i9	int
      //   473	1004	10	i10	int
      //   541	198	11	i11	int
      //   69	1375	12	i12	int
      //   65	1375	13	i13	int
      //   81	1410	14	i14	int
      //   238	1122	15	i15	int
      //   401	963	16	i16	int
      //   593	842	17	i17	int
      //   596	842	18	i18	int
      //   600	842	19	i19	int
      //   603	843	20	i20	int
      //   187	1242	21	bool1	boolean
      //   180	14	22	bool2	boolean
      //   1049	189	23	l1	long
      //   1190	22	25	l2	long
      //   72	364	27	localk1	f.k
      //   523	11	27	localRuntimeException	RuntimeException
      //   589	164	27	localObject1	Object
      //   832	6	27	localObject2	Object
      //   875	6	27	localObject3	Object
      //   964	11	27	localObject4	Object
      //   1033	58	27	localObject5	Object
      //   1109	1	27	localObject6	Object
      //   1114	3	27	localObject7	Object
      //   1179	6	27	localObject8	Object
      //   1248	6	27	localObject9	Object
      //   1292	39	27	localObject10	Object
      //   1387	6	27	localObject11	Object
      //   1400	22	27	localk2	f.k
      //   129	6	28	localObject12	Object
      //   297	1026	28	localObject13	Object
      //   1395	22	28	localObject14	Object
      //   1419	6	28	localObject15	Object
      //   1	1357	29	localj	j
      //   75	1000	30	localGL10	GL10
      //   160	1121	31	localObject16	Object
      //   78	1205	32	localObject17	Object
      //   89	1301	33	localk3	f.k
      // Exception table:
      //   from	to	target	type
      //   117	128	129	finally
      //   131	134	129	finally
      //   494	502	523	java/lang/RuntimeException
      //   811	826	832	finally
      //   834	837	832	finally
      //   848	869	875	finally
      //   877	880	875	finally
      //   931	953	964	finally
      //   1008	1022	1033	finally
      //   1069	1081	1114	finally
      //   1090	1097	1114	finally
      //   1100	1107	1114	finally
      //   1158	1173	1179	finally
      //   1181	1184	1179	finally
      //   1234	1245	1248	finally
      //   1250	1253	1248	finally
      //   98	109	1387	finally
      //   137	162	1387	finally
      //   175	189	1387	finally
      //   196	209	1387	finally
      //   212	234	1387	finally
      //   245	253	1387	finally
      //   261	273	1387	finally
      //   278	299	1387	finally
      //   310	317	1387	finally
      //   322	326	1387	finally
      //   326	354	1387	finally
      //   354	372	1387	finally
      //   372	400	1387	finally
      //   407	425	1387	finally
      //   428	435	1387	finally
      //   444	450	1387	finally
      //   454	468	1387	finally
      //   494	502	1387	finally
      //   502	514	1387	finally
      //   525	536	1387	finally
      //   545	553	1387	finally
      //   562	576	1387	finally
      //   605	647	1387	finally
      //   656	668	1387	finally
      //   713	721	1387	finally
      //   765	768	1387	finally
      //   1314	1329	1387	finally
      //   1350	1356	1387	finally
      //   1389	1392	1387	finally
      //   86	94	1395	finally
      //   773	780	1395	finally
      //   792	811	1395	finally
      //   837	840	1395	finally
      //   840	848	1395	finally
      //   880	883	1395	finally
      //   892	905	1395	finally
      //   913	926	1395	finally
      //   953	961	1395	finally
      //   966	977	1395	finally
      //   990	1003	1395	finally
      //   1022	1030	1395	finally
      //   1035	1046	1395	finally
      //   1046	1064	1395	finally
      //   1116	1119	1395	finally
      //   1119	1128	1395	finally
      //   1142	1158	1395	finally
      //   1184	1187	1395	finally
      //   1187	1192	1395	finally
      //   1204	1219	1395	finally
      //   1226	1234	1395	finally
      //   1253	1256	1395	finally
      //   1392	1395	1395	finally
      //   1405	1416	1419	finally
      //   1421	1424	1419	finally
    }
    
    private boolean f()
    {
      boolean bool2 = this.d;
      boolean bool1 = true;
      if ((!bool2) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0))
      {
        if (this.o) {
          return bool1;
        }
        if (this.n == 1) {
          return true;
        }
      }
      bool1 = false;
      return bool1;
    }
    
    private void i()
    {
      if (this.h)
      {
        this.u.e();
        this.h = false;
        f.a().a(this);
      }
    }
    
    private void j()
    {
      if (this.i)
      {
        this.i = false;
        this.u.c();
      }
    }
    
    public void a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= 1)) {
        synchronized (f.a())
        {
          this.n = paramInt;
          f.a().notifyAll();
          return;
        }
      }
      throw new IllegalArgumentException("renderMode");
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        this.l = paramInt1;
        this.m = paramInt2;
        this.s = true;
        this.o = true;
        this.q = false;
        if (Thread.currentThread() == this) {
          return;
        }
        f.a().notifyAll();
        while ((!this.b) && (!this.d) && (!this.q))
        {
          boolean bool = a();
          if (!bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label89:
            break label89;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable != null) {
        synchronized (f.a())
        {
          this.r.add(paramRunnable);
          f.a().notifyAll();
          return;
        }
      }
      throw new IllegalArgumentException("r must not be null");
    }
    
    public boolean a()
    {
      return (this.h) && (this.i) && (f());
    }
    
    public int b()
    {
      synchronized ()
      {
        int i1 = this.n;
        return i1;
      }
    }
    
    public void b(Runnable paramRunnable)
    {
      synchronized ()
      {
        if (Thread.currentThread() == this) {
          return;
        }
        this.p = true;
        this.o = true;
        this.q = false;
        this.t = paramRunnable;
        f.a().notifyAll();
        return;
      }
    }
    
    public void d()
    {
      synchronized ()
      {
        this.c = true;
        f.a().notifyAll();
        while (!this.b)
        {
          boolean bool = this.d;
          if (bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label42:
            break label42;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void e()
    {
      synchronized ()
      {
        this.c = false;
        this.o = true;
        this.q = false;
        f.a().notifyAll();
        while ((!this.b) && (this.d))
        {
          boolean bool = this.q;
          if (bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label59:
            break label59;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void g()
    {
      synchronized ()
      {
        this.a = true;
        f.a().notifyAll();
        for (;;)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label35:
            break label35;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void h()
    {
      synchronized ()
      {
        this.o = true;
        f.a().notifyAll();
        return;
      }
    }
    
    public void k()
    {
      synchronized ()
      {
        this.e = true;
        this.j = false;
        f.a().notifyAll();
        while ((this.g) && (!this.j))
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label54:
            break label54;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void l()
    {
      synchronized ()
      {
        this.e = false;
        f.a().notifyAll();
        while (!this.g)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            f.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label42:
            break label42;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: new 242	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 243	java/lang/StringBuilder:<init>	()V
      //   7: astore_1
      //   8: aload_1
      //   9: ldc 245
      //   11: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: pop
      //   15: aload_1
      //   16: aload_0
      //   17: invokevirtual 252	java/lang/Thread:getId	()J
      //   20: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   23: pop
      //   24: aload_0
      //   25: aload_1
      //   26: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: invokevirtual 262	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   32: aload_0
      //   33: invokespecial 263	com/baidu/platform/comapi/map/f$j:c	()V
      //   36: goto +13 -> 49
      //   39: astore_1
      //   40: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   43: aload_0
      //   44: invokevirtual 265	com/baidu/platform/comapi/map/f$k:b	(Lcom/baidu/platform/comapi/map/f$j;)V
      //   47: aload_1
      //   48: athrow
      //   49: invokestatic 87	com/baidu/platform/comapi/map/f:a	()Lcom/baidu/platform/comapi/map/f$k;
      //   52: aload_0
      //   53: invokevirtual 265	com/baidu/platform/comapi/map/f$k:b	(Lcom/baidu/platform/comapi/map/f$j;)V
      //   56: return
      //   57: astore_1
      //   58: goto -9 -> 49
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	j
      //   7	19	1	localStringBuilder	StringBuilder
      //   39	9	1	localObject	Object
      //   57	1	1	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   32	36	39	finally
      //   32	36	57	java/lang/InterruptedException
    }
  }
  
  private static class k
  {
    public void a(f.j paramj)
    {
      notifyAll();
    }
    
    public void b(f.j paramj)
    {
      try
      {
        f.j.a(paramj, true);
        notifyAll();
        return;
      }
      finally
      {
        paramj = finally;
        throw paramj;
      }
    }
  }
  
  static abstract interface l
  {
    public abstract GL a(GL paramGL);
  }
  
  static class m
    extends Writer
  {
    private StringBuilder a = new StringBuilder();
    
    private void a()
    {
      if (this.a.length() > 0)
      {
        Log.v("GLSurfaceView26", this.a.toString());
        StringBuilder localStringBuilder = this.a;
        localStringBuilder.delete(0, localStringBuilder.length());
      }
    }
    
    public void close()
    {
      a();
    }
    
    public void flush()
    {
      a();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          a();
        } else {
          this.a.append(c);
        }
        i += 1;
      }
    }
  }
  
  private class n
    extends f.c
  {
    public n(boolean paramBoolean)
    {
      super(8, 8, 8, 0, i, 0, 1, 4);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.f
 * JD-Core Version:    0.7.0.1
 */