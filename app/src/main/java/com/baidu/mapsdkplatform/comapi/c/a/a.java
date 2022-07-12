package com.baidu.mapsdkplatform.comapi.c.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private static int c = 10240;
  private static volatile boolean d = false;
  private String a = "";
  private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
  
  public static a a()
  {
    return b.a();
  }
  
  private void a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    try
    {
      Object localObject = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
      paramThrowable.printStackTrace(localPrintWriter);
      paramThrowable = paramThrowable.getCause();
      if (paramThrowable != null) {
        paramThrowable.printStackTrace(localPrintWriter);
      }
      localPrintWriter.close();
      localObject = localObject.toString();
      if (((String)localObject).isEmpty()) {
        return;
      }
      int i = ((String)localObject).length();
      int j = c;
      paramThrowable = (Throwable)localObject;
      if (i > j) {
        paramThrowable = ((String)localObject).substring(0, j);
      }
      if (!paramThrowable.contains("BDMapSDKException"))
      {
        if ((!paramThrowable.contains("com.baidu.platform")) && (!paramThrowable.contains("com.baidu.mapsdkplatform"))) {
          return;
        }
        localObject = this.a;
        if (localObject != null)
        {
          if (((String)localObject).isEmpty()) {
            return;
          }
          long l = System.currentTimeMillis() / 1000L;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(".txt");
          localObject = ((StringBuilder)localObject).toString();
          b.c().a((String)localObject, paramThrowable);
        }
      }
      return;
    }
    catch (Exception paramThrowable) {}
  }
  
  protected void a(String paramString)
  {
    this.a = paramString;
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof a)) {
      Thread.setDefaultUncaughtExceptionHandler(this);
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (d) {
      return;
    }
    d = true;
    a(paramThrowable);
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.b;
    if (localUncaughtExceptionHandler != null) {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
  
  private static class b
  {
    private static final a a = new a(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.c.a.a
 * JD-Core Version:    0.7.0.1
 */