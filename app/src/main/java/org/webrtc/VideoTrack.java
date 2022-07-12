package org.webrtc;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;

public class VideoTrack
  extends MediaStreamTrack
{
  private final IdentityHashMap<VideoSink, Long> sinks = new IdentityHashMap();
  
  public VideoTrack(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeAddSink(long paramLong1, long paramLong2);
  
  private static native void nativeFreeSink(long paramLong);
  
  private static native void nativeRemoveSink(long paramLong1, long paramLong2);
  
  private static native long nativeWrapSink(VideoSink paramVideoSink);
  
  public void addSink(VideoSink paramVideoSink)
  {
    if (paramVideoSink != null)
    {
      if (!this.sinks.containsKey(paramVideoSink))
      {
        long l = nativeWrapSink(paramVideoSink);
        this.sinks.put(paramVideoSink, Long.valueOf(l));
        nativeAddSink(getNativeMediaStreamTrack(), l);
      }
      return;
    }
    throw new IllegalArgumentException("The VideoSink is not allowed to be null");
  }
  
  public void dispose()
  {
    Iterator localIterator = this.sinks.values().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      nativeRemoveSink(getNativeMediaStreamTrack(), l);
      nativeFreeSink(l);
    }
    this.sinks.clear();
    super.dispose();
  }
  
  long getNativeVideoTrack()
  {
    return getNativeMediaStreamTrack();
  }
  
  public void removeSink(VideoSink paramVideoSink)
  {
    paramVideoSink = (Long)this.sinks.remove(paramVideoSink);
    if (paramVideoSink != null)
    {
      nativeRemoveSink(getNativeMediaStreamTrack(), paramVideoSink.longValue());
      nativeFreeSink(paramVideoSink.longValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoTrack
 * JD-Core Version:    0.7.0.1
 */