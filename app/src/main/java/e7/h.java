package e7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import g0.g;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private final g<String, i> a = new g();
  private final g<String, PropertyValuesHolder[]> b = new g();
  
  private static void a(h paramh, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramh.l(paramAnimator.getPropertyName(), paramAnimator.getValues());
      paramh.m(paramAnimator.getPropertyName(), i.b(paramAnimator));
      return;
    }
    paramh = new StringBuilder();
    paramh.append("Animator must be an ObjectAnimator: ");
    paramh.append(paramAnimator);
    throw new IllegalArgumentException(paramh.toString());
  }
  
  private PropertyValuesHolder[] b(PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[paramArrayOfPropertyValuesHolder.length];
    int i = 0;
    while (i < paramArrayOfPropertyValuesHolder.length)
    {
      arrayOfPropertyValuesHolder[i] = paramArrayOfPropertyValuesHolder[i].clone();
      i += 1;
    }
    return arrayOfPropertyValuesHolder;
  }
  
  public static h c(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return d(paramContext, paramInt);
      }
    }
    return null;
  }
  
  public static h d(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet)) {
        return e(((AnimatorSet)paramContext).getChildAnimations());
      }
      if (paramContext != null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramContext);
        paramContext = e((List)localObject);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can't load animation resource ID #0x");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", ((StringBuilder)localObject).toString(), paramContext);
    }
    return null;
  }
  
  private static h e(List<Animator> paramList)
  {
    h localh = new h();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a(localh, (Animator)paramList.get(i));
      i += 1;
    }
    return localh;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public <T> ObjectAnimator f(String paramString, T paramT, Property<T, ?> paramProperty)
  {
    paramT = ObjectAnimator.ofPropertyValuesHolder(paramT, g(paramString));
    paramT.setProperty(paramProperty);
    h(paramString).a(paramT);
    return paramT;
  }
  
  public PropertyValuesHolder[] g(String paramString)
  {
    if (j(paramString)) {
      return b((PropertyValuesHolder[])this.b.get(paramString));
    }
    throw new IllegalArgumentException();
  }
  
  public i h(String paramString)
  {
    if (k(paramString)) {
      return (i)this.a.get(paramString);
    }
    throw new IllegalArgumentException();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public long i()
  {
    int j = this.a.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      i locali = (i)this.a.m(i);
      l = Math.max(l, locali.c() + locali.d());
      i += 1;
    }
    return l;
  }
  
  public boolean j(String paramString)
  {
    return this.b.get(paramString) != null;
  }
  
  public boolean k(String paramString)
  {
    return this.a.get(paramString) != null;
  }
  
  public void l(String paramString, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    this.b.put(paramString, paramArrayOfPropertyValuesHolder);
  }
  
  public void m(String paramString, i parami)
  {
    this.a.put(paramString, parami);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.h
 * JD-Core Version:    0.7.0.1
 */