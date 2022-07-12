package com.baidu.platform.comapi.bmsdk;

public class BmLayer
  extends BmObject
{
  public BmLayer()
  {
    super(1, nativeCreate());
  }
  
  private static native long nativeCreate();
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.bmsdk.BmLayer
 * JD-Core Version:    0.7.0.1
 */