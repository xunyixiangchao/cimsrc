package com.baidu.b.a;

import java.util.Arrays;

public class a
{
  g[] a = { new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1) };
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    f localf = new f();
    byte[] arrayOfByte = c.a(paramArrayOfByte, paramArrayOfByte.length + (this.a.length + 1) * f.a);
    c.a(arrayOfByte, localf.a(), paramArrayOfByte.length);
    int i = 0;
    for (;;)
    {
      Object localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      int j = paramArrayOfByte.length;
      i += 1;
      j += f.a * i;
      localf.a(((g)localObject).a(arrayOfByte, 0, j), ((g)localObject).a(), ((g)localObject).b(), ((g)localObject).c());
      c.a(arrayOfByte, localf.a(), j);
    }
    return Arrays.copyOf(localf.a(), f.a);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.a
 * JD-Core Version:    0.7.0.1
 */