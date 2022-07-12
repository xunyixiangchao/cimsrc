package b2;

import java.io.IOException;

public final class e
  extends IOException
{
  private final int a;
  
  public e(int paramInt)
  {
    this("Http request failed", paramInt);
  }
  
  public e(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public e(String paramString, int paramInt, Throwable paramThrowable)
  {
    super(localStringBuilder.toString(), paramThrowable);
    this.a = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.e
 * JD-Core Version:    0.7.0.1
 */