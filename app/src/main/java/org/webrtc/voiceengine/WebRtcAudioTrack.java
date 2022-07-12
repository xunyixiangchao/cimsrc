package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Process;
import java.nio.ByteBuffer;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.ThreadUtils.ThreadChecker;

public class WebRtcAudioTrack
{
  private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_USAGE;
  private static final String TAG = "WebRtcAudioTrack";
  private static ErrorCallback errorCallback;
  private static WebRtcAudioTrackErrorCallback errorCallbackOld;
  private static volatile boolean speakerMute;
  private static int usageAttribute;
  private final AudioManager audioManager;
  private AudioTrackThread audioThread;
  private AudioTrack audioTrack;
  private ByteBuffer byteBuffer;
  private byte[] emptyBytes;
  private final long nativeAudioTrack;
  private final ThreadUtils.ThreadChecker threadChecker;
  
  static
  {
    int i = getDefaultUsageAttribute();
    DEFAULT_USAGE = i;
    usageAttribute = i;
  }
  
  WebRtcAudioTrack(long paramLong)
  {
    Object localObject = new ThreadUtils.ThreadChecker();
    this.threadChecker = ((ThreadUtils.ThreadChecker)localObject);
    ((ThreadUtils.ThreadChecker)localObject).checkIsOnValidThread();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ctor");
    ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    this.nativeAudioTrack = paramLong;
    this.audioManager = ((AudioManager)ContextUtils.getApplicationContext().getSystemService("audio"));
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
    Logging.d("WebRtcAudioTrack", "createAudioTrackOnLollipopOrHigher");
    int i = AudioTrack.getNativeOutputSampleRate(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeOutputSampleRate: ");
    localStringBuilder.append(i);
    Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
    if (paramInt1 != i) {
      Logging.w("WebRtcAudioTrack", "Unable to use fast mode since requested sample rate is not native");
    }
    if (usageAttribute != DEFAULT_USAGE)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A non default usage attribute is used: ");
      localStringBuilder.append(usageAttribute);
      Logging.w("WebRtcAudioTrack", localStringBuilder.toString());
    }
    return new AudioTrack(new AudioAttributes.Builder().setUsage(usageAttribute).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(paramInt1).setChannelMask(paramInt2).build(), paramInt3, 1, 0);
  }
  
  private static AudioTrack createAudioTrackOnLowerThanLollipop(int paramInt1, int paramInt2, int paramInt3)
  {
    return new AudioTrack(0, paramInt1, paramInt2, 2, paramInt3, 1);
  }
  
  private int getBufferSizeInFrames()
  {
    return this.audioTrack.getBufferSizeInFrames();
  }
  
  private static int getDefaultUsageAttribute()
  {
    return 2;
  }
  
  private int getStreamMaxVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrack", "getStreamMaxVolume");
    boolean bool;
    if (this.audioManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    return this.audioManager.getStreamMaxVolume(0);
  }
  
  private int getStreamVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrack", "getStreamVolume");
    boolean bool;
    if (this.audioManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    return this.audioManager.getStreamVolume(0);
  }
  
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
    Logging.d("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt2 * 2 * (paramInt1 / 100));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteBuffer.capacity: ");
    ((StringBuilder)localObject).append(this.byteBuffer.capacity());
    Logging.d("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
    paramInt2 = channelCountToConfiguration(paramInt2);
    int i = (int)(AudioTrack.getMinBufferSize(paramInt1, paramInt2, 2) * paramDouble);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("minBufferSizeInBytes: ");
    ((StringBuilder)localObject).append(i);
    Logging.d("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
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
      Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
    }
  }
  
