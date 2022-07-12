package com.baidu.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
{
  private a a;
  private Map b = new HashMap();
  
  public c(a parama)
  {
    this.a = parama;
    parama = parama.a().iterator();
    while (parama.hasNext())
    {
      a locala = (a)parama.next();
      this.b.put(locala.a(), locala);
    }
  }
  
  public List a()
  {
    return new ArrayList(this.b.values());
  }
  
  public static abstract interface a
  {
    public abstract List a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.b.c
 * JD-Core Version:    0.7.0.1
 */