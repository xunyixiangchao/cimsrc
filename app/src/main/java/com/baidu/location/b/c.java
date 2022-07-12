package com.baidu.location.b;

import android.os.Bundle;

public class c
{
  private static Object a = new Object();
  private static c b;
  private int c = -1;
  
  public static c a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new c();
      }
      c localc = b;
      return localc;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 != this.c)
    {
      this.c = paramInt2;
      Bundle localBundle = new Bundle();
      localBundle.putInt("loctype", paramInt1);
      localBundle.putInt("diagtype", paramInt2);
      localBundle.putByteArray("diagmessage", paramString.getBytes());
      b.a().a(localBundle, 303);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.c
 * JD-Core Version:    0.7.0.1
 */