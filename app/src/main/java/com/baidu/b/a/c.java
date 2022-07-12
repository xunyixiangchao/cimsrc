package com.baidu.b.a;

import java.util.Arrays;

class c
{
  public static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramInt >= 0)
    {
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
      {
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
        {
          if (paramArrayOfByte1.length >= paramArrayOfByte2.length)
          {
            int i = paramArrayOfByte2.length;
            if (paramArrayOfByte1.length >= i + paramInt)
            {
              System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
              return;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("start should be less than:");
            localStringBuilder.append(paramArrayOfByte1.length - paramArrayOfByte2.length);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("dst array length should be longer than:");
          paramArrayOfByte1.append(paramArrayOfByte2.length);
          throw new IllegalArgumentException(paramArrayOfByte1.toString());
        }
        throw new IllegalArgumentException("src array should not be null or empty");
      }
      throw new IllegalArgumentException("dst array should not be null or empty");
    }
    throw new IllegalArgumentException("start should be more than zero!");
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramInt >= 0) {
        return Arrays.copyOf(paramArrayOfByte, paramInt);
      }
      throw new IllegalArgumentException("length should be more than zero!");
    }
    throw new IllegalArgumentException("original array should not be null or empty");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.c
 * JD-Core Version:    0.7.0.1
 */