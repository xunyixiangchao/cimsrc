package com.yalantis.ucrop.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;

public class EglUtils
{
  private static final String TAG = "EglUtils";
  
  @TargetApi(14)
  private static int getMaxTextureEgl10()
  {
    EGL10 localEGL10 = (EGL10)javax.microedition.khronos.egl.EGLContext.getEGL();
    javax.microedition.khronos.egl.EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    Object localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if (localObject2[0] == 0) {
      return 0;
    }
    localObject2 = localObject1[0];
    localObject1 = localEGL10.eglCreatePbufferSurface(localEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject2, new int[] { 12375, 64, 12374, 64, 12344 });
    localObject2 = localEGL10.eglCreateContext(localEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject2, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 1, 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, (javax.microedition.khronos.egl.EGLSurface)localObject1, (javax.microedition.khronos.egl.EGLSurface)localObject1, (javax.microedition.khronos.egl.EGLContext)localObject2);
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    javax.microedition.khronos.egl.EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroySurface(localEGLDisplay, (javax.microedition.khronos.egl.EGLSurface)localObject1);
    localEGL10.eglDestroyContext(localEGLDisplay, (javax.microedition.khronos.egl.EGLContext)localObject2);
    localEGL10.eglTerminate(localEGLDisplay);
    return arrayOfInt[0];
  }
  
  @TargetApi(17)
  private static int getMaxTextureEgl14()
  {
    android.opengl.EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(localEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new android.opengl.EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if (localObject2[0] == 0) {
      return 0;
    }
    localObject2 = localObject1[0];
    localObject1 = EGL14.eglCreatePbufferSurface(localEGLDisplay, (android.opengl.EGLConfig)localObject2, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    localObject2 = EGL14.eglCreateContext(localEGLDisplay, (android.opengl.EGLConfig)localObject2, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    EGL14.eglMakeCurrent(localEGLDisplay, (android.opengl.EGLSurface)localObject1, (android.opengl.EGLSurface)localObject1, (android.opengl.EGLContext)localObject2);
    int[] arrayOfInt = new int[1];
    GLES20.glGetIntegerv(3379, arrayOfInt, 0);
    android.opengl.EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
    EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
    EGL14.eglDestroySurface(localEGLDisplay, (android.opengl.EGLSurface)localObject1);
    EGL14.eglDestroyContext(localEGLDisplay, (android.opengl.EGLContext)localObject2);
    EGL14.eglTerminate(localEGLDisplay);
    return arrayOfInt[0];
  }
  
  public static int getMaxTextureSize()
  {
    try
    {
      int i = getMaxTextureEgl14();
      return i;
    }
    catch (Exception localException)
    {
      Log.d("EglUtils", "getMaxTextureSize: ", localException);
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.util.EglUtils
 * JD-Core Version:    0.7.0.1
 */