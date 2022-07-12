package org.webrtc;

class Predicate$1
  implements Predicate<T>
{
  Predicate$1(Predicate paramPredicate1, Predicate paramPredicate2) {}
  
  public boolean test(T paramT)
  {
    return (this.this$0.test(paramT)) || (this.val$other.test(paramT));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Predicate.1
 * JD-Core Version:    0.7.0.1
 */