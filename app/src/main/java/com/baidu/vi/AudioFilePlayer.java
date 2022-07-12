package com.baidu.vi;

import android.media.MediaPlayer;

public class AudioFilePlayer
{
  private AudioFilePlayer()
  {
    new MediaPlayer();
  }
  
  private native boolean onErrorOccured(long paramLong, int paramInt);
  
  private native void onPlayCompleted(long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.AudioFilePlayer
 * JD-Core Version:    0.7.0.1
 */