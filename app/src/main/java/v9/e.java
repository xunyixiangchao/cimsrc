package v9;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class e
{
  private static final int b(LogRecord paramLogRecord)
  {
    if (paramLogRecord.getLevel().intValue() > Level.INFO.intValue()) {
      return 5;
    }
    if (paramLogRecord.getLevel().intValue() == Level.INFO.intValue()) {
      return 4;
    }
    return 3;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.e
 * JD-Core Version:    0.7.0.1
 */