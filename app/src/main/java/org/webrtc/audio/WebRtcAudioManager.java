package org.webrtc.audio;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;

class WebRtcAudioManager
{
  private static final int BITS_PER_SAMPLE = 16;
  private static final int DEFAULT_FRAME_PER_BUFFER = 256;
  private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
  private static final String TAG = "WebRtcAudioManagerExternal";
  
  @CalledByNative
  static AudioManager getAudioManager(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  @CalledByNative
  static int getInputBufferSize(Context paramContext, AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    if (isLowLatencyInputSupported(paramContext)) {
      return getLowLatencyFramesPerBuffer(paramAudioManager);
    }
    return getMinInputFrameSize(paramInt1, paramInt2);
  }
  
  private static int getLowLatencyFramesPerBuffer(AudioManager paramAudioManager)
  {
    paramAudioManager = paramAudioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
    if (paramAudioManager == null) {
      return 256;
    }
    return Integer.parseInt(paramAudioManager);
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
  
  @CalledByNative
  static int getOutputBufferSize(Context paramContext, AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    if (isLowLatencyOutputSupported(paramContext)) {
      return getLowLatencyFramesPerBuffer(paramAudioManager);
    }
    return getMinOutputFrameSize(paramInt1, paramInt2);
  }
  
  @CalledByNative
  static int getSampleRate(AudioManager paramAudioManager)
  {
    if (WebRtcAudioUtils.runningOnEmulator())
    {
      Logging.d("WebRtcAudioManagerExternal", "Running emulator, overriding sample rate to 8 kHz.");
      return 8000;
    }
    int i = getSampleRateForApiLevel(paramAudioManager);
    paramAudioManager = new StringBuilder();
    paramAudioManager.append("Sample rate is set to ");
    paramAudioManager.append(i);
    paramAudioManager.append(" Hz");
    Logging.d("WebRtcAudioManagerExternal", paramAudioManager.toString());
    return i;
  }
  
  private static int getSampleRateForApiLevel(AudioManager paramAudioManager)
  {
    paramAudioManager = paramAudioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
    if (paramAudioManager == null) {
      return 16000;
    }
    return Integer.parseInt(paramAudioManager);
  }
  
  private static boolean isLowLatencyInputSupported(Context paramContext)
  {
    return isLowLatencyOutputSupported(paramContext);
  }
  
  private static boolean isLowLatencyOutputSupported(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.WebRtcAudioManager
 * JD-Core Version:    0.7.0.1
 */