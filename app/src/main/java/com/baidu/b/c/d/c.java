package com.baidu.b.c.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;

public final class c
{
  private static final byte[] a = new byte[0];
  private int b;
  private String c = "PKCS1Padding";
  private f d;
  private OAEPParameterSpec e = null;
  private byte[] f;
  private int g;
  private int h;
  private d i;
  private String j = "SHA-1";
  
  private void a(int paramInt, d paramd, SecureRandom paramSecureRandom, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    int m = 2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label64;
        }
        if (paramInt != 4)
        {
          paramd = new StringBuilder();
          paramd.append("Unknown mode: ");
          paramd.append(paramInt);
          throw new InvalidKeyException(paramd.toString());
        }
      }
      paramInt = 0;
      break label66;
    }
    label64:
    paramInt = 1;
    label66:
    if ((paramd instanceof d))
    {
      if (paramInt != 0) {
        k = 1;
      } else {
        k = 4;
      }
      this.b = k;
      this.i = paramd;
      int n = b.a(paramd.a());
      this.h = n;
      this.g = 0;
      paramd = this.c;
      if (paramd == "NoPadding")
      {
        if (paramAlgorithmParameterSpec == null)
        {
          this.d = f.a(3, n, paramSecureRandom);
          this.f = new byte[n];
          return;
        }
        throw new InvalidAlgorithmParameterException("Parameters not supported");
      }
      if (paramd == "PKCS1Padding")
      {
        if (paramAlgorithmParameterSpec == null)
        {
          if (this.b <= 2) {
            k = m;
          } else {
            k = 1;
          }
          paramd = f.a(k, n, paramSecureRandom);
          this.d = paramd;
          if (paramInt != 0)
          {
            this.f = new byte[paramd.a()];
            return;
          }
          this.f = new byte[n];
          return;
        }
        throw new InvalidAlgorithmParameterException("Parameters not supported");
      }
      int k = this.b;
      if ((k != 3) && (k != 4))
      {
        if (paramAlgorithmParameterSpec != null)
        {
          if ((paramAlgorithmParameterSpec instanceof OAEPParameterSpec)) {
            paramd = (OAEPParameterSpec)paramAlgorithmParameterSpec;
          } else {
            throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
          }
        }
        else {
          paramd = new OAEPParameterSpec(this.j, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        }
        paramd = f.a(4, n, paramSecureRandom, paramd);
        this.d = paramd;
        if (paramInt != 0)
        {
          this.f = new byte[paramd.a()];
          return;
        }
        this.f = new byte[n];
        return;
      }
      throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
    }
    throw new InvalidKeyException("only support helios key");
  }
  
  private byte[] a()
  {
    int k = this.g;
    byte[] arrayOfByte = this.f;
    if (k <= arrayOfByte.length) {
      try
      {
        int m = this.b;
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 4)
              {
                arrayOfByte = b.a(b.a(arrayOfByte, 0, k), this.i);
                arrayOfByte = this.d.b(arrayOfByte);
                return arrayOfByte;
              }
              throw new AssertionError("Internal error");
            }
            throw new UnsupportedOperationException("only verify supported");
          }
          throw new UnsupportedOperationException("only verify supported");
        }
        arrayOfByte = b.a(this.d.a(arrayOfByte, 0, k), this.i);
        return arrayOfByte;
      }
      finally
      {
        this.g = 0;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Data must not be longer than ");
    localStringBuilder.append(this.f.length);
    localStringBuilder.append(" bytes");
    throw new IllegalBlockSizeException(localStringBuilder.toString());
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      int k = this.g;
      byte[] arrayOfByte = this.f;
      if (k + paramInt2 > arrayOfByte.length) {}
      for (paramInt1 = arrayOfByte.length + 1;; paramInt1 = this.g + paramInt2)
      {
        this.g = paramInt1;
        return;
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, k, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, d paramd, SecureRandom paramSecureRandom)
  {
    try
    {
      a(paramInt, paramd, paramSecureRandom, null);
      return;
    }
    catch (InvalidAlgorithmParameterException paramd)
    {
      paramSecureRandom = new InvalidKeyException("Wrong parameters");
      paramSecureRandom.initCause(paramd);
      throw paramSecureRandom;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = "NoPadding";
    if (paramString.equalsIgnoreCase("NoPadding")) {}
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      this.c = paramString;
      return;
      localObject = "PKCS1Padding";
      if (!paramString.equalsIgnoreCase("PKCS1Padding")) {
        break;
      }
    }
    localObject = paramString.toLowerCase(Locale.ENGLISH);
    if (((String)localObject).equals("oaeppadding"))
    {
      this.c = "OAEP";
      return;
    }
    if ((((String)localObject).startsWith("oaepwith")) && (((String)localObject).endsWith("andmgf1padding")))
    {
      this.c = "OAEP";
      this.j = paramString.substring(8, paramString.length() - 14);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MessageDigest not available for ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchPaddingException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Padding ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not supported");
    throw new NoSuchPaddingException(((StringBuilder)localObject).toString());
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte, paramInt1, paramInt2);
    return a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.d.c
 * JD-Core Version:    0.7.0.1
 */