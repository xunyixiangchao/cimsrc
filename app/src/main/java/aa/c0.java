package aa;

import a9.f;
import f9.l;

public final class c0
{
  private static final b.a a = new b.a();
  private static final int b = -1234567890;
  
  public static final boolean a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    f.f(paramArrayOfByte1, "a");
    f.f(paramArrayOfByte2, "b");
    if (paramInt3 > 0)
    {
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (paramArrayOfByte1[(i + paramInt1)] != paramArrayOfByte2[(i + paramInt2)]) {
          return false;
        }
        if (j >= paramInt3) {
          break;
        }
      }
    }
    return true;
  }
  
  public static final void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" offset=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" byteCount=");
    localStringBuilder.append(paramLong3);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public static final int c(e parame, int paramInt)
  {
    f.f(parame, "<this>");
    if (paramInt == b) {
      return parame.r();
    }
    return paramInt;
  }
  
  public static final int d(int paramInt)
  {
    return (paramInt & 0xFF) << 24 | (0xFF000000 & paramInt) >>> 24 | (0xFF0000 & paramInt) >>> 8 | (0xFF00 & paramInt) << 8;
  }
  
  public static final short e(short paramShort)
  {
    paramShort &= 0xFFFF;
    return (short)((paramShort & 0xFF) << 8 | (0xFF00 & paramShort) >>> 8);
  }
  
  public static final String f(byte paramByte)
  {
    return l.h(new char[] { ba.b.f()[(paramByte >> 4 & 0xF)], ba.b.f()[(paramByte & 0xF)] });
  }
  
  public static final String g(int paramInt)
  {
    if (paramInt == 0) {
      return "0";
    }
    char[] arrayOfChar = new char[8];
    int i = ba.b.f()[(paramInt >> 28 & 0xF)];
    int j = 0;
    arrayOfChar[0] = i;
    arrayOfChar[1] = ba.b.f()[(paramInt >> 24 & 0xF)];
    arrayOfChar[2] = ba.b.f()[(paramInt >> 20 & 0xF)];
    arrayOfChar[3] = ba.b.f()[(paramInt >> 16 & 0xF)];
    arrayOfChar[4] = ba.b.f()[(paramInt >> 12 & 0xF)];
    arrayOfChar[5] = ba.b.f()[(paramInt >> 8 & 0xF)];
    arrayOfChar[6] = ba.b.f()[(paramInt >> 4 & 0xF)];
    arrayOfChar[7] = ba.b.f()[(paramInt & 0xF)];
    paramInt = j;
    while ((paramInt < 8) && (arrayOfChar[paramInt] == '0')) {
      paramInt += 1;
    }
    return l.i(arrayOfChar, paramInt, 8);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.c0
 * JD-Core Version:    0.7.0.1
 */