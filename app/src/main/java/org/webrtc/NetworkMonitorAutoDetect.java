package org.webrtc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkMonitorAutoDetect
  extends BroadcastReceiver
  implements NetworkChangeDetector
{
  private static final long INVALID_NET_ID = -1L;
  private static final String TAG = "NetworkMonitorAutoDetect";
  private final ConnectivityManager.NetworkCallback allNetworkCallback;
  private NetworkChangeDetector.ConnectionType connectionType;
  private ConnectivityManagerDelegate connectivityManagerDelegate;
  private final Context context;
  private final IntentFilter intentFilter;
  private boolean isRegistered;
  private final ConnectivityManager.NetworkCallback mobileNetworkCallback;
  private final NetworkChangeDetector.Observer observer;
  private WifiDirectManagerDelegate wifiDirectManagerDelegate;
  private WifiManagerDelegate wifiManagerDelegate;
  private String wifiSSID;
  
  @SuppressLint({"NewApi"})
  public NetworkMonitorAutoDetect(NetworkChangeDetector.Observer paramObserver, Context paramContext)
  {
    this.observer = paramObserver;
    this.context = paramContext;
    this.connectivityManagerDelegate = new ConnectivityManagerDelegate(paramContext);
    this.wifiManagerDelegate = new WifiManagerDelegate(paramContext);
    NetworkState localNetworkState = this.connectivityManagerDelegate.getNetworkState();
    this.connectionType = getConnectionType(localNetworkState);
    this.wifiSSID = getWifiSSID(localNetworkState);
    this.intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    if (PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals("Enabled")) {
      this.wifiDirectManagerDelegate = new WifiDirectManagerDelegate(paramObserver, paramContext);
    }
    registerReceiver();
    if (this.connectivityManagerDelegate.supportNetworkCallback()) {
      paramObserver = new ConnectivityManager.NetworkCallback();
    }
    try
    {
      this.connectivityManagerDelegate.requestMobileNetwork(paramObserver);
    }
    catch (SecurityException paramObserver)
    {
      label135:
      break label135;
    }
    Logging.w("NetworkMonitorAutoDetect", "Unable to obtain permission to request a cellular network.");
    paramObserver = null;
    this.mobileNetworkCallback = paramObserver;
    paramObserver = new SimpleNetworkCallback(null);
    this.allNetworkCallback = paramObserver;
    this.connectivityManagerDelegate.registerNetworkCallback(paramObserver);
    return;
    this.mobileNetworkCallback = null;
    this.allNetworkCallback = null;
  }
  
  private void connectionTypeChanged(NetworkState paramNetworkState)
  {
    NetworkChangeDetector.ConnectionType localConnectionType = getConnectionType(paramNetworkState);
    paramNetworkState = getWifiSSID(paramNetworkState);
    if ((localConnectionType == this.connectionType) && (paramNetworkState.equals(this.wifiSSID))) {
      return;
    }
    this.connectionType = localConnectionType;
    this.wifiSSID = paramNetworkState;
    paramNetworkState = new StringBuilder();
    paramNetworkState.append("Network connectivity changed, type is: ");
    paramNetworkState.append(this.connectionType);
    Logging.d("NetworkMonitorAutoDetect", paramNetworkState.toString());
    this.observer.onConnectionTypeChanged(localConnectionType);
  }
  
  public static NetworkChangeDetector.ConnectionType getConnectionType(NetworkState paramNetworkState)
  {
    return getConnectionType(paramNetworkState.isConnected(), paramNetworkState.getNetworkType(), paramNetworkState.getNetworkSubType());
  }
  
  private static NetworkChangeDetector.ConnectionType getConnectionType(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      return NetworkChangeDetector.ConnectionType.CONNECTION_NONE;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 6)
        {
          if (paramInt1 != 7)
          {
            if (paramInt1 != 9)
            {
              if (paramInt1 != 17) {
                return NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN;
              }
              return NetworkChangeDetector.ConnectionType.CONNECTION_VPN;
            }
            return NetworkChangeDetector.ConnectionType.CONNECTION_ETHERNET;
          }
          return NetworkChangeDetector.ConnectionType.CONNECTION_BLUETOOTH;
        }
        return NetworkChangeDetector.ConnectionType.CONNECTION_4G;
      }
      return NetworkChangeDetector.ConnectionType.CONNECTION_WIFI;
    }
    switch (paramInt2)
    {
    case 19: 
    default: 
      return NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
    case 20: 
      return NetworkChangeDetector.ConnectionType.CONNECTION_5G;
    case 13: 
    case 18: 
      return NetworkChangeDetector.ConnectionType.CONNECTION_4G;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return NetworkChangeDetector.ConnectionType.CONNECTION_3G;
    }
    return NetworkChangeDetector.ConnectionType.CONNECTION_2G;
  }
  
  private static NetworkChangeDetector.ConnectionType getUnderlyingConnectionTypeForVpn(NetworkState paramNetworkState)
  {
    if (paramNetworkState.getNetworkType() != 17) {
      return NetworkChangeDetector.ConnectionType.CONNECTION_NONE;
    }
    return getConnectionType(paramNetworkState.isConnected(), paramNetworkState.getUnderlyingNetworkTypeForVpn(), paramNetworkState.getUnderlyingNetworkSubtypeForVpn());
  }
  
  private String getWifiSSID(NetworkState paramNetworkState)
  {
    if (getConnectionType(paramNetworkState) != NetworkChangeDetector.ConnectionType.CONNECTION_WIFI) {
      return "";
    }
    return this.wifiManagerDelegate.getWifiSSID();
  }
  
  @SuppressLint({"NewApi"})
  private static long networkToNetId(Network paramNetwork)
  {
    return paramNetwork.getNetworkHandle();
  }
  
  private void registerReceiver()
  {
    if (this.isRegistered) {
      return;
    }
    this.isRegistered = true;
    this.context.registerReceiver(this, this.intentFilter);
  }
  
  private void unregisterReceiver()
  {
    if (!this.isRegistered) {
      return;
    }
    this.isRegistered = false;
    this.context.unregisterReceiver(this);
  }
  
  public void destroy()
  {
    Object localObject = this.allNetworkCallback;
    if (localObject != null) {
      this.connectivityManagerDelegate.releaseCallback((ConnectivityManager.NetworkCallback)localObject);
    }
    localObject = this.mobileNetworkCallback;
    if (localObject != null) {
      this.connectivityManagerDelegate.releaseCallback((ConnectivityManager.NetworkCallback)localObject);
    }
    localObject = this.wifiDirectManagerDelegate;
    if (localObject != null) {
      ((WifiDirectManagerDelegate)localObject).release();
    }
    unregisterReceiver();
  }
  
  public List<NetworkChangeDetector.NetworkInformation> getActiveNetworkList()
  {
    Object localObject = this.connectivityManagerDelegate.getActiveNetworkList();
    if (localObject == null) {
      return null;
    }
    localObject = new ArrayList((Collection)localObject);
    WifiDirectManagerDelegate localWifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
    if (localWifiDirectManagerDelegate != null) {
      ((ArrayList)localObject).addAll(localWifiDirectManagerDelegate.getActiveNetworkList());
    }
    return localObject;
  }
  
  public NetworkChangeDetector.ConnectionType getCurrentConnectionType()
  {
    return getConnectionType(getCurrentNetworkState());
  }
  
  public NetworkState getCurrentNetworkState()
  {
    return this.connectivityManagerDelegate.getNetworkState();
  }
  
  public long getDefaultNetId()
  {
    return this.connectivityManagerDelegate.getDefaultNetId();
  }
  
  boolean isReceiverRegisteredForTesting()
  {
    return this.isRegistered;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = getCurrentNetworkState();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      connectionTypeChanged(paramContext);
    }
  }
  
  void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate paramConnectivityManagerDelegate)
  {
    this.connectivityManagerDelegate = paramConnectivityManagerDelegate;
  }
  
  void setWifiManagerDelegateForTests(WifiManagerDelegate paramWifiManagerDelegate)
  {
    this.wifiManagerDelegate = paramWifiManagerDelegate;
  }
  
  public boolean supportNetworkCallback()
  {
    return this.connectivityManagerDelegate.supportNetworkCallback();
  }
  
  static class ConnectivityManagerDelegate
  {
    private final ConnectivityManager connectivityManager;
    
    ConnectivityManagerDelegate()
    {
      this.connectivityManager = null;
    }
    
    ConnectivityManagerDelegate(Context paramContext)
    {
      this.connectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    }
    
    private NetworkMonitorAutoDetect.NetworkState getNetworkState(NetworkInfo paramNetworkInfo)
    {
      if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected())) {
        return new NetworkMonitorAutoDetect.NetworkState(true, paramNetworkInfo.getType(), paramNetworkInfo.getSubtype(), -1, -1);
      }
      return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
    }
    
    @SuppressLint({"NewApi"})
    private NetworkChangeDetector.NetworkInformation networkToInfo(Network paramNetwork)
    {
      Object localObject1 = null;
      if (paramNetwork != null)
      {
        localObject1 = this.connectivityManager;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(paramNetwork);
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Detected unknown network: ");
          ((StringBuilder)localObject1).append(paramNetwork.toString());
          Logging.w("NetworkMonitorAutoDetect", ((StringBuilder)localObject1).toString());
          return null;
        }
        if (((LinkProperties)localObject1).getInterfaceName() == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Null interface name for network ");
          ((StringBuilder)localObject1).append(paramNetwork.toString());
          Logging.w("NetworkMonitorAutoDetect", ((StringBuilder)localObject1).toString());
          return null;
        }
        Object localObject2 = getNetworkState(paramNetwork);
        NetworkChangeDetector.ConnectionType localConnectionType = NetworkMonitorAutoDetect.getConnectionType((NetworkMonitorAutoDetect.NetworkState)localObject2);
        if (localConnectionType == NetworkChangeDetector.ConnectionType.CONNECTION_NONE)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Network ");
          ((StringBuilder)localObject1).append(paramNetwork.toString());
          ((StringBuilder)localObject1).append(" is disconnected");
          Logging.d("NetworkMonitorAutoDetect", ((StringBuilder)localObject1).toString());
          return null;
        }
        if ((localConnectionType == NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN) || (localConnectionType == NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN_CELLULAR))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Network ");
          localStringBuilder.append(paramNetwork.toString());
          localStringBuilder.append(" connection type is ");
          localStringBuilder.append(localConnectionType);
          localStringBuilder.append(" because it has type ");
          localStringBuilder.append(((NetworkMonitorAutoDetect.NetworkState)localObject2).getNetworkType());
          localStringBuilder.append(" and subtype ");
          localStringBuilder.append(((NetworkMonitorAutoDetect.NetworkState)localObject2).getNetworkSubType());
          Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
        }
        localObject2 = NetworkMonitorAutoDetect.getUnderlyingConnectionTypeForVpn((NetworkMonitorAutoDetect.NetworkState)localObject2);
        localObject1 = new NetworkChangeDetector.NetworkInformation(((LinkProperties)localObject1).getInterfaceName(), localConnectionType, (NetworkChangeDetector.ConnectionType)localObject2, NetworkMonitorAutoDetect.networkToNetId(paramNetwork), getIPAddresses((LinkProperties)localObject1));
      }
      return localObject1;
    }
    
    List<NetworkChangeDetector.NetworkInformation> getActiveNetworkList()
    {
      if (!supportNetworkCallback()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Network[] arrayOfNetwork = getAllNetworks();
      int j = arrayOfNetwork.length;
      int i = 0;
      while (i < j)
      {
        NetworkChangeDetector.NetworkInformation localNetworkInformation = networkToInfo(arrayOfNetwork[i]);
        if (localNetworkInformation != null) {
          localArrayList.add(localNetworkInformation);
        }
        i += 1;
      }
      return localArrayList;
    }
    
    @SuppressLint({"NewApi"})
    Network[] getAllNetworks()
    {
      ConnectivityManager localConnectivityManager = this.connectivityManager;
      if (localConnectivityManager == null) {
        return new Network[0];
      }
      return localConnectivityManager.getAllNetworks();
    }
    
    @SuppressLint({"NewApi"})
    long getDefaultNetId()
    {
      if (!supportNetworkCallback()) {
        return -1L;
      }
      NetworkInfo localNetworkInfo1 = this.connectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo1 == null) {
        return -1L;
      }
      Network[] arrayOfNetwork = getAllNetworks();
      int j = arrayOfNetwork.length;
      int i = 0;
      long l2;
      for (long l1 = -1L; i < j; l1 = l2)
      {
        Network localNetwork = arrayOfNetwork[i];
        if (!hasInternetCapability(localNetwork))
        {
          l2 = l1;
        }
        else
        {
          NetworkInfo localNetworkInfo2 = this.connectivityManager.getNetworkInfo(localNetwork);
          l2 = l1;
          if (localNetworkInfo2 != null)
          {
            l2 = l1;
            if (localNetworkInfo2.getType() == localNetworkInfo1.getType()) {
              if (l1 == -1L) {
                l2 = NetworkMonitorAutoDetect.networkToNetId(localNetwork);
              } else {
                throw new RuntimeException("Multiple connected networks of same type are not supported.");
              }
            }
          }
        }
        i += 1;
      }
      return l1;
    }
    
    @SuppressLint({"NewApi"})
    NetworkChangeDetector.IPAddress[] getIPAddresses(LinkProperties paramLinkProperties)
    {
      NetworkChangeDetector.IPAddress[] arrayOfIPAddress = new NetworkChangeDetector.IPAddress[paramLinkProperties.getLinkAddresses().size()];
      paramLinkProperties = paramLinkProperties.getLinkAddresses().iterator();
      int i = 0;
      while (paramLinkProperties.hasNext())
      {
        arrayOfIPAddress[i] = new NetworkChangeDetector.IPAddress(((LinkAddress)paramLinkProperties.next()).getAddress().getAddress());
        i += 1;
      }
      return arrayOfIPAddress;
    }
    
    NetworkMonitorAutoDetect.NetworkState getNetworkState()
    {
      ConnectivityManager localConnectivityManager = this.connectivityManager;
      if (localConnectivityManager == null) {
        return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
      }
      return getNetworkState(localConnectivityManager.getActiveNetworkInfo());
    }
    
    @SuppressLint({"NewApi"})
    NetworkMonitorAutoDetect.NetworkState getNetworkState(Network paramNetwork)
    {
      if (paramNetwork != null)
      {
        Object localObject = this.connectivityManager;
        if (localObject != null)
        {
          localObject = ((ConnectivityManager)localObject).getNetworkInfo(paramNetwork);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Couldn't retrieve information from network ");
            ((StringBuilder)localObject).append(paramNetwork.toString());
            Logging.w("NetworkMonitorAutoDetect", ((StringBuilder)localObject).toString());
            return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
          }
          if (((NetworkInfo)localObject).getType() != 17)
          {
            paramNetwork = this.connectivityManager.getNetworkCapabilities(paramNetwork);
            if ((paramNetwork != null) && (paramNetwork.hasTransport(4))) {
              return new NetworkMonitorAutoDetect.NetworkState(((NetworkInfo)localObject).isConnected(), 17, -1, ((NetworkInfo)localObject).getType(), ((NetworkInfo)localObject).getSubtype());
            }
            return getNetworkState((NetworkInfo)localObject);
          }
          if (((NetworkInfo)localObject).getType() == 17)
          {
            if (paramNetwork.equals(this.connectivityManager.getActiveNetwork()))
            {
              paramNetwork = this.connectivityManager.getActiveNetworkInfo();
              if ((paramNetwork != null) && (paramNetwork.getType() != 17)) {
                return new NetworkMonitorAutoDetect.NetworkState(((NetworkInfo)localObject).isConnected(), 17, -1, paramNetwork.getType(), paramNetwork.getSubtype());
              }
            }
            return new NetworkMonitorAutoDetect.NetworkState(((NetworkInfo)localObject).isConnected(), 17, -1, -1, -1);
          }
          return getNetworkState((NetworkInfo)localObject);
        }
      }
      return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
    }
    
    @SuppressLint({"NewApi"})
    boolean hasInternetCapability(Network paramNetwork)
    {
      ConnectivityManager localConnectivityManager = this.connectivityManager;
      boolean bool2 = false;
      if (localConnectivityManager == null) {
        return false;
      }
      paramNetwork = localConnectivityManager.getNetworkCapabilities(paramNetwork);
      boolean bool1 = bool2;
      if (paramNetwork != null)
      {
        bool1 = bool2;
        if (paramNetwork.hasCapability(12)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    @SuppressLint({"NewApi"})
    public void registerNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), paramNetworkCallback);
    }
    
    @SuppressLint({"NewApi"})
    public void releaseCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      if (supportNetworkCallback())
      {
        Logging.d("NetworkMonitorAutoDetect", "Unregister network callback");
        this.connectivityManager.unregisterNetworkCallback(paramNetworkCallback);
      }
    }
    
    @SuppressLint({"NewApi"})
    public void requestMobileNetwork(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
      localBuilder.addCapability(12).addTransportType(0);
      this.connectivityManager.requestNetwork(localBuilder.build(), paramNetworkCallback);
    }
    
    public boolean supportNetworkCallback()
    {
      return this.connectivityManager != null;
    }
  }
  
  static class NetworkState
  {
    private final boolean connected;
    private final int subtype;
    private final int type;
    private final int underlyingNetworkSubtypeForVpn;
    private final int underlyingNetworkTypeForVpn;
    
    public NetworkState(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.connected = paramBoolean;
      this.type = paramInt1;
      this.subtype = paramInt2;
      this.underlyingNetworkTypeForVpn = paramInt3;
      this.underlyingNetworkSubtypeForVpn = paramInt4;
    }
    
    public int getNetworkSubType()
    {
      return this.subtype;
    }
    
    public int getNetworkType()
    {
      return this.type;
    }
    
    public int getUnderlyingNetworkSubtypeForVpn()
    {
      return this.underlyingNetworkSubtypeForVpn;
    }
    
    public int getUnderlyingNetworkTypeForVpn()
    {
      return this.underlyingNetworkTypeForVpn;
    }
    
    public boolean isConnected()
    {
      return this.connected;
    }
  }
  
  @SuppressLint({"NewApi"})
  private class SimpleNetworkCallback
    extends ConnectivityManager.NetworkCallback
  {
    private SimpleNetworkCallback() {}
    
    private void onNetworkChanged(Network paramNetwork)
    {
      paramNetwork = NetworkMonitorAutoDetect.this.connectivityManagerDelegate.networkToInfo(paramNetwork);
      if (paramNetwork != null) {
        NetworkMonitorAutoDetect.this.observer.onNetworkConnect(paramNetwork);
      }
    }
    
    public void onAvailable(Network paramNetwork)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Network becomes available: ");
      localStringBuilder.append(paramNetwork.toString());
      Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
      onNetworkChanged(paramNetwork);
    }
    
    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("capabilities changed: ");
      localStringBuilder.append(paramNetworkCapabilities.toString());
      Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
      onNetworkChanged(paramNetwork);
    }
    
    public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("link properties changed: ");
      localStringBuilder.append(paramLinkProperties.toString());
      Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
      onNetworkChanged(paramNetwork);
    }
    
    public void onLosing(Network paramNetwork, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Network ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" is about to lose in ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("ms");
      Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
    }
    
    public void onLost(Network paramNetwork)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Network ");
      localStringBuilder.append(paramNetwork.toString());
      localStringBuilder.append(" is disconnected");
      Logging.d("NetworkMonitorAutoDetect", localStringBuilder.toString());
      NetworkMonitorAutoDetect.this.observer.onNetworkDisconnect(NetworkMonitorAutoDetect.networkToNetId(paramNetwork));
    }
  }
  
  static class WifiDirectManagerDelegate
    extends BroadcastReceiver
  {
    private static final int WIFI_P2P_NETWORK_HANDLE = 0;
    private final Context context;
    private final NetworkChangeDetector.Observer observer;
    private NetworkChangeDetector.NetworkInformation wifiP2pNetworkInfo;
    
    WifiDirectManagerDelegate(NetworkChangeDetector.Observer paramObserver, Context paramContext)
    {
      this.context = paramContext;
      this.observer = paramObserver;
      paramObserver = new IntentFilter();
      paramObserver.addAction("android.net.wifi.p2p.STATE_CHANGED");
      paramObserver.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
      paramContext.registerReceiver(this, paramObserver);
      if (Build.VERSION.SDK_INT > 28)
      {
        paramObserver = (WifiP2pManager)paramContext.getSystemService("wifip2p");
        paramObserver.requestGroupInfo(paramObserver.initialize(paramContext, paramContext.getMainLooper(), null), new u(this));
      }
    }
    
    private void onWifiP2pGroupChange(WifiP2pGroup paramWifiP2pGroup)
    {
      if (paramWifiP2pGroup != null)
      {
        if (paramWifiP2pGroup.getInterface() == null) {
          return;
        }
        try
        {
          Object localObject = NetworkInterface.getByName(paramWifiP2pGroup.getInterface());
          localObject = Collections.list(((NetworkInterface)localObject).getInetAddresses());
          NetworkChangeDetector.IPAddress[] arrayOfIPAddress = new NetworkChangeDetector.IPAddress[((List)localObject).size()];
          int i = 0;
          while (i < ((List)localObject).size())
          {
            arrayOfIPAddress[i] = new NetworkChangeDetector.IPAddress(((InetAddress)((List)localObject).get(i)).getAddress());
            i += 1;
          }
          paramWifiP2pGroup = new NetworkChangeDetector.NetworkInformation(paramWifiP2pGroup.getInterface(), NetworkChangeDetector.ConnectionType.CONNECTION_WIFI, NetworkChangeDetector.ConnectionType.CONNECTION_NONE, 0L, arrayOfIPAddress);
          this.wifiP2pNetworkInfo = paramWifiP2pGroup;
          this.observer.onNetworkConnect(paramWifiP2pGroup);
          return;
        }
        catch (SocketException paramWifiP2pGroup)
        {
          Logging.e("NetworkMonitorAutoDetect", "Unable to get WifiP2p network interface", paramWifiP2pGroup);
        }
      }
    }
    
    private void onWifiP2pStateChange(int paramInt)
    {
      if (paramInt == 1)
      {
        this.wifiP2pNetworkInfo = null;
        this.observer.onNetworkDisconnect(0L);
      }
    }
    
    public List<NetworkChangeDetector.NetworkInformation> getActiveNetworkList()
    {
      NetworkChangeDetector.NetworkInformation localNetworkInformation = this.wifiP2pNetworkInfo;
      if (localNetworkInformation != null) {
        return Collections.singletonList(localNetworkInformation);
      }
      return Collections.emptyList();
    }
    
    @SuppressLint({"InlinedApi"})
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(paramIntent.getAction()))
      {
        onWifiP2pGroupChange((WifiP2pGroup)paramIntent.getParcelableExtra("p2pGroupInfo"));
        return;
      }
      if ("android.net.wifi.p2p.STATE_CHANGED".equals(paramIntent.getAction())) {
        onWifiP2pStateChange(paramIntent.getIntExtra("wifi_p2p_state", 0));
      }
    }
    
    public void release()
    {
      this.context.unregisterReceiver(this);
    }
  }
  
  static class WifiManagerDelegate
  {
    private final Context context;
    
    WifiManagerDelegate()
    {
      this.context = null;
    }
    
    WifiManagerDelegate(Context paramContext)
    {
      this.context = paramContext;
    }
    
    String getWifiSSID()
    {
      Object localObject = this.context.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
      if (localObject != null)
      {
        localObject = (WifiInfo)((Intent)localObject).getParcelableExtra("wifiInfo");
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getSSID();
          if (localObject != null) {
            return localObject;
          }
        }
      }
      return "";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NetworkMonitorAutoDetect
 * JD-Core Version:    0.7.0.1
 */