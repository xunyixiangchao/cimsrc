package com.farsunset.hoxin.common.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class TextureVideoView
  extends TextureView
  implements MediaController.MediaPlayerControl
{
  private Uri a;
  private Map<String, String> b;
  private int c;
  private int d = 0;
  private Surface e = null;
  private MediaPlayer f = null;
  private int g;
  private int h = 0;
  private int i = 0;
  private final MediaPlayer.OnVideoSizeChangedListener j = new a();
  private MediaController k;
  private MediaPlayer.OnCompletionListener l;
  private MediaPlayer.OnPreparedListener m;
  private int n;
  private MediaPlayer.OnErrorListener o;
  private MediaPlayer.OnInfoListener p;
  private int q;
  private boolean r;
  private boolean s;
  private boolean t;
  private final MediaPlayer.OnPreparedListener u = new b();
  private boolean v = true;
  private final MediaPlayer.OnCompletionListener w = new c();
  private final MediaPlayer.OnInfoListener x = new d();
  private final MediaPlayer.OnErrorListener y = new e();
  private final MediaPlayer.OnBufferingUpdateListener z = new f();
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(new g());
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.c = 0;
    this.d = 0;
  }
  
  private void A(boolean paramBoolean)
  {
    MediaPlayer localMediaPlayer = this.f;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.reset();
      this.f.release();
      this.f = null;
      this.c = 0;
      if (paramBoolean) {
        this.d = 0;
      }
      if (this.v) {
        ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
      }
    }
  }
  
  private void B(Uri paramUri, Map<String, String> paramMap)
  {
    this.a = paramUri;
    this.b = paramMap;
    this.q = 0;
    z();
    requestLayout();
    invalidate();
  }
  
  private void D()
  {
    if (this.k.isShowing())
    {
      this.k.hide();
      return;
    }
    this.k.show();
  }
  
  private void w()
  {
    if (this.f != null)
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        ((MediaController)localObject).setMediaPlayer(this);
        if ((getParent() instanceof View)) {
          localObject = (View)getParent();
        } else {
          localObject = this;
        }
        this.k.setAnchorView((View)localObject);
        this.k.setEnabled(y());
      }
    }
  }
  
  private void x()
  {
    if (this.e != null)
    {
      EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
      EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      localEGL10.eglInitialize(localEGLDisplay, null);
      Object localObject1 = new EGLConfig[1];
      Object localObject2 = new int[1];
      localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject1, 1, (int[])localObject2);
      localObject2 = localObject1[0];
      localObject1 = localEGL10.eglCreateContext(localEGLDisplay, (EGLConfig)localObject2, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      localObject2 = localEGL10.eglCreateWindowSurface(localEGLDisplay, (EGLConfig)localObject2, this.e, new int[] { 12344 });
      localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject2, (EGLSurface)localObject2, (EGLContext)localObject1);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      localEGL10.eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject2);
      localEGL10.eglDestroySurface(localEGLDisplay, (EGLSurface)localObject2);
      localObject2 = EGL10.EGL_NO_SURFACE;
      localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject2, (EGLSurface)localObject2, EGL10.EGL_NO_CONTEXT);
      localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject1);
      localEGL10.eglTerminate(localEGLDisplay);
    }
  }
  
  private boolean y()
  {
    if (this.f != null)
    {
      int i1 = this.c;
      if ((i1 != -1) && (i1 != 0) && (i1 != 1)) {
        return true;
      }
    }
    return false;
  }
  
  private void z()
  {
    if (this.a != null)
    {
      if (this.e == null) {
        return;
      }
      A(false);
      if (this.v) {
        ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
      }
    }
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.f = localMediaPlayer;
      localMediaPlayer.setAudioStreamType(3);
      int i1 = this.g;
      if (i1 != 0) {
        this.f.setAudioSessionId(i1);
      } else {
        this.g = this.f.getAudioSessionId();
      }
      this.f.setOnPreparedListener(this.u);
      this.f.setOnVideoSizeChangedListener(this.j);
      this.f.setOnCompletionListener(this.w);
      this.f.setOnErrorListener(this.y);
      this.f.setOnInfoListener(this.x);
      this.f.setOnBufferingUpdateListener(this.z);
      this.n = 0;
      this.f.setDataSource(getContext().getApplicationContext(), this.a, this.b);
      this.f.setSurface(this.e);
      this.f.setAudioStreamType(3);
      this.f.setScreenOnWhilePlaying(true);
      this.f.prepareAsync();
      this.c = 1;
      w();
      return;
    }
    catch (IOException|IllegalArgumentException localIOException)
    {
      label235:
      break label235;
    }
    this.c = -1;
    this.d = -1;
    this.y.onError(this.f, 1, 0);
  }
  
  public void C()
  {
    MediaPlayer localMediaPlayer = this.f;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.f.release();
      this.f = null;
      this.c = 0;
      this.d = 0;
      if (this.v) {
        ((AudioManager)getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    x();
  }
  
  public boolean canPause()
  {
    return this.r;
  }
  
  public boolean canSeekBackward()
  {
    return this.s;
  }
  
  public boolean canSeekForward()
  {
    return this.t;
  }
  
  public int getAudioSessionId()
  {
    if (this.g == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.g = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.g;
  }
  
  public int getBufferPercentage()
  {
    if (this.f != null) {
      return this.n;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (y()) {
      return this.f.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (y()) {
      return this.f.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (y()) && (this.f.isPlaying());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextureVideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 164) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((y()) && (i1 != 0) && (this.k != null)) {
      if ((paramInt != 79) && (paramInt != 85))
      {
        if (paramInt == 126)
        {
          if (!this.f.isPlaying())
          {
            start();
            this.k.hide();
          }
          return true;
        }
        if ((paramInt != 86) && (paramInt != 127))
        {
          D();
        }
        else
        {
          if (this.f.isPlaying())
          {
            pause();
            this.k.show();
          }
          return true;
        }
      }
      else
      {
        if (this.f.isPlaying())
        {
          pause();
          this.k.show();
          return true;
        }
        start();
        this.k.hide();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = TextureView.getDefaultSize(this.h, paramInt1);
    int i4 = TextureView.getDefaultSize(this.i, paramInt2);
    int i1 = i3;
    int i2 = i4;
    if (this.h > 0)
    {
      i1 = i3;
      i2 = i4;
      if (this.i > 0)
      {
        int i6 = View.MeasureSpec.getMode(paramInt1);
        i3 = View.MeasureSpec.getSize(paramInt1);
        i1 = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((i6 == 1073741824) && (i1 == 1073741824))
        {
          paramInt1 = this.h;
          i1 = this.i;
          if (paramInt1 * paramInt2 < i3 * i1)
          {
            paramInt1 = paramInt1 * paramInt2 / i1;
            break label234;
          }
          if (paramInt1 * paramInt2 <= i3 * i1) {
            break label224;
          }
          paramInt1 = i1 * i3 / paramInt1;
        }
        else
        {
          if (i6 != 1073741824) {
            break label179;
          }
          paramInt1 = this.i * i3 / this.h;
          if ((i1 == -2147483648) && (paramInt1 > paramInt2)) {
            break label224;
          }
        }
        for (;;)
        {
          i1 = i3;
          i2 = paramInt1;
          break;
          label179:
          if (i1 == 1073741824)
          {
            i2 = this.h * paramInt2 / this.i;
            i1 = i2;
            paramInt1 = paramInt2;
            if (i6 == -2147483648)
            {
              i1 = i2;
              paramInt1 = paramInt2;
              if (i2 > i3)
              {
                label224:
                paramInt1 = i3;
                break label234;
              }
            }
          }
          label234:
          int i5;
          do
          {
            do
            {
              paramInt2 = paramInt1;
              paramInt1 = i1;
              i1 = paramInt1;
              i2 = paramInt2;
              break;
              i4 = this.h;
              i5 = this.i;
              if ((i1 == -2147483648) && (i5 > paramInt2))
              {
                i2 = paramInt2 * i4 / i5;
              }
              else
              {
                i2 = i4;
                paramInt2 = i5;
              }
              i1 = i2;
              paramInt1 = paramInt2;
            } while (i6 != -2147483648);
            i1 = i2;
            paramInt1 = paramInt2;
          } while (i2 <= i3);
          paramInt1 = i5 * i3 / i4;
        }
      }
    }
    setMeasuredDimension(i1, i2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((y()) && (this.k != null)) {
      D();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((y()) && (this.k != null)) {
      D();
    }
    return false;
  }
  
  public void pause()
  {
    if ((y()) && (this.f.isPlaying()))
    {
      this.f.pause();
      this.c = 4;
    }
    this.d = 4;
  }
  
  public void seekTo(int paramInt)
  {
    int i1 = paramInt;
    if (y())
    {
      this.f.seekTo(paramInt);
      i1 = 0;
    }
    this.q = i1;
  }
  
  public void setMediaController(MediaController paramMediaController)
  {
    MediaController localMediaController = this.k;
    if (localMediaController != null) {
      localMediaController.hide();
    }
    this.k = paramMediaController;
    w();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.l = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.o = paramOnErrorListener;
  }
  
  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.p = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.m = paramOnPreparedListener;
  }
  
  public void setShouldRequestAudioFocus(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    B(paramUri, null);
  }
  
  public void start()
  {
    if (y())
    {
      this.f.start();
      this.c = 3;
    }
    this.d = 3;
  }
  
  class a
    implements MediaPlayer.OnVideoSizeChangedListener
  {
    a() {}
    
    public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      TextureVideoView.b(TextureVideoView.this, paramMediaPlayer.getVideoWidth());
      TextureVideoView.f(TextureVideoView.this, paramMediaPlayer.getVideoHeight());
      if ((TextureVideoView.a(TextureVideoView.this) != 0) && (TextureVideoView.c(TextureVideoView.this) != 0))
      {
        TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.a(TextureVideoView.this), TextureVideoView.c(TextureVideoView.this));
        TextureVideoView.this.requestLayout();
      }
    }
  }
  
  class b
    implements MediaPlayer.OnPreparedListener
  {
    b() {}
    
    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      TextureVideoView.o(TextureVideoView.this, 2);
      TextureVideoView localTextureVideoView = TextureVideoView.this;
      TextureVideoView.p(localTextureVideoView, TextureVideoView.q(localTextureVideoView, TextureVideoView.r(localTextureVideoView, true)));
      if (TextureVideoView.s(TextureVideoView.this) != null) {
        TextureVideoView.s(TextureVideoView.this).onPrepared(TextureVideoView.t(TextureVideoView.this));
      }
      if (TextureVideoView.u(TextureVideoView.this) != null) {
        TextureVideoView.u(TextureVideoView.this).setEnabled(true);
      }
      TextureVideoView.b(TextureVideoView.this, paramMediaPlayer.getVideoWidth());
      TextureVideoView.f(TextureVideoView.this, paramMediaPlayer.getVideoHeight());
      int i = TextureVideoView.v(TextureVideoView.this);
      if (i != 0) {
        TextureVideoView.this.seekTo(i);
      }
      if ((TextureVideoView.a(TextureVideoView.this) != 0) && (TextureVideoView.c(TextureVideoView.this) != 0))
      {
        TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.a(TextureVideoView.this), TextureVideoView.c(TextureVideoView.this));
        if (TextureVideoView.d(TextureVideoView.this) == 3)
        {
          TextureVideoView.this.start();
          if (TextureVideoView.u(TextureVideoView.this) != null) {
            TextureVideoView.u(TextureVideoView.this).show();
          }
        }
        else if ((!TextureVideoView.this.isPlaying()) && ((i != 0) || (TextureVideoView.this.getCurrentPosition() > 0)) && (TextureVideoView.u(TextureVideoView.this) != null))
        {
          TextureVideoView.u(TextureVideoView.this).show(0);
        }
      }
      else if (TextureVideoView.d(TextureVideoView.this) == 3)
      {
        TextureVideoView.this.start();
      }
    }
  }
  
  class c
    implements MediaPlayer.OnCompletionListener
  {
    c() {}
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      TextureVideoView.o(TextureVideoView.this, 5);
      TextureVideoView.e(TextureVideoView.this, 5);
      if (TextureVideoView.u(TextureVideoView.this) != null) {
        TextureVideoView.u(TextureVideoView.this).hide();
      }
      if (TextureVideoView.g(TextureVideoView.this) != null) {
        TextureVideoView.g(TextureVideoView.this).onCompletion(TextureVideoView.t(TextureVideoView.this));
      }
    }
  }
  
  class d
    implements MediaPlayer.OnInfoListener
  {
    d() {}
    
    public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      if (TextureVideoView.h(TextureVideoView.this) != null) {
        TextureVideoView.h(TextureVideoView.this).onInfo(paramMediaPlayer, paramInt1, paramInt2);
      }
      return true;
    }
  }
  
  class e
    implements MediaPlayer.OnErrorListener
  {
    e() {}
    
    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      TextureVideoView.o(TextureVideoView.this, -1);
      TextureVideoView.e(TextureVideoView.this, -1);
      if (TextureVideoView.u(TextureVideoView.this) != null) {
        TextureVideoView.u(TextureVideoView.this).hide();
      }
      if ((TextureVideoView.i(TextureVideoView.this) != null) && (TextureVideoView.i(TextureVideoView.this).onError(TextureVideoView.t(TextureVideoView.this), paramInt1, paramInt2))) {
        return true;
      }
      if (TextureVideoView.this.getWindowToken() != null)
      {
        if (paramInt1 == 200) {
          paramInt1 = 17039381;
        } else {
          paramInt1 = 17039377;
        }
        new AlertDialog.Builder(TextureVideoView.this.getContext()).setMessage(paramInt1).setPositiveButton(17039376, new b(this)).setCancelable(false).show();
      }
      return true;
    }
  }
  
  class f
    implements MediaPlayer.OnBufferingUpdateListener
  {
    f() {}
    
    public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
      TextureVideoView.j(TextureVideoView.this, paramInt);
    }
  }
  
  class g
    implements TextureView.SurfaceTextureListener
  {
    g() {}
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      TextureVideoView.l(TextureVideoView.this, new Surface(paramSurfaceTexture));
      TextureVideoView.m(TextureVideoView.this);
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      if (TextureVideoView.k(TextureVideoView.this) != null)
      {
        TextureVideoView.k(TextureVideoView.this).release();
        TextureVideoView.l(TextureVideoView.this, null);
      }
      if (TextureVideoView.u(TextureVideoView.this) != null) {
        TextureVideoView.u(TextureVideoView.this).hide();
      }
      TextureVideoView.n(TextureVideoView.this, true);
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      int i = TextureVideoView.d(TextureVideoView.this);
      int j = 1;
      if (i == 3) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        paramInt1 = j;
      } else {
        paramInt1 = 0;
      }
      if ((TextureVideoView.t(TextureVideoView.this) != null) && (i != 0) && (paramInt1 != 0))
      {
        if (TextureVideoView.v(TextureVideoView.this) != 0)
        {
          paramSurfaceTexture = TextureVideoView.this;
          paramSurfaceTexture.seekTo(TextureVideoView.v(paramSurfaceTexture));
        }
        TextureVideoView.this.start();
      }
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.TextureVideoView
 * JD-Core Version:    0.7.0.1
 */