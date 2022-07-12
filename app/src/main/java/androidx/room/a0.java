package androidx.room;

import java.util.ArrayList;
import java.util.List;
import p1.i;

final class a0
  implements i
{
  private List<Object> a = new ArrayList();
  
  private void g(int paramInt, Object paramObject)
  {
    int i = paramInt - 1;
    if (i >= this.a.size())
    {
      paramInt = this.a.size();
      while (paramInt <= i)
      {
        this.a.add(null);
        paramInt += 1;
      }
    }
    this.a.set(i, paramObject);
  }
  
  public void A(int paramInt, double paramDouble)
  {
    g(paramInt, Double.valueOf(paramDouble));
  }
  
  public void O(int paramInt, long paramLong)
  {
    g(paramInt, Long.valueOf(paramLong));
  }
  
  public void S(int paramInt, byte[] paramArrayOfByte)
  {
    g(paramInt, paramArrayOfByte);
  }
  
  List<Object> a()
  {
    return this.a;
  }
  
  public void close() {}
  
  public void r(int paramInt, String paramString)
  {
    g(paramInt, paramString);
  }
  
  public void y(int paramInt)
  {
    g(paramInt, null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.a0
 * JD-Core Version:    0.7.0.1
 */