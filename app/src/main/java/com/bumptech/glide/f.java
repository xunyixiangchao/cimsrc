package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class f
{
  private final Map<Class<?>, Object> a;
  
  f(a parama)
  {
    this.a = Collections.unmodifiableMap(new HashMap(a.a(parama)));
  }
  
  public boolean a(Class<Object> paramClass)
  {
    return this.a.containsKey(paramClass);
  }
  
  static final class a
  {
    private final Map<Class<?>, Object> a = new HashMap();
    
    f b()
    {
      return new f(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.f
 * JD-Core Version:    0.7.0.1
 */