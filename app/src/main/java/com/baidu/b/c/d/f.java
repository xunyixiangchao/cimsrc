package com.baidu.b.c.d;

import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.PSource.PSpecified;

public final class f
{
  private static final Map h = Collections.synchronizedMap(new HashMap());
  private final int a;
  private final int b;
  private SecureRandom c;
  private final int d;
  private MessageDigest e;
  private MessageDigest f;
  private byte[] g;
  
  private f(int paramInt1, int paramInt2, SecureRandom paramSecureRandom, OAEPParameterSpec paramOAEPParameterSpec)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramSecureRandom;
    int i;
    Object localObject1;
    if (paramInt2 >= 64) {
      if ((paramInt1 != 1) && (paramInt1 != 2))
      {
        i = paramInt2;
        if (paramInt1 == 3) {
          break label466;
        }
        if (paramInt1 == 4)
        {
          localObject1 = null;
          paramSecureRandom = "SHA-1";
          if (paramOAEPParameterSpec == null) {
            break label483;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramOAEPParameterSpec.getDigestAlgorithm();
        paramSecureRandom = (SecureRandom)localObject1;
        localObject2 = paramOAEPParameterSpec.getMGFAlgorithm();
        paramSecureRandom = (SecureRandom)localObject1;
        if (((String)localObject2).equalsIgnoreCase("MGF1"))
        {
          paramSecureRandom = (SecureRandom)localObject1;
          localObject2 = ((MGF1ParameterSpec)paramOAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
          paramSecureRandom = (SecureRandom)localObject1;
          PSource localPSource = paramOAEPParameterSpec.getPSource();
          paramSecureRandom = (SecureRandom)localObject1;
          paramOAEPParameterSpec = localPSource.getAlgorithm();
          paramSecureRandom = (SecureRandom)localObject1;
          if (paramOAEPParameterSpec.equalsIgnoreCase("PSpecified"))
          {
            paramSecureRandom = (SecureRandom)localObject1;
            paramOAEPParameterSpec = ((PSource.PSpecified)localPSource).getValue();
            paramSecureRandom = (SecureRandom)localObject2;
            localObject2 = paramOAEPParameterSpec;
            paramOAEPParameterSpec = (OAEPParameterSpec)localObject1;
            localObject1 = localObject2;
            localObject2 = paramSecureRandom;
          }
          else
          {
            paramSecureRandom = (SecureRandom)localObject1;
            localObject2 = new StringBuilder();
            paramSecureRandom = (SecureRandom)localObject1;
            ((StringBuilder)localObject2).append("Unsupported pSource algo: ");
            paramSecureRandom = (SecureRandom)localObject1;
            ((StringBuilder)localObject2).append(paramOAEPParameterSpec);
            paramSecureRandom = (SecureRandom)localObject1;
            throw new InvalidAlgorithmParameterException(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          paramSecureRandom = (SecureRandom)localObject1;
          paramOAEPParameterSpec = new StringBuilder();
          paramSecureRandom = (SecureRandom)localObject1;
          paramOAEPParameterSpec.append("Unsupported MGF algo: ");
          paramSecureRandom = (SecureRandom)localObject1;
          paramOAEPParameterSpec.append((String)localObject2);
          paramSecureRandom = (SecureRandom)localObject1;
          throw new InvalidAlgorithmParameterException(paramOAEPParameterSpec.toString());
        }
        paramSecureRandom = paramOAEPParameterSpec;
        this.e = MessageDigest.getInstance(paramOAEPParameterSpec);
        paramSecureRandom = paramOAEPParameterSpec;
        this.f = MessageDigest.getInstance((String)localObject2);
        paramSecureRandom = a(this.e, (byte[])localObject1);
        this.g = paramSecureRandom;
        paramInt1 = paramInt2 - 2 - paramSecureRandom.length * 2;
        this.d = paramInt1;
        if (paramInt1 > 0) {
          return;
        }
        paramSecureRandom = new StringBuilder();
        paramSecureRandom.append("Key is too short for encryption using OAEPPadding with ");
        paramSecureRandom.append(paramOAEPParameterSpec);
        paramSecureRandom.append(" and MGF1");
        paramSecureRandom.append((String)localObject2);
        throw new InvalidKeyException(paramSecureRandom.toString());
      }
      catch (NoSuchAlgorithmException paramOAEPParameterSpec)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Digest ");
        ((StringBuilder)localObject1).append(paramSecureRandom);
        ((StringBuilder)localObject1).append(" not available");
        throw new InvalidKeyException(((StringBuilder)localObject1).toString(), paramOAEPParameterSpec);
      }
      paramSecureRandom = new StringBuilder();
      paramSecureRandom.append("Invalid padding: ");
      paramSecureRandom.append(paramInt1);
      throw new InvalidKeyException(paramSecureRandom.toString());
      i = paramInt2 - 11;
      label466:
      this.d = i;
      return;
      throw new InvalidKeyException("Padded size must be at least 64");
      label483:
      Object localObject2 = "SHA-1";
      paramOAEPParameterSpec = paramSecureRandom;
    }
  }
  
  public static f a(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    return new f(paramInt1, paramInt2, paramSecureRandom, null);
  }
  
  public static f a(int paramInt1, int paramInt2, SecureRandom paramSecureRandom, OAEPParameterSpec paramOAEPParameterSpec)
  {
    return new f(paramInt1, paramInt2, paramSecureRandom, paramOAEPParameterSpec);
  }
  
  private void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[20];
    int j = paramInt4;
    int k = paramInt3;
    while (j > 0)
    {
      this.f.update(paramArrayOfByte1, paramInt1, paramInt2);
      this.f.update(arrayOfByte1);
      try
      {
        MessageDigest localMessageDigest = this.f;
        int m = 0;
        localMessageDigest.digest(arrayOfByte2, 0, 20);
        paramInt4 = j;
        paramInt3 = k;
        j = m;
        while ((j < 20) && (paramInt4 > 0))
        {
          k = paramArrayOfByte2[paramInt3];
          paramArrayOfByte2[paramInt3] = ((byte)(arrayOfByte2[j] ^ k));
          paramInt4 -= 1;
          paramInt3 += 1;
          j += 1;
        }
        k = paramInt3;
        j = paramInt4;
        if (paramInt4 <= 0) {
          continue;
        }
        m = 3;
        for (;;)
        {
          int i = (byte)(arrayOfByte1[m] + 1);
          arrayOfByte1[m] = i;
          k = paramInt3;
          j = paramInt4;
          if (i != 0) {
            break;
          }
          k = paramInt3;
          j = paramInt4;
          if (m <= 0) {
            break;
          }
          m -= 1;
        }
        return;
      }
      catch (DigestException paramArrayOfByte1)
      {
        throw new BadPaddingException(paramArrayOfByte1.toString());
      }
    }
  }
  
  private static byte[] a(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return paramMessageDigest.digest(paramArrayOfByte);
    }
    paramArrayOfByte = paramMessageDigest.getAlgorithm();
    Map localMap = h;
    byte[] arrayOfByte = (byte[])localMap.get(paramArrayOfByte);
    if (arrayOfByte == null)
    {
      paramMessageDigest = paramMessageDigest.digest();
      localMap.put(paramArrayOfByte, paramMessageDigest);
      return paramMessageDigest;
    }
    return arrayOfByte;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    int i = this.b;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, i - paramArrayOfByte.length, paramArrayOfByte.length);
    int k = this.b - 3 - paramArrayOfByte.length;
    arrayOfByte[0] = 0;
    int m = this.a;
    arrayOfByte[1] = ((byte)m);
    i = -1;
    int j = 2;
    if (m == 1) {
      while (k > 0)
      {
        arrayOfByte[j] = -1;
        j += 1;
        k -= 1;
      }
    }
    if (this.c == null) {
      this.c = b.a;
    }
    paramArrayOfByte = new byte[64];
    if (k > 0) {
      for (;;)
      {
        m = i;
        if (i < 0)
        {
          this.c.nextBytes(paramArrayOfByte);
          m = 63;
        }
        i = m - 1;
        m = paramArrayOfByte[m] & 0xFF;
        if (m != 0)
        {
          arrayOfByte[j] = ((byte)m);
          k -= 1;
          j += 1;
          break;
        }
      }
    }
    return arrayOfByte;
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] == 0)
    {
      int i = 2;
      if (paramArrayOfByte[1] == this.a)
      {
        for (;;)
        {
          int j = i + 1;
          i = paramArrayOfByte[i] & 0xFF;
          if (i == 0)
          {
            i = paramArrayOfByte.length - j;
            if (i <= this.d)
            {
              localObject = new byte[i];
              System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - i, localObject, 0, i);
              return localObject;
            }
            throw new BadPaddingException("Padding string too short");
          }
          if (j == paramArrayOfByte.length) {
            break;
          }
          if ((this.a == 1) && (i != 255))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("Padding byte not 0xff: ");
            paramArrayOfByte.append(i);
            throw new BadPaddingException(paramArrayOfByte.toString());
          }
          i = j;
        }
        throw new BadPaddingException("Padding string not terminated");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Blocktype mismatch: ");
      ((StringBuilder)localObject).append(paramArrayOfByte[1]);
      throw new BadPaddingException(((StringBuilder)localObject).toString());
    }
    throw new BadPaddingException("Data must start with zero");
  }
  
  private byte[] e(byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      this.c = b.a;
    }
    int i = this.g.length;
    byte[] arrayOfByte1 = new byte[i];
    this.c.nextBytes(arrayOfByte1);
    int k = this.b;
    byte[] arrayOfByte2 = new byte[k];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, i);
    int j = i + 1;
    k -= j;
    int m = this.b - paramArrayOfByte.length;
    System.arraycopy(this.g, 0, arrayOfByte2, j, i);
    arrayOfByte2[(m - 1)] = 1;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, m, paramArrayOfByte.length);
    a(arrayOfByte2, 1, i, arrayOfByte2, j, k);
    a(arrayOfByte2, j, k, arrayOfByte2, 1, i);
    return arrayOfByte2;
  }
  
  private byte[] f(byte[] paramArrayOfByte)
  {
    int j = this.g.length;
    if (paramArrayOfByte[0] == 0)
    {
      int k = j + 1;
      int i = paramArrayOfByte.length - k;
      a(paramArrayOfByte, k, i, paramArrayOfByte, 1, j);
      a(paramArrayOfByte, 1, j, paramArrayOfByte, k, i);
      i = 0;
      while (i < j) {
        if (this.g[i] == paramArrayOfByte[(k + i)]) {
          i += 1;
        } else {
          throw new BadPaddingException("lHash mismatch");
        }
      }
      i = k + j;
      while (paramArrayOfByte[i] == 0)
      {
        i += 1;
        if (i >= paramArrayOfByte.length) {
          throw new BadPaddingException("Padding string not terminated");
        }
      }
      j = i + 1;
      if (paramArrayOfByte[i] == 1)
      {
        i = paramArrayOfByte.length - j;
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      throw new BadPaddingException("Padding string not terminated by 0x01 byte");
    }
    throw new BadPaddingException("Data must start with zero");
  }
  
  public int a()
  {
    return this.d;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length <= this.d)
    {
      int i = this.a;
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if (i == 4) {
            return e(paramArrayOfByte);
          }
          throw new AssertionError();
        }
        return paramArrayOfByte;
      }
      return c(paramArrayOfByte);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Data must be shorter than ");
    paramArrayOfByte.append(this.d + 1);
    paramArrayOfByte.append(" bytes");
    throw new BadPaddingException(paramArrayOfByte.toString());
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(b.a(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == this.b)
    {
      int i = this.a;
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if (i == 4) {
            return f(paramArrayOfByte);
          }
          throw new AssertionError();
        }
        return paramArrayOfByte;
      }
      return d(paramArrayOfByte);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Padded length must be ");
    paramArrayOfByte.append(this.b);
    throw new BadPaddingException(paramArrayOfByte.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.d.f
 * JD-Core Version:    0.7.0.1
 */