package com.baidu.b.c.a;

import java.security.SecureRandom;

public class c
{
  public static final SecureRandom a = new SecureRandom();
  private e b = null;
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    c localc = new c();
    localc.a(2, paramArrayOfByte1, paramArrayOfByte2);
    return localc.a(paramArrayOfByte3);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.b.a(paramInt, paramArrayOfByte1, paramArrayOfByte2, a);
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return this.b.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("Null input buffer");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.c
 * JD-Core Version:    0.7.0.1
 */