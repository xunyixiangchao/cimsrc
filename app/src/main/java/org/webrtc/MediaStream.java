package org.webrtc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaStream
{
  private static final String TAG = "MediaStream";
  public final List<AudioTrack> audioTracks = new ArrayList();
  private long nativeStream;
  public final List<VideoTrack> preservedVideoTracks = new ArrayList();
  public final List<VideoTrack> videoTracks = new ArrayList();
  
  @CalledByNative
  public MediaStream(long paramLong)
  {
    this.nativeStream = paramLong;
  }
  
  private void checkMediaStreamExists()
  {
    if (this.nativeStream != 0L) {
      return;
    }
    throw new IllegalStateException("MediaStream has been disposed.");
  }
  
  private static native boolean nativeAddAudioTrackToNativeStream(long paramLong1, long paramLong2);
  
  private static native boolean nativeAddVideoTrackToNativeStream(long paramLong1, long paramLong2);
  
  private static native String nativeGetId(long paramLong);
  
  private static native boolean nativeRemoveAudioTrack(long paramLong1, long paramLong2);
  
  private static native boolean nativeRemoveVideoTrack(long paramLong1, long paramLong2);
  
  private static void removeMediaStreamTrack(List<? extends MediaStreamTrack> paramList, long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MediaStreamTrack localMediaStreamTrack = (MediaStreamTrack)paramList.next();
      if (localMediaStreamTrack.getNativeMediaStreamTrack() == paramLong)
      {
        localMediaStreamTrack.dispose();
        paramList.remove();
        return;
      }
    }
    Logging.e("MediaStream", "Couldn't not find track");
  }
  
  @CalledByNative
  void addNativeAudioTrack(long paramLong)
  {
    this.audioTracks.add(new AudioTrack(paramLong));
  }
  
  @CalledByNative
  void addNativeVideoTrack(long paramLong)
  {
    this.videoTracks.add(new VideoTrack(paramLong));
  }
  
  public boolean addPreservedTrack(VideoTrack paramVideoTrack)
  {
    checkMediaStreamExists();
    if (nativeAddVideoTrackToNativeStream(this.nativeStream, paramVideoTrack.getNativeVideoTrack()))
    {
      this.preservedVideoTracks.add(paramVideoTrack);
      return true;
    }
    return false;
  }
  
  public boolean addTrack(AudioTrack paramAudioTrack)
  {
    checkMediaStreamExists();
    if (nativeAddAudioTrackToNativeStream(this.nativeStream, paramAudioTrack.getNativeAudioTrack()))
    {
      this.audioTracks.add(paramAudioTrack);
      return true;
    }
    return false;
  }
  
  public boolean addTrack(VideoTrack paramVideoTrack)
  {
    checkMediaStreamExists();
    if (nativeAddVideoTrackToNativeStream(this.nativeStream, paramVideoTrack.getNativeVideoTrack()))
    {
      this.videoTracks.add(paramVideoTrack);
      return true;
    }
    return false;
  }
  
  @CalledByNative
  public void dispose()
  {
    checkMediaStreamExists();
    Object localObject;
    while (!this.audioTracks.isEmpty())
    {
      localObject = (AudioTrack)this.audioTracks.get(0);
      removeTrack((AudioTrack)localObject);
      ((MediaStreamTrack)localObject).dispose();
    }
    while (!this.videoTracks.isEmpty())
    {
      localObject = (VideoTrack)this.videoTracks.get(0);
      removeTrack((VideoTrack)localObject);
      ((VideoTrack)localObject).dispose();
    }
    while (!this.preservedVideoTracks.isEmpty()) {
      removeTrack((VideoTrack)this.preservedVideoTracks.get(0));
    }
    JniCommon.nativeReleaseRef(this.nativeStream);
    this.nativeStream = 0L;
  }
  
  public String getId()
  {
    checkMediaStreamExists();
    return nativeGetId(this.nativeStream);
  }
  
  long getNativeMediaStream()
  {
    checkMediaStreamExists();
    return this.nativeStream;
  }
  
  @CalledByNative
  void removeAudioTrack(long paramLong)
  {
    removeMediaStreamTrack(this.audioTracks, paramLong);
  }
  
  public boolean removeTrack(AudioTrack paramAudioTrack)
  {
    checkMediaStreamExists();
    this.audioTracks.remove(paramAudioTrack);
    return nativeRemoveAudioTrack(this.nativeStream, paramAudioTrack.getNativeAudioTrack());
  }
  
  public boolean removeTrack(VideoTrack paramVideoTrack)
  {
    checkMediaStreamExists();
    this.videoTracks.remove(paramVideoTrack);
    this.preservedVideoTracks.remove(paramVideoTrack);
    return nativeRemoveVideoTrack(this.nativeStream, paramVideoTrack.getNativeVideoTrack());
  }
  
  @CalledByNative
  void removeVideoTrack(long paramLong)
  {
    removeMediaStreamTrack(this.videoTracks, paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(getId());
    localStringBuilder.append(":A=");
    localStringBuilder.append(this.audioTracks.size());
    localStringBuilder.append(":V=");
    localStringBuilder.append(this.videoTracks.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaStream
 * JD-Core Version:    0.7.0.1
 */