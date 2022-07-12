package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.view.Surface;

@TargetApi(18)
class EglBase14Impl
  implements EglBase14
{
  private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
  private static final int EGLExt_SDK_VERSION = 18;
  private static final String TAG = "EglBase14Impl";
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface = EGL14.EGL_NO_SURFACE;
  
  public EglBase14Impl(EGLContext paramEGLContext, int[] paramArrayOfInt)
  {
    EGLDisplay localEGLDisplay = getEglDisplay();
    this.eglDisplay = localEGLDisplay;
    this.eglConfig = getEglConfig(localEGLDisplay, paramArrayOfInt);
    int i = g.k(paramArrayOfInt);
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("Using OpenGL ES version ");
    paramArrayOfInt.append(i);
    Logging.d("EglBase14Impl", paramArrayOfInt.toString());
    this.eglContext = createEglContext(paramEGLContext, this.eglDisplay, this.eglConfig, i);
  }
  
  private void checkIsNotReleased()
  {
    if ((this.eglDisplay != EGL14.EGL_NO_DISPLAY) && (this.eglContext != EGL14.EGL_NO_CONTEXT) && (this.eglConfig != null)) {
      return;
    }
    throw new RuntimeException("This object has been released");
  }
  
  private static EGLContext createEglContext(EGLContext arg0, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    if ((??? != null) && (??? == EGL14.EGL_NO_CONTEXT)) {
      throw new RuntimeException("Invalid sharedContext");
    }
    EGLContext localEGLContext = ???;
    if (??? == null) {
      localEGLContext = EGL14.EGL_NO_CONTEXT;
    }
    synchronized (EglBase.lock)
    {
      paramEGLDisplay = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, new int[] { 12440, paramInt, 12344 }, 0);
      if (paramEGLDisplay != EGL14.EGL_NO_CONTEXT) {
        return paramEGLDisplay;
      }
      ??? = new StringBuilder();
      ???.append("Failed to create EGL context: 0x");
      ???.append(Integer.toHexString(EGL14.eglGetError()));
      throw new RuntimeException(???.toString());
    }
  }
  
  private void createSurfaceInternal(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
    }
    checkIsNotReleased();
    if (this.eglSurface == EGL14.EGL_NO_SURFACE)
    {
      paramObject = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, paramObject, new int[] { 12344 }, 0);
      this.eglSurface = paramObject;
      if (paramObject != EGL14.EGL_NO_SURFACE) {
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("Failed to create window surface: 0x");
      paramObject.append(Integer.toHexString(EGL14.eglGetError()));
      throw new RuntimeException(paramObject.toString());
    }
    throw new RuntimeException("Already has an EGLSurface");
  }
  
  private static EGLConfig getEglConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (EGL14.eglChooseConfig(paramEGLDisplay, paramArrayOfInt, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0))
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
    paramEGLDisplay.append(Integer.toHexString(EGL14.eglGetError()));
    throw new RuntimeException(paramEGLDisplay.toString());
  }
  
  private static EGLDisplay getEglDisplay()
  {
    Object localObject = EGL14.eglGetDisplay(0);
    if (localObject != EGL14.EGL_NO_DISPLAY)
    {
      int[] arrayOfInt = new int[2];
      if (EGL14.eglInitialize((EGLDisplay)localObject, arrayOfInt, 0, arrayOfInt, 1)) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to initialize EGL14: 0x");
      ((StringBuilder)localObject).append(Integer.toHexString(EGL14.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to get EGL14 display: 0x");
    ((StringBuilder)localObject).append(Integer.toHexString(EGL14.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public static boolean isEGL14Supported()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK version: ");
    int i = CURRENT_SDK_VERSION;
    localStringBuilder.append(i);
    localStringBuilder.append(". isEGL14Supported: ");
    boolean bool;
    if (i >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    Logging.d("EglBase14Impl", localStringBuilder.toString());
    return i >= 18;
  }
  
  public void createDummyPbufferSurface()
  {
    createPbufferSurface(1, 1);
  }
  
  public void createPbufferSurface(int paramInt1, int paramInt2)
  {
    checkIsNotReleased();
    if (this.eglSurface == EGL14.EGL_NO_SURFACE)
    {
      Object localObject = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
      this.eglSurface = ((EGLSurface)localObject);
      if (localObject != EGL14.EGL_NO_SURFACE) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to create pixel buffer surface with size ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(": 0x");
      ((StringBuilder)localObject).append(Integer.toHexString(EGL14.eglGetError()));
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
    createSurfaceInternal(paramSurface);
  }
  
  public void detachCurrent()
  {
    synchronized (EglBase.lock)
    {
      Object localObject2 = this.eglDisplay;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      if (EGL14.eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT)) {
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("eglDetachCurrent failed: 0x");
      ((StringBuilder)localObject2).append(Integer.toHexString(EGL14.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject2).toString());
    }
  }
  
  public Context getEglBaseContext()
  {
    return new Context(this.eglContext);
  }
  
  public boolean hasSurface()
  {
    return this.eglSurface != EGL14.EGL_NO_SURFACE;
  }
  
  public void makeCurrent()
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
      synchronized (EglBase.lock)
      {
        Object localObject2 = this.eglDisplay;
        EGLSurface localEGLSurface = this.eglSurface;
        if (EGL14.eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.eglContext)) {
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("eglMakeCurrent failed: 0x");
        ((StringBuilder)localObject2).append(Integer.toHexString(EGL14.eglGetError()));
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
    synchronized (EglBase.lock)
    {
      EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.eglDisplay);
      this.eglContext = EGL14.EGL_NO_CONTEXT;
      this.eglDisplay = EGL14.EGL_NO_DISPLAY;
      this.eglConfig = null;
      return;
    }
  }
  
  public void releaseSurface()
  {
    EGLSurface localEGLSurface = this.eglSurface;
    if (localEGLSurface != EGL14.EGL_NO_SURFACE)
    {
      EGL14.eglDestroySurface(this.eglDisplay, localEGLSurface);
      this.eglSurface = EGL14.EGL_NO_SURFACE;
    }
  }
  
  public int surfaceHeight()
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public int surfaceWidth()
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public void swapBuffers()
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
      synchronized (EglBase.lock)
      {
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        return;
      }
    }
    throw new RuntimeException("No EGLSurface - can't swap buffers");
  }
  
  public void swapBuffers(long paramLong)
  {
    checkIsNotReleased();
    if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
      synchronized (EglBase.lock)
      {
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, paramLong);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        return;
      }
    }
    throw new RuntimeException("No EGLSurface - can't swap buffers");
  }
  
  public static class Context
    implements EglBase14.Context
  {
    private final EGLContext egl14Context;
    
    public Context(EGLContext paramEGLContext)
    {
      this.egl14Context = paramEGLContext;
    }
    
    @TargetApi(21)
    public long getNativeEglContext()
    {
      if (EglBase14Impl.CURRENT_SDK_VERSION >= 21) {
        return this.egl14Context.getNativeHandle();
      }
      return this.egl14Context.getHandle();
    }
    
    public EGLContext getRawContext()
    {
      return this.egl14Context;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EglBase14Impl
 * JD-Core Version:    0.7.0.1
 */