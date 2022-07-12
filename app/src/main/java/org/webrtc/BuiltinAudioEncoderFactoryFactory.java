package org.webrtc;

public class BuiltinAudioEncoderFactoryFactory
  implements AudioEncoderFactoryFactory
{
  private static native long nativeCreateBuiltinAudioEncoderFactory();
  
  public long createNativeAudioEncoderFactory()
  {
    return nativeCreateBuiltinAudioEncoderFactory();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.BuiltinAudioEncoderFactoryFactory
 * JD-Core Version:    0.7.0.1
 */