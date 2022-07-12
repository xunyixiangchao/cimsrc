package org.webrtc.voiceengine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;

public class WebRtcAudioManager
{
  private static final int BITS_PER_SAMPLE = 16;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_FRAME_PER_BUFFER = 256;
  private static final String TAG = "WebRtcAudioManager";
  private static final boolean blacklistDeviceForAAudioUsage = true;
  private static boolean blacklistDeviceForOpenSLESUsage;
  private static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
  private static boolean useStereoInput;
  private static boolean useStereoOutput;
  private boolean aAudio;
  private final AudioManager audioManager;
  private boolean hardwareAEC;
  private boolean hardwareAGC;
  private boolean hardwareNS;
  private boolean initialized;
  private int inputBufferSize;
  private int inputChannels;
  private boolean lowLatencyInput;
  private boolean lowLatencyOutput;
  private final long nativeAudioManager;
  private int nativeChannels;
  private int nativeSampleRate;
  private int outputBufferSize;
  private int outputChannels;
  private boolean proAudio;
  private int sampleRate;
  private final VolumeLogger volumeLogger;
  
  WebRtcAudioManager(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ctor");
    ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioManager", ((StringBuilder)localObject).toString());
    this.nativeAudioManager = paramLong;
    localObject = (AudioManager)ContextUtils.getApplicationContext().getSystemService("audio");
    this.audioManager = ((AudioManager)localObject);
    this.volumeLogger = new VolumeLogger((AudioManager)localObject);
    storeAudioParameters();
    nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, paramLong);
    WebRtcAudioUtils.logAudioState("WebRtcAudioManager");
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError("Expected condition to be true");
  }
  
  private void dispose()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispose");
    localStringBuilder.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioManager", localStringBuilder.toString());
    if (!this.initialized) {
      return;
    }
    this.volumeLogger.stop();
  }
  
  private int getLowLatencyInputFramesPerBuffer()
  {
    assertTrue(isLowLatencyInputSupported());
    return getLowLatencyOutputFramesPerBuffer();
  }
  
  private int getLowLatencyOutputFramesPerBuffer()
  {
    assertTrue(isLowLatencyOutputSupported());
    String str = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
    if (str == null) {
      return 256;
    }
    return Integer.parseInt(str);
  }
  
  private static int getMinInputFrameSize(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 1) {
      i = 16;
    } else {
      i = 12;
    }
    return AudioRecord.getMinBufferSize(paramInt1, i, 2) / (paramInt2 * 2);
  }
  
  private static int getMinOutputFrameSize(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 1) {
      i = 4;
    } else {
      i = 12;
    }
    return AudioTrack.getMinBufferSize(paramInt1, i, 2) / (paramInt2 * 2);
  }
  
  private int getNativeOutputSampleRate()
  {
    if (WebRtcAudioUtils.runningOnEmulator())
    {
      Logging.d("WebRtcAudioManager", "Running emulator, overriding sample rate to 8 kHz.");
      return 8000;
    }
    if (WebRtcAudioUtils.isDefaultSampleRateOverridden())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Default sample rate is overriden to ");
      localStringBuilder.append(WebRtcAudioUtils.getDefaultSampleRateHz());
      localStringBuilder.append(" Hz");
      Logging.d("WebRtcAudioManager", localStringBuilder.toString());
      return WebRtcAudioUtils.getDefaultSampleRateHz();
    }
    int i = getSampleRateForApiLevel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sample rate is set to ");
    localStringBuilder.append(i);
    localStringBuilder.append(" Hz");
    Logging.d("WebRtcAudioManager", localStringBuilder.toString());
    return i;
  }
  
  private int getSampleRateForApiLevel()
  {
    String str = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
    if (str == null) {
      return WebRtcAudioUtils.getDefaultSampleRateHz();
    }
    return Integer.parseInt(str);
  }
  
  public static boolean getStereoInput()
  {
    try
    {
      boolean bool = useStereoInput;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean getStereoOutput()
  {
    try
    {
      boolean bool = useStereoOutput;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean hasEarpiece()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
  }
  
  private boolean init()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init");
    localStringBuilder.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioManager", localStringBuilder.toString());
    if (this.initialized) {
      return true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("audio mode is: ");
    localStringBuilder.append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
    Logging.d("WebRtcAudioManager", localStringBuilder.toString());
    this.initialized = true;
    this.volumeLogger.start();
    return true;
  }
  
  private boolean isAAudioSupported()
  {
    Logging.w("WebRtcAudioManager", "AAudio support is currently disabled on all devices!");
    return false;
  }
  
  private static boolean isAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.canUseAcousticEchoCanceler();
  }
  
  private boolean isCommunicationModeEnabled()
  {
    return this.audioManager.getMode() == 3;
  }
  
  private boolean isDeviceBlacklistedForOpenSLESUsage()
  {
    boolean bool;
    if (blacklistDeviceForOpenSLESUsageIsOverridden) {
      bool = blacklistDeviceForOpenSLESUsage;
    } else {
      bool = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
    }
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append(" is blacklisted for OpenSL ES usage!");
      Logging.d("WebRtcAudioManager", localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean isLowLatencyOutputSupported()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }
  
  private static boolean isNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.canUseNoiseSuppressor();
  }
  
  private boolean isProAudioSupported()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro");
  }
  
  private native void nativeCacheAudioParameters(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt4, int paramInt5, long paramLong);
  
  public static void setBlacklistDeviceForOpenSLESUsage(boolean paramBoolean)
  {
    try
    {
      blacklistDeviceForOpenSLESUsageIsOverridden = true;
      blacklistDeviceForOpenSLESUsage = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setStereoInput(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Overriding default input behavior: setStereoInput(");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(')');
      Logging.w("WebRtcAudioManager", localStringBuilder.toString());
      useStereoInput = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setStereoOutput(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Overriding default output behavior: setStereoOutput(");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(')');
      Logging.w("WebRtcAudioManager", localStringBuilder.toString());
      useStereoOutput = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void storeAudioParameters()
  {
    boolean bool = getStereoOutput();
    int j = 2;
    int i;
    if (bool) {
      i = 2;
    } else {
      i = 1;
    }
    this.outputChannels = i;
    if (getStereoInput()) {
      i = j;
    } else {
      i = 1;
    }
    this.inputChannels = i;
    this.sampleRate = getNativeOutputSampleRate();
    this.hardwareAEC = isAcousticEchoCancelerSupported();
    this.hardwareAGC = false;
    this.hardwareNS = isNoiseSuppressorSupported();
    this.lowLatencyOutput = isLowLatencyOutputSupported();
    this.lowLatencyInput = isLowLatencyInputSupported();
    this.proAudio = isProAudioSupported();
    this.aAudio = isAAudioSupported();
    if (this.lowLatencyOutput) {
      i = getLowLatencyOutputFramesPerBuffer();
    } else {
      i = getMinOutputFrameSize(this.sampleRate, this.outputChannels);
    }
    this.outputBufferSize = i;
    if (this.lowLatencyInput) {
      i = getLowLatencyInputFramesPerBuffer();
    } else {
      i = getMinInputFrameSize(this.sampleRate, this.inputChannels);
    }
    this.inputBufferSize = i;
  }
  
  public boolean isLowLatencyInputSupported()
  {
    return isLowLatencyOutputSupported();
  }
  
  private static class VolumeLogger
  {
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;
    private Timer timer;
    
    public VolumeLogger(AudioManager paramAudioManager)
    {
      this.audioManager = paramAudioManager;
    }
    
    private void stop()
    {
      Timer localTimer = this.timer;
      if (localTimer != null)
      {
        localTimer.cancel();
        this.timer = null;
      }
    }
    
    public void start()
    {
      Timer localTimer = new Timer("WebRtcVolumeLevelLoggerThread");
      this.timer = localTimer;
      localTimer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }
    
    private class LogVolumeTask
      extends TimerTask
    {
      private final int maxRingVolume;
      private final int maxVoiceCallVolume;
      
      LogVolumeTask(int paramInt1, int paramInt2)
      {
        this.maxRingVolume = paramInt1;
        this.maxVoiceCallVolume = paramInt2;
      }
      
      public void run()
      {
        int i = WebRtcAudioManager.VolumeLogger.this.audioManager.getMode();
        StringBuilder localStringBuilder;
        if (i == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("STREAM_RING stream volume: ");
          localStringBuilder.append(WebRtcAudioManager.VolumeLogger.this.audioManager.getStreamVolume(2));
          localStringBuilder.append(" (max=");
        }
        for (i = this.maxRingVolume;; i = this.maxVoiceCallVolume)
        {
          localStringBuilder.append(i);
          localStringBuilder.append(")");
          Logging.d("WebRtcAudioManager", localStringBuilder.toString());
          return;
          if (i != 3) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("VOICE_CALL stream volume: ");
          localStringBuilder.append(WebRtcAudioManager.VolumeLogger.this.audioManager.getStreamVolume(0));
          localStringBuilder.append(" (max=");
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioManager
 * JD-Core Version:    0.7.0.1
 */