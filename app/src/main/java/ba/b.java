package ba;

import a9.f;
import aa.e;
import o8.o;

public final class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static final int c(byte[] paramArrayOfByte, int paramInt)
  {
    int i2 = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    int k = 0;
    if (i < i2)
    {
      int n = paramArrayOfByte[i];
      int m;
      label122:
      int i1;
      if (n >= 0)
      {
        m = k + 1;
        if (k == paramInt) {
          return j;
        }
        if ((n != 10) && (n != 13))
        {
          if ((n >= 0) && (n <= 31)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k == 0)
          {
            if ((127 <= n) && (n <= 159)) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              k = 0;
              break label122;
            }
          }
          k = 1;
          if (k != 0) {}
        }
        else
        {
          if (n != 65533) {
            break label136;
          }
        }
        return -1;
        label136:
        if (n < 65536) {
          k = 1;
        } else {
          k = 2;
        }
        n = j + k;
        j = i + 1;
        i = m;
        m = j;
        for (;;)
        {
          i1 = i;
          i = m;
          j = n;
          k = i1;
          if (m >= i2) {
            break;
          }
          i = m;
          j = n;
          k = i1;
          if (paramArrayOfByte[m] < 0) {
            break;
          }
          k = paramArrayOfByte[m];
          j = i1 + 1;
          if (i1 == paramInt) {
            return n;
          }
          if ((k != 10) && (k != 13))
          {
            if ((k >= 0) && (k <= 31)) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0)
            {
              if ((127 <= k) && (k <= 159)) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0)
              {
                i = 0;
                break label298;
              }
            }
            i = 1;
            label298:
            if (i != 0) {}
          }
          else
          {
            if (k != 65533) {
              break label311;
            }
          }
          return -1;
          label311:
          if (k < 65536) {
            i = 1;
          } else {
            i = 2;
          }
          n += i;
          m += 1;
          i = j;
        }
      }
      label547:
      label561:
      o localo;
      if (n >> 5 == -2)
      {
        m = i + 1;
        if (i2 <= m)
        {
          if (k == paramInt) {
            return j;
          }
          return -1;
        }
        n = paramArrayOfByte[i];
        i1 = paramArrayOfByte[m];
        if ((i1 & 0xC0) == 128) {
          m = 1;
        } else {
          m = 0;
        }
        if (m == 0)
        {
          if (k == paramInt) {
            return j;
          }
          return -1;
        }
        n = i1 ^ 0xF80 ^ n << 6;
        if (n < 128)
        {
          if (k == paramInt) {
            return j;
          }
          return -1;
        }
        m = k + 1;
        if (k == paramInt) {
          return j;
        }
        if ((n != 10) && (n != 13))
        {
          if ((n >= 0) && (n <= 31)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k == 0)
          {
            if ((127 <= n) && (n <= 159)) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              k = 0;
              break label547;
            }
          }
          k = 1;
          if (k != 0) {}
        }
        else
        {
          if (n != 65533) {
            break label561;
          }
        }
        return -1;
        if (n < 65536) {
          k = 1;
        } else {
          k = 2;
        }
        j += k;
        localo = o.a;
        i += 2;
        k = m;
      }
      for (;;)
      {
        break;
        int i3;
        if (n >> 4 == -2)
        {
          i3 = i + 2;
          if (i2 <= i3)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = paramArrayOfByte[i];
          i1 = paramArrayOfByte[(i + 1)];
          if ((i1 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          i3 = paramArrayOfByte[i3];
          if ((i3 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = i3 ^ 0xFFFE1F80 ^ i1 << 6 ^ n << 12;
          if (n < 2048)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          if ((55296 <= n) && (n <= 57343)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          m = k + 1;
          if (k == paramInt) {
            return j;
          }
          if ((n != 10) && (n != 13))
          {
            if ((n >= 0) && (n <= 31)) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              if ((127 <= n) && (n <= 159)) {
                k = 1;
              } else {
                k = 0;
              }
              if (k == 0)
              {
                k = 0;
                break label889;
              }
            }
            k = 1;
            label889:
            if (k != 0) {}
          }
          else
          {
            if (n != 65533) {
              break label903;
            }
          }
          return -1;
          label903:
          if (n < 65536) {
            k = 1;
          } else {
            k = 2;
          }
          j += k;
          localo = o.a;
          i += 3;
          k = m;
        }
        else
        {
          if (n >> 3 != -2) {
            break label1347;
          }
          int i4 = i + 3;
          if (i2 <= i4)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = paramArrayOfByte[i];
          i1 = paramArrayOfByte[(i + 1)];
          if ((i1 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          i3 = paramArrayOfByte[(i + 2)];
          if ((i3 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          i4 = paramArrayOfByte[i4];
          if ((i4 & 0xC0) == 128) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          n = i4 ^ 0x381F80 ^ i3 << 6 ^ i1 << 12 ^ n << 18;
          if (n > 1114111)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          if ((55296 <= n) && (n <= 57343)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          if (n < 65536)
          {
            if (k == paramInt) {
              return j;
            }
            return -1;
          }
          m = k + 1;
          if (k == paramInt) {
            return j;
          }
          if ((n != 10) && (n != 13))
          {
            if ((n >= 0) && (n <= 31)) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              if ((127 <= n) && (n <= 159)) {
                k = 1;
              } else {
                k = 0;
              }
              if (k == 0)
              {
                k = 0;
                break label1296;
              }
            }
            k = 1;
            label1296:
            if (k != 0) {}
          }
          else
          {
            if (n != 65533) {
              break label1310;
            }
          }
          return -1;
          label1310:
          if (n < 65536) {
            k = 1;
          } else {
            k = 2;
          }
          j += k;
          localo = o.a;
          i += 4;
          k = m;
        }
      }
      label1347:
      if (k == paramInt) {
        return j;
      }
      return -1;
    }
    return j;
  }
  
  public static final void d(e parame, aa.b paramb, int paramInt1, int paramInt2)
  {
    f.f(parame, "<this>");
    f.f(paramb, "buffer");
    paramb.F0(parame.e(), paramInt1, paramInt2);
  }
  
  private static final int e(char paramChar)
  {
    char c2 = '\001';
    if (('0' <= paramChar) && (paramChar <= '9')) {
      c1 = '\001';
    } else {
      c1 = '\000';
    }
    if (c1 != 0) {
      return paramChar - '0';
    }
    char c3 = 'a';
    if (('a' <= paramChar) && (paramChar <= 'f')) {
      c1 = '\001';
    } else {
      c1 = '\000';
    }
    if (c1 != 0) {}
    for (char c1 = c3;; c1 = c3)
    {
      return paramChar - c1 + 10;
      c3 = 'A';
      if (('A' <= paramChar) && (paramChar <= 'F')) {
        c1 = c2;
      } else {
        c1 = '\000';
      }
      if (c1 == 0) {
        break;
      }
    }
    throw new IllegalArgumentException(f.m("Unexpected hex digit: ", Character.valueOf(paramChar)));
  }
  
  public static final char[] f()
  {
    return a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ba.b
 * JD-Core Version:    0.7.0.1
 */