package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Process;
import java.nio.ByteBuffer;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.ThreadUtils.ThreadChecker;

class WebRtcAudioTrack
{
  private static final int AUDIO_TRACK_START = 0;
  private static final int AUDIO_TRACK_STOP = 1;
  private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final int DEFAULT_USAGE = ;
  private static final String TAG = "WebRtcAudioTrackExternal";
  private final AudioManager audioManager;
  private AudioTrackThread audioThread;
  private AudioTrack audioTrack;
  private ByteBuffer byteBuffer;
  private final Context context;
  private byte[] emptyBytes;
  private final JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
  private long nativeAudioTrack;
  private volatile boolean speakerMute;
  private final JavaAudioDeviceModule.AudioTrackStateCallback stateCallback;
  private final ThreadUtils.ThreadChecker threadChecker;
  private final VolumeLogger volumeLogger;
  
  @CalledByNative
  WebRtcAudioTrack(Context paramContext, AudioManager paramAudioManager)
  {
    this(paramContext, paramAudioManager, null, null);
  }
  
  WebRtcAudioTrack(Context paramContext, AudioManager paramAudioManager, JavaAudioDeviceModule.AudioTrackErrorCallback paramAudioTrackErrorCallback, JavaAudioDeviceModule.AudioTrackStateCallback paramAudioTrackStateCallback)
  {
    ThreadUtils.ThreadChecker localThreadChecker = new ThreadUtils.ThreadChecker();
    this.threadChecker = localThreadChecker;
    localThreadChecker.detachThread();
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.errorCallback = paramAudioTrackErrorCallback;
    this.stateCallback = paramAudioTrackStateCallback;
    this.volumeLogger = new VolumeLogger(paramAudioManager);
    paramContext = new StringBuilder();
    paramContext.append("ctor");
    paramContext.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioTrackExternal", paramContext.toString());
  }
  
