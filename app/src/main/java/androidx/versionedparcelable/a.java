package androidx.versionedparcelable;

import android.os.Parcelable;
import g0.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  protected final g0.a<String, Method> a;
  protected final g0.a<String, Method> b;
  protected final g0.a<String, Class> c;
  
  public a(g0.a<String, Method> parama1, g0.a<String, Method> parama2, g0.a<String, Class> parama)
  {
    this.a = parama1;
    this.b = parama2;
    this.c = parama;
  }
  
  private void N(u1.a parama)
  {
    try
    {
      Class localClass = c(parama.getClass());
      I(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.getClass().getSimpleName());
      localStringBuilder.append(" does not have a Parcelizer");
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  private Class c(Class<? extends u1.a> paramClass)
  {
    Class localClass2 = (Class)this.c.get(paramClass.getName());
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      this.c.put(paramClass.getName(), localClass1);
    }
    return localClass1;
  }
  
  private Method d(String paramString)
  {
    Method localMethod2 = (Method)this.a.get(paramString);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      System.currentTimeMillis();
      localMethod1 = Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class });
      this.a.put(paramString, localMethod1);
    }
    return localMethod1;
  }
  
  private Method e(Class paramClass)
  {
    Method localMethod = (Method)this.b.get(paramClass.getName());
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = c(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, a.class });
      this.b.put(paramClass.getName(), localObject);
    }
    return localObject;
  }
  
  protected abstract void A(byte[] paramArrayOfByte);
  
  public void B(byte[] paramArrayOfByte, int paramInt)
  {
    w(paramInt);
    A(paramArrayOfByte);
  }
  
  protected abstract void C(CharSequence paramCharSequence);
  
  public void D(CharSequence paramCharSequence, int paramInt)
  {
    w(paramInt);
    C(paramCharSequence);
  }
  
  protected abstract void E(int paramInt);
  
  public void F(int paramInt1, int paramInt2)
  {
    w(paramInt2);
    E(paramInt1);
  }
  
  protected abstract void G(Parcelable paramParcelable);
  
  public void H(Parcelable paramParcelable, int paramInt)
  {
    w(paramInt);
    G(paramParcelable);
  }
  
  protected abstract void I(String paramString);
  
  public void J(String paramString, int paramInt)
  {
    w(paramInt);
    I(paramString);
  }
  
  protected <T extends u1.a> void K(T paramT, a parama)
  {
    try
    {
      e(paramT.getClass()).invoke(null, new Object[] { paramT, parama });
      return;
    }
    catch (ClassNotFoundException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramT);
    }
    catch (NoSuchMethodException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramT);
    }
    catch (InvocationTargetException paramT)
    {
      if ((paramT.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramT.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramT);
    }
    catch (IllegalAccessException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramT);
    }
  }
  
  protected void L(u1.a parama)
  {
    if (parama == null)
    {
      I(null);
      return;
    }
    N(parama);
    a locala = b();
    K(parama, locala);
    locala.a();
  }
  
  public void M(u1.a parama, int paramInt)
  {
    w(paramInt);
    L(parama);
  }
  
  protected abstract void a();
  
  protected abstract a b();
  
  public boolean f()
  {
    return false;
  }
  
  protected abstract boolean g();
  
  public boolean h(boolean paramBoolean, int paramInt)
  {
    if (!m(paramInt)) {
      return paramBoolean;
    }
    return g();
  }
  
  protected abstract byte[] i();
  
  public byte[] j(byte[] paramArrayOfByte, int paramInt)
  {
    if (!m(paramInt)) {
      return paramArrayOfByte;
    }
    return i();
  }
  
  protected abstract CharSequence k();
  
  public CharSequence l(CharSequence paramCharSequence, int paramInt)
  {
    if (!m(paramInt)) {
      return paramCharSequence;
    }
    return k();
  }
  
  protected abstract boolean m(int paramInt);
  
  protected <T extends u1.a> T n(String paramString, a parama)
  {
    try
    {
      paramString = (u1.a)d(paramString).invoke(null, new Object[] { parama });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
  }
  
  protected abstract int o();
  
  public int p(int paramInt1, int paramInt2)
  {
    if (!m(paramInt2)) {
      return paramInt1;
    }
    return o();
  }
  
  protected abstract <T extends Parcelable> T q();
  
  public <T extends Parcelable> T r(T paramT, int paramInt)
  {
    if (!m(paramInt)) {
      return paramT;
    }
    return q();
  }
  
  protected abstract String s();
  
  public String t(String paramString, int paramInt)
  {
    if (!m(paramInt)) {
      return paramString;
    }
    return s();
  }
  
  protected <T extends u1.a> T u()
  {
    String str = s();
    if (str == null) {
      return null;
    }
    return n(str, b());
  }
  
  public <T extends u1.a> T v(T paramT, int paramInt)
  {
    if (!m(paramInt)) {
      return paramT;
    }
    return u();
  }
  
  protected abstract void w(int paramInt);
  
  public void x(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected abstract void y(boolean paramBoolean);
  
  public void z(boolean paramBoolean, int paramInt)
  {
    w(paramInt);
    y(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */