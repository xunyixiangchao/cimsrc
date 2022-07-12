package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

public abstract interface MessageLite
  extends MessageLiteOrBuilder
{
  public abstract Parser<? extends MessageLite> getParserForType();
  
  public abstract int getSerializedSize();
  
  public abstract Builder newBuilderForType();
  
  public abstract Builder toBuilder();
  
  public abstract byte[] toByteArray();
  
  public abstract ByteString toByteString();
  
  public abstract void writeDelimitedTo(OutputStream paramOutputStream);
  
  public abstract void writeTo(CodedOutputStream paramCodedOutputStream);
  
  public abstract void writeTo(OutputStream paramOutputStream);
  
  public static abstract interface Builder
    extends MessageLiteOrBuilder, Cloneable
  {
    public abstract MessageLite build();
    
    public abstract MessageLite buildPartial();
    
    public abstract Builder clear();
    
    public abstract Builder clone();
    
    public abstract boolean mergeDelimitedFrom(InputStream paramInputStream);
    
    public abstract boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public abstract Builder mergeFrom(ByteString paramByteString);
    
    public abstract Builder mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream);
    
    public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public abstract Builder mergeFrom(MessageLite paramMessageLite);
    
    public abstract Builder mergeFrom(InputStream paramInputStream);
    
    public abstract Builder mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte);
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.MessageLite
 * JD-Core Version:    0.7.0.1
 */