package org.webrtc;

public abstract interface Predicate<T>
{
  public abstract Predicate<T> and(Predicate<? super T> paramPredicate);
  
  public abstract Predicate<T> negate();
  
  public abstract Predicate<T> or(Predicate<? super T> paramPredicate);
  
  public abstract boolean test(T paramT);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Predicate
 * JD-Core Version:    0.7.0.1
 */