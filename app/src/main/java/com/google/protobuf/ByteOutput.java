package com.google.protobuf;

import java.nio.ByteBuffer;

public abstract class ByteOutput
{
  public abstract void write(byte paramByte);
  
  public abstract void write(ByteBuffer paramByteBuffer);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeLazy(ByteBuffer paramByteBuffer);
  
  public abstract void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ByteOutput
 * JD-Core Version:    0.7.0.1
 */