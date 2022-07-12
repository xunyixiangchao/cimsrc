package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.baidu.platform.comapi.util.f;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class g
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final h n = new h(null);
  private int a = 60;
  private final View.OnLayoutChangeListener b = new a();
  private final WeakReference<g> c = new WeakReference(this);
  private g d;
  private b0 e;
  private boolean f;
  private GLSurfaceView.EGLConfigChooser g;
  private GLSurfaceView.EGLContextFactory h;
  private GLSurfaceView.EGLWindowSurfaceFactory i;
  private GLSurfaceView.GLWrapper j;
  private int k;
  private int l;
  private boolean m;
  
  public g(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public g(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public g(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
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
  
  private void c()
  {
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(this.b);
  }
  
  public Bitmap captureImageFromSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Bitmap.Config paramConfig)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, (GL10)paramObject, paramConfig);
  }
  
  protected void finalize()
  {
    try
    {
      g localg = this.d;
      if (localg != null) {
        localg.g();
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
    return this.a;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.m;
  }
  
  public int getRenderMode()
  {
    return this.d.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAttachedToWindow reattach =");
    ((StringBuilder)localObject).append(this.f);
    Log.d("GLTextureView", ((StringBuilder)localObject).toString());
    if ((this.f) && (this.e != null))
    {
      localObject = this.d;
      int i1;
      if (localObject != null) {
        i1 = ((g)localObject).b();
      } else {
        i1 = 1;
      }
      localObject = new g(this.c);
      this.d = ((g)localObject);
      if (i1 != 1) {
        ((g)localObject).a(i1);
      }
      this.d.start();
    }
    this.f = false;
  }
  
  protected void onDetachedFromWindow()
  {
    Log.d("GLTextureView", "onDetachedFromWindow");
    g localg = this.d;
    if (localg != null) {
      localg.g();
    }
    this.f = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    g localg = this.d;
    if (localg != null) {
      localg.d();
    }
  }
  
  public void onResume()
  {
    g localg = this.d;
    if (localg != null) {
      localg.e();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    surfaceCreated(paramSurfaceTexture);
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    surfaceDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    g localg = this.d;
    if (localg != null) {
      localg.a(paramRunnable);
    }
  }
  
  public void requestRender()
  {
    g localg = this.d;
    if (localg != null) {
      localg.i();
    }
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    b();
    this.g = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new j(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    b();
    this.l = paramInt;
  }
  
  public void setEGLContextFactory(GLSurfaceView.EGLContextFactory paramEGLContextFactory)
  {
    b();
    this.h = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    b();
    this.i = paramEGLWindowSurfaceFactory;
  }
  
  public void setFPS(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setGLWrapper(GLSurfaceView.GLWrapper paramGLWrapper)
  {
    this.j = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setRenderer(b0 paramb0)
  {
    b();
    if (this.g == null) {}
    try
    {
      if (f.a(8, 8, 8, 0, 24, 8)) {
        setEGLConfigChooser(8, 8, 8, 0, 24, 8);
      } else {
        setEGLConfigChooser(true);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label54:
      break label54;
    }
    setEGLConfigChooser(true);
    if (this.h == null) {
      this.h = new d(null);
    }
    if (this.i == null) {
      this.i = new e(null);
    }
    this.e = paramb0;
    paramb0 = new g(this.c);
    this.d = paramb0;
    paramb0.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceTexture = this.d;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.d;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.l();
    }
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.d;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.m();
    }
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    a() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      paramView = g.this;
      paramView.onSurfaceTextureSizeChanged(paramView.getSurfaceTexture(), paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  private abstract class b
    implements GLSurfaceView.EGLConfigChooser
  {
    protected int[] a = a(paramArrayOfInt);
    
    public b(int[] paramArrayOfInt) {}
    
    private int[] a(int[] paramArrayOfInt)
    {
      if (g.b(g.this) != 2) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      int j = i - 1;
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
      arrayOfInt[j] = 12352;
      arrayOfInt[i] = 4;
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
    extends g.b
  {
    private int[] c = new int[1];
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
      this.g = paramInt4;
      this.h = paramInt5;
      this.i = paramInt6;
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
      int m = paramArrayOfEGLConfig.length;
      int k = 0;
      while (k < m)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((n >= this.h) && (i1 >= this.i))
        {
          n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((n == this.d) && (i1 == this.e) && (i2 == this.f) && (i3 == this.g)) {
            return localEGLConfig;
          }
        }
        k += 1;
      }
      return null;
    }
  }
  
  private class d
    implements GLSurfaceView.EGLContextFactory
  {
    private int a = 12440;
    
    private d() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.a;
      arrayOfInt[1] = g.b(g.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (g.b(g.this) == 0) {
        arrayOfInt = null;
      }
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
        return;
      }
      paramEGLDisplay = new StringBuilder();
      paramEGLDisplay.append("tid=");
      paramEGLDisplay.append(Thread.currentThread().getId());
      Log.i("DefaultContextFactory", paramEGLDisplay.toString());
      g.f.b("eglDestroyContex", paramEGL10.eglGetError());
      throw null;
    }
  }
  
  private static class e
    implements GLSurfaceView.EGLWindowSurfaceFactory
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
        Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  private static class f
  {
    private WeakReference<g> a;
    EGL10 b;
    EGLDisplay c;
    EGLSurface d;
    EGLConfig e;
    EGLContext f;
    
    public f(WeakReference<g> paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    public static String a(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" EGL failed code: ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    
    private void a(String paramString)
    {
      b(paramString, this.b.eglGetError());
      throw null;
    }
    
    public static void a(String paramString1, String paramString2, int paramInt) {}
    
    public static void b(String paramString, int paramInt)
    {
      paramString = a(paramString, paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("throwEglException tid=");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      Log.e("EglHelper", localStringBuilder.toString());
      throw new RuntimeException(paramString);
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
          localObject = (g)this.a.get();
          if (localObject != null) {
            g.e((g)localObject).destroySurface(this.b, this.c, this.d);
          }
          this.d = null;
        }
      }
    }
    
    GL a()
    {
      GL localGL2 = this.f.getGL();
      g localg = (g)this.a.get();
      Object localObject = localGL2;
      if (localg != null)
      {
        GL localGL1 = localGL2;
        if (g.f(localg) != null) {
          localGL1 = g.f(localg).wrap(localGL2);
        }
        localObject = localGL1;
        if ((g.g(localg) & 0x3) != 0)
        {
          int i = 0;
          localObject = null;
          if ((g.g(localg) & 0x1) != 0) {
            i = 1;
          }
          if ((g.g(localg) & 0x2) != 0) {
            localObject = new g.i();
          }
          localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        }
      }
      return localObject;
    }
    
    public boolean b()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createSurface()  tid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      Log.w("EglHelper", ((StringBuilder)localObject).toString());
      if (this.b != null)
      {
        if (this.c != null)
        {
          if (this.e != null)
          {
            d();
            localObject = (g)this.a.get();
            if (localObject != null) {
              localObject = g.e((g)localObject).createWindowSurface(this.b, this.c, this.e, ((TextureView)localObject).getSurfaceTexture());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroySurface()  tid=");
      localStringBuilder.append(Thread.currentThread().getId());
      Log.w("EglHelper", localStringBuilder.toString());
      d();
    }
    
    public void e()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finish() tid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      Log.w("EglHelper", ((StringBuilder)localObject).toString());
      if (this.f != null)
      {
        localObject = (g)this.a.get();
        if (localObject != null) {
          g.d((g)localObject).destroyContext(this.b, this.c, this.f);
        }
        this.f = null;
      }
      localObject = this.c;
      if (localObject != null)
      {
        this.b.eglTerminate((EGLDisplay)localObject);
        this.c = null;
      }
    }
    
    public void f()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start() tid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      Log.w("EglHelper", ((StringBuilder)localObject).toString());
      localObject = (EGL10)EGLContext.getEGL();
      this.b = ((EGL10)localObject);
      localObject = ((EGL10)localObject).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      this.c = ((EGLDisplay)localObject);
      if (localObject != EGL10.EGL_NO_DISPLAY)
      {
        int[] arrayOfInt = new int[2];
        if (this.b.eglInitialize((EGLDisplay)localObject, arrayOfInt))
        {
          localObject = (g)this.a.get();
          if (localObject == null)
          {
            this.e = null;
            this.f = null;
          }
          else
          {
            this.e = g.c((g)localObject).chooseConfig(this.b, this.c);
            this.f = g.d((g)localObject).createContext(this.b, this.c, this.e);
          }
          localObject = this.f;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_CONTEXT))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("createContext ");
            ((StringBuilder)localObject).append(this.f);
            ((StringBuilder)localObject).append(" tid=");
            ((StringBuilder)localObject).append(Thread.currentThread().getId());
            Log.w("EglHelper", ((StringBuilder)localObject).toString());
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
  
  static class g
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
    private int k = 0;
    private int l = 0;
    private int m = 1;
    private boolean n = true;
    private boolean o;
    private ArrayList<Runnable> p = new ArrayList();
    private boolean q = true;
    private g.f r;
    private WeakReference<g> s;
    
    g(WeakReference<g> paramWeakReference)
    {
      this.s = paramWeakReference;
    }
    
    /* Error */
    private void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 64	com/baidu/platform/comapi/map/g$f
      //   4: dup
      //   5: aload_0
      //   6: getfield 54	com/baidu/platform/comapi/map/g$g:s	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 66	com/baidu/platform/comapi/map/g$f:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   25: iconst_0
      //   26: istore_2
      //   27: iload_2
      //   28: istore 6
      //   30: iload 6
      //   32: istore 5
      //   34: iload 5
      //   36: istore_3
      //   37: iload_3
      //   38: istore 4
      //   40: iload 4
      //   42: istore 8
      //   44: iload 8
      //   46: istore_1
      //   47: iload_1
      //   48: istore 7
      //   50: iload 7
      //   52: istore 10
      //   54: iload 10
      //   56: istore 9
      //   58: aconst_null
      //   59: astore 21
      //   61: aconst_null
      //   62: astore 22
      //   64: iload_1
      //   65: istore 11
      //   67: iload 6
      //   69: istore_1
      //   70: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   73: astore 23
      //   75: aload 23
      //   77: monitorenter
      //   78: iload 11
      //   80: istore 14
      //   82: aload_0
      //   83: getfield 77	com/baidu/platform/comapi/map/g$g:a	Z
      //   86: ifeq +34 -> 120
      //   89: aload 23
      //   91: monitorexit
      //   92: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   95: astore 21
      //   97: aload 21
      //   99: monitorenter
      //   100: aload_0
      //   101: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   104: aload_0
      //   105: invokespecial 81	com/baidu/platform/comapi/map/g$g:j	()V
      //   108: aload 21
      //   110: monitorexit
      //   111: return
      //   112: astore 22
      //   114: aload 21
      //   116: monitorexit
      //   117: aload 22
      //   119: athrow
      //   120: aload_0
      //   121: getfield 42	com/baidu/platform/comapi/map/g$g:p	Ljava/util/ArrayList;
      //   124: invokevirtual 85	java/util/ArrayList:isEmpty	()Z
      //   127: ifne +25 -> 152
      //   130: aload_0
      //   131: getfield 42	com/baidu/platform/comapi/map/g$g:p	Ljava/util/ArrayList;
      //   134: iconst_0
      //   135: invokevirtual 89	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   138: checkcast 91	java/lang/Runnable
      //   141: astore 22
      //   143: iload_1
      //   144: istore 6
      //   146: iload 14
      //   148: istore_1
      //   149: goto +837 -> 986
      //   152: aload_0
      //   153: getfield 93	com/baidu/platform/comapi/map/g$g:d	Z
      //   156: istore 16
      //   158: aload_0
      //   159: getfield 95	com/baidu/platform/comapi/map/g$g:c	Z
      //   162: istore 15
      //   164: iload 16
      //   166: iload 15
      //   168: if_icmpeq +1638 -> 1806
      //   171: aload_0
      //   172: iload 15
      //   174: putfield 93	com/baidu/platform/comapi/map/g$g:d	Z
      //   177: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   180: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   183: new 102	java/lang/StringBuilder
      //   186: dup
      //   187: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   190: astore 24
      //   192: aload 24
      //   194: ldc 105
      //   196: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: pop
      //   200: aload 24
      //   202: aload_0
      //   203: getfield 93	com/baidu/platform/comapi/map/g$g:d	Z
      //   206: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   209: pop
      //   210: aload 24
      //   212: ldc 114
      //   214: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   217: pop
      //   218: aload 24
      //   220: aload_0
      //   221: invokevirtual 118	java/lang/Thread:getId	()J
      //   224: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   227: pop
      //   228: ldc 123
      //   230: aload 24
      //   232: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   235: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   238: pop
      //   239: goto +3 -> 242
      //   242: aload_0
      //   243: getfield 134	com/baidu/platform/comapi/map/g$g:j	Z
      //   246: istore 16
      //   248: iload 16
      //   250: ifeq +57 -> 307
      //   253: new 102	java/lang/StringBuilder
      //   256: dup
      //   257: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   260: astore 24
      //   262: aload 24
      //   264: ldc 136
      //   266: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: pop
      //   270: aload 24
      //   272: aload_0
      //   273: invokevirtual 118	java/lang/Thread:getId	()J
      //   276: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   279: pop
      //   280: ldc 123
      //   282: aload 24
      //   284: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   287: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   290: pop
      //   291: aload_0
      //   292: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   295: aload_0
      //   296: invokespecial 81	com/baidu/platform/comapi/map/g$g:j	()V
      //   299: aload_0
      //   300: iconst_0
      //   301: putfield 134	com/baidu/platform/comapi/map/g$g:j	Z
      //   304: iconst_1
      //   305: istore 7
      //   307: iload_3
      //   308: istore 11
      //   310: iload_3
      //   311: ifeq +14 -> 325
      //   314: aload_0
      //   315: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   318: aload_0
      //   319: invokespecial 81	com/baidu/platform/comapi/map/g$g:j	()V
      //   322: iconst_0
      //   323: istore 11
      //   325: iload 15
      //   327: ifeq +56 -> 383
      //   330: aload_0
      //   331: getfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   334: istore 16
      //   336: iload 16
      //   338: ifeq +45 -> 383
      //   341: new 102	java/lang/StringBuilder
      //   344: dup
      //   345: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   348: astore 24
      //   350: aload 24
      //   352: ldc 138
      //   354: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   357: pop
      //   358: aload 24
      //   360: aload_0
      //   361: invokevirtual 118	java/lang/Thread:getId	()J
      //   364: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   367: pop
      //   368: ldc 123
      //   370: aload 24
      //   372: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   375: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   378: pop
      //   379: aload_0
      //   380: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   383: iload 15
      //   385: ifeq +95 -> 480
      //   388: aload_0
      //   389: getfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   392: ifeq +88 -> 480
      //   395: aload_0
      //   396: getfield 54	com/baidu/platform/comapi/map/g$g:s	Ljava/lang/ref/WeakReference;
      //   399: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   402: checkcast 6	com/baidu/platform/comapi/map/g
      //   405: astore 24
      //   407: aload 24
      //   409: ifnull +1403 -> 1812
      //   412: aload 24
      //   414: invokestatic 147	com/baidu/platform/comapi/map/g:h	(Lcom/baidu/platform/comapi/map/g;)Z
      //   417: ifeq +1395 -> 1812
      //   420: iconst_1
      //   421: istore_3
      //   422: goto +3 -> 425
      //   425: iload_3
      //   426: ifeq +12 -> 438
      //   429: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   432: invokevirtual 151	com/baidu/platform/comapi/map/g$h:b	()Z
      //   435: ifeq +45 -> 480
      //   438: aload_0
      //   439: invokespecial 81	com/baidu/platform/comapi/map/g$g:j	()V
      //   442: new 102	java/lang/StringBuilder
      //   445: dup
      //   446: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   449: astore 24
      //   451: aload 24
      //   453: ldc 153
      //   455: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   458: pop
      //   459: aload 24
      //   461: aload_0
      //   462: invokevirtual 118	java/lang/Thread:getId	()J
      //   465: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   468: pop
      //   469: ldc 123
      //   471: aload 24
      //   473: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   476: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   479: pop
      //   480: iload 15
      //   482: ifeq +57 -> 539
      //   485: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   488: invokevirtual 155	com/baidu/platform/comapi/map/g$h:c	()Z
      //   491: ifeq +48 -> 539
      //   494: aload_0
      //   495: getfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   498: invokevirtual 157	com/baidu/platform/comapi/map/g$f:e	()V
      //   501: new 102	java/lang/StringBuilder
      //   504: dup
      //   505: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   508: astore 24
      //   510: aload 24
      //   512: ldc 159
      //   514: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   517: pop
      //   518: aload 24
      //   520: aload_0
      //   521: invokevirtual 118	java/lang/Thread:getId	()J
      //   524: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   527: pop
      //   528: ldc 123
      //   530: aload 24
      //   532: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   535: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   538: pop
      //   539: aload_0
      //   540: getfield 161	com/baidu/platform/comapi/map/g$g:e	Z
      //   543: ifne +79 -> 622
      //   546: aload_0
      //   547: getfield 163	com/baidu/platform/comapi/map/g$g:g	Z
      //   550: istore 15
      //   552: iload 15
      //   554: ifne +68 -> 622
      //   557: new 102	java/lang/StringBuilder
      //   560: dup
      //   561: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   564: astore 24
      //   566: aload 24
      //   568: ldc 165
      //   570: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   573: pop
      //   574: aload 24
      //   576: aload_0
      //   577: invokevirtual 118	java/lang/Thread:getId	()J
      //   580: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   583: pop
      //   584: ldc 123
      //   586: aload 24
      //   588: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   591: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   594: pop
      //   595: aload_0
      //   596: getfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   599: ifeq +7 -> 606
      //   602: aload_0
      //   603: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   606: aload_0
      //   607: iconst_1
      //   608: putfield 163	com/baidu/platform/comapi/map/g$g:g	Z
      //   611: aload_0
      //   612: iconst_0
      //   613: putfield 167	com/baidu/platform/comapi/map/g$g:f	Z
      //   616: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   619: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   622: aload_0
      //   623: getfield 161	com/baidu/platform/comapi/map/g$g:e	Z
      //   626: ifeq +63 -> 689
      //   629: aload_0
      //   630: getfield 163	com/baidu/platform/comapi/map/g$g:g	Z
      //   633: istore 15
      //   635: iload 15
      //   637: ifeq +52 -> 689
      //   640: new 102	java/lang/StringBuilder
      //   643: dup
      //   644: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   647: astore 24
      //   649: aload 24
      //   651: ldc 169
      //   653: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   656: pop
      //   657: aload 24
      //   659: aload_0
      //   660: invokevirtual 118	java/lang/Thread:getId	()J
      //   663: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   666: pop
      //   667: ldc 123
      //   669: aload 24
      //   671: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   674: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   677: pop
      //   678: aload_0
      //   679: iconst_0
      //   680: putfield 163	com/baidu/platform/comapi/map/g$g:g	Z
      //   683: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   686: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   689: iload 8
      //   691: istore 13
      //   693: iload 14
      //   695: istore 12
      //   697: iload 14
      //   699: ifeq +58 -> 757
      //   702: new 102	java/lang/StringBuilder
      //   705: dup
      //   706: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   709: astore 24
      //   711: aload 24
      //   713: ldc 171
      //   715: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   718: pop
      //   719: aload 24
      //   721: aload_0
      //   722: invokevirtual 118	java/lang/Thread:getId	()J
      //   725: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   728: pop
      //   729: ldc 123
      //   731: aload 24
      //   733: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   736: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   739: pop
      //   740: aload_0
      //   741: iconst_1
      //   742: putfield 173	com/baidu/platform/comapi/map/g$g:o	Z
      //   745: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   748: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   751: iconst_0
      //   752: istore 13
      //   754: iconst_0
      //   755: istore 12
      //   757: aload_0
      //   758: invokespecial 175	com/baidu/platform/comapi/map/g$g:f	()Z
      //   761: ifeq +756 -> 1517
      //   764: aload_0
      //   765: getfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   768: ifne +1049 -> 1817
      //   771: iload 7
      //   773: ifeq +9 -> 782
      //   776: iconst_0
      //   777: istore 7
      //   779: goto +52 -> 831
      //   782: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   785: aload_0
      //   786: invokevirtual 178	com/baidu/platform/comapi/map/g$h:c	(Lcom/baidu/platform/comapi/map/g$g;)Z
      //   789: istore 15
      //   791: iload 15
      //   793: ifeq +1024 -> 1817
      //   796: aload_0
      //   797: getfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   800: invokevirtual 180	com/baidu/platform/comapi/map/g$f:f	()V
      //   803: aload_0
      //   804: iconst_1
      //   805: putfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   808: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   811: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   814: iconst_1
      //   815: istore_2
      //   816: goto +15 -> 831
      //   819: astore 21
      //   821: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   824: aload_0
      //   825: invokevirtual 183	com/baidu/platform/comapi/map/g$h:a	(Lcom/baidu/platform/comapi/map/g$g;)V
      //   828: aload 21
      //   830: athrow
      //   831: iload_1
      //   832: istore 8
      //   834: iload 5
      //   836: istore 6
      //   838: iload 4
      //   840: istore_3
      //   841: aload_0
      //   842: getfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   845: ifeq +33 -> 878
      //   848: iload_1
      //   849: istore 8
      //   851: iload 5
      //   853: istore 6
      //   855: iload 4
      //   857: istore_3
      //   858: aload_0
      //   859: getfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   862: ifne +16 -> 878
      //   865: aload_0
      //   866: iconst_1
      //   867: putfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   870: iconst_1
      //   871: istore 8
      //   873: iconst_1
      //   874: istore 6
      //   876: iconst_1
      //   877: istore_3
      //   878: aload_0
      //   879: getfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   882: ifeq +622 -> 1504
      //   885: aload_0
      //   886: getfield 44	com/baidu/platform/comapi/map/g$g:q	Z
      //   889: ifeq +931 -> 1820
      //   892: aload_0
      //   893: getfield 46	com/baidu/platform/comapi/map/g$g:k	I
      //   896: istore 10
      //   898: aload_0
      //   899: getfield 48	com/baidu/platform/comapi/map/g$g:l	I
      //   902: istore 9
      //   904: new 102	java/lang/StringBuilder
      //   907: dup
      //   908: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   911: astore 24
      //   913: aload 24
      //   915: ldc 185
      //   917: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   920: pop
      //   921: aload 24
      //   923: aload_0
      //   924: invokevirtual 118	java/lang/Thread:getId	()J
      //   927: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   930: pop
      //   931: ldc 123
      //   933: aload 24
      //   935: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   938: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   941: pop
      //   942: aload_0
      //   943: iconst_0
      //   944: putfield 44	com/baidu/platform/comapi/map/g$g:q	Z
      //   947: iconst_1
      //   948: istore 14
      //   950: iconst_1
      //   951: istore_3
      //   952: iconst_1
      //   953: istore 8
      //   955: goto +3 -> 958
      //   958: aload_0
      //   959: iconst_0
      //   960: putfield 50	com/baidu/platform/comapi/map/g$g:n	Z
      //   963: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   966: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   969: iload 12
      //   971: istore_1
      //   972: iload_3
      //   973: istore 4
      //   975: iload 11
      //   977: istore_3
      //   978: iload 6
      //   980: istore 5
      //   982: iload 14
      //   984: istore 6
      //   986: aload 23
      //   988: monitorexit
      //   989: aload 22
      //   991: ifnull +13 -> 1004
      //   994: aload 22
      //   996: invokeinterface 188 1 0
      //   1001: goto -940 -> 61
      //   1004: iload 6
      //   1006: istore 11
      //   1008: iload 6
      //   1010: ifeq +57 -> 1067
      //   1013: ldc 123
      //   1015: ldc 190
      //   1017: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1020: pop
      //   1021: aload_0
      //   1022: getfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   1025: invokevirtual 194	com/baidu/platform/comapi/map/g$f:b	()Z
      //   1028: ifne +803 -> 1831
      //   1031: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1034: astore 23
      //   1036: aload 23
      //   1038: monitorenter
      //   1039: aload_0
      //   1040: iconst_1
      //   1041: putfield 167	com/baidu/platform/comapi/map/g$g:f	Z
      //   1044: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1047: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1050: aload 23
      //   1052: monitorexit
      //   1053: iload_1
      //   1054: istore 11
      //   1056: goto +442 -> 1498
      //   1059: astore 21
      //   1061: aload 23
      //   1063: monitorexit
      //   1064: aload 21
      //   1066: athrow
      //   1067: iload 5
      //   1069: ifeq +768 -> 1837
      //   1072: aload_0
      //   1073: getfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   1076: invokevirtual 197	com/baidu/platform/comapi/map/g$f:a	()Ljavax/microedition/khronos/opengles/GL;
      //   1079: checkcast 199	javax/microedition/khronos/opengles/GL10
      //   1082: astore 21
      //   1084: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1087: aload 21
      //   1089: invokevirtual 202	com/baidu/platform/comapi/map/g$h:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1092: iconst_0
      //   1093: istore 5
      //   1095: goto +3 -> 1098
      //   1098: iload_2
      //   1099: ifeq +58 -> 1157
      //   1102: ldc 123
      //   1104: ldc 204
      //   1106: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1109: pop
      //   1110: aload_0
      //   1111: getfield 54	com/baidu/platform/comapi/map/g$g:s	Ljava/lang/ref/WeakReference;
      //   1114: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1117: checkcast 6	com/baidu/platform/comapi/map/g
      //   1120: astore 23
      //   1122: aload 23
      //   1124: ifnull +28 -> 1152
      //   1127: aload 23
      //   1129: invokestatic 207	com/baidu/platform/comapi/map/g:a	(Lcom/baidu/platform/comapi/map/g;)Lcom/baidu/platform/comapi/map/b0;
      //   1132: aconst_null
      //   1133: aload 23
      //   1135: invokevirtual 213	android/view/TextureView:getWidth	()I
      //   1138: aload 23
      //   1140: invokevirtual 216	android/view/TextureView:getHeight	()I
      //   1143: iconst_0
      //   1144: invokeinterface 221 5 0
      //   1149: goto +3 -> 1152
      //   1152: iconst_0
      //   1153: istore_2
      //   1154: goto +3 -> 1157
      //   1157: iload 4
      //   1159: istore 6
      //   1161: iload 4
      //   1163: ifeq +97 -> 1260
      //   1166: new 102	java/lang/StringBuilder
      //   1169: dup
      //   1170: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   1173: astore 23
      //   1175: aload 23
      //   1177: ldc 223
      //   1179: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1182: pop
      //   1183: aload 23
      //   1185: iload 10
      //   1187: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1190: pop
      //   1191: aload 23
      //   1193: ldc 228
      //   1195: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1198: pop
      //   1199: aload 23
      //   1201: iload 9
      //   1203: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1206: pop
      //   1207: aload 23
      //   1209: ldc 230
      //   1211: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1214: pop
      //   1215: ldc 123
      //   1217: aload 23
      //   1219: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1222: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1225: pop
      //   1226: aload_0
      //   1227: getfield 54	com/baidu/platform/comapi/map/g$g:s	Ljava/lang/ref/WeakReference;
      //   1230: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1233: checkcast 6	com/baidu/platform/comapi/map/g
      //   1236: astore 23
      //   1238: aload 23
      //   1240: ifnull +600 -> 1840
      //   1243: aload 23
      //   1245: invokestatic 207	com/baidu/platform/comapi/map/g:a	(Lcom/baidu/platform/comapi/map/g;)Lcom/baidu/platform/comapi/map/b0;
      //   1248: iload 10
      //   1250: iload 9
      //   1252: invokeinterface 233 3 0
      //   1257: goto +583 -> 1840
      //   1260: invokestatic 238	java/lang/System:currentTimeMillis	()J
      //   1263: lstore 17
      //   1265: aload_0
      //   1266: getfield 54	com/baidu/platform/comapi/map/g$g:s	Ljava/lang/ref/WeakReference;
      //   1269: invokevirtual 144	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1272: checkcast 6	com/baidu/platform/comapi/map/g
      //   1275: astore 23
      //   1277: aload 23
      //   1279: ifnull +567 -> 1846
      //   1282: aload 23
      //   1284: invokestatic 207	com/baidu/platform/comapi/map/g:a	(Lcom/baidu/platform/comapi/map/g;)Lcom/baidu/platform/comapi/map/b0;
      //   1287: aload 21
      //   1289: invokeinterface 241 2 0
      //   1294: aload 23
      //   1296: invokevirtual 244	com/baidu/platform/comapi/map/g:getFPS	()I
      //   1299: istore 4
      //   1301: goto +3 -> 1304
      //   1304: aload_0
      //   1305: getfield 68	com/baidu/platform/comapi/map/g$g:r	Lcom/baidu/platform/comapi/map/g$f;
      //   1308: invokevirtual 246	com/baidu/platform/comapi/map/g$f:g	()I
      //   1311: istore 12
      //   1313: iload 12
      //   1315: sipush 12288
      //   1318: if_icmpeq +535 -> 1853
      //   1321: iload 12
      //   1323: sipush 12302
      //   1326: if_icmpeq +45 -> 1371
      //   1329: ldc 123
      //   1331: ldc 248
      //   1333: iload 12
      //   1335: invokestatic 251	com/baidu/platform/comapi/map/g$f:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1338: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1341: astore 23
      //   1343: aload 23
      //   1345: monitorenter
      //   1346: aload_0
      //   1347: iconst_1
      //   1348: putfield 167	com/baidu/platform/comapi/map/g$g:f	Z
      //   1351: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1354: invokevirtual 100	java/lang/Object:notifyAll	()V
      //   1357: aload 23
      //   1359: monitorexit
      //   1360: goto +493 -> 1853
      //   1363: astore 21
      //   1365: aload 23
      //   1367: monitorexit
      //   1368: aload 21
      //   1370: athrow
      //   1371: new 102	java/lang/StringBuilder
      //   1374: dup
      //   1375: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   1378: astore 23
      //   1380: aload 23
      //   1382: ldc 253
      //   1384: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1387: pop
      //   1388: aload 23
      //   1390: aload_0
      //   1391: invokevirtual 118	java/lang/Thread:getId	()J
      //   1394: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1397: pop
      //   1398: ldc 123
      //   1400: aload 23
      //   1402: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1405: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   1408: pop
      //   1409: iconst_1
      //   1410: istore_3
      //   1411: goto +442 -> 1853
      //   1414: invokestatic 238	java/lang/System:currentTimeMillis	()J
      //   1417: lstore 19
      //   1419: iload 4
      //   1421: bipush 60
      //   1423: if_icmpge +60 -> 1483
      //   1426: iload 4
      //   1428: ifle +55 -> 1483
      //   1431: sipush 1000
      //   1434: iload 4
      //   1436: idiv
      //   1437: i2l
      //   1438: lload 19
      //   1440: lload 17
      //   1442: lsub
      //   1443: lsub
      //   1444: lstore 17
      //   1446: lload 17
      //   1448: lconst_1
      //   1449: lcmp
      //   1450: ifle +33 -> 1483
      //   1453: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1456: astore 23
      //   1458: aload 23
      //   1460: monitorenter
      //   1461: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1464: lload 17
      //   1466: invokevirtual 257	java/lang/Object:wait	(J)V
      //   1469: aload 23
      //   1471: monitorexit
      //   1472: goto +11 -> 1483
      //   1475: astore 21
      //   1477: aload 23
      //   1479: monitorexit
      //   1480: aload 21
      //   1482: athrow
      //   1483: iload 11
      //   1485: istore 12
      //   1487: iload_1
      //   1488: istore 11
      //   1490: iload 6
      //   1492: istore 4
      //   1494: iload 12
      //   1496: istore 6
      //   1498: iload 6
      //   1500: istore_1
      //   1501: goto -1431 -> 70
      //   1504: iload 8
      //   1506: istore_1
      //   1507: iload 6
      //   1509: istore 5
      //   1511: iload_3
      //   1512: istore 4
      //   1514: goto +3 -> 1517
      //   1517: new 102	java/lang/StringBuilder
      //   1520: dup
      //   1521: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   1524: astore 24
      //   1526: aload 24
      //   1528: ldc_w 259
      //   1531: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1534: pop
      //   1535: aload 24
      //   1537: aload_0
      //   1538: invokevirtual 118	java/lang/Thread:getId	()J
      //   1541: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1544: pop
      //   1545: aload 24
      //   1547: ldc_w 261
      //   1550: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1553: pop
      //   1554: aload 24
      //   1556: aload_0
      //   1557: getfield 70	com/baidu/platform/comapi/map/g$g:h	Z
      //   1560: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1563: pop
      //   1564: aload 24
      //   1566: ldc_w 263
      //   1569: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1572: pop
      //   1573: aload 24
      //   1575: aload_0
      //   1576: getfield 72	com/baidu/platform/comapi/map/g$g:i	Z
      //   1579: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1582: pop
      //   1583: aload 24
      //   1585: ldc_w 265
      //   1588: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1591: pop
      //   1592: aload 24
      //   1594: aload_0
      //   1595: getfield 93	com/baidu/platform/comapi/map/g$g:d	Z
      //   1598: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1601: pop
      //   1602: aload 24
      //   1604: ldc_w 267
      //   1607: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1610: pop
      //   1611: aload 24
      //   1613: aload_0
      //   1614: getfield 161	com/baidu/platform/comapi/map/g$g:e	Z
      //   1617: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1620: pop
      //   1621: aload 24
      //   1623: ldc_w 269
      //   1626: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1629: pop
      //   1630: aload 24
      //   1632: aload_0
      //   1633: getfield 167	com/baidu/platform/comapi/map/g$g:f	Z
      //   1636: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1639: pop
      //   1640: aload 24
      //   1642: ldc_w 271
      //   1645: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1648: pop
      //   1649: aload 24
      //   1651: aload_0
      //   1652: getfield 163	com/baidu/platform/comapi/map/g$g:g	Z
      //   1655: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1658: pop
      //   1659: aload 24
      //   1661: ldc_w 273
      //   1664: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1667: pop
      //   1668: aload 24
      //   1670: aload_0
      //   1671: getfield 46	com/baidu/platform/comapi/map/g$g:k	I
      //   1674: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1677: pop
      //   1678: aload 24
      //   1680: ldc_w 275
      //   1683: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1686: pop
      //   1687: aload 24
      //   1689: aload_0
      //   1690: getfield 48	com/baidu/platform/comapi/map/g$g:l	I
      //   1693: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1696: pop
      //   1697: aload 24
      //   1699: ldc_w 277
      //   1702: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1705: pop
      //   1706: aload 24
      //   1708: aload_0
      //   1709: getfield 50	com/baidu/platform/comapi/map/g$g:n	Z
      //   1712: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1715: pop
      //   1716: aload 24
      //   1718: ldc_w 279
      //   1721: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1724: pop
      //   1725: aload 24
      //   1727: aload_0
      //   1728: getfield 52	com/baidu/platform/comapi/map/g$g:m	I
      //   1731: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1734: pop
      //   1735: ldc 123
      //   1737: aload 24
      //   1739: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1742: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   1745: pop
      //   1746: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1749: invokevirtual 281	java/lang/Object:wait	()V
      //   1752: iload 11
      //   1754: istore_3
      //   1755: iload 13
      //   1757: istore 8
      //   1759: iload 12
      //   1761: istore 14
      //   1763: goto -1681 -> 82
      //   1766: astore 21
      //   1768: aload 23
      //   1770: monitorexit
      //   1771: aload 21
      //   1773: athrow
      //   1774: astore 22
      //   1776: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   1779: astore 21
      //   1781: aload 21
      //   1783: monitorenter
      //   1784: aload_0
      //   1785: invokespecial 79	com/baidu/platform/comapi/map/g$g:k	()V
      //   1788: aload_0
      //   1789: invokespecial 81	com/baidu/platform/comapi/map/g$g:j	()V
      //   1792: aload 21
      //   1794: monitorexit
      //   1795: aload 22
      //   1797: athrow
      //   1798: astore 22
      //   1800: aload 21
      //   1802: monitorexit
      //   1803: aload 22
      //   1805: athrow
      //   1806: iconst_0
      //   1807: istore 15
      //   1809: goto -1567 -> 242
      //   1812: iconst_0
      //   1813: istore_3
      //   1814: goto -1389 -> 425
      //   1817: goto -986 -> 831
      //   1820: iload 8
      //   1822: istore 14
      //   1824: iload 13
      //   1826: istore 8
      //   1828: goto -870 -> 958
      //   1831: iconst_0
      //   1832: istore 11
      //   1834: goto -767 -> 1067
      //   1837: goto -739 -> 1098
      //   1840: iconst_0
      //   1841: istore 6
      //   1843: goto -583 -> 1260
      //   1846: bipush 60
      //   1848: istore 4
      //   1850: goto -546 -> 1304
      //   1853: iload 8
      //   1855: ifeq -441 -> 1414
      //   1858: iconst_1
      //   1859: istore_1
      //   1860: goto -446 -> 1414
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1863	0	this	g
      //   46	1814	1	i1	int
      //   26	1128	2	i2	int
      //   36	1778	3	i3	int
      //   38	1811	4	i4	int
      //   32	1478	5	i5	int
      //   28	1814	6	i6	int
      //   48	730	7	i7	int
      //   42	1812	8	i8	int
      //   56	1195	9	i9	int
      //   52	1197	10	i10	int
      //   65	1768	11	i11	int
      //   695	1065	12	i12	int
      //   691	1134	13	i13	int
      //   80	1743	14	i14	int
      //   162	1646	15	bool1	boolean
      //   156	181	16	bool2	boolean
      //   1263	202	17	l1	long
      //   1417	22	19	l2	long
      //   59	56	21	localh1	g.h
      //   819	10	21	localRuntimeException	RuntimeException
      //   1059	6	21	localObject1	Object
      //   1082	206	21	localGL10	GL10
      //   1363	6	21	localObject2	Object
      //   1475	6	21	localObject3	Object
      //   1766	6	21	localObject4	Object
      //   1779	22	21	localh2	g.h
      //   62	1	22	localObject5	Object
      //   112	6	22	localObject6	Object
      //   141	854	22	localRunnable	Runnable
      //   1774	22	22	localObject7	Object
      //   1798	6	22	localObject8	Object
      //   73	1696	23	localObject9	Object
      //   190	1548	24	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   100	111	112	finally
      //   114	117	112	finally
      //   796	803	819	java/lang/RuntimeException
      //   1039	1053	1059	finally
      //   1061	1064	1059	finally
      //   1346	1360	1363	finally
      //   1365	1368	1363	finally
      //   1461	1472	1475	finally
      //   1477	1480	1475	finally
      //   82	92	1766	finally
      //   120	143	1766	finally
      //   152	164	1766	finally
      //   171	183	1766	finally
      //   183	239	1766	finally
      //   242	248	1766	finally
      //   253	304	1766	finally
      //   314	322	1766	finally
      //   330	336	1766	finally
      //   341	383	1766	finally
      //   388	407	1766	finally
      //   412	420	1766	finally
      //   429	438	1766	finally
      //   438	442	1766	finally
      //   442	480	1766	finally
      //   485	501	1766	finally
      //   501	539	1766	finally
      //   539	552	1766	finally
      //   557	606	1766	finally
      //   606	622	1766	finally
      //   622	635	1766	finally
      //   640	689	1766	finally
      //   702	751	1766	finally
      //   757	771	1766	finally
      //   782	791	1766	finally
      //   796	803	1766	finally
      //   803	814	1766	finally
      //   821	831	1766	finally
      //   841	848	1766	finally
      //   858	870	1766	finally
      //   878	904	1766	finally
      //   904	947	1766	finally
      //   958	969	1766	finally
      //   986	989	1766	finally
      //   1517	1752	1766	finally
      //   1768	1771	1766	finally
      //   70	78	1774	finally
      //   994	1001	1774	finally
      //   1013	1039	1774	finally
      //   1064	1067	1774	finally
      //   1072	1092	1774	finally
      //   1102	1122	1774	finally
      //   1127	1149	1774	finally
      //   1166	1238	1774	finally
      //   1243	1257	1774	finally
      //   1260	1277	1774	finally
      //   1282	1301	1774	finally
      //   1304	1313	1774	finally
      //   1329	1346	1774	finally
      //   1368	1371	1774	finally
      //   1371	1409	1774	finally
      //   1414	1419	1774	finally
      //   1431	1446	1774	finally
      //   1453	1461	1774	finally
      //   1480	1483	1774	finally
      //   1771	1774	1774	finally
      //   1784	1795	1798	finally
      //   1800	1803	1798	finally
    }
    
    private boolean f()
    {
      boolean bool2 = this.d;
      boolean bool1 = true;
      if ((!bool2) && (this.e) && (!this.f) && (this.k > 0) && (this.l > 0))
      {
        if (this.n) {
          return bool1;
        }
        if (this.m == 1) {
          return true;
        }
      }
      bool1 = false;
      return bool1;
    }
    
    private void j()
    {
      if (this.h)
      {
        this.r.e();
        this.h = false;
        g.a().a(this);
      }
    }
    
    private void k()
    {
      if (this.i)
      {
        this.i = false;
        this.r.c();
      }
    }
    
    public void a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= 1)) {
        synchronized (g.a())
        {
          this.m = paramInt;
          g.a().notifyAll();
          return;
        }
      }
      throw new IllegalArgumentException("renderMode");
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        this.k = paramInt1;
        this.l = paramInt2;
        this.q = true;
        this.n = true;
        this.o = false;
        g.a().notifyAll();
        while ((!this.b) && (!this.d) && (!this.o))
        {
          boolean bool = a();
          if (!bool) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onWindowResize waiting for render complete from tid=");
          localStringBuilder.append(getId());
          Log.i("Main thread", localStringBuilder.toString());
          try
          {
            g.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label118:
            break label118;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable != null) {
        synchronized (g.a())
        {
          this.p.add(paramRunnable);
          g.a().notifyAll();
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
        int i1 = this.m;
        return i1;
      }
    }
    
    public void d()
    {
      synchronized ()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPause tid=");
        localStringBuilder.append(getId());
        Log.i("GLThread", localStringBuilder.toString());
        this.c = true;
        g.a().notifyAll();
        while ((!this.b) && (!this.d))
        {
          Log.i("Main thread", "onPause waiting for mPaused.");
          try
          {
            g.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label85:
            break label85;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume tid=");
        localStringBuilder.append(getId());
        Log.i("GLThread", localStringBuilder.toString());
        this.c = false;
        this.n = true;
        this.o = false;
        g.a().notifyAll();
        while ((!this.b) && (this.d) && (!this.o))
        {
          Log.i("Main thread", "onResume waiting for !mPaused.");
          try
          {
            g.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label102:
            break label102;
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
        g.a().notifyAll();
        for (;;)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            g.a().wait();
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
      this.j = true;
      g.a().notifyAll();
    }
    
    public void i()
    {
      synchronized ()
      {
        this.n = true;
        g.a().notifyAll();
        return;
      }
    }
    
    public void l()
    {
      synchronized ()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("surfaceCreated tid=");
        localStringBuilder.append(getId());
        Log.i("GLThread", localStringBuilder.toString());
        this.e = true;
        g.a().notifyAll();
        while (this.g)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            g.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label77:
            break label77;
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void m()
    {
      synchronized ()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("surfaceDestroyed tid=");
        localStringBuilder.append(getId());
        Log.i("GLThread", localStringBuilder.toString());
        this.e = false;
        g.a().notifyAll();
        while (!this.g)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            g.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label77:
            break label77;
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
      //   0: new 102	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   7: astore_1
      //   8: aload_1
      //   9: ldc_w 327
      //   12: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: pop
      //   16: aload_1
      //   17: aload_0
      //   18: invokevirtual 118	java/lang/Thread:getId	()J
      //   21: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   24: pop
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   30: invokevirtual 330	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   33: new 102	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   40: astore_1
      //   41: aload_1
      //   42: ldc_w 332
      //   45: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: pop
      //   49: aload_1
      //   50: aload_0
      //   51: invokevirtual 118	java/lang/Thread:getId	()J
      //   54: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   57: pop
      //   58: ldc 123
      //   60: aload_1
      //   61: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   64: invokestatic 132	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   67: pop
      //   68: aload_0
      //   69: invokespecial 333	com/baidu/platform/comapi/map/g$g:c	()V
      //   72: goto +13 -> 85
      //   75: astore_1
      //   76: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   79: aload_0
      //   80: invokevirtual 335	com/baidu/platform/comapi/map/g$h:b	(Lcom/baidu/platform/comapi/map/g$g;)V
      //   83: aload_1
      //   84: athrow
      //   85: invokestatic 75	com/baidu/platform/comapi/map/g:a	()Lcom/baidu/platform/comapi/map/g$h;
      //   88: aload_0
      //   89: invokevirtual 335	com/baidu/platform/comapi/map/g$h:b	(Lcom/baidu/platform/comapi/map/g$g;)V
      //   92: return
      //   93: astore_1
      //   94: goto -9 -> 85
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	97	0	this	g
      //   7	54	1	localStringBuilder	StringBuilder
      //   75	9	1	localObject	Object
      //   93	1	1	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   68	72	75	finally
      //   68	72	93	java/lang/InterruptedException
    }
  }
  
  private static class h
  {
    private static String g = "GLThreadManager";
    private static final Class h;
    private static final Method i;
    private boolean a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private g.g f;
    
    static
    {
      try
      {
        Object localObject = Class.forName("android.os.SystemProperties");
        h = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
        i = (Method)localObject;
        ((Method)localObject).setAccessible(true);
        return;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    
    private void a()
    {
      if (!this.a) {}
      try
      {
        this.b = ((Integer)i.invoke(null, new Object[] { "ro.opengles.version", Integer.valueOf(0) })).intValue();
      }
      catch (Exception localException)
      {
        label43:
        String str;
        StringBuilder localStringBuilder;
        break label43;
      }
      this.b = 65536;
      if (this.b >= 131072) {
        this.d = true;
      }
      str = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkGLESVersion mGLESVersion = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" mMultipleGLESContextsAllowed = ");
      localStringBuilder.append(this.d);
      Log.w(str, localStringBuilder.toString());
      this.a = true;
    }
    
    public void a(g.g paramg)
    {
      if (this.f == paramg) {
        this.f = null;
      }
      notifyAll();
    }
    
    public void a(GL10 paramGL10)
    {
      try
      {
        if (!this.c)
        {
          a();
          paramGL10 = paramGL10.glGetString(7937);
          if (this.b < 131072)
          {
            this.d = (paramGL10.startsWith("Q3Dimension MSM7500 ") ^ true);
            notifyAll();
          }
          this.e = (this.d ^ true);
          String str = g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkGLDriver renderer = \"");
          localStringBuilder.append(paramGL10);
          localStringBuilder.append("\" multipleContextsAllowed = ");
          localStringBuilder.append(this.d);
          localStringBuilder.append(" mLimitedGLESContexts = ");
          localStringBuilder.append(this.e);
          Log.w(str, localStringBuilder.toString());
          this.c = true;
        }
        return;
      }
      finally {}
    }
    
    public void b(g.g paramg)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exiting tid=");
        localStringBuilder.append(paramg.getId());
        Log.i("GLThread", localStringBuilder.toString());
        g.g.a(paramg, true);
        if (this.f == paramg) {
          this.f = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public boolean b()
    {
      try
      {
        boolean bool = this.e;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public boolean c()
    {
      try
      {
        a();
        boolean bool = this.d;
        return bool ^ true;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public boolean c(g.g paramg)
    {
      g.g localg = this.f;
      if ((localg != paramg) && (localg != null))
      {
        a();
        if (this.d) {
          return true;
        }
        paramg = this.f;
        if (paramg != null) {
          paramg.h();
        }
        return false;
      }
      this.f = paramg;
      notifyAll();
      return true;
    }
  }
  
  static class i
    extends Writer
  {
    private StringBuilder a = new StringBuilder();
    
    private void a()
    {
      if (this.a.length() > 0)
      {
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
  
  private class j
    extends g.c
  {
    public j(boolean paramBoolean)
    {
      super(8, 8, 8, 0, i, 0);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.g
 * JD-Core Version:    0.7.0.1
 */