package org.webrtc;

import java.nio.ByteBuffer;

public class JniCommon
{
  public static native void nativeAddRef(long paramLong);
  
  public static native ByteBuffer nativeAllocateByteBuffer(int paramInt);
  
  public static native void nativeFreeByteBuffer(ByteBuffer paramByteBuffer);
  
  public static native void nativeReleaseRef(long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.JniCommon
 * JD-Core Version:    0.7.0.1
 */