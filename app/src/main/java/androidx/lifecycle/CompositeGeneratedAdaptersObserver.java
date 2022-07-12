package androidx.lifecycle;

class CompositeGeneratedAdaptersObserver
  implements j
{
  private final g[] a;
  
  CompositeGeneratedAdaptersObserver(g[] paramArrayOfg)
  {
    this.a = paramArrayOfg;
  }
  
  public void d(l paraml, h.b paramb)
  {
    q localq = new q();
    g[] arrayOfg = this.a;
    int k = arrayOfg.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      arrayOfg[i].a(paraml, paramb, false, localq);
      i += 1;
    }
    arrayOfg = this.a;
    k = arrayOfg.length;
    i = j;
    while (i < k)
    {
      arrayOfg[i].a(paraml, paramb, true, localq);
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.CompositeGeneratedAdaptersObserver
 * JD-Core Version:    0.7.0.1
 */