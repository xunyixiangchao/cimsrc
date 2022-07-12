package m1;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;
import p1.i;
import p1.j;

public class l
  implements j, i
{
  static final TreeMap<Integer, l> i = new TreeMap();
  private volatile String a;
  final long[] b;
  final double[] c;
  final String[] d;
  final byte[][] e;
  private final int[] f;
  final int g;
  int h;
  
  private l(int paramInt)
  {
    this.g = paramInt;
    paramInt += 1;
    this.f = new int[paramInt];
    this.b = new long[paramInt];
    this.c = new double[paramInt];
    this.d = new String[paramInt];
    this.e = new byte[paramInt][];
  }
  
  private static void B()
  {
    Object localObject = i;
    if (((TreeMap)localObject).size() > 15)
    {
      int j = ((TreeMap)localObject).size() - 10;
      localObject = ((TreeMap)localObject).descendingKeySet().iterator();
      while (j > 0)
      {
        ((Iterator)localObject).next();
        ((Iterator)localObject).remove();
        j -= 1;
      }
    }
  }
  
  public static l h(String paramString, int paramInt)
  {
    synchronized (i)
    {
      Object localObject2 = ((TreeMap)???).ceilingEntry(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        ((TreeMap)???).remove(((Map.Entry)localObject2).getKey());
        localObject2 = (l)((Map.Entry)localObject2).getValue();
        ((l)localObject2).i(paramString, paramInt);
        return localObject2;
      }
      ??? = new l(paramInt);
      ((l)???).i(paramString, paramInt);
      return ???;
    }
  }
  
  public void A(int paramInt, double paramDouble)
  {
    this.f[paramInt] = 3;
    this.c[paramInt] = paramDouble;
  }
  
  public void O(int paramInt, long paramLong)
  {
    this.f[paramInt] = 2;
    this.b[paramInt] = paramLong;
  }
  
  public void S(int paramInt, byte[] paramArrayOfByte)
  {
    this.f[paramInt] = 5;
    this.e[paramInt] = paramArrayOfByte;
  }
  
  public void a(i parami)
  {
    int j = 1;
    while (j <= this.h)
    {
      int k = this.f[j];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k == 5) {
                parami.S(j, this.e[j]);
              }
            }
            else {
              parami.r(j, this.d[j]);
            }
          }
          else {
            parami.A(j, this.c[j]);
          }
        }
        else {
          parami.O(j, this.b[j]);
        }
      }
      else {
        parami.y(j);
      }
      j += 1;
    }
  }
  
  public void close() {}
  
  public void d0()
  {
    synchronized (i)
    {
      ???.put(Integer.valueOf(this.g), this);
      B();
      return;
    }
  }
  
  public String g()
  {
    return this.a;
  }
  
  void i(String paramString, int paramInt)
  {
    this.a = paramString;
    this.h = paramInt;
  }
  
  public void r(int paramInt, String paramString)
  {
    this.f[paramInt] = 4;
    this.d[paramInt] = paramString;
  }
  
  public void y(int paramInt)
  {
    this.f[paramInt] = 1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.l
 * JD-Core Version:    0.7.0.1
 */