package com.google.protobuf;

import java.io.InputStream;

public abstract interface Parser<MessageType>
{
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream);
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(ByteString paramByteString);
  
  public abstract MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream);
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(InputStream paramInputStream);
  
  public abstract MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream);
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString);
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream);
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream);
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte);
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.Parser
 * JD-Core Version:    0.7.0.1
 */