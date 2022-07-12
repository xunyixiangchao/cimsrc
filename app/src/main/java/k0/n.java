package k0;

import h0.c;
import java.util.ArrayList;

public class n
  extends e
{
  public ArrayList<e> V0 = new ArrayList();
  
  public void a(e parame)
  {
    this.V0.add(parame);
    if (parame.M() != null) {
      ((n)parame.M()).x1(parame);
    }
    parame.g1(this);
  }
  
  public void v0()
  {
    this.V0.clear();
    super.v0();
  }
  
  public ArrayList<e> v1()
  {
    return this.V0;
  }
  
  public void w1()
  {
    Object localObject = this.V0;
    if (localObject == null) {
      return;
    }
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (e)this.V0.get(i);
      if ((localObject instanceof n)) {
        ((n)localObject).w1();
      }
      i += 1;
    }
  }
  
  public void x1(e parame)
  {
    this.V0.remove(parame);
    parame.v0();
  }
  
  public void y1()
  {
    this.V0.clear();
  }
  
  public void z0(c paramc)
  {
    super.z0(paramc);
    int j = this.V0.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.V0.get(i)).z0(paramc);
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.n
 * JD-Core Version:    0.7.0.1
 */