  private void logBufferSizeInFrames()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioTrack: buffer size in frames: ");
    localStringBuilder.append(this.audioTrack.getBufferSizeInFrames());
    Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
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
    Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
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
      Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
    }
  }
  
  private native void nativeCacheDirectBufferAddress(ByteBuffer paramByteBuffer, long paramLong);
  
  private native void nativeGetPlayoutData(int paramInt, long paramLong);
  
  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioTrack", "releaseAudioResources");
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
    Logging.e("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrack");
    localObject = errorCallbackOld;
    if (localObject != null) {
      ((WebRtcAudioTrackErrorCallback)localObject).onWebRtcAudioTrackError(paramString);
    }
    localObject = errorCallback;
    if (localObject != null) {
      ((ErrorCallback)localObject).onWebRtcAudioTrackError(paramString);
    }
  }
  
  private void reportWebRtcAudioTrackInitError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init playout error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrack");
    localObject = errorCallbackOld;
    if (localObject != null) {
      ((WebRtcAudioTrackErrorCallback)localObject).onWebRtcAudioTrackInitError(paramString);
    }
    localObject = errorCallback;
    if (localObject != null) {
      ((ErrorCallback)localObject).onWebRtcAudioTrackInitError(paramString);
    }
  }
  
  private void reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Start playout error: ");
    ((StringBuilder)localObject).append(paramAudioTrackStartErrorCode);
    ((StringBuilder)localObject).append(". ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrack");
    localObject = errorCallbackOld;
    if (localObject != null) {
      ((WebRtcAudioTrackErrorCallback)localObject).onWebRtcAudioTrackStartError(paramString);
    }
    localObject = errorCallback;
    if (localObject != null) {
      ((ErrorCallback)localObject).onWebRtcAudioTrackStartError(paramAudioTrackStartErrorCode, paramString);
    }
  }
  
  public static void setAudioTrackUsageAttribute(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Default usage attribute is changed from: ");
      localStringBuilder.append(DEFAULT_USAGE);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramInt);
      Logging.w("WebRtcAudioTrack", localStringBuilder.toString());
      usageAttribute = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setErrorCallback(ErrorCallback paramErrorCallback)
  {
    Logging.d("WebRtcAudioTrack", "Set extended error callback");
    errorCallback = paramErrorCallback;
  }
  
  @Deprecated
  public static void setErrorCallback(WebRtcAudioTrackErrorCallback paramWebRtcAudioTrackErrorCallback)
  {
    Logging.d("WebRtcAudioTrack", "Set error callback (deprecated");
    errorCallbackOld = paramWebRtcAudioTrackErrorCallback;
  }
  
  public static void setSpeakerMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeakerMute(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.w("WebRtcAudioTrack", localStringBuilder.toString());
    speakerMute = paramBoolean;
  }
  
  private boolean setStreamVolume(int paramInt)
  {
    this.threadChecker.checkIsOnValidThread();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStreamVolume(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioTrack", localStringBuilder.toString());
    boolean bool;
    if (this.audioManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    if (isVolumeFixed())
    {
      Logging.e("WebRtcAudioTrack", "The device implements a fixed volume policy.");
      return false;
    }
    this.audioManager.setStreamVolume(0, paramInt, 0);
    return true;
  }
  
  private boolean startPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrack", "startPlayout");
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
        break label116;
      }
      localObject1 = AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AudioTrack.play failed - incorrect state :");
      ((StringBuilder)localObject2).append(this.audioTrack.getPlayState());
      reportWebRtcAudioTrackStartError((AudioTrackStartErrorCode)localObject1, ((StringBuilder)localObject2).toString());
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioTrack.play failed: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        reportWebRtcAudioTrackStartError((AudioTrackStartErrorCode)localObject2, localStringBuilder.toString());
      }
    }
    releaseAudioResources();
    return false;
    label116:
    localObject1 = new AudioTrackThread("AudioTrackJavaThread");
    this.audioThread = ((AudioTrackThread)localObject1);
    ((Thread)localObject1).start();
    return true;
  }
  
  private boolean stopPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrack", "stopPlayout");
    boolean bool;
    if (this.audioThread != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    logUnderrunCount();
    this.audioThread.stopThread();
    Logging.d("WebRtcAudioTrack", "Stopping the AudioTrackThread...");
    this.audioThread.interrupt();
    if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
    {
      Logging.e("WebRtcAudioTrack", "Join of AudioTrackThread timed out.");
      WebRtcAudioUtils.logAudioState("WebRtcAudioTrack");
    }
    Logging.d("WebRtcAudioTrack", "AudioTrackThread has now been stopped.");
    this.audioThread = null;
    releaseAudioResources();
    return true;
  }
  
  public static enum AudioTrackStartErrorCode
  {
    static
    {
      AudioTrackStartErrorCode localAudioTrackStartErrorCode1 = new AudioTrackStartErrorCode("AUDIO_TRACK_START_EXCEPTION", 0);
      AUDIO_TRACK_START_EXCEPTION = localAudioTrackStartErrorCode1;
      AudioTrackStartErrorCode localAudioTrackStartErrorCode2 = new AudioTrackStartErrorCode("AUDIO_TRACK_START_STATE_MISMATCH", 1);
      AUDIO_TRACK_START_STATE_MISMATCH = localAudioTrackStartErrorCode2;
      $VALUES = new AudioTrackStartErrorCode[] { localAudioTrackStartErrorCode1, localAudioTrackStartErrorCode2 };
    }
    
    private AudioTrackStartErrorCode() {}
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
      Logging.d("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
      boolean bool;
      if (WebRtcAudioTrack.this.audioTrack.getPlayState() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      WebRtcAudioTrack.assertTrue(bool);
      int i = WebRtcAudioTrack.this.byteBuffer.capacity();
      StringBuilder localStringBuilder;
      while (this.keepAlive)
      {
        localObject = WebRtcAudioTrack.this;
        ((WebRtcAudioTrack)localObject).nativeGetPlayoutData(i, ((WebRtcAudioTrack)localObject).nativeAudioTrack);
        if (i <= WebRtcAudioTrack.this.byteBuffer.remaining()) {
          bool = true;
        } else {
          bool = false;
        }
        WebRtcAudioTrack.assertTrue(bool);
        if (WebRtcAudioTrack.speakerMute)
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
          Logging.e("WebRtcAudioTrack", ((StringBuilder)localObject).toString());
          if (j < 0)
          {
            this.keepAlive = false;
            localObject = WebRtcAudioTrack.this;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("AudioTrack.write failed: ");
            localStringBuilder.append(j);
            ((WebRtcAudioTrack)localObject).reportWebRtcAudioTrackError(localStringBuilder.toString());
          }
        }
        WebRtcAudioTrack.this.byteBuffer.rewind();
      }
      if (WebRtcAudioTrack.this.audioTrack != null)
      {
        Logging.d("WebRtcAudioTrack", "Calling AudioTrack.stop...");
        try
        {
          WebRtcAudioTrack.this.audioTrack.stop();
          Logging.d("WebRtcAudioTrack", "AudioTrack.stop is done.");
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("AudioTrack.stop failed: ");
          localStringBuilder.append(localIllegalStateException.getMessage());
          Logging.e("WebRtcAudioTrack", localStringBuilder.toString());
        }
      }
    }
    
    public void stopThread()
    {
      Logging.d("WebRtcAudioTrack", "stopThread");
      this.keepAlive = false;
    }
  }
  
  public static abstract interface ErrorCallback
  {
    public abstract void onWebRtcAudioTrackError(String paramString);
    
    public abstract void onWebRtcAudioTrackInitError(String paramString);
    
    public abstract void onWebRtcAudioTrackStartError(WebRtcAudioTrack.AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString);
  }
  
  @Deprecated
  public static abstract interface WebRtcAudioTrackErrorCallback
  {
    public abstract void onWebRtcAudioTrackError(String paramString);
    
    public abstract void onWebRtcAudioTrackInitError(String paramString);
    
    public abstract void onWebRtcAudioTrackStartError(String paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioTrack
 * JD-Core Version:    0.7.0.1
 */