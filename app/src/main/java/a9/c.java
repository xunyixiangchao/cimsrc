package a9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<*>;
import java.util.Iterator;
import java.util.Objects;

public final class c
{
  private static final Object[] a = new Object[0];
  
  public static final Object[] a(Collection<?> paramCollection)
  {
    f.f(paramCollection, "collection");
    int i = paramCollection.size();
    if (i == 0) {}
    Iterator localIterator;
    do
    {
      return a;
      localIterator = paramCollection.iterator();
    } while (!localIterator.hasNext());
    paramCollection = new Object[i];
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      Object localObject;
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j) {
          if (j < 2147483645) {
            i = 2147483645;
          } else {
            throw new OutOfMemoryError();
          }
        }
        localObject = Arrays.copyOf(paramCollection, i);
        f.e(localObject, "copyOf(result, newSize)");
      }
      else
      {
        localObject = paramCollection;
        if (!localIterator.hasNext())
        {
          paramCollection = Arrays.copyOf(paramCollection, j);
          f.e(paramCollection, "copyOf(result, size)");
          return paramCollection;
        }
      }
      i = j;
      paramCollection = (Collection<?>)localObject;
    }
  }
  
  public static final Object[] b(Collection<?> paramCollection, Object[] paramArrayOfObject)
  {
    f.f(paramCollection, "collection");
    Objects.requireNonNull(paramArrayOfObject);
    int j = paramCollection.size();
    int i = 0;
    Iterator localIterator;
    if (j == 0)
    {
      paramCollection = paramArrayOfObject;
      if (paramArrayOfObject.length > 0)
      {
        paramArrayOfObject[0] = null;
        return paramArrayOfObject;
      }
    }
    else
    {
      localIterator = paramCollection.iterator();
      if (!localIterator.hasNext())
      {
        paramCollection = paramArrayOfObject;
        if (paramArrayOfObject.length > 0)
        {
          paramArrayOfObject[0] = null;
          return paramArrayOfObject;
        }
      }
      else if (j <= paramArrayOfObject.length)
      {
        paramCollection = paramArrayOfObject;
      }
      else
      {
        paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
        f.d(paramCollection, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      }
    }
    Object localObject;
    for (paramCollection = (Object[])paramCollection;; paramCollection = (Collection<?>)localObject)
    {
      j = i + 1;
      paramCollection[i] = localIterator.next();
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j) {
          if (j < 2147483645) {
            i = 2147483645;
          } else {
            throw new OutOfMemoryError();
          }
        }
        localObject = Arrays.copyOf(paramCollection, i);
        f.e(localObject, "copyOf(result, newSize)");
      }
      else
      {
        localObject = paramCollection;
        if (!localIterator.hasNext())
        {
          if (paramCollection == paramArrayOfObject)
          {
            paramArrayOfObject[j] = null;
            return paramArrayOfObject;
          }
          paramCollection = Arrays.copyOf(paramCollection, j);
          f.e(paramCollection, "copyOf(result, size)");
          return paramCollection;
        }
      }
      i = j;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.c
 * JD-Core Version:    0.7.0.1
 */