package u8;

import a9.f;
import java.lang.reflect.Method;

final class g
{
  public static final g a = new g();
  private static final a b = new a(null, null, null);
  private static a c;
  
  private final a a(a parama)
  {
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      c = parama;
      return parama;
    }
    catch (Exception parama)
    {
      label67:
      break label67;
    }
    parama = b;
    c = parama;
    return parama;
  }
  
  public final String b(a parama)
  {
    f.f(parama, "continuation");
    a locala = c;
    Object localObject1 = locala;
    if (locala == null) {
      localObject1 = a(parama);
    }
    Object localObject2 = b;
    locala = null;
    if (localObject1 == localObject2) {
      return null;
    }
    localObject2 = ((a)localObject1).a;
    if (localObject2 != null) {
      parama = ((Method)localObject2).invoke(parama.getClass(), new Object[0]);
    } else {
      parama = null;
    }
    if (parama == null) {
      return null;
    }
    localObject2 = ((a)localObject1).b;
    if (localObject2 != null) {
      parama = ((Method)localObject2).invoke(parama, new Object[0]);
    } else {
      parama = null;
    }
    if (parama == null) {
      return null;
    }
    localObject1 = ((a)localObject1).c;
    if (localObject1 != null) {
      parama = ((Method)localObject1).invoke(parama, new Object[0]);
    } else {
      parama = null;
    }
    localObject1 = locala;
    if ((parama instanceof String)) {
      localObject1 = (String)parama;
    }
    return localObject1;
  }
  
  private static final class a
  {
    public final Method a;
    public final Method b;
    public final Method c;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u8.g
 * JD-Core Version:    0.7.0.1
 */