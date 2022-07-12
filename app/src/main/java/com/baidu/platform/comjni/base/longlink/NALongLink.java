package com.baidu.platform.comjni.base.longlink;

import android.util.Log;
import com.baidu.platform.comapi.b;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comjni.JNIBaseApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NALongLink
  extends JNIBaseApi
{
  private static Map<Integer, LinkedList<Object>> a = new ConcurrentHashMap();
  private static ELongLinkStatus[] b = { ELongLinkStatus.OK, ELongLinkStatus.SendFormatError, ELongLinkStatus.SendUnRegistered, ELongLinkStatus.SendLimited, ELongLinkStatus.SendDataLenLimited, ELongLinkStatus.SendInvalidReqID, ELongLinkStatus.ResultConnectError, ELongLinkStatus.ResultSendError, ELongLinkStatus.ResultTimeout, ELongLinkStatus.ResultServerError, ELongLinkStatus.CloudStop, ELongLinkStatus.CloudRestart };
  
  public static long create()
  {
    return nativeCreate();
  }
  
  public static boolean init(long paramLong, String paramString1, String paramString2)
  {
    return nativeInit(paramLong, paramString1, paramString2);
  }
  
  private static native long nativeCreate();
  
  private static native boolean nativeInit(long paramLong, String paramString1, String paramString2);
  
  private static native boolean nativeRegister(long paramLong, int paramInt);
  
  private static native int nativeRelease(long paramLong);
  
  private static native int nativeSendData(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private static native int nativeSendFileData(long paramLong, int paramInt1, int paramInt2, String paramString, ArrayList<LongLinkFileData> paramArrayList);
  
  private static native boolean nativeStart(long paramLong);
  
  private static native boolean nativeStop(long paramLong);
  
  private static native boolean nativeUnRegister(long paramLong, int paramInt);
  
  public static boolean onJNILongLinkDataCallback(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onJNILongLinkDataCallback:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" status:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" reqId:");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(" isPush:");
    ((StringBuilder)localObject1).append(paramBoolean);
    Log.e("JNILongLink", ((StringBuilder)localObject1).toString());
    if ((paramInt2 >= 0) && (paramInt2 < b.length))
    {
      if (paramArrayOfByte != null)
      {
        localObject1 = paramArrayOfByte;
        if (paramArrayOfByte.length > 0) {}
      }
      else
      {
        localObject1 = new byte[0];
      }
      paramArrayOfByte = null;
      try
      {
        Object localObject2 = (LinkedList)a.get(Integer.valueOf(paramInt1));
        if (localObject2 != null) {
          paramArrayOfByte = new LinkedList((Collection)localObject2);
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject2 = paramArrayOfByte.next();
            if (localObject2 != null)
            {
              try
              {
                if (!(localObject2 instanceof LongLinkDataCallback)) {
                  continue;
                }
                localObject3 = b[paramInt2];
                ((ELongLinkStatus)localObject3).setRequestId(paramInt3);
                String str = localObject2.getClass().getName();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("className = ");
                localStringBuilder.append(str);
                Log.d("JNILongLink", localStringBuilder.toString());
                ((LongLinkDataCallback)localObject2).onReceiveData((ELongLinkStatus)localObject3, paramInt3, (byte[])localObject1, paramBoolean);
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("className = ");
                ((StringBuilder)localObject3).append(str);
                ((StringBuilder)localObject3).append("done");
                Log.d("JNILongLink", ((StringBuilder)localObject3).toString());
              }
              catch (Exception localException)
              {
                Object localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("className = ");
                ((StringBuilder)localObject3).append(localObject2.getClass().getName());
                ((StringBuilder)localObject3).append(",exception = ");
                ((StringBuilder)localObject3).append(localException.toString());
                Log.e("JNILongLink", ((StringBuilder)localObject3).toString());
              }
              if (b.e()) {
                throw localException;
              }
            }
          }
        }
        return true;
      }
      finally {}
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("invalid status = ");
    paramArrayOfByte.append(paramInt2);
    Log.e("JNILongLink", paramArrayOfByte.toString());
    if (!b.e()) {
      return false;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public static boolean register(long paramLong, int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register moduleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", callback = ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register moduleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", callback = ");
      ((StringBuilder)localObject).append(paramObject);
    }
    Log.e("JNILongLink", ((StringBuilder)localObject).toString());
    int j = 0;
    try
    {
      localObject = (LinkedList)a.get(Integer.valueOf(paramInt));
      int i;
      if (localObject == null)
      {
        localObject = new LinkedList();
        ((LinkedList)localObject).add(paramObject);
        a.put(Integer.valueOf(paramInt), localObject);
        i = 1;
      }
      else
      {
        i = j;
        if (!((LinkedList)localObject).contains(paramObject))
        {
          ((LinkedList)localObject).add(paramObject);
          a.put(Integer.valueOf(paramInt), localObject);
          i = j;
        }
      }
      if (i != 0) {
        return nativeRegister(paramLong, paramInt);
      }
      return true;
    }
    finally {}
  }
  
  public static int release(long paramLong)
  {
    return nativeRelease(paramLong);
  }
  
  public static int sendData(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return nativeSendData(paramLong, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public static int sendFileData(long paramLong, int paramInt1, int paramInt2, String paramString, ArrayList<LongLinkFileData> paramArrayList)
  {
    return nativeSendFileData(paramLong, paramInt1, paramInt2, paramString, paramArrayList);
  }
  
  public static boolean start(long paramLong)
  {
    return nativeStart(paramLong);
  }
  
  public static boolean stop(long paramLong)
  {
    return nativeStop(paramLong);
  }
  
  public static boolean unRegister(long paramLong, int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unegister moduleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", callback = ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unregister moduleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", callback = ");
      ((StringBuilder)localObject).append(paramObject);
    }
    Log.e("JNILongLink", ((StringBuilder)localObject).toString());
    try
    {
      localObject = (LinkedList)a.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (paramObject != null) {
          ((LinkedList)localObject).remove(paramObject);
        }
        if (((LinkedList)localObject).isEmpty()) {
          a.remove(Integer.valueOf(paramInt));
        }
      }
      if (localObject != null)
      {
        if (((LinkedList)localObject).isEmpty()) {
          return nativeUnRegister(paramLong, paramInt);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.base.longlink.NALongLink
 * JD-Core Version:    0.7.0.1
 */