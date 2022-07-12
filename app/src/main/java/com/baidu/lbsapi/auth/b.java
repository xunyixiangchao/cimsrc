package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

class b
{
  static String a()
  {
    return Locale.getDefault().getLanguage();
  }
  
  protected static String a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = a(paramContext, str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(";");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private static String a(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      SigningInfo localSigningInfo;
      if (Build.VERSION.SDK_INT >= 28)
      {
        localSigningInfo = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo;
        if (localSigningInfo != null) {}
      }
      for (paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);; paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64))
      {
        paramContext = paramContext.signatures;
        break;
        if (localSigningInfo.hasMultipleSigners())
        {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo.getApkContentsSigners();
          break;
        }
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo.getSigningCertificateHistory();
        break;
      }
      paramContext = a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramContext[0].toByteArray())));
    }
    catch (CertificateException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getFingerPrint：");
      paramContext = paramContext.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getFingerPrint：");
      paramContext = paramContext.toString();
    }
    paramString.append(paramContext);
    a.a(paramString.toString());
    paramContext = "";
    paramString = new StringBuffer();
    if (paramContext != null) {
      while (i < paramContext.length())
      {
        paramString.append(paramContext.charAt(i));
        if ((i > 0) && (i % 2 == 1) && (i < paramContext.length() - 1)) {
          paramString.append(":");
        }
        i += 1;
      }
    }
    return paramString.toString();
  }
  
  static String a(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = a.a(a(paramX509Certificate.getEncoded()));
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFingerprintAs：");
      localStringBuilder.append(paramX509Certificate.toString());
      a.a(localStringBuilder.toString());
    }
    return null;
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA1").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateSHA1：");
      localStringBuilder.append(paramArrayOfByte.toString());
      a.a(localStringBuilder.toString());
    }
    return null;
  }
  
  protected static String[] b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    String[] arrayOfString2 = b(paramContext, str);
    if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
    {
      int j = arrayOfString2.length;
      String[] arrayOfString1 = new String[j];
      int i = 0;
      for (;;)
      {
        paramContext = arrayOfString1;
        if (i >= j) {
          break;
        }
        paramContext = new StringBuilder();
        paramContext.append(arrayOfString2[i]);
        paramContext.append(";");
        paramContext.append(str);
        arrayOfString1[i] = paramContext.toString();
        if (a.a)
        {
          paramContext = new StringBuilder();
          paramContext.append("mcode");
          paramContext.append(arrayOfString1[i]);
          a.a(paramContext.toString());
        }
        i += 1;
      }
    }
    paramContext = null;
    return paramContext;
  }
  
  private static String[] b(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    int i;
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        localObject1 = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo;
        if (localObject1 != null) {}
      }
      for (paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);; paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64))
      {
        localObject1 = paramContext.signatures;
        break;
        if (((SigningInfo)localObject1).hasMultipleSigners())
        {
          localObject1 = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo.getApkContentsSigners();
          break;
        }
        localObject1 = paramContext.getPackageManager().getPackageInfo(paramString, 134217728).signingInfo.getSigningCertificateHistory();
        break;
      }
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        paramContext = new String[localObject1.length];
        i = 0;
        for (;;)
        {
          paramString = paramContext;
          try
          {
            if (i >= localObject1.length) {
              break label276;
            }
            paramContext[i] = a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(localObject1[i].toByteArray())));
            i += 1;
          }
          catch (CertificateException paramString)
          {
            break label198;
          }
          catch (PackageManager.NameNotFoundException paramString)
          {
            break label234;
          }
        }
      }
      paramString = null;
    }
    catch (CertificateException paramString)
    {
      paramContext = null;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFingerPrint：");
      localObject3 = paramString.toString();
      paramString = (String)localObject1;
      localObject1 = localObject3;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label198:
      paramContext = null;
      label234:
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getFingerPrint：");
      localObject1 = paramString.toString();
      paramString = (String)localObject3;
    }
    paramString.append((String)localObject1);
    a.a(paramString.toString());
    paramString = paramContext;
    label276:
    paramContext = localObject2;
    if (paramString != null)
    {
      paramContext = localObject2;
      if (paramString.length > 0)
      {
        localObject1 = new String[paramString.length];
        i = 0;
        for (;;)
        {
          paramContext = (Context)localObject1;
          if (i >= paramString.length) {
            break;
          }
          paramContext = new StringBuffer();
          int j = 0;
          while (j < paramString[i].length())
          {
            paramContext.append(paramString[i].charAt(j));
            if ((j > 0) && (j % 2 == 1) && (j < paramString[i].length() - 1)) {
              paramContext.append(":");
            }
            j += 1;
          }
          localObject1[i] = paramContext.toString();
          i += 1;
        }
      }
    }
    return paramContext;
  }
  
  static class a
  {
    public static String a(byte[] paramArrayOfByte)
    {
      char[] arrayOfChar = new char[16];
      char[] tmp6_5 = arrayOfChar;
      tmp6_5[0] = 48;
      char[] tmp11_6 = tmp6_5;
      tmp11_6[1] = 49;
      char[] tmp16_11 = tmp11_6;
      tmp16_11[2] = 50;
      char[] tmp21_16 = tmp16_11;
      tmp21_16[3] = 51;
      char[] tmp26_21 = tmp21_16;
      tmp26_21[4] = 52;
      char[] tmp31_26 = tmp26_21;
      tmp31_26[5] = 53;
      char[] tmp36_31 = tmp31_26;
      tmp36_31[6] = 54;
      char[] tmp42_36 = tmp36_31;
      tmp42_36[7] = 55;
      char[] tmp48_42 = tmp42_36;
      tmp48_42[8] = 56;
      char[] tmp54_48 = tmp48_42;
      tmp54_48[9] = 57;
      char[] tmp60_54 = tmp54_48;
      tmp60_54[10] = 65;
      char[] tmp66_60 = tmp60_54;
      tmp66_60[11] = 66;
      char[] tmp72_66 = tmp66_60;
      tmp72_66[12] = 67;
      char[] tmp78_72 = tmp72_66;
      tmp78_72[13] = 68;
      char[] tmp84_78 = tmp78_72;
      tmp84_78[14] = 69;
      char[] tmp90_84 = tmp84_78;
      tmp90_84[15] = 70;
      tmp90_84;
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(arrayOfChar[((paramArrayOfByte[i] & 0xF0) >> 4)]);
        localStringBuilder.append(arrayOfChar[(paramArrayOfByte[i] & 0xF)]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */