package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsafeUtil
{
  private static final long ARRAY_BASE_OFFSET = byteArrayBaseOffset();
  private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  private static final Unsafe UNSAFE = ;
  
  static
  {
    HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
  }
  
  static long addressOffset(ByteBuffer paramByteBuffer)
  {
    return UNSAFE.getLong(paramByteBuffer, BUFFER_ADDRESS_OFFSET);
  }
  
  private static int byteArrayBaseOffset()
  {
    if (HAS_UNSAFE_ARRAY_OPERATIONS) {
      return UNSAFE.arrayBaseOffset([B.class);
    }
    return -1;
  }
  
  static void copyMemory(long paramLong1, long paramLong2, long paramLong3)
  {
    UNSAFE.copyMemory(paramLong1, paramLong2, paramLong3);
  }
  
  static void copyMemory(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3)
  {
    UNSAFE.copyMemory(paramArrayOfByte1, paramLong1, paramArrayOfByte2, paramLong2, paramLong3);
  }
  
  private static Field field(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally
    {
      label13:
      break label13;
    }
    return null;
  }
  
  private static long fieldOffset(Field paramField)
  {
    if (paramField != null)
    {
      Unsafe localUnsafe = UNSAFE;
      if (localUnsafe != null) {
        return localUnsafe.objectFieldOffset(paramField);
      }
    }
    return -1L;
  }
  
  static long getArrayBaseOffset()
  {
    return ARRAY_BASE_OFFSET;
  }
  
  static byte getByte(long paramLong)
  {
    return UNSAFE.getByte(paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfByte, long paramLong)
  {
    return UNSAFE.getByte(paramArrayOfByte, paramLong);
  }
  
  static long getLong(long paramLong)
  {
    return UNSAFE.getLong(paramLong);
  }
  
  static long getLong(byte[] paramArrayOfByte, long paramLong)
  {
    return UNSAFE.getLong(paramArrayOfByte, paramLong);
  }
  
  private static Unsafe getUnsafe()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction()
      {
        public Unsafe run()
        {
          Field[] arrayOfField = Unsafe.class.getDeclaredFields();
          int j = arrayOfField.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = arrayOfField[i];
            ((Field)localObject).setAccessible(true);
            localObject = ((Field)localObject).get(null);
            if (Unsafe.class.isInstance(localObject)) {
              return (Unsafe)Unsafe.class.cast(localObject);
            }
            i += 1;
          }
          return null;
        }
      });
      return localUnsafe;
    }
    finally
    {
      label16:
      break label16;
    }
    return null;
  }
  
  static boolean hasUnsafeArrayOperations()
  {
    return HAS_UNSAFE_ARRAY_OPERATIONS;
  }
  
  static boolean hasUnsafeByteBufferOperations()
  {
    return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  }
  
  static void putByte(long paramLong, byte paramByte)
  {
    UNSAFE.putByte(paramLong, paramByte);
  }
  
  static void putByte(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    UNSAFE.putByte(paramArrayOfByte, paramLong, paramByte);
  }
  
  private static boolean supportsUnsafeArrayOperations()
  {
    Object localObject1 = UNSAFE;
    if (localObject1 != null) {}
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("arrayBaseOffset", new Class[] { Class.class });
      Class localClass = Long.TYPE;
      ((Class)localObject1).getMethod("getByte", new Class[] { Object.class, localClass });
      ((Class)localObject1).getMethod("putByte", new Class[] { Object.class, localClass, Byte.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localClass });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Object.class, localClass, Object.class, localClass, localClass });
      return true;
    }
    finally
    {
      label134:
      break label134;
    }
    return false;
  }
  
  private static boolean supportsUnsafeByteBufferOperations()
  {
    Object localObject1 = UNSAFE;
    if (localObject1 != null) {}
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      Class localClass = Long.TYPE;
      ((Class)localObject1).getMethod("getByte", new Class[] { localClass });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localClass });
      ((Class)localObject1).getMethod("putByte", new Class[] { localClass, Byte.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { localClass });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { localClass, localClass, localClass });
      return true;
    }
    finally
    {
      label129:
      break label129;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.UnsafeUtil
 * JD-Core Version:    0.7.0.1
 */