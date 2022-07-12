package com.baidu.b.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA-1").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.d.c
 * JD-Core Version:    0.7.0.1
 */