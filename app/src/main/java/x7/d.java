package x7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v7.b;
import v7.f;
import v7.v;
import v7.w;
import w7.e;

public final class d
  implements w, Cloneable
{
  public static final d g = new d();
  private double a = -1.0D;
  private int b = 136;
  private boolean c = true;
  private boolean d;
  private List<b> e = Collections.emptyList();
  private List<b> f = Collections.emptyList();
  
  private boolean d(Class<?> paramClass)
  {
    if ((this.a != -1.0D) && (!o((w7.d)paramClass.getAnnotation(w7.d.class), (e)paramClass.getAnnotation(e.class)))) {
      return true;
    }
    if ((!this.c) && (k(paramClass))) {
      return true;
    }
    return j(paramClass);
  }
  
  private boolean e(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = this.e;
    } else {
      localObject = this.f;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((b)((Iterator)localObject).next()).a(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean j(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean k(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!l(paramClass));
  }
  
  private boolean l(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  private boolean m(w7.d paramd)
  {
    return (paramd == null) || (paramd.value() <= this.a);
  }
  
  private boolean n(e parame)
  {
    return (parame == null) || (parame.value() > this.a);
  }
  
  private boolean o(w7.d paramd, e parame)
  {
    return (m(paramd)) && (n(parame));
  }
  
  public <T> v<T> a(final f paramf, final com.google.gson.reflect.a<T> parama)
  {
    Class localClass = parama.getRawType();
    final boolean bool2 = d(localClass);
    final boolean bool1;
    if ((!bool2) && (!e(localClass, true))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((!bool2) && (!e(localClass, false))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if ((!bool1) && (!bool2)) {
      return null;
    }
    return new a(bool2, bool1, paramf, parama);
  }
  
  protected d b()
  {
    try
    {
      d locald = (d)super.clone();
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public boolean c(Class<?> paramClass, boolean paramBoolean)
  {
    return (d(paramClass)) || (e(paramClass, paramBoolean));
  }
  
  public boolean f(Field paramField, boolean paramBoolean)
  {
    if ((this.b & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.a != -1.0D) && (!o((w7.d)paramField.getAnnotation(w7.d.class), (e)paramField.getAnnotation(e.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    Object localObject;
    if (this.d)
    {
      localObject = (w7.a)paramField.getAnnotation(w7.a.class);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          if (!((w7.a)localObject).serialize()) {
            return true;
          }
        }
        else if (((w7.a)localObject).deserialize()) {}
      }
      else {
        return true;
      }
    }
    if ((!this.c) && (k(paramField.getType()))) {
      return true;
    }
    if (j(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {
      localObject = this.e;
    } else {
      localObject = this.f;
    }
    if (!((List)localObject).isEmpty())
    {
      paramField = new v7.c(paramField);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((b)((Iterator)localObject).next()).b(paramField)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public d p(b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    d locald = b();
    ArrayList localArrayList;
    if (paramBoolean1)
    {
      localArrayList = new ArrayList(this.e);
      locald.e = localArrayList;
      localArrayList.add(paramb);
    }
    if (paramBoolean2)
    {
      localArrayList = new ArrayList(this.f);
      locald.f = localArrayList;
      localArrayList.add(paramb);
    }
    return locald;
  }
  
  class a
    extends v<T>
  {
    private v<T> a;
    
    a(boolean paramBoolean1, boolean paramBoolean2, f paramf, com.google.gson.reflect.a parama) {}
    
    private v<T> e()
    {
      v localv = this.a;
      if (localv != null) {
        return localv;
      }
      localv = paramf.m(d.this, parama);
      this.a = localv;
      return localv;
    }
    
    public T b(b8.a parama)
    {
      if (bool2)
      {
        parama.E0();
        return null;
      }
      return e().b(parama);
    }
    
    public void d(b8.c paramc, T paramT)
    {
      if (bool1)
      {
        paramc.k0();
        return;
      }
      e().d(paramc, paramT);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.d
 * JD-Core Version:    0.7.0.1
 */