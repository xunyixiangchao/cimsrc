package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class g
  extends FilterInputStream
{
  private static final byte[] c;
  private static final int d;
  private static final int e;
  private final byte a;
  private int b;
  
  static
  {
    byte[] arrayOfByte = new byte[29];
    byte[] tmp6_5 = arrayOfByte;
    tmp6_5[0] = -1;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = -31;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 28;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 69;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 120;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 105;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 102;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 0;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 0;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 77;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 77;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 0;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 0;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 0;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 0;
    byte[] tmp96_90 = tmp90_84;
    tmp96_90[16] = 0;
    byte[] tmp102_96 = tmp96_90;
    tmp102_96[17] = 8;
    byte[] tmp108_102 = tmp102_96;
    tmp108_102[18] = 0;
    byte[] tmp114_108 = tmp108_102;
    tmp114_108[19] = 1;
    byte[] tmp120_114 = tmp114_108;
    tmp120_114[20] = 1;
    byte[] tmp126_120 = tmp120_114;
    tmp126_120[21] = 18;
    byte[] tmp132_126 = tmp126_120;
    tmp132_126[22] = 0;
    byte[] tmp138_132 = tmp132_126;
    tmp138_132[23] = 2;
    byte[] tmp144_138 = tmp138_132;
    tmp144_138[24] = 0;
    byte[] tmp150_144 = tmp144_138;
    tmp150_144[25] = 0;
    byte[] tmp156_150 = tmp150_144;
    tmp156_150[26] = 0;
    byte[] tmp162_156 = tmp156_150;
    tmp162_156[27] = 1;
    byte[] tmp168_162 = tmp162_156;
    tmp168_162[28] = 0;
    tmp168_162;
    c = arrayOfByte;
    int i = arrayOfByte.length;
    d = i;
    e = i + 2;
  }
  
  public g(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if ((paramInt >= -1) && (paramInt <= 8))
    {
      this.a = ((byte)paramInt);
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Cannot add invalid orientation: ");
    paramInputStream.append(paramInt);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
  {
    int i = this.b;
    if (i >= 2)
    {
      int j = e;
      if (i <= j)
      {
        if (i == j)
        {
          i = this.a;
          break label55;
        }
        i = c[(i - 2)] & 0xFF;
        break label55;
      }
    }
    i = super.read();
    label55:
    if (i != -1) {
      this.b += 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.b;
    int j = e;
    if (i > j)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    else if (i == j)
    {
      paramArrayOfByte[paramInt1] = this.a;
      paramInt1 = 1;
    }
    else if (i < 2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, 2 - i);
    }
    else
    {
      paramInt2 = Math.min(j - i, paramInt2);
      System.arraycopy(c, this.b - 2, paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    }
    if (paramInt1 > 0) {
      this.b += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
  {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong)
  {
    paramLong = super.skip(paramLong);
    if (paramLong > 0L) {
      this.b = ((int)(this.b + paramLong));
    }
    return paramLong;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.g
 * JD-Core Version:    0.7.0.1
 */