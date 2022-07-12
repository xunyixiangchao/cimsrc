package org.webrtc;

import java.nio.ByteBuffer;

public class DataChannel
{
  private long nativeDataChannel;
  private long nativeObserver;
  
  @CalledByNative
  public DataChannel(long paramLong)
  {
    this.nativeDataChannel = paramLong;
  }
  
  private void checkDataChannelExists()
  {
    if (this.nativeDataChannel != 0L) {
      return;
    }
    throw new IllegalStateException("DataChannel has been disposed.");
  }
  
  private native long nativeBufferedAmount();
  
  private native void nativeClose();
  
  private native int nativeId();
  
  private native String nativeLabel();
  
  private native long nativeRegisterObserver(Observer paramObserver);
  
  private native boolean nativeSend(byte[] paramArrayOfByte, boolean paramBoolean);
  
  private native State nativeState();
  
  private native void nativeUnregisterObserver(long paramLong);
  
  public long bufferedAmount()
  {
    checkDataChannelExists();
    return nativeBufferedAmount();
  }
  
  public void close()
  {
    checkDataChannelExists();
    nativeClose();
  }
  
  public void dispose()
  {
    checkDataChannelExists();
    JniCommon.nativeReleaseRef(this.nativeDataChannel);
    this.nativeDataChannel = 0L;
  }
  
  @CalledByNative
  long getNativeDataChannel()
  {
    return this.nativeDataChannel;
  }
  
  public int id()
  {
    checkDataChannelExists();
    return nativeId();
  }
  
  public String label()
  {
    checkDataChannelExists();
    return nativeLabel();
  }
  
  public void registerObserver(Observer paramObserver)
  {
    checkDataChannelExists();
    long l = this.nativeObserver;
    if (l != 0L) {
      nativeUnregisterObserver(l);
    }
    this.nativeObserver = nativeRegisterObserver(paramObserver);
  }
  
  public boolean send(Buffer paramBuffer)
  {
    checkDataChannelExists();
    byte[] arrayOfByte = new byte[paramBuffer.data.remaining()];
    paramBuffer.data.get(arrayOfByte);
    return nativeSend(arrayOfByte, paramBuffer.binary);
  }
  
  public State state()
  {
    checkDataChannelExists();
    return nativeState();
  }
  
  public void unregisterObserver()
  {
    checkDataChannelExists();
    nativeUnregisterObserver(this.nativeObserver);
  }
  
  public static class Buffer
  {
    public final boolean binary;
    public final ByteBuffer data;
    
    @CalledByNative("Buffer")
    public Buffer(ByteBuffer paramByteBuffer, boolean paramBoolean)
    {
      this.data = paramByteBuffer;
      this.binary = paramBoolean;
    }
  }
  
  public static class Init
  {
    public int id = -1;
    public int maxRetransmitTimeMs = -1;
    public int maxRetransmits = -1;
    public boolean negotiated;
    public boolean ordered = true;
    public String protocol = "";
    
    @CalledByNative("Init")
    int getId()
    {
      return this.id;
    }
    
    @CalledByNative("Init")
    int getMaxRetransmitTimeMs()
    {
      return this.maxRetransmitTimeMs;
    }
    
    @CalledByNative("Init")
    int getMaxRetransmits()
    {
      return this.maxRetransmits;
    }
    
    @CalledByNative("Init")
    boolean getNegotiated()
    {
      return this.negotiated;
    }
    
    @CalledByNative("Init")
    boolean getOrdered()
    {
      return this.ordered;
    }
    
    @CalledByNative("Init")
    String getProtocol()
    {
      return this.protocol;
    }
  }
  
  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onBufferedAmountChange(long paramLong);
    
    @CalledByNative("Observer")
    public abstract void onMessage(DataChannel.Buffer paramBuffer);
    
    @CalledByNative("Observer")
    public abstract void onStateChange();
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("CONNECTING", 0);
      CONNECTING = localState1;
      State localState2 = new State("OPEN", 1);
      OPEN = localState2;
      State localState3 = new State("CLOSING", 2);
      CLOSING = localState3;
      State localState4 = new State("CLOSED", 3);
      CLOSED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
    
    private State() {}
    
    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.DataChannel
 * JD-Core Version:    0.7.0.1
 */