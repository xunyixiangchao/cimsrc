package p8;

import a9.f;
import java.util.Arrays;
import java.util.List;

class i
  extends h
{
  public static <T> List<T> c(T[] paramArrayOfT)
  {
    f.f(paramArrayOfT, "<this>");
    paramArrayOfT = k.a(paramArrayOfT);
    f.e(paramArrayOfT, "asList(this)");
    return paramArrayOfT;
  }
  
  public static byte[] d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    f.f(paramArrayOfByte1, "<this>");
    f.f(paramArrayOfByte2, "destination");
    System.arraycopy(paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfByte2;
  }
  
  public static <T> T[] e(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt1, int paramInt2, int paramInt3)
  {
    f.f(paramArrayOfT1, "<this>");
    f.f(paramArrayOfT2, "destination");
    System.arraycopy(paramArrayOfT1, paramInt2, paramArrayOfT2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfT2;
  }
  
  public static byte[] h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfByte, "<this>");
    g.b(paramInt2, paramArrayOfByte.length);
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    f.e(paramArrayOfByte, "copyOfRange(this, fromIndex, toIndex)");
    return paramArrayOfByte;
  }
  
  public static <T> T[] i(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfT, "<this>");
    g.b(paramInt2, paramArrayOfT.length);
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    f.e(paramArrayOfT, "copyOfRange(this, fromIndex, toIndex)");
    return paramArrayOfT;
  }
  
  public static void j(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfByte, "<this>");
    Arrays.fill(paramArrayOfByte, paramInt1, paramInt2, paramByte);
  }
  
  public static <T> void k(T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfT, "<this>");
    Arrays.fill(paramArrayOfT, paramInt1, paramInt2, paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.i
 * JD-Core Version:    0.7.0.1
 */