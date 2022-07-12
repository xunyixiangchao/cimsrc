package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageProxy
{
  private static final SparseArray<List<Handler>> a = new SparseArray();
  
  public static void destroy()
  {
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = a;
      localObject = (List)((SparseArray)localObject).get(((SparseArray)localObject).keyAt(i));
      if (localObject != null) {
        ((List)localObject).clear();
      }
      i += 1;
    }
    a.clear();
  }
  
  public static void dispatchMessage(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    synchronized (a)
    {
      Object localObject1 = (List)???.get(paramInt1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Handler localHandler = (Handler)((Iterator)localObject1).next();
          Message localMessage = Message.obtain(localHandler, paramInt1, paramInt2, paramInt3, Long.valueOf(paramLong));
          if ((paramInt1 != 41) && ((paramInt1 != 39) || ((paramInt2 != 0) && (paramInt2 != 1)))) {
            localMessage.sendToTarget();
          } else {
            localHandler.handleMessage(localMessage);
          }
        }
      }
      return;
    }
  }
  
  public static void registerMessageHandler(int paramInt, Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    synchronized (a)
    {
      Object localObject = (List)???.get(paramInt);
      if (localObject != null)
      {
        if (!((List)localObject).contains(paramHandler)) {
          ((List)localObject).add(paramHandler);
        }
      }
      else
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramHandler);
        ???.put(paramInt, localObject);
      }
      return;
    }
  }
  
  public static void unRegisterMessageHandler(int paramInt, Handler paramHandler)
  {
    if (paramHandler != null)
    {
      paramHandler.removeCallbacksAndMessages(null);
      synchronized (a)
      {
        List localList = (List)???.get(paramInt);
        if (localList != null) {
          localList.remove(paramHandler);
        }
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comjni.engine.MessageProxy
 * JD-Core Version:    0.7.0.1
 */