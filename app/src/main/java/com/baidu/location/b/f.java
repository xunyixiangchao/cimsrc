package com.baidu.location.b;

import com.baidu.location.e.g;
import com.baidu.location.e.h;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class f
{
  private static f a;
  private static String b = "Temp_in.dat";
  private static File c = new File(g.a, b);
  private static StringBuffer d = null;
  private static boolean e = true;
  private static int f = 0;
  private static int g = 0;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static double k = 0.0D;
  private static double l = 0.0D;
  private static int m = 0;
  private static int n = 0;
  private static int o = 0;
  
  public static String a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      return null;
    }
    if (!((File)localObject1).exists()) {
      return null;
    }
    int i3;
    try
    {
      localObject1 = new RandomAccessFile(c, "rw");
      ((RandomAccessFile)localObject1).seek(0L);
      i2 = ((RandomAccessFile)localObject1).readInt();
      i3 = ((RandomAccessFile)localObject1).readInt();
      i1 = ((RandomAccessFile)localObject1).readInt();
      if (a(i2, i3, i1)) {
        break label209;
      }
      ((RandomAccessFile)localObject1).close();
      c();
      return null;
    }
    catch (IOException localIOException)
    {
      int i2;
      long l1;
      Object localObject2;
      return null;
    }
    l1 = (i3 - 1) * 1024 + 12 + 0L;
    ((RandomAccessFile)localObject1).seek(l1);
    int i4 = ((RandomAccessFile)localObject1).readInt();
    localObject2 = new byte[i4];
    ((RandomAccessFile)localObject1).seek(l1 + 4L);
    int i1 = 0;
    while (i1 < i4)
    {
      localObject2[i1] = ((RandomAccessFile)localObject1).readByte();
      i1 += 1;
    }
    localObject2 = new String((byte[])localObject2);
    i4 = h.ae;
    i1 = 1;
    if (i2 < i4) {
      i1 = i3 + 1;
    }
    for (;;)
    {
      ((RandomAccessFile)localObject1).seek(4L);
      ((RandomAccessFile)localObject1).writeInt(i1);
      ((RandomAccessFile)localObject1).close();
      return localObject2;
      for (;;)
      {
        ((RandomAccessFile)localObject1).close();
        return null;
        label209:
        if (i3 != 0) {
          if (i3 != i1) {
            break;
          }
        }
      }
      if (i3 != i4) {
        i1 = 1 + i3;
      }
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      int i1 = h.ae;
      if (paramInt1 > i1) {
        return false;
      }
      if (paramInt2 >= 0)
      {
        paramInt1 += 1;
        if (paramInt2 > paramInt1) {
          return false;
        }
        if ((paramInt3 >= 1) && (paramInt3 <= paramInt1)) {
          return paramInt3 <= i1;
        }
      }
    }
    return false;
  }
  
  private static void b()
  {
    e = true;
    d = null;
    f = 0;
    g = 0;
    h = 0L;
    i = 0L;
    j = 0L;
    k = 0.0D;
    l = 0.0D;
    m = 0;
    n = 0;
    o = 0;
  }
  
  private static boolean c()
  {
    if (c.exists()) {
      c.delete();
    }
    if (!c.getParentFile().exists()) {
      c.getParentFile().mkdirs();
    }
    try
    {
      c.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(c, "rw");
      localRandomAccessFile.seek(0L);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(1);
      localRandomAccessFile.close();
      b();
      return c.exists();
    }
    catch (IOException localIOException) {}
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.f
 * JD-Core Version:    0.7.0.1
 */