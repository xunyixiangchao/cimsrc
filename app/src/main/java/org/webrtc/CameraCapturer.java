package org.webrtc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

abstract class CameraCapturer
  implements CameraVideoCapturer
{
  private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
  private static final int OPEN_CAMERA_DELAY_MS = 500;
  private static final int OPEN_CAMERA_TIMEOUT = 10000;
  private static final String TAG = "CameraCapturer";
  private Context applicationContext;
  private final CameraEnumerator cameraEnumerator;
  private String cameraName;
  private final CameraSession.Events cameraSessionEventsHandler = new CameraSession.Events()
  {
    public void onCameraClosed(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if ((paramAnonymousCameraSession != CameraCapturer.this.currentSession) && (CameraCapturer.this.currentSession != null))
        {
          Logging.d("CameraCapturer", "onCameraClosed from another session.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraClosed();
        return;
      }
    }
    
    public void onCameraDisconnected(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          Logging.w("CameraCapturer", "onCameraDisconnected from another session.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraDisconnected();
        CameraCapturer.this.stopCapture();
        return;
      }
    }
    
    public void onCameraError(CameraSession paramAnonymousCameraSession, String paramAnonymousString)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          paramAnonymousCameraSession = new StringBuilder();
          paramAnonymousCameraSession.append("onCameraError from another session: ");
          paramAnonymousCameraSession.append(paramAnonymousString);
          Logging.w("CameraCapturer", paramAnonymousCameraSession.toString());
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraError(paramAnonymousString);
        CameraCapturer.this.stopCapture();
        return;
      }
    }
    
    public void onCameraOpening()
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (CameraCapturer.this.currentSession != null)
        {
          Logging.w("CameraCapturer", "onCameraOpening while session was open.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraOpening(CameraCapturer.this.cameraName);
        return;
      }
    }
    
    public void onFrameCaptured(CameraSession paramAnonymousCameraSession, VideoFrame paramAnonymousVideoFrame)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          Logging.w("CameraCapturer", "onFrameCaptured from another session.");
          return;
        }
        if (!CameraCapturer.this.firstFrameObserved)
        {
          CameraCapturer.this.eventsHandler.onFirstFrameAvailable();
          CameraCapturer.access$1102(CameraCapturer.this, true);
        }
        CameraCapturer.this.cameraStatistics.addFrame();
        CameraCapturer.this.capturerObserver.onFrameCaptured(paramAnonymousVideoFrame);
        return;
      }
    }
  };
  private CameraVideoCapturer.CameraStatistics cameraStatistics;
  private Handler cameraThreadHandler;
  private CapturerObserver capturerObserver;
  private final CameraSession.CreateSessionCallback createSessionCallback = new CameraSession.CreateSessionCallback()
  {
    public void onDone(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Create session done. Switch state: ");
      ((StringBuilder)???).append(CameraCapturer.this.switchState);
      Logging.d("CameraCapturer", ((StringBuilder)???).toString());
      CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
      synchronized (CameraCapturer.this.stateLock)
      {
        CameraCapturer.this.capturerObserver.onCapturerStarted(true);
        CameraCapturer.access$602(CameraCapturer.this, false);
        CameraCapturer.access$702(CameraCapturer.this, paramAnonymousCameraSession);
        paramAnonymousCameraSession = CameraCapturer.this;
        CameraCapturer.access$802(paramAnonymousCameraSession, new CameraVideoCapturer.CameraStatistics(paramAnonymousCameraSession.surfaceHelper, CameraCapturer.this.eventsHandler));
        CameraCapturer.access$1102(CameraCapturer.this, false);
        CameraCapturer.this.stateLock.notifyAll();
        if (CameraCapturer.this.switchState == CameraCapturer.SwitchState.IN_PROGRESS)
        {
          CameraCapturer.access$102(CameraCapturer.this, CameraCapturer.SwitchState.IDLE);
          if (CameraCapturer.this.switchEventsHandler != null)
          {
            CameraCapturer.this.switchEventsHandler.onCameraSwitchDone(CameraCapturer.this.cameraEnumerator.isFrontFacing(CameraCapturer.this.cameraName));
            CameraCapturer.access$1202(CameraCapturer.this, null);
          }
        }
        else if (CameraCapturer.this.switchState == CameraCapturer.SwitchState.PENDING)
        {
          paramAnonymousCameraSession = CameraCapturer.this.pendingCameraName;
          CameraCapturer.access$1502(CameraCapturer.this, null);
          CameraCapturer.access$102(CameraCapturer.this, CameraCapturer.SwitchState.IDLE);
          CameraCapturer localCameraCapturer = CameraCapturer.this;
          localCameraCapturer.switchCameraInternal(localCameraCapturer.switchEventsHandler, paramAnonymousCameraSession);
        }
        return;
      }
    }
    
    public void onFailure(CameraSession.FailureType paramAnonymousFailureType, String paramAnonymousString)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
      synchronized (CameraCapturer.this.stateLock)
      {
        CameraCapturer.this.capturerObserver.onCapturerStarted(false);
        CameraCapturer.access$1710(CameraCapturer.this);
        if (CameraCapturer.this.openAttemptsRemaining <= 0)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Opening camera failed, passing: ");
          ((StringBuilder)localObject2).append(paramAnonymousString);
          Logging.w("CameraCapturer", ((StringBuilder)localObject2).toString());
          CameraCapturer.access$602(CameraCapturer.this, false);
          CameraCapturer.this.stateLock.notifyAll();
          localObject2 = CameraCapturer.this.switchState;
          CameraCapturer.SwitchState localSwitchState = CameraCapturer.SwitchState.IDLE;
          if (localObject2 != localSwitchState)
          {
            if (CameraCapturer.this.switchEventsHandler != null)
            {
              CameraCapturer.this.switchEventsHandler.onCameraSwitchError(paramAnonymousString);
              CameraCapturer.access$1202(CameraCapturer.this, null);
            }
            CameraCapturer.access$102(CameraCapturer.this, localSwitchState);
          }
          if (paramAnonymousFailureType == CameraSession.FailureType.DISCONNECTED) {
            CameraCapturer.this.eventsHandler.onCameraDisconnected();
          } else {
            CameraCapturer.this.eventsHandler.onCameraError(paramAnonymousString);
          }
        }
        else
        {
          paramAnonymousFailureType = new StringBuilder();
          paramAnonymousFailureType.append("Opening camera failed, retry: ");
          paramAnonymousFailureType.append(paramAnonymousString);
          Logging.w("CameraCapturer", paramAnonymousFailureType.toString());
          CameraCapturer.this.createSessionInternal(500);
        }
        return;
      }
    }
  };
  private CameraSession currentSession;
  private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
  private boolean firstFrameObserved;
  private int framerate;
  private int height;
  private int openAttemptsRemaining;
  private final Runnable openCameraTimeoutRunnable = new Runnable()
  {
    public void run()
    {
      CameraCapturer.this.eventsHandler.onCameraError("Camera failed to start within timeout.");
    }
  };
  private String pendingCameraName;
  private boolean sessionOpening;
  private final Object stateLock = new Object();
  private SurfaceTextureHelper surfaceHelper;
  private CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
  private SwitchState switchState = SwitchState.IDLE;
  private final Handler uiThreadHandler;
  private int width;
  
  public CameraCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler, CameraEnumerator paramCameraEnumerator)
  {
    Object localObject = paramCameraEventsHandler;
    if (paramCameraEventsHandler == null) {
      localObject = new CameraVideoCapturer.CameraEventsHandler()
      {
        public void onCameraClosed() {}
        
        public void onCameraDisconnected() {}
        
        public void onCameraError(String paramAnonymousString) {}
        
        public void onCameraFreezed(String paramAnonymousString) {}
        
        public void onCameraOpening(String paramAnonymousString) {}
        
        public void onFirstFrameAvailable() {}
      };
    }
    this.eventsHandler = ((CameraVideoCapturer.CameraEventsHandler)localObject);
    this.cameraEnumerator = paramCameraEnumerator;
    this.cameraName = paramString;
    paramString = Arrays.asList(paramCameraEnumerator.getDeviceNames());
    this.uiThreadHandler = new Handler(Looper.getMainLooper());
    if (!paramString.isEmpty())
    {
      if (paramString.contains(this.cameraName)) {
        return;
      }
      paramString = new StringBuilder();
      paramString.append("Camera name ");
      paramString.append(this.cameraName);
      paramString.append(" does not match any known camera device.");
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new RuntimeException("No cameras attached.");
  }
  
  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
      return;
    }
    Logging.e("CameraCapturer", "Check is on camera thread failed.");
    throw new RuntimeException("Not on camera thread.");
  }
  
  private void createSessionInternal(int paramInt)
  {
    this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, paramInt + 10000);
    this.cameraThreadHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        CameraCapturer localCameraCapturer = CameraCapturer.this;
        localCameraCapturer.createCameraSession(localCameraCapturer.createSessionCallback, CameraCapturer.this.cameraSessionEventsHandler, CameraCapturer.this.applicationContext, CameraCapturer.this.surfaceHelper, CameraCapturer.this.cameraName, CameraCapturer.this.width, CameraCapturer.this.height, CameraCapturer.this.framerate);
      }
    }, paramInt);
  }
  
  private void reportCameraSwitchError(String paramString, CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler)
  {
    Logging.e("CameraCapturer", paramString);
    if (paramCameraSwitchHandler != null) {
      paramCameraSwitchHandler.onCameraSwitchError(paramString);
    }
  }
  
  private void switchCameraInternal(final CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler, String paramString)
  {
    Logging.d("CameraCapturer", "switchCamera internal");
    if (!Arrays.asList(this.cameraEnumerator.getDeviceNames()).contains(paramString))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Attempted to switch to unknown camera device ");
      ((StringBuilder)???).append(paramString);
      reportCameraSwitchError(((StringBuilder)???).toString(), paramCameraSwitchHandler);
      return;
    }
    synchronized (this.stateLock)
    {
      if (this.switchState != SwitchState.IDLE)
      {
        reportCameraSwitchError("Camera switch already in progress.", paramCameraSwitchHandler);
        return;
      }
      boolean bool = this.sessionOpening;
      if ((!bool) && (this.currentSession == null))
      {
        reportCameraSwitchError("switchCamera: camera is not running.", paramCameraSwitchHandler);
        return;
      }
      this.switchEventsHandler = paramCameraSwitchHandler;
      if (bool)
      {
        this.switchState = SwitchState.PENDING;
        this.pendingCameraName = paramString;
        return;
      }
      this.switchState = SwitchState.IN_PROGRESS;
      Logging.d("CameraCapturer", "switchCamera: Stopping session");
      this.cameraStatistics.release();
      this.cameraStatistics = null;
      paramCameraSwitchHandler = this.currentSession;
      this.cameraThreadHandler.post(new Runnable()
      {
        public void run()
        {
          paramCameraSwitchHandler.stop();
        }
      });
      this.currentSession = null;
      this.cameraName = paramString;
      this.sessionOpening = true;
      this.openAttemptsRemaining = 1;
      createSessionInternal(0);
      Logging.d("CameraCapturer", "switchCamera done");
      return;
    }
  }
  
  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("changeCaptureFormat: ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append("x");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append("@");
    ((StringBuilder)???).append(paramInt3);
    Logging.d("CameraCapturer", ((StringBuilder)???).toString());
    synchronized (this.stateLock)
    {
      stopCapture();
      startCapture(paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  protected abstract void createCameraSession(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public void dispose()
  {
    Logging.d("CameraCapturer", "dispose");
    stopCapture();
  }
  
  protected String getCameraName()
  {
    synchronized (this.stateLock)
    {
      String str = this.cameraName;
      return str;
    }
  }
  
  public void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    this.applicationContext = paramContext;
    this.capturerObserver = paramCapturerObserver;
    this.surfaceHelper = paramSurfaceTextureHelper;
    this.cameraThreadHandler = paramSurfaceTextureHelper.getHandler();
  }
  
  public boolean isScreencast()
  {
    return false;
  }
  
  public void printStackTrace()
  {
    Object localObject = this.cameraThreadHandler;
    if (localObject != null) {
      localObject = ((Handler)localObject).getLooper().getThread();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((Thread)localObject).getStackTrace();
      if (localObject.length > 0)
      {
        Logging.d("CameraCapturer", "CameraCapturer stack trace:");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          Logging.d("CameraCapturer", localObject[i].toString());
          i += 1;
        }
      }
    }
  }
  
  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("startCapture: ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append("x");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append("@");
    ((StringBuilder)???).append(paramInt3);
    Logging.d("CameraCapturer", ((StringBuilder)???).toString());
    if (this.applicationContext != null) {
      synchronized (this.stateLock)
      {
        if ((!this.sessionOpening) && (this.currentSession == null))
        {
          this.width = paramInt1;
          this.height = paramInt2;
          this.framerate = paramInt3;
          this.sessionOpening = true;
          this.openAttemptsRemaining = 3;
          createSessionInternal(0);
          return;
        }
        Logging.w("CameraCapturer", "Session already open");
        return;
      }
    }
    throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
  }
  
  public void stopCapture()
  {
    Logging.d("CameraCapturer", "Stop capture");
    synchronized (this.stateLock)
    {
      for (;;)
      {
        if (!this.sessionOpening) {
          break label57;
        }
        Logging.d("CameraCapturer", "Stop capture: Waiting for session to open");
        try
        {
          this.stateLock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label40:
          label57:
          final CameraSession localCameraSession;
          break label40;
        }
      }
      Logging.w("CameraCapturer", "Stop capture interrupted while waiting for the session to open.");
      Thread.currentThread().interrupt();
      return;
      if (this.currentSession != null)
      {
        Logging.d("CameraCapturer", "Stop capture: Nulling session");
        this.cameraStatistics.release();
        this.cameraStatistics = null;
        localCameraSession = this.currentSession;
        this.cameraThreadHandler.post(new Runnable()
        {
          public void run()
          {
            localCameraSession.stop();
          }
        });
        this.currentSession = null;
        this.capturerObserver.onCapturerStopped();
      }
      else
      {
        Logging.d("CameraCapturer", "Stop capture: No session open");
      }
      Logging.d("CameraCapturer", "Stop capture done");
      return;
    }
  }
  
  public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler)
  {
    Logging.d("CameraCapturer", "switchCamera");
    this.cameraThreadHandler.post(new Runnable()
    {
      public void run()
      {
        Object localObject = Arrays.asList(CameraCapturer.this.cameraEnumerator.getDeviceNames());
        if (((List)localObject).size() < 2)
        {
          CameraCapturer.this.reportCameraSwitchError("No camera to switch to.", paramCameraSwitchHandler);
          return;
        }
        localObject = (String)((List)localObject).get((((List)localObject).indexOf(CameraCapturer.this.cameraName) + 1) % ((List)localObject).size());
        CameraCapturer.this.switchCameraInternal(paramCameraSwitchHandler, (String)localObject);
      }
    });
  }
  
  public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler, final String paramString)
  {
    Logging.d("CameraCapturer", "switchCamera");
    this.cameraThreadHandler.post(new Runnable()
    {
      public void run()
      {
        CameraCapturer.this.switchCameraInternal(paramCameraSwitchHandler, paramString);
      }
    });
  }
  
  static enum SwitchState
  {
    static
    {
      SwitchState localSwitchState1 = new SwitchState("IDLE", 0);
      IDLE = localSwitchState1;
      SwitchState localSwitchState2 = new SwitchState("PENDING", 1);
      PENDING = localSwitchState2;
      SwitchState localSwitchState3 = new SwitchState("IN_PROGRESS", 2);
      IN_PROGRESS = localSwitchState3;
      $VALUES = new SwitchState[] { localSwitchState1, localSwitchState2, localSwitchState3 };
    }
    
    private SwitchState() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CameraCapturer
 * JD-Core Version:    0.7.0.1
 */