package org.webrtc.voiceengine;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import java.util.List;
import java.util.UUID;
import org.webrtc.Logging;

public class WebRtcAudioEffects
{
  private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
  private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
  private static final boolean DEBUG = false;
  private static final String TAG = "WebRtcAudioEffects";
  private static AudioEffect.Descriptor[] cachedEffects;
  private AcousticEchoCanceler aec;
  private NoiseSuppressor ns;
  private boolean shouldEnableAec;
  private boolean shouldEnableNs;
  
  private WebRtcAudioEffects()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ctor");
    localStringBuilder.append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError("Expected condition to be true");
  }
  
  public static boolean canUseAcousticEchoCanceler()
  {
    boolean bool;
    if ((isAcousticEchoCancelerSupported()) && (!WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler()) && (!isAcousticEchoCancelerBlacklisted()) && (!isAcousticEchoCancelerExcludedByUUID())) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canUseAcousticEchoCanceler: ");
    localStringBuilder.append(bool);
    Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
    return bool;
  }
  
  public static boolean canUseNoiseSuppressor()
  {
    boolean bool;
    if ((isNoiseSuppressorSupported()) && (!WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor()) && (!isNoiseSuppressorBlacklisted()) && (!isNoiseSuppressorExcludedByUUID())) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canUseNoiseSuppressor: ");
    localStringBuilder.append(bool);
    Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
    return bool;
  }
  
  public static WebRtcAudioEffects create()
  {
    return new WebRtcAudioEffects();
  }
  
  private boolean effectTypeIsVoIP(UUID paramUUID)
  {
    return ((AudioEffect.EFFECT_TYPE_AEC.equals(paramUUID)) && (isAcousticEchoCancelerSupported())) || ((AudioEffect.EFFECT_TYPE_NS.equals(paramUUID)) && (isNoiseSuppressorSupported()));
  }
  
  private static AudioEffect.Descriptor[] getAvailableEffects()
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = cachedEffects;
    if (arrayOfDescriptor != null) {
      return arrayOfDescriptor;
    }
    arrayOfDescriptor = AudioEffect.queryEffects();
    cachedEffects = arrayOfDescriptor;
    return arrayOfDescriptor;
  }
  
  public static boolean isAcousticEchoCancelerBlacklisted()
  {
    Object localObject = WebRtcAudioUtils.getBlackListedModelsForAecUsage();
    String str = Build.MODEL;
    boolean bool = ((List)localObject).contains(str);
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" is blacklisted for HW AEC usage!");
      Logging.w("WebRtcAudioEffects", ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private static boolean isAcousticEchoCancelerEffectAvailable()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
  }
  
  private static boolean isAcousticEchoCancelerExcludedByUUID()
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    int j = arrayOfDescriptor.length;
    int i = 0;
    while (i < j)
    {
      AudioEffect.Descriptor localDescriptor = arrayOfDescriptor[i];
      if ((localDescriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC)) && (localDescriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isAcousticEchoCancelerSupported()
  {
    return isAcousticEchoCancelerEffectAvailable();
  }
  
  private static boolean isEffectTypeAvailable(UUID paramUUID)
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    if (arrayOfDescriptor == null) {
      return false;
    }
    int j = arrayOfDescriptor.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfDescriptor[i].type.equals(paramUUID)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isNoiseSuppressorBlacklisted()
  {
    Object localObject = WebRtcAudioUtils.getBlackListedModelsForNsUsage();
    String str = Build.MODEL;
    boolean bool = ((List)localObject).contains(str);
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" is blacklisted for HW NS usage!");
      Logging.w("WebRtcAudioEffects", ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private static boolean isNoiseSuppressorEffectAvailable()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
  }
  
  private static boolean isNoiseSuppressorExcludedByUUID()
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    int j = arrayOfDescriptor.length;
    int i = 0;
    while (i < j)
    {
      AudioEffect.Descriptor localDescriptor = arrayOfDescriptor[i];
      if ((localDescriptor.type.equals(AudioEffect.EFFECT_TYPE_NS)) && (localDescriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isNoiseSuppressorSupported()
  {
    return isNoiseSuppressorEffectAvailable();
  }
  
  public void enable(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enable(audioSession=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(")");
    Logging.d("WebRtcAudioEffects", ((StringBuilder)localObject).toString());
    localObject = this.aec;
    boolean bool2 = true;
    if (localObject == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    assertTrue(bool1);
    if (this.ns == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    assertTrue(bool1);
    boolean bool1 = isAcousticEchoCancelerSupported();
    String str = "enabled";
    boolean bool3;
    StringBuilder localStringBuilder;
    if (bool1)
    {
      localObject = AcousticEchoCanceler.create(paramInt);
      this.aec = ((AcousticEchoCanceler)localObject);
      if (localObject != null)
      {
        bool3 = ((AcousticEchoCanceler)localObject).getEnabled();
        if ((this.shouldEnableAec) && (canUseAcousticEchoCanceler())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (this.aec.setEnabled(bool1) != 0) {
          Logging.e("WebRtcAudioEffects", "Failed to set the AcousticEchoCanceler state");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("AcousticEchoCanceler: was ");
        if (bool3) {
          localObject = "enabled";
        } else {
          localObject = "disabled";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", enable: ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", is now: ");
        if (this.aec.getEnabled()) {
          localObject = "enabled";
        } else {
          localObject = "disabled";
        }
        localStringBuilder.append((String)localObject);
        Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
      }
      else
      {
        Logging.e("WebRtcAudioEffects", "Failed to create the AcousticEchoCanceler instance");
      }
    }
    if (isNoiseSuppressorSupported())
    {
      localObject = NoiseSuppressor.create(paramInt);
      this.ns = ((NoiseSuppressor)localObject);
      if (localObject != null)
      {
        bool3 = ((NoiseSuppressor)localObject).getEnabled();
        if ((this.shouldEnableNs) && (canUseNoiseSuppressor())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        if (this.ns.setEnabled(bool1) != 0) {
          Logging.e("WebRtcAudioEffects", "Failed to set the NoiseSuppressor state");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("NoiseSuppressor: was ");
        if (bool3) {
          localObject = "enabled";
        } else {
          localObject = "disabled";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", enable: ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", is now: ");
        if (this.ns.getEnabled()) {
          localObject = str;
        } else {
          localObject = "disabled";
        }
        localStringBuilder.append((String)localObject);
        Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
        return;
      }
      Logging.e("WebRtcAudioEffects", "Failed to create the NoiseSuppressor instance");
    }
  }
  
  public void release()
  {
    Logging.d("WebRtcAudioEffects", "release");
    Object localObject = this.aec;
    if (localObject != null)
    {
      ((AcousticEchoCanceler)localObject).release();
      this.aec = null;
    }
    localObject = this.ns;
    if (localObject != null)
    {
      ((NoiseSuppressor)localObject).release();
      this.ns = null;
    }
  }
  
  public boolean setAEC(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAEC(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
    if (!canUseAcousticEchoCanceler())
    {
      Logging.w("WebRtcAudioEffects", "Platform AEC is not supported");
      this.shouldEnableAec = false;
      return false;
    }
    if ((this.aec != null) && (paramBoolean != this.shouldEnableAec))
    {
      Logging.e("WebRtcAudioEffects", "Platform AEC state can't be modified while recording");
      return false;
    }
    this.shouldEnableAec = paramBoolean;
    return true;
  }
  
  public boolean setNS(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNS(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    Logging.d("WebRtcAudioEffects", localStringBuilder.toString());
    if (!canUseNoiseSuppressor())
    {
      Logging.w("WebRtcAudioEffects", "Platform NS is not supported");
      this.shouldEnableNs = false;
      return false;
    }
    if ((this.ns != null) && (paramBoolean != this.shouldEnableNs))
    {
      Logging.e("WebRtcAudioEffects", "Platform NS state can't be modified while recording");
      return false;
    }
    this.shouldEnableNs = paramBoolean;
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioEffects
 * JD-Core Version:    0.7.0.1
 */