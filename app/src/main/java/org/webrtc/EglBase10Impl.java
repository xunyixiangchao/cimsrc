package org.webrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class EglBase10Impl
  implements EglBase10
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final String TAG = "EglBase10Impl";
  private final EGL10 egl = (EGL10)EGLContext.getEGL();
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface = EGL10.EGL_NO_SURFACE;
  
  public EglBase10Impl(EGLContext paramEGLContext, int[] paramArrayOfInt)
  {
    EGLDisplay localEGLDisplay = getEglDisplay();
    this.eglDisplay = localEGLDisplay;
    this.eglConfig = getEglConfig(localEGLDisplay, paramArrayOfInt);
    int i = g.k(paramArrayOfInt);
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("Using OpenGL ES version ");
    paramArrayOfInt.append(i);
    Logging.d("EglBase10Impl", paramArrayOfInt.toString());
    this.eglContext = createEglContext(paramEGLContext, this.eglDisplay, this.eglConfig, i);
  }
  
  private void checkIsNotReleased()
  {
    if ((this.eglDisplay != EGL10.EGL_NO_DISPLAY) && (this.eglContext != EGL10.EGL_NO_CONTEXT) && (this.eglConfig != null)) {
      return;
    }
    throw new RuntimeException("This object has been released");
  }
  
  private EGLContext createEglContext(EGLContext arg1, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    if ((??? != null) && (??? == EGL10.EGL_NO_CONTEXT)) {
      throw new RuntimeException("Invalid sharedContext");
    }
    EGLContext localEGLContext = ???;
    if (??? == null) {
      localEGLContext = EGL10.EGL_NO_CONTEXT;
    }
    synchronized (EglBase.lock)
    {
      paramEGLDisplay = this.egl.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, new int[] { 12440, paramInt, 12344 });
      if (paramEGLDisplay != EGL10.EGL_NO_CONTEXT) {
        return paramEGLDisplay;
      }
      ??? = new StringBuilder();
      ???.append("Failed to create EGL context: 0x");
      ???.append(Integer.toHexString(this.egl.eglGetError()));
      throw new RuntimeException(???.toString());
    }
  }
  
  private void createSurfaceInternal(Object paramObject)
  {
    if ((!(paramObject instanceof SurfaceHolder)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
    }
    checkIsNotReleased();
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
    {
      paramObject = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, paramObject, new int[] { 12344 });
      this.eglSurface = paramObject;
      if (paramObject != EGL10.EGL_NO_SURFACE) {
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("Failed to create window surface: 0x");
      paramObject.append(Integer.toHexString(this.egl.eglGetError()));
      throw new RuntimeException(paramObject.toString());
    }
    throw new RuntimeException("Already has an EGLSurface");
  }
  
  private EGLConfig getEglConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (this.egl.eglChooseConfig(paramEGLDisplay, paramArrayOfInt, arrayOfEGLConfig, 1, arrayOfInt))
    {
      if (arrayOfInt[0] > 0)
      {
        paramEGLDisplay = arrayOfEGLConfig[0];
        if (paramEGLDisplay != null) {
          return paramEGLDisplay;
        }
        throw new RuntimeException("eglChooseConfig returned null");
      }
      throw new RuntimeException("Unable to find any matching EGL config");
    }
    paramEGLDisplay = new StringBuilder();
    paramEGLDisplay.append("eglChooseConfig failed: 0x");
    paramEGLDisplay.append(Integer.toHexString(this.egl.eglGetError()));
    throw new RuntimeException(paramEGLDisplay.toString());
  }
  
  private EGLDisplay getEglDisplay()
  {
    Object localObject = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (localObject != EGL10.EGL_NO_DISPLAY)
    {
      int[] arrayOfInt = new int[2];
      if (this.egl.eglInitialize((EGLDisplay)localObject, arrayOfInt)) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to initialize EGL10: 0x");
      ((StringBuilder)localObject).append(Integer.toHexString(this.egl.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to get EGL10 display: 0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.egl.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public void createDummyPbufferSurface()
  {
    createPbufferSurface(1, 1);
  }
  
  public void createPbufferSurface(int paramInt1, int paramInt2)
  {
    checkIsNotReleased();
    if (this.eglSurface == EGL10.EGL_NO_SURFACE)
    {
      Object localObject = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
      this.eglSurface = ((EGLSurface)localObject);
      if (localObject != EGL10.EGL_NO_SURFACE) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to create pixel buffer surface with size ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(": 0x");
      ((StringBuilder)localObject).append(Integer.toHexString(this.egl.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    throw new RuntimeException("Already has an EGLSurface");
  }
  
  public void createSurface(SurfaceTexture paramSurfaceTexture)
  {
    createSurfaceInternal(paramSurfaceTexture);
  }
  
  public void createSurface(Surface paramSurface)
  {
    createSurfaceInternal(new SurfaceHolder()
    {
      private final Surface surface;
      
      public void addCallback(SurfaceHolder.Callback paramAnonymousCallback) {}
      
      public Surface getSurface()
      {
        return this.surface;
      }
      
      public Rect getSurfaceFrame()
      {
        return null;
      }
      
      public boolean isCreating()
      {
        return false;
      }
      
      public Canvas lockCanvas()
      {
        return null;
      }
      
      public Canvas lockCanvas(Rect paramAnonymousRect)
      {
        return null;
      }
      
      public void removeCallback(SurfaceHolder.Callback paramAnonymousCallback) {}
      
      public void setFixedSize(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void setFormat(int paramAnonymousInt) {}
      
      public void setKeepScreenOn(boolean paramAnonymousBoolean) {}
      
      public void setSizeFromLayout() {}
      
      @Deprecated
      public void setType(int paramAnonymousInt) {}
      
      public void unlockCanvasAndPost(Canvas paramAnonymousCanvas) {}
    });
  }
  
  public void detachCurrent()
  {
    synchronized (EglBase.lock)
    {
      Object localObject2 = this.egl;
      EGLDisplay localEGLDisplay = this.eglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      if (((EGL10)localObject2).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT)) {
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("eglDetachCurrent failed: 0x");
      ((StringBuilder)localObject2).append(Integer.toHexString(this.egl.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject2).toString());
    }
  }
  
  public EglBase.Context getEglBaseContext()
  {
    return new Context(this.eglContext);
  }
  
  public boolean hasSurface()
  {
    return this.eglSurface != EGL10.EGL_NO_SURFACE;
  }
  
  public void makeCurrent()
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
      synchronized (EglBase.lock)
      {
        Object localObject2 = this.egl;
        EGLDisplay localEGLDisplay = this.eglDisplay;
        EGLSurface localEGLSurface = this.eglSurface;
        if (((EGL10)localObject2).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.eglContext)) {
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("eglMakeCurrent failed: 0x");
        ((StringBuilder)localObject2).append(Integer.toHexString(this.egl.eglGetError()));
        throw new RuntimeException(((StringBuilder)localObject2).toString());
      }
    }
    throw new RuntimeException("No EGLSurface - can't make current");
  }
  
  public void release()
  {
    checkIsNotReleased();
    releaseSurface();
    detachCurrent();
    this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
    this.egl.eglTerminate(this.eglDisplay);
    this.eglContext = EGL10.EGL_NO_CONTEXT;
    this.eglDisplay = EGL10.EGL_NO_DISPLAY;
    this.eglConfig = null;
  }
  
  public void releaseSurface()
  {
    EGLSurface localEGLSurface = this.eglSurface;
    if (localEGLSurface != EGL10.EGL_NO_SURFACE)
    {
      this.egl.eglDestroySurface(this.eglDisplay, localEGLSurface);
      this.eglSurface = EGL10.EGL_NO_SURFACE;
    }
  }
  
  public int surfaceHeight()
  {
    int[] arrayOfInt = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, arrayOfInt);
    return arrayOfInt[0];
  }
  
  public int surfaceWidth()
  {
    int[] arrayOfInt = new int[1];
    this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, arrayOfInt);
    return arrayOfInt[0];
  }
  
  public void swapBuffers()
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
      synchronized (EglBase.lock)
      {
        this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        return;
      }
    }
    throw new RuntimeException("No EGLSurface - can't swap buffers");
  }
  
  public void swapBuffers(long paramLong)
  {
    swapBuffers();
  }
  
  private static class Context
    implements EglBase10.Context
  {
    private final EGLContext eglContext;
    
    public Context(EGLContext paramEGLContext)
    {
      this.eglContext = paramEGLContext;
    }
    
    public long getNativeEglContext()
    {
      return 0L;
    }
    
    public EGLContext getRawContext()
    {
      return this.eglContext;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglBase10Impl
 * JD-Core Version:    0.7.0.1
 */