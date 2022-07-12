package com.baidu.mapsdkplatform.comapi.util;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AlgorithmUtil
{
  private static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes("ASCII"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
      localCipher.init(2, paramString2, new IvParameterSpec(paramString1.getBytes()));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CTR/NoPadding");
      localCipher.init(2, paramString2, new IvParameterSpec(paramString1.getBytes()));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (paramString2 == null) {
      return null;
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
    paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
    paramString2.init(1, localSecretKeySpec, new IvParameterSpec(paramString1.getBytes()));
    int i = paramArrayOfByte.length;
    while (i % 16 != 0) {
      i += 1;
    }
    paramString1 = new byte[i];
    int j = 0;
    while (j < i)
    {
      if (j < paramArrayOfByte.length) {
        paramString1[j] = paramArrayOfByte[j];
      } else {
        paramString1[j] = 0;
      }
      j += 1;
    }
    return paramString2.doFinal(paramString1);
  }
  
  public static byte[] getDecryptInfo(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return b(paramString1, paramString2, paramArrayOfByte);
  }
  
  public static byte[] getUrlNeedInfo(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramArrayOfByte);
  }
  
  public static byte[] setUrlNeedInfo(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return c(paramString1, paramString2, paramArrayOfByte);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil
 * JD-Core Version:    0.7.0.1
 */