package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite>
  implements Parser<MessageType>
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  
  private MessageType checkMessageInitialized(MessageType paramMessageType)
  {
    if (paramMessageType != null)
    {
      if (paramMessageType.isInitialized()) {
        return paramMessageType;
      }
      throw newUninitializedMessageException(paramMessageType).asInvalidProtocolBufferException().setUnfinishedMessage(paramMessageType);
    }
    return paramMessageType;
  }
  
  private UninitializedMessageException newUninitializedMessageException(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof AbstractMessageLite)) {
      return ((AbstractMessageLite)paramMessageType).newUninitializedMessageException();
    }
    return new UninitializedMessageException(paramMessageType);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream)
  {
    return parseDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteString paramByteString)
  {
    return parseFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramByteString, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream)
  {
    return parseFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized((MessageLite)parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(InputStream paramInputStream)
  {
    return parseFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte)
  {
    return parseFrom(paramArrayOfByte, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parseFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return parseFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
  {
    return parsePartialDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      i = CodedInputStream.readRawVarint32(i, paramInputStream);
      return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i), paramExtensionRegistryLite);
    }
    catch (IOException paramInputStream)
    {
      throw new InvalidProtocolBufferException(paramInputStream.getMessage());
    }
  }
  
  public MessageType parsePartialFrom(ByteString paramByteString)
  {
    return parsePartialFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 164	com/google/protobuf/ByteString:newCodedInput	()Lcom/google/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokeinterface 92 3 0
    //   13: checkcast 94	com/google/protobuf/MessageLite
    //   16: astore_2
    //   17: aload_1
    //   18: iconst_0
    //   19: invokevirtual 168	com/google/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   22: aload_2
    //   23: areturn
    //   24: astore_1
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual 47	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   30: athrow
    //   31: astore_1
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	AbstractParser
    //   0	34	1	paramByteString	ByteString
    //   0	34	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   17	22	24	com/google/protobuf/InvalidProtocolBufferException
    //   0	17	31	com/google/protobuf/InvalidProtocolBufferException
    //   25	31	31	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public MessageType parsePartialFrom(CodedInputStream paramCodedInputStream)
  {
    return (MessageLite)parsePartialFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream)
  {
    return parsePartialFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramInputStream = CodedInputStream.newInstance(paramInputStream);
    paramExtensionRegistryLite = (MessageLite)parsePartialFrom(paramInputStream, paramExtensionRegistryLite);
    try
    {
      paramInputStream.checkLastTagWas(0);
      return paramExtensionRegistryLite;
    }
    catch (InvalidProtocolBufferException paramInputStream)
    {
      throw paramInputStream.setUnfinishedMessage(paramExtensionRegistryLite);
    }
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: invokestatic 175	com/google/protobuf/CodedInputStream:newInstance	([BII)Lcom/google/protobuf/CodedInputStream;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: aload 4
    //   11: invokeinterface 92 3 0
    //   16: checkcast 94	com/google/protobuf/MessageLite
    //   19: astore 4
    //   21: aload_1
    //   22: iconst_0
    //   23: invokevirtual 168	com/google/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   26: aload 4
    //   28: areturn
    //   29: astore_1
    //   30: aload_1
    //   31: aload 4
    //   33: invokevirtual 47	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   36: athrow
    //   37: astore_1
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractParser
    //   0	40	1	paramArrayOfByte	byte[]
    //   0	40	2	paramInt1	int
    //   0	40	3	paramInt2	int
    //   0	40	4	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   21	26	29	com/google/protobuf/InvalidProtocolBufferException
    //   0	21	37	com/google/protobuf/InvalidProtocolBufferException
    //   30	37	37	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.AbstractParser
 * JD-Core Version:    0.7.0.1
 */