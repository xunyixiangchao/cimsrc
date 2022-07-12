package a0;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class h
{
  private AtomicInteger a = new AtomicInteger(0);
  private final Lock b;
  private final Condition c;
  
  h()
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.b = localReentrantLock;
    this.c = localReentrantLock.newCondition();
  }
  
  void a()
  {
    this.b.lock();
    try
    {
      int i = this.a.getAndDecrement();
      if (i != -1)
      {
        if (i != 0)
        {
          this.c.signal();
          return;
        }
        throw new IllegalStateException("Unable to decrement. No corresponding counter increment");
      }
      throw new IllegalStateException("Unable to decrement. Counter already destroyed");
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  void b()
  {
    this.b.lock();
    for (;;)
    {
      try
      {
        boolean bool = this.a.compareAndSet(0, -1);
        if (bool) {}
      }
      finally
      {
        this.b.unlock();
      }
      try
      {
        this.c.await();
      }
      catch (InterruptedException localInterruptedException) {}
      this.b.unlock();
      return;
    }
  }
  
  boolean c()
  {
    this.b.lock();
    try
    {
      int i = this.a.get();
      if (i == -1) {
        return false;
      }
      this.a.getAndIncrement();
      return true;
    }
    finally
    {
      this.b.unlock();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.h
 * JD-Core Version:    0.7.0.1
 */