package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
  implements MessageLite
{
  protected int memoizedHashCode = 0;
  
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
  {
    Builder.addAll(paramIterable, paramCollection);
  }
  
  protected static void checkByteStringIsUtf8(ByteString paramByteString)
  {
    if (paramByteString.isValidUtf8()) {
      return;
    }
    throw new IllegalArgumentException("Byte string is not UTF-8.");
  }
  
  private String getSerializingExceptionMessage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Serializing ");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" to a ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" threw an IOException (should never happen).");
    return localStringBuilder.toString();
  }
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return new UninitializedMessageException(this);
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(arrayOfByte);
      writeTo(localCodedOutputStream);
      localCodedOutputStream.checkNoSpaceLeft();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("byte array"), localIOException);
    }
  }
  
  public ByteString toByteString()
  {
    try
    {
      Object localObject = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(((ByteString.CodedBuilder)localObject).getCodedOutput());
      localObject = ((ByteString.CodedBuilder)localObject).build();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("ByteString"), localIOException);
    }
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream)
  {
    int i = getSerializedSize();
    paramOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(i) + i));
    paramOutputStream.writeRawVarint32(i);
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
    implements MessageLite.Builder
  {
    protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
    {
      Objects.requireNonNull(paramIterable);
      if ((paramIterable instanceof LazyStringList)) {
        checkForNullValues(((LazyStringList)paramIterable).getUnderlyingElements());
      }
      for (;;)
      {
        paramCollection.addAll((Collection)paramIterable);
        return;
        if (!(paramIterable instanceof Collection)) {
          break;
        }
        checkForNullValues(paramIterable);
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        Objects.requireNonNull(localObject);
        paramCollection.add(localObject);
      }
    }
    
    private static void checkForNullValues(Iterable<?> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        Objects.requireNonNull(paramIterable.next());
      }
    }
    
    private String getReadingExceptionMessage(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Reading ");
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append(" from a ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" threw an IOException (should never happen).");
      return localStringBuilder.toString();
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(MessageLite paramMessageLite)
    {
      return new UninitializedMessageException(paramMessageLite);
    }
    
    public abstract BuilderType clone();
    
    protected abstract BuilderType internalMergeFrom(MessageType paramMessageType);
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream)
    {
      return mergeDelimitedFrom(paramInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return false;
      }
      mergeFrom(new LimitedInputStream(paramInputStream, CodedInputStream.readRawVarint32(i, paramInputStream)), paramExtensionRegistryLite);
      return true;
    }
    
    public BuilderType mergeFrom(ByteString paramByteString)
    {
      try
      {
        paramByteString = paramByteString.newCodedInput();
        mergeFrom(paramByteString);
        paramByteString.checkLastTagWas(0);
        return this;
      }
      catch (IOException paramByteString)
      {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramByteString);
      }
      catch (InvalidProtocolBufferException paramByteString)
      {
        throw paramByteString;
      }
    }
    
    public BuilderType mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      try
      {
        paramByteString = paramByteString.newCodedInput();
        mergeFrom(paramByteString, paramExtensionRegistryLite);
        paramByteString.checkLastTagWas(0);
        return this;
      }
      catch (IOException paramByteString)
      {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramByteString);
      }
      catch (InvalidProtocolBufferException paramByteString)
      {
        throw paramByteString;
      }
    }
    
    public BuilderType mergeFrom(CodedInputStream paramCodedInputStream)
    {
      return mergeFrom(paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public abstract BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
    
    public BuilderType mergeFrom(MessageLite paramMessageLite)
    {
      if (getDefaultInstanceForType().getClass().isInstance(paramMessageLite)) {
        return internalMergeFrom((AbstractMessageLite)paramMessageLite);
      }
      throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream)
    {
      paramInputStream = CodedInputStream.newInstance(paramInputStream);
      mergeFrom(paramInputStream);
      paramInputStream.checkLastTagWas(0);
      return this;
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      paramInputStream = CodedInputStream.newInstance(paramInputStream);
      mergeFrom(paramInputStream, paramExtensionRegistryLite);
      paramInputStream.checkLastTagWas(0);
      return this;
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte)
    {
      return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        paramArrayOfByte = CodedInputStream.newInstance(paramArrayOfByte, paramInt1, paramInt2);
        mergeFrom(paramArrayOfByte);
        paramArrayOfByte.checkLastTagWas(0);
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      try
      {
        paramArrayOfByte = CodedInputStream.newInstance(paramArrayOfByte, paramInt1, paramInt2);
        mergeFrom(paramArrayOfByte, paramExtensionRegistryLite);
        paramArrayOfByte.checkLastTagWas(0);
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
    }
    
    static final class LimitedInputStream
      extends FilterInputStream
    {
      private int limit;
      
      LimitedInputStream(InputStream paramInputStream, int paramInt)
      {
        super();
        this.limit = paramInt;
      }
      
      public int available()
      {
        return Math.min(super.available(), this.limit);
      }
      
      public int read()
      {
        if (this.limit <= 0) {
          return -1;
        }
        int i = super.read();
        if (i >= 0) {
          this.limit -= 1;
        }
        return i;
      }
      
      public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        int i = this.limit;
        if (i <= 0) {
          return -1;
        }
        paramInt1 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, i));
        if (paramInt1 >= 0) {
          this.limit -= paramInt1;
        }
        return paramInt1;
      }
      
      public long skip(long paramLong)
      {
        paramLong = super.skip(Math.min(paramLong, this.limit));
        if (paramLong >= 0L) {
          this.limit = ((int)(this.limit - paramLong));
        }
        return paramLong;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.AbstractMessageLite
 * JD-Core Version:    0.7.0.1
 */