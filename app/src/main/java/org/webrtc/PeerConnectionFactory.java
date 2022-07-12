package org.webrtc;

import android.content.Context;
import android.os.Process;
import java.util.List;
import java.util.Objects;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule.Builder;

public class PeerConnectionFactory
{
  private static final String TAG = "PeerConnectionFactory";
  public static final String TRIAL_ENABLED = "Enabled";
  private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";
  @Deprecated
  public static final String VIDEO_FRAME_EMIT_TRIAL = "VideoFrameEmit";
  private static volatile boolean internalTracerInitialized;
  private static ThreadInfo staticNetworkThread;
  private static ThreadInfo staticSignalingThread;
  private static ThreadInfo staticWorkerThread;
  private long nativeFactory;
  private volatile ThreadInfo networkThread;
  private volatile ThreadInfo signalingThread;
  private volatile ThreadInfo workerThread;
  
  @CalledByNative
  PeerConnectionFactory(long paramLong)
  {
    checkInitializeHasBeenCalled();
    if (paramLong != 0L)
    {
      this.nativeFactory = paramLong;
      return;
    }
    throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private static void checkInitializeHasBeenCalled()
  {
    if ((NativeLibrary.isLoaded()) && (ContextUtils.getApplicationContext() != null)) {
      return;
    }
    throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
  }
  
  private void checkPeerConnectionFactoryExists()
  {
    if (this.nativeFactory != 0L) {
      return;
    }
    throw new IllegalStateException("PeerConnectionFactory has been disposed.");
  }
  
  public static String fieldTrialsFindFullName(String paramString)
  {
    if (NativeLibrary.isLoaded()) {
      return nativeFindFieldTrialsFullName(paramString);
    }
    return "";
  }
  
  public static void initialize(InitializationOptions paramInitializationOptions)
  {
    ContextUtils.initialize(paramInitializationOptions.applicationContext);
    NativeLibrary.initialize(paramInitializationOptions.nativeLibraryLoader, paramInitializationOptions.nativeLibraryName);
    nativeInitializeAndroidGlobals();
    nativeInitializeFieldTrials(paramInitializationOptions.fieldTrials);
    if ((paramInitializationOptions.enableInternalTracer) && (!internalTracerInitialized)) {
      initializeInternalTracer();
    }
    Loggable localLoggable = paramInitializationOptions.loggable;
    if (localLoggable != null)
    {
      Logging.injectLoggable(localLoggable, paramInitializationOptions.loggableSeverity);
      nativeInjectLoggable(new JNILogging(paramInitializationOptions.loggable), paramInitializationOptions.loggableSeverity.ordinal());
      return;
    }
    Logging.d("PeerConnectionFactory", "PeerConnectionFactory was initialized without an injected Loggable. Any existing Loggable will be deleted.");
    Logging.deleteInjectedLoggable();
    nativeDeleteLoggable();
  }
  
  @Deprecated
  public static void initializeFieldTrials(String paramString)
  {
    nativeInitializeFieldTrials(paramString);
  }
  
  private static void initializeInternalTracer()
  {
    internalTracerInitialized = true;
    nativeInitializeInternalTracer();
  }
  
  private static native long nativeCreateAudioSource(long paramLong, MediaConstraints paramMediaConstraints);
  
  private static native long nativeCreateAudioTrack(long paramLong1, String paramString, long paramLong2);
  
  private static native long nativeCreateLocalMediaStream(long paramLong, String paramString);
  
  private static native long nativeCreatePeerConnection(long paramLong1, PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, long paramLong2, SSLCertificateVerifier paramSSLCertificateVerifier);
  
  private static native PeerConnectionFactory nativeCreatePeerConnectionFactory(Context paramContext, Options paramOptions, long paramLong1, long paramLong2, long paramLong3, VideoEncoderFactory paramVideoEncoderFactory, VideoDecoderFactory paramVideoDecoderFactory, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
  
  private static native long nativeCreateVideoSource(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native long nativeCreateVideoTrack(long paramLong1, String paramString, long paramLong2);
  
  private static native void nativeDeleteLoggable();
  
  private static native String nativeFindFieldTrialsFullName(String paramString);
  
  private static native void nativeFreeFactory(long paramLong);
  
  private static native long nativeGetNativePeerConnectionFactory(long paramLong);
  
  private static native void nativeInitializeAndroidGlobals();
  
  private static native void nativeInitializeFieldTrials(String paramString);
  
  private static native void nativeInitializeInternalTracer();
  
  private static native void nativeInjectLoggable(JNILogging paramJNILogging, int paramInt);
  
  private static native void nativePrintStackTrace(int paramInt);
  
  private static native void nativePrintStackTracesOfRegisteredThreads();
  
  private static native void nativeShutdownInternalTracer();
  
  private static native boolean nativeStartAecDump(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativeStartInternalTracingCapture(String paramString);
  
  private static native void nativeStopAecDump(long paramLong);
  
  private static native void nativeStopInternalTracingCapture();
  
  @CalledByNative
  private void onNetworkThreadReady()
  {
    this.networkThread = ThreadInfo.getCurrent();
    staticNetworkThread = this.networkThread;
    Logging.d("PeerConnectionFactory", "onNetworkThreadReady");
  }
  
  @CalledByNative
  private void onSignalingThreadReady()
  {
    this.signalingThread = ThreadInfo.getCurrent();
    staticSignalingThread = this.signalingThread;
    Logging.d("PeerConnectionFactory", "onSignalingThreadReady");
  }
  
  @CalledByNative
  private void onWorkerThreadReady()
  {
    this.workerThread = ThreadInfo.getCurrent();
    staticWorkerThread = this.workerThread;
    Logging.d("PeerConnectionFactory", "onWorkerThreadReady");
  }
  
  private static void printStackTrace(ThreadInfo paramThreadInfo, boolean paramBoolean)
  {
    if (paramThreadInfo == null) {
      return;
    }
    String str = paramThreadInfo.thread.getName();
    Object localObject = paramThreadInfo.thread.getStackTrace();
    if (localObject.length > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" stacktrace:");
      Logging.w("PeerConnectionFactory", localStringBuilder.toString());
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        Logging.w("PeerConnectionFactory", localObject[i].toString());
        i += 1;
      }
    }
    if (paramBoolean)
    {
      Logging.w("PeerConnectionFactory", "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pid: ");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append(", tid: ");
      ((StringBuilder)localObject).append(paramThreadInfo.tid);
      ((StringBuilder)localObject).append(", name: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  >>> WebRTC <<<");
      Logging.w("PeerConnectionFactory", ((StringBuilder)localObject).toString());
      nativePrintStackTrace(paramThreadInfo.tid);
    }
  }
  
  @Deprecated
  public static void printStackTraces()
  {
    printStackTrace(staticNetworkThread, false);
    printStackTrace(staticWorkerThread, false);
    printStackTrace(staticSignalingThread, false);
  }
  
  public static void shutdownInternalTracer()
  {
    internalTracerInitialized = false;
    nativeShutdownInternalTracer();
  }
  
  public static boolean startInternalTracingCapture(String paramString)
  {
    return nativeStartInternalTracingCapture(paramString);
  }
  
  public static void stopInternalTracingCapture() {}
  
  public AudioSource createAudioSource(MediaConstraints paramMediaConstraints)
  {
    checkPeerConnectionFactoryExists();
    return new AudioSource(nativeCreateAudioSource(this.nativeFactory, paramMediaConstraints));
  }
  
  public AudioTrack createAudioTrack(String paramString, AudioSource paramAudioSource)
  {
    checkPeerConnectionFactoryExists();
    return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, paramString, paramAudioSource.getNativeAudioSource()));
  }
  
