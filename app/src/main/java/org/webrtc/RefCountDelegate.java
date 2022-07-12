package org.webrtc;

import java.util.concurrent.atomic.AtomicInteger;

class RefCountDelegate
  implements RefCounted
{
  private final AtomicInteger refCount = new AtomicInteger(1);
  private final Runnable releaseCallback;
  
  public RefCountDelegate(Runnable paramRunnable)
  {
    this.releaseCallback = paramRunnable;
  }
  
  public void release()
  {
    int i = this.refCount.decrementAndGet();
    if (i >= 0)
    {
      if (i == 0)
      {
        Runnable localRunnable = this.releaseCallback;
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    throw new IllegalStateException("release() called on an object with refcount < 1");
  }
  
  public void retain()
  {
    if (this.refCount.incrementAndGet() >= 2) {
      return;
    }
    throw new IllegalStateException("retain() called on an object with refcount < 1");
  }
  
  boolean safeRetain()
  {
    int i;
    do
    {
      i = this.refCount.get();
      if (i == 0) {
        break;
      }
    } while (!this.refCount.weakCompareAndSet(i, i + 1));
    return true;
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.RefCountDelegate
 * JD-Core Version:    0.7.0.1
 */