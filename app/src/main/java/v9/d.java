package v9;

import a9.f;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public final class d
  extends Handler
{
  public static final d a = new d();
  
  public void close() {}
  
  public void flush() {}
  
  public void publish(LogRecord paramLogRecord)
  {
    f.f(paramLogRecord, "record");
    c localc = c.a;
    String str1 = paramLogRecord.getLoggerName();
    f.e(str1, "record.loggerName");
    int i = e.a(paramLogRecord);
    String str2 = paramLogRecord.getMessage();
    f.e(str2, "record.message");
    localc.a(str1, i, str2, paramLogRecord.getThrown());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.d
 * JD-Core Version:    0.7.0.1
 */