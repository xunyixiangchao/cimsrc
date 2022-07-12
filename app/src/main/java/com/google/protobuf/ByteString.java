package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ByteString
  implements Iterable<Byte>, Serializable
{
  static final int CONCATENATE_BY_COPY_SIZE = 128;
  public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
  static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
  static final int MIN_READ_FROM_CHUNK_SIZE = 256;
  private static final ByteArrayCopier byteArrayCopier;
  private int hash = 0;
  
  static
  {
    int i = 1;
    try
    {
      Class.forName("android.content.Context");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label24:
      Object localObject;
      break label24;
    }
    i = 0;
    if (i != 0) {
      localObject = new SystemByteArrayCopier(null);
    } else {
      localObject = new ArraysByteArrayCopier(null);
    }
    byteArrayCopier = (ByteArrayCopier)localObject;
  }
  
  private static ByteString balancedConcat(Iterator<ByteString> paramIterator, int paramInt)
  {
    if (paramInt == 1) {
      return (ByteString)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return balancedConcat(paramIterator, i).concat(balancedConcat(paramIterator, paramInt - i));
  }
  
  static void checkIndex(int paramInt1, int paramInt2)
  {
    if ((paramInt2 - (paramInt1 + 1) | paramInt1) < 0)
    {
      if (paramInt1 < 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Index < 0: ");
        localStringBuilder.append(paramInt1);
        throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index > length: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  static int checkRange(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  public static ByteString copyFrom(Iterable<ByteString> paramIterable)
  {
    if (!(paramIterable instanceof Collection))
    {
      int i = 0;
      Iterator localIterator = paramIterable.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localIterator.next();
        i += 1;
      }
    }
    int j = ((Collection)paramIterable).size();
    if (j == 0) {
      return EMPTY;
    }
    return balancedConcat(paramIterable.iterator(), j);
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2)
  {
    return new LiteralByteString(paramString1.getBytes(paramString2));
  }
  
  public static ByteString copyFrom(String paramString, Charset paramCharset)
  {
    return new LiteralByteString(paramString.getBytes(paramCharset));
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer)
  {
    return copyFrom(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new LiteralByteString(arrayOfByte);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new LiteralByteString(byteArrayCopier.copyFrom(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    return new LiteralByteString(paramString.getBytes(Internal.UTF_8));
  }
  
  static CodedBuilder newCodedBuilder(int paramInt)
  {
    return new CodedBuilder(paramInt, null);
  }
  
  public static Output newOutput()
  {
    return new Output(128);
  }
  
  public static Output newOutput(int paramInt)
  {
    return new Output(paramInt);
  }
  
  private static ByteString readChunk(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i == 0) {
      return null;
    }
    return copyFrom(arrayOfByte, 0, i);
  }
  
  public static ByteString readFrom(InputStream paramInputStream)
  {
    return readFrom(paramInputStream, 256, 8192);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt)
  {
    return readFrom(paramInputStream, paramInt, paramInt);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      ByteString localByteString = readChunk(paramInputStream, paramInt1);
      if (localByteString == null) {
        return copyFrom(localArrayList);
      }
      localArrayList.add(localByteString);
      paramInt1 = Math.min(paramInt1 * 2, paramInt2);
    }
  }
  
  static ByteString wrap(byte[] paramArrayOfByte)
  {
    return new LiteralByteString(paramArrayOfByte);
  }
  
  static ByteString wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new BoundedByteString(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract ByteBuffer asReadOnlyByteBuffer();
  
  public abstract List<ByteBuffer> asReadOnlyByteBufferList();
  
  public abstract byte byteAt(int paramInt);
  
  public final ByteString concat(ByteString paramByteString)
  {
    if (2147483647 - size() >= paramByteString.size()) {
      return RopeByteString.concatenate(this, paramByteString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ByteString would be too long: ");
    localStringBuilder.append(size());
    localStringBuilder.append("+");
    localStringBuilder.append(paramByteString.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public abstract void copyTo(ByteBuffer paramByteBuffer);
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    copyTo(paramArrayOfByte, 0, paramInt, size());
  }
  
  public final void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    checkRange(paramInt1, paramInt1 + paramInt3, size());
    checkRange(paramInt2, paramInt2 + paramInt3, paramArrayOfByte.length);
    if (paramInt3 > 0) {
      copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public final boolean endsWith(ByteString paramByteString)
  {
    return (size() >= paramByteString.size()) && (substring(size() - paramByteString.size()).equals(paramByteString));
  }
  
  public abstract boolean equals(Object paramObject);
  
  protected abstract int getTreeDepth();
  
  public final int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  protected abstract boolean isBalanced();
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isValidUtf8();
  
  public final ByteIterator iterator()
  {
    new ByteIterator()
    {
      private final int limit = ByteString.this.size();
      private int position = 0;
      
      public boolean hasNext()
      {
        return this.position < this.limit;
      }
      
      public Byte next()
      {
        return Byte.valueOf(nextByte());
      }
      
      public byte nextByte()
      {
        try
        {
          ByteString localByteString = ByteString.this;
          int i = this.position;
          this.position = (i + 1);
          byte b = localByteString.byteAt(i);
          return b;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
        }
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public abstract CodedInputStream newCodedInput();
  
  public abstract InputStream newInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  protected final int peekCachedHashCode()
  {
    return this.hash;
  }
  
  public abstract int size();
  
  public final boolean startsWith(ByteString paramByteString)
  {
    int i = size();
    int j = paramByteString.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= j)
    {
      bool1 = bool2;
      if (substring(0, paramByteString.size()).equals(paramByteString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final ByteString substring(int paramInt)
  {
    return substring(paramInt, size());
  }
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return Internal.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public final String toString(String paramString)
  {
    try
    {
      String str = toString(Charset.forName(paramString));
      return str;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      paramString = new UnsupportedEncodingException(paramString);
      paramString.initCause(localUnsupportedCharsetException);
      throw paramString;
    }
  }
  
  public final String toString(Charset paramCharset)
  {
    if (size() == 0) {
      return "";
    }
    return toStringInternal(paramCharset);
  }
  
  protected abstract String toStringInternal(Charset paramCharset);
  
  public final String toStringUtf8()
  {
    return toString(Internal.UTF_8);
  }
  
  abstract void writeTo(ByteOutput paramByteOutput);
  
  public abstract void writeTo(OutputStream paramOutputStream);
  
  final void writeTo(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    checkRange(paramInt1, paramInt1 + paramInt2, size());
    if (paramInt2 > 0) {
      writeToInternal(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  abstract void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  private static final class ArraysByteArrayCopier
    implements ByteString.ByteArrayCopier
  {
    public byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    }
  }
  
  private static final class BoundedByteString
    extends ByteString.LiteralByteString
  {
    private static final long serialVersionUID = 1L;
    private final int bytesLength;
    private final int bytesOffset;
    
    BoundedByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      ByteString.checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.bytesOffset = paramInt1;
      this.bytesLength = paramInt2;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
    {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    public byte byteAt(int paramInt)
    {
      ByteString.checkIndex(paramInt, size());
      return this.bytes[(this.bytesOffset + paramInt)];
    }
    
    protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.bytes, getOffsetIntoBytes() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    protected int getOffsetIntoBytes()
    {
      return this.bytesOffset;
    }
    
    public int size()
    {
      return this.bytesLength;
    }
    
    Object writeReplace()
    {
      return ByteString.wrap(toByteArray());
    }
  }
  
  private static abstract interface ByteArrayCopier
  {
    public abstract byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface ByteIterator
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  static final class CodedBuilder
  {
    private final byte[] buffer;
    private final CodedOutputStream output;
    
    private CodedBuilder(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      this.buffer = arrayOfByte;
      this.output = CodedOutputStream.newInstance(arrayOfByte);
    }
    
    public ByteString build()
    {
      this.output.checkNoSpaceLeft();
      return new ByteString.LiteralByteString(this.buffer);
    }
    
    public CodedOutputStream getCodedOutput()
    {
      return this.output;
    }
  }
  
  static abstract class LeafByteString
    extends ByteString
  {
    abstract boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2);
    
    protected final int getTreeDepth()
    {
      return 0;
    }
    
    protected final boolean isBalanced()
    {
      return true;
    }
  }
  
  private static class LiteralByteString
    extends ByteString.LeafByteString
  {
    private static final long serialVersionUID = 1L;
    protected final byte[] bytes;
    
    LiteralByteString(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
    
    public final ByteBuffer asReadOnlyByteBuffer()
    {
      return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }
    
    public final List<ByteBuffer> asReadOnlyByteBufferList()
    {
      return Collections.singletonList(asReadOnlyByteBuffer());
    }
    
    public byte byteAt(int paramInt)
    {
      return this.bytes[paramInt];
    }
    
    public final void copyTo(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ByteString)) {
        return false;
      }
      if (size() != ((ByteString)paramObject).size()) {
        return false;
      }
      if (size() == 0) {
        return true;
      }
      if ((paramObject instanceof LiteralByteString))
      {
        paramObject = (LiteralByteString)paramObject;
        int i = peekCachedHashCode();
        int j = paramObject.peekCachedHashCode();
        if ((i != 0) && (j != 0) && (i != j)) {
          return false;
        }
        return equalsRange(paramObject, 0, size());
      }
      return paramObject.equals(this);
    }
    
    final boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2)
    {
      if (paramInt2 <= paramByteString.size())
      {
        int i = paramInt1 + paramInt2;
        if (i <= paramByteString.size())
        {
          if ((paramByteString instanceof LiteralByteString))
          {
            paramByteString = (LiteralByteString)paramByteString;
            localObject = this.bytes;
            byte[] arrayOfByte = paramByteString.bytes;
            int j = getOffsetIntoBytes();
            i = getOffsetIntoBytes();
            paramInt1 = paramByteString.getOffsetIntoBytes() + paramInt1;
            while (i < j + paramInt2)
            {
              if (localObject[i] != arrayOfByte[paramInt1]) {
                return false;
              }
              i += 1;
              paramInt1 += 1;
            }
            return true;
          }
          return paramByteString.substring(paramInt1, i).equals(substring(0, paramInt2));
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Ran off end of other: ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramByteString.size());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      paramByteString = new StringBuilder();
      paramByteString.append("Length too large: ");
      paramByteString.append(paramInt2);
      paramByteString.append(size());
      throw new IllegalArgumentException(paramByteString.toString());
    }
    
    protected int getOffsetIntoBytes()
    {
      return 0;
    }
    
    public final boolean isValidUtf8()
    {
      int i = getOffsetIntoBytes();
      return Utf8.isValidUtf8(this.bytes, i, size() + i);
    }
    
    public final CodedInputStream newCodedInput()
    {
      return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
    }
    
    public final InputStream newInput()
    {
      return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected final int partialHash(int paramInt1, int paramInt2, int paramInt3)
    {
      return Internal.partialHash(paramInt1, this.bytes, getOffsetIntoBytes() + paramInt2, paramInt3);
    }
    
    protected final int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
    {
      paramInt2 = getOffsetIntoBytes() + paramInt2;
      return Utf8.partialIsValidUtf8(paramInt1, this.bytes, paramInt2, paramInt3 + paramInt2);
    }
    
    public int size()
    {
      return this.bytes.length;
    }
    
    public final ByteString substring(int paramInt1, int paramInt2)
    {
      paramInt2 = ByteString.checkRange(paramInt1, paramInt2, size());
      if (paramInt2 == 0) {
        return ByteString.EMPTY;
      }
      return new ByteString.BoundedByteString(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
    }
    
    protected final String toStringInternal(Charset paramCharset)
    {
      return new String(this.bytes, getOffsetIntoBytes(), size(), paramCharset);
    }
    
    final void writeTo(ByteOutput paramByteOutput)
    {
      paramByteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      paramOutputStream.write(toByteArray());
    }
    
    final void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
    {
      paramOutputStream.write(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
    }
  }
  
  public static final class Output
    extends OutputStream
  {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private byte[] buffer;
    private int bufferPos;
    private final ArrayList<ByteString> flushedBuffers;
    private int flushedBuffersTotalBytes;
    private final int initialCapacity;
    
    Output(int paramInt)
    {
      if (paramInt >= 0)
      {
        this.initialCapacity = paramInt;
        this.flushedBuffers = new ArrayList();
        this.buffer = new byte[paramInt];
        return;
      }
      throw new IllegalArgumentException("Buffer size < 0");
    }
    
    private byte[] copyArray(byte[] paramArrayOfByte, int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt));
      return arrayOfByte;
    }
    
    private void flushFullBuffer(int paramInt)
    {
      this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
      int i = this.flushedBuffersTotalBytes + this.buffer.length;
      this.flushedBuffersTotalBytes = i;
      this.buffer = new byte[Math.max(this.initialCapacity, Math.max(paramInt, i >>> 1))];
      this.bufferPos = 0;
    }
    
    private void flushLastBuffer()
    {
      int i = this.bufferPos;
      byte[] arrayOfByte = this.buffer;
      if (i < arrayOfByte.length)
      {
        if (i > 0)
        {
          arrayOfByte = copyArray(arrayOfByte, i);
          this.flushedBuffers.add(new ByteString.LiteralByteString(arrayOfByte));
        }
      }
      else
      {
        this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
        this.buffer = EMPTY_BYTE_ARRAY;
      }
      this.flushedBuffersTotalBytes += this.bufferPos;
      this.bufferPos = 0;
    }
    
    public void reset()
    {
      try
      {
        this.flushedBuffers.clear();
        this.flushedBuffersTotalBytes = 0;
        this.bufferPos = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public int size()
    {
      try
      {
        int i = this.flushedBuffersTotalBytes;
        int j = this.bufferPos;
        return i + j;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public ByteString toByteString()
    {
      try
      {
        flushLastBuffer();
        ByteString localByteString = ByteString.copyFrom(this.flushedBuffers);
        return localByteString;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public String toString()
    {
      return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
    }
    
    public void write(int paramInt)
    {
      try
      {
        if (this.bufferPos == this.buffer.length) {
          flushFullBuffer(1);
        }
        byte[] arrayOfByte = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        return;
      }
      finally {}
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int j = arrayOfByte.length;
        int i = this.bufferPos;
        if (paramInt2 <= j - i)
        {
          System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
          this.bufferPos += paramInt2;
        }
        else
        {
          j = arrayOfByte.length - i;
          System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, j);
          paramInt2 -= j;
          flushFullBuffer(paramInt2);
          System.arraycopy(paramArrayOfByte, paramInt1 + j, this.buffer, 0, paramInt2);
          this.bufferPos = paramInt2;
        }
        return;
      }
      finally {}
    }
    
    public void writeTo(OutputStream paramOutputStream)
    {
      try
      {
        Object localObject = this.flushedBuffers;
        localObject = (ByteString[])((ArrayList)localObject).toArray(new ByteString[((ArrayList)localObject).size()]);
        byte[] arrayOfByte = this.buffer;
        int j = this.bufferPos;
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          localObject[i].writeTo(paramOutputStream);
          i += 1;
        }
        paramOutputStream.write(copyArray(arrayOfByte, j));
        return;
      }
      finally {}
    }
  }
  
  private static final class SystemByteArrayCopier
    implements ByteString.ByteArrayCopier
  {
    public byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ByteString
 * JD-Core Version:    0.7.0.1
 */