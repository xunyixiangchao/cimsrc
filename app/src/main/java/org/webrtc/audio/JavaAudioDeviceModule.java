package org.webrtc.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import org.webrtc.JniCommon;
import org.webrtc.Logging;

public class JavaAudioDeviceModule
  implements AudioDeviceModule
{
  private static final String TAG = "JavaAudioDeviceModule";
  private final WebRtcAudioRecord audioInput;
  private final AudioManager audioManager;
  private final WebRtcAudioTrack audioOutput;
  private final Context context;
  private final int inputSampleRate;
  private long nativeAudioDeviceModule;
  private final Object nativeLock = new Object();
  private final int outputSampleRate;
  private final boolean useStereoInput;
  private final boolean useStereoOutput;
  
  private JavaAudioDeviceModule(Context paramContext, AudioManager paramAudioManager, WebRtcAudioRecord paramWebRtcAudioRecord, WebRtcAudioTrack paramWebRtcAudioTrack, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.audioInput = paramWebRtcAudioRecord;
    this.audioOutput = paramWebRtcAudioTrack;
    this.inputSampleRate = paramInt1;
    this.outputSampleRate = paramInt2;
    this.useStereoInput = paramBoolean1;
    this.useStereoOutput = paramBoolean2;
  }
  
  public static Builder builder(Context paramContext)
  {
    return new Builder(paramContext, null);
  }
  
  public static boolean isBuiltInAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.isAcousticEchoCancelerSupported();
  }
  
  public static boolean isBuiltInNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.isNoiseSuppressorSupported();
  }
  
  private static native long nativeCreateAudioDeviceModule(Context paramContext, AudioManager paramAudioManager, WebRtcAudioRecord paramWebRtcAudioRecord, WebRtcAudioTrack paramWebRtcAudioTrack, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public long getNativeAudioDeviceModulePointer()
  {
    synchronized (this.nativeLock)
    {
      if (this.nativeAudioDeviceModule == 0L) {
        this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
      }
      long l = this.nativeAudioDeviceModule;
      return l;
    }
  }
  
  public void release()
  {
    synchronized (this.nativeLock)
    {
      long l = this.nativeAudioDeviceModule;
      if (l != 0L)
      {
        JniCommon.nativeReleaseRef(l);
        this.nativeAudioDeviceModule = 0L;
      }
      return;
    }
  }
  
  public void setMicrophoneMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMicrophoneMute: ");
    localStringBuilder.append(paramBoolean);
    Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
    this.audioInput.setMicrophoneMute(paramBoolean);
  }
  
  public void setPreferredInputDevice(AudioDeviceInfo paramAudioDeviceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreferredInputDevice: ");
    localStringBuilder.append(paramAudioDeviceInfo);
    Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
    this.audioInput.setPreferredDevice(paramAudioDeviceInfo);
  }
  
  public void setSpeakerMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeakerMute: ");
    localStringBuilder.append(paramBoolean);
    Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
    this.audioOutput.setSpeakerMute(paramBoolean);
  }
  
  public static abstract interface AudioRecordErrorCallback
  {
    public abstract void onWebRtcAudioRecordError(String paramString);
    
    public abstract void onWebRtcAudioRecordInitError(String paramString);
    
    public abstract void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString);
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
  
  public static abstract interface AudioRecordStateCallback
  {
    public abstract void onWebRtcAudioRecordStart();
    
    public abstract void onWebRtcAudioRecordStop();
  }
  
  public static class AudioSamples
  {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;
    
    public AudioSamples(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.audioFormat = paramInt1;
      this.channelCount = paramInt2;
      this.sampleRate = paramInt3;
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
  
  public static abstract interface AudioTrackErrorCallback
  {
    public abstract void onWebRtcAudioTrackError(String paramString);
    
    public abstract void onWebRtcAudioTrackInitError(String paramString);
    
    public abstract void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString);
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
  
  public static abstract interface AudioTrackStateCallback
  {
    public abstract void onWebRtcAudioTrackStart();
    
    public abstract void onWebRtcAudioTrackStop();
  }
  
  public static class Builder
  {
    private int audioFormat = 2;
    private final AudioManager audioManager;
    private JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback;
    private JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback;
    private int audioSource = 7;
    private JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback;
    private JavaAudioDeviceModule.AudioTrackStateCallback audioTrackStateCallback;
    private final Context context;
    private int inputSampleRate;
    private int outputSampleRate;
    private JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback;
    private boolean useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
    private boolean useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
    private boolean useStereoInput;
    private boolean useStereoOutput;
    
    private Builder(Context paramContext)
    {
      this.context = paramContext;
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      this.audioManager = paramContext;
      this.inputSampleRate = WebRtcAudioManager.getSampleRate(paramContext);
      this.outputSampleRate = WebRtcAudioManager.getSampleRate(paramContext);
    }
    
    public JavaAudioDeviceModule createAudioDeviceModule()
    {
      Logging.d("JavaAudioDeviceModule", "createAudioDeviceModule");
      if (this.useHardwareNoiseSuppressor) {}
      for (Object localObject = "HW NS will be used.";; localObject = "HW NS will not be used.")
      {
        Logging.d("JavaAudioDeviceModule", (String)localObject);
        break;
        if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
          Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC NS!");
        }
      }
      if (this.useHardwareAcousticEchoCanceler) {}
      for (localObject = "HW AEC will be used.";; localObject = "HW AEC will not be used.")
      {
        Logging.d("JavaAudioDeviceModule", (String)localObject);
        break;
        if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
          Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC AEC!");
        }
      }
      localObject = new WebRtcAudioRecord(this.context, this.audioManager, this.audioSource, this.audioFormat, this.audioRecordErrorCallback, this.audioRecordStateCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor);
      WebRtcAudioTrack localWebRtcAudioTrack = new WebRtcAudioTrack(this.context, this.audioManager, this.audioTrackErrorCallback, this.audioTrackStateCallback);
      return new JavaAudioDeviceModule(this.context, this.audioManager, (WebRtcAudioRecord)localObject, localWebRtcAudioTrack, this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput, null);
    }
    
    public Builder setAudioFormat(int paramInt)
    {
      this.audioFormat = paramInt;
      return this;
    }
    
    public Builder setAudioRecordErrorCallback(JavaAudioDeviceModule.AudioRecordErrorCallback paramAudioRecordErrorCallback)
    {
      this.audioRecordErrorCallback = paramAudioRecordErrorCallback;
      return this;
    }
    
    public Builder setAudioRecordStateCallback(JavaAudioDeviceModule.AudioRecordStateCallback paramAudioRecordStateCallback)
    {
      this.audioRecordStateCallback = paramAudioRecordStateCallback;
      return this;
    }
    
    public Builder setAudioSource(int paramInt)
    {
      this.audioSource = paramInt;
      return this;
    }
    
    public Builder setAudioTrackErrorCallback(JavaAudioDeviceModule.AudioTrackErrorCallback paramAudioTrackErrorCallback)
    {
      this.audioTrackErrorCallback = paramAudioTrackErrorCallback;
      return this;
    }
    
    public Builder setAudioTrackStateCallback(JavaAudioDeviceModule.AudioTrackStateCallback paramAudioTrackStateCallback)
    {
      this.audioTrackStateCallback = paramAudioTrackStateCallback;
      return this;
    }
    
    public Builder setInputSampleRate(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Input sample rate overridden to: ");
      localStringBuilder.append(paramInt);
      Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
      this.inputSampleRate = paramInt;
      return this;
    }
    
    public Builder setOutputSampleRate(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Output sample rate overridden to: ");
      localStringBuilder.append(paramInt);
      Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
      this.outputSampleRate = paramInt;
      return this;
    }
    
    public Builder setSampleRate(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Input/Output sample rate overridden to: ");
      localStringBuilder.append(paramInt);
      Logging.d("JavaAudioDeviceModule", localStringBuilder.toString());
      this.inputSampleRate = paramInt;
      this.outputSampleRate = paramInt;
      return this;
    }
    
    public Builder setSamplesReadyCallback(JavaAudioDeviceModule.SamplesReadyCallback paramSamplesReadyCallback)
    {
      this.samplesReadyCallback = paramSamplesReadyCallback;
      return this;
    }
    
    public Builder setUseHardwareAcousticEchoCanceler(boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported())
        {
          Logging.e("JavaAudioDeviceModule", "HW AEC not supported");
          bool = false;
        }
      }
      this.useHardwareAcousticEchoCanceler = bool;
      return this;
    }
    
    public Builder setUseHardwareNoiseSuppressor(boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported())
        {
          Logging.e("JavaAudioDeviceModule", "HW NS not supported");
          bool = false;
        }
      }
      this.useHardwareNoiseSuppressor = bool;
      return this;
    }
    
    public Builder setUseStereoInput(boolean paramBoolean)
    {
      this.useStereoInput = paramBoolean;
      return this;
    }
    
    public Builder setUseStereoOutput(boolean paramBoolean)
    {
      this.useStereoOutput = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface SamplesReadyCallback
  {
    public abstract void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples paramAudioSamples);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.JavaAudioDeviceModule
 * JD-Core Version:    0.7.0.1
 */