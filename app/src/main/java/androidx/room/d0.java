package androidx.room;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p1.i;
import p1.k;

final class d0
  implements k
{
  private final k a;
  private final f0.f b;
  private final String c;
  private final List<Object> d = new ArrayList();
  private final Executor e;
  
  d0(k paramk, f0.f paramf, String paramString, Executor paramExecutor)
  {
    this.a = paramk;
    this.b = paramf;
    this.c = paramString;
    this.e = paramExecutor;
  }
  
  private void B(int paramInt, Object paramObject)
  {
    int i = paramInt - 1;
    if (i >= this.d.size())
    {
      paramInt = this.d.size();
      while (paramInt <= i)
      {
        this.d.add(null);
        paramInt += 1;
      }
    }
    this.d.set(i, paramObject);
  }
  
  public void A(int paramInt, double paramDouble)
  {
    B(paramInt, Double.valueOf(paramDouble));
    this.a.A(paramInt, paramDouble);
  }
  
  public void O(int paramInt, long paramLong)
  {
    B(paramInt, Long.valueOf(paramLong));
    this.a.O(paramInt, paramLong);
  }
  
  public void S(int paramInt, byte[] paramArrayOfByte)
  {
    B(paramInt, paramArrayOfByte);
    this.a.S(paramInt, paramArrayOfByte);
  }
  
  public long Z()
  {
    this.e.execute(new b0(this));
    return this.a.Z();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void r(int paramInt, String paramString)
  {
    B(paramInt, paramString);
    this.a.r(paramInt, paramString);
  }
  
  public int u()
  {
    this.e.execute(new c0(this));
    return this.a.u();
  }
  
  public void y(int paramInt)
  {
    B(paramInt, this.d.toArray());
    this.a.y(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.d0
 * JD-Core Version:    0.7.0.1
 */