package org.webrtc;

public abstract interface SSLCertificateVerifier
{
  @CalledByNative
  public abstract boolean verify(byte[] paramArrayOfByte);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SSLCertificateVerifier
 * JD-Core Version:    0.7.0.1
 */