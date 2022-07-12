package com.yanzhenjie.permission.bridge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class d
{
  private static d b;
  private final BlockingQueue<a> a;
  
  private d()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    this.a = localLinkedBlockingQueue;
    new c(localLinkedBlockingQueue).start();
  }
  
  public static d b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new d();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yanzhenjie.permission.bridge.d
 * JD-Core Version:    0.7.0.1
 */