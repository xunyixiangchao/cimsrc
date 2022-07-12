package org.webrtc;

public class MediaStreamTrack
{
  public static final String AUDIO_TRACK_KIND = "audio";
  public static final String VIDEO_TRACK_KIND = "video";
  private long nativeTrack;
  
  public MediaStreamTrack(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.nativeTrack = paramLong;
      return;
    }
    throw new IllegalArgumentException("nativeTrack may not be null");
  }
  
  private void checkMediaStreamTrackExists()
  {
    if (this.nativeTrack != 0L) {
      return;
    }
    throw new IllegalStateException("MediaStreamTrack has been disposed.");
  }
  
  static MediaStreamTrack createMediaStreamTrack(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    String str = nativeGetKind(paramLong);
    if (str.equals("audio")) {
      return new AudioTrack(paramLong);
    }
    if (str.equals("video")) {
      return new VideoTrack(paramLong);
    }
    return null;
  }
  
  private static native boolean nativeGetEnabled(long paramLong);
  
  private static native String nativeGetId(long paramLong);
  
  private static native String nativeGetKind(long paramLong);
  
  private static native State nativeGetState(long paramLong);
  
  private static native boolean nativeSetEnabled(long paramLong, boolean paramBoolean);
  
  public void dispose()
  {
    checkMediaStreamTrackExists();
    JniCommon.nativeReleaseRef(this.nativeTrack);
    this.nativeTrack = 0L;
  }
  
  public boolean enabled()
  {
    checkMediaStreamTrackExists();
    return nativeGetEnabled(this.nativeTrack);
  }
  
  long getNativeMediaStreamTrack()
  {
    checkMediaStreamTrackExists();
    return this.nativeTrack;
  }
  
  public String id()
  {
    checkMediaStreamTrackExists();
    return nativeGetId(this.nativeTrack);
  }
  
  public String kind()
  {
    checkMediaStreamTrackExists();
    return nativeGetKind(this.nativeTrack);
  }
  
  public boolean setEnabled(boolean paramBoolean)
  {
    checkMediaStreamTrackExists();
    return nativeSetEnabled(this.nativeTrack, paramBoolean);
  }
  
  public State state()
  {
    checkMediaStreamTrackExists();
    return nativeGetState(this.nativeTrack);
  }
  
  public static enum MediaType
  {
    private final int nativeIndex;
    
    static
    {
      MediaType localMediaType1 = new MediaType("MEDIA_TYPE_AUDIO", 0, 0);
      MEDIA_TYPE_AUDIO = localMediaType1;
      MediaType localMediaType2 = new MediaType("MEDIA_TYPE_VIDEO", 1, 1);
      MEDIA_TYPE_VIDEO = localMediaType2;
      $VALUES = new MediaType[] { localMediaType1, localMediaType2 };
    }
    
    private MediaType(int paramInt)
    {
      this.nativeIndex = paramInt;
    }
    
    @CalledByNative("MediaType")
    static MediaType fromNativeIndex(int paramInt)
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        MediaType localMediaType = localObject[i];
        if (localMediaType.getNative() == paramInt) {
          return localMediaType;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown native media type: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    @CalledByNative("MediaType")
    int getNative()
    {
      return this.nativeIndex;
    }
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("LIVE", 0);
      LIVE = localState1;
      State localState2 = new State("ENDED", 1);
      ENDED = localState2;
      $VALUES = new State[] { localState1, localState2 };
    }
    
    private State() {}
    
    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaStreamTrack
 * JD-Core Version:    0.7.0.1
 */