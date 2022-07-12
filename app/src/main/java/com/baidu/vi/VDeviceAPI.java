package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VDeviceAPI
{
  private static BroadcastReceiver a;
  
  public static String getAppVersion()
  {
    String str = VIContext.getContext().getApplicationInfo().packageName;
    try
    {
      str = VIContext.getContext().getPackageManager().getPackageInfo(str, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label27:
      break label27;
    }
    return "";
  }
  
  public static long getAvailableMemory()
  {
    ActivityManager localActivityManager = (ActivityManager)VIContext.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public static String getCachePath()
  {
    return Environment.getDataDirectory().getAbsolutePath();
  }
  
  public static String getCellId()
  {
    return "";
  }
  
  public static String getCuid()
  {
    return SyncSysInfo.getCid();
  }
  
  public static int getCurrentNetworkType()
  {
    try
    {
      int i = Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
      return i;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return -1;
  }
  
  public static long getFreeSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
  
  public static String getImei()
  {
    return null;
  }
  
  public static String getImsi()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)VIContext.getContext().getSystemService("phone");
    return null;
  }
  
  public static String getLac()
  {
    return "";
  }
  
  public static String getModuleFileName()
  {
    return VIContext.getContext().getFilesDir().getAbsolutePath();
  }
  
  public static VNetworkInfo getNetworkInfo(int paramInt)
  {
    Object localObject = (ConnectivityManager)VIContext.getContext().getSystemService("connectivity");
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        localObject = null;
        break label40;
      }
      paramInt = 0;
    }
    else
    {
      paramInt = 1;
    }
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(paramInt);
    label40:
    if (localObject != null) {
      return new VNetworkInfo((NetworkInfo)localObject);
    }
    return null;
  }
  
  public static String getOsVersion()
  {
    return "android";
  }
  
  @TargetApi(8)
  public static int getScreenBrightness()
  {
    ContentResolver localContentResolver = VIContext.getContext().getContentResolver();
    try
    {
      i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          int i = Settings.System.getInt(localContentResolver, "screen_brightness");
          return i;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException) {}
        localException = localException;
      }
    }
    i = 0;
    if (i == 1) {
      return -1;
    }
    return -1;
  }
  
  public static float getScreenDensity()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.density;
  }
  
  public static int getScreenDensityDpi()
  {
    if (VIContext.getContext() == null) {
      return 0;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if ((localWindowManager != null) && (localWindowManager.getDefaultDisplay() != null)) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.densityDpi;
  }
  
  public static long getSdcardFreeSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
  
  public static String getSdcardPath()
  {
    return SysOSUtil.getInstance().getCompatibleSdcardPath();
  }
  
  public static long getSdcardTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static float getSystemMetricsX()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.widthPixels;
  }
  
  public static float getSystemMetricsY()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.heightPixels;
  }
  
  @Deprecated
  public static int getTelecomInfo()
  {
    return -1;
  }
  
  public static long getTotalMemory()
  {
    long l3 = 0L;
    long l2 = l3;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      l2 = l3;
      String str = localBufferedReader.readLine();
      long l1 = l3;
      if (str != null)
      {
        l2 = l3;
        l1 = Integer.valueOf(str.split("\\s+")[1]).intValue();
      }
      l2 = l1;
      localBufferedReader.close();
      return l1;
    }
    catch (IOException localIOException) {}
    return l2;
  }
  
  public static long getTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static ScanResult[] getWifiHotpot()
  {
    return null;
  }
  
  public static boolean isWifiConnected()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public static void makeCall(String paramString) {}
  
  public static native void onNetworkStateChanged();
  
  public static void openUrl(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    VIContext.getContext().startActivity(paramString);
  }
  
  public static int sendMMS(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return 0;
  }
  
  public static void sendSMS(String paramString1, String paramString2) {}
  
  public static void setNetworkChangedCallback()
  {
    unsetNetworkChangedCallback();
    a = new a();
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    VIContext.getContext().registerReceiver(a, localIntentFilter);
  }
  
  public static void setScreenAlwaysOn(boolean paramBoolean) {}
  
  public static void setupSoftware(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    VIContext.getContext().startActivity(localIntent);
  }
  
  public static void unsetNetworkChangedCallback()
  {
    if (a != null)
    {
      VIContext.getContext().unregisterReceiver(a);
      a = null;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.VDeviceAPI
 * JD-Core Version:    0.7.0.1
 */