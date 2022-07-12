package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8
{
  private static final long ASCII_MASK_LONG = -9187201950435737472L;
  public static final int COMPLETE = 0;
  public static final int MALFORMED = -1;
  static final int MAX_BYTES_PER_CHAR = 3;
  private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
  private static final Processor processor;
  
  static
  {
    Object localObject;
    if (UnsafeProcessor.isAvailable()) {
      localObject = new UnsafeProcessor();
    } else {
      localObject = new SafeProcessor();
    }
    processor = (Processor)localObject;
  }
  
  static int encode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return processor.encodeUtf8(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    processor.encodeUtf8(paramCharSequence, paramByteBuffer);
  }
  
  static int encodedLength(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while ((j < m) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    int i = m;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break label87;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int k = i + encodedLengthGeneral(paramCharSequence, j);
    label87:
    if (k >= m) {
      return k;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      else
      {
        int k = i + 2;
        i = k;
        j = paramInt;
        if (55296 <= n)
        {
          i = k;
          j = paramInt;
          if (n <= 57343) {
            if (Character.codePointAt(paramCharSequence, paramInt) >= 65536)
            {
              j = paramInt + 1;
              i = k;
            }
            else
            {
              throw new UnpairedSurrogateException(paramInt, m);
            }
          }
        }
      }
      paramInt = j + 1;
    }
    return i;
  }
  
  private static int estimateConsecutiveAscii(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt2 - 7) && ((paramByteBuffer.getLong(i) & 0x80808080) == 0L)) {
      i += 8;
    }
    return i - paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  private static int incompleteStateFor(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1)
      {
        if (paramInt3 == 2) {
          return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2), paramByteBuffer.get(paramInt2 + 1));
        }
        throw new AssertionError();
      }
      return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2));
    }
    return incompleteStateFor(paramInt1);
  }
  
  private static int incompleteStateFor(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return incompleteStateFor(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return incompleteStateFor(i, paramArrayOfByte[paramInt1]);
    }
    return incompleteStateFor(i);
  }
  
  static boolean isValidUtf8(ByteBuffer paramByteBuffer)
  {
    return processor.isValidUtf8(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return processor.isValidUtf8(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return processor.isValidUtf8(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    return processor.partialIsValidUtf8(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  public static int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return processor.partialIsValidUtf8(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  static abstract class Processor
  {
    private static int partialIsValidUtf8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      paramInt1 += Utf8.estimateConsecutiveAscii(paramByteBuffer, paramInt1, paramInt2);
      label237:
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          return 0;
        }
        int i = paramInt1 + 1;
        int j = paramByteBuffer.get(paramInt1);
        paramInt1 = i;
        if (j < 0) {
          if (j < -32)
          {
            if (i >= paramInt2) {
              return j;
            }
            if (j >= -62)
            {
              if (paramByteBuffer.get(i) > -65) {
                return -1;
              }
              paramInt1 = i + 1;
            }
            else
            {
              return -1;
            }
          }
          else
          {
            if (j < -16) {
              if (i < paramInt2 - 1) {}
            }
            while (i >= paramInt2 - 2)
            {
              return Utf8.incompleteStateFor(paramByteBuffer, j, i, paramInt2 - i);
              paramInt1 = i + 1;
              i = paramByteBuffer.get(i);
              if ((i <= -65) && ((j != -32) || (i >= -96)) && ((j != -19) || (i < -96)))
              {
                if (paramByteBuffer.get(paramInt1) > -65) {
                  return -1;
                }
                paramInt1 += 1;
                break;
              }
              return -1;
            }
            paramInt1 = i + 1;
            i = paramByteBuffer.get(i);
            if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
            {
              i = paramInt1 + 1;
              if (paramByteBuffer.get(paramInt1) <= -65)
              {
                paramInt1 = i + 1;
                if (paramByteBuffer.get(i) <= -65) {
                  break label237;
                }
              }
            }
            return -1;
          }
        }
      }
    }
    
    abstract int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    final void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        int i = paramByteBuffer.arrayOffset();
        paramByteBuffer.position(Utf8.encode(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
        return;
      }
      if (paramByteBuffer.isDirect())
      {
        encodeUtf8Direct(paramCharSequence, paramByteBuffer);
        return;
      }
      encodeUtf8Default(paramCharSequence, paramByteBuffer);
    }
    
    final void encodeUtf8Default(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      int i2 = paramCharSequence.length();
      k = paramByteBuffer.position();
      j = 0;
      for (;;)
      {
        int n;
        int m;
        if (j < i2)
        {
          n = k;
          m = j;
        }
        try
        {
          i1 = paramCharSequence.charAt(j);
          if (i1 < 128)
          {
            n = k;
            m = j;
            paramByteBuffer.put(k + j, (byte)i1);
            j += 1;
          }
          else
          {
            if (j != i2) {
              break label677;
            }
            n = k;
            m = j;
            paramByteBuffer.position(k + j);
            return;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          for (;;)
          {
            int i1;
            int i;
            byte b;
            char c;
            int i3;
            j = m;
            continue;
            k += j;
            continue;
            j += 1;
            k += 1;
          }
        }
      }
      if (j < i2)
      {
        n = k;
        m = j;
        i = paramCharSequence.charAt(j);
        if (i < 128)
        {
          n = k;
          m = j;
          paramByteBuffer.put(k, (byte)i);
          break label687;
        }
        if (i < 2048)
        {
          n = k + 1;
          b = (byte)(i >>> 6 | 0xC0);
          m = n;
        }
      }
      try
      {
        paramByteBuffer.put(k, b);
        m = n;
        paramByteBuffer.put(n, (byte)(i & 0x3F | 0x80));
        k = n;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
      {
        label225:
        break label225;
      }
      n = m;
      break label574;
      if ((i >= 55296) && (57343 >= i))
      {
        m = j + 1;
        if (m != i2) {
          j = k;
        }
      }
      try
      {
        c = paramCharSequence.charAt(m);
        j = k;
        if (Character.isSurrogatePair(i, c))
        {
          j = k;
          i3 = Character.toCodePoint(i, c);
          n = k + 1;
          b = (byte)(i3 >>> 18 | 0xF0);
          j = n;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException3)
      {
        label424:
        label434:
        label445:
        break label434;
      }
      try
      {
        paramByteBuffer.put(k, b);
        i1 = n + 1;
        b = (byte)(i3 >>> 12 & 0x3F | 0x80);
        j = i1;
        paramByteBuffer.put(n, b);
        k = i1 + 1;
        b = (byte)(i3 >>> 6 & 0x3F | 0x80);
        j = k;
        paramByteBuffer.put(i1, b);
        j = k;
        paramByteBuffer.put(k, (byte)(i3 & 0x3F | 0x80));
        j = m;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException4)
      {
        break label424;
      }
      break label434;
      j = m;
      break label445;
      n = j;
      j = m;
      break label574;
      n = k;
      m = j;
      throw new Utf8.UnpairedSurrogateException(j, i2);
      i1 = k + 1;
      b = (byte)(i >>> 12 | 0xE0);
      m = i1;
      paramByteBuffer.put(k, b);
      k = i1 + 1;
      b = (byte)(i >>> 6 & 0x3F | 0x80);
      n = k;
      m = j;
      paramByteBuffer.put(i1, b);
      n = k;
      m = j;
      paramByteBuffer.put(k, (byte)(i & 0x3F | 0x80));
      break label687;
      n = k;
      m = j;
      paramByteBuffer.position(k);
      return;
      label574:
      k = paramByteBuffer.position();
      m = Math.max(j, n - paramByteBuffer.position() + 1);
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Failed writing ");
      paramByteBuffer.append(paramCharSequence.charAt(j));
      paramByteBuffer.append(" at index ");
      paramByteBuffer.append(k + m);
      throw new ArrayIndexOutOfBoundsException(paramByteBuffer.toString());
    }
    
    abstract void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);
    
    final boolean isValidUtf8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      boolean bool = false;
      if (partialIsValidUtf8(0, paramByteBuffer, paramInt1, paramInt2) == 0) {
        bool = true;
      }
      return bool;
    }
    
    final boolean isValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      boolean bool = false;
      if (partialIsValidUtf8(0, paramArrayOfByte, paramInt1, paramInt2) == 0) {
        bool = true;
      }
      return bool;
    }
    
    final int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer.hasArray())
      {
        int i = paramByteBuffer.arrayOffset();
        return partialIsValidUtf8(paramInt1, paramByteBuffer.array(), paramInt2 + i, i + paramInt3);
      }
      if (paramByteBuffer.isDirect()) {
        return partialIsValidUtf8Direct(paramInt1, paramByteBuffer, paramInt2, paramInt3);
      }
      return partialIsValidUtf8Default(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
    
    abstract int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
    
    final int partialIsValidUtf8Default(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        int m = (byte)paramInt1;
        if (m < -32) {
          if (m >= -62)
          {
            paramInt1 = paramInt2 + 1;
            if (paramByteBuffer.get(paramInt2) > -65) {
              return -1;
            }
          }
        }
        int j;
        label157:
        do
        {
          do
          {
            i = paramInt1;
            break label299;
            return -1;
            if (m >= -16) {
              break label157;
            }
            j = (byte)(paramInt1 >> 8);
            paramInt1 = j;
            i = paramInt2;
            if (j == 0)
            {
              i = paramInt2 + 1;
              paramInt1 = paramByteBuffer.get(paramInt2);
              if (i >= paramInt3) {
                return Utf8.incompleteStateFor(m, paramInt1);
              }
            }
            if ((paramInt1 > -65) || ((m == -32) && (paramInt1 < -96)) || ((m == -19) && (paramInt1 >= -96))) {
              break;
            }
            paramInt1 = i + 1;
          } while (paramByteBuffer.get(i) <= -65);
          return -1;
          i = (byte)(paramInt1 >> 8);
          j = 0;
          if (i == 0)
          {
            paramInt1 = paramInt2 + 1;
            i = paramByteBuffer.get(paramInt2);
            if (paramInt1 >= paramInt3) {
              return Utf8.incompleteStateFor(m, i);
            }
            paramInt2 = paramInt1;
            paramInt1 = j;
          }
          else
          {
            paramInt1 = (byte)(paramInt1 >> 16);
          }
          int k = paramInt1;
          j = paramInt2;
          if (paramInt1 == 0)
          {
            j = paramInt2 + 1;
            k = paramByteBuffer.get(paramInt2);
            if (j >= paramInt3) {
              return Utf8.incompleteStateFor(m, i, k);
            }
          }
          if ((i > -65) || ((m << 28) + (i + 112) >> 30 != 0) || (k > -65)) {
            break;
          }
          paramInt1 = j + 1;
        } while (paramByteBuffer.get(j) <= -65);
        return -1;
      }
      label299:
      return partialIsValidUtf8(paramByteBuffer, i, paramInt3);
    }
    
    abstract int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  }
  
  static final class SafeProcessor
    extends Utf8.Processor
  {
    private static int partialIsValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
        paramInt1 += 1;
      }
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      return partialIsValidUtf8NonAscii(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    private static int partialIsValidUtf8NonAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      label207:
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          return 0;
        }
        int i = paramInt1 + 1;
        int j = paramArrayOfByte[paramInt1];
        paramInt1 = i;
        if (j < 0) {
          if (j < -32)
          {
            if (i >= paramInt2) {
              return j;
            }
            if (j >= -62)
            {
              paramInt1 = i + 1;
              if (paramArrayOfByte[i] <= -65) {}
            }
            else
            {
              return -1;
            }
          }
          else if (j < -16)
          {
            if (i >= paramInt2 - 1) {
              return Utf8.incompleteStateFor(paramArrayOfByte, i, paramInt2);
            }
            int k = i + 1;
            paramInt1 = paramArrayOfByte[i];
            if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
            {
              paramInt1 = k + 1;
              if (paramArrayOfByte[k] <= -65) {}
            }
            else
            {
              return -1;
            }
          }
          else
          {
            if (i >= paramInt2 - 2) {
              return Utf8.incompleteStateFor(paramArrayOfByte, i, paramInt2);
            }
            paramInt1 = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
            {
              i = paramInt1 + 1;
              if (paramArrayOfByte[paramInt1] <= -65)
              {
                paramInt1 = i + 1;
                if (paramArrayOfByte[i] <= -65) {
                  break label207;
                }
              }
            }
            return -1;
          }
        }
      }
    }
    
    int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int k = paramCharSequence.length();
      int m = paramInt2 + paramInt1;
      paramInt2 = 0;
      int n;
      while (paramInt2 < k)
      {
        j = paramInt2 + paramInt1;
        if (j >= m) {
          break;
        }
        n = paramCharSequence.charAt(paramInt2);
        if (n >= 128) {
          break;
        }
        paramArrayOfByte[j] = ((byte)n);
        paramInt2 += 1;
      }
      if (paramInt2 == k) {
        return paramInt1 + k;
      }
      int j = paramInt1 + paramInt2;
      paramInt1 = paramInt2;
      while (paramInt1 < k)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < 128) && (j < m))
        {
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)i);
        }
        for (;;)
        {
          break;
          if ((i < 2048) && (j <= m - 2))
          {
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 | 0x3C0));
            paramInt2 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else if (((i < 55296) || (57343 < i)) && (j <= m - 3))
          {
            paramInt2 = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 12 | 0x1E0));
            j = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt2 = j + 1;
            paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (j > m - 4) {
              break label456;
            }
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == paramCharSequence.length()) {
              break label443;
            }
            char c = paramCharSequence.charAt(paramInt2);
            if (!Character.isSurrogatePair(i, c)) {
              break label440;
            }
            paramInt1 = Character.toCodePoint(i, c);
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
            j = n + 1;
            paramArrayOfByte[n] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            j = n + 1;
            paramArrayOfByte[n] = ((byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
            paramInt2 = j;
          }
        }
        paramInt1 += 1;
        j = paramInt2;
        continue;
        label440:
        paramInt1 = paramInt2;
        label443:
        throw new Utf8.UnpairedSurrogateException(paramInt1 - 1, k);
        label456:
        if ((55296 <= i) && (i <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
            throw new Utf8.UnpairedSurrogateException(paramInt1, k);
          }
        }
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(j);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      return j;
    }
    
    void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      encodeUtf8Default(paramCharSequence, paramByteBuffer);
    }
    
    int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        int m = (byte)paramInt1;
        if (m < -32) {
          if (m >= -62)
          {
            paramInt1 = paramInt2 + 1;
            if (paramArrayOfByte[paramInt2] > -65) {
              return -1;
            }
          }
        }
        int j;
        label151:
        do
        {
          do
          {
            i = paramInt1;
            break label287;
            return -1;
            if (m >= -16) {
              break label151;
            }
            j = (byte)(paramInt1 >> 8);
            paramInt1 = j;
            i = paramInt2;
            if (j == 0)
            {
              i = paramInt2 + 1;
              paramInt1 = paramArrayOfByte[paramInt2];
              if (i >= paramInt3) {
                return Utf8.incompleteStateFor(m, paramInt1);
              }
            }
            if ((paramInt1 > -65) || ((m == -32) && (paramInt1 < -96)) || ((m == -19) && (paramInt1 >= -96))) {
              break;
            }
            paramInt1 = i + 1;
          } while (paramArrayOfByte[i] <= -65);
          return -1;
          i = (byte)(paramInt1 >> 8);
          j = 0;
          if (i == 0)
          {
            paramInt1 = paramInt2 + 1;
            i = paramArrayOfByte[paramInt2];
            if (paramInt1 >= paramInt3) {
              return Utf8.incompleteStateFor(m, i);
            }
            paramInt2 = paramInt1;
            paramInt1 = j;
          }
          else
          {
            paramInt1 = (byte)(paramInt1 >> 16);
          }
          int k = paramInt1;
          j = paramInt2;
          if (paramInt1 == 0)
          {
            j = paramInt2 + 1;
            k = paramArrayOfByte[paramInt2];
            if (j >= paramInt3) {
              return Utf8.incompleteStateFor(m, i, k);
            }
          }
          if ((i > -65) || ((m << 28) + (i + 112) >> 30 != 0) || (k > -65)) {
            break;
          }
          paramInt1 = j + 1;
        } while (paramArrayOfByte[j] <= -65);
        return -1;
      }
      label287:
      return partialIsValidUtf8(paramArrayOfByte, i, paramInt3);
    }
    
    int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      return partialIsValidUtf8Default(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
  }
  
  static class UnpairedSurrogateException
    extends IllegalArgumentException
  {
    UnpairedSurrogateException(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  static final class UnsafeProcessor
    extends Utf8.Processor
  {
    static boolean isAvailable()
    {
      return (UnsafeUtil.hasUnsafeArrayOperations()) && (UnsafeUtil.hasUnsafeByteBufferOperations());
    }
    
    private static int partialIsValidUtf8(long paramLong, int paramInt)
    {
      int i = unsafeEstimateConsecutiveAscii(paramLong, paramInt);
      paramLong += i;
      paramInt -= i;
      int j = 0;
      i = paramInt;
      paramInt = j;
      long l1;
      for (;;)
      {
        l1 = paramLong;
        if (i <= 0) {
          break;
        }
        l1 = paramLong + 1L;
        paramInt = UnsafeUtil.getByte(paramLong);
        if (paramInt < 0) {
          break;
        }
        i -= 1;
        paramLong = l1;
      }
      if (i == 0) {
        return 0;
      }
      i -= 1;
      if (paramInt < -32)
      {
        if (i == 0) {
          return paramInt;
        }
        i -= 1;
        if (paramInt >= -62)
        {
          paramLong = 1L + l1;
          paramInt = i;
          if (UnsafeUtil.getByte(l1) > -65) {
            return -1;
          }
        }
      }
      label196:
      label198:
      do
      {
        long l2;
        do
        {
          break;
          return -1;
          if (paramInt >= -16) {
            break label198;
          }
          if (i < 2) {
            return unsafeIncompleteStateFor(l1, paramInt, i);
          }
          i -= 2;
          l2 = l1 + 1L;
          j = UnsafeUtil.getByte(l1);
          if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96))) {
            break label196;
          }
          paramLong = 1L + l2;
          paramInt = i;
        } while (UnsafeUtil.getByte(l2) <= -65);
        return -1;
        if (i < 3) {
          return unsafeIncompleteStateFor(l1, paramInt, i);
        }
        i -= 3;
        paramLong = l1 + 1L;
        j = UnsafeUtil.getByte(l1);
        if ((j > -65) || ((paramInt << 28) + (j + 112) >> 30 != 0)) {
          break label281;
        }
        l1 = paramLong + 1L;
        if (UnsafeUtil.getByte(paramLong) > -65) {
          break label281;
        }
        paramLong = 1L + l1;
        paramInt = i;
      } while (UnsafeUtil.getByte(l1) <= -65);
      label281:
      return -1;
    }
    
    private static int partialIsValidUtf8(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      int i = unsafeEstimateConsecutiveAscii(paramArrayOfByte, paramLong, paramInt);
      paramInt -= i;
      paramLong += i;
      int j = 0;
      i = paramInt;
      paramInt = j;
      long l1;
      for (;;)
      {
        l1 = paramLong;
        if (i <= 0) {
          break;
        }
        l1 = paramLong + 1L;
        paramInt = UnsafeUtil.getByte(paramArrayOfByte, paramLong);
        if (paramInt < 0) {
          break;
        }
        i -= 1;
        paramLong = l1;
      }
      if (i == 0) {
        return 0;
      }
      i -= 1;
      if (paramInt < -32)
      {
        if (i == 0) {
          return paramInt;
        }
        i -= 1;
        if (paramInt >= -62)
        {
          paramLong = 1L + l1;
          paramInt = i;
          if (UnsafeUtil.getByte(paramArrayOfByte, l1) > -65) {
            return -1;
          }
        }
      }
      label221:
      label223:
      do
      {
        long l2;
        do
        {
          break;
          return -1;
          if (paramInt >= -16) {
            break label223;
          }
          if (i < 2) {
            return unsafeIncompleteStateFor(paramArrayOfByte, paramInt, l1, i);
          }
          i -= 2;
          l2 = l1 + 1L;
          j = UnsafeUtil.getByte(paramArrayOfByte, l1);
          if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96))) {
            break label221;
          }
          paramLong = 1L + l2;
          paramInt = i;
        } while (UnsafeUtil.getByte(paramArrayOfByte, l2) <= -65);
        return -1;
        if (i < 3) {
          return unsafeIncompleteStateFor(paramArrayOfByte, paramInt, l1, i);
        }
        i -= 3;
        paramLong = l1 + 1L;
        j = UnsafeUtil.getByte(paramArrayOfByte, l1);
        if ((j > -65) || ((paramInt << 28) + (j + 112) >> 30 != 0)) {
          break label315;
        }
        l1 = paramLong + 1L;
        if (UnsafeUtil.getByte(paramArrayOfByte, paramLong) > -65) {
          break label315;
        }
        paramLong = 1L + l1;
        paramInt = i;
      } while (UnsafeUtil.getByte(paramArrayOfByte, l1) <= -65);
      label315:
      return -1;
    }
    
    private static int unsafeEstimateConsecutiveAscii(long paramLong, int paramInt)
    {
      if (paramInt < 16) {
        return 0;
      }
      int j = (int)paramLong & 0x7;
      int i = j;
      while (i > 0)
      {
        if (UnsafeUtil.getByte(paramLong) < 0) {
          return j - i;
        }
        i -= 1;
        paramLong = 1L + paramLong;
      }
      i = paramInt - j;
      while ((i >= 8) && ((UnsafeUtil.getLong(paramLong) & 0x80808080) == 0L))
      {
        paramLong += 8L;
        i -= 8;
      }
      return paramInt - i;
    }
    
    private static int unsafeEstimateConsecutiveAscii(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      if (paramInt < 16) {
        return 0;
      }
      int j = (int)paramLong & 0x7;
      int i = j;
      while (i > 0)
      {
        if (UnsafeUtil.getByte(paramArrayOfByte, paramLong) < 0) {
          return j - i;
        }
        i -= 1;
        paramLong = 1L + paramLong;
      }
      i = paramInt - j;
      while ((i >= 8) && ((UnsafeUtil.getLong(paramArrayOfByte, paramLong) & 0x80808080) == 0L))
      {
        paramLong += 8L;
        i -= 8;
      }
      return paramInt - i;
    }
    
    private static int unsafeIncompleteStateFor(long paramLong, int paramInt1, int paramInt2)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2) {
            return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramLong), UnsafeUtil.getByte(paramLong + 1L));
          }
          throw new AssertionError();
        }
        return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramLong));
      }
      return Utf8.incompleteStateFor(paramInt1);
    }
    
    private static int unsafeIncompleteStateFor(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2) {
            return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramArrayOfByte, paramLong), UnsafeUtil.getByte(paramArrayOfByte, paramLong + 1L));
          }
          throw new AssertionError();
        }
        return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramArrayOfByte, paramLong));
      }
      return Utf8.incompleteStateFor(paramInt1);
    }
    
    int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      long l2 = UnsafeUtil.getArrayBaseOffset() + paramInt1;
      long l4 = paramInt2 + l2;
      int k = paramCharSequence.length();
      if ((k <= paramInt2) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
      {
        paramInt2 = 0;
        int j;
        long l1;
        for (;;)
        {
          j = 128;
          l1 = 1L;
          if (paramInt2 >= k) {
            break;
          }
          paramInt1 = paramCharSequence.charAt(paramInt2);
          if (paramInt1 >= 128) {
            break;
          }
          UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)paramInt1);
          paramInt2 += 1;
          l2 = 1L + l2;
        }
        paramInt1 = paramInt2;
        long l3 = l2;
        if (paramInt2 == k) {
          return (int)(l2 - UnsafeUtil.getArrayBaseOffset());
        }
        int i;
        for (;;)
        {
          l2 = l3;
          if (paramInt1 >= k) {
            break;
          }
          i = paramCharSequence.charAt(paramInt1);
          if ((i < j) && (l3 < l4))
          {
            UnsafeUtil.putByte(paramArrayOfByte, l3, (byte)i);
            l2 = l1;
            l3 += l1;
            paramInt2 = paramInt1;
            l1 = l2;
            paramInt1 = j;
            l2 = l3;
          }
          else if ((i < 2048) && (l3 <= l4 - 2L))
          {
            l2 = l3 + l1;
            UnsafeUtil.putByte(paramArrayOfByte, l3, (byte)(i >>> 6 | 0x3C0));
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
            j = 128;
            l2 += l1;
            paramInt2 = paramInt1;
            paramInt1 = j;
          }
          else if (((i < 55296) || (57343 < i)) && (l3 <= l4 - 3L))
          {
            l2 = l3 + l1;
            UnsafeUtil.putByte(paramArrayOfByte, l3, (byte)(i >>> 12 | 0x1E0));
            l1 = l2 + l1;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(i >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
            l2 = l1 + 1L;
            l1 = 1L;
            j = 128;
            paramInt2 = paramInt1;
            paramInt1 = j;
          }
          else
          {
            if (l3 > l4 - 4L) {
              break label573;
            }
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == k) {
              break label560;
            }
            char c = paramCharSequence.charAt(paramInt2);
            if (!Character.isSurrogatePair(i, c)) {
              break label557;
            }
            j = Character.toCodePoint(i, c);
            l1 = l3 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l3, (byte)(j >>> 18 | 0xF0));
            l2 = l1 + 1L;
            paramInt1 = 128;
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(j >>> 12 & 0x3F | 0x80));
            l3 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(j >>> 6 & 0x3F | 0x80));
            l1 = 1L;
            l2 = l3 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l3, (byte)(j & 0x3F | 0x80));
          }
          paramInt2 += 1;
          j = paramInt1;
          paramInt1 = paramInt2;
          l3 = l2;
        }
        label557:
        paramInt1 = paramInt2;
        label560:
        throw new Utf8.UnpairedSurrogateException(paramInt1 - 1, k);
        label573:
        if ((55296 <= i) && (i <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == k) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
            throw new Utf8.UnpairedSurrogateException(paramInt1, k);
          }
        }
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l3);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Failed writing ");
      paramArrayOfByte.append(paramCharSequence.charAt(k - 1));
      paramArrayOfByte.append(" at index ");
      paramArrayOfByte.append(paramInt1 + paramInt2);
      throw new ArrayIndexOutOfBoundsException(paramArrayOfByte.toString());
    }
    
    void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      long l5 = UnsafeUtil.addressOffset(paramByteBuffer);
      long l1 = paramByteBuffer.position() + l5;
      long l3 = paramByteBuffer.limit() + l5;
      int n = paramCharSequence.length();
      if (n <= l3 - l1)
      {
        int k = 0;
        int m;
        for (;;)
        {
          m = 128;
          if (k >= n) {
            break;
          }
          j = paramCharSequence.charAt(k);
          if (j >= 128) {
            break;
          }
          UnsafeUtil.putByte(l1, (byte)j);
          k += 1;
          l1 += 1L;
        }
        long l2 = l5;
        long l4 = l1;
        int j = k;
        if (k == n) {}
        for (j = (int)(l1 - l5);; j = (int)(l4 - l2))
        {
          paramByteBuffer.position(j);
          return;
          while (j < n)
          {
            int i = paramCharSequence.charAt(j);
            if ((i < m) && (l4 < l3))
            {
              UnsafeUtil.putByte(l4, (byte)i);
              l1 = l4 + 1L;
              k = j;
              j = m;
            }
            else
            {
              if ((i < 2048) && (l4 <= l3 - 2L))
              {
                l1 = l4 + 1L;
                UnsafeUtil.putByte(l4, (byte)(i >>> 6 | 0x3C0));
                UnsafeUtil.putByte(l1, (byte)(i & 0x3F | 0x80));
              }
              for (l1 += 1L;; l1 = l4 + 1L)
              {
                m = 128;
                k = j;
                j = m;
                break label503;
                if (((i >= 55296) && (57343 >= i)) || (l4 > l3 - 3L)) {
                  break;
                }
                l1 = l4 + 1L;
                UnsafeUtil.putByte(l4, (byte)(i >>> 12 | 0x1E0));
                l4 = l1 + 1L;
                UnsafeUtil.putByte(l1, (byte)(i >>> 6 & 0x3F | 0x80));
                UnsafeUtil.putByte(l4, (byte)(i & 0x3F | 0x80));
              }
              if (l4 > l3 - 4L) {
                break label538;
              }
              k = j + 1;
              if (k == n) {
                break label524;
              }
              char c = paramCharSequence.charAt(k);
              if (!Character.isSurrogatePair(i, c)) {
                break label520;
              }
              m = Character.toCodePoint(i, c);
              l1 = l4 + 1L;
              UnsafeUtil.putByte(l4, (byte)(m >>> 18 | 0xF0));
              l4 = l1 + 1L;
              j = 128;
              UnsafeUtil.putByte(l1, (byte)(m >>> 12 & 0x3F | 0x80));
              l1 = l4 + 1L;
              UnsafeUtil.putByte(l4, (byte)(m >>> 6 & 0x3F | 0x80));
              UnsafeUtil.putByte(l1, (byte)(m & 0x3F | 0x80));
              l1 += 1L;
            }
            label503:
            m = j;
            j = k + 1;
            l4 = l1;
            continue;
            label520:
            j = k;
            label524:
            throw new Utf8.UnpairedSurrogateException(j - 1, n);
            label538:
            if ((55296 <= i) && (i <= 57343))
            {
              k = j + 1;
              if ((k == n) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(k)))) {
                throw new Utf8.UnpairedSurrogateException(j, n);
              }
            }
            paramCharSequence = new StringBuilder();
            paramCharSequence.append("Failed writing ");
            paramCharSequence.append(i);
            paramCharSequence.append(" at index ");
            paramCharSequence.append(l4);
            throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
          }
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed writing ");
      localStringBuilder.append(paramCharSequence.charAt(n - 1));
      localStringBuilder.append(" at index ");
      localStringBuilder.append(paramByteBuffer.limit());
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      if ((paramInt2 | paramInt3 | j - paramInt3) >= 0)
      {
        long l1 = UnsafeUtil.getArrayBaseOffset() + paramInt2;
        long l3 = UnsafeUtil.getArrayBaseOffset() + paramInt3;
        long l2 = l1;
        if (paramInt1 != 0)
        {
          if (l1 >= l3) {
            return paramInt1;
          }
          j = (byte)paramInt1;
          if (j < -32)
          {
            if (j >= -62)
            {
              if (UnsafeUtil.getByte(paramArrayOfByte, l1) > -65) {
                return -1;
              }
              l2 = 1L + l1;
            }
            else
            {
              return -1;
            }
          }
          else
          {
            if (j < -16)
            {
              paramInt2 = (byte)(paramInt1 >> 8);
              l2 = l1;
              paramInt1 = paramInt2;
              if (paramInt2 == 0)
              {
                l2 = l1 + 1L;
                paramInt1 = UnsafeUtil.getByte(paramArrayOfByte, l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt1);
                }
              }
              if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
              {
                l1 = l2 + 1L;
                if (UnsafeUtil.getByte(paramArrayOfByte, l2) > -65) {
                  return -1;
                }
              }
            }
            do
            {
              l2 = l1;
              break label352;
              return -1;
              paramInt2 = (byte)(paramInt1 >> 8);
              if (paramInt2 == 0)
              {
                l2 = l1 + 1L;
                paramInt2 = UnsafeUtil.getByte(paramArrayOfByte, l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt2);
                }
                l1 = l2;
                paramInt1 = i;
              }
              else
              {
                paramInt1 = (byte)(paramInt1 >> 16);
              }
              paramInt3 = paramInt1;
              l2 = l1;
              if (paramInt1 == 0)
              {
                l2 = l1 + 1L;
                paramInt3 = UnsafeUtil.getByte(paramArrayOfByte, l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt2, paramInt3);
                }
              }
              if ((paramInt2 > -65) || ((j << 28) + (paramInt2 + 112) >> 30 != 0) || (paramInt3 > -65)) {
                break;
              }
              l1 = l2 + 1L;
            } while (UnsafeUtil.getByte(paramArrayOfByte, l2) <= -65);
            return -1;
          }
        }
        label352:
        return partialIsValidUtf8(paramArrayOfByte, l2, (int)(l3 - l2));
      }
      throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    
    int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      int j = paramByteBuffer.limit();
      int i = 0;
      if ((paramInt2 | paramInt3 | j - paramInt3) >= 0)
      {
        long l1 = UnsafeUtil.addressOffset(paramByteBuffer) + paramInt2;
        long l3 = paramInt3 - paramInt2 + l1;
        long l2 = l1;
        if (paramInt1 != 0)
        {
          if (l1 >= l3) {
            return paramInt1;
          }
          j = (byte)paramInt1;
          if (j < -32)
          {
            if (j >= -62)
            {
              if (UnsafeUtil.getByte(l1) > -65) {
                return -1;
              }
              l2 = 1L + l1;
            }
            else
            {
              return -1;
            }
          }
          else
          {
            if (j < -16)
            {
              paramInt2 = (byte)(paramInt1 >> 8);
              l2 = l1;
              paramInt1 = paramInt2;
              if (paramInt2 == 0)
              {
                l2 = l1 + 1L;
                paramInt1 = UnsafeUtil.getByte(l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt1);
                }
              }
              if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
              {
                l1 = l2 + 1L;
                if (UnsafeUtil.getByte(l2) > -65) {
                  return -1;
                }
              }
            }
            do
            {
              l2 = l1;
              break label350;
              return -1;
              paramInt2 = (byte)(paramInt1 >> 8);
              if (paramInt2 == 0)
              {
                l2 = l1 + 1L;
                paramInt2 = UnsafeUtil.getByte(l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt2);
                }
                l1 = l2;
                paramInt1 = i;
              }
              else
              {
                paramInt1 = (byte)(paramInt1 >> 16);
              }
              paramInt3 = paramInt1;
              l2 = l1;
              if (paramInt1 == 0)
              {
                l2 = l1 + 1L;
                paramInt3 = UnsafeUtil.getByte(l1);
                if (l2 >= l3) {
                  return Utf8.incompleteStateFor(j, paramInt2, paramInt3);
                }
              }
              if ((paramInt2 > -65) || ((j << 28) + (paramInt2 + 112) >> 30 != 0) || (paramInt3 > -65)) {
                break;
              }
              l1 = l2 + 1L;
            } while (UnsafeUtil.getByte(l2) <= -65);
            return -1;
          }
        }
        label350:
        return partialIsValidUtf8(l2, (int)(l3 - l2));
      }
      throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.Utf8
 * JD-Core Version:    0.7.0.1
 */