package com.baidu.b.c.a;

import com.baidu.b.c.c.b;

public class g
{
  private static volatile byte[] a;
  
  public static byte[] a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          Object localObject2 = b.b();
          byte[] arrayOfByte = new byte[16];
          System.arraycopy(localObject2, 0, arrayOfByte, 0, 16);
          localObject2 = new c();
          ((c)localObject2).a(2, arrayOfByte, arrayOfByte);
          a = ((c)localObject2).a(new byte[] { -71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50 });
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.g
 * JD-Core Version:    0.7.0.1
 */