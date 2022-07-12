package e2;

import java.util.Queue;

abstract class c<T extends l>
{
  private final Queue<T> a = x2.l.f(20);
  
  abstract T a();
  
  T b()
  {
    l locall2 = (l)this.a.poll();
    l locall1 = locall2;
    if (locall2 == null) {
      locall1 = a();
    }
    return locall1;
  }
  
  public void c(T paramT)
  {
    if (this.a.size() < 20) {
      this.a.offer(paramT);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.c
 * JD-Core Version:    0.7.0.1
 */