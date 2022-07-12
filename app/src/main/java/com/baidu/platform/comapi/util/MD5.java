package com.baidu.platform.comapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  protected static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char[] arrayOfChar = a;
    char c1 = arrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = arrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static boolean checkPassword(String paramString1, String paramString2)
  {
    return getMD5String(paramString1).equals(paramString2);
  }
  
  public static String getFileMD5String(File paramFile)
  {
    return getFileMD5String(paramFile, 131072);
  }
  
  public static String getFileMD5String(File paramFile, int paramInt)
  {
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      MessageDigest localMessageDigest;
      label9:
      byte[] arrayOfByte;
      break label9;
    }
    localMessageDigest = null;
    if (localMessageDigest == null) {
      return "";
    }
    paramFile = new FileInputStream(paramFile);
    arrayOfByte = new byte[paramInt];
    for (;;)
    {
      paramInt = paramFile.read(arrayOfByte);
      if (paramInt <= 0) {
        break;
      }
      localMessageDigest.update(arrayOfByte, 0, paramInt);
    }
    paramFile.close();
    try
    {
      paramFile = a(localMessageDigest.digest());
      return paramFile;
    }
    catch (Exception paramFile)
    {
      throw new IOException(paramFile.toString());
    }
  }
  
  public static String getFileMD5StringNIO(File paramFile)
  {
    return getFileMD5StringNIO(paramFile, 131072);
  }
  
  public static String getFileMD5StringNIO(File paramFile, int paramInt)
  {
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      MessageDigest localMessageDigest;
      label9:
      FileChannel localFileChannel;
      ByteBuffer localByteBuffer;
      break label9;
    }
    localMessageDigest = null;
    if (localMessageDigest == null) {
      return "";
    }
    paramFile = new FileInputStream(paramFile);
    localFileChannel = paramFile.getChannel();
    localByteBuffer = ByteBuffer.allocate(paramInt);
    while (localFileChannel.read(localByteBuffer) != -1)
    {
      localByteBuffer.flip();
      localMessageDigest.update(localByteBuffer);
      if (!localByteBuffer.hasRemaining()) {
        localByteBuffer.clear();
      }
    }
    paramFile.close();
    try
    {
      paramFile = a(localMessageDigest.digest());
      return paramFile;
    }
    catch (Exception paramFile)
    {
      throw new IOException(paramFile.toString());
    }
  }
  
  public static String getMD5String(String paramString)
  {
    return getMD5String(paramString.getBytes());
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        try
        {
          MessageDigest localMessageDigest;
          paramArrayOfByte = a(localMessageDigest.digest());
          return paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
      }
    }
    localMessageDigest = null;
    if (localMessageDigest == null) {
      return "";
    }
    localMessageDigest.update(paramArrayOfByte);
    return "";
  }
  
  public static String getMD5String16(String paramString)
  {
    paramString = getMD5String(paramString.getBytes());
    if (paramString.length() == 32) {
      return paramString.substring(8, 24);
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.MD5
 * JD-Core Version:    0.7.0.1
 */