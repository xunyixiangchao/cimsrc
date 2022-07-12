package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream
  extends ByteOutput
{
  private static final long ARRAY_BASE_OFFSET = UnsafeUtil.getArrayBaseOffset();
  public static final int DEFAULT_BUFFER_SIZE = 4096;
  private static final int FIXED_32_SIZE = 4;
  private static final int FIXED_64_SIZE = 8;
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  @Deprecated
  public static final int LITTLE_ENDIAN_32_SIZE = 4;
  private static final int MAX_VARINT_SIZE = 10;
  private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
  
  static
  {
    HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
  }
  
  public static int computeBoolSize(int paramInt, boolean paramBoolean)
  {
    return computeTagSize(paramInt) + computeBoolSizeNoTag(paramBoolean);
  }
  
  public static int computeBoolSizeNoTag(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int computeByteArraySize(int paramInt, byte[] paramArrayOfByte)
  {
    return computeTagSize(paramInt) + computeByteArraySizeNoTag(paramArrayOfByte);
  }
  
  public static int computeByteArraySizeNoTag(byte[] paramArrayOfByte)
  {
    return computeLengthDelimitedFieldSize(paramArrayOfByte.length);
  }
  
  public static int computeByteBufferSize(int paramInt, ByteBuffer paramByteBuffer)
  {
    return computeTagSize(paramInt) + computeByteBufferSizeNoTag(paramByteBuffer);
  }
  
  public static int computeByteBufferSizeNoTag(ByteBuffer paramByteBuffer)
  {
    return computeLengthDelimitedFieldSize(paramByteBuffer.capacity());
  }
  
  public static int computeBytesSize(int paramInt, ByteString paramByteString)
  {
    return computeTagSize(paramInt) + computeBytesSizeNoTag(paramByteString);
  }
  
  public static int computeBytesSizeNoTag(ByteString paramByteString)
  {
    return computeLengthDelimitedFieldSize(paramByteString.size());
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return computeTagSize(paramInt) + computeDoubleSizeNoTag(paramDouble);
  }
  
  public static int computeDoubleSizeNoTag(double paramDouble)
  {
    return 8;
  }
  
  public static int computeEnumSize(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeEnumSizeNoTag(paramInt2);
  }
  
  public static int computeEnumSizeNoTag(int paramInt)
  {
    return computeInt32SizeNoTag(paramInt);
  }
  
  public static int computeFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeFixed64SizeNoTag(paramLong);
  }
  
  public static int computeFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return computeTagSize(paramInt) + computeFloatSizeNoTag(paramFloat);
  }
  
  public static int computeFloatSizeNoTag(float paramFloat)
  {
    return 4;
  }
  
  @Deprecated
  public static int computeGroupSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(paramInt) * 2 + computeGroupSizeNoTag(paramMessageLite);
  }
  
  @Deprecated
  public static int computeGroupSizeNoTag(MessageLite paramMessageLite)
  {
    return paramMessageLite.getSerializedSize();
  }
  
  public static int computeInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeInt32SizeNoTag(paramInt2);
  }
  
  public static int computeInt32SizeNoTag(int paramInt)
  {
    if (paramInt >= 0) {
      return computeUInt32SizeNoTag(paramInt);
    }
    return 10;
  }
  
  public static int computeInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeInt64SizeNoTag(paramLong);
  }
  
  public static int computeInt64SizeNoTag(long paramLong)
  {
    return computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeLazyFieldMessageSetExtensionSize(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeLazyFieldSize(3, paramLazyFieldLite);
  }
  
  public static int computeLazyFieldSize(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return computeTagSize(paramInt) + computeLazyFieldSizeNoTag(paramLazyFieldLite);
  }
  
  public static int computeLazyFieldSizeNoTag(LazyFieldLite paramLazyFieldLite)
  {
    return computeLengthDelimitedFieldSize(paramLazyFieldLite.getSerializedSize());
  }
  
  static int computeLengthDelimitedFieldSize(int paramInt)
  {
    return computeUInt32SizeNoTag(paramInt) + paramInt;
  }
  
  public static int computeMessageSetExtensionSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeMessageSize(3, paramMessageLite);
  }
  
  public static int computeMessageSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(paramInt) + computeMessageSizeNoTag(paramMessageLite);
  }
  
  public static int computeMessageSizeNoTag(MessageLite paramMessageLite)
  {
    return computeLengthDelimitedFieldSize(paramMessageLite.getSerializedSize());
  }
  
  static int computePreferredBufferSize(int paramInt)
  {
    if (paramInt > 4096) {
      return 4096;
    }
    return paramInt;
  }
  
  public static int computeRawMessageSetExtensionSize(int paramInt, ByteString paramByteString)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeBytesSize(3, paramByteString);
  }
  
  @Deprecated
  public static int computeRawVarint32Size(int paramInt)
  {
    return computeUInt32SizeNoTag(paramInt);
  }
  
  @Deprecated
  public static int computeRawVarint64Size(long paramLong)
  {
    return computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeSFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeSFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSFixed64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeSInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSInt32SizeNoTag(paramInt2);
  }
  
  public static int computeSInt32SizeNoTag(int paramInt)
  {
    return computeUInt32SizeNoTag(encodeZigZag32(paramInt));
  }
  
  public static int computeSInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSInt64SizeNoTag(paramLong);
  }
  
  public static int computeSInt64SizeNoTag(long paramLong)
  {
    return computeUInt64SizeNoTag(encodeZigZag64(paramLong));
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
  }
  
  public static int computeStringSizeNoTag(String paramString)
  {
    try
    {
      i = Utf8.encodedLength(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      int i;
      label8:
      break label8;
    }
    i = paramString.getBytes(Internal.UTF_8).length;
    return computeLengthDelimitedFieldSize(i);
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeUInt32SizeNoTag(WireFormat.makeTag(paramInt, 0));
  }
  
  public static int computeUInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeUInt32SizeNoTag(paramInt2);
  }
  
  public static int computeUInt32SizeNoTag(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeUInt64SizeNoTag(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0x0 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    else
    {
      j = 2;
    }
    int i = j;
    long l = paramLong;
    if ((0xFFE00000 & paramLong) != 0L)
    {
      i = j + 2;
      l = paramLong >>> 14;
    }
    int j = i;
    if ((l & 0xFFFFC000) != 0L) {
      j = i + 1;
    }
    return j;
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  static CodedOutputStream newInstance(ByteOutput paramByteOutput, int paramInt)
  {
    if (paramInt >= 0) {
      return new ByteOutputEncoder(paramByteOutput, paramInt);
    }
    throw new IllegalArgumentException("bufferSize must be positive");
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream)
  {
    return newInstance(paramOutputStream, 4096);
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream, int paramInt)
  {
    return new OutputStreamEncoder(paramOutputStream, paramInt);
  }
  
  public static CodedOutputStream newInstance(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return new NioHeapEncoder(paramByteBuffer);
    }
    return new NioEncoder(paramByteBuffer);
  }
  
  @Deprecated
  public static CodedOutputStream newInstance(ByteBuffer paramByteBuffer, int paramInt)
  {
    return newInstance(paramByteBuffer);
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ArrayEncoder(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void checkNoSpaceLeft()
  {
    if (spaceLeft() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void flush();
  
  public abstract int getTotalBytesWritten();
  
  final void inefficientWriteStringNoTag(String paramString, Utf8.UnpairedSurrogateException paramUnpairedSurrogateException)
  {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramUnpairedSurrogateException);
    paramString = paramString.getBytes(Internal.UTF_8);
    try
    {
      writeUInt32NoTag(paramString.length);
      writeLazy(paramString, 0, paramString.length);
      return;
    }
    catch (OutOfSpaceException paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new OutOfSpaceException(paramString);
    }
  }
  
  public abstract int spaceLeft();
  
  public abstract void write(byte paramByte);
  
  public abstract void write(ByteBuffer paramByteBuffer);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeBool(int paramInt, boolean paramBoolean);
  
  public final void writeBoolNoTag(boolean paramBoolean)
  {
    write((byte)paramBoolean);
  }
  
  public abstract void writeByteArray(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public final void writeByteArrayNoTag(byte[] paramArrayOfByte)
  {
    writeByteArrayNoTag(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  abstract void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer);
  
  public abstract void writeBytes(int paramInt, ByteString paramByteString);
  
  public abstract void writeBytesNoTag(ByteString paramByteString);
  
  public final void writeDouble(int paramInt, double paramDouble)
  {
    writeFixed64(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void writeDoubleNoTag(double paramDouble)
  {
    writeFixed64NoTag(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void writeEnum(int paramInt1, int paramInt2)
  {
    writeInt32(paramInt1, paramInt2);
  }
  
  public final void writeEnumNoTag(int paramInt)
  {
    writeInt32NoTag(paramInt);
  }
  
  public abstract void writeFixed32(int paramInt1, int paramInt2);
  
  public abstract void writeFixed32NoTag(int paramInt);
  
  public abstract void writeFixed64(int paramInt, long paramLong);
  
  public abstract void writeFixed64NoTag(long paramLong);
  
  public final void writeFloat(int paramInt, float paramFloat)
  {
    writeFixed32(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void writeFloatNoTag(float paramFloat)
  {
    writeFixed32NoTag(Float.floatToRawIntBits(paramFloat));
  }
  
  @Deprecated
  public final void writeGroup(int paramInt, MessageLite paramMessageLite)
  {
    writeTag(paramInt, 3);
    writeGroupNoTag(paramMessageLite);
    writeTag(paramInt, 4);
  }
  
  @Deprecated
  public final void writeGroupNoTag(MessageLite paramMessageLite)
  {
    paramMessageLite.writeTo(this);
  }
  
  public abstract void writeInt32(int paramInt1, int paramInt2);
  
  public abstract void writeInt32NoTag(int paramInt);
  
  public final void writeInt64(int paramInt, long paramLong)
  {
    writeUInt64(paramInt, paramLong);
  }
  
  public final void writeInt64NoTag(long paramLong)
  {
    writeUInt64NoTag(paramLong);
  }
  
  public abstract void writeLazy(ByteBuffer paramByteBuffer);
  
  public abstract void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeMessage(int paramInt, MessageLite paramMessageLite);
  
  public abstract void writeMessageNoTag(MessageLite paramMessageLite);
  
  public abstract void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite);
  
  public final void writeRawByte(byte paramByte)
  {
    write(paramByte);
  }
  
  public final void writeRawByte(int paramInt)
  {
    write((byte)paramInt);
  }
  
  public final void writeRawBytes(ByteString paramByteString)
  {
    paramByteString.writeTo(this);
  }
  
  public abstract void writeRawBytes(ByteBuffer paramByteBuffer);
  
  public final void writeRawBytes(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void writeRawBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @Deprecated
  public final void writeRawLittleEndian32(int paramInt)
  {
    writeFixed32NoTag(paramInt);
  }
  
  @Deprecated
  public final void writeRawLittleEndian64(long paramLong)
  {
    writeFixed64NoTag(paramLong);
  }
  
  public abstract void writeRawMessageSetExtension(int paramInt, ByteString paramByteString);
  
  @Deprecated
  public final void writeRawVarint32(int paramInt)
  {
    writeUInt32NoTag(paramInt);
  }
  
  @Deprecated
  public final void writeRawVarint64(long paramLong)
  {
    writeUInt64NoTag(paramLong);
  }
  
  public final void writeSFixed32(int paramInt1, int paramInt2)
  {
    writeFixed32(paramInt1, paramInt2);
  }
  
  public final void writeSFixed32NoTag(int paramInt)
  {
    writeFixed32NoTag(paramInt);
  }
  
  public final void writeSFixed64(int paramInt, long paramLong)
  {
    writeFixed64(paramInt, paramLong);
  }
  
  public final void writeSFixed64NoTag(long paramLong)
  {
    writeFixed64NoTag(paramLong);
  }
  
  public final void writeSInt32(int paramInt1, int paramInt2)
  {
    writeUInt32(paramInt1, encodeZigZag32(paramInt2));
  }
  
  public final void writeSInt32NoTag(int paramInt)
  {
    writeUInt32NoTag(encodeZigZag32(paramInt));
  }
  
  public final void writeSInt64(int paramInt, long paramLong)
  {
    writeUInt64(paramInt, encodeZigZag64(paramLong));
  }
  
  public final void writeSInt64NoTag(long paramLong)
  {
    writeUInt64NoTag(encodeZigZag64(paramLong));
  }
  
  public abstract void writeString(int paramInt, String paramString);
  
  public abstract void writeStringNoTag(String paramString);
  
  public abstract void writeTag(int paramInt1, int paramInt2);
  
  public abstract void writeUInt32(int paramInt1, int paramInt2);
  
  public abstract void writeUInt32NoTag(int paramInt);
  
  public abstract void writeUInt64(int paramInt, long paramLong);
  
  public abstract void writeUInt64NoTag(long paramLong);
  
  private static abstract class AbstractBufferedEncoder
    extends CodedOutputStream
  {
    final byte[] buffer;
    final int limit;
    int position;
    int totalBytesWritten;
    
    AbstractBufferedEncoder(int paramInt)
    {
      super();
      if (paramInt >= 0)
      {
        byte[] arrayOfByte = new byte[Math.max(paramInt, 20)];
        this.buffer = arrayOfByte;
        this.limit = arrayOfByte.length;
        return;
      }
      throw new IllegalArgumentException("bufferSize must be >= 0");
    }
    
    final void buffer(byte paramByte)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = paramByte;
      this.totalBytesWritten += 1;
    }
    
    final void bufferFixed32NoTag(int paramInt)
    {
      byte[] arrayOfByte = this.buffer;
      int j = this.position;
      int i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)(paramInt & 0xFF));
      j = i + 1;
      this.position = j;
      arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
      i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)(paramInt >> 16 & 0xFF));
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
      this.totalBytesWritten += 4;
    }
    
    final void bufferFixed64NoTag(long paramLong)
    {
      byte[] arrayOfByte = this.buffer;
      int j = this.position;
      int i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)(int)(paramLong & 0xFF));
      j = i + 1;
      this.position = j;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
      i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)(int)(paramLong >> 16 & 0xFF));
      j = i + 1;
      this.position = j;
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong >> 24));
      i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)((int)(paramLong >> 32) & 0xFF));
      j = i + 1;
      this.position = j;
      arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
      i = j + 1;
      this.position = i;
      arrayOfByte[j] = ((byte)((int)(paramLong >> 48) & 0xFF));
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
      this.totalBytesWritten += 8;
    }
    
    final void bufferInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        bufferUInt32NoTag(paramInt);
        return;
      }
      bufferUInt64NoTag(paramInt);
    }
    
    final void bufferTag(int paramInt1, int paramInt2)
    {
      bufferUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    final void bufferUInt32NoTag(int paramInt)
    {
      int i = paramInt;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        long l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
        for (long l1 = l2;; l1 = 1L + l1)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            UnsafeUtil.putByte(this.buffer, l1, (byte)paramInt);
            paramInt = (int)(1L + l1 - l2);
            this.position += paramInt;
            this.totalBytesWritten += paramInt;
            return;
          }
          UnsafeUtil.putByte(this.buffer, l1, (byte)(paramInt & 0x7F | 0x80));
          paramInt >>>= 7;
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0)
        {
          arrayOfByte = this.buffer;
          paramInt = this.position;
          this.position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          this.totalBytesWritten += 1;
          return;
        }
        byte[] arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        this.totalBytesWritten += 1;
        i >>>= 7;
      }
    }
    
    final void bufferUInt64NoTag(long paramLong)
    {
      long l1 = paramLong;
      int i;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        long l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
        for (l1 = l2;; l1 = 1L + l1)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            UnsafeUtil.putByte(this.buffer, l1, (byte)(int)paramLong);
            i = (int)(1L + l1 - l2);
            this.position += i;
            this.totalBytesWritten += i;
            return;
          }
          UnsafeUtil.putByte(this.buffer, l1, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
      for (;;)
      {
        if ((l1 & 0xFFFFFF80) == 0L)
        {
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)(int)l1);
          this.totalBytesWritten += 1;
          return;
        }
        byte[] arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l1 & 0x7F | 0x80));
        this.totalBytesWritten += 1;
        l1 >>>= 7;
      }
    }
    
    public final int getTotalBytesWritten()
    {
      return this.totalBytesWritten;
    }
    
    public final int spaceLeft()
    {
      throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
  }
  
  private static class ArrayEncoder
    extends CodedOutputStream
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    ArrayEncoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      Objects.requireNonNull(paramArrayOfByte, "buffer");
      int i = paramArrayOfByte.length;
      int j = paramInt1 + paramInt2;
      if ((paramInt1 | paramInt2 | i - j) >= 0)
      {
        this.buffer = paramArrayOfByte;
        this.offset = paramInt1;
        this.position = paramInt1;
        this.limit = j;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    
    public void flush() {}
    
    public final int getTotalBytesWritten()
    {
      return this.position - this.offset;
    }
    
    public final int spaceLeft()
    {
      return this.limit - this.position;
    }
    
    public final void write(byte paramByte)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void write(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.remaining();
      try
      {
        paramByteBuffer.get(this.buffer, this.position, i);
        this.position += i;
        return;
      }
      catch (IndexOutOfBoundsException paramByteBuffer)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i) }), paramByteBuffer);
      }
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void writeBool(int paramInt, boolean paramBoolean)
    {
      writeTag(paramInt, 0);
      write((byte)paramBoolean);
    }
    
    public final void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public final void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public final void writeBytes(int paramInt, ByteString paramByteString)
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public final void writeBytesNoTag(ByteString paramByteString)
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public final void writeFixed32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 5);
      writeFixed32NoTag(paramInt2);
    }
    
    public final void writeFixed32NoTag(int paramInt)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int j = this.position;
        int i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(paramInt & 0xFF));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)(paramInt >> 16 & 0xFF));
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void writeFixed64(int paramInt, long paramLong)
    {
      writeTag(paramInt, 1);
      writeFixed64NoTag(paramLong);
    }
    
    public final void writeFixed64NoTag(long paramLong)
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int j = this.position;
        int i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)((int)paramLong & 0xFF));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)((int)(paramLong >> 16) & 0xFF));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)((int)(paramLong >> 32) & 0xFF));
        j = i + 1;
        this.position = j;
        arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
        i = j + 1;
        this.position = i;
        arrayOfByte[j] = ((byte)((int)(paramLong >> 48) & 0xFF));
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void writeInt32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 0);
      writeInt32NoTag(paramInt2);
    }
    
    public final void writeInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public final void writeLazy(ByteBuffer paramByteBuffer)
    {
      write(paramByteBuffer);
    }
    
    public final void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeMessage(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public final void writeMessageNoTag(MessageLite paramMessageLite)
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public final void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public final void writeRawBytes(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public final void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public final void writeString(int paramInt, String paramString)
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public final void writeStringNoTag(String paramString)
    {
      int j = this.position;
      try
      {
        int i = CodedOutputStream.computeUInt32SizeNoTag(paramString.length() * 3);
        int k = CodedOutputStream.computeUInt32SizeNoTag(paramString.length());
        if (k == i)
        {
          i = j + k;
          this.position = i;
          i = Utf8.encode(paramString, this.buffer, i, spaceLeft());
          this.position = j;
          writeUInt32NoTag(i - j - k);
        }
        for (;;)
        {
          this.position = i;
          return;
          writeUInt32NoTag(Utf8.encodedLength(paramString));
          i = Utf8.encode(paramString, this.buffer, this.position, spaceLeft());
        }
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.position = j;
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
      }
    }
    
    public final void writeTag(int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public final void writeUInt32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 0);
      writeUInt32NoTag(paramInt2);
    }
    
    public final void writeUInt32NoTag(int paramInt)
    {
      int i = paramInt;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        i = paramInt;
        if (spaceLeft() >= 10) {
          for (long l = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;; l = 1L + l)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              UnsafeUtil.putByte(this.buffer, l, (byte)paramInt);
              this.position += 1;
              return;
            }
            UnsafeUtil.putByte(this.buffer, l, (byte)(paramInt & 0x7F | 0x80));
            this.position += 1;
            paramInt >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0) {}
        try
        {
          arrayOfByte = this.buffer;
          paramInt = this.position;
          this.position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          byte[] arrayOfByte;
          throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void writeUInt64(int paramInt, long paramLong)
    {
      writeTag(paramInt, 0);
      writeUInt64NoTag(paramLong);
    }
    
    public final void writeUInt64NoTag(long paramLong)
    {
      long l1 = paramLong;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        l1 = paramLong;
        if (spaceLeft() >= 10)
        {
          long l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
          l1 = paramLong;
          for (paramLong = l2;; paramLong = 1L + paramLong)
          {
            if ((l1 & 0xFFFFFF80) == 0L)
            {
              UnsafeUtil.putByte(this.buffer, paramLong, (byte)(int)l1);
              this.position += 1;
              return;
            }
            UnsafeUtil.putByte(this.buffer, paramLong, (byte)((int)l1 & 0x7F | 0x80));
            this.position += 1;
            l1 >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((l1 & 0xFFFFFF80) == 0L) {}
        try
        {
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)(int)l1);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          byte[] arrayOfByte;
          int i;
          throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l1 & 0x7F | 0x80));
        l1 >>>= 7;
      }
    }
  }
  
  private static final class ByteOutputEncoder
    extends CodedOutputStream.AbstractBufferedEncoder
  {
    private final ByteOutput out;
    
    ByteOutputEncoder(ByteOutput paramByteOutput, int paramInt)
    {
      super();
      Objects.requireNonNull(paramByteOutput, "out");
      this.out = paramByteOutput;
    }
    
    private void doFlush()
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
    }
    
    private void flushIfNotAvailable(int paramInt)
    {
      if (this.limit - this.position < paramInt) {
        doFlush();
      }
    }
    
    public void flush()
    {
      if (this.position > 0) {
        doFlush();
      }
    }
    
    public void write(byte paramByte)
    {
      if (this.position == this.limit) {
        doFlush();
      }
      buffer(paramByte);
    }
    
    public void write(ByteBuffer paramByteBuffer)
    {
      flush();
      int i = paramByteBuffer.remaining();
      this.out.write(paramByteBuffer);
      this.totalBytesWritten += i;
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      flush();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      this.totalBytesWritten += paramInt2;
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
    {
      flushIfNotAvailable(11);
      bufferTag(paramInt, 0);
      buffer((byte)paramBoolean);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(14);
      bufferTag(paramInt1, 5);
      bufferFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
    {
      flushIfNotAvailable(4);
      bufferFixed32NoTag(paramInt);
    }
    
    public void writeFixed64(int paramInt, long paramLong)
    {
      flushIfNotAvailable(18);
      bufferTag(paramInt, 1);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
    {
      flushIfNotAvailable(8);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
    {
      flush();
      int i = paramByteBuffer.remaining();
      this.out.writeLazy(paramByteBuffer);
      this.totalBytesWritten += i;
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      flush();
      this.out.writeLazy(paramArrayOfByte, paramInt1, paramInt2);
      this.totalBytesWritten += paramInt2;
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public void writeStringNoTag(String paramString)
    {
      int i = paramString.length() * 3;
      int j = CodedOutputStream.computeUInt32SizeNoTag(i);
      int k = j + i;
      int m = this.limit;
      if (k > m)
      {
        byte[] arrayOfByte = new byte[i];
        i = Utf8.encode(paramString, arrayOfByte, 0, i);
        writeUInt32NoTag(i);
        writeLazy(arrayOfByte, 0, i);
        return;
      }
      if (k > m - this.position) {
        doFlush();
      }
      i = this.position;
      try
      {
        k = CodedOutputStream.computeUInt32SizeNoTag(paramString.length());
        if (k == j)
        {
          j = i + k;
          this.position = j;
          j = Utf8.encode(paramString, this.buffer, j, this.limit - j);
          this.position = i;
          k = j - i - k;
          bufferUInt32NoTag(k);
          this.position = j;
          this.totalBytesWritten += k;
          return;
        }
        j = Utf8.encodedLength(paramString);
        bufferUInt32NoTag(j);
        this.position = Utf8.encode(paramString, this.buffer, this.position, j);
        this.totalBytesWritten += j;
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.totalBytesWritten -= this.position - i;
        this.position = i;
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
      }
    }
    
    public void writeTag(int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
    {
      flushIfNotAvailable(10);
      bufferUInt32NoTag(paramInt);
    }
    
    public void writeUInt64(int paramInt, long paramLong)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt, 0);
      bufferUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
    {
      flushIfNotAvailable(10);
      bufferUInt64NoTag(paramLong);
    }
  }
  
  private static final class NioEncoder
    extends CodedOutputStream
  {
    private final ByteBuffer buffer;
    private final int initialPosition;
    private final ByteBuffer originalBuffer;
    
    NioEncoder(ByteBuffer paramByteBuffer)
    {
      super();
      this.originalBuffer = paramByteBuffer;
      this.buffer = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.initialPosition = paramByteBuffer.position();
    }
    
    private void encode(String paramString)
    {
      try
      {
        Utf8.encodeUtf8(paramString, this.buffer);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
    }
    
    public void flush()
    {
      this.originalBuffer.position(this.buffer.position());
    }
    
    public int getTotalBytesWritten()
    {
      return this.buffer.position() - this.initialPosition;
    }
    
    public int spaceLeft()
    {
      return this.buffer.remaining();
    }
    
    public void write(byte paramByte)
    {
      try
      {
        this.buffer.put(paramByte);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void write(ByteBuffer paramByteBuffer)
    {
      try
      {
        this.buffer.put(paramByteBuffer);
        return;
      }
      catch (BufferOverflowException paramByteBuffer)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramByteBuffer);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        this.buffer.put(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (BufferOverflowException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
      }
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
    {
      writeTag(paramInt, 0);
      write((byte)paramBoolean);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 5);
      writeFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
    {
      try
      {
        this.buffer.putInt(paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void writeFixed64(int paramInt, long paramLong)
    {
      writeTag(paramInt, 1);
      writeFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
    {
      try
      {
        this.buffer.putLong(paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 0);
      writeInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
    {
      write(paramByteBuffer);
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public void writeStringNoTag(String paramString)
    {
      int i = this.buffer.position();
      try
      {
        int j = CodedOutputStream.computeUInt32SizeNoTag(paramString.length() * 3);
        int k = CodedOutputStream.computeUInt32SizeNoTag(paramString.length());
        if (k == j)
        {
          j = this.buffer.position() + k;
          this.buffer.position(j);
          encode(paramString);
          k = this.buffer.position();
          this.buffer.position(i);
          writeUInt32NoTag(k - j);
          this.buffer.position(k);
          return;
        }
        writeUInt32NoTag(Utf8.encodedLength(paramString));
        encode(paramString);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.buffer.position(i);
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
      }
    }
    
    public void writeTag(int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
    {
      writeTag(paramInt1, 0);
      writeUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
    {
      for (;;)
      {
        if ((paramInt & 0xFFFFFF80) == 0) {}
        try
        {
          this.buffer.put((byte)paramInt);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
        }
        this.buffer.put((byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      }
    }
    
    public void writeUInt64(int paramInt, long paramLong)
    {
      writeTag(paramInt, 0);
      writeUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
    {
      for (;;)
      {
        if ((0xFFFFFF80 & paramLong) == 0L) {}
        try
        {
          this.buffer.put((byte)(int)paramLong);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
        }
        this.buffer.put((byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7;
      }
    }
  }
  
  private static final class NioHeapEncoder
    extends CodedOutputStream.ArrayEncoder
  {
    private final ByteBuffer byteBuffer;
    private int initialPosition;
    
    NioHeapEncoder(ByteBuffer paramByteBuffer)
    {
      super(paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      this.byteBuffer = paramByteBuffer;
      this.initialPosition = paramByteBuffer.position();
    }
    
    public void flush()
    {
      this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
    }
  }
  
  public static class OutOfSpaceException
    extends IOException
  {
    private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
    private static final long serialVersionUID = -6947486886997889499L;
    
    OutOfSpaceException()
    {
      super();
    }
    
    OutOfSpaceException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    OutOfSpaceException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  private static final class OutputStreamEncoder
    extends CodedOutputStream.AbstractBufferedEncoder
  {
    private final OutputStream out;
    
    OutputStreamEncoder(OutputStream paramOutputStream, int paramInt)
    {
      super();
      Objects.requireNonNull(paramOutputStream, "out");
      this.out = paramOutputStream;
    }
    
    private void doFlush()
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
    }
    
    private void flushIfNotAvailable(int paramInt)
    {
      if (this.limit - this.position < paramInt) {
        doFlush();
      }
    }
    
    public void flush()
    {
      if (this.position > 0) {
        doFlush();
      }
    }
    
    public void write(byte paramByte)
    {
      if (this.position == this.limit) {
        doFlush();
      }
      buffer(paramByte);
    }
    
    public void write(ByteBuffer paramByteBuffer)
    {
      int i = paramByteBuffer.remaining();
      int k = this.limit;
      int j = this.position;
      if (k - j >= i) {
        paramByteBuffer.get(this.buffer, j, i);
      }
      for (this.position += i;; this.position = i)
      {
        this.totalBytesWritten += i;
        return;
        k -= j;
        paramByteBuffer.get(this.buffer, j, k);
        i -= k;
        this.position = this.limit;
        this.totalBytesWritten += k;
        doFlush();
        for (;;)
        {
          j = this.limit;
          if (i <= j) {
            break;
          }
          paramByteBuffer.get(this.buffer, 0, j);
          this.out.write(this.buffer, 0, this.limit);
          j = this.limit;
          i -= j;
          this.totalBytesWritten += j;
        }
        paramByteBuffer.get(this.buffer, 0, i);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = this.limit;
      int j = this.position;
      if (i - j >= paramInt2)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, j, paramInt2);
        this.position += paramInt2;
      }
      for (;;)
      {
        this.totalBytesWritten += paramInt2;
        return;
        i -= j;
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, j, i);
        paramInt1 += i;
        paramInt2 -= i;
        this.position = this.limit;
        this.totalBytesWritten += i;
        doFlush();
        if (paramInt2 <= this.limit)
        {
          System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, 0, paramInt2);
          this.position = paramInt2;
        }
        else
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
    {
      flushIfNotAvailable(11);
      bufferTag(paramInt, 0);
      buffer((byte)paramBoolean);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(14);
      bufferTag(paramInt1, 5);
      bufferFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
    {
      flushIfNotAvailable(4);
      bufferFixed32NoTag(paramInt);
    }
    
    public void writeFixed64(int paramInt, long paramLong)
    {
      flushIfNotAvailable(18);
      bufferTag(paramInt, 1);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
    {
      flushIfNotAvailable(8);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
    {
      write(paramByteBuffer);
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public void writeStringNoTag(String paramString)
    {
      try
      {
        int j = paramString.length() * 3;
        int i = CodedOutputStream.computeUInt32SizeNoTag(j);
        int k = i + j;
        int m = this.limit;
        if (k > m)
        {
          byte[] arrayOfByte = new byte[j];
          i = Utf8.encode(paramString, arrayOfByte, 0, j);
          writeUInt32NoTag(i);
          writeLazy(arrayOfByte, 0, i);
          return;
        }
        if (k > m - this.position) {
          doFlush();
        }
        k = CodedOutputStream.computeUInt32SizeNoTag(paramString.length());
        j = this.position;
        if (k == i) {
          i = j + k;
        }
        try
        {
          this.position = i;
          m = Utf8.encode(paramString, this.buffer, i, this.limit - i);
          this.position = j;
          i = m - j - k;
          bufferUInt32NoTag(i);
          this.position = m;
          break label175;
          i = Utf8.encodedLength(paramString);
          bufferUInt32NoTag(i);
          this.position = Utf8.encode(paramString, this.buffer, this.position, i);
          label175:
          this.totalBytesWritten += i;
          return;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw new CodedOutputStream.OutOfSpaceException(localArrayIndexOutOfBoundsException);
        }
        catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException1)
        {
          this.totalBytesWritten -= this.position - j;
          this.position = j;
          throw localUnpairedSurrogateException1;
        }
        return;
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException2)
      {
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException2);
      }
    }
    
    public void writeTag(int paramInt1, int paramInt2)
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
    {
      flushIfNotAvailable(10);
      bufferUInt32NoTag(paramInt);
    }
    
    public void writeUInt64(int paramInt, long paramLong)
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt, 0);
      bufferUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
    {
      flushIfNotAvailable(10);
      bufferUInt64NoTag(paramLong);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.CodedOutputStream
 * JD-Core Version:    0.7.0.1
 */