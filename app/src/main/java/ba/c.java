package ba;

import a9.f;
import aa.u;

public final class c
{
  public static final int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    f.f(paramArrayOfInt, "<this>");
    paramInt3 -= 1;
    while (paramInt2 <= paramInt3)
    {
      int i = paramInt2 + paramInt3 >>> 1;
      int j = paramArrayOfInt[i];
      if (j < paramInt1) {
        paramInt2 = i + 1;
      } else if (j > paramInt1) {
        paramInt3 = i - 1;
      } else {
        return i;
      }
    }
    return -paramInt2 - 1;
  }
  
  public static final int b(u paramu, int paramInt)
  {
    f.f(paramu, "<this>");
    paramInt = a(paramu.w(), paramInt + 1, 0, paramu.x().length);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ba.c
 * JD-Core Version:    0.7.0.1
 */