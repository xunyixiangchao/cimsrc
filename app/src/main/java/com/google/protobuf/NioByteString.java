package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class NioByteString
  extends ByteString.LeafByteString
{
  private final ByteBuffer buffer;
  
  NioByteString(ByteBuffer paramByteBuffer)
  {
    Objects.requireNonNull(paramByteBuffer, "buffer");
    this.buffer = paramByteBuffer.slice().order(ByteOrder.nativeOrder());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
  }
  
  private ByteBuffer slice(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.buffer.position()) && (paramInt2 <= this.buffer.limit()) && (paramInt1 <= paramInt2))
    {
      ByteBuffer localByteBuffer = this.buffer.slice();
      localByteBuffer.position(paramInt1 - this.buffer.position());
      localByteBuffer.limit(paramInt2 - this.buffer.position());
      return localByteBuffer;
    }
    throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private Object writeReplace()
  {
    return ByteString.copyFrom(this.buffer.slice());
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return this.buffer.asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    return Collections.singletonList(asReadOnlyByteBuffer());
  }
  
  public byte byteAt(int paramInt)
  {
    try
    {
      byte b = this.buffer.get(paramInt);
      return b;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(this.buffer.slice());
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = this.buffer.slice();
    localByteBuffer.position(paramInt1);
    localByteBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    ByteString localByteString = (ByteString)paramObject;
    if (size() != localByteString.size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof NioByteString)) {
      return this.buffer.equals(((NioByteString)paramObject).buffer);
    }
    if ((paramObject instanceof RopeByteString)) {
      return paramObject.equals(this);
    }
    return this.buffer.equals(localByteString.asReadOnlyByteBuffer());
  }
  
  boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2)
  {
    return substring(0, paramInt2).equals(paramByteString.substring(paramInt1, paramInt2 + paramInt1));
  }
  
  public boolean isValidUtf8()
  {
    return Utf8.isValidUtf8(this.buffer);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(this.buffer);
  }
  
  public InputStream newInput()
  {
    new InputStream()
    {
      private final ByteBuffer buf = NioByteString.this.buffer.slice();
      
      public int available()
      {
        return this.buf.remaining();
      }
      
      public void mark(int paramAnonymousInt)
      {
        this.buf.mark();
      }
      
      public boolean markSupported()
      {
        return true;
      }
      
      public int read()
      {
        if (!this.buf.hasRemaining()) {
          return -1;
        }
        return this.buf.get() & 0xFF;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (!this.buf.hasRemaining()) {
          return -1;
        }
        paramAnonymousInt2 = Math.min(paramAnonymousInt2, this.buf.remaining());
        this.buf.get(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        return paramAnonymousInt2;
      }
      
      public void reset()
      {
        try
        {
          this.buf.reset();
          return;
        }
        catch (InvalidMarkException localInvalidMarkException)
        {
          throw new IOException(localInvalidMarkException);
        }
      }
    };
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + this.buffer.get(i);
      i += 1;
    }
    return paramInt1;
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    return Utf8.partialIsValidUtf8(paramInt1, this.buffer, paramInt2, paramInt3 + paramInt2);
  }
  
  public int size()
  {
    return this.buffer.remaining();
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    try
    {
      NioByteString localNioByteString = new NioByteString(slice(paramInt1, paramInt2));
      return localNioByteString;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  protected String toStringInternal(Charset paramCharset)
  {
    byte[] arrayOfByte;
    int i;
    int j;
    if (this.buffer.hasArray())
    {
      arrayOfByte = this.buffer.array();
      i = this.buffer.arrayOffset() + this.buffer.position();
      j = this.buffer.remaining();
    }
    else
    {
      arrayOfByte = toByteArray();
      i = 0;
      j = arrayOfByte.length;
    }
    return new String(arrayOfByte, i, j, paramCharset);
  }
  
  void writeTo(ByteOutput paramByteOutput)
  {
    paramByteOutput.writeLazy(this.buffer.slice());
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream.write(toByteArray());
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (this.buffer.hasArray())
    {
      int i = this.buffer.arrayOffset();
      int j = this.buffer.position();
      paramOutputStream.write(this.buffer.array(), i + j + paramInt1, paramInt2);
      return;
    }
    ByteBufferWriter.write(slice(paramInt1, paramInt2 + paramInt1), paramOutputStream);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.NioByteString
 * JD-Core Version:    0.7.0.1
 */