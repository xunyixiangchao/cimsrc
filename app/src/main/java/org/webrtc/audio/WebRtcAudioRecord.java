package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecord.Builder;
import android.media.AudioRecordingConfiguration;
import android.os.Build.VERSION;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

class WebRtcAudioRecord
{
  private static final int AUDIO_RECORD_START = 0;
  private static final int AUDIO_RECORD_STOP = 1;
  private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int BUFFER_SIZE_FACTOR = 2;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final int CHECK_REC_STATUS_DELAY_MS = 100;
  public static final int DEFAULT_AUDIO_FORMAT = 2;
  public static final int DEFAULT_AUDIO_SOURCE = 7;
  private static final String TAG = "WebRtcAudioRecordExternal";
  private final int audioFormat;
  private final AudioManager audioManager;
  private AudioRecord audioRecord;
  private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
  private final int audioSource;
  private boolean audioSourceMatchesRecordingSession;
  private AudioRecordThread audioThread;
  private ByteBuffer byteBuffer;
  private final Context context;
  private final WebRtcAudioEffects effects = new WebRtcAudioEffects();
  private byte[] emptyBytes;
  private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
  private ScheduledExecutorService executor;
  private ScheduledFuture<String> future;
  private final boolean isAcousticEchoCancelerSupported;
  private boolean isAudioConfigVerified;
  private final boolean isNoiseSuppressorSupported;
  private volatile boolean microphoneMute;
  private long nativeAudioRecord;
  private AudioDeviceInfo preferredDevice;
  private final JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;
  
