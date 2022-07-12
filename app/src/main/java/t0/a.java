package t0;

public class a
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static long c(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    if (paramLong1 > paramLong3) {
      return paramLong3;
    }
    return paramLong1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t0.a
 * JD-Core Version:    0.7.0.1
 */