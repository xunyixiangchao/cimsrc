package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

public class p
{
  private ExecutorService a = null;
  private ExecutorService b = null;
  
  public static p a()
  {
    return a.a();
  }
  
  public ExecutorService b()
  {
    try
    {
      ExecutorService localExecutorService = this.a;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ExecutorService c()
  {
    try
    {
      ExecutorService localExecutorService = this.b;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    ExecutorService localExecutorService = this.a;
    if (localExecutorService != null) {
      localExecutorService.shutdown();
    }
    localExecutorService = this.b;
    if (localExecutorService != null) {
      localExecutorService.shutdown();
    }
  }
  
  private static class a
  {
    private static p a = new p(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.p
 * JD-Core Version:    0.7.0.1
 */