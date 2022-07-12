package androidx.lifecycle;

class FullLifecycleObserverAdapter
  implements j
{
  private final f a;
  private final j b;
  
  FullLifecycleObserverAdapter(f paramf, j paramj)
  {
    this.a = paramf;
    this.b = paramj;
  }
  
  public void d(l paraml, h.b paramb)
  {
    switch (a.a[paramb.ordinal()])
    {
    default: 
      break;
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 6: 
      this.a.onDestroy(paraml);
      break;
    case 5: 
      this.a.onStop(paraml);
      break;
    case 4: 
      this.a.onPause(paraml);
      break;
    case 3: 
      this.a.onResume(paraml);
      break;
    case 2: 
      this.a.onStart(paraml);
      break;
    case 1: 
      this.a.b(paraml);
    }
    j localj = this.b;
    if (localj != null) {
      localj.d(paraml, paramb);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */