package com.baidu.b.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;

public final class b
  implements a
{
  private static int[] g = null;
  private static int[] h;
  private static final byte[] i;
  private static final byte[] j;
  private static final int[] k;
  private static final int[] l;
  private static final int[] m;
  private static final int[] n;
  private static final int[] o;
  private static final int[] p;
  private static final int[] q;
  private static final int[] r;
  private static final int[] s;
  private static final int[] t;
  private static final int[] u;
  private static final int[] v;
  private static final byte[] w;
  private boolean b = false;
  private boolean c = false;
  private Object[] d = null;
  private int[] e = null;
  private int f = 0;
  
  static
  {
    Object localObject1 = new int[256];
    g = (int[])localObject1;
    h = new int[256];
    i = new byte[256];
    j = new byte[256];
    k = new int[256];
    l = new int[256];
    m = new int[256];
    n = new int[256];
    o = new int[256];
    p = new int[256];
    q = new int[256];
    r = new int[256];
    s = new int[256];
    t = new int[256];
    u = new int[256];
    v = new int[256];
    w = new byte[30];
    localObject1[0] = 1;
    int i2 = 1;
    int i4;
    while (i2 < 256)
    {
      localObject1 = g;
      i3 = i2 - 1;
      i4 = localObject1[i3];
      i4 = localObject1[i3] ^ i4 << 1;
      i3 = i4;
      if ((i4 & 0x100) != 0) {
        i3 = i4 ^ 0x11B;
      }
      localObject1[i2] = i3;
      i2 += 1;
    }
    i2 = 1;
    while (i2 < 255)
    {
      h[g[i2]] = i2;
      i2 += 1;
    }
    byte[] arrayOfByte1 = { 1, 1, 1, 1, 1, 0, 0, 0 };
    Object localObject3 = { 1, 1, 0, 0, 0, 1, 1, 1 };
    Object localObject4 = { 1, 1, 1, 0, 0, 0, 1, 1 };
    Object localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 256, 8 });
    localObject2[1][7] = 1;
    i2 = 2;
    while (i2 < 256)
    {
      i4 = g[(255 - h[i2])];
      i3 = 0;
      while (i3 < 8)
      {
        localObject2[i2][i3] = ((byte)(i4 >>> 7 - i3 & 0x1));
        i3 += 1;
      }
      i2 += 1;
    }
    localObject1 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 256, 8 });
    i2 = 0;
    while (i2 < 256)
    {
      i3 = 0;
      while (i3 < 8)
      {
        localObject1[i2][i3] = new byte[] { 0, 1, 1, 0, 0, 0, 1, 1 }[i3];
        i4 = 0;
        while (i4 < 8)
        {
          arrayOfByte = localObject1[i2];
          arrayOfByte[i3] = ((byte)(arrayOfByte[i3] ^ new byte[][] { arrayOfByte1, { 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, localObject3, localObject4, { 1, 1, 1, 1, 0, 0, 0, 1 } }[i3][i4] * localObject2[i2][i4]));
          i4 += 1;
        }
        i3 += 1;
      }
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 256)
    {
      i[i2] = ((byte)(localObject1[i2][0] << 7));
      i3 = 1;
      while (i3 < 8)
      {
        localObject2 = i;
        localObject2[i2] = ((byte)(localObject2[i2] ^ localObject1[i2][i3] << 7 - i3));
        i3 += 1;
      }
      j[(i[i2] & 0xFF)] = ((byte)i2);
      i2 += 1;
    }
    localObject1 = new byte[4][];
    localObject1[0] = { 2, 1, 1, 3 };
    localObject1[1] = { 3, 2, 1, 1 };
    localObject1[2] = { 1, 3, 2, 1 };
    localObject1[3] = { 1, 1, 3, 2 };
    localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 4, 8 });
    i2 = 0;
    while (i2 < 4)
    {
      i3 = 0;
      while (i3 < 4)
      {
        localObject2[i2][i3] = localObject1[i2][i3];
        i3 += 1;
      }
      localObject2[i2][(i2 + 4)] = 1;
      i2 += 1;
    }
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 4, 4 });
    i2 = 0;
    while (i2 < 4)
    {
      i4 = localObject2[i2][i2];
      i3 = i4;
      if (i4 == 0)
      {
        i3 = i2 + 1;
        while ((localObject2[i3][i2] == 0) && (i3 < 4)) {
          i3 += 1;
        }
        if (i3 != 4)
        {
          i4 = 0;
          while (i4 < 8)
          {
            int i1 = localObject2[i2][i4];
            localObject2[i2][i4] = localObject2[i3][i4];
            localObject2[i3][i4] = i1;
            i4 += 1;
          }
          i3 = localObject2[i2][i2];
        }
        else
        {
          throw new RuntimeException("G matrix is not invertible");
        }
      }
      i4 = 0;
      while (i4 < 8)
      {
        if (localObject2[i2][i4] != 0)
        {
          arrayOfByte1 = localObject2[i2];
          localObject3 = g;
          localObject4 = h;
          arrayOfByte1[i4] = ((byte)localObject3[((localObject4[(localObject2[i2][i4] & 0xFF)] + 255 - localObject4[(i3 & 0xFF)]) % 255)]);
        }
        i4 += 1;
      }
      i3 = 0;
      while (i3 < 4)
      {
        if (i2 != i3)
        {
          i4 = i2 + 1;
          while (i4 < 8)
          {
            arrayOfByte1 = localObject2[i3];
            arrayOfByte1[i4] = ((byte)(arrayOfByte1[i4] ^ a(localObject2[i2][i4], localObject2[i3][i2])));
            i4 += 1;
          }
          localObject2[i3][i2] = 0;
        }
        i3 += 1;
      }
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 4)
    {
      i3 = 0;
      while (i3 < 4)
      {
        arrayOfByte[i2][i3] = localObject2[i2][(i3 + 4)];
        i3 += 1;
      }
      i2 += 1;
    }
    i2 = 0;
    while (i2 < 256)
    {
      i3 = i[i2];
      k[i2] = a(i3, localObject1[0]);
      l[i2] = a(i3, localObject1[1]);
      m[i2] = a(i3, localObject1[2]);
      n[i2] = a(i3, localObject1[3]);
      i3 = j[i2];
      o[i2] = a(i3, arrayOfByte[0]);
      p[i2] = a(i3, arrayOfByte[1]);
      q[i2] = a(i3, arrayOfByte[2]);
      r[i2] = a(i3, arrayOfByte[3]);
      s[i2] = a(i2, arrayOfByte[0]);
      t[i2] = a(i2, arrayOfByte[1]);
      u[i2] = a(i2, arrayOfByte[2]);
      v[i2] = a(i2, arrayOfByte[3]);
      i2 += 1;
    }
    localObject1 = w;
    int i3 = 1;
    localObject1[0] = 1;
    i2 = 1;
    while (i2 < 30)
    {
      i3 = a(2, i3);
      w[i2] = ((byte)i3);
      i2 += 1;
    }
    h = null;
  }
  
  private static final int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int[] arrayOfInt1 = g;
      int[] arrayOfInt2 = h;
      return arrayOfInt1[((arrayOfInt2[(paramInt1 & 0xFF)] + arrayOfInt2[(paramInt2 & 0xFF)]) % 255)];
    }
    return 0;
  }
  
  private static final int a(int paramInt, byte[] paramArrayOfByte)
  {
    int i3 = 0;
    if (paramInt == 0) {
      return 0;
    }
    int[] arrayOfInt = h;
    int i4 = arrayOfInt[(paramInt & 0xFF)];
    if (paramArrayOfByte[0] != 0) {
      paramInt = g[((arrayOfInt[(paramArrayOfByte[0] & 0xFF)] + i4) % 255)] & 0xFF;
    } else {
      paramInt = 0;
    }
    int i1;
    if (paramArrayOfByte[1] != 0) {
      i1 = g[((arrayOfInt[(paramArrayOfByte[1] & 0xFF)] + i4) % 255)] & 0xFF;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramArrayOfByte[2] != 0) {
      i2 = g[((arrayOfInt[(paramArrayOfByte[2] & 0xFF)] + i4) % 255)] & 0xFF;
    } else {
      i2 = 0;
    }
    if (paramArrayOfByte[3] != 0) {
      i3 = g[((i4 + arrayOfInt[(paramArrayOfByte[3] & 0xFF)]) % 255)] & 0xFF;
    }
    return paramInt << 24 | i1 << 16 | i2 << 8 | i3;
  }
  
  private void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static final boolean a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = a.a;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i1]) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static Object[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (a(paramArrayOfByte.length))
      {
        int i7 = b(paramArrayOfByte.length);
        int i1 = i7 + 1;
        int i8 = i1 * 4;
        localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1, 4 });
        int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1, 4 });
        int i9 = paramArrayOfByte.length / 4;
        int[] arrayOfInt1 = new int[i9];
        int i2 = 0;
        i1 = i2;
        int i4;
        while (i2 < i9)
        {
          i3 = paramArrayOfByte[i1];
          i4 = paramArrayOfByte[(i1 + 1)];
          arrayOfInt1[i2] = ((paramArrayOfByte[(i1 + 2)] & 0xFF) << 8 | i3 << 24 | (i4 & 0xFF) << 16 | paramArrayOfByte[(i1 + 3)] & 0xFF);
          i2 += 1;
          i1 += 4;
        }
        i2 = 0;
        i1 = i2;
        while ((i2 < i9) && (i1 < i8))
        {
          i3 = i1 / 4;
          paramArrayOfByte = localObject[i3];
          i4 = i1 % 4;
          paramArrayOfByte[i4] = arrayOfInt1[i2];
          arrayOfInt[(i7 - i3)][i4] = arrayOfInt1[i2];
          i2 += 1;
          i1 += 1;
        }
        int i3 = 0;
        i2 = i1;
        i1 = i3;
        int i5;
        int i6;
        while (i2 < i8)
        {
          int i10 = arrayOfInt1[(i9 - 1)];
          i3 = arrayOfInt1[0];
          paramArrayOfByte = i;
          i4 = paramArrayOfByte[(i10 >>> 16 & 0xFF)];
          i5 = paramArrayOfByte[(i10 >>> 8 & 0xFF)];
          i6 = paramArrayOfByte[(i10 & 0xFF)];
          i10 = paramArrayOfByte[(i10 >>> 24)];
          arrayOfInt1[0] = (w[i1] << 24 ^ i4 << 24 ^ (i5 & 0xFF) << 16 ^ (i6 & 0xFF) << 8 ^ i10 & 0xFF ^ i3);
          i3 = 1;
          i5 = 1;
          i4 = 0;
          i6 = 0;
          if (i9 != 8)
          {
            i3 = i6;
            i4 = i5;
            while (i4 < i9)
            {
              arrayOfInt1[i4] ^= arrayOfInt1[i3];
              i4 += 1;
              i3 += 1;
            }
          }
          for (;;)
          {
            i5 = i9 / 2;
            if (i3 >= i5) {
              break;
            }
            arrayOfInt1[i3] ^= arrayOfInt1[i4];
            i3 += 1;
            i4 += 1;
          }
          i3 = arrayOfInt1[(i5 - 1)];
          i4 = arrayOfInt1[i5];
          paramArrayOfByte = i;
          i6 = paramArrayOfByte[(i3 & 0xFF)];
          i10 = paramArrayOfByte[(i3 >>> 8 & 0xFF)];
          int i11 = paramArrayOfByte[(i3 >>> 16 & 0xFF)];
          arrayOfInt1[i5] = (paramArrayOfByte[(i3 >>> 24)] << 24 ^ (i10 & 0xFF) << 8 ^ i6 & 0xFF ^ (i11 & 0xFF) << 16 ^ i4);
          i4 = i5 + 1;
          i3 = i5;
          while (i4 < i9)
          {
            arrayOfInt1[i4] ^= arrayOfInt1[i3];
            i4 += 1;
            i3 += 1;
          }
          i3 = 0;
          while ((i3 < i9) && (i2 < i8))
          {
            i4 = i2 / 4;
            paramArrayOfByte = localObject[i4];
            i5 = i2 % 4;
            paramArrayOfByte[i5] = arrayOfInt1[i3];
            arrayOfInt[(i7 - i4)][i5] = arrayOfInt1[i3];
            i3 += 1;
            i2 += 1;
          }
          i1 += 1;
        }
        i1 = 1;
        while (i1 < i7)
        {
          i2 = 0;
          while (i2 < 4)
          {
            i3 = arrayOfInt[i1][i2];
            paramArrayOfByte = arrayOfInt[i1];
            i4 = s[(i3 >>> 24 & 0xFF)];
            i5 = t[(i3 >>> 16 & 0xFF)];
            i6 = u[(i3 >>> 8 & 0xFF)];
            paramArrayOfByte[i2] = (v[(i3 & 0xFF)] ^ i4 ^ i5 ^ i6);
            i2 += 1;
          }
          i1 += 1;
        }
        return new Object[] { localObject, arrayOfInt };
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid AES key length: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      ((StringBuilder)localObject).append(" bytes");
      throw new InvalidKeyException(((StringBuilder)localObject).toString());
    }
    throw new InvalidKeyException("Empty key");
  }
  
  private static int b(int paramInt)
  {
    return (paramInt >> 2) + 6;
  }
  
  int a()
  {
    return 16;
  }
  
  void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    if (a(paramArrayOfByte.length))
    {
      this.d = a(paramArrayOfByte);
      a(paramBoolean);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Invalid AES key length: ");
    paramString.append(paramArrayOfByte.length);
    paramString.append(" bytes");
    throw new InvalidKeyException(paramString.toString());
  }
  
  void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte1[paramInt1];
    int i1 = i2 + 1;
    i2 = paramArrayOfByte1[i2];
    int i3 = i1 + 1;
    int i4 = paramArrayOfByte1[i1];
    i1 = i3 + 1;
    i3 = paramArrayOfByte1[i3];
    Object localObject = this.e;
    i2 = ((i2 & 0xFF) << 16 | paramInt1 << 24 | (i4 & 0xFF) << 8 | i3 & 0xFF) ^ localObject[0];
    i4 = i1 + 1;
    paramInt1 = paramArrayOfByte1[i1];
    i3 = i4 + 1;
    i1 = paramArrayOfByte1[i4];
    i4 = i3 + 1;
    int i5 = paramArrayOfByte1[i3];
    i3 = i4 + 1;
    i1 = (paramInt1 << 24 | (i1 & 0xFF) << 16 | (i5 & 0xFF) << 8 | paramArrayOfByte1[i4] & 0xFF) ^ localObject[1];
    i4 = i3 + 1;
    paramInt1 = paramArrayOfByte1[i3];
    i3 = i4 + 1;
    i4 = paramArrayOfByte1[i4];
    i5 = i3 + 1;
    int i6 = paramArrayOfByte1[i3];
    i3 = i5 + 1;
    paramInt1 = ((i4 & 0xFF) << 16 | paramInt1 << 24 | (i6 & 0xFF) << 8 | paramArrayOfByte1[i5] & 0xFF) ^ localObject[2];
    i5 = i3 + 1;
    i3 = paramArrayOfByte1[i3];
    i4 = i5 + 1;
    i5 = paramArrayOfByte1[i5];
    i6 = paramArrayOfByte1[i4];
    i4 = paramArrayOfByte1[(i4 + 1)];
    i3 = localObject[3] ^ ((i5 & 0xFF) << 16 | i3 << 24 | (i6 & 0xFF) << 8 | i4 & 0xFF);
    int i9;
    for (i4 = 4; i4 < this.f; i4 = i9 + 1)
    {
      paramArrayOfByte1 = k;
      i5 = paramArrayOfByte1[(i2 >>> 24)];
      localObject = l;
      i6 = localObject[(i1 >>> 16 & 0xFF)];
      int[] arrayOfInt1 = m;
      i7 = arrayOfInt1[(paramInt1 >>> 8 & 0xFF)];
      int[] arrayOfInt2 = n;
      int i8 = arrayOfInt2[(i3 & 0xFF)];
      int[] arrayOfInt3 = this.e;
      i9 = i4 + 1;
      i4 = arrayOfInt3[i4];
      int i10 = paramArrayOfByte1[(i1 >>> 24)];
      int i11 = localObject[(paramInt1 >>> 16 & 0xFF)];
      int i12 = arrayOfInt1[(i3 >>> 8 & 0xFF)];
      int i13 = arrayOfInt2[(i2 & 0xFF)];
      int i19 = i9 + 1;
      int i18 = arrayOfInt3[i9];
      int i14 = paramArrayOfByte1[(paramInt1 >>> 24)];
      int i15 = localObject[(i3 >>> 16 & 0xFF)];
      int i16 = arrayOfInt1[(i2 >>> 8 & 0xFF)];
      int i17 = arrayOfInt2[(i1 & 0xFF)];
      i9 = i19 + 1;
      i19 = arrayOfInt3[i19];
      i3 = paramArrayOfByte1[(i3 >>> 24)];
      i2 = localObject[(i2 >>> 16 & 0xFF)];
      int i20 = arrayOfInt1[(i1 >>> 8 & 0xFF)];
      int i21 = arrayOfInt2[(paramInt1 & 0xFF)];
      int i22 = arrayOfInt3[i9];
      i1 = i10 ^ i11 ^ i12 ^ i13 ^ i18;
      paramInt1 = i14 ^ i15 ^ i16 ^ i17 ^ i19;
      i3 = i2 ^ i3 ^ i20 ^ i21 ^ i22;
      i2 = i4 ^ i5 ^ i6 ^ i7 ^ i8;
    }
    paramArrayOfByte1 = this.e;
    i5 = i4 + 1;
    i4 = paramArrayOfByte1[i4];
    i6 = paramInt2 + 1;
    localObject = i;
    paramArrayOfByte2[paramInt2] = ((byte)(localObject[(i2 >>> 24)] ^ i4 >>> 24));
    paramInt2 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(localObject[(i1 >>> 16 & 0xFF)] ^ i4 >>> 16));
    int i7 = paramInt2 + 1;
    paramArrayOfByte2[paramInt2] = ((byte)(localObject[(paramInt1 >>> 8 & 0xFF)] ^ i4 >>> 8));
    i6 = i7 + 1;
    paramArrayOfByte2[i7] = ((byte)(i4 ^ localObject[(i3 & 0xFF)]));
    paramInt2 = i5 + 1;
    i4 = paramArrayOfByte1[i5];
    i5 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(localObject[(i1 >>> 24)] ^ i4 >>> 24));
    i6 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(localObject[(paramInt1 >>> 16 & 0xFF)] ^ i4 >>> 16));
    i7 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(localObject[(i3 >>> 8 & 0xFF)] ^ i4 >>> 8));
    i5 = i7 + 1;
    paramArrayOfByte2[i7] = ((byte)(i4 ^ localObject[(i2 & 0xFF)]));
    i4 = paramArrayOfByte1[paramInt2];
    i6 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(localObject[(paramInt1 >>> 24)] ^ i4 >>> 24));
    i5 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(localObject[(i3 >>> 16 & 0xFF)] ^ i4 >>> 16));
    i6 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(localObject[(i2 >>> 8 & 0xFF)] ^ i4 >>> 8));
    i5 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(i4 ^ localObject[(i1 & 0xFF)]));
    paramInt2 = paramArrayOfByte1[(paramInt2 + 1)];
    i4 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(localObject[(i3 >>> 24)] ^ paramInt2 >>> 24));
    i3 = i4 + 1;
    paramArrayOfByte2[i4] = ((byte)(localObject[(i2 >>> 16 & 0xFF)] ^ paramInt2 >>> 16));
    paramArrayOfByte2[i3] = ((byte)(localObject[(i1 >>> 8 & 0xFF)] ^ paramInt2 >>> 8));
    paramArrayOfByte2[(i3 + 1)] = ((byte)(localObject[(paramInt1 & 0xFF)] ^ paramInt2));
  }
  
  void b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte1[paramInt1];
    int i1 = i2 + 1;
    i2 = paramArrayOfByte1[i2];
    int i3 = i1 + 1;
    int i4 = paramArrayOfByte1[i1];
    i1 = i3 + 1;
    i3 = paramArrayOfByte1[i3];
    int[] arrayOfInt1 = this.e;
    paramInt1 = ((i2 & 0xFF) << 16 | paramInt1 << 24 | (i4 & 0xFF) << 8 | i3 & 0xFF) ^ arrayOfInt1[4];
    i3 = i1 + 1;
    i1 = paramArrayOfByte1[i1];
    i2 = i3 + 1;
    i3 = paramArrayOfByte1[i3];
    i4 = i2 + 1;
    int i5 = paramArrayOfByte1[i2];
    i2 = i4 + 1;
    i1 = (i1 << 24 | (i3 & 0xFF) << 16 | (i5 & 0xFF) << 8 | paramArrayOfByte1[i4] & 0xFF) ^ arrayOfInt1[5];
    i3 = i2 + 1;
    i2 = paramArrayOfByte1[i2];
    i4 = i3 + 1;
    i3 = paramArrayOfByte1[i3];
    i5 = i4 + 1;
    int i6 = paramArrayOfByte1[i4];
    i4 = i5 + 1;
    i3 = ((i3 & 0xFF) << 16 | i2 << 24 | (i6 & 0xFF) << 8 | paramArrayOfByte1[i5] & 0xFF) ^ arrayOfInt1[6];
    i2 = i4 + 1;
    i4 = paramArrayOfByte1[i4];
    i5 = i2 + 1;
    i2 = ((paramArrayOfByte1[i2] & 0xFF) << 16 | i4 << 24 | (paramArrayOfByte1[i5] & 0xFF) << 8 | paramArrayOfByte1[(i5 + 1)] & 0xFF) ^ arrayOfInt1[7];
    if (this.b)
    {
      paramArrayOfByte1 = o;
      i4 = paramArrayOfByte1[(paramInt1 >>> 24)];
      arrayOfInt2 = p;
      i5 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
      arrayOfInt3 = q;
      i6 = arrayOfInt3[(i3 >>> 8 & 0xFF)];
      arrayOfInt4 = r;
      i4 = i4 ^ i5 ^ i6 ^ arrayOfInt4[(i1 & 0xFF)] ^ arrayOfInt1[8];
      i5 = paramArrayOfByte1[(i1 >>> 24)];
      i5 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)] ^ i5 ^ arrayOfInt3[(i2 >>> 8 & 0xFF)] ^ arrayOfInt4[(i3 & 0xFF)] ^ arrayOfInt1[9];
      i6 = paramArrayOfByte1[(i3 >>> 24)];
      i6 = arrayOfInt2[(i1 >>> 16 & 0xFF)] ^ i6 ^ arrayOfInt3[(paramInt1 >>> 8 & 0xFF)] ^ arrayOfInt4[(i2 & 0xFF)] ^ arrayOfInt1[10];
      i2 = paramArrayOfByte1[(i2 >>> 24)];
      i3 = arrayOfInt2[(i3 >>> 16 & 0xFF)];
      i1 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
      i2 = arrayOfInt4[(paramInt1 & 0xFF)] ^ i1 ^ i3 ^ i2 ^ arrayOfInt1[11];
      paramInt1 = paramArrayOfByte1[(i4 >>> 24)];
      i1 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
      i3 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
      i7 = arrayOfInt4[(i5 & 0xFF)];
      paramInt1 = arrayOfInt1[12] ^ paramInt1 ^ i1 ^ i3 ^ i7;
      i1 = paramArrayOfByte1[(i5 >>> 24)] ^ arrayOfInt2[(i4 >>> 16 & 0xFF)] ^ arrayOfInt3[(i2 >>> 8 & 0xFF)] ^ arrayOfInt4[(i6 & 0xFF)] ^ arrayOfInt1[13];
      i3 = paramArrayOfByte1[(i6 >>> 24)] ^ arrayOfInt2[(i5 >>> 16 & 0xFF)] ^ arrayOfInt3[(i4 >>> 8 & 0xFF)] ^ arrayOfInt4[(i2 & 0xFF)] ^ arrayOfInt1[14];
      i2 = paramArrayOfByte1[(i2 >>> 24)] ^ arrayOfInt2[(i6 >>> 16 & 0xFF)] ^ arrayOfInt3[(i5 >>> 8 & 0xFF)] ^ arrayOfInt4[(i4 & 0xFF)] ^ arrayOfInt1[15];
      if (this.c)
      {
        i4 = paramArrayOfByte1[(paramInt1 >>> 24)] ^ arrayOfInt2[(i2 >>> 16 & 0xFF)] ^ arrayOfInt3[(i3 >>> 8 & 0xFF)] ^ arrayOfInt4[(i1 & 0xFF)] ^ arrayOfInt1[16];
        i5 = paramArrayOfByte1[(i1 >>> 24)];
        i6 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
        i7 = arrayOfInt3[(i2 >>> 8 & 0xFF)];
        i8 = arrayOfInt4[(i3 & 0xFF)];
        i5 = arrayOfInt1[17] ^ i5 ^ i6 ^ i7 ^ i8;
        i6 = paramArrayOfByte1[(i3 >>> 24)] ^ arrayOfInt2[(i1 >>> 16 & 0xFF)] ^ arrayOfInt3[(paramInt1 >>> 8 & 0xFF)] ^ arrayOfInt4[(i2 & 0xFF)] ^ arrayOfInt1[18];
        i2 = paramArrayOfByte1[(i2 >>> 24)] ^ arrayOfInt2[(i3 >>> 16 & 0xFF)] ^ arrayOfInt3[(i1 >>> 8 & 0xFF)] ^ arrayOfInt4[(paramInt1 & 0xFF)] ^ arrayOfInt1[19];
        paramInt1 = paramArrayOfByte1[(i4 >>> 24)];
        i1 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
        i3 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
        i7 = arrayOfInt4[(i5 & 0xFF)];
        paramInt1 = arrayOfInt1[20] ^ paramInt1 ^ i1 ^ i3 ^ i7;
        i1 = paramArrayOfByte1[(i5 >>> 24)] ^ arrayOfInt2[(i4 >>> 16 & 0xFF)] ^ arrayOfInt3[(i2 >>> 8 & 0xFF)] ^ arrayOfInt4[(i6 & 0xFF)] ^ arrayOfInt1[21];
        i3 = paramArrayOfByte1[(i6 >>> 24)] ^ arrayOfInt2[(i5 >>> 16 & 0xFF)] ^ arrayOfInt3[(i4 >>> 8 & 0xFF)] ^ arrayOfInt4[(i2 & 0xFF)] ^ arrayOfInt1[22];
        i2 = paramArrayOfByte1[(i2 >>> 24)] ^ arrayOfInt2[(i6 >>> 16 & 0xFF)] ^ arrayOfInt3[(i5 >>> 8 & 0xFF)] ^ arrayOfInt4[(i4 & 0xFF)] ^ arrayOfInt1[23];
        i4 = 24;
      }
      else
      {
        i4 = 16;
      }
    }
    else
    {
      i4 = 8;
    }
    paramArrayOfByte1 = o;
    i6 = paramArrayOfByte1[(paramInt1 >>> 24)];
    int[] arrayOfInt2 = p;
    int i7 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
    int[] arrayOfInt3 = q;
    int i8 = arrayOfInt3[(i3 >>> 8 & 0xFF)];
    int[] arrayOfInt4 = r;
    int i9 = arrayOfInt4[(i1 & 0xFF)];
    i5 = i4 + 1;
    i4 = arrayOfInt1[i4] ^ i6 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i1 >>> 24)];
    i8 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i2 >>> 8 & 0xFF)];
    int i10 = arrayOfInt4[(i3 & 0xFF)];
    i6 = i5 + 1;
    i5 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i5];
    i8 = paramArrayOfByte1[(i3 >>> 24)];
    i9 = arrayOfInt2[(i1 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(paramInt1 >>> 8 & 0xFF)];
    int i11 = arrayOfInt4[(i2 & 0xFF)];
    i7 = i6 + 1;
    i6 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i6];
    i2 = paramArrayOfByte1[(i2 >>> 24)];
    i3 = arrayOfInt2[(i3 >>> 16 & 0xFF)];
    i1 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(paramInt1 & 0xFF)];
    paramInt1 = i7 + 1;
    i1 = i8 ^ i2 ^ i3 ^ i1 ^ arrayOfInt1[i7];
    i3 = paramArrayOfByte1[(i4 >>> 24)];
    i7 = arrayOfInt2[(i1 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i5 & 0xFF)];
    i2 = paramInt1 + 1;
    paramInt1 = arrayOfInt1[paramInt1] ^ i3 ^ i7 ^ i8 ^ i9;
    i3 = paramArrayOfByte1[(i5 >>> 24)];
    i8 = arrayOfInt2[(i4 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i2 + 1;
    i2 = i3 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i2];
    i8 = paramArrayOfByte1[(i6 >>> 24)];
    i9 = arrayOfInt2[(i5 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(i4 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i1 & 0xFF)];
    i3 = i7 + 1;
    i7 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i7];
    i8 = paramArrayOfByte1[(i1 >>> 24)];
    i6 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i5 = arrayOfInt3[(i5 >>> 8 & 0xFF)];
    i4 = arrayOfInt4[(i4 & 0xFF)];
    i1 = i3 + 1;
    i5 = i4 ^ i8 ^ i6 ^ i5 ^ arrayOfInt1[i3];
    i4 = paramArrayOfByte1[(paramInt1 >>> 24)];
    i6 = arrayOfInt2[(i5 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i7 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i2 & 0xFF)];
    i3 = i1 + 1;
    i1 = arrayOfInt1[i1] ^ i4 ^ i6 ^ i8 ^ i9;
    i6 = paramArrayOfByte1[(i2 >>> 24)];
    i8 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i5 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i7 & 0xFF)];
    i4 = i3 + 1;
    i3 = i6 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i3];
    i8 = paramArrayOfByte1[(i7 >>> 24)];
    i9 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(paramInt1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i5 & 0xFF)];
    i6 = i4 + 1;
    i4 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i4];
    i5 = paramArrayOfByte1[(i5 >>> 24)];
    i7 = arrayOfInt2[(i7 >>> 16 & 0xFF)];
    i2 = arrayOfInt3[(i2 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(paramInt1 & 0xFF)];
    paramInt1 = i6 + 1;
    i6 = i5 ^ i7 ^ i2 ^ i8 ^ arrayOfInt1[i6];
    i5 = paramArrayOfByte1[(i1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i4 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i3 & 0xFF)];
    i2 = paramInt1 + 1;
    paramInt1 = arrayOfInt1[paramInt1] ^ i5 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i3 >>> 24)];
    i8 = arrayOfInt2[(i1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i4 & 0xFF)];
    i5 = i2 + 1;
    i2 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i2];
    i8 = paramArrayOfByte1[(i4 >>> 24)];
    i9 = arrayOfInt2[(i3 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i5 + 1;
    i5 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i5];
    i6 = paramArrayOfByte1[(i6 >>> 24)];
    i4 = arrayOfInt2[(i4 >>> 16 & 0xFF)];
    i3 = arrayOfInt3[(i3 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(i1 & 0xFF)];
    i1 = i7 + 1;
    i6 = i6 ^ i4 ^ i3 ^ i8 ^ arrayOfInt1[i7];
    i4 = paramArrayOfByte1[(paramInt1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i5 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i2 & 0xFF)];
    i3 = i1 + 1;
    i1 = arrayOfInt1[i1] ^ i4 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i2 >>> 24)];
    i8 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i5 & 0xFF)];
    i4 = i3 + 1;
    i3 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i3];
    i8 = paramArrayOfByte1[(i5 >>> 24)];
    i9 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(paramInt1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i4 + 1;
    i4 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i4];
    i6 = paramArrayOfByte1[(i6 >>> 24)];
    i5 = arrayOfInt2[(i5 >>> 16 & 0xFF)];
    i2 = arrayOfInt3[(i2 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(paramInt1 & 0xFF)];
    paramInt1 = i7 + 1;
    i6 = i6 ^ i5 ^ i2 ^ i8 ^ arrayOfInt1[i7];
    i5 = paramArrayOfByte1[(i1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i4 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i3 & 0xFF)];
    i2 = paramInt1 + 1;
    paramInt1 = arrayOfInt1[paramInt1] ^ i5 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i3 >>> 24)];
    i8 = arrayOfInt2[(i1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i4 & 0xFF)];
    i5 = i2 + 1;
    i2 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i2];
    i8 = paramArrayOfByte1[(i4 >>> 24)];
    i9 = arrayOfInt2[(i3 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i5 + 1;
    i5 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i5];
    i6 = paramArrayOfByte1[(i6 >>> 24)];
    i4 = arrayOfInt2[(i4 >>> 16 & 0xFF)];
    i3 = arrayOfInt3[(i3 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(i1 & 0xFF)];
    i1 = i7 + 1;
    i6 = i6 ^ i4 ^ i3 ^ i8 ^ arrayOfInt1[i7];
    i4 = paramArrayOfByte1[(paramInt1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i5 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i2 & 0xFF)];
    i3 = i1 + 1;
    i1 = arrayOfInt1[i1] ^ i4 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i2 >>> 24)];
    i8 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i5 & 0xFF)];
    i4 = i3 + 1;
    i3 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i3];
    i8 = paramArrayOfByte1[(i5 >>> 24)];
    i9 = arrayOfInt2[(i2 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(paramInt1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i4 + 1;
    i4 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i4];
    i6 = paramArrayOfByte1[(i6 >>> 24)];
    i5 = arrayOfInt2[(i5 >>> 16 & 0xFF)];
    i2 = arrayOfInt3[(i2 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(paramInt1 & 0xFF)];
    paramInt1 = i7 + 1;
    i6 = i6 ^ i5 ^ i2 ^ i8 ^ arrayOfInt1[i7];
    i5 = paramArrayOfByte1[(i1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i4 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i3 & 0xFF)];
    i2 = paramInt1 + 1;
    paramInt1 = arrayOfInt1[paramInt1] ^ i5 ^ i7 ^ i8 ^ i9;
    i7 = paramArrayOfByte1[(i3 >>> 24)];
    i8 = arrayOfInt2[(i1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i4 & 0xFF)];
    i5 = i2 + 1;
    i2 = i7 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i2];
    i8 = paramArrayOfByte1[(i4 >>> 24)];
    i9 = arrayOfInt2[(i3 >>> 16 & 0xFF)];
    i10 = arrayOfInt3[(i1 >>> 8 & 0xFF)];
    i11 = arrayOfInt4[(i6 & 0xFF)];
    i7 = i5 + 1;
    i5 = i8 ^ i9 ^ i10 ^ i11 ^ arrayOfInt1[i5];
    i6 = paramArrayOfByte1[(i6 >>> 24)];
    i4 = arrayOfInt2[(i4 >>> 16 & 0xFF)];
    i3 = arrayOfInt3[(i3 >>> 8 & 0xFF)];
    i8 = arrayOfInt4[(i1 & 0xFF)];
    i1 = i7 + 1;
    i6 = i6 ^ i4 ^ i3 ^ i8 ^ arrayOfInt1[i7];
    i4 = paramArrayOfByte1[(paramInt1 >>> 24)];
    i7 = arrayOfInt2[(i6 >>> 16 & 0xFF)];
    i8 = arrayOfInt3[(i5 >>> 8 & 0xFF)];
    i9 = arrayOfInt4[(i2 & 0xFF)];
    i3 = i1 + 1;
    i1 = arrayOfInt1[i1] ^ i4 ^ i7 ^ i8 ^ i9;
    i4 = paramArrayOfByte1[(i2 >>> 24)];
    i8 = arrayOfInt2[(paramInt1 >>> 16 & 0xFF)];
    i9 = arrayOfInt3[(i6 >>> 8 & 0xFF)];
    i10 = arrayOfInt4[(i5 & 0xFF)];
    i7 = i3 + 1;
    i3 = i4 ^ i8 ^ i9 ^ i10 ^ arrayOfInt1[i3];
    i4 = paramArrayOfByte1[(i5 >>> 24)] ^ arrayOfInt2[(i2 >>> 16 & 0xFF)] ^ arrayOfInt3[(paramInt1 >>> 8 & 0xFF)] ^ arrayOfInt4[(i6 & 0xFF)] ^ arrayOfInt1[i7];
    paramInt1 = paramArrayOfByte1[(i6 >>> 24)] ^ arrayOfInt2[(i5 >>> 16 & 0xFF)] ^ arrayOfInt3[(i2 >>> 8 & 0xFF)] ^ arrayOfInt4[(paramInt1 & 0xFF)] ^ arrayOfInt1[(i7 + 1)];
    i2 = arrayOfInt1[0];
    i5 = paramInt2 + 1;
    paramArrayOfByte1 = j;
    paramArrayOfByte2[paramInt2] = ((byte)(paramArrayOfByte1[(i1 >>> 24)] ^ i2 >>> 24));
    paramInt2 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramArrayOfByte1[(paramInt1 >>> 16 & 0xFF)] ^ i2 >>> 16));
    i6 = paramInt2 + 1;
    paramArrayOfByte2[paramInt2] = ((byte)(paramArrayOfByte1[(i4 >>> 8 & 0xFF)] ^ i2 >>> 8));
    i5 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(i2 ^ paramArrayOfByte1[(i3 & 0xFF)]));
    paramInt2 = arrayOfInt1[1];
    i2 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramArrayOfByte1[(i3 >>> 24)] ^ paramInt2 >>> 24));
    i5 = i2 + 1;
    paramArrayOfByte2[i2] = ((byte)(paramArrayOfByte1[(i1 >>> 16 & 0xFF)] ^ paramInt2 >>> 16));
    i6 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramArrayOfByte1[(paramInt1 >>> 8 & 0xFF)] ^ paramInt2 >>> 8));
    i2 = i6 + 1;
    paramArrayOfByte2[i6] = ((byte)(paramInt2 ^ paramArrayOfByte1[(i4 & 0xFF)]));
    paramInt2 = arrayOfInt1[2];
    i5 = i2 + 1;
    paramArrayOfByte2[i2] = ((byte)(paramArrayOfByte1[(i4 >>> 24)] ^ paramInt2 >>> 24));
    i2 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramArrayOfByte1[(i3 >>> 16 & 0xFF)] ^ paramInt2 >>> 16));
    i5 = i2 + 1;
    paramArrayOfByte2[i2] = ((byte)(paramArrayOfByte1[(i1 >>> 8 & 0xFF)] ^ paramInt2 >>> 8));
    i2 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramInt2 ^ paramArrayOfByte1[(paramInt1 & 0xFF)]));
    paramInt2 = arrayOfInt1[3];
    i5 = i2 + 1;
    paramArrayOfByte2[i2] = ((byte)(paramArrayOfByte1[(paramInt1 >>> 24)] ^ paramInt2 >>> 24));
    paramInt1 = i5 + 1;
    paramArrayOfByte2[i5] = ((byte)(paramArrayOfByte1[(i4 >>> 16 & 0xFF)] ^ paramInt2 >>> 16));
    paramArrayOfByte2[paramInt1] = ((byte)(paramArrayOfByte1[(i3 >>> 8 & 0xFF)] ^ paramInt2 >>> 8));
    paramArrayOfByte2[(paramInt1 + 1)] = ((byte)(paramArrayOfByte1[(i1 & 0xFF)] ^ paramInt2));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.b
 * JD-Core Version:    0.7.0.1
 */