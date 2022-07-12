package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.a;
import java.util.Map;

public class BuglyStrategy
{
  protected int a = 31;
  protected boolean b = false;
  private String c;
  private String d;
  private String e;
  private long f;
  private String g;
  private String h;
  private String i;
  private boolean j = true;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private boolean n = true;
  private Class<?> o = null;
  private boolean p = true;
  private boolean q = true;
  private boolean r = true;
  private boolean s = true;
  private boolean t = false;
  private a u;
  private boolean v = false;
  
  public String getAppChannel()
  {
    try
    {
      String str = this.d;
      if (str == null)
      {
        str = a.b().k;
        return str;
      }
      return str;
    }
    finally {}
  }
  
  public String getAppPackageName()
  {
    try
    {
      String str = this.e;
      if (str == null)
      {
        str = a.b().c;
        return str;
      }
      return str;
    }
    finally {}
  }
  
  public long getAppReportDelay()
  {
    try
    {
      long l1 = this.f;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getAppVersion()
  {
    try
    {
      String str = this.c;
      if (str == null)
      {
        str = a.b().i;
        return str;
      }
      return str;
    }
    finally {}
  }
  
  public int getCallBackType()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean getCloseErrorCallback()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public a getCrashHandleCallback()
  {
    try
    {
      a locala = this.u;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDeviceID()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDeviceModel()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLibBuglySOFilePath()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Class<?> getUserInfoActivity()
  {
    try
    {
      Class localClass = this.o;
      return localClass;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isBuglyLogUpload()
  {
    try
    {
      boolean bool = this.p;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableANRCrashMonitor()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableCatchAnrTrace()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableNativeCrashMonitor()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableRecordAnrMainStack()
  {
    return this.m;
  }
  
  public boolean isEnableUserInfo()
  {
    try
    {
      boolean bool = this.n;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isMerged()
  {
    return this.v;
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.q;
  }
  
  public boolean isUploadProcess()
  {
    try
    {
      boolean bool = this.r;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isUploadSpotCrash()
  {
    try
    {
      boolean bool = this.s;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean recordUserInfoOnceADay()
  {
    try
    {
      boolean bool = this.t;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppChannel(String paramString)
  {
    try
    {
      this.d = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppPackageName(String paramString)
  {
    try
    {
      this.e = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppReportDelay(long paramLong)
  {
    try
    {
      this.f = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppVersion(String paramString)
  {
    try
    {
      this.c = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setBuglyLogUpload(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCallBackType(int paramInt)
  {
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCloseErrorCallback(boolean paramBoolean)
  {
    try
    {
      this.b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setCrashHandleCallback(a parama)
  {
    try
    {
      this.u = parama;
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public BuglyStrategy setDeviceID(String paramString)
  {
    try
    {
      this.h = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setDeviceModel(String paramString)
  {
    try
    {
      this.i = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEnableCatchAnrTrace(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEnableRecordAnrMainStack(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
  {
    try
    {
      this.n = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setLibBuglySOFilePath(String paramString)
  {
    try
    {
      this.g = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public void setMerged(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.t = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReplaceOldChannel(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public BuglyStrategy setUploadProcess(boolean paramBoolean)
  {
    try
    {
      this.r = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setUploadSpotCrash(boolean paramBoolean)
  {
    try
    {
      this.s = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setUserInfoActivity(Class<?> paramClass)
  {
    try
    {
      this.o = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static class a
  {
    public static final int CRASHTYPE_ANR = 4;
    public static final int CRASHTYPE_BLOCK = 7;
    public static final int CRASHTYPE_COCOS2DX_JS = 5;
    public static final int CRASHTYPE_COCOS2DX_LUA = 6;
    public static final int CRASHTYPE_JAVA_CATCH = 1;
    public static final int CRASHTYPE_JAVA_CRASH = 0;
    public static final int CRASHTYPE_NATIVE = 2;
    public static final int CRASHTYPE_U3D = 3;
    public static final int MAX_USERDATA_KEY_LENGTH = 100;
    public static final int MAX_USERDATA_VALUE_LENGTH = 100000;
    
    public Map<String, String> onCrashHandleStart(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
    
    public byte[] onCrashHandleStart2GetExtraDatas(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.BuglyStrategy
 * JD-Core Version:    0.7.0.1
 */