package aa;

import a9.f;

public final class a0
{
  private static final byte[] a;
  private static final byte[] b;
  
  static
  {
    e.a locala = e.d;
    a = locala.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").e();
    b = locala.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").e();
  }
  
  public static final String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    f.f(paramArrayOfByte1, "<this>");
    f.f(paramArrayOfByte2, "map");
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) / 3 * 4];
    int m = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int k = 0;
    int j = 0;
    int n;
    while (k < m)
    {
      n = k + 1;
      int i1 = paramArrayOfByte1[k];
      k = n + 1;
      int i2 = paramArrayOfByte1[n];
      n = paramArrayOfByte1[k];
      int i3 = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((i1 & 0xFF) >> 2)];
      j = i3 + 1;
      arrayOfByte[i3] = paramArrayOfByte2[((i1 & 0x3) << 4 | (i2 & 0xFF) >> 4)];
      i1 = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((i2 & 0xF) << 2 | (n & 0xFF) >> 6)];
      j = i1 + 1;
      arrayOfByte[i1] = paramArrayOfByte2[(n & 0x3F)];
      k += 1;
    }
    m = paramArrayOfByte1.length - m;
    if (m != 1)
    {
      if (m == 2)
      {
        m = paramArrayOfByte1[k];
        k = paramArrayOfByte1[(k + 1)];
        n = j + 1;
        arrayOfByte[j] = paramArrayOfByte2[((m & 0xFF) >> 2)];
        j = n + 1;
        arrayOfByte[n] = paramArrayOfByte2[((m & 0x3) << 4 | (k & 0xFF) >> 4)];
        arrayOfByte[j] = paramArrayOfByte2[((k & 0xF) << 2)];
        arrayOfByte[(j + 1)] = ((byte)61);
      }
    }
    else
    {
      k = paramArrayOfByte1[k];
      m = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((k & 0xFF) >> 2)];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[((k & 0x3) << 4)];
      int i = (byte)61;
      arrayOfByte[j] = i;
      arrayOfByte[(j + 1)] = i;
    }
    return b0.b(arrayOfByte);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.a0
 * JD-Core Version:    0.7.0.1
 */