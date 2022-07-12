package org.webrtc;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NetworkMonitor
{
  private static final String TAG = "NetworkMonitor";
  private volatile NetworkChangeDetector.ConnectionType currentConnectionType = NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN;
  private final ArrayList<Long> nativeNetworkObservers = new ArrayList();
  private NetworkChangeDetector networkChangeDetector;
  private NetworkChangeDetectorFactory networkChangeDetectorFactory = new NetworkChangeDetectorFactory()
  {
    public NetworkChangeDetector create(NetworkChangeDetector.Observer paramAnonymousObserver, Context paramAnonymousContext)
    {
      return new NetworkMonitorAutoDetect(paramAnonymousObserver, paramAnonymousContext);
    }
  };
  private final Object networkChangeDetectorLock = new Object();
  private final ArrayList<NetworkObserver> networkObservers = new ArrayList();
  private int numObservers = 0;
  
  @Deprecated
  public static void addNetworkObserver(NetworkObserver paramNetworkObserver)
  {
    getInstance().addObserver(paramNetworkObserver);
  }
  
  @CalledByNative
  private static int androidSdkInt()
  {
    return Build.VERSION.SDK_INT;
  }
  
  private static void assertIsTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError("Expected to be true");
  }
  
  static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context paramContext)
  {
    NetworkMonitor localNetworkMonitor = getInstance();
    paramContext = localNetworkMonitor.createNetworkChangeDetector(paramContext);
    localNetworkMonitor.networkChangeDetector = paramContext;
    return (NetworkMonitorAutoDetect)paramContext;
  }
  
  private NetworkChangeDetector createNetworkChangeDetector(Context paramContext)
  {
    this.networkChangeDetectorFactory.create(new NetworkChangeDetector.Observer()
    {
      public void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType paramAnonymousConnectionType)
      {
        NetworkMonitor.this.updateCurrentConnectionType(paramAnonymousConnectionType);
      }
      
      public void onNetworkConnect(NetworkChangeDetector.NetworkInformation paramAnonymousNetworkInformation)
      {
        NetworkMonitor.this.notifyObserversOfNetworkConnect(paramAnonymousNetworkInformation);
      }
      
      public void onNetworkDisconnect(long paramAnonymousLong)
      {
        NetworkMonitor.this.notifyObserversOfNetworkDisconnect(paramAnonymousLong);
      }
      
      public void onNetworkPreference(List<NetworkChangeDetector.ConnectionType> paramAnonymousList, int paramAnonymousInt)
      {
        NetworkMonitor.this.notifyObserversOfNetworkPreference(paramAnonymousList, paramAnonymousInt);
      }
    }, paramContext);
  }
  
  private NetworkChangeDetector.ConnectionType getCurrentConnectionType()
  {
    return this.currentConnectionType;
  }
  
  @CalledByNative
  public static NetworkMonitor getInstance()
  {
    return InstanceHolder.instance;
  }
  
  private List<Long> getNativeNetworkObserversSync()
  {
    synchronized (this.nativeNetworkObservers)
    {
      ArrayList localArrayList2 = new ArrayList(this.nativeNetworkObservers);
      return localArrayList2;
    }
  }
  
  @Deprecated
  public static void init(Context paramContext) {}
  
  public static boolean isOnline()
  {
    return getInstance().getCurrentConnectionType() != NetworkChangeDetector.ConnectionType.CONNECTION_NONE;
  }
  
  private native void nativeNotifyConnectionTypeChanged(long paramLong);
  
  private native void nativeNotifyOfActiveNetworkList(long paramLong, NetworkChangeDetector.NetworkInformation[] paramArrayOfNetworkInformation);
  
  private native void nativeNotifyOfNetworkConnect(long paramLong, NetworkChangeDetector.NetworkInformation paramNetworkInformation);
  
  private native void nativeNotifyOfNetworkDisconnect(long paramLong1, long paramLong2);
  
  private native void nativeNotifyOfNetworkPreference(long paramLong, NetworkChangeDetector.ConnectionType paramConnectionType, int paramInt);
  
  @CalledByNative
  private boolean networkBindingSupported()
  {
    for (;;)
    {
      synchronized (this.networkChangeDetectorLock)
      {
        NetworkChangeDetector localNetworkChangeDetector = this.networkChangeDetector;
        if ((localNetworkChangeDetector != null) && (localNetworkChangeDetector.supportNetworkCallback()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void notifyObserversOfConnectionTypeChange(NetworkChangeDetector.ConnectionType paramConnectionType)
  {
    ??? = getNativeNetworkObserversSync().iterator();
    while (((Iterator)???).hasNext()) {
      nativeNotifyConnectionTypeChanged(((Long)((Iterator)???).next()).longValue());
    }
    synchronized (this.networkObservers)
    {
      ArrayList localArrayList = new ArrayList(this.networkObservers);
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((NetworkObserver)((Iterator)???).next()).onConnectionTypeChanged(paramConnectionType);
      }
      return;
    }
  }
  
  private void notifyObserversOfNetworkConnect(NetworkChangeDetector.NetworkInformation paramNetworkInformation)
  {
    Iterator localIterator = getNativeNetworkObserversSync().iterator();
    while (localIterator.hasNext()) {
      nativeNotifyOfNetworkConnect(((Long)localIterator.next()).longValue(), paramNetworkInformation);
    }
  }
  
  private void notifyObserversOfNetworkDisconnect(long paramLong)
  {
    Iterator localIterator = getNativeNetworkObserversSync().iterator();
    while (localIterator.hasNext()) {
      nativeNotifyOfNetworkDisconnect(((Long)localIterator.next()).longValue(), paramLong);
    }
  }
  
  private void notifyObserversOfNetworkPreference(List<NetworkChangeDetector.ConnectionType> paramList, int paramInt)
  {
    List localList = getNativeNetworkObserversSync();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      NetworkChangeDetector.ConnectionType localConnectionType = (NetworkChangeDetector.ConnectionType)paramList.next();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        nativeNotifyOfNetworkPreference(((Long)localIterator.next()).longValue(), localConnectionType, paramInt);
      }
    }
  }
  
  @Deprecated
  public static void removeNetworkObserver(NetworkObserver paramNetworkObserver)
  {
    getInstance().removeObserver(paramNetworkObserver);
  }
  
  @CalledByNative
  private void startMonitoring(Context arg1, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start monitoring with native observer ");
    localStringBuilder.append(paramLong);
    Logging.d("NetworkMonitor", localStringBuilder.toString());
    if (??? == null) {
      ??? = ContextUtils.getApplicationContext();
    }
    startMonitoring(???);
    synchronized (this.nativeNetworkObservers)
    {
      this.nativeNetworkObservers.add(Long.valueOf(paramLong));
      updateObserverActiveNetworkList(paramLong);
      notifyObserversOfConnectionTypeChange(this.currentConnectionType);
      return;
    }
  }
  
  @CalledByNative
  private void stopMonitoring(long paramLong)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Stop monitoring with native observer ");
    ((StringBuilder)???).append(paramLong);
    Logging.d("NetworkMonitor", ((StringBuilder)???).toString());
    stopMonitoring();
    synchronized (this.nativeNetworkObservers)
    {
      this.nativeNetworkObservers.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  private void updateCurrentConnectionType(NetworkChangeDetector.ConnectionType paramConnectionType)
  {
    this.currentConnectionType = paramConnectionType;
    notifyObserversOfConnectionTypeChange(paramConnectionType);
  }
  
  private void updateObserverActiveNetworkList(long paramLong)
  {
    synchronized (this.networkChangeDetectorLock)
    {
      Object localObject1 = this.networkChangeDetector;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((NetworkChangeDetector)localObject1).getActiveNetworkList();
      }
      if (localObject1 != null)
      {
        if (((List)localObject1).size() == 0) {
          return;
        }
        nativeNotifyOfActiveNetworkList(paramLong, (NetworkChangeDetector.NetworkInformation[])((List)localObject1).toArray(new NetworkChangeDetector.NetworkInformation[((List)localObject1).size()]));
      }
      return;
    }
  }
  
  public void addObserver(NetworkObserver paramNetworkObserver)
  {
    synchronized (this.networkObservers)
    {
      this.networkObservers.add(paramNetworkObserver);
      return;
    }
  }
  
  NetworkChangeDetector getNetworkChangeDetector()
  {
    synchronized (this.networkChangeDetectorLock)
    {
      NetworkChangeDetector localNetworkChangeDetector = this.networkChangeDetector;
      return localNetworkChangeDetector;
    }
  }
  
  int getNumObservers()
  {
    synchronized (this.networkChangeDetectorLock)
    {
      int i = this.numObservers;
      return i;
    }
  }
  
  public void removeObserver(NetworkObserver paramNetworkObserver)
  {
    synchronized (this.networkObservers)
    {
      this.networkObservers.remove(paramNetworkObserver);
      return;
    }
  }
  
  public void setNetworkChangeDetectorFactory(NetworkChangeDetectorFactory paramNetworkChangeDetectorFactory)
  {
    boolean bool;
    if (this.numObservers == 0) {
      bool = true;
    } else {
      bool = false;
    }
    assertIsTrue(bool);
    this.networkChangeDetectorFactory = paramNetworkChangeDetectorFactory;
  }
  
  @Deprecated
  public void startMonitoring()
  {
    startMonitoring(ContextUtils.getApplicationContext());
  }
  
  public void startMonitoring(Context paramContext)
  {
    synchronized (this.networkChangeDetectorLock)
    {
      this.numObservers += 1;
      if (this.networkChangeDetector == null) {
        this.networkChangeDetector = createNetworkChangeDetector(paramContext);
      }
      this.currentConnectionType = this.networkChangeDetector.getCurrentConnectionType();
      return;
    }
  }
  
  public void stopMonitoring()
  {
    synchronized (this.networkChangeDetectorLock)
    {
      int i = this.numObservers - 1;
      this.numObservers = i;
      if (i == 0)
      {
        this.networkChangeDetector.destroy();
        this.networkChangeDetector = null;
      }
      return;
    }
  }
  
  private static class InstanceHolder
  {
    static final NetworkMonitor instance = new NetworkMonitor(null);
  }
  
  public static abstract interface NetworkObserver
  {
    public abstract void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType paramConnectionType);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NetworkMonitor
 * JD-Core Version:    0.7.0.1
 */