  @CalledByNative
  private int GetPlayoutUnderrunCount()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      AudioTrack localAudioTrack = this.audioTrack;
      if (localAudioTrack != null) {
        return localAudioTrack.getUnderrunCount();
      }
      return -1;
    }
    return -2;
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError("Expected condition to be true");
  }
  
  private int channelCountToConfiguration(int paramInt)
  {
    if (paramInt == 1) {
      return 4;
    }
    return 12;
  }
  
  @TargetApi(21)
  private static AudioTrack createAudioTrackOnLollipopOrHigher(int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("WebRtcAudioTrackExternal", "createAudioTrackOnLollipopOrHigher");
    int i = AudioTrack.getNativeOutputSampleRate(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeOutputSampleRate: ");
    localStringBuilder.append(i);
    Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
    if (paramInt1 != i) {
      Logging.w("WebRtcAudioTrackExternal", "Unable to use fast mode since requested sample rate is not native");
    }
    return new AudioTrack(new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(paramInt1).setChannelMask(paramInt2).build(), paramInt3, 1, 0);
  }
  
  private static AudioTrack createAudioTrackOnLowerThanLollipop(int paramInt1, int paramInt2, int paramInt3)
  {
    return new AudioTrack(0, paramInt1, paramInt2, 2, paramInt3, 1);
  }
  
  private void doAudioTrackStateCallback(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAudioTrackStateCallback: ");
    ((StringBuilder)localObject).append(paramInt);
    Logging.d("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    localObject = this.stateCallback;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((JavaAudioDeviceModule.AudioTrackStateCallback)localObject).onWebRtcAudioTrackStart();
        return;
      }
      if (paramInt == 1)
      {
        ((JavaAudioDeviceModule.AudioTrackStateCallback)localObject).onWebRtcAudioTrackStop();
        return;
      }
      Logging.e("WebRtcAudioTrackExternal", "Invalid audio state");
    }
  }
  
  @CalledByNative
  private int getBufferSizeInFrames()
  {
    return this.audioTrack.getBufferSizeInFrames();
  }
  
  private static int getDefaultUsageAttribute()
  {
    return 2;
  }
  
  @CalledByNative
  private int getStreamMaxVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "getStreamMaxVolume");
    return this.audioManager.getStreamMaxVolume(0);
  }
  
  @CalledByNative
  private int getStreamVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "getStreamVolume");
    return this.audioManager.getStreamVolume(0);
  }
  
  @CalledByNative
  private int initPlayout(int paramInt1, int paramInt2, double paramDouble)
  {
    this.threadChecker.checkIsOnValidThread();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initPlayout(sampleRate=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", channels=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", bufferSizeFactor=");
    ((StringBuilder)localObject).append(paramDouble);
    ((StringBuilder)localObject).append(")");
    Logging.d("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt2 * 2 * (paramInt1 / 100));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteBuffer.capacity: ");
    ((StringBuilder)localObject).append(this.byteBuffer.capacity());
    Logging.d("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
    paramInt2 = channelCountToConfiguration(paramInt2);
    int i = (int)(AudioTrack.getMinBufferSize(paramInt1, paramInt2, 2) * paramDouble);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("minBufferSizeInBytes: ");
    ((StringBuilder)localObject).append(i);
    Logging.d("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    if (i < this.byteBuffer.capacity())
    {
      reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
      return -1;
    }
    if (this.audioTrack != null)
    {
      reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
      return -1;
    }
    try
    {
      localObject = createAudioTrackOnLollipopOrHigher(paramInt1, paramInt2, i);
      this.audioTrack = ((AudioTrack)localObject);
      if ((localObject != null) && (((AudioTrack)localObject).getState() == 1))
      {
        logMainParameters();
        logMainParametersExtended();
        return i;
      }
      reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
      releaseAudioResources();
      return -1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      reportWebRtcAudioTrackInitError(localIllegalArgumentException.getMessage());
      releaseAudioResources();
    }
    return -1;
  }
  
  private boolean isVolumeFixed()
  {
    return this.audioManager.isVolumeFixed();
  }
  
  private void logBufferCapacityInFrames()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioTrack: buffer capacity in frames: ");
      localStringBuilder.append(this.audioTrack.getBufferCapacityInFrames());
      Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
    }
  }
  
  private void logBufferSizeInFrames()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioTrack: buffer size in frames: ");
    localStringBuilder.append(this.audioTrack.getBufferSizeInFrames());
    Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
  }
  
  private void logMainParameters()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioTrack: session ID: ");
    localStringBuilder.append(this.audioTrack.getAudioSessionId());
    localStringBuilder.append(", channels: ");
    localStringBuilder.append(this.audioTrack.getChannelCount());
    localStringBuilder.append(", sample rate: ");
    localStringBuilder.append(this.audioTrack.getSampleRate());
    localStringBuilder.append(", max gain: ");
    localStringBuilder.append(AudioTrack.getMaxVolume());
    Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
  }
  
  private void logMainParametersExtended()
  {
    logBufferSizeInFrames();
    logBufferCapacityInFrames();
  }
  
  private void logUnderrunCount()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("underrun count: ");
      localStringBuilder.append(this.audioTrack.getUnderrunCount());
      Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
    }
  }
  
  private static native void nativeCacheDirectBufferAddress(long paramLong, ByteBuffer paramByteBuffer);
  
  private static native void nativeGetPlayoutData(long paramLong, int paramInt);
  
  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioTrackExternal", "releaseAudioResources");
    AudioTrack localAudioTrack = this.audioTrack;
    if (localAudioTrack != null)
    {
      localAudioTrack.release();
      this.audioTrack = null;
    }
  }
  
  private void reportWebRtcAudioTrackError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Run-time playback error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioTrackErrorCallback)localObject).onWebRtcAudioTrackError(paramString);
    }
  }
  
  private void reportWebRtcAudioTrackInitError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init playout error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioTrackErrorCallback)localObject).onWebRtcAudioTrackInitError(paramString);
    }
  }
  
  private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Start playout error: ");
    ((StringBuilder)localObject).append(paramAudioTrackStartErrorCode);
    ((StringBuilder)localObject).append(". ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioTrackErrorCallback)localObject).onWebRtcAudioTrackStartError(paramAudioTrackStartErrorCode, paramString);
    }
  }
  
  @CalledByNative
  private boolean setStreamVolume(int paramInt)
  {
    this.threadChecker.checkIsOnValidThread();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStreamVolume(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioTrackExternal", localStringBuilder.toString());
    if (isVolumeFixed())
    {
      Logging.e("WebRtcAudioTrackExternal", "The device implements a fixed volume policy.");
      return false;
    }
    this.audioManager.setStreamVolume(0, paramInt, 0);
    return true;
  }
  
  @CalledByNative
  private boolean startPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    this.volumeLogger.start();
    Logging.d("WebRtcAudioTrackExternal", "startPlayout");
    boolean bool;
    if (this.audioTrack != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    if (this.audioThread == null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    try
    {
      this.audioTrack.play();
      if (this.audioTrack.getPlayState() == 3) {
        break label123;
      }
      localObject1 = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AudioTrack.play failed - incorrect state :");
      ((StringBuilder)localObject2).append(this.audioTrack.getPlayState());
      reportWebRtcAudioTrackStartError((JavaAudioDeviceModule.AudioTrackStartErrorCode)localObject1, ((StringBuilder)localObject2).toString());
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioTrack.play failed: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        reportWebRtcAudioTrackStartError((JavaAudioDeviceModule.AudioTrackStartErrorCode)localObject2, localStringBuilder.toString());
      }
    }
    releaseAudioResources();
    return false;
    label123:
    localObject1 = new AudioTrackThread("AudioTrackJavaThread");
    this.audioThread = ((AudioTrackThread)localObject1);
    ((Thread)localObject1).start();
    return true;
  }
  
  @CalledByNative
  private boolean stopPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    this.volumeLogger.stop();
    Logging.d("WebRtcAudioTrackExternal", "stopPlayout");
    boolean bool;
    if (this.audioThread != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    logUnderrunCount();
    this.audioThread.stopThread();
    Logging.d("WebRtcAudioTrackExternal", "Stopping the AudioTrackThread...");
    this.audioThread.interrupt();
    if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
    {
      Logging.e("WebRtcAudioTrackExternal", "Join of AudioTrackThread timed out.");
      WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    }
    Logging.d("WebRtcAudioTrackExternal", "AudioTrackThread has now been stopped.");
    this.audioThread = null;
    if (this.audioTrack != null)
    {
      Logging.d("WebRtcAudioTrackExternal", "Calling AudioTrack.stop...");
      try
      {
        this.audioTrack.stop();
        Logging.d("WebRtcAudioTrackExternal", "AudioTrack.stop is done.");
        doAudioTrackStateCallback(1);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioTrack.stop failed: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        Logging.e("WebRtcAudioTrackExternal", localStringBuilder.toString());
      }
    }
    releaseAudioResources();
    return true;
  }
  
  @CalledByNative
  public void setNativeAudioTrack(long paramLong)
  {
    this.nativeAudioTrack = paramLong;
  }
  
  public void setSpeakerMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeakerMute(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.w("WebRtcAudioTrackExternal", localStringBuilder.toString());
    this.speakerMute = paramBoolean;
  }
  
  private class AudioTrackThread
    extends Thread
  {
    private volatile boolean keepAlive = true;
    
    public AudioTrackThread(String paramString)
    {
      super();
    }
    
    private int writeBytes(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
    {
      return paramAudioTrack.write(paramByteBuffer, paramInt, 0);
    }
    
    public void run()
    {
      Process.setThreadPriority(-19);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioTrackThread");
      ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
      Logging.d("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
      boolean bool;
      if (WebRtcAudioTrack.this.audioTrack.getPlayState() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      WebRtcAudioTrack.assertTrue(bool);
      WebRtcAudioTrack.this.doAudioTrackStateCallback(0);
      int i = WebRtcAudioTrack.this.byteBuffer.capacity();
      while (this.keepAlive)
      {
        WebRtcAudioTrack.nativeGetPlayoutData(WebRtcAudioTrack.this.nativeAudioTrack, i);
        if (i <= WebRtcAudioTrack.this.byteBuffer.remaining()) {
          bool = true;
        } else {
          bool = false;
        }
        WebRtcAudioTrack.assertTrue(bool);
        if (WebRtcAudioTrack.this.speakerMute)
        {
          WebRtcAudioTrack.this.byteBuffer.clear();
          WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
          WebRtcAudioTrack.this.byteBuffer.position(0);
        }
        int j = writeBytes(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, i);
        if (j != i)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AudioTrack.write played invalid number of bytes: ");
          ((StringBuilder)localObject).append(j);
          Logging.e("WebRtcAudioTrackExternal", ((StringBuilder)localObject).toString());
          if (j < 0)
          {
            this.keepAlive = false;
            localObject = WebRtcAudioTrack.this;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("AudioTrack.write failed: ");
            localStringBuilder.append(j);
            ((WebRtcAudioTrack)localObject).reportWebRtcAudioTrackError(localStringBuilder.toString());
          }
        }
        WebRtcAudioTrack.this.byteBuffer.rewind();
      }
    }
    
    public void stopThread()
    {
      Logging.d("WebRtcAudioTrackExternal", "stopThread");
      this.keepAlive = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.WebRtcAudioTrack
 * JD-Core Version:    0.7.0.1
 */