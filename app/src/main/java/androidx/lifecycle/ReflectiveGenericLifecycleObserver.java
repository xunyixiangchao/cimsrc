package androidx.lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver
  implements j
{
  private final Object a;
  private final b.a b;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.a = paramObject;
    this.b = b.c.c(paramObject.getClass());
  }
  
  public void d(l paraml, h.b paramb)
  {
    this.b.a(paraml, paramb, this.a);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */