package com.baidu.platform.comapi.bmsdk;

public abstract class BmObject
{
  protected final long a;
  
  private BmObject()
  {
    this.a = 0L;
  }
  
  public BmObject(int paramInt, long paramLong)
  {
    this.a = paramLong;
  }
  
  private void a()
  {
    long l = this.a;
    if (l != 0L) {
      nativeFinalizer(l);
    }
  }
  
  private static native void nativeFinalizer(long paramLong);
  
  public long b()
  {
    return this.a;
  }
  
  protected void finalize()
  {
    try
    {
      a();
      label4:
      super.finalize();
      return;
    }
    finally
    {
      break label4;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.bmsdk.BmObject
 * JD-Core Version:    0.7.0.1
 */