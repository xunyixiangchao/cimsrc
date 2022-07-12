package com.google.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream
{
  private static final int BUFFER_SIZE = 4096;
  private static final int DEFAULT_RECURSION_LIMIT = 100;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private final byte[] buffer;
  private final boolean bufferIsImmutable;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int currentLimit = 2147483647;
  private boolean enableAliasing = false;
  private final InputStream input;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 100;
  private RefillCallback refillCallback = null;
  private int sizeLimit = 67108864;
  private int totalBytesRetired;
  
  private CodedInputStream(InputStream paramInputStream, int paramInt)
  {
    this.buffer = new byte[paramInt];
    this.bufferPos = 0;
    this.totalBytesRetired = 0;
    this.input = paramInputStream;
    this.bufferIsImmutable = false;
  }
  
  private CodedInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt2 + paramInt1);
    this.bufferPos = paramInt1;
    this.totalBytesRetired = (-paramInt1);
    this.input = null;
    this.bufferIsImmutable = paramBoolean;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream)
  {
    return new CodedInputStream(paramInputStream, 4096);
  }
  
  static CodedInputStream newInstance(InputStream paramInputStream, int paramInt)
  {
    return new CodedInputStream(paramInputStream, paramInt);
  }
  
  public static CodedInputStream newInstance(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return newInstance(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    paramByteBuffer = paramByteBuffer.duplicate();
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return newInstance(arrayOfByte);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newInstance(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  static CodedInputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new CodedInputStream(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
    try
    {
      paramArrayOfByte.pushLimit(paramInt2);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  private byte[] readRawBytesSlowPath(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0) {
        return Internal.EMPTY_BYTE_ARRAY;
      }
      throw InvalidProtocolBufferException.negativeSize();
    }
    int j = this.totalBytesRetired;
    int m = this.bufferPos;
    int i = j + m + paramInt;
    if (i <= this.sizeLimit)
    {
      int k = this.currentLimit;
      if (i <= k)
      {
        Object localObject1 = this.input;
        if (localObject1 != null)
        {
          k = this.bufferSize;
          i = k - m;
          this.totalBytesRetired = (j + k);
          this.bufferPos = 0;
          this.bufferSize = 0;
          j = paramInt - i;
          if ((j >= 4096) && (j > ((InputStream)localObject1).available()))
          {
            Object localObject2 = new ArrayList();
            while (j > 0)
            {
              int n = Math.min(j, 4096);
              localObject1 = new byte[n];
              k = 0;
              while (k < n)
              {
                int i1 = this.input.read((byte[])localObject1, k, n - k);
                if (i1 != -1)
                {
                  this.totalBytesRetired += i1;
                  k += i1;
                }
                else
                {
                  throw InvalidProtocolBufferException.truncatedMessage();
                }
              }
              j -= n;
              ((List)localObject2).add(localObject1);
            }
            localObject1 = new byte[paramInt];
            System.arraycopy(this.buffer, m, localObject1, 0, i);
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
              System.arraycopy(arrayOfByte, 0, localObject1, i, arrayOfByte.length);
              i += arrayOfByte.length;
            }
            return localObject1;
          }
          localObject1 = new byte[paramInt];
          System.arraycopy(this.buffer, m, localObject1, 0, i);
          while (i < paramInt)
          {
            j = this.input.read((byte[])localObject1, i, paramInt - i);
            if (j != -1)
            {
              this.totalBytesRetired += j;
              i += j;
            }
            else
            {
              throw InvalidProtocolBufferException.truncatedMessage();
            }
          }
          return localObject1;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      skipRawBytes(k - j - m);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.sizeLimitExceeded();
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream)
  {
    if ((paramInt & 0x80) == 0) {
      return paramInt;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    int j;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label67;
      }
      j = paramInputStream.read();
      if (j == -1) {
        break;
      }
      i |= (j & 0x7F) << paramInt;
      if ((j & 0x80) == 0) {
        return i;
      }
      paramInt += 7;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
    label67:
    while (j < 64)
    {
      paramInt = paramInputStream.read();
      if (paramInt != -1)
      {
        if ((paramInt & 0x80) == 0) {
          return i;
        }
        j += 7;
      }
      else
      {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  static int readRawVarint32(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return readRawVarint32(i, paramInputStream);
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    int i = this.bufferSize + this.bufferSizeAfterLimit;
    this.bufferSize = i;
    int j = this.totalBytesRetired + i;
    int k = this.currentLimit;
    if (j > k)
    {
      j -= k;
      this.bufferSizeAfterLimit = j;
      this.bufferSize = (i - j);
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private void refillBuffer(int paramInt)
  {
    if (tryRefillBuffer(paramInt)) {
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void skipRawBytesSlowPath(int paramInt)
  {
    if (paramInt >= 0)
    {
      int j = this.totalBytesRetired;
      int i = this.bufferPos;
      int k = this.currentLimit;
      if (j + i + paramInt <= k)
      {
        j = this.bufferSize;
        i = j - i;
        for (this.bufferPos = j;; this.bufferPos = j)
        {
          refillBuffer(1);
          k = paramInt - i;
          j = this.bufferSize;
          if (k <= j) {
            break;
          }
          i += j;
        }
        this.bufferPos = k;
        return;
      }
      skipRawBytes(k - j - i);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  private void skipRawVarint()
  {
    int j = this.bufferSize;
    int i = this.bufferPos;
    if (j - i >= 10)
    {
      byte[] arrayOfByte = this.buffer;
      j = 0;
      while (j < 10)
      {
        int k = i + 1;
        if (arrayOfByte[i] >= 0)
        {
          this.bufferPos = k;
          return;
        }
        j += 1;
        i = k;
      }
    }
    skipRawVarintSlowPath();
  }
  
  private void skipRawVarintSlowPath()
  {
    int i = 0;
    while (i < 10)
    {
      if (readRawByte() >= 0) {
        return;
      }
      i += 1;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private boolean tryRefillBuffer(int paramInt)
  {
    int i = this.bufferPos;
    if (i + paramInt > this.bufferSize)
    {
      if (this.totalBytesRetired + i + paramInt > this.currentLimit) {
        return false;
      }
      localObject = this.refillCallback;
      if (localObject != null) {
        ((RefillCallback)localObject).onRefill();
      }
      if (this.input != null)
      {
        i = this.bufferPos;
        if (i > 0)
        {
          int j = this.bufferSize;
          if (j > i)
          {
            localObject = this.buffer;
            System.arraycopy(localObject, i, localObject, 0, j - i);
          }
          this.totalBytesRetired += i;
          this.bufferSize -= i;
          this.bufferPos = 0;
        }
        localObject = this.input;
        byte[] arrayOfByte = this.buffer;
        i = this.bufferSize;
        i = ((InputStream)localObject).read(arrayOfByte, i, arrayOfByte.length - i);
        if ((i != 0) && (i >= -1) && (i <= this.buffer.length))
        {
          if (i > 0)
          {
            this.bufferSize += i;
            if (this.totalBytesRetired + paramInt - this.sizeLimit <= 0)
            {
              recomputeBufferSizeAfterLimit();
              if (this.bufferSize >= paramInt) {
                return true;
              }
              return tryRefillBuffer(paramInt);
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("InputStream#read(byte[]) returned invalid result: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("\nThe InputStream implementation is buggy.");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refillBuffer() called when ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes were already available in buffer");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  public void enableAliasing(boolean paramBoolean)
  {
    this.enableAliasing = paramBoolean;
  }
  
  public int getBytesUntilLimit()
  {
    int i = this.currentLimit;
    if (i == 2147483647) {
      return -1;
    }
    return i - (this.totalBytesRetired + this.bufferPos);
  }
  
  public int getLastTag()
  {
    return this.lastTag;
  }
  
  public int getTotalBytesRead()
  {
    return this.totalBytesRetired + this.bufferPos;
  }
  
  public boolean isAtEnd()
  {
    return (this.bufferPos == this.bufferSize) && (!tryRefillBuffer(1));
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      paramInt += this.totalBytesRetired + this.bufferPos;
      int i = this.currentLimit;
      if (paramInt <= i)
      {
        this.currentLimit = paramInt;
        recomputeBufferSizeAfterLimit();
        return i;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public boolean readBool()
  {
    return readRawVarint64() != 0L;
  }
  
  public byte[] readByteArray()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, k, k + i);
      this.bufferPos += i;
      return arrayOfByte;
    }
    return readRawBytesSlowPath(i);
  }
  
  public ByteBuffer readByteBuffer()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      ByteBuffer localByteBuffer;
      if ((this.input == null) && (!this.bufferIsImmutable) && (this.enableAliasing)) {
        localByteBuffer = ByteBuffer.wrap(this.buffer, k, i).slice();
      } else {
        localByteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, k, k + i));
      }
      this.bufferPos += i;
      return localByteBuffer;
    }
    if (i == 0) {
      return Internal.EMPTY_BYTE_BUFFER;
    }
    return ByteBuffer.wrap(readRawBytesSlowPath(i));
  }
  
  public ByteString readBytes()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      ByteString localByteString;
      if ((this.bufferIsImmutable) && (this.enableAliasing)) {
        localByteString = ByteString.wrap(this.buffer, k, i);
      } else {
        localByteString = ByteString.copyFrom(this.buffer, k, i);
      }
      this.bufferPos += i;
      return localByteString;
    }
    if (i == 0) {
      return ByteString.EMPTY;
    }
    return ByteString.wrap(readRawBytesSlowPath(i));
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum()
  {
    return readRawVarint32();
  }
  
  public int readFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public <T extends MessageLite> T readGroup(int paramInt, Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.recursionDepth;
    if (i < this.recursionLimit)
    {
      this.recursionDepth = (i + 1);
      paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(WireFormat.makeTag(paramInt, 4));
      this.recursionDepth -= 1;
      return paramParser;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.recursionDepth;
    if (i < this.recursionLimit)
    {
      this.recursionDepth = (i + 1);
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(WireFormat.makeTag(paramInt, 4));
      this.recursionDepth -= 1;
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public int readInt32()
  {
    return readRawVarint32();
  }
  
  public long readInt64()
  {
    return readRawVarint64();
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return paramParser;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public byte readRawByte()
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt)
  {
    int i = this.bufferPos;
    if ((paramInt <= this.bufferSize - i) && (paramInt > 0))
    {
      paramInt += i;
      this.bufferPos = paramInt;
      return Arrays.copyOfRange(this.buffer, i, paramInt);
    }
    return readRawBytesSlowPath(paramInt);
  }
  
  public int readRawLittleEndian32()
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      refillBuffer(4);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public long readRawLittleEndian64()
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      refillBuffer(8);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  public int readRawVarint32()
  {
    int k = this.bufferPos;
    int i = this.bufferSize;
    int j;
    if (i != k)
    {
      byte[] arrayOfByte = this.buffer;
      j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.bufferPos = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0)
        {
          j = k ^ 0xFFFFFF80;
          break label269;
        }
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          k ^= 0x3F80;
          i = j;
          j = k;
        }
        int m;
        int n;
        do
        {
          do
          {
            do
            {
              break;
              i = j + 1;
              j = k ^ arrayOfByte[j] << 21;
              if (j < 0)
              {
                j ^= 0xFFE03F80;
                break;
              }
              m = i + 1;
              n = arrayOfByte[i];
              k = j ^ n << 28 ^ 0xFE03F80;
              j = k;
              i = m;
            } while (n >= 0);
            n = m + 1;
            j = k;
            i = n;
            if (arrayOfByte[m] >= 0) {
              break;
            }
            m = n + 1;
            j = k;
            i = m;
          } while (arrayOfByte[n] >= 0);
          n = m + 1;
          j = k;
          i = n;
          if (arrayOfByte[m] >= 0) {
            break;
          }
          m = n + 1;
          j = k;
          i = m;
        } while (arrayOfByte[n] >= 0);
        i = m + 1;
        j = k;
        if (arrayOfByte[m] >= 0) {
          break label269;
        }
      }
    }
    return (int)readRawVarint64SlowPath();
    label269:
    this.bufferPos = i;
    return j;
  }
  
  public long readRawVarint64()
  {
    int k = this.bufferPos;
    int i = this.bufferSize;
    int j;
    long l1;
    if (i != k)
    {
      byte[] arrayOfByte = this.buffer;
      j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.bufferPos = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0) {
          j = k ^ 0xFFFFFF80;
        }
        for (;;)
        {
          l1 = j;
          break label343;
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0)
          {
            l1 = k ^ 0x3F80;
            i = j;
            break label343;
          }
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j >= 0) {
            break;
          }
          j ^= 0xFFE03F80;
        }
        l1 = j;
        j = i + 1;
        long l2 = l1 ^ arrayOfByte[i] << 28;
        if (l2 >= 0L)
        {
          l1 = 266354560L;
          i = j;
          l1 = l2 ^ l1;
          break label343;
        }
        i = j + 1;
        l1 = l2 ^ arrayOfByte[j] << 35;
        if (l1 < 0L) {}
        for (l2 = -34093383808L;; l2 = -558586000294016L)
        {
          l1 ^= l2;
          break label343;
          j = i + 1;
          l2 = l1 ^ arrayOfByte[i] << 42;
          if (l2 >= 0L)
          {
            l1 = 4363953127296L;
            i = j;
            break;
          }
          i = j + 1;
          l1 = l2 ^ arrayOfByte[j] << 49;
          if (l1 >= 0L) {
            break label294;
          }
        }
        label294:
        j = i + 1;
        l1 = l1 ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
        if (l1 >= 0L) {
          break label341;
        }
        i = j + 1;
        if (arrayOfByte[j] >= 0L) {
          break label343;
        }
      }
    }
    return readRawVarint64SlowPath();
    label341:
    i = j;
    label343:
    this.bufferPos = i;
    return l1;
  }
  
  long readRawVarint64SlowPath()
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public int readSFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    String str;
    if ((i <= j - k) && (i > 0))
    {
      str = new String(this.buffer, k, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i <= j)
    {
      refillBuffer(i);
      str = new String(this.buffer, this.bufferPos, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    }
    return new String(readRawBytesSlowPath(i), Internal.UTF_8);
  }
  
  public String readStringRequireUtf8()
  {
    int j = readRawVarint32();
    int i = this.bufferPos;
    int k = this.bufferSize;
    byte[] arrayOfByte;
    if ((j <= k - i) && (j > 0))
    {
      arrayOfByte = this.buffer;
      this.bufferPos = (i + j);
    }
    else
    {
      if (j == 0) {
        return "";
      }
      if (j <= k)
      {
        refillBuffer(j);
        arrayOfByte = this.buffer;
        this.bufferPos = (j + 0);
      }
      else
      {
        arrayOfByte = readRawBytesSlowPath(j);
      }
      i = 0;
    }
    if (Utf8.isValidUtf8(arrayOfByte, i, i + j)) {
      return new String(arrayOfByte, i, j, Internal.UTF_8);
    }
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  public int readTag()
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    int i = readRawVarint32();
    this.lastTag = i;
    if (WireFormat.getTagFieldNumber(i) != 0) {
      return this.lastTag;
    }
    throw InvalidProtocolBufferException.invalidTag();
  }
  
  public int readUInt32()
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
  {
    return readRawVarint64();
  }
  
  @Deprecated
  public void readUnknownGroup(int paramInt, MessageLite.Builder paramBuilder)
  {
    readGroup(paramInt, paramBuilder, null);
  }
  
  public void resetSizeCounter()
  {
    this.totalBytesRetired = (-this.bufferPos);
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.recursionLimit;
      this.recursionLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recursion limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.sizeLimit;
      this.sizeLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean skipField(int paramInt)
  {
    int i = WireFormat.getTagWireType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                skipRawBytes(4);
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          skipMessage();
          checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4));
          return true;
        }
        skipRawBytes(readRawVarint32());
        return true;
      }
      skipRawBytes(8);
      return true;
    }
    skipRawVarint();
    return true;
  }
  
  public boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    int i = WireFormat.getTagWireType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                i = readRawLittleEndian32();
                paramCodedOutputStream.writeRawVarint32(paramInt);
                paramCodedOutputStream.writeFixed32NoTag(i);
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          paramCodedOutputStream.writeRawVarint32(paramInt);
          skipMessage(paramCodedOutputStream);
          paramInt = WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4);
          checkLastTagWas(paramInt);
          paramCodedOutputStream.writeRawVarint32(paramInt);
          return true;
        }
        ByteString localByteString = readBytes();
        paramCodedOutputStream.writeRawVarint32(paramInt);
        paramCodedOutputStream.writeBytesNoTag(localByteString);
        return true;
      }
      l = readRawLittleEndian64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeFixed64NoTag(l);
      return true;
    }
    long l = readInt64();
    paramCodedOutputStream.writeRawVarint32(paramInt);
    paramCodedOutputStream.writeUInt64NoTag(l);
    return true;
  }
  
  public void skipMessage()
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public void skipMessage(CodedOutputStream paramCodedOutputStream)
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i, paramCodedOutputStream)));
  }
  
  public void skipRawBytes(int paramInt)
  {
    int i = this.bufferSize;
    int j = this.bufferPos;
    if ((paramInt <= i - j) && (paramInt >= 0))
    {
      this.bufferPos = (j + paramInt);
      return;
    }
    skipRawBytesSlowPath(paramInt);
  }
  
  private static abstract interface RefillCallback
  {
    public abstract void onRefill();
  }
  
  private class SkippedDataSink
    implements CodedInputStream.RefillCallback
  {
    private ByteArrayOutputStream byteArrayStream;
    private int lastPos = CodedInputStream.this.bufferPos;
    
    private SkippedDataSink() {}
    
    ByteBuffer getSkippedData()
    {
      ByteArrayOutputStream localByteArrayOutputStream = this.byteArrayStream;
      if (localByteArrayOutputStream == null) {
        return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      }
      localByteArrayOutputStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
      return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
    
    public void onRefill()
    {
      if (this.byteArrayStream == null) {
        this.byteArrayStream = new ByteArrayOutputStream();
      }
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      this.lastPos = 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.CodedInputStream
 * JD-Core Version:    0.7.0.1
 */