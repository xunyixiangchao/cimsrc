package com.baidu.b.d;

public final class a
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt / 4 * 3;
    if (i == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[i];
    int j = 0;
    int k = paramInt;
    for (;;)
    {
      i = paramArrayOfByte[(k - 1)];
      paramInt = j;
      if (i != 10)
      {
        paramInt = j;
        if (i != 13)
        {
          paramInt = j;
          if (i != 32) {
            if (i == 9)
            {
              paramInt = j;
            }
            else if (i == 61)
            {
              paramInt = j + 1;
            }
            else
            {
              int n = 0;
              paramInt = n;
              i = paramInt;
              int m = i;
              int i1 = paramInt;
              while (n < k)
              {
                int i4 = paramArrayOfByte[n];
                int i2 = i1;
                paramInt = i;
                int i3 = m;
                if (i4 != 10)
                {
                  i2 = i1;
                  paramInt = i;
                  i3 = m;
                  if (i4 != 13)
                  {
                    i2 = i1;
                    paramInt = i;
                    i3 = m;
                    if (i4 != 32) {
                      if (i4 == 9)
                      {
                        i2 = i1;
                        paramInt = i;
                        i3 = m;
                      }
                      else
                      {
                        if ((i4 >= 65) && (i4 <= 90))
                        {
                          paramInt = i4 - 65;
                        }
                        else if ((i4 >= 97) && (i4 <= 122))
                        {
                          paramInt = i4 - 71;
                        }
                        else if ((i4 >= 48) && (i4 <= 57))
                        {
                          paramInt = i4 + 4;
                        }
                        else if (i4 == 43)
                        {
                          paramInt = 62;
                        }
                        else
                        {
                          if (i4 != 47) {
                            break label346;
                          }
                          paramInt = 63;
                        }
                        i2 = (byte)paramInt | i1 << 6;
                        paramInt = i;
                        if (m % 4 == 3)
                        {
                          paramInt = i + 1;
                          arrayOfByte[i] = ((byte)((0xFF0000 & i2) >> 16));
                          i = paramInt + 1;
                          arrayOfByte[paramInt] = ((byte)((0xFF00 & i2) >> 8));
                          arrayOfByte[i] = ((byte)(i2 & 0xFF));
                          paramInt = i + 1;
                        }
                        i3 = m + 1;
                        break label348;
                        label346:
                        return null;
                      }
                    }
                  }
                }
                label348:
                n += 1;
                i1 = i2;
                i = paramInt;
                m = i3;
              }
              paramInt = i;
              if (j > 0)
              {
                k = i1 << j * 6;
                paramInt = i + 1;
                arrayOfByte[i] = ((byte)((k & 0xFF0000) >> 16));
                if (j == 1)
                {
                  i = paramInt + 1;
                  arrayOfByte[paramInt] = ((byte)((k & 0xFF00) >> 8));
                  paramInt = i;
                }
              }
              paramArrayOfByte = new byte[paramInt];
              System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, paramInt);
              return paramArrayOfByte;
            }
          }
        }
      }
      k -= 1;
      j = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.d.a
 * JD-Core Version:    0.7.0.1
 */