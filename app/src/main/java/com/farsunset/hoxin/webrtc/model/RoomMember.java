package com.farsunset.hoxin.webrtc.model;

import java.io.Serializable;
import java.util.Objects;

public class RoomMember
  implements Serializable
{
  public static final int STATE_ACTIVE = 1;
  public static final int STATE_BUSY = 4;
  public static final int STATE_LEAVE = 5;
  public static final int STATE_PENDING = 0;
  public static final int STATE_REJECT = 3;
  public static final int STATE_TIMEOUT = 2;
  public boolean cameraEnable = true;
  public boolean master;
  public boolean microphoneEnable = true;
  public String name;
  public int state;
  public long uid;
  public boolean videoMode;
  
  public static RoomMember of(long paramLong)
  {
    RoomMember localRoomMember = new RoomMember();
    localRoomMember.uid = paramLong;
    return localRoomMember;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof RoomMember)) {
      return Objects.equals(Long.valueOf(((RoomMember)paramObject).uid), Long.valueOf(this.uid));
    }
    return false;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.webrtc.model.RoomMember
 * JD-Core Version:    0.7.0.1
 */