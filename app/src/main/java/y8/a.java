package y8;

import java.io.Closeable;

public final class a
{
  public static final void a(Closeable paramCloseable, Throwable paramThrowable)
  {
    if (paramCloseable != null)
    {
      if (paramThrowable == null)
      {
        paramCloseable.close();
        return;
      }
      try
      {
        paramCloseable.close();
        return;
      }
      finally
      {
        o8.a.a(paramThrowable, paramCloseable);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y8.a
 * JD-Core Version:    0.7.0.1
 */