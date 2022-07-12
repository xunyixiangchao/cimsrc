package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

abstract interface v
{
  public abstract c a(k paramk);
  
  public abstract k b(int paramInt);
  
  public static class a
    implements v
  {
    SparseArray<k> a = new SparseArray();
    int b = 0;
    
    public v.c a(k paramk)
    {
      return new a(paramk);
    }
    
    public k b(int paramInt)
    {
      Object localObject = (k)this.a.get(paramInt);
      if (localObject != null) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot find the wrapper for global view type ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    int c(k paramk)
    {
      int i = this.b;
      this.b = (i + 1);
      this.a.put(i, paramk);
      return i;
    }
    
    class a
      implements v.c
    {
      private SparseIntArray a = new SparseIntArray(1);
      private SparseIntArray b = new SparseIntArray(1);
      final k c;
      
      a(k paramk)
      {
        this.c = paramk;
      }
      
      public int a(int paramInt)
      {
        int i = this.b.indexOfKey(paramInt);
        if (i >= 0) {
          return this.b.valueAt(i);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requested global type ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" does not belong to the adapter:");
        localStringBuilder.append(this.c.c);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      
      public int b(int paramInt)
      {
        int i = this.a.indexOfKey(paramInt);
        if (i > -1) {
          return this.a.valueAt(i);
        }
        i = v.a.this.c(this.c);
        this.a.put(paramInt, i);
        this.b.put(i, paramInt);
        return i;
      }
    }
  }
  
  public static class b
    implements v
  {
    SparseArray<List<k>> a = new SparseArray();
    
    public v.c a(k paramk)
    {
      return new a(paramk);
    }
    
    public k b(int paramInt)
    {
      Object localObject = (List)this.a.get(paramInt);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        return (k)((List)localObject).get(0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot find the wrapper for global view type ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    class a
      implements v.c
    {
      final k a;
      
      a(k paramk)
      {
        this.a = paramk;
      }
      
      public int a(int paramInt)
      {
        return paramInt;
      }
      
      public int b(int paramInt)
      {
        List localList = (List)v.b.this.a.get(paramInt);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList();
          v.b.this.a.put(paramInt, localObject);
        }
        if (!((List)localObject).contains(this.a)) {
          ((List)localObject).add(this.a);
        }
        return paramInt;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract int a(int paramInt);
    
    public abstract int b(int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.v
 * JD-Core Version:    0.7.0.1
 */