package p1;

import java.io.Closeable;

public abstract interface i
  extends Closeable
{
  public abstract void A(int paramInt, double paramDouble);
  
  public abstract void O(int paramInt, long paramLong);
  
  public abstract void S(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void r(int paramInt, String paramString);
  
  public abstract void y(int paramInt);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.i
 * JD-Core Version:    0.7.0.1
 */