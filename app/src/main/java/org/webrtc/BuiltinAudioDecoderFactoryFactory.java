package org.webrtc;

public class BuiltinAudioDecoderFactoryFactory
  implements AudioDecoderFactoryFactory
{
  private static native long nativeCreateBuiltinAudioDecoderFactory();
  
  public long createNativeAudioDecoderFactory()
  {
    return nativeCreateBuiltinAudioDecoderFactory();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.BuiltinAudioDecoderFactoryFactory
 * JD-Core Version:    0.7.0.1
 */