  @CalledByNative
  WebRtcAudioRecord(Context paramContext, AudioManager paramAudioManager)
  {
    this(paramContext, paramAudioManager, 7, 2, null, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
  }
  
  public WebRtcAudioRecord(Context paramContext, AudioManager paramAudioManager, int paramInt1, int paramInt2, JavaAudioDeviceModule.AudioRecordErrorCallback paramAudioRecordErrorCallback, JavaAudioDeviceModule.AudioRecordStateCallback paramAudioRecordStateCallback, JavaAudioDeviceModule.SamplesReadyCallback paramSamplesReadyCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!WebRtcAudioEffects.isAcousticEchoCancelerSupported())) {
      throw new IllegalArgumentException("HW AEC not supported");
    }
    if ((paramBoolean2) && (!WebRtcAudioEffects.isNoiseSuppressorSupported())) {
      throw new IllegalArgumentException("HW NS not supported");
    }
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.audioSource = paramInt1;
    this.audioFormat = paramInt2;
    this.errorCallback = paramAudioRecordErrorCallback;
    this.stateCallback = paramAudioRecordStateCallback;
    this.audioSamplesReadyCallback = paramSamplesReadyCallback;
    this.isAcousticEchoCancelerSupported = paramBoolean1;
    this.isNoiseSuppressorSupported = paramBoolean2;
    paramContext = new StringBuilder();
    paramContext.append("ctor");
    paramContext.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioRecordExternal", paramContext.toString());
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError("Expected condition to be true");
  }
  
  private static String audioStateToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "INVALID";
      }
      return "STOP";
    }
    return "START";
  }
  
  private int channelCountToConfiguration(int paramInt)
  {
    if (paramInt == 1) {
      return 16;
    }
    return 12;
  }
  
  @TargetApi(24)
  private static boolean checkDeviceMatch(AudioDeviceInfo paramAudioDeviceInfo1, AudioDeviceInfo paramAudioDeviceInfo2)
  {
    return (paramAudioDeviceInfo1.getId() == paramAudioDeviceInfo2.getId()) && (paramAudioDeviceInfo1.getType() == paramAudioDeviceInfo2.getType());
  }
  
  private static AudioRecord createAudioRecordOnLowerThanM(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Logging.d("WebRtcAudioRecordExternal", "createAudioRecordOnLowerThanM");
    return new AudioRecord(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  @TargetApi(23)
  private static AudioRecord createAudioRecordOnMOrHigher(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Logging.d("WebRtcAudioRecordExternal", "createAudioRecordOnMOrHigher");
    return new AudioRecord.Builder().setAudioSource(paramInt1).setAudioFormat(new AudioFormat.Builder().setEncoding(paramInt4).setSampleRate(paramInt2).setChannelMask(paramInt3).build()).setBufferSizeInBytes(paramInt5).build();
  }
  
  private void doAudioRecordStateCallback(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAudioRecordStateCallback: ");
    ((StringBuilder)localObject).append(audioStateToString(paramInt));
    Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    localObject = this.stateCallback;
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        ((JavaAudioDeviceModule.AudioRecordStateCallback)localObject).onWebRtcAudioRecordStart();
        return;
      }
      if (paramInt == 1)
      {
        ((JavaAudioDeviceModule.AudioRecordStateCallback)localObject).onWebRtcAudioRecordStop();
        return;
      }
      Logging.e("WebRtcAudioRecordExternal", "Invalid audio state");
    }
  }
  
  @CalledByNative
  private boolean enableBuiltInAEC(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBuiltInAEC(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
    return this.effects.setAEC(paramBoolean);
  }
  
  @CalledByNative
  private boolean enableBuiltInNS(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableBuiltInNS(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
    return this.effects.setNS(paramBoolean);
  }
  
  private static int getBytesPerSample(int paramInt)
  {
    int i = 1;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        i = 4;
        if (paramInt != 4)
        {
          if (paramInt == 13) {
            return 2;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Bad audio format ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      return i;
    }
    return 2;
  }
  
  @CalledByNative
  private int initRecording(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initRecording(sampleRate=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", channels=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(")");
    Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    if (this.audioRecord != null)
    {
      reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
      return -1;
    }
    int j = getBytesPerSample(this.audioFormat);
    int i = paramInt1 / 100;
    localObject = ByteBuffer.allocateDirect(j * paramInt2 * i);
    this.byteBuffer = ((ByteBuffer)localObject);
    if (!((ByteBuffer)localObject).hasArray())
    {
      reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
      return -1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteBuffer.capacity: ");
    ((StringBuilder)localObject).append(this.byteBuffer.capacity());
    Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
    paramInt2 = channelCountToConfiguration(paramInt2);
    j = AudioRecord.getMinBufferSize(paramInt1, paramInt2, this.audioFormat);
    if ((j != -1) && (j != -2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioRecord.getMinBufferSize: ");
      ((StringBuilder)localObject).append(j);
      Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
      j = Math.max(j * 2, this.byteBuffer.capacity());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bufferSizeInBytes: ");
      ((StringBuilder)localObject).append(j);
      Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
      try
      {
        this.audioRecord = createAudioRecordOnMOrHigher(this.audioSource, paramInt1, paramInt2, this.audioFormat, j);
        localObject = this.preferredDevice;
        if (localObject != null) {
          setPreferredDevice((AudioDeviceInfo)localObject);
        }
        localObject = this.audioRecord;
        if ((localObject != null) && (((AudioRecord)localObject).getState() == 1))
        {
          this.effects.enable(this.audioRecord.getAudioSessionId());
          logMainParameters();
          logMainParametersExtended();
          paramInt1 = logRecordingConfigurations(false);
          if (paramInt1 != 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Potential microphone conflict. Active sessions: ");
            ((StringBuilder)localObject).append(paramInt1);
            Logging.w("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
          }
          return i;
        }
        reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
        releaseAudioResources();
        return -1;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
      reportWebRtcAudioRecordInitError(localIllegalArgumentException.getMessage());
      releaseAudioResources();
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioRecord.getMinBufferSize failed: ");
    localStringBuilder.append(j);
    reportWebRtcAudioRecordInitError(localStringBuilder.toString());
    return -1;
  }
  
  @TargetApi(24)
  private static boolean logActiveRecordingConfigs(int paramInt, List<AudioRecordingConfiguration> paramList)
  {
    assertTrue(paramList.isEmpty() ^ true);
    Iterator localIterator = paramList.iterator();
    for (paramList = "AudioRecordingConfigurations: ";; paramList = paramList.toString())
    {
      Logging.d("WebRtcAudioRecordExternal", paramList);
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (AudioRecordingConfiguration)localIterator.next();
      paramList = new StringBuilder();
      int i = ((AudioRecordingConfiguration)localObject).getClientAudioSource();
      paramList.append("  client audio source=");
      paramList.append(WebRtcAudioUtils.audioSourceToString(i));
      paramList.append(", client session id=");
      paramList.append(((AudioRecordingConfiguration)localObject).getClientAudioSessionId());
      paramList.append(" (");
      paramList.append(paramInt);
      paramList.append(")");
      paramList.append("\n");
      AudioFormat localAudioFormat = ((AudioRecordingConfiguration)localObject).getFormat();
      paramList.append("  Device AudioFormat: ");
      paramList.append("channel count=");
      paramList.append(localAudioFormat.getChannelCount());
      paramList.append(", channel index mask=");
      paramList.append(localAudioFormat.getChannelIndexMask());
      paramList.append(", channel mask=");
      paramList.append(WebRtcAudioUtils.channelMaskToString(localAudioFormat.getChannelMask()));
      paramList.append(", encoding=");
      paramList.append(WebRtcAudioUtils.audioEncodingToString(localAudioFormat.getEncoding()));
      paramList.append(", sample rate=");
      paramList.append(localAudioFormat.getSampleRate());
      paramList.append("\n");
      localAudioFormat = ((AudioRecordingConfiguration)localObject).getClientFormat();
      paramList.append("  Client AudioFormat: ");
      paramList.append("channel count=");
      paramList.append(localAudioFormat.getChannelCount());
      paramList.append(", channel index mask=");
      paramList.append(localAudioFormat.getChannelIndexMask());
      paramList.append(", channel mask=");
      paramList.append(WebRtcAudioUtils.channelMaskToString(localAudioFormat.getChannelMask()));
      paramList.append(", encoding=");
      paramList.append(WebRtcAudioUtils.audioEncodingToString(localAudioFormat.getEncoding()));
      paramList.append(", sample rate=");
      paramList.append(localAudioFormat.getSampleRate());
      paramList.append("\n");
      localObject = ((AudioRecordingConfiguration)localObject).getAudioDevice();
      if (localObject != null)
      {
        assertTrue(((AudioDeviceInfo)localObject).isSource());
        paramList.append("  AudioDevice: ");
        paramList.append("type=");
        paramList.append(WebRtcAudioUtils.deviceTypeToString(((AudioDeviceInfo)localObject).getType()));
        paramList.append(", id=");
        paramList.append(((AudioDeviceInfo)localObject).getId());
      }
    }
    return true;
  }
  
  private void logMainParameters()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioRecord: session ID: ");
    localStringBuilder.append(this.audioRecord.getAudioSessionId());
    localStringBuilder.append(", channels: ");
    localStringBuilder.append(this.audioRecord.getChannelCount());
    localStringBuilder.append(", sample rate: ");
    localStringBuilder.append(this.audioRecord.getSampleRate());
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
  }
  
  @TargetApi(23)
  private void logMainParametersExtended()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioRecord: buffer size in frames: ");
    localStringBuilder.append(this.audioRecord.getBufferSizeInFrames());
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
  }
  
  @TargetApi(24)
  private int logRecordingConfigurations(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      Logging.w("WebRtcAudioRecordExternal", "AudioManager#getActiveRecordingConfigurations() requires N or higher");
      return 0;
    }
    if (this.audioRecord == null) {
      return 0;
    }
    List localList = this.audioManager.getActiveRecordingConfigurations();
    int i = localList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Number of active recording sessions: ");
    localStringBuilder.append(i);
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
    if (i > 0)
    {
      logActiveRecordingConfigs(this.audioRecord.getAudioSessionId(), localList);
      if (paramBoolean)
      {
        this.audioSourceMatchesRecordingSession = verifyAudioConfig(this.audioRecord.getAudioSource(), this.audioRecord.getAudioSessionId(), this.audioRecord.getFormat(), this.audioRecord.getRoutedDevice(), localList);
        this.isAudioConfigVerified = true;
      }
    }
    return i;
  }
  
  private native void nativeCacheDirectBufferAddress(long paramLong, ByteBuffer paramByteBuffer);
  
  private native void nativeDataIsRecorded(long paramLong, int paramInt);
  
  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioRecordExternal", "releaseAudioResources");
    AudioRecord localAudioRecord = this.audioRecord;
    if (localAudioRecord != null)
    {
      localAudioRecord.release();
      this.audioRecord = null;
    }
  }
  
  private void reportWebRtcAudioRecordError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Run-time recording error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioRecordErrorCallback)localObject).onWebRtcAudioRecordError(paramString);
    }
  }
  
  private void reportWebRtcAudioRecordInitError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init recording error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    logRecordingConfigurations(false);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioRecordErrorCallback)localObject).onWebRtcAudioRecordInitError(paramString);
    }
  }
  
  private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Start recording error: ");
    ((StringBuilder)localObject).append(paramAudioRecordStartErrorCode);
    ((StringBuilder)localObject).append(". ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    logRecordingConfigurations(false);
    localObject = this.errorCallback;
    if (localObject != null) {
      ((JavaAudioDeviceModule.AudioRecordErrorCallback)localObject).onWebRtcAudioRecordStartError(paramAudioRecordStartErrorCode, paramString);
    }
  }
  
  private void scheduleLogRecordingConfigurationsTask()
  {
    Logging.d("WebRtcAudioRecordExternal", "scheduleLogRecordingConfigurationsTask");
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject = this.executor;
    if (localObject != null) {
      ((ScheduledExecutorService)localObject).shutdownNow();
    }
    this.executor = Executors.newSingleThreadScheduledExecutor();
    localObject = new a(this);
    ScheduledFuture localScheduledFuture = this.future;
    if ((localScheduledFuture != null) && (!localScheduledFuture.isDone())) {
      this.future.cancel(true);
    }
    this.future = this.executor.schedule((Callable)localObject, 100L, TimeUnit.MILLISECONDS);
  }
  
  @CalledByNative
  private boolean startRecording()
  {
    Logging.d("WebRtcAudioRecordExternal", "startRecording");
    boolean bool;
    if (this.audioRecord != null) {
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
      this.audioRecord.startRecording();
      if (this.audioRecord.getRecordingState() != 3)
      {
        localObject1 = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AudioRecord.startRecording failed - incorrect state: ");
        ((StringBuilder)localObject2).append(this.audioRecord.getRecordingState());
        reportWebRtcAudioRecordStartError((JavaAudioDeviceModule.AudioRecordStartErrorCode)localObject1, ((StringBuilder)localObject2).toString());
        return false;
      }
      Object localObject1 = new AudioRecordThread("AudioRecordJavaThread");
      this.audioThread = ((AudioRecordThread)localObject1);
      ((Thread)localObject1).start();
      scheduleLogRecordingConfigurationsTask();
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Object localObject2 = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioRecord.startRecording failed: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      reportWebRtcAudioRecordStartError((JavaAudioDeviceModule.AudioRecordStartErrorCode)localObject2, localStringBuilder.toString());
    }
    return false;
  }
  
  @CalledByNative
  private boolean stopRecording()
  {
    Logging.d("WebRtcAudioRecordExternal", "stopRecording");
    boolean bool;
    if (this.audioThread != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    Object localObject = this.future;
    if (localObject != null)
    {
      if (!((ScheduledFuture)localObject).isDone()) {
        this.future.cancel(true);
      }
      this.future = null;
    }
    localObject = this.executor;
    if (localObject != null)
    {
      ((ScheduledExecutorService)localObject).shutdownNow();
      this.executor = null;
    }
    this.audioThread.stopThread();
    if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
    {
      Logging.e("WebRtcAudioRecordExternal", "Join of AudioRecordJavaThread timed out");
      WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    }
    this.audioThread = null;
    this.effects.release();
    releaseAudioResources();
    return true;
  }
  
  @TargetApi(24)
  private static boolean verifyAudioConfig(int paramInt1, int paramInt2, AudioFormat paramAudioFormat, AudioDeviceInfo paramAudioDeviceInfo, List<AudioRecordingConfiguration> paramList)
  {
    assertTrue(paramList.isEmpty() ^ true);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AudioRecordingConfiguration localAudioRecordingConfiguration = (AudioRecordingConfiguration)paramList.next();
      AudioDeviceInfo localAudioDeviceInfo = localAudioRecordingConfiguration.getAudioDevice();
      if ((localAudioDeviceInfo != null) && (localAudioRecordingConfiguration.getClientAudioSource() == paramInt1) && (localAudioRecordingConfiguration.getClientAudioSessionId() == paramInt2) && (localAudioRecordingConfiguration.getClientFormat().getEncoding() == paramAudioFormat.getEncoding()) && (localAudioRecordingConfiguration.getClientFormat().getSampleRate() == paramAudioFormat.getSampleRate()) && (localAudioRecordingConfiguration.getClientFormat().getChannelMask() == paramAudioFormat.getChannelMask()) && (localAudioRecordingConfiguration.getClientFormat().getChannelIndexMask() == paramAudioFormat.getChannelIndexMask()) && (localAudioRecordingConfiguration.getFormat().getEncoding() != 0) && (localAudioRecordingConfiguration.getFormat().getSampleRate() > 0) && ((localAudioRecordingConfiguration.getFormat().getChannelMask() != 0) || (localAudioRecordingConfiguration.getFormat().getChannelIndexMask() != 0)) && (checkDeviceMatch(localAudioDeviceInfo, paramAudioDeviceInfo)))
      {
        Logging.d("WebRtcAudioRecordExternal", "verifyAudioConfig: PASS");
        return true;
      }
    }
    Logging.e("WebRtcAudioRecordExternal", "verifyAudioConfig: FAILED");
    return false;
  }
  
  @CalledByNative
  boolean isAcousticEchoCancelerSupported()
  {
    return this.isAcousticEchoCancelerSupported;
  }
  
  @CalledByNative
  boolean isAudioConfigVerified()
  {
    return this.isAudioConfigVerified;
  }
  
  @CalledByNative
  boolean isAudioSourceMatchingRecordingSession()
  {
    if (!this.isAudioConfigVerified)
    {
      Logging.w("WebRtcAudioRecordExternal", "Audio configuration has not yet been verified");
      return false;
    }
    return this.audioSourceMatchesRecordingSession;
  }
  
  @CalledByNative
  boolean isNoiseSuppressorSupported()
  {
    return this.isNoiseSuppressorSupported;
  }
  
  public void setMicrophoneMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMicrophoneMute(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.w("WebRtcAudioRecordExternal", localStringBuilder.toString());
    this.microphoneMute = paramBoolean;
  }
  
  @CalledByNative
  public void setNativeAudioRecord(long paramLong)
  {
    this.nativeAudioRecord = paramLong;
  }
  
  @TargetApi(23)
  void setPreferredDevice(AudioDeviceInfo paramAudioDeviceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreferredDevice ");
    if (paramAudioDeviceInfo != null) {
      localObject = Integer.valueOf(paramAudioDeviceInfo.getId());
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    Logging.d("WebRtcAudioRecordExternal", localStringBuilder.toString());
    this.preferredDevice = paramAudioDeviceInfo;
    Object localObject = this.audioRecord;
    if ((localObject != null) && (!((AudioRecord)localObject).setPreferredDevice(paramAudioDeviceInfo))) {
      Logging.e("WebRtcAudioRecordExternal", "setPreferredDevice failed");
    }
  }
  
  private class AudioRecordThread
    extends Thread
  {
    private volatile boolean keepAlive = true;
    
    public AudioRecordThread(String paramString)
    {
      super();
    }
    
    public void run()
    {
      Process.setThreadPriority(-19);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioRecordThread");
      ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
      Logging.d("WebRtcAudioRecordExternal", ((StringBuilder)localObject).toString());
      boolean bool;
      if (WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      WebRtcAudioRecord.assertTrue(bool);
      WebRtcAudioRecord.this.doAudioRecordStateCallback(0);
      System.nanoTime();
      while (this.keepAlive)
      {
        int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
        if (i == WebRtcAudioRecord.this.byteBuffer.capacity())
        {
          if (WebRtcAudioRecord.this.microphoneMute)
          {
            WebRtcAudioRecord.this.byteBuffer.clear();
            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
          }
          if (this.keepAlive)
          {
            localObject = WebRtcAudioRecord.this;
            ((WebRtcAudioRecord)localObject).nativeDataIsRecorded(((WebRtcAudioRecord)localObject).nativeAudioRecord, i);
          }
          if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null)
          {
            localObject = Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset());
            WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioRecord.getAudioFormat(), WebRtcAudioRecord.this.audioRecord.getChannelCount(), WebRtcAudioRecord.this.audioRecord.getSampleRate(), (byte[])localObject));
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AudioRecord.read failed: ");
          ((StringBuilder)localObject).append(i);
          localObject = ((StringBuilder)localObject).toString();
          Logging.e("WebRtcAudioRecordExternal", (String)localObject);
          if (i == -3)
          {
            this.keepAlive = false;
            WebRtcAudioRecord.this.reportWebRtcAudioRecordError((String)localObject);
          }
        }
      }
      try
      {
        if (WebRtcAudioRecord.this.audioRecord != null)
        {
          WebRtcAudioRecord.this.audioRecord.stop();
          WebRtcAudioRecord.this.doAudioRecordStateCallback(1);
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioRecord.stop failed: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        Logging.e("WebRtcAudioRecordExternal", localStringBuilder.toString());
      }
    }
    
    public void stopThread()
    {
      Logging.d("WebRtcAudioRecordExternal", "stopThread");
      this.keepAlive = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.WebRtcAudioRecord
 * JD-Core Version:    0.7.0.1
 */