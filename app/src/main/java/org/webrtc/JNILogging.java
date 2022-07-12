package org.webrtc;

class JNILogging
{
  private final Loggable loggable;
  
  public JNILogging(Loggable paramLoggable)
  {
    this.loggable = paramLoggable;
  }
  
  @CalledByNative
  public void logToInjectable(String paramString1, Integer paramInteger, String paramString2)
  {
    this.loggable.onLogMessage(paramString1, Logging.Severity.values()[paramInteger.intValue()], paramString2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.JNILogging
 * JD-Core Version:    0.7.0.1
 */