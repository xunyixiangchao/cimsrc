package com.baidu.b.c.d;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;

public final class b
{
  public static final SecureRandom a = new SecureRandom();
  
  public static int a(BigInteger paramBigInteger)
  {
    return paramBigInteger.bitLength() + 7 >> 3;
  }
  
  private static BigInteger a(byte[] paramArrayOfByte, BigInteger paramBigInteger)
  {
    paramArrayOfByte = new BigInteger(1, paramArrayOfByte);
    if (paramArrayOfByte.compareTo(paramBigInteger) < 0) {
      return paramArrayOfByte;
    }
    throw new BadPaddingException("Message is larger than modulus");
  }
  
  private static byte[] a(BigInteger paramBigInteger, int paramInt)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    int i = paramBigInteger.length;
    if (i == paramInt) {
      return paramBigInteger;
    }
    if ((i == paramInt + 1) && (paramBigInteger[0] == 0))
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, paramInt);
      return arrayOfByte;
    }
    if (i >= paramInt) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramBigInteger, 0, arrayOfByte, paramInt - i, i);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length)) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, d paramd)
  {
    return a(paramArrayOfByte, paramd.a(), paramd.b());
  }
  
  private static byte[] a(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return a(a(paramArrayOfByte, paramBigInteger1).modPow(paramBigInteger2, paramBigInteger1), a(paramBigInteger1));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.d.b
 * JD-Core Version:    0.7.0.1
 */