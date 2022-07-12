package v9;

import a9.f;
import android.util.Log;
import f9.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import l9.b0;
import p8.c0;
import t9.e;

public final class c
{
  public static final c a = new c();
  private static final CopyOnWriteArraySet<Logger> b = new CopyOnWriteArraySet();
  private static final Map<String, String> c;
  
  static
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = b0.class.getPackage();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Package)localObject).getName();
    }
    if (localObject != null) {
      localLinkedHashMap.put(localObject, "OkHttp");
    }
    localObject = b0.class.getName();
    f.e(localObject, "OkHttpClient::class.java.name");
    localLinkedHashMap.put(localObject, "okhttp.OkHttpClient");
    localObject = e.class.getName();
    f.e(localObject, "Http2::class.java.name");
    localLinkedHashMap.put(localObject, "okhttp.Http2");
    localObject = p9.d.class.getName();
    f.e(localObject, "TaskRunner::class.java.name");
    localLinkedHashMap.put(localObject, "okhttp.TaskRunner");
    localLinkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
    c = c0.d(localLinkedHashMap);
  }
  
  private final void c(String paramString1, String paramString2)
  {
    Logger localLogger = Logger.getLogger(paramString1);
    if (b.add(localLogger))
    {
      localLogger.setUseParentHandlers(false);
      if (Log.isLoggable(paramString2, 3)) {
        paramString1 = Level.FINE;
      } else if (Log.isLoggable(paramString2, 4)) {
        paramString1 = Level.INFO;
      } else {
        paramString1 = Level.WARNING;
      }
      localLogger.setLevel(paramString1);
      localLogger.addHandler(d.a);
    }
  }
  
  private final String d(String paramString)
  {
    String str2 = (String)c.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = l.p0(paramString, 23);
    }
    return str1;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    f.f(paramString1, "loggerName");
    f.f(paramString2, "message");
    String str = d(paramString1);
    if (Log.isLoggable(str, paramInt))
    {
      paramString1 = paramString2;
      if (paramThrowable != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append('\n');
        paramString1.append(Log.getStackTraceString(paramThrowable));
        paramString1 = paramString1.toString();
      }
      int i = 0;
      int k = paramString1.length();
      if (i < k)
      {
        int j = l.M(paramString1, '\n', i, false, 4, null);
        if (j == -1) {
          j = k;
        }
        for (;;)
        {
          int m = Math.min(j, i + 4000);
          paramString2 = paramString1.substring(i, m);
          f.e(paramString2, "this as java.lang.String…ing(startIndex, endIndex)");
          Log.println(paramInt, str, paramString2);
          if (m >= j)
          {
            i = m + 1;
            break;
          }
          i = m;
        }
      }
    }
  }
  
  public final void b()
  {
    Iterator localIterator = c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      c((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v9.c
 * JD-Core Version:    0.7.0.1
 */