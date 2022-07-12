package org.webrtc.voiceengine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;

public final class WebRtcAudioUtils
{
  private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
  private static final String[] BLACKLISTED_NS_MODELS = new String[0];
  private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
  private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
  private static final String TAG = "WebRtcAudioUtils";
  private static int defaultSampleRateHz = 16000;
  private static boolean isDefaultSampleRateOverridden;
  private static boolean useWebRtcBasedAcousticEchoCanceler;
  private static boolean useWebRtcBasedNoiseSuppressor;
  
  public static boolean deviceIsBlacklistedForOpenSLESUsage()
  {
    return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
  }
  
  private static String deviceTypeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "TYPE_UNKNOWN";
    case 22: 
      return "TYPE_USB_HEADSET";
    case 21: 
      return "TYPE_BUS";
    case 20: 
      return "TYPE_IP";
    case 19: 
      return "TYPE_AUX_LINE";
    case 18: 
      return "TYPE_TELEPHONY";
    case 17: 
      return "TYPE_TV_TUNER";
    case 16: 
      return "TYPE_FM_TUNER";
    case 15: 
      return "TYPE_BUILTIN_MIC";
    case 14: 
      return "TYPE_FM";
    case 13: 
      return "TYPE_DOCK";
    case 12: 
      return "TYPE_USB_ACCESSORY";
    case 11: 
      return "TYPE_USB_DEVICE";
    case 10: 
      return "TYPE_HDMI_ARC";
    case 9: 
      return "TYPE_HDMI";
    case 8: 
      return "TYPE_BLUETOOTH_A2DP";
    case 7: 
      return "TYPE_BLUETOOTH_SCO";
    case 6: 
      return "TYPE_LINE_DIGITAL";
    case 5: 
      return "TYPE_LINE_ANALOG";
    case 4: 
      return "TYPE_WIRED_HEADPHONES";
    case 3: 
      return "TYPE_WIRED_HEADSET";
    case 2: 
      return "TYPE_BUILTIN_SPEAKER";
    }
    return "TYPE_BUILTIN_EARPIECE";
  }
  
  public static List<String> getBlackListedModelsForAecUsage()
  {
    return Arrays.asList(BLACKLISTED_AEC_MODELS);
  }
  
  public static List<String> getBlackListedModelsForNsUsage()
  {
    return Arrays.asList(BLACKLISTED_NS_MODELS);
  }
  
  public static int getDefaultSampleRateHz()
  {
    try
    {
      int i = defaultSampleRateHz;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getThreadInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@[name=");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(", id=");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private static boolean hasMicrophone()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
  }
  
  public static boolean isAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.canUseAcousticEchoCanceler();
  }
  
  public static boolean isAutomaticGainControlSupported()
  {
    return false;
  }
  
  public static boolean isDefaultSampleRateOverridden()
  {
    try
    {
      boolean bool = isDefaultSampleRateOverridden;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.canUseNoiseSuppressor();
  }
  
  private static boolean isVolumeFixed(AudioManager paramAudioManager)
  {
    return paramAudioManager.isVolumeFixed();
  }
  
  private static void logAudioDeviceInfo(String paramString, AudioManager paramAudioManager)
  {
    AudioDeviceInfo[] arrayOfAudioDeviceInfo = paramAudioManager.getDevices(3);
    if (arrayOfAudioDeviceInfo.length == 0) {
      return;
    }
    Logging.d(paramString, "Audio Devices: ");
    int j = arrayOfAudioDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      AudioDeviceInfo localAudioDeviceInfo = arrayOfAudioDeviceInfo[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  ");
      localStringBuilder.append(deviceTypeToString(localAudioDeviceInfo.getType()));
      if (localAudioDeviceInfo.isSource()) {
        paramAudioManager = "(in): ";
      } else {
        paramAudioManager = "(out): ";
      }
      localStringBuilder.append(paramAudioManager);
      if (localAudioDeviceInfo.getChannelCounts().length > 0)
      {
        localStringBuilder.append("channels=");
        localStringBuilder.append(Arrays.toString(localAudioDeviceInfo.getChannelCounts()));
        localStringBuilder.append(", ");
      }
      if (localAudioDeviceInfo.getEncodings().length > 0)
      {
        localStringBuilder.append("encodings=");
        localStringBuilder.append(Arrays.toString(localAudioDeviceInfo.getEncodings()));
        localStringBuilder.append(", ");
      }
      if (localAudioDeviceInfo.getSampleRates().length > 0)
      {
        localStringBuilder.append("sample rates=");
        localStringBuilder.append(Arrays.toString(localAudioDeviceInfo.getSampleRates()));
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id=");
      localStringBuilder.append(localAudioDeviceInfo.getId());
      Logging.d(paramString, localStringBuilder.toString());
      i += 1;
    }
  }
  
  static void logAudioState(String paramString)
  {
    logDeviceInfo(paramString);
    AudioManager localAudioManager = (AudioManager)ContextUtils.getApplicationContext().getSystemService("audio");
    logAudioStateBasic(paramString, localAudioManager);
    logAudioStateVolume(paramString, localAudioManager);
    logAudioDeviceInfo(paramString, localAudioManager);
  }
  
  private static void logAudioStateBasic(String paramString, AudioManager paramAudioManager)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Audio State: audio mode: ");
    localStringBuilder.append(modeToString(paramAudioManager.getMode()));
    localStringBuilder.append(", has mic: ");
    localStringBuilder.append(hasMicrophone());
    localStringBuilder.append(", mic muted: ");
    localStringBuilder.append(paramAudioManager.isMicrophoneMute());
    localStringBuilder.append(", music active: ");
    localStringBuilder.append(paramAudioManager.isMusicActive());
    localStringBuilder.append(", speakerphone: ");
    localStringBuilder.append(paramAudioManager.isSpeakerphoneOn());
    localStringBuilder.append(", BT SCO: ");
    localStringBuilder.append(paramAudioManager.isBluetoothScoOn());
    Logging.d(paramString, localStringBuilder.toString());
  }
  
  private static void logAudioStateVolume(String paramString, AudioManager paramAudioManager)
  {
    Logging.d(paramString, "Audio State: ");
    boolean bool = isVolumeFixed(paramAudioManager);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("  fixed volume=");
    localStringBuilder1.append(bool);
    Logging.d(paramString, localStringBuilder1.toString());
    if (!bool)
    {
      int i = 0;
      while (i < 6)
      {
        int j = new int[] { 0, 3, 2, 4, 5, 1 }[i];
        localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("  ");
        localStringBuilder2.append(streamTypeToString(j));
        localStringBuilder2.append(": ");
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("volume=");
        localStringBuilder1.append(paramAudioManager.getStreamVolume(j));
        localStringBuilder1.append(", max=");
        localStringBuilder1.append(paramAudioManager.getStreamMaxVolume(j));
        logIsStreamMute(paramString, paramAudioManager, j, localStringBuilder1);
        Logging.d(paramString, localStringBuilder1.toString());
        i += 1;
      }
    }
  }
  
  static void logDeviceInfo(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android SDK: ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(", Release: ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append(", Brand: ");
    localStringBuilder.append(Build.BRAND);
    localStringBuilder.append(", Device: ");
    localStringBuilder.append(Build.DEVICE);
    localStringBuilder.append(", Id: ");
    localStringBuilder.append(Build.ID);
    localStringBuilder.append(", Hardware: ");
    localStringBuilder.append(Build.HARDWARE);
    localStringBuilder.append(", Manufacturer: ");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(", Model: ");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(", Product: ");
    localStringBuilder.append(Build.PRODUCT);
    Logging.d(paramString, localStringBuilder.toString());
  }
  
  private static void logIsStreamMute(String paramString, AudioManager paramAudioManager, int paramInt, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(", muted=");
    paramStringBuilder.append(paramAudioManager.isStreamMute(paramInt));
  }
  
  static String modeToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "MODE_INVALID";
          }
          return "MODE_IN_COMMUNICATION";
        }
        return "MODE_IN_CALL";
      }
      return "MODE_RINGTONE";
    }
    return "MODE_NORMAL";
  }
  
  public static boolean runningOnEmulator()
  {
    return (Build.HARDWARE.equals("goldfish")) && (Build.BRAND.startsWith("generic_"));
  }
  
  public static void setDefaultSampleRateHz(int paramInt)
  {
    try
    {
      isDefaultSampleRateOverridden = true;
      defaultSampleRateHz = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setWebRtcBasedAcousticEchoCanceler(boolean paramBoolean)
  {
    try
    {
      useWebRtcBasedAcousticEchoCanceler = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setWebRtcBasedAutomaticGainControl(boolean paramBoolean)
  {
    try
    {
      Logging.w("WebRtcAudioUtils", "setWebRtcBasedAutomaticGainControl() is deprecated");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setWebRtcBasedNoiseSuppressor(boolean paramBoolean)
  {
    try
    {
      useWebRtcBasedNoiseSuppressor = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String streamTypeToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "STREAM_INVALID";
              }
              return "STREAM_NOTIFICATION";
            }
            return "STREAM_ALARM";
          }
          return "STREAM_MUSIC";
        }
        return "STREAM_RING";
      }
      return "STREAM_SYSTEM";
    }
    return "STREAM_VOICE_CALL";
  }
  
  public static boolean useWebRtcBasedAcousticEchoCanceler()
  {
    try
    {
      if (useWebRtcBasedAcousticEchoCanceler) {
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC AEC!");
      }
      boolean bool = useWebRtcBasedAcousticEchoCanceler;
      return bool;
    }
    finally {}
  }
  
  public static boolean useWebRtcBasedAutomaticGainControl()
  {
    return true;
  }
  
  public static boolean useWebRtcBasedNoiseSuppressor()
  {
    try
    {
      if (useWebRtcBasedNoiseSuppressor) {
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC NS!");
      }
      boolean bool = useWebRtcBasedNoiseSuppressor;
      return bool;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioUtils
 * JD-Core Version:    0.7.0.1
 */