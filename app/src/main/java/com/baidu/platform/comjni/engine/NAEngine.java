package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;

public class NAEngine
  extends NativeComponent
{
  private static LongLinkClient a;
  private static boolean b = false;
  
  public NAEngine()
  {
    create();
  }
  
  public static void a()
  {
    nativeInitClass(new Bundle(), 0);
    b = true;
  }
  
  public static void a(int paramInt)
  {
    nativeMonitorSetLogPriority(paramInt);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    nativeMonitorAddLog(paramInt, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    nativeInitMonitor(paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    nativeEnableMonitor(paramBoolean);
  }
  
  public static void a(String[] paramArrayOfString)
  {
    nativeSetMonitorLogFilter(paramArrayOfString);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!b) {
      a();
    }
    try
    {
      boolean bool = nativeInitEngine(paramContext, paramString);
      return bool;
    }
    finally
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    nativeMonitorSetOutPutType(paramInt);
  }
  
  public static boolean b()
  {
    return nativeStartSocketProc();
  }
  
  public static boolean c()
  {
    try
    {
      LongLinkClient localLongLinkClient = a;
      if (localLongLinkClient != null)
      {
        localLongLinkClient.unRegister(null);
        a.release();
        a = null;
      }
      boolean bool = nativeUninitEngine();
      return bool;
    }
    finally
    {
      label31:
      break label31;
    }
    return false;
  }
  
  public static String getIP(String paramString)
  {
    return nativeGetIP(paramString);
  }
  
  public static boolean initLongLinkClient()
  {
    if (a == null) {}
    try
    {
      a = LongLinkClient.create();
      label12:
      return a != null;
    }
    catch (ComInitException localComInitException)
    {
      break label12;
    }
  }
  
  private native long nativeCreate();
  
  private static native void nativeEnableMonitor(boolean paramBoolean);
  
  private static native boolean nativeGetFlaxLength(Bundle paramBundle);
  
  private static native String nativeGetIP(String paramString);
  
  private static native void nativeInitCVLogFilePath(String paramString);
  
  private static native int nativeInitClass(Object paramObject, int paramInt);
  
  private static native boolean nativeInitEngine(Object paramObject, String paramString);
  
  private static native void nativeInitMonitor(String paramString);
  
  private static native void nativeMonitorAddLog(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeMonitorSetLogPriority(int paramInt);
  
  private static native void nativeMonitorSetOutPutType(int paramInt);
  
  private native int nativeRelease(long paramLong);
  
  private static native void nativeSetHttpsEnable(boolean paramBoolean);
  
  private static native void nativeSetMonitorLogFilter(String[] paramArrayOfString);
  
  private static native void nativeSetNewDomainEnable(boolean paramBoolean);
  
  private static native void nativeSetProxyInfo(String paramString, int paramInt);
  
  private static native void nativeStartRunningRequest();
  
  private static native boolean nativeStartSocketProc();
  
  private static native boolean nativeStartSocketProcByCache(String paramString);
  
  private static native void nativeSyncAppRuntime(String paramString);
  
  private static native void nativeUninitCVLogFilePath();
  
  private static native boolean nativeUninitEngine();
  
  public static void restartLongLink()
  {
    LongLinkClient localLongLinkClient = a;
    if (localLongLinkClient != null) {}
    try
    {
      localLongLinkClient.start();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void startRunningRequest() {}
  
  public static void stopLongLink()
  {
    LongLinkClient localLongLinkClient = a;
    if (localLongLinkClient != null) {}
    try
    {
      localLongLinkClient.stop();
      return;
    }
    catch (Exception localException) {}
  }
  
  public long create()
  {
    this.mNativePointer = nativeCreate();
    return this.mNativePointer;
  }
  
  public int dispose()
  {
    return nativeRelease(this.mNativePointer);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.engine.NAEngine
 * JD-Core Version:    0.7.0.1
 */