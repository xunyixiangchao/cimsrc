package com.baidu.b.c.c;

import java.math.BigInteger;

public class b
{
  private static byte[] a;
  private static byte[] b;
  
  public static byte[] a()
  {
    byte[] arrayOfByte = a;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = new BigInteger(a.a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
    a = arrayOfByte;
    return arrayOfByte;
  }
  
  public static byte[] b()
  {
    byte[] arrayOfByte = b;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
    b = arrayOfByte;
    return arrayOfByte;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.c.b
 * JD-Core Version:    0.7.0.1
 */