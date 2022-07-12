package org.webrtc.voiceengine;

import android.media.AudioRecord;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

public class WebRtcAudioRecord
{
  private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int BUFFER_SIZE_FACTOR = 2;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_AUDIO_SOURCE;
  private static final String TAG = "WebRtcAudioRecord";
  private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
  private static int audioSource;
  private static WebRtcAudioRecordErrorCallback errorCallback;
  private static volatile boolean microphoneMute;
  private AudioRecord audioRecord;
  private AudioRecordThread audioThread;
  private ByteBuffer byteBuffer;
  private WebRtcAudioEffects effects;
  private byte[] emptyBytes;
  private final long nativeAudioRecord;
  
  static
  {
    int i = getDefaultAudioSource();
    DEFAULT_AUDIO_SOURCE = i;
    audioSource = i;
  }
  
  WebRtcAudioRecord(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ctor");
    localStringBuilder.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioRecord", localStringBuilder.toString());
    this.nativeAudioRecord = paramLong;
    this.effects = WebRtcAudioEffects.create();
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
      return 16;
    }
    return 12;
  }
  
  private boolean enableBuiltInAEC(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableBuiltInAEC(");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(')');
    Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    localObject = this.effects;
    if (localObject == null)
    {
      Logging.e("WebRtcAudioRecord", "Built-in AEC is not supported on this platform");
      return false;
    }
    return ((WebRtcAudioEffects)localObject).setAEC(paramBoolean);
  }
  
  private boolean enableBuiltInNS(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableBuiltInNS(");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(')');
    Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    localObject = this.effects;
    if (localObject == null)
    {
      Logging.e("WebRtcAudioRecord", "Built-in NS is not supported on this platform");
      return false;
    }
    return ((WebRtcAudioEffects)localObject).setNS(paramBoolean);
  }
  
  private static int getDefaultAudioSource()
  {
    return 7;
  }
  
  private int initRecording(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initRecording(sampleRate=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", channels=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(")");
    Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    if (this.audioRecord != null)
    {
      reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
      return -1;
    }
    int i = paramInt1 / 100;
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt2 * 2 * i);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteBuffer.capacity: ");
    ((StringBuilder)localObject).append(this.byteBuffer.capacity());
    Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
    paramInt2 = channelCountToConfiguration(paramInt2);
    int j = AudioRecord.getMinBufferSize(paramInt1, paramInt2, 2);
    if ((j != -1) && (j != -2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioRecord.getMinBufferSize: ");
      ((StringBuilder)localObject).append(j);
      Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
      j = Math.max(j * 2, this.byteBuffer.capacity());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bufferSizeInBytes: ");
      ((StringBuilder)localObject).append(j);
      Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
      try
      {
        localObject = new AudioRecord(audioSource, paramInt1, paramInt2, 2, j);
        this.audioRecord = ((AudioRecord)localObject);
        if (((AudioRecord)localObject).getState() != 1)
        {
          reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
          releaseAudioResources();
          return -1;
        }
        localObject = this.effects;
        if (localObject != null) {
          ((WebRtcAudioEffects)localObject).enable(this.audioRecord.getAudioSessionId());
        }
        logMainParameters();
        logMainParametersExtended();
        return i;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("AudioRecord ctor error: ");
        localStringBuilder2.append(localIllegalArgumentException.getMessage());
        reportWebRtcAudioRecordInitError(localStringBuilder2.toString());
        releaseAudioResources();
        return -1;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("AudioRecord.getMinBufferSize failed: ");
    localStringBuilder1.append(j);
    reportWebRtcAudioRecordInitError(localStringBuilder1.toString());
    return -1;
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
    Logging.d("WebRtcAudioRecord", localStringBuilder.toString());
  }
  
  private void logMainParametersExtended()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioRecord: buffer size in frames: ");
    localStringBuilder.append(this.audioRecord.getBufferSizeInFrames());
    Logging.d("WebRtcAudioRecord", localStringBuilder.toString());
  }
  
  private native void nativeCacheDirectBufferAddress(ByteBuffer paramByteBuffer, long paramLong);
  
  private native void nativeDataIsRecorded(int paramInt, long paramLong);
  
  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioRecord", "releaseAudioResources");
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
    Logging.e("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    localObject = errorCallback;
    if (localObject != null) {
      ((WebRtcAudioRecordErrorCallback)localObject).onWebRtcAudioRecordError(paramString);
    }
  }
  
  private void reportWebRtcAudioRecordInitError(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init recording error: ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    localObject = errorCallback;
    if (localObject != null) {
      ((WebRtcAudioRecordErrorCallback)localObject).onWebRtcAudioRecordInitError(paramString);
    }
  }
  
  private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Start recording error: ");
    ((StringBuilder)localObject).append(paramAudioRecordStartErrorCode);
    ((StringBuilder)localObject).append(". ");
    ((StringBuilder)localObject).append(paramString);
    Logging.e("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    localObject = errorCallback;
    if (localObject != null) {
      ((WebRtcAudioRecordErrorCallback)localObject).onWebRtcAudioRecordStartError(paramAudioRecordStartErrorCode, paramString);
    }
  }
  
  public static void setAudioSource(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Audio source is changed from: ");
      localStringBuilder.append(audioSource);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramInt);
      Logging.w("WebRtcAudioRecord", localStringBuilder.toString());
      audioSource = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setErrorCallback(WebRtcAudioRecordErrorCallback paramWebRtcAudioRecordErrorCallback)
  {
    Logging.d("WebRtcAudioRecord", "Set error callback");
    errorCallback = paramWebRtcAudioRecordErrorCallback;
  }
  
  public static void setMicrophoneMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMicrophoneMute(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.w("WebRtcAudioRecord", localStringBuilder.toString());
    microphoneMute = paramBoolean;
  }
  
  public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback paramWebRtcAudioRecordSamplesReadyCallback)
  {
    audioSamplesReadyCallback = paramWebRtcAudioRecordSamplesReadyCallback;
  }
  
  private boolean startRecording()
  {
    Logging.d("WebRtcAudioRecord", "startRecording");
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
        localObject1 = AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AudioRecord.startRecording failed - incorrect state :");
        ((StringBuilder)localObject2).append(this.audioRecord.getRecordingState());
        reportWebRtcAudioRecordStartError((AudioRecordStartErrorCode)localObject1, ((StringBuilder)localObject2).toString());
        return false;
      }
      Object localObject1 = new AudioRecordThread("AudioRecordJavaThread");
      this.audioThread = ((AudioRecordThread)localObject1);
      ((Thread)localObject1).start();
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Object localObject2 = AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioRecord.startRecording failed: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      reportWebRtcAudioRecordStartError((AudioRecordStartErrorCode)localObject2, localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean stopRecording()
  {
    Logging.d("WebRtcAudioRecord", "stopRecording");
    boolean bool;
    if (this.audioThread != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(bool);
    this.audioThread.stopThread();
    if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
    {
      Logging.e("WebRtcAudioRecord", "Join of AudioRecordJavaThread timed out");
      WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    }
    this.audioThread = null;
    WebRtcAudioEffects localWebRtcAudioEffects = this.effects;
    if (localWebRtcAudioEffects != null) {
      localWebRtcAudioEffects.release();
    }
    releaseAudioResources();
    return true;
  }
  
  public static enum AudioRecordStartErrorCode
  {
    static
    {
      AudioRecordStartErrorCode localAudioRecordStartErrorCode1 = new AudioRecordStartErrorCode("AUDIO_RECORD_START_EXCEPTION", 0);
      AUDIO_RECORD_START_EXCEPTION = localAudioRecordStartErrorCode1;
      AudioRecordStartErrorCode localAudioRecordStartErrorCode2 = new AudioRecordStartErrorCode("AUDIO_RECORD_START_STATE_MISMATCH", 1);
      AUDIO_RECORD_START_STATE_MISMATCH = localAudioRecordStartErrorCode2;
      $VALUES = new AudioRecordStartErrorCode[] { localAudioRecordStartErrorCode1, localAudioRecordStartErrorCode2 };
    }
    
    private AudioRecordStartErrorCode() {}
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
      Logging.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
      boolean bool;
      if (WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      WebRtcAudioRecord.assertTrue(bool);
      System.nanoTime();
      while (this.keepAlive)
      {
        int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
        if (i == WebRtcAudioRecord.this.byteBuffer.capacity())
        {
          if (WebRtcAudioRecord.microphoneMute)
          {
            WebRtcAudioRecord.this.byteBuffer.clear();
            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
          }
          if (this.keepAlive)
          {
            localObject = WebRtcAudioRecord.this;
            ((WebRtcAudioRecord)localObject).nativeDataIsRecorded(i, ((WebRtcAudioRecord)localObject).nativeAudioRecord);
          }
          if (WebRtcAudioRecord.audioSamplesReadyCallback != null)
          {
            localObject = Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity());
            WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new WebRtcAudioRecord.AudioSamples(WebRtcAudioRecord.this.audioRecord, (byte[])localObject, null));
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AudioRecord.read failed: ");
          ((StringBuilder)localObject).append(i);
          localObject = ((StringBuilder)localObject).toString();
          Logging.e("WebRtcAudioRecord", (String)localObject);
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
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AudioRecord.stop failed: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        Logging.e("WebRtcAudioRecord", localStringBuilder.toString());
      }
    }
    
    public void stopThread()
    {
      Logging.d("WebRtcAudioRecord", "stopThread");
      this.keepAlive = false;
    }
  }
  
  public static class AudioSamples
  {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;
    
    private AudioSamples(AudioRecord paramAudioRecord, byte[] paramArrayOfByte)
    {
      this.audioFormat = paramAudioRecord.getAudioFormat();
      this.channelCount = paramAudioRecord.getChannelCount();
      this.sampleRate = paramAudioRecord.getSampleRate();
      this.data = paramArrayOfByte;
    }
    
    public int getAudioFormat()
    {
      return this.audioFormat;
    }
    
    public int getChannelCount()
    {
      return this.channelCount;
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public int getSampleRate()
    {
      return this.sampleRate;
    }
  }
  
  public static abstract interface WebRtcAudioRecordErrorCallback
  {
    public abstract void onWebRtcAudioRecordError(String paramString);
    
    public abstract void onWebRtcAudioRecordInitError(String paramString);
    
    public abstract void onWebRtcAudioRecordStartError(WebRtcAudioRecord.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString);
  }
  
  public static abstract interface WebRtcAudioRecordSamplesReadyCallback
  {
    public abstract void onWebRtcAudioRecordSamplesReady(WebRtcAudioRecord.AudioSamples paramAudioSamples);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioRecord
 * JD-Core Version:    0.7.0.1
 */