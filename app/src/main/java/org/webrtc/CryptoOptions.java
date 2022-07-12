package org.webrtc;

public final class CryptoOptions
{
  private final SFrame sframe;
  private final Srtp srtp;
  
  private CryptoOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.srtp = new Srtp(paramBoolean1, paramBoolean2, paramBoolean3, null);
    this.sframe = new SFrame(paramBoolean4, null);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  @CalledByNative
  public SFrame getSFrame()
  {
    return this.sframe;
  }
  
  @CalledByNative
  public Srtp getSrtp()
  {
    return this.srtp;
  }
  
  public static class Builder
  {
    private boolean enableAes128Sha1_32CryptoCipher;
    private boolean enableEncryptedRtpHeaderExtensions;
    private boolean enableGcmCryptoSuites;
    private boolean requireFrameEncryption;
    
    public CryptoOptions createCryptoOptions()
    {
      return new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption, null);
    }
    
    public Builder setEnableAes128Sha1_32CryptoCipher(boolean paramBoolean)
    {
      this.enableAes128Sha1_32CryptoCipher = paramBoolean;
      return this;
    }
    
    public Builder setEnableEncryptedRtpHeaderExtensions(boolean paramBoolean)
    {
      this.enableEncryptedRtpHeaderExtensions = paramBoolean;
      return this;
    }
    
    public Builder setEnableGcmCryptoSuites(boolean paramBoolean)
    {
      this.enableGcmCryptoSuites = paramBoolean;
      return this;
    }
    
    public Builder setRequireFrameEncryption(boolean paramBoolean)
    {
      this.requireFrameEncryption = paramBoolean;
      return this;
    }
  }
  
  public final class SFrame
  {
    private final boolean requireFrameEncryption;
    
    private SFrame(boolean paramBoolean)
    {
      this.requireFrameEncryption = paramBoolean;
    }
    
    @CalledByNative("SFrame")
    public boolean getRequireFrameEncryption()
    {
      return this.requireFrameEncryption;
    }
  }
  
  public final class Srtp
  {
    private final boolean enableAes128Sha1_32CryptoCipher;
    private final boolean enableEncryptedRtpHeaderExtensions;
    private final boolean enableGcmCryptoSuites;
    
    private Srtp(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.enableGcmCryptoSuites = paramBoolean1;
      this.enableAes128Sha1_32CryptoCipher = paramBoolean2;
      this.enableEncryptedRtpHeaderExtensions = paramBoolean3;
    }
    
    @CalledByNative("Srtp")
    public boolean getEnableAes128Sha1_32CryptoCipher()
    {
      return this.enableAes128Sha1_32CryptoCipher;
    }
    
    @CalledByNative("Srtp")
    public boolean getEnableEncryptedRtpHeaderExtensions()
    {
      return this.enableEncryptedRtpHeaderExtensions;
    }
    
    @CalledByNative("Srtp")
    public boolean getEnableGcmCryptoSuites()
    {
      return this.enableGcmCryptoSuites;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.CryptoOptions
 * JD-Core Version:    0.7.0.1
 */