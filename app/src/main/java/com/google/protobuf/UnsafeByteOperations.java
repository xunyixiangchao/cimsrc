package com.google.protobuf;

import java.nio.ByteBuffer;

public final class UnsafeByteOperations
{
  public static ByteString unsafeWrap(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return ByteString.wrap(paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    return new NioByteString(paramByteBuffer);
  }
  
  public static void unsafeWriteTo(ByteString paramByteString, ByteOutput paramByteOutput)
  {
    paramByteString.writeTo(paramByteOutput);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.UnsafeByteOperations
 * JD-Core Version:    0.7.0.1
 */