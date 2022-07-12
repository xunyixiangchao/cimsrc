package org.webrtc;

import java.util.List;

public abstract interface NetworkChangeDetector
{
  public abstract void destroy();
  
  public abstract List<NetworkInformation> getActiveNetworkList();
  
  public abstract ConnectionType getCurrentConnectionType();
  
  public abstract boolean supportNetworkCallback();
  
  public static enum ConnectionType
  {
    static
    {
      ConnectionType localConnectionType1 = new ConnectionType("CONNECTION_UNKNOWN", 0);
      CONNECTION_UNKNOWN = localConnectionType1;
      ConnectionType localConnectionType2 = new ConnectionType("CONNECTION_ETHERNET", 1);
      CONNECTION_ETHERNET = localConnectionType2;
      ConnectionType localConnectionType3 = new ConnectionType("CONNECTION_WIFI", 2);
      CONNECTION_WIFI = localConnectionType3;
      ConnectionType localConnectionType4 = new ConnectionType("CONNECTION_5G", 3);
      CONNECTION_5G = localConnectionType4;
      ConnectionType localConnectionType5 = new ConnectionType("CONNECTION_4G", 4);
      CONNECTION_4G = localConnectionType5;
      ConnectionType localConnectionType6 = new ConnectionType("CONNECTION_3G", 5);
      CONNECTION_3G = localConnectionType6;
      ConnectionType localConnectionType7 = new ConnectionType("CONNECTION_2G", 6);
      CONNECTION_2G = localConnectionType7;
      ConnectionType localConnectionType8 = new ConnectionType("CONNECTION_UNKNOWN_CELLULAR", 7);
      CONNECTION_UNKNOWN_CELLULAR = localConnectionType8;
      ConnectionType localConnectionType9 = new ConnectionType("CONNECTION_BLUETOOTH", 8);
      CONNECTION_BLUETOOTH = localConnectionType9;
      ConnectionType localConnectionType10 = new ConnectionType("CONNECTION_VPN", 9);
      CONNECTION_VPN = localConnectionType10;
      ConnectionType localConnectionType11 = new ConnectionType("CONNECTION_NONE", 10);
      CONNECTION_NONE = localConnectionType11;
      $VALUES = new ConnectionType[] { localConnectionType1, localConnectionType2, localConnectionType3, localConnectionType4, localConnectionType5, localConnectionType6, localConnectionType7, localConnectionType8, localConnectionType9, localConnectionType10, localConnectionType11 };
    }
    
    private ConnectionType() {}
  }
  
  public static class IPAddress
  {
    public final byte[] address;
    
    public IPAddress(byte[] paramArrayOfByte)
    {
      this.address = paramArrayOfByte;
    }
    
    @CalledByNative("IPAddress")
    private byte[] getAddress()
    {
      return this.address;
    }
  }
  
  public static class NetworkInformation
  {
    public final long handle;
    public final NetworkChangeDetector.IPAddress[] ipAddresses;
    public final String name;
    public final NetworkChangeDetector.ConnectionType type;
    public final NetworkChangeDetector.ConnectionType underlyingTypeForVpn;
    
    public NetworkInformation(String paramString, NetworkChangeDetector.ConnectionType paramConnectionType1, NetworkChangeDetector.ConnectionType paramConnectionType2, long paramLong, NetworkChangeDetector.IPAddress[] paramArrayOfIPAddress)
    {
      this.name = paramString;
      this.type = paramConnectionType1;
      this.underlyingTypeForVpn = paramConnectionType2;
      this.handle = paramLong;
      this.ipAddresses = paramArrayOfIPAddress;
    }
    
    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector.ConnectionType getConnectionType()
    {
      return this.type;
    }
    
    @CalledByNative("NetworkInformation")
    private long getHandle()
    {
      return this.handle;
    }
    
    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector.IPAddress[] getIpAddresses()
    {
      return this.ipAddresses;
    }
    
    @CalledByNative("NetworkInformation")
    private String getName()
    {
      return this.name;
    }
    
    @CalledByNative("NetworkInformation")
    private NetworkChangeDetector.ConnectionType getUnderlyingConnectionTypeForVpn()
    {
      return this.underlyingTypeForVpn;
    }
  }
  
  public static abstract interface Observer
  {
    public abstract void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType paramConnectionType);
    
    public abstract void onNetworkConnect(NetworkChangeDetector.NetworkInformation paramNetworkInformation);
    
    public abstract void onNetworkDisconnect(long paramLong);
    
    public abstract void onNetworkPreference(List<NetworkChangeDetector.ConnectionType> paramList, int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NetworkChangeDetector
 * JD-Core Version:    0.7.0.1
 */