  public MediaStream createLocalMediaStream(String paramString)
  {
    checkPeerConnectionFactoryExists();
    return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, paramString));
  }
  
  @Deprecated
  public PeerConnection createPeerConnection(List<PeerConnection.IceServer> paramList, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(new PeerConnection.RTCConfiguration(paramList), paramMediaConstraints, paramObserver);
  }
  
  public PeerConnection createPeerConnection(List<PeerConnection.IceServer> paramList, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(new PeerConnection.RTCConfiguration(paramList), paramObserver);
  }
  
  @Deprecated
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver)
  {
    return createPeerConnectionInternal(paramRTCConfiguration, paramMediaConstraints, paramObserver, null);
  }
  
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(paramRTCConfiguration, null, paramObserver);
  }
  
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, PeerConnectionDependencies paramPeerConnectionDependencies)
  {
    return createPeerConnectionInternal(paramRTCConfiguration, null, paramPeerConnectionDependencies.getObserver(), paramPeerConnectionDependencies.getSSLCertificateVerifier());
  }
  
  PeerConnection createPeerConnectionInternal(PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver, SSLCertificateVerifier paramSSLCertificateVerifier)
  {
    checkPeerConnectionFactoryExists();
    long l = PeerConnection.createNativePeerConnectionObserver(paramObserver);
    if (l == 0L) {
      return null;
    }
    l = nativeCreatePeerConnection(this.nativeFactory, paramRTCConfiguration, paramMediaConstraints, l, paramSSLCertificateVerifier);
    if (l == 0L) {
      return null;
    }
    return new PeerConnection(l);
  }
  
  public VideoSource createVideoSource(boolean paramBoolean)
  {
    return createVideoSource(paramBoolean, true);
  }
  
  public VideoSource createVideoSource(boolean paramBoolean1, boolean paramBoolean2)
  {
    checkPeerConnectionFactoryExists();
    return new VideoSource(nativeCreateVideoSource(this.nativeFactory, paramBoolean1, paramBoolean2));
  }
  
  public VideoTrack createVideoTrack(String paramString, VideoSource paramVideoSource)
  {
    checkPeerConnectionFactoryExists();
    return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, paramString, paramVideoSource.getNativeVideoTrackSource()));
  }
  
  public void dispose()
  {
    checkPeerConnectionFactoryExists();
    nativeFreeFactory(this.nativeFactory);
    this.networkThread = null;
    this.workerThread = null;
    this.signalingThread = null;
    this.nativeFactory = 0L;
  }
  
  public long getNativeOwnedFactoryAndThreads()
  {
    checkPeerConnectionFactoryExists();
    return this.nativeFactory;
  }
  
  public long getNativePeerConnectionFactory()
  {
    checkPeerConnectionFactoryExists();
    return nativeGetNativePeerConnectionFactory(this.nativeFactory);
  }
  
  public void printInternalStackTraces(boolean paramBoolean)
  {
    printStackTrace(this.signalingThread, paramBoolean);
    printStackTrace(this.workerThread, paramBoolean);
    printStackTrace(this.networkThread, paramBoolean);
    if (paramBoolean) {
      nativePrintStackTracesOfRegisteredThreads();
    }
  }
  
  public boolean startAecDump(int paramInt1, int paramInt2)
  {
    checkPeerConnectionFactoryExists();
    return nativeStartAecDump(this.nativeFactory, paramInt1, paramInt2);
  }
  
  public void stopAecDump()
  {
    checkPeerConnectionFactoryExists();
    nativeStopAecDump(this.nativeFactory);
  }
  
  public static class Builder
  {
    private AudioDecoderFactoryFactory audioDecoderFactoryFactory = new BuiltinAudioDecoderFactoryFactory();
    private AudioDeviceModule audioDeviceModule;
    private AudioEncoderFactoryFactory audioEncoderFactoryFactory = new BuiltinAudioEncoderFactoryFactory();
    private AudioProcessingFactory audioProcessingFactory;
    private FecControllerFactoryFactoryInterface fecControllerFactoryFactory;
    private NetEqFactoryFactory neteqFactoryFactory;
    private NetworkControllerFactoryFactory networkControllerFactoryFactory;
    private NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory;
    private PeerConnectionFactory.Options options;
    private VideoDecoderFactory videoDecoderFactory;
    private VideoEncoderFactory videoEncoderFactory;
    
    public PeerConnectionFactory createPeerConnectionFactory()
    {
      
      if (this.audioDeviceModule == null) {
        this.audioDeviceModule = JavaAudioDeviceModule.builder(ContextUtils.getApplicationContext()).createAudioDeviceModule();
      }
      Context localContext = ContextUtils.getApplicationContext();
      PeerConnectionFactory.Options localOptions = this.options;
      long l6 = this.audioDeviceModule.getNativeAudioDeviceModulePointer();
      long l7 = this.audioEncoderFactoryFactory.createNativeAudioEncoderFactory();
      long l8 = this.audioDecoderFactoryFactory.createNativeAudioDecoderFactory();
      VideoEncoderFactory localVideoEncoderFactory = this.videoEncoderFactory;
      VideoDecoderFactory localVideoDecoderFactory = this.videoDecoderFactory;
      Object localObject = this.audioProcessingFactory;
      long l5 = 0L;
      long l1;
      if (localObject == null) {
        l1 = 0L;
      } else {
        l1 = ((AudioProcessingFactory)localObject).createNative();
      }
      localObject = this.fecControllerFactoryFactory;
      long l2;
      if (localObject == null) {
        l2 = 0L;
      } else {
        l2 = ((FecControllerFactoryFactoryInterface)localObject).createNative();
      }
      localObject = this.networkControllerFactoryFactory;
      long l3;
      if (localObject == null) {
        l3 = 0L;
      } else {
        l3 = ((NetworkControllerFactoryFactory)localObject).createNativeNetworkControllerFactory();
      }
      localObject = this.networkStatePredictorFactoryFactory;
      long l4;
      if (localObject == null) {
        l4 = 0L;
      } else {
        l4 = ((NetworkStatePredictorFactoryFactory)localObject).createNativeNetworkStatePredictorFactory();
      }
      localObject = this.neteqFactoryFactory;
      if (localObject != null) {
        l5 = ((NetEqFactoryFactory)localObject).createNativeNetEqFactory();
      }
      return PeerConnectionFactory.nativeCreatePeerConnectionFactory(localContext, localOptions, l6, l7, l8, localVideoEncoderFactory, localVideoDecoderFactory, l1, l2, l3, l4, l5);
    }
    
    public Builder setAudioDecoderFactoryFactory(AudioDecoderFactoryFactory paramAudioDecoderFactoryFactory)
    {
      if (paramAudioDecoderFactoryFactory != null)
      {
        this.audioDecoderFactoryFactory = paramAudioDecoderFactoryFactory;
        return this;
      }
      throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioDecoderFactoryFactory.");
    }
    
    public Builder setAudioDeviceModule(AudioDeviceModule paramAudioDeviceModule)
    {
      this.audioDeviceModule = paramAudioDeviceModule;
      return this;
    }
    
    public Builder setAudioEncoderFactoryFactory(AudioEncoderFactoryFactory paramAudioEncoderFactoryFactory)
    {
      if (paramAudioEncoderFactoryFactory != null)
      {
        this.audioEncoderFactoryFactory = paramAudioEncoderFactoryFactory;
        return this;
      }
      throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioEncoderFactoryFactory.");
    }
    
    public Builder setAudioProcessingFactory(AudioProcessingFactory paramAudioProcessingFactory)
    {
      Objects.requireNonNull(paramAudioProcessingFactory, "PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
      this.audioProcessingFactory = paramAudioProcessingFactory;
      return this;
    }
    
    public Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface paramFecControllerFactoryFactoryInterface)
    {
      this.fecControllerFactoryFactory = paramFecControllerFactoryFactoryInterface;
      return this;
    }
    
    public Builder setNetEqFactoryFactory(NetEqFactoryFactory paramNetEqFactoryFactory)
    {
      this.neteqFactoryFactory = paramNetEqFactoryFactory;
      return this;
    }
    
    public Builder setNetworkControllerFactoryFactory(NetworkControllerFactoryFactory paramNetworkControllerFactoryFactory)
    {
      this.networkControllerFactoryFactory = paramNetworkControllerFactoryFactory;
      return this;
    }
    
    public Builder setNetworkStatePredictorFactoryFactory(NetworkStatePredictorFactoryFactory paramNetworkStatePredictorFactoryFactory)
    {
      this.networkStatePredictorFactoryFactory = paramNetworkStatePredictorFactoryFactory;
      return this;
    }
    
    public Builder setOptions(PeerConnectionFactory.Options paramOptions)
    {
      this.options = paramOptions;
      return this;
    }
    
    public Builder setVideoDecoderFactory(VideoDecoderFactory paramVideoDecoderFactory)
    {
      this.videoDecoderFactory = paramVideoDecoderFactory;
      return this;
    }
    
    public Builder setVideoEncoderFactory(VideoEncoderFactory paramVideoEncoderFactory)
    {
      this.videoEncoderFactory = paramVideoEncoderFactory;
      return this;
    }
  }
  
  public static class InitializationOptions
  {
    final Context applicationContext;
    final boolean enableInternalTracer;
    final String fieldTrials;
    Loggable loggable;
    Logging.Severity loggableSeverity;
    final NativeLibraryLoader nativeLibraryLoader;
    final String nativeLibraryName;
    
    private InitializationOptions(Context paramContext, String paramString1, boolean paramBoolean, NativeLibraryLoader paramNativeLibraryLoader, String paramString2, Loggable paramLoggable, Logging.Severity paramSeverity)
    {
      this.applicationContext = paramContext;
      this.fieldTrials = paramString1;
      this.enableInternalTracer = paramBoolean;
      this.nativeLibraryLoader = paramNativeLibraryLoader;
      this.nativeLibraryName = paramString2;
      this.loggable = paramLoggable;
      this.loggableSeverity = paramSeverity;
    }
    
    public static Builder builder(Context paramContext)
    {
      return new Builder(paramContext);
    }
    
    public static class Builder
    {
      private final Context applicationContext;
      private boolean enableInternalTracer;
      private String fieldTrials = "";
      private Loggable loggable;
      private Logging.Severity loggableSeverity;
      private NativeLibraryLoader nativeLibraryLoader = new NativeLibrary.DefaultLoader();
      private String nativeLibraryName = "jingle_peerconnection_so";
      
      Builder(Context paramContext)
      {
        this.applicationContext = paramContext;
      }
      
      public PeerConnectionFactory.InitializationOptions createInitializationOptions()
      {
        return new PeerConnectionFactory.InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity, null);
      }
      
      public Builder setEnableInternalTracer(boolean paramBoolean)
      {
        this.enableInternalTracer = paramBoolean;
        return this;
      }
      
      public Builder setFieldTrials(String paramString)
      {
        this.fieldTrials = paramString;
        return this;
      }
      
      public Builder setInjectableLogger(Loggable paramLoggable, Logging.Severity paramSeverity)
      {
        this.loggable = paramLoggable;
        this.loggableSeverity = paramSeverity;
        return this;
      }
      
      public Builder setNativeLibraryLoader(NativeLibraryLoader paramNativeLibraryLoader)
      {
        this.nativeLibraryLoader = paramNativeLibraryLoader;
        return this;
      }
      
      public Builder setNativeLibraryName(String paramString)
      {
        this.nativeLibraryName = paramString;
        return this;
      }
    }
  }
  
  public static class Options
  {
    static final int ADAPTER_TYPE_ANY = 32;
    static final int ADAPTER_TYPE_CELLULAR = 4;
    static final int ADAPTER_TYPE_ETHERNET = 1;
    static final int ADAPTER_TYPE_LOOPBACK = 16;
    static final int ADAPTER_TYPE_UNKNOWN = 0;
    static final int ADAPTER_TYPE_VPN = 8;
    static final int ADAPTER_TYPE_WIFI = 2;
    public boolean disableEncryption;
    public boolean disableNetworkMonitor;
    public int networkIgnoreMask;
    
    @CalledByNative("Options")
    boolean getDisableEncryption()
    {
      return this.disableEncryption;
    }
    
    @CalledByNative("Options")
    boolean getDisableNetworkMonitor()
    {
      return this.disableNetworkMonitor;
    }
    
    @CalledByNative("Options")
    int getNetworkIgnoreMask()
    {
      return this.networkIgnoreMask;
    }
  }
  
  private static class ThreadInfo
  {
    final Thread thread;
    final int tid;
    
    private ThreadInfo(Thread paramThread, int paramInt)
    {
      this.thread = paramThread;
      this.tid = paramInt;
    }
    
    public static ThreadInfo getCurrent()
    {
      return new ThreadInfo(Thread.currentThread(), Process.myTid());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.PeerConnectionFactory
 * JD-Core Version:    0.7.0.1
 */