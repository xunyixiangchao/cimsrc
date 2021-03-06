package com.google.protobuf;

import java.util.Collection;
import java.util.List;

public abstract interface LazyStringList
  extends ProtocolStringList
{
  public abstract void add(ByteString paramByteString);
  
  public abstract void add(byte[] paramArrayOfByte);
  
  public abstract boolean addAllByteArray(Collection<byte[]> paramCollection);
  
  public abstract boolean addAllByteString(Collection<? extends ByteString> paramCollection);
  
  public abstract List<byte[]> asByteArrayList();
  
  public abstract byte[] getByteArray(int paramInt);
  
  public abstract ByteString getByteString(int paramInt);
  
  public abstract Object getRaw(int paramInt);
  
  public abstract List<?> getUnderlyingElements();
  
  public abstract LazyStringList getUnmodifiableView();
  
  public abstract void mergeFrom(LazyStringList paramLazyStringList);
  
  public abstract void set(int paramInt, ByteString paramByteString);
  
  public abstract void set(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.LazyStringList
 * JD-Core Version:    0.7.0.1
 */