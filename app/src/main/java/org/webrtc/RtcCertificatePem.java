package org.webrtc;

public class RtcCertificatePem
{
  private static final long DEFAULT_EXPIRY = 2592000L;
  public final String certificate;
  public final String privateKey;
  
  @CalledByNative
  public RtcCertificatePem(String paramString1, String paramString2)
  {
    this.privateKey = paramString1;
    this.certificate = paramString2;
  }
  
  public static RtcCertificatePem generateCertificate()
  {
    return nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, 2592000L);
  }
  
  public static RtcCertificatePem generateCertificate(long paramLong)
  {
    return nativeGenerateCertificate(PeerConnection.KeyType.ECDSA, paramLong);
  }
  
  public static RtcCertificatePem generateCertificate(PeerConnection.KeyType paramKeyType)
  {
    return nativeGenerateCertificate(paramKeyType, 2592000L);
  }
  
  public static RtcCertificatePem generateCertificate(PeerConnection.KeyType paramKeyType, long paramLong)
  {
    return nativeGenerateCertificate(paramKeyType, paramLong);
  }
  
  private static native RtcCertificatePem nativeGenerateCertificate(PeerConnection.KeyType paramKeyType, long paramLong);
  
  @CalledByNative
  String getCertificate()
  {
    return this.certificate;
  }
  
  @CalledByNative
  String getPrivateKey()
  {
    return this.privateKey;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RtcCertificatePem
 * JD-Core Version:    0.7.0.1
 */