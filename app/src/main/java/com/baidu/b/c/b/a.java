package com.baidu.b.c.b;

import java.nio.ByteBuffer;

final class a
{
  static void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt)
  {
    if ((paramInt >= 0) && (paramByteBuffer2.remaining() >= paramInt) && (paramByteBuffer3.remaining() >= paramInt) && (paramByteBuffer1.remaining() >= paramInt))
    {
      int i = 0;
      while (i < paramInt)
      {
        paramByteBuffer1.put((byte)(paramByteBuffer2.get() ^ paramByteBuffer3.get()));
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.b.a
 * JD-Core Version:    0.7.0.1
 */