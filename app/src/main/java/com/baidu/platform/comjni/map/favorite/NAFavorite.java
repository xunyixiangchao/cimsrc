package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;

public class NAFavorite
  extends JNIBaseApi
{
  private long a = 0L;
  
  private native boolean nativeAdd(long paramLong, String paramString1, String paramString2);
  
  private native boolean nativeClear(long paramLong);
  
  private native boolean nativeCloseCache(long paramLong);
  
  private native long nativeCreate();
  
  private native boolean nativeDelete(long paramLong);
  
  private native int nativeGetAll(long paramLong, Bundle paramBundle);
  
  private native int nativeGetLength(long paramLong);
  
  private native int nativeGetRelations(long paramLong, String paramString, Bundle paramBundle, int paramInt);
  
  private native String nativeGetValue(long paramLong, String paramString);
  
  private native boolean nativeIsExist(long paramLong, String paramString);
  
  private native boolean nativeLoad(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3);
  
  private native int nativeRelease(long paramLong);
  
  private native boolean nativeRemove(long paramLong, String paramString);
  
  private native boolean nativeResumeCache(long paramLong);
  
  private native boolean nativeSaveCache(long paramLong);
  
  private native boolean nativeSetType(long paramLong, int paramInt);
  
  private native boolean nativeUpdate(long paramLong, String paramString1, String paramString2);
  
  private native boolean nativeUpdateInOrder(long paramLong, String paramString1, String paramString2);
  
  public int a(Bundle paramBundle)
  {
    try
    {
      int i = nativeGetAll(this.a, paramBundle);
      return i;
    }
    finally
    {
      label12:
      break label12;
    }
    return 0;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = nativeGetValue(this.a, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  public boolean a()
  {
    return nativeClear(this.a);
  }
  
  public boolean a(int paramInt)
  {
    return nativeSetType(this.a, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return nativeAdd(this.a, paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeLoad(this.a, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3);
  }
  
  public long b()
  {
    long l = nativeCreate();
    this.a = l;
    return l;
  }
  
  public boolean b(String paramString)
  {
    try
    {
      boolean bool = nativeIsExist(this.a, paramString);
      return bool;
    }
    finally
    {
      label12:
      break label12;
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return nativeUpdate(this.a, paramString1, paramString2);
  }
  
  public int c()
  {
    return nativeRelease(this.a);
  }
  
  public boolean c(String paramString)
  {
    return nativeRemove(this.a, paramString);
  }
  
  public boolean d()
  {
    return nativeSaveCache(this.a);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.map.favorite.NAFavorite
 * JD-Core Version:    0.7.0.1
 */