package k0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import l0.o;

public class j
  extends e
  implements i
{
  public e[] V0 = new e[4];
  public int W0 = 0;
  
  public void a(e parame)
  {
    if (parame != this)
    {
      if (parame == null) {
        return;
      }
      int i = this.W0;
      e[] arrayOfe = this.V0;
      if (i + 1 > arrayOfe.length) {
        this.V0 = ((e[])Arrays.copyOf(arrayOfe, arrayOfe.length * 2));
      }
      arrayOfe = this.V0;
      i = this.W0;
      arrayOfe[i] = parame;
      this.W0 = (i + 1);
    }
  }
  
  public void b(f paramf) {}
  
  public void c()
  {
    this.W0 = 0;
    Arrays.fill(this.V0, null);
  }
  
  public void n(e parame, HashMap<e, e> paramHashMap)
  {
    super.n(parame, paramHashMap);
    parame = (j)parame;
    int i = 0;
    this.W0 = 0;
    int j = parame.W0;
    while (i < j)
    {
      a((e)paramHashMap.get(parame.V0[i]));
      i += 1;
    }
  }
  
  public void v1(ArrayList<o> paramArrayList, int paramInt, o paramo)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.W0) {
        break;
      }
      paramo.a(this.V0[i]);
      i += 1;
    }
    while (j < this.W0)
    {
      l0.i.a(this.V0[j], paramInt, paramArrayList, paramo);
      j += 1;
    }
  }
  
  public int w1(int paramInt)
  {
    int i = 0;
    while (i < this.W0)
    {
      e locale = this.V0[i];
      int j;
      if (paramInt == 0)
      {
        j = locale.S0;
        if (j != -1) {
          return j;
        }
      }
      if (paramInt == 1)
      {
        j = locale.T0;
        if (j != -1) {
          return j;
        }
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.j
 * JD-Core Version:    0.7.0.1
 */