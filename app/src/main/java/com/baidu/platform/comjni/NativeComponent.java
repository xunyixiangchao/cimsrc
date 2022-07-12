package com.baidu.platform.comjni;

public abstract class NativeComponent
  extends JNIBaseApi
{
  protected volatile long mNativePointer;
  
  public abstract long create();
  
  public abstract int dispose();
  
  protected void finalize()
  {
    dispose();
    super.finalize();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.NativeComponent
 * JD-Core Version:    0.7.0.1
 */