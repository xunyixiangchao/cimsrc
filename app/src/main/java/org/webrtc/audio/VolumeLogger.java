package org.webrtc.audio;

import android.media.AudioManager;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.Logging;

class VolumeLogger
{
  private static final String TAG = "VolumeLogger";
  private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
  private static final int TIMER_PERIOD_IN_SECONDS = 30;
  private final AudioManager audioManager;
  private Timer timer;
  
  public VolumeLogger(AudioManager paramAudioManager)
  {
    this.audioManager = paramAudioManager;
  }
  
  public void start()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start");
    ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("VolumeLogger", ((StringBuilder)localObject).toString());
    if (this.timer != null) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("audio mode is: ");
    ((StringBuilder)localObject).append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
    Logging.d("VolumeLogger", ((StringBuilder)localObject).toString());
    localObject = new Timer("WebRtcVolumeLevelLoggerThread");
    this.timer = ((Timer)localObject);
    ((Timer)localObject).schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
  }
  
  public void stop()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop");
    ((StringBuilder)localObject).append(WebRtcAudioUtils.getThreadInfo());
    Logging.d("VolumeLogger", ((StringBuilder)localObject).toString());
    localObject = this.timer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.timer = null;
    }
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
      int i = VolumeLogger.this.audioManager.getMode();
      StringBuilder localStringBuilder;
      if (i == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("STREAM_RING stream volume: ");
        localStringBuilder.append(VolumeLogger.this.audioManager.getStreamVolume(2));
        localStringBuilder.append(" (max=");
      }
      for (i = this.maxRingVolume;; i = this.maxVoiceCallVolume)
      {
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        Logging.d("VolumeLogger", localStringBuilder.toString());
        return;
        if (i != 3) {
          break;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VOICE_CALL stream volume: ");
        localStringBuilder.append(VolumeLogger.this.audioManager.getStreamVolume(0));
        localStringBuilder.append(" (max=");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.audio.VolumeLogger
 * JD-Core Version:    0.7.0.1
 */