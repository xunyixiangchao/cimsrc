package org.webrtc;

public final class PeerConnectionDependencies
{
  private final PeerConnection.Observer observer;
  private final SSLCertificateVerifier sslCertificateVerifier;
  
  private PeerConnectionDependencies(PeerConnection.Observer paramObserver, SSLCertificateVerifier paramSSLCertificateVerifier)
  {
    this.observer = paramObserver;
    this.sslCertificateVerifier = paramSSLCertificateVerifier;
  }
  
  public static Builder builder(PeerConnection.Observer paramObserver)
  {
    return new Builder(paramObserver, null);
  }
  
  PeerConnection.Observer getObserver()
  {
    return this.observer;
  }
  
  SSLCertificateVerifier getSSLCertificateVerifier()
  {
    return this.sslCertificateVerifier;
  }
  
  public static class Builder
  {
    private PeerConnection.Observer observer;
    private SSLCertificateVerifier sslCertificateVerifier;
    
    private Builder(PeerConnection.Observer paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public PeerConnectionDependencies createPeerConnectionDependencies()
    {
      return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier, null);
    }
    
    public Builder setSSLCertificateVerifier(SSLCertificateVerifier paramSSLCertificateVerifier)
    {
      this.sslCertificateVerifier = paramSSLCertificateVerifier;
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.PeerConnectionDependencies
 * JD-Core Version:    0.7.0.1
 */