package u0;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Deprecated
public final class f
{
  private static long a;
  private static Method b;
  private static Method c;
  private static Method d;
  private static Method e;
  
  static
  {
    if (Build.VERSION.SDK_INT < 29) {
      try
      {
        a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        Class localClass1 = Long.TYPE;
        b = Trace.class.getMethod("isTagEnabled", new Class[] { localClass1 });
        Class localClass2 = Integer.TYPE;
        c = Trace.class.getMethod("asyncTraceBegin", new Class[] { localClass1, String.class, localClass2 });
        d = Trace.class.getMethod("asyncTraceEnd", new Class[] { localClass1, String.class, localClass2 });
        e = Trace.class.getMethod("traceCounter", new Class[] { localClass1, String.class, localClass2 });
        return;
      }
      catch (Exception localException)
      {
        Log.i("TraceCompat", "Unable to initialize via reflection.", localException);
      }
    }
  }
  
  public static void a(String paramString)
  {
    Trace.beginSection(paramString);
  }
  
  public static void b() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u0.f
 * JD-Core Version:    0.7.0.1
 */