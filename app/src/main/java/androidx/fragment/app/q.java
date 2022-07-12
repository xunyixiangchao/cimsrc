package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.h.c;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class q
{
  private final g a;
  private final ClassLoader b;
  ArrayList<a> c = new ArrayList();
  int d;
  int e;
  int f;
  int g;
  int h;
  boolean i;
  boolean j = true;
  String k;
  int l;
  CharSequence m;
  int n;
  CharSequence o;
  ArrayList<String> p;
  ArrayList<String> q;
  boolean r = false;
  ArrayList<Runnable> s;
  
  q(g paramg, ClassLoader paramClassLoader)
  {
    this.a = paramg;
    this.b = paramClassLoader;
  }
  
  public q b(int paramInt, Fragment paramFragment, String paramString)
  {
    m(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  q c(ViewGroup paramViewGroup, Fragment paramFragment, String paramString)
  {
    paramFragment.mContainer = paramViewGroup;
    return b(paramViewGroup.getId(), paramFragment, paramString);
  }
  
  public q d(Fragment paramFragment, String paramString)
  {
    m(0, paramFragment, paramString, 1);
    return this;
  }
  
  void e(a parama)
  {
    this.c.add(parama);
    parama.c = this.d;
    parama.d = this.e;
    parama.e = this.f;
    parama.f = this.g;
  }
  
  public q f(Fragment paramFragment)
  {
    e(new a(7, paramFragment));
    return this;
  }
  
  public abstract int g();
  
  public abstract int h();
  
  public abstract void i();
  
  public abstract void j();
  
  public q k(Fragment paramFragment)
  {
    e(new a(6, paramFragment));
    return this;
  }
  
  public q l()
  {
    if (!this.i)
    {
      this.j = false;
      return this;
    }
    throw new IllegalStateException("This transaction is already being added to the back stack");
  }
  
  void m(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Object localObject = paramFragment.getClass();
    int i1 = ((Class)localObject).getModifiers();
    if ((!((Class)localObject).isAnonymousClass()) && (Modifier.isPublic(i1)) && ((!((Class)localObject).isMemberClass()) || (Modifier.isStatic(i1))))
    {
      if (paramString != null)
      {
        localObject = paramFragment.mTag;
        if ((localObject != null) && (!paramString.equals(localObject)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't change tag of fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(": was ");
          ((StringBuilder)localObject).append(paramFragment.mTag);
          ((StringBuilder)localObject).append(" now ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        paramFragment.mTag = paramString;
      }
      if (paramInt1 != 0) {
        if (paramInt1 != -1)
        {
          i1 = paramFragment.mFragmentId;
          if ((i1 != 0) && (i1 != paramInt1))
          {
            paramString = new StringBuilder();
            paramString.append("Can't change container ID of fragment ");
            paramString.append(paramFragment);
            paramString.append(": was ");
            paramString.append(paramFragment.mFragmentId);
            paramString.append(" now ");
            paramString.append(paramInt1);
            throw new IllegalStateException(paramString.toString());
          }
          paramFragment.mFragmentId = paramInt1;
          paramFragment.mContainerId = paramInt1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't add fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(" with tag ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" to container view with no id");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      e(new a(paramInt2, paramFragment));
      return;
    }
    paramFragment = new StringBuilder();
    paramFragment.append("Fragment ");
    paramFragment.append(((Class)localObject).getCanonicalName());
    paramFragment.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(paramFragment.toString());
  }
  
  public q n(Fragment paramFragment)
  {
    e(new a(3, paramFragment));
    return this;
  }
  
  public q o(int paramInt, Fragment paramFragment)
  {
    return p(paramInt, paramFragment, null);
  }
  
  public q p(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt != 0)
    {
      m(paramInt, paramFragment, paramString, 2);
      return this;
    }
    throw new IllegalArgumentException("Must use non-zero containerViewId");
  }
  
  public q q(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  static final class a
  {
    int a;
    Fragment b;
    int c;
    int d;
    int e;
    int f;
    h.c g;
    h.c h;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.a = paramInt;
      this.b = paramFragment;
      paramFragment = h.c.e;
      this.g = paramFragment;
      this.h = paramFragment;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.q
 * JD-Core Version:    0.7.0.1
 */