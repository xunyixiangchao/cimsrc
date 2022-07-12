package org.webrtc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging
{
  private static final Logger fallbackLogger = ;
  private static Loggable loggable;
  private static Severity loggableSeverity;
  private static volatile boolean loggingEnabled;
  
  private static Logger createFallbackLogger()
  {
    Logger localLogger = Logger.getLogger("org.webrtc.Logging");
    localLogger.setLevel(Level.ALL);
    return localLogger;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    log(Severity.LS_INFO, paramString1, paramString2);
  }
  
  static void deleteInjectedLoggable()
  {
    loggable = null;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(Severity.LS_ERROR, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Severity localSeverity = Severity.LS_ERROR;
    log(localSeverity, paramString1, paramString2);
    log(localSeverity, paramString1, paramThrowable.toString());
    log(localSeverity, paramString1, getStackTraceString(paramThrowable));
  }
  
  public static void enableLogThreads() {}
  
  public static void enableLogTimeStamps() {}
  
  public static void enableLogToDebugOutput(Severity paramSeverity)
  {
    try
    {
      if (loggable == null)
      {
        nativeEnableLogToDebugOutput(paramSeverity.ordinal());
        loggingEnabled = true;
        return;
      }
      throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
    }
    finally {}
  }
  
  @Deprecated
  public static void enableTracing(String paramString, EnumSet<TraceLevel> paramEnumSet) {}
  
  private static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  static void injectLoggable(Loggable paramLoggable, Severity paramSeverity)
  {
    if (paramLoggable != null)
    {
      loggable = paramLoggable;
      loggableSeverity = paramSeverity;
    }
  }
  
  public static void log(Severity paramSeverity, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (loggable != null)
      {
        if (paramSeverity.ordinal() < loggableSeverity.ordinal()) {
          return;
        }
        loggable.onLogMessage(paramString2, paramSeverity, paramString1);
        return;
      }
      if (loggingEnabled)
      {
        nativeLog(paramSeverity.ordinal(), paramString1, paramString2);
        return;
      }
      int i = 1.$SwitchMap$org$webrtc$Logging$Severity[paramSeverity.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramSeverity = Level.FINE;
          } else {
            paramSeverity = Level.INFO;
          }
        }
        else {
          paramSeverity = Level.WARNING;
        }
      }
      else {
        paramSeverity = Level.SEVERE;
      }
      Logger localLogger = fallbackLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localLogger.log(paramSeverity, localStringBuilder.toString());
      return;
    }
    throw new IllegalArgumentException("Logging tag or message may not be null.");
  }
  
  private static native void nativeEnableLogThreads();
  
  private static native void nativeEnableLogTimeStamps();
  
  private static native void nativeEnableLogToDebugOutput(int paramInt);
  
  private static native void nativeLog(int paramInt, String paramString1, String paramString2);
  
  public static void v(String paramString1, String paramString2)
  {
    log(Severity.LS_VERBOSE, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(Severity.LS_WARNING, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Severity localSeverity = Severity.LS_WARNING;
    log(localSeverity, paramString1, paramString2);
    log(localSeverity, paramString1, paramThrowable.toString());
    log(localSeverity, paramString1, getStackTraceString(paramThrowable));
  }
  
  public static enum Severity
  {
    static
    {
      Severity localSeverity1 = new Severity("LS_VERBOSE", 0);
      LS_VERBOSE = localSeverity1;
      Severity localSeverity2 = new Severity("LS_INFO", 1);
      LS_INFO = localSeverity2;
      Severity localSeverity3 = new Severity("LS_WARNING", 2);
      LS_WARNING = localSeverity3;
      Severity localSeverity4 = new Severity("LS_ERROR", 3);
      LS_ERROR = localSeverity4;
      Severity localSeverity5 = new Severity("LS_NONE", 4);
      LS_NONE = localSeverity5;
      $VALUES = new Severity[] { localSeverity1, localSeverity2, localSeverity3, localSeverity4, localSeverity5 };
    }
    
    private Severity() {}
  }
  
  @Deprecated
  public static enum TraceLevel
  {
    public final int level;
    
    static
    {
      TraceLevel localTraceLevel1 = new TraceLevel("TRACE_NONE", 0, 0);
      TRACE_NONE = localTraceLevel1;
      TraceLevel localTraceLevel2 = new TraceLevel("TRACE_STATEINFO", 1, 1);
      TRACE_STATEINFO = localTraceLevel2;
      TraceLevel localTraceLevel3 = new TraceLevel("TRACE_WARNING", 2, 2);
      TRACE_WARNING = localTraceLevel3;
      TraceLevel localTraceLevel4 = new TraceLevel("TRACE_ERROR", 3, 4);
      TRACE_ERROR = localTraceLevel4;
      TraceLevel localTraceLevel5 = new TraceLevel("TRACE_CRITICAL", 4, 8);
      TRACE_CRITICAL = localTraceLevel5;
      TraceLevel localTraceLevel6 = new TraceLevel("TRACE_APICALL", 5, 16);
      TRACE_APICALL = localTraceLevel6;
      TraceLevel localTraceLevel7 = new TraceLevel("TRACE_DEFAULT", 6, 255);
      TRACE_DEFAULT = localTraceLevel7;
      TraceLevel localTraceLevel8 = new TraceLevel("TRACE_MODULECALL", 7, 32);
      TRACE_MODULECALL = localTraceLevel8;
      TraceLevel localTraceLevel9 = new TraceLevel("TRACE_MEMORY", 8, 256);
      TRACE_MEMORY = localTraceLevel9;
      TraceLevel localTraceLevel10 = new TraceLevel("TRACE_TIMER", 9, 512);
      TRACE_TIMER = localTraceLevel10;
      TraceLevel localTraceLevel11 = new TraceLevel("TRACE_STREAM", 10, 1024);
      TRACE_STREAM = localTraceLevel11;
      TraceLevel localTraceLevel12 = new TraceLevel("TRACE_DEBUG", 11, 2048);
      TRACE_DEBUG = localTraceLevel12;
      TraceLevel localTraceLevel13 = new TraceLevel("TRACE_INFO", 12, 4096);
      TRACE_INFO = localTraceLevel13;
      TraceLevel localTraceLevel14 = new TraceLevel("TRACE_TERSEINFO", 13, 8192);
      TRACE_TERSEINFO = localTraceLevel14;
      TraceLevel localTraceLevel15 = new TraceLevel("TRACE_ALL", 14, 65535);
      TRACE_ALL = localTraceLevel15;
      $VALUES = new TraceLevel[] { localTraceLevel1, localTraceLevel2, localTraceLevel3, localTraceLevel4, localTraceLevel5, localTraceLevel6, localTraceLevel7, localTraceLevel8, localTraceLevel9, localTraceLevel10, localTraceLevel11, localTraceLevel12, localTraceLevel13, localTraceLevel14, localTraceLevel15 };
    }
    
    private TraceLevel(int paramInt)
    {
      this.level = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Logging
 * JD-Core Version:    0.7.0.1
 */