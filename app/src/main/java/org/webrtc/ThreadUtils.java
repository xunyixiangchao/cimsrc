package org.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadUtils
{
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch)
  {
    executeUninterruptibly(new BlockingOperation()
    {
      public void run()
      {
        ThreadUtils.this.await();
      }
    });
  }
  
  public static boolean awaitUninterruptibly(CountDownLatch paramCountDownLatch, long paramLong)
  {
    long l3 = SystemClock.elapsedRealtime();
    boolean bool1 = false;
    long l1 = paramLong;
    int i = 0;
    label31:
    do
    {
      try
      {
        boolean bool2 = paramCountDownLatch.await(l1, TimeUnit.MILLISECONDS);
        bool1 = bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        int j;
        long l2;
        break label31;
      }
      j = 1;
      i = 1;
      l2 = paramLong - (SystemClock.elapsedRealtime() - l3);
      l1 = l2;
    } while (l2 > 0L);
    i = j;
    if (i != 0) {
      Thread.currentThread().interrupt();
    }
    return bool1;
  }
  
  public static void checkIsOnMainThread()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return;
    }
    throw new IllegalStateException("Not on main thread!");
  }
  
  static StackTraceElement[] concatStackTraces(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement1.length + paramArrayOfStackTraceElement2.length];
    System.arraycopy(paramArrayOfStackTraceElement1, 0, arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement1.length);
    System.arraycopy(paramArrayOfStackTraceElement2, 0, arrayOfStackTraceElement, paramArrayOfStackTraceElement1.length, paramArrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement;
  }
  
  public static void executeUninterruptibly(BlockingOperation paramBlockingOperation)
  {
    for (int i = 0;; i = 1) {
      try
      {
        paramBlockingOperation.run();
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        label19:
        break label19;
      }
    }
  }
  
  public static <V> V invokeAtFrontUninterruptibly(Handler paramHandler, final Callable<V> paramCallable)
  {
    if (paramHandler.getLooper().getThread() == Thread.currentThread()) {
      try
      {
        paramHandler = paramCallable.call();
        return paramHandler;
      }
      catch (Exception paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    Object local1Result = new Object()
    {
      public V value;
    };
    final Object local1CaughtException = new Object()
    {
      Exception e;
    };
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ThreadUtils.this.value = paramCallable.call();
        }
        catch (Exception localException)
        {
          local1CaughtException.e = localException;
        }
        localCountDownLatch.countDown();
      }
    });
    awaitUninterruptibly(localCountDownLatch);
    if (local1CaughtException.e == null) {
      return local1Result.value;
    }
    paramHandler = new RuntimeException(local1CaughtException.e);
    paramHandler.setStackTrace(concatStackTraces(local1CaughtException.e.getStackTrace(), paramHandler.getStackTrace()));
    throw paramHandler;
  }
  
  public static void invokeAtFrontUninterruptibly(Handler paramHandler, Runnable paramRunnable)
  {
    invokeAtFrontUninterruptibly(paramHandler, new Callable()
    {
      public Void call()
      {
        ThreadUtils.this.run();
        return null;
      }
    });
  }
  
  public static void joinUninterruptibly(Thread paramThread)
  {
    executeUninterruptibly(new BlockingOperation()
    {
      public void run()
      {
        ThreadUtils.this.join();
      }
    });
  }
  
  public static boolean joinUninterruptibly(Thread paramThread, long paramLong)
  {
    long l2 = SystemClock.elapsedRealtime();
    int i = 0;
    long l1 = paramLong;
    while (l1 > 0L)
    {
      try
      {
        paramThread.join(l1);
      }
      catch (InterruptedException localInterruptedException)
      {
        label26:
        break label26;
      }
      l1 = paramLong - (SystemClock.elapsedRealtime() - l2);
      i = 1;
    }
    if (i != 0) {
      Thread.currentThread().interrupt();
    }
    return paramThread.isAlive() ^ true;
  }
  
  public static abstract interface BlockingOperation
  {
    public abstract void run();
  }
  
  public static class ThreadChecker
  {
    private Thread thread = Thread.currentThread();
    
    public void checkIsOnValidThread()
    {
      if (this.thread == null) {
        this.thread = Thread.currentThread();
      }
      if (Thread.currentThread() == this.thread) {
        return;
      }
      throw new IllegalStateException("Wrong thread");
    }
    
    public void detachThread()
    {
      this.thread = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */