package n8;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class a
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    int i7 = paramInt;
    Bitmap localBitmap;
    if (paramBoolean) {
      localBitmap = paramBitmap;
    } else {
      localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    if (i7 < 1) {
      return null;
    }
    int i16 = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    int i = i16 * j;
    int[] arrayOfInt2 = new int[i];
    localBitmap.getPixels(arrayOfInt2, 0, i16, 0, 0, i16, j);
    int i19 = i16 - 1;
    int k = j - 1;
    int i15 = i7 + i7 + 1;
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    paramBitmap = new int[Math.max(i16, j)];
    i = i15 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    int[] arrayOfInt1 = new int[n];
    i = 0;
    while (i < n)
    {
      arrayOfInt1[i] = (i / m);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i15, 3 });
    int i18 = i7 + 1;
    int i9 = 0;
    int i10 = 0;
    int i8 = 0;
    i = k;
    int i11;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i12;
    int[] arrayOfInt6;
    int i13;
    int i14;
    while (i9 < j)
    {
      i11 = -i7;
      i1 = 0;
      i2 = 0;
      n = 0;
      m = 0;
      k = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      while (i11 <= i7)
      {
        i12 = arrayOfInt2[(i10 + Math.min(i19, Math.max(i11, 0)))];
        arrayOfInt6 = arrayOfInt[(i11 + i7)];
        arrayOfInt6[0] = ((i12 & 0xFF0000) >> 16);
        arrayOfInt6[1] = ((i12 & 0xFF00) >> 8);
        arrayOfInt6[2] = (i12 & 0xFF);
        i12 = i18 - Math.abs(i11);
        i6 += arrayOfInt6[0] * i12;
        i1 += arrayOfInt6[1] * i12;
        i2 += arrayOfInt6[2] * i12;
        if (i11 > 0)
        {
          i3 += arrayOfInt6[0];
          i4 += arrayOfInt6[1];
          i5 += arrayOfInt6[2];
        }
        else
        {
          n += arrayOfInt6[0];
          m += arrayOfInt6[1];
          k += arrayOfInt6[2];
        }
        i11 += 1;
      }
      i13 = i7;
      i14 = i6;
      int i17 = 0;
      i6 = i5;
      i11 = i4;
      i12 = i3;
      i3 = i1;
      i1 = i13;
      i5 = i14;
      i4 = i17;
      while (i4 < i16)
      {
        arrayOfInt3[i10] = arrayOfInt1[i5];
        arrayOfInt4[i10] = arrayOfInt1[i3];
        arrayOfInt5[i10] = arrayOfInt1[i2];
        arrayOfInt6 = arrayOfInt[((i1 - i7 + i15) % i15)];
        i17 = arrayOfInt6[0];
        i14 = arrayOfInt6[1];
        i13 = arrayOfInt6[2];
        if (i9 == 0) {
          paramBitmap[i4] = Math.min(i4 + i7 + 1, i19);
        }
        int i20 = arrayOfInt2[(i8 + paramBitmap[i4])];
        arrayOfInt6[0] = ((i20 & 0xFF0000) >> 16);
        arrayOfInt6[1] = ((i20 & 0xFF00) >> 8);
        arrayOfInt6[2] = (i20 & 0xFF);
        i12 += arrayOfInt6[0];
        i11 += arrayOfInt6[1];
        i6 += arrayOfInt6[2];
        i5 = i5 - n + i12;
        i3 = i3 - m + i11;
        i2 = i2 - k + i6;
        i1 = (i1 + 1) % i15;
        arrayOfInt6 = arrayOfInt[(i1 % i15)];
        n = n - i17 + arrayOfInt6[0];
        m = m - i14 + arrayOfInt6[1];
        k = k - i13 + arrayOfInt6[2];
        i12 -= arrayOfInt6[0];
        i11 -= arrayOfInt6[1];
        i6 -= arrayOfInt6[2];
        i10 += 1;
        i4 += 1;
      }
      i8 += i16;
      i9 += 1;
    }
    i9 = j;
    m = 0;
    j = i;
    k = i16;
    i8 = i15;
    i = m;
    for (;;)
    {
      i10 = paramInt;
      if (i >= k) {
        break;
      }
      i6 = -i10;
      i2 = 0;
      i1 = 0;
      n = 0;
      m = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i12 = i6;
      i11 = i6 * k;
      i6 = 0;
      i7 = 0;
      while (i12 <= i10)
      {
        i13 = Math.max(0, i11) + i;
        arrayOfInt6 = arrayOfInt[(i12 + i10)];
        arrayOfInt6[0] = arrayOfInt3[i13];
        arrayOfInt6[1] = arrayOfInt4[i13];
        arrayOfInt6[2] = arrayOfInt5[i13];
        i14 = i18 - Math.abs(i12);
        i6 += arrayOfInt3[i13] * i14;
        i7 += arrayOfInt4[i13] * i14;
        i2 += arrayOfInt5[i13] * i14;
        if (i12 > 0)
        {
          i3 += arrayOfInt6[0];
          i4 += arrayOfInt6[1];
          i5 += arrayOfInt6[2];
        }
        else
        {
          i1 += arrayOfInt6[0];
          n += arrayOfInt6[1];
          m += arrayOfInt6[2];
        }
        i13 = i11;
        if (i12 < j) {
          i13 = i11 + k;
        }
        i12 += 1;
        i11 = i13;
      }
      i11 = i10;
      i10 = i;
      i13 = i7;
      i14 = i6;
      i15 = 0;
      i7 = i11;
      i6 = i10;
      i10 = i5;
      i11 = i4;
      i12 = i3;
      i3 = i13;
      i5 = i14;
      i4 = i15;
      while (i4 < i9)
      {
        arrayOfInt2[i6] = (arrayOfInt2[i6] & 0xFF000000 | arrayOfInt1[i5] << 16 | arrayOfInt1[i3] << 8 | arrayOfInt1[i2]);
        arrayOfInt6 = arrayOfInt[((i7 - paramInt + i8) % i8)];
        i15 = arrayOfInt6[0];
        i14 = arrayOfInt6[1];
        i13 = arrayOfInt6[2];
        if (i == 0) {
          paramBitmap[i4] = (Math.min(i4 + i18, j) * k);
        }
        i16 = paramBitmap[i4] + i;
        arrayOfInt6[0] = arrayOfInt3[i16];
        arrayOfInt6[1] = arrayOfInt4[i16];
        arrayOfInt6[2] = arrayOfInt5[i16];
        i12 += arrayOfInt6[0];
        i11 += arrayOfInt6[1];
        i10 += arrayOfInt6[2];
        i5 = i5 - i1 + i12;
        i3 = i3 - n + i11;
        i2 = i2 - m + i10;
        i7 = (i7 + 1) % i8;
        arrayOfInt6 = arrayOfInt[i7];
        i1 = i1 - i15 + arrayOfInt6[0];
        n = n - i14 + arrayOfInt6[1];
        m = m - i13 + arrayOfInt6[2];
        i12 -= arrayOfInt6[0];
        i11 -= arrayOfInt6[1];
        i10 -= arrayOfInt6[2];
        i6 += k;
        i4 += 1;
      }
      i += 1;
    }
    localBitmap.setPixels(arrayOfInt2, 0, k, 0, 0, k, i9);
    return localBitmap;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n8.a
 * JD-Core Version:    0.7.0.